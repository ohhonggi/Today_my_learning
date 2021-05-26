-- 이전에 빌린 기록이 있는 책들에 대해서 빌린 사람의 학번, 이름,
-- 책 고유번호, 책 이름을 출력하는 sql문을 작성하시오.
--select c.cno 학번, c.name 이름, p.e_isbn as "책 고유번호", e.title 책이름
--from ebook e, previousrental p join customer c
--on p.c_cno = c.cno
--where p.e_isbn = e.isbn

-- previousrental 테이블에서 책마다 빌린 사람의
-- 학번과 빌린 사람 수의 합을 집계하여 구하시오.
--select p.e_isbn, p.c_cno, count(*)
--from previousrental p
--group by rollup (p.e_isbn, p.c_cno)
--order by p.e_isbn

-- previousrental 테이블에서 책의 수를 rank
-- 로 집계하시오
--select distinct p.e_isbn, 
--    count(*) over(partition by p.e_isbn) as "빌린횟수"
--from previousrental p
--order by count(*) over(partition by p.e_isbn) desc

-- previousrental 테이블에서 책마다 빌려진 횟수를 계산하고,
-- 횟수가 높은 순서로 출력하시오.
--select DISTINCT e_isbn, all_rented,
--   dense_rank() over (order by all_rented DESC) as rank
--from (select e_isbn, count(*) over(partition by e_isbn) as all_rented
--        from previousrental)
--order by rank
