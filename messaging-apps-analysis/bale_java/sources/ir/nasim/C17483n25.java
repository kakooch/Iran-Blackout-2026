package ir.nasim;

/* renamed from: ir.nasim.n25, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17483n25 extends AbstractC18385oa2 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final C11458d25 a;

    /* renamed from: ir.nasim.n25$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C17483n25(C11458d25 c11458d25) {
        this.a = c11458d25;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String a() {
        return "peer_chat_closed";
    }

    public final C11458d25 b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC18385oa2
    public String toString() {
        C11458d25 c11458d25 = this.a;
        if (c11458d25 == null) {
            return "peer_chat_closed {peer is null}";
        }
        return "peer_chat_closed {" + c11458d25.D() + "}";
    }
}
