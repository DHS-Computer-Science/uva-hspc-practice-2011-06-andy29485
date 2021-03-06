//Andriy Zasypkin
//2016-03-14
//Practice 2011 - 06: Triangular Matrices

public class Matrix {
  int[][] aanMatrix;
  int[]   anPointer;
  Matrix  prev;

  public Matrix(int nSize) {
    aanMatrix = new int[nSize][];
    for(int i=0; i<nSize; i++) {
      aanMatrix[i] = new int[i+1];
    }
    anPointer = new int[] {0, 0};
    prev = null;
  }

  public Matrix(Matrix tmp) {
    aanMatrix = new int[tmp.getSize()][];
    for(int i=0; i<tmp.getSize(); i++) {
      aanMatrix[i] = new int[i+1];
      for(int j=0; j<=i; j++) {
        this.set(i, j, tmp.get(i, j));
      }
    }
    anPointer = new int[] {0, 0};
    prev = null;
  }

  public Matrix(int nSize, int... nValues) {
    aanMatrix = new int[nSize][];
    int nCount = 0;
    for(int i=0; i<nSize; i++) {
      aanMatrix[i] = new int[i+1];
      for(int j=0; j<i; j++) {
        aanMatrix[i][j] = nValues[nCount++];
      }
    }
    anPointer = new int[] {0, 0};
    prev = null;
  }

  public int get(int i, int j) {
    return aanMatrix[i][j];
  }

  public void set(int i, int j, int nValue) {
    aanMatrix[i][j] = nValue;
  }

  public int getSize() {
    return aanMatrix.length;
  }

  public void setPrev(Matrix m) {
    this.prev = m;
  }

  public Matrix getPrev() {
    return this.prev;
  }

  public void populate(String strLine) {
    for(String strValue : strLine.split("\\s+")) {
      aanMatrix[anPointer[0]][anPointer[1]] = Integer.valueOf(strValue);
      anPointer[1]++;
      if(anPointer[1] >= aanMatrix[anPointer[0]].length) {
        anPointer[0]++;
        anPointer[1] = 0;
      }
      if(anPointer[0] >= aanMatrix.length) {
        anPointer[0] = 0;
      }
    }
  }

  public Matrix add(Matrix rhs) {
    Matrix sum = new Matrix(this.getSize()>rhs.getSize()
                            ? this.getSize() : rhs.getSize());
    for(int i=0; i<aanMatrix.length; i++) {
      for(int j=0; j<aanMatrix[i].length; j++) {
        sum.set(i, j, this.get(i,j) + rhs.get(i,j));
      }
    }
    return sum;
  }

  public Matrix mult(Matrix rhs) {
    if(this.getSize() > rhs.getSize())
      return new Matrix(0);
    Matrix product = new Matrix(rhs.getSize()-this.getSize()+1);
    for(int i=0; i<(rhs.getSize()-this.getSize()+1); i++) {
      for(int j=0; j<(i+1); j++) {
        int tmp = 0;
        for(int k=0; k<this.getSize(); k++) {
          for(int l=0; l<aanMatrix[k].length; l++) {
            tmp += this.get(k, l)*rhs.get(i+k, j+l);
          }
        }
        product.set(i, j, tmp);
      }
    }
    return product;
  }

  public static int hightToSize(int nHeight) {
    int nSize = 0;
    for(int i=1; i<=nHeight; i++) {
      nSize += i;
    }
    return nSize;
  }

  public String toString() {
    String strOut = "";
    for(int i=0; i<aanMatrix.length; i++) {
      for(int j=0; j<aanMatrix[i].length; j++) {
        strOut += aanMatrix[i][j] + " ";
      }
      if(i < aanMatrix.length-1)
        strOut += "\n";
    }
    return strOut.length() == 0 ? "Invalid Expression" : strOut;
  }
}
