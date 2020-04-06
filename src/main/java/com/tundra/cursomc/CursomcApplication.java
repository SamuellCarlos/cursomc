package com.tundra.cursomc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tundra.cursomc.domain.Categoria;
import com.tundra.cursomc.domain.Cidade;
import com.tundra.cursomc.domain.Cliente;
import com.tundra.cursomc.domain.Endereco;
import com.tundra.cursomc.domain.Estado;
import com.tundra.cursomc.domain.Produto;
import com.tundra.cursomc.domain.enums.TipoCliente;
import com.tundra.cursomc.repositories.CategoriaRepository;
import com.tundra.cursomc.repositories.CidadeRepository;
import com.tundra.cursomc.repositories.ClienteRepository;
import com.tundra.cursomc.repositories.EnderecoRepository;
import com.tundra.cursomc.repositories.EstadoRepository;
import com.tundra.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
		
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	public void run(String... args ) {
		
		
			//Cadastro e lançamentoo do Categoria e Produto
			Categoria cat1 = new Categoria(null, "informátia");
			Categoria cat2 = new Categoria(null, "Escritório");
			Produto p1 = new Produto(null, "Computador", 2000.00);
			Produto p2 = new Produto(null, "Impressora", 800.00);
			Produto p3 = new Produto(null, "Mouse", 80.00);
			cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
			cat2.getProdutos().addAll(Arrays.asList(p2));
			p1.getCategorias().addAll(Arrays.asList(cat1));
			p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
			p3.getCategorias().addAll(Arrays.asList(cat1));
			categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
			produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
			
			
			//Lançamento de Estado e Cidades
			Estado est1 = new Estado(null, "Paraiba");
			Estado est2 = new Estado(null, "São Paulo");
			Cidade c1 = new Cidade(null, "Campina Grande", est1);
			Cidade c2 = new Cidade(null, "São Paulo", est2);
			Cidade c3 = new Cidade(null, "João Pessoa",est1);
			est1.getCidades().addAll(Arrays.asList(c1, c3));
			est2.getCidades().addAll(Arrays.asList(c2));
			estadoRepository.saveAll(Arrays.asList(est1, est2));
			cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
			
			
			//Lançamennto de Cliente, Telefone e Endereço
			Cliente cli1 = new Cliente(null, "Maria da Silva", "maria@gmail.com", "01001001000101", TipoCliente.PESSOAFISCIA);
			cli1.getTelefones().addAll(Arrays.asList("0833988888888", "083999999999"));	
			Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 202", "Catolé", "58410000", cli1, c1);
			Endereco e2 = new Endereco(null, "Avenida Matos", "1100", "Sala 800", "Centro", "58410000", cli1, c2);
			cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
			clienteRepository.saveAll(Arrays.asList(cli1));
			enderecoRepository.saveAll(Arrays.asList(e1, e2));
			Cliente cli2 = new Cliente(null, "Gabriel Barbosa", "gabigol@flamengo.com", "0011122233344", TipoCliente.PESSOAFISCIA);
			cli2.getTelefones().addAll(Arrays.asList("021981818181", "011988881122"));
			Endereco e3 = new Endereco(null, "Rua da Gavea", "1100", "Casa 500", "Barra", "51120999", cli2, c2);
			cli2.getEnderecos().addAll(Arrays.asList(e3));
			clienteRepository.saveAll(Arrays.asList(cli2));
			enderecoRepository.saveAll(Arrays.asList(e3));

			
		}
	

}
