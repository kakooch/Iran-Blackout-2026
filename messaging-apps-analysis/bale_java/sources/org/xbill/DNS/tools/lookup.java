package org.xbill.DNS.tools;

import android.gov.nist.core.Separators;
import java.io.PrintStream;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

/* loaded from: classes8.dex */
public class lookup {
    public static void main(String[] strArr) {
        int iValue = 1;
        int i = 0;
        if (strArr.length > 2 && strArr[0].equals("-t")) {
            iValue = Type.value(strArr[1]);
            if (iValue < 0) {
                throw new IllegalArgumentException("invalid type");
            }
            i = 2;
        }
        while (i < strArr.length) {
            Lookup lookup = new Lookup(strArr[i], iValue);
            lookup.run();
            printAnswer(strArr[i], lookup);
            i++;
        }
    }

    public static void printAnswer(String str, Lookup lookup) {
        PrintStream printStream = System.out;
        printStream.print(str + ":");
        if (lookup.getResult() != 0) {
            printStream.print(Separators.SP + lookup.getErrorString());
        }
        printStream.println();
        Name[] aliases = lookup.getAliases();
        if (aliases.length > 0) {
            printStream.print("# aliases: ");
            for (int i = 0; i < aliases.length; i++) {
                PrintStream printStream2 = System.out;
                printStream2.print(aliases[i]);
                if (i < aliases.length - 1) {
                    printStream2.print(Separators.SP);
                }
            }
            System.out.println();
        }
        if (lookup.getResult() == 0) {
            for (Record record : lookup.getAnswers()) {
                System.out.println(record);
            }
        }
    }
}
