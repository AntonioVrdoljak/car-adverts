CREATE TABLE car_adverts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    fuelType VARCHAR(50) NOT NULL,
    price INT NOT NULL,
    isNew BOOLEAN NOT NULL,
    mileage INT,
    firstRegistration DATE
);