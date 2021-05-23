/*SET SERVEROUTPUT ON 
DECLARE
v_id s_item.id%TYPE:= 101 ;
v_count number (2) := 1  ;
BEGIN 
       LOOP 
            INSERT INTO s_item(id , ord ) values (v_id , v_count) ; 
            v_count :=v_count +1 ; 
            EXIT WHEN v_count >10 ;
            
    END LOOP ;
END ; 
/ 
SET SERVEROUTPUT ON 
DECLARE
v_id s_item.id%TYPE:= 101 ;
BEGIN 
          FOR i IN 1..10 LOOP
              INSERT INTO s_item(id , ord ) values (i , v_id) ;  
              END LOOP;
            
     
END ; 
/

SELECT * from s_item ; 
 
SET SERVEROUTPUT ON 
DECLARE
rec emp%ROWTYPE ; 
CURSOR c1 is SELECT * FROM emp order by sal DESC ; 
BEGIN
  OPEN c1 ; 
  FOR j IN 1..5 LOOP
      FETCH c1 INTO rec;
      DBMS_OUTPUT.PUT_LINE(rec.NOM ||''||TO_CHAR(rec.PRENOM));
    END LOOP;
    CLOSE c1 ; 
END ; 
/

SET SERVEROUTPUT ON 

BEGIN
 FOR i in (select * from emp) loop 
  DBMS_OUTPUT.PUT_LINE(i.id||''|| i.NOM )  ; 
  end loop ;
END ; 
/*/
SET SERVEROUTPUT ON 
DECLARE 
CURSOR c1( num number ) is SELECT *
            from emp where id = num ; 
BEGIN
  FOR i in c1 (2) loop 
  DBMS_OUTPUT.PUT_LINE(i.id||''|| i.NOM )  ; 
  end loop ;
END ; 
/
SELECT * from emp ;
    