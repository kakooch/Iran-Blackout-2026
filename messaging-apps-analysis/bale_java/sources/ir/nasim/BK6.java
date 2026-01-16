package ir.nasim;

import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class BK6 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(long j) throws IOException {
        String strValueOf = String.valueOf(j);
        StringBuilder sb = new StringBuilder();
        int length = strValueOf.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strValueOf.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return AbstractC22039uZ6.B1(string, AbstractC23053wG5.i(String.valueOf(j).length(), 10));
    }
}
