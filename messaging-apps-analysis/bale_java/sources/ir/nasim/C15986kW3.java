package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.kW3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C15986kW3 {
    public static final C15986kW3 a = new C15986kW3();

    /* renamed from: ir.nasim.kW3$a */
    private static final class a implements ZV3 {
        private final InterfaceC9236Zb3 a;
        private final c b;
        private final d c;

        public a(InterfaceC9236Zb3 interfaceC9236Zb3, c cVar, d dVar) {
            this.a = interfaceC9236Zb3;
            this.b = cVar;
            this.c = dVar;
        }

        @Override // ir.nasim.InterfaceC9236Zb3
        public int Z(int i) {
            return this.a.Z(i);
        }

        @Override // ir.nasim.InterfaceC9236Zb3
        public Object h() {
            return this.a.h();
        }

        @Override // ir.nasim.InterfaceC9236Zb3
        public int i0(int i) {
            return this.a.i0(i);
        }

        @Override // ir.nasim.InterfaceC9236Zb3
        public int k0(int i) {
            return this.a.k0(i);
        }

        @Override // ir.nasim.ZV3
        public AbstractC21430te5 l0(long j) {
            if (this.c == d.a) {
                return new b(this.b == c.b ? this.a.k0(C17833ne1.k(j)) : this.a.i0(C17833ne1.k(j)), C17833ne1.g(j) ? C17833ne1.k(j) : 32767);
            }
            return new b(C17833ne1.h(j) ? C17833ne1.l(j) : 32767, this.b == c.b ? this.a.z(C17833ne1.l(j)) : this.a.Z(C17833ne1.l(j)));
        }

        @Override // ir.nasim.InterfaceC9236Zb3
        public int z(int i) {
            return this.a.z(i);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.kW3$c */
    private static final class c {
        public static final c a = new c("Min", 0);
        public static final c b = new c("Max", 1);
        private static final /* synthetic */ c[] c;
        private static final /* synthetic */ F92 d;

        static {
            c[] cVarArrA = a();
            c = cVarArrA;
            d = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.kW3$d */
    private static final class d {
        public static final d a = new d("Width", 0);
        public static final d b = new d("Height", 1);
        private static final /* synthetic */ d[] c;
        private static final /* synthetic */ F92 d;

        static {
            d[] dVarArrA = a();
            c = dVarArrA;
            d = G92.a(dVarArrA);
        }

        private d(String str, int i) {
        }

        private static final /* synthetic */ d[] a() {
            return new d[]{a, b};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) c.clone();
        }
    }

    private C15986kW3() {
    }

    public final int a(InterfaceC20377ru3 interfaceC20377ru3, InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC20377ru3.b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), new a(interfaceC9236Zb3, c.b, d.b), AbstractC19606qe1.b(0, i, 0, 0, 13, null)).getHeight();
    }

    public final int b(InterfaceC20377ru3 interfaceC20377ru3, InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC20377ru3.b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), new a(interfaceC9236Zb3, c.b, d.a), AbstractC19606qe1.b(0, 0, 0, i, 7, null)).getWidth();
    }

    public final int c(InterfaceC20377ru3 interfaceC20377ru3, InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC20377ru3.b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), new a(interfaceC9236Zb3, c.a, d.b), AbstractC19606qe1.b(0, i, 0, 0, 13, null)).getHeight();
    }

    public final int d(InterfaceC20377ru3 interfaceC20377ru3, InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC20377ru3.b(new C15451jc3(interfaceC10436bc3, interfaceC10436bc3.getLayoutDirection()), new a(interfaceC9236Zb3, c.a, d.a), AbstractC19606qe1.b(0, 0, 0, i, 7, null)).getWidth();
    }

    /* renamed from: ir.nasim.kW3$b */
    private static final class b extends AbstractC21430te5 {
        public b(int i, int i2) {
            Y0(C4414Fa3.c((i2 & 4294967295L) | (i << 32)));
        }

        @Override // ir.nasim.InterfaceC14195hW3
        public int J(AbstractC13165fm abstractC13165fm) {
            return RecyclerView.UNDEFINED_DURATION;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21430te5
        public void U0(long j, float f, UA2 ua2) {
        }
    }
}
