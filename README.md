Neste trabalho, cada grupo terá que desenvolver um sistema para cadastro de matrículas de estudantes, também conhecido popularmente como CRUD (Create, Retrieve, Update, Delete), referindo-se as quatro operações fundamentais de um sistema de cadastro: criação, recuperação, atualização e remoção. O sistema deverá ser implementado segundo o paradigma de programação orientada a objetos, utilizando a linguagem de programação Java. O sistema deverá também possuir uma interface gráfica de usuário (GUI - Graphical User Interface), utilizando a biblioteca Java Swing, e estar integrada a um banco de dados MySQL.

Funcionamento do Sistema
A tela inicial do sistema deverá exibir uma tabela com os estudantes cadastrados no sistema. Nesta tabela, devem constar todas as informações do estudante, exceto seu usuário e senha. Esta tela também deve possuir uma opção para cadastrar um novo estudante no sistema (criação), uma opção para atualizar um estudante já cadastrado (selecionado na tabela) e uma opção para remover um estudante já cadastrado (selecionado na tabela). Ao solicitar a remoção de um estudante cadastrado, o sistema deve solicitar a confirmação do usuário antes de proceder com a exclusão do cadastro. O cadastro de cada estudante deve conter as seguintes informações:

Nome completo (obrigatório);
Idade na matrícula (anos completos; obrigatório);
E-mail (obrigatório);
Endereço (obrigatório);
CEP;
Telefone;
Usuário (para acesso ao sistema acadêmico; obrigatório);
Senha (para acesso ao sistema acadêmico; obrigatório);
Curso (de um conjunto de opções previamente cadastradas; obrigatório);
Observações (texto livre);
Ativo (sim/não; obrigatório).
O sistema deve utilizar caixas de diálogo para avisar o preenchimento incorreto de campos e informar erros no sistema.
