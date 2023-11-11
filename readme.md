<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>API de Gerenciamento de Estoque</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1,
        h2,
        h3 {
            color: #333;
        }

        code {
            background-color: #f4f4f4;
            padding: 2px 5px;
            border-radius: 4px;
            font-family: 'Courier New', Courier, monospace;
        }
    </style>
</head>

<body>
    <h1>API de Gerenciamento de Estoque</h1>

    <p>Esta é uma API simples de gerenciamento de estoque desenvolvida em Java 21 e Spring. A API fornece endpoints para realizar operações básicas de CRUD (Create, Read, Update, Delete).</p>

    <h2>Endpoints</h2>

    <h3>1. Obter todos os itens do estoque</h3>
    <pre><code>GET /api/estoque</code></pre>

    <h3>2. Obter um item específico por ID</h3>
    <pre><code>GET /api/estoque/{id}</code></pre>

    <h3>3. Adicionar um novo item ao estoque</h3>
    <pre><code>POST /api/estoque</code></pre>

    <h3>4. Atualizar um item existente no estoque por ID</h3>
    <pre><code>PUT /api/estoque/{id}</code></pre>

    <h3>5. Excluir um item do estoque por ID</h3>
    <pre><code>DELETE /api/estoque/{id}</code></pre>

    <h2>Como Consumir a API</h2>

    <p>Você pode utilizar o Postman ou qualquer outra ferramenta para realizar requisições HTTP para os endpoints mencionados acima.</p>

    <h2>Exemplo de Requisição POST</h2>
    <pre><code>
        POST /api/estoque
        Content-Type: application/json

        {
            "nome": "Produto",
            "quantidade": 10,
            "preco": 20.50
        }
    </code></pre>

    <p>Adapte os dados conforme necessário para suas requisições.</p>

    <h2>Configurações Adicionais</h2>

    <p>As configurações específicas, como configurações do banco de dados, podem ser encontradas no código-fonte da aplicação.</p>

    <h2>Como Executar Localmente</h2>
    <p>Para executar a aplicação localmente, você precisará do ambiente Java 21 e Maven instalados. Clone o repositório e execute:</p>
    <pre><code>
        mvn spring-boot:run
    </code></pre>

    <p>A API estará disponível em <code>http://localhost:8080</code>.</p>

    <h2>Licença</h2>

    <p>Este projeto está licenciado sob a MIT License - consulte o arquivo <code>LICENSE.md</code> para obter detalhes.</p>
</body>

</html>
