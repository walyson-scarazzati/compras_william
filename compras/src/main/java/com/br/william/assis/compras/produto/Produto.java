package com.br.william.assis.compras.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.DecimalMin;

import com.br.william.assis.compras.categoria.Categoria;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
    private String nome;

      @Column(scale = 2) @DecimalMin("0.00")
     private BigDecimal preco;

      @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns =@JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
      private List<Categoria> categorias= new ArrayList<>();

     @Deprecated
    public Produto() {
    }

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public boolean adicionarCategoria(Categoria categorias)
	{
		return getCategorias().add(categorias);
	}

	public boolean removerCategoria(Categoria categorias)
	{
		return getCategorias().remove(categorias);
	}

	
}
