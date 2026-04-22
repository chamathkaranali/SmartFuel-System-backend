CREATE TABLE users(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) UNIQUE,
    role VARCHAR(50)
);

CREATE TABLE fuel_shed(
    shed_id INT AUTO_INCREMENT PRIMARY KEY,
    shed_name VARCHAR(255) NOT NULL UNIQUE,
    location VARCHAR(255)
);

INSERT INTO users (user_name, email, role) VALUES
('admin', 'admin@smartfuel.com', 'ADMIN'),
('operator.colombo', 'operator.colombo@smartfuel.com', 'OPERATOR'),
('operator.kandy', 'operator.kandy@smartfuel.com', 'OPERATOR');

INSERT INTO fuel_shed (shed_name, location) VALUES
('FuelMart Colombo 07', 'Colombo 07'),
('GreenFuel Kandy', 'Kandy'),
('CityFuel Galle', 'Galle'),
('SmartFuel Negombo', 'Negombo'),
('EcoFuel Kurunegala', 'Kurunegala'),
('PrimeFuel Matara', 'Matara'),
('VitalFuel Jaffna', 'Jaffna');

