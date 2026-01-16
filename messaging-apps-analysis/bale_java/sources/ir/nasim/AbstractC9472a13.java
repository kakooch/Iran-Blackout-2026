package ir.nasim;

/* renamed from: ir.nasim.a13, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9472a13 {
    public static final Y03 a(int i, int i2, int i3, boolean z, AbstractC9775aY0 abstractC9775aY0) {
        return AbstractC19123pp.a(i, i2, i3, z, abstractC9775aY0);
    }

    public static /* synthetic */ Y03 b(int i, int i2, int i3, boolean z, AbstractC9775aY0 abstractC9775aY0, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = Z03.b.b();
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            abstractC9775aY0 = LY0.a.G();
        }
        return a(i, i2, i3, z, abstractC9775aY0);
    }
}
