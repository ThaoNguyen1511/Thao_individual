import org.junit.Test;

public class GD2 {


    /**
     * Check the balance of the provided card.
     * Card with not enough balance will be return false
     * This test is created to test bool checkBalance(Card card) method
     */
    @Test
    public void falseWillBeReturnedWhenCardHasInSufficientBalance(){ }
    /**
     * Check the balance of the provided card.
     * This test should be passed when a card with sufficient balance
     * This test is created to test bool checkBalance(Card card) method
     */
    @Test
    public void trueWillBeReturnedWhenCardHasSufficientBalance(){ }

    /**
     * This test should be passed when a new card is given to the gambler successfully by the cashier
     * This test is created to test void giveCardToGambler(Gambler gambler) method
     */
    @Test
    public void aNewCardShouldBeAssignedToGamblerSuccessfully(){ }

    /**
     * This test should throw exception when updating the credit on the card with the insufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateCardBalanceWithInsufficientAmountShouldThrowException(){ }
    /**
     * This test should be passed when updating the credit on the card with the sufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test
    public void updateCardBalanceWithSufficientAmountShouldBeSuccessful(){ }

    /**
     * This test should be passed when a card is handed back to the cashier successfully
     * This test is created to test void resetCard(Card c) method
     */
    public void cardSuccessfullyHandedBackToCashier(){ }






    /**
     * This test should be passed when a gambler place a bet successfully via the gaming machine
     * This test is created to test void placeBet(Bet bet) method
     */
    public void aBetPlacedSuccessfulByAGambler(){ }

    /**
     * This test should be passed when token is set successfully to the betting round when betting authority acquires
     for a token
     * this test is created to test void setToken(string token) method
     */
    public void tokenIsSetSuccessfullyToBettingRoundWhenBettingAuthorityAcquiresForAToken(){ }

    /**
     * This test should be passed if balance of the card is updated successfully with the amount won when the round has ended
     * This test is created to test void endRound(Cashier cashier, double amount) method
     */
    public void balanceOfTheCardIsUpdatedSuccessfullyWithTheAmountWonWhenTheRoundHasEnded(){ }

    /**
     * Test should be passed if a random number is get successfully for a betting round from its token.
     * It can be asked to generate for random numbers
     * This test is created to test int getRandomNumberForGame(GameType gameType) method
     */
    public void aRandomNumberShouldBeGeneratedForABettingRoundFromItsToken(){ }

    /**
     * Test should be passed if a list of placed bets is returned successfully
     * this test is created for List<Bet> getListOfPlacedBets() method
     */
    public void aListOfPlacedBetsShouldBeReturnedSuccessfully(){ }










}
