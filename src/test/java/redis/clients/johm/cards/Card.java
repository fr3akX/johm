package redis.clients.johm.cards;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Model;

@Model
public class Card implements Externalizable {
	
	public enum Suits {
	      HEARTS,
	      SPADES,
	      DIAMONDS,
	      CLUBS,
	}
	public enum Ranks {
	      TWO,
	      THREE,
	      FOUR,
	      FIVE,
	      SIX,
	      SEVEN,
	      EIGHT,
	      NINE,
	      TEN,
	      JACK,
	      QUEEN,
	      KING,
	      ACE,
	}
	
    @Id
    private Long id;
	@Attribute
	private Ranks rank;
	@Attribute
	private Suits suit;
	
	public Card(Ranks rank, Suits suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public long getId(){
		return id;
	}
	
	public Ranks getRank(){
		return rank;
	}
	
	public Suits getSuit(){
		return suit;
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		rank  = Ranks.values()[in.readInt()];
		suit = Suits.values()[in.readInt()];
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(rank.ordinal());
		out.writeInt(suit.ordinal());
	}
}
