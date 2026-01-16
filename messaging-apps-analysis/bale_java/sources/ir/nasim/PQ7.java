package ir.nasim;

import ir.nasim.C17784nZ1;
import ir.nasim.C19557qZ1;
import ir.nasim.C22045ua3;
import ir.nasim.C4414Fa3;
import ir.nasim.CK5;
import ir.nasim.OD6;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
public abstract class PQ7 {
    private static final InterfaceC5342Ix7 a = a(e.e, f.e);
    private static final InterfaceC5342Ix7 b = a(k.e, l.e);
    private static final InterfaceC5342Ix7 c = a(c.e, d.e);
    private static final InterfaceC5342Ix7 d = a(a.e, b.e);
    private static final InterfaceC5342Ix7 e = a(q.e, r.e);
    private static final InterfaceC5342Ix7 f = a(m.e, n.e);
    private static final InterfaceC5342Ix7 g = a(g.e, h.e);
    private static final InterfaceC5342Ix7 h = a(i.e, j.e);
    private static final InterfaceC5342Ix7 i = a(o.e, p.e);

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final C7444Rt a(long j) {
            return new C7444Rt(C19557qZ1.e(j), C19557qZ1.f(j));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((C19557qZ1) obj).i());
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final long a(C7444Rt c7444Rt) {
            float fQ = C17784nZ1.q(c7444Rt.f());
            float fQ2 = C17784nZ1.q(c7444Rt.g());
            return C19557qZ1.b((Float.floatToRawIntBits(fQ) << 32) | (Float.floatToRawIntBits(fQ2) & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C19557qZ1.a(a((C7444Rt) obj));
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        public final C7210Qt a(float f) {
            return new C7210Qt(f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((C17784nZ1) obj).v());
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        public final float a(C7210Qt c7210Qt) {
            return C17784nZ1.q(c7210Qt.f());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C17784nZ1.j(a((C7210Qt) obj));
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        public final C7210Qt a(float f) {
            return new C7210Qt(f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke(C7210Qt c7210Qt) {
            return Float.valueOf(c7210Qt.f());
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        g() {
            super(1);
        }

        public final C7444Rt a(long j) {
            return new C7444Rt(C22045ua3.k(j), C22045ua3.l(j));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((C22045ua3) obj).r());
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        public static final h e = new h();

        h() {
            super(1);
        }

        public final long a(C7444Rt c7444Rt) {
            return C22045ua3.f((Math.round(c7444Rt.f()) << 32) | (Math.round(c7444Rt.g()) & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C22045ua3.c(a((C7444Rt) obj));
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        public static final i e = new i();

        i() {
            super(1);
        }

        public final C7444Rt a(long j) {
            return new C7444Rt((int) (j >> 32), (int) (j & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((C4414Fa3) obj).j());
        }
    }

    static final class j extends AbstractC8614Ws3 implements UA2 {
        public static final j e = new j();

        j() {
            super(1);
        }

        public final long a(C7444Rt c7444Rt) {
            int iRound = Math.round(c7444Rt.f());
            if (iRound < 0) {
                iRound = 0;
            }
            return C4414Fa3.c(((Math.round(c7444Rt.g()) >= 0 ? r7 : 0) & 4294967295L) | (iRound << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a((C7444Rt) obj));
        }
    }

    static final class k extends AbstractC8614Ws3 implements UA2 {
        public static final k e = new k();

        k() {
            super(1);
        }

        public final C7210Qt a(int i) {
            return new C7210Qt(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class l extends AbstractC8614Ws3 implements UA2 {
        public static final l e = new l();

        l() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(C7210Qt c7210Qt) {
            return Integer.valueOf((int) c7210Qt.f());
        }
    }

    static final class m extends AbstractC8614Ws3 implements UA2 {
        public static final m e = new m();

        m() {
            super(1);
        }

        public final C7444Rt a(long j) {
            return new C7444Rt(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((ZG4) obj).t());
        }
    }

    static final class n extends AbstractC8614Ws3 implements UA2 {
        public static final n e = new n();

        n() {
            super(1);
        }

        public final long a(C7444Rt c7444Rt) {
            float f = c7444Rt.f();
            float fG = c7444Rt.g();
            return ZG4.e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(fG) & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return ZG4.d(a((C7444Rt) obj));
        }
    }

    static final class o extends AbstractC8614Ws3 implements UA2 {
        public static final o e = new o();

        o() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C7917Tt invoke(CK5 ck5) {
            return new C7917Tt(ck5.i(), ck5.l(), ck5.j(), ck5.e());
        }
    }

    static final class p extends AbstractC8614Ws3 implements UA2 {
        public static final p e = new p();

        p() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CK5 invoke(C7917Tt c7917Tt) {
            return new CK5(c7917Tt.f(), c7917Tt.g(), c7917Tt.h(), c7917Tt.i());
        }
    }

    static final class q extends AbstractC8614Ws3 implements UA2 {
        public static final q e = new q();

        q() {
            super(1);
        }

        public final C7444Rt a(long j) {
            return new C7444Rt(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((OD6) obj).m());
        }
    }

    static final class r extends AbstractC8614Ws3 implements UA2 {
        public static final r e = new r();

        r() {
            super(1);
        }

        public final long a(C7444Rt c7444Rt) {
            float f = c7444Rt.f();
            float fG = c7444Rt.g();
            return OD6.d((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(fG) & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return OD6.c(a((C7444Rt) obj));
        }
    }

    public static final InterfaceC5342Ix7 a(UA2 ua2, UA2 ua22) {
        return new C5576Jx7(ua2, ua22);
    }

    public static final InterfaceC5342Ix7 b(C17784nZ1.a aVar) {
        return c;
    }

    public static final InterfaceC5342Ix7 c(C19557qZ1.a aVar) {
        return d;
    }

    public static final InterfaceC5342Ix7 d(C9361Zp2 c9361Zp2) {
        return a;
    }

    public static final InterfaceC5342Ix7 e(C15431ja3 c15431ja3) {
        return b;
    }

    public static final InterfaceC5342Ix7 f(C22045ua3.a aVar) {
        return g;
    }

    public static final InterfaceC5342Ix7 g(C4414Fa3.a aVar) {
        return h;
    }

    public static final InterfaceC5342Ix7 h(ZG4.a aVar) {
        return f;
    }

    public static final InterfaceC5342Ix7 i(CK5.a aVar) {
        return i;
    }

    public static final InterfaceC5342Ix7 j(OD6.a aVar) {
        return e;
    }
}
