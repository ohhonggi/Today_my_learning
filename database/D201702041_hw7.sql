--부서번호가 20 인 사람들의 집합과 부서번호가 30인 사람들의 집합의 합집합
--select *
--from emp
--where deptno = 30
--union
--select *
--from emp
--where deptno = 20

--select *
--from emp
--where sal >= 1000
--minus
--select *
--from emp
--where job = 'CLERK'

-- family 테이블에서 구성(composition)이 증조할아버지(greatgrandfather)인 
-- 사람부터 아들(son)까지 부모 관계(parent_node)를 순방향 전개로 나타내시오.
--select level, lpad(' ', 4 * (level-1)) || composition,person_name, parent_node,
--    CONNECT_BY_ISLEAF
--from family
--start with parent_node is null
--connect by prior composition = parent_node

-- 사원번호(empno)가 7876으로부터 상위 관리자(mgr)를 찾는 역방향 전개를 구하시오
--select level, lpad(' ', 4 * (level -1)) || job, empno, mgr, connect_by_isleaf
--isleaf
--from emp
--start with empno = 7876
--connect by prior mgr = empno;

-- 차상위관리자가 없는 사원(사장,매니저)을 제외하고 자신의 직속관리자를
-- 기준으로 하여 차상위관리자를 셀프조인을 이용하여 구하고, 사원 번호
-- 직속관리자 번호, 차상위관리자 번호를 구하시오.
--select e1.empno 사원, e1.mgr, e2.mgr 차상위관리자
--from emp e1, emp e2
--where e1.mgr = e2.empno
--and e2.mgr is not null
--order by e1.empno

select e1.empno 사원, e1.mgr, e2.mgr 차상위관리자
from emp e1 left outer join emp e2
 on (e1.mgr = e2.empno)
order by e1.empno








