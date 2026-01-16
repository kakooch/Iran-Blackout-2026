package ir.nasim;

import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.ns, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17971ns extends AbstractC19912r90 {
    public C17971ns(List list) {
        super(b(list));
    }

    private static C24561yp3 a(C24561yp3 c24561yp3) {
        WJ2 wj2 = (WJ2) c24561yp3.b;
        WJ2 wj22 = (WJ2) c24561yp3.c;
        if (wj2 == null || wj22 == null || wj2.e().length == wj22.e().length) {
            return c24561yp3;
        }
        float[] fArrC = c(wj2.e(), wj22.e());
        return c24561yp3.b(wj2.b(fArrC), wj22.b(fArrC));
    }

    private static List b(List list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, a((C24561yp3) list.get(i)));
        }
        return list;
    }

    static float[] c(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // ir.nasim.AbstractC19912r90, ir.nasim.InterfaceC4104Ds
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public AbstractC24408ya0 j() {
        return new YJ2(this.a);
    }

    @Override // ir.nasim.AbstractC19912r90, ir.nasim.InterfaceC4104Ds
    public /* bridge */ /* synthetic */ List k() {
        return super.k();
    }

    @Override // ir.nasim.AbstractC19912r90
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
