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

Pasta docs:
* Diagrama de Classe: Diagrama de Classe ETL.png
* Arquivo Astah: astah_class_diagram.asta
* Diagrama de dependência de Beans: beans.png
* Resposta do item 5) do exercício: item5.pdf 