-- Refactored SQL schema (extended normalization)

-- Lookup Tables
CREATE TABLE vehicle_status_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(50) NOT NULL UNIQUE,
  description VARCHAR(255)
);

CREATE TABLE vehicle_condition_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(50) NOT NULL UNIQUE,
  description VARCHAR(255)
);

CREATE TABLE workflow_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE,
  description TEXT
);

CREATE TABLE workflow_step_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE,
  description TEXT
);

-- Contact Info
CREATE TABLE contact_info (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255),
  phone_area_code VARCHAR(10),
  phone_exchange_number VARCHAR(10),
  phone_unit_number VARCHAR(10),
  phone_extension VARCHAR(10)
);

-- Address
CREATE TABLE address (
  id INT AUTO_INCREMENT PRIMARY KEY,
  line1 VARCHAR(255),
  line2 VARCHAR(255),
  city VARCHAR(100),
  state VARCHAR(50),
  postal_code VARCHAR(20)
);

-- Users
CREATE TABLE `user` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  contact_info_id INT,
  address_id INT,
  enabled BOOLEAN DEFAULT TRUE,
  created_at DATETIME,
  updated_at DATETIME,
  FOREIGN KEY (contact_info_id) REFERENCES contact_info(id),
  FOREIGN KEY (address_id) REFERENCES address(id)
);

-- Leads
CREATE TABLE `lead` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  dealership VARCHAR(100),
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  email VARCHAR(255),
  promo_code VARCHAR(100),
  referrer VARCHAR(100),
  status VARCHAR(100),
  status_date DATE,
  expiration_date DATE,
  created_at DATETIME,
  updated_at DATETIME,
  contact_info_id INT,
  FOREIGN KEY (contact_info_id) REFERENCES contact_info(id)
);

-- Vehicles
CREATE TABLE vehicle (
  id INT AUTO_INCREMENT PRIMARY KEY,
  vin VARCHAR(50) NOT NULL UNIQUE,
  make VARCHAR(50),
  model VARCHAR(50),
  year INT,
  created_at DATETIME,
  updated_at DATETIME
);

-- Vehicle Condition
CREATE TABLE vehicle_condition (
  id INT AUTO_INCREMENT PRIMARY KEY,
  vehicle_id INT NOT NULL,
  condition_type_id INT,
  condition_date DATE,
  comments TEXT,
  FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
  FOREIGN KEY (condition_type_id) REFERENCES vehicle_condition_type(id)
);

-- Vehicle Status
CREATE TABLE vehicle_status (
  id INT AUTO_INCREMENT PRIMARY KEY,
  vehicle_id INT NOT NULL,
  status_type_id INT NOT NULL,
  status_date DATE,
  notes TEXT,
  FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
  FOREIGN KEY (status_type_id) REFERENCES vehicle_status_type(id)
);

-- Vehicle Metadata (EAV pattern)
CREATE TABLE vehicle_metadata (
  id INT AUTO_INCREMENT PRIMARY KEY,
  vehicle_id INT NOT NULL,
  type VARCHAR(100) NOT NULL, -- e.g., 'inspection', 'insurance'
  data JSON NOT NULL,
  created_at DATETIME,
  FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);

-- Workflow
CREATE TABLE workflow (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  type_id INT,
  created_at DATETIME,
  FOREIGN KEY (type_id) REFERENCES workflow_type(id)
);

CREATE TABLE workflow_step (
  id INT AUTO_INCREMENT PRIMARY KEY,
  workflow_id INT,
  step_type_id INT,
  description TEXT,
  created_at DATETIME,
  FOREIGN KEY (workflow_id) REFERENCES workflow(id),
  FOREIGN KEY (step_type_id) REFERENCES workflow_step_type(id)
);

CREATE TABLE workflow_log (
  id INT AUTO_INCREMENT PRIMARY KEY,
  workflow_id INT,
  message TEXT,
  created_at DATETIME,
  FOREIGN KEY (workflow_id) REFERENCES workflow(id)
);

CREATE TABLE workflow_queue (
  id INT AUTO_INCREMENT PRIMARY KEY,
  workflow_id INT,
  status VARCHAR(100),
  created_at DATETIME,
  FOREIGN KEY (workflow_id) REFERENCES workflow(id)
);

CREATE TABLE auction_filter (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  filter_data JSON,
  created_at DATETIME,
  FOREIGN KEY (user_id) REFERENCES `user`(id)
);

CREATE TABLE auction_watch (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  watch_data JSON,
  created_at DATETIME,
  FOREIGN KEY (user_id) REFERENCES `user`(id)
);
