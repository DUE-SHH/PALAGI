import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

public class BirdsOfFeather {
    private static final ReentrantLock lock =  new ReentrantLock();

    public static void main(String[] args) {
        singSong();
    }
    public static void animateText(String text, long delay){

        lock.lock();
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                Thread.sleep(delay);

            }
            System.out.println();

        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
        }
    }
    public static void singSong(String Lyric, long delay, long speed) {
        try {
            Thread.sleep(delay);
            animateText(Lyric,speed);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void singSong() {
        String[][] lyrics = {
            {"Birds of a feather", "250"},
            {"we should stick together", "250",}
            {"I said i'd never think i wasn't better alone", "300"},
            {"Can't change the weather might be not", "200"},
            {"Be forever", "260"},
            {"But if it's forever it's even better", "200"},
            {"And i don't know what I'm crying for", "120"},
            {"I don't think I could love you more", "120"},
            {"It might not be long, but baby, I", "130"},
            {"I'll love you 'til the day that I die", "170"},
            {"'Til the day that I die", "220"},
            {"'Till the day that I die", "200"},
            {"'TIll the light leave my eyes", "230"},
            {"'Till the day that I die", "300"},

        };
        long[] delays ={300,3900,7000,10500,15000,18500,21500,24900};
        ExecutorService executor = Executors.newFixedThreadPool(lyrics.length);
        for (int i = 0; i < lyrics.length; i++) {
            final int index = i;
            executor.submit(() -> singSong(lyrics[index][0], delays [index], Long.parseLong(lyrics[index][1])));





        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }

    }




}