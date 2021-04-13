--select team_id ÆÀ, round(avg(height),1) Æò±ÕÅ°, round(avg(weight),1) Æò±Õ¸ö¹«°Ô
--from player
--group by team_id

--select job ¿ªÇÒ, count(*) Á÷¿ø¼ö, sum(sal*12+NVL2(comm,comm,0)) ¿¬ºÀÃÑÇÕ,
--trunc(avg(sal*12+NVL2(comm,comm,0))) ¿¬ºÀÆò±Õ, trunc(stddev(sal*12+NVL2(comm,comm,0))) ¿¬ºÀÇ¥ÁØÆíÂ÷
--from emp
--group by job
--having trunc(avg(sal*12+NVL2(comm,comm,0)))>=30000

--select job ¿ªÇÒ, ename ÀÌ¸§, hiredate ÀÔ»çÀÏ, sal ¿ù±Þ¿©
--from emp
--where job = 'CLERK' or job = 'MANAGER'
--order by job desc, hiredate desc, sal asc

select *
from (select team_id ÆÀ, count(team_id) ¸í¼ö
      from player
      where e_player_name is not null 
      group by team_id
      having count(team_id)>=20
      order by count(team_id) desc)
where rownum <=4
 
 
 
