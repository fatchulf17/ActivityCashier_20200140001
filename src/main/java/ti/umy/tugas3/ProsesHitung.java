/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ti.umy.tugas3;

import org.springframework.ui.Model;

/**
 *
 * @author lenovo
 */
public class ProsesHitung {
    Double totalBayar, jumlahBayar, hargadiskon;
    public int disk;
    public String bayar (Double hargaBuah, Double Qty, Double uangBayar, Model get)
    {
        jumlahBayar = hargaBuah * Qty;
        
        if (jumlahBayar < 16000)
        {
            disk = 0;
        }
        else if (jumlahBayar >= 16000 && jumlahBayar < 25000)
        {
           disk = 10;
        }
        else if (jumlahBayar >= 25000)
        {
            disk = 15;
        }
       
        hargadiskon = jumlahBayar * disk /100;
        totalBayar = jumlahBayar - hargadiskon;
        
        String keterangan = "";
        Double kembali =  uangBayar - totalBayar;
        Double kurang = totalBayar - uangBayar;
        
        if (totalBayar < uangBayar)
        {
            keterangan = "Kembalian anda Rp. " + kembali;
        }
        
        else if (totalBayar > uangBayar)
        {
            
            keterangan = "Uang anda kurang Rp. " + kurang;
        }
        
        else
        {
            keterangan = "Uang anda pas";
        }
        
        get.addAttribute("ket", keterangan);
        
        return keterangan;
    }
}