# README

## 1. 구현 범위에 대한 설명
- 해당 프로젝트를 이해하고 변경 위해 알아야 할 내용들 입니다.

### 1.1 아키텍쳐
[//]: # (// TODO)
- 헥사고날 아키텍쳐를 표방했습니다.

#### 1.1.1 adaptor
- 표현 계층과 도메인 모델을 연결하는 역할을 합니다.
- 도메일 모델을 영속 계층으로 부터 가져오거나, 영속 계층에 전달합니다.

#### 1.1.2 application
- HTTP API의 요청을 처리하고, 도메인 모델을 사용하여 응답을 생성합니다.

#### 1.1.3 domain
- 브랜드와 카테고리는 상품 이전에 존재해야 하는 객체 입니다.
- 상품

### 1.2 HTTP API
[//]: # (// TODO)
- 리스트 조회는 과제 요구사항 내 범위상 필요하지 않아 구현하지 않음

#### 1.2.1 브랜드
- [x] 브랜드 생성
- [x] 단일 브랜드 조회
- [x] 단일 브랜드 삭제
- [ ] 단일 브랜드 정보 수정

#### 1.2.2 상품
- [x] 상품 생성
- [x] 단일 상품 조회
- [x] 단일 상품 삭제
- [ ] 단일 상품 정보 수정

#### 1.2.3 가격
- [x] 전체 카테고리별 최저가 상품의 브랜드와 금액 리스트 조회
- [x] 특정 브랜드의 전체 카테고리 별 최저가 상품 조합을 가지는 브랜드와 상품 리스트 조회
- [x] 특정 카테고리의 최저과 상품 및 최고가 상품의 브랜드와 금액 조회


### 1.3 코드 컨벤션
[//]: # (// TODO)
- HTTP API의 매핑은 kebab-case로 작성합니다.
- 기본적으로 REST의 설계 원칙을 따르지만, 엄격한 RESTful을 지향하지 않습니다. 예외적 사항은 아래와 같습니다.
  - 버저닝을 허용합니다.
  - 자원에 대한 수정에 있어 HTTP Method의 수정에 

### 1.4 예외 처리
[//]: # (// TODO)

### 1.5 테스트
[//]: # (// TODO)
- 테스트 코드는 E2E 테스트와 단위 테스트로 이루어져 있습니다.

---

## 2. 코드 빌드, 테스트, 실행 방법
[//]: # (// TODO)
- shell script로 빌드, 테스트, 실행을 한번에 할 수 있도록 구성

---

## 3. 기타 추가 정보
- 과제 내의 기능 구현의 범위를 설정하기 위해 필요했던 추가 정보들 입니다.

### 3.1 요구사항 정의(기능 제약)
- 브랜드는 각 카테고리별 상품을 하나씩 가지고 있다.
  - ~~브랜드가 특정 카테고리에 대한 상품이 존재하지 않는 경우는 없다.~~ -> 수정에 따라 존재할 수도 있음
  - 브랜드는 아이디로 식별하며, 이름이 같은 브랜드는 존재할 수 없다. 
- 상품은 반드시 가격을 가지고 있다.
  - 가격은 반드시 0 이상이다.
- 상품은 반드시 브랜드를 가지고 있다.
- 상품은 반드시 카테고리를 가지고 있다.

### 3.2 도출된 사용자 스토리와 인수 조건
- 사용자는 특정 카테고리의 최저 가격과 최고 가격의 상품을 조회할 수 있다.
  - 새로운 상품이 최저가 및 최고가로 등록되는 경우 해당 상품으로 조회되어야 한다. 
- 사용자는 전체 카테고리 별 최저 가격 상품과 그 합산 금액을 조회할 수 있다.
  - 모든 카테고리 중 하나라도 상품이 없는 브랜드의 경우 조회되지 않는다.
- 사용자는 전체 카테고리를 단일 브랜드로 구매하는 경우, 최저 금액 조합을 갖는 브랜드의 상품 리스트와 그 합산 금액을 조회할 수 있다.
- 관리자는 브랜드를 등록/조회/수정/삭제 할 수 있다.
- 관리자는 상품을 등록/조회/수정/삭제 할 수 있다.

### 3.3 향후 고려 사항
- 상품 가격의 할인 문제
  - 상품 가격 할인이 사용자 별로 상이한 경우, 가격 계산을 어떻게 할 것인가?  
- 동일 브랜드 문제 
  - 브랜드 명이 동일한 경우 어떻게 브랜드를 구분할 것인가?
- 동일 삼품 문제
  - 동일 브랜드의 동일 카테고리 동일 가격 상품을 어떻게 구분할 것인가? 
- 카테고리의 동적 처리 문제
  - 카테고리가 동적으로 변경될 수도 있는가?

- 가격 조회 API의 성능 문제
  - 가격 조합을 조회하는 API의 경우 DB의 윈도우 함수와 집계 함수에 의존하고 있음
  - 실시간으로 상품 혹은 카테고리, 브랜드 변경에 따른 조합이 변경되어야 하는 경우, 성능 이슈가 있을 수 있음
  - 변경에 따른 가격 조회 API의 성능 이슈를 해결하기 위해, 비즈니스 상 필요한 케이스가 구체화 되어야 함.

---

## 4. 해결 못한 문제들
- 실패 케이스의 테스트
- 조회 건 수에 따른 쿼리 성능과 해결 방법

### 4.1 아키텍쳐
- ~~응답 클래스를 별도로 만들어야 하는가?~~ => 만들다
  - 응답 클래스를 만들어야 한다면, 애플리케이션 계층은 도메인 모델을 응답하는가 애플리케이션을 응답하는가? => 도메인 모델을 응답
  - 응답 클래스는 어디에 위치해야 하는가. => adaptor
  - 매퍼가 필요하다면 어디에 위치하고 어느 것을 어떤 것으로 바꾸는 역할을 하는가?
- 간접 참조를 사용하고 도메인 모델과 ORM 매핑 엔티티 클래스를 분리해서 사용하는 경우, 참조 포함한 도메인 모델을 어떻게 만들 것인가? 
