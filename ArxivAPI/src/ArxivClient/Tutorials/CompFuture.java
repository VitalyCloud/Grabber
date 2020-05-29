package ArxivClient.Tutorials;


import java.util.concurrent.CompletableFuture;

public class CompFuture {
    public static void main(String[] args) {
        fourthExample();
    }

    //.get()
    public static void firstExample() {


        CompletableFuture<String> one = CompletableFuture.supplyAsync(()-> "Hello"); //Can return value
        CompletableFuture<Void> two = CompletableFuture.runAsync(() -> { //Just runnable
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("World");
        });

        try {
            two.get(); //Block thread
            System.out.println(one.get());
        } catch (Exception e) {

        }
    }

    // Call backs
    public static void secondExample() {
        // Call backs
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");

        future.thenApply(result -> {
            System.out.println(result + " all"); //output Hi all
            return result;
        });

        future.thenApply(result -> {
            System.out.println(result + ", world!"); //output Hi, world!
            return result;
        });

//        try {
//            future.get();
//        } catch (Exception e) {}


        //Async variant
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
//
//        future.thenApplyAsync(result -> {
//            System.out.println(result + " all"); //output Hi all
//            return result;
//        });
//
//        try {
//            Thread.sleep(100);
//        } catch (Exception e) {}
    }

    //Composition
    public static void thirdExample() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenCompose(result ->
                        CompletableFuture.supplyAsync(() -> result * 2)
                ).thenCompose(result ->
                        CompletableFuture.supplyAsync(() -> result * 5)
                ).thenCompose(result ->
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println("Computation completed!");
                            return result;
                        })
                );

//        future.whenComplete((result, error) -> System.out.println("Result=" + result));

//        try {
//            System.out.println(future.get()); //output 100
//        } catch (Exception e) {}

    }

    public static void fourthExample() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenCompose(result ->
                        CompletableFuture.supplyAsync(() -> result * 2)
                ).thenCompose(result ->
                        CompletableFuture.supplyAsync(() -> result * 5)
                ).thenCompose(result ->
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println("Computation completed!");
                            return result;
                        })
                );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        future.thenAccept((result) -> System.out.println("After 3 second variable = " + result));
    }

    public static void fifthExample() {
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> {
                    throw new RuntimeException("error in async running");
                }).handle((obj, err) -> {
                    System.out.print(err.getMessage());
                    return 10;
                });

//        System.out.println(" "+future.get()); //output java.lang.RuntimeException: error in async running 10
    }
}
