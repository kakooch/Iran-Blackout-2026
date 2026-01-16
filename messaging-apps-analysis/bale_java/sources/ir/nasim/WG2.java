package ir.nasim;

import android.graphics.Bitmap;
import ir.nasim.InterfaceC9624aH2;

/* loaded from: classes2.dex */
public final class WG2 implements InterfaceC9624aH2.a {
    private final InterfaceC13106fg0 a;
    private final LJ b;

    public WG2(InterfaceC13106fg0 interfaceC13106fg0, LJ lj) {
        this.a = interfaceC13106fg0;
        this.b = lj;
    }

    @Override // ir.nasim.InterfaceC9624aH2.a
    public void a(Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // ir.nasim.InterfaceC9624aH2.a
    public byte[] b(int i) {
        LJ lj = this.b;
        return lj == null ? new byte[i] : (byte[]) lj.c(i, byte[].class);
    }

    @Override // ir.nasim.InterfaceC9624aH2.a
    public Bitmap c(int i, int i2, Bitmap.Config config) {
        return this.a.e(i, i2, config);
    }

    @Override // ir.nasim.InterfaceC9624aH2.a
    public int[] d(int i) {
        LJ lj = this.b;
        return lj == null ? new int[i] : (int[]) lj.c(i, int[].class);
    }

    @Override // ir.nasim.InterfaceC9624aH2.a
    public void e(byte[] bArr) {
        LJ lj = this.b;
        if (lj == null) {
            return;
        }
        lj.e(bArr);
    }

    @Override // ir.nasim.InterfaceC9624aH2.a
    public void f(int[] iArr) {
        LJ lj = this.b;
        if (lj == null) {
            return;
        }
        lj.e(iArr);
    }
}
