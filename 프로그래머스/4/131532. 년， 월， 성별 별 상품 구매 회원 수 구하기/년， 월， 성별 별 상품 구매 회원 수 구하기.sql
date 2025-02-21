-- 코드를 입력하세요
SELECT EXTRACT(YEAR from o.SALES_DATE) as YEAR, EXTRACT(MONTH from o.SALES_DATE) as MONTH, u.GENDER as gender, count(distinct(u.user_id)) as USERS
from user_info u
inner join online_sale o on u.user_id = o.user_id
group by EXTRACT(YEAR from o.SALES_DATE), EXTRACT(MONTH from o.SALES_DATE), u.GENDER
having u.gender is not null
order by year, month, gender;
