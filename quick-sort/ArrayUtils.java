package cpsc331.assignment4;

import cpsc331.collections.Array;
import java.util.Random;

public class ArrayUtils<T extends Comparable<T>> {

 // Deterministic partitioning method used by dQuickSort1

  int dPartition1(Array<T> A, int p, int r) throws IndexOutOfBoundsException {
  
    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // b) p and r are input integers.
    //
    // Postcondition:
    //  a) If p >= 0, p <= r, and r < A.length, then the following conditions
    //     are satisfied:
    //     i) The value returned is an integer such that p <= q <= r.
    //     ii) A[h] <= A[q] for every integer h such that p <= h <= q-1.
    //     iii) A[h] > A[q] for every integer h such that q+1 <= h <= r.
    //     iv) If h is an integer such that 0 <= h < p or such that
    //         r+1 <= h < A.length, then A[h] has not been changed.
    //     v) The entries of A have been reordered but are otherwise unchanged.
    //   b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed.

    if ((p < 0) || (p > r) || (r >= A.length())) {

      throw new IndexOutOfBoundsException();

    } else {  

      T x = A.get(r);
      int i = p-1;
      int j = p;

      // Loop Invariant:
      // a) A is an input array with positive length storing values from an
      //    ordered type T.
      // b) p and r are input integers such that 0 <= p <= r < A.length.
      // c) j is an integer variable such that p <= j <= r.
      // d) i is an integer variable such that p-1 <= i <= j-1.
      // e) The following hold for every integer h such that p <= h <= r:
      //    - If h = r the A[h] = x, so that x is a value with type T.
      //    - If p <= h <=i then A[h] <= x.
      //    - If i+1 <= h <= j-1 then A[h] > x.
      // f) A[h] has been unchanged for each integer h such that
      //    0 <= h < p or r < h <= A.length-1.
      // g) The entries of A have been reordered but are otherwise
      //    unchanged.
      //
      //  Bound Function: r-j

      // Assertion for Beginning of the Loop:
      // a) The loop invariant is satisfied.
      // b) i = p-1 and j = p.
 
      while (j < r) {

        // Assertion for Beginning of the Body of the Loop:
        // a) The loop invariant is satisfied.
        // b) p <= j <= r-1.

        if (A.get(j).compareTo(x) <= 0) {
          i = i + 1;
          T tmp = A.get(i);
          A.set(i, A.get(j));
          A.set(j, tmp);
        };
        j = j + 1;

        // Assertion for End of the Body of the Loop:
        // a) The loop invariant is satisfied.
        // b) p+1 <= j <= r.

      }; 

      // Assertion for the End of the Loop:
      // a) The loop invariant is satisfied.
      // b) j = r.

      T tmp = A.get(i+1);
      A.set(i+1, A.get(r));
      A.set(r, tmp);
      return i+1;

    }

  }

  void dQuickSort1(Array<T> A, int p, int r) throws IndexOutOfBoundsException {

    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // b) p and r are input integers.
    //
    // Postcondition:
    // a) If p >= 0, p <= r, and r <= A.length-1 then the following conditions
    //    are satisfied:
    //    - A[h] has been unchanged for every integer h such that 0 <= h < p.
    //    - A[h] <= A[h+1] for every integer h such that p <= h < r.
    //    - A[h] has been unchanged for every integer h such that
    //       r+1 <= h <= A.length-1.
    //    - The entries of A have been reordered but are otherwise unchanged.
    //   b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed.
    //
    // Bound Function: r-p+1

    if (p < r) {

      int q = dPartition1(A, p, r);
      if (q > p) {
        dQuickSort1(A, p, q-1);
      };
      if (q < r) {
        dQuickSort1(A, q+1, r);
      };

    } else if ((p < 0) || (p > r) || (r >= A.length())) {

      throw new IndexOutOfBoundsException();

    } 

  }

  public void dQuickSort1( Array<T> A ){

    // Precondition:
    // a) A is an input array with positive length storing values from an 
    //    ordered type T.
    //
    // Postcondition:
    // a) A[h] <= A[h+1] for every integer h such that 0 <= h <= A.length-2.
    // b) The entries of A have been reordered but are otherwise unchanged.`

    if (A.length() > 1) {
      dQuickSort1(A, 0, A.length()-1);
    };

  };

  // Randomized partitioning method used by rQuickSort 1

  int rPartition1(Array<T> A, int p, int r) throws IndexOutOfBoundsException {
  
    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // b) p and r are input integers.
    //
    // Postcondition:
    //  a) If p >= 0, p <= r, and r < A.length, then the following conditions
    //     are satisfied:
    //     i) The value returned is an integer such that p <= q <= r.
    //     ii) A[h] <= A[q] for every integer h such that p <= h <= q-1.
    //     iii) A[h] > A[q] for every integer h such that q+1 <= h <= r.
    //     iv) If h is an integer such that 0 <= h < p or such that
    //         r+1 <= h < A.length, then A[h] has not been changed.
    //     v) The entries of A have been reordered but are otherwise unchanged.
    //   b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed.

    if ((p < 0) || (p > r) ||  (r >= A.length())) {

      throw new IndexOutOfBoundsException();

    } else {

      Random generator = new Random();
      int s = p + generator.nextInt(r-p+1);
      T tmp = A.get(s);
      A.set(s, A.get(r));
      A.set(r, tmp);
      return dPartition1(A, p, r);

    }

  }

  void rQuickSort1 (Array<T> A, int p, int r) throws IndexOutOfBoundsException {

    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // b) p and r are input integers.
    //
    // Postcondition:
    // a) If p >= 0, p <= r, and r <= A.length-1 then the following conditions
    //    are satisfied:
    //    - A[h] has been unchanged for every integer h such that 0 <= h < p.
    //    - A[h] <= A[h+1] for every integer h such that p <= h < r.
    //    - A[h] has been unchanged for every integer h such that 
    //       r+1 <= h <= A.length-1.
    //    - The entries of A have been reordered but are otherwise unchanged.
    // b) Otherwise an IndexOoutOfBoundsException is thrown and A is not changed.
    //
    // Bound Function: r-p+1

    if (p < r) {

      int q = rPartition1(A, p, r);
      if (q > p) {
        rQuickSort1(A, p, q-1);
      };
      if (q < r) {
        rQuickSort1(A, q+1, r);
      };

    } else if ((p < 0) || (p > r) || (r >= A.length())) {

      throw new IndexOutOfBoundsException();

    }

  }
  
  public void rQuickSort1( Array<T> A ){

    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    //
    // Postcondition:
    // a) A[h] <= A[h+1] for every integer h such that 0 <= h <= A.length-2.
    // b) The entries of A have been reordered but are otherwise unchanged.`

   if (A.length() > 1) {
      rQuickSort1(A, 0, A.length() - 1);
   };

  };

  // Deterministic partitioning method used, indirectly, by dQuickSort2

  int dPartition2(Array<T> A, int p, int r) throws IndexOutOfBoundsException {
  
    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // b) p and r are input integers.
    //
    // Postcondition:
    //  a) If p >= 0, p <= r, and r < A.length, then the following conditions
    //     are satisfied:
    //     i) The value returned is an integer such that p <= q <= r.
    //     ii) A[h] < A[q] for every integer h such that p <= h <= q-1.
    //     iii) A[h] >= A[q] for every integer h such that q+1 <= h <= r.
    //     iv) If h is an integer such that 0 <= h < p or such that
    //         r+1 <= h < A.length, then A[h] has not been changed.
    //     v) The entries of A have been reordered but are otherwise unchanged.
    //   b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed

    if ((p < 0) || (r >= A.length()) || (p > r)) {

      throw new IndexOutOfBoundsException();

    } else {

      T x = A.get(r);
      int i = p-1;
      int j = p;

      // Loop Invariant:
      // a) A is an input array with positive length storing values from an
      //    ordered type T.
      // b) p and r are input integers such that 0 <= p <= r < A.length.
      // c) j is an integer variable such that p <= j <= r.
      // d) i is an integer such that p-1 <= i <= j-1.
      // e) The following hold for each integer h such that p <= h <= r:
      //    - If h = r then A[h] = x, so that x is a value with type T.
      //    - If p <= h <= i then A[h] < x.
      //    - If i+1 <= h <= j-1 then A[h] >= x.
      // f) A[h] has been unchanged for each integer h such that
      //    0 <= h < p or r < h <= A.length - 1.
      // g) The entries of A have been reordered but are otherwise unchanged,
      //
      // Bound Function: r - j

      // Assertion for Beginning of the Loop:
      // a) The loop invariant is satisfied.
      // b) i = p-1 and j = p.

      while (j < r) {

        // Assertion for Beginning of the Body of the Loop:
        // a) The loop invariant is satisfied.
        // b) p <= j <= r-1.

        if (A.get(j).compareTo(x) < 0) {
          i = i + 1;
          T tmp = A.get(i);
          A.set(i, A.get(j));
          A.set(j, tmp);
        };
        j = j + 1;

        // Assertion for End of the Body of the Loop:
        // a) The loop invariant is satisfied.
        // b) p+1 <= j <= r.

      };

      // Assertion for End of the Loop:
      // a) The loop invariant is satisfied.
      // b) j = r.

      T tmp = A.get(i+1);
      A.set(i+1, A.get(r));
      A.set(r, tmp);
      return i+1;

    }

  }

  // Deterministic partition method used by dQuickSort2

  int[] dPartition3(Array<T> A, int p, int r) throws IndexOutOfBoundsException {
  
  // Precondition:
  // a) A is an input array with positive length storing values from an
  //    ordered type T.
  // b) p and r are input integers.
  //
  // Postcondition:
  // a) If p >= 0, p <= r, and r < A.length, then the following conditions
  //    are satisfied:
  //    i) An integer array with length 2 and storing values s and t
  //       such that p <= s, s <= t and t <= r is returned as output
  //    ii) A[h] < A[s] for every integer h such that p <= h < s
  //    iii) A[h] = A[s] for every integer h such that s <= h <= t
  //    iv) A[h] > A[s] for every integer h such that t+1 <= h <= r
  //    v) If h is an integer such that 0 <= h < p or such that
  //       r+1 <= h < A.length, then A[h] has not been changed.
  //    vi) The entries of A have been reordered but are otherwise unchanged.
  // b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed.

    int[] B = new int[2];
    B[1] = dPartition1(A, p, r);
    B[0] = dPartition2(A, p, B[1]);
    return B;

  }

  void dQuickSort2(Array<T> A, int p, int r) throws IndexOutOfBoundsException {

    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // b) p and r are input integers.
    // Postcondition:
    // a) If p >= 0, p <= r, and r <= A.length-1 then the following conditions
    //    are satisfied:
    //    - A[h] has been unchanged for every integer h such that 0 <= h < p.
    //    - A[h] <= A[h+1] for every integer h such that p <= h < r.
    //    - A[h] has been unchanged for every integer h such that 
    //       r+1 <= h <= A.length-1.
    //    - The entries of A have been reordered but are otherwise unchanged.
    // b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed.
    //
    // Bound Function: r-p+1

    if (p < r) {

      int[] B = dPartition3(A, p, r);
      if (B[0] > p) {
        dQuickSort2(A, p, B[0]-1);
       };
       if (B[1] < r) {
        dQuickSort2(A, B[1]+1, r);
       };

    } else if ((p < 0) || (p > r) || (r >= A.length())) {
      
       throw new IndexOutOfBoundsException();

    }

  }
  
  public void dQuickSort2( Array<T> A ){

    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // Postcondition:
    // a) A[h] <= A[h+1] for every integer h such that 0 <= h <= A.length-2.
    // b) The entries of A have been reordered but are otherwise unchanged.`

    if (A.length() > 1) {
      dQuickSort2(A, 0, A.length() - 1);
    };

  };

  // Randomized partition method used by rQuickSort2

  int[]  rPartition2(Array<T> A, int p, int r) throws IndexOutOfBoundsException {
  
  // Precondition:
  // a) A is an input array with positive length storing values from an
  //    ordered type T.
  // b) p and r are input integers.
  // Postcondition:
  // a) If p >= 0, p <= r, and r < A.length, then the following conditions
  //    are satisfied:
  //    i) An integer array with length 2 and storing values s and t
  //       such that p <= s, s <= t and t <= r is returned as output
  //    ii) A[h] < A[s] for every integer h such that p <= h < s
  //    iii) A[h] = A[s] for every integer h such that s <= h <= t
  //    iv) A[h] > A[s] for every integer h such that t+1 <= h <= r
  //    v) If h is an integer such that 0 <= h < p or such that
  //       r+1 <= h < A.length, then A[h] has not been changed.
  //    vi) The entries of A have been reordered but are otherwise unchanged.
  // b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed.
  //
  // Bound Function: r-p+1

    if ((p < 0) || ( p > r) || (r >= A.length())) {

      throw new IndexOutOfBoundsException();

    } else {

      Random generator = new Random();
      int s = p + generator.nextInt(r-p+1);
      T tmp = A.get(s);
      A.set(s, A.get(r));
      A.set(r, tmp);
      return dPartition3(A, p, r);
    }

  }
  
  void rQuickSort2( Array<T> A, int p, int r ){

    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // b) p and r are input integers.
    // Postcondition:
    // a) If p >= 0, p <= r, and r <= A.length-1 then the following conditions
    //    are satisfied:
    //    - A[h] has been unchanged for every integer h such that 0 <= h < p.
    //    - A[h] <= A[h+1] for every integer h such that p <= h < r.
    //    - A[h] has been unchanged for every integer h such that 
    //      r+1 <= h <= A.length-1.
    //    - The entries of A have been reordered but are otherwise unchanged.
    // b) Otherwise an IndexOutOfBoundsException is thrown and A is not changed.
    //
    // Bound Function: r-p+1

    if (p < r) {

      int[] B = rPartition2(A, p, r);
      if (B[0] > p) {
        rQuickSort2(A, p, B[0]-1);
      };
      if (B[1] < r) {
        rQuickSort2(A, B[1]+1, r);
      };

    } else if ((p < 0) || (p > r) || (r >= A.length())) {

      throw new IndexOutOfBoundsException();

    }

  };

  public void rQuickSort2(Array<T> A) {

    // Precondition:
    // a) A is an input array with positive length storing values from an
    //    ordered type T.
    // a) A[h] <= A[h+1] for every integer h such that 0 <= h <= A.length-2.
    // b) The entries of A have been reordered but are otherwise unchanged.`

    if (A.length() > 1) {
      rQuickSort2(A, 0, A.length()-1);
    };

  }

}
