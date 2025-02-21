-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(b.price*bs.sales) as total_sales
from author a
join book b on a.author_id = b.author_id
join book_sales bs on b.book_id = bs.book_id
where to_char(bs.sales_date,'mm') = '01'
group by a.author_id, a.author_name, b.category
order by author_id asc, category desc;
