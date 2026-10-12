# Blue Lock Mod (Fabric 1.21.1)

## Itens
- **Bola de Futebol**: clique direito pra chutar (6 de dano + empurrão). Cai no chão quando acerta algo, é só pegar de novo.
- **Chuteira Blue Lock**: bota que dá Velocidade II enquanto estiver equipada.
- **Metavisão**: por 10s mostra todo mundo num raio de 20 blocos (Brilho), + Visão Noturna e Velocidade. Recarga de 30s.

Todos estão na aba criativa "Blue Lock".

## Como compilar
1. Instale o JDK 21.
2. Na pasta do projeto rode `gradle wrapper` (ou copie a pasta `src/` pra um projeto gerado em https://fabricmc.net/develop/template).
3. `./gradlew build` -> o .jar fica em `build/libs/`.
4. Coloque o .jar na pasta `mods` junto com o Fabric Loader e o Fabric API (1.21.1).

## Testar direto no jogo
`./gradlew runClient`
