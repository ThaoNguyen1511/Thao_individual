import RaceResultService.Client;
import RaceResultService.Message;
import RaceResultService.RaceResultsService;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class RaceResultServiceTest {
        @Test
        public void subscribedClientShouldReceiveMessage() {
            RaceResultsService raceResults = new RaceResultsService();
            Client client = mock(Client.class);
            Message message = mock(Message.class);

            raceResults.addSubscriber(client);
            raceResults.send(message);
            verify(client).receive(message);
        }
    }
