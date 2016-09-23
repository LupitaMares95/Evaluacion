
package utng.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.dao.ClienteDAO;
import utng.dao.ClienteDAOImp;
import utng.modelo.Cliente;

/**
 *
 * @author Gerardo González gerardog3229@gmail.com
 */
public class ClienteControlador extends HttpServlet {
    
    private static final String LISTA_CLIENTES = "/listarCliente.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/cliente.jsp";
    private ClienteDAO dao;
    
    public ClienteControlador() {
        dao = new ClienteDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_CLIENTES;
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            dao.borrarCliente(idCliente);
            request.setAttribute("clientes", dao.desplegarCliente());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idUsuario = Integer.parseInt(request.getParameter("idCliente"));
            Cliente cliente = dao.elegirCliente(idUsuario);
            request.setAttribute("cliente", cliente);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_CLIENTES;
            request.setAttribute("clientes", dao.desplegarCliente());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();
        String idCliente = request.getParameter("idCliente");
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setApePat(request.getParameter("apepat"));
        cliente.setApePat(request.getParameter("apemat"));
        cliente.setTelefo(request.getParameter("telefono"));
        cliente.setEdad(Integer.parseInt(request.getParameter("edad")));
        if (idCliente == null || idCliente.isEmpty()) {
            dao.agregarCliente(cliente);
        } else {
            cliente.setIdCliente(Integer.parseInt(idCliente));
            dao.cambiarCliente(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIENTES);
        request.setAttribute("usuarios", dao.desplegarCliente());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
