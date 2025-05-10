package com.ecomerce2.service;

import com.ecomerce2.dto.ProdutoDTO;
import com.ecomerce2.models.Produto;
import com.ecomerce2.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private  ProdutoRepository produtoRepository;
    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = converterProdutoDTOParaProduto(produtoDTO);
        produto = produtoRepository.save(produto);
        return converterProdutoParaProdutoDTO(produto);
    }
    public static ProdutoDTO converterProdutoParaProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setImagem(produto.getImagem());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setCategoria(produto.getCategoria());
        return produtoDTO;
    }

    public static Produto converterProdutoDTOParaProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setImagem(produtoDTO.getImagem());
        produto.setPreco(produtoDTO.getPreco());
        produto.setCategoria(produtoDTO.getCategoria());
        return produto;
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }
    public ProdutoDTO atualizarProduto(ProdutoDTO produtoDTO) {
        if (produtoDTO.getId() == null) {
            throw new IllegalArgumentException("id não informado");
        }
        Produto produto = produtoRepository.findById(produtoDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado"));
        produto = converterProdutoDTOParaProduto(produtoDTO);
        produto = produtoRepository.save(produto);
        return converterProdutoParaProdutoDTO(produto);
    }


    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }


}
