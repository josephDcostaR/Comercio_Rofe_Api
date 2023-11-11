# ComercioRofe API

Uma API simples para gerenciar tarefas utilizando Java 21 e Spring Boot.

## Pré-requisitos
- Java 21 ou superior.
- Spring Boot
- Postman (ou outra ferramenta para testar APIs)

## Configuração
1. Clone o repositório para a sua máquina:
   ```bash
   git clone https://github.com/josephDcostaR/Comercio_Rofe_Api.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd Comercio_Rofe_Api
   ```

3. Instale as dependências:
   ```bash
   mvn install
   ```

4. Inicie o servidor:
   ```bash
   mvn spring-boot:run
   ```
   A API estará disponível em [http://localhost:8080](http://localhost:8080).

## Endpoints

### Listar Produtos

- **URL:** [http://localhost:8080/produtos](http://localhost:8080/products)
- **Método:** GET
- **Resposta de Sucesso (200 OK):** Retorna uma lista de produtos no formato JSON.

### Adicionar Produto

- **URL:** [http://localhost:8080/produtos](http://localhost:8080/products)
- **Método:** POST
- **Corpo da Requisição:** Envie um objeto JSON contendo os dados do produto.
- **Resposta de Sucesso (201 Created):** Retorna o produto criado no formato JSON.

### Obter Produto por ID

- **URL:** [http://localhost:8080/produtos/{id}](http://localhost:8080/products/{id})
- **Método:** GET
- **Resposta de Sucesso (200 OK):** Retorna os detalhes do produto no formato JSON.
- **Resposta de Erro (404 Not Found):** Produto não encontrado.

### Editar Produto

- **URL:** [http://localhost:8080/produtos/{id}](http://localhost:8080/products/{id})
- **Método:** PUT
- **Corpo da Requisição:** Envie um objeto JSON contendo os dados atualizados do produto.
- **Resposta de Sucesso (200 OK):** Retorna o produto editado no formato JSON.
- **Resposta de Erro (404 Not Found):** Produto não encontrado ou dados inválidos.

### Excluir Produto

- **URL:** [http://localhost:8080/produtos/{id}](http://localhost:8080/products/{id})
- **Método:** DELETE
- **Resposta de Sucesso (200 OK):** Produto excluído com sucesso.
- **Resposta de Erro (404 Not Found):** Produto não encontrado.

## Testando a API

Você pode testar a API utilizando o Postman ou outra ferramenta similar. Importe a coleção de requisições do Postman disponível neste repositório para facilitar os testes.

## Contribuindo

Contribuições são bem-vindas! Se você encontrar um problema ou tiver alguma sugestão, sinta-se à vontade para abrir uma issue ou enviar um pull request.
