package cpsc331.assignment4;

import org.junit.*;
import static org.junit.Assert.*;
import cpsc331.collections.Array;
import cpsc331.assignment4.ArrayUtils;
import java.util.Random;

public class testRQuick2 {

  // Test with an empty array

  @Test
  public void TestSame() {

    Array<Integer> A = new Array<Integer>(0);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();

    utils.rQuickSort2(A);

    assertTrue(A.length() == 0);

  }

  // Test with an array with length one

  @Test
  public void TestSame2() {

    Array<Integer> A = new Array<Integer>(1);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    Integer ONE = new Integer(1);

    A.set(0, ONE);

    utils.rQuickSort2(A);

    assertTrue(A.length() == 1);
    assertTrue(A.get(0).compareTo(ONE) == 0);

  }

  // Test with a small array whose entries are the same

  @Test
  public void TestSame3() {

    Array<Integer> A = new Array<Integer>(10);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    Integer ZERO = new Integer(0);

    int i = 0;
    while (i < A.length()) {
      A.set(i, ZERO);
      i = i + 1;
    };
    utils.rQuickSort2(A);

    assertTrue(A.length() == 10);

    i = 0;
    while (i < A.length()) {
      assertTrue(A.get(i).compareTo(ZERO) == 0);
      i = i + 1;
    }

  }

  // Test with a small array whose entries are increasing

  @Test
  public void TestIncreasing() {

    Array<Integer> A = new Array<Integer>(10);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();

    int i = 0;
    while (i < A.length()) {
      Integer value = new Integer(i);
      A.set(i, value);
      i = i + 1;
    };
    utils.rQuickSort2(A);

    assertTrue(A.length() == 10);

    i = 0;
    while (i < A.length()) {
      Integer value = new Integer(i);
      assertTrue(A.get(i).compareTo(value) == 0);
      i = i + 1;
    }

  }

  // Test with a small array whose entries are decreasing

  @Test
  public void TestDecreasing() {

    Array<Integer> A = new Array<Integer>(10);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();

    int i = 0;
    while (i < A.length()) {
      Integer value = new Integer(9 - i);
      A.set(i, value);
      i = i + 1;
    };
    utils.rQuickSort2(A);

    assertTrue(A.length() == 10);

    i = 0;
    while (i < A.length()) {
      Integer value = new Integer(i);
      assertTrue(A.get(i).compareTo(value) == 0);
      i = i + 1;
    }

  }

  // Tests with Larger Arrays: Entries are the Same

  Array<Integer> buildArray() {

    Array<Integer> A = new Array<Integer>(1000);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    Integer ZERO = new Integer(0);

    int i = 0;
    while (i < A.length()) {
      A.set(i, ZERO);
      i = i + 1;
    };

    return A;

  }

  @Test
  public void TestSame4() {

    Array<Integer> A = buildArray();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  // Large Array with Increasing Entries

  Array<Integer> buildArray2() {

    Array<Integer> A = new Array<Integer>(1000);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();

    int i = 0;
    while (i < A.length()) {
      Integer value = new Integer(i);
      A.set(i, value);
      i = i + 1;
    };

    return A;

  }

  @Test
  public void TestIncreasing2() {

    Array<Integer> A = buildArray2();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  // Large Array with Decreasing Entries

  Array<Integer> buildArray3() {

    Array<Integer> A = new Array<Integer>(1000);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();

    int i = 0;
    while (i < A.length()) {
      Integer value = new Integer(1000 - i - 1);
      A.set(i, value);
      i = i + 1;
    };

    return A;

  }

  @Test
  public void TestDecreasing2() {

    Array<Integer> A = buildArray3();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  // Large Array with Multiple Copies of an Increasing Sequence

  Array<Integer> buildArray4() {

    Array<Integer> A = new Array<Integer>(10000);
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();

    int i = 0;
    while (10 *i < A.length()) {
      int j = 0;
      while (j < 10) {
        Integer value = new Integer(j);
        A.set(10*i + j, value);
        j = j + 1;
      };
      i = i + 1;
    };

    return A;

  }

  @Test
  public void TestStagger() {

    Array<Integer> A = buildArray4();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  // Tests of Random Arrays

  Array<Integer> buildArray5() {

    Array<Integer> A = new Array<Integer>(20000);
    Random random = new Random();

    int i = 0;
    while (i < A.length()) {
      Integer value = new Integer(random.nextInt());
      A.set(i, value);
      i = i + 1;
    };

    return A;

  }

  @Test
  public void TestRandom1() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom2() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom3() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom4() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom5() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom6() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom7() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom8() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom9() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

  @Test
  public void TestRandom10() {

    Array<Integer> A = buildArray5();
    ArrayUtils<Integer> utils = new ArrayUtils<Integer>();
    TestUtils<Integer> testUtils = new TestUtils<Integer>();

    Array<Integer> B = testUtils.SelectionSort(A);
    utils.rQuickSort2(A);

    assertTrue(testUtils.isEqual(A, B));

  }

}
