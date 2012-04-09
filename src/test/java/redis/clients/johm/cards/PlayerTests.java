package redis.clients.johm.cards;

import static org.junit.Assert.*;


import org.junit.Test;

import redis.clients.jedis.JedisPool;
import redis.clients.johm.JOhm;
import redis.clients.johm.cards.Card.Ranks;
import redis.clients.johm.cards.Card.Suits;

public class PlayerTests {

	@Test
	public void test() {
		JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
		JOhm.setPool(jedisPool);
        //User user = new User();
        ///JOhm.save(user);

		Player player = new Player();
		JOhm.save(player);
		player.addCard(new Card(Ranks.ACE, Suits.CLUBS));
		//System.out.println(player.getId());
	}

}
