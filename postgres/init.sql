CREATE TABLE todos (
                       id SERIAL PRIMARY KEY,
                       description VARCHAR(255),
                       note TEXT,
                       created_at TIMESTAMP
);

INSERT INTO todos (description, note, created_at)
VALUES

    ('Complete homework assignment', 'Due by Friday', '2024-05-30 10:00:00'),
    ('Buy groceries', 'Milk, bread, eggs', '2024-05-30 12:30:00'),
    ('Call mom', 'Wish her a happy birthday', '2024-05-30 15:45:00');
