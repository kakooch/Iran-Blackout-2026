package ir.nasim;

/* loaded from: classes3.dex */
public abstract class Y20 {
    private static final C11322co6 a = new C11322co6("IsBalloon", a.e);

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19938rB7 invoke(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            AbstractC13042fc3.i(c19938rB72, "<anonymous parameter 1>");
            throw new IllegalStateException("merge function called on unmergeable property IsBalloon. A dialog should not be a child of a clickable/focusable node.");
        }
    }

    public static final void a(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "<this>");
        interfaceC11943do6.f(a, C19938rB7.a);
    }
}
