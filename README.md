# treinamento-spring-boot-2026-exercicios

## Exercício 1

**Executar dentro do diretório exercicio1**: 

```bash
mvn clean install
mvn exec:java -Dexec.mainClass=br.uff.sti.App -Dexec.args="input.csv"
```

## Exercício 2

**Executar dentro do diretório exercicio2**: 

```bash
mvn clean install
mvn spring-boot:run
```
Obs:
* 1- arquivo custom_input.json em src/main/resources
* 2- saida csv do json em custom_output.csv em src/main/resources
* 3- saída csv do log em custom_log_output.csv em src/main/resources
* 4- não utilizada uma classe ou record para mapear os dados do Json, foi utilizado um Map, para que a quantidade de atributos do Json pudesse ser dinâmica sem precisar alterar o código. Foi acrescentado um campo novo Telefone ao Json dado de exemplo.

Pasta docs:
* Diagrama de Classe: Diagrama de Classe ETL.png
* Arquivo Astah: astah_class_diagram.asta
* Diagrama de dependência de Beans: beans.png
* Resposta do item 5) do exercício: item5.pdf 

## Exercício 3

**Executar dentro do diretório hsqldb**:

Colocar o hsqldb para executar

```bash
./run.sh
```
Isso vai colcoar a instância do banco para rodar (mydb-exercicios)

**Executar dentro do diretório exercicio3**:

Antes de executar a aplicação, criar o schema com uso da IDE de banco:
* executar o arquivo src/main/resources/schema.sql 
* post.data_postagem agora é um TIMESTAMP
* o nome do schema agora é AP3_EXERCICIOS

Para utilizar uma IDE de banco utilize a conexão de banco:

```bash
jdbc:hsqldb:hsql://localhost:9001/mydb-exercicios
```
* username: sa
* senha: (vazio)

Executar a aplicação:

```bash
mvn clean install   # -DskipTests #se qusiser não executar os testes
mvn spring-boot:run # -DskipTests #se qusiser não executar os testes
```

O que será impresso:

Cada item do exercício será impresso com o formato:

```bash
=========================================================
| Item: #
=========================================================
```
Onde # corresponde ao respectivo Item 

Obs:
* 1- arquivo schema.sql em src/main/resources
* 2- application.properties com debug e show_sql = true

Pasta docs:
* Resposta do Item 6) do exercício: item6.pdf

## Exercício 4

**Executar dentro do diretório hsqldb**:

Colocar o hsqldb para executar

```bash
./run.sh
```
Isso vai colcoar a instância do banco para rodar (mydb-exercicios)

**Executar dentro do diretório exercicio4**:

Antes de executar a aplicação, criar o schema com uso da IDE de banco:
* executar o arquivo src/main/resources/schema.sql 
* post.data_postagem agora é um DATETIME
* o nome do schema agora é AP4_EXERCICIOS

Para utilizar uma IDE de banco utilize a conexão de banco:

```bash
jdbc:hsqldb:hsql://localhost:9001/mydb-exercicios
```
* username: sa
* senha: (vazio)

Executar a aplicação:

```bash
mvn clean install   # -DskipTests #se qusiser não executar os testes
mvn spring-boot:run # -DskipTests #se qusiser não executar os testes
```

URL: http://localhost:8080/

Será exibido um index com links para Posts e Usuarios.

Obs:
* 1- arquivo schema.sql em src/main/resources
* 2- application.properties com 'spring.thymeleaf.cache=false' e 'spring.mvc.hiddenmethod.filter.enabled=true'

