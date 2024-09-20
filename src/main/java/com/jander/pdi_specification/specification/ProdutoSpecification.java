package com.jander.pdi_specification.specification;

import com.jander.pdi_specification.entity.Produto;
import com.jander.pdi_specification.enums.Categoria;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class ProdutoSpecification {

  public static Specification<Produto> nomeContem(String nome, String order) {
    return (root, query, builder) -> {
      if (Objects.equals(order, "desc")) {
        Objects.requireNonNull(query).orderBy(builder.desc(root.get("preco")));
      } else {
        Objects.requireNonNull(query).orderBy(builder.asc(root.get("preco")));
      }
      return builder.like(root.get("nome"), "%" + nome + "%");
    };
  }

  public static Specification<Produto> categoriaIgual(Categoria categoria, String order) {
    return (root, query, builder) -> {
      if (Objects.equals(order, "desc")) {
        Objects.requireNonNull(query).orderBy(builder.desc(root.get("preco")));
      } else {
        Objects.requireNonNull(query).orderBy(builder.asc(root.get("preco")));
      }
      return  builder.equal(root.get("categoria"), categoria);
    };
  }

  public static Specification<Produto> precoMaiorIgualQue(double preco, String order) {
    return (root, query, builder) -> {
      if (Objects.equals(order, "desc")) {
        Objects.requireNonNull(query).orderBy(builder.desc(root.get("preco")));
      } else {
        Objects.requireNonNull(query).orderBy(builder.asc(root.get("preco")));
      }
      return builder.greaterThanOrEqualTo(root.get("preco"), preco);
    };
  }

  public static Specification<Produto> precoMenorIgualQue(double preco, String order) {
    return (root, query, builder) -> {
      if (Objects.equals(order, "desc")) {
        Objects.requireNonNull(query).orderBy(builder.desc(root.get("preco")));
      } else {
        Objects.requireNonNull(query).orderBy(builder.asc(root.get("preco")));
      }
      return builder.lessThanOrEqualTo(root.get("preco"), preco);
    };
  }

  public static Specification<Produto> precoEntre(double precoMin, double precoMax, String order) {
    return (root, query, builder) -> {
      if (Objects.equals(order, "desc")) {
        Objects.requireNonNull(query).orderBy(builder.desc(root.get("preco")));
      } else {
        Objects.requireNonNull(query).orderBy(builder.asc(root.get("preco")));
      }
      return builder.between(root.get("preco"), precoMin, precoMax);
    };
  }
}
