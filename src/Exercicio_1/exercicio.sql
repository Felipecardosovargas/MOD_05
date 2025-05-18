-- Dados de exemplo para a tabela employees
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(255),
    job_title VARCHAR(255),
    salary INT,
    hire_date DATE
);

INSERT INTO employees (emp_id, emp_name, job_title, salary, hire_date) VALUES
    (1, 'Alice', 'Manager', 60000, '2020-01-15'),
    (2, 'Bob', 'Developer', 50000, '2019-05-20'),
    (3, 'Charlie', 'Sales', 45000, '2021-03-10'),
    (4, 'Diana', 'Manager', 62000, '2022-02-28'),
    (5, 'Eve', 'Marketing', 48000, '2020-11-12');

SELECT *
FROM employees;

SELECT emp_id, emp_name, job_title, salary, hire_date
FROM employees
WHERE salary > 55000;

SELECT emp_id, emp_name, job_title, salary, hire_date
FROM employees
WHERE hire_date > '2020-12-31';
-- Ou, de forma mais legível para o ano:
-- WHERE EXTRACT(YEAR FROM hire_date) > 2020;


SELECT emp_id, emp_name, job_title, salary, hire_date
FROM employees
WHERE emp_name LIKE 'A%';

-- Dados de exemplo para a tabela orders
CREATE TABLE orders (
    rder_id INT PRIMARY KEY,
    customer_id INT,
    total_amount DECIMAL(10, 2), -- Usando DECIMAL para valores monetários
    order_date DATE
);

INSERT INTO orders (order_id, customer_id, total_amount, order_date) VALUES
    (1, 101, 250.00, '2023-01-05'),
    (2, 102, 300.00, '2023-02-10'),
    (3, 101, 150.00, '2023-01-20'),
    (4, 103, 200.00, '2023-03-15'),
    (5, 102, 350.00, '2023-02-28');

SELECT SUM(total_amount) AS total_geral_pedidos
FROM orders;

SELECT customer_id, SUM(total_amount) AS total_pedidos_por_cliente
FROM orders
GROUP BY customer_id
ORDER BY customer_id; -- Opcional, para ordenar os resultados

SELECT
    AVG(total_amount) AS media_valor_pedido,
    SUM(total_amount) AS valor_total_pedidos
FROM orders;