package ir.nasim;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class YV0 {
    public static final void a(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC16632lc2.a(th, th2);
            }
        }
    }
}
