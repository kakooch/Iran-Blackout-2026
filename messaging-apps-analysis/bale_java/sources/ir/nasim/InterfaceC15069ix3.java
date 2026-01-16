package ir.nasim;

/* renamed from: ir.nasim.ix3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC15069ix3 {

    /* renamed from: ir.nasim.ix3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final Void a(int i) {
            return null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static /* synthetic */ void d(InterfaceC15069ix3 interfaceC15069ix3, Object obj, Object obj2, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        interfaceC15069ix3.f(obj, obj2, interfaceC15796kB2);
    }

    static /* synthetic */ void g(InterfaceC15069ix3 interfaceC15069ix3, int i, UA2 ua2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i2 & 2) != 0) {
            ua2 = null;
        }
        if ((i2 & 4) != 0) {
            ua22 = a.e;
        }
        interfaceC15069ix3.a(i, ua2, ua22, interfaceC16978mB2);
    }

    void a(int i, UA2 ua2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2);

    void f(Object obj, Object obj2, InterfaceC15796kB2 interfaceC15796kB2);
}
