
package interaction;

import exception.NomExistantException;
import exception.PartiePleineException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import model.BoatPosition;
import model.Grille;
import model.Position;


public interface ServeurInterface extends Remote {
    
    public abstract void verifierInscription(String name, BoatPosition position) throws RemoteException, PartiePleineException, NomExistantException;
    public abstract void setClient(String name, Grille grille) throws RemoteException;
    public abstract void sendPosition(Position position) throws RemoteException;
    
}
