/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaction;

import graphic.StageJeu;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Grille;
import model.Position;

/**
 *
 * @author Maxime
 */
public class ClientGraphique extends UnicastRemoteObject implements ClientInterface, Serializable {

    public static StageJeu stagejeu = null;

    /**
     * Nom du client.
     */
    private String name;
    
    /**
     * Grille du client.
     */
    public static Grille grille;


    /**
     * Créer un client à partir de son nom.
     *
     * @param name Nom du client
     * @param grille Grille du client
     * @throws RemoteException
     */
    public ClientGraphique(String name, Grille grille) throws RemoteException{
        this.name = name;
        ClientGraphique.grille = grille;
    }
    
    @Override
    public void afficherResultat(boolean touche) throws RemoteException {
        stagejeu.tracer(touche);
    }

    @Override
    public void recevoirMessage(String message) throws RemoteException {
        if (stagejeu != null) {
            stagejeu.ajouteTextToChat(message);
        }
    }

    @Override
    public void jouer() throws RemoteException {
        stagejeu.enAttente = false;
        this.recevoirMessage("A toi de jouer ! \n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    @Override
    public boolean modeGraphique() throws RemoteException {
        return true;
    }
    
}
