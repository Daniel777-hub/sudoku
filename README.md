Com certeza. Aqui está o conteúdo do seu `README.md`, pronto para ser adicionado à pasta raiz do seu projeto. Ele descreve o projeto, as inovações que foram adicionadas e como executá-lo.

---


# Sudoku

Este é um projeto de jogo de Sudoku em Java, desenvolvido para ser executado no console. Ele foi aprimorado com funcionalidades avançadas para oferecer uma experiência de jogo dinâmica e interativa.

## **Recursos Principais**

* **Jogo em Console:** Toda a interação com o usuário é feita através do terminal, oferecendo uma interface simples e direta.
* **Geração Dinâmica de Tabuleiros:** O jogo não depende mais de um tabuleiro fixo. [cite_start]Ele utiliza um algoritmo de **backtracking** para gerar tabuleiros de Sudoku únicos e válidos a cada nova partida, com diferentes níveis de dificuldade[cite: 1, 2].
* **Controle de Dificuldade:** Ao iniciar um novo jogo, você pode escolher entre três níveis de dificuldade (Fácil, Médio e Difícil). [cite_start]O nível de dificuldade é determinado pela quantidade de números pré-preenchidos no tabuleiro[cite: 1, 2].

## **Como Executar o Projeto**

Para rodar o jogo, certifique-se de ter o **JDK 21** ou superior instalado em sua máquina. O projeto foi configurado no IntelliJ IDEA, mas pode ser executado em qualquer IDE que suporte Java.

1.  **Clone o Repositório:** Se você for usar Git, clone o projeto para o seu diretório local.
2.  **Abra o Projeto:** Abra a pasta do projeto em sua IDE (IntelliJ IDEA, Eclipse, etc.).
3.  **Execute a Classe `Main`:** Navegue até a classe `Main.java` (localizada em `src/br/com/dio/Main.java`) e execute-a.
4.  **Jogue:** Siga as instruções no console para navegar pelo menu e jogar.

## **Estrutura do Projeto**

O projeto segue uma estrutura de pacotes para manter o código organizado e com alta coesão:

* `br.com.dio.Main`: A classe principal que gerencia a interface com o usuário, o menu e a interação com a lógica do jogo.
* `br.com.dio.model`: Contém as classes que representam os elementos do jogo:
    * **`Board`**: A lógica do tabuleiro e as regras do jogo.
    * **`Space`**: A classe que representa cada célula do tabuleiro.
    * **`GameStatusEnum`**: Uma enumeração para os diferentes estados do jogo.
* `br.com.dio.util`: Contém classes utilitárias para o projeto:
    * [cite_start]**`BoardGenerator`**: O gerador de tabuleiros que cria novos jogos dinamicamente[cite: 1, 2].
    * **`BoardTemplate`**: A constante de string que define a aparência do tabuleiro no console.

## **Contribuições Futuras**

As próximas melhorias planejadas para o projeto incluem:

* **Sistema de Validação Inteligente:** Para verificar se cada movimento é válido em tempo real.
* **Funcionalidade de Dica:** Para ajudar o jogador a resolver o tabuleiro, fornecendo a resposta correta de um espaço vazio.
* **Interface Gráfica (GUI):** Aprimorar a experiência do usuário com uma interface visual, substituindo a interação por console por uma janela gráfica.
