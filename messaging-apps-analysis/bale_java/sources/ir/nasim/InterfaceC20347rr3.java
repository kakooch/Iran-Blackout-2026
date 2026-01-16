package ir.nasim;

/* renamed from: ir.nasim.rr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC20347rr3 extends InterfaceC24581yr3 {

    /* renamed from: ir.nasim.rr3$a */
    public static abstract class a {

        /* renamed from: ir.nasim.rr3$a$a, reason: collision with other inner class name */
        public static final class C1530a extends a {
            private final InterfaceC22805vr3 a;
            private final byte[] b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1530a(InterfaceC22805vr3 interfaceC22805vr3, byte[] bArr) {
                super(null);
                AbstractC13042fc3.i(interfaceC22805vr3, "kotlinJvmBinaryClass");
                this.a = interfaceC22805vr3;
                this.b = bArr;
            }

            public final InterfaceC22805vr3 b() {
                return this.a;
            }

            public /* synthetic */ C1530a(InterfaceC22805vr3 interfaceC22805vr3, byte[] bArr, int i, ED1 ed1) {
                this(interfaceC22805vr3, (i & 2) != 0 ? null : bArr);
            }
        }

        private a() {
        }

        public final InterfaceC22805vr3 a() {
            C1530a c1530a = this instanceof C1530a ? (C1530a) this : null;
            if (c1530a == null) {
                return null;
            }
            return c1530a.b();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    a a(InterfaceC7106Qh3 interfaceC7106Qh3);

    a b(C24948zU0 c24948zU0);
}
