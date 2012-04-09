package redis.clients.johm.cards;

import java.util.Set;

import redis.clients.johm.Attribute;
import redis.clients.johm.CollectionSet;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;

@Model
public class Player {
    @Id
    private Long id;
    
    @Attribute
    private char initial;

    @Attribute
    @Indexed
    private String name;
	
    @CollectionSet(of=Card.class)
    @Indexed
	private  Set<Card> hand;

    public String getName() {
        return name;
    }
    
    public void addCard(Card card){
    	hand.add(card);
    }
    
    public void removeCard(Card card){
    	hand.remove(card);
    }

    public Card[] getCards(){
    	return (Card[]) hand.toArray();
    }
    
    public Long getId(){
    	return id;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + id.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this == obj)
    		return true;
    	if(id.equals(((Player)obj).id))
    		return true;
    	return false;
    }
}
