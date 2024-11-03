-- 브랜드 데이터 삽입
INSERT INTO brand (name) VALUES
                              ('A'), ('B'), ('C'), ('D'), ('E'), ('F'), ('G'), ('H'), ('I');

-- A 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'TOP', 11200),
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'OUTER', 5500),
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'PANTS', 4200),
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'SNEAKERS', 9000),
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'BAG', 2000),
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'CAP', 1700),
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'SOCKS', 1800),
                                                  ((SELECT id FROM brand WHERE name = 'A'), 'ACCESSORY', 2300);

-- B 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'TOP', 10500),
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'OUTER', 5900),
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'PANTS', 3800),
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'SNEAKERS', 9100),
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'BAG', 2100),
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'CAP', 2000),
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'SOCKS', 2000),
                                                  ((SELECT id FROM brand WHERE name = 'B'), 'ACCESSORY', 2200);

-- C 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'TOP', 10000),
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'OUTER', 6200),
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'PANTS', 3300),
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'SNEAKERS', 9200),
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'BAG', 2200),
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'CAP', 1900),
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'SOCKS', 2200),
                                                  ((SELECT id FROM brand WHERE name = 'C'), 'ACCESSORY', 2100);

-- D 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'TOP', 10100),
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'OUTER', 5100),
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'PANTS', 3000),
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'SNEAKERS', 9500),
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'BAG', 2500),
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'CAP', 1500),
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'SOCKS', 2400),
                                                  ((SELECT id FROM brand WHERE name = 'D'), 'ACCESSORY', 2000);

-- E 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'TOP', 10700),
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'OUTER', 5000),
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'PANTS', 3800),
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'SNEAKERS', 9900),
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'BAG', 2300),
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'CAP', 1800),
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'SOCKS', 2100),
                                                  ((SELECT id FROM brand WHERE name = 'E'), 'ACCESSORY', 2100);

-- F 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'TOP', 11200),
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'OUTER', 7200),
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'PANTS', 4000),
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'SNEAKERS', 9300),
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'BAG', 2100),
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'CAP', 1600),
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'SOCKS', 2300),
                                                  ((SELECT id FROM brand WHERE name = 'F'), 'ACCESSORY', 1900);

-- G 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'TOP', 10500),
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'OUTER', 5800),
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'PANTS', 3900),
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'SNEAKERS', 9000),
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'BAG', 2200),
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'CAP', 1700),
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'SOCKS', 2100),
                                                  ((SELECT id FROM brand WHERE name = 'G'), 'ACCESSORY', 2000);

-- H 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'TOP', 10800),
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'OUTER', 6300),
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'PANTS', 3100),
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'SNEAKERS', 9700),
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'BAG', 2100),
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'CAP', 1600),
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'SOCKS', 2000),
                                                  ((SELECT id FROM brand WHERE name = 'H'), 'ACCESSORY', 2000);

-- I 브랜드 상품
INSERT INTO item (brand_id, category, price) VALUES
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'TOP', 11400),
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'OUTER', 6700),
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'PANTS', 3200),
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'SNEAKERS', 9500),
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'BAG', 2400),
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'CAP', 1700),
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'SOCKS', 1700),
                                                  ((SELECT id FROM brand WHERE name = 'I'), 'ACCESSORY', 2400);


WITH
RankedItems AS (
    -- 각 브랜드의 카테고리별로 최저가 상품을 하나만 선택 (동일 가격시 ID가 가장 작은 것)
    SELECT i.brand_id
         , i.category
         , i.price
         , i.id as item_id
         , ROW_NUMBER() OVER (PARTITION BY i.brand_id, i.category ORDER BY i.price, i.id) AS rn
    FROM item i
),
CategoryMinPrices AS (
         -- 각 브랜드/카테고리별로 선택된 하나의 최저가 상품
         SELECT brand_id
              , category
              , price AS min_price
              , item_id
         FROM RankedItems
         WHERE rn = 1
),
BrandTotals AS (
     -- 브랜드별 카테고리 최저가의 총합 계산
     SELECT b.name                       AS brand_name
          , b.id                         AS brand_id
          , COUNT(DISTINCT cmp.category) AS category_count
          , SUM(cmp.min_price)           AS total_price
       FROM brand b
       JOIN CategoryMinPrices cmp ON b.id = cmp.brand_id
      GROUP BY b.id, b.name
     HAVING COUNT(DISTINCT cmp.category) = 8
)
SELECT bt.brand_name
     , bt.total_price
     , cmp.category
     , cmp.min_price AS price
     , cmp.item_id
  FROM BrandTotals bt
  JOIN CategoryMinPrices cmp ON bt.brand_id = cmp.brand_id
 WHERE bt.total_price = (SELECT MIN(total_price)
                        FROM BrandTotals)
 ORDER BY cmp.category;
