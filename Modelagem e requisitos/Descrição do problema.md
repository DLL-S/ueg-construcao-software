# Descrição do problema

A PeçaCerta – Auto Peças, é uma revenda de peças para veículos pequenos, médios e grandes entre veículos de passeio e de trabalho. Com mais de 20 anos de mercado, possui uma vasta gama de produtos em seu estoque, das mais variadas marcas e modelos existentes. Seus clientes são consumidores à varejo em busca de peças para conserto de veículos e até mesmo grandes empresas que buscam peças para repor peças defeituosas da sua frota de veículos.

Com o crescimento do número de clientes a sistemática atual de atendimento e venda de seus produtos acabou por não atender às expectativas da empresa. Surgiu então a necessidade de **automatizar o controle de estoque e vendas** para aumentar a qualidade e agilidade do atendimento ao cliente final. O intuído da implementação da tecnologia é oferecer ao cliente **comodidade ao fazer suas compras de modo seguro e rápido**, abolindo etapas burocráticas entre o fornecedor e o consumidor. A solução proposta visa aumentar a qualidade dos serviços oferecidos ao cliente, como rapidez, segurança e comodidade. Com a automatização é possível, ainda, incrementar os meios de relacionamento com o cliente. **O sistema deverá ter a capacidade de funcionar no parque de máquinas atual da empresa que utilizam o sistema operacional Windows 10 com browser Chrome e MS Edge**. Cada funcionalidade não poderá ser executada com tempo superior a **2 segundos por transação. Em todas as janelas do sistema é necessário mostrar a logo da PeçaCerta.**

**O passo inicial para a implantação do sistema é criar a base de produtos. Para isso é necessário cadastrar para cada produto: O código, o código de barras, o nome, a descrição, categoria do produto, a marca, e a quantidade atual.**

A movimentação dos produtos no estoque deverá ser:  **Entrada** – onde uma nova quantidade de produtos será acrescida a quantidade atual de produtos, **Saída** – Onde uma quantidade de produtos deverá ser subtraída da quantidade atual do produto; **Perda** – Onde uma quantidade de produtos estragada deverá ser subtraída da quantidade atual do produto; **Troca** - Onde uma quantidade de produtos não sofre alteração, mas o movimento do estoque é registrado.

A sistemática a ser adotada para o cliente que entra no estabelecimento para fazer um pedido ou orçamento é:

O cliente informa o produto que deseja comprar ou orçar o seu preço;

**O atendente identificado no sistema**, **procura o produto pelo código, caso saiba, ou pelo nome, ou parte do nome, ou categoria ou até mesmo pela marca do produto.** Localizado o produto e o cliente confirmando a compra, é verificado se existe um cadastro do cliente na loja. **Em caso de ser um novo cliente é feito o seu cadastro através de suas informações básicas de identificação e contatos.** **Para os clientes já cadastrados é feita a busca pelo nome ou parte do nome.** Após essa etapa **efetiva-se a venda com a baixa do produto em estoque emitindo a nota fiscal.** O **cliente poderá realizar uma compra com mais de um produto em uma só nota fiscal.**

**No momento da finalização da venda é informada a forma de pagamento, que atualmente é: À vista, À prazo em 3x no cartão, à vista no cheque e através de boleto bancário.** As vendas à prazo no cheque e boleto de cobrança são permitidas somente para clientes **Pessoa Jurídica com a autorização do gerente da loja**.

**Os clientes poderão consultar o seu histórico de compras realizadas na loja.**

**O sistema deverá ser web** com a possibilidade de se **implantar uma versão futura que permita as vendas pela internet**. A empresa necessitará de um **sistema de help online** a fim de auxiliar os vendedores nos primeiros momentos de transição do sistema bem como treinamento para novos vendedores. A empresa precisará também de um **manual, tipo wiki**, para futuras consultas. **O sistema deverá ter uma rotina automatizada para o backup da base de dados em nuvem.**
