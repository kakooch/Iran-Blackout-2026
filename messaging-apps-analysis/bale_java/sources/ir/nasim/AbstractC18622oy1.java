package ir.nasim;

import android.content.Context;
import io.livekit.android.room.Room;
import ir.nasim.VC3;

/* renamed from: ir.nasim.oy1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC18622oy1 {

    /* renamed from: ir.nasim.oy1$b */
    private static final class b implements VC3.a {
        private b() {
        }

        @Override // ir.nasim.VC3.a
        public VC3 a(Context context, QN4 qn4) {
            AbstractC4746Gj5.b(context);
            AbstractC4746Gj5.b(qn4);
            return new c(qn4, context);
        }
    }

    /* renamed from: ir.nasim.oy1$c */
    private static final class c implements VC3 {
        private InterfaceC7720Sx5 A;
        private InterfaceC7720Sx5 B;
        private InterfaceC7720Sx5 C;
        private InterfaceC7720Sx5 D;
        private InterfaceC7720Sx5 E;
        private InterfaceC7720Sx5 F;
        private InterfaceC7720Sx5 G;
        private InterfaceC7720Sx5 H;
        private InterfaceC7720Sx5 I;
        private io.livekit.android.room.c J;
        private InterfaceC7720Sx5 K;
        private InterfaceC7720Sx5 L;
        private InterfaceC7720Sx5 M;
        private InterfaceC7720Sx5 N;
        private C23650xH3 O;
        private C12242eH3 P;
        private InterfaceC7720Sx5 Q;
        private InterfaceC7720Sx5 R;
        private InterfaceC7720Sx5 S;
        private JG3 T;
        private InterfaceC7720Sx5 U;
        private InterfaceC7720Sx5 V;
        private InterfaceC7720Sx5 W;
        private ZG3 X;
        private InterfaceC7720Sx5 Y;
        private InterfaceC7720Sx5 Z;
        private final c a;
        private InterfaceC7720Sx5 a0;
        private InterfaceC7720Sx5 b;
        private InterfaceC7720Sx5 b0;
        private InterfaceC7720Sx5 c;
        private C24686z22 c0;
        private InterfaceC7720Sx5 d;
        private InterfaceC7720Sx5 d0;
        private InterfaceC7720Sx5 e;
        private InterfaceC7720Sx5 e0;
        private InterfaceC7720Sx5 f;
        private InterfaceC7720Sx5 f0;
        private InterfaceC7720Sx5 g;
        private InterfaceC7720Sx5 g0;
        private InterfaceC7720Sx5 h;
        private InterfaceC7720Sx5 h0;
        private InterfaceC7720Sx5 i;
        private C24287yM5 i0;
        private InterfaceC7720Sx5 j;
        private InterfaceC7720Sx5 j0;
        private InterfaceC7720Sx5 k;
        private InterfaceC7720Sx5 k0;
        private InterfaceC7720Sx5 l;
        private InterfaceC7720Sx5 l0;
        private InterfaceC7720Sx5 m;
        private C12298eN5 m0;
        private InterfaceC7720Sx5 n;
        private InterfaceC7720Sx5 n0;
        private InterfaceC7720Sx5 o;
        private DN5 o0;
        private InterfaceC7720Sx5 p;
        private InterfaceC7720Sx5 p0;
        private InterfaceC7720Sx5 q;
        private C23116wN5 q0;
        private InterfaceC7720Sx5 r;
        private InterfaceC7720Sx5 r0;
        private InterfaceC7720Sx5 s;
        private io.livekit.android.room.j s0;
        private InterfaceC7720Sx5 t;
        private InterfaceC7720Sx5 t0;
        private InterfaceC7720Sx5 u;
        private InterfaceC7720Sx5 v;
        private InterfaceC7720Sx5 w;
        private InterfaceC7720Sx5 x;
        private InterfaceC7720Sx5 y;
        private InterfaceC7720Sx5 z;

        private void b(QN4 qn4, Context context) {
            YN4 yn4A = YN4.a(qn4);
            this.b = yn4A;
            InterfaceC7720Sx5 interfaceC7720Sx5C = C14202hX1.c(C16354l78.a(yn4A));
            this.c = interfaceC7720Sx5C;
            this.d = C16945m78.a(interfaceC7720Sx5C);
            this.e = C18773pD6.b(C4270Ek3.a());
            InterfaceC19617qf2 interfaceC19617qf2A = C11006ca3.a(context);
            this.f = interfaceC19617qf2A;
            this.g = C18773pD6.b(C15763k78.a(interfaceC19617qf2A));
            this.h = C14202hX1.c(C16400lC6.a(this.d, this.e, this.c, C5723Ko1.a(), this.g));
            this.i = C14202hX1.c(C21858uF5.a(this.f));
            this.j = RN4.b(qn4);
            this.k = XN4.a(qn4);
            TN4 tn4B = TN4.b(qn4);
            this.l = tn4B;
            NN nnB = NN.b(tn4B);
            this.m = nnB;
            this.n = MN.b(nnB);
            this.o = C14202hX1.c(S34.b());
            this.p = VN4.a(qn4);
            InterfaceC7720Sx5 interfaceC7720Sx5C2 = C14202hX1.c(C12077e01.a(C5723Ko1.a()));
            this.q = interfaceC7720Sx5C2;
            this.r = C14202hX1.c(ON.b(this.p, this.m, this.o, interfaceC7720Sx5C2));
            this.s = C14202hX1.c(C23044wF5.a());
            InterfaceC7720Sx5 interfaceC7720Sx5C3 = C14202hX1.c(C22448vF5.a());
            this.t = interfaceC7720Sx5C3;
            this.u = C14202hX1.c(C17608nF5.b(this.j, this.k, this.n, this.f, this.o, this.r, this.s, interfaceC7720Sx5C3));
            WN4 wn4A = WN4.a(qn4);
            this.v = wn4A;
            InterfaceC7720Sx5 interfaceC7720Sx5C4 = C14202hX1.c(C20581sF5.a(wn4A, this.o));
            this.w = interfaceC7720Sx5C4;
            this.x = C21184tF5.a(interfaceC7720Sx5C4);
            this.y = C10283bO4.a(qn4);
            this.z = DF5.a(this.i, EF5.a(), this.x, this.y);
            this.A = C9689aO4.a(qn4);
            this.B = CF5.a(this.i, EF5.a(), this.x, this.A);
            this.C = ZN4.a(qn4);
            UN4 un4B = UN4.b(qn4);
            this.D = un4B;
            InterfaceC7720Sx5 interfaceC7720Sx5C5 = C14202hX1.c(C19972rF5.a(this.i, un4B));
            this.E = interfaceC7720Sx5C5;
            C19381qF5 c19381qF5B = C19381qF5.b(interfaceC7720Sx5C5);
            this.F = c19381qF5B;
            InterfaceC7720Sx5 interfaceC7720Sx5C6 = C14202hX1.c(C24224yF5.a(this.i, this.u, this.z, this.B, this.C, this.o, c19381qF5B));
            this.G = interfaceC7720Sx5C6;
            this.H = C14202hX1.c(C23634xF5.a(interfaceC7720Sx5C6));
            this.I = C18773pD6.b(C24818zF5.a(this.G));
            io.livekit.android.room.c cVarA = io.livekit.android.room.c.a(C5723Ko1.a(), this.H, AF5.a(), this.I);
            this.J = cVarA;
            InterfaceC7720Sx5 interfaceC7720Sx5B = io.livekit.android.room.d.b(cVarA);
            this.K = interfaceC7720Sx5B;
            this.L = C14202hX1.c(io.livekit.android.room.g.a(this.h, interfaceC7720Sx5B, C5723Ko1.a(), this.I));
            this.M = C14202hX1.c(C20586sG1.a());
            NG1 ng1 = new NG1();
            this.N = ng1;
            C23650xH3 c23650xH3A = C23650xH3.a(this.H, this.f, this.w, this.M, ng1, this.I);
            this.O = c23650xH3A;
            NG1.a(this.N, C24240yH3.b(c23650xH3A));
            C12242eH3 c12242eH3A = C12242eH3.a(this.H, this.f, this.w, this.M, this.N, this.I);
            this.P = c12242eH3A;
            this.Q = C12851fH3.b(c12242eH3A);
            this.R = C18790pF5.b(this.E);
            this.S = C18199oF5.b(this.u);
            JG3 jg3A = JG3.a(this.R, C5489Jo1.a(), this.s, this.t, this.S, this.I);
            this.T = jg3A;
            this.U = KG3.b(jg3A);
            this.V = BF5.a(this.H);
            this.W = UM4.a(this.L);
            ZG3 zg3A = ZG3.a(this.L, this.H, this.f, this.w, this.Q, this.N, this.U, this.M, C5489Jo1.a(), this.V, this.W);
            this.X = zg3A;
            this.Y = io.livekit.android.room.participant.b.b(zg3A);
            this.Z = C14202hX1.c(C22532vP.a(this.f));
            SN4 sn4B = SN4.b(qn4);
            this.a0 = sn4B;
            this.b0 = C14202hX1.c(LN.b(this.Z, sn4B, this.m));
            C24686z22 c24686z22A = C24686z22.a(this.H);
            this.c0 = c24686z22A;
            this.d0 = A22.a(c24686z22A);
            this.e0 = C7196Qr3.a(this.w, this.u);
            C13972h78 c13972h78B = C13972h78.b(this.f);
            this.f0 = c13972h78B;
            C15172j78 c15172j78A = C15172j78.a(c13972h78B);
            this.g0 = c15172j78A;
            this.h0 = C18773pD6.b(C14570i78.a(this.o, c15172j78A));
            C24287yM5 c24287yM5A = C24287yM5.a(this.c, this.e);
            this.i0 = c24287yM5A;
            this.j0 = io.livekit.android.room.i.b(c24287yM5A);
            C18216oH4 c18216oH4A = C18216oH4.a(this.c);
            this.k0 = c18216oH4A;
            this.l0 = C13381g78.b(c18216oH4A);
            C12298eN5 c12298eN5A = C12298eN5.a(this.I);
            this.m0 = c12298eN5A;
            this.n0 = C12907fN5.b(c12298eN5A);
            DN5 dn5A = DN5.a(C5489Jo1.a(), this.I);
            this.o0 = dn5A;
            this.p0 = EN5.b(dn5A);
            C23116wN5 c23116wN5A = C23116wN5.a(this.h, C5723Ko1.a(), C5489Jo1.a(), this.n0, this.p0);
            this.q0 = c23116wN5A;
            this.r0 = io.livekit.android.room.participant.e.b(c23116wN5A);
            io.livekit.android.room.j jVarA = io.livekit.android.room.j.a(this.L, this.w, this.Y, this.M, C5489Jo1.a(), C5723Ko1.a(), this.b0, this.o, this.d0, this.r, this.R, this.e0, this.h0, this.u, this.j0, this.l0, this.S, H53.a(), this.r0);
            this.s0 = jVarA;
            this.t0 = io.livekit.android.room.k.b(jVarA);
        }

        @Override // ir.nasim.VC3
        public Room.a a() {
            return (Room.a) this.t0.get();
        }

        private c(QN4 qn4, Context context) {
            this.a = this;
            b(qn4, context);
        }
    }

    public static VC3.a a() {
        return new b();
    }
}
