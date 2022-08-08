package org.example;

import org.junit.Assert;
import org.junit.Test;

public class SegitigaTest {

    @Test //anotasi test, untuk menjalankan test
    public void testLuasSegitiga(){
        Segitiga segitiga = new Segitiga(10, 8);
        double luas = segitiga.getLuas();
        double expected = 40;

        // Verify Element Text
        Assert.assertEquals(expected, luas, 0); //delta itu angka dibelakang koma nya, kalau int gaperlu delta
    }
}
