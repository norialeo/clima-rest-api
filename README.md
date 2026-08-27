# 🌦️ API REST de Clima - Belo Horizonte (Spring Boot)

API REST desenvolvida em Java com Spring Boot para consultar e disponibilizar informações meteorológicas em tempo real da cidade de Belo Horizonte - MG, consumindo a API externa do Open-Meteo.

---

## 👥 Integrantes (Dupla)
- **Integrante 1:** [Leonardo Gonzaga]
- **Integrante 2:** [João Pedro Oliveira]

---

## 💻 Código-Fonte Completo
O projeto está organizado na seguinte estrutura padrão de pacotes do Spring Boot:

```text
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── ClimaRestAPI/
                    ├── controller/
                    │   └── ClimaController.java
                    ├── service/
                    │   └── ClimaService.java
                    └── ClimaRestApiApplication.java



📦 Dependências Utilizadas
As dependências do projeto estão gerenciadas via Maven (pom.xml):

Java 21

Spring Boot 3.4.1

Spring Web (spring-boot-starter-web): Para criação de endpoints REST e requisições HTTP via RestTemplate.

Jackson Databind: Para processamento e parse dos objetos JSON recebidos da API externa.

Spring Boot Starter Test: Para suporte a testes unitários/integração.

🔑 Orientações para Configuração de API Key
Observação: Esta aplicação consome a API do Open-Meteo, que é um serviço meteorológico gratuito e sem necessidade de API Key.
Portanto, nenhuma chave de acesso precisa ser configurada no arquivo application.properties ou em variáveis de ambiente para a execução do projeto.

🌐 Documentação dos Endpoints
1. Obter Clima de Belo Horizonte - MG
Endpoint: /clima/belo-horizonte

Método HTTP: GET

Descrição: Retorna os dados climáticos atuais (temperatura, umidade, vento) e previsões do dia (mínima e máxima) para Belo Horizonte.

Headers: Content-Type: application/json



▶️ Instruções para Executar a Aplicação Localmente
Pré-requisitos
JDK 21 instalado e configurado nas variáveis de ambiente.

Git instalado.

IDE de sua preferência (VS Code, IntelliJ IDEA, Eclipse).

Passo a Passo
1 - Clonar o repositório: git clone https://github.com/norialeo/clima-rest-api

2 - Compilar e baixar dependências:
  ./mvnw clean install

3 - Executar a aplicação:
  Via Terminal: ./mvnw spring-boot:run

4 - Testar o endpoint:
Abra o navegador ou uma ferramenta HTTP (Postman/Insomnia) e acesse: http://localhost:8080/clima/belo-horizonte
