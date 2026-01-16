package ir.nasim;

/* renamed from: ir.nasim.um8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C22170um8 extends AbstractC19693qm8 {
    private final AbstractC25130zm8 c;

    C22170um8(AbstractC25130zm8 abstractC25130zm8, int i) {
        super(abstractC25130zm8.size(), i);
        this.c = abstractC25130zm8;
    }

    @Override // ir.nasim.AbstractC19693qm8
    protected final Object a(int i) {
        return this.c.get(i);
    }
}
