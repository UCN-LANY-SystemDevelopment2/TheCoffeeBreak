CREATE DATABASE TheCoffeeBreak;
GO

USE TheCoffeeBreak;

CREATE TABLE Products(
	Id int PRIMARY KEY NOT NULL,
	Name nvarchar(50) UNIQUE NOT NULL, 
	Description nvarchar(MAX), 
	Price decimal(18,2)
);

CREATE TABLE Orders(
	Id int PRIMARY KEY NOT NULL,
	CustomerName nvarchar(50) NOT NULL,
	Finished DATETIME,
	Discount decimal(18,2) DEFAULT(0)
);

CREATE TABLE OrderLines(
	Id int PRIMARY KEY NOT NULL,
	OrderId int FOREIGN KEY REFERENCES Orders(Id) NOT NULL,
	ProductId int FOREIGN KEY REFERENCES Products(Id) NOT NULL,
	Quantity int NOT NULL,
	SubTotal decimal(18,2) NOT NULL
);
GO 

-- Products
INSERT INTO Products VALUES (1, 'Americano', 'Espresso shots topped with hot water create a light layer of crema culminating in this wonderfully rich cup with depth and nuance.', 22.5);
INSERT INTO Products VALUES (2, 'Dark Roast Coffee', 'This full-bodied dark roast coffee with bold, robust flavors showcases our roasting and blending artistry—an essential blend of balanced and lingering flavors.', 32.5);
INSERT INTO Products VALUES (3, 'Misto', 'A one-to-one combination of fresh-brewed coffee and steamed milk add up to one distinctly delicious coffee drink remarkably mixed.', 32.5);
INSERT INTO Products VALUES (4, 'Cappuccino', 'Dark, rich espresso lies in wait under a smoothed and stretched layer of thick milk foam. An alchemy of barista artistry and craft.', 29.5);
INSERT INTO Products VALUES (5, 'Espresso', 'Our smooth signature Espresso Roast with rich flavor and caramelly sweetness is at the very heart of everything we do.', 19.5);
INSERT INTO Products VALUES (6, 'Latte', 'Our dark, rich espresso balanced with steamed milk and a light layer of foam. A perfect milk-forward warm-up.', 29.5);
INSERT INTO Products VALUES (7, 'Cinnamon Dolce Latte', 'We add freshly steamed milk and cinnamon dolce-flavored syrup to our classic espresso, topped with sweetened whipped cream and a cinnamon dolce topping to bring you specialness in a treat.', 32.5);
INSERT INTO Products VALUES (8, 'Flat White', 'Smooth ristretto shots of espresso get the perfect amount of steamed whole milk to create a not-too-strong, not-too-creamy, just-right flavor.', 29.5);
INSERT INTO Products VALUES (9, 'Caramel Macchiato', 'Freshly steamed milk with vanilla-flavored syrup marked with espresso and topped with a caramel drizzle for an oh-so-sweet finish.', 29.5);

