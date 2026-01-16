package ir.nasim;

/* renamed from: ir.nasim.p93, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18733p93 {

    /* renamed from: ir.nasim.p93$a */
    class a extends AbstractC18733p93 {
        a() {
        }

        @Override // ir.nasim.AbstractC18733p93
        public AbstractC18142o93 a(String str) {
            return null;
        }
    }

    public static AbstractC18733p93 c() {
        return new a();
    }

    public abstract AbstractC18142o93 a(String str);

    public final AbstractC18142o93 b(String str) {
        AbstractC18142o93 abstractC18142o93A = a(str);
        return abstractC18142o93A == null ? AbstractC18142o93.a(str) : abstractC18142o93A;
    }
}
