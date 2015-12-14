# Practice 2011 - 06: Triangular Matrices

## Background
Let triangular matrices be defined as equilateral triangles with numbers in the
form:
![Diagram](/background_1.png?raw=true "Background 1")

Let triangular matrix addition be defined as:
![Diagram](/background_2.png?raw=true "Background 2")

Let triangular matrix multiplication be defined as:
![Diagram](/background_3.png?raw=true "Background 3")

The multiplication operation is not commutative, and the first matrix, A, must
be of size less than or equal to B. The elements in the resultant matrix will
be determined by matching A with every triangle of size A within the matrix B.
For each of these matchings, multiply the overlapping elements of A and B and
then sum them. Each matching will have a corresponding place in the resulting
matrix.

## Description

### Input
Input sets will be given by an integer N, the number of matrices involved in the
operation. For the next N lines, the matrices will be specified. A matrix will
be specified by a string identifier K followed by an integer L, the length of
each side of the matrix. The next L lines will contain the values in the matrix,
each value separated by a space. The first line will only contain 1 value, the
second line will contain 2 values, the third line will contain three values, and
so on until the L th line. The first line with one value signifies the top point
of the triangle, and the L th line of L values signifies the bottom of the
triangle.

After the matrices are given, there will be an expression, with spaces between
the operators and symbols that needs to be evaluated. The expression will
contain matrices that are represented by their string identifiers. The end of
input will be given by N = 0.
### Output

## Sample
### Input
```
2
A 2
1
2 2
B 3
1
3 1
2 2 1
A B * A +
0
```

### Output
```
10
13 9
```
