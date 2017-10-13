package com.TestNg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestCase {
  @Test(description="Testing Description and Priority")
  public void sest(){
	  System.out.println("A");
  }
  @BeforeMethod
  public void best() {
	  System.out.println("2nd before method");
  }
  @BeforeTest
  public void dest() {
	  System.out.println("1st before test");
  }
  @BeforeTest
  public void eest() {
	  System.out.println("2nd before test");
  }
  @BeforeMethod
  public void aest() {
	  System.out.println("1st Before Method");
  }
  @Test(description="Testing Description and Priority")
  public void test() {
	  System.out.println("D");

  }
 
} 
