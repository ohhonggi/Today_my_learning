-- 코드를 입력하세요
SELECT F.FOOD_TYPE, R.REST_ID, R.REST_NAME, F.FAVORITES
FROM (SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
FROM REST_INFO
GROUP BY FOOD_TYPE) AS F
JOIN REST_INFO AS R
ON (F.FOOD_TYPE = R.FOOD_TYPE
    AND F.FAVORITES = R.FAVORITES)
ORDER BY F.FOOD_TYPE DESC