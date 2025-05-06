package com.ecomerce2.resources;

import com.ecomerce2.dto.ProdutoDTO;
import com.ecomerce2.models.Produto;
import com.ecomerce2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos/")
public class ProdutoResource {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produtoService.converterProdutoParaProdutoDTO(produto));
    }

    @PostMapping("/")
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = produtoService.salvarProduto(produtoDTO);
        return ResponseEntity.ok(produtoDTO);

    }

    @PutMapping()
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = produtoService.atualizarProduto(produtoDTO);
        return ResponseEntity.ok(produtoDTO);

    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarProduto(@RequestBody ProdutoDTO produtoDTO)  {
        produtoService.deletarProduto(produtoDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
