package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RODRIGO
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           //criação de um atribito que sera ultilisado entre as paginas jsp
           request.setAttribute("msg","Você clicou em listar");
           //aqui vamos redirecionar para a view correta(cliente)
           //Dispatcher = despachar ou enviar
           request.getRequestDispatcher("view_mensagem.jsp").
                   forward(request, response);
       }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //essas linhas configuram  o codico de pagina
        // ou sje, acetus e caracteris especiais
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //vamos criar controle para administra o que está acontecendo
        //Vamos criar uma variavel para recuperar qual a opcao que o usuario escoleu
        //esta opção vira dos formularios (<input type="hidden" name="operacao" value="Inserir" />)
        String operacao = request.getParameter("operacao");
        //criaremos as opçes de operassoes que vamos usar nesta aplicaçaõ
        // Inserir, pesquisar, editar, atualizar, excluir e confirmar exclusão
        //vamos usar o switvh para selecionar a opcao desejada
        //todas as operacoes abaixo são referente ao banco de dados que não temos ainda
       
        switch(operacao){
        case "Inserir":
       System.out.println("Foi clicado em inserir no inserir");
       String ra = request.getParameter("ra");
       String nome = request.getParameter("nome");
       String curso = request.getParameter("curso");
       
       request.setAttribute("mensagem", "voce clicou em inserir");
       request.setAttribute("ra", ra);
       request.setAttribute("nome", nome);
       request.setAttribute("curso", curso);   
            break;
        case "Pesquisar":
             System.out.println("Foi clicado em Pesquisar");
             request.setAttribute("msg","Você clicou em Pesquisar");
        break;
        case "Editar":
             System.out.println("Foi clicado em Editar");
        request.setAttribute("msg","Você clicou em Editar");
        break;
        case "Atualizar":
             System.out.println("Foi clicado em Atualizar");
        request.setAttribute("msg","Você clicou em Atualizar");
        break;
        case "Excluir":
             System.out.println("foi clicado em Excluir");
        request.setAttribute("msg","Você clicou em Excluir");
        break;
        case "confirmar exclusao":
              System.out.println("Foi clicado em confirmar a exclusao");
        request.setAttribute("msg","Você clicou em confirmar a exclusao");
        break;
}   
  
           request.getRequestDispatcher("view_mensagem.jsp").
                   forward(request, response);
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    }
}
