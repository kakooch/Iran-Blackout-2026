package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.wm8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23356wm8 extends AbstractC25130zm8 {
    final transient int c;
    final transient int d;
    final /* synthetic */ AbstractC25130zm8 e;

    C23356wm8(AbstractC25130zm8 abstractC25130zm8, int i, int i2) {
        this.e = abstractC25130zm8;
        this.c = i;
        this.d = i2;
    }

    @Override // ir.nasim.AbstractC20893sm8
    final boolean C() {
        return true;
    }

    @Override // ir.nasim.AbstractC20893sm8
    final Object[] D() {
        return this.e.D();
    }

    @Override // ir.nasim.AbstractC25130zm8
    /* renamed from: E */
    public final AbstractC25130zm8 subList(int i, int i2) {
        AbstractC18511om8.c(i, i2, this.d);
        AbstractC25130zm8 abstractC25130zm8 = this.e;
        int i3 = this.c;
        return abstractC25130zm8.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC18511om8.a(i, this.d, "index");
        return this.e.get(i + this.c);
    }

    @Override // ir.nasim.AbstractC20893sm8
    final int j() {
        return this.e.r() + this.c + this.d;
    }

    @Override // ir.nasim.AbstractC20893sm8
    final int r() {
        return this.e.r() + this.c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC25130zm8, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
