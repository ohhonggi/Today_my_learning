--select
--    decode(grouping(team_id), 1,
--    'all team', team_id) "팀ID",
--    decode(grouping(position), 1,
--    'all position', position) "포지션",
--    count(*) "합"
--from player
--where position is not null
--group by grouping sets (team_id, position)
--order by team_id

-- player 테이블 내의 position과 team_id이 가질 수 있는 모든 경우의 대해
-- subtotal을 생성해라 (position이 null인 데이터는 제외하고 출력하여라)
--
--select
--    case grouping(position)
--    when 1 then 'all position'
--    else position end "포지션",
--    case grouping(team_id)
--    when 1 then 'all team_id'
--    else team_id end "팀ID",
--    count(*) "총 선수"
--from player
--where position is not null
--group by cube (position, team_id)

--select team_id "팀ID", count(*) "소속선수 수",
--    rank() over (order by count(*) desc) rank,
--    DENSE_RANK() over (order by  count(*) desc) dense_rank
--from player
--group by team_id

--select team_id 팀ID, player_name 선수명, height 선수키,
--    max(height) over (partition by team_id) as "최장신 선수 키",
--    min(height) over (partition by team_id) as "최단신 선수 키"
--from player

--select player_name 선수명, join_yyyy 입단년도, weight 체중,
--    trunc (avg(weight) over (PARTITION by join_yyyy), 1) 평균몸무게
--from player;

--select position, player_name, join_yyyy,
--    first_value(player_name) over
--    (partition by position order by join_yyyy asc,
--    player_name asc rows unbounded preceding) "입단연도가 가장 빠른선수",
--    last_value(player_name) over
--    (partition by position order by join_yyyy asc,
--    player_name asc rows between current row
--    and unbounded following) "입단연도가 가장 느린선수"
--from player
--where join_yyyy is not null

select player_name, weight,
    ntile(50) over (order by weight desc) "50분할"
from player
where weight is not null
and weight >= 70










