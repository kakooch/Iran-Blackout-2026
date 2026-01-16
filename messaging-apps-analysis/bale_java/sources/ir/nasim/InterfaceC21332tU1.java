package ir.nasim;

import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import okio.FileSystem;
import okio.Path;

/* renamed from: ir.nasim.tU1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC21332tU1 {

    /* renamed from: ir.nasim.tU1$a */
    public static final class a {
        private Path a;
        private long f;
        private FileSystem b = FileSystem.SYSTEM;
        private double c = 0.02d;
        private long d = 10485760;
        private long e = 262144000;
        private AbstractC13778go1 g = C12366eV1.b();

        public final InterfaceC21332tU1 a() {
            long jO;
            Path path = this.a;
            if (path == null) {
                throw new IllegalStateException("directory == null".toString());
            }
            if (this.c > 0.0d) {
                try {
                    File file = path.toFile();
                    file.mkdir();
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    jO = AbstractC23053wG5.o((long) (this.c * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), this.d, this.e);
                } catch (Exception unused) {
                    jO = this.d;
                }
            } else {
                jO = this.f;
            }
            return new EI5(jO, path, this.b, this.g);
        }

        public final a b(File file) {
            return c(Path.Companion.get$default(Path.INSTANCE, file, false, 1, (Object) null));
        }

        public final a c(Path path) {
            this.a = path;
            return this;
        }

        public final a d(double d) {
            if (0.0d > d || d > 1.0d) {
                throw new IllegalArgumentException("size must be in the range [0.0, 1.0].".toString());
            }
            this.f = 0L;
            this.c = d;
            return this;
        }
    }

    /* renamed from: ir.nasim.tU1$b */
    public interface b {
        c a();

        void abort();

        Path getData();

        Path o();
    }

    /* renamed from: ir.nasim.tU1$c */
    public interface c extends Closeable {
        Path getData();

        b m1();

        Path o();
    }

    b a(String str);

    c b(String str);

    FileSystem c();
}
