/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

/**
 *
 * @author david
 */
@WebServlet("/Contador")
public class ContadorServlet  extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //declaramos la variable contador
        int contador = 0;
        //Revisamos sia existe  la cookie contadorvisiras
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                    
                }
            }
        }
        //incrementamos el contador uno por uno 
        contador++;
        //agregaremos la respuesta al navegador 
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        //la cokie se almacena en el cliente por 1 hr (3600 seg)
        c.setMaxAge(3600);
        response.addCookie(c);
        //mandamos mensaje al navegador
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas de cada cliente:"+contador);
        
    }
}
