package cn.ms.neural.limiter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.ms.micro.common.URL;

public class RedisLimiterTest {

	RedisLimiter redisLimiter = new RedisLimiter();

	public RedisLimiterTest() {
		redisLimiter.start(URL.valueOf("redis://127.0.0.1:6379"));
	}

	@Test
	public void setLimiterRulesTest() {
		LimiterRule limiterRule = new LimiterRule();
		limiterRule.setKeys("app");
		List<Granularity> list = new ArrayList<Granularity>();
		list.add(new Granularity("HOUR", 100l, 0l));
		list.add(new Granularity("MINUTE", 20l, 0l));
		list.add(new Granularity("SECOND", 6l, 0l));
		limiterRule.setLimiterRes(list);
		redisLimiter.setLimiterRules(limiterRule);
	}

	@Test
	public void incrementTest() {
		for (int i = 0; i < 5; i++) {
			redisLimiter.increment("app");
		}
	}

	@Test
	public void queryLimiterRulesTest() {
		System.out.println(redisLimiter.queryLimiterRules(""));
	}

}