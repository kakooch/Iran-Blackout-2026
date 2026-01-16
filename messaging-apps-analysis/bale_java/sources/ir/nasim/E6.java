package ir.nasim;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.G;

/* loaded from: classes3.dex */
final class E6 implements LE2 {
    private final InterfaceC15408jX7 a;
    private final Context b;
    private volatile C6 c;
    private final Object d = new Object();

    class a implements G.c {
        final /* synthetic */ Context b;

        a(Context context) {
            this.b = context;
        }

        @Override // androidx.lifecycle.G.c
        public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
            C6317Nb6 c6317Nb6 = new C6317Nb6(abstractC20375ru1);
            return new c(((b) C92.a(this.b, b.class)).f1().b(c6317Nb6).a(), c6317Nb6);
        }
    }

    public interface b {
        D6 f1();
    }

    static final class c extends VW7 {
        private final C6 b;
        private final C6317Nb6 c;

        c(C6 c6, C6317Nb6 c6317Nb6) {
            this.b = c6;
            this.c = c6317Nb6;
        }

        @Override // ir.nasim.VW7
        protected void L0() {
            super.L0();
            ((C17474n16) ((d) D92.a(this.b, d.class)).b()).a();
        }

        C6 P0() {
            return this.b;
        }

        C6317Nb6 R0() {
            return this.c;
        }
    }

    public interface d {
        G6 b();
    }

    static abstract class e {
        static G6 a() {
            return new C17474n16();
        }
    }

    E6(ComponentActivity componentActivity) {
        this.a = componentActivity;
        this.b = componentActivity;
    }

    private C6 a() {
        return ((c) d(this.a, this.b).b(c.class)).P0();
    }

    private androidx.lifecycle.G d(InterfaceC15408jX7 interfaceC15408jX7, Context context) {
        return new androidx.lifecycle.G(interfaceC15408jX7, new a(context));
    }

    @Override // ir.nasim.LE2
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C6 N2() {
        if (this.c == null) {
            synchronized (this.d) {
                try {
                    if (this.c == null) {
                        this.c = a();
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public C6317Nb6 c() {
        return ((c) d(this.a, this.b).b(c.class)).R0();
    }
}
