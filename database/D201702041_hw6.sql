--select e.empno , e.ename, d.deptno, d.dname
--from dept d, emp e
--where e.deptno = d.deptno

select sc.sche_date 경기일, st.stadium_name 구장명,
    ht.team_name as 홈팀이름, at.team_name as 원정팀이름    
from stadium st, schedule sc, team ht, team at
where sc.stadium_id = st.stadium_id
and sc.hometeam_id = ht.team_id
and sc.awayteam_id = at.team_id
order by sc.sche_date, st.stadium_name

-- 팀 id와 선수 이름, 팀이름, 포지션을 찾아본다.
--select team_id, player_name, team_name, position
--from player natural join team;

-- 홈팀 점수와 원정팀 점수가 null이 아닌 값들에 대해 schedule과 stadium을
-- stadium_id로 join 하여 경기일과 구장명, 홈팀 점수 및 원정팀 점수를 출력하라.
--select s.sche_date 경기일, d.stadium_name 구장명,
--    s.home_score, s.away_score
--from schedule s join stadium d
--on s.stadium_id = d.stadium_id
--where s.home_score is not null
--and s.away_score is not null

--select *
--from stadium s cross join team t
-- 300

--select *
--from stadium st right join team t
--on st.stadium_id = t.stadium_id
-- 15

--select stadium_name, stadium.stadium_id, seat_count,
--    hometeam_id, team_name
--from stadium left outer join team
--on stadium.hometeam_id = team.team_id
--order by hometeam_id
















