package ir.nasim;

/* renamed from: ir.nasim.Ev3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC4369Ev3 {

    /* renamed from: ir.nasim.Ev3$a */
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

    static /* synthetic */ void b(InterfaceC4369Ev3 interfaceC4369Ev3, Object obj, UA2 ua2, Object obj2, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            ua2 = null;
        }
        if ((i & 4) != 0) {
            obj2 = null;
        }
        interfaceC4369Ev3.c(obj, ua2, obj2, interfaceC15796kB2);
    }

    static /* synthetic */ void h(InterfaceC4369Ev3 interfaceC4369Ev3, int i, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        UA2 ua23 = (i2 & 2) != 0 ? null : ua2;
        InterfaceC14603iB2 interfaceC14603iB22 = (i2 & 4) != 0 ? null : interfaceC14603iB2;
        if ((i2 & 8) != 0) {
            ua22 = a.e;
        }
        interfaceC4369Ev3.e(i, ua23, interfaceC14603iB22, ua22, interfaceC16978mB2);
    }

    void c(Object obj, UA2 ua2, Object obj2, InterfaceC15796kB2 interfaceC15796kB2);

    void e(int i, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2);
}
