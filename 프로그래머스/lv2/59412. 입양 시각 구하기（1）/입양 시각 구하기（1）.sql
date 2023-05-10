-- 코드를 입력하세요
SELECT left(a.HOUR,2) as HOUR, count(a.animal_id) as 'COUNT'
from (select substring(datetime, 12,19) as HOUR, animal_id
     from animal_outs
     having HOUR between '09:00:00' and '19:59:59'
     ) as a
group by left(a.HOUR,2)
order by left(a.HOUR,2)