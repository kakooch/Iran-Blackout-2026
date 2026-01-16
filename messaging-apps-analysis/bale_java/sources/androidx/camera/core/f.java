package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import ir.nasim.W13;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface f extends AutoCloseable {

    public interface a {
        int a();

        int b();

        ByteBuffer getBuffer();
    }

    int C();

    Image F1();

    a[] P0();

    @Override // java.lang.AutoCloseable
    void close();

    int getHeight();

    int getWidth();

    W13 u1();

    void y0(Rect rect);
}
