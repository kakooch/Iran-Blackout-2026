package ir.nasim;

import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* renamed from: ir.nasim.Cg2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3765Cg2 extends ForwardingSink {
    private final UA2 a;
    private boolean b;

    public C3765Cg2(Sink sink, UA2 ua2) {
        super(sink);
        this.a = ua2;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            this.b = true;
            this.a.invoke(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        try {
            super.flush();
        } catch (IOException e) {
            this.b = true;
            this.a.invoke(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j) throws EOFException {
        if (this.b) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.b = true;
            this.a.invoke(e);
        }
    }
}
