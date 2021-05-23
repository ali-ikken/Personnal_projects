/* Highschooler(ID int, name text, grade int);
Friend(ID1 int, ID2 int);
Likes(ID1 int, ID2 int);  */
create table highschooler (id int primary key ,name varchar(20) ,grade int ) ;
create table friend (id1 int , id2 int );

create or replace trigger tr_friends
after Delete  on friend 
for each row 
when exist (select * from friend where id1 = :old.id2 and id2=:old.id1)
begin 
  delete from  firend where id1 = :old.id2  ;
end ; 
/
---------------------------------------------------------------------------------------
create or replace trigger tr_friends2
after insert  on friend 
for each row 
when not exist (select * from friend where ( id1 = :new.id2 and id2=:new.id1) ) 
begin 
  insert into firend values (new.id2 , new.id1) ;
end ; 
/
------------------------------------------------------------
create or replace trigger trriger_diplome
after update of grade on highschooler
for each row 
when (new.grade>12)
begin 
  delete from  highschooler where id = :new.id  ;
end ; 
/
insert into highschooler values (1 , 'karim' , 10);
update highschooler set grade = 13 where id = 1 ;

--------------------------------------------------------------------------------------------------
/* CUSTOMER ( SSN, Name, Surname, PhoneNum, Plan)
o PRICINGPLAN ( Code, ConnectionFee, PricePerSecond )
o PHONECALL ( SSN, Date, Time, CalledNum, Seconds)
o BILL( SSN, Month, Year, amount ) */
/*  ? Écrivez un déclencheur qu’après chaque appel téléphonique met à jour le facture
du client.
? Rédigez un déclencheur qui, à la fin de chaque mois, réduira la facture de 5 cents
par appel aux utilisateurs directs de la société (c'est-à-dire aux numéros des
utilisateurs enregistrés dans le tableau CLIENT) si le montant total mensuel de la
facture dépasse 100 € */
create or replace trigger_bill 
after insert on PHONECALL
for each row 
begin 
 update BILL B 
    set year = new.date.year 
                    and month = new.date.month
                  and    amount = amount+ :new.seconde * (Select PP.connectionfree 
                  + PP.pricepersecond*new.second from PRICINGPLAN PP JOIN CUSTOMER C 
                              on C.plan = PP.code where new.SSN = C.SSN ) where B.SSN = :new.SSN ;
end ; 
/
