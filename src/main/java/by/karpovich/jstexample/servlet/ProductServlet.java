package by.karpovich.jstexample.servlet;

import by.karpovich.jstexample.model.Product;
import by.karpovich.jstexample.service.ProductService;
import by.karpovich.jstexample.service.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService service;

    @Override
    public void init() throws ServletException {
        service = new ProductServiceImpl();

    }

    //findAll, findById, delete
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product first = new Product();
        first.setName("Apple");
        first.setPrice(25);
        Product second = new Product();
        second.setName("Banana");
        second.setPrice(5);
        service.save(first);
        System.out.println("First:" + service.findById(first.getId()));
        service.save(second);
        System.out.println("All products: " + service.findAll());
        second.setPrice(50);
        second.setName("Cherry");
        service.save(second);
        System.out.println("All products: " + service.findAll());
        service.delete(first.getId());
        System.out.println("All products: " + service.findAll());
        req.getRequestDispatcher("success.jsp").forward(req,resp);
    }

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var findParam = req.getParameter("find");
//        var deleteParam = req.getParameter("delete");
//        if (isPresent(findParam)){
//            req.setAttribute("product", service.findById(findParam));
//            req.getRequestDispatcher("success.jsp").forward(req, resp);
//        } else if (isPresent(deleteParam)){
//            service.delete(deleteParam);
//            req.setAttribute("products", service.findById(deleteParam));
//            req.getRequestDispatcher("success.jsp").forward(req, resp);
//        }
//    }


    //create, update
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = getProductFromRequest(req);
        service.save(product);
        req.setAttribute("products", service.findAll());
        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }

    private static Product getProductFromRequest(HttpServletRequest req) {
        var id = req.getParameter("id");
        var name = req.getParameter("name");
        var price = req.getParameter("price");
        Product product = new Product();
        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        if (id != null && !id.isEmpty()){
            product.setId(id);
        }
        return product;
    }

    private static boolean isPresent(String id){
         return id != null && id.isEmpty();
    }
}
