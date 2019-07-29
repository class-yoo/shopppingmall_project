# Shopping mall _ Project



### Swagger URL List

![swagger_url_list.PNG](https://github.com/Yujaehyeong/shoppingmall_1/blob/master/3week/swagger_url_list.PNG?raw=true)



------



### 쇼핑몰 작업계획 테이블

| API목록                             | URL                                                          | 예상일정 | 예상소요시간        | 개발일정    | 개발시간           | 작업결과서                                                   |
| :---------------------------------- | ------------------------------------------------------------ | -------- | ------------------- | ----------- | ------------------ | ------------------------------------------------------------ |
| 아이디 중복체크 API                 | user/checkid/{userId}                                        | 7.15     | 1h(1시간)           | 7.15        | 1h(1시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%ED%9A%8C%EC%9B%90) |
| 로그인 API                          | user/join                                                    | 7.16     | 1h(1시간)           | 7.16        | 30M(30분)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%ED%9A%8C%EC%9B%90) |
| 회원가입 API                        | user/login                                                   | 7.16     | 1h(1시간)           | 7.16        | 30M(30분)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%ED%9A%8C%EC%9B%90) |
| 장바구니 목록보기 API(회원, 비회원) | cart/list/{userId}                                           | 7.17     | 2h(2시간)           | 7.17        | 1h 30M(1시간 30분) | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88) |
| 장바구니 담기 API(회원, 비회원)     | cart/put                                                     | 7.17     | 2h(2시간)           | 7.17        | 30M(30분)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88) |
| 주문하기 API(회원, 비회원)          | order/add                                                    | 7.18     | 2h(2시간)           | 7.19        | 2h(2시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%A3%BC%EB%AC%B8) |
| 주문목록보기 API(회원, 비회원)      | order/list/{userId}                                          | 7.22     | 1h 30분(1시간 30분) | 7.22        | 1h(1시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%A3%BC%EB%AC%B8) |
| 주문상세보기 API(회원, 비회원)      | order/{orderNo}                                              | 7.22     | 2h(2시간)           | 7.23        | 2h(2시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/3-Week-%EC%A3%BC%EB%AC%B8) |
| 상품정보보기 API(관리자)            | product/{productNo}                                          | 7.24     | 3h(2시간)           | 7.24        | 2h(2시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC) |
| 상품추가하기API(관리자)             | product/add                                                  | 7.24     | 2h(2시간)           | 7.24 - 7.25 | 2h(2시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC) |
| 상품삭제하기API(관리자)             | product/remove/{productNo}                                   | 7.25     | 2h(2시간)           | 7.25        | 30M(30분)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC) |
| 상품수정하기API(관리자)             | product/modify                                               | 7.25     | 2h(2시간)           | 7.25        | 2h(2시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC) |
| 상품목록보기API                     | product/list/{keyword}/{category}/{curpageNum}/{showProductNum} | 7.25     | 2h 30M(2시간 30분)  | 7.29        | 2h(2시간)          | [보기](https://github.com/Yujaehyeong/shoppingmall_1/wiki/4-Week-%EC%83%81%ED%92%88%EA%B4%80%EB%A6%AC) |

