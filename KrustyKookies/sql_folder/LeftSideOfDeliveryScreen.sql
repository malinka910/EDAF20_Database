



--Hämta Orders från en customer skriva ut antal 

SELECT *
FROM Pallets
WHERE CookieName = (Select cookieName
					From Orders
					Where customerName = "hämta från gui");
					
