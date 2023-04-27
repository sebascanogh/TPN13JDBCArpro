package paquetejdbc;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ConxDataBase {
	public static void main(String[] args) {
		try {
			//registrar el driver
			Class.forName ("com.mysql.jdbc.Driver");
			
			//creamos la conexion				
			
			Connection cX = DriverManager.getConnection("jdbc:mysql://localhost:3306/comprasuper","root","");
			
			//creamos la consulta
			Statement cSQL = cX.createStatement();
			
			//String consulta1= "insert into productos values (idP,'cafe', 'frasco de 500grs', 450, now())";
			//String consulta1 = "update productos set nomP = 'Rollo de cocina', descP = '120 paños' where idP = 12";
			//cSQL.executeUpdate(consulta1);
			
			String consulta = "select * from productos ";
			
			//where precioP <150
			//order by nomP asc
			ResultSet mostrarCon = cSQL.executeQuery(consulta);
			
				System.out.println("CODIGO\tPRECIO\tNOMBRE\tDESCRIPCION");
				while(mostrarCon.next()) {
					System.out.println(mostrarCon.getInt(1)+"\t"+mostrarCon.getDouble(4)+"\t"+mostrarCon.getString(2)+"\t"
							+mostrarCon.getString(3));
					
				}
			
							
		} catch (Exception e) {							
		
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
	}

}
