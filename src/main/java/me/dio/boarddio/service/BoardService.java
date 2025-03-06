package com.boardidio.service;

import com.boarddio.model.Board;
import com.boarddio.repository.BoardRepository;

public class BoardService {

    private BoardRepository boardRepository;

    public BoardService() {
        this.boardRepository = new BoardRepository(); // Inicializa o repositório do board
    }

    public Board criarBoard(String nome) {
        Board board = new Board();
        board.setNome(nome);
        // Salva o board no banco de dados
        return boardRepository.save(board); // Aqui você vai salvar no banco de dados
    }

    public Board buscarBoardPorId(int id) {
        return boardRepository.findById(id); // Busca o board pelo ID no banco de dados
    }

    public boolean excluirBoard(int id) {
        return boardRepository.deleteById(id); // Exclui o board do banco de dados
    }

    // Outros métodos que você pode precisar (como listar todos os boards, etc)
}
