package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import java.util.List;

/* renamed from: ir.nasim.Fu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4593Fu2 implements Comparable {
    public static final a b = new a(null);
    private static final C4593Fu2 c;
    private static final C4593Fu2 d;
    private static final C4593Fu2 e;
    private static final C4593Fu2 f;
    private static final C4593Fu2 g;
    private static final C4593Fu2 h;
    private static final C4593Fu2 i;
    private static final C4593Fu2 j;
    private static final C4593Fu2 k;
    private static final C4593Fu2 l;
    private static final C4593Fu2 m;
    private static final C4593Fu2 n;
    private static final C4593Fu2 o;
    private static final C4593Fu2 p;
    private static final C4593Fu2 q;
    private static final C4593Fu2 r;
    private static final C4593Fu2 s;
    private static final C4593Fu2 t;
    private static final List u;
    private final int a;

    /* renamed from: ir.nasim.Fu2$a */
    public static final class a {
        private a() {
        }

        public final C4593Fu2 a() {
            return C4593Fu2.r;
        }

        public final C4593Fu2 b() {
            return C4593Fu2.n;
        }

        public final C4593Fu2 c() {
            return C4593Fu2.p;
        }

        public final C4593Fu2 d() {
            return C4593Fu2.o;
        }

        public final C4593Fu2 e() {
            return C4593Fu2.e;
        }

        public final C4593Fu2 f() {
            return C4593Fu2.f;
        }

        public final C4593Fu2 g() {
            return C4593Fu2.g;
        }

        public final C4593Fu2 h() {
            return C4593Fu2.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        C4593Fu2 c4593Fu2 = new C4593Fu2(100);
        c = c4593Fu2;
        C4593Fu2 c4593Fu22 = new C4593Fu2(200);
        d = c4593Fu22;
        C4593Fu2 c4593Fu23 = new C4593Fu2(300);
        e = c4593Fu23;
        C4593Fu2 c4593Fu24 = new C4593Fu2(400);
        f = c4593Fu24;
        C4593Fu2 c4593Fu25 = new C4593Fu2(SIPTransactionStack.BASE_TIMER_INTERVAL);
        g = c4593Fu25;
        C4593Fu2 c4593Fu26 = new C4593Fu2(SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER);
        h = c4593Fu26;
        C4593Fu2 c4593Fu27 = new C4593Fu2(700);
        i = c4593Fu27;
        C4593Fu2 c4593Fu28 = new C4593Fu2(800);
        j = c4593Fu28;
        C4593Fu2 c4593Fu29 = new C4593Fu2(900);
        k = c4593Fu29;
        l = c4593Fu2;
        m = c4593Fu22;
        n = c4593Fu23;
        o = c4593Fu24;
        p = c4593Fu25;
        q = c4593Fu26;
        r = c4593Fu27;
        s = c4593Fu28;
        t = c4593Fu29;
        u = AbstractC10360bX0.p(c4593Fu2, c4593Fu22, c4593Fu23, c4593Fu24, c4593Fu25, c4593Fu26, c4593Fu27, c4593Fu28, c4593Fu29);
    }

    public C4593Fu2(int i2) {
        this.a = i2;
        boolean z = false;
        if (1 <= i2 && i2 < 1001) {
            z = true;
        }
        if (z) {
            return;
        }
        N73.a("Font weight can be in range [1, 1000]. Current value: " + i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C4593Fu2) && this.a == ((C4593Fu2) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4593Fu2 c4593Fu2) {
        return AbstractC13042fc3.k(this.a, c4593Fu2.a);
    }

    public final int t() {
        return this.a;
    }

    public String toString() {
        return "FontWeight(weight=" + this.a + ')';
    }
}
