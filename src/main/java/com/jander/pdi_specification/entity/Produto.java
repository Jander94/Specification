package com.jander.pdi_specification.entity;

import com.jander.pdi_specification.enums.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @Column
  public String nome;

  @Column
  public Double preco;

  @Column
  @Enumerated(EnumType.STRING)
  public Categoria categoria;
}
