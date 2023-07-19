/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import model.UsuarioDbUtil;
import model.Medida;
import model.MedidaDbUtil;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 *
 * @author rlgar
 */
@WebServlet(name = "IMC", urlPatterns = {"/IMC"})
public class IMC extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String sel = request.getParameter("sel");
            if (sel.equals("Login"))
            {                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginPage.jsp");
                dispatcher.forward(request, response);
            }
            else if (sel.equals("Valida Login"))
            {
            
                String SUsuario = request.getParameter("Usuario");
                String SPassword = request.getParameter("Password");
                int resultado;
                resultado = model.UsuarioDbUtil.ValidaUsuario(SUsuario, SPassword);
                if (resultado == 2) {
                   model.Usuario U = model.UsuarioDbUtil.GetUser(SUsuario);
                   /*request.setAttribute("IdUsuario", U.getIdUsuario());
                   request.setAttribute("NombreCompleto", U.getNombreCompleto() );
                   request.setAttribute("NombreUsuario", U.getNombreUsuario());
                   request.setAttribute("Edad", U.getEdad());
                   request.setAttribute("Sexo", U.getSexo());
                   request.setAttribute("Estatura", U.getEstatura());   */
                   
                   HttpSession sesion = request.getSession(false);
                   
                   sesion.setAttribute("IdUsuario", U.getIdUsuario());
                   sesion.setAttribute("NombreCompleto", U.getNombreCompleto());
                   sesion.setAttribute("NombreUsuario", U.getNombreUsuario());
                   sesion.setAttribute("Edad", U.getEdad());
                   sesion.setAttribute("Sexo", U.getSexo());
                   sesion.setAttribute("Estatura", U.getEstatura());
                                      
                   
                   RequestDispatcher dispatcher = request.getRequestDispatcher("/calcIMC.jsp");
                   dispatcher.forward(request, response);
                } 
                else {                
                    String Smensaje;
                    Smensaje = model.UsuarioDbUtil.GetMessage(resultado);
                    request.setAttribute("mensaje", Smensaje );
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginPage.jsp");
                    dispatcher.forward(request, response);
                }                
            } else if (sel.equals("Calcula IMC")) 
              {
                String peso = request.getParameter("Peso");
                String sValidacion = "";                
                
                model.Medida m = new model.Medida( Integer.valueOf(peso));
                sValidacion = m.ValidaPeso();
                if (sValidacion.equals("")) {
                    
                    HttpSession sesion = request.getSession(false);
                    Enumeration e = sesion.getAttributeNames();
                    
                    String IdUsuario="";
                    String NombreCompleto="";
                    String NombreUsuario="";
                    String Edad="";
                    String Sexo="";
                    String Estatura="";                    
                    
                    if(e.hasMoreElements())
                    {
                        IdUsuario = String.valueOf(sesion.getAttribute("IdUsuario"));
                        NombreCompleto = String.valueOf(sesion.getAttribute("NombreCompleto"));
                        NombreUsuario = String.valueOf(sesion.getAttribute("NombreUsuario"));
                        Edad = String.valueOf(sesion.getAttribute("Edad"));
                        Sexo = String.valueOf(sesion.getAttribute("Sexo"));
                        Estatura = String.valueOf(sesion.getAttribute("Estatura"));                        
                    }
                    
                    model.Usuario U = new model.Usuario(Integer.valueOf(IdUsuario),
                                                        NombreCompleto,
                                                        "",
                                                        NombreUsuario,
                                                        Integer.valueOf(Edad),
                                                        Sexo,
                                                        Integer.valueOf(Estatura));
                    float IMC = U.CalcIMC(Integer.valueOf(peso));                    
                    request.setAttribute("IMC", IMC );
                    
                    MedidaDbUtil.InsertMedida(U,Integer.valueOf(peso));
                    
                    List<model.Medida> MedidaItems = null;
                    try {
                         MedidaItems = MedidaDbUtil.getMedidas(IdUsuario);                    
                    }catch (ClassNotFoundException | SQLException j) {
                        j.printStackTrace();                }
                    request.setAttribute("medidas", MedidaItems);                
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/VisualizarHistorico.jsp");
                    dispatcher.forward(request, response);
                                        
                } else 
                {
                    request.setAttribute("mensaje", sValidacion );
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/calcIMC.jsp");
                    dispatcher.forward(request, response);                    
                }
              } else if (sel.equals("SalvarUsuario")) 
                {
                  String SNombreCompleto = request.getParameter("Nombre");  
                  String SUsuario = request.getParameter("Usuario");
                  String SPassword = request.getParameter("Password");
                  String SEdad = request.getParameter("Edad");
                  String SSexo = request.getParameter("Sexo");
                  String SEstatura = request.getParameter("Estatura");
                  
                  String sValidacion;
                  sValidacion = model.Usuario.ValidaDatosUsuario(Integer.valueOf(SEdad),Integer.valueOf(SEstatura), SUsuario, SPassword);
                  
                  if (sValidacion.equals("")) {
                      
                      model.Usuario U = new model.Usuario(0,
                                                        SNombreCompleto,
                                                        SUsuario,
                                                        SPassword,
                                                        Integer.valueOf(SEdad),
                                                        SSexo,
                                                        Integer.valueOf(SEstatura));
                      
                      int idUsuario = UsuarioDbUtil.InsertUsuario(U);
                      U.setIdUsuario(idUsuario);
                      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                      dispatcher.forward(request, response);                      
                  } else {
                      request.setAttribute("mensaje", sValidacion );
                      RequestDispatcher dispatcher = request.getRequestDispatcher("/WPUsuario.jsp");
                      dispatcher.forward(request, response);                      
                  }                  
                } else if (sel.equals("AltaUsuario")) 
                    {
                      RequestDispatcher dispatcher = request.getRequestDispatcher("/WPUsuario.jsp");
                      dispatcher.forward(request, response);                      
                    }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
