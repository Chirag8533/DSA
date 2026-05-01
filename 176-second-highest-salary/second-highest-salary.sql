# Write your MySQL query statement below
Select(select  distinct salary from Employee 
where salary is not null
Order by salary desc
limit 1 Offset 1) as SecondHighestSalary