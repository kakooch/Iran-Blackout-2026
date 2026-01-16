package ir.nasim;

import ir.nasim.AbstractC10086b33;
import java.io.File;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* loaded from: classes2.dex */
public final class LH6 extends AbstractC10086b33 {
    private final AbstractC10086b33.a a;
    private boolean b;
    private BufferedSource c;
    private SA2 d;
    private Path e;

    public LH6(BufferedSource bufferedSource, SA2 sa2, AbstractC10086b33.a aVar) {
        super(null);
        this.a = aVar;
        this.c = bufferedSource;
        this.d = sa2;
    }

    private final void d() {
        if (!(!this.b)) {
            throw new IllegalStateException("closed".toString());
        }
    }

    private final Path e() {
        SA2 sa2 = this.d;
        AbstractC13042fc3.f(sa2);
        File file = (File) sa2.invoke();
        if (file.isDirectory()) {
            return Path.Companion.get$default(Path.INSTANCE, File.createTempFile("tmp", null, file), false, 1, (Object) null);
        }
        throw new IllegalStateException("cacheDirectory must be a directory.".toString());
    }

    @Override // ir.nasim.AbstractC10086b33
    public synchronized Path a() {
        Throwable th;
        Long lValueOf;
        try {
            d();
            Path path = this.e;
            if (path != null) {
                return path;
            }
            Path pathE = e();
            BufferedSink bufferedSinkBuffer = Okio.buffer(g().sink(pathE, false));
            try {
                BufferedSource bufferedSource = this.c;
                AbstractC13042fc3.f(bufferedSource);
                lValueOf = Long.valueOf(bufferedSinkBuffer.writeAll(bufferedSource));
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        AbstractC16632lc2.a(th3, th4);
                    }
                }
                th = th3;
                lValueOf = null;
            }
            if (th != null) {
                throw th;
            }
            AbstractC13042fc3.f(lValueOf);
            this.c = null;
            this.e = pathE;
            this.d = null;
            return pathE;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    @Override // ir.nasim.AbstractC10086b33
    public AbstractC10086b33.a b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC10086b33
    public synchronized BufferedSource c() {
        d();
        BufferedSource bufferedSource = this.c;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        FileSystem fileSystemG = g();
        Path path = this.e;
        AbstractC13042fc3.f(path);
        BufferedSource bufferedSourceBuffer = Okio.buffer(fileSystemG.source(path));
        this.c = bufferedSourceBuffer;
        return bufferedSourceBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.b = true;
            BufferedSource bufferedSource = this.c;
            if (bufferedSource != null) {
                AbstractC18638p.d(bufferedSource);
            }
            Path path = this.e;
            if (path != null) {
                g().delete(path);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public FileSystem g() {
        return FileSystem.SYSTEM;
    }
}
