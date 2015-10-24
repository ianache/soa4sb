-- METAMODELING
-- @Author: Ilver Anache Pupo
-- @Company: CROSSNET SAC
--
-- DATE			Author 			DESCRIPTION
-- ----------------------------------------------------------------------------
-- 17/10/2015	Ilver Anache	Creacion  inicial

insert into PARTYTYPE (ID, NAME) values(null, 'BASE');

-- Rationships types
insert into PARTYRELATIONSHIPTYPE (ID,NAME,DESCRIPTION) 
	values (null,'AGGREGATION','Aggregation relationhips. Define a whole - part relationhips');

insert into PARTYRELROLETYPE (PARTYRELTYPE_ID,ID,DESCRIPTION,PARTYTYPE_ID,MINOCCUR,MAXOCCUR)
	values(0,'WHOLE','Role for container entity',0,'1','1');
insert into PARTYRELROLETYPE (PARTYRELTYPE_ID,ID,DESCRIPTION,PARTYTYPE_ID,MINOCCUR,MAXOCCUR)
	values(0,'PART','Role for contained entity',0,'0','*');