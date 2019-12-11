package RaceResultService;
import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {
    private Collection<Client> normalClients = new HashSet<Client>();
    private Collection<Client> horseClients = new HashSet<Client>();
    private Collection<Client> f1Clients = new HashSet<Client>();
    private Collection<Client> boatClients = new HashSet<Client>();
    private Log log;

    public void setLog(Log log){
        this.log = log;
    }

    public void addSubscriber(Client client, RaceCategory category) {
        if (category == null) {
            normalClients.add(client);
        } else {
            switch (category) {
                case F1:
                    f1Clients.add(client);
                    break;
                case BOAT:
                    boatClients.add(client);
                    break;
                case HORSE:
                    horseClients.add(client);
                    break;
            }
        }
    }
    public void send(Message message, RaceCategory category) {
        Collection<Client> clients = new HashSet<Client>();
        if (category == null) {
            clients = normalClients;
        } else {
            switch (category) {
                case HORSE:
                    clients = horseClients;
                    break;
                case BOAT:
                    clients = boatClients;
                    break;
                case F1:
                    clients = f1Clients;
                    break;
            }
        }
        log.log(message.getDate(),message.getMessage());
        for (Client client : clients) {
            client.receive(message);
        }
    }

    public void removeSubscriber(Client client, RaceCategory category) {
        if (category == null) {
            normalClients.remove(client);
        } else {
            switch (category) {
                case F1:
                    f1Clients.remove(client);
                    break;
                case BOAT:
                    boatClients.remove(client);
                    break;
                case HORSE:
                    horseClients.remove(client);
                    break;
            }
        }
    }
}
