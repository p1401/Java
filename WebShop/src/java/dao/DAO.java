/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Account;
import models.Cart;
import models.Category;
import models.Order;
import models.Product;
import models.Users;

/**
 *
 * @author duyph
 */
public class DAO {

    private Connection connection;

    public DAO(DBContext db) {
        try {
            connection = db.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Account getAccountByUsername(String username) {
        try {
            String sql = "SELECT * "
                    + "  FROM [dbo].[HE141503_Account]\n"
                    + "WHERE [username] = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int checkUserAccount(String username, String password) {
        Account acc = getAccountByUsername(username);
        if (acc == null) {
            return 0; //Account is not available
        } else if (!acc.getPass().equals(password)) {
            return 1; //Wrong password
        } else {
            return 2; //Account available
        }
    }

    public void signUpAccount(String username, String password, String email, String phone) {
        try {
            String sql = "INSERT INTO [dbo].[HE141503_User]\n"
                    + "           ([username]\n"
                    + "           ,[password]\n"
                    + "           ,[email]\n"
                    + "           ,[phone])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void UpdateMethod(Users us, String oldusername) {
        try {
            String sql = "UPDATE [dbo].[HE141503_User]\n"
                    + "   SET [username] = ?\n"
                    + "      ,[password] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[phone] = ?\n"
                    + " WHERE [username] = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, us.getUsername());
            statement.setString(2, us.getPassword());
            statement.setString(3, us.getEmail());
            statement.setString(4, us.getPhone());
            statement.setString(5, oldusername);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addToContact(String username, String email, String phone, String contents) {
        try {
            String sql = "INSERT INTO [dbo].[HE141503_Contact]\n"
                    + "           ([name]\n"
                    + "           ,[email]\n"
                    + "           ,[phone]\n"
                    + "           ,[contents])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, contents);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addtoProduct(int id, String name, int price, String image) throws SQLException {
        String sql = "INSERT INTO [dbo].[HE141503_Product]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[price]\n"
                + "           ,[image])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        JOptionPane.showMessageDialog(null, id + " " + name + " " + price + " " + image);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, price);
        ps.setString(4, image);
        ps.executeUpdate();
    }

    public Product getProductByID(int pid) {
        try {
            String sql = "select * from HE141503_Product p where p.ProductID = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setProductPrice(rs.getInt("ProductPrice"));
                p.setProductImage(rs.getString("ProductImage"));
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getListProduct(int pageIndex) throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
            String query = "select * from("
                    + "select ROW_NUMBER() over (order by ProductID ASC) as rn, *\n"
                    + "from Product"
                    + ")as x\n"
                    + "where rn between (?-1)*?+1"
                    + "and ?*?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, pageIndex);
            ps.setInt(2, 6);
            ps.setInt(3, pageIndex);
            ps.setInt(4, 6);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setProductPrice(rs.getInt("ProductPrice"));
                p.setProductImage(rs.getString("ProductImage"));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from HE141503_Product";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("ProductID"), rs.getString("ProductName"),
                        rs.getInt("ProductPrice"), rs.getString("ProductImage"));
                list.add(p);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void UpdateProduct(Product p, int oldid) {
        try {
            String sql = "UPDATE [dbo].[HE141503_Product]\n"
                    + "   SET [ProductID] = ?\n"
                    + "      ,[ProductName] = ?\n"
                    + "      ,[ProductPrice] = ?\n"
                    + "      ,[ProductImage] = ?\n"
                    + " WHERE [ProductID] = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, p.getProductID());
            statement.setString(2, p.getProductName());
            statement.setInt(3, p.getProductPrice());
            statement.setString(4, p.getProductImage());
            statement.setInt(5, oldid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteByProductID(int id) {
        try {
            deleteOrderbyproductID(id);

            String sql = "DELETE FROM [dbo].[HE141503_Product] WHERE ProductID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getLastOrderID() {
        int orderID = 0;
        try {
            String sql = "select top(1) OrderID from [HE141503_Order] order by OrderID desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderID;
    }

    public List<Order> getAllProductByUser(String username) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "select p.ProductImage, p.ProductName, p.ProductPrice, o.OrderQuantity,o.OrderTotalPrice\n"
                    + "from [HE141503_Order] o, HE141503_Product p, [HE141503_User] u \n"
                    + "where o.ProductID = p.ProductID and o.username = u.username and u.username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                int orderID = getLastOrderID();
                o.setOrderID(orderID + 1);
                o.setProductImage(rs.getString(1));
                o.setProductName(rs.getString(2));
                o.setProductPrice(rs.getInt(3));
                o.setQuantity(rs.getInt(4));
                o.setTotalPrice(rs.getInt(3) * rs.getInt(4));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Order> getHistory(String username) {
        List<Order> list = new ArrayList();
        try {
            String sql = "select o.OrderID, p.ProductName, p.ProductPrice,o.OrderQuantity, o.OrderTotalPrice\n"
                    + "  from HE141503_Product p, [HE141503_Order] o\n"
                    + "  where p.ProductID = o.productid and o.username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public void Buy(int orderID, int quantity, int total, int pID, String username) {
        try {
            String sql = "insert into [HE141503_Order] "
                    + "(OrderID, OrderQuantity, OrderTotalPrice, ProductID, username) "
                    + "values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, quantity);
            ps.setInt(3, total);
            ps.setInt(4, pID);
            ps.setString(5, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getCount() throws SQLException {
        int count = 0;
        try {
            String query = "select count(*) from HE141503_Product";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;

    }

    public List<Users> getAllUser() {
        List<Users> list = new ArrayList<>();
        try {
            String sql = "select username from [dbo].[HE141503_User] where username not like 'admin'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users u = new Users();
                u.setUsername(rs.getString("username"));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteOrderbyusername(String username) throws SQLException {
        String sql1 = "delete from [dbo].[HE141503_Order] where username = ?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setString(1, username);
        ps1.execute();

    }

    public void deleteOrderbyproductID(int ID) throws SQLException {
        String sql1 = "delete from [dbo].[HE141503_Order] where ProductID = ?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setInt(1, 1);
        ps1.execute();

    }

    public void deleteByUsername(String username) {
        try {
            deleteOrderbyusername(username);
            String sql = "delete from [dbo].[HE141503_User] where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public int checkProduct(int id) {
        Product acc = getProductByID(id);
        if (acc == null) {
            return 0; //Product is not available
        } else {
            return 1; //Wrong password
        }
    }

    public void editProduct(int productID, String Productname, int ProductPrice, String Productimgae) {
        try {

            String sql = "UPDATE HE141503_Product\n"
                    + "   SET [ProductName] = ?\n"
                    + "      ,[ProductPrice] = ?\n"
                    + "      ,[ProductImage] = ?\n"
                    + " WHERE ProductID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Productname);
            ps.setInt(2, ProductPrice);
            ps.setString(3, Productimgae);
            ps.setInt(4, productID);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public void addProduct(int id, String name, int price, String image) {
        String sql = "INSERT INTO [dbo].[HE141503_Product]\n"
                + "           ([ProductID]\n"
                + "           ,[ProductName]\n"
                + "           ,[ProductPrice]\n"
                + "           ,[ProductImage])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, price);
            ps.setString(4, image);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteByorderID(String ProductID) {
        try {
            String sql = "DELETE FROM HE141503_Product /n"
                    + "Where ProductID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ProductID);
            ps.executeQuery();
        } catch (Exception e) {

        }
    }
    
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try {
            String query = "select * from Category";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Product> getAllProductByCategoryID(String cid) {
        List<Product> list = new ArrayList<>();
        try {
            String query = "select * from Products\n" +
                          "where CategoryID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
   /* private HashMap<Integer, Product> hmProduct;
    private HashMap<Integer, Category> hmCategory;
    private List<String> list;
    private List<Integer> list2;
    private List<Product> list3;
    private List<Cart> list4;
    private List<Account> listAccount;
    private List<Users> listUser;

    public HashMap<Integer, Product> getHmProduct() {
        return hmProduct;
    }

    public void setHmProduct(HashMap<Integer, Product> hmProduct) {
        this.hmProduct = hmProduct;
    }
    
    public HashMap<Integer, Product> getProductList(String sql){
        hmProduct=new HashMap<Integer, Product>();
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p = new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getInt(8)
                );
                hmProduct.put(rs.getInt(1), p);
            }
        }catch(Exception e){
            
        }
        return hmProduct;
    }
    
    public HashMap<Integer, Category> getCategory(String sql){
        hmCategory=new HashMap<Integer, Category>();
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Category ct=new Category(rs.getInt(1), rs.getString(2));
                hmCategory.put(rs.getInt(1), ct);
            }
        }catch(Exception e){
            
        }
        return hmCategory;
    }
    
    public List<String> getListString(String sql){
        list=new ArrayList<String>();
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString(1));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    
    public List<Integer> getListInt(String sql){
        list2=new ArrayList<Integer>();
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list2.add(rs.getInt(1));
            }
        }catch(Exception e){
            
        }
        return list2;
    }
    
    public Product getProductDetail(String sql){
        Product p = null;
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                p=new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3),  
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
            }
        }catch(Exception e){
            
        }
        return p;
    }
    
    public Account login(String user, String pass){
        String sql="Select * from HE141503_Account where account like ? and password like ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getBoolean(4));            
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public Account checkAccount(String user){
        String sql="Select * from HE141503_Account where account like ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, user);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getBoolean(4));            
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public void signUpAccount(String user, String pass){
        String sql="INSERT INTO HE141503_Account values (?,?,0)";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public void signUpUser(String user, String password, String email,String address,String phone){
        String s ="SELECT COUNT(id) from HE141503_Account";
        String accountId = null;
        try{
            PreparedStatement ps= connection.prepareCall(s);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                  accountId=rs.getString(1);
            }
        }catch(Exception e){
            
        }
        String sql="INSERT INTO HE141503_User values ("+accountId+",?,?,?,?,?)";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
    public Users loginUser(String id){
        String sql="Select * from HE141503_User where id like ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Users(rs.getInt(1), rs.getInt(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    
    public int getNumberPage(String sql){
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int total=rs.getInt(1);
                int page=0;
                if(total%6!=0){
                    page=total/6+1;
                }else{
                    page=total/6;
                }
                return page;
            }
        }catch(Exception e){
            
        }
        return 0;
    }
    
    public void deleteProduct(String id){
        String sql2="Delete from HE141503_Cart where productId = ?";
        String sql = "Delete from HE141503_Product where ProductId = ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql2);
            ps.setString(1, id);
            ps.executeUpdate();
            ps= connection.prepareCall(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
    public void deleteAccount(String id){
        String sql2="Delete from HE141503_User where accountId = ?";
        String sql = "Delete from HE141503_Account where id = ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql2);
            ps.setString(1, id);
            ps.executeUpdate();
            ps= connection.prepareCall(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
    public void insertProduct(String name,String image,String price,
            String amount,String description,String title, String cate){
        String sql="INSERT INTO HE141503_Product values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, amount);
            ps.setString(5, description);
            ps.setString(6, title);
            ps.setString(7, cate);           
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateProduct(String name,String image,String price,
            String amount,String description,String title, String cate, String id){
        String sql="Update HE141503_Product set [name] = ? , [image] = ? , [price] = ? ,"
                + "[amount] = ? , [description] = ? , [title] = ? , [catID] = ? "
                + "Where id = ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, amount);
            ps.setString(5, description);
            ps.setString(6, title);
            ps.setString(7, cate);      
            ps.setString(8, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public List<Product> loadCart(String id){
        list3 = new ArrayList<Product>();
        String sql="Select p.id,p.name, p.image, p.price, c.amount , p.description , p.title, p.catID \n" +
"from HE141503_Cart c, HE141503_Product p \n" +
"where c.accountId = ? AND c.productId=p.id";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
                list3.add(p);    
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list3;
    }
    
    public void addCart(String accountId,String productId,String amount){
        String sql="INSERT INTO HE141503_Cart values (?,?,?)";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, accountId);
            ps.setString(2, productId);
            ps.setString(3, amount);        
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Cart checkCart(String accountId,String productId){
        String sql="Select * from HE141503_Cart where accountId like ? AND productId like ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, accountId);
            ps.setString(2, productId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Cart(rs.getInt(1), rs.getInt(2), 
                        rs.getInt(3), rs.getInt(4));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void updateCart(String amount, String id){
        String sql="Update HE141503_Cart set [amount] = ? Where id = ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, amount);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteCart(String accountId, String pid){
        String sql="Delete from HE141503_Cart where productId like ? AND accountId like ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, pid);
            ps.setString(2, accountId);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void addCheckOut(String accountId,String productId, String amount, String firstName, String lastName, String address,
            String phone, String email,String cardType, String cardNumber,Date date,Time time){
        String sql="INSERT INTO HE141503_checkOut values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, accountId);
            ps.setString(2, productId);
            ps.setString(3, amount);
            ps.setString(4, firstName);
            ps.setString(5, lastName);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setString(8, phone);
            ps.setString(9, cardType);
            ps.setString(10, cardNumber); 
            ps.setDate(11, (java.sql.Date) date);
            ps.setTime(12, time);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void placeOrder(Integer amount, String pid, Integer firstAmount){
        String sql="Update HE141503_Product set [amount] = ? Where id = ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setInt(1, firstAmount-amount);
            ps.setString(2, pid);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage()+1);
        }
    }
    
    public List<Cart> takeCart(String accountId){
        list4 = new ArrayList<Cart>();
        String sql = "Select * from HE141503_Cart where accountId=?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, accountId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ 
                Cart c=new Cart(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getInt(3), 
                        rs.getInt(4)
                );
                list4.add(c);    
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list4;
    }
    
    public void updatePass(String id,String pass){
        String sql="Update HE141503_Account set [pass] = ? Where id = ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, pass);
            ps.setString(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateUser(String id,String username,String email,
            String address,String phone){
        String sql="Update HE141503_User set [username] = ? , [email] = ? ,"
                + "[address] = ? , [phone] = ?  Where accountId = ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public List<Account> loadAccount(){
        listAccount = new ArrayList<Account>();
        String sql="Select * from HE141503_Account Where id > 1";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ 
                Account a=new Account(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getBoolean(4)
                );
                listAccount.add(a);    
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listAccount;
    }
    
    public List<Users> loadUser(){
        listUser = new ArrayList<Users>();
        String sql="Select * from HE141503_User Where id > 1";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ 
                Users a=new Users(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                listUser.add(a);    
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listUser;
    }
    
    public void deleteAll(String sql){
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Product getProductCoockie(String sql,String amount){
        Product p = null;
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                p=new Product(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        Integer.parseInt(amount), 
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
            }
        }catch(Exception e){
            
        }
        return p;
    }
    
    public Account getAccount(String id){
        String sql="Select * from HE141503_Account where id like ?";
        try{
            PreparedStatement ps= connection.prepareCall(sql);
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getBoolean(4));            
            }
        }catch(Exception e){
            
        }
        return null;
    }*/
}
