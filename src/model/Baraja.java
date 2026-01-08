package model;


import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cleme
 */
public class Baraja {
    
    public ArrayList<Carta> cartas;
    public ArrayList<Carta> barajaBase;
    String [] palos = {"_of_clubs", "_of_diamonds", "_of_hearts", "_of_spades"};
    String [] numeros = {"1","2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    
    public Baraja() {
        cartas = new ArrayList<Carta>();
        barajaBase = new ArrayList<>();

        Carta cartaValor;
        
            for(int p=0; p < palos.length; p++){
                for (int i = 0; i < numeros.length; i++){
                    int valor = i+1;
                    if (valor > 10) {
                        valor = 10;
                    }
                    
                    cartaValor = new Carta ("/Playing Cards/"+ numeros[i] + palos[p] + ".png", valor);
                    barajaBase.add(cartaValor);
                    cartas.add(cartaValor);
                    
                }//For de 13 cartas
}//For de palos
    }//End Baraja
    
    
    
    public Carta SacaCartaAlAzar(){
        Random rnd = new Random();
        int id = rnd.nextInt(cartas.size());
        Carta cartaValor = cartas.get(id);
        cartas.remove(id);
        return cartaValor;
    }//End SacaCarta
    
    public void resetBaraja() {
    cartas.clear();
    cartas.addAll(barajaBase);
    }
    
}
