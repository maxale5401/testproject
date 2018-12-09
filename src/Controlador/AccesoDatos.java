package Controlador;
import Modelo.Peliculas;
import java.sql.*;
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
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("error al conectar con la BD");
        }
        
    }
    
    //metodo para la desconexion 
    private void desconexion(){
        try{
            con.close();
        }catch(SQLException e){
            System.err.println("error en la desconexion con la BD");
        }catch(Exception e){
            
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
            String sql = "select * from peliculas where cod_pel='"+cod+"'";
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
    public boolean modificarPelicula(Peliculas p){
        try{
            conexion();
            st = con.createStatement();
            String sql = "update peliculas set nom_pel='"+p.getNombre()+"', gen_pel='"+p.getGenero()+"', cla_pel='"+p.getClasificacion()+"', fec_pel='"+p.getFecha()+"' where cod_pel = '"+p.getCodigo()+"' ";
            st.execute(sql);
            st.close();
            desconexion();
            return true;
        }catch(SQLException e){
            System.err.println("sql");
            return false;
        }
    }
    
    
    //lista las peliculas :v
    public ArrayList<Peliculas> listarPelicula(){
        try{
            conexion();
            String sql = "select * from peliculas;";
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
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }    
    
    public ArrayList<Peliculas> filtraracc(){//metodo para filtrar las peliculas de accion
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Accion';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrarave(){//metodo para filtrar las peliculas de aventura
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Aventura';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrarani(){//metodo para filtrar las peliculas de animacion
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Animacion';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrarcom(){//metodo para filtrar las peliculas de comedia
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Comedia';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrardoc(){//metodo para filtrar las peliculas de documental
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Documental';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrardram(){//metodo para filtrar las peliculas de drama
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Drama';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrarrom(){//metodo para filtrar las peliculas de romance
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Romance';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrarsci(){//metodo para filtrar las peliculas de Sci-fy
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Sci-fy';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrarter(){//metodo para filtrar las peliculas de terror
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where gen_pel = 'Terror';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrartod(){//metodo para filtrar las peliculas para todo publico
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where cla_pel = 'Todo espectador';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtrarado(){//metodo para filtrar las peliculas para mayores de 15
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where cla_pel = 'R+15';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
    public ArrayList<Peliculas> filtraradu(){//metodo para filtrar las peliculas para mayores de edad
        try{
            conexion();
            st=con.createStatement();
            String sql="select * from peliculas where cla_pel = 'R+18';";
            ArrayList<Peliculas> lispel = new ArrayList<Peliculas>();
            rs=st.executeQuery(sql);
            while(rs.next()){
                String cod = rs.getString("cod_pel");
                String nom = rs.getString("nom_pel");
                String gen = rs.getString("gen_pel");
                String cla = rs.getString("cla_pel");
                int fec =  rs.getInt("fec_pel");
                Peliculas p = new Peliculas(cod,nom,gen,cla,fec);
                lispel.add(p);
            }
            desconexion();
            return lispel;
        }catch(SQLException e1){
            desconexion();
            return null;
        }catch(Exception e2){
            desconexion();
            return null;
        }
    }
    
}
