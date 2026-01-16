package ir.nasim;

import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.MeetStruct$GroupCall;
import ai.bale.proto.PeersStruct$OutExPeer;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12895fM2;
import ir.nasim.AbstractC17643nJ4;
import ir.nasim.AbstractC21761u53;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.C17448mz0;
import ir.nasim.C4627Fy0;
import ir.nasim.C9475a16;
import ir.nasim.E26;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC18490ok7;
import ir.nasim.InterfaceC9449Zz0;
import ir.nasim.T25;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.features.call.service.CallService;
import ir.nasim.features.call.service.VideoCallService;
import ir.nasim.features.call.ui.CallActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Fy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4627Fy0 implements InterfaceC5110Hy0 {
    public static final C4628a C = new C4628a(null);
    public static final int D = 8;
    private final InterfaceC8327Vm4 A;
    private Long B;
    private final InterfaceC20315ro1 a;
    private final AbstractC13778go1 b;
    private final Context c;
    private final A08 d;
    private final OK7 e;
    private final C10299bQ2 f;
    private final C8054Ui1 g;
    private final UG7 h;
    private final AbstractC13778go1 i;
    private final C22875vy0 j;
    private final C6409Nm k;
    private final E84 l;
    private final int m;
    private final SettingsModule n;
    private final C5344Iy0 o;
    private InterfaceC13730gj3 p;
    private long q;
    private final InterfaceC8327Vm4 r;
    private final InterfaceC8327Vm4 s;
    private final InterfaceC9173Yu3 t;
    private final InterfaceC9173Yu3 u;
    private XV4 v;
    private final Map w;
    private final InterfaceC8327Vm4 x;
    private final InterfaceC8327Vm4 y;
    private int z;

    /* renamed from: ir.nasim.Fy0$A */
    static final class A extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Fy0$A$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C4627Fy0 a;

            a(C4627Fy0 c4627Fy0) {
                this.a = c4627Fy0;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                C19406qI3.a("CallRepository", "current call state : " + c17448mz0.e() + Separators.SP, new Object[0]);
                this.a.O(c17448mz0);
                return C19938rB7.a;
            }
        }

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C17448mz0.a y(C17448mz0 c17448mz0) {
            return c17448mz0.e();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new A(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C18039nz0.a.d(), new UA2() { // from class: ir.nasim.Gy0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C4627Fy0.A.y((C17448mz0) obj2);
                    }
                });
                a aVar = new a(C4627Fy0.this);
                this.b = 1;
                if (interfaceC4557Fq2X.b(aVar, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$B */
    static final class B extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        B(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objZ0 = C4627Fy0.this.Z0(0L, this);
            return objZ0 == AbstractC14862ic3.e() ? objZ0 : C9475a16.a(objZ0);
        }
    }

    /* renamed from: ir.nasim.Fy0$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new C(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C4627Fy0.this.j;
                long j = this.d;
                this.b = 1;
                objB = c22875vy0.b(j, this);
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
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$D */
    static final class D extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        D(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA1 = C4627Fy0.this.a1(0L, this);
            return objA1 == AbstractC14862ic3.e() ? objA1 : C9475a16.a(objA1);
        }
    }

    /* renamed from: ir.nasim.Fy0$E */
    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new E(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objF;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C4627Fy0.this.j;
                long j = this.d;
                this.b = 1;
                objF = c22875vy0.f(j, this);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objF = ((C9475a16) obj).l();
            }
            return C9475a16.a(objF);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$F */
    static final class F extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        F(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objB1 = C4627Fy0.this.b1(0L, null, this);
            return objB1 == AbstractC14862ic3.e() ? objB1 : C9475a16.a(objB1);
        }
    }

    /* renamed from: ir.nasim.Fy0$G */
    static final class G extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        G(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objK1 = C4627Fy0.this.k1(0L, null, this);
            return objK1 == AbstractC14862ic3.e() ? objK1 : C9475a16.a(objK1);
        }
    }

    /* renamed from: ir.nasim.Fy0$H */
    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(long j, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new H(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objJ;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C4627Fy0.this.j;
                long j = this.d;
                String str = this.e;
                this.b = 1;
                objJ = c22875vy0.j(j, str, this);
                if (objJ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objJ = ((C9475a16) obj).l();
            }
            return C9475a16.a(objJ);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$I */
    static final class I extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C22675ve3 c;
        final /* synthetic */ C4627Fy0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        I(C22675ve3 c22675ve3, C4627Fy0 c4627Fy0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c22675ve3;
            this.d = c4627Fy0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new I(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long jB = this.c.b();
                this.b = 1;
                if (HG1.b(jB, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C19406qI3.a("CallRepository", "invited time expired for user " + this.c.a(), new Object[0]);
            this.d.Y0(this.c.a());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((I) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$J */
    static final class J extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ MeetStruct$Call e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        J(int i, MeetStruct$Call meetStruct$Call, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = meetStruct$Call;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new J(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4627Fy0 c4627Fy0 = C4627Fy0.this;
                int i2 = this.d;
                MeetStruct$Call meetStruct$Call = this.e;
                boolean z = this.f;
                this.b = 1;
                if (c4627Fy0.W(i2, meetStruct$Call, z, this) == objE) {
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
            return ((J) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$K */
    static final class K extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        K(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objT1 = C4627Fy0.this.t1(this);
            return objT1 == AbstractC14862ic3.e() ? objT1 : C9475a16.a(objT1);
        }
    }

    /* renamed from: ir.nasim.Fy0$L */
    static final class L extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        L(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new L(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objK;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C4627Fy0.this.j;
                long jC = ((C17448mz0) C18039nz0.a.d().getValue()).c();
                this.b = 1;
                objK = c22875vy0.k(jC, this);
                if (objK == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objK = ((C9475a16) obj).l();
            }
            return C9475a16.a(objK);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((L) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$M */
    static final class M extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        M(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new M(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C4627Fy0.this.j;
                long jC = ((C17448mz0) C18039nz0.a.d().getValue()).c();
                this.b = 1;
                if (c22875vy0.l(jC, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((M) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$N */
    static final class N extends AbstractC19859r37 implements InterfaceC14603iB2 {
        boolean b;
        int c;

        /* renamed from: ir.nasim.Fy0$N$a */
        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Fy0$N$a$a, reason: collision with other inner class name */
            public static final class C0381a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Fy0$N$a$a$a, reason: collision with other inner class name */
                public static final class C0382a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0382a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C0381a.this.a(null, this);
                    }
                }

                public C0381a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                        boolean r0 = r6 instanceof ir.nasim.C4627Fy0.N.a.C0381a.C0382a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Fy0$N$a$a$a r0 = (ir.nasim.C4627Fy0.N.a.C0381a.C0382a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Fy0$N$a$a$a r0 = new ir.nasim.Fy0$N$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.M26 r5 = (ir.nasim.M26) r5
                        boolean r5 = r5.q()
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.N.a.C0381a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C0381a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Fy0$N$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Fy0$N$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Fy0$N$b$a$a, reason: collision with other inner class name */
                public static final class C0383a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0383a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                        boolean r0 = r6 instanceof ir.nasim.C4627Fy0.N.b.a.C0383a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Fy0$N$b$a$a r0 = (ir.nasim.C4627Fy0.N.b.a.C0383a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Fy0$N$b$a$a r0 = new ir.nasim.Fy0$N$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.M26 r5 = (ir.nasim.M26) r5
                        boolean r5 = r5.r()
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.N.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        N(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new N(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00be  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                boolean r0 = r10.b
                ir.nasim.AbstractC10685c16.b(r11)
                goto L6d
            L14:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1c:
                ir.nasim.AbstractC10685c16.b(r11)
                goto L43
            L20:
                ir.nasim.AbstractC10685c16.b(r11)
                ir.nasim.nz0 r11 = ir.nasim.C18039nz0.a
                ir.nasim.Zm4 r11 = r11.h()
                java.lang.Object r11 = r11.getValue()
                ir.nasim.mz0 r11 = (ir.nasim.C17448mz0) r11
                ir.nasim.Fq2 r11 = r11.h()
                if (r11 == 0) goto Ld8
                ir.nasim.Fy0$N$a r1 = new ir.nasim.Fy0$N$a
                r1.<init>(r11)
                r10.c = r3
                java.lang.Object r11 = ir.nasim.AbstractC6459Nq2.G(r1, r10)
                if (r11 != r0) goto L43
                return r0
            L43:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                ir.nasim.nz0 r1 = ir.nasim.C18039nz0.a
                ir.nasim.Zm4 r1 = r1.h()
                java.lang.Object r1 = r1.getValue()
                ir.nasim.mz0 r1 = (ir.nasim.C17448mz0) r1
                ir.nasim.Fq2 r1 = r1.h()
                if (r1 == 0) goto Ld5
                ir.nasim.Fy0$N$b r4 = new ir.nasim.Fy0$N$b
                r4.<init>(r1)
                r10.b = r11
                r10.c = r2
                java.lang.Object r1 = ir.nasim.AbstractC6459Nq2.G(r4, r10)
                if (r1 != r0) goto L6b
                return r0
            L6b:
                r0 = r11
                r11 = r1
            L6d:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r0 == 0) goto Lbe
                if (r11 == 0) goto L81
                ir.nasim.Fy0 r11 = ir.nasim.C4627Fy0.this
                long r0 = java.lang.System.currentTimeMillis()
                ir.nasim.C4627Fy0.J(r11, r0)
                goto Lbb
            L81:
                ir.nasim.Fy0 r4 = ir.nasim.C4627Fy0.this
                ir.nasim.Q12$a r11 = ir.nasim.Q12.b
                long r0 = java.lang.System.currentTimeMillis()
                ir.nasim.Fy0 r11 = ir.nasim.C4627Fy0.this
                long r5 = ir.nasim.C4627Fy0.C(r11)
                long r0 = r0 - r5
                ir.nasim.W12 r11 = ir.nasim.W12.d
                long r0 = ir.nasim.T12.t(r0, r11)
                long r5 = ir.nasim.Q12.D(r0)
                ir.nasim.nz0 r11 = ir.nasim.C18039nz0.a
                ir.nasim.bL6 r0 = r11.d()
                java.lang.Object r0 = r0.getValue()
                ir.nasim.mz0 r0 = (ir.nasim.C17448mz0) r0
                long r7 = r0.c()
                ir.nasim.Zm4 r11 = r11.h()
                java.lang.Object r11 = r11.getValue()
                ir.nasim.mz0 r11 = (ir.nasim.C17448mz0) r11
                ir.nasim.Xx0 r9 = r11.d()
                ir.nasim.C4627Fy0.I(r4, r5, r7, r9)
            Lbb:
                java.lang.String r11 = "toggle_camera"
                goto Lc9
            Lbe:
                ir.nasim.Fy0 r11 = ir.nasim.C4627Fy0.this
                long r0 = java.lang.System.currentTimeMillis()
                ir.nasim.C4627Fy0.J(r11, r0)
                java.lang.String r11 = "enable_video"
            Lc9:
                ir.nasim.Fy0 r0 = ir.nasim.C4627Fy0.this
                android.content.Intent r11 = ir.nasim.C4627Fy0.u(r0, r11)
                ir.nasim.C4627Fy0.H(r0, r11, r3)
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            Ld5:
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            Ld8:
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.N.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((N) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$O */
    static final class O extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        O(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.x1(null, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$a, reason: case insensitive filesystem */
    public static final class C4628a {
        private C4628a() {
        }

        public /* synthetic */ C4628a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Fy0$b, reason: case insensitive filesystem */
    public /* synthetic */ class C4629b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC12029dv0.values().length];
            try {
                iArr[EnumC12029dv0.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12029dv0.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC12029dv0.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC12029dv0.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[C17448mz0.a.values().length];
            try {
                iArr2[C17448mz0.a.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[C17448mz0.a.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[C17448mz0.a.j.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[C17448mz0.a.l.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[C17448mz0.a.m.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[C17448mz0.a.k.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[C17448mz0.a.d.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            b = iArr2;
            int[] iArr3 = new int[T25.f.values().length];
            try {
                iArr3[T25.f.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[T25.f.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            c = iArr3;
        }
    }

    /* renamed from: ir.nasim.Fy0$c, reason: case insensitive filesystem */
    static final class C4630c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC17643nJ4.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4630c(AbstractC17643nJ4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new C4630c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4627Fy0 c4627Fy0 = C4627Fy0.this;
                AbstractC21761u53.a aVar = new AbstractC21761u53.a(this.d.a(), this.d.b(), this.d.d(), new AbstractC7031Pz0.b(AbstractC12895fM2.b.a), this.d.c());
                this.b = 1;
                if (c4627Fy0.x1(aVar, this) == objE) {
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
            return ((C4630c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$d, reason: case insensitive filesystem */
    static final class C4631d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        C4631d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.L(null, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$e, reason: case insensitive filesystem */
    static final class C4632e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C4632e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new C4632e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(90000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C19406qI3.a("CallRepository", "stopCallJob executed", new Object[0]);
            C4627Fy0.this.q0().cancel((int) ((C17448mz0) C18039nz0.a.d().getValue()).c());
            C5344Iy0 c5344Iy0 = C4627Fy0.this.o;
            if (c5344Iy0 != null) {
                c5344Iy0.g();
            }
            C4627Fy0.this.w0(C17448mz0.a.n);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C4632e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$f, reason: case insensitive filesystem */
    static final class C4633f extends AbstractC22163um1 {
        Object a;
        Object b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        C4633f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.W(0, null, false, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$g, reason: case insensitive filesystem */
    static final class C4634g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        C4634g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA0 = C4627Fy0.this.a0(false, null, this);
            return objA0 == AbstractC14862ic3.e() ? objA0 : C9475a16.a(objA0);
        }
    }

    /* renamed from: ir.nasim.Fy0$h, reason: case insensitive filesystem */
    static final class C4635h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;
        final /* synthetic */ Long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4635h(boolean z, Long l, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
            this.e = l;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new C4635h(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C4627Fy0.this.j;
                boolean z = this.d;
                Long l = this.e;
                this.b = 1;
                objC = c22875vy0.c(z, l, this);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objC = ((C9475a16) obj).l();
            }
            return C9475a16.a(objC);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C4635h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$i, reason: case insensitive filesystem */
    static final class C4636i extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        C4636i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG0 = C4627Fy0.this.g0(null, this);
            return objG0 == AbstractC14862ic3.e() ? objG0 : C9475a16.a(objG0);
        }
    }

    /* renamed from: ir.nasim.Fy0$j, reason: case insensitive filesystem */
    static final class C4637j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4637j(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new C4637j(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C4627Fy0.this.j;
                String str = this.d;
                this.b = 1;
                objD = c22875vy0.d(str, this);
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
            return C9475a16.a(objD);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C4637j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$k, reason: case insensitive filesystem */
    static final class C4638k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ UG7 d;
        final /* synthetic */ C4627Fy0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4638k(int i, UG7 ug7, C4627Fy0 c4627Fy0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = ug7;
            this.e = c4627Fy0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C4638k(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                int i2 = this.c;
                if (i2 == 0) {
                    return new C8942Xx0(0, "", null, true);
                }
                C6517Nv5 c6517Nv5W = this.d.W(AbstractC9766aX0.e(new C25238zy(i2, 0L)));
                AbstractC13042fc3.h(c6517Nv5W, "forceLoadRequiredGroupPeers(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5W, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return (C8942Xx0) obj;
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C4627Fy0 c4627Fy0 = this.e;
            int i3 = this.c;
            if (C9475a16.e(objD) != null) {
                return new C8942Xx0(0, "", null, true);
            }
            C10299bQ2 c10299bQ2 = c4627Fy0.f;
            this.b = 2;
            obj = c4627Fy0.n0(i3, "", c10299bQ2, this);
            if (obj == objE) {
                return objE;
            }
            return (C8942Xx0) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C4638k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$l, reason: case insensitive filesystem */
    static final class C4639l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ UG7 e;
        final /* synthetic */ C4627Fy0 f;
        final /* synthetic */ OK7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4639l(int i, String str, UG7 ug7, C4627Fy0 c4627Fy0, OK7 ok7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = str;
            this.e = ug7;
            this.f = c4627Fy0;
            this.g = ok7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C4639l(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                int i2 = this.c;
                if (i2 == 0) {
                    return new C8942Xx0(0, this.d, null, false, 8, null);
                }
                C6517Nv5 c6517Nv5S0 = this.e.s0(AbstractC10360bX0.g(new C18766pD(i2, 0L)), AbstractC10360bX0.m());
                AbstractC13042fc3.h(c6517Nv5S0, "loadRequiredPeers(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5S0, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return (C8942Xx0) obj;
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C4627Fy0 c4627Fy0 = this.f;
            int i3 = this.c;
            String str = this.d;
            OK7 ok7 = this.g;
            if (C9475a16.e(objD) != null) {
                return new C8942Xx0(0, str, null, false, 8, null);
            }
            this.b = 2;
            obj = c4627Fy0.o0(i3, str, ok7, this);
            if (obj == objE) {
                return objE;
            }
            return (C8942Xx0) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C4639l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$m, reason: case insensitive filesystem */
    static final class C4640m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ String d;
        final /* synthetic */ UG7 e;
        final /* synthetic */ C4627Fy0 f;
        final /* synthetic */ OK7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4640m(List list, String str, UG7 ug7, C4627Fy0 c4627Fy0, OK7 ok7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = str;
            this.e = ug7;
            this.f = c4627Fy0;
            this.g = ok7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C4640m(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.isEmpty()) {
                    return new C8942Xx0(0, this.d, null, false, 8, null);
                }
                UG7 ug7 = this.e;
                List list = this.c;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C18766pD(((Number) it.next()).intValue(), 0L));
                }
                C6517Nv5 c6517Nv5S0 = ug7.s0(arrayList, AbstractC10360bX0.m());
                AbstractC13042fc3.h(c6517Nv5S0, "loadRequiredPeers(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5S0, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return (C8942Xx0) obj;
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C4627Fy0 c4627Fy0 = this.f;
            List list2 = this.c;
            String str = this.d;
            OK7 ok7 = this.g;
            if (C9475a16.e(objD) != null) {
                return new C8942Xx0(0, str, null, false, 8, null);
            }
            this.b = 2;
            obj = c4627Fy0.p0(list2, str, ok7, this);
            if (obj == objE) {
                return objE;
            }
            return (C8942Xx0) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C4640m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$n, reason: case insensitive filesystem */
    static final class C4641n extends AbstractC22163um1 {
        int a;
        Object b;
        /* synthetic */ Object c;
        int e;

        C4641n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.n0(0, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$o, reason: case insensitive filesystem */
    static final class C4642o extends AbstractC22163um1 {
        int a;
        Object b;
        /* synthetic */ Object c;
        int e;

        C4642o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.o0(0, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$p */
    static final class p extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        /* synthetic */ Object h;
        int j;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.p0(null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$q */
    public static final class q implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Fy0$q$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Fy0$q$a$a, reason: collision with other inner class name */
            public static final class C0384a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0384a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C4627Fy0.q.a.C0384a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Fy0$q$a$a r0 = (ir.nasim.C4627Fy0.q.a.C0384a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Fy0$q$a$a r0 = new ir.nasim.Fy0$q$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.NT4 r6 = (ir.nasim.NT4) r6
                    ir.nasim.Fy0$r r2 = new ir.nasim.Fy0$r
                    r4 = 0
                    r2.<init>(r4)
                    ir.nasim.NT4 r6 = ir.nasim.TT4.g(r6, r2)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.q.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public q(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Fy0$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            r rVar = new r(interfaceC20295rm1);
            rVar.c = obj;
            return rVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return new C9279Zg1().a((C3512Be1) this.c);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C3512Be1 c3512Be1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(c3512Be1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C9669aM2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(C9669aM2 c9669aM2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c9669aM2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4627Fy0.this.new s(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4627Fy0 c4627Fy0 = C4627Fy0.this;
                AbstractC21761u53.a aVar = new AbstractC21761u53.a(this.d.a().getId(), this.d.a().getInitiatorUserId(), this.d.a().getCreateDate().getValue(), new AbstractC7031Pz0.b(AbstractC12895fM2.b.a), this.d.a().getPeer().getId());
                this.b = 1;
                if (c4627Fy0.x1(aVar, this) == objE) {
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
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C4627Fy0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(List list, C4627Fy0 c4627Fy0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c4627Fy0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new t(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ArrayList arrayList = new ArrayList();
                List list = this.c;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AbstractC6392Nk0.d(((R25) it.next()).c()));
                }
                arrayList.addAll(arrayList2);
                C6517Nv5 c6517Nv5W0 = this.d.e.w0(arrayList, true);
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5W0, null, this, 1, null);
                if (objD == objE) {
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
                objD = ((C9475a16) obj).l();
            }
            C4627Fy0 c4627Fy0 = this.d;
            List list2 = this.c;
            if (C9475a16.e(objD) == null) {
                this.b = 2;
                if (c4627Fy0.L(list2, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$u */
    static final class u extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objL0 = C4627Fy0.this.L0(0L, null, this);
            return objL0 == AbstractC14862ic3.e() ? objL0 : C9475a16.a(objL0);
        }
    }

    /* renamed from: ir.nasim.Fy0$v */
    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C4627Fy0 d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(List list, C4627Fy0 c4627Fy0, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c4627Fy0;
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new v(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list = this.c;
                C4627Fy0 c4627Fy0 = this.d;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    PeersStruct$OutExPeer peersStruct$OutExPeerX1 = C18732p92.a.x1(c4627Fy0.b0((C11458d25) it.next()));
                    if (peersStruct$OutExPeerX1 == null) {
                        C9475a16.a aVar = C9475a16.b;
                        return C9475a16.a(C9475a16.b(AbstractC10685c16.a(new Exception("Invalid peer"))));
                    }
                    arrayList.add(peersStruct$OutExPeerX1);
                }
                C4627Fy0 c4627Fy02 = this.d;
                long j = this.e;
                this.b = 1;
                objB1 = c4627Fy02.b1(j, arrayList, this);
                if (objB1 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objB1 = ((C9475a16) obj).l();
            }
            return C9475a16.a(objB1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fy0$w */
    static final class w extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.Q0(null, false, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$x */
    static final class x extends AbstractC22163um1 {
        Object a;
        Object b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        x(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.R0(null, null, false, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$y */
    static final class y extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        y(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C4627Fy0.this.S0(null, 0, 0L, this);
        }
    }

    /* renamed from: ir.nasim.Fy0$z */
    static final class z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ C4627Fy0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(long j, C4627Fy0 c4627Fy0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = c4627Fy0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new z(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            long j = this.c;
            if (j != 0) {
                C19406qI3.a("CallRepository", "discard notification  argument with updateCallId  " + j + " | " + ((int) j), new Object[0]);
                this.d.q0().cancel((int) this.c);
            } else {
                C18039nz0 c18039nz0 = C18039nz0.a;
                C19406qI3.a("CallRepository", "discard notification with normal arguemnt id " + ((C17448mz0) c18039nz0.d().getValue()).c() + " | " + ((int) ((C17448mz0) c18039nz0.d().getValue()).c()), new Object[0]);
                this.d.q0().cancel((int) ((C17448mz0) c18039nz0.d().getValue()).c());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((z) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4627Fy0(InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, Context context, A08 a08, OK7 ok7, C10299bQ2 c10299bQ2, C8054Ui1 c8054Ui1, UG7 ug7, AbstractC13778go1 abstractC13778go12, C22875vy0 c22875vy0, C6409Nm c6409Nm, E84 e84, int i, SettingsModule settingsModule, C5344Iy0 c5344Iy0) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(a08, "voiceCallModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(ug7, "updateModule");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(c22875vy0, "callRemoteDataSource");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c5344Iy0, "callRingtoneHandler");
        this.a = interfaceC20315ro1;
        this.b = abstractC13778go1;
        this.c = context;
        this.d = a08;
        this.e = ok7;
        this.f = c10299bQ2;
        this.g = c8054Ui1;
        this.h = ug7;
        this.i = abstractC13778go12;
        this.j = c22875vy0;
        this.k = c6409Nm;
        this.l = e84;
        this.m = i;
        this.n = settingsModule;
        this.o = c5344Iy0;
        V0();
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.r = interfaceC8327Vm4B;
        this.s = interfaceC8327Vm4B;
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yy0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4627Fy0.T0(this.a);
            }
        });
        this.u = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zy0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C4627Fy0.U0(this.a));
            }
        });
        this.w = new LinkedHashMap();
        InterfaceC8327Vm4 interfaceC8327Vm4B2 = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.x = interfaceC8327Vm4B2;
        this.y = interfaceC8327Vm4B2;
        this.A = AbstractC11420cy6.b(0, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A0(boolean z2, C4627Fy0 c4627Fy0, C9669aM2 c9669aM2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        AbstractC13042fc3.i(c9669aM2, "$groupCallStarted");
        if (!z3) {
            C19406qI3.a("CallRepository", "groupCallStarted => amICreator: " + z2 + " isUserOnACall: " + z4, new Object[0]);
            if (!z2 && !z4) {
                AbstractC10533bm0.d(c4627Fy0.a, null, null, c4627Fy0.new s(c9669aM2, null), 3, null);
            }
        }
        return C19938rB7.a;
    }

    private final void B0(C6826Pd3 c6826Pd3) {
        C10263bM2.a.f(c6826Pd3.a());
        if (((C17448mz0) C18039nz0.a.h().getValue()).c() == c6826Pd3.a()) {
            d(EnumC12029dv0.d, 0);
        }
    }

    private final void D0(int i) {
        Object value;
        C17448mz0 c17448mz0;
        C18039nz0 c18039nz0;
        AbstractC7031Pz0 abstractC7031Pz0F;
        Object value2;
        C17448mz0 c17448mz02;
        Object value3;
        C18039nz0 c18039nz02 = C18039nz0.a;
        if (((C17448mz0) c18039nz02.h().getValue()).e() == C17448mz0.a.g) {
            InterfaceC9336Zm4 interfaceC9336Zm4H = c18039nz02.h();
            do {
                value = interfaceC9336Zm4H.getValue();
                c17448mz0 = (C17448mz0) value;
                c18039nz0 = C18039nz0.a;
                abstractC7031Pz0F = ((C17448mz0) c18039nz0.d().getValue()).f();
                if (abstractC7031Pz0F == null) {
                    throw new IllegalStateException("");
                }
            } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : y1(abstractC7031Pz0F), (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
            InterfaceC9336Zm4 interfaceC9336Zm4H2 = c18039nz0.h();
            do {
                value2 = interfaceC9336Zm4H2.getValue();
                c17448mz02 = (C17448mz0) value2;
                InterfaceC9336Zm4 interfaceC9336Zm4G = c17448mz02.g();
                do {
                    value3 = interfaceC9336Zm4G.getValue();
                } while (!interfaceC9336Zm4G.f(value3, AbstractC15401jX0.R0(AbstractC9766aX0.e(new M26(false, false, false, false, String.valueOf(i), null, N26.b, null, null, false, null, null, null, null, null, 32687, null)), (List) value3)));
            } while (!interfaceC9336Zm4H2.f(value2, c17448mz02));
        }
    }

    private final void E0(R25 r25) {
        C18039nz0 c18039nz0 = C18039nz0.a;
        if (((C17448mz0) c18039nz0.d().getValue()).e() == C17448mz0.a.e && ((C17448mz0) c18039nz0.d().getValue()).c() == r25.a() && r25.c() == this.m) {
            this.o.g();
            q0().cancel((int) ((C17448mz0) c18039nz0.d().getValue()).c());
        }
    }

    private final Object G0(int i, T25.f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
        int i2 = C4629b.c[fVar.ordinal()];
        if (i2 == 1) {
            Object objA = this.x.a(new E26.a(i), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        Object objA2 = this.x.a(new E26.b(i), interfaceC20295rm1);
        return objA2 == AbstractC14862ic3.e() ? objA2 : C19938rB7.a;
    }

    private final void H0() {
        this.d.H(((C17448mz0) C18039nz0.a.d().getValue()).c(), K04.CallDiscardReason_HANGUP);
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0081 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00e1 -> B:60:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0111 -> B:60:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x011d -> B:60:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0127 -> B:60:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x012f -> B:60:0x0138). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(java.util.List r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.L(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    private final boolean M() {
        C18039nz0 c18039nz0 = C18039nz0.a;
        int i = C4629b.b[((C17448mz0) c18039nz0.h().getValue()).e().ordinal()];
        if (i == 3 || i == 4 || i == 5) {
            return true;
        }
        return i != 6 ? i == 7 && ((C17448mz0) c18039nz0.h().getValue()).i() != null : ((C17448mz0) c18039nz0.d().getValue()).f() instanceof AbstractC7031Pz0.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(C17448mz0 c17448mz0) {
        int i = C4629b.b[c17448mz0.e().ordinal()];
        if (i == 1) {
            Q(this.a);
            InterfaceC13730gj3 interfaceC13730gj3 = this.p;
            if (interfaceC13730gj3 != null) {
                interfaceC13730gj3.start();
            }
            this.d.R(c17448mz0.c());
            return;
        }
        if (i != 2) {
            return;
        }
        InterfaceC13730gj3 interfaceC13730gj32 = this.p;
        if (interfaceC13730gj32 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
        }
        InterfaceC13730gj3 interfaceC13730gj33 = this.p;
        C19406qI3.a("CallRepository", "stopCallJob cancelled " + interfaceC13730gj33 + " | job cancelled status => " + (interfaceC13730gj33 != null ? Boolean.valueOf(interfaceC13730gj33.isCancelled()) : null), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent P(String str) {
        Intent intent = new Intent(this.c, (Class<?>) VideoCallService.class);
        intent.putExtra("switch_type", EnumC13941h47.a);
        intent.setAction(str);
        return intent;
    }

    private final void Q(InterfaceC20315ro1 interfaceC20315ro1) {
        InterfaceC13730gj3 interfaceC13730gj3 = this.p;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.p = AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C4632e(null), 3, null);
    }

    private final void R(boolean z2, long j) {
        C19406qI3.a("CallRepository", "declineCall => isFromNotif " + z2, new Object[0]);
        this.o.g();
        C18039nz0 c18039nz0 = C18039nz0.a;
        if (((C17448mz0) c18039nz0.d().getValue()).c() != j) {
            C19406qI3.a("CallRepository", "declineCall => wrong state call id is not valid <" + j + " - " + ((C17448mz0) c18039nz0.d().getValue()).c() + "> | <" + ((int) j) + " - " + ((int) ((C17448mz0) c18039nz0.d().getValue()).c()) + Separators.GREATER_THAN, new Object[0]);
        }
        if (j != -1) {
            C19406qI3.a("CallRepository", "discard notification pushCallId argument with id " + j + "}", new Object[0]);
            q0().cancel((int) j);
        } else {
            C19406qI3.a("CallRepository", "discard notification with normal callId id " + ((C17448mz0) c18039nz0.d().getValue()).c() + " }", new Object[0]);
            q0().cancel((int) ((C17448mz0) c18039nz0.d().getValue()).c());
        }
        C17448mz0 c17448mz0 = (C17448mz0) c18039nz0.h().getValue();
        if (c17448mz0.f() != null) {
            if (!(c17448mz0.f() instanceof AbstractC7031Pz0.d)) {
                this.d.H(c17448mz0.c(), K04.CallDiscardReason_HANGUP);
            } else if (AbstractC13042fc3.d(((AbstractC7031Pz0.d) c17448mz0.f()).d(), AbstractC12895fM2.a.a)) {
                this.d.P(((C17448mz0) c18039nz0.d().getValue()).c(), false);
            }
        }
        w0(C17448mz0.a.n);
    }

    static /* synthetic */ void S(C4627Fy0 c4627Fy0, boolean z2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = -1;
        }
        c4627Fy0.R(z2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager T0(C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        Object systemService = c4627Fy0.c.getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U0(C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        return !AD4.e(c4627Fy0.c).a();
    }

    private final void V() {
        f1(P("ACTION_DESTROY_SERVICE_SWITCH"), true);
    }

    private final InterfaceC13730gj3 V0() {
        return AbstractC10533bm0.d(this.a, null, null, new A(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W(int r8, final ai.bale.proto.MeetStruct$Call r9, final boolean r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof ir.nasim.C4627Fy0.C4633f
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.Fy0$f r0 = (ir.nasim.C4627Fy0.C4633f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Fy0$f r0 = new ir.nasim.Fy0$f
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.d
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.f
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            boolean r10 = r6.c
            java.lang.Object r8 = r6.b
            r9 = r8
            ai.bale.proto.MeetStruct$Call r9 = (ai.bale.proto.MeetStruct$Call) r9
            java.lang.Object r8 = r6.a
            ir.nasim.Fy0 r8 = (ir.nasim.C4627Fy0) r8
            ir.nasim.AbstractC10685c16.b(r11)
            goto L59
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.UG7 r4 = r7.h
            ir.nasim.OK7 r5 = r7.e
            r6.a = r7
            r6.b = r9
            r6.c = r10
            r6.f = r2
            java.lang.String r3 = ""
            r1 = r7
            r2 = r8
            java.lang.Object r11 = r1.i0(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L58
            return r0
        L58:
            r8 = r7
        L59:
            ir.nasim.Xx0 r11 = (ir.nasim.C8942Xx0) r11
            ir.nasim.By0 r0 = new ir.nasim.By0
            r0.<init>()
            ir.nasim.AbstractC20507s76.z(r0)
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.W(int, ai.bale.proto.MeetStruct$Call, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(MeetStruct$Call meetStruct$Call, C4627Fy0 c4627Fy0, boolean z2, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "$callPeer");
        if (meetStruct$Call != null && c4627Fy0.r0() && (AbstractC7426Rr.a.q() || !C5161Id6.a.i())) {
            C19406qI3.a("CallRepository", "Return from init call, because notifications is disabled!", new Object[0]);
            c4627Fy0.d.T();
            return;
        }
        Long lValueOf = meetStruct$Call != null ? Long.valueOf(meetStruct$Call.getId()) : null;
        AbstractC13042fc3.f(lValueOf);
        long jLongValue = lValueOf.longValue();
        AbstractC7031Pz0 abstractC7031Pz0 = z2 ? AbstractC7031Pz0.c.b : AbstractC7031Pz0.e.b;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        while (true) {
            Object value = interfaceC9336Zm4H.getValue();
            C17448mz0 c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
            if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : c8942Xx0, (4091 & 2) != 0 ? c17448mz0.b : jLongValue, (4091 & 4) != 0 ? c17448mz0.c : abstractC7031Pz0, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.e, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                break;
            } else {
                interfaceC9336Zm4H = interfaceC9336Zm4;
            }
        }
        if (c4627Fy0.r0()) {
            c4627Fy0.X0();
        } else {
            c4627Fy0.o.d();
            c4627Fy0.n1(c8942Xx0, meetStruct$Call.getId(), c4627Fy0.c, z2);
        }
    }

    private final void X0() {
        C19406qI3.a("CallRepository", "openCallActivity", new Object[0]);
        Intent intent = new Intent(this.c, (Class<?>) CallActivity.class);
        intent.setAction("bale_voice_call");
        intent.addFlags(268435456);
        this.c.startActivity(intent);
    }

    private final String Y(String str) {
        return AbstractC20762sZ6.f1(str, "_", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(int i) {
        Object value;
        C17448mz0 c17448mz0;
        Object value2;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4G = c17448mz0.g();
            do {
                value2 = interfaceC9336Zm4G.getValue();
                arrayList = new ArrayList();
                for (Object obj : (List) value2) {
                    if (Integer.parseInt(((M26) obj).j()) != i) {
                        arrayList.add(obj);
                    }
                }
            } while (!interfaceC9336Zm4G.f(value2, arrayList));
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.w.get(Integer.valueOf(i));
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            this.w.remove(Integer.valueOf(i));
        } while (!interfaceC9336Zm4H.f(value, c17448mz0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b1(long r5, java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C4627Fy0.F
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Fy0$F r0 = (ir.nasim.C4627Fy0.F) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$F r0 = new ir.nasim.Fy0$F
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.vy0 r8 = r4.j
            r0.c = r3
            java.lang.Object r5 = r8.i(r5, r7, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            boolean r6 = ir.nasim.C9475a16.j(r5)
            if (r6 == 0) goto L4f
            ai.bale.proto.Misc$ResponseVoid r5 = (ai.bale.proto.Misc$ResponseVoid) r5
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
        L4f:
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.b1(long, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ C6517Nv5 d0(C4627Fy0 c4627Fy0, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = 0;
        }
        return c4627Fy0.c0(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(C4627Fy0 c4627Fy0, long j, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        c4627Fy0.v = new XV4(c17637nI7.getName(), Long.valueOf(j));
    }

    private final void e1(InterfaceC8179Uw0 interfaceC8179Uw0, String str, long j, int i, int i2) {
        this.k.d("call_management", AbstractC20051rO3.p(AbstractC4616Fw7.a("action_type", Integer.valueOf(interfaceC8179Uw0.a())), AbstractC4616Fw7.a("call_id", Long.valueOf(j)), AbstractC4616Fw7.a("intended_user_id", Y(str)), AbstractC4616Fw7.a("peer_id", Integer.valueOf(i)), AbstractC4616Fw7.a("peer_type", Integer.valueOf(i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(Intent intent, boolean z2) {
        if (C18039nz0.k()) {
            if (z2 && CallService.INSTANCE.a() == null) {
                return;
            }
            intent.putExtra("switch_type", EnumC13941h47.a);
            r1(this, intent, !AD4.e(C5721Ko.a.d()).a(), false, 4, null);
        }
    }

    static /* synthetic */ void g1(C4627Fy0 c4627Fy0, Intent intent, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        c4627Fy0.f1(intent, z2);
    }

    private final Object h0(int i, UG7 ug7, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new C4638k(i, ug7, this, null), interfaceC20295rm1);
    }

    private final Object i0(int i, String str, UG7 ug7, OK7 ok7, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new C4639l(i, str, ug7, this, ok7, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(long j, long j2, C8942Xx0 c8942Xx0) {
        Map mapP = AbstractC20051rO3.p(AbstractC4616Fw7.a("action_type", 11), AbstractC4616Fw7.a("call_id", Long.valueOf(j2)), AbstractC4616Fw7.a("duration", Long.valueOf(j)));
        if (c8942Xx0 != null) {
            mapP.put("peer_id", Integer.valueOf(c8942Xx0.b()));
            mapP.put("peer_type", Integer.valueOf(c8942Xx0.b() == 0 ? 0 : c8942Xx0.d() ? 2 : 1));
        }
        this.k.d("call_action", mapP);
    }

    private final Object j0(List list, String str, UG7 ug7, OK7 ok7, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new C4640m(list, str, ug7, this, ok7, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(int r8, java.lang.String r9, ir.nasim.C10299bQ2 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof ir.nasim.C4627Fy0.C4641n
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Fy0$n r0 = (ir.nasim.C4627Fy0.C4641n) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Fy0$n r0 = new ir.nasim.Fy0$n
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            int r8 = r0.a
            java.lang.Object r9 = r0.b
            java.lang.String r9 = (java.lang.String) r9
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r10 = r11.l()
            goto L5c
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Vo3 r10 = r10.X1()
            long r5 = (long) r8
            ir.nasim.Nv5 r10 = r10.a(r5)
            java.lang.String r11 = "getValue(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            r0.b = r9
            r0.a = r8
            r0.e = r4
            java.lang.Object r10 = ir.nasim.AbstractC6756Ov5.d(r10, r3, r0, r4, r3)
            if (r10 != r1) goto L5c
            return r1
        L5c:
            java.lang.Throwable r11 = ir.nasim.C9475a16.e(r10)
            if (r11 != 0) goto L77
            ir.nasim.iL2 r10 = (ir.nasim.C14697iL2) r10
            ir.nasim.Xx0 r9 = new ir.nasim.Xx0
            java.lang.String r11 = r10.G0()
            java.lang.String r0 = "getTitle(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r0)
            ir.nasim.core.modules.profile.entity.Avatar r10 = r10.h0()
            r9.<init>(r8, r11, r10, r4)
            goto L7e
        L77:
            ir.nasim.Xx0 r8 = new ir.nasim.Xx0
            r10 = 0
            r8.<init>(r10, r9, r3, r4)
            r9 = r8
        L7e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.n0(int, java.lang.String, ir.nasim.bQ2, ir.nasim.rm1):java.lang.Object");
    }

    private final void n1(C8942Xx0 c8942Xx0, final long j, Context context, boolean z2) {
        C19406qI3.a("CallRepository", "SHOW INCOMING NOTIFICATION WITH ID $" + j, new Object[0]);
        q0().notify((int) j, C5335Ix0.a.C(context, c8942Xx0, j, z2, new UA2() { // from class: ir.nasim.Dy0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C4627Fy0.o1(this.a, j, (Notification) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o0(int r12, java.lang.String r13, ir.nasim.OK7 r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof ir.nasim.C4627Fy0.C4642o
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.Fy0$o r0 = (ir.nasim.C4627Fy0.C4642o) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Fy0$o r0 = new ir.nasim.Fy0$o
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r12 = r0.a
            java.lang.Object r13 = r0.b
            java.lang.String r13 = (java.lang.String) r13
            ir.nasim.AbstractC10685c16.b(r15)
            ir.nasim.a16 r15 = (ir.nasim.C9475a16) r15
            java.lang.Object r14 = r15.l()
        L34:
            r3 = r12
            r6 = r13
            goto L5e
        L37:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3f:
            ir.nasim.AbstractC10685c16.b(r15)
            ir.nasim.VL3 r14 = r14.o0()
            long r4 = (long) r12
            ir.nasim.Nv5 r14 = r14.k(r4)
            java.lang.String r15 = "get(...)"
            ir.nasim.AbstractC13042fc3.h(r14, r15)
            r0.b = r13
            r0.a = r12
            r0.e = r3
            r15 = 0
            java.lang.Object r14 = ir.nasim.AbstractC6756Ov5.d(r14, r15, r0, r3, r15)
            if (r14 != r1) goto L34
            return r1
        L5e:
            java.lang.Throwable r12 = ir.nasim.C9475a16.e(r14)
            if (r12 != 0) goto L8b
            ir.nasim.tK7 r14 = (ir.nasim.C21231tK7) r14
            ir.nasim.Xx0 r12 = new ir.nasim.Xx0
            ir.nasim.bZ6 r13 = r14.r()
            java.lang.Object r13 = r13.b()
            java.lang.String r13 = (java.lang.String) r13
            if (r13 != 0) goto L76
            r4 = r6
            goto L77
        L76:
            r4 = r13
        L77:
            ir.nasim.qQ7 r13 = r14.h()
            java.lang.Object r13 = r13.b()
            r5 = r13
            ir.nasim.core.modules.profile.entity.Avatar r5 = (ir.nasim.core.modules.profile.entity.Avatar) r5
            r7 = 8
            r8 = 0
            r6 = 0
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L97
        L8b:
            ir.nasim.Xx0 r12 = new ir.nasim.Xx0
            r9 = 8
            r10 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10)
        L97:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.o0(int, java.lang.String, ir.nasim.OK7, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o1(C4627Fy0 c4627Fy0, long j, Notification notification) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        AbstractC13042fc3.i(notification, "newIncomingNotification");
        if (((C17448mz0) C18039nz0.a.d().getValue()).e() == C17448mz0.a.e) {
            c4627Fy0.q0().notify((int) j, notification);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b1 -> B:21:0x00b8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p0(java.util.List r21, java.lang.String r22, ir.nasim.OK7 r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.p0(java.util.List, java.lang.String, ir.nasim.OK7, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0012 A[Catch: all -> 0x0010, TRY_LEAVE, TryCatch #0 {all -> 0x0010, blocks: (B:3:0x0002, B:6:0x000a, B:9:0x0012), top: B:22:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void q1(android.content.Intent r3, boolean r4, boolean r5) {
        /*
            r2 = this;
            if (r4 != 0) goto L12
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L10
            r0 = 26
            if (r4 < r0) goto L12
            if (r5 == 0) goto L12
            android.content.Context r4 = r2.c     // Catch: java.lang.Throwable -> L10
            ir.nasim.TM7.a(r4, r3)     // Catch: java.lang.Throwable -> L10
            goto L5e
        L10:
            r4 = move-exception
            goto L18
        L12:
            android.content.Context r4 = r2.c     // Catch: java.lang.Throwable -> L10
            r4.startService(r3)     // Catch: java.lang.Throwable -> L10
            goto L5e
        L18:
            java.lang.String r5 = r4.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error in startCallService: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "CallRepository"
            ir.nasim.C19406qI3.a(r1, r5, r0)
            java.lang.String r5 = r3.getAction()
            java.lang.String r0 = "incoming_voice"
            boolean r5 = ir.nasim.AbstractC13042fc3.d(r5, r0)
            if (r5 != 0) goto L4d
            java.lang.String r3 = r3.getAction()
            java.lang.String r5 = "incoming_video"
            boolean r3 = ir.nasim.AbstractC13042fc3.d(r3, r5)
            if (r3 == 0) goto L5e
        L4d:
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r3 < r5) goto L5e
            boolean r3 = ir.nasim.AbstractC13847gv0.a(r4)
            if (r3 == 0) goto L5e
            ir.nasim.A08 r3 = r2.d
            r3.T()
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.q1(android.content.Intent, boolean, boolean):void");
    }

    private final boolean r0() {
        return ((Boolean) this.u.getValue()).booleanValue();
    }

    static /* synthetic */ void r1(C4627Fy0 c4627Fy0, Intent intent, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = true;
        }
        c4627Fy0.q1(intent, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(C4627Fy0 c4627Fy0, MeetStruct$Call meetStruct$Call, int i, boolean z2) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        AbstractC13042fc3.i(meetStruct$Call, "$protoCall");
        if (InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, c4627Fy0.c, true, null, 4, null).b()) {
            C19406qI3.a("CallRepository", "startIncomingCall => doInitiateIncomingCall", new Object[0]);
            AbstractC10533bm0.d(c4627Fy0.a, null, null, c4627Fy0.new J(i, meetStruct$Call, z2, null), 3, null);
        } else {
            C19406qI3.a("CallRepository", "startIncomingCall => declineCallWithBusy", new Object[0]);
            c4627Fy0.U(meetStruct$Call.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 t0(C4627Fy0 c4627Fy0, String str) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        AbstractC13042fc3.i(str, "$search");
        return new C9884aj1(c4627Fy0.g, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(C17448mz0.a aVar) {
        C17448mz0 c17448mz0A;
        Object obj;
        InterfaceC9336Zm4 interfaceC9336Zm4;
        C17448mz0.a aVar2 = aVar;
        C19406qI3.a("CallRepository", "goToFinalState with state " + aVar2, new Object[0]);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        while (true) {
            Object value = interfaceC9336Zm4H.getValue();
            C17448mz0 c17448mz0 = (C17448mz0) value;
            if (aVar2 == C17448mz0.a.n) {
                c17448mz0A = new C17448mz0(null, 0L, null, null, null, null, null, false, null, null, null, false, 4095, null);
                obj = value;
                interfaceC9336Zm4 = interfaceC9336Zm4H;
            } else {
                c17448mz0A = c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : aVar, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false);
                obj = value;
                interfaceC9336Zm4 = interfaceC9336Zm4H;
            }
            if (interfaceC9336Zm4.f(obj, c17448mz0A)) {
                return;
            }
            aVar2 = aVar;
            interfaceC9336Zm4H = interfaceC9336Zm4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x0(C4627Fy0 c4627Fy0, MeetStruct$GroupCall meetStruct$GroupCall, boolean z2, boolean z3) {
        AbstractC13042fc3.i(c4627Fy0, "this$0");
        AbstractC13042fc3.i(meetStruct$GroupCall, "$call");
        if (z2) {
            C19406qI3.a("CallRepository", "groupCallEnded => callExist: " + z2 + " isCallRunning: " + z3, new Object[0]);
            if (z3) {
                c4627Fy0.d(EnumC12029dv0.d, meetStruct$GroupCall.getDuration().getValue());
            }
        }
        return C19938rB7.a;
    }

    private final void y0(InterfaceC9449Zz0.a aVar) {
        if (((C17448mz0) C18039nz0.a.d().getValue()).c() == aVar.a()) {
            if (C8386Vt0.a.f5()) {
                this.o.f();
            }
            this.A.c(Boolean.TRUE);
            this.B = Long.valueOf(aVar.b());
        }
    }

    private final AbstractC7031Pz0 y1(AbstractC7031Pz0 abstractC7031Pz0) {
        if (AbstractC13042fc3.d(abstractC7031Pz0, AbstractC7031Pz0.c.b)) {
            return new AbstractC7031Pz0.b(AbstractC12895fM2.a.a);
        }
        if (AbstractC13042fc3.d(abstractC7031Pz0, AbstractC7031Pz0.e.b)) {
            return new AbstractC7031Pz0.d(AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.k) {
            return new AbstractC7031Pz0.h(AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.i) {
            return new AbstractC7031Pz0.j(AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.b) {
            return new AbstractC7031Pz0.b(AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.d) {
            return new AbstractC7031Pz0.d(AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.h) {
            return new AbstractC7031Pz0.h(AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.j) {
            return new AbstractC7031Pz0.j(AbstractC12895fM2.a.a);
        }
        if (abstractC7031Pz0 instanceof AbstractC7031Pz0.f) {
            return new AbstractC7031Pz0.f(AbstractC12895fM2.a.a, false, null, null, null, null, 62, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void z0(final C9669aM2 c9669aM2) {
        final boolean z2 = c9669aM2.a().getInitiatorUserId() == AbstractC5969Lp4.f();
        C10263bM2 c10263bM2 = C10263bM2.a;
        E84 e84G = AbstractC5969Lp4.d().o2().G();
        AbstractC13042fc3.h(e84G, "getMessagesModule(...)");
        c10263bM2.e(e84G, c9669aM2.a(), new InterfaceC14603iB2() { // from class: ir.nasim.Cy0
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C4627Fy0.A0(z2, this, c9669aM2, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            }
        });
    }

    public final Object A1(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object value;
        C17448mz0 c17448mz0;
        Object value2;
        List listP1;
        Object value3;
        C17448mz0 c17448mz02;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new M26(false, false, false, false, String.valueOf(((C11458d25) it.next()).getPeerId()), null, N26.b, null, null, false, null, null, null, null, null, 32687, null));
            }
            InterfaceC9336Zm4 interfaceC9336Zm4G = c17448mz0.g();
            do {
                value2 = interfaceC9336Zm4G.getValue();
                listP1 = AbstractC15401jX0.p1((List) value2);
                listP1.addAll(arrayList);
            } while (!interfaceC9336Zm4G.f(value2, listP1));
        } while (!interfaceC9336Zm4H.f(value, c17448mz0));
        C18039nz0 c18039nz0 = C18039nz0.a;
        AbstractC7031Pz0 abstractC7031Pz0F = ((C17448mz0) c18039nz0.d().getValue()).f();
        if (abstractC7031Pz0F == null) {
            throw new IllegalStateException("");
        }
        InterfaceC9336Zm4 interfaceC9336Zm4H2 = c18039nz0.h();
        do {
            value3 = interfaceC9336Zm4H2.getValue();
            c17448mz02 = (C17448mz0) value3;
        } while (!interfaceC9336Zm4H2.f(value3, c17448mz02.a((4091 & 1) != 0 ? c17448mz02.a : null, (4091 & 2) != 0 ? c17448mz02.b : 0L, (4091 & 4) != 0 ? c17448mz02.c : y1(abstractC7031Pz0F), (4091 & 8) != 0 ? c17448mz02.d : null, (4091 & 16) != 0 ? c17448mz02.e : null, (4091 & 32) != 0 ? c17448mz02.f : null, (4091 & 64) != 0 ? c17448mz02.g : null, (4091 & 128) != 0 ? c17448mz02.h : false, (4091 & 256) != 0 ? c17448mz02.i : null, (4091 & 512) != 0 ? c17448mz02.j : null, (4091 & 1024) != 0 ? c17448mz02.k : null, (4091 & 2048) != 0 ? c17448mz02.l : false)));
        return C19938rB7.a;
    }

    public final void C0(List list) {
        AbstractC13042fc3.i(list, "memberIds");
        C10263bM2.a.g(((C17448mz0) C18039nz0.a.d().getValue()).c(), list);
    }

    public final void F0(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        C19406qI3.a("CallRepository", "handleNotificationIntent " + intent.getAction(), new Object[0]);
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1277590163) {
                if (iHashCode != -856671737) {
                    if (iHashCode == 1725037378 && action.equals("end_call")) {
                        H0();
                        return;
                    }
                } else if (action.equals("decline_call")) {
                    R(true, intent.getLongExtra("call_id", -1L));
                    return;
                }
            } else if (action.equals("ACTION_DECLINE_GROUP")) {
                R(true, intent.getLongExtra("call_id", -1L));
                return;
            }
        }
        C19406qI3.a("CallRepository", "action not supported send to callHelper " + intent.getAction(), new Object[0]);
        C20384rv0.a.N(intent);
    }

    public void I0(boolean z2) {
        if (z2) {
            C10263bM2.a.f(((C17448mz0) C18039nz0.a.h().getValue()).c());
        }
        Intent intentP = P("ACTION_END_GROUP_CALL");
        intentP.putExtra("END_FOR_ALL", z2);
        g1(this, intentP, false, 2, null);
    }

    public void J0() {
        g1(this, P("end_call"), false, 2, null);
    }

    public void K(List list) {
        Object next;
        AbstractC13042fc3.i(list, "onGoingCalls");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof AbstractC17643nJ4.a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        loop1: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AbstractC17643nJ4.a aVar = (AbstractC17643nJ4.a) next;
            List list2 = (List) C10263bM2.a.b().getValue();
            if (list2.isEmpty()) {
                break;
            }
            List list3 = list2;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    if (((AbstractC17643nJ4) it2.next()).a() != aVar.a()) {
                        break loop1;
                    }
                }
            }
        }
        AbstractC17643nJ4.a aVar2 = (AbstractC17643nJ4.a) next;
        if (aVar2 != null) {
            AbstractC10533bm0.d(this.a, null, null, new C4630c(aVar2, null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean K0(C8942Xx0 c8942Xx0) {
        if (!C8386Vt0.a.q6() || c8942Xx0 == null) {
            return false;
        }
        if (c8942Xx0.b() == 0) {
            AbstractC7031Pz0 abstractC7031Pz0F = ((C17448mz0) C18039nz0.a.d().getValue()).f();
            AbstractC7031Pz0.f fVar = abstractC7031Pz0F instanceof AbstractC7031Pz0.f ? (AbstractC7031Pz0.f) abstractC7031Pz0F : null;
            if (fVar != null) {
                return fVar.c();
            }
            return false;
        }
        C14733iO2 c14733iO2 = (C14733iO2) this.f.Y1().n(c8942Xx0.b());
        if (c14733iO2 == null) {
            return false;
        }
        C23104wM2 c23104wM2 = (C23104wM2) c14733iO2.s().b();
        Boolean boolValueOf = c23104wM2 != null ? Boolean.valueOf(c23104wM2.j()) : null;
        C24119y45 c24119y45 = (C24119y45) c14733iO2.z().b();
        Boolean boolValueOf2 = c24119y45 != null ? Boolean.valueOf(c24119y45.r()) : null;
        Object[] objArr = c14733iO2.x() == AbstractC5969Lp4.f();
        Boolean bool = Boolean.TRUE;
        return (AbstractC13042fc3.d(boolValueOf, bool) && AbstractC13042fc3.d(boolValueOf2, bool)) || objArr == true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L0(long r11, java.util.List r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C4627Fy0.u
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.Fy0$u r0 = (ir.nasim.C4627Fy0.u) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$u r0 = new ir.nasim.Fy0$u
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L49
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.b
            ir.nasim.Fy0$v r2 = new ir.nasim.Fy0$v
            r9 = 0
            r4 = r2
            r5 = r13
            r6 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.L0(long, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    public final boolean M0(long j) {
        return ((C17448mz0) C18039nz0.a.d().getValue()).c() == j;
    }

    public final void N() {
        this.B = null;
    }

    public final InterfaceC8327Vm4 N0() {
        return this.A;
    }

    public final void O0(long j, boolean z2, Long l, String str, String str2, Long l2, boolean z3, boolean z4, boolean z5) {
        if (((C17448mz0) C18039nz0.a.d().getValue()).l()) {
            return;
        }
        Intent intentP = P("ACTION_JOIN_GROUP_CALL");
        intentP.putExtras(AbstractC23348wm0.b(AbstractC4616Fw7.a("call_id", Long.valueOf(j)), AbstractC4616Fw7.a("AM_I_INITIATOR_GROUP_CALL", Boolean.valueOf(z2)), AbstractC4616Fw7.a("EXTRA_CALL_INITIATOR_USER_ID", l), AbstractC4616Fw7.a("CALL_LINK", str), AbstractC4616Fw7.a("EXTRA_CALL_TITLE", str2), AbstractC4616Fw7.a("EXTRA_CALL_START_TIME", l2), AbstractC4616Fw7.a("EXTRA_IS_VOICE_MUTED", Boolean.valueOf(z3)), AbstractC4616Fw7.a("EXTRA_IS_VIDEO_MUTED", Boolean.valueOf(z4)), AbstractC4616Fw7.a("EXTRA_IS_VIDEO_FRONT_CAMERA", Boolean.valueOf(z5))));
        if (l != null) {
            c0(l.longValue(), j);
        }
        r1(this, intentP, false, false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q0(java.lang.String r18, boolean r19, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof ir.nasim.C4627Fy0.w
            if (r2 == 0) goto L18
            r2 = r1
            ir.nasim.Fy0$w r2 = (ir.nasim.C4627Fy0.w) r2
            int r3 = r2.e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.e = r3
        L16:
            r8 = r2
            goto L1e
        L18:
            ir.nasim.Fy0$w r2 = new ir.nasim.Fy0$w
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r8.c
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            int r3 = r8.e
            r9 = 1
            if (r3 == 0) goto L46
            if (r3 != r9) goto L3e
            java.lang.Object r2 = r8.b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r8.a
            ir.nasim.Fy0 r3 = (ir.nasim.C4627Fy0) r3
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.a16 r1 = (ir.nasim.C9475a16) r1
            r1.l()
            r12 = r2
            r10 = r3
            goto L70
        L3e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L46:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.vy0 r3 = r0.j
            ir.nasim.nz0 r1 = ir.nasim.C18039nz0.a
            ir.nasim.bL6 r1 = r1.d()
            java.lang.Object r1 = r1.getValue()
            ir.nasim.mz0 r1 = (ir.nasim.C17448mz0) r1
            long r4 = r1.c()
            r8.a = r0
            r1 = r18
            r8.b = r1
            r8.e = r9
            r6 = r18
            r7 = r19
            java.lang.Object r3 = r3.g(r4, r6, r7, r8)
            if (r3 != r2) goto L6e
            return r2
        L6e:
            r10 = r0
            r12 = r1
        L70:
            ir.nasim.Uw0$a r11 = new ir.nasim.Uw0$a
            r1 = 0
            r2 = 0
            r11.<init>(r2, r9, r1)
            ir.nasim.nz0 r1 = ir.nasim.C18039nz0.a
            ir.nasim.bL6 r3 = r1.d()
            java.lang.Object r3 = r3.getValue()
            ir.nasim.mz0 r3 = (ir.nasim.C17448mz0) r3
            long r13 = r3.c()
            ir.nasim.bL6 r3 = r1.d()
            java.lang.Object r3 = r3.getValue()
            ir.nasim.mz0 r3 = (ir.nasim.C17448mz0) r3
            ir.nasim.Xx0 r3 = r3.d()
            if (r3 == 0) goto L9d
            int r3 = r3.b()
            r15 = r3
            goto L9e
        L9d:
            r15 = r2
        L9e:
            ir.nasim.bL6 r1 = r1.d()
            java.lang.Object r1 = r1.getValue()
            ir.nasim.mz0 r1 = (ir.nasim.C17448mz0) r1
            boolean r1 = r1.n()
            if (r1 == 0) goto Lb1
            r16 = r2
            goto Lb4
        Lb1:
            r1 = 2
            r16 = r1
        Lb4:
            r10.e1(r11, r12, r13, r15, r16)
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.Q0(java.lang.String, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R0(java.lang.String r18, java.lang.String r19, boolean r20, ir.nasim.InterfaceC20295rm1 r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r21
            boolean r2 = r1 instanceof ir.nasim.C4627Fy0.x
            if (r2 == 0) goto L18
            r2 = r1
            ir.nasim.Fy0$x r2 = (ir.nasim.C4627Fy0.x) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f = r3
        L16:
            r8 = r2
            goto L1e
        L18:
            ir.nasim.Fy0$x r2 = new ir.nasim.Fy0$x
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r8.d
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            int r3 = r8.f
            r9 = 1
            if (r3 == 0) goto L48
            if (r3 != r9) goto L40
            boolean r2 = r8.c
            java.lang.Object r3 = r8.b
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r8.a
            ir.nasim.Fy0 r4 = (ir.nasim.C4627Fy0) r4
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.a16 r1 = (ir.nasim.C9475a16) r1
            r1.l()
            r12 = r3
            r10 = r4
            goto L77
        L40:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L48:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.vy0 r3 = r0.j
            ir.nasim.nz0 r1 = ir.nasim.C18039nz0.a
            ir.nasim.bL6 r1 = r1.d()
            java.lang.Object r1 = r1.getValue()
            ir.nasim.mz0 r1 = (ir.nasim.C17448mz0) r1
            long r5 = r1.c()
            r8.a = r0
            r1 = r19
            r8.b = r1
            r10 = r20
            r8.c = r10
            r8.f = r9
            r4 = r18
            r7 = r19
            java.lang.Object r3 = r3.h(r4, r5, r7, r8)
            if (r3 != r2) goto L74
            return r2
        L74:
            r12 = r1
            r2 = r10
            r10 = r0
        L77:
            r1 = 0
            r3 = 0
            if (r2 == 0) goto L82
            ir.nasim.Uw0$c r2 = new ir.nasim.Uw0$c
            r2.<init>(r3, r9, r1)
        L80:
            r11 = r2
            goto L88
        L82:
            ir.nasim.Uw0$b r2 = new ir.nasim.Uw0$b
            r2.<init>(r3, r9, r1)
            goto L80
        L88:
            ir.nasim.nz0 r1 = ir.nasim.C18039nz0.a
            ir.nasim.bL6 r2 = r1.d()
            java.lang.Object r2 = r2.getValue()
            ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
            long r13 = r2.c()
            ir.nasim.bL6 r2 = r1.d()
            java.lang.Object r2 = r2.getValue()
            ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
            ir.nasim.Xx0 r2 = r2.d()
            if (r2 == 0) goto Lae
            int r2 = r2.b()
            r15 = r2
            goto Laf
        Lae:
            r15 = r3
        Laf:
            ir.nasim.bL6 r1 = r1.d()
            java.lang.Object r1 = r1.getValue()
            ir.nasim.mz0 r1 = (ir.nasim.C17448mz0) r1
            boolean r1 = r1.n()
            if (r1 == 0) goto Lc2
            r16 = r3
            goto Lc5
        Lc2:
            r1 = 2
            r16 = r1
        Lc5:
            r10.e1(r11, r12, r13, r15, r16)
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.R0(java.lang.String, java.lang.String, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object S0(ir.nasim.EnumC12029dv0 r8, int r9, long r10, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.S0(ir.nasim.dv0, int, long, ir.nasim.rm1):java.lang.Object");
    }

    public final void T() {
        S(this, false, 0L, 2, null);
    }

    public final void U(long j) {
        this.d.H(j, K04.CallDiscardReason_BUSY);
    }

    public void W0() {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.c, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
    }

    public final void Z(List list, String str) {
        AbstractC13042fc3.i(list, ContactEntity.TABLE_NAME);
        if (str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.l.A2(C11458d25.E(((C22613vY) it.next()).d()), str, null, true, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Z0(long r6, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C4627Fy0.B
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Fy0$B r0 = (ir.nasim.C4627Fy0.B) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$B r0 = new ir.nasim.Fy0$B
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.Fy0$C r2 = new ir.nasim.Fy0$C
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.Z0(long, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void a(boolean z2, long j) {
        String str;
        String str2;
        C19406qI3.a("CallRepository", "acceptIncomingCall => is notif " + z2, new Object[0]);
        this.o.g();
        C18039nz0 c18039nz0 = C18039nz0.a;
        if (((C17448mz0) c18039nz0.d().getValue()).c() != j && j != -1) {
            C19406qI3.a("CallRepository", "declineCall => wrong state call id is not valid <" + j + " - " + ((C17448mz0) c18039nz0.d().getValue()).c() + Separators.GREATER_THAN, new Object[0]);
        }
        if (j != -1) {
            C19406qI3.a("CallRepository", "clear with notification call id", new Object[0]);
            q0().cancel((int) j);
        } else {
            q0().cancel((int) ((C17448mz0) c18039nz0.d().getValue()).c());
        }
        if (z2) {
            AbstractC7031Pz0 abstractC7031Pz0F = ((C17448mz0) c18039nz0.d().getValue()).f();
            if (AbstractC13042fc3.d(abstractC7031Pz0F, AbstractC7031Pz0.e.b)) {
                str2 = "answer_voice_call";
            } else if (AbstractC13042fc3.d(abstractC7031Pz0F, AbstractC7031Pz0.c.b)) {
                str2 = "answer_video_call";
            } else {
                str = "ACTION_JOIN_VOICE_CALL";
                if (!(abstractC7031Pz0F instanceof AbstractC7031Pz0.b) && !(abstractC7031Pz0F instanceof AbstractC7031Pz0.d)) {
                    C19406qI3.a("CallRepository", "acceptIncomingCall not Support this call type -> pushId " + j, new Object[0]);
                    return;
                }
                str2 = str;
            }
        } else {
            AbstractC7031Pz0 abstractC7031Pz0F2 = ((C17448mz0) c18039nz0.d().getValue()).f();
            if (AbstractC13042fc3.d(abstractC7031Pz0F2, AbstractC7031Pz0.e.b)) {
                str2 = "accept_voice_from_activity";
            } else if (AbstractC13042fc3.d(abstractC7031Pz0F2, AbstractC7031Pz0.c.b)) {
                str2 = "accept_video_from_activity";
            } else {
                str = "ACTION_JOIN_VOICE_CALL_FROM_ACTIVITY";
                if (!(abstractC7031Pz0F2 instanceof AbstractC7031Pz0.b) && !(abstractC7031Pz0F2 instanceof AbstractC7031Pz0.d)) {
                    C19406qI3.a("CallRepository", "acceptIncomingCall not Support this call type -> pushId " + j, new Object[0]);
                    return;
                }
                str2 = str;
            }
        }
        g1(this, P(str2), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a0(boolean r6, java.lang.Long r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C4627Fy0.C4634g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Fy0$g r0 = (ir.nasim.C4627Fy0.C4634g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$g r0 = new ir.nasim.Fy0$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.Fy0$h r2 = new ir.nasim.Fy0$h
            r4 = 0
            r2.<init>(r6, r7, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.a0(boolean, java.lang.Long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a1(long r6, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C4627Fy0.D
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Fy0$D r0 = (ir.nasim.C4627Fy0.D) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$D r0 = new ir.nasim.Fy0$D
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.Fy0$E r2 = new ir.nasim.Fy0$E
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.a1(long, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void b(List list) {
        AbstractC13042fc3.i(list, "list");
        AbstractC10533bm0.d(this.a, C12366eV1.c(), null, new t(list, this, null), 2, null);
    }

    public final C16966mA b0(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        if (c11458d25.s() == W25.a) {
            InterfaceC8844Xo3 interfaceC8844Xo3D = this.e.p0().d(c11458d25.getPeerId());
            AbstractC13042fc3.h(interfaceC8844Xo3D, "getValueBlocking(...)");
            C17637nI7 c17637nI7 = (C17637nI7) interfaceC8844Xo3D;
            if (c17637nI7.getExPeerType() == null) {
                return null;
            }
            ExPeerType exPeerType = c17637nI7.getExPeerType();
            AbstractC13042fc3.f(exPeerType);
            return new C16966mA(exPeerType.toApi(), c11458d25.getPeerId(), c17637nI7.getAccessHash());
        }
        if (c11458d25.s() != W25.b) {
            return null;
        }
        InterfaceC8844Xo3 interfaceC8844Xo3D2 = this.f.X1().d(c11458d25.getPeerId());
        AbstractC13042fc3.h(interfaceC8844Xo3D2, "getValueBlocking(...)");
        C14697iL2 c14697iL2 = (C14697iL2) interfaceC8844Xo3D2;
        if (c14697iL2.getExPeerType() == null) {
            return null;
        }
        ExPeerType exPeerType2 = c14697iL2.getExPeerType();
        AbstractC13042fc3.f(exPeerType2);
        return new C16966mA(exPeerType2.toApi(), c11458d25.getPeerId(), c14697iL2.getAccessHash());
    }

    public final C6517Nv5 c0(long j, final long j2) {
        return this.e.p0().a(j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.wy0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4627Fy0.e0(this.a, j2, (C17637nI7) obj);
            }
        });
    }

    public final void c1(InterfaceC22848vv0 interfaceC22848vv0, long j) {
        AbstractC13042fc3.i(interfaceC22848vv0, "eventType");
        this.k.d("call_link_click", AbstractC20051rO3.p(AbstractC4616Fw7.a("action_type", Integer.valueOf(interfaceC22848vv0.a())), AbstractC4616Fw7.a("call_id", Long.valueOf(j))));
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void d(EnumC12029dv0 enumC12029dv0, int i) {
        C18039nz0 c18039nz0 = C18039nz0.a;
        if (((C17448mz0) c18039nz0.d().getValue()).e() == C17448mz0.a.o) {
            C19406qI3.a("CallRepository", "update onCallDiscarded ignored because not in call " + ((C17448mz0) c18039nz0.d().getValue()).e(), new Object[0]);
            return;
        }
        this.o.g();
        C19406qI3.a("CallRepository", "discard notification with normal arguemnt id " + ((C17448mz0) c18039nz0.d().getValue()).c() + " | " + ((int) ((C17448mz0) c18039nz0.d().getValue()).c()), new Object[0]);
        q0().cancel((int) ((C17448mz0) c18039nz0.d().getValue()).c());
        C19406qI3.a("CallRepository", "onCallDiscarded reason: " + enumC12029dv0 + ", duration: " + i, new Object[0]);
        int i2 = enumC12029dv0 == null ? -1 : C4629b.a[enumC12029dv0.ordinal()];
        C17448mz0.a aVar = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? C17448mz0.a.n : C17448mz0.a.l : i <= 0 ? C17448mz0.a.j : C17448mz0.a.n : C17448mz0.a.m : C17448mz0.a.k;
        C19406qI3.a("CallRepository", "onCallDiscarded callState: " + aVar, new Object[0]);
        V();
        w0(aVar);
        if (M()) {
            w0(C17448mz0.a.n);
        } else {
            w0(C17448mz0.a.n);
        }
    }

    public final void d1(boolean z2) {
        this.k.d("create_call_link_tryagain", AbstractC20051rO3.p(AbstractC4616Fw7.a("is_successful", Boolean.valueOf(z2))));
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void e() {
        this.o.g();
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void f() {
        C10263bM2 c10263bM2 = C10263bM2.a;
        C18039nz0 c18039nz0 = C18039nz0.a;
        long jC = ((C17448mz0) c18039nz0.d().getValue()).c();
        Integer numValueOf = Integer.valueOf(AbstractC5969Lp4.f());
        C8942Xx0 c8942Xx0D = ((C17448mz0) c18039nz0.h().getValue()).d();
        c10263bM2.g(jC, AbstractC10360bX0.p(numValueOf, Integer.valueOf(c8942Xx0D != null ? c8942Xx0D.b() : 0)));
    }

    public final String f0(long j) {
        XV4 xv4 = this.v;
        if (xv4 == null) {
            return null;
        }
        if (((Number) xv4.f()).longValue() != j) {
            xv4 = null;
        }
        if (xv4 != null) {
            return (String) xv4.e();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void g(InterfaceC9449Zz0 interfaceC9449Zz0) {
        AbstractC13042fc3.i(interfaceC9449Zz0, "callUpdate");
        if (interfaceC9449Zz0 instanceof C9669aM2) {
            z0((C9669aM2) interfaceC9449Zz0);
        } else if (interfaceC9449Zz0 instanceof C6826Pd3) {
            B0((C6826Pd3) interfaceC9449Zz0);
        } else if (interfaceC9449Zz0 instanceof InterfaceC9449Zz0.a) {
            y0((InterfaceC9449Zz0.a) interfaceC9449Zz0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g0(java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C4627Fy0.C4636i
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Fy0$i r0 = (ir.nasim.C4627Fy0.C4636i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$i r0 = new ir.nasim.Fy0$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.b
            ir.nasim.Fy0$j r2 = new ir.nasim.Fy0$j
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.g0(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void h(final int i, final MeetStruct$Call meetStruct$Call, final boolean z2) {
        AbstractC13042fc3.i(meetStruct$Call, "protoCall");
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.Ay0
            @Override // java.lang.Runnable
            public final void run() {
                C4627Fy0.s1(this.a, meetStruct$Call, i, z2);
            }
        });
    }

    public final void h1() {
        this.k.b("create_call_link");
    }

    @Override // ir.nasim.InterfaceC5110Hy0
    public void i(final MeetStruct$GroupCall meetStruct$GroupCall) {
        AbstractC13042fc3.i(meetStruct$GroupCall, "call");
        C10263bM2 c10263bM2 = C10263bM2.a;
        E84 e84G = AbstractC5969Lp4.d().o2().G();
        AbstractC13042fc3.h(e84G, "getMessagesModule(...)");
        c10263bM2.d(e84G, meetStruct$GroupCall, new InterfaceC14603iB2() { // from class: ir.nasim.Ey0
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C4627Fy0.x0(this.a, meetStruct$GroupCall, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            }
        });
    }

    public final void j1(InterfaceC6775Ox6 interfaceC6775Ox6) {
        AbstractC13042fc3.i(interfaceC6775Ox6, "eventType");
        this.k.d("share_call_link", AbstractC20051rO3.p(AbstractC4616Fw7.a("action_type", Integer.valueOf(interfaceC6775Ox6.a()))));
    }

    public InterfaceC8327Vm4 k0() {
        return this.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k1(long r11, java.lang.String r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C4627Fy0.G
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.Fy0$G r0 = (ir.nasim.C4627Fy0.G) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$G r0 = new ir.nasim.Fy0$G
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L49
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.b
            ir.nasim.Fy0$H r2 = new ir.nasim.Fy0$H
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r8 = r13
            r4.<init>(r6, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.k1(long, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final int l0() {
        return this.z;
    }

    public final void l1(int i) {
        this.z = i;
    }

    public final String m0(String str, Long l, String str2, String str3) {
        AbstractC13042fc3.i(str3, "callLink");
        Context context = this.c;
        int i = AbstractC12217eE5.nasim_call_link_share_template_title;
        if (!(true ^ (str == null || AbstractC20762sZ6.n0(str)))) {
            str = null;
        }
        if (str == null) {
            str = this.c.getString(AbstractC12217eE5.nasim_call_link_share_template_default_title);
            AbstractC13042fc3.h(str, "getString(...)");
        }
        String string = context.getString(i, str);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = l != null ? this.c.getString(AbstractC12217eE5.nasim_call_link_share_template_creation_date, C14593iA1.a.n(l.longValue())) : null;
        String string3 = str2 != null ? this.c.getString(AbstractC12217eE5.nasim_call_link_share_template_initiator_name, str2) : null;
        String string4 = this.c.getString(AbstractC12217eE5.nasim_call_link_share_template_link);
        AbstractC13042fc3.h(string4, "getString(...)");
        return AbstractC15401jX0.A0(AbstractC10360bX0.r(string, string2, string3, string4, str3), Separators.RETURN, null, null, 0, null, null, 62, null);
    }

    public void m1(List list) {
        AbstractC13042fc3.i(list, "list");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C22675ve3 c22675ve3 = (C22675ve3) it.next();
            this.w.put(Integer.valueOf(c22675ve3.a()), AbstractC10533bm0.d(this.a, null, null, new I(c22675ve3, this, null), 3, null));
        }
        Map map = this.w;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((Number) ((Map.Entry) it2.next()).getKey()).intValue()));
        }
        C19406qI3.a("CallRepository", "setTimerForInvitedUsers " + arrayList, new Object[0]);
    }

    public final void p1(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        Intent intentP = P("ACTION_START_SHARE_SCREEN");
        intentP.putExtra("EXTRA_SHARE_SCREEN_INTENT", intent);
        g1(this, intentP, false, 2, null);
    }

    public final NotificationManager q0() {
        return (NotificationManager) this.t.getValue();
    }

    public InterfaceC4557Fq2 s0(InterfaceC20315ro1 interfaceC20315ro1, final String str) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(str, "search");
        return new q(new C12960fT4(new MT4(15, 0, false, 15, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.xy0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4627Fy0.t0(this.a, str);
            }
        }, 2, null).a());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t1(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C4627Fy0.K
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Fy0$K r0 = (ir.nasim.C4627Fy0.K) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fy0$K r0 = new ir.nasim.Fy0$K
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.b
            ir.nasim.Fy0$L r2 = new ir.nasim.Fy0$L
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.t1(ir.nasim.rm1):java.lang.Object");
    }

    public InterfaceC8327Vm4 u0() {
        return this.y;
    }

    public final void u1() {
        AbstractC10533bm0.d(this.a, null, null, new M(null), 3, null);
    }

    public final Long v0() {
        return this.B;
    }

    public final void v1() {
        g1(this, P("ACTION_STOP_SHARE_SCREEN"), false, 2, null);
    }

    public void w1() {
        AbstractC10533bm0.d(this.a, null, null, new N(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object x1(ir.nasim.AbstractC21761u53 r27, ir.nasim.InterfaceC20295rm1 r28) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4627Fy0.x1(ir.nasim.u53, ir.nasim.rm1):java.lang.Object");
    }

    public void z1(int i) {
        Object value;
        C17448mz0 c17448mz0;
        Object value2;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4G = c17448mz0.g();
            do {
                value2 = interfaceC9336Zm4G.getValue();
                arrayList = new ArrayList();
                for (Object obj : (List) value2) {
                    if (Integer.parseInt(((M26) obj).j()) != i) {
                        arrayList.add(obj);
                    }
                }
            } while (!interfaceC9336Zm4G.f(value2, arrayList));
            Y0(i);
        } while (!interfaceC9336Zm4H.f(value, c17448mz0));
    }
}
