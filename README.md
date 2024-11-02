# README

## 1. 구현 범위에 대한 설명
- 해당 프로젝트를 이해하고 변경 위해 알아야 할 내용들 입니다.

### 1.1 아키텍쳐
- 헥사고날 아키텍쳐를 표방했습니다.

### 1.2 HTTP API
- [ ] 특정 브랜드의 카테고리 별 최소 금액 상품 리스트 조회
- [ ] ]

### 1.3 코드 컨벤션
- HTTP API의 매핑은 kebab-case로 작성합니다.
- 기본적으로 REST의 원칙을 따르지만 엄격한 RESTful을 지향하지 않습니다.
  - 버저닝을 허용합니다.
  - 자원에 대한 수정에 있어HTTP Method의 수정에 

### 1.4 예외 처리
### 1.5 테스트


# 코드 빌드, 테스트, 실행 방법
- shell script로 빌드, 테스트, 실행을 한번에 할 수 있도록 구성


# 기타 추가 정보

## 요구사항 정의(기능 제약)
- 브랜드는 각 카테고리별 상품을 하나씩 가지고 있다.
  - 브랜드가 특정 카테고리에 대한 상품이 존재하지 않는 경우는 없다.
  - 브랜드는 아이디로 식별하며, 이름이 같은 브랜드가 있을 수 있다. 이름이 같은 브랜드는 사업자 번호로 구분한다.
  - 동일 사업자 번호 + 브랜드 명이 동일한 경우는 존재하지 않는다.
- 상품은 반드시 가격을 가지고 있다.
  - 가격은 반드시 0 이상이다.
- 상품은 반드시 브랜드를 가지고 있다.
- 상품은 반드시 카테고리를 가지고 있다.

## 도출된 사용자 스토리
- 사용자는 카테고리별 최저 가격의 상품을 조회할 수 있다.
- 사용자는 카테고리별 최저 가격으로 조합


## 추가 고려 사항
- 동시성 관리 -> DB


## 해결 못한 문제들
### 아키텍쳐
- ~~응답 클래스를 별도로 만들어야 하는가?~~ => 만들다
  - 응답 클래스를 만들어야 한다면, 애플리케이션 계층은 도메인 모델을 응답하는가 애플리케이션을 응답하는가? => 도메인 모델을 응답
  - 응답 클래스는 어디에 위치해야 하는가. => adaptor
  - 매퍼가 필요하다면 어디에 위치하고 어느 것을 어떤 것으로 바꾸는 역할을 하는가?
