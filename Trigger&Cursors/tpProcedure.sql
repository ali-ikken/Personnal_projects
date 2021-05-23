DECLARE
 d VARCHAR2(1);
 /* Create exception with a predefined name. */
 no_data_found EXCEPTION;
BEGIN
 SELECT dummy INTO d FROM dual WHERE 1=2;
 IF d IS NULL
 THEN
 /*
 || Raise my own exception, not the predefined
 || STANDARD exception of the same name.
 */
 RAISE no_data_found;
 END IF;
EXCEPTION
 /* This handler only responds to the RAISE statement. */
 WHEN no_data_found
 THEN
 DBMS_OUTPUT.PUT_LINE ('Predefined or programmer-defined?');
END;