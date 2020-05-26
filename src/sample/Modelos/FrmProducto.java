package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Vistas.ProductosDAO;


public class FrmProducto extends Stage {
    private TableView<ProductosDAO> tbvProductos;
    private ProductosDAO objP;
    private VBox vbox;
    private TextField txtDesc,txtcosto,txtprecio,txtExistencia;
    private ComboBox<String> cbxVigente;
    private ComboBox<ProveedoresDAO> cbxProveedor;
    private Button btnGuardar;
    private Scene escena;


     public FrmProducto(TableView<ProductosDAO> tbvProductos, ProductosDAO obj){

         if (obj != null)
             this.objP = obj;
         else
             objP = new ProductosDAO();


         this.tbvProductos = tbvProductos;
         CrearGUI();
         this.setTitle("Gestion de productos");
         this.setScene(escena);
         this.show();
     }


    private void CrearGUI() {
         vbox = new VBox();
         txtDesc = new TextField();
         txtDesc.setText(objP.getNomProducto());
         txtDesc.setPromptText("Introduce la descripción");
         txtcosto = new TextField();
         txtprecio.setText(objP.getPrecio()+"");
         txtprecio.setPromptText("Introduce el precio");
         txtExistencia = new TextField();
         txtcosto.setText(objP.getCosto()+"");
         txtcosto.setPromptText("Introduce el costo");
         txtprecio = new TextField();
         txtExistencia.setText(objP.getExistencia()+"");
         txtExistencia.setPromptText("Introduce la existencia");

         ObservableList<String> listVigente = FXCollections.observableArrayList();
         listVigente.addAll("Vigente","Descontinuado");
         cbxVigente = new ComboBox();
         String val = (objP.isVigente() == true) ? "Vigente" : "Descontinuado";
         cbxVigente.setItems(listVigente);
         cbxVigente.setValue(val);

         cbxProveedor = new ComboBox();
         cbxProveedor.setItems(new ProveedoresDAO().selAllProveedores());
         ProveedoresDAO objPr = new ProveedoresDAO();
         objPr.setIdProveedor(objP.getIdProveedor());
         objPr.getProvById();
         cbxProveedor.setValue(objPr);

         btnGuardar = new Button("Guardar");
         btnGuardar.setOnAction(event -> { guardarDatos(); });
         vbox.getChildren().addAll(txtDesc,txtcosto,txtprecio,txtExistencia,cbxVigente,cbxProveedor,btnGuardar);
         escena = new Scene(vbox,350,250);
    }

    private void guardarDatos() {
         //objP.setIdProducto(Integer.parseInt(idPro.getText()));
         objP.setNomProducto(txtDesc.getText());
         objP.setCosto(Float.parseFloat(txtcosto.getText()));
         objP.setPrecio(Float.parseFloat(txtprecio.getText()));
         objP.setExistencia(Integer.parseInt(txtExistencia.getText()));


         boolean ban = (cbxVigente.getValue()=="Vigente") ?true : false;
         objP.setVigente(ban);

         ProveedoresDAO objTemp = cbxProveedor.getValue();
         objP.setIdProveedor(objTemp.getIdProveedor());

         if(objP.getIdProveedor() >= 1)
             objP.insProducto();
         else
             objP.updProducto();

         tbvProductos.setItems(objP.selAllProducto());
         tbvProductos.refresh();

         this.close();

    }
}
