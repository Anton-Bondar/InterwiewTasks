-- Виріши задачу мовою SQL. Є табличка employee_salary з такими полями:
--
-- BIGINT employee_id, DOUBLE salary, DATE salary_date
--
-- В результуючій вибірці, вивести три записи з найбільшою середньою salary за останні два тижні. В таблиці можуть бути дублікати employee_id
CREATE TABLE IF NOT EXISTS employee_salary(
                                              employee_id BIGINT,
                                              salary DECIMAL,
                                              salary_date DATE
);

SELECT employee_id, AVG(salary) as avg_salary
FROM employee_salary
WHERE salary_date >= CURRENT_DATE - INTERVAL '2 weeks'
GROUP BY employee_id
ORDER BY avg_salary DESC
LIMIT 3;