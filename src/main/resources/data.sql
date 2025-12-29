INSERT INTO patient (name, birth_date, email, gender, created_at, blood_group)
VALUES
('Mohit Bagul', '2003-07-29', 'mohit@gmail.com', 'Male', CURRENT_DATE, 'A_POS'),

('Piyush Bagul', '2008-12-06', 'piyush@gmail.com', 'Male', CURRENT_DATE, 'B_POS'),

('Riya Sharma', '1999-03-15', 'riya@gmail.com', 'Female', CURRENT_DATE, 'O_POS'),

('Amit Verma', '1995-11-10', 'amit@gmail.com', 'Male', CURRENT_DATE, 'A_NEG'),

('Sneha Patil', '2001-05-22', 'sneha@gmail.com', 'Female', CURRENT_DATE, 'AB_POS');


INSERT INTO doctor (id, name, specialization, email) VALUES
(1, 'Dr. Anjali Sharma', 'Cardiology', 'anjali.sharma@hospital.com');

INSERT INTO doctor (id, name, specialization, email) VALUES
(2, 'Dr. Rohit Mehta', 'Orthopedics', 'rohit.mehta@hospital.com');

INSERT INTO doctor (id, name, specialization, email) VALUES
(3, 'Dr. Neha Kulkarni', 'Neurology', 'neha.kulkarni@hospital.com');
