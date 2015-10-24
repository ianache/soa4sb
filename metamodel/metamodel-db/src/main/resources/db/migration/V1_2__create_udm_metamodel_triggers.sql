-- METAMODELING
-- @Author: Ilver Anache Pupo
-- @Company: CROSSNET SAC
--
-- DATE			Author 			DESCRIPTION
-- ----------------------------------------------------------------------------
-- 17/10/2015	Ilver Anache	Creacion  inicial
create sequence partyreltype_seq minvalue 0 start with 0 increment by 1 nocache nocycle;

create or replace trigger TGR1_PARTYRELTYPE before insert on PARTYRELATIONSHIPTYPE for each row
begin
   select partyreltype_seq.nextval into :NEW.ID from dual;
end;