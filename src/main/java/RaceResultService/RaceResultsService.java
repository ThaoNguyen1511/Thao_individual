package RaceResultService;

import java.util.ArrayList;
import java.util.Collection;

public class RaceResultsService {
    private Collection<Client> clients = new ArrayList<Client>();
    public void addSubscriber(Client client) {
        clients.add(client);
    }
    public void send(Message message) {
        for(Client c : clients){
            c.receive(message);
        }
    }
}
