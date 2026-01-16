package ir.nasim;

/* renamed from: ir.nasim.wo2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23370wo2 {

    /* renamed from: ir.nasim.wo2$a */
    /* synthetic */ class a extends DB2 implements UA2 {
        public static final a a = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C24948zU0.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final C24948zU0 invoke(C24948zU0 c24948zU0) {
            AbstractC13042fc3.i(c24948zU0, "p0");
            return c24948zU0.g();
        }
    }

    /* renamed from: ir.nasim.wo2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final int a(C24948zU0 c24948zU0) {
            AbstractC13042fc3.i(c24948zU0, "it");
            return 0;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Integer.valueOf(a((C24948zU0) obj));
        }
    }

    public static final InterfaceC21331tU0 a(InterfaceC8507Wg4 interfaceC8507Wg4, C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "<this>");
        AbstractC13042fc3.i(c24948zU0, "classId");
        MU0 mu0B = b(interfaceC8507Wg4, c24948zU0);
        if (mu0B instanceof InterfaceC21331tU0) {
            return (InterfaceC21331tU0) mu0B;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.MU0 b(ir.nasim.InterfaceC8507Wg4 r10, ir.nasim.C24948zU0 r11) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23370wo2.b(ir.nasim.Wg4, ir.nasim.zU0):ir.nasim.MU0");
    }

    public static final InterfaceC21331tU0 c(InterfaceC8507Wg4 interfaceC8507Wg4, C24948zU0 c24948zU0, C21830uC4 c21830uC4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "<this>");
        AbstractC13042fc3.i(c24948zU0, "classId");
        AbstractC13042fc3.i(c21830uC4, "notFoundClasses");
        InterfaceC21331tU0 interfaceC21331tU0A = a(interfaceC8507Wg4, c24948zU0);
        return interfaceC21331tU0A != null ? interfaceC21331tU0A : c21830uC4.d(c24948zU0, AbstractC11342cq6.K(AbstractC11342cq6.C(AbstractC9962aq6.j(c24948zU0, a.a), b.e)));
    }

    public static final InterfaceC7722Sx7 d(InterfaceC8507Wg4 interfaceC8507Wg4, C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "<this>");
        AbstractC13042fc3.i(c24948zU0, "classId");
        MU0 mu0B = b(interfaceC8507Wg4, c24948zU0);
        if (mu0B instanceof InterfaceC7722Sx7) {
            return (InterfaceC7722Sx7) mu0B;
        }
        return null;
    }
}
