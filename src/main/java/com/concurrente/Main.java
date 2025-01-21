package com.concurrente;

public class Main {
    public static void main(String[] args) {
        Thread Hilo1 = new Thread(() -> {
            System.out.println("Inicio de Hilo 1");
            try{
                Thread.sleep(5000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Fin de Hilo 1");
        });
        Thread Hilo2 = new Thread(() -> {
            System.out.println("Inicio de Hilo 2: esperando a Hilo 1");
            while(Hilo1.isAlive()){
                System.out.println("Hilo 2 en ejecucion al mismo tiempo que Hilo 1");
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Fin de Hilo 2 tras terminar Hilo 1");
        });
        Hilo1.start();
        Hilo2.start();
        try{
            Hilo1.join();
            Hilo2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}