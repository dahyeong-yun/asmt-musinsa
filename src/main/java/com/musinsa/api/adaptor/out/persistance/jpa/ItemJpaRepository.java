package com.musinsa.api.adaptor.out.persistance.jpa;

import com.musinsa.api.adaptor.out.persistance.entity.ItemEntity;
import com.musinsa.api.adaptor.out.persistance.projcetion.BrandLowestPriceResult;
import com.musinsa.api.adaptor.out.persistance.projcetion.CategoryLowestPriceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findByBrandId(Long brandId);

    @Query(nativeQuery = true, value = """
    WITH
    RankedItems AS (
        SELECT i.brand_id
             , i.category
             , i.price
             , i.id as item_id
             , ROW_NUMBER() OVER (PARTITION BY i.brand_id, i.category ORDER BY i.price, i.id) AS rn
        FROM item i
    ),
    CategoryMinPrices AS (
        SELECT brand_id
             , category
             , price AS min_price
             , item_id
        FROM RankedItems
        WHERE rn = 1
    ),
    BrandTotals AS (
        SELECT b.name AS brand_name
             , b.id AS brand_id
             , COUNT(DISTINCT cmp.category) AS category_count
             , SUM(cmp.min_price) AS total_price
        FROM brand b
        JOIN CategoryMinPrices cmp ON b.id = cmp.brand_id
        GROUP BY b.id, b.name
        HAVING COUNT(DISTINCT cmp.category) = 8
    )
    SELECT bt.brand_id AS brandId
         , bt.brand_name AS brandName
         , bt.total_price AS totalPrice
         , cmp.category AS category
         , cmp.min_price AS price
         , cmp.item_id AS itemId
    FROM BrandTotals bt
    JOIN CategoryMinPrices cmp ON bt.brand_id = cmp.brand_id
    WHERE bt.total_price = (SELECT MIN(total_price)
                           FROM BrandTotals)
    ORDER BY 
        CASE cmp.category
            WHEN 'TOP' THEN 1
            WHEN 'OUTER' THEN 2
            WHEN 'PANTS' THEN 3
            WHEN 'SNEAKERS' THEN 4
            WHEN 'BAG' THEN 5
            WHEN 'CAP' THEN 6
            WHEN 'SOCKS' THEN 7
            WHEN 'ACCESSORY' THEN 8
        END
    """)
    List<BrandLowestPriceResult> findLowestPriceCategorySetPerBrand();

    @Query(nativeQuery = true, value = """
        WITH RankedItems AS (
            SELECT i.id as item_id
                 , i.brand_id
                 , b.name as brand_name
                 , i.category
                 , i.price
                 , ROW_NUMBER() OVER (PARTITION BY i.category ORDER BY i.price, b.id DESC, i.id) AS rn
            FROM item i
            JOIN brand b ON i.brand_id = b.id
        )
        SELECT ri.brand_id   AS brandId
             , ri.brand_name AS brandName
             , ri.category   AS category
             , ri.price      AS price
             , ri.item_id    AS itemId
          FROM RankedItems ri
         WHERE ri.rn = 1
         ORDER BY 
            CASE ri.category
                WHEN 'TOP' THEN 1
                WHEN 'OUTER' THEN 2
                WHEN 'PANTS' THEN 3
                WHEN 'SNEAKERS' THEN 4
                WHEN 'BAG' THEN 5
                WHEN 'CAP' THEN 6
                WHEN 'SOCKS' THEN 7
                WHEN 'ACCESSORY' THEN 8
            END
        """)
    List<CategoryLowestPriceResult> findLowestPriceCategorySetAcrossBrands();
}
