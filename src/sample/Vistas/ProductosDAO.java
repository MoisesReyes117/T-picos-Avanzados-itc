package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Modelos.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductosDAO {

    private int idProducto;
    private int existencia;
    private  String nomProducto;
    private float costo,precio;
    private boolean vigente;
    private int idProveedor;

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public void setIdProducto() { }
    public int getExistencia() { return existencia; }
    public void setExistencia(int existencia) { this.existencia = existencia; }
    public String getNomProducto() { return nomProducto; }
    public void setNomProducto(String nomProducto) { this.nomProducto = nomProducto; }
    public float getCosto() { return costo; }
    public void setCosto(float costo) { this.costo = costo; }
    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }
    public boolean isVigente() { return vigente; }
    public void setVigente(boolean vigente) { this.vigente = vigente; }
    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    private Connection con;
    public ProductosDAO(){
        con = Conexion.con;
    }

    public void insProducto(){
        //insert into tbl_Proveedores(nombreProveedor,dirProveedor,telProveedor,mailProveedor) values('Ruben','mi casa','cel','ruben@gmail.com');
        String query = "insert into tbl_Productos(nomProducto,costo,precio,existencia,vigente,idProveedor) " +
                "values('"+nomProducto+"',"+costo+","+precio+","+existencia+","+vigente+","+idProveedor+")";
        try {
            Statement  stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updProducto(){
        String query = "update tbl_Productos set nomProducto='"+nomProducto+"'" +
                ",costo="+costo+",precio="+precio+",existencia="+existencia+"," +
                "vigente="+vigente+",idProveedor="+idProveedor+" where "+
                "idProducto="+idProducto;
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Error en la actualización");
        }
    }
    public void delProducto(){
        String query = "delete from tbl_Productos where idProducto="+idProducto;
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList <ProductosDAO> selALLProducto(){
        ObservableList<ProductosDAO> listaP = FXCollections.observableArrayList();
        ProductosDAO objP = null;
        String query = "select * from tbl_Productos order by nomProducto";
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objP = new ProductosDAO();
                objP.setIdProducto(res.getInt("idProducto"));
                objP.setNomProducto(res.getString("nomProducto"));
                objP.setCosto(res.getFloat("costo"));
                objP.setPrecio(res.getFloat("precio"));
                objP.setExistencia(res.getInt("existencia"));
                objP.setVigente(res.getBoolean("vigente"));
                objP.setIdProveedor(res.getInt("idProveedor"));
                listaP.add(objP);
            }
        }catch (Exception e){

        }
        return listaP;
    }
    public void selByIdProducto(){
        String query = "";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){}
    }
}
