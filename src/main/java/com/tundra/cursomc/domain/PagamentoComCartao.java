package com.tundra.cursomc.domain;

import javax.persistence.Entity;

import com.tundra.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao()
	{
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParccelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParccelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	

}
