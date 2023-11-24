CREATE TABLE Books (
	book_id SERIAL PRIMARY KEY,
	title VARCHAR(100),
	genre VARCHAR(100),
	price INT NOT NULL,
	stock INT
);

CREATE TABLE Authors (
	author_id SERIAL PRIMARY KEY,
	author_name VARCHAR(100)
);

CREATE TABLE Orders (
	order_id SERIAL PRIMARY KEY,
	customer_id INT REFERENCES Customer(customer_id),
	order_date DATE,
	total_cost INT NOT NULL
); 

CREATE TABLE Customer (
	customer_id SERIAL PRIMARY KEY,
	address VARCHAR(100),
	email VARCHAR(50),
	customer_name VARCHAR(100)	
);

CREATE TABLE BooksInformation (
	book_id INT REFERENCES Books(book_id),
	author_id INT REFERENCES Authors(author_id),
	PRIMARY KEY (book_id, author_id)
);

CREATE TABLE OrderInformation (
	order_id INT REFERENCES Orders(order_id),
    book_id INT REFERENCES Books(book_id),
    PRIMARY KEY (order_id, book_id)
);

