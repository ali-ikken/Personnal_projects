 create table employe (ENUM int primary key,ENAME VARCHAR(20),SALARY FLOAT,ADDRESS VARCHAR(40),NDEP int ) ;
 
 create table dept ( Dnum int primary key ,DNAME VARCHAR(20), FLOOR VARCHAR(20),
                                                 NBEMP int  ,MGR int , foreign key (MGR) references employee(Enum) ) ;
 alter table employe 
    add  foreign key (NDEP) REFERENCES dept(DNUM) ;
 insert into employe values ('1' ,'ahmed' , '3000' , 'berrechid','10');
insert into dept values ('10','MATH','ENSA','1','1');
set serveroutput on
 //--------------------AVANT ----------------
create or replace trigger monTrigger
 after 
    insert on employe
 begin
    dbms_output.put_line('insertion ok ! ');
 end;
 /
 
 //--------------------------- APRES ----------------------------
  set serveroutput on    
create or replace trigger monTrigger2
 before 
    insert on employee
 begin
    dbms_output.put_line('modification ok ! ');
 end;
 /
 //-----------------------------------------
 CREATE OR REPLACE TRIGGER monTrigger3     
      AFTER UPDATE ON employe       
      BEGIN             
      IF UPDATING('ENAME') THEN     
             DBMS_OUTPUT.PUT_LINE(' UPDATED ');   
      END IF; 
END;
/ 
set serveroutput on
CREATE OR REPLACE TRIGGER ti_emp 
AFTER UPDATE of salary on employee
for each row 
BEGIN 
if(:new.salary>:old.salary) then
DBMS_OUTPUT.PUT_LINE('Salaire actuel '||:new.salary||'   Ancien Salaire '||:old.salary);
end if;
end;