DELETE FROM taco_ingredient;
DELETE FROM taco_order;
DELETE FROM taco;
DELETE FROM ingredient;


INSERT INTO ingredient(id, name, type) VALUES
('FLTO', 'Flour Tortilla', 'WRAP'),
('COTO', 'Corn Tortilla', 'WRAP'),
('GRBF', 'Ground Beef', 'PROTEIN'),
('CARN', 'Carnitas', 'PROTEIN'),
('TMTO', 'Diced Tomatoes', 'VEGGIES'),
('LETC', 'Lettuce', 'VEGGIES'),
('CHED', 'Cheddar', 'CHEESE'),
('JACK', 'Monterrey Jack', 'CHEESE'),
('SLSA', 'Salsa', 'SAUCE'),
('SRCR', 'Sour Cream', 'SAUCE');


INSERT INTO users(username, password, full_name, street, city, state, zip, phone_number) VALUES
('admin', '$2a$12$yzu8xNUK1bJy.EakqA2SaukdMZHfLfpKLo4l2pjcfwpcpwKY6gCQK', 'admin', 'mock street', 'mock city', 'mock state', 'mock zip', 'mock phone number');