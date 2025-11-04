# Trabalho 3 de Algoritmos e Estruturas de Dados I

Este repositório contém a implementação de duas aplicações didáticas. Ambas usam estruturas em árvore implementadas em Java
e foram desenvolvidas como exercícios práticos para estudar percursos, operações e
propriedades de árvores.

Modos disponíveis
1. Torneio Eliminatório (árvore binária)
	 - Implementação em `src/arvoreBinaria/` (classe principal: `BinaryTreeOfInteger`).
	 - Simula um torneio eliminatório onde cada nó representa um competidor.
	 - Operações típicas: construir a árvore do torneio, percursos (pré, pós, largura), remoções/atualizações.

2. Navegação de App / Menu Hierárquico (árvore genérica)
	 - Implementação em `src/arvoreGenerica/` (classe principal: `GeneralTreeOfInteger`).
	 - Modela menus ou navegação hierárquica de um aplicativo (cada nó pode ter N filhos).
	 - Possui operações de inserção de itens, remoção de galhos (subárvores), percursos (pré-ordem e em largura), consulta de nível e outras utilidades (altura, grau máximo, etc.).

## Estrutura do projeto

- `src/`
	- `arvoreGenerica/Main.java`: classe com menu de interface simples e interativo para testar operações da árvore genérica.
	- `arvoreBinaria/`
		- `BinaryTreeOfInteger.java`: implementação da árvore binária usada para o torneio.
		- `LinkedListOfInteger.java`, `EmptyTreeException.java`: utilitários usados pela árvore binária.
	- `arvoreGenerica/`
		- `GeneralTreeOfInteger.java`: implementação da árvore genérica (n-ária) usada para o menu hierárquico.
		- `Queue.java`, `EmptyQueueException.java`: utilitários auxiliares.

	## Execução via linha de comando (PowerShell)

	Comandos objetivos para compilar e executar no Windows PowerShell:

	1) Compilar (gera classes em `out`):

	```powershell
	if (!(Test-Path out)) { New-Item -ItemType Directory -Path out }
	javac -d out src\Main.java src\arvoreGenerica\*.java src\arvoreBinaria\*.java
	```

	2) Executar (Main no package default):

	```powershell
	java -cp out Main
	```

	3) Executar a versão com `Main` no package `arvoreGenerica` (se aplicável):

	```powershell
	java -cp out arvoreGenerica.Main
	```

	Esses comandos são intencionados para uso rápido; ajuste os caminhos se o `Main` desejado estiver em outro local.
