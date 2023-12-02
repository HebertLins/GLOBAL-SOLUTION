CREATE TABLE comprovantes (
    id_comprovante             NUMBER(10) NOT NULL,
    data_aplicacao_comprovante DATE NOT NULL,
    lote_comprovante           NUMBER(15) NOT NULL,
    nome_comprovante           VARCHAR2(60) NOT NULL,
    cpf_paciente               NUMBER(11) NOT NULL
);

ALTER TABLE comprovantes ADD CONSTRAINT comprovantes_pk PRIMARY KEY ( id_comprovante );

CREATE TABLE exames (
    id_exame         NUMBER(10) NOT NULL,
    data_exame       DATE NOT NULL,
    tipo_exame       VARCHAR2(60) NOT NULL,
    crm_medico_exame NUMBER(15) NOT NULL,
    descricao_exame  VARCHAR2(60) NOT NULL,
    cpf_paciente     NUMBER(11) NOT NULL
);

ALTER TABLE exames ADD CONSTRAINT exames_pk PRIMARY KEY ( id_exame );

CREATE TABLE instituicao (
    cnpj_instituicao NUMBER(15) NOT NULL,
    id_usuario       NUMBER(10) NOT NULL
);

ALTER TABLE instituicao ADD CONSTRAINT instituicao_pk PRIMARY KEY ( cnpj_instituicao );

CREATE TABLE lembretes (
    id_lembrete       NUMBER(10) NOT NULL,
    conteudo_lembrete VARCHAR2(60) NOT NULL,
    cpf_paciente      NUMBER(11) NOT NULL
);

ALTER TABLE lembretes ADD CONSTRAINT lembretes_pk PRIMARY KEY ( id_lembrete );

CREATE TABLE paciente (
    cpf_paciente   NUMBER(11) NOT NULL,
    idade_paciente NUMBER(3) NOT NULL,
    sexo_paciente  VARCHAR2(9) NOT NULL,
    id_usuario     NUMBER(10) NOT NULL
);

ALTER TABLE paciente ADD CONSTRAINT paciente_pk PRIMARY KEY ( cpf_paciente );

CREATE TABLE usuario (
    id_usuario    NUMBER(10) NOT NULL,
    end_usuario   VARCHAR2(60) NOT NULL,
    email_usuario VARCHAR2(30) NOT NULL,
    nome_usuario  VARCHAR2(30) NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE comprovantes
    ADD CONSTRAINT comprovantes_paciente_fk FOREIGN KEY ( cpf_paciente )
        REFERENCES paciente ( cpf_paciente );

ALTER TABLE exames
    ADD CONSTRAINT exames_paciente_fk FOREIGN KEY ( cpf_paciente )
        REFERENCES paciente ( cpf_paciente );

ALTER TABLE instituicao
    ADD CONSTRAINT instituicao_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE lembretes
    ADD CONSTRAINT lembretes_paciente_fk FOREIGN KEY ( cpf_paciente )
        REFERENCES paciente ( cpf_paciente );

ALTER TABLE paciente
    ADD CONSTRAINT paciente_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );

SET SERVEROUTPUT ON;


DECLARE
     v_cpf_paciente NUMBER(11);
     v_id_usuario NUMBER(10);
     v_nome_usuario VARCHAR2(30);
     v_email_usuario VARCHAR2(30);
     v_end_usuario VARCHAR2(60);
     v_idade_paciente NUMBER(3);
     v_sexo_paciente VARCHAR2(9);
     v_cnpj_instituicao NUMBER(15);
     v_id_comprovante NUMBER(10);
     v_data_aplicacao_comprovante DATE;
     v_lote_comprovante NUMBER(15);
     v_nome_comprovante VARCHAR2(60);
     v_id_exame NUMBER(10);
     v_data_exame DATE;
     v_tipo_exame VARCHAR2(60);
     v_crm_medico_exame NUMBER(15);
     v_descricao_exame VARCHAR2(60);
     v_id_lembrete NUMBER(10);
     v_conteudo_lembrete VARCHAR2(60);

  
BEGIN
     -- Solicitando inserção de dados para a tabela usuario
     DBMS_OUTPUT.PUT_LINE('Digite os dados do usuário:');
     v_id_usuario := '&id_usuario';
     v_nome_usuario := '&nome_usuario';
     v_email_usuario := '&email_usuario';
     v_end_usuario := '&end_usuario';
  
     INSERT INTO usuario (id_usuario, end_usuario, email_usuario, nome_usuario) VALUES (v_id_usuario, v_end_usuario, v_email_usuario, v_nome_usuario);
  
     -- Solicitando inserção de dados para a tabela paciente
     DBMS_OUTPUT.PUT_LINE('Digite os dados do paciente:');
     v_cpf_paciente := '&cpf_paciente';
     v_idade_paciente := '&idade_paciente';
     v_sexo_paciente := '&sexo_paciente';
      
     INSERT INTO paciente (cpf_paciente, idade_paciente, sexo_paciente, id_usuario) VALUES (v_cpf_paciente, v_idade_paciente, v_sexo_paciente, v_id_usuario);
      
     -- Solicitando inserção de dados para a tabela exames
     DBMS_OUTPUT.PUT_LINE('Digite os dados do exame:');
     v_id_exame := '&id_exame';
     v_data_exame := '&data_exame';
     v_tipo_exame := '&tipo_exame';
     v_crm_medico_exame := '&crm_medico_exame';
     v_descricao_exame := '&descricao_exame';
      
     INSERT INTO exames (id_exame, data_exame, tipo_exame, crm_medico_exame, descricao_exame, cpf_paciente) VALUES (v_id_exame, v_data_exame, v_tipo_exame, v_crm_medico_exame, v_descricao_exame, v_cpf_paciente);
      
     -- Solicitando inserção de dados para a tabela lembretes
     DBMS_OUTPUT.PUT_LINE('Digite os dados do lembrete:');
     v_id_lembrete := '&id_lembrete';
     v_conteudo_lembrete := '&conteudo_lembrete';
      
     INSERT INTO lembretes (id_lembrete, conteudo_lembrete, cpf_paciente) VALUES (v_id_lembrete, v_conteudo_lembrete, v_cpf_paciente);
      
     -- Solicitando inserção de dados para a tabela comprovantes
     DBMS_OUTPUT.PUT_LINE('Digite os dados do comprovante:');
     v_id_comprovante := '&id_comprovante';
     v_data_aplicacao_comprovante := '&data_aplicacao_comprovante';
     v_lote_comprovante := '&lote_comprovante';
     v_nome_comprovante := '&nome_comprovante';
      
     INSERT INTO comprovantes (id_comprovante, data_aplicacao_comprovante, lote_comprovante, nome_comprovante, cpf_paciente) VALUES (v_id_comprovante, v_data_aplicacao_comprovante, v_lote_comprovante, v_nome_comprovante, v_cpf_paciente);
     
      
     DBMS_OUTPUT.PUT_LINE('Dados inseridos com sucesso!');
END;

DECLARE
  CURSOR cur_usuarios IS
    SELECT u.nome_usuario, u.email_usuario, u.end_usuario
    FROM usuario u
    WHERE UPPER(u.nome_usuario) LIKE '%A%';
  
  nome_usuario usuario.nome_usuario%TYPE;
  email_usuario usuario.email_usuario%TYPE;
  end_usuario usuario.end_usuario%TYPE;
BEGIN
  OPEN cur_usuarios;
  DBMS_OUTPUT.PUT_LINE('Relatório de Usuários com a Letra ''A'' no Nome:');
  DBMS_OUTPUT.PUT_LINE('------------------------------------------------------');
  DBMS_OUTPUT.PUT_LINE('Nome do Usuário | E-mail do Usuário | Endereço do Usuário');
  DBMS_OUTPUT.PUT_LINE('------------------------------------------------------');
  
  LOOP
    FETCH cur_usuarios INTO nome_usuario, email_usuario, end_usuario;
    EXIT WHEN cur_usuarios%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(nome_usuario || ' | ' || email_usuario || ' | ' || end_usuario);
  END LOOP;
  
  CLOSE cur_usuarios;
END;

DECLARE
  CURSOR cur_exames IS
    SELECT e.id_exame, e.data_exame, e.tipo_exame, e.crm_medico_exame, e.descricao_exame
    FROM exames e
    WHERE EXTRACT(YEAR FROM e.data_exame) = 2022;
  
  id_exame exames.id_exame%TYPE;
  data_exame exames.data_exame%TYPE;
  tipo_exame exames.tipo_exame%TYPE;
  crm_medico_exame exames.crm_medico_exame%TYPE;
  descricao_exame exames.descricao_exame%TYPE;
BEGIN
  OPEN cur_exames;
  DBMS_OUTPUT.PUT_LINE('Relatório de Exames Feitos em 2022:');
  DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
  DBMS_OUTPUT.PUT_LINE('ID do Exame | Data do Exame | Tipo de Exame | CRM do Médico | Descrição do Exame');
  DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
  
  LOOP
    FETCH cur_exames INTO id_exame, data_exame, tipo_exame, crm_medico_exame, descricao_exame;
    EXIT WHEN cur_exames%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(id_exame || ' | ' || TO_CHAR(data_exame, 'DD/MM/YYYY') || ' | ' || tipo_exame || ' | ' || crm_medico_exame || ' | ' || descricao_exame);
  END LOOP;
  
  CLOSE cur_exames;
END;