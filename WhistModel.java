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

/**
 * Created by Kim on 1/30/2016.
 */
public class WhistModel extends GenericStandardDeckGame implements CardGameModel<Card> {
  protected int turns = 0;
  protected List<WhistPlayer> players;
  protected Card[] trick;
  protected Suit currentSuit = null;
  protected int currentPlayer = 0;
  protected boolean gameStarted = false;

  public WhistModel () {
    players = new ArrayList<WhistPlayer>();
  }

   /**
   * 52 cards with 2, ..., jack, queen, king, ace in each of clubs,
    * diamonds, hearts and spades
   * @return a deck of cards
   */
   @Override
   public List<Card> getDeck() {
     // System.out.println("getDeck()");
    List<Card> deck = new ArrayList<Card>();
    for (Value v : Value.values()) {
      for (Suit s : Suit.values()) {
        Card c = new Card(v , s);
        deck.add(c);
      }
    }
    return deck;
  }

  /**
   * Checks deck for the correct amount, no dupes, and valid value/suit
   * @param deck to be checked
   * @return true if valid deck, false if invalid
   */
  public boolean checkDeck(List<Card> deck) {
    // System.out.println("checkDeck()");
    Set<Card> set = new HashSet<Card>(deck);
    if (deck.size() != 52 ) {
      return false;
    }
    if(set.size() < deck.size()) {
      return false;
    }
    for (int i = 0; i < deck.size(); i++) {
      Card curr = deck.get(i);
      if (curr.getValue().value == 0) { //gets value of card and checks if valid
        return false;
      }
      if (curr.getSuit().value == 0) { //gets suit of card and checks if valid
        return false;
      }
    }
    return true;
  }

  /**
   * creates Player objs and adds to the list of Players
   * @param numPlayers
   */
  protected void createPlayers(int numPlayers) {
    // System.out.println("createPlayers()");
    players.clear();
    for (int i = 0; i < numPlayers; i++) {
      WhistPlayer p = new WhistPlayer(i);
      players.add(p);
    }
  }

  /**
   * adds cards to player's hand
   * @param deck
   */
  protected void dealCards(List<Card> deck) {
    // System.out.println("dealCards()");
    for (int p = 0; p < players.size(); p++) {
      Player curr = players.get(p); //current player
      for (int c = p; c < deck.size(); c += players.size()) {
        curr.addCard(deck.get(c)); //adds card to their hand
      }
    }
  }

  /**
   * distributes cards in order among players
   * @throws IllegalArgumentException if players < 1 or invalid deck
   */
  @Override
  public void startPlay(int numPlayers, List<Card> deck) {
    // System.out.println("startPlay()");
    boolean validDeck = checkDeck(deck);

    if (numPlayers <= 1) throw new IllegalArgumentException("Players are not " +
            "greater than 1.");
    if (!validDeck) throw new IllegalArgumentException("Deck is not valid.");

    //sort deck
    Collections.sort(deck);

    //creates players
    createPlayers(numPlayers);

    //deals cards to each player
    dealCards(deck);

    //allot space for trick
    trick = new Card[players.size()];

  }

  /**
   * Plays card at index in the set of cards for player
   * assumes that player numbers and card indices begin with 0 and hands are sorted
   * @param player player
   * @param index index of card
   */
  @Override
  public void play(int player, int index){
    if (players.size()  > turns) {
      if (player != getCurrentPlayer()) {
        throw new IllegalArgumentException("Incorrect player.");
      } else {
        WhistPlayer curr = players.get(player);
        if (gameStarted == false || turns == players.size()) {
          currentSuit = curr.getCard(index).getSuit();
          addToTrick(player, index);
        } else if (turns != 0 && curr.getCard(index).getSuit().equals(currentSuit)) {
          addToTrick(player, index);
        } else if (turns != 0 && !curr.getCard(index).getSuit().equals(currentSuit)
                && !curr.hasSuit(currentSuit)) {
          addToTrick(player, index);
        } else {
          throw new IllegalArgumentException();
        }
      }
      setNextPlayer(currentPlayer);
      turns++;

    } else { // hand has ended
      // check winner of hand and restart
      int trickwin = getTrickWinner();
      players.get(trickwin).addHand(); //give the winner the hand
      setNextPlayer(trickwin);
      clearTrick();
      turns = 0;
    }
  }

  protected void clearTrick() {
    for (int i = 0; i < trick.length; i++) {
      trick[i] = null;
    }
  }
  protected void setNextPlayer(int curr) {
    currentPlayer = (curr + 1) % players.size();
  }

  /**
   * add played card to trick and discards from player's hand
   * if it's not the right suit, don't keep in trick
   */
  protected void addToTrick(int player, int index) {
    WhistPlayer p = players.get(player);
    trick[player] = p.getCard(index);
    p.removeCard(index);
  }

  /**
   * Sorts the trick and finds winner
   * @return round winner
   */
  protected int getTrickWinner() {
    // System.out.println("getTrickWinner()");
    List<Card> h = new ArrayList<Card>();
    Collections.addAll(h, trick);
    Collections.sort(h);
    return java.util.Arrays.asList(trick).indexOf(h.get(0));
  }

  /**
   *
   * @return the player whose turn it is to play
   */
  @Override
  public int getCurrentPlayer(){
    return currentPlayer;
  }

  /**
   * Game is over when there are fewer than two players with any cards remaining.
   * @return if game is over true, else false
   */
  @Override
  public boolean isGameOver(){
    if (turns != players.size() || gameStarted) {
      return false;
    } else {
      int out = 0;
      for (int i = 0; i < players.size(); i++) {
        if (players.get(i).getNumCards() == 0) {
          out++;
        }
      }
      if ((players.size() - out) < 2) {
        return true;
      } else {
        return false;
      }
    }
  }

  /**
   *
   * @return winner
   */
  public int getWinner() {
    int win = 0;
    List<Integer> scores = new ArrayList<Integer>();
    List<Integer> sort = new ArrayList<Integer>();
    for (int n = 0; n < players.size(); n++) {
      scores.add(players.get(n).getHands());
      sort.add(players.get(n).getHands());
    }
    Collections.sort(sort);
    Collections.reverse(sort);
    if (scores.size() != 0) {

      try {
        win = scores.indexOf(sort.get(0));
      } catch (IndexOutOfBoundsException e) {
        e.printStackTrace();
      }
    }

    return win+1;
  }

  /**
   * @return a string that contains the entire state of the game
   */
  @Override
  public String getGameState(){
    // System.out.println("getGameState()");
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
      state.append("Turn: Player " + (getCurrentPlayer() + 1));
    }
    return state.toString();
  }

}
