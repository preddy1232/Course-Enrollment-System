//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    CourseEnrollmentTester is the tester file for the class CourseEnrollment
// Course:   CS 300 Fall 2023
//
// Author:   Prithvi Reddy
// Email:    pdreddy@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

/**
* This utility class implements unit tests to check the correctness of methods defined in the
* CourseEnrollment class of the Course Enrollment System program.
*
*/
public class CourseEnrollmentTester {

  
 /**
  * Ensures the correctness of the createEmptyList() method
  * 
  * @return true if the tester verifies a correct functionality and false if at least one bug is
  *         detected
  */
  public static boolean createEmptyListTester() {
   String errMsg = "Bug detected: createEmptyList did not return the expected array.";
   // Create an empty list String[][] whose capacity is 5
   String[][] actual = CourseEnrollment.createEmptyList(5);
   String[][] expected = new String[5][];
   // same as expected = new String[][]{null, null, null, null, null}
  
   if (!Arrays.deepEquals(actual, expected)) {
     // Recommended: descriptive error messages to help locating the bug
     System.out.println(errMsg);
     System.out.println("Expected: " + Arrays.deepToString(expected));
     System.out.println("Actual: " + Arrays.deepToString(actual));
     return false;
   }
  

   // Try a different capacity: create an empty list String[][] whose capacity is 8
   actual = CourseEnrollment.createEmptyList(8);
   expected = new String[8][];
   // same as expected = new String[][]{null, null, null, null, null}
  
   if (!Arrays.deepEquals(actual, expected)) {
     // descriptive error messages to help locating the bug
     System.out.println(errMsg);
     System.out.println("Expected: " + Arrays.deepToString(expected));
     System.out.println("Actual: " + Arrays.deepToString(actual));
     return false;
   }
  
   return true; // expected behavior verified, no bugs detected!
  }

 /**
  * Ensures the correctness of the indexOf(String, String[][]) method
  * 
  * Expected behavior to be verified:<BR>
  * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
  * (+) No changes made to the contents of the input list<BR>
  * 
  * @return true if the tester verifies a correct functionality and false if at least one bug is
  *         detected
  */
  public static boolean indexOfPerfectSizeArrayTester() {
   // TODO complete the implementation of this method
   String [][] list = {{"Bob", "bobjoe", "5495790236"}, {"Jim", "jimjames", "0345795438"}, 
       {"Josh", "joshjacobs", "2344775458"}, {"Prith", "prithjordan", null}, {"Jeff", "jeffbezos", "6345395478"},
       {"John", "johnjames", "5345539003"}};
   
   int firstIndex = CourseEnrollment.indexOf(list[0][2], list);
   System.out.println(firstIndex); // (1) edge case: match found at index 0
   int lastIndex = CourseEnrollment.indexOf(list[list.length - 1][2], list);
   System.out.println(lastIndex); // (2) edge case: match found at index length-1 considering a full input array
   int midIndex = CourseEnrollment.indexOf(list[3][2], list);
   System.out.println(midIndex); // (3) normal case: match found at the middle of the input array
   int noIndex = CourseEnrollment.indexOf("2355775458", list);
   System.out.println(noIndex); // (4) normal case: no match found, -1 should be returned
   if(noIndex == -1 && lastIndex != -1 && midIndex != -1 && firstIndex != -1)
   {
     return true;
   }
  
   return false; // default return statement added to resolve compiler errors
  }

 /**
  * Ensures the correctness of the indexOf(String, String[][], int) method
  * Same method as the previous one, but now for an oversize array
  * Expected behavior to be verified:<BR>
  * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
  * (+) No changes made to the contents of the input list<BR>
  * 
  * @return true if the tester verifies a correct functionality and false if at least one bug is
  *         detected
  */
  public static boolean indexOfOversizeSizeArrayTester() {
   // TODO complete the implementation of this method
    String [][] list = {{"Bob", "bobjoe", "5495790236"}, 
        {"Jim", "jimjames", "0345795438"}, 
        {"Josh", "joshjacobs", "2344775458"}, 
        {"Prith", "prithjordan", "0345691428"}, 
        {"Jeff", "jeffbezos", "6345395478"},
        {"John", "johnjames", "5345539003"}};
    int size = 5;
    int firstIndex = CourseEnrollment.indexOf(list[0][2], list, size);
    System.out.println(firstIndex); // (1) edge case: match found at index 0
    int lastIndex = CourseEnrollment.indexOf(list[size - 1][2], list, size);
    System.out.println(lastIndex); // (2) edge case: match found at index length-1 considering a full input array
    int midIndex = CourseEnrollment.indexOf("2344775458", list, size);
    System.out.println(midIndex);// (3) normal case: match found at the middle of the input array
    int noIndex = CourseEnrollment.indexOf("2355775458", list, size);
    System.out.println(noIndex); // (4) normal case: no match found, -1 should be returned
    if(noIndex == -1 && lastIndex != -1 && midIndex != -1 && firstIndex != -1)
    {
      return true;
    }
   return false; // default return statement added to resolve compiler errors
  }
  
  // Helper method to compare actual and expected oversize roster arrays
 /**
  * Helper method defined to help verifying the actual roster and waitlist arrays with respect to
  * the expected ones
  * 
  * @param methodName     name of the method being tested
  * @param actualRoster   actual roster
  * @param expectedRoster expected roster
  * @param actualSize     actual roster size
  * @param expectedSize   expected roster size
  * 
  * @return true if expected behavior satisfied, false if any bug is detected
  */
  private static boolean assessDeepEqualOversizeArraysHelper(String methodName,
     String[][] actualRoster, String[][] expectedRoster, int actualSize, int expectedSize) {
   // error messages
   String errMsgBadSize =
       "Bug detected: Your " + methodName + "() method did not return the expected size.";
   String errMsgBadRoster = "Bug detected: The contents of the roster array was not as expected "
       + "after " + "your " + methodName + "() method returned.";
  
   // check roster size
   if (actualSize != expectedSize) {
     System.out.println(errMsgBadSize);
     System.out.println("Expected size: " + expectedSize + ". Actual size: " + actualSize);
     return false;
   }
  
   // compare roster contents
   if (!Arrays.deepEquals(actualRoster, expectedRoster)) {
     System.out.println(errMsgBadRoster);
     System.out.println("Expected Roster: " + Arrays.deepToString(expectedRoster));
     System.out.println("Actual Roster: " + Arrays.deepToString(actualRoster));
     return false;
   }
  
   return true; // expected behavior satisfied, no bugs detected
  }
  
  // Helper method to compare actual and expected oversize roster arrays
  /**
  * Helper method defined to help verifying the actual roster and waitlist arrays with respect to
  * the expected ones
  * 
  * @param methodName       name of the method being tested
  * @param actualWaitlist   actual waitlist
  * @param expectedWaitlist expected waitlist
  * 
  * @return true if expected behavior satisfied, false if any bug is detected
  */
  private static boolean assessDeepEqualPerfectSizeArraysHelper(String methodName,
     String[][] actualWaitlist, String[][] expectedWaitlist) {
   // error message
   String errMsgBadWaitlist =
       "Bug detected: The contents of the waitlist array was not as expected after " + "your "
           + methodName + "() method returned";
  
   // compare waitlist contents
   if (!Arrays.deepEquals(actualWaitlist, expectedWaitlist)) {
     System.out.println(errMsgBadWaitlist);
     System.out.println("Expected Waitlist: " + Arrays.deepToString(expectedWaitlist));
     System.out.println("Actual Waitlist: " + Arrays.deepToString(actualWaitlist));
     return false;
   }
   return true; // expected behavior satisfied, no bugs detected
  }
  
 /**
  * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
  * record in the course. The course did not reach its capacity and the course pre-requisites are
  * satisfied.
  * 
  * Expected behavior to be verified:<BR>
  * (+) Student record correctly added to the end of the roster array<BR>
  * (+) No changes made to the waitlist array<BR>
  * (+) Correct size returned
  * 
  * @return true if the tester verifies a correct functionality and false if at least one bug is
  *         detected
  */
  public static boolean enrollOneStudentTester() {
   // You do not need to make changes to this method
   // create a waitlist array. We can consider a normal case: not-empty and not-full waitlist)
   String[][] actualWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
       {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};
  
   // No changes to the waitlist are expected
   String[][] expectedWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
       {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};
  
   // This method considers three test cases:
   // (1) edge case: adding to an empty roster
   // (2) normal case: adding to the end of a non-empty roster
   // (3) edge case: after adding the student record, the roster is full
  
   // To avoid code redundancy, we defined a helper method named verifyCorrectBehaviorHelper() to
   // help verifying the expected behavior for each of the above test cases.
  
   // --------------------------------------------------------------------------
   // (1) edge case Enroll a student considering an empty roster oversize array
   // enroll one student satisfying prerequisites
   // Create an empty roster
   String[][] actualRoster = new String[3][];
   int actualSize = 0;
  
   // Try to enroll George
   actualSize = CourseEnrollment.enrollOneStudent("George", "george@wisc.edu", "9780563421", true,
       actualRoster, actualSize, actualWaitlist);
   // expected roster and its size
   String[][] expectedRoster =
       new String[][] {{"George", "george@wisc.edu", "9780563421"}, null, null};
   int expectedSize = 1;
   boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
       expectedRoster, actualSize, expectedSize);
  
   // --------------------------------------------------------------------------
   // (2) normal case: adding to the end of a non-empty roster
   actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
       {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};
   actualSize = 2;
  
   // Try to enroll Matt
   actualSize = CourseEnrollment.enrollOneStudent("Matt", "matt@wisc.edu", "9745632180", true,
       actualRoster, actualSize, actualWaitlist);
   // expected roster and its size
   expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
       {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
   expectedSize = 3;
   boolean resultCase2 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
       expectedRoster, actualSize, expectedSize);
  
   // --------------------------------------------------------------------------
   // (3) edge case: after adding the student record, the roster is full
   actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
       {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
   actualSize = 3;
  
   // Try to enroll Lisa
   actualSize = CourseEnrollment.enrollOneStudent("Lisa", "lisa@wisc.edu", "9784563211", true,
       actualRoster, actualSize, actualWaitlist);
   // expected roster and its size
   expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
       {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"},
       {"Lisa", "lisa@wisc.edu", "9784563211"}};
   expectedSize = 4;
   boolean resultCase3 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
       expectedRoster, actualSize, expectedSize);
  
   // Verify that all the above enrollOneStudent() method calls did not make any changes to the
   // contents of the input waitlist
   boolean assessWaitlistContents = assessDeepEqualPerfectSizeArraysHelper("enrollOneStudent",
       actualWaitlist, expectedWaitlist);
  
   // test passes only if each of the defined test scenarios passes
   return resultCase1 && resultCase2 && resultCase3 && assessWaitlistContents;
  }
  
  
 /**
  * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
  * record in the course. The student record is in the waitlist, course pre-requisites are
  * satisfied, and there is room in the roster to enroll the student in the course.
  * 
  * Expected behavior to be verified:<BR>
  * (+) Student record correctly added to the end of the roster array<BR>
  * (+) Matching student correctly record removed off the waitlist<BR>
  * (+) Correct size returned
  * 
  * @return true if the tester verifies a correct functionality and false if at least one bug is
  *         detected
  */
  public static boolean enrollOneStudentMoveFromWaitlistTester() {
   // TODO complete the implementation of this method
    String [][] waitlist = {{"Bob", "bobjoe", "5495790236"}, {"Jim", "jimjames", "0345795438"}, 
        {"Josh", "joshjacobs", "2344775458"}, {"John", "johnjames", "5345539003"}, null, null};
    String[][] actualRoster = new String[3][];
    actualRoster = new String[][] {{"Prith", "prithjordan", "0215795476"},
      {"Jeff", "jeffbezos", "6345395478"}, null, null};
      int actualSize = 2;
    
    actualSize = CourseEnrollment.enrollOneStudent("Bob", "bobjoe", "5495790236", true,
        actualRoster, actualSize, waitlist);
    String[][] expectedRoster =
        new String[][] {{"Bob", "bobjoe", "5495790236"}, null, null};
    expectedRoster = new String[][] {{"Prith", "prithjordan", "0215795476"},
      {"Jeff", "jeffbezos", "6345395478"}, {"Bob", "bobjoe", "5495790236"}, null};
    int expectedSize = 3;
    boolean resultCase2 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
      expectedRoster, actualSize, expectedSize);
    boolean resultCase3 = true;
    for(int i = 0; i < waitlist.length; i++)
    {
      if(waitlist[i] != null && ("5495790236").equals(waitlist[i][2]))
      {
        resultCase3 = false;
      }
    }
   return resultCase2 && resultCase3; // default return statement added to resolve compiler errors
  }
  
 /**
  * Ensures the correctness of the dropCourse() method when called to remove an existing student
  * record from a course enrollment roster of the class.
  * 
  * Expected behavior to be verified:<BR>
  * (+) Matching student record correctly removed off the input roster array. Order of precedence
  * of the student records must be preserved.<BR>
  * (+) Correct size returned
  * 
  * @return true if the tester verifies a correct functionality and false if at least one bug is
  *         detected
  */
  public static boolean successfulDropCourseTester() {
   // TODO complete the implementation of this method
    String [][] list = {{"Bob", "bobjoe", "5495790236"}, {"Jim", "jimjames", "0345795438"}, 
        {"Josh", "joshjacobs", "2344775458"}, {"Prith", "prithjordan", "0215795476"}, 
        {"Jeff", "jeffbezos", "6345395478"},
        {"John", "johnjames", "5345539003"}};
    int size = 4;
    int length = CourseEnrollment.dropCourse("0345795438", list, size);
    if(length == (size - 1))//called the dropCourse method and see if the size went down by one
    {
      return true;//return correct boolean
    }
    else
      return false;//default return statement
  }
  
 /**
  * Ensures the correctness of the dropCourse() method when called to remove a non-existing student
  * record from a course enrollment roster of the class.
  * 
  * Expected behavior to be verified:<BR>
  * (+) No changes made to the input roster array: Fail to find a matching student record .<BR>
  * (+) Correct size returned (same size passed as input to the method)
  * 
  * @return true if the tester verifies a correct functionality and false if at least one bug is
  *         detected
  */
  public static boolean unsuccessfulDropCourseTester() {
   // TODO complete the implementation of this method
    String [][] list = {{"Bob", "bobjoe", "5495790236"}, {"Jim", "jimjames", "0345795438"}, 
        {"Josh", "joshjacobs", "2344775458"}, 
        {"Prith", "prithjordan", "0215795476"}, {"Jeff", "jeffbezos", "6345395478"},
        {"John", "johnjames", "5345539003"}};
    int size = 4;
    int length = CourseEnrollment.dropCourse("1345795436", list, size);
    if(length == size)//called the dropCourse method and if size is same the course is not dropped
    {
      return true;
    }
    else
      return false;
  }
  
  
 /**
  * Runs all the tester methods defined in this class.
  * 
  * @return true if no bugs are detected.
  */
  public static boolean runAllTests() {
   boolean createEmptyListTesterResult = createEmptyListTester();
   System.out
       .println("createEmptyListTester: " + (createEmptyListTesterResult ? "Pass" : "Failed!"));
  
   System.out.println("-----------------------------------------------");
   boolean indexOfOversizeSizeArrayTesterResult = indexOfOversizeSizeArrayTester();
   System.out.println("indexOfOversizeSizeArrayTester: "
       + (indexOfOversizeSizeArrayTesterResult ? "Pass" : "Failed!"));
  
   System.out.println("-----------------------------------------------");
   boolean indexOfPerfectSizeArrayTesterResult = indexOfPerfectSizeArrayTester();
   System.out.println("indexOfPerfectSizeArrayTester: "
       + (indexOfPerfectSizeArrayTesterResult ? "Pass" : "Failed!"));
  
   System.out.println("-----------------------------------------------");
   boolean enrollOneStudentTesterResult = enrollOneStudentTester();
   System.out
       .println("enrollOneStudentTester: " + (enrollOneStudentTesterResult ? "Pass" : "Failed!"));
  
   System.out.println("-----------------------------------------------");
   boolean enrollOneStudentMoveFromWaitlistTesterResult = enrollOneStudentMoveFromWaitlistTester();
   System.out.println("enrollOneStudentMoveFromWaitlistTester: "
       + (enrollOneStudentMoveFromWaitlistTesterResult ? "Pass" : "Failed!"));
  
   System.out.println("-----------------------------------------------");
   boolean successfulDropCourseTesterResult = successfulDropCourseTester();
   System.out.println(
       "successfulDropCourseTester: " + (successfulDropCourseTesterResult ? "Pass" : "Failed!"));
  
   System.out.println("-----------------------------------------------");
   boolean unsuccessfulDropCourseTesterResult = unsuccessfulDropCourseTester();
   System.out.println("unsuccessfulDropCourseTester: "
       + (unsuccessfulDropCourseTesterResult ? "Pass" : "Failed!"));
  
   System.out.println("-----------------------------------------------");
  
   return createEmptyListTesterResult && indexOfOversizeSizeArrayTesterResult
       && indexOfPerfectSizeArrayTesterResult && enrollOneStudentTesterResult
       && enrollOneStudentMoveFromWaitlistTesterResult && successfulDropCourseTesterResult
       && unsuccessfulDropCourseTesterResult;
  }
  
  /**
    * Main method to run this tester class.
    * 
    * @param args list of input arguments if any
    */
  public static void main(String[] args) {
     System.out.println("-----------------------------------------------");
     System.out.println("runAllTests: " + (runAllTests() ? "Pass" : "Failed!"));
    }
    
    }
    
