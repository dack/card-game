package cs3500.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cs3500.hw02.Card;
import cs3500.hw02.GenericStandardDeckGame;
import cs3500.hw02.Player;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistModel;
import cs3500.hw03.WhistPlayer;

/**
 * Created by Kim on 1/30/2016.
 */
public class TrumpModel extends WhistModel implements CardGameModel<Card> {
  protected Suit trumpSuit;

  public TrumpModel() {
    players = new ArrayList<WhistPlayer>();
  }

   /**
   * 52 cards with 2, ..., jack, queen, king, ace in each of clubs,
    * diamonds, hearts and spades
   * @return a deck of cards
   */
   @Override
   public List<Card> getDeck() {
     return super.getDeck();
   }

  /**
   * Checks deck for the correct amount, no dupes, and valid value/suit
   * @param deck to be checked
   * @return true if valid deck, false if invalid
   */
  public boolean checkDeck(List<Card> deck) {
    return super.checkDeck(deck);
  }

  /**
   * creates Player objs and adds to the list of Players
   * @param numPlayers
   */
  protected void createPlayers(int numPlayers) {
    super.createPlayers(numPlayers);
  }

  /**
   * adds cards to player's hand
   * @param deck
   */
  protected void dealCards(List<Card> deck) {
    super.dealCards(deck);
  }

  /**
   * distributes cards in order among players
   * @throws IllegalArgumentException if players < 1 or invalid deck
   */
  @Override
  public void startPlay(int numPlayers, List<Card> deck) {
    boolean validDeck = checkDeck(deck);

    if (numPlayers <= 1) throw new IllegalArgumentException("Players are not " +
            "greater than 1.");
    if (!validDeck) throw new IllegalArgumentException("Deck is not valid.");

    //sort deck
    Collections.sort(deck);

    //set trump suit
    trumpSuit = deck.get(0).getSuit();

    //creates players
    createPlayers(numPlayers);

    //deals cards to each player
    dealCards(deck);

    //allot space for trick
    trick = new Card[this.players.size()];

  }

  public Suit getTrumpSuit() {
    return trumpSuit;
  }


  /**
   * Plays card at index in the set of cards for player
   * assumes that player numbers and card indices begin with 0 and hands are sorted
   * @param player player
   * @param index index of card
   */
  @Override
  public void play(int player, int index){
    super.play(player, index);
  }
  
  protected void setNextPlayer(int curr) { super.setNextPlayer(curr); }
  
  /**
   * add played card to trick and discards from player's hand
   * if it's not the right suit, don't keep in trick
   */
  @Override
  protected void addToTrick(int player, int index) {
	WhistPlayer p = players.get(player);

    //if suit doesn't match current suit
    if (p.getCard(index).getSuit() != currentSuit) {
      //if suit matches trump. otherwise forfeit
      if (p.getCard(index).getSuit() == trumpSuit) {
        trick[player] = p.getCard(index);
      } else {
        trick[player] = null;
      }
    } else {
    	trick[player] = p.getCard(index);
    }
    
    p.removeCard(index);
  }

  /**
   * Sorts the trick and finds winner
   * @return round winner
   */
  @Override
  protected int getTrickWinner() {
	List<Card> h = new ArrayList<Card>();
	Collections.addAll(h, trick);
	Collections.sort(h);

    //check if a trump has been played, if true, choose the first instance
    //since the cards have already been sorted
    for (int c = 0; c < h.size(); c++) {
      if (h.get(c).getSuit() == trumpSuit) {
        return java.util.Arrays.asList(trick).indexOf(h.get(c));
      }
    }
    //otherwise just choose the first index
    return java.util.Arrays.asList(trick).indexOf(h.get(0));
  }

  /**
   *
   * @return the player whose turn it is to play
   */
  public int getCurrentPlayer(){
    return super.getCurrentPlayer();
  }

  /**
   * Game is over when there are fewer than two players with any cards remaining.
   * @return if game is over true, else false
   */
  public boolean isGameOver(){
    return super.isGameOver();
  }

  /**
   *
   * @return winner
   */
  public int getWinner() {
    return super.getWinner();
  }

  /**
   * @return a string that contains the entire state of the game
   */
  @Override
  public String getGameState(){
    //System.out.println("getGameState()");
    StringBuilder state = new StringBuilder();
    state.append("Number of players: " + players.size() + '\n');
    for (int i = 0; i < players.size(); i++) {
      state.append("Player " + (i+1) + ": " + players.get(i).getCards() + '\n');
    }
    for (int i = 0; i < players.size(); i++) {
      state.append("Player " + (i+1) + ": " + players.get(i).getHands() + " hands won" + '\n');
    }
    if (isGameOver()) {
      state.append("Game over. Player " + getWinner() + " won.");
    } else {
      state.append("Turn: Player " + getCurrentPlayer() + '\n');
      state.append("Trump suit: " + trumpSuit);
    }
    return state.toString();
  }

}
