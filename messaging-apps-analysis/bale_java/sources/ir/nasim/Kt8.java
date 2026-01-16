package ir.nasim;

import android.os.Trace;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class Kt8 implements Closeable {
    private static final InterfaceC9881ai8 b = Th8.b().a("nts.enable_tracing", true);
    private final boolean a;

    public Kt8(String str) {
        boolean z = AbstractC3993Df5.c() && ((Boolean) b.get()).booleanValue();
        this.a = z;
        if (z) {
            Trace.beginSection(str.length() > 127 ? str.substring(0, 127) : str);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.a) {
            Trace.endSection();
        }
    }
}
