package ir.nasim;

/* loaded from: classes8.dex */
public interface HE0 extends InterfaceC20295rm1 {

    public static final class a {
        public static /* synthetic */ boolean a(HE0 he0, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return he0.F(th);
        }
    }

    Object C(Object obj, Object obj2, UA2 ua2);

    Object E(Throwable th);

    boolean F(Throwable th);

    void J(UA2 ua2);

    void N(Object obj, UA2 ua2);

    void O(AbstractC13778go1 abstractC13778go1, Object obj);

    void W(Object obj);

    boolean b();

    boolean p();
}
