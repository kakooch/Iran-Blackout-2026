package ir.nasim;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.aH2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC9624aH2 {

    /* renamed from: ir.nasim.aH2$a */
    public interface a {
        void a(Bitmap bitmap);

        byte[] b(int i);

        Bitmap c(int i, int i2, Bitmap.Config config);

        int[] d(int i);

        void e(byte[] bArr);

        void f(int[] iArr);
    }

    void a();

    int b();

    void c(Bitmap.Config config);

    void clear();

    int d();

    void e();

    int f();

    int g();

    ByteBuffer getData();

    Bitmap getNextFrame();
}
