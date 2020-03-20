package com.example.demo.decorate;

import lombok.extern.log4j.Log4j2;

import java.io.*;


/**
* 装饰模式
*/
@Log4j2
public class DecorateService {

    public static void main(String[] args){

        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Soy(beverage);

        log.info(beverage.getDescript());
        log.info(beverage.cost());

        sssk();
    }

    private void sss(){
        byte[] bytes = new byte[100];
        InputStream inputStream = new ByteArrayInputStream(bytes);
        FileInputStream fileInputStream = null;
        FilterInputStream filterInputStream = null;
        BufferedInputStream bufferedInputStream = null;
    }

    private static void sssk(){
        int c;
        try {
            InputStream inputStream = new LowercaseInputStream(new BufferedInputStream(new FileInputStream("src\\main\\java\\com\\example\\demo\\decorate\\test.txt")));

            while ((c = inputStream.read()) != -1){
                log.info((char)c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
