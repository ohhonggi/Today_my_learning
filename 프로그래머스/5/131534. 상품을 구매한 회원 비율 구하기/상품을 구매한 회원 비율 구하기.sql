select year(sales_date) as year,month(sales_date) as month, 
count(distinct(a.user_id)) as puchased_users,
round(count(distinct(a.user_id))/
(select count(distinct(user_Id)) from user_info where joined like '2021%'),1) as puchased_ratio
from user_info a
left join online_sale b
on a.user_id = b.user_id 
where sales_date is not null and joined like '2021%'
group by month(sales_date)
order by 1 asc, 2 asc