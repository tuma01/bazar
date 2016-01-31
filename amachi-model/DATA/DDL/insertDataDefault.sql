--TABLE user_roles
INSERT INTO user_role (ROLE_NAME, ROLE_DESCRIPTION) VALUES ('ROLE_ADMIN', 'Administrator');
INSERT INTO user_role (ROLE_NAME, ROLE_DESCRIPTION) VALUES ('ROLE_USER', 'User par default');

--TABLE user
INSERT INTO user (USERNAME, PASSWORD, LASTNAME, FIRSTNAME, EMAIL, ENABLED, FK_ROLE_NAME) 
VALUES ('tuma', 'bolivia', 'Amachi', 'Juan', 'juan.amachi@gmail.com', 1,'ROLE_ADMIN');


commit;