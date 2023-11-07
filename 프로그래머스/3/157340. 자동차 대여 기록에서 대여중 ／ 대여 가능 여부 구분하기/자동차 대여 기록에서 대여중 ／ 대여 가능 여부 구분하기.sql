-- 코드를 입력하세요
# SELECT C.CAR_ID
# # (CASE WHEN END_DATE LIKE '2022-10-16%' THEN '대여중' 
# # ELSE '대여 가능' END) AS AVAILABILITY
# FROM (SELECT CAR_ID 
#       FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#       WHERE END_DATE >= '2022-10-16') AS C
# GROUP BY C.CAR_ID
# ORDER BY C.CAR_ID DESC

SELECT C.CAR_ID,
(CASE WHEN C.START_DATE <= '2022-10-16' AND C.END_DATE >= '2022-10-16' THEN '대여중'
 ELSE '대여 가능' END) AS AVAILABILITY
FROM (SELECT *
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE END_DATE >= '2022-10-16'
    ORDER BY END_DATE
    ) AS C
GROUP BY C.CAR_ID
ORDER BY C.CAR_ID DESC
