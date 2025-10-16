public interface ImmutableList {
    public boolean equals(final Object other);
    public int length();
    public int sum(); // empty list sum is defined as 0
    public ImmutableList append(final ImmutableList other);
    public boolean contains(final int value);
    public String toString();
    public int hashCode();
} // ImmutableList

//to run with tests
//javac -cp .:hamcrest-2.2.jar:junit-4.13.jar -Xlint:all ImmutableList.java Cons.java Nil.java ImmutableListTest.java
//java -cp .:hamcrest-2.2.jar:junit-4.13.jar org.junit.runner.JUnitCore ImmutableListTest