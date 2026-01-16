package ir.nasim;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class MM4 {
    public static MM4 h(int i, int i2, Rect rect, Size size, int i3, boolean z) {
        return i(i, i2, rect, size, i3, z, false);
    }

    public static MM4 i(int i, int i2, Rect rect, Size size, int i3, boolean z, boolean z2) {
        return new C20092rT(UUID.randomUUID(), i, i2, rect, size, i3, z, z2);
    }

    public abstract Rect a();

    public abstract int b();

    public abstract int c();

    public abstract Size d();

    public abstract int e();

    abstract UUID f();

    public abstract boolean g();

    public abstract boolean j();
}
