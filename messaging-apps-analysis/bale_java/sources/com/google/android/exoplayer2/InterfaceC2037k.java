package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.C2031h;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC7218Qt7;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.BO5;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC15205jB2;
import ir.nasim.InterfaceC6170Mm;
import ir.nasim.ME1;
import ir.nasim.NV0;
import ir.nasim.Q17;
import ir.nasim.RF3;
import ir.nasim.UD1;
import ir.nasim.YF1;

/* renamed from: com.google.android.exoplayer2.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC2037k extends z0 {

    /* renamed from: com.google.android.exoplayer2.k$a */
    public interface a {
        default void r(boolean z) {
        }

        void s(boolean z);
    }

    /* renamed from: com.google.android.exoplayer2.k$b */
    public static final class b {
        Looper A;
        boolean B;
        final Context a;
        NV0 b;
        long c;
        Q17 d;
        Q17 e;
        Q17 f;
        Q17 g;
        Q17 h;
        InterfaceC15205jB2 i;
        Looper j;
        com.google.android.exoplayer2.audio.a k;
        boolean l;
        int m;
        boolean n;
        boolean o;
        int p;
        int q;
        boolean r;
        C22738vk6 s;
        long t;
        long u;
        Z v;
        long w;
        long x;
        boolean y;
        boolean z;

        public b(final Context context) {
            this(context, new Q17() { // from class: ir.nasim.Ld2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return InterfaceC2037k.b.k(context);
                }
            }, new Q17() { // from class: ir.nasim.Md2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return InterfaceC2037k.b.l(context);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ BO5 k(Context context) {
            return new ME1(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory l(Context context) {
            return new DefaultMediaSourceFactory(context, new UD1());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ AbstractC7218Qt7 m(Context context) {
            return new YF1(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory p(MediaSource.Factory factory) {
            return factory;
        }

        public InterfaceC2037k i() {
            AbstractC20011rK.g(!this.B);
            this.B = true;
            return new K(this, null);
        }

        E0 j() {
            AbstractC20011rK.g(!this.B);
            this.B = true;
            return new E0(this);
        }

        public b s(final RF3 rf3) {
            AbstractC20011rK.g(!this.B);
            AbstractC20011rK.e(rf3);
            this.g = new Q17() { // from class: ir.nasim.Ud2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return InterfaceC2037k.b.o(rf3);
                }
            };
            return this;
        }

        public b t(final MediaSource.Factory factory) {
            AbstractC20011rK.g(!this.B);
            AbstractC20011rK.e(factory);
            this.e = new Q17() { // from class: ir.nasim.Td2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return InterfaceC2037k.b.p(factory);
                }
            };
            return this;
        }

        public b u(final BO5 bo5) {
            AbstractC20011rK.g(!this.B);
            AbstractC20011rK.e(bo5);
            this.d = new Q17() { // from class: ir.nasim.Od2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return InterfaceC2037k.b.q(bo5);
                }
            };
            return this;
        }

        public b v(final AbstractC7218Qt7 abstractC7218Qt7) {
            AbstractC20011rK.g(!this.B);
            AbstractC20011rK.e(abstractC7218Qt7);
            this.f = new Q17() { // from class: ir.nasim.Nd2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return InterfaceC2037k.b.r(abstractC7218Qt7);
                }
            };
            return this;
        }

        private b(final Context context, Q17 q17, Q17 q172) {
            this(context, q17, q172, new Q17() { // from class: ir.nasim.Pd2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return InterfaceC2037k.b.m(context);
                }
            }, new Q17() { // from class: ir.nasim.Qd2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return new C17595nE1();
                }
            }, new Q17() { // from class: ir.nasim.Rd2
                @Override // ir.nasim.Q17
                public final Object get() {
                    return C23612xD1.n(context);
                }
            }, new InterfaceC15205jB2() { // from class: ir.nasim.Sd2
                @Override // ir.nasim.InterfaceC15205jB2
                public final Object apply(Object obj) {
                    return new C14624iD1((NV0) obj);
                }
            });
        }

        private b(Context context, Q17 q17, Q17 q172, Q17 q173, Q17 q174, Q17 q175, InterfaceC15205jB2 interfaceC15205jB2) {
            this.a = (Context) AbstractC20011rK.e(context);
            this.d = q17;
            this.e = q172;
            this.f = q173;
            this.g = q174;
            this.h = q175;
            this.i = interfaceC15205jB2;
            this.j = AbstractC9683aN7.N();
            this.k = com.google.android.exoplayer2.audio.a.g;
            this.m = 0;
            this.p = 1;
            this.q = 0;
            this.r = true;
            this.s = C22738vk6.g;
            this.t = 5000L;
            this.u = 15000L;
            this.v = new C2031h.b().a();
            this.b = NV0.a;
            this.w = 500L;
            this.x = 2000L;
            this.z = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ RF3 o(RF3 rf3) {
            return rf3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ BO5 q(BO5 bo5) {
            return bo5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ AbstractC7218Qt7 r(AbstractC7218Qt7 abstractC7218Qt7) {
            return abstractC7218Qt7;
        }
    }

    void E(InterfaceC6170Mm interfaceC6170Mm);

    void J(boolean z);

    void S(com.google.android.exoplayer2.audio.a aVar, boolean z);

    ExoPlaybackException a();

    void d(MediaSource mediaSource);

    void q0(ShuffleOrder shuffleOrder);

    void z0(MediaSource mediaSource, boolean z);
}
