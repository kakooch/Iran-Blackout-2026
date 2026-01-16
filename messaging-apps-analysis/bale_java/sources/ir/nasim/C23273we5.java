package ir.nasim;

import ir.nasim.C8243Vd1;

/* renamed from: ir.nasim.we5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23273we5 extends DY7 {
    @Override // ir.nasim.DY7
    public void B1(int i, int i2, int i3, int i4) {
        int iY1 = y1() + z1();
        int iA1 = A1() + x1();
        if (this.W0 > 0) {
            iY1 += this.V0[0].X();
            iA1 += this.V0[0].z();
        }
        int iMax = Math.max(L(), iY1);
        int iMax2 = Math.max(K(), iA1);
        if (i != 1073741824) {
            i2 = i == Integer.MIN_VALUE ? Math.min(iMax, i2) : i == 0 ? iMax : 0;
        }
        if (i3 != 1073741824) {
            i4 = i3 == Integer.MIN_VALUE ? Math.min(iMax2, i4) : i3 == 0 ? iMax2 : 0;
        }
        G1(i2, i4);
        j1(i2);
        K0(i4);
        F1(this.W0 > 0);
    }

    @Override // ir.nasim.C16651le1
    public void g(C8963Xz3 c8963Xz3, boolean z) {
        super.g(c8963Xz3, z);
        if (this.W0 > 0) {
            C16651le1 c16651le1 = this.V0[0];
            c16651le1.v0();
            C8243Vd1.b bVar = C8243Vd1.b.LEFT;
            c16651le1.j(bVar, this, bVar);
            C8243Vd1.b bVar2 = C8243Vd1.b.RIGHT;
            c16651le1.j(bVar2, this, bVar2);
            C8243Vd1.b bVar3 = C8243Vd1.b.TOP;
            c16651le1.j(bVar3, this, bVar3);
            C8243Vd1.b bVar4 = C8243Vd1.b.BOTTOM;
            c16651le1.j(bVar4, this, bVar4);
        }
    }
}
