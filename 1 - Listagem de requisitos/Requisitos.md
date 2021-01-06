# :clipboard:	 Lista de Requisitos

- [Requisitos Funcionais](#requisitos-funcionais)
- [Requisitos Não Funcionais](#requisitos-não-funcionais)


## Requisitos Funcionais
|  **Cód.** | **Nome** | **Descrição** | **Categoria** |
| :---: | :---: | :--- | :---: |
|  F1 | Manter Produtos | O sistema deverá possibilitar a inclusão e alteração de produtos; as seguintes informações deverão ser mantidas: Código do produto, código de barras, nome, descrição, categoria, marca, preço, quantidade atual. | Evidente |
|  F2 | Manter funcionários | O sistema deverá possibilitar o cadastro e alteração de funcionários; as seguintes informações deverão ser mantidas: Código, nome, CPF, data de nascimento, endereço (cep, logradouro, bairro, número, complemento, cidade, estado), e-mail, telefone, tipo de funcionário (Atendente, Gerente), senha de acesso e status. | Evidente |
|  F3 | Manter clientes | O sistema deverá possibilitar o cadastro de clientes; as seguintes informações deverão ser mantidas: Código, nome, tipo de cliente (PF/PJ), CPF/CNPJ, data de nascimento/fundação, endereço (cep, logradouro, bairro, número, complemento, cidade, estado), e-mail, telefone. | Evidente |
|  F4 | Manter orçamentos | O sistema deverá gravar os orçamentos realizados por cliente, para futura consulta caso a venda não seja efetivada no mesmo momento. As seguinte informações deverão ser mantidas: Código, cliente, data, lista produtos, quantidade, valor total, observações. | Evidente |
|  F5 | Manter marcas | O sistema deverá possibilitar a inclusão e alteração das marcas dos produtos vendidos pela loja. As seguintes informações deverão ser mantidas: Código, nome. | Evidente |
|  F6 | Manter categorias | O sistema deverá possibilitar a inclusão e alteração das categorias de produtos vendidos pela loja. As seguintes informações deverão ser mantidas: Código, nome. | Evidente |
|  F7 | Manter vendas | Para cada venda, o sistema deverá manter as seguintes informações: Código da venda, data da venda, valor, forma de pagamento, cliente, código da nota fiscal, observações. | Evidente |
|  F8 | Pesquisar produtos | O sistema deverá possibilitar a pesquisa de produtos a partir do código, nome ou parte do nome, categoria ou marca. | Evidente |
|  F9 | Pesquisar clientes | O sistema deverá possibilitar a pesquisa de clientes a partir do nome ou parte do nome. | Evidente |
|  F10 | Pesquisar orçamentos | O sistema deverá possibilitar a pesquisa de orçamentos a partir do código ou nome do cliente. | Evidente |
|  F11 | Pesquisar vendas | O sistema deverá possibilitar a pesquisa de vendas a partir do código da venda ou cliente. | Evidente |
|  F12 | Pesquisar compras | O sistema deverá possibilitar que clientes visualizem, e filtrem seu histórico de compras a partir do número da nota fiscal. | Evidente |
|  F13 | Movimentação de produtos no estoque | O sistema deverá possibilitar as seguintes operações sobre o estoque: Entrada - Uma nova quantidade de produtos será acrescida a quantidade atual de produtos; Saída - Uma quantidade de produtos deverá ser subtraída da quantidade atual do produto; Perda - Uma quantidade de produtos estragada deverá ser subtraída da quantidade atual do produto; Troca - Uma quantidade de produtos não sofre alteração, mas o movimento do estoque é registrado. | Oculto |
|  F14 | Efetivar venda | O sistema deverá efetivar as vendas, gravando as informações (conforme o requisito F4), dando baixa dos produtos no estoque ("Saída" F8) e emitindo a nota fiscal. | Evidente |
|  F15 | Efetivar venda com autorização de gerente | Caso a venda se encaixe no requisito NF4, o sistema deverá exibir uma tela solicitando a aprovação do gerente por meio de seu cpf e senha. | Evidente |
|  F16 | Registrar aprovação de venda | Após a aprovação do gerente, o sistema deverá preencher o campo de "observação" da venda, informando a data e a hora e o gerente que aprovou tal venda. | Oculto |
|  F17 | Emitir nota fiscal | Após efetivar uma venda o sistema deverá emitir uma nota fiscal contendo as seguintes informações: Código, Número, Valor, Produtos, Cliente, Forma de pagamento | Evidente |
|  F18 | Autenticar Usuário | O sistema deverá possibilitar a autenticação de usuários, pré-cadastrados, no sistema através de e-mail e senha de acesso. | Evidente |

#
## Requisitos Não Funcionais

|  **Cód.** | **Nome** | **Restrição** | **Categoria** | **Obrigatoriedade** | **Permanência** |
| :---: | :---: | :---: | :---: | :---: | :---: |
|  NF1 | Local de implantação | O sistema deve ter capacidade para funcionar no parque de máquinas da empresa, que utiliza o sistema operacional Windows 10 com browser Chrome e MS Edge. | Compatibilidade | Obrigatório | Permanente |
|  NF2 | Quantidade de produtos por venda | O sistema deverá permitir vendas com mais de um produto, em uma única nota fiscal. | Interoperabilidade | Obrigatório | Permanente |
|  NF2 | Finalização vendas e forma pagamento | O sistema deve perguntar na finalização de uma venda, qual a forma de pagamento: à vista, à prazo em até 3x no cartão crédito, à vista no cheque e no boleto bancário. | Usabilidade | Obrigatório | Permanente |
|  NF4 | Forma de pagamento | O sistema deverá permitir vendas à prazo no cheque e boleto somente para clientes pessoa Jurídica, e com autorização do gerente. | Segurança | Obrigatório | Permanente |
|  NF5 | Arquitetura Web | O sistema deverá ser web. | Implementação | Obrigatório | Permanente |
|  NF6 | Impantação futura | O sistema deverá possibilitar que futuramente seja implantada uma versão com suporte a vendas pela web. | Compatibilidade | Obrigatório | Permanente |
|  NF7 | Suporte online | O sistema deverá contar com  um canal para suporte online, disponível aos funcionários. | Documentação | Obrigatório | Transitório |
|  NF8 | Manual de instrução | O sistema deverá possuir um manual de instruções (wiki), disponível ao usuário para consulta. | Documentação | Obrigatório | Permanente |
|  NF9 | Tempo de resposta | Cada funcionalidade não poderá ser executada com tempo superior à 2 segundos por transação. | Desempenho | Obrigatório | Permanente |
|  NF10 | Logo da empresa | Em todas as janelas do sistema que forem abertas, deverá conter a logo do peça certa. | Interface | Obrigatório | Permanente |
|  NF11 | Rotina de backup | O sistema deverá possuir uma rotina automatizada de backup em núvem. | Confiabilidade | Obrigatório | Permanente |
|  NF12 | Confirmar inativação de funcionários | O sistema deverá exibir uma tela confirmando se o usuário realmente deseja inativar determinado funcionário. | Interface | Desejável | Permanente |