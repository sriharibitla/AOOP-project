package onlineauction;

public class Main {
    public static void main(String[] args) {
        // Create auction and bidders
        Auction auction = new Auction();
        Bidder bidder1 = new Bidder("Alice");
        Bidder bidder2 = new Bidder("Bob");

        // Register bidders to auction
        auction.registerObserver(bidder1);
        auction.registerObserver(bidder2);

        // Simulate auction events
        auction.setItem("Vintage Car");
        auction.startBidding();
        auction.endBidding();

        // Unregister a bidder
        auction.unregisterObserver(bidder1);

        // Simulate more auction events
        auction.setItem("Antique Vase");
        auction.startBidding();
    }
}
