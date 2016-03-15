//Andriy Zasypkin
//2016-03-14
//Practice 2011 - 06: Triangular Matrices

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));

    Matrix tmp;

    while(true) {
      int nMatricies = Integer.valueOf(input.readLine());
      Stack stack = new Stack();

      if(nMatricies == 0)
        break;

      Map<String,Matrix> map = new HashMap<String,Matrix>();

      for(int i=0; i<nMatricies; i++) {
        String[] info  = input.readLine().split("\\s+");
        String   name  = info[0];
        int      nSize = Integer.valueOf(info[1]);
                 tmp   = new Matrix(nSize);
        for(int j=0; j<nSize; j++) {
          tmp.populate(input.readLine());
        }
        map.put(name, tmp);
      }
      String[] strExpression = input.readLine().split("\\s+");
      for(String strValue : strExpression) {
        //System.err.println(strValue);
        if(strValue.equals("+")) {
          tmp = stack.get();
          stack.put(tmp.add(stack.get()));
        }
        else if(strValue.equals("*")) {
          tmp = stack.get();
          stack.put(tmp.mult(stack.get()));
        }
        else {
          stack.put(map.get(strValue));
        }
      }
      System.out.println(stack.get().toString());
    }

    //close stream
    input.close();

    System.exit(0);
  }
}
