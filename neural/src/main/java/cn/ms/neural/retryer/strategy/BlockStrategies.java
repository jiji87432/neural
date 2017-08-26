package cn.ms.neural.retryer.strategy;

/**
 * Factory class for {@link BlockStrategy} instances.
 * 
 * @author lry
 */
public final class BlockStrategies {

    private static final BlockStrategy THREAD_SLEEP_STRATEGY = new ThreadSleepStrategy();

    private BlockStrategies() {
    }

    /**
     * Returns a block strategy that puts the current thread to sleep between
     * retries.
     *
     * @return a block strategy that puts the current thread to sleep between retries
     */
    public static BlockStrategy threadSleepStrategy() {
        return THREAD_SLEEP_STRATEGY;
    }

    private static class ThreadSleepStrategy implements BlockStrategy {

        @Override
        public void block(long sleepTime) throws InterruptedException {
            Thread.sleep(sleepTime);
        }
    }
    
}