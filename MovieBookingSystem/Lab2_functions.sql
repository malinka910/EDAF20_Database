-- insert into Bookings values(nbr, userName, movie , day)


-- movies shown
select distinct movie
from showing

-- movies and dates
select showday
from showing
where movie = 'Red Lion'

-- get info for a specific showing
select *
from showing
where movie = 'Red Lion' and showday = 20170216

-- make a booking
insert into Bookings values( 
null,
'Greg423',
'Shichinin No Samurai',
20170215
);

-- find userName
select *
from users
where username = 'randomName'

-- get number of booking for a show
Select MAX(nbr)
from bookings
where movie = 'Shichinin No Samurai' and showday = '20170215';

-- theater seats
select seats from theaters where theaterName ='Chinese';

-- thing
update showing set freeSeats = freeSeats - 1
where movie = 'Psycho' and showday = '20170217';

select freeSeats from showing
where movie = 'Psycho' and showday = '20170217';