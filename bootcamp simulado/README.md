bootcamp simulado 

1)É um modelo de programação baseado na modelagem do sistema por meio de objetos, que representam entidades do mundo real, combinando dados presentes nele ou seja seus atributos e ações e comportamentos nas quais eles podem realizar ou seja seu métodos .A vantagem de se utilizar o método de poo seria a organização do código na qual fica mais limpo, e decorrente disso traz sua segunda vantagem que é justamente facilitar a parte da manutenção do próprio.

2)Encapsulamento é o princípio de ocultar os detalhes internos de um objeto e permitir acesso controlado aos seus dados por meio de métodos getters e setters.
Ele acaba por resolver problemas como:
Acesso indevido aos atributos;
Dificuldade de manutenção;
Quebra de regras de negócio

3)O princípio violado aqui é o de Encapsulamento.
Os atributos são public, permitindo acesso direto externo, o que quebra o controle interno do objeto.

4) utilizando os getters e setters você controla o acesso aos atributos assim tendo a necessidade de permissão de validações, além de também facilicar a manutenção e progressão do código em questão e também protege os dados para não ter uso indevido.

5) encapsulando os atributos com as seguintes questões
    private Long id;
    private String nome;
    private double preco;

Além disso também deve utilizar os gets e setter corretos como os abaixo:
    public void setNome(String nome) { this.nome = nome;}
 
    public double getPreco() { return preco; }

    public void setPreco(double preco) { this.preco = preco; }


6) Spring Boot é um framework que simplifica o desenvolvimento de aplicações Spring, reduzindo configurações manuais assim aumentando muito mais a produtividade e facilitando a configuração pois já tem uma configuração automática.

7)A anotação na qual define um controller rest é o @RestController

8)Define o mapeamento de URLs para métodos ou classes, associando rotas HTTP a handlers do controller.

9)O Controller  está acessando diretamente o Repository, violando o princípio de separação de camadas.O correto nessa ocasião seria usar uma Service Layer.

10) GET = Buscar dados (tipo um select da linguagem sql)
POST = Criar novo recurso (tipo insert do sql)
PUT = Atualizar recurso existente (tipo update do sql)
DELETE = Remover recurso

11) O JPA é especificação para mapeamento objeto-relacional. já o Hibernate é justamente a implementação da JPA que realiza a persistência no banco.

12)O comando @Entity que é utilizado para isso.

13) a função do comando @Id é de Definir a chave primária.Enquanto o @GeneratedValue é quem Define o método de geração automática do ID

14)As responsabilidades fornecidas pela interface é a de 
Operações CRUD (save, findById, delete…),além disso tem a 
Paginação e ordenação de forma automática.

15)Por meio do uso Do JPA é possivel ter a Redução de acoplamento ao banco assim removendo a necessidade direta de construção de códigos sql manuais. 

16) DTO ou Data Transfer Object é um objeto usado para transferir dados entre camadas, evitando expor diretamente a entidade.

17)A função está recebendo e retornando o produto, ou seja caso tenha alguma modificação nesse produto irá quebrar a api assim violando a questão de DTO.

18)As responsabilidade da camada sevice é a de Centralizar as regras de negócio, desacoplar controller do repositório e organizar melhor a lógica da aplicação.
Além disso Implementar regras de negócio e coordenar operações entre controller e repositor.

19)A regra de negocio fica na camada service, pois é onde todas as ações estão são coordenadas entre controller e repositor assim tornando necessário que em caso de regras a serem aplicadas nas ações elas acabarem por ter de ser atribuídas nessa camada.

20)Porque viola a questão da separação de responsabilidades e dificulta manutenção, testes e escalabilidade.

21) Um exemplo de aplicação:
Errado: classe que valida, salva e gera relatório
Certo: cada responsabilidade em uma classe separada ou seja uma 

22) O principio violado é o de SRP pois o controller nessa situação apresenta mais funções do que deveria pois apresenta a logica de validação mas também a regra de negocio e o acesso ao banco quando deveria apenas ter uma função principal.

23) Classes devem estar abertas para extensão e fechadas para modificação.

24)Subclasses devem poder substituir a classe base sem alterar o comportamento esperado.

25)Interfaces devem ser específicas, evitando métodos que não serão usados.

26)O principio violado é o de ISP pois ele está utilizando métodos na qual não são relacionados um ao outro. No caso o melhor a se fazer seria uma quebra de métodos menores. 

27)Módulos de alto nível não devem depender de módulos de baixo nível, ambos devem depender de abstrações.

28)Uso de interfaces e injeção de dependência.

29) O fluxo de forma mais visual é Cliente ->Controller -> Service -> Repository -> Banco -> retorno ao cliente

30)por que acabam por Reduzir o acoplamento facilita a execução de testes, melhora e facilita a manutenção do código, aumenta a proteção de classes e dados além de Permitir que haja evolução sem quebrar código.
