package ir.nasim;

import android.view.Surface;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface O23 {

    public interface a {
        void a(O23 o23);
    }

    androidx.camera.core.f b();

    int c();

    void close();

    void d();

    int e();

    void f(a aVar, Executor executor);

    androidx.camera.core.f g();

    int getHeight();

    Surface getSurface();

    int getWidth();
}
