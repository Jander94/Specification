package com.jander.pdi_specification.controller;

import com.jander.pdi_specification.entity.Produto;
import com.jander.pdi_specification.enums.Categoria;
import com.jander.pdi_specification.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoService produtoService;

  @GetMapping
  public List<Produto> getProdutos(
          @RequestParam(required = false) String nome,
          @RequestParam(required = false) Double precoMin,
          @RequestParam(required = false) Double precoMax,
          @RequestParam(required = false) Categoria categoria,
          @RequestParam(required = false) String order
  ) {
    return produtoService.listarProdutos(nome, precoMin, precoMax, categoria, order);
  }

  @PostMapping
  public Produto salvarProduto(@RequestBody Produto produto) {
    return produtoService.salvarProduto(produto);
  }

  @DeleteMapping("{id}")
  public void deletarProduto(@RequestParam Long id) {
    produtoService.deletarProduto(id);
  }
}
