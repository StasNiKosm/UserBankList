CREATE DATABASE bank;

CREATE TABLE bank.user (
  userid INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  PRIMARY KEY (userid));

CREATE TABLE bank.account (
  accountid INT NOT NULL AUTO_INCREMENT,
  account INT NOT NULL,
  userid INT NOT NULL,
  PRIMARY KEY (accountid),
  CONSTRAINT userid
  FOREIGN KEY (userid) REFERENCES bank.user (userid)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO bank.user(name, surname)
VALUES ('Stas', 'Nikunenko'),
	('Petr', 'Pervyj'),	('Lina', 'Paulina'),
	('Tanya', 'Gud'),	('Tom', 'Osten'),
	('Doll', 'Sewdgweck'), ('Anna', 'Bana'),
	('Avon', 'Lon'),	('Artur', 'Hotter'),
	('Moly', 'Milan'),	('Polina', 'Agarutyjan'),
	('Alex', 'Tor');
    
INSERT INTO bank.account (account, userid)
VALUES (70, 1), (20, 2), (100, 1), (19, 3), 
	(109, 4), (140, 5), (60, 6), (34, 7), 
    (180, 8), (130, 7), (0, 9), (110, 10);
    
SELECT * FROM bank.user;

SELECT * FROM bank.account;

select * from bank.user join bank.account 
	on (bank.user.userid = bank.account.userid);

select * from bank.user cross join bank.account;

select * from bank.user left join bank.account 
	on (bank.user.userid = bank.account.userid);

select name, surname, sum(account) as 'sum' from bank.user join bank.account 
	on (bank.user.userid = bank.account.userid)
    group by name
    order by sum(account) desc
    limit 1;
    
select sum(account) as 'full_sum' from bank.account;



    

    
    

