package test2;

public abstract class te2 {
  protected int age;
  protected int year;

  public te2(int age, int year) {
    this.age = age;
    this.year = year;
  }

  public void function1() {
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
   * Gets the value of year.
   *
   * @return the value of year
   */
  public int getYear() {
    return this.year;
  }

  /**
   * Sets the year.
   *
   * @param year year
   */
  public void setYear(int year) {
    this.year = year;
  }
}
