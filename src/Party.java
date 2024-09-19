public class Party {
    private int partyNumber;
    private int numPeople;

    public Party(int partyNumber, int numPeople) {
        this.partyNumber = partyNumber;
        this.numPeople = numPeople;
    }

    public int getNumPeople()   {
        return numPeople;
    }
    
    public int getPartyNumber() {
        return partyNumber;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }
}
