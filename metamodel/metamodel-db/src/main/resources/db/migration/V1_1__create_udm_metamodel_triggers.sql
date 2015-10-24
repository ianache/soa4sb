-- METAMODELING
-- @Author: Ilver Anache Pupo
-- @Company: CROSSNET SAC
--
-- DATE			Author 			DESCRIPTION
-- ----------------------------------------------------------------------------
-- 17/10/2015	Ilver Anache	Creacion  inicial
create sequence partytype_seq minvalue 0 start with 0 increment by 1 nocache nocycle;

create or replace trigger TGR1_PARTYTYPE before insert on PARTYTYPE for each row
begin
   select partytype_seq.nextval into :NEW.ID from dual;
end;
