package ir.nasim;

import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface G27 extends Closeable {

    public static abstract class a {
        public static a f(Size size, Rect rect, InterfaceC15221jD0 interfaceC15221jD0, int i, boolean z) {
            return new ET(size, rect, interfaceC15221jD0, i, z);
        }

        public abstract InterfaceC15221jD0 a();

        public abstract Rect b();

        public abstract Size c();

        public abstract boolean d();

        public abstract int e();
    }

    public static abstract class b {
        b() {
        }

        public static b c(int i, G27 g27) {
            return new FT(i, g27);
        }

        public abstract int a();

        public abstract G27 b();
    }

    int C();

    void Q(float[] fArr, float[] fArr2, boolean z);

    void V0(float[] fArr, float[] fArr2);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Size f();

    Surface g0(Executor executor, InterfaceC25043ze1 interfaceC25043ze1);
}
