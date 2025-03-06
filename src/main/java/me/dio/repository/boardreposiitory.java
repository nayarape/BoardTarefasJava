package com.boarddio.repository;

import com.boarddio.model.Board;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BoardRepository {

    private EntityManagerFactory emf;
    private EntityManager em;

    public BoardRepository() {
        emf = Persistence.createEntityManagerFactory("seu_persistence_unit");
        em = emf.createEntityManager();
    }

    public Board save(Board board) {
        em.getTransaction().begin();
        em.persist(board);
        em.getTransaction().commit();
        return board;
    }

    public Board findById(int id) {
        return em.find(Board.class, id);
    }

    public boolean deleteById(int id) {
        Board board = findById(id);
        if (board != null) {
            em.getTransaction().begin();
            em.remove(board);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    // Outros métodos, como listar todos os boards, podem ser adicionados aqui
}
