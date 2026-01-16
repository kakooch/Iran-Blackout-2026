package ir.nasim;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;

/* loaded from: classes3.dex */
public abstract class HB2 {
    static final InterfaceC16387lB2 a = new g();
    public static final Runnable b = new d();
    public static final H4 c = new a();
    static final InterfaceC23859xe1 d = new b();
    public static final InterfaceC23859xe1 e = new e();
    public static final InterfaceC23859xe1 f = new j();
    public static final InterfaceC11617dJ3 g = new c();
    static final InterfaceC10518bk5 h = new k();
    static final InterfaceC10518bk5 i = new f();
    static final R17 j = new i();
    public static final InterfaceC23859xe1 k = new h();

    static final class c implements InterfaceC11617dJ3 {
        c() {
        }
    }

    static final class e implements InterfaceC23859xe1 {
        e() {
        }

        @Override // ir.nasim.InterfaceC23859xe1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            D76.d(th);
        }
    }

    static final class f implements InterfaceC10518bk5 {
        f() {
        }
    }

    static final class h implements InterfaceC23859xe1 {
        h() {
        }

        public void a(InterfaceC18056o07 interfaceC18056o07) {
            interfaceC18056o07.request(Long.MAX_VALUE);
        }

        @Override // ir.nasim.InterfaceC23859xe1
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
        }
    }

    static final class i implements R17 {
        i() {
        }
    }

    static final class j implements InterfaceC23859xe1 {
        j() {
        }

        @Override // ir.nasim.InterfaceC23859xe1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            D76.d(new OnErrorNotImplementedException(th));
        }
    }

    static final class k implements InterfaceC10518bk5 {
        k() {
        }
    }

    public static InterfaceC23859xe1 a() {
        return d;
    }

    static final class a implements H4 {
        a() {
        }

        public String toString() {
            return "EmptyAction";
        }

        @Override // ir.nasim.H4
        public void run() {
        }
    }

    static final class d implements Runnable {
        d() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static final class b implements InterfaceC23859xe1 {
        b() {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        @Override // ir.nasim.InterfaceC23859xe1
        public void accept(Object obj) {
        }
    }

    static final class g implements InterfaceC16387lB2 {
        g() {
        }

        public String toString() {
            return "IdentityFunction";
        }

        @Override // ir.nasim.InterfaceC16387lB2
        public Object apply(Object obj) {
            return obj;
        }
    }
}
