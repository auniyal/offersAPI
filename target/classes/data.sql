drop table offers
create table offers (id int, description varchar(255), category varchar(255), percent_discount int,currently_active boolean, offer_end date)  
insert into offers values(1,'Bank Holiday Offer','electronic',15, false,'2017-12-31')
insert into offers values(2,'XMas Holiday Offer','electronic',25, true,'2017-12-31')
insert into offers values(3,'New Year Offer','electronic',20, false,'2017-12-31')
insert into offers values(4,'No Offer','electronic',10, false,'2017-12-31')
insert into offers values(5,'Super Autumn Offer','electronic',5, true,'2017-12-31')

drop table products
create table products (id int, description varchar(255), category varchar(255),price int,promotion boolean, currency varchar(10))  
insert into products values(1,'iphone 6s','electronic',455, true,'GBP')
insert into products values(2,'iphone 7','electronic',580, true,'GBP')
insert into products values(3,'Samsung galaxy s7 edge','electronic',460, true,'GBP')
insert into products values(4,'Samsung galaxy s8','electronic',660, false,'GBP')
