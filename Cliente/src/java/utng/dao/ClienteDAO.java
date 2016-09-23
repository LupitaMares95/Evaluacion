/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.modelo.Cliente;


 
public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    void borrarCliente(int idCliente);
    void cambiarCliente(Cliente cliente);
    List<Cliente> desplegarCliente();
    Cliente elegirCliente(int idCliente);
 }
