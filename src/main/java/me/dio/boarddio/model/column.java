package com.boarddio.model;

import javax.persistence.*;

@Entity
@Table(name = "columns")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;  // Pode ser "Inicial", "Final", "Cancelamento", "Pendente"

    @Column(name = "position", nullable = false)
    private Integer position;  // Define a ordem da coluna no board

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;  // Relacionamento com o Board

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
