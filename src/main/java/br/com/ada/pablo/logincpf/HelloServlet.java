package br.com.ada.pablo.logincpf;

import java.io.*;

import br.com.ada.pablo.model.Pessoa;
import br.com.ada.pablo.utils.MetodosAuxiliares;
import br.com.ada.pablo.utils.ValidaCpf;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/cadastrar")
public class HelloServlet extends HttpServlet {

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
            out.println("<html><body>Cpf não válido</body><html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("txtCpf");
        String cpfFormatado = ValidaCpf.formatarCpf(cpf);
        PrintWriter out = resp.getWriter();
        if (!MetodosAuxiliares.contemCpf(cpfFormatado)) {
            Pessoa pessoa = MetodosAuxiliares.retornaPessoa(cpfFormatado);
            out.println("<html><body>Olá " + pessoa.getNome() + " Portador do CPF " + pessoa.getCpf() + "</body><html>");
        }
        else {
            out.println("<html><body>Cpf não cadastrado</body><html>");
        }
    }

    public void destroy() {
    }
}