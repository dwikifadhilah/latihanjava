package org.example;

import org.junit.Assert;
import org.junit.Test;

public class KalkulatorTest {
    @Test
    public void hasilPerkalianKalkulator(){
        Kalkulator kalkulator = new Kalkulator(10,2);
        Assert.assertEquals(20,kalkulator.getHasilPerkalian());
    }

    @Test
    public void hasilPembagianKalkulator(){
        Kalkulator kalkulator = new Kalkulator(10, 2);
        Assert.assertEquals(5,kalkulator.getHasilPembagian());
    }

    @Test
    public void hasilPenjumlahanKalkulator(){
        Kalkulator kalkulator = new Kalkulator(10, 2);
        Assert.assertEquals(12,kalkulator.getHasilPenjumlahan());
    }

    @Test
    public void hasilPenguranganKalkulator(){
        Kalkulator kalkulator = new Kalkulator(10, 2);
        Assert.assertEquals(8,kalkulator.getHasilPengurangan());
    }
}
