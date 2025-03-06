package com.boarddio.menu;

public class MenuUtils {
    public static void exibirCabecalho() {
        System.out.println("\n==============================");
        System.out.println("        BOARD DIO");
        System.out.println("==============================");
    }

    public static void exibirOpcoes() {
        System.out.println("1 - Criar novo board");
        System.out.println("2 - Selecionar board");
        System.out.println("3 - Excluir board");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}
