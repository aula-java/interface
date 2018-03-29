## [Módulo 1: Programação Java](https://aula-java.github.io/aulas/modulo-1.html)

### [Exercício: Conceitos Avançados: Interfaces](https://aula-java.github.io/aulas/avancado/#/6)

1. Clone o projeto e analise o código

<img height="400" src="https://aula-java.github.io/aulas/avancado/interface/exerc-1.png">

2. Transforme a classe **Conta** em uma interface e adapte as classes **ContaCorrente** e **ContaPoupanca**. Não altere nenhuma classe de teste, exceto **ContaTest**, que deve ser removida do projeto. Os testes devem todos passar com essas modificações.

3. A interface **Comparable** definida no pacote *java.lang* serve para comparar objetos. Ela é utilizada geralmente para a ordenação de elementos. A classe que implementar **Comparable** é obrigada a fornecer a implementação para o método abstrato:
```
  int compareTo(Object o)

  Faça a alteração na classe Conta para implementar a interface Comparable<Conta>. 
  O método de comparação irá retornar o valor inteiro da soma de (saldo + limite) da 
  classe base menos (saldo + limite) da classe passada como argumento. Não se esqueça 
  de fazer a conversão para inteiro. 

  A classe ContaTest deve passar pelo teste abaixo:
    @Test
    public void testComparaContas() {
      Conta cc = new ContaCorrente();
      cc.setLimite(1000);
      cc.setSaldo(2000);

      Conta cp = new ContaPoupanca();
      cp.setSaldo(500);

      assertEquals("A diferença da conta poupanca é (500) - (1000+2000)", -2500,cp.compareTo(cc));
      assertEquals("A diferença da conta poupanca é (1000+2000) + 500", 2500,cc.compareTo(cp));

      cp.setLimite(200);
      assertEquals("A diferença da conta poupanca é (1000+2000) + 500", 2300,cc.compareTo(cp));

  }
```  

4. Uma cópia é diferente de uma clonagem. A cópia é uma referência ao objeto original e alterações realizadas sobre a cópia irão afetar o objeto original
```
  Ex: 

  Data d = new Data(2, 4, 1973);

  Data d2 = d;
  Qualquer modificação em d altera d2 e vice versa.

  O clone, por sua vez, é um novo objeto com conteúdo idêntico ao original (atributos), 
  mas com o tempo de vida e ObjectID próprios. Ele compartilha com o original a referência 
  aos objetos "agregados"

  Ex: 

  Data d = new Data(2, 4, 1973);

  Data d2 = (Data)d.clone();
  As alterações em d não impactam d2, pois d2 é um novo objeto clonado de d.

  Para utilizar o método clone() da classe Object, é necessário que a classe que terá os objetos 
  clonados implemente a interface Cloneable e o método clone(). 
    @Override
    protected Conta clone()  {...}

  Altere a classe Conta para adicionar o método clone() de forma que passe nos testes unitários 
  abaixo que devem ser adicionados em ContaTest.
  
    @Test
    public void testClonaContas() {
      Conta conta = new Conta();
      conta.setLimite(1000);
      conta.setSaldo(2000);
      conta.setNumero(12345);
      conta.setTitular(new Cliente());

      Conta cloneConta = conta.clone();
      assertEquals("A conta original possui o limite de 1000", 1000,conta.getLimite(),0);
      assertEquals("O clone possui o mesmo limite da conta original", 1000,cloneConta.getLimite(),0);

      cloneConta.setLimite(2000);
      assertEquals("A conta original não altera o limite de 1000", 1000,conta.getLimite(),0);
      assertEquals("O clone que é um novo objeto e diferente de conta teve seu limite alterado para 2000", 
          2000,cloneConta.getLimite(),0);

    }

    @Test
    public void testCopiaContas() {
      Conta conta = new Conta();
      conta.setLimite(1000);
      conta.setSaldo(2000);
      conta.setNumero(12345);
      conta.setTitular(new Cliente());

      Conta copiaConta = conta;
      assertEquals("A conta original possui o limite de 1000", 1000, conta.getLimite(),0);
      assertEquals("A copia possui o mesmo limite da conta original", 1000,copiaConta.getLimite(),0);

      conta.setLimite(2000);
      assertEquals("A conta original teve seu limite alterado para 2000", 2000, conta.getLimite(),0);
      assertEquals("O clone também teve seu limite alterado para 2000",2000,copiaConta.getLimite(),0);

    }
```

