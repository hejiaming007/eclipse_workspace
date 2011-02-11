delete from SEC_PRINCIPALS;
delete from SEC_CREDENTIALS;
delete from SEC_PERMISSIONS;

insert into SEC_PRINCIPALS (PRINCIPAL_ID, CLASS_NAME, FULL_PATH,
 CREATED_TIME, MODIFIED_TIME) 
values('1986150778', 'com.hsbc.gltc.gwis.services.security.core.UserPrincipalImpl', '/user/admin', 
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_PRINCIPALS (PRINCIPAL_ID, CLASS_NAME, FULL_PATH,
 CREATED_TIME, MODIFIED_TIME) 
values('1454265258', 'com.hsbc.gltc.gwis.services.security.core.RolePrincipalImpl', '/role/', 
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_PRINCIPALS (PRINCIPAL_ID, CLASS_NAME, FULL_PATH, PARENT_ID,
 CREATED_TIME, MODIFIED_TIME) 
values('1877699045', 'com.hsbc.gltc.gwis.services.security.core.RolePrincipalImpl', '/role/admin', '1454265258',
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

--insert into SEC_CREDENTIALS (CREDENTIAL_ID, USER_FULL_PATH, VALUE, TYPE, CLASS_NAME, 
--UPDATE_REQUIRED, IS_ENCODED, IS_ENABLED, AUTH_FAILURES, IS_EXPIRED,
--CREATED_TIME, MODIFIED_TIME, PREV_AUTH_TIME, LAST_AUTH_TIME, EXPIRATION_DATE) 
--values('662821652', '/user/admin', 'TWALplIwyrucJQ7MwDV6lv1m7W0=', 0, 'com.hsbc.gltc.gwis.services.security.core.credential.DefaultPasswordCredential',
--0, 1, 1, 0, 0,'2007-04-19 10:52:27', '2007-04-19 10:52:27', '2007-04-19 10:52:27', '2007-04-19 10:52:27', 2050-01-01');

insert into SEC_PERMISSIONS (PERMISSION_ID, CLASS_NAME, NAME, ACTIONS, 
CREATED_TIME, MODIFIED_TIME)
values('-1424848553', 'com.hsbc.gltc.gwis.services.security.core.security.AdministratorPermission', '', '',
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_PERMISSIONS (PERMISSION_ID, CLASS_NAME, NAME, ACTIONS, 
CREATED_TIME, MODIFIED_TIME)
values('1015283970', 'com.hsbc.gltc.gwis.services.gsf.core.security.ServicePermission', '*', 'access,execute,config',
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_USER_ROLES (USER_FULL_PATH, ROLE_ID)
values('/user/admin', '1877699045');

insert into SEC_PRIN_PERMS (PRINCIPAL_ID, PERMISSION_ID)
values('1877699045', '-1424848553');

insert into SEC_PRIN_PERMS (PRINCIPAL_ID, PERMISSION_ID)
values('1877699045', '1015283970');
delete from SEC_PRINCIPALS;
delete from SEC_CREDENTIALS;
delete from SEC_PERMISSIONS;

insert into SEC_PRINCIPALS (PRINCIPAL_ID, CLASS_NAME, FULL_PATH,
 CREATED_TIME, MODIFIED_TIME) 
values('1986150778', 'com.hsbc.gltc.gwis.services.security.core.UserPrincipalImpl', '/user/admin', 
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_PRINCIPALS (PRINCIPAL_ID, CLASS_NAME, FULL_PATH,
 CREATED_TIME, MODIFIED_TIME) 
values('1454265258', 'com.hsbc.gltc.gwis.services.security.core.RolePrincipalImpl', '/role/', 
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_PRINCIPALS (PRINCIPAL_ID, CLASS_NAME, FULL_PATH, PARENT_ID,
 CREATED_TIME, MODIFIED_TIME) 
values('1877699045', 'com.hsbc.gltc.gwis.services.security.core.RolePrincipalImpl', '/role/admin', '1454265258',
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

--insert into SEC_CREDENTIALS (CREDENTIAL_ID, USER_FULL_PATH, VALUE, TYPE, CLASS_NAME, 
--UPDATE_REQUIRED, IS_ENCODED, IS_ENABLED, AUTH_FAILURES, IS_EXPIRED,
--CREATED_TIME, MODIFIED_TIME, PREV_AUTH_TIME, LAST_AUTH_TIME, EXPIRATION_DATE) 
--values('662821652', '/user/admin', 'TWALplIwyrucJQ7MwDV6lv1m7W0=', 0, 'com.hsbc.gltc.gwis.services.security.core.credential.DefaultPasswordCredential',
--0, 1, 1, 0, 0,
--'2007-04-19 10:52:27', '2007-04-19 10:52:27', '2007-04-19 10:52:27', '2007-04-19 10:52:27', '01/01/2050');

insert into SEC_PERMISSIONS (PERMISSION_ID, CLASS_NAME, NAME, ACTIONS, 
CREATED_TIME, MODIFIED_TIME)
values('-1424848553', 'com.hsbc.gltc.gwis.services.security.core.security.AdministratorPermission', '', '',
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_PERMISSIONS (PERMISSION_ID, CLASS_NAME, NAME, ACTIONS, 
CREATED_TIME, MODIFIED_TIME)
values('1015283970', 'com.hsbc.gltc.gwis.services.gsf.core.security.ServicePermission', '*', 'access,execute,config',
'2007-04-19 10:52:27', '2007-04-19 10:52:27');

insert into SEC_USER_ROLES (USER_FULL_PATH, ROLE_ID)
values('/user/admin', '1877699045');

insert into SEC_PRIN_PERMS (PRINCIPAL_ID, PERMISSION_ID)
values('1877699045', '-1424848553');

insert into SEC_PRIN_PERMS (PRINCIPAL_ID, PERMISSION_ID)
values('1877699045', '1015283970');
--disconnect current
