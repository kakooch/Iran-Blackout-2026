package ir.nasim;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public final class RA1 implements II3 {
    private int a;

    public RA1(int i) {
        this.a = i;
        c(i);
    }

    private final void c(int i) {
        if (2 > i || i >= 8) {
            throw new IllegalArgumentException(("Invalid log level: " + i).toString());
        }
    }

    @Override // ir.nasim.II3
    public int a() {
        return this.a;
    }

    @Override // ir.nasim.II3
    public void b(String str, int i, String str2, Throwable th) {
        if (str2 != null) {
            Log.println(i, str, str2);
        }
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            Log.println(i, str, stringWriter.toString());
        }
    }

    public /* synthetic */ RA1(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 3 : i);
    }
}
