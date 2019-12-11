import RaceResultService.*;
import org.junit.Test;
import java.time.LocalDate;
import static org.mockito.Mockito.*;

public class RaceResultServiceTest {

    //arrange SUT
    private RaceResultsService raceResults = new RaceResultsService();
    //arrange DOCs
    private Message message = mock(Message.class);
    private Message boatMessage = mock(Message.class);
    private Message f1Message = mock(Message.class);
    private Message horseMessage = mock(Message.class);
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Client horseSubscribedClient = mock(Client.class, "horseSubscribedClient");
    private Client f1SubscribedClient = mock(Client.class, "f1SubscribedClient");
    private Client boatSubscribedClient = mock(Client.class, "boatSubscribedClient");
    private Log logger = mock(Log.class);

    // zero subscribers
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message,null);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }
    // one subscriber
    @Test
    public void subscribedClientWithNoCategoryShouldReceiveMessage() {
        //act
        raceResults.addSubscriber(clientA,null);
        raceResults.send(message,null);

        verify(clientA).receive(message);
    }
    //two subscribers
    @Test
    public void messageShouldBeSentToAllSubscribedClientsWithNoCategory() {
        raceResults.addSubscriber(clientA,null);
        raceResults.addSubscriber(clientB,null);
        raceResults.send(message,null);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
    @Test
    public void shouldSendMessageToMultiSubscriberWithNoCategory() {
        raceResults.addSubscriber(clientA,null);
        raceResults.addSubscriber(clientB,null);
        raceResults.send(message,null);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
    @Test
    public void unsubscribedClientWithNoCategoryShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA,null);
        raceResults.removeSubscriber(clientA,null);
        raceResults.send(message,null);
        verify(clientA, never()).receive(message);
    }

    @Test
    public void clientSubscribedToHorseRaceShouldReceiveHorseRaceMessage(){
        raceResults.addSubscriber(clientA, RaceCategory.HORSE);
        raceResults.send(horseMessage,RaceCategory.HORSE);
        verify(clientA).receive(horseMessage);
    }
    @Test
    public void clientSubscribedToF1RaceShouldReceiveF1RaceMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.F1);
        raceResults.send(f1Message,RaceCategory.F1);
        verify(clientA).receive(f1Message);
    }
    @Test
    public void clientSubscribedToBoatRaceShouldReceiveBoatRaceMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.BOAT);
        raceResults.send(boatMessage,RaceCategory.BOAT);
        verify(clientA).receive(boatMessage);
    }
    @Test
    public void onlyHorseSubscribedClientsShouldReceiveMessage(){
        raceResults.addSubscriber(clientA,null);
        raceResults.addSubscriber(horseSubscribedClient,RaceCategory.HORSE);
        raceResults.addSubscriber(f1SubscribedClient,RaceCategory.F1);
        raceResults.addSubscriber(boatSubscribedClient,RaceCategory.BOAT);
        raceResults.send(message,RaceCategory.HORSE);

        verify(horseSubscribedClient).receive(message);
        verify(clientA,never()).receive(message);
        verify(boatSubscribedClient,never()).receive(message);
        verify(f1SubscribedClient,never()).receive(message);
    }
    @Test
    public void onlyF1SubscribedClientsShouldReceiveMessage(){
        raceResults.addSubscriber(clientA,null);
        raceResults.addSubscriber(horseSubscribedClient,RaceCategory.HORSE);
        raceResults.addSubscriber(f1SubscribedClient,RaceCategory.F1);
        raceResults.addSubscriber(boatSubscribedClient,RaceCategory.BOAT);
        raceResults.send(f1Message,RaceCategory.F1);

        verify(f1SubscribedClient).receive(f1Message);
        verify(clientA,never()).receive(f1Message);
        verify(boatSubscribedClient,never()).receive(f1Message);
        verify(horseSubscribedClient,never()).receive(f1Message);
    }
    @Test
    public void onlyBoatSubscribedClientsShouldReceiveMessage(){
        raceResults.addSubscriber(clientA,null);
        raceResults.addSubscriber(horseSubscribedClient,RaceCategory.HORSE);
        raceResults.addSubscriber(f1SubscribedClient,RaceCategory.F1);
        raceResults.addSubscriber(boatSubscribedClient,RaceCategory.BOAT);
        raceResults.send(boatMessage,RaceCategory.BOAT);

        verify(boatSubscribedClient).receive(boatMessage);
        verify(clientA,never()).receive(boatMessage);
        verify(horseSubscribedClient,never()).receive(boatMessage);
        verify(f1SubscribedClient,never()).receive(boatMessage);
    }

    @Test
    public void multipleHorseSubscribedClientsShouldReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.HORSE);
        raceResults.addSubscriber(clientB,RaceCategory.HORSE);
        raceResults.addSubscriber(horseSubscribedClient,RaceCategory.HORSE);
        raceResults.addSubscriber(f1SubscribedClient,RaceCategory.F1);

        raceResults.send(message,RaceCategory.HORSE);

        verify(f1SubscribedClient,never()).receive(message);
        verify(clientA).receive(message);
        verify(clientB).receive(message);
        verify(horseSubscribedClient).receive(message);
    }

    @Test
    public void multipleF1SubscribedClientsShouldReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.F1);
        raceResults.addSubscriber(clientB,RaceCategory.F1);
        raceResults.addSubscriber(f1SubscribedClient,RaceCategory.F1);
        raceResults.addSubscriber(horseSubscribedClient,RaceCategory.HORSE);

        raceResults.send(message,RaceCategory.F1);

        verify(horseSubscribedClient,never()).receive(message);
        verify(clientB).receive(message);
        verify(clientA).receive(message);
        verify(f1SubscribedClient).receive(message);
    }
    @Test
    public void multipleBoatSubscribedClientsShouldReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.BOAT);
        raceResults.addSubscriber(clientB,RaceCategory.BOAT);
        raceResults.addSubscriber(boatSubscribedClient,RaceCategory.BOAT);
        raceResults.addSubscriber(horseSubscribedClient,RaceCategory.HORSE);

        raceResults.send(message,RaceCategory.BOAT);

        verify(horseSubscribedClient,never()).receive(message);
        verify(clientB).receive(message);
        verify(clientA).receive(message);
        verify(boatSubscribedClient).receive(message);
    }

    @Test
    public void oneClientSubscribedToMultipleCategoriesShouldReceiveAllMessages(){
        raceResults.addSubscriber(clientA,RaceCategory.BOAT);
        raceResults.addSubscriber(clientA,RaceCategory.F1);
        raceResults.addSubscriber(clientA,RaceCategory.HORSE);
        raceResults.addSubscriber(clientA,null);

        raceResults.send(boatMessage,RaceCategory.BOAT);
        raceResults.send(f1Message,RaceCategory.F1);
        raceResults.send(horseMessage,RaceCategory.HORSE);
        raceResults.send(message,null);

        verify(clientA).receive(message);
        verify(clientA).receive(boatMessage);
        verify(clientA).receive(f1Message);
        verify(clientA).receive(horseMessage);
    }

    @Test
    public void anUnsubscribedHorseClientShouldNotReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.HORSE);
        raceResults.addSubscriber(clientB,RaceCategory.HORSE);

        raceResults.removeSubscriber(clientA,RaceCategory.HORSE);

        raceResults.send(message,RaceCategory.HORSE);

        verify(clientB).receive(message);
        verify(clientA,never()).receive(message);
    }

    @Test
    public void MultipleUnsubscribedHorseClientsShouldNotReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.HORSE);
        raceResults.addSubscriber(horseSubscribedClient,RaceCategory.HORSE);
        raceResults.addSubscriber(clientB,RaceCategory.HORSE);

        raceResults.removeSubscriber(clientA,RaceCategory.HORSE);
        raceResults.removeSubscriber(clientB,RaceCategory.HORSE);

        raceResults.send(message,RaceCategory.HORSE);

        verify(horseSubscribedClient).receive(message);
        verify(clientB,never()).receive(message);
        verify(clientA,never()).receive(message);
    }


    @Test
    public void anUnsubscribedF1ClientShouldNotReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.F1);
        raceResults.addSubscriber(clientB,RaceCategory.F1);

        raceResults.removeSubscriber(clientA,RaceCategory.F1);

        raceResults.send(message,RaceCategory.F1);

        verify(clientB).receive(message);
        verify(clientA,never()).receive(message);
    }
    @Test
    public void multipleUnsubscribedF1ClientsShouldNotReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.F1);
        raceResults.addSubscriber(f1SubscribedClient,RaceCategory.F1);
        raceResults.addSubscriber(clientB,RaceCategory.F1);

        raceResults.removeSubscriber(clientA,RaceCategory.F1);
        raceResults.removeSubscriber(clientB,RaceCategory.F1);

        raceResults.send(message,RaceCategory.F1);

        verify(f1SubscribedClient).receive(message);
        verify(clientB,never()).receive(message);
        verify(clientA,never()).receive(message);
    }
    @Test
    public void anUnsubscribedBoatClientShouldNotReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.BOAT);
        raceResults.addSubscriber(clientB,RaceCategory.BOAT);

        raceResults.removeSubscriber(clientA,RaceCategory.BOAT);

        raceResults.send(message,RaceCategory.BOAT);

        verify(clientB).receive(message);
        verify(clientA,never()).receive(message);
    }
    @Test
    public void multipleUnsubscribedBoatClientsShouldNotReceiveMessage(){
        raceResults.addSubscriber(clientA,RaceCategory.BOAT);
        raceResults.addSubscriber(boatSubscribedClient,RaceCategory.BOAT);
        raceResults.addSubscriber(clientB,RaceCategory.BOAT);

        raceResults.removeSubscriber(clientA,RaceCategory.BOAT);
        raceResults.removeSubscriber(clientB,RaceCategory.BOAT);

        raceResults.send(message,RaceCategory.BOAT);

        verify(boatSubscribedClient).receive(message);
        verify(clientB,never()).receive(message);
        verify(clientA,never()).receive(message);
    }
    @Test
    public void aClientShouldNotReceiveMessageWhenMessageIsNotYetSent(){
        raceResults.addSubscriber(clientA,null);

        verify(clientA,never()).receive(message);
    }
    @Test
    public void DateAndMessageShouldBeLoggedWhenMessageIsSent(){
        LocalDate loggedDate =LocalDate.now();
        String loggedMessage = "Date and Message are Logged";
        when(message.getDate()).thenReturn(loggedDate);
        when(message.getMessage()).thenReturn(loggedMessage);
        raceResults.setLog(logger);

        raceResults.addSubscriber(clientA,null);
        raceResults.send(message,null);

        verify(logger).log(loggedDate,loggedMessage);
    }
    @Test
    public void DateAndMessageShouldNotBeLoggedWhenMessageIsNotYetSent(){
        LocalDate loggedDate =LocalDate.now();
        String loggedMessage = "Date and Message are Logged";
        raceResults.setLog(logger);
        raceResults.addSubscriber(clientA,null);

        verify(logger,never()).log(loggedDate,loggedMessage);
    }
}
