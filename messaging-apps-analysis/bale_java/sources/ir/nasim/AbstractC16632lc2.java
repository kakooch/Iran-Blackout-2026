package ir.nasim;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.lc2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16632lc2 {
    public static void a(Throwable th, Throwable th2) {
        AbstractC13042fc3.i(th, "<this>");
        AbstractC13042fc3.i(th2, "exception");
        if (th != th2) {
            AbstractC13101ff5.a.a(th, th2);
        }
    }

    public static String b(Throwable th) {
        AbstractC13042fc3.i(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }
}
