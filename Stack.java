//Andriy Zasypkin
//2016-03-14
//Practice 2011 - 06: Triangular Matrices

public class Stack {
  Matrix topp;
  public Stack() {
    topp = null;
  }

  public void put(Matrix m) {
    m.setPrev(topp);
    topp = m;
  }

  public Matrix get() {
    Matrix m = topp;
    topp = topp.getPrev();
    return m;
  }
}
