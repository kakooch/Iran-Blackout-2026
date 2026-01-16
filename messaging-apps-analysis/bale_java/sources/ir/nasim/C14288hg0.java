package ir.nasim;

import android.graphics.Bitmap;

/* renamed from: ir.nasim.hg0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14288hg0 implements DW5, B73 {
    private final Bitmap a;
    private final InterfaceC13106fg0 b;

    public C14288hg0(Bitmap bitmap, InterfaceC13106fg0 interfaceC13106fg0) {
        this.a = (Bitmap) AbstractC3322Aj5.e(bitmap, "Bitmap must not be null");
        this.b = (InterfaceC13106fg0) AbstractC3322Aj5.e(interfaceC13106fg0, "BitmapPool must not be null");
    }

    public static C14288hg0 d(Bitmap bitmap, InterfaceC13106fg0 interfaceC13106fg0) {
        if (bitmap == null) {
            return null;
        }
        return new C14288hg0(bitmap, interfaceC13106fg0);
    }

    @Override // ir.nasim.DW5
    public void a() {
        this.b.c(this.a);
    }

    @Override // ir.nasim.DW5
    public Class b() {
        return Bitmap.class;
    }

    @Override // ir.nasim.DW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.a;
    }

    @Override // ir.nasim.DW5
    public int f() {
        return YM7.i(this.a);
    }

    @Override // ir.nasim.B73
    public void initialize() {
        this.a.prepareToDraw();
    }
}
