
HÖGER SIDA AV DELIVERY SCREEN

--create new Order

INSERT INTO Order
Values(ordernbr(öka vid varje nytt skapande), DATE(dagens datum, ska ändra till timeStamp), 
		nbrPallets(läggs till från gui:t), customerNAme(textView), deliverytimestamp);
		
		
--create new pallet

INSERT INTO Pallets
Values( palletnbr(samma som i ordernbr(öka))? , productionTimeStamp(Samma som DATE i order), cookieName(hämta från gui(vid tryckning av "+" kolla vilken kaka som ökas), ordernbr, loaded, blocked);

--New customer when new order, BHEÖVS DETTA???? Eller ska customers vara "hårdkodad"

INSERT INTO Customers
Values(customerName(get from textView), customerAddress(Ha en textView för detta i gui));

--Uppdatera NbrPallets(Varför finns denna?)
--om Cookiepallet inte redan finns gör nedan:
INSERT INTO NbrPallets
Values(orderNbr, cookieName, 1);
--Annars gör detta:
INSERT INTO NbrPallets(orderNbr, nbrPallets)
Values(orderNbr(hämta från programmet), nbrPallets++)
Where(cookieName = "den kakan som användaren valde skapa order av";





--Vid val av en kaka, se om det finns tillräckligt med ingredienser(vid varje pallet som väljs +-)

--Vid knapptryckning av +-tecknet,
--Minska ingrediensen i Ingredient och se om neg värde, ge felmeddelande om att det inte går skapa fler pallets.
--Om man sparar ingredients i databasen och uppdaterar och minskar mängd vid knapptryckning av + så kan man samtidigt se om det finns tillräckligt 
--av ingrediesnen. Vit tryckning av produce/order så uppdateras tabellen och minskar mängden av amount(som sparas vid varje + tryck). 

Update Ingredients
SET amount = (Det sparade värdet))
Where ingredient = (ha en loop som går igenom alla ändrade ingredientamount);