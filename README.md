Shopping mall _ Project 작업계획서

### Swagger URL List

![swagger_url_list.PNG](https://github.com/Yujaehyeong/shoppingmall_1/blob/master/3week/swagger_url_list.PNG?raw=true)



------



### 쇼핑몰 작업계획 테이블



##### 유저관련 테이블

|       API목록       |          URL          | 예상일정 | 예상소요시간 | 개발일정 | 개발시간  |                          작업결과서                          |
| :-----------------: | :-------------------: | :------: | :----------: | :------: | :-------: | :----------------------------------------------------------: |
| 아이디 중복체크 API | user/checkid/{userId} |   7.15   |  1h(1시간)   |   7.15   | 1h(1시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%ED%9A%8C%EC%9B%90#%EC%95%84%EC%9D%B4%EB%94%94-%EC%A4%91%EB%B3%B5%EC%B2%B4%ED%81%AC-api) |
|    회원가입 API     |       user/join       |   7.16   |  1h(1시간)   |   7.16   | 30M(30분) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%ED%9A%8C%EC%9B%90#%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-api) |
|     로그인 API      |      user/login       |   7.16   |  1h(1시간)   |   7.16   | 30M(30분) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%ED%9A%8C%EC%9B%90#%EB%A1%9C%EA%B7%B8%EC%9D%B8-api) |



------



##### 장바구니관련 테이블

|               API목록               |        URL         | 예상일정 | 예상소요시간 | 개발일정 |      개발시간      |                          작업결과서                          |
| :---------------------------------: | :----------------: | :------: | :----------: | :------: | :----------------: | :----------------------------------------------------------: |
|   장바구니 담기 API(회원, 비회원)   |      cart/put      |   7.17   |  2h(2시간)   |   7.17   |     30M(30분)      | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88#%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88%EB%8B%B4%EA%B8%B0-api) |
| 장바구니 목록보기 API(회원, 비회원) | cart/list/{userId} |   7.17   |  2h(2시간)   |   7.17   | 1h 30M(1시간 30분) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88#%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88-%EB%AA%A9%EB%A1%9D%EB%B3%B4%EA%B8%B0-api) |



------



##### 주문관련 테이블

|            API목록             |         URL         | 예상일정 |    예상소요시간     | 개발일정 | 개발시간  |                          작업결과서                          |
| :----------------------------: | :-----------------: | :------: | :-----------------: | :------: | :-------: | :----------------------------------------------------------: |
|   주문하기 API(회원, 비회원)   |      order/add      |   7.18   |      2h(2시간)      |   7.19   | 2h(2시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%A3%BC%EB%AC%B8#%EC%A3%BC%EB%AC%B8%ED%95%98%EA%B8%B0-api) |
| 주문목록보기 API(회원, 비회원) | order/list/{userId} |   7.22   | 1h 30분(1시간 30분) |   7.22   | 1h(1시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%A3%BC%EB%AC%B8#%EC%A3%BC%EB%AC%B8%EB%AA%A9%EB%A1%9D%EB%B3%B4%EA%B8%B0-api) |
| 주문상세보기 API(회원, 비회원) |   order/{orderNo}   |   7.22   |      2h(2시간)      |   7.23   | 2h(2시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%A3%BC%EB%AC%B8#%EC%A3%BC%EB%AC%B8%EC%83%81%EC%84%B8%EB%B3%B4%EA%B8%B0-api) |



------



##### 상품관련 테이블

|         API목록         |         URL         | 예상일정 |    예상소요시간    |  개발일정   | 개발시간  |                          작업결과서                          |
| :---------------------: | :-----------------: | :------: | :----------------: | :---------: | :-------: | :----------------------------------------------------------: |
|    상품정보보기 API     | product/{productNo} |   7.23   |     2h(2시간)      |    7.23     | 2h(2시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC#%EC%83%81%ED%92%88%EC%A0%95%EB%B3%B4%EB%B3%B4%EA%B8%B0-api) |
| 상품추가하기API(관리자) |     product/add     |   7.24   |     2h(2시간)      | 7.24 - 7.25 | 2h(2시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC#%EC%83%81%ED%92%88%EC%83%81%ED%92%88-%EC%A7%84%EC%97%B4%EC%83%81%ED%92%88-%EC%98%B5%EC%85%98-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%B6%94%EA%B0%80%ED%95%98%EA%B8%B0-api) |
| 상품삭제하기API(관리자) | product/{productNo} |   7.25   |     2h(2시간)      |    7.25     | 30M(30분) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC#%EC%83%81%ED%92%88%EC%82%AD%EC%A0%9C%ED%95%98%EA%B8%B0-api) |
| 상품수정하기API(관리자) |   product/modify    |   7.25   |     2h(2시간)      |    7.25     | 2h(2시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC#%EC%83%81%ED%92%88%EC%88%98%EC%A0%95%ED%95%98%EA%B8%B0-api) |
|     상품목록보기API     |    product/list     |   7.25   | 2h 30M(2시간 30분) |    7.29     | 2h(2시간) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC#%EC%83%81%ED%92%88%EB%AA%A9%EB%A1%9D%EB%B3%B4%EA%B8%B0-api) |



------



### 전체구현일정 테이블

|       기능        |           일정            | 구현완료 여부 | 기능추가여부 |
| :---------------: | :-----------------------: | :-----------: | :----------: |
|   유저관련 기능   |       7.15  ~ 7. 16       |       O       |      ?       |
| 장바구니관련 기능 |        7.17 ~ 7.17        |       O       |      ?       |
|   주문관련 기능   | 7.18 ~ 7.19 / 7.22 ~ 7.23 |       O       |      ?       |
|   상품관련 기능   | 7.23~ 7.26 / 7.29 ~ 7.29  |       O       |      ?       |
|  프론트서버 구현  |           7.30~           |       X       |             |

