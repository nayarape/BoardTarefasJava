package com.boarddio.menu;

import com.boarddio.controller.BoardController;
import com.boarddio.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    private final BoardController boardController;
    private final Scanner scanner;

    @Autowired
    public Menu(BoardController boardController) {
        this.boardController = boardController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            MenuUtils.exibirCabecalho();
            MenuUtils.exibirOpcoes();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    boardController.criarBoard();
                    break;
                case 2:
                    boardController.listarBoards();
                    break;
                case 3:
                    boardController.excluirBoard();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }
}
