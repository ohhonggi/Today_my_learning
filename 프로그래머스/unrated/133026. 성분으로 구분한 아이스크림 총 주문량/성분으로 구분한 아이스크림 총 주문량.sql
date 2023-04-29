-- 코드를 입력하세요
SELECT i.ingredient_type, sum(f.total_order) as TOTAL_ORDER
from icecream_info as i, first_half as f
where i.flavor = f.flavor
group by ingredient_type
order by ingredient_type desc