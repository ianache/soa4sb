-- CORE ENTIRY
-- @Author: Ilver Anache Pupo
-- @Company: CROSSNET SAC
--
-- DATE			Author 			DESCRIPTION
-- ----------------------------------------------------------------------------
-- 17/10/2015	Ilver Anache	Creacion  inicial
create sequence party_seq minvalue 0 start with 0 increment by 1 nocache nocycle;

create table PARTY (
	ID INT NOT NULL,
	NAME VARCHAR(120) NOT NULL,
	DESCRIPTION VARCHAR(4000) NULL,
	PARTYTYPE_ID INT NOT NULL
);
ALTER TABLE PARTY ADD CONSTRAINT PK1_PARTY PRIMARY KEY(ID);
ALTER TABLE PARTY ADD CONSTRAINT FK1_PARTY FOREIGN KEY (PARTYTYPE_ID) 
	REFERENCES PARTYTYPE (ID);

create or replace trigger TGR1_PARTY before insert on PARTY for each row
begin
   select party_seq.nextval into :NEW.ID from dual;
end TGR1_PARTY;	