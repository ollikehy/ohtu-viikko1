/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

/**
 *
 * @author keolli
 */
public interface Store {

    void aloitaAsiointi();

    boolean tilimaksu(String nimi, String tiliNumero);
    
}
