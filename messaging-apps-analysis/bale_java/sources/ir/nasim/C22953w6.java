package ir.nasim;

/* renamed from: ir.nasim.w6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22953w6 {
    private AbstractC22357v6 a;

    public final void a(Object obj, AbstractC15744k6 abstractC15744k6) {
        C19938rB7 c19938rB7;
        AbstractC22357v6 abstractC22357v6 = this.a;
        if (abstractC22357v6 != null) {
            abstractC22357v6.b(obj, abstractC15744k6);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            throw new IllegalStateException("Launcher has not been initialized".toString());
        }
    }

    public final void b(AbstractC22357v6 abstractC22357v6) {
        this.a = abstractC22357v6;
    }

    public final void c() {
        C19938rB7 c19938rB7;
        AbstractC22357v6 abstractC22357v6 = this.a;
        if (abstractC22357v6 != null) {
            abstractC22357v6.c();
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            throw new IllegalStateException("Launcher has not been initialized".toString());
        }
    }
}
