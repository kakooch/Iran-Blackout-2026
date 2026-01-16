package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import ir.nasim.C14269he1;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.he1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C14269he1 implements InterfaceC13678ge1, YM5 {
    private final C11044ce1 a;
    private Handler b;
    private final androidx.compose.runtime.snapshots.k c;
    private boolean d;
    private final UA2 e;
    private final List f;

    /* renamed from: ir.nasim.he1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ List e;
        final /* synthetic */ TK6 f;
        final /* synthetic */ C14269he1 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, TK6 tk6, C14269he1 c14269he1) {
            super(0);
            this.e = list;
            this.f = tk6;
            this.g = c14269he1;
        }

        public final void a() {
            List list = this.e;
            TK6 tk6 = this.f;
            C14269he1 c14269he1 = this.g;
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object objH = ((ZV3) list.get(i)).h();
                C10454be1 c10454be1 = objH instanceof C10454be1 ? (C10454be1) objH : null;
                if (c10454be1 != null) {
                    C7536Sd1 c7536Sd1 = new C7536Sd1(c10454be1.b().c());
                    c10454be1.a().invoke(c7536Sd1);
                    c7536Sd1.a(tk6);
                }
                c14269he1.f.add(c10454be1);
                if (i2 > size) {
                    return;
                } else {
                    i = i2;
                }
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.he1$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$tmp0");
            sa2.invoke();
        }

        public final void b(final SA2 sa2) {
            AbstractC13042fc3.i(sa2, "it");
            if (AbstractC13042fc3.d(Looper.myLooper(), Looper.getMainLooper())) {
                sa2.invoke();
                return;
            }
            Handler handler = C14269he1.this.b;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
                C14269he1.this.b = handler;
            }
            handler.post(new Runnable() { // from class: ir.nasim.ie1
                @Override // java.lang.Runnable
                public final void run() {
                    C14269he1.b.c(sa2);
                }
            });
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SA2) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.he1$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final void a(C19938rB7 c19938rB7) {
            AbstractC13042fc3.i(c19938rB7, "$noName_0");
            C14269he1.this.i(true);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C19938rB7) obj);
            return C19938rB7.a;
        }
    }

    public C14269he1(C11044ce1 c11044ce1) {
        AbstractC13042fc3.i(c11044ce1, "scope");
        this.a = c11044ce1;
        this.c = new androidx.compose.runtime.snapshots.k(new b());
        this.d = true;
        this.e = new c();
        this.f = new ArrayList();
    }

    @Override // ir.nasim.InterfaceC13678ge1
    public boolean a(List list) {
        AbstractC13042fc3.i(list, "measurables");
        if (this.d || list.size() != this.f.size()) {
            return true;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object objH = ((ZV3) list.get(i)).h();
                if (!AbstractC13042fc3.d(objH instanceof C10454be1 ? (C10454be1) objH : null, this.f.get(i))) {
                    return true;
                }
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        return false;
    }

    @Override // ir.nasim.YM5
    public void b() {
        this.c.t();
    }

    @Override // ir.nasim.InterfaceC13678ge1
    public void c(TK6 tk6, List list) {
        AbstractC13042fc3.i(tk6, "state");
        AbstractC13042fc3.i(list, "measurables");
        this.a.a(tk6);
        this.f.clear();
        this.c.p(C19938rB7.a, this.e, new a(list, tk6, this));
        this.d = false;
    }

    @Override // ir.nasim.YM5
    public void e() {
        this.c.u();
        this.c.k();
    }

    public final void i(boolean z) {
        this.d = z;
    }

    @Override // ir.nasim.YM5
    public void d() {
    }
}
