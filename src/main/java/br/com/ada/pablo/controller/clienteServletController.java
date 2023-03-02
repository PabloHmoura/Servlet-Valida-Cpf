package br.com.ada.pablo.controller;

import br.com.ada.pablo.model.Pessoa;
import br.com.ada.pablo.utils.ValidaCpf;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "clienteServlet", value = "/cadastrarCliente")
public class clienteServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Pessoa> listaClientes = (List<Pessoa>) session.getAttribute("lista_clientes");

        request.setAttribute("lista_clientes", listaClientes);
        request.getRequestDispatcher("/telaUsuarioListaCliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeCadastrado = request.getParameter("txtNome");
        String cpfCadastrado = request.getParameter("txtCpf");

        if (ValidaCpf.validarCpf(cpfCadastrado)) {
            String cpfFormatado = ValidaCpf.formatarCpf(cpfCadastrado);
            var listarClientes = listaClientes(request);
            listarClientes.add(new Pessoa(nomeCadastrado, cpfFormatado));
            HttpSession session = request.getSession();
            session.setAttribute("lista_clientes", listarClientes);
            request.setAttribute("lista_clientes", listarClientes);
            request.getRequestDispatcher("/telaUsuarioAlert.jsp").forward(request, response);
        } else {
            throw new RuntimeException("Cliente inválido");
        }
    }

    private List<Pessoa> listaClientes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Pessoa> clientes = (List<Pessoa>) session.getAttribute("historico_cliente");
        if (clientes == null) {
            clientes = new ArrayList<>();
            session.setAttribute("historico_cliente", clientes);
        }
        return clientes;
    }
}
