package ir.nasim;

import android.content.res.Resources;

/* renamed from: ir.nasim.Rf0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7319Rf0 implements HW5 {
    private final HW5 a;
    private final Resources b;

    public C7319Rf0(Resources resources, HW5 hw5) {
        this.b = (Resources) AbstractC3322Aj5.d(resources);
        this.a = (HW5) AbstractC3322Aj5.d(hw5);
    }

    @Override // ir.nasim.HW5
    public DW5 a(Object obj, int i, int i2, HL4 hl4) {
        return C10009av3.d(this.b, this.a.a(obj, i, i2, hl4));
    }

    @Override // ir.nasim.HW5
    public boolean b(Object obj, HL4 hl4) {
        return this.a.b(obj, hl4);
    }
}
