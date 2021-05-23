o /*employee (ENUM,ENAME,SALARY,ADDRESS,#DEP)
o departement (NUM,DNAME, FLOOR,NBEMP,#MGR) */
 drop table emp ;
 create table dept(NUM int primary key,DNAME varchar(20), FLOOR varchar(20),NBEMP int ,MGR float) ;
 create table emp(ENUM int primary key,ENAME varchar(20),SALARY float  
                           ,ADDRESS varchar (20),NDEP int , foreign key (NDEP)references dept (NUM));
 -----------------Q1----------------------------
 set SERVEROUTPUT ON ; 
 create or replace trigger tr_1 
 after insert on emp 
   begin 
  DBMS_OUTPUT.PUT_LINE('insertion Ok') ;
   end ; 
   /
   ---test 
    insert into dept  values(10 , 'info','ensa',10 , 2000);
   insert into emp values(10 , 'ali' , '300' , 'berchid',10 ) ;
   