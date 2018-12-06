package Controlador;
import java.sql.*;
import Modelo.Peliculas;
import java.util.ArrayList;

public class AccesoDatos {
    //declaracion de objetos necesarios
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    //metodo de conexion  a la base de datos
    private void conexion(){
        try{
            String url = "jdbc:mysql://localhost:3306/peliculas?zeroDateTimeBehavior=convertToNull";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
        }catch(Exception e){
            System.err.println("error al conectar con la BD");
        }
        
    }
    
    //metodo para la desconexion 
    private void desconexion(){
        try{
            con.close();
        }catch(Exception e){
            System.err.println("error en la desconexion con la BD");
        }
    }
    
    //registro de peliculas
    public boolean registrarPelicula(Peliculas p){
        try{
            conexion();
            String cod = p.getCodigo();
            String nom = p.getNombre();
            String gen = p.getGenero();
            String cla = p.getClasificacion();
            int fec = p.getFecha();
            st = con.createStatement();
            String sql = "insert into peliculas values ('"+cod+"','"+nom+"','"+gen+"','"+cla+"','"+fec+"')";
            st.execute(sql);
            st.close();
            desconexion();
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    //lista las peliculas :v
    public ArrayList<Peliculas> listarPelicula(){
        try{
            conexion();
            String sql = "select * from peliculas order by fec_pel DESC";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            st = con.createStatement();
            rs =st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec = rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            st.close();
            desconexion();
            return lispel;
        }catch(Exception e){
            return null;
        }
    }
    
    //elimina las peliculas :v
    public boolean eliminarPelicula(String cod){
        try{
            conexion();
            st = con.createStatement();
            String sql = "delete from peliculas where cod_pel='"+cod+"'";
            st.execute(sql);
            st.close();
            desconexion();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    //consulta una pelicula :v
    public Peliculas consultarPelicula(String cod){
        try{
            conexion();
            st = con.createStatement();
            String sql = "select from peliculas where cod_pel='"+cod+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec = rs.getInt("fec_pel");
                Peliculas p = new Peliculas (cod,nom,gen,cla,fec);
                st.close();
                desconexion();
                return p;
            }else{
                st.close();
                desconexion();
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }
    
    //modifica una pelicula
    public Peliculas modificarPelicula(Peliculas p){
        try{
            conexion();
            st = con.createStatement();
            String sql = "update peliculas set nom_pel '"+p.getNombre()+"', gen_pel '"+p.getGenero()+"', cla_pel'"+p.getClasificacion()+"', fec_pel '"+p.getFecha()+"' where cod_pel = '"+p.getCodigo()+"' ";
            rs = st.executeQuery(sql);
            st.close();
            desconexion();
        }catch(Exception e){
            return null;
        }
    }
}
