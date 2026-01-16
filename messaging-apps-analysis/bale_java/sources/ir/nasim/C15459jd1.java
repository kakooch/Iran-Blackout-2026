package ir.nasim;

/* renamed from: ir.nasim.jd1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15459jd1 extends AbstractC18385oa2 {
    public static final a c = new a(null);
    public final boolean a;
    public final EnumC19739qr4 b;

    /* renamed from: ir.nasim.jd1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C15459jd1(boolean z, EnumC19739qr4 enumC19739qr4) {
        this.a = z;
        this.b = enumC19739qr4;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String a() {
        return "connecting_state_changed";
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String toString() {
        EnumC19739qr4 enumC19739qr4 = this.b;
        if (enumC19739qr4 == null) {
            return "connecting_state_changed { isConnecting: " + this.a + "}";
        }
        return "connecting_state_changed { isConnecting: " + this.a + ", networkState: " + enumC19739qr4 + "}";
    }
}
