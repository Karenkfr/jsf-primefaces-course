package id;

public class Main {
	
	public static void main(String[] args) {
		
		
		PedidosRepository pedidos = new PedidosRepository();
		
		RelatorioService relatorioService = new RelatorioService(pedidos);
		//relatorioService.setPedidosRepository(pedidos);
	}
	


}
