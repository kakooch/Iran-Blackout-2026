package ir.nasim;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.gov.nist.core.Separators;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.AbstractC4886Gz1;
import ir.nasim.C22484vJ5;
import ir.nasim.C23952xn4;
import ir.nasim.EA3;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.KA3;
import ir.nasim.L5;
import ir.nasim.PA7;
import ir.nasim.TY1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.network.RpcException;
import ir.nasim.core.shortcut.ShortcutShortcutReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Wy6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C8671Wy6 extends VW7 {
    public static final C8673b x1 = new C8673b(null);
    public static final int y1 = 8;
    private final C6409Nm A;
    private final C21855uF2 A0;
    private final InterfaceC22918w24 B;
    private final LE B0;
    private final int C0;
    private final EA3.b D;
    private final Context D0;
    private final YE4 E0;
    private final C18852pM4 F0;
    private final C23952xn4.a.InterfaceC1774a G;
    private final C24651yy6 G0;
    private final C22484vJ5.a H;
    private final InterfaceC5943Lm5 H0;
    public InterfaceC8898Xu3 I0;
    private final InterfaceC23080wJ5 J;
    private final String J0;
    private final String K0;
    private InterfaceC9336Zm4 L0;
    private final InterfaceC9336Zm4 M0;
    private final InterfaceC10258bL6 N0;
    private InterfaceC9336Zm4 O0;
    private InterfaceC9336Zm4 P0;
    private final InterfaceC9336Zm4 Q0;
    private final InterfaceC10258bL6 R0;
    private final InterfaceC9173Yu3 S0;
    private final InterfaceC4557Fq2 T0;
    private final FT4 U0;
    private final InterfaceC4557Fq2 V0;
    private InterfaceC9336Zm4 W0;
    private final boolean X0;
    private final androidx.lifecycle.y Y;
    private final C11458d25 Y0;
    private final InterfaceC4308Eo5 Z;
    private final boolean Z0;
    private C21231tK7 a1;
    private final C10299bQ2 b;
    private C14733iO2 b1;
    private final OK7 c;
    private final InterfaceC9173Yu3 c1;
    private final SettingsModule d;
    private final InterfaceC9336Zm4 d1;
    private final C3841Co6 e;
    private InterfaceC9336Zm4 e1;
    private final C8054Ui1 f;
    private ExPeerType f1;
    private final V24 g;
    private List g1;
    private final C18804pH1 h;
    private InterfaceC9336Zm4 h1;
    private final C17039mI0 i;
    private final boolean i1;
    private final InterfaceC5409Jf2 j;
    private final InterfaceC9173Yu3 j1;
    private final C22434vE0 k;
    private final InterfaceC8327Vm4 k1;
    private final C19854r32 l;
    private final InterfaceC9336Zm4 l1;
    private final C21844uE0 m;
    private final InterfaceC9336Zm4 m1;
    private final WF2 n;
    private final InterfaceC10258bL6 n1;
    private final InterfaceC14587i95 o;
    private boolean o1;
    private final ET7 p;
    private InterfaceC4557Fq2 p1;
    private final M08 q;
    private InterfaceC4557Fq2 q1;
    private final ZN r;
    private InterfaceC4557Fq2 r1;
    private final InterfaceC7375Rl2 s;
    private InterfaceC4557Fq2 s1;
    private final InterfaceC16732lm2 t;
    private InterfaceC4557Fq2 t1;
    private final InterfaceC21103t7 u;
    private InterfaceC4557Fq2 u1;
    private final F95 v;
    private final InterfaceC10040ay6 v1;
    private final VU7 w;
    private final InterfaceC4557Fq2 w1;
    private final C13168fm2 x;
    private final C17101mP y;
    private final X08 z;
    private final E84 z0;

    /* renamed from: ir.nasim.Wy6$A */
    static final class A extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new A(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                r23 = this;
                r0 = r23
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2f
                if (r2 == r4) goto L23
                if (r2 != r3) goto L1b
                java.lang.Object r1 = r0.c
                ir.nasim.Wy6 r1 = (ir.nasim.C8671Wy6) r1
                ir.nasim.AbstractC10685c16.b(r24)
                r2 = r24
                goto L9b
            L1b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L23:
                ir.nasim.AbstractC10685c16.b(r24)
                r2 = r24
                ir.nasim.a16 r2 = (ir.nasim.C9475a16) r2
                java.lang.Object r2 = r2.l()
                goto L4b
            L2f:
                ir.nasim.AbstractC10685c16.b(r24)
                ir.nasim.Wy6 r2 = ir.nasim.C8671Wy6.this
                ir.nasim.Lm5 r2 = ir.nasim.C8671Wy6.G1(r2)
                ir.nasim.Wy6 r5 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r5 = r5.v3()
                int r5 = r5.getPeerId()
                r0.d = r4
                java.lang.Object r2 = r2.k(r5, r4, r0)
                if (r2 != r1) goto L4b
                return r1
            L4b:
                ir.nasim.Wy6 r4 = ir.nasim.C8671Wy6.this
                boolean r5 = ir.nasim.C9475a16.j(r2)
                if (r5 == 0) goto Ld1
                r5 = r2
                ai.bale.proto.PremiumOuterClass$ResponseIsPremium r5 = (ai.bale.proto.PremiumOuterClass$ResponseIsPremium) r5
                ai.bale.proto.PremiumStruct$UserPremiumStatus r6 = r5.getUserStatus()
                boolean r6 = r6.getIsPremium()
                if (r6 == 0) goto Ld1
                ir.nasim.Lm5 r6 = ir.nasim.C8671Wy6.G1(r4)
                ai.bale.proto.PremiumStruct$UserPremiumStatus r7 = r5.getUserStatus()
                ai.bale.proto.PremiumStruct$UserPremiumDetail r7 = r7.getDetail()
                ai.bale.proto.PremiumStruct$Badge r7 = r7.getBadge()
                long r7 = r7.getBadgeId()
                ai.bale.proto.PremiumStruct$UserPremiumStatus r5 = r5.getUserStatus()
                ai.bale.proto.PremiumStruct$UserPremiumDetail r5 = r5.getDetail()
                ai.bale.proto.PremiumStruct$Badge r5 = r5.getBadge()
                java.lang.String r5 = r5.getMediaUrl()
                java.lang.String r9 = "getMediaUrl(...)"
                ir.nasim.AbstractC13042fc3.h(r5, r9)
                ir.nasim.Fq2 r5 = r6.l(r7, r5)
                r0.b = r2
                r0.c = r4
                r0.d = r3
                java.lang.Object r2 = ir.nasim.AbstractC6459Nq2.I(r5, r0)
                if (r2 != r1) goto L9a
                return r1
            L9a:
                r1 = r4
            L9b:
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto Ld1
                ir.nasim.Zm4 r1 = ir.nasim.C8671Wy6.p1(r1)
            La3:
                java.lang.Object r15 = r1.getValue()
                r3 = r15
                ir.nasim.Gz1$b r3 = (ir.nasim.AbstractC4886Gz1.b) r3
                r20 = 32767(0x7fff, float:4.5916E-41)
                r21 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r16 = 0
                r22 = r15
                r15 = r16
                r17 = 0
                r18 = 0
                r19 = r2
                ir.nasim.Gz1$b r3 = ir.nasim.AbstractC4886Gz1.b.b(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
                r4 = r22
                boolean r3 = r1.f(r4, r3)
                if (r3 == 0) goto La3
            Ld1:
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.A.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$B */
    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        B(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new B(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                V24 v24 = C8671Wy6.this.g;
                this.b = 1;
                if (v24.h(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Q14 d;

        /* renamed from: ir.nasim.Wy6$C$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8671Wy6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8671Wy6 c8671Wy6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8671Wy6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    V24 v24 = this.c.g;
                    this.b = 1;
                    if (v24.h(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(Q14 q14, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = q14;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5T2 = C8671Wy6.this.b.t2(C8671Wy6.this.v3().getPeerId(), this.d.f());
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5T2, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C8671Wy6 c8671Wy6 = C8671Wy6.this;
            Q14 q14 = this.d;
            if (C9475a16.j(objD)) {
                AbstractC10533bm0.d(AbstractC9773aX7.a(c8671Wy6), null, null, new a(c8671Wy6, null), 3, null);
                String string = c8671Wy6.D0.getString(c8671Wy6.f1 == ExPeerType.GROUP ? RD5.user_kicked_from_group : RD5.user_kicked_from_channel, q14.e(), c8671Wy6.s3());
                AbstractC13042fc3.h(string, "getString(...)");
                c8671Wy6.I2(string);
            }
            C8671Wy6 c8671Wy62 = C8671Wy6.this;
            Throwable thE = C9475a16.e(objD);
            if (thE != null) {
                if (thE instanceof RpcException) {
                    c8671Wy62.G2((Exception) thE);
                } else {
                    c8671Wy62.G2(new Exception(thE));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$D */
    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        D(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new D(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24651yy6 c24651yy6 = C8671Wy6.this.G0;
                ExPeer exPeer = new ExPeer(C8671Wy6.this.f1, C8671Wy6.this.v3().getPeerId());
                this.b = 1;
                obj = c24651yy6.c(exPeer, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            List listP1 = AbstractC15401jX0.p1(C8671Wy6.this.e4((List) obj));
            if (!C8671Wy6.this.U3()) {
                listP1.add(listP1.size(), AbstractC6392Nk0.d(RD5.media_link));
            }
            if (C8671Wy6.this.d3() == ExPeerType.PRIVATE && C8386Vt0.W7() && C8671Wy6.this.v3().getPeerId() != C8671Wy6.this.r3()) {
                listP1.add(listP1.size(), AbstractC6392Nk0.d(RD5.mutual_group));
            }
            if (C8671Wy6.this.d3() == ExPeerType.BOT && C8386Vt0.a.N4()) {
                listP1.add(0, AbstractC6392Nk0.d(RD5.media_recommended_peer_bot));
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C8671Wy6.this.M0;
            this.b = 2;
            if (interfaceC9336Zm4.a(listP1, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$E */
    public static final class E implements Comparator {
        final /* synthetic */ Map a;

        public E(Map map) {
            this.a = map;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) this.a.get(((C3697By6) obj).a());
            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            Integer num2 = (Integer) this.a.get(((C3697By6) obj2).a());
            return AbstractC18050o01.d(numValueOf, Integer.valueOf(num2 != null ? num2.intValue() : Integer.MAX_VALUE));
        }
    }

    /* renamed from: ir.nasim.Wy6$F */
    static final class F extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC17445my6 d;
        final /* synthetic */ C8671Wy6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        F(InterfaceC17445my6 interfaceC17445my6, C8671Wy6 c8671Wy6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC17445my6;
            this.e = c8671Wy6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            F f = new F(this.d, this.e, interfaceC20295rm1);
            f.c = obj;
            return f;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC3346Am2 interfaceC3346Am2A;
            String descriptor;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            try {
                try {
                    TY1 ty1D = this.d.d();
                    TY1.a aVar = ty1D instanceof TY1.a ? (TY1.a) ty1D : null;
                    if (aVar != null && (interfaceC3346Am2A = aVar.a()) != null && (descriptor = interfaceC3346Am2A.getDescriptor()) != null) {
                        C18987pb3.a.C1(this.e.D0, descriptor, descriptor);
                    }
                } catch (Exception e) {
                    C19406qI3.c("SharedMediaViewModel", "openFile: " + e, e);
                    this.e.H2(RD5.toast_unable_open);
                }
                AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
                return C19938rB7.a;
            } catch (Throwable th) {
                AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$G */
    static final class G implements SA2 {
        G() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final YT4 invoke() {
            return C8671Wy6.this.B.a(C8671Wy6.this.v3().getPeerId(), C8671Wy6.this.i3().x(), C8671Wy6.this.U0.e());
        }
    }

    /* renamed from: ir.nasim.Wy6$H */
    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* renamed from: ir.nasim.Wy6$H$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8671Wy6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8671Wy6 c8671Wy6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8671Wy6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    V24 v24 = this.c.g;
                    this.b = 1;
                    if (v24.h(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new H(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5R2 = C8671Wy6.this.b.R2(C8671Wy6.this.v3().getPeerId(), this.d);
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5R2, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C8671Wy6 c8671Wy6 = C8671Wy6.this;
            if (C9475a16.j(objD)) {
                AbstractC10533bm0.d(AbstractC9773aX7.a(c8671Wy6), null, null, new a(c8671Wy6, null), 3, null);
            }
            C8671Wy6 c8671Wy62 = C8671Wy6.this;
            Throwable thE = C9475a16.e(objD);
            if (thE != null) {
                if (thE instanceof RpcException) {
                    c8671Wy62.G2((Exception) thE);
                } else {
                    c8671Wy62.G2(new Exception(thE));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$I */
    public static final class I implements InterfaceC15419jZ0 {
        I() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public /* bridge */ /* synthetic */ void a(Object obj) {
            b(((Boolean) obj).booleanValue());
        }

        public void b(boolean z) {
            if (z) {
                C8671Wy6.this.H2(RD5.contact_deleted);
                C8671Wy6.this.K3().z().i(Boolean.FALSE);
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C8671Wy6.this.H2(RD5.security_toast_unable_to_load);
        }
    }

    /* renamed from: ir.nasim.Wy6$J */
    static final class J extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        J(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C8671Wy6.this.r4(null, this);
        }
    }

    /* renamed from: ir.nasim.Wy6$K */
    static final class K extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        K(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            K k = C8671Wy6.this.new K(this.e, interfaceC20295rm1);
            k.c = obj;
            return k;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                r23 = this;
                r1 = r23
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r1.b
                r3 = 1
                if (r2 == 0) goto L23
                if (r2 != r3) goto L1b
                ir.nasim.AbstractC10685c16.b(r24)     // Catch: java.lang.Throwable -> L19
                r0 = r24
                ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0     // Catch: java.lang.Throwable -> L19
                java.lang.Object r0 = r0.l()     // Catch: java.lang.Throwable -> L19
                goto L49
            L19:
                r0 = move-exception
                goto L52
            L1b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L23:
                ir.nasim.AbstractC10685c16.b(r24)
                java.lang.Object r2 = r1.c
                ir.nasim.ro1 r2 = (ir.nasim.InterfaceC20315ro1) r2
                ir.nasim.Vt0 r2 = ir.nasim.C8386Vt0.a
                boolean r2 = r2.R4()
                if (r2 != 0) goto L35
                ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                return r0
            L35:
                ir.nasim.Wy6 r2 = ir.nasim.C8671Wy6.this
                int r4 = r1.e
                ir.nasim.a16$a r5 = ir.nasim.C9475a16.b     // Catch: java.lang.Throwable -> L19
                ir.nasim.uE0 r2 = ir.nasim.C8671Wy6.l1(r2)     // Catch: java.lang.Throwable -> L19
                r1.b = r3     // Catch: java.lang.Throwable -> L19
                java.lang.Object r2 = r2.a(r4, r1)     // Catch: java.lang.Throwable -> L19
                if (r2 != r0) goto L48
                return r0
            L48:
                r0 = r2
            L49:
                ir.nasim.a16 r0 = ir.nasim.C9475a16.a(r0)     // Catch: java.lang.Throwable -> L19
                java.lang.Object r0 = ir.nasim.C9475a16.b(r0)     // Catch: java.lang.Throwable -> L19
                goto L5c
            L52:
                ir.nasim.a16$a r2 = ir.nasim.C9475a16.b
                java.lang.Object r0 = ir.nasim.AbstractC10685c16.a(r0)
                java.lang.Object r0 = ir.nasim.C9475a16.b(r0)
            L5c:
                boolean r2 = ir.nasim.C9475a16.g(r0)
                r3 = 0
                if (r2 == 0) goto L64
                r0 = r3
            L64:
                ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
                if (r0 == 0) goto L7d
                java.lang.Object r0 = r0.l()
                boolean r2 = ir.nasim.C9475a16.g(r0)
                if (r2 == 0) goto L73
                goto L74
            L73:
                r3 = r0
            L74:
                java.lang.Boolean r3 = (java.lang.Boolean) r3
                if (r3 == 0) goto L7d
                boolean r0 = r3.booleanValue()
                goto L7e
            L7d:
                r0 = 0
            L7e:
                ir.nasim.Wy6 r2 = ir.nasim.C8671Wy6.this
                ir.nasim.Zm4 r2 = ir.nasim.C8671Wy6.p1(r2)
            L84:
                java.lang.Object r15 = r2.getValue()
                r17 = r15
                ir.nasim.Gz1$b r17 = (ir.nasim.AbstractC4886Gz1.b) r17
                r19 = 49151(0xbfff, float:6.8875E-41)
                r20 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r16 = 0
                r21 = r15
                r15 = r16
                r16 = 0
                r18 = 0
                r22 = r2
                r2 = r17
                r17 = r0
                ir.nasim.Gz1$b r2 = ir.nasim.AbstractC4886Gz1.b.b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
                r4 = r21
                r3 = r22
                boolean r2 = r3.f(r4, r2)
                if (r2 == 0) goto Lbe
                ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                return r0
            Lbe:
                r2 = r3
                goto L84
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.K.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((K) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$L */
    static final class L extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C8671Wy6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        L(boolean z, C8671Wy6 c8671Wy6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c8671Wy6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new L(this.c, this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x008f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a4 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                ir.nasim.AbstractC10685c16.b(r7)
                goto La5
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L90
            L23:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L66
            L27:
                ir.nasim.AbstractC10685c16.b(r7)
                boolean r7 = r6.c
                if (r7 != 0) goto L90
                ir.nasim.Wy6 r7 = r6.d
                java.util.List r7 = ir.nasim.C8671Wy6.I1(r7)
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.Iterator r7 = r7.iterator()
            L3a:
                boolean r1 = r7.hasNext()
                if (r1 == 0) goto L4a
                java.lang.Object r1 = r7.next()
                ir.nasim.my6 r1 = (ir.nasim.InterfaceC17445my6) r1
                r1.c(r5)
                goto L3a
            L4a:
                ir.nasim.Wy6 r7 = r6.d
                java.util.List r7 = ir.nasim.C8671Wy6.I1(r7)
                r7.clear()
                ir.nasim.Wy6 r7 = r6.d
                ir.nasim.Zm4 r7 = r7.G3()
                java.lang.Integer r1 = ir.nasim.AbstractC6392Nk0.d(r5)
                r6.b = r4
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto L66
                return r0
            L66:
                ir.nasim.Wy6 r7 = r6.d
                ir.nasim.Zm4 r7 = ir.nasim.C8671Wy6.J1(r7)
            L6c:
                java.lang.Object r1 = r7.getValue()
                r4 = r1
                java.util.List r4 = (java.util.List) r4
                java.util.List r4 = ir.nasim.ZW0.m()
                boolean r1 = r7.f(r1, r4)
                if (r1 == 0) goto L6c
                ir.nasim.Wy6 r7 = r6.d
                ir.nasim.Zm4 r7 = r7.G3()
                java.lang.Integer r1 = ir.nasim.AbstractC6392Nk0.d(r5)
                r6.b = r3
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto L90
                return r0
            L90:
                ir.nasim.Wy6 r7 = r6.d
                ir.nasim.Zm4 r7 = ir.nasim.C8671Wy6.Q1(r7)
                boolean r1 = r6.c
                java.lang.Boolean r1 = ir.nasim.AbstractC6392Nk0.a(r1)
                r6.b = r2
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto La5
                return r0
            La5:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.L.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((L) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$M */
    static final class M extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        M(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new M(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C8671Wy6.this.E0.a(C8671Wy6.this.v3().getPeerId(), C8671Wy6.this.f1);
                C8671Wy6 c8671Wy6 = C8671Wy6.this;
                this.b = 1;
                if (c8671Wy6.E4(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (C8671Wy6.this.v3().C()) {
                C8671Wy6.this.c.j0(C8671Wy6.this.v3().getPeerId());
            } else {
                C8671Wy6.this.b.T1(C8671Wy6.this.v3());
            }
            C8671Wy6.this.e.a(C8671Wy6.this.v3(), C8671Wy6.this.f1);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((M) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$N */
    static final class N extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        N(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C8671Wy6.this.E4(this);
        }
    }

    /* renamed from: ir.nasim.Wy6$O */
    static final class O extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ C8671Wy6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        O(UA2 ua2, C8671Wy6 c8671Wy6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = c8671Wy6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new O(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            UA2 ua2;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua22 = this.d;
                InterfaceC21103t7 interfaceC21103t7 = this.e.u;
                int peerId = this.e.v3().getPeerId();
                this.b = ua22;
                this.c = 1;
                Object objD = interfaceC21103t7.d(peerId, this);
                if (objD == objE) {
                    return objE;
                }
                ua2 = ua22;
                objL = objD;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua2 = (UA2) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            Boolean boolA = AbstractC6392Nk0.a(false);
            if (C9475a16.g(objL)) {
                objL = boolA;
            }
            ua2.invoke(objL);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((O) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$P */
    public static final class P extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C8671Wy6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public P(InterfaceC20295rm1 interfaceC20295rm1, C8671Wy6 c8671Wy6) {
            super(3, interfaceC20295rm1);
            this.e = c8671Wy6;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4557Fq2 interfaceC4557Fq2A;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                String str = (String) this.d;
                if (str.length() == 0) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.e.P0;
                    do {
                        value = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value, AbstractC17858ng6.b.b));
                    interfaceC4557Fq2A = new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, this.e.new y(), 2, null).a();
                } else {
                    interfaceC4557Fq2A = new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, this.e.new z(str), 2, null).a();
                }
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2A, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            P p = new P(interfaceC20295rm1, this.e);
            p.c = interfaceC4806Gq2;
            p.d = obj;
            return p.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$Q */
    public static final class Q extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C8671Wy6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Q(InterfaceC20295rm1 interfaceC20295rm1, C8671Wy6 c8671Wy6) {
            super(3, interfaceC20295rm1);
            this.e = c8671Wy6;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00bf A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 0
                r4 = 1
                r5 = 2
                if (r2 == 0) goto L29
                if (r2 == r4) goto L1e
                if (r2 != r5) goto L16
                ir.nasim.AbstractC10685c16.b(r19)
                goto Lc0
            L16:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L1e:
                java.lang.Object r2 = r0.c
                ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                ir.nasim.AbstractC10685c16.b(r19)
                r4 = r19
                goto Lb1
            L29:
                ir.nasim.AbstractC10685c16.b(r19)
                java.lang.Object r2 = r0.c
                ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                java.lang.Object r6 = r0.d
                java.lang.String r6 = (java.lang.String) r6
                int r7 = r6.length()
                r8 = 0
                if (r7 != 0) goto L7a
                ir.nasim.Wy6 r4 = r0.e
                ir.nasim.Zm4 r7 = ir.nasim.C8671Wy6.T1(r4)
            L41:
                java.lang.Object r4 = r7.getValue()
                r6 = r4
                ir.nasim.fi6 r6 = (ir.nasim.C13132fi6) r6
                ir.nasim.ng6$b r9 = ir.nasim.AbstractC17858ng6.b.b
                ir.nasim.fi6 r6 = r6.a(r9, r8)
                boolean r4 = r7.f(r4, r6)
                if (r4 == 0) goto L41
                ir.nasim.fT4 r4 = new ir.nasim.fT4
                ir.nasim.MT4 r15 = new ir.nasim.MT4
                r13 = 50
                r14 = 0
                r7 = 50
                r8 = 0
                r9 = 0
                r10 = 50
                r11 = 0
                r12 = 0
                r6 = r15
                r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
                ir.nasim.Wy6$G r12 = new ir.nasim.Wy6$G
                ir.nasim.Wy6 r6 = r0.e
                r12.<init>()
                r13 = 2
                r11 = 0
                r9 = r4
                r10 = r15
                r9.<init>(r10, r11, r12, r13, r14)
                ir.nasim.Fq2 r4 = r4.a()
                goto Lb5
            L7a:
                ir.nasim.Wy6 r7 = r0.e
                ir.nasim.Zm4 r7 = ir.nasim.C8671Wy6.T1(r7)
            L80:
                java.lang.Object r9 = r7.getValue()
                r10 = r9
                ir.nasim.fi6 r10 = (ir.nasim.C13132fi6) r10
                ir.nasim.ng6$a r15 = new ir.nasim.ng6$a
                r16 = 5
                r17 = 0
                r12 = 0
                r13 = 1
                r14 = 0
                r11 = r15
                r4 = r15
                r15 = r16
                r16 = r17
                r11.<init>(r12, r13, r14, r15, r16)
                ir.nasim.fi6 r4 = ir.nasim.C13132fi6.b(r10, r4, r8, r5, r3)
                boolean r4 = r7.f(r9, r4)
                if (r4 == 0) goto Lc3
                ir.nasim.Wy6 r4 = r0.e
                r0.c = r2
                r9 = 1
                r0.b = r9
                java.lang.Object r4 = ir.nasim.C8671Wy6.X1(r4, r6, r0)
                if (r4 != r1) goto Lb1
                return r1
            Lb1:
                ir.nasim.Fq2 r4 = ir.nasim.AbstractC6459Nq2.T(r4)
            Lb5:
                r0.c = r3
                r0.b = r5
                java.lang.Object r2 = ir.nasim.AbstractC6459Nq2.A(r2, r4, r0)
                if (r2 != r1) goto Lc0
                return r1
            Lc0:
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            Lc3:
                r4 = 1
                goto L80
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.Q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            Q q = new Q(interfaceC20295rm1, this.e);
            q.c = interfaceC4806Gq2;
            q.d = obj;
            return q.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$R */
    static final class R extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        R(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C8671Wy6.this.I4(0, null, this);
        }
    }

    /* renamed from: ir.nasim.Wy6$S */
    static final class S extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        S(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new S(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                V24 v24 = C8671Wy6.this.g;
                this.b = 1;
                if (v24.h(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((S) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$T */
    static final class T extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        T(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            L5 l5 = (L5) this.c;
            return l5 instanceof L5.a ? PA7.a.b : l5 instanceof L5.b ? new PA7.b(new AbstractC4886Gz1.a(((L5.b) l5).a())) : l5 instanceof L5.c ? new PA7.c((AbstractC4886Gz1.b) this.d) : PA7.a.b;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(L5 l5, AbstractC4886Gz1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            T t = new T(interfaceC20295rm1);
            t.c = l5;
            t.d = bVar;
            return t.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$a, reason: case insensitive filesystem */
    static final class C8672a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Wy6$a$a, reason: collision with other inner class name */
        static final class C0740a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C8671Wy6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0740a(C8671Wy6 c8671Wy6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c8671Wy6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0740a c0740a = new C0740a(this.d, interfaceC20295rm1);
                c0740a.c = obj;
                return c0740a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Set set = (Set) this.c;
                    InterfaceC4308Eo5 interfaceC4308Eo5 = this.d.Z;
                    List listM1 = AbstractC15401jX0.m1(set);
                    this.b = 1;
                    if (interfaceC4308Eo5.f(listM1, true, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0740a) create(set, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Wy6$a$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Wy6$a$b$a, reason: collision with other inner class name */
            public static final class C0741a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Wy6$a$b$a$a, reason: collision with other inner class name */
                public static final class C0742a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0742a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C0741a.this.a(null, this);
                    }
                }

                public C0741a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C8671Wy6.C8672a.b.C0741a.C0742a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Wy6$a$b$a$a r0 = (ir.nasim.C8671Wy6.C8672a.b.C0741a.C0742a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Wy6$a$b$a$a r0 = new ir.nasim.Wy6$a$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.util.Set r2 = (java.util.Set) r2
                        java.util.Collection r2 = (java.util.Collection) r2
                        boolean r2 = r2.isEmpty()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L4b
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.C8672a.b.C0741a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C0741a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        C8672a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8672a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(C8671Wy6.this.U0.d());
                C0740a c0740a = new C0740a(C8671Wy6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, c0740a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8672a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$b, reason: case insensitive filesystem */
    public static final class C8673b {
        private C8673b() {
        }

        public /* synthetic */ C8673b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Wy6$c, reason: case insensitive filesystem */
    public /* synthetic */ class C8674c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC18627oy6.values().length];
            try {
                iArr2[EnumC18627oy6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[EnumC18627oy6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC18627oy6.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC18627oy6.a.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC18627oy6.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.Wy6$d, reason: case insensitive filesystem */
    public static final class C8675d implements InterfaceC15419jZ0 {
        C8675d() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public /* bridge */ /* synthetic */ void a(Object obj) {
            b(((Boolean) obj).booleanValue());
        }

        public void b(boolean z) {
            if (z) {
                C8671Wy6.this.H2(RD5.contact_added);
                C8671Wy6.this.K3().z().i(Boolean.TRUE);
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C8671Wy6.this.H2(RD5.security_toast_unable_to_load);
        }
    }

    /* renamed from: ir.nasim.Wy6$e, reason: case insensitive filesystem */
    public static final class C8676e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C8671Wy6 b;

        /* renamed from: ir.nasim.Wy6$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C8671Wy6 b;

            /* renamed from: ir.nasim.Wy6$e$a$a, reason: collision with other inner class name */
            public static final class C0743a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0743a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C8671Wy6 c8671Wy6) {
                this.a = interfaceC4806Gq2;
                this.b = c8671Wy6;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C8671Wy6.C8676e.a.C0743a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Wy6$e$a$a r0 = (ir.nasim.C8671Wy6.C8676e.a.C0743a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Wy6$e$a$a r0 = new ir.nasim.Wy6$e$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L56
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    boolean r5 = r5.booleanValue()
                    if (r5 == 0) goto L48
                    ir.nasim.Wy6 r5 = r4.b
                    boolean r5 = r5.X3()
                    if (r5 != 0) goto L48
                    r5 = r3
                    goto L49
                L48:
                    r5 = 0
                L49:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L56
                    return r1
                L56:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.C8676e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public C8676e(InterfaceC4557Fq2 interfaceC4557Fq2, C8671Wy6 c8671Wy6) {
            this.a = interfaceC4557Fq2;
            this.b = c8671Wy6;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wy6$f, reason: case insensitive filesystem */
    static final class C8677f extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        C8677f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objK2 = C8671Wy6.this.k2(null, this);
            return objK2 == AbstractC14862ic3.e() ? objK2 : C9475a16.a(objK2);
        }
    }

    /* renamed from: ir.nasim.Wy6$g, reason: case insensitive filesystem */
    static final class C8678g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C8671Wy6 d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8678g(boolean z, C8671Wy6 c8671Wy6, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c8671Wy6;
            this.e = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C8678g(this.c, this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L2c
                if (r1 == r4) goto L22
                if (r1 != r2) goto L1a
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L9e
            L1a:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L22:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L51
            L2c:
                ir.nasim.AbstractC10685c16.b(r7)
                boolean r7 = r6.c
                r1 = 0
                if (r7 == 0) goto L81
                ir.nasim.Wy6 r7 = r6.d
                ir.nasim.OK7 r7 = ir.nasim.C8671Wy6.N1(r7)
                ir.nasim.Wy6 r2 = r6.d
                ir.nasim.d25 r2 = r2.v3()
                int r2 = r2.getPeerId()
                ir.nasim.Nv5 r7 = r7.U(r2)
                r6.b = r4
                java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r1, r6, r4, r1)
                if (r7 != r0) goto L51
                return r0
            L51:
                ir.nasim.Wy6 r0 = r6.d
                ir.nasim.SA2 r1 = r6.e
                boolean r2 = ir.nasim.C9475a16.j(r7)
                if (r2 == 0) goto L75
                r2 = r7
                ir.nasim.i18 r2 = (ir.nasim.C14505i18) r2
                ir.nasim.C8671Wy6.c2(r0, r4)
                ir.nasim.tK7 r0 = r0.K3()
                ir.nasim.Wh0 r0 = r0.p()
                java.lang.Boolean r2 = ir.nasim.AbstractC6392Nk0.a(r4)
                r0.i(r2)
                if (r1 == 0) goto L75
                r1.invoke()
            L75:
                ir.nasim.Wy6 r0 = r6.d
                java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
                if (r7 == 0) goto Lc6
                ir.nasim.C8671Wy6.c2(r0, r3)
                goto Lc6
            L81:
                ir.nasim.Wy6 r7 = r6.d
                ir.nasim.OK7 r7 = ir.nasim.C8671Wy6.N1(r7)
                ir.nasim.Wy6 r5 = r6.d
                ir.nasim.d25 r5 = r5.v3()
                int r5 = r5.getPeerId()
                ir.nasim.Nv5 r7 = r7.C0(r5)
                r6.b = r2
                java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r1, r6, r4, r1)
                if (r7 != r0) goto L9e
                return r0
            L9e:
                ir.nasim.Wy6 r0 = r6.d
                boolean r1 = ir.nasim.C9475a16.j(r7)
                if (r1 == 0) goto Lbb
                r1 = r7
                ir.nasim.i18 r1 = (ir.nasim.C14505i18) r1
                ir.nasim.C8671Wy6.c2(r0, r4)
                ir.nasim.tK7 r0 = r0.K3()
                ir.nasim.Wh0 r0 = r0.p()
                java.lang.Boolean r1 = ir.nasim.AbstractC6392Nk0.a(r3)
                r0.i(r1)
            Lbb:
                ir.nasim.Wy6 r0 = r6.d
                java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
                if (r7 == 0) goto Lc6
                ir.nasim.C8671Wy6.c2(r0, r3)
            Lc6:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.C8678g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8678g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$h, reason: case insensitive filesystem */
    static final class C8679h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ String d;
        final /* synthetic */ C8671Wy6 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8679h(String str, C8671Wy6 c8671Wy6, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = c8671Wy6;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C8679h(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C8671Wy6 c8671Wy6;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String str = this.d;
                if (str != null) {
                    C8671Wy6 c8671Wy62 = this.e;
                    int i2 = this.f;
                    C17039mI0 c17039mI0 = c8671Wy62.i;
                    this.b = c8671Wy62;
                    this.c = 1;
                    if (c17039mI0.a(i2, str, this) == objE) {
                        return objE;
                    }
                    c8671Wy6 = c8671Wy62;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c8671Wy6 = (C8671Wy6) this.b;
            AbstractC10685c16.b(obj);
            String string = c8671Wy6.D0.getString(c8671Wy6.f1 == ExPeerType.GROUP ? RD5.group_avatar_changed : RD5.channel_avatar_changed, c8671Wy6.s3());
            AbstractC13042fc3.h(string, "getString(...)");
            c8671Wy6.I2(string);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8679h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$i, reason: case insensitive filesystem */
    static final class C8680i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C8680i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8680i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                V24 v24 = C8671Wy6.this.g;
                this.b = 1;
                if (v24.h(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8680i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$j, reason: case insensitive filesystem */
    static final class C8681j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8681j(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8681j(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L8b
            L18:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L20:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L4f
            L2a:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r7 = r7.v3()
                boolean r7 = r7.C()
                r1 = 0
                if (r7 == 0) goto L6c
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.OK7 r7 = ir.nasim.C8671Wy6.N1(r7)
                java.lang.String r2 = r6.d
                ir.nasim.Nv5 r7 = r7.X(r2)
                r6.b = r3
                java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r1, r6, r3, r1)
                if (r7 != r0) goto L4f
                return r0
            L4f:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                boolean r1 = ir.nasim.C9475a16.j(r7)
                if (r1 == 0) goto L5f
                r1 = r7
                ir.nasim.i18 r1 = (ir.nasim.C14505i18) r1
                int r1 = ir.nasim.RD5.your_about_text_changed
                r0.H2(r1)
            L5f:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
                if (r7 == 0) goto Ld5
                r7 = 0
                ir.nasim.C8671Wy6.c2(r0, r7)
                goto Ld5
            L6c:
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.bQ2 r7 = ir.nasim.C8671Wy6.z1(r7)
                ir.nasim.Wy6 r4 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r4 = r4.v3()
                int r4 = r4.getPeerId()
                java.lang.String r5 = r6.d
                ir.nasim.Nv5 r7 = r7.D1(r4, r5)
                r6.b = r2
                java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r1, r6, r3, r1)
                if (r7 != r0) goto L8b
                return r0
            L8b:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                boolean r1 = ir.nasim.C9475a16.j(r7)
                if (r1 == 0) goto Lbb
                r1 = r7
                ir.nasim.i18 r1 = (ir.nasim.C14505i18) r1
                android.content.Context r1 = ir.nasim.C8671Wy6.o1(r0)
                ir.nasim.core.modules.profile.entity.ExPeerType r2 = ir.nasim.C8671Wy6.t1(r0)
                ir.nasim.core.modules.profile.entity.ExPeerType r3 = ir.nasim.core.modules.profile.entity.ExPeerType.GROUP
                if (r2 != r3) goto La5
                int r2 = ir.nasim.RD5.group_about_changed
                goto La7
            La5:
                int r2 = ir.nasim.RD5.channel_about_changed
            La7:
                java.lang.String r3 = r0.s3()
                java.lang.Object[] r3 = new java.lang.Object[]{r3}
                java.lang.String r1 = r1.getString(r2, r3)
                java.lang.String r2 = "getString(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r2)
                r0.I2(r1)
            Lbb:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
                if (r7 == 0) goto Ld5
                boolean r1 = r7 instanceof ir.nasim.core.network.RpcException
                if (r1 == 0) goto Lcd
                java.lang.Exception r7 = (java.lang.Exception) r7
                ir.nasim.C8671Wy6.e1(r0, r7)
                goto Ld5
            Lcd:
                java.lang.Exception r1 = new java.lang.Exception
                r1.<init>(r7)
                ir.nasim.C8671Wy6.e1(r0, r1)
            Ld5:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.C8681j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8681j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$k, reason: case insensitive filesystem */
    static final class C8682k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ C8671Wy6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8682k(String str, C8671Wy6 c8671Wy6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = c8671Wy6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C8682k(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String str = this.c;
                if (str != null) {
                    C17039mI0 c17039mI0 = this.d.i;
                    this.b = 1;
                    if (c17039mI0.b(str, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8682k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$l, reason: case insensitive filesystem */
    static final class C8683l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8683l(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8683l(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto La9
            L19:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L21:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L60
            L2b:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r7 = r7.v3()
                boolean r7 = r7.C()
                r1 = 0
                if (r7 == 0) goto L7e
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r7 = r7.v3()
                int r7 = r7.getPeerId()
                int r4 = ir.nasim.AbstractC5969Lp4.f()
                if (r7 != r4) goto L7e
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.OK7 r7 = ir.nasim.C8671Wy6.N1(r7)
                java.lang.String r2 = r6.d
                ir.nasim.Nv5 r7 = r7.Z(r2)
                r6.b = r3
                java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r1, r6, r3, r1)
                if (r7 != r0) goto L60
                return r0
            L60:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                boolean r1 = ir.nasim.C9475a16.j(r7)
                if (r1 == 0) goto L70
                r1 = r7
                ir.nasim.i18 r1 = (ir.nasim.C14505i18) r1
                int r1 = ir.nasim.RD5.your_name_changed
                r0.H2(r1)
            L70:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
                if (r7 == 0) goto Lf7
                r7 = 0
                ir.nasim.C8671Wy6.c2(r0, r7)
                goto Lf7
            L7e:
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r7 = r7.v3()
                boolean r7 = r7.z()
                if (r7 == 0) goto Lf7
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.bQ2 r7 = ir.nasim.C8671Wy6.z1(r7)
                ir.nasim.Wy6 r4 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r4 = r4.v3()
                int r4 = r4.getPeerId()
                java.lang.String r5 = r6.d
                ir.nasim.Nv5 r7 = r7.J1(r4, r5)
                r6.b = r2
                java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r1, r6, r3, r1)
                if (r7 != r0) goto La9
                return r0
            La9:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                java.lang.String r1 = r6.d
                boolean r2 = ir.nasim.C9475a16.j(r7)
                if (r2 == 0) goto Ldd
                r2 = r7
                ir.nasim.i18 r2 = (ir.nasim.C14505i18) r2
                android.content.Context r2 = ir.nasim.C8671Wy6.o1(r0)
                ir.nasim.core.modules.profile.entity.ExPeerType r3 = ir.nasim.C8671Wy6.t1(r0)
                ir.nasim.core.modules.profile.entity.ExPeerType r4 = ir.nasim.core.modules.profile.entity.ExPeerType.GROUP
                if (r3 != r4) goto Lc5
                int r3 = ir.nasim.RD5.group_name_changed
                goto Lc7
            Lc5:
                int r3 = ir.nasim.RD5.channel_name_changed
            Lc7:
                r4 = 30
                java.lang.String r1 = ir.nasim.AbstractC14836iZ6.A1(r1, r4)
                java.lang.Object[] r1 = new java.lang.Object[]{r1}
                java.lang.String r1 = r2.getString(r3, r1)
                java.lang.String r2 = "getString(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r2)
                r0.I2(r1)
            Ldd:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
                if (r7 == 0) goto Lf7
                boolean r1 = r7 instanceof ir.nasim.core.network.RpcException
                if (r1 == 0) goto Lef
                java.lang.Exception r7 = (java.lang.Exception) r7
                ir.nasim.C8671Wy6.e1(r0, r7)
                goto Lf7
            Lef:
                java.lang.Exception r1 = new java.lang.Exception
                r1.<init>(r7)
                ir.nasim.C8671Wy6.e1(r0, r1)
            Lf7:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.C8683l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8683l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$m, reason: case insensitive filesystem */
    static final class C8684m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8684m(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8684m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19854r32 c19854r32 = C8671Wy6.this.l;
                int peerId = C8671Wy6.this.v3().getPeerId();
                String str = this.d;
                this.b = 1;
                objB = c19854r32.b(peerId, str, this);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            C8671Wy6 c8671Wy6 = C8671Wy6.this;
            if (C9475a16.j(objB)) {
                ((Boolean) objB).booleanValue();
                String string = c8671Wy6.D0.getString(RD5.edit_channel_nick_name_toast_profile_fragment, c8671Wy6.s3());
                AbstractC13042fc3.h(string, "getString(...)");
                c8671Wy6.I2(string);
            }
            C8671Wy6 c8671Wy62 = C8671Wy6.this;
            if (C9475a16.e(objB) != null) {
                c8671Wy62.J4(false);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8684m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$n, reason: case insensitive filesystem */
    static final class C8685n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        /* renamed from: ir.nasim.Wy6$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ C8671Wy6 d;
            final /* synthetic */ int e;
            final /* synthetic */ String f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8671Wy6 c8671Wy6, int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c8671Wy6;
                this.e = i;
                this.f = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, this.e, this.f, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r6.c
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L26
                    if (r1 == r3) goto L1c
                    if (r1 != r2) goto L14
                    java.lang.Object r0 = r6.b
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L5d
                L14:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1c:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                    java.lang.Object r7 = r7.l()
                    goto L42
                L26:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Wy6 r7 = r6.d
                    ir.nasim.t7 r7 = ir.nasim.C8671Wy6.h1(r7)
                    ir.nasim.Wy6 r1 = r6.d
                    ir.nasim.d25 r1 = r1.v3()
                    int r1 = r1.getPeerId()
                    r6.c = r3
                    java.lang.Object r7 = r7.f(r1, r6)
                    if (r7 != r0) goto L42
                    return r0
                L42:
                    ir.nasim.Wy6 r1 = r6.d
                    int r3 = r6.e
                    java.lang.String r4 = r6.f
                    boolean r5 = ir.nasim.C9475a16.j(r7)
                    if (r5 == 0) goto L5e
                    r5 = r7
                    ir.nasim.rB7 r5 = (ir.nasim.C19938rB7) r5
                    r6.b = r7
                    r6.c = r2
                    java.lang.Object r1 = ir.nasim.C8671Wy6.a2(r1, r3, r4, r6)
                    if (r1 != r0) goto L5c
                    return r0
                L5c:
                    r0 = r7
                L5d:
                    r7 = r0
                L5e:
                    ir.nasim.Wy6 r0 = r6.d
                    java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
                    if (r7 == 0) goto L78
                    boolean r1 = r7 instanceof ir.nasim.core.network.RpcException
                    if (r1 == 0) goto L70
                    java.lang.Exception r7 = (java.lang.Exception) r7
                    ir.nasim.C8671Wy6.e1(r0, r7)
                    goto L78
                L70:
                    java.lang.Exception r1 = new java.lang.Exception
                    r1.<init>(r7)
                    ir.nasim.C8671Wy6.e1(r0, r1)
                L78:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.C8685n.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8685n(int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8685n(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (C8671Wy6.this.f1 == ExPeerType.CHANNEL) {
                    AbstractC10533bm0.d(AbstractC9773aX7.a(C8671Wy6.this), null, null, new a(C8671Wy6.this, this.d, this.e, null), 3, null);
                } else {
                    C8671Wy6 c8671Wy6 = C8671Wy6.this;
                    int i2 = this.d;
                    String str = this.e;
                    this.b = 1;
                    if (c8671Wy6.I4(i2, str, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8685n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$o, reason: case insensitive filesystem */
    static final class C8686o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8686o(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8686o(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5409Jf2 interfaceC5409Jf2 = C8671Wy6.this.j;
                String str = this.d;
                this.b = 1;
                objA = interfaceC5409Jf2.a(str, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objA)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C8671Wy6.this.Q0;
                String str2 = this.d;
                EnumC4458Ff2 enumC4458Ff2 = EnumC4458Ff2.c;
                if (C9475a16.g(objA)) {
                    objA = enumC4458Ff2;
                }
                interfaceC9336Zm4.setValue(new KA3.b(str2, (EnumC4458Ff2) objA));
            } else {
                C8671Wy6.this.Q0.setValue(new KA3.a(this.d));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8686o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$p, reason: case insensitive filesystem */
    static final class C8687p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C8687p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C8687p c8687p = C8671Wy6.this.new C8687p(interfaceC20295rm1);
            c8687p.c = obj;
            return c8687p;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC4886Gz1.b bVar = (AbstractC4886Gz1.b) this.c;
            InterfaceC9336Zm4 interfaceC9336Zm4 = C8671Wy6.this.l1;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, bVar));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC4886Gz1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8687p) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$q, reason: case insensitive filesystem */
    public static final class C8688q implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;
        final /* synthetic */ C8671Wy6 b;
        final /* synthetic */ C14733iO2 c;

        /* renamed from: ir.nasim.Wy6$q$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC4557Fq2[] e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                super(0);
                this.e = interfaceC4557Fq2Arr;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object[] invoke() {
                return new Object[this.e.length];
            }
        }

        /* renamed from: ir.nasim.Wy6$q$b */
        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C8671Wy6 e;
            final /* synthetic */ C14733iO2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC20295rm1 interfaceC20295rm1, C8671Wy6 c8671Wy6, C14733iO2 c14733iO2) {
                super(3, interfaceC20295rm1);
                this.e = c8671Wy6;
                this.f = c14733iO2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Object[] objArr = (Object[]) this.d;
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    String str3 = (String) objArr[2];
                    C24119y45 c24119y45 = (C24119y45) objArr[3];
                    E25 e25 = (E25) objArr[4];
                    Avatar avatar = (Avatar) objArr[5];
                    Integer num = (Integer) objArr[6];
                    AbstractC4886Gz1.b bVar = (AbstractC4886Gz1.b) this.e.l1.getValue();
                    AbstractC4886Gz1.b bVarA = bVar.a((32767 & 1) != 0 ? bVar.a : RD5.Done, (32767 & 2) != 0 ? bVar.b : str, (32767 & 4) != 0 ? bVar.c : str3, (32767 & 8) != 0 ? bVar.d : null, (32767 & 16) != 0 ? bVar.e : str2, (32767 & 32) != 0 ? bVar.f : avatar, (32767 & 64) != 0 ? bVar.g : c24119y45, (32767 & 128) != 0 ? bVar.h : e25, (32767 & 256) != 0 ? bVar.i : null, (32767 & 512) != 0 ? bVar.j : num, (32767 & 1024) != 0 ? bVar.k : null, (32767 & 2048) != 0 ? bVar.l : false, (32767 & 4096) != 0 ? bVar.m : false, (32767 & 8192) != 0 ? bVar.n : null, (32767 & 16384) != 0 ? bVar.o : this.e.R3(this.f), (32767 & 32768) != 0 ? bVar.p : null);
                    this.b = 1;
                    if (interfaceC4806Gq2.a(bVarA, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1, this.e, this.f);
                bVar.c = interfaceC4806Gq2;
                bVar.d = objArr;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        public C8688q(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, C8671Wy6 c8671Wy6, C14733iO2 c14733iO2) {
            this.a = interfaceC4557Fq2Arr;
            this.b = c8671Wy6;
            this.c = c14733iO2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new b(null, this.b, this.c), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wy6$r, reason: case insensitive filesystem */
    static final class C8689r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        C8689r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new C8689r(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.c
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 != r3) goto L14
                java.lang.Object r0 = r6.b
                ir.nasim.Zd5$a r0 = (ir.nasim.AbstractC9256Zd5.a) r0
                ir.nasim.AbstractC10685c16.b(r7)
                goto L5a
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1c:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Zd5$a r7 = new ir.nasim.Zd5$a
                ir.nasim.core.modules.profile.entity.ExPeer r1 = new ir.nasim.core.modules.profile.entity.ExPeer
                ir.nasim.Wy6 r4 = ir.nasim.C8671Wy6.this
                ir.nasim.core.modules.profile.entity.ExPeerType r4 = ir.nasim.C8671Wy6.t1(r4)
                ir.nasim.Wy6 r5 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r5 = r5.v3()
                int r5 = r5.getPeerId()
                r1.<init>(r4, r5)
                r7.<init>(r1)
                ir.nasim.Wy6 r1 = ir.nasim.C8671Wy6.this
                ir.nasim.core.modules.profile.entity.Avatar r1 = ir.nasim.C8671Wy6.k1(r1)
                if (r1 == 0) goto L5d
                ir.nasim.core.modules.profile.entity.AvatarImage r1 = r1.getSmallImage()
                if (r1 == 0) goto L5d
                ir.nasim.Wy6 r4 = ir.nasim.C8671Wy6.this
                ir.nasim.uF2 r4 = ir.nasim.C8671Wy6.y1(r4)
                r6.b = r7
                r6.c = r3
                java.lang.Object r1 = r4.b(r1, r6)
                if (r1 != r0) goto L58
                return r0
            L58:
                r0 = r7
                r7 = r1
            L5a:
                ir.nasim.Am2 r7 = (ir.nasim.InterfaceC3346Am2) r7
                goto L5f
            L5d:
                r0 = r7
                r7 = r2
            L5f:
                ir.nasim.Wy6 r1 = ir.nasim.C8671Wy6.this
                android.app.PendingIntent r1 = ir.nasim.C8671Wy6.d1(r1)
                ir.nasim.Wy6 r3 = ir.nasim.C8671Wy6.this
                ir.nasim.LE r3 = ir.nasim.C8671Wy6.i1(r3)
                ir.nasim.Wy6 r4 = ir.nasim.C8671Wy6.this
                java.lang.String r4 = r4.s3()
                if (r7 == 0) goto L77
                java.lang.String r2 = r7.getDescriptor()
            L77:
                android.content.IntentSender r7 = r1.getIntentSender()
                r3.a(r4, r2, r0, r7)
                ir.nasim.Wy6 r7 = ir.nasim.C8671Wy6.this
                ir.nasim.Kz6 r0 = ir.nasim.EnumC5827Kz6.b
                ir.nasim.C8671Wy6.Y1(r7, r0)
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.C8689r.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8689r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$s, reason: case insensitive filesystem */
    static final class C8690s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C8690s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C8690s c8690s = C8671Wy6.this.new C8690s(interfaceC20295rm1);
            c8690s.c = obj;
            return c8690s;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC4886Gz1.b bVar = (AbstractC4886Gz1.b) this.c;
            InterfaceC9336Zm4 interfaceC9336Zm4 = C8671Wy6.this.l1;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, bVar));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC4886Gz1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8690s) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$t, reason: case insensitive filesystem */
    public static final class C8691t implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;
        final /* synthetic */ C8671Wy6 b;

        /* renamed from: ir.nasim.Wy6$t$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC4557Fq2[] e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                super(0);
                this.e = interfaceC4557Fq2Arr;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object[] invoke() {
                return new Object[this.e.length];
            }
        }

        /* renamed from: ir.nasim.Wy6$t$b */
        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C8671Wy6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC20295rm1 interfaceC20295rm1, C8671Wy6 c8671Wy6) {
                super(3, interfaceC20295rm1);
                this.e = c8671Wy6;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                NI7 ni7;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Object[] objArr = (Object[]) this.d;
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    String str3 = (String) objArr[2];
                    C8671Wy6 c8671Wy6 = this.e;
                    ArrayList arrayList = (ArrayList) objArr[3];
                    String strK2 = c8671Wy6.K2(String.valueOf((arrayList == null || (ni7 = (NI7) AbstractC15401jX0.F0(arrayList)) == null) ? null : AbstractC6392Nk0.e(ni7.a())));
                    E25 e25 = (E25) objArr[4];
                    ir.nasim.features.mxp.entity.a aVar = (ir.nasim.features.mxp.entity.a) objArr[5];
                    Avatar avatar = (Avatar) objArr[6];
                    Boolean bool = (Boolean) objArr[7];
                    C5902Li0 c5902Li0 = (C5902Li0) objArr[8];
                    AbstractC4886Gz1.b bVar = (AbstractC4886Gz1.b) this.e.l1.getValue();
                    int i2 = RD5.Done;
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    String strA = c5902Li0 != null ? c5902Li0.a() : null;
                    boolean zC = c5902Li0 != null ? c5902Li0.c() : false;
                    int iT4 = this.e.d.t4();
                    String strU4 = this.e.d.u4();
                    if (AbstractC20762sZ6.n0(strU4)) {
                        strU4 = null;
                    }
                    AbstractC4886Gz1.b bVarA = bVar.a((32767 & 1) != 0 ? bVar.a : i2, (32767 & 2) != 0 ? bVar.b : str, (32767 & 4) != 0 ? bVar.c : str3, (32767 & 8) != 0 ? bVar.d : strK2, (32767 & 16) != 0 ? bVar.e : str2, (32767 & 32) != 0 ? bVar.f : avatar, (32767 & 64) != 0 ? bVar.g : null, (32767 & 128) != 0 ? bVar.h : e25, (32767 & 256) != 0 ? bVar.i : aVar, (32767 & 512) != 0 ? bVar.j : null, (32767 & 1024) != 0 ? bVar.k : strA, (32767 & 2048) != 0 ? bVar.l : zBooleanValue, (32767 & 4096) != 0 ? bVar.m : zC, (32767 & 8192) != 0 ? bVar.n : (!C8386Vt0.a.Hb() || c5902Li0 == null || !c5902Li0.d() || this.e.d.t4() == -1) ? null : new C5504Jp7(iT4, strU4, String.valueOf(this.e.v3().getPeerId())), (32767 & 16384) != 0 ? bVar.o : false, (32767 & 32768) != 0 ? bVar.p : null);
                    this.b = 1;
                    if (interfaceC4806Gq2.a(bVarA, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1, this.e);
                bVar.c = interfaceC4806Gq2;
                bVar.d = objArr;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        public C8691t(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, C8671Wy6 c8671Wy6) {
            this.a = interfaceC4557Fq2Arr;
            this.b = c8671Wy6;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new b(null, this.b), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wy6$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new u(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2c
                if (r1 == r4) goto L22
                if (r1 != r3) goto L1a
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
                java.lang.Object r6 = r6.l()
                goto L9d
            L1a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L22:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
                java.lang.Object r6 = r6.l()
                goto L54
            L2c:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.Wy6 r6 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r6 = r6.v3()
                boolean r6 = r6.z()
                if (r6 == 0) goto L7e
                ir.nasim.Wy6 r6 = ir.nasim.C8671Wy6.this
                ir.nasim.pH1 r6 = ir.nasim.C8671Wy6.q1(r6)
                ir.nasim.Wy6 r1 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r1 = r1.v3()
                int r1 = r1.getPeerId()
                r5.b = r4
                java.lang.Object r6 = r6.c(r1, r5)
                if (r6 != r0) goto L54
                return r0
            L54:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                boolean r1 = ir.nasim.C9475a16.j(r6)
                if (r1 == 0) goto L72
                r1 = r6
                ir.nasim.rB7 r1 = (ir.nasim.C19938rB7) r1
                ir.nasim.Zm4 r0 = ir.nasim.C8671Wy6.g1(r0)
            L63:
                java.lang.Object r1 = r0.getValue()
                r3 = r1
                ir.nasim.L5 r3 = (ir.nasim.L5) r3
                ir.nasim.L5$a r3 = ir.nasim.L5.a.a
                boolean r1 = r0.f(r1, r3)
                if (r1 == 0) goto L63
            L72:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                java.lang.Throwable r6 = ir.nasim.C9475a16.e(r6)
                if (r6 == 0) goto Lc6
                ir.nasim.C8671Wy6.c2(r0, r2)
                goto Lc6
            L7e:
                ir.nasim.Wy6 r6 = ir.nasim.C8671Wy6.this
                ir.nasim.E84 r6 = ir.nasim.C8671Wy6.C1(r6)
                ir.nasim.Wy6 r1 = ir.nasim.C8671Wy6.this
                ir.nasim.d25 r1 = r1.v3()
                ir.nasim.Nv5 r6 = r6.r0(r1)
                java.lang.String r1 = "deleteChat(...)"
                ir.nasim.AbstractC13042fc3.h(r6, r1)
                r5.b = r3
                r1 = 0
                java.lang.Object r6 = ir.nasim.AbstractC6756Ov5.d(r6, r1, r5, r4, r1)
                if (r6 != r0) goto L9d
                return r0
            L9d:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                boolean r1 = ir.nasim.C9475a16.j(r6)
                if (r1 == 0) goto Lbb
                r1 = r6
                ir.nasim.i18 r1 = (ir.nasim.C14505i18) r1
                ir.nasim.Zm4 r0 = ir.nasim.C8671Wy6.g1(r0)
            Lac:
                java.lang.Object r1 = r0.getValue()
                r3 = r1
                ir.nasim.L5 r3 = (ir.nasim.L5) r3
                ir.nasim.L5$a r3 = ir.nasim.L5.a.a
                boolean r1 = r0.f(r1, r3)
                if (r1 == 0) goto Lac
            Lbb:
                ir.nasim.Wy6 r0 = ir.nasim.C8671Wy6.this
                java.lang.Throwable r6 = ir.nasim.C9475a16.e(r6)
                if (r6 == 0) goto Lc6
                ir.nasim.C8671Wy6.c2(r0, r2)
            Lc6:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.u.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$v */
    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        boolean g;
        int h;
        final /* synthetic */ List i;
        final /* synthetic */ C8671Wy6 j;
        final /* synthetic */ List k;
        final /* synthetic */ List l;
        final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(List list, C8671Wy6 c8671Wy6, List list2, List list3, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = list;
            this.j = c8671Wy6;
            this.k = list2;
            this.l = list3;
            this.m = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new v(this.i, this.j, this.k, this.l, this.m, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List list;
            Iterator it;
            C8671Wy6 c8671Wy6;
            List list2;
            List list3;
            boolean z;
            UY3 uy3;
            Object objE = AbstractC14862ic3.e();
            int i = this.h;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list4 = this.i;
                C8671Wy6 c8671Wy62 = this.j;
                List list5 = this.k;
                List list6 = this.l;
                boolean z2 = this.m;
                list = list4;
                it = list4.iterator();
                c8671Wy6 = c8671Wy62;
                list2 = list5;
                list3 = list6;
                z = z2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = this.g;
                Iterator it2 = (Iterator) this.f;
                List list7 = (List) this.e;
                List list8 = (List) this.d;
                List list9 = (List) this.c;
                C8671Wy6 c8671Wy63 = (C8671Wy6) this.b;
                AbstractC10685c16.b(obj);
                z = z3;
                it = it2;
                list3 = list7;
                list2 = list8;
                list = list9;
                c8671Wy6 = c8671Wy63;
            }
            while (it.hasNext()) {
                InterfaceC17445my6 interfaceC17445my6 = (InterfaceC17445my6) it.next();
                if (interfaceC17445my6 instanceof InterfaceC17445my6.d) {
                    uy3 = c8671Wy6.v;
                } else if (interfaceC17445my6 instanceof InterfaceC17445my6.e) {
                    uy3 = c8671Wy6.w;
                } else if (interfaceC17445my6 instanceof InterfaceC17445my6.a) {
                    uy3 = c8671Wy6.y;
                } else if (interfaceC17445my6 instanceof InterfaceC17445my6.c) {
                    uy3 = c8671Wy6.x;
                } else {
                    if (!(interfaceC17445my6 instanceof InterfaceC17445my6.f)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    uy3 = c8671Wy6.z;
                }
                C11458d25 c11458d25V3 = c8671Wy6.v3();
                this.b = c8671Wy6;
                this.c = list;
                this.d = list2;
                this.e = list3;
                this.f = it;
                this.g = z;
                this.h = 1;
                if (uy3.e(list, c11458d25V3, list2, list3, z, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new w(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4J3 = C8671Wy6.this.j3();
                String string = C8671Wy6.this.D0.getString(this.d);
                AbstractC13042fc3.h(string, "getString(...)");
                this.b = 1;
                if (interfaceC8327Vm4J3.a(string, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$x */
    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8671Wy6.this.new x(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4J3 = C8671Wy6.this.j3();
                String str = this.d;
                this.b = 1;
                if (interfaceC8327Vm4J3.a(str, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wy6$y */
    static final class y implements SA2 {
        y() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final YT4 invoke() {
            return C8671Wy6.this.s.a(C8671Wy6.this.v3());
        }
    }

    /* renamed from: ir.nasim.Wy6$z */
    static final class z implements SA2 {
        final /* synthetic */ String b;

        z(String str) {
            this.b = str;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final YT4 invoke() {
            return C8671Wy6.this.t.a(C8671Wy6.this.v3(), this.b);
        }
    }

    public C8671Wy6(C10299bQ2 c10299bQ2, OK7 ok7, SettingsModule settingsModule, C3841Co6 c3841Co6, C8054Ui1 c8054Ui1, V24 v24, C18804pH1 c18804pH1, C17039mI0 c17039mI0, InterfaceC5409Jf2 interfaceC5409Jf2, C22434vE0 c22434vE0, C19854r32 c19854r32, C21844uE0 c21844uE0, WF2 wf2, InterfaceC14587i95 interfaceC14587i95, ET7 et7, M08 m08, ZN zn, InterfaceC7375Rl2 interfaceC7375Rl2, InterfaceC16732lm2 interfaceC16732lm2, InterfaceC21103t7 interfaceC21103t7, F95 f95, VU7 vu7, C13168fm2 c13168fm2, C17101mP c17101mP, X08 x08, C6409Nm c6409Nm, InterfaceC22918w24 interfaceC22918w24, EA3.b bVar, C23952xn4.a.InterfaceC1774a interfaceC1774a, C22484vJ5.a aVar, InterfaceC23080wJ5 interfaceC23080wJ5, androidx.lifecycle.y yVar, InterfaceC4308Eo5 interfaceC4308Eo5, E84 e84, C21855uF2 c21855uF2, LE le, int i, Context context, YE4 ye4, C18852pM4 c18852pM4, C24651yy6 c24651yy6, InterfaceC5943Lm5 interfaceC5943Lm5) {
        C11458d25 c11458d25Y;
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(ok7, "userModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c3841Co6, "sendPeerInfoEventsUseCase");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(v24, "memberRepository");
        AbstractC13042fc3.i(c18804pH1, "deleteAndLeaveGroupUseCase");
        AbstractC13042fc3.i(c17039mI0, "changeAvatarUseCase");
        AbstractC13042fc3.i(interfaceC5409Jf2, "falakeRepository");
        AbstractC13042fc3.i(c22434vE0, "canSetNickNameUseCase");
        AbstractC13042fc3.i(c19854r32, "editGroupNickUseCase");
        AbstractC13042fc3.i(c21844uE0, "canSendStoryUseCase");
        AbstractC13042fc3.i(wf2, "galleryResultUseCase");
        AbstractC13042fc3.i(interfaceC14587i95, "photoPagingFactory");
        AbstractC13042fc3.i(et7, "videoPagingFactory");
        AbstractC13042fc3.i(m08, "voicePagingFactory");
        AbstractC13042fc3.i(zn, "audioPagingFactory");
        AbstractC13042fc3.i(interfaceC7375Rl2, "filePagingFactory");
        AbstractC13042fc3.i(interfaceC16732lm2, "fileSearchPagingFactory");
        AbstractC13042fc3.i(interfaceC21103t7, "adRepository");
        AbstractC13042fc3.i(f95, "photoRepository");
        AbstractC13042fc3.i(vu7, "videoRepository");
        AbstractC13042fc3.i(c13168fm2, "fileRepository");
        AbstractC13042fc3.i(c17101mP, "audioRepository");
        AbstractC13042fc3.i(x08, "voiceRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(interfaceC22918w24, "memberPageSourceFactory");
        AbstractC13042fc3.i(bVar, "linkSharedMediaDataLoaderFactory");
        AbstractC13042fc3.i(interfaceC1774a, "mutualGroupRepositoryFactory");
        AbstractC13042fc3.i(aVar, "recommendedPeerPagingFactory");
        AbstractC13042fc3.i(interfaceC23080wJ5, "recommendedPeerRepository");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(e84, "messageModule");
        AbstractC13042fc3.i(c21855uF2, "getAvatarFileSystemRefUseCase");
        AbstractC13042fc3.i(le, "appShortcutHelper");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(ye4, "notifyEventBusOnProfileOpenUseCase");
        AbstractC13042fc3.i(c18852pM4, "organizationPreferencesStorage");
        AbstractC13042fc3.i(c24651yy6, "sharedMediaRepository");
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        this.b = c10299bQ2;
        this.c = ok7;
        this.d = settingsModule;
        this.e = c3841Co6;
        this.f = c8054Ui1;
        this.g = v24;
        this.h = c18804pH1;
        this.i = c17039mI0;
        this.j = interfaceC5409Jf2;
        this.k = c22434vE0;
        this.l = c19854r32;
        this.m = c21844uE0;
        this.n = wf2;
        this.o = interfaceC14587i95;
        this.p = et7;
        this.q = m08;
        this.r = zn;
        this.s = interfaceC7375Rl2;
        this.t = interfaceC16732lm2;
        this.u = interfaceC21103t7;
        this.v = f95;
        this.w = vu7;
        this.x = c13168fm2;
        this.y = c17101mP;
        this.z = x08;
        this.A = c6409Nm;
        this.B = interfaceC22918w24;
        this.D = bVar;
        this.G = interfaceC1774a;
        this.H = aVar;
        this.J = interfaceC23080wJ5;
        this.Y = yVar;
        this.Z = interfaceC4308Eo5;
        this.z0 = e84;
        this.A0 = c21855uF2;
        this.B0 = le;
        this.C0 = i;
        this.D0 = context;
        this.E0 = ye4;
        this.F0 = c18852pM4;
        this.G0 = c24651yy6;
        this.H0 = interfaceC5943Lm5;
        this.J0 = settingsModule.N0();
        this.K0 = settingsModule.n1();
        this.L0 = AbstractC12281eL6.a("");
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new ArrayList());
        this.M0 = interfaceC9336Zm4A;
        this.N0 = interfaceC9336Zm4A;
        this.O0 = AbstractC12281eL6.a("");
        this.P0 = AbstractC12281eL6.a(AbstractC17858ng6.b.b);
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(null);
        this.Q0 = interfaceC9336Zm4A2;
        this.R0 = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        this.S0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Qy6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.F4(this.a);
            }
        });
        this.T0 = AbstractC9395Zt0.a(AbstractC6459Nq2.s0(AbstractC6459Nq2.t(this.O0, new UA2() { // from class: ir.nasim.Ry6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(C8671Wy6.J2((String) obj));
            }
        }), new P(null, this)), AbstractC9773aX7.a(this));
        this.U0 = new FT4(AbstractC9773aX7.a(this));
        this.V0 = AbstractC9395Zt0.a(AbstractC6459Nq2.s0(AbstractC6459Nq2.t(this.L0, new UA2() { // from class: ir.nasim.Sy6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(C8671Wy6.j4((String) obj));
            }
        }), new Q(null, this)), AbstractC9773aX7.a(this));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8672a(null), 3, null);
        this.W0 = AbstractC12281eL6.a(new C13132fi6(null, false, 3, null));
        Boolean bool = (Boolean) yVar.c("is_private");
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        this.X0 = zBooleanValue;
        if (zBooleanValue) {
            Object objC = yVar.c("uid_profile_fragment");
            AbstractC13042fc3.f(objC);
            c11458d25Y = C11458d25.E(((Number) objC).intValue());
            AbstractC13042fc3.f(c11458d25Y);
        } else {
            Object objC2 = yVar.c("uid_profile_fragment");
            AbstractC13042fc3.f(objC2);
            c11458d25Y = C11458d25.y(((Number) objC2).intValue());
            AbstractC13042fc3.f(c11458d25Y);
        }
        this.Y0 = c11458d25Y;
        Boolean bool2 = (Boolean) yVar.c("open_photo");
        this.Z0 = bool2 != null ? bool2.booleanValue() : false;
        this.c1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ty6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.L2(this.a);
            }
        });
        this.d1 = AbstractC12281eL6.a(0);
        this.e1 = AbstractC12281eL6.a(Boolean.FALSE);
        this.f1 = ExPeerType.PRIVATE;
        this.g1 = new ArrayList();
        this.h1 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.i1 = c11458d25Y.getPeerId() == i;
        this.j1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Uy6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.j2(this.a);
            }
        });
        this.k1 = AbstractC11420cy6.b(0, 0, null, 4, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(new AbstractC4886Gz1.b(0, null, null, null, null, null, null, null, null, null, null, false, false, null, false, null, 65535, null));
        this.l1 = interfaceC9336Zm4A3;
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(new L5.b(0.0f));
        this.m1 = interfaceC9336Zm4A4;
        this.n1 = AbstractC6459Nq2.o0(AbstractC6459Nq2.S(interfaceC9336Zm4A4, interfaceC9336Zm4A3, new T(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), new PA7.b(new AbstractC4886Gz1.a(0.0f)));
        this.v1 = interfaceC23080wJ5.b();
        this.w1 = AbstractC9395Zt0.a(new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Vy6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.n4(this.a);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent A2() {
        AbstractC4277El1.c(this.D0, I3(), new IntentFilter("android.intent.action.CREATE_SHORTCUT"), false, 4, null);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.D0, 0, new Intent("android.intent.action.CREATE_SHORTCUT"), 67108864);
        AbstractC13042fc3.h(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final InterfaceC13730gj3 C2() {
        InterfaceC4557Fq2 interfaceC4557Fq2T;
        InterfaceC4557Fq2 interfaceC4557Fq2T2;
        C21231tK7 c21231tK7 = this.a1;
        if (c21231tK7 == null) {
            AbstractC13042fc3.y("userVM");
            c21231tK7 = null;
        }
        C10410bZ6 c10410bZ6G = c21231tK7.g();
        AbstractC13042fc3.h(c10410bZ6G, "getAbout(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC23145wQ7.a(c10410bZ6G);
        C10410bZ6 c10410bZ6R = c21231tK7.r();
        AbstractC13042fc3.h(c10410bZ6R, "getName(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A2 = AbstractC23145wQ7.a(c10410bZ6R);
        C10410bZ6 c10410bZ6S = c21231tK7.s();
        AbstractC13042fc3.h(c10410bZ6S, "getNick(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A3 = AbstractC23145wQ7.a(c10410bZ6S);
        C19482qQ7 c19482qQ7U = c21231tK7.u();
        AbstractC13042fc3.h(c19482qQ7U, "getPhones(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A4 = AbstractC23145wQ7.a(c19482qQ7U);
        C19482qQ7 c19482qQ7T = c21231tK7.t();
        if (c19482qQ7T == null || (interfaceC4557Fq2T = AbstractC23145wQ7.a(c19482qQ7T)) == null) {
            interfaceC4557Fq2T = AbstractC6459Nq2.T(null);
        }
        O92 o92X = c21231tK7.x();
        AbstractC13042fc3.h(o92X, "getPuppet(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A5 = AbstractC23145wQ7.a(o92X);
        C19482qQ7 c19482qQ7H = c21231tK7.h();
        AbstractC13042fc3.h(c19482qQ7H, "getAvatar(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A6 = AbstractC23145wQ7.a(c19482qQ7H);
        C8512Wh0 c8512Wh0V = c21231tK7.v();
        if (c8512Wh0V == null || (interfaceC4557Fq2T2 = AbstractC23145wQ7.a(c8512Wh0V)) == null) {
            interfaceC4557Fq2T2 = AbstractC6459Nq2.T(null);
        }
        C19482qQ7 c19482qQ7J = c21231tK7.j();
        AbstractC13042fc3.h(c19482qQ7J, "getBotExInfo(...)");
        return AbstractC6459Nq2.W(AbstractC6459Nq2.b0(new C8691t(new InterfaceC4557Fq2[]{interfaceC4557Fq2A, interfaceC4557Fq2A2, interfaceC4557Fq2A3, interfaceC4557Fq2A4, interfaceC4557Fq2T, interfaceC4557Fq2A5, interfaceC4557Fq2A6, interfaceC4557Fq2T2, AbstractC23145wQ7.a(c19482qQ7J)}, this), new C8690s(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E4(ir.nasim.InterfaceC20295rm1 r9) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.E4(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortcutShortcutReceiver F4(final C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return new ShortcutShortcutReceiver(new WeakReference(new UA2() { // from class: ir.nasim.My6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8671Wy6.G4(this.a, ((Boolean) obj).booleanValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2(Exception exc) {
        I2(UN2.a(exc, this.f1 == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G4(C8671Wy6 c8671Wy6, boolean z2) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        c8671Wy6.u4(EnumC5827Kz6.d);
        return C19938rB7.a;
    }

    private final ShortcutShortcutReceiver I3() {
        return (ShortcutShortcutReceiver) this.S0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I4(int r11, java.lang.String r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof ir.nasim.C8671Wy6.R
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.Wy6$R r0 = (ir.nasim.C8671Wy6.R) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Wy6$R r0 = new ir.nasim.Wy6$R
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r11 = r0.b
            r12 = r11
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r11 = r0.a
            ir.nasim.Wy6 r11 = (ir.nasim.C8671Wy6) r11
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.a16 r13 = (ir.nasim.C9475a16) r13
            java.lang.Object r13 = r13.l()
            goto L5e
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.bQ2 r13 = r10.b
            ir.nasim.d25 r2 = r10.Y0
            int r2 = r2.getPeerId()
            ir.nasim.Nv5 r11 = r13.F3(r2, r11)
            r0.a = r10
            r0.b = r12
            r0.e = r4
            java.lang.Object r13 = ir.nasim.AbstractC6756Ov5.d(r11, r3, r0, r4, r3)
            if (r13 != r1) goto L5d
            return r1
        L5d:
            r11 = r10
        L5e:
            boolean r0 = ir.nasim.C9475a16.j(r13)
            if (r0 == 0) goto L98
            r0 = r13
            ir.nasim.i18 r0 = (ir.nasim.C14505i18) r0
            android.content.Context r0 = r11.D0
            ir.nasim.core.modules.profile.entity.ExPeerType r1 = r11.f1
            ir.nasim.core.modules.profile.entity.ExPeerType r2 = ir.nasim.core.modules.profile.entity.ExPeerType.GROUP
            if (r1 != r2) goto L72
            int r1 = ir.nasim.RD5.ownership_of_group_was_transferred
            goto L74
        L72:
            int r1 = ir.nasim.RD5.ownership_of_channel_was_transferred
        L74:
            java.lang.String r2 = r11.s3()
            java.lang.Object[] r12 = new java.lang.Object[]{r2, r12}
            java.lang.String r12 = r0.getString(r1, r12)
            java.lang.String r0 = "getString(...)"
            ir.nasim.AbstractC13042fc3.h(r12, r0)
            r11.I2(r12)
            ir.nasim.ro1 r4 = ir.nasim.AbstractC9773aX7.a(r11)
            ir.nasim.Wy6$S r7 = new ir.nasim.Wy6$S
            r7.<init>(r3)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            ir.nasim.AbstractC9323Zl0.d(r4, r5, r6, r7, r8, r9)
        L98:
            java.lang.Throwable r12 = ir.nasim.C9475a16.e(r13)
            if (r12 == 0) goto Lb0
            boolean r13 = r12 instanceof ir.nasim.core.network.RpcException
            if (r13 == 0) goto La8
            java.lang.Exception r12 = (java.lang.Exception) r12
            r11.G2(r12)
            goto Lb0
        La8:
            java.lang.Exception r13 = new java.lang.Exception
            r13.<init>(r12)
            r11.G2(r13)
        Lb0:
            ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.I4(int, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long J2(String str) {
        AbstractC13042fc3.i(str, "it");
        return str.length() == 0 ? 0L : 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J4(boolean z2) {
        if (z2) {
            H2(RD5.success_ok);
        } else {
            H2(RD5.operation_is_unsuccess);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K2(String str) {
        if (AbstractC13042fc3.d(str, "null")) {
            return null;
        }
        if (str == null || !AbstractC20153rZ6.S(str, "98", false, 2, null)) {
            return str;
        }
        return "+" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10040ay6 L2(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return AbstractC9370Zq2.h(c8671Wy6.n.a("SharedMediaViewModel"), AbstractC9773aX7.a(c8671Wy6), InterfaceC16863lz6.a.d(), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 N3(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return c8671Wy6.p.a(c8671Wy6.Y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 O2(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return c8671Wy6.r.a(c8671Wy6.Y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Avatar P2() {
        return ((AbstractC4886Gz1.b) this.l1.getValue()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 P3(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return c8671Wy6.q.a(c8671Wy6.Y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R3(C14733iO2 c14733iO2) {
        boolean z2 = c14733iO2.x() != this.C0;
        boolean z3 = ((C24119y45) c14733iO2.z().b()).c() && C8386Vt0.a.Ya();
        if (z2 && !z3) {
            return false;
        }
        int i = C8674c.a[d3().ordinal()];
        if (i == 1) {
            return this.m.b(c14733iO2);
        }
        if (i != 2) {
            return false;
        }
        return this.m.c(c14733iO2);
    }

    private final boolean T3(Q14 q14) {
        return q14.j() && q14.h() != 0 && q14.h() == this.C0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List e4(List list) {
        Map mapN = AbstractC20051rO3.n(AbstractC4616Fw7.a(EnumC18627oy6.c, 0), AbstractC4616Fw7.a(EnumC18627oy6.b, 1), AbstractC4616Fw7.a(EnumC18627oy6.d, 2), AbstractC4616Fw7.a(EnumC18627oy6.a, 3), AbstractC4616Fw7.a(EnumC18627oy6.e, 4));
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((C3697By6) obj).a() != EnumC18627oy6.f) {
                arrayList.add(obj);
            }
        }
        List listA1 = AbstractC15401jX0.a1(arrayList, new E(mapN));
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listA1, 10));
        Iterator it = listA1.iterator();
        while (it.hasNext()) {
            int i = C8674c.b[((C3697By6) it.next()).a().ordinal()];
            arrayList2.add(Integer.valueOf(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? RD5.unknown : RD5.media_audio : RD5.shared_media_audio : RD5.media_Document : RD5.media_video2 : RD5.media_picture));
        }
        return arrayList2;
    }

    private final boolean f2(Q14 q14) {
        if (W3()) {
            return q14.j() || q14.i() == this.C0;
        }
        if (S3()) {
            return T3(q14) || q14.i() == this.C0;
        }
        return false;
    }

    private final boolean g2(Q14 q14) {
        if (W3()) {
            return true;
        }
        if (S3()) {
            return !q14.j() || T3(q14) || q14.i() == this.C0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 j2(C8671Wy6 c8671Wy6) {
        InterfaceC4557Fq2 interfaceC4557Fq2T;
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        C14733iO2 c14733iO2 = c8671Wy6.b1;
        if (c14733iO2 != null) {
            if (c14733iO2 == null) {
                AbstractC13042fc3.y("groupVM");
                c14733iO2 = null;
            }
            C8512Wh0 c8512Wh0G = c14733iO2.g();
            AbstractC13042fc3.h(c8512Wh0G, "canViewMembers(...)");
            interfaceC4557Fq2T = new C8676e(AbstractC23145wQ7.a(c8512Wh0G), c8671Wy6);
        } else {
            interfaceC4557Fq2T = AbstractC6459Nq2.T(Boolean.FALSE);
        }
        return AbstractC6459Nq2.o0(interfaceC4557Fq2T, AbstractC9773aX7.a(c8671Wy6), InterfaceC16863lz6.a.c(), Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j4(String str) {
        AbstractC13042fc3.i(str, "it");
        return str.length() == 0 ? 0L : 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 l3(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return new C16970mA3(c8671Wy6.D.a(c8671Wy6.Y0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 n4(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return c8671Wy6.H.a(c8671Wy6.Y0);
    }

    public static /* synthetic */ InterfaceC13730gj3 o2(C8671Wy6 c8671Wy6, boolean z2, SA2 sa2, int i, Object obj) {
        if ((i & 2) != 0) {
            sa2 = null;
        }
        return c8671Wy6.n2(z2, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 q3(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return new C23362wn4(c8671Wy6.G.a(c8671Wy6.Y0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r4(java.lang.String r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof ir.nasim.C8671Wy6.J
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.Wy6$J r0 = (ir.nasim.C8671Wy6.J) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Wy6$J r0 = new ir.nasim.Wy6$J
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r13 = r0.a
            ir.nasim.Wy6 r13 = (ir.nasim.C8671Wy6) r13
            ir.nasim.AbstractC10685c16.b(r14)
            goto L50
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.V24 r14 = r12.g
            ir.nasim.d25 r2 = r12.Y0
            ir.nasim.iO2 r4 = r12.i3()
            int r4 = r4.x()
            r0.a = r12
            r0.d = r3
            java.lang.Object r14 = r14.p(r2, r13, r4, r0)
            if (r14 != r1) goto L4f
            return r1
        L4f:
            r13 = r12
        L50:
            java.util.List r14 = (java.util.List) r14
            ir.nasim.Zm4 r0 = r13.W0
        L54:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            ir.nasim.fi6 r2 = (ir.nasim.C13132fi6) r2
            boolean r4 = r14.isEmpty()
            r5 = 0
            ir.nasim.fi6 r2 = ir.nasim.C13132fi6.b(r2, r5, r4, r3, r5)
            boolean r1 = r0.f(r1, r2)
            if (r1 == 0) goto L54
            ir.nasim.NT4$d r0 = ir.nasim.NT4.e
            ir.nasim.NT4 r1 = r0.b(r14)
            ir.nasim.Zm4 r2 = r13.W0
        L72:
            java.lang.Object r13 = r2.getValue()
            r14 = r13
            ir.nasim.fi6 r14 = (ir.nasim.C13132fi6) r14
            ir.nasim.ng6$a r0 = new ir.nasim.ng6$a
            r10 = 5
            r11 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            r3 = 0
            r4 = 2
            ir.nasim.fi6 r14 = ir.nasim.C13132fi6.b(r14, r0, r3, r4, r5)
            boolean r13 = r2.f(r13, r14)
            if (r13 == 0) goto L72
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.r4(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ void t4(C8671Wy6 c8671Wy6, EnumC14682iJ5 enumC14682iJ5, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        c8671Wy6.s4(enumC14682iJ5, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u4(EnumC5827Kz6 enumC5827Kz6) {
        this.A.d("Shortcut_Bot", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.Y0.getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("action_type", Integer.valueOf(enumC5827Kz6.j()))));
    }

    private final void v4(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new K(i, null), 3, null);
    }

    private final InterfaceC13730gj3 y2() {
        InterfaceC4557Fq2 interfaceC4557Fq2T;
        C14733iO2 c14733iO2 = this.b1;
        if (c14733iO2 == null) {
            AbstractC13042fc3.y("groupVM");
            c14733iO2 = null;
        }
        C10410bZ6 c10410bZ6H = c14733iO2.h();
        if (c10410bZ6H == null || (interfaceC4557Fq2T = AbstractC23145wQ7.a(c10410bZ6H)) == null) {
            interfaceC4557Fq2T = AbstractC6459Nq2.T(null);
        }
        C10410bZ6 c10410bZ6V = c14733iO2.v();
        AbstractC13042fc3.h(c10410bZ6V, "getName(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC23145wQ7.a(c10410bZ6V);
        C10410bZ6 c10410bZ6W = c14733iO2.w();
        AbstractC13042fc3.h(c10410bZ6W, "getNick(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A2 = AbstractC23145wQ7.a(c10410bZ6W);
        C19482qQ7 c19482qQ7Z = c14733iO2.z();
        AbstractC13042fc3.h(c19482qQ7Z, "getPermissions(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A3 = AbstractC23145wQ7.a(c19482qQ7Z);
        C19482qQ7 c19482qQ7Y = c14733iO2.y();
        AbstractC13042fc3.h(c19482qQ7Y, "getPeerIdentity(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A4 = AbstractC23145wQ7.a(c19482qQ7Y);
        C19482qQ7 c19482qQ7J = c14733iO2.j();
        AbstractC13042fc3.h(c19482qQ7J, "getAvatar(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A5 = AbstractC23145wQ7.a(c19482qQ7J);
        C6305Na3 c6305Na3U = c14733iO2.u();
        AbstractC13042fc3.h(c6305Na3U, "getMembersCount(...)");
        return AbstractC6459Nq2.W(AbstractC6459Nq2.b0(new C8688q(new InterfaceC4557Fq2[]{interfaceC4557Fq2T, interfaceC4557Fq2A, interfaceC4557Fq2A2, interfaceC4557Fq2A3, interfaceC4557Fq2A4, interfaceC4557Fq2A5, AbstractC23145wQ7.a(c6305Na3U)}, this, c14733iO2), new C8687p(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 y3(C8671Wy6 c8671Wy6) {
        AbstractC13042fc3.i(c8671Wy6, "this$0");
        return c8671Wy6.o.a(c8671Wy6.Y0);
    }

    private final void z4() {
        Object value;
        if (this.g1.isEmpty() && ((List) this.h1.getValue()).isEmpty()) {
            x4(false);
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d1;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Number) value).intValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(this.g1.size() + ((List) this.h1.getValue()).size())));
    }

    public final InterfaceC10258bL6 A3() {
        return AbstractC6459Nq2.c(this.L0);
    }

    public final void A4(AbstractC17858ng6 abstractC17858ng6) {
        Object value;
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.W0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13132fi6.b((C13132fi6) value, abstractC17858ng6, false, 2, null)));
    }

    public final InterfaceC4557Fq2 B3() {
        return this.w1;
    }

    public final void B4(AbstractC17858ng6 abstractC17858ng6) {
        Object value;
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.P0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, abstractC17858ng6));
    }

    public final InterfaceC10258bL6 C3() {
        return AbstractC6459Nq2.c(this.P0);
    }

    public final InterfaceC13730gj3 C4() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new M(null), 3, null);
    }

    public final InterfaceC13730gj3 D2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new u(null), 3, null);
    }

    public final InterfaceC10258bL6 D3() {
        return AbstractC6459Nq2.c(this.W0);
    }

    public final void E2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m1;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, L5.a.a));
    }

    public final List E3() {
        return AbstractC15401jX0.m1(this.g1);
    }

    public final void F2(List list, List list2, List list3, boolean z2) {
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(list2, "rids");
        AbstractC13042fc3.i(list3, "dates");
        this.z0.u0(this.Y0, list2, list3, !z2);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new v(list, this, list2, list3, z2, null), 3, null);
        x4(false);
    }

    public final InterfaceC10258bL6 F3() {
        return AbstractC6459Nq2.c(this.h1);
    }

    public final InterfaceC9336Zm4 G3() {
        return this.d1;
    }

    public final void H2(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new w(i, null), 3, null);
    }

    public final InterfaceC10258bL6 H3() {
        return this.N0;
    }

    public final void H4(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onResult");
        if (W3() && this.f1 == ExPeerType.CHANNEL) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new O(ua2, this, null), 3, null);
        } else {
            ua2.invoke(Boolean.FALSE);
        }
    }

    public final void I2(String str) {
        AbstractC13042fc3.i(str, "msg");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new x(str, null), 3, null);
    }

    public final InterfaceC10258bL6 J3() {
        return this.n1;
    }

    public final C21231tK7 K3() {
        C21231tK7 c21231tK7 = this.a1;
        if (c21231tK7 != null) {
            return c21231tK7;
        }
        AbstractC13042fc3.y("userVM");
        return null;
    }

    public final InterfaceC4557Fq2 L3() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.q1;
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Ny6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.N3(this.a);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.q1 = interfaceC4557Fq2A;
        return interfaceC4557Fq2A;
    }

    public final String M2() {
        return ((AbstractC4886Gz1.b) this.l1.getValue()).c();
    }

    public final InterfaceC4557Fq2 N2() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.r1;
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Oy6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.O2(this.a);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.r1 = interfaceC4557Fq2A;
        return interfaceC4557Fq2A;
    }

    public final InterfaceC4557Fq2 O3() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.s1;
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Ky6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.P3(this.a);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.s1 = interfaceC4557Fq2A;
        return interfaceC4557Fq2A;
    }

    public final String Q2() {
        return this.K0;
    }

    public final void Q3(boolean z2) {
        if (z2) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new B(null), 3, null);
        } else {
            J4(false);
        }
    }

    public final String R2() {
        return ((AbstractC4886Gz1.b) this.l1.getValue()).e();
    }

    public final String S2() {
        return this.J0;
    }

    public final boolean S3() {
        C23104wM2 c23104wM2;
        C19482qQ7 c19482qQ7S = i3().s();
        return (c19482qQ7S == null || (c23104wM2 = (C23104wM2) c19482qQ7S.b()) == null || !c23104wM2.j()) ? false : true;
    }

    public final boolean U2() {
        if (this.f1 == ExPeerType.GROUP && this.d.B5(EnumC4196Ec1.C0) && this.d.q2() >= n3() && n3() != 0) {
            C14733iO2 c14733iO2 = this.b1;
            if (c14733iO2 == null) {
                AbstractC13042fc3.y("groupVM");
                c14733iO2 = null;
            }
            C24119y45 c24119y45 = (C24119y45) c14733iO2.z().b();
            if (c24119y45 != null && c24119y45.r()) {
                return true;
            }
        }
        return false;
    }

    public final boolean U3() {
        return this.Z0;
    }

    public final boolean W2() {
        List list;
        C24411ya3 c24411ya3;
        return (W3() || S3()) && C8386Vt0.Z3() && (list = (List) this.d.T().get("notice_bar_interacted_channels")) != null && (list.contains(Integer.valueOf(this.Y0.getPeerId())) ^ true) && (c24411ya3 = (C24411ya3) this.d.S().get("total_range")) != null && c24411ya3.B(n3());
    }

    public final boolean W3() {
        return i3().x() == this.C0;
    }

    public final boolean X3() {
        return this.X0;
    }

    public final boolean Y2() {
        return !this.Y0.C() && (W3() || S3());
    }

    public final boolean Y3() {
        return this.i1;
    }

    public final InterfaceC10258bL6 Z3() {
        return this.e1;
    }

    public final boolean a3() {
        if (W3() || S3()) {
            C14733iO2 c14733iO2 = this.b1;
            if (c14733iO2 == null) {
                AbstractC13042fc3.y("groupVM");
                c14733iO2 = null;
            }
            if (c14733iO2.E().b() == W06.PUBLIC && C8386Vt0.t5()) {
                return true;
            }
        }
        return false;
    }

    public final boolean a4() {
        return this.B0.c();
    }

    public final InterfaceC10258bL6 b3() {
        return (InterfaceC10258bL6) this.j1.getValue();
    }

    public final InterfaceC13730gj3 b4(Q14 q14) {
        AbstractC13042fc3.i(q14, "member");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C(q14, null), 3, null);
    }

    public final boolean c3() {
        return this.f1 == ExPeerType.CHANNEL && (W3() || S3()) && C8386Vt0.a.u7();
    }

    public final void d2() {
        this.f.U(this.Y0.getPeerId()).a(new C8675d());
    }

    public final ExPeerType d3() {
        return this.f1;
    }

    public final InterfaceC13730gj3 d4() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new D(null), 3, null);
    }

    public final boolean e2(Q14 q14) {
        AbstractC13042fc3.i(q14, "member");
        int i = C8674c.a[d3().ordinal()];
        if (i == 1) {
            return f2(q14);
        }
        if (i != 2) {
            return false;
        }
        return g2(q14);
    }

    public final InterfaceC4557Fq2 e3() {
        return this.T0;
    }

    public final void f4(InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(interfaceC17445my6, "content");
        if (this.g1.contains(interfaceC17445my6)) {
            this.g1.remove(interfaceC17445my6);
        } else {
            this.g1.add(interfaceC17445my6);
        }
        z4();
    }

    public final InterfaceC10258bL6 g3() {
        return AbstractC6459Nq2.c(this.O0);
    }

    public final void g4(C9562aA3 c9562aA3) {
        Object value;
        List listP1;
        AbstractC13042fc3.i(c9562aA3, "content");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h1;
        do {
            value = interfaceC9336Zm4.getValue();
            List list = (List) value;
            if (list.contains(c9562aA3)) {
                listP1 = AbstractC15401jX0.p1(list);
                listP1.remove(c9562aA3);
            } else {
                listP1 = AbstractC15401jX0.p1(list);
                listP1.add(c9562aA3);
            }
        } while (!interfaceC9336Zm4.f(value, listP1));
        z4();
    }

    public final boolean h2(Q14 q14) {
        AbstractC13042fc3.i(q14, "member");
        if (!q14.j() && !q14.l()) {
            if (W3()) {
                return true;
            }
            C24119y45 c24119y45W3 = w3();
            if (c24119y45W3 != null && c24119y45W3.b()) {
                return true;
            }
        }
        return false;
    }

    public final InterfaceC4557Fq2 h3() {
        return (InterfaceC4557Fq2) this.c1.getValue();
    }

    public final InterfaceC13730gj3 h4(InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(interfaceC17445my6, "sharedMediaContent");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new F(interfaceC17445my6, this, null), 3, null);
    }

    public final boolean i2(Q14 q14) {
        C24119y45 c24119y45W3;
        AbstractC13042fc3.i(q14, "member");
        if (!q14.l()) {
            if (W3()) {
                return true;
            }
            if (S3() && (c24119y45W3 = w3()) != null && c24119y45W3.j()) {
                if (!q14.j()) {
                    return true;
                }
                if (q14.j() && T3(q14)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final C14733iO2 i3() {
        C14733iO2 c14733iO2 = this.b1;
        if (c14733iO2 != null) {
            return c14733iO2;
        }
        AbstractC13042fc3.y("groupVM");
        return null;
    }

    public final void i4(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        try {
            C18987pb3.a.k0(new Intent("android.intent.action.VIEW", Uri.parse(AbstractC20153rZ6.M(this.d.a0(), "%ld", String.valueOf(this.Y0.u()), false, 4, null))), activity);
        } catch (Exception unused) {
            C19406qI3.b("SharedMediaViewModel", "Failed to parse live bot uri.");
        }
    }

    public final InterfaceC8327Vm4 j3() {
        return this.k1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k2(java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C8671Wy6.C8677f
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Wy6$f r0 = (ir.nasim.C8671Wy6.C8677f) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Wy6$f r0 = new ir.nasim.Wy6$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.a
            ir.nasim.Wy6 r7 = (ir.nasim.C8671Wy6) r7
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L5b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            ir.nasim.AbstractC10685c16.b(r8)
            boolean r8 = ir.nasim.AbstractC14836iZ6.n0(r7)
            if (r8 != 0) goto Ld8
            int r8 = r7.length()
            r2 = 5
            if (r8 >= r2) goto L4d
            goto Ld8
        L4d:
            ir.nasim.vE0 r8 = r6.k
            r0.a = r6
            r0.d = r3
            java.lang.Object r8 = r8.a(r7, r0)
            if (r8 != r1) goto L5a
            return r1
        L5a:
            r7 = r6
        L5b:
            boolean r0 = ir.nasim.C9475a16.j(r8)
            if (r0 == 0) goto L88
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L72
            java.lang.Boolean r7 = ir.nasim.AbstractC6392Nk0.a(r3)
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
            goto L87
        L72:
            java.lang.Exception r8 = new java.lang.Exception
            android.content.Context r7 = r7.D0
            int r0 = ir.nasim.RD5.group_error_nickname_already_taken
            java.lang.String r7 = r7.getString(r0)
            r8.<init>(r7)
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r8)
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
        L87:
            return r7
        L88:
            java.lang.Throwable r7 = ir.nasim.C9475a16.e(r8)
            if (r7 == 0) goto Le4
            boolean r8 = r7 instanceof ir.nasim.core.network.RpcException
            r0 = 0
            r1 = 2
            r2 = 0
            if (r8 == 0) goto Lb1
            r3 = r7
            ir.nasim.core.network.RpcException r3 = (ir.nasim.core.network.RpcException) r3
            java.lang.String r3 = r3.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String()
            ir.nasim.sharedmedia.ui.state.ChangeNickErrorState$InvalidChannelNick r4 = ir.nasim.sharedmedia.ui.state.ChangeNickErrorState.InvalidChannelNick.a
            java.lang.String r5 = r4.a()
            boolean r3 = ir.nasim.AbstractC14836iZ6.X(r3, r5, r2, r1, r0)
            if (r3 == 0) goto Lb1
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r4)
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
            goto Ld7
        Lb1:
            if (r8 == 0) goto Lcf
            r8 = r7
            ir.nasim.core.network.RpcException r8 = (ir.nasim.core.network.RpcException) r8
            java.lang.String r8 = r8.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String()
            ir.nasim.sharedmedia.ui.state.ChangeNickErrorState$ForbiddenNick r3 = ir.nasim.sharedmedia.ui.state.ChangeNickErrorState.ForbiddenNick.a
            java.lang.String r4 = r3.a()
            boolean r8 = ir.nasim.AbstractC14836iZ6.X(r8, r4, r2, r1, r0)
            if (r8 == 0) goto Lcf
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r3)
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
            goto Ld7
        Lcf:
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r7)
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
        Ld7:
            return r7
        Ld8:
            ir.nasim.a16$a r7 = ir.nasim.C9475a16.b
            ir.nasim.sharedmedia.ui.state.ChangeNickErrorState$InvalidChannelInput r7 = ir.nasim.sharedmedia.ui.state.ChangeNickErrorState.InvalidChannelInput.a
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r7)
            java.lang.Object r8 = ir.nasim.C9475a16.b(r7)
        Le4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8671Wy6.k2(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC4557Fq2 k3() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.t1;
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Jy6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.l3(this.a);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.t1 = interfaceC4557Fq2A;
        return interfaceC4557Fq2A;
    }

    public final boolean l2(Q14 q14) {
        AbstractC13042fc3.i(q14, "member");
        return W3() && q14.j() && q14.i() != this.C0;
    }

    public final boolean l4(Context context) {
        AbstractC13042fc3.i(context, "context");
        String strT3 = t3();
        if (strT3 == null) {
            strT3 = "";
        }
        KV0.a(context, Separators.AT + strT3);
        if (KV0.b()) {
            int i = C8674c.a[this.f1.ordinal()];
            int i2 = (i == 1 || i != 2) ? RD5.toast_nickname_copied : RD5.toast_group_nickname_copied;
            String string = context.getString(i2);
            AbstractC13042fc3.h(string, "getString(...)");
            I2(string);
        }
        return true;
    }

    public final boolean m2(Q14 q14) {
        AbstractC13042fc3.i(q14, "member");
        return (!W3() || q14.k() || q14.i() == this.C0) ? false : true;
    }

    public final InterfaceC10258bL6 m3() {
        return this.R0;
    }

    public final InterfaceC4557Fq2 m4(long j) {
        return AbstractC6459Nq2.F(this.Z.c(j));
    }

    public final InterfaceC13730gj3 n2(boolean z2, SA2 sa2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8678g(z2, this, sa2, null), 3, null);
    }

    public final int n3() {
        Integer numG = ((AbstractC4886Gz1.b) this.l1.getValue()).g();
        if (numG != null) {
            return numG.intValue();
        }
        return 0;
    }

    public final InterfaceC10040ay6 o3() {
        return this.v1;
    }

    public final void o4(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new H(i, null), 3, null);
    }

    public final InterfaceC13730gj3 p2(int i, String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8679h(str, this, i, null), 3, null);
    }

    public final InterfaceC4557Fq2 p3() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.u1;
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Ly6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.q3(this.a);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.u1 = interfaceC4557Fq2A;
        return interfaceC4557Fq2A;
    }

    public final void p4() {
        this.f.r0(this.Y0.getPeerId()).a(new I());
    }

    public final void q4() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.Q0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void r2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8680i(null), 3, null);
    }

    public final int r3() {
        return this.C0;
    }

    public final InterfaceC13730gj3 s2(String str) {
        AbstractC13042fc3.i(str, "about");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8681j(str, null), 3, null);
    }

    public final String s3() {
        String strH = ((AbstractC4886Gz1.b) this.l1.getValue()).h();
        return strH == null ? "" : strH;
    }

    public final void s4(EnumC14682iJ5 enumC14682iJ5, Integer num) {
        AbstractC13042fc3.i(enumC14682iJ5, "actionType");
        C6409Nm c6409Nm = this.A;
        Map mapP = AbstractC20051rO3.p(AbstractC4616Fw7.a("peer_type", String.valueOf(this.f1.getValue())), AbstractC4616Fw7.a("action_type", enumC14682iJ5), AbstractC4616Fw7.a("source_id", Integer.valueOf(this.Y0.getPeerId())));
        if (num != null) {
            mapP.put("peer_id", Integer.valueOf(num.intValue()));
        }
        C19938rB7 c19938rB7 = C19938rB7.a;
        c6409Nm.d("recommended_bots", mapP);
    }

    public final InterfaceC13730gj3 t2(String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8682k(str, this, null), 3, null);
    }

    public final String t3() {
        return ((AbstractC4886Gz1.b) this.l1.getValue()).p();
    }

    public final InterfaceC13730gj3 u2(String str) {
        AbstractC13042fc3.i(str, "name");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8683l(str, null), 3, null);
    }

    public final InterfaceC4557Fq2 u3() {
        return this.V0;
    }

    public final InterfaceC13730gj3 v2(String str) {
        AbstractC13042fc3.i(str, "nick");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8684m(str, null), 3, null);
    }

    public final C11458d25 v3() {
        return this.Y0;
    }

    public final InterfaceC13730gj3 w2(int i, String str) {
        AbstractC13042fc3.i(str, "name");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8685n(i, str, null), 3, null);
    }

    public final C24119y45 w3() {
        return ((AbstractC4886Gz1.b) this.l1.getValue()).j();
    }

    public final void w4(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.O0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    public final InterfaceC13730gj3 x2(String str) {
        AbstractC13042fc3.i(str, "link");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8686o(str, null), 3, null);
    }

    public final InterfaceC4557Fq2 x3() {
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.p1;
        if (interfaceC4557Fq2 != null) {
            return interfaceC4557Fq2;
        }
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(new C12960fT4(new MT4(21, 0, false, 21, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.Py6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8671Wy6.y3(this.a);
            }
        }, 2, null).a(), AbstractC9773aX7.a(this));
        this.p1 = interfaceC4557Fq2A;
        return interfaceC4557Fq2A;
    }

    public final void x4(boolean z2) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new L(z2, this, null), 3, null);
    }

    public final void y4(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    public final void z2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8689r(null), 3, null);
    }

    public final InterfaceC13730gj3 z3() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new A(null), 3, null);
    }
}
