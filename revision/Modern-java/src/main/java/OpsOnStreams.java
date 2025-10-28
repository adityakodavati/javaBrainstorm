import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OpsOnStreams {

    public IntStream numStream = IntStream.rangeClosed(0, 20);


    public static void main(String[] args) {

        Consumer<OpsOnStreams> usingfilter = OpsOnStreams::usingfilter;

        new OpsOnStreams().usingfilter();

    }

    public void usingfilter() {
        numStream.filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    public void usingMap() {
        numStream.map(n -> n * n).forEach(System.out::println);
    }

    public void usingFlatMap() {
        List<List<Integer>> integerList = Arrays.asList(List.of(1),
                List.of(2));

        List<Integer> lists = integerList.stream().flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("used flatmap to flat the list" + lists);
    }

    public void usingPeek() {
        numStream.peek(System.out::println).filter(n -> n % 2 == 0).peek(System.out::println);
    }


}
