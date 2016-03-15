//Andriy Zasypkin
//2016-03-14
//Practice 2011 - 06: Triangular Matrices

public class Stack {
  Matrix topp;
  public Stack() {
    topp = null;
  }

  public void put(Matrix m) {
    Matrix tmp = new Matrix(m);
    tmp.setPrev(topp);
    topp = tmp;
  }

  public Matrix get() {
    Matrix m = topp;
    topp = topp.getPrev();
    return m;
  }

  public Matrix peek() {
    return topp;
  }
}
