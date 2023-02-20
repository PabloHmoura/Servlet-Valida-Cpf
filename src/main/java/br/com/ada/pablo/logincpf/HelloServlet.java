package br.com.ada.pablo.logincpf;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.ada.pablo.utils.ValidaCpf;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/cadastrar")
public class HelloServlet extends HttpServlet {
    private List listaCpf = new ArrayList<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cpfCadastrado = request.getParameter("txtCpf");
        PrintWriter out = response.getWriter();

        boolean validaCpf = ValidaCpf.validarCpf(cpfCadastrado);
        String cpfFormatado = "";
        if (validaCpf) {
            cpfFormatado = ValidaCpf.formatarCpf(cpfCadastrado);
            listaCpf.add(cpfFormatado);
            out.println("<html><body>Cpf " + cpfFormatado + " cadastrado!</body><html>");
        } else {
            out.println("<html><body>Cpf não válido</body><html>");
        }
    }

    public void destroy() {
    }
}