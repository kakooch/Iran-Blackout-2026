package ir.nasim;

/* renamed from: ir.nasim.oU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C18332oU3 {
    private final C23767xU3 a;
    private final CK b;
    private final E47 c;
    private final InterfaceC23587xA3 d;
    private final L13 e;
    private final Z23 f;
    private final InterfaceC22581vU3 g;

    /* renamed from: ir.nasim.oU3$a */
    public static class a {
        private C23767xU3 a;
        private CK b;
        private E47 c;
        private InterfaceC23587xA3 d;
        private L13 e;
        private Z23 f;
        private InterfaceC22581vU3 g;

        a() {
        }

        public C18332oU3 h(C23767xU3 c23767xU3, InterfaceC22581vU3 interfaceC22581vU3) {
            this.a = c23767xU3;
            this.g = interfaceC22581vU3;
            if (this.b == null) {
                this.b = CK.a();
            }
            if (this.c == null) {
                this.c = new F47();
            }
            if (this.d == null) {
                this.d = new C24177yA3();
            }
            if (this.e == null) {
                this.e = L13.a();
            }
            if (this.f == null) {
                this.f = new C9492a33();
            }
            return new C18332oU3(this);
        }
    }

    public InterfaceC22581vU3 a() {
        return this.g;
    }

    public C23767xU3 b() {
        return this.a;
    }

    private C18332oU3(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }
}
