insert into usr (id, username, password, active)
    values (0 ,'1', '$2a$10$SvYH57UVZ22VcY12NjwB5eEttoJaAJC.RbK2CWKcs/vIp2eEjbH0y', true);

insert into user_role (user_id, roles)
values (0, 'USER'), (0, 'ADMIN');