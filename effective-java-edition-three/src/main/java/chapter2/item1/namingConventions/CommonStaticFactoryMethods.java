package chapter2.item1.namingConventions;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;

enum Rank {
    JACK, QUEEN, KING
}

enum Complaint {
    A, B, C
}

enum Color {
    RED, YELLOW, GREEN, BLUE, BLACK, WHITE
}

public class CommonStaticFactoryMethods {
    public static void main(String[] args) throws IOException {
        System.out.println("--- 1. from() ---");
        Instant inst = Instant.now();
        Date date = Date.from(inst);
        System.out.println("Date.from(inst) -> " + date);

        System.out.println("\n--- 2. of() ---");
        Set<Rank> faceCards = EnumSet.of(Rank.JACK, Rank.QUEEN, Rank.KING);
        System.out.println("EnumSet.of(...) -> " + faceCards);

        System.out.println("\n--- 3. valueOf() ---");
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
        System.out.println("BigInteger.valueOf(...) -> " + prime);

        System.out.println("\n--- 4. getInstance() ---");
        StackWalkerDemo stackWalkerDemo = new StackWalkerDemo();
        stackWalkerDemo.methodThree();

        System.out.println("\n--- 5. newInstance() ---");
        int arrayLen = 3;
        Object newArray = Array.newInstance(String.class, arrayLen);
        System.out.println("Array.newInstance(...) -> " + newArray.getClass());

        System.out.println("\n--- 6. type() / list() ---");
        Vector<Complaint> v = new Vector<>();
        v.add(Complaint.A);
        v.add(Complaint.B);
        v.add(Complaint.C);

        Enumeration<Complaint> legacyLitany = v.elements();
        List<Complaint> litany = Collections.list(legacyLitany);
        System.out.println("Collections.list(...) -> " + litany);

        System.out.println("\n--- 7. noneOf() ---");
        EnumSet<Color> enumSet = EnumSet.noneOf(Color.class);
        System.out.println("EnumSet.noneOf(Color.class) -> " + enumSet.getClass());
    }
}

class StackWalkerDemo {
    public void methodOne() {
        this.methodTwo();
    }

    public void methodTwo() {
        this.methodThree();
    }

    public void methodThree() {
        Class<?> callerClass = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .getCallerClass();
        System.out.println("StackWalker.getInstance(...) -> " + callerClass);
    }
}
