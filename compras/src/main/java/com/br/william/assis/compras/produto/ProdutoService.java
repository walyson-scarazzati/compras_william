package com.br.william.assis.compras.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.william.assis.compras.categoria.Categoria;
import com.br.william.assis.compras.categoria.CategoriaRepository;



@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto buscar(Long produtoId)
	{
		return produtoRepository.getOne(produtoId);
	}
	
	@Transactional
	public void associarCategoria(Long produtoId, Long categoriaId)
	{
		Produto produto = buscar(produtoId);

		Categoria categoria = categoriaRepository.getOne(categoriaId);

		produto.adicionarCategoria(categoria);
	}

	@Transactional
	public void desassociarCategoria(Long produtoId, Long categoriaId)
	{
		Produto produto = buscar(produtoId);

		Categoria categoria = categoriaRepository.getOne(categoriaId);

		produto.removerCategoria(categoria);
	}
	
}
