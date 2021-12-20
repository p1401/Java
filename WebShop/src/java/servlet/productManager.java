///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package servlet;
//
//import context.DBContext;
//import dao.DAO;
//import models.Category;
//import models.Product;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author duyph
// */
//@WebServlet(name = "ManagerProductControl", urlPatterns = {"/ManagerProductControl"})
//public class productManager extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        DBContext db = new DBContext();
//        DAO dao= new DAO(db);
//        HttpSession ses= request.getSession();
//        String index= request.getParameter("index");
//        if(ses.getAttribute("account")==null){
//            response.sendRedirect("login.jsp");
//        }else{
//            Map<Integer, Product> hmProduct;
//            if(index==null){
//                hmProduct=dao.getProductList("SELECT * FROM HE141488_product ORDER BY id OFFSET 0"
//                    + "ROWS FETCH NEXT 6 ROWS ONLY");
//                request.setAttribute("tagIndex", 1);
//            }else{
//                int indexPage=(Integer.parseInt(index)-1)*6;
//                hmProduct=dao.getProductList("SELECT * FROM HE141488_product ORDER BY id OFFSET "+indexPage
//                    + " ROWS FETCH NEXT 6 ROWS ONLY");
//                request.setAttribute("tagIndex", index);
//                
//            }
//            Map<Integer, Category> hmCategory=dao.getCategory("SELECT * FROM HE141488_category");
//            List<String> listTitle=dao.getListString("Select DISTINCT title FROM HE141488_product Order by title ASC");
//            List<String> listColor=dao.getListString("Select DISTINCT color FROM HE141488_product Order by color ASC");
//            List<Integer> listSize=dao.getListInt("Select DISTINCT size FROM HE141488_product Order by size ASC");
//            int page = dao.getNumberPage("SELECT COUNT(*) FROM HE141488_product");
//            request.setAttribute("product", hmProduct);
//            request.setAttribute("cate", hmCategory);
//            request.setAttribute("listTitle", listTitle);
//            request.setAttribute("listColor", listColor);
//            request.setAttribute("listSize", listSize);
//            request.setAttribute("page", page);
//            request.getRequestDispatcher("managerProduct.jsp").forward(request, response);
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
