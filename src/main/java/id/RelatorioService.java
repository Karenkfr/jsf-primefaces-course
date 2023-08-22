package id;

import java.math.BigDecimal;

import javax.inject.Inject;

public class RelatorioService {
	
	@Inject
	private PedidosRepository pedidosRepository;
	
	public RelatorioService() {
		
	}
	
	public RelatorioService(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}


	public BigDecimal totalPedidosMesAtual() {
		return pedidosRepository.totalPedidosMesAtual();
	}
	
	public void setPedidosRepository(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}

}
