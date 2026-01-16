package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.sx5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20998sx5 {
    protected AbstractC20998sx5() {
    }

    public abstract AbstractC20998sx5 a(C9207Yy1 c9207Yy1);

    public byte[] b() {
        C12658ez1 c12658ez1 = new C12658ez1();
        try {
            c(c12658ez1);
        } catch (IOException e) {
            C19406qI3.d("ProtoObject", e);
        }
        return c12658ez1.c();
    }

    public abstract void c(C12658ez1 c12658ez1);

    protected AbstractC20998sx5(C9207Yy1 c9207Yy1) {
        a(c9207Yy1);
    }
}
