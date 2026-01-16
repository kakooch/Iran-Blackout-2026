package ir.nasim;

/* renamed from: ir.nasim.pz7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC19228pz7 extends InterfaceC9664aL6 {

    /* renamed from: ir.nasim.pz7$a */
    public static final class a implements InterfaceC19228pz7, InterfaceC9664aL6 {
        private final EK a;

        public a(EK ek) {
            this.a = ek;
        }

        @Override // ir.nasim.InterfaceC19228pz7
        public boolean e() {
            return this.a.i();
        }

        @Override // ir.nasim.InterfaceC9664aL6
        public Object getValue() {
            return this.a.getValue();
        }
    }

    /* renamed from: ir.nasim.pz7$b */
    public static final class b implements InterfaceC19228pz7 {
        private final Object a;
        private final boolean b;

        public b(Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }

        @Override // ir.nasim.InterfaceC19228pz7
        public boolean e() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC9664aL6
        public Object getValue() {
            return this.a;
        }

        public /* synthetic */ b(Object obj, boolean z, int i, ED1 ed1) {
            this(obj, (i & 2) != 0 ? true : z);
        }
    }

    boolean e();
}
