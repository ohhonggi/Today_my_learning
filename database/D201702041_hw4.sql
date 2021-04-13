--SELECT ENAME,HIREDATE,
--    TRUNC(MONTHS_BETWEEN(CAST('2021-02-20' AS DATE), HIREDATE)/12) 연차,    
--    TRUNC((CAST('2021-02-20' AS DATE) - HIREDATE)/365) 연차
--FROM EMP,DUAL;
--SELECT LOC,
--    CASE LOC
--    WHEN 'NEW YORK' THEN 'east'
--    WHEN 'boston' THEN 'east'
--    WHEN 'chicago' THEN 'center'
--    WHEN 'dallas' THEN 'center'
--    ELSE 'etc'
--    END AS AREA
--FROM DEPT

--SELECT PLAYER_NAME, HEIGHT,
--    CASE
--    WHEN HEIGHT >= 190 THEN 'long'
--    WHEN HEIGHT >= 180 THEN 'average'
--    ELSE 'short'
--    END AS aver
--FROM PLAYER
 
SELECT PLAYER_NAME,JOIN_YYYY,
    CASE 
        WHEN JOIN_YYYY = '2002'
        THEN '2002 WorldCup player'
        ELSE (CASE 
                WHEN JOIN_YYYY LIKE '20%'
                THEN 'player'                
                ELSE NVL(JOIN_YYYY,'no year player') END)
        END AS PLAYER
FROM PLAYER
