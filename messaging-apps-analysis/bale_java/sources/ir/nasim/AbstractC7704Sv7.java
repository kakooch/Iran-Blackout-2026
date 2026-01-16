package ir.nasim;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: ir.nasim.Sv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC7704Sv7 implements Closeable {

    /* renamed from: ir.nasim.Sv7$a */
    interface a {
        AbstractC7704Sv7 a();

        a b(Context context);
    }

    AbstractC7704Sv7() {
    }

    abstract InterfaceC13031fb2 a();

    abstract C7470Rv7 b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
