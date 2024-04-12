# Elasticsearch와 Spring Boot를 이용한 예제 프로젝트

이 프로젝트는 Spring Boot와 Elasticsearch을 사용한 간단한 CRUD기능의 RESTful API예제입니다.

## CRUD


### 제품 추가

-   **POST** `/products`
-   **body**:
    

    
    `{
      "name": "삼성 보조배터리",
      "description": "든든 보조배터리 강력"
    }` 
---    

### 설명으로 제품 검색

-   **GET** `/products/search?description=키워드`
- ---

### 제품 세부 정보 가져오기

-   **GET** `/products/{id}`
- ---

### 제품 업데이트

-   **PUT** `/products`
-   **body**:
    

    
    `{
      "id": "제품-id",
      "name": "업데이트된 제품 이름",
      "description": "업데이트된 제품 설명"
    }` 
---

### 제품 삭제

-   **DELETE** `/products/{id}`




## 더미 데이터 관리

애플리케이션 시작 시 자동으로 더미 데이터를 삽입하며, 
애플리케이션 종료 시 더미 데이터는 자동으로 삭제됩니다.