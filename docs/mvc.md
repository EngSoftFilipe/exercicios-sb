# MVC
 
**Model View Controller** é um padrão arquitetural cujo papel é organizar a aplicação inteira em camadas, com cada coisa no seu devido lugar, evitando a bagunça. Existem três camadas: Model (Modelo), View (Apresentação) e Controller (Controlador).
 
Na arquitetura MVC, a View é a camada de apresentação, o que o usuário vê. O Controller recebe as requisições, faz validações básicas e coordena o fluxo. O Model representa os dados e as regras de negócio, e o acesso ao banco fica a cargo de um Repository.
 
**Repository:** é a classe ou interface responsável por conversar com o banco de dados em nome do resto da aplicação. Ela guarda e busca as entidades (salvar um cliente, buscar por id, listar, excluir), e o resto do código nem precisa saber como isso é feito. O Repository faz parte do Model: é a parte dele que fala com o banco.

## Passo a passo de uma requisição
 
1. **View:** o usuário faz um pedido (clica, envia um formulário, chama a API).
2. **Controller:** recebe o pedido, faz validações básicas e coordena o fluxo.
3. **Model:** aplica as regras de negócio e busca ou guarda os dados (via Repository).
4. A resposta volta pelo mesmo caminho, até a View mostrar o resultado.

**Resumo:** a View mostra, o Controller coordena e o Model decide.