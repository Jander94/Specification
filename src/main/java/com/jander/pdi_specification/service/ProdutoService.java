package com.jander.pdi_specification.service;

import com.jander.pdi_specification.entity.Produto;
import com.jander.pdi_specification.enums.Categoria;
import com.jander.pdi_specification.repository.ProdutoRepository;
import com.jander.pdi_specification.specification.ProdutoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository produtoRepository;

  public List<Produto> listarProdutos(String nome, Double precoMin, Double precoMax, Categoria categoria, String order) {
    Specification<Produto> specification = Specification.where(null);
    if (nome != null && !nome.isEmpty()) {
      specification = specification.and(ProdutoSpecification.nomeContem(nome, order));
    }
    if (categoria != null && !categoria.toString().isEmpty()) {
      specification = specification.and(ProdutoSpecification.categoriaIgual(categoria, order));
    }
    if (precoMin != null && precoMax == null) {
      specification = specification.and(ProdutoSpecification.precoMaiorIgualQue(precoMin, order));
    }
    if (precoMin == null && precoMax != null) {
      specification = specification.and(ProdutoSpecification.precoMenorIgualQue(precoMax, order));
    }
    if (precoMin != null && precoMax != null) {
      specification = specification.and(ProdutoSpecification.precoEntre(precoMin, precoMax, order));
    }
    return produtoRepository.findAll(specification);
  }

  public Produto salvarProduto(Produto produto) {
    return produtoRepository.save(produto);
  }

  public void deletarProduto(Long id) {
    produtoRepository.deleteById(id);
  }

}
