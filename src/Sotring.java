import java.util.*;

public class Sotring {
    public static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomArr(int size){
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i){
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    public static int[] generateOrderedArr(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateBackOrderedArr(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i){
            arr[i] = size-i;
        }
        return arr;
    }

    public static void test(int type, int size){
        int[] array = generateRandomArr(size);
        if (type == 1){
            array = generateOrderedArr(size);

        }
        else if (type == 2){
            array = generateBackOrderedArr(size);
        }
        Map<Integer, String> map = new TreeMap<>();
        System.out.println("Пузырьковая сортировка".toUpperCase());
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println("Отсортированный массив:");
        long startTime = System.nanoTime();
        printArr(bubbleSort(array));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Время выполнения: " + duration + " наносекунд");
        map.put((int) duration, "Пузырьковая сортировка");
        System.out.println("-".repeat(100));

        System.out.println("Шейкерная сортировка".toUpperCase());
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println("Отсортированный массив:");
        startTime = System.nanoTime();
        printArr(shakerSort(array));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        map.put((int) duration, "Шейкерная сортировка");
        System.out.println("Время выполнения: " + duration + " наносекунд");

        System.out.println("-".repeat(100));

        System.out.println("Сортировка вставками".toUpperCase());
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println("Отсортированный массив:");
        startTime = System.nanoTime();
        printArr(insertionSort(array));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        map.put((int) duration, "Сортировка вставками");
        System.out.println("Время выполнения: " + duration + " наносекунд");

        System.out.println("-".repeat(100));

        System.out.println("Сортировка выбором".toUpperCase());
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println("Отсортированный массив:");
        startTime = System.nanoTime();
        printArr(selectionSort(array));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        map.put((int) duration, "Сортировка выбором");
        System.out.println("Время выполнения: " + duration + " наносекунд");

        System.out.println("-".repeat(100));

        System.out.println("Быстрая сортировка".toUpperCase());
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println("Отсортированный массив:");
        startTime = System.nanoTime();
        printArr(quickSort(array));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        map.put((int) duration, "Быстрая сортировка");
        System.out.println("Время выполнения: " + duration + " наносекунд");

        System.out.println("-".repeat(100));

        System.out.println("Сортировка кучей".toUpperCase());
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println("Отсортированный массив:");
        startTime = System.nanoTime();
        printArr(heapSort(array));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        map.put((int) duration, "Сортировка кучей");
        System.out.println("Время выполнения: " + duration + " наносекунд");

        System.out.println("-".repeat(100));

        System.out.println("Сортировка слиянием".toUpperCase());
        System.out.println("Исходный массив:");
        printArr(array);
        System.out.println("Отсортированный массив:");
        startTime = System.nanoTime();
        printArr(mergeSort(array));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        map.put((int) duration, "Сортировка слиянием");
        System.out.println("Время выполнения: " + duration + " наносекунд");

        System.out.println("-".repeat(100));

        System.out.println("Топ сортировок на "+size+" элементов");
        map.forEach((key, value) -> {
            System.out.println("Алгоритм: " + value + ", Время выполнения: " + key + " наносекунд");
        });
    }

    /**
     * Пузырьковая сортировка.
     *
     * Пузырьковая сортировка — это простой алгоритм сортировки, который многократно проходит по списку,
     * сравнивает соседние элементы и меняет их местами, если они находятся в неправильном порядке.
     *
     * Временная сложность:
     * - Лучший случай: O(n)
     * - Средний случай: O(n^2)
     * - Худший случай: O(n^2)
     *
     * Этот алгоритм лучше всего использовать для небольших массивов или в образовательных целях,
     * так как он неэффективен для больших наборов данных.
     */
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        int[] arr = array.clone();
        for (int i = 0; i < length - 1; ++i){
            boolean swapped = false;
            for (int j = 0; j < length - 1 - i; ++j){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                return arr;
            }
        }
        return arr;
    }

    /**
     * Шейкерная сортировка.
     *
     * Шейкерная сортировка — это улучшенная версия пузырьковой сортировки, которая проходит по массиву
     * в обоих направлениях, что позволяет быстрее перемещать большие элементы к концу массива.
     *
     * Временная сложность:
     * - Лучший случай: O(n)
     * - Средний случай: O(n^2)
     * - Худший случай: O(n^2)
     *
     * Этот алгоритм также лучше всего подходит для небольших массивов и может быть использован,
     * когда требуется более быстрая сортировка по сравнению с пузырьковой сортировкой.
     */
    public static int[] shakerSort(int[] array){
        int[] arr = array.clone();
        int left = 0, right = arr.length-1;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = left; i < right; ++i){
                if (arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            right--;

            for (int i = right; i > left; --i){
                if (arr[i] < arr[i-1]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    swapped = true;
                }
            }
            left++;
        } while (swapped);
        return arr;
    }

    /**
     * Сортировка вставками.
     *
     * Сортировка вставками — это простой алгоритм, который строит отсортированный массив по одному элементу,
     * вставляя каждый новый элемент в правильное место среди уже отсортированных.
     *
     * Временная сложность:
     * - Лучший случай: O(n)
     * - Средний случай: O(n^2)
     * - Худший случай: O(n^2)
     *
     * Этот алгоритм хорошо работает на небольших или почти отсортированных массивах.
     */
    public static int[] insertionSort(int[] array){
        int[] arr = array.clone();
        int length = arr.length;
        for (int i = 1; i < length; ++i){
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    /**
     * Сортировка выбором.
     *
     * Сортировка выбором — это алгоритм, который делит массив на отсортированную и неотсортированную части,
     * последовательно выбирая минимальный элемент из неотсортированной части и перемещая его в конец отсортированной.
     *
     * Временная сложность:
     * - Лучший случай: O(n^2)
     * - Средний случай: O(n^2)
     * - Худший случай: O(n^2)
     *
     * Этот алгоритм подходит для небольших массивов и когда память ограничена, так как он требует
     * минимального количества дополнительных ресурсов.
     */
    public static int[] selectionSort(int[] array){
        int[] arr = array.clone();
        int length = arr.length;
        for (int i = 0; i < length; ++i){
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < length; ++j){
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = min;
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    /**
     * Быстрая сортировка.
     *
     * Быстрая сортировка — это эффективный алгоритм, который использует метод "разделяй и властвуй",
     * выбирая опорный элемент и разделяя массив на подмассивы, которые затем сортируются рекурсивно.
     *
     * Временная сложность:
     * - Лучший случай: O(n log n)
     * - Средний случай: O(n log n)
     * - Худший случай: O(n^2)
     *
     * Этот алгоритм хорошо подходит для больших массивов и является одним из самых быстрых алгоритмов сортировки.
     */
    public static int[] quickSort(int[] array){
        int[] arr = array.clone();
        quickSortAlg(arr, 0, arr.length-1);
        return arr;
    }

    public static void quickSortAlg(int[] array, int low, int high){
        if (low < high){
            int pivotIndex = partition(array, low, high);
            quickSortAlg(array, low, pivotIndex-1);
            quickSortAlg(array, pivotIndex+1, high);
        }
    }

    public static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; ++j){
            if (array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;

    }

    /**
     * Сортировка кучей.
     *
     * Сортировка кучей — это алгоритм, который использует структуру данных "куча" для сортировки элементов.
     * Он сначала строит кучу из массива, а затем извлекает элементы из кучи в отсортированном порядке.
     *
     * Временная сложность:
     * - Лучший случай: O(n log n)
     * - Средний случай: O(n log n)
     * - Худший случай: O(n log n)
     *
     * Этот алгоритм хорошо подходит для больших массивов и когда требуется гарантированное время выполнения.
     */
    public static int[] heapSort(int[] array){
        int arr[] = array.clone();
        int length = arr.length;
        for (int i = length/2 -1 ; i >= 0; --i){
            heapify(arr, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;

    }

    public static void heapify(int[] arr, int length, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && arr[left] > arr[largest]){
            largest = left;
        }

        if (right < length && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }
    /**
     * Сортировка слиянием.
     *
     * Сортировка слиянием — это алгоритм, который использует метод "разделяй и властвуй", разбивая массив
     * на две половины, сортируя каждую из них рекурсивно и затем сливая отсортированные половины.
     *
     * Временная сложность:
     * - Лучший случай: O(n log n)
     * - Средний случай: O(n log n)
     * - Худший случай: O(n log n)
     *
     * Этот алгоритм хорошо подходит для больших массивов и когда требуется стабильная сортировка.
     */
    public static int[] mergeSort(int[] array) {
        int[] arr = array.clone();
        mergeSortAlg(arr);
        return arr;
    }

    public static void mergeSortAlg(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        int mid = length / 2;
        int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(arr, mid, length);
        mergeSortAlg(leftHalf);
        mergeSortAlg(rightHalf);
        merge(arr, leftHalf, rightHalf);
    }

    public static void merge(int[] result, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            }
            else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
    }

    //type - тип заполнения массива
    //size - размер массиива
    //type == 1 - упорядоченное по возрастанию заполнение массива
    //type == 2 - упорядоченное по возрастанию заполнение массива
    //другой type - случаное заполненеи массива
    public static void main(String[] args) {
        test(3, 1000);
    }
}