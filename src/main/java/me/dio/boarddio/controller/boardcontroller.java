package com.boarddio.controller;

import com.boarddio.models.Board;
import com.boarddio.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Controller
public class BoardController {
    private final BoardRepository boardRepository;
    private final Scanner scanner;

    @Autowired
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
        this.scanner = new Scanner(System.in);
    }

    public void criarBoard() {
        System.out.print("Digite o nome do novo board: ");
        String nome = scanner.nextLine();

        Board novoBoard = new Board();
        novoBoard.setNome(nome);

        boardRepository.save(novoBoard);
        System.out.println("Board criado com sucesso!");
    }

    public void listarBoards() {
        List<Board> boards = boardRepository.findAll();
        if (boards.isEmpty()) {
            System.out.println("Nenhum board encontrado.");
        } else {
            boards.forEach(board -> System.out.println(board.getId() + " - " + board.getNome()));
        }
    }

    public void excluirBoard() {
        System.out.print("Digite o ID do board a ser excluído: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir quebra de linha

        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent()) {
            boardRepository.delete(board.get());
            System.out.println("Board excluído com sucesso!");
        } else {
            System.out.println("Board não encontrado.");
        }
    }
}
