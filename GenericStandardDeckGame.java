package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kim on 1/30/2016.
 */
public class GenericStandardDeckGame implements GenericCardGameModel<Card> {
  protected List<Player> players; //list of players

  /**
   * Creates list of players
   */
  public GenericStandardDeckGame () {
    players = new ArrayList<Player>();
  }

  /**
   *  52 cards with 2, ..., jack, queen, king, ace in each of clubs, diamonds, hearts and spades
   * @return a deck of cards
   */
  @Override
  public List<Card> getDeck() {
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
   * @return list of players
   */
  private List<Player> getPlayers() {
    return players;
  }

  /**
   * creates Player objs and adds to the list of Players
   * @param numPlayers
   */
  private void createPlayers(int numPlayers) {
    players.clear();
    for (int i = 0; i < numPlayers; i++) {
      Player p = new Player(i);
      players.add(p);
    }
  }

  /**
   * adds cards to player's hand
   * @param deck
   */
  private void dealCards(List<Card> deck) {
    for (int p = 0; p < players.size(); p++) {
      Player curr = players.get(p); //current player
      for (int c = p; c < deck.size(); c += players.size()) {
        curr.addCard(deck.get(c)); //adds card to their hand
      }
    }
  }

  /**
   * distributes cards in order among players
   *
   * @throws IllegalArgumentException if players < 1 or invalid deck
   */
  @Override
  public void startPlay(int numPlayers, List<Card> deck) {
    boolean validDeck = checkDeck(deck);

    if (numPlayers <= 1) throw new IllegalArgumentException("Players are not greater than 1.");
    if (!validDeck) throw new IllegalArgumentException("Deck is not valid.");

    //sort deck
    Collections.sort(deck);

    //creates players
    createPlayers(numPlayers);

    //deals cards to each player
    dealCards(deck);
  }

  /**
   * @return a string that contains the entire state of the game
   */
  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    state.append("Number of players: " + players.size() + '\n');
    for (int i = 0; i < players.size(); i++) {
      state.append("Player " + i + ": " + players.get(i).getCards() + '\n');
    }
    return state.toString();
  }
}
