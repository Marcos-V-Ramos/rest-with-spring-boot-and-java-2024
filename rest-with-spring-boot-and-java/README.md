# Fundamentos Teóricos do REST
- O que são Webservices;
- SOAP x REST;
- O que é REST;
- Request e Response;
- Tipos de parâmetros;
- HTTP Status Code;
- Verbos HTTP;
- Níveis de maturidade do REST;
- HATEOAS;
- Autenticação.

## O que são Webservices
- Para o W3C os webservices **são aplicações cliente servidor que se comunicam pela World Wide Web’s** (WWW) através do protocolo HTTP (HyperText Transfer Protocol) possibilitando a interoperabilidade entre softwares e aplicações executando em uma grande variedade de plataformas e frameworks.

- Caracterizam-se por sua grande interoperabilidade e extensibilidade podendo ser combinados de forma baixamente acoplada para executarem operações complexas. Programas proveem simples serviços que podem interagir uns com os outros gerando soluções sofisticadas.
## SOAP x REST
- O SOAP (Simple Object Access Protocol) é um protocolo que usa um envelopamento próprio (SOAP envelopes), usando HTTP para fazer **chamadas RPC trafegando XML**.
- Já o REST (Representational State Transfer) é um modelo arquitetural que faz requisições HTTP suportando diversos formatos de arquivo.
## O que é REST
- O REST (Representational State Transfer) é um modelo arquitetural stateless de webservices, onde é possível trafegar diversos formatos de arquivos utilizando **verbos HTTP** (GET, POST, PUT, DELETE, etc..).
- O REST (Representational State Transfer) é um modelo arquitetural stateless de web services, no qual é possível trafegar diversos formatos de dados ou recursos utilizando verbos HTTP (GET, POST, PUT, DELETE, entre outros).
- Este modelo baseia-se no conceito de que **cada requisição é independente e não mantém estado no servidor** entre as requisições. Isso significa que cada requisição contém todas as informações necessárias para ser processada com sucesso.
## Request X Response
1.  **Request (Requisição):**

    -   Uma "request" é uma solicitação enviada pelo cliente para o servidor. Ela contém informações sobre a ação que o cliente deseja realizar no servidor, juntamente com quaisquer dados adicionais necessários para executar essa ação.
    -   Uma requisição REST geralmente consiste nos seguintes elementos:
        -   Método HTTP: Indica a ação a ser realizada no recurso do servidor (por exemplo, GET, POST, PUT, DELETE).
        -   URI (Uniform Resource Identifier): Identifica o recurso no servidor que a requisição está direcionada.
        -   Corpo da Requisição (Opcional): Contém dados adicionais enviados pelo cliente, como parâmetros de consulta, dados de formulário ou payload no formato JSON ou XML.
            ![Request](https://miro.medium.com/v2/resize:fit:828/format:webp/1*gL3rDLeWO_ctEBmPLYWcrw.png)
2.  **Response (Resposta):**

    -   Uma "response" é a resposta enviada pelo servidor de volta ao cliente após processar a requisição. Ela contém informações sobre o resultado da operação solicitada pelo cliente.
    -   Uma resposta REST geralmente consiste nos seguintes elementos:
        -   Código de Status HTTP: Indica o resultado da operação (por exemplo, 200 para sucesso, 404 para recurso não encontrado, 500 para erro interno do servidor).
        -   Corpo da Resposta (Opcional): Contém dados retornados pelo servidor como resultado da operação, geralmente no formato JSON ou XML.
            ![Response](https://i.stack.imgur.com/jydIo.png)

# Tipos de Parâmetros
1.  **Path Parameters (Parâmetros de Caminho):**

    -   São usados para identificar recursos específicos em uma URI. Eles fazem parte da própria URI e são indicados por um nome precedido por dois pontos (:).
    -   Exemplo: `https://api.exemplo.com/users/{id}`
        -   Neste exemplo, `{id}` é um path parameter que representa o identificador único de um usuário na API.
2.  **Query Parameters (Parâmetros de Consulta):**

    -   São usados para enviar dados na forma de pares chave-valor na parte de consulta de uma URI.
    -   Exemplo: `https://api.exemplo.com/search?query=termo&limit=10`
        -   Neste exemplo, `query` e `limit` são query parameters que especificam o termo de busca e o número máximo de resultados a serem retornados.
3.  **Header Parameters (Parâmetros de Cabeçalho):**

    -   São usados para enviar metadados adicionais na parte de cabeçalho de uma requisição HTTP.
    -   Exemplo:

        	GET /api/users HTTP/1.1
        	Host: api.exemplo.com
        	Authorization: Bearer token_de_autorizacao

    -   Neste exemplo, `Authorization` é um header parameter que envia um token de autorização para autenticar o usuário na API.
4.  **Body Parameters (Parâmetros de Corpo):**

    -   São usados para enviar dados mais complexos no corpo de uma requisição HTTP, geralmente em formato JSON ou XML.
    -   Exemplo (JSON):
       ```
    GET /api/users HTTP/1.1
	Host: api.exemplo.com
	Authorization: Bearer token_de_autorizacao
    ``` 
    -   Neste exemplo, o corpo da requisição contém um objeto JSON com os dados de um novo usuário a ser criado na API, incluindo nome, idade e email.

Esses são exemplos básicos de cada tipo de parâmetro em uma requisição HTTP, demonstrando como eles podem ser usados para diferentes finalidades na comunicação entre cliente e servidor.

## HTTP Status Codes
Existem cinco famílias de Status Code, referentes ao HTTP:
1.  **1xx (Informational - Informativo):**

    -   Indica que a solicitação foi recebida e está sendo processada. Normalmente, isso não requer nenhuma ação do cliente.
2.  **2xx (Success - Sucesso):**

    -   Indica que a solicitação foi recebida, compreendida e aceita com sucesso.
    -   Exemplos comuns incluem:
        -   200 (OK): Indica que a solicitação foi bem-sucedida.
        -   201 (Created): Indica que a solicitação foi bem-sucedida e resultou na criação de um novo recurso.
        -   204 (No Content): Indica que a solicitação foi bem-sucedida, mas não há conteúdo a ser retornado.
3.  **3xx (Redirection - Redirecionamento):**

    -   Indica que o cliente precisa realizar uma ação adicional para concluir a solicitação.
    -   Exemplos comuns incluem:
        -   301 (Moved Permanently): Indica que o recurso solicitado foi movido permanentemente para uma nova localização.
        -   302 (Found): Indica que o recurso solicitado foi temporariamente movido para uma nova localização.
4.  **4xx (Client Error - Erro do Cliente):**

    -   Indica que houve um erro na solicitação feita pelo cliente.
    -   Exemplos comuns incluem:
        -   400 (Bad Request): Indica que a solicitação feita pelo cliente é inválida ou malformada.
        -   404 (Not Found): Indica que o recurso solicitado não foi encontrado no servidor.
5.  **5xx (Server Error - Erro do Servidor):**

    -   Indica que houve um erro no servidor ao processar a solicitação do cliente.
    -   Exemplos comuns incluem:
        -   500 (Internal Server Error): Indica que ocorreu um erro interno no servidor.
        -   503 (Service Unavailable): Indica que o servidor não está disponível para processar a solicitação no momento.

Esses são apenas alguns exemplos dos códigos de status HTTP mais comuns em cada grupo na família de códigos HTTP. Cada código de status HTTP fornece informações valiosas sobre o resultado de uma solicitação HTTP, ajudando os desenvolvedores a entender e diagnosticar problemas de comunicação entre clientes e servidores web.

Com o site HTTP Cats, é possível entender um pouco melhor sobre os códigos HTTP: [Acessar HTTP Cats](https://http.cat/)

## Verbos HTTP
1.  **GET:**

    -   **Verbo HTTP:** O método GET é usado para recuperar dados de um recurso específico do servidor.
    -   **Possíveis Códigos de Status:** Alguns dos códigos de status comuns que podem ser retornados incluem:
        -   200 (OK): Indica que a solicitação foi bem-sucedida e os dados solicitados foram retornados.
        -   404 (Not Found): Indica que o recurso solicitado não foi encontrado no servidor.
    -   **Tipos de Parâmetros Suportados:** O método GET suporta path, query e também header parameters.
        Por exemplo: `GET /api/users?status=active`.
2.  **POST:**

    -   **Verbo HTTP:** O método POST é usado para enviar dados ao servidor para criar um novo recurso.
    -   **Possíveis Códigos de Status:** Alguns dos códigos de status comuns que podem ser retornados incluem:
        -   201 (Created): Indica que o recurso foi criado com sucesso.
        -   400 (Bad Request): Indica que a solicitação foi malformada ou inválida.
    -   **Tipos de Parâmetros Suportados:** O método POST suporta path, query, body e também header parameters.
3.  **PUT:**

    -   **Verbo HTTP:** O método PUT é usado para atualizar um recurso existente no servidor.
    -   **Possíveis Códigos de Status:** Alguns dos códigos de status comuns que podem ser retornados incluem:
        -   200 (OK): Indica que a atualização foi bem-sucedida.
        -   404 (Not Found): Indica que o recurso a ser atualizado não foi encontrado.
    -   **Tipos de Parâmetros Suportados:** O método PUT suporta path, query, body e também header parameters.
4.  **DELETE:**

    -   **Verbo HTTP:** O método DELETE é usado para excluir um recurso específico do servidor.
    -   **Possíveis Códigos de Status:** Alguns dos códigos de status comuns que podem ser retornados incluem:
        -   204 (No Content): Indica que o recurso foi excluído com sucesso.
        -   404 (Not Found): Indica que o recurso a ser excluído não foi encontrado.
    -   **Tipos de Parâmetros Suportados:** O método DELETE geralmente não suporta parâmetros no corpo da solicitação, pois a identificação do recurso a ser excluído é feita pela URI da solicitação.

Além destes principais verbos, existem outros, que são menos utilizados.

No link abaixo é possível entender um pouco mais sobre os outros verbos:
[Documentação Web Mozilla](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods)


## Níveis de maturidade do REST

Os níveis de maturidade do REST, também conhecidos como Richardson Maturity Model, são uma maneira de classificar a adesão aos princípios e práticas do estilo arquitetural REST. Este modelo foi proposto por Leonard Richardson em 2008 e define quatro níveis de maturidade, cada um representando um estágio na adoção dos princípios RESTful. Aqui está uma visão geral de cada nível:

1. **Nível 0 - POX (Plain Old XML):**
    - Neste nível, a comunicação entre cliente e servidor é baseada no protocolo HTTP, mas não segue nenhum dos princípios RESTful.
    - As operações são geralmente realizadas usando um único endpoint, e os métodos HTTP (como GET, POST, PUT, DELETE) não são utilizados corretamente.
    - Exemplo: Usar apenas um endpoint `/api` e usar apenas o método POST para todas as operações.

2. **Nível 1 - Recursos Individuais:**
    - Neste nível, os recursos individuais são identificados por URIs específicas, mas os relacionamentos entre recursos não são expressos.
    - Os métodos HTTP são usados corretamente para realizar operações nos recursos, mas os verbos são aplicados de forma genérica a todos os recursos.
    - Exemplo: Usar URIs específicas para recursos individuais, como `/api/users/123`, mas usar apenas o método POST para operações CRUD.

3. **Nível 2 - Utilização de Verbos HTTP:**
    - Neste nível, os recursos individuais são identificados por URIs específicas, e os relacionamentos entre recursos são expressos por meio de hyperlinks.
    - Os métodos HTTP são usados corretamente para operações CRUD nos recursos, conforme definido pelos verbos HTTP (GET, POST, PUT, DELETE).
    - Exemplo: Usar URIs específicas para recursos individuais e utilizar os métodos HTTP adequados para operações CRUD, como `/api/users/123` (GET para recuperar, PUT para atualizar, DELETE para excluir).

4. **Nível 3 - HATEOAS (Hypermedia as the Engine of Application State):**
    - Neste nível, os clientes não dependem mais de URIs fixas para interagir com os recursos. Em vez disso, eles seguem links dinâmicos fornecidos nas respostas para descobrir e interagir com os recursos relacionados.
    - A aplicação utiliza hypermedia para fornecer um estado de aplicação completo para o cliente, permitindo que ele descubra e navegue pelos recursos de forma dinâmica.
    - Exemplo: As respostas da API incluem links para recursos relacionados, permitindo que os clientes naveguem pela aplicação sem depender de URIs fixas.

Esses são os quatro níveis de maturidade do REST, de acordo com o modelo de Richardson. Cada nível representa um aumento na adesão aos princípios e práticas do estilo arquitetural RESTful, com o objetivo final de alcançar o nível 3, onde o HATEOAS é totalmente implementado para fornecer uma API altamente flexível e dinâmica.

![Richardson Maturity Model](https://martinfowler.com/articles/images/richardsonMaturityModel/overview.png)

## HATEOAS
HATEOAS (Hypermedia as the Engine of Application State) é um princípio fundamental no estilo arquitetural RESTful que enfatiza o uso de hypermedia para gerenciar o estado da aplicação. Em essência, HATEOAS permite que os clientes naveguem dinamicamente pelos recursos de uma API RESTful por meio de links fornecidos nas respostas.

Em uma API RESTful que adere ao princípio HATEOAS, cada resposta retornada pelo servidor inclui links ou hyperlinks para recursos relacionados, juntamente com informações sobre quais ações são permitidas em cada recurso. Isso permite que os clientes descubram e explorem a API de forma dinâmica, seguindo os links fornecidos e interagindo com os recursos conforme apropriado.

Por exemplo, suponha que uma API RESTful forneça informações sobre usuários e suas postagens. Uma resposta que segue o princípio HATEOAS pode incluir links para as postagens de um usuário específico, permitindo que o cliente navegue diretamente para essas postagens sem precisar conhecer a URI exata de cada recurso.

O uso de **HATEOAS** torna as APIs mais flexíveis e auto-descritivas, reduzindo a dependência dos clientes em URIs fixas e simplificando a integração e evolução da API ao longo do tempo. Ele promove a descoberta de recursos e a navegação dinâmica entre eles, facilitando o desenvolvimento de clientes que interagem de forma mais inteligente e eficiente com a API.

```
{
  "id": 123,
  "nome": "João",
  "idade": 30,
  "links": [
    {
      "rel": "self",
      "href": "https://api.exemplo.com/users/123"
    },
    {
      "rel": "posts",
      "href": "https://api.exemplo.com/users/123/posts"
    },
    {
      "rel": "update",
      "href": "https://api.exemplo.com/users/123",
      "method": "PUT"
    },
    {
      "rel": "delete",
      "href": "https://api.exemplo.com/users/123",
      "method": "DELETE"
    }
  ]
}
```

## Autenticação
Em sistemas RESTful, a autenticação e a autorização são dois conceitos distintos, mas relacionados, que desempenham papéis importantes na segurança e no controle de acesso aos recursos da API. Aqui está a diferença entre eles:

1. **Autenticação:**
    - A autenticação é o processo de verificar a identidade do usuário ou cliente que está acessando a API. Ela valida as credenciais fornecidas pelo usuário para garantir que ele é quem diz ser.
    - O objetivo da autenticação é responder à pergunta: "Quem é você?"
    - Exemplos de métodos de autenticação em REST incluem JWT, Basic Authentication, OAuth, entre outros.

2. **Autorização:**
    - A autorização é o processo de determinar se um usuário autenticado tem permissão para acessar um determinado recurso ou realizar uma determinada ação na API.
    - Ela verifica se o usuário autenticado possui os privilégios necessários para realizar a operação desejada.
    - O objetivo da autorização é responder à pergunta: "Você tem permissão para fazer isso?"
    - A autorização geralmente é baseada em papéis, permissões ou políticas definidas pelo sistema, e pode variar de acordo com o contexto da solicitação.

Em resumo, a autenticação verifica a identidade do usuário, enquanto a autorização verifica as permissões do usuário para acessar recursos específicos da API. Ambos os conceitos são essenciais para garantir a segurança e a integridade dos sistemas RESTful, pois ajudam a controlar quem pode acessar quais recursos e o que podem fazer com esses recursos.
![JWT](https://miro.medium.com/v2/resize:fit:1200/1*u3a-5xZDeudKrFGcxHzLew.png)