package tests;

import org.testng.annotations.Test;

public class test1 extends baseTest {

  @Test
  public void verifyAttendance1() {

    System.out.println("test1 foe parallel 1");

  }

  @Test
  public void verifyAttendance4() {

    System.out.println(" test1 foe parallel 4");

  }

  @Test
  public void verifyAttendance2() {

    System.out.println("test1 foe parallel 2");

  }

  @Test
  public void verifyAttendance3() {

    System.out.println("test1 foe parallel 3");

  }

}
