-- 코드를 입력하세요
SELECT purchase.USER_ID, purchase.PRODUCT_ID
FROM (SELECT USER_ID, PRODUCT_ID, count(*) as c
    FROM ONLINE_SALE
    GROUP BY USER_ID, PRODUCT_ID) as purchase
where purchase.c > 1
ORDER BY purchase.USER_ID ASC, purchase.PRODUCT_ID DESC