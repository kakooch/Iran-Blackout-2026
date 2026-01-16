package ir.nasim;

import ir.nasim.AbstractC10086b33;
import java.io.Closeable;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* renamed from: ir.nasim.ul2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22154ul2 extends AbstractC10086b33 {
    private final Path a;
    private final FileSystem b;
    private final String c;
    private final Closeable d;
    private final AbstractC10086b33.a e;
    private boolean f;
    private BufferedSource g;

    public C22154ul2(Path path, FileSystem fileSystem, String str, Closeable closeable, AbstractC10086b33.a aVar) {
        super(null);
        this.a = path;
        this.b = fileSystem;
        this.c = str;
        this.d = closeable;
        this.e = aVar;
    }

    private final void d() {
        if (!(!this.f)) {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // ir.nasim.AbstractC10086b33
    public synchronized Path a() {
        d();
        return this.a;
    }

    @Override // ir.nasim.AbstractC10086b33
    public AbstractC10086b33.a b() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC10086b33
    public synchronized BufferedSource c() {
        d();
        BufferedSource bufferedSource = this.g;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(g().source(this.a));
        this.g = bufferedSourceBuffer;
        return bufferedSourceBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.f = true;
            BufferedSource bufferedSource = this.g;
            if (bufferedSource != null) {
                AbstractC18638p.d(bufferedSource);
            }
            Closeable closeable = this.d;
            if (closeable != null) {
                AbstractC18638p.d(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String e() {
        return this.c;
    }

    public FileSystem g() {
        return this.b;
    }
}
