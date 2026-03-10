package com.example.emutuelle.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "villages")
public class Village {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @ManyToOne
    @JoinColumn(name = "cell_id")
    private Cell cell;

    public Village() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Cell getCell() { return cell; }
    public void setCell(Cell cell) { this.cell = cell; }
}