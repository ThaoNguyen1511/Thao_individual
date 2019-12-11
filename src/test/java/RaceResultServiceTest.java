import RaceResultService.Client;
import RaceResultService.Message;
import RaceResultService.RaceResultsService;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class RaceResultServiceTest {
         private RaceResultsService raceResults = new RaceResultsService();
         private Message message = mock(Message.class);
         private Client clientA = mock(Client.class, "clientA");
         private Client clientB = mock(Client.class, "clientB");

    @Test
        public void subscribedClientShouldReceiveMessage() {
            RaceResultsService raceResults = new RaceResultsService();
            raceResults.addSubscriber(clientA);
            raceResults.send(message);
            verify(clientA).receive(message);
        }

    @Test
    public void messageShouldBeSentToAllSubscribedClients() {
            raceResults.addSubscriber(clientA);
            raceResults.addSubscriber(clientB);
            raceResults.send(message);

            verify(clientA).receive(message);
            verify(clientB).receive(message);
    }
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
            raceResults.send(message);
            verify(clientA, never()).receive(message);
            verify(clientB, never()).receive(message);
    }

}
