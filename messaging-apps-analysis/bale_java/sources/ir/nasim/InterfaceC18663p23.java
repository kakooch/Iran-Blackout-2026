package ir.nasim;

import android.content.Context;
import coil.memory.MemoryCache;
import ir.nasim.InterfaceC8217Va2;
import okhttp3.OkHttpClient;

/* renamed from: ir.nasim.p23, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC18663p23 {
    Object a(W23 w23, InterfaceC20295rm1 interfaceC20295rm1);

    NE1 b();

    a c();

    IV1 d(W23 w23);

    MemoryCache e();

    C12087e11 getComponents();

    /* renamed from: ir.nasim.p23$a */
    public static final class a {
        private final Context a;
        private NE1 b;
        private InterfaceC9173Yu3 c;
        private InterfaceC9173Yu3 d;
        private InterfaceC9173Yu3 e;
        private InterfaceC8217Va2.c f;
        private C12087e11 g;
        private C22321v23 h;
        private II3 i;

        /* renamed from: ir.nasim.p23$a$a, reason: collision with other inner class name */
        static final class C1433a extends AbstractC8614Ws3 implements SA2 {
            C1433a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MemoryCache invoke() {
                return new MemoryCache.a(a.this.a).a();
            }
        }

        /* renamed from: ir.nasim.p23$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC21332tU1 invoke() {
                return GD6.a.a(a.this.a);
            }
        }

        /* renamed from: ir.nasim.p23$a$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            public static final c e = new c();

            c() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final OkHttpClient invoke() {
                return new OkHttpClient();
            }
        }

        public a(Context context) {
            this.a = context.getApplicationContext();
            this.b = AbstractC16865m.b();
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = new C22321v23(false, false, false, 0, null, 31, null);
            this.i = null;
        }

        public final InterfaceC18663p23 b() {
            Context context = this.a;
            NE1 ne1 = this.b;
            InterfaceC9173Yu3 interfaceC9173Yu3A = this.c;
            if (interfaceC9173Yu3A == null) {
                interfaceC9173Yu3A = AbstractC13269fw3.a(new C1433a());
            }
            InterfaceC9173Yu3 interfaceC9173Yu3 = interfaceC9173Yu3A;
            InterfaceC9173Yu3 interfaceC9173Yu3A2 = this.d;
            if (interfaceC9173Yu3A2 == null) {
                interfaceC9173Yu3A2 = AbstractC13269fw3.a(new b());
            }
            InterfaceC9173Yu3 interfaceC9173Yu32 = interfaceC9173Yu3A2;
            InterfaceC9173Yu3 interfaceC9173Yu3A3 = this.e;
            if (interfaceC9173Yu3A3 == null) {
                interfaceC9173Yu3A3 = AbstractC13269fw3.a(c.e);
            }
            InterfaceC9173Yu3 interfaceC9173Yu33 = interfaceC9173Yu3A3;
            InterfaceC8217Va2.c cVar = this.f;
            if (cVar == null) {
                cVar = InterfaceC8217Va2.c.b;
            }
            InterfaceC8217Va2.c cVar2 = cVar;
            C12087e11 c12087e11 = this.g;
            if (c12087e11 == null) {
                c12087e11 = new C12087e11();
            }
            return new FI5(context, ne1, interfaceC9173Yu3, interfaceC9173Yu32, interfaceC9173Yu33, cVar2, c12087e11, this.h, this.i);
        }

        public final a c(C12087e11 c12087e11) {
            this.g = c12087e11;
            return this;
        }

        public final a d(SA2 sa2) {
            this.d = AbstractC13269fw3.a(sa2);
            return this;
        }

        public final a e(EnumC16760lp0 enumC16760lp0) {
            NE1 ne1 = this.b;
            this.b = ne1.a((24575 & 1) != 0 ? ne1.a : null, (24575 & 2) != 0 ? ne1.b : null, (24575 & 4) != 0 ? ne1.c : null, (24575 & 8) != 0 ? ne1.d : null, (24575 & 16) != 0 ? ne1.e : null, (24575 & 32) != 0 ? ne1.f : null, (24575 & 64) != 0 ? ne1.g : null, (24575 & 128) != 0 ? ne1.h : false, (24575 & 256) != 0 ? ne1.i : false, (24575 & 512) != 0 ? ne1.j : null, (24575 & 1024) != 0 ? ne1.k : null, (24575 & 2048) != 0 ? ne1.l : null, (24575 & 4096) != 0 ? ne1.m : null, (24575 & 8192) != 0 ? ne1.n : enumC16760lp0, (24575 & 16384) != 0 ? ne1.o : null);
            return this;
        }

        public final a f(II3 ii3) {
            this.i = ii3;
            return this;
        }

        public final a g(SA2 sa2) {
            this.c = AbstractC13269fw3.a(sa2);
            return this;
        }

        public final a h(EnumC16760lp0 enumC16760lp0) {
            NE1 ne1 = this.b;
            this.b = ne1.a((24575 & 1) != 0 ? ne1.a : null, (24575 & 2) != 0 ? ne1.b : null, (24575 & 4) != 0 ? ne1.c : null, (24575 & 8) != 0 ? ne1.d : null, (24575 & 16) != 0 ? ne1.e : null, (24575 & 32) != 0 ? ne1.f : null, (24575 & 64) != 0 ? ne1.g : null, (24575 & 128) != 0 ? ne1.h : false, (24575 & 256) != 0 ? ne1.i : false, (24575 & 512) != 0 ? ne1.j : null, (24575 & 1024) != 0 ? ne1.k : null, (24575 & 2048) != 0 ? ne1.l : null, (24575 & 4096) != 0 ? ne1.m : enumC16760lp0, (24575 & 8192) != 0 ? ne1.n : null, (24575 & 16384) != 0 ? ne1.o : null);
            return this;
        }

        public final a i(boolean z) {
            this.h = C22321v23.b(this.h, false, false, z, 0, null, 27, null);
            return this;
        }

        public a(FI5 fi5) {
            this.a = fi5.k().getApplicationContext();
            this.b = fi5.b();
            this.c = fi5.o();
            this.d = fi5.l();
            this.e = fi5.i();
            this.f = fi5.m();
            this.g = fi5.j();
            this.h = fi5.p();
            this.i = fi5.n();
        }
    }
}
