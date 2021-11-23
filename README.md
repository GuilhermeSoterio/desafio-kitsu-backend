<h2 align="center">
  🔥 Desafio Kitsu - Firedev IT :coffee: 🔥
</h2>

<p align="center">
 <a href="#-solução">Solução</a> •
 <a href="#-tecnologias">Tecnologias</a> •
 <a href="#-tecnologias">Banco de dados</a> •
  <a href="#-ferramentas">Documentação</a> •
 <a href="#-ferramentas">Ferramentas</a> •
  <a href="#-testes">Testes</a> •
 <a href="#-testes">Considerações</a>
</p>

## 💡 Solução
Para o problema proposto o primeiro passo foi realizar uma análise da API com as rotas necessárias para retornar os dados requisitados.
Aps essa verificação, com as rotas já pré selecionadas, foi necessário então encontrar um framework que fizesse o consumo dessa API e o manipulasse com  o <b>SpringBoot</b> em Java.
Para esse objetivo foi utilizado o framework <b>Open-Feign</b>.

Encontrado essas respostas, então criei a arquitetura de camadas iriam necessárias, considerando a parte do problema a implantação de uma Estrutura no <b>Banco de dados</b>. A estrutura ficou dividida da seguinte forma: Camada Model, camada Services, camada Repository e camada Rest.
<br>- <b>Camada Model</b> contendo as entidades de modelo para a API.
<br>- <b>Camada Service</b> está comunicando com os modelos e e com a RestService com a lógica das consultas da API
<br>- <b>Camada Repository</b> responsável por fazer consultas no banco de dados.
<br>- <b>Camada Rest Service</b> está contida todas as rotas tratadas e implementadas pelo Service

## 💻 Tecnologias
As seguintes tecnologias foram utilizadas na construção do projeto:
- [Java 11](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/)
- [MySQL](https://www.mysql.com)
- [Junit](https://junit.org/junit5/)

Hospedagem realizada com Heroku:
<b>Hospedagem:</b> https://firedev-guilhermesoterio.herokuapp.com/

## 📐 Banco de Dados
Para a solução desse problema, pensei em criar uma tabela que representasse a entidade de pesquisa. Ela contem três atributos: Id, Moment e Busca, utilizando o <b>MySQL</b> então criei essa tabela e com o auxilio do spring integrei o banco de dados a uma classe mapeada pelo JPA com um repository para gerar um gatilho toda vez que a rota de Pesquisa fosse acionada iria criar um registro nessa tabela.

O método de inserção no banco de dados, foi criado utilizando o <b>EntityManager</b> que é um serviço que permite sincronizar operações com banco de dados personalizando essas consultas conforme a necessidade.

### Configurando o Banco de dados:
```bash
# Criando um Banco de dados:
Create table tb_pesquisa(
 id int PRIMARY KEY auto_increment, moment timestamp, busca varchar(255)
 );
```
```bash
USE tb_pesquisa;
# Inserindo valores
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "Samurai X");
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "Dragon Ball Z");
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "One Punch Man");
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "Sakura Cards");
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "Jujutso no Kaizen");
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "Demon Salyer");
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "Naruto");
INSERT INTO tb_pesquisa(id, moment, busca) VALUES (null, NOW(), "Naruto");
```
```bash
# Gerando relatório
SELECT  distinct id, CONCAT(busca, "(",count(id),")") AS quantidade FROM tb_pesquisa GROUP BY busca ORDER BY count(id) DESC;
```
<p align="center">
  <img src="Relatorio-mysql.png" width="350">
</p>

## 📝 Documentação
### -Documentação das classes
Para documentar o código, foi utilizado o Javadoc. Acesse a pasta doc, e execute o arquivo: "index.html" para poder abrir toda a documentação formatada pelo javadoc.
### -Documentação da API
Documentação hospedada pelo Heroku.
https://firedev-guilhermesoterio.herokuapp.com/swagger-ui/index.html

## 🛠 Ferramentas

- [Spring Tools Suite 4](https://spring.io/tools) - IDE de desenvolvimento de aplicações Spring.
- [Postman](https://www.postman.com/) - documentação das requisições API REST.
- [Swagger](https://swagger.io) - framework para documentar as rotas da API.

## 📈 Testes
        Foram implementados testes unitários cobrindo todas as entidades e classes presentes.
<br>• Testes na camada model
<br>• Testes na camada Service
<br>• Testes na camada Rest
      
#### Como rodar os testes?
Na pasta raiz, navegue para a pasta <b>src</b> > <b>test </b> com o botão direito do mouse no: <b>src/test/java</b> clique no Run as> Junit Test


## 🔗 Considerações

Com certeza a experiência de realizar este teste foi bem interessante, particularmente foi bem empolgante todo o seu percurso e os obstáculos que eu tive que ultrapassar durante o desenvolvimento. Quero agradecer muito toda a equipe envolvido e o suporte que me deram, em especial o Guilherme Mallmann que foi bastante presente e empático.
