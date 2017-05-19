DROP PROCEDURE IF EXISTS delivery;
DROP PROCEDURE IF EXISTS producePallet;
DROP PROCEDURE IF EXISTS placeOrder;

DELIMITER //
CREATE PROCEDURE delivery(
	IN ing varchar(40), 
	IN dt datetime,
	IN am decimal(6,2)
)
BEGIN
	insert into ingredientdelivery values(ing, dt, am);
	update ingredients set amount = amount + am where ingredient = ing;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE producePallet(
	IN cName varchar(30), 
	IN dt datetime
)
BEGIN
	update Ingredients set amount = amount - (
		select ingredientAmount 
		from Recipes 
		where Ingredients.ingredient = Recipes.ingredient AND cookieName = cName
	)
	where ingredient in (
		select ingredient 
		from Recipes 
		where cookieName = cName
	);
	insert into pallets values(null, dt, cName, null, 0, 0);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE placeOrder(
	IN custName varchar(20), 
	IN expDate date,
	IN almondDelight int(11),
	IN amneris int(11),
	IN berliner int(11),
	IN nutCookie int(11),
	IN nutRing int(11),
	IN tango int(11)
)
BEGIN
	insert into orders values(null, expDate, null, custName, null);
	set @ordNbr = (
		select max(orderNbr) 
		from orders
	);
	insert into nbrPallets values(@ordNbr, 'Almond delight', almondDelight);
	insert into nbrPallets values(@ordNbr, 'Amneris', amneris);
	insert into nbrPallets values(@ordNbr, 'Berliner', berliner);
	insert into nbrPallets values(@ordNbr, 'Nut cookie', nutCookie);
	insert into nbrPallets values(@ordNbr, 'Nut ring', nutRing);
	insert into nbrPallets values(@ordNbr, 'Tango', tango);
	update orders set nbrPalletsTotal = ( 
		select sum(nbrPallets) 
		from nbrPallets 
		where orderNbr = @ordNbr 
	) 
	where orderNbr = @ordNbr; 
END//
DELIMITER ;
