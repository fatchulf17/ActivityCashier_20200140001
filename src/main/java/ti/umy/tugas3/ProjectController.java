/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ti.umy.tugas3;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lenovo
 */

@Controller
public class ProjectController {
    ProsesHitung ph = new ProsesHitung();
    
    @RequestMapping ("/Hitung")
    public String prosesInputan (HttpServletRequest data, Model get)
    {
        String namaSayur = data.getParameter("namaSayur");
        String Harga = data.getParameter("hargaperkilo");
        String Qty = data.getParameter("jumlahbeli");
        String Bayar = data.getParameter("uangbayar");
        Double uangBayar = Double.valueOf(Bayar);
        Double hargaSayur = Double.valueOf(Harga);
        Double jumlahBeli = Double.valueOf(Qty);
        
        ph.bayar(hargaSayur, jumlahBeli, uangBayar, get);
        
        get.addAttribute("sayur", namaSayur);
        get.addAttribute("harga", Harga);
        get.addAttribute("qty", Qty);
        get.addAttribute("bayar", Bayar);
        get.addAttribute("hargaawal", ph.jumlahBayar);  
        get.addAttribute("disc", ph.disk);
        get.addAttribute("discount", ph.hargadiskon);
        get.addAttribute("total", ph.totalBayar);
        
        return "Tampil"; 
    }
}