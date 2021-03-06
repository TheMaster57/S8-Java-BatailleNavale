package interaction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Grille;
import model.Position;

public interface ClientInterface extends Remote {

    /**
     * Méthode appelée par le serveur pour envoyer un message au client.
     *
     * @param message message
     * @throws RemoteException
     */
    public void recevoirMessage(String message) throws RemoteException;
    
    public void jouer() throws RemoteException;
    
    public boolean modeGraphique() throws RemoteException;
    
    public abstract void afficherResultat(boolean touche) throws RemoteException;
    
}
