package ir.nasim;

import java.util.Set;

/* renamed from: ir.nasim.q00, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19231q00 {
    public static final a b = new a(null);
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.p00
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C19231q00.p();
        }
    });
    private final C8542Wk3 a;

    /* renamed from: ir.nasim.q00$a */
    public static final class a {
        private a() {
        }

        public final KS2 a() {
            return (KS2) C19231q00.c.getValue();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C19231q00() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KS2 p() {
        return new KS2();
    }

    public final C19231q00 c(String str, C13149fk3 c13149fk3) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(c13149fk3, "value");
        this.a.C(str, c13149fk3);
        return this;
    }

    public final C19231q00 d(String str, C8542Wk3 c8542Wk3) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(c8542Wk3, "value");
        this.a.C(str, c8542Wk3);
        return this;
    }

    public final C19231q00 e(String str, Number number) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(number, "value");
        this.a.E(str, number);
        return this;
    }

    public final C19231q00 f(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        this.a.F(str, str2);
        return this;
    }

    public final AbstractC22735vk3 g(String str) {
        AbstractC13042fc3.i(str, "key");
        return this.a.L(str);
    }

    public final C13149fk3 h(String str) {
        C13149fk3 c13149fk3J;
        AbstractC13042fc3.i(str, "key");
        AbstractC22735vk3 abstractC22735vk3L = this.a.L(str);
        return (abstractC22735vk3L == null || (c13149fk3J = abstractC22735vk3L.j()) == null) ? new C13149fk3() : c13149fk3J;
    }

    public final boolean i(String str, boolean z) {
        AbstractC13042fc3.i(str, "key");
        AbstractC22735vk3 abstractC22735vk3L = this.a.L(str);
        return abstractC22735vk3L != null ? abstractC22735vk3L.f() : z;
    }

    public final double j(String str, double d) {
        AbstractC13042fc3.i(str, "key");
        AbstractC22735vk3 abstractC22735vk3L = this.a.L(str);
        return abstractC22735vk3L != null ? abstractC22735vk3L.h() : d;
    }

    public final int k(String str, int i) {
        AbstractC13042fc3.i(str, "key");
        AbstractC22735vk3 abstractC22735vk3L = this.a.L(str);
        return abstractC22735vk3L != null ? abstractC22735vk3L.i() : i;
    }

    public final C8542Wk3 l() {
        return this.a;
    }

    public final long m(String str, long j) {
        AbstractC13042fc3.i(str, "key");
        AbstractC22735vk3 abstractC22735vk3L = this.a.L(str);
        return abstractC22735vk3L != null ? abstractC22735vk3L.t() : j;
    }

    public final String n(String str) {
        AbstractC13042fc3.i(str, "key");
        AbstractC22735vk3 abstractC22735vk3L = this.a.L(str);
        if (abstractC22735vk3L != null) {
            return abstractC22735vk3L.v();
        }
        return null;
    }

    public final String o(String str, String str2) {
        String strV;
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "default");
        AbstractC22735vk3 abstractC22735vk3L = this.a.L(str);
        return (abstractC22735vk3L == null || (strV = abstractC22735vk3L.v()) == null) ? str2 : strV;
    }

    public final boolean q(String str) {
        AbstractC13042fc3.i(str, "key");
        return this.a.O(str);
    }

    public final Set r() {
        Set setP = this.a.P();
        AbstractC13042fc3.h(setP, "keySet(...)");
        return setP;
    }

    public String toString() {
        String string = this.a.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public C19231q00(C8542Wk3 c8542Wk3) {
        AbstractC13042fc3.i(c8542Wk3, "jsonObject");
        this.a = c8542Wk3;
    }

    public /* synthetic */ C19231q00(C8542Wk3 c8542Wk3, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C8542Wk3() : c8542Wk3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C19231q00(String str) {
        Object objK = b.a().k(str, C8542Wk3.class);
        AbstractC13042fc3.h(objK, "fromJson(...)");
        this((C8542Wk3) objK);
    }
}
