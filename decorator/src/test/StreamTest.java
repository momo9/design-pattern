package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import stream.UpperInputStream;

public class StreamTest {

    @Test
    public void testStream() throws IOException {
        UpperInputStream uis = new UpperInputStream(System.in);
        InputStreamReader isr = new InputStreamReader(uis);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);            
        }
        br.close();
    }

}
