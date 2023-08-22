-- 코드를 입력하세요
SELECT C.CAR_ID, C.AVERAGE_DURATION
FROM (SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1),1) as AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID) AS C
WHERE C.AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, C.CAR_ID DESC
