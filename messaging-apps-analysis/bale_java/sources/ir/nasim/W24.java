package ir.nasim;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes8.dex */
public interface W24 extends InterfaceC22011uW5 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final UA2 b = C0729a.e;

        /* renamed from: ir.nasim.W24$a$a, reason: collision with other inner class name */
        static final class C0729a extends AbstractC8614Ws3 implements UA2 {
            public static final C0729a e = new C0729a();

            C0729a() {
                super(1);
            }

            public final boolean a(C6432No4 c6432No4) {
                AbstractC13042fc3.i(c6432No4, "it");
                return true;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(a((C6432No4) obj));
            }
        }

        private a() {
        }

        public final UA2 a() {
            return b;
        }
    }

    public static final class b extends X24 {
        public static final b b = new b();

        private b() {
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Set a() {
            return AbstractC4597Fu6.d();
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Set c() {
            return AbstractC4597Fu6.d();
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Set g() {
            return AbstractC4597Fu6.d();
        }
    }

    Set a();

    Collection b(C6432No4 c6432No4, IJ3 ij3);

    Set c();

    Collection d(C6432No4 c6432No4, IJ3 ij3);

    Set g();
}
