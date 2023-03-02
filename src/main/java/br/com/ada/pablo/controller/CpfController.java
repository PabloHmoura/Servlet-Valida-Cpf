package br.com.ada.pablo.controller;

import java.io.*;

import br.com.ada.pablo.model.Pessoa;
import br.com.ada.pablo.utils.MetodosAuxiliares;
import br.com.ada.pablo.utils.ValidaCpf;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/cadastrar")
public class CpfController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nomeCadastrado = request.getParameter("txtNome");
        String cpfCadastrado = request.getParameter("txtCpf");
        PrintWriter out = response.getWriter();

        String cpfFormatado = "";
        if (ValidaCpf.validarCpf(cpfCadastrado)) {
            cpfFormatado = ValidaCpf.formatarCpf(cpfCadastrado);
            Pessoa pessoa = new Pessoa(nomeCadastrado, cpfFormatado);
            MetodosAuxiliares.adicionarCpf(pessoa);

            request.setAttribute("nome", pessoa.getNome());
            request.setAttribute("cpf", pessoa.getCpf());
            request.getRequestDispatcher("/pessoaCadastrada.jsp").forward(request, response);
        } else {
            out.println("<html><body>Cpf inválido</body><html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("txtCpf");
        String cpfFormatado = ValidaCpf.formatarCpf(cpf);
        PrintWriter out = resp.getWriter();
        if (MetodosAuxiliares.contemCpf(cpfFormatado)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/telaUsuario.jsp");
            dispatcher.forward(req,resp);
        } else {
            out.println("<html><body>Cpf não cadastrado</body><html>");
        }
    }
}