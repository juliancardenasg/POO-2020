package entities;

public class Aseo extends Producto{
		//---------------------Attributes------------------------
		private String nombreEmpresa;
		private boolean tieneInvima;
		private TipoProducto tipoProducto;
		//---------------------Constructors------------------------
		public Aseo() {}
		public Aseo(long pid, String nombreComercial, double precio, String tienda, String nombreEmpresa,
				boolean tieneInvima, TipoProducto tipoProducto) {
			super(pid, nombreComercial, precio, tienda);
			this.nombreEmpresa = nombreEmpresa;
			this.tieneInvima = tieneInvima;
			this.tipoProducto = tipoProducto;
		}
		//---------------------Accessors------------------------
		public String getNombreEmpresa() {
			return nombreEmpresa;
		}
		public void setNombreEmpresa(String nombreEmpresa) {
			this.nombreEmpresa = nombreEmpresa;
		}
		public boolean isTieneInvima() {
			return tieneInvima;
		}
		public void setTieneInvima(boolean tieneInvima) {
			this.tieneInvima = tieneInvima;
		}
		public TipoProducto getTipoProducto() {
			return tipoProducto;
		}
		public void setTipoProducto(TipoProducto tipoProducto) {
			this.tipoProducto = tipoProducto;
		}
		//---------------------Methods------------------------
		
		@Override
		public double calcularPrecio() {
			double precioAseo = 0;
			precioAseo = super.calcularPrecio();
			if(this.tipoProducto == TipoProducto.HOGAR && this.tipoProducto == TipoProducto.INDUSTRIAL) {
				precioAseo -= .1*(precioAseo);
			}
			else if(this.tipoProducto == TipoProducto.HOSPITALARIO){
				precioAseo -= .3*(precioAseo);
			}
			return precioAseo;
		}
		
		

}
