/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import context.DBContext;
import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Product;

/**
 *
 * @author duyph
 */
@WebServlet(name = "category", urlPatterns = {"/category"})
public class category extends HttpServlet {

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
        DBContext db = new DBContext();
        DAO dao=new DAO(db);
//        HashMap<Integer, Category> hmCategory=dao.getCategory("SELECT * FROM HE141503_Category");
//        List<String> listTitle=dao.getListString("Select DISTINCT title FROM HE141503_Product Order by title ASC");
//        List<String> listColor=dao.getListString("Select DISTINCT color FROM HE141503_Product Order by color ASC");
//        List<Integer> listSize=dao.getListInt("Select DISTINCT size FROM HE141503_Product Order by size ASC");
        HashMap<Integer, Product> hmProduct;
                
        String cate=request.getParameter("cate");
        String title=request.getParameter("title");
        String color=request.getParameter("color");
        String size=request.getParameter("size");
        String price = request.getParameter("price");
        String gender = request.getParameter("gender");
        String index=request.getParameter("index");
        
        String sql="Select * from HE141503_Product Where";
        String sql2="Select count(*) from HE141503_Product Where";
        int count=0;
        if(title!=null){
            if(count!=0) sql+=" and";
            sql+=" title = '"+title+"'";
            sql2+=" title = '"+title+"'";
            count++;
        }
        if(size!=null){
            if(count!=0) sql+=" and";
            sql+=" size = "+size;
            sql2+=" size = "+size;
            count++;
        }
        if(color!=null){
            if(count!=0) sql+=" and";
            sql+=" color = '"+color+"'";
            sql2+=" color = '"+color+"'";
            count++;
        }
        if(cate!=null){
            if(count!=0) sql+=" and";
            sql+=" catID = "+cate;
            sql2+=" catID = "+cate;
            count++;
        }
        if(gender!=null){
            if(count!=0) sql+=" and";
            sql+=" gender = "+gender;
            sql2+=" gender = "+gender;
            count++;
        }
        if(price!=null){
            if(count!=0) sql+=" and";
            if(price.equals("0")){
                sql+=" price >= 0 and price <= 200000";
                sql2+=" price >= 0 and price <= 200000";
            }else if(price.equals("1600")){
                sql+=" price >= 1600000";
                sql2+=" price >= 1600000";
            }else if(price.equals("200")){
                sql+=" price >= 200000 and price <= 400000";
                sql2+=" price >= 200000 and price <= 400000";
            }
            else if(price.equals("400")){
                sql+=" price >= 400000 and price <= 800000";
                sql2+=" price >= 400000 and price <= 800000";
            }
            else if(price.equals("800")){
                sql+=" price >= 800000 and price <= 1600000";
                sql2+=" price >= 800000 and price <= 1600000";
            }
            count++;
        }
        if(index!=null){
            int indexPage=(Integer.parseInt(index)-1)*6;
            if(count==0){
                sql="Select * from HE141503_product ORDER BY id OFFSET "+indexPage+" ROWS FETCH NEXT 6 ROWS ONLY";
                sql2="Select count(*) from HE141503_product";
            }else{
                sql+=" ORDER BY id OFFSET "+indexPage+" ROWS FETCH NEXT 6 ROWS ONLY";
            }
        }else{
            sql+=" ORDER BY id OFFSET 0 ROWS FETCH NEXT 6 ROWS ONLY";
            index="1";
        }
        
//        hmProduct=dao.getProductList(sql);
//        int page=dao.getNumberPage(sql2);
//        request.setAttribute("product", hmProduct);
//        request.setAttribute("listTitle", listTitle);
//        request.setAttribute("listColor", listColor);
//        request.setAttribute("listSize", listSize);
//        request.setAttribute("cate", hmCategory);
//        request.setAttribute("tagCate", cate);
//        request.setAttribute("tagTitle", title);
//        request.setAttribute("tagColor", color);
//        request.setAttribute("tagSize", size);
//        request.setAttribute("tagPrice", price);
//        request.setAttribute("tagGender", gender);
//        request.setAttribute("tagIndex", index);
//        request.setAttribute("page", page);
        request.getRequestDispatcher("productList.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
