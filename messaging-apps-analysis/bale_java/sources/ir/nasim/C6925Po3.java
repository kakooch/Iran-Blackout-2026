package ir.nasim;

/* renamed from: ir.nasim.Po3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6925Po3 {
    private final C6691Oo3 a = null;
    private final AbstractC20124rW4 b;

    private C6925Po3(AbstractC20124rW4 abstractC20124rW4) {
        this.b = abstractC20124rW4;
    }

    public static C6925Po3 a(AbstractC20124rW4 abstractC20124rW4) {
        return new C6925Po3(abstractC20124rW4);
    }

    C6691Oo3 b() {
        C6691Oo3 c6691Oo3 = this.a;
        if (c6691Oo3 != null) {
            return c6691Oo3;
        }
        AbstractC20124rW4 abstractC20124rW4 = this.b;
        return abstractC20124rW4 instanceof C6282My3 ? ((C6282My3) abstractC20124rW4).b().d() : ((C22275ux5) com.google.crypto.tink.internal.b.c().n(this.b, C22275ux5.class)).d();
    }
}
