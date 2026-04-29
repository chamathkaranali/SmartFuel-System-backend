CREATE TABLE fuel_shed(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    location VARCHAR(255),
    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO fuel_shed (name, location, latitude, longitude) VALUES
('City Center Express', '123 Main St, Downtown', 40.7127760, -74.0059740),
('Highway Oasis', 'Exit 45, Interstate 95', 34.0522350, -118.2436830),
('Riverside Refuel', '88 River Road, North Port', 41.8781130, -87.6297990),
('Mountain Peak Gas', 'High Ridge Pass, Sector 7', 39.7392350, -104.9902510),
('Coastal Service Station', 'Pacific Coast Hwy, Bay Area', 37.7749290, -122.4194160),
('Green Valley Fuel', '42 Maple Avenue, Suburbia', 25.7616810, -80.1917880),
('Industrial Park Pumps', 'Building 4, Commerce Way', 42.3600810, -71.0588840);

