package github.com.miguelfreelancer56577.java11course.strings;
/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 3: Working with Java Primitive Data Types and String APIs
Topic: Create and Manipulate Strings
Sub-Topic: Strings and the Compound Concatenation Operator
*/

public class StringCompoundConcat {
	public static void main(String[] args) {
		StringCompoundConcat.main2(args);
	}
    public static void main1(String[] args) {

        String helloString = "hello";
        String worldString = " world";

        // Use the compound concatenator on string literals
        String compoundString = "hello";
        compoundString += " world";
        System.out.println("compoundString = " + compoundString);

        // Use the compound concatenator on String objects
        String compoundString2 = helloString;
        compoundString2 += worldString;
        System.out.println("compoundString2 = " + compoundString2);

        // Use a null String on the left
        String nullString = null;
        nullString += helloString;
        System.out.println("nullString = " + nullString);

        // Use a null String on the right...
        nullString = null;
        String compoundStringWithNull = helloString;
        compoundStringWithNull += nullString;
        System.out.println("compoundStringWithNull = " + compoundStringWithNull);

        // String concatenation when right hand object is not a String, but is a CharSequence
        Object charSequenceObject = new StringBuilder("testing");
        String compoundString3 = "charSequenceObject ";
        compoundString3 += charSequenceObject;
        System.out.println("compoundString3 = " + compoundString3);

        // String concatenation when left hand object is not a String, but is a CharSequence
        charSequenceObject = new StringBuilder("testing");
        charSequenceObject += helloString;
        System.out.println("charSequenceObject = " + charSequenceObject);

        // String concatenation when right hand object is not a String,
// or CharSequence.  We created ImmutableString class in the last topic.
        Object someOtherObject = new ImmutableString();
        String compoundString4 = "object ";
        compoundString4 += someOtherObject;
        System.out.println("compoundString4 = " + compoundString4);

        // String concatenation when left hand object is not a String
        // We created ImmutableString class in the last topic.
        someOtherObject = new ImmutableString();
        someOtherObject += helloString;
        System.out.println("someOtherObject = " + someOtherObject);
        System.out.println("someOtherObject.toString() = " +
                someOtherObject.toString());

    }
    
    public static void main2(String[] args) {
        String helloString = "hello";
        String worldString = "world";

        // firstString will be “hello world”, concats 3 literals..
        String firstString = helloString + " " + worldString;
        System.out.println("firstString = " + firstString);

        Object nullObject = null;
        // secondString will be “null hello"
        String secondString = nullObject + " " + helloString;
        System.out.println("secondString = " + secondString);

        int i = 10;
        // thirdString will be “10 hello"
        String thirdString = i + " " + helloString;
        System.out.println("thirdString = " + thirdString);

        // concatenating to an object (not null)
        Object ourObject = new OurSimpleClass();

        // fourthString will be "hello Our Simple Class"
        String fourthString = helloString + " " + ourObject;
        System.out.println("fourthString = " + fourthString);

        int j = 10;
        String resultString = i + j + " = " + i + j;
        System.out.println("resultString is: " + resultString);

        String resultStringCorrectedForIntegerMath = i + j + " = " + (i + j);
        String resultStringCorrectedForStringConcat = "" + i + j + " = " + i + j;
        System.out.println("resultStringCorrectedForIntegerMath is: " +
                resultStringCorrectedForIntegerMath);
        System.out.println("resultStringCorrectedForStringConcat is: " +
                resultStringCorrectedForStringConcat);
    }
}

class OurSimpleClass {
    public String toString() {
        return "Our Simple Class";
    }
}

class ImmutableString{}