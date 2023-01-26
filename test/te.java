package test;

import java.util.Objects;

public class te {
  private int age;
  private char c;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    te te = (te) o;
    return age == te.age && c == te.c;
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, c);
  }

  public te(int age, char c) {
    this.age = age;
    this.c = c;
  }

  /**
   * Gets the value of age.
   *
   * @return the value of age
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Sets the age.
   *
   * @param age age
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Gets the value of c.
   *
   * @return the value of c
   */
  public char getC() {
    return this.c;
  }

  /**
   * Sets the c.
   *
   * @param c c
   */
  public void setC(char c) {
    this.c = c;
  }
}
