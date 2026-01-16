package ir.nasim;

import android.graphics.Bitmap;

/* renamed from: ir.nasim.gg0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13697gg0 implements InterfaceC13106fg0 {
    @Override // ir.nasim.InterfaceC13106fg0
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public void b() {
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public void a(int i) {
    }
}
