package br.com.ada.pablo.logincpf;

import java.io.*;

import br.com.ada.pablo.utils.MetodosAuxiliares;
import br.com.ada.pablo.utils.ValidaCpf;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/cadastrar")
public class HelloServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cpfCadastrado = request.getParameter("txtCpf");
        PrintWriter out = response.getWriter();

        boolean validaCpf = ValidaCpf.validarCpf(cpfCadastrado);
        String cpfFormatado = "";
        if (validaCpf) {
            cpfFormatado = ValidaCpf.formatarCpf(cpfCadastrado);
            MetodosAuxiliares.adicionarCpf(cpfCadastrado);
            out.println("<html><body>Cpf " + cpfFormatado + " cadastrado!</body><html>");
        } else {
            out.println("<html><body>Cpf não válido</body><html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = String.valueOf(req.getParameter("txtCpf"));
        PrintWriter out = resp.getWriter();
        if (MetodosAuxiliares.contemCpf(cpf)) {
            String cpfFormatado = ValidaCpf.formatarCpf(cpf);
            out.println("<html><body>Olá Cpf " + cpfFormatado + "</body><html>");
        }
        else {
            out.println("<html><body>Cpf não cadastrado</body><html>");
        }
    }

    public void destroy() {
    }
}