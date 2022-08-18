### Tema
Uma API para um jogo de perguntas e respostas

### Funcionalidades
* Cadastrar, deletar e manipular perguntas/respostas*
* Cadastrar, deletar e manipular jogadores*
* Cadastra, deletar e manipular partidas*
* Logar jogador**
* Iniciar partida
* Buscar buscar pergunta atual da partida
* Pular pergunta
* Responder pergunta
* Desistir da partida
* Listar partidas para um jogador
* Ranking de jogadores

### Entidades
* Pergunta
  - id
  - texto
* Alternativa
  - id
  - idPergunta
  - texto
  - ehCorreta
* Partida
  - id
  - idJogador
  - estaAtiva
  - pontuacao
* Resposta
  - id
  - idPartida
  - idPergunta
  - idAlternativa
  - estaAtiva
* Jogador
  - id
  - nome
  - usuario
  - senha

### Diagrama
![Diagrama](/diagrama.png?raw=true "Diagrama de classes")
