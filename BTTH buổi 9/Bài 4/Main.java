import java.util.Arrays;

interface Sorter {
    int[] sort(int[] arr);
}


class LegacySorter {
    public int[] quickSort(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }
}

class SorterAdapter implements Sorter {
    private LegacySorter legacySorter;

    public SorterAdapter(LegacySorter legacySorter) {
        this.legacySorter = legacySorter;
    }

    @Override
    public int[] sort(int[] arr) {
        return legacySorter.quickSort(arr);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = {34, 7, 23, 32, 5, 62};

        LegacySorter oldSorter = new LegacySorter();
        Sorter sorter = new SorterAdapter(oldSorter);

        int[] sortedNumbers = sorter.sort(numbers);

        System.out.println("Mảng ban đầu: " + Arrays.toString(numbers));
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(sortedNumbers));
    }
}