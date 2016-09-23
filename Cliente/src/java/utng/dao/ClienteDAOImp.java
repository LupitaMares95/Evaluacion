/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.modelo.Cliente;
import utng.util.utilDB;

/**
 *
 * @author 
 */
public class ClienteDAOImp implements ClienteDAO {
    
    private Connection connection;
    
    public ClienteDAOImp() {
        connection = utilDB.getConnection();
    }

    @Override
    public void agregarCliente(Cliente cliente) {
            try {
            String query = "INSERT INTO clientes (nombre,apepat,apemat,telefono,edad)" + "VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApePat());
            ps.setString(3, cliente.getApeMat());
            ps.setString(4, cliente.getTelefo());
            ps.setInt(5, cliente.getEdad());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public void borrarCliente(int idCliente) {
        
        try {
            String query = "DELETE FROM clientes WHERE "
                    + " id_cliente=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public void cambiarCliente(Cliente cliente) {
 
        try {
            String query = "UPDATE clientes SET nombre= ?"
                    + ", apepat=?"
                    + ", apemat=?"
                    + ", telefono=?"
                    + ", edad=?"
                    + "WHERE id_cliente=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApePat());
            ps.setString(3, cliente.getApeMat());
            ps.setString(4, cliente.getTelefo());
            ps.setInt(4, cliente.getEdad());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Cliente> desplegarCliente() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apepat"),
                        rs.getString("apemat"),
                        rs.getString("telefono"),
                        rs.getInt("edad"));
                clientes.add(cliente);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    
    }

    @Override
    public Cliente elegirCliente(int idCliente) {
      
         Cliente cliente=null;
        try {
            String query = " SELECT * FROM usuarios WHERE id_usuario=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                  cliente = new Cliente(
                        rs.getInt("id_Cliente"),
                        rs.getString("nombre"),
                        rs.getString("apepat"),
                        rs.getString("apemat"),
                          rs.getString("teleono"),
                        rs.getInt("edad"));
             
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    
}//FIN DE LA CLASE
