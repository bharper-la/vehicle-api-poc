-- Lookup table seed data
INSERT INTO vehicle_status_type (code, description) VALUES
                                                        ('AVAILABLE', 'Vehicle is available'),
                                                        ('SOLD', 'Vehicle has been sold');

INSERT INTO vehicle_condition_type (code, description) VALUES
                                                           ('NEW', 'Brand new condition'),
                                                           ('USED', 'Used condition');

INSERT INTO workflow_type (name, description) VALUES
    ('Default Workflow', 'Standard vehicle processing workflow');

INSERT INTO workflow_step_type (name, description) VALUES
                                                       ('Inspection', 'Vehicle inspection step'),
                                                       ('Sale', 'Vehicle sale step');

-- Contact info
INSERT INTO contact_info (email, phone_area_code, phone_exchange_number, phone_unit_number, phone_extension) VALUES
                                                                                                                 ('john.doe@example.com', '123', '456', '7890', NULL),
                                                                                                                 ('jane.smith@example.com', '987', '654', '3210', NULL);

-- Address
INSERT INTO address (line1, line2, city, state, postal_code) VALUES
                                                                 ('123 Main St', NULL, 'Metropolis', 'NY', '12345'),
                                                                 ('456 Elm St', 'Apt 2', 'Gotham', 'IL', '54321');

-- Users
INSERT INTO `user` (login, password, contact_info_id, address_id, enabled, created_at, updated_at) VALUES
                                                                                                       ('admin', 'password', 1, 1, TRUE, NOW(), NOW()),
                                                                                                       ('user1', 'password', 2, 2, TRUE, NOW(), NOW());

-- Leads
INSERT INTO `lead` (dealership, first_name, last_name, email, promo_code, referrer, status, status_date, expiration_date, created_at, updated_at, contact_info_id) VALUES
    ('Super Cars', 'Clark', 'Kent', 'clark.kent@example.com', 'PROMO123', 'Daily Planet', 'NEW', NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), NOW(), NOW(), 1);

-- Vehicles
INSERT INTO vehicle (vin, make, model, year, created_at, updated_at) VALUES
                                                                         ('1HGCM82633A004352', 'Honda', 'Accord', 2020, NOW(), NOW()),
                                                                         ('2HGCM82633A004353', 'Toyota', 'Camry', 2021, NOW(), NOW());

-- Vehicle Condition
INSERT INTO vehicle_condition (vehicle_id, condition_type_id, condition_date, comments) VALUES
    (1, 1, NOW(), 'Excellent condition');

-- Vehicle Status
INSERT INTO vehicle_status (vehicle_id, status_type_id, status_date, notes) VALUES
    (1, 1, NOW(), 'Ready for sale');

-- Vehicle Metadata
INSERT INTO vehicle_metadata (vehicle_id, type, data, created_at) VALUES
    (1, 'inspection', '{"mileage": 15000}', NOW());

-- Workflow
INSERT INTO workflow (name, type_id, created_at) VALUES
    ('Vehicle Sale Process', 1, NOW());

-- Workflow Step
INSERT INTO workflow_step (workflow_id, step_type_id, description, created_at) VALUES
    (1, 1, 'Initial inspection completed', NOW());

-- Workflow Log
INSERT INTO workflow_log (workflow_id, message, created_at) VALUES
    (1, 'Workflow started', NOW());

-- Workflow Queue
INSERT INTO workflow_queue (workflow_id, status, created_at) VALUES
    (1, 'Pending', NOW());

-- Auction Filter
INSERT INTO auction_filter (user_id, filter_data, created_at) VALUES
    (1, '{"make": "Honda"}', NOW());

-- Auction Watch
INSERT INTO auction_watch (user_id, watch_data, created_at) VALUES
    (1, '{"vin": "1HGCM82633A004352"}', NOW());
