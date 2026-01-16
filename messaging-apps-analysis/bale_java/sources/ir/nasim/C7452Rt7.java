package ir.nasim;

/* renamed from: ir.nasim.Rt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7452Rt7 {
    public final int a;
    public final AO5[] b;
    public final InterfaceC13679ge2[] c;
    public final com.google.android.exoplayer2.K0 d;
    public final Object e;

    public C7452Rt7(AO5[] ao5Arr, InterfaceC13679ge2[] interfaceC13679ge2Arr, com.google.android.exoplayer2.K0 k0, Object obj) {
        this.b = ao5Arr;
        this.c = (InterfaceC13679ge2[]) interfaceC13679ge2Arr.clone();
        this.d = k0;
        this.e = obj;
        this.a = ao5Arr.length;
    }

    public boolean a(C7452Rt7 c7452Rt7) {
        if (c7452Rt7 == null || c7452Rt7.c.length != this.c.length) {
            return false;
        }
        for (int i = 0; i < this.c.length; i++) {
            if (!b(c7452Rt7, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(C7452Rt7 c7452Rt7, int i) {
        return c7452Rt7 != null && AbstractC9683aN7.c(this.b[i], c7452Rt7.b[i]) && AbstractC9683aN7.c(this.c[i], c7452Rt7.c[i]);
    }

    public boolean c(int i) {
        return this.b[i] != null;
    }
}
