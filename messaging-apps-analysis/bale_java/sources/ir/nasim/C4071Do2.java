package ir.nasim;

import android.content.Context;
import android.os.Handler;
import ir.nasim.C4305Eo2;

/* renamed from: ir.nasim.Do2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4071Do2 {
    public static final c b = new c(null);
    public static final int c = 8;
    private static d d = new a();
    private final Context a;

    /* renamed from: ir.nasim.Do2$a */
    private static final class a implements d {
        public static final C0327a a = new C0327a(null);

        /* renamed from: ir.nasim.Do2$a$a, reason: collision with other inner class name */
        public static final class C0327a {

            /* renamed from: ir.nasim.Do2$a$a$a, reason: collision with other inner class name */
            public static final class C0328a extends C4305Eo2.a {
                final /* synthetic */ b a;

                C0328a(b bVar) {
                    this.a = bVar;
                }

                @Override // ir.nasim.C4305Eo2.a
                public void a(CharSequence charSequence) {
                    AbstractC13042fc3.i(charSequence, "errString");
                    this.a.a(charSequence);
                }

                @Override // ir.nasim.C4305Eo2.a
                public void b() {
                    this.a.b();
                }

                @Override // ir.nasim.C4305Eo2.a
                public void c() {
                    this.a.c();
                }
            }

            private C0327a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final C4305Eo2.a b(b bVar) {
                return new C0328a(bVar);
            }

            public /* synthetic */ C0327a(ED1 ed1) {
                this();
            }
        }

        @Override // ir.nasim.C4071Do2.d
        public void a(Context context, int i, QE0 qe0, b bVar, Handler handler) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(bVar, "callback");
            C4305Eo2.a.a(context, i, qe0 != null ? qe0.b() : null, a.b(bVar), handler);
        }

        @Override // ir.nasim.C4071Do2.d
        public boolean b(Context context) {
            AbstractC13042fc3.i(context, "context");
            return C4305Eo2.a.d(context);
        }

        @Override // ir.nasim.C4071Do2.d
        public boolean c(Context context) {
            AbstractC13042fc3.i(context, "context");
            return C4305Eo2.a.c(context);
        }
    }

    /* renamed from: ir.nasim.Do2$b */
    public static abstract class b {
        public abstract void a(CharSequence charSequence);

        public abstract void b();

        public abstract void c();
    }

    /* renamed from: ir.nasim.Do2$c */
    public static final class c {
        private c() {
        }

        public final C4071Do2 a(Context context) {
            AbstractC13042fc3.i(context, "context");
            return new C4071Do2(context, null);
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Do2$d */
    public interface d {
        void a(Context context, int i, QE0 qe0, b bVar, Handler handler);

        boolean b(Context context);

        boolean c(Context context);
    }

    public /* synthetic */ C4071Do2(Context context, ED1 ed1) {
        this(context);
    }

    public static final C4071Do2 b(Context context) {
        return b.a(context);
    }

    public final void a(int i, QE0 qe0, b bVar, Handler handler) {
        AbstractC13042fc3.i(bVar, "callback");
        d.a(this.a, i, qe0, bVar, handler);
    }

    public final boolean c() {
        return d.c(this.a);
    }

    public final boolean d() {
        return d.b(this.a);
    }

    private C4071Do2(Context context) {
        this.a = context;
    }
}
