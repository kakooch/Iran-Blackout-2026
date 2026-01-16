package ir.nasim;

import ai.bale.proto.PremiumOuterClass$ResponseIsPremium;
import ai.bale.proto.PremiumStruct$UserPremiumStatus;
import android.content.Context;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12129e53;
import ir.nasim.AbstractC18874pP;
import ir.nasim.AbstractC20029rM;
import ir.nasim.AbstractC24832zH1;
import ir.nasim.AbstractC9512a53;
import ir.nasim.DD;
import ir.nasim.InterfaceC13521gN1;
import ir.nasim.InterfaceC13548gQ1;
import ir.nasim.InterfaceC14139hQ1;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.RP1;
import ir.nasim.VF6;
import ir.nasim.XB4;
import ir.nasim.XI3;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.dialoglist.data.model.DialogDTO;
import ir.nasim.features.eventbar.data.model.EventBarData;
import ir.nasim.features.root.AbstractC13089g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class XB4 extends VW7 implements JN1 {
    private final InterfaceC9336Zm4 A;
    private final InterfaceC10258bL6 A0;
    private final InterfaceC10258bL6 B;
    private final InterfaceC10258bL6 B0;
    private final InterfaceC10258bL6 C0;
    private AbstractC9512a53 D;
    private final InterfaceC9336Zm4 D0;
    private final InterfaceC10258bL6 E0;
    private final InterfaceC9336Zm4 F0;
    private final InterfaceC9336Zm4 G;
    private final InterfaceC9336Zm4 G0;
    private final InterfaceC10258bL6 H;
    private final InterfaceC10258bL6 H0;
    private final InterfaceC9102Ym4 I0;
    private final List J;
    private final InterfaceC9664aL6 J0;
    private final InterfaceC10258bL6 K0;
    private final InterfaceC9336Zm4 L0;
    private final InterfaceC10258bL6 M0;
    private final InterfaceC4557Fq2 N0;
    private final InterfaceC9336Zm4 O0;
    private final InterfaceC10258bL6 P0;
    private final InterfaceC9336Zm4 Q0;
    private final InterfaceC9336Zm4 R0;
    private final InterfaceC10258bL6 S0;
    private final InterfaceC8327Vm4 T0;
    private final InterfaceC10040ay6 U0;
    private final InterfaceC10258bL6 V0;
    private final InterfaceC12321eQ1 W0;
    private final InterfaceC10258bL6 Y;
    private final InterfaceC10258bL6 Z;
    private final GO1 b;
    private final InterfaceC6828Pd5 c;
    private final int d;
    private final SettingsModule e;
    private final C15250jG2 f;
    private final InterfaceC20667sP1 g;
    private final C12903fN1 h;
    private final KM2 i;
    private final C18804pH1 j;
    private final E84 k;
    private final C8054Ui1 l;
    private final AbstractC13778go1 m;
    private final InterfaceC24010xt2 n;
    private final InterfaceC16501lO o;
    private final TP1 p;
    private final C12720f53 q;
    private final FD7 r;
    private final InterfaceC5943Lm5 s;
    private final OK7 t;
    private final InterfaceC8327Vm4 u;
    private final InterfaceC9173Yu3 v;
    private final InterfaceC20315ro1 w;
    private final InterfaceC9173Yu3 x;
    private XI3 y;
    private final InterfaceC9336Zm4 z;
    private final InterfaceC9336Zm4 z0;

    static final class A extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Map.Entry d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        A(Map.Entry entry, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = entry;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new A(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws NumberFormatException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                XB4 xb4 = XB4.this;
                int i2 = Integer.parseInt((String) this.d.getKey());
                Iterable iterable = (Iterable) this.d.getValue();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.e(Long.parseLong((String) it.next())));
                }
                this.b = 1;
                if (xb4.l3(i2, arrayList, this) == objE) {
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
            return ((A) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Map.Entry d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(Map.Entry entry, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = entry;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new B(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws NumberFormatException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                XB4 xb4 = XB4.this;
                int i2 = Integer.parseInt((String) this.d.getKey());
                Iterable iterable = (Iterable) this.d.getValue();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.e(Long.parseLong((String) it.next())));
                }
                this.b = 1;
                if (xb4.m3(i2, arrayList, this) == objE) {
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

    static final class C extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        C(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return XB4.this.l3(0, null, this);
        }
    }

    static final class D extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        D(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return XB4.this.m3(0, null, this);
        }
    }

    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new E(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20667sP1 interfaceC20667sP1 = XB4.this.g;
                List list = this.d;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.e(((DialogDTO) it.next()).getPeerUniqueId()));
                }
                this.b = 1;
                if (interfaceC20667sP1.m(arrayList, this) == objE) {
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
            return ((E) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class F implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.XB4$F$a$a, reason: collision with other inner class name */
            public static final class C0744a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0744a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.XB4.F.a.C0744a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.XB4$F$a$a r0 = (ir.nasim.XB4.F.a.C0744a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.XB4$F$a$a r0 = new ir.nasim.XB4$F$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    boolean r2 = r5 instanceof ir.nasim.C17019mF7
                    if (r2 == 0) goto L43
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.F.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public F(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class G implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.XB4$G$a$a, reason: collision with other inner class name */
            public static final class C0745a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0745a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.XB4.G.a.C0745a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.XB4$G$a$a r0 = (ir.nasim.XB4.G.a.C0745a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.XB4$G$a$a r0 = new ir.nasim.XB4$G$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L32
                    if (r2 != r3) goto L2a
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto Lbc
                L2a:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L32:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    ir.nasim.g43 r8 = (ir.nasim.InterfaceC13346g43) r8
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r8 = r8.iterator()
                L42:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L82
                    java.lang.Object r4 = r8.next()
                    ir.nasim.gN1 r4 = (ir.nasim.InterfaceC13521gN1) r4
                    boolean r5 = r4 instanceof ir.nasim.InterfaceC13521gN1.b
                    if (r5 == 0) goto L60
                    ir.nasim.AJ6 r5 = new ir.nasim.AJ6
                    ir.nasim.gN1$b r4 = (ir.nasim.InterfaceC13521gN1.b) r4
                    int r4 = r4.e()
                    ir.nasim.BJ6 r6 = ir.nasim.BJ6.a
                    r5.<init>(r4, r6)
                    goto L76
                L60:
                    boolean r5 = r4 instanceof ir.nasim.InterfaceC13521gN1.a
                    if (r5 == 0) goto L6d
                    ir.nasim.AJ6 r5 = new ir.nasim.AJ6
                    r4 = -1
                    ir.nasim.BJ6 r6 = ir.nasim.BJ6.b
                    r5.<init>(r4, r6)
                    goto L76
                L6d:
                    ir.nasim.gN1$c r5 = ir.nasim.InterfaceC13521gN1.c.a
                    boolean r4 = ir.nasim.AbstractC13042fc3.d(r4, r5)
                    if (r4 == 0) goto L7c
                    r5 = 0
                L76:
                    if (r5 == 0) goto L42
                    r2.add(r5)
                    goto L42
                L7c:
                    kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
                    r8.<init>()
                    throw r8
                L82:
                    java.util.HashSet r8 = new java.util.HashSet
                    r8.<init>()
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r2 = r2.iterator()
                L90:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto Laf
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    ir.nasim.AJ6 r6 = (ir.nasim.AJ6) r6
                    int r6 = r6.a()
                    java.lang.Integer r6 = ir.nasim.AbstractC6392Nk0.d(r6)
                    boolean r6 = r8.add(r6)
                    if (r6 == 0) goto L90
                    r4.add(r5)
                    goto L90
                Laf:
                    ir.nasim.g43 r8 = ir.nasim.AbstractC7783Te2.d(r4)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto Lbc
                    return r1
                Lbc:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.G.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public G(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class H implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ XB4 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ XB4 b;

            /* renamed from: ir.nasim.XB4$H$a$a, reason: collision with other inner class name */
            public static final class C0746a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0746a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, XB4 xb4) {
                this.a = interfaceC4806Gq2;
                this.b = xb4;
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
                    boolean r0 = r6 instanceof ir.nasim.XB4.H.a.C0746a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.XB4$H$a$a r0 = (ir.nasim.XB4.H.a.C0746a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.XB4$H$a$a r0 = new ir.nasim.XB4$H$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L72
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.lang.Number r5 = (java.lang.Number) r5
                    int r5 = r5.intValue()
                    ir.nasim.XB4 r2 = r4.b
                    ir.nasim.bL6 r2 = r2.A2()
                    java.lang.Object r2 = r2.getValue()
                    ir.nasim.g43 r2 = (ir.nasim.InterfaceC13346g43) r2
                    java.lang.Object r5 = r2.get(r5)
                    ir.nasim.gN1 r5 = (ir.nasim.InterfaceC13521gN1) r5
                    boolean r2 = r5 instanceof ir.nasim.InterfaceC13521gN1.a
                    if (r2 != 0) goto L68
                    ir.nasim.gN1$c r2 = ir.nasim.InterfaceC13521gN1.c.a
                    boolean r2 = ir.nasim.AbstractC13042fc3.d(r5, r2)
                    if (r2 == 0) goto L5b
                    goto L68
                L5b:
                    boolean r2 = r5 instanceof ir.nasim.InterfaceC13521gN1.b
                    if (r2 == 0) goto L62
                    ir.nasim.gN1$b r5 = (ir.nasim.InterfaceC13521gN1.b) r5
                    goto L69
                L62:
                    kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                    r5.<init>()
                    throw r5
                L68:
                    r5 = 0
                L69:
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L72
                    return r1
                L72:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.H.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public H(InterfaceC4557Fq2 interfaceC4557Fq2, XB4 xb4) {
            this.a = interfaceC4557Fq2;
            this.b = xb4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class I implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ XB4 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ XB4 b;

            /* renamed from: ir.nasim.XB4$I$a$a, reason: collision with other inner class name */
            public static final class C0747a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0747a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, XB4 xb4) {
                this.a = interfaceC4806Gq2;
                this.b = xb4;
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
                    boolean r0 = r6 instanceof ir.nasim.XB4.I.a.C0747a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.XB4$I$a$a r0 = (ir.nasim.XB4.I.a.C0747a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.XB4$I$a$a r0 = new ir.nasim.XB4$I$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L57
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.lang.Number r5 = (java.lang.Number) r5
                    int r5 = r5.intValue()
                    ir.nasim.XB4 r2 = r4.b
                    ir.nasim.bL6 r2 = r2.A2()
                    java.lang.Object r2 = r2.getValue()
                    ir.nasim.g43 r2 = (ir.nasim.InterfaceC13346g43) r2
                    java.lang.Object r5 = r2.get(r5)
                    if (r5 == 0) goto L57
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L57
                    return r1
                L57:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.I.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public I(InterfaceC4557Fq2 interfaceC4557Fq2, XB4 xb4) {
            this.a = interfaceC4557Fq2;
            this.b = xb4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class J extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        J(int i, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new J(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC13521gN1.b bVar = (InterfaceC13521gN1.b) XB4.this.C0.getValue();
                if (bVar != null && bVar.e() == this.d) {
                    InterfaceC8327Vm4 interfaceC8327Vm4 = XB4.this.u;
                    XV4 xv4 = new XV4(AbstractC6392Nk0.d(this.d), this.e);
                    this.b = 1;
                    if (interfaceC8327Vm4.a(xv4, this) == objE) {
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
            return ((J) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class K extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        K(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                List list = (List) this.d;
                LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list, 10)), 16));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    XV4 xv4A = AbstractC4616Fw7.a(AbstractC6392Nk0.e(((C14755iQ6) it.next()).a().u()), AbstractC6392Nk0.a(!r3.b()));
                    linkedHashMap.put(xv4A.e(), xv4A.f());
                }
                HashMap map = new HashMap(linkedHashMap);
                this.c = null;
                this.b = 1;
                if (interfaceC4806Gq2.a(map, this) == objE) {
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
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            K k = new K(interfaceC20295rm1);
            k.c = interfaceC4806Gq2;
            k.d = list;
            return k.invokeSuspend(C19938rB7.a);
        }
    }

    static final class L extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        L(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            HashMap map = (HashMap) this.c;
            Set setKeySet = ((Map) this.d).keySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(setKeySet, 10)), 16));
            for (Object obj2 : setKeySet) {
                ((Number) obj2).longValue();
                linkedHashMap.put(obj2, EnumC18228oI7.a);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(AbstractC19460qO3.f(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap2.put(entry.getKey(), ((Boolean) entry.getValue()).booleanValue() ? EnumC18228oI7.c : EnumC18228oI7.d);
            }
            return XB4.this.O1(linkedHashMap, linkedHashMap2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(HashMap map, Map map2, InterfaceC20295rm1 interfaceC20295rm1) {
            L l = XB4.this.new L(interfaceC20295rm1);
            l.c = map;
            l.d = map2;
            return l.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$a, reason: case insensitive filesystem */
    static final class C8702a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.XB4$a$a, reason: collision with other inner class name */
        static final class C0748a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ XB4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0748a(XB4 xb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = xb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0748a c0748a = new C0748a(this.d, interfaceC20295rm1);
                c0748a.c = obj;
                return c0748a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.b.d((List) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0748a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C8702a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8702a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2J = XB4.this.n.j(10);
                C0748a c0748a = new C0748a(XB4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2J, c0748a, this) == objE) {
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
            return ((C8702a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$b, reason: case insensitive filesystem */
    public /* synthetic */ class C8703b {
        public static final /* synthetic */ F92 a = G92.a(EnumC7296Rc4.values());
    }

    /* renamed from: ir.nasim.XB4$c, reason: case insensitive filesystem */
    public /* synthetic */ class C8704c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[AbstractC13089g.b.values().length];
            try {
                iArr2[AbstractC13089g.b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AbstractC13089g.b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AbstractC13089g.b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC21241tM.values().length];
            try {
                iArr3[EnumC21241tM.d.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[EnumC21241tM.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[EnumC21241tM.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[EnumC21241tM.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            c = iArr3;
        }
    }

    /* renamed from: ir.nasim.XB4$d, reason: case insensitive filesystem */
    static final class C8705d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Integer d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8705d(Integer num, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = num;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8705d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objQ;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Collection<DialogDTO> collectionValues = ((Map) XB4.this.u2().getValue()).values();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionValues, 10));
                for (DialogDTO dialogDTO : collectionValues) {
                    arrayList.add(new ExPeer(dialogDTO.getExPeerType(), C11458d25.r(dialogDTO.getPeerUniqueId()).getPeerId()));
                }
                Set setR1 = AbstractC15401jX0.r1(arrayList);
                InterfaceC24010xt2 interfaceC24010xt2 = XB4.this.n;
                int iIntValue = this.d.intValue();
                String str = this.e;
                List listM1 = AbstractC15401jX0.m1(setR1);
                List listM = AbstractC10360bX0.m();
                this.b = 1;
                objQ = interfaceC24010xt2.q(iIntValue, str, listM1, listM, this);
                if (objQ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objQ = ((C9475a16) obj).l();
            }
            XB4 xb4 = XB4.this;
            if (C9475a16.j(objQ)) {
                xb4.x3(false);
                xb4.N1();
            }
            XB4 xb42 = XB4.this;
            Throwable thE = C9475a16.e(objQ);
            if (thE != null) {
                xb42.X1(thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8705d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$e, reason: case insensitive filesystem */
    static final class C8706e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C8706e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8706e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            XB4.this.k3();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8706e) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$f, reason: case insensitive filesystem */
    public static final class C8707f implements InterfaceC12321eQ1 {
        private final SA2 a;
        private final SA2 b;
        private final SA2 c;
        private final UA2 d;
        private final UA2 e;
        private final SA2 f;
        private final SA2 g;
        private final SA2 h;
        private final SA2 i;
        private final UA2 j;
        private final SA2 k;
        private final UA2 l;

        /* renamed from: ir.nasim.XB4$f$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;
            public static final /* synthetic */ int[] b;

            static {
                int[] iArr = new int[EnumC7540Sd5.values().length];
                try {
                    iArr[EnumC7540Sd5.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC7540Sd5.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
                int[] iArr2 = new int[EnumC18820pJ.values().length];
                try {
                    iArr2[EnumC18820pJ.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[EnumC18820pJ.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                b = iArr2;
            }
        }

        C8707f(final XB4 xb4) {
            this.a = new SA2() { // from class: ir.nasim.YB4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.A(xb4);
                }
            };
            this.b = new SA2() { // from class: ir.nasim.dC4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.C(xb4);
                }
            };
            this.c = new SA2() { // from class: ir.nasim.eC4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.H(xb4);
                }
            };
            this.d = new UA2() { // from class: ir.nasim.fC4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return XB4.C8707f.F(xb4, (EnumC7540Sd5) obj);
                }
            };
            this.e = new UA2() { // from class: ir.nasim.gC4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return XB4.C8707f.E(xb4, (EnumC19108pn4) obj);
                }
            };
            this.f = new SA2() { // from class: ir.nasim.hC4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.B(xb4);
                }
            };
            this.g = new SA2() { // from class: ir.nasim.iC4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.x(xb4);
                }
            };
            this.h = new SA2() { // from class: ir.nasim.jC4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.D(xb4);
                }
            };
            this.i = new SA2() { // from class: ir.nasim.ZB4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.I(xb4);
                }
            };
            this.j = new UA2() { // from class: ir.nasim.aC4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return XB4.C8707f.z(xb4, (EnumC18820pJ) obj);
                }
            };
            this.k = new SA2() { // from class: ir.nasim.bC4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return XB4.C8707f.y(xb4);
                }
            };
            this.l = new UA2() { // from class: ir.nasim.cC4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return XB4.C8707f.G(xb4, (Context) obj);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            if (((Number) xb4.v2().getValue()).intValue() == EnumC11273cj7.a.ordinal()) {
                xb4.T0.c(EnumC3635Br7.b);
            } else {
                xb4.M1();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 B(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            xb4.e3();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 C(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            xb4.q3(true);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            xb4.q3(false);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 E(XB4 xb4, EnumC19108pn4 enumC19108pn4) {
            AbstractC13042fc3.i(xb4, "this$0");
            AbstractC13042fc3.i(enumC19108pn4, "muteState");
            Map map = (Map) xb4.u2().getValue();
            ArrayList arrayList = new ArrayList(map.size());
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((DialogDTO) ((Map.Entry) it.next()).getValue()).getPeerUniqueId()));
            }
            xb4.L1(arrayList, enumC19108pn4 != EnumC19108pn4.c);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 F(XB4 xb4, EnumC7540Sd5 enumC7540Sd5) {
            AbstractC13042fc3.i(xb4, "this$0");
            AbstractC13042fc3.i(enumC7540Sd5, "pinState");
            int i = a.a[enumC7540Sd5.ordinal()];
            if (i == 1) {
                xb4.g3();
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                xb4.h3();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 G(XB4 xb4, Context context) throws NumberFormatException {
            AbstractC13042fc3.i(xb4, "this$0");
            AbstractC13042fc3.i(context, "it");
            xb4.T1(context);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 H(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            if (((Number) xb4.v2().getValue()).intValue() == EnumC11273cj7.a.ordinal()) {
                xb4.T0.c(EnumC3635Br7.a);
            } else {
                xb4.z3();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 I(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            xb4.F2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            xb4.E2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(XB4 xb4) {
            AbstractC13042fc3.i(xb4, "this$0");
            xb4.x3(true);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(XB4 xb4, EnumC18820pJ enumC18820pJ) {
            AbstractC13042fc3.i(xb4, "this$0");
            AbstractC13042fc3.i(enumC18820pJ, "state");
            int i = a.b[enumC18820pJ.ordinal()];
            if (i == 1) {
                xb4.H1();
                if (!xb4.e.u0()) {
                    xb4.e.e6(true);
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                xb4.S1(11, "");
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 a() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 b() {
            return this.k;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 c() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 d() {
            return this.l;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 e() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 f() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 g() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 h() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 i() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 j() {
            return this.j;
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 k() {
            return this.g;
        }
    }

    /* renamed from: ir.nasim.XB4$g, reason: case insensitive filesystem */
    static final class C8708g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        int c;

        C8708g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8708g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objQ;
            int i;
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i2 = this.c;
            if (i2 == 0) {
                AbstractC10685c16.b(obj);
                Collection<DialogDTO> collectionValues = ((Map) XB4.this.u2().getValue()).values();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionValues, 10));
                for (DialogDTO dialogDTO : collectionValues) {
                    arrayList.add(new ExPeer(dialogDTO.getExPeerType(), C11458d25.r(dialogDTO.getPeerUniqueId()).getPeerId()));
                }
                Set setR1 = AbstractC15401jX0.r1(arrayList);
                int size = setR1.size();
                InterfaceC24010xt2 interfaceC24010xt2 = XB4.this.n;
                List listM1 = AbstractC15401jX0.m1(setR1);
                List listM = AbstractC10360bX0.m();
                this.b = size;
                this.c = 1;
                objQ = interfaceC24010xt2.q(11, "", listM1, listM, this);
                if (objQ == objE) {
                    return objE;
                }
                i = size;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.b;
                AbstractC10685c16.b(obj);
                objQ = ((C9475a16) obj).l();
            }
            XB4 xb4 = XB4.this;
            if (C9475a16.j(objQ)) {
                if (i == 1) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = xb4.R0;
                    do {
                        value2 = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value2, VF6.f.b));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = xb4.R0;
                    do {
                        value = interfaceC9336Zm42.getValue();
                    } while (!interfaceC9336Zm42.f(value, VF6.b.b));
                }
                xb4.N1();
            }
            XB4 xb42 = XB4.this;
            Throwable thE = C9475a16.e(objQ);
            if (thE != null) {
                xb42.X1(thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8708g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$h, reason: case insensitive filesystem */
    static final class C8709h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8709h(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8709h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5U = XB4.this.t.U(this.d);
                this.b = 1;
                if (AbstractC6756Ov5.d(c6517Nv5U, null, this, 1, null) == objE) {
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
            return ((C8709h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$i, reason: case insensitive filesystem */
    static final class C8710i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8710i(List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8710i(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TP1 tp1 = XB4.this.p;
                RP1.i iVar = new RP1.i(AbstractC15401jX0.r1(this.d), this.e);
                this.b = 1;
                if (tp1.e(iVar, this) == objE) {
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
            return ((C8710i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$j, reason: case insensitive filesystem */
    static final class C8711j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 c;
        final /* synthetic */ XB4 d;
        final /* synthetic */ ExPeerType e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8711j(C11458d25 c11458d25, XB4 xb4, ExPeerType exPeerType, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11458d25;
            this.d = xb4;
            this.e = exPeerType;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C8711j(this.c, this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                ir.nasim.AbstractC10685c16.b(r5)
                ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
                java.lang.Object r5 = r5.l()
                goto La7
            L19:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L21:
                ir.nasim.AbstractC10685c16.b(r5)
                ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
                java.lang.Object r5 = r5.l()
                goto L4b
            L2b:
                ir.nasim.AbstractC10685c16.b(r5)
                ir.nasim.d25 r5 = r4.c
                boolean r5 = r5.z()
                if (r5 == 0) goto L8c
                ir.nasim.XB4 r5 = r4.d
                ir.nasim.pH1 r5 = ir.nasim.XB4.Z0(r5)
                ir.nasim.d25 r1 = r4.c
                int r1 = r1.getPeerId()
                r4.b = r3
                java.lang.Object r5 = r5.c(r1, r4)
                if (r5 != r0) goto L4b
                return r0
            L4b:
                ir.nasim.core.modules.profile.entity.ExPeerType r0 = r4.e
                ir.nasim.XB4 r1 = r4.d
                java.lang.Throwable r2 = ir.nasim.C9475a16.e(r5)
                if (r2 == 0) goto L78
                ir.nasim.core.modules.profile.entity.ExPeerType r3 = ir.nasim.core.modules.profile.entity.ExPeerType.GROUP
                if (r0 != r3) goto L5c
                ir.nasim.ZN2 r0 = ir.nasim.ZN2.GROUP
                goto L5e
            L5c:
                ir.nasim.ZN2 r0 = ir.nasim.ZN2.CHANNEL
            L5e:
                java.lang.String r0 = ir.nasim.UN2.a(r2, r0)
                ir.nasim.Zm4 r1 = ir.nasim.XB4.o1(r1)
            L66:
                java.lang.Object r2 = r1.getValue()
                r3 = r2
                ir.nasim.VF6 r3 = (ir.nasim.VF6) r3
                ir.nasim.VF6$a r3 = new ir.nasim.VF6$a
                r3.<init>(r0)
                boolean r2 = r1.f(r2, r3)
                if (r2 == 0) goto L66
            L78:
                ir.nasim.XB4 r0 = r4.d
                ir.nasim.d25 r1 = r4.c
                boolean r2 = ir.nasim.C9475a16.j(r5)
                if (r2 == 0) goto Ld5
                ir.nasim.rB7 r5 = (ir.nasim.C19938rB7) r5
                ir.nasim.E84 r5 = ir.nasim.XB4.f1(r0)
                r5.s0(r1)
                goto Ld5
            L8c:
                ir.nasim.XB4 r5 = r4.d
                ir.nasim.E84 r5 = ir.nasim.XB4.f1(r5)
                ir.nasim.d25 r1 = r4.c
                ir.nasim.Nv5 r5 = r5.r0(r1)
                java.lang.String r1 = "deleteChat(...)"
                ir.nasim.AbstractC13042fc3.h(r5, r1)
                r4.b = r2
                r1 = 0
                java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r1, r4, r3, r1)
                if (r5 != r0) goto La7
                return r0
            La7:
                ir.nasim.XB4 r0 = r4.d
                java.lang.Throwable r1 = ir.nasim.C9475a16.e(r5)
                if (r1 == 0) goto Lc2
                ir.nasim.Zm4 r0 = ir.nasim.XB4.o1(r0)
            Lb3:
                java.lang.Object r1 = r0.getValue()
                r2 = r1
                ir.nasim.VF6 r2 = (ir.nasim.VF6) r2
                ir.nasim.VF6$l r2 = ir.nasim.VF6.l.b
                boolean r1 = r0.f(r1, r2)
                if (r1 == 0) goto Lb3
            Lc2:
                ir.nasim.XB4 r0 = r4.d
                ir.nasim.d25 r1 = r4.c
                boolean r2 = ir.nasim.C9475a16.j(r5)
                if (r2 == 0) goto Ld5
                ir.nasim.i18 r5 = (ir.nasim.C14505i18) r5
                ir.nasim.E84 r5 = ir.nasim.XB4.f1(r0)
                r5.s0(r1)
            Ld5:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.C8711j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8711j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$k, reason: case insensitive filesystem */
    static final class C8712k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8712k(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8712k(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objM;
            Object value;
            ArrayList arrayList;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC24010xt2 interfaceC24010xt2 = XB4.this.n;
                int i2 = this.d;
                this.b = 1;
                objM = interfaceC24010xt2.m(i2, this);
                if (objM == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objM = ((C9475a16) obj).l();
            }
            XB4 xb4 = XB4.this;
            Throwable thE = C9475a16.e(objM);
            if (thE != null) {
                xb4.X1(thE);
            }
            XB4 xb42 = XB4.this;
            int i3 = this.d;
            if (C9475a16.j(objM)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = xb42.A;
                do {
                    value = interfaceC9336Zm4.getValue();
                    List<C8870Xr2> list = (List) value;
                    arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    for (C8870Xr2 c8870Xr2 : list) {
                        arrayList.add(C8870Xr2.b(c8870Xr2, 0, null, false, c8870Xr2.c() == i3 ? false : c8870Xr2.e(), false, false, 55, null));
                    }
                } while (!interfaceC9336Zm4.f(value, arrayList));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8712k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.XB4$l, reason: case insensitive filesystem */
    static final class C8713l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8713l(int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new C8713l(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objQ;
            Object value;
            String message;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Collection<DialogDTO> collectionValues = ((Map) XB4.this.u2().getValue()).values();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionValues, 10));
                for (DialogDTO dialogDTO : collectionValues) {
                    arrayList.add(new ExPeer(dialogDTO.getExPeerType(), C11458d25.r(dialogDTO.getPeerUniqueId()).getPeerId()));
                }
                Set setR1 = AbstractC15401jX0.r1(arrayList);
                InterfaceC24010xt2 interfaceC24010xt2 = XB4.this.n;
                int i2 = this.d;
                String str = this.e;
                List listM = AbstractC10360bX0.m();
                List listM1 = AbstractC15401jX0.m1(setR1);
                this.b = 1;
                objQ = interfaceC24010xt2.q(i2, str, listM, listM1, this);
                if (objQ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objQ = ((C9475a16) obj).l();
            }
            XB4 xb4 = XB4.this;
            if (C9475a16.j(objQ)) {
                xb4.N1();
            }
            XB4 xb42 = XB4.this;
            Throwable thE = C9475a16.e(objQ);
            if (thE != null) {
                if (thE instanceof RpcException) {
                    RpcException rpcException = (RpcException) thE;
                    if (AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "TIMEOUT")) {
                        InterfaceC9336Zm4 interfaceC9336Zm4 = xb42.R0;
                        do {
                            value3 = interfaceC9336Zm4.getValue();
                        } while (!interfaceC9336Zm4.f(value3, VF6.k.b));
                    } else {
                        InterfaceC9336Zm4 interfaceC9336Zm42 = xb42.R0;
                        do {
                            value2 = interfaceC9336Zm42.getValue();
                        } while (!interfaceC9336Zm42.f(value2, new VF6.a(rpcException.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String())));
                    }
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm43 = xb42.R0;
                    do {
                        value = interfaceC9336Zm43.getValue();
                        message = thE.getMessage();
                        if (message == null) {
                            message = "EXCEPTION";
                        }
                    } while (!interfaceC9336Zm43.f(value, new VF6.a(message)));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8713l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;

        /* synthetic */ class a extends EB2 implements UA2 {
            a(Object obj) {
                super(1, obj, XB4.class, "onDismissListenerDeleteDialogs", "onDismissListenerDeleteDialogs(Z)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y(((Boolean) obj).booleanValue());
                return C19938rB7.a;
            }

            public final void y(boolean z) {
                ((XB4) this.receiver).b3(z);
            }
        }

        /* synthetic */ class b extends EB2 implements UA2 {
            b(Object obj) {
                super(1, obj, XB4.class, "onDismissListenerDeleteDialogs", "onDismissListenerDeleteDialogs(Z)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y(((Boolean) obj).booleanValue());
                return C19938rB7.a;
            }

            public final void y(boolean z) {
                ((XB4) this.receiver).b3(z);
            }
        }

        /* synthetic */ class c extends EB2 implements UA2 {
            c(Object obj) {
                super(1, obj, XB4.class, "onDismissListenerDeleteDialogs", "onDismissListenerDeleteDialogs(Z)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y(((Boolean) obj).booleanValue());
                return C19938rB7.a;
            }

            public final void y(boolean z) {
                ((XB4) this.receiver).b3(z);
            }
        }

        /* synthetic */ class d extends EB2 implements UA2 {
            d(Object obj) {
                super(1, obj, XB4.class, "onDismissListenerDeleteDialogs", "onDismissListenerDeleteDialogs(Z)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y(((Boolean) obj).booleanValue());
                return C19938rB7.a;
            }

            public final void y(boolean z) {
                ((XB4) this.receiver).b3(z);
            }
        }

        public /* synthetic */ class e {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ExPeerType.values().length];
                try {
                    iArr[ExPeerType.GROUP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ExPeerType.CHANNEL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 G(XB4 xb4) {
            xb4.o3((List) xb4.F0.getValue());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 H(XB4 xb4) {
            xb4.o3((List) xb4.F0.getValue());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 K(XB4 xb4) {
            xb4.o3((List) xb4.F0.getValue());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 L(XB4 xb4) {
            xb4.o3((List) xb4.F0.getValue());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new m(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0072 -> B:14:0x0075). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 686
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC24010xt2 interfaceC24010xt2 = XB4.this.n;
                this.b = 1;
                obj = interfaceC24010xt2.n(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            List list = (List) obj;
            if (list.isEmpty()) {
                XB4.this.v3(true);
            } else {
                InterfaceC9336Zm4 interfaceC9336Zm4 = XB4.this.A;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, list));
                XB4.this.w3(true);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new o(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0159 A[LOOP:1: B:45:0x0153->B:47:0x0159, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0180 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 401
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class p extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;
        /* synthetic */ boolean e;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            return n((EventBarData) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (InterfaceC20295rm1) obj4);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            EventBarData eventBarData = (EventBarData) this.c;
            boolean z = this.d;
            boolean z2 = this.e;
            if (C8386Vt0.J5()) {
                z = eventBarData instanceof EventBarData.Enabled;
            }
            return AbstractC6392Nk0.a(z || z2);
        }

        public final Object n(EventBarData eventBarData, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            p pVar = new p(interfaceC20295rm1);
            pVar.c = eventBarData;
            pVar.d = z;
            pVar.e = z2;
            return pVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = new q(interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(((InterfaceC14139hQ1) this.c) instanceof InterfaceC14139hQ1.b);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14139hQ1 interfaceC14139hQ1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC14139hQ1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class r extends AbstractC22163um1 {
        Object a;
        int b;
        int c;
        /* synthetic */ Object d;
        int f;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return XB4.this.L2(0, 0, null, this);
        }
    }

    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            PremiumStruct$UserPremiumStatus userStatus;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5943Lm5 interfaceC5943Lm5 = XB4.this.s;
                this.b = 1;
                objA = interfaceC5943Lm5.a(this);
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
            if (C9475a16.g(objA)) {
                objA = null;
            }
            PremiumOuterClass$ResponseIsPremium premiumOuterClass$ResponseIsPremium = (PremiumOuterClass$ResponseIsPremium) objA;
            if (premiumOuterClass$ResponseIsPremium == null || (userStatus = premiumOuterClass$ResponseIsPremium.getUserStatus()) == null) {
                return null;
            }
            return AbstractC6392Nk0.e(userStatus.getExpirationTime());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new t(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20667sP1 interfaceC20667sP1 = XB4.this.g;
                List list = this.d;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.e(((DialogDTO) it.next()).getPeerUniqueId()));
                }
                this.b = 1;
                if (interfaceC20667sP1.A(arrayList, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            List<DialogDTO> list2 = this.d;
            XB4 xb4 = XB4.this;
            for (DialogDTO dialogDTO : list2) {
                C18804pH1 c18804pH1 = xb4.j;
                C11458d25 c11458d25R = C11458d25.r(dialogDTO.getPeerUniqueId());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                c18804pH1.b(c11458d25R);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Set d;
        final /* synthetic */ XB4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(Set set, XB4 xb4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = set;
            this.e = xb4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            u uVar = new u(this.d, this.e, interfaceC20295rm1);
            uVar.c = obj;
            return uVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objL;
            String name;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                if (this.d.isEmpty()) {
                    return C19938rB7.a;
                }
                InterfaceC20667sP1 interfaceC20667sP1 = this.e.g;
                Set<DialogDTO> set = this.d;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set, 10));
                for (DialogDTO dialogDTO : set) {
                    arrayList.add(new ExPeer(dialogDTO.getExPeerType(), C11458d25.r(dialogDTO.getPeerUniqueId()).getPeerId()));
                }
                this.c = interfaceC20315ro12;
                this.b = 1;
                Object objG = interfaceC20667sP1.g(arrayList, this);
                if (objG == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
                objL = objG;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                    name = interfaceC20315ro1.getClass().getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = interfaceC20315ro1.getClass().getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                Log.i(name, String.valueOf(thE.getMessage()));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            v vVar = XB4.this.new v(interfaceC20295rm1);
            vVar.c = obj;
            return vVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC9512a53 cVar;
            Object value;
            Object objB;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC12129e53 abstractC12129e53 = (AbstractC12129e53) this.c;
            if (abstractC12129e53 instanceof AbstractC12129e53.a) {
                cVar = AbstractC9512a53.a.a;
            } else if (abstractC12129e53 instanceof AbstractC12129e53.e) {
                cVar = AbstractC9512a53.d.a;
            } else if (AbstractC13042fc3.d(abstractC12129e53, AbstractC12129e53.b.b) || AbstractC13042fc3.d(abstractC12129e53, AbstractC12129e53.f.b) || AbstractC13042fc3.d(abstractC12129e53, AbstractC12129e53.d.b)) {
                cVar = AbstractC9512a53.b.a;
            } else {
                if (!(abstractC12129e53 instanceof AbstractC12129e53.c)) {
                    throw new NoWhenBranchMatchedException();
                }
                cVar = new AbstractC9512a53.c(((AbstractC12129e53.c) abstractC12129e53).f());
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = XB4.this.L0;
            do {
                value = interfaceC9336Zm4.getValue();
                objB = (InterfaceC14139hQ1) value;
                if (objB instanceof InterfaceC14139hQ1.a) {
                    objB = InterfaceC14139hQ1.a.b((InterfaceC14139hQ1.a) objB, null, false, cVar, null, 11, null);
                }
            } while (!interfaceC9336Zm4.f(value, objB));
            XB4.this.D = cVar;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC12129e53 abstractC12129e53, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v) create(abstractC12129e53, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            w wVar = XB4.this.new w(interfaceC20295rm1);
            wVar.c = obj;
            return wVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            EnumC23849xd1 enumC23849xd1 = (EnumC23849xd1) this.c;
            XB4 xb4 = XB4.this;
            xb4.y = xb4.D3(xb4.y, enumC23849xd1);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EnumC23849xd1 enumC23849xd1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w) create(enumC23849xd1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class x implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ XB4 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ XB4 b;

            /* renamed from: ir.nasim.XB4$x$a$a, reason: collision with other inner class name */
            public static final class C0749a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0749a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, XB4 xb4) {
                this.a = interfaceC4806Gq2;
                this.b = xb4;
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
                    boolean r0 = r6 instanceof ir.nasim.XB4.x.a.C0749a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.XB4$x$a$a r0 = (ir.nasim.XB4.x.a.C0749a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.XB4$x$a$a r0 = new ir.nasim.XB4$x$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.util.Map r5 = (java.util.Map) r5
                    ir.nasim.XB4 r2 = r4.b
                    ir.nasim.hQ1 r5 = ir.nasim.XB4.t1(r2, r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.x.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public x(InterfaceC4557Fq2 interfaceC4557Fq2, XB4 xb4) {
            this.a = interfaceC4557Fq2;
            this.b = xb4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        y(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            y yVar = XB4.this.new y(interfaceC20295rm1);
            yVar.c = obj;
            return yVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            XB4.this.L0.setValue((InterfaceC14139hQ1) this.c);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14139hQ1 interfaceC14139hQ1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((y) create(interfaceC14139hQ1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XB4.this.new z(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objP;
            Object value;
            ArrayList arrayList;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                XB4.this.p3(this.d, true);
                InterfaceC24010xt2 interfaceC24010xt2 = XB4.this.n;
                int i2 = this.d;
                this.b = 1;
                objP = interfaceC24010xt2.p(i2, this);
                if (objP == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objP = ((C9475a16) obj).l();
            }
            XB4 xb4 = XB4.this;
            int i3 = this.d;
            Throwable thE = C9475a16.e(objP);
            if (thE != null) {
                xb4.p3(i3, false);
                xb4.X1(thE);
            }
            XB4 xb42 = XB4.this;
            int i4 = this.d;
            if (C9475a16.j(objP)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = xb42.A;
                do {
                    value = interfaceC9336Zm4.getValue();
                    List<C8870Xr2> list = (List) value;
                    arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    for (C8870Xr2 c8870Xr2B : list) {
                        if (c8870Xr2B.c() == i4) {
                            c8870Xr2B = C8870Xr2.b(c8870Xr2B, 0, null, false, true, false, false, 39, null);
                        }
                        arrayList.add(c8870Xr2B);
                    }
                } while (!interfaceC9336Zm4.f(value, arrayList));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((z) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public XB4(C14723iN1 c14723iN1, GO1 go1, InterfaceC6828Pd5 interfaceC6828Pd5, int i, SettingsModule settingsModule, C15250jG2 c15250jG2, InterfaceC20667sP1 interfaceC20667sP1, C12903fN1 c12903fN1, KM2 km2, C4413Fa2 c4413Fa2, C18804pH1 c18804pH1, E84 e84, C8054Ui1 c8054Ui1, AbstractC13778go1 abstractC13778go1, InterfaceC24010xt2 interfaceC24010xt2, C18787pF2 c18787pF2, InterfaceC16501lO interfaceC16501lO, TP1 tp1, C12720f53 c12720f53, FD7 fd7, InterfaceC5943Lm5 interfaceC5943Lm5, OK7 ok7, LD3 ld3) {
        AbstractC13042fc3.i(c14723iN1, "dialogFolderTabsProvider");
        AbstractC13042fc3.i(go1, "dialogListTopSpotStateManager");
        AbstractC13042fc3.i(interfaceC6828Pd5, "pinRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c15250jG2, "getNetworkStateUseCase");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(c12903fN1, "pagingSourcesManagers");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(c4413Fa2, "eventBarStateManager");
        AbstractC13042fc3.i(c18804pH1, "deleteAndLeaveGroupUseCase");
        AbstractC13042fc3.i(e84, "messageModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC24010xt2, "foldersRepository");
        AbstractC13042fc3.i(c18787pF2, "getAudioBarStateUseCase");
        AbstractC13042fc3.i(interfaceC16501lO, "audioPlayer");
        AbstractC13042fc3.i(tp1, "dialogUpdatesProvider");
        AbstractC13042fc3.i(c12720f53, "inAppUpdateStateManager");
        AbstractC13042fc3.i(fd7, "updateGateway");
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(ld3, "liveStreamRepository");
        this.b = go1;
        this.c = interfaceC6828Pd5;
        this.d = i;
        this.e = settingsModule;
        this.f = c15250jG2;
        this.g = interfaceC20667sP1;
        this.h = c12903fN1;
        this.i = km2;
        this.j = c18804pH1;
        this.k = e84;
        this.l = c8054Ui1;
        this.m = abstractC13778go1;
        this.n = interfaceC24010xt2;
        this.o = interfaceC16501lO;
        this.p = tp1;
        this.q = c12720f53;
        this.r = fd7;
        this.s = interfaceC5943Lm5;
        this.t = ok7;
        this.u = AbstractC11420cy6.b(1, 0, null, 6, null);
        this.v = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(XB4.K2(this.a));
            }
        });
        this.w = AbstractC9773aX7.a(this);
        this.x = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return XB4.N2(this.a);
            }
        });
        this.y = Q2(C20477s46.a.a());
        Boolean bool = Boolean.FALSE;
        this.z = AbstractC12281eL6.a(bool);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.A = interfaceC9336Zm4A;
        this.B = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.D = AbstractC9512a53.b.a;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(bool);
        this.G = interfaceC9336Zm4A2;
        InterfaceC4557Fq2 interfaceC4557Fq2O = AbstractC6459Nq2.o(c4413Fa2.f(), interfaceC9336Zm4A2, c12720f53.l(), new p(null));
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar = InterfaceC16863lz6.a;
        this.H = AbstractC6459Nq2.o0(interfaceC4557Fq2O, interfaceC20315ro1A, aVar.d(), bool);
        this.J = new ArrayList();
        InterfaceC10258bL6 interfaceC10258bL6R = c14723iN1.r();
        this.Y = interfaceC10258bL6R;
        this.Z = AbstractC6459Nq2.o0(AbstractC6459Nq2.v(new G(interfaceC10258bL6R)), AbstractC9773aX7.a(this), aVar.c(), AbstractC7783Te2.d(AbstractC10360bX0.m()));
        Iterator it = ((List) interfaceC10258bL6R.getValue()).iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            InterfaceC13521gN1 interfaceC13521gN1 = (InterfaceC13521gN1) it.next();
            if ((interfaceC13521gN1 instanceof InterfaceC13521gN1.b) && ((InterfaceC13521gN1.b) interfaceC13521gN1).e() == 0) {
                break;
            } else {
                i2++;
            }
        }
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(Integer.valueOf(i2));
        this.z0 = interfaceC9336Zm4A3;
        this.A0 = interfaceC9336Zm4A3;
        InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(new I(interfaceC9336Zm4A3, this), this.m);
        InterfaceC20315ro1 interfaceC20315ro1A2 = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar2 = InterfaceC16863lz6.a;
        this.B0 = AbstractC6459Nq2.o0(interfaceC4557Fq2V, interfaceC20315ro1A2, aVar2.c(), InterfaceC13521gN1.c.a);
        this.C0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.V(new H(interfaceC9336Zm4A3, this), this.m), AbstractC9773aX7.a(this), aVar2.c(), null);
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(AbstractC20051rO3.k());
        this.D0 = interfaceC9336Zm4A4;
        this.E0 = interfaceC9336Zm4A4;
        this.F0 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(new C8136Ur2(false, false, false, 7, null));
        this.G0 = interfaceC9336Zm4A5;
        this.H0 = AbstractC6459Nq2.c(interfaceC9336Zm4A5);
        InterfaceC9102Ym4 interfaceC9102Ym4D = AbstractC13472gH6.d(null, null, 2, null);
        this.I0 = interfaceC9102Ym4D;
        this.J0 = interfaceC9102Ym4D;
        this.K0 = AbstractC6459Nq2.o0(c18787pF2.g(), AbstractC9773aX7.a(this), aVar2.c(), new C17092mO(null, null, 3, null));
        XI3 xi3 = this.y;
        boolean zA3 = A3();
        AbstractC9512a53.b bVar = AbstractC9512a53.b.a;
        InterfaceC9336Zm4 interfaceC9336Zm4A6 = AbstractC12281eL6.a(new InterfaceC14139hQ1.a(xi3, zA3, bVar, null, 8, null));
        this.L0 = interfaceC9336Zm4A6;
        this.M0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.c0(interfaceC9336Zm4A6, new C8706e(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(aVar2, 0L, 0L, 3, null), new InterfaceC14139hQ1.a(this.y, A3(), bVar, null, 8, null));
        this.N0 = AbstractC6459Nq2.v(AbstractC6459Nq2.X(interfaceC9336Zm4A6, new q(null)));
        InterfaceC9336Zm4 interfaceC9336Zm4A7 = AbstractC12281eL6.a(null);
        this.O0 = interfaceC9336Zm4A7;
        this.P0 = AbstractC6459Nq2.c(interfaceC9336Zm4A7);
        this.Q0 = AbstractC12281eL6.a(null);
        InterfaceC9336Zm4 interfaceC9336Zm4A8 = AbstractC12281eL6.a(null);
        this.R0 = interfaceC9336Zm4A8;
        this.S0 = AbstractC6459Nq2.c(interfaceC9336Zm4A8);
        InterfaceC8327Vm4 interfaceC8327Vm4A = AbstractC11420cy6.a(0, 1, EnumC6162Ml0.DROP_OLDEST);
        this.T0 = interfaceC8327Vm4A;
        this.U0 = AbstractC6459Nq2.b(interfaceC8327Vm4A);
        this.V0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.v(AbstractC6459Nq2.p(AbstractC6459Nq2.s0(InterfaceC23301wh3.a.a().a(), new K(null)), ld3.m(), new L(null))), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.b(aVar2, 0L, 0L, 3, null), AbstractC20051rO3.k());
        this.W0 = new C8707f(this);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.m, null, new C8702a(null), 2, null);
    }

    private final boolean A3() {
        return this.e.e4() && C8386Vt0.u8();
    }

    private final boolean B3() {
        return this.e.f4() && C8386Vt0.u8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XI3 D3(XI3 xi3, EnumC23849xd1 enumC23849xd1) {
        XI3 xi3C;
        Object value;
        if (xi3 instanceof XI3.c) {
            xi3C = XI3.c.c((XI3.c) xi3, enumC23849xd1, 0, 2, null);
        } else if (xi3 instanceof XI3.a) {
            xi3C = XI3.a.c((XI3.a) xi3, enumC23849xd1, null, 2, null);
        } else {
            if (!(xi3 instanceof XI3.b)) {
                throw new NoWhenBranchMatchedException();
            }
            xi3C = XI3.b.c((XI3.b) xi3, enumC23849xd1, 0, 2, null);
        }
        if (this.L0.getValue() instanceof InterfaceC14139hQ1.a) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, new InterfaceC14139hQ1.a(xi3C, A3(), this.D, null, 8, null)));
        }
        return xi3C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new n(null), 3, null);
    }

    private final boolean G2(Map map) {
        return map.size() == 1 && !AbstractC13042fc3.d(map.keySet(), AbstractC4363Eu6.c(Long.valueOf((long) this.d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8708g(null), 3, null);
    }

    private final void J1(int i) {
        C10431bb8.a.b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K2(XB4 xb4) {
        AbstractC13042fc3.i(xb4, "this$0");
        return xb4.e.B5(EnumC4196Ec1.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(List list, boolean z2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC5969Lp4.d().t(C11458d25.r(((Number) it.next()).longValue()), z2);
        }
        N1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8710i(list, z2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L2(int r8, int r9, ir.nasim.core.modules.profile.entity.ExPeerType r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof ir.nasim.XB4.r
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.XB4$r r0 = (ir.nasim.XB4.r) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.XB4$r r0 = new ir.nasim.XB4$r
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r9 = r0.c
            int r8 = r0.b
            java.lang.Object r10 = r0.a
            ir.nasim.XB4 r10 = (ir.nasim.XB4) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L5d
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.core.modules.profile.entity.ExPeerType r11 = ir.nasim.core.modules.profile.entity.ExPeerType.GROUP
            if (r10 == r11) goto L4a
            ir.nasim.core.modules.profile.entity.ExPeerType r11 = ir.nasim.core.modules.profile.entity.ExPeerType.CHANNEL
            if (r10 == r11) goto L4a
            java.lang.Boolean r8 = ir.nasim.AbstractC6392Nk0.a(r4)
            return r8
        L4a:
            ir.nasim.KM2 r10 = r7.i
            long r5 = (long) r8
            r0.a = r7
            r0.b = r8
            r0.c = r9
            r0.f = r3
            java.lang.Object r11 = r10.l(r5, r0)
            if (r11 != r1) goto L5c
            return r1
        L5c:
            r10 = r7
        L5d:
            ir.nasim.iL2 r11 = (ir.nasim.C14697iL2) r11
            if (r11 != 0) goto Lbe
            java.lang.Class r9 = r10.getClass()
            boolean r9 = r9.isAnonymousClass()
            java.lang.String r10 = "substring(...)"
            java.lang.Class<ir.nasim.XB4> r11 = ir.nasim.XB4.class
            r0 = 23
            if (r9 != 0) goto L87
            java.lang.String r9 = r11.getSimpleName()
            int r11 = r9.length()
            ir.nasim.AbstractC13042fc3.f(r9)
            if (r11 > r0) goto L7f
            goto La5
        L7f:
            java.lang.String r9 = r9.substring(r4, r0)
            ir.nasim.AbstractC13042fc3.h(r9, r10)
            goto La5
        L87:
            java.lang.String r9 = r11.getName()
            int r11 = r9.length()
            ir.nasim.AbstractC13042fc3.f(r9)
            if (r11 > r0) goto L95
            goto La5
        L95:
            int r11 = r9.length()
            int r11 = r11 - r0
            int r0 = r9.length()
            java.lang.String r9 = r9.substring(r11, r0)
            ir.nasim.AbstractC13042fc3.h(r9, r10)
        La5:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Group not found for peerId: "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            android.util.Log.w(r9, r8)
            java.lang.Boolean r8 = ir.nasim.AbstractC6392Nk0.a(r4)
            return r8
        Lbe:
            int r8 = r11.w0()
            if (r8 == 0) goto Lc7
            if (r8 != r9) goto Lc7
            goto Lc8
        Lc7:
            r3 = r4
        Lc8:
            java.lang.Boolean r8 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.L2(int, int, ir.nasim.core.modules.profile.entity.ExPeerType, ir.nasim.rm1):java.lang.Object");
    }

    private final boolean M2(Set set) {
        Set set2 = set;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set2, 10));
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Number) it2.next()).intValue();
            F92 f92 = C8703b.a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : f92) {
                if (((EnumC7296Rc4) obj) != EnumC7296Rc4.UNRECOGNIZED) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(Integer.valueOf(((EnumC7296Rc4) it3.next()).getNumber()));
            }
            if (!arrayList3.contains(Integer.valueOf(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String N2(XB4 xb4) {
        AbstractC13042fc3.i(xb4, "this$0");
        return xb4.e.I2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap O1(Map... mapArr) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map map : mapArr) {
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (!concurrentHashMap.containsKey(key)) {
                    concurrentHashMap.put(key, value);
                }
            }
        }
        return concurrentHashMap;
    }

    private final String P1(int i, long j) {
        return i + "_" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC14139hQ1 P2(Map map) {
        if (map.isEmpty()) {
            M1();
            return new InterfaceC14139hQ1.a(this.y, A3(), this.D, null, 8, null);
        }
        Collection collectionValues = map.values();
        boolean z2 = true;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (W1((DialogDTO) it.next())) {
                    z2 = false;
                    break;
                }
            }
        }
        boolean z3 = z2;
        EnumC7540Sd5 enumC7540Sd5R2 = r2(map.values());
        EnumC19108pn4 enumC19108pn4O2 = o2(map.values());
        EnumC5526Js2 enumC5526Js2J2 = j2(map.keySet());
        return new InterfaceC14139hQ1.b(map.size(), false, G2(map), false, true, enumC7540Sd5R2, enumC19108pn4O2, z3, enumC5526Js2J2, B3(), y3(), a2(map.keySet()), 2, null);
    }

    private final void Q1(C11458d25 c11458d25, ExPeerType exPeerType) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8711j(c11458d25, this, exPeerType, null), 3, null);
    }

    private final XI3 Q2(C16913m46 c16913m46) {
        DD ddC = c16913m46.c(0);
        if (ddC == null) {
            return new XI3.c(EnumC23849xd1.e, c16913m46.b(0));
        }
        if (ddC instanceof DD.a) {
            return new XI3.b(EnumC23849xd1.e, ((DD.a) ddC).a());
        }
        if (ddC instanceof DD.b) {
            return new XI3.a(EnumC23849xd1.e, ((DD.b) ddC).a());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R2(List list) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new t(list, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(int i, String str) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8713l(i, str, null), 3, null);
    }

    private final void U2() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(this.q.k(), new v(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W1(DialogDTO dialogDTO) {
        Integer numK;
        Boolean boolF;
        SP1 sp1 = (SP1) ((Map) this.p.f().getValue()).get(Long.valueOf(dialogDTO.getPeerUniqueId()));
        return ((sp1 == null || (boolF = sp1.f()) == null) ? dialogDTO.getMarkAsUnread() : boolF.booleanValue()) || ((sp1 == null || (numK = sp1.k()) == null) ? dialogDTO.getUnreadMessageCount() : numK.intValue()) > 0;
    }

    private final void W2() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(this.f.b(), new w(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(Throwable th) {
        Object value;
        String message;
        Object value2;
        Object value3;
        if (!(th instanceof RpcException)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.R0;
            do {
                value = interfaceC9336Zm4.getValue();
                message = th.getMessage();
                if (message == null) {
                    message = "EXCEPTION";
                }
            } while (!interfaceC9336Zm4.f(value, new VF6.a(message)));
            return;
        }
        RpcException rpcException = (RpcException) th;
        if (AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "TIMEOUT")) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.R0;
            do {
                value3 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value3, VF6.k.b));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm43 = this.R0;
        do {
            value2 = interfaceC9336Zm43.getValue();
        } while (!interfaceC9336Zm43.f(value2, new VF6.a(rpcException.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String())));
    }

    private final void Y2() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(new x(this.E0, this), new y(null)), AbstractC9773aX7.a(this));
    }

    private final EnumC18820pJ a2(Set set) {
        Object obj = null;
        if (((Number) this.A0.getValue()).intValue() == EnumC11273cj7.a.ordinal() || !C8386Vt0.I3()) {
            return null;
        }
        Iterator it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (AbstractC20153rZ6.Q((String) next, "11_", true)) {
                obj = next;
                break;
            }
        }
        return obj != null ? EnumC18820pJ.d : EnumC18820pJ.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b3(boolean z2) {
        for (DialogDTO dialogDTO : (Iterable) this.F0.getValue()) {
            J1((int) dialogDTO.getPeerUniqueId());
            if (!z2) {
                C11458d25 c11458d25R = C11458d25.r(dialogDTO.getPeerUniqueId());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                Q1(c11458d25R, dialogDTO.getExPeerType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g3() {
        Set setKeySet = ((Map) this.E0.getValue()).keySet();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(j3((String) it.next()));
        }
        ArrayList<XV4> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!AbstractC13042fc3.d(((XV4) obj).e(), "10")) {
                arrayList2.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (XV4 xv4 : arrayList2) {
            String str = (String) xv4.e();
            Object arrayList3 = linkedHashMap.get(str);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(str, arrayList3);
            }
            ((List) arrayList3).add((String) xv4.f());
        }
        M1();
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new A((Map.Entry) it2.next(), null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h3() {
        Set setKeySet = ((Map) this.E0.getValue()).keySet();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(j3((String) it.next()));
        }
        ArrayList<XV4> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!AbstractC13042fc3.d(((XV4) obj).e(), "10")) {
                arrayList2.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (XV4 xv4 : arrayList2) {
            String str = (String) xv4.e();
            Object arrayList3 = linkedHashMap.get(str);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(str, arrayList3);
            }
            ((List) arrayList3).add((String) xv4.f());
        }
        M1();
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new B((Map.Entry) it2.next(), null), 3, null);
        }
    }

    private final boolean i3() {
        Iterable iterable = (Iterable) this.Y.getValue();
        ArrayList<InterfaceC13521gN1.b> arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (obj instanceof InterfaceC13521gN1.b) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        for (InterfaceC13521gN1.b bVar : arrayList) {
            F92 f92 = C8703b.a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : f92) {
                if (((EnumC7296Rc4) obj2) != EnumC7296Rc4.UNRECOGNIZED) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(Integer.valueOf(((EnumC7296Rc4) it.next()).getNumber()));
            }
            if (!arrayList3.contains(Integer.valueOf(bVar.e()))) {
                return false;
            }
        }
        return true;
    }

    private final EnumC5526Js2 j2(Set set) {
        Set set2 = set;
        ArrayList<XV4> arrayList = new ArrayList(AbstractC10976cX0.x(set2, 10));
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(j3((String) it.next()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (XV4 xv4 : arrayList) {
            String str = (String) xv4.e();
            Object arrayList2 = linkedHashMap.get(str);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(str, arrayList2);
            }
            ((List) arrayList2).add((String) xv4.f());
        }
        return i3() ? EnumC5526Js2.c : (linkedHashMap.size() != 1 || M2(linkedHashMap.keySet())) ? EnumC5526Js2.a : EnumC5526Js2.b;
    }

    private final XV4 j3(String str) {
        List listN0 = AbstractC20762sZ6.N0(str, new String[]{"_"}, false, 0, 6, null);
        return AbstractC4616Fw7.a((String) listN0.get(0), (String) listN0.get(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k3() {
        Y2();
        W2();
        U2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l3(int r5, java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.XB4.C
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.XB4$C r0 = (ir.nasim.XB4.C) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.XB4$C r0 = new ir.nasim.XB4$C
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r5 = r0.b
            java.lang.Object r6 = r0.a
            ir.nasim.XB4 r6 = (ir.nasim.XB4) r6
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r7 = r7.l()
            goto L50
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.Pd5 r7 = r4.c
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r7 = r7.a(r5, r6, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            r6 = r4
        L50:
            ir.nasim.OP1 r0 = ir.nasim.OP1.ALL
            int r0 = r0.j()
            if (r5 != r0) goto L5f
            ir.nasim.core.modules.settings.SettingsModule r5 = r6.e
            int r5 = r5.y3()
            goto L65
        L5f:
            ir.nasim.core.modules.settings.SettingsModule r5 = r6.e
            int r5 = r5.z3()
        L65:
            java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
            if (r7 == 0) goto Le2
            boolean r0 = r7 instanceof ir.nasim.core.network.RpcException
            if (r0 == 0) goto Lc6
            r0 = r7
            ir.nasim.core.network.RpcException r0 = (ir.nasim.core.network.RpcException) r0
            java.lang.String r7 = r0.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String()
            java.lang.String r1 = "pinned dialogs limit exceeded"
            boolean r1 = ir.nasim.AbstractC13042fc3.d(r7, r1)
            if (r1 == 0) goto L93
            ir.nasim.Zm4 r1 = r6.R0
        L80:
            java.lang.Object r6 = r1.getValue()
            r7 = r6
            ir.nasim.VF6 r7 = (ir.nasim.VF6) r7
            ir.nasim.VF6$e r7 = new ir.nasim.VF6$e
            r7.<init>(r5)
            boolean r6 = r1.f(r6, r7)
            if (r6 == 0) goto L80
            goto Le2
        L93:
            java.lang.String r5 = "TIMEOUT"
            boolean r5 = ir.nasim.AbstractC13042fc3.d(r7, r5)
            if (r5 == 0) goto Lad
            ir.nasim.Zm4 r5 = r6.R0
        L9d:
            java.lang.Object r6 = r5.getValue()
            r7 = r6
            ir.nasim.VF6 r7 = (ir.nasim.VF6) r7
            ir.nasim.VF6$k r7 = ir.nasim.VF6.k.b
            boolean r6 = r5.f(r6, r7)
            if (r6 == 0) goto L9d
            goto Le2
        Lad:
            ir.nasim.Zm4 r5 = r6.R0
        Laf:
            java.lang.Object r6 = r5.getValue()
            r7 = r6
            ir.nasim.VF6 r7 = (ir.nasim.VF6) r7
            ir.nasim.VF6$a r7 = new ir.nasim.VF6$a
            java.lang.String r1 = r0.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String()
            r7.<init>(r1)
            boolean r6 = r5.f(r6, r7)
            if (r6 == 0) goto Laf
            goto Le2
        Lc6:
            ir.nasim.Zm4 r5 = r6.R0
        Lc8:
            java.lang.Object r6 = r5.getValue()
            r0 = r6
            ir.nasim.VF6 r0 = (ir.nasim.VF6) r0
            ir.nasim.VF6$a r0 = new ir.nasim.VF6$a
            java.lang.String r1 = r7.getMessage()
            if (r1 != 0) goto Ld9
            java.lang.String r1 = "EXCEPTION"
        Ld9:
            r0.<init>(r1)
            boolean r6 = r5.f(r6, r0)
            if (r6 == 0) goto Lc8
        Le2:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.l3(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m3(int r5, java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.XB4.D
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.XB4$D r0 = (ir.nasim.XB4.D) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.XB4$D r0 = new ir.nasim.XB4$D
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r5 = r0.b
            java.lang.Object r6 = r0.a
            ir.nasim.XB4 r6 = (ir.nasim.XB4) r6
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r7 = r7.l()
            goto L50
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.Pd5 r7 = r4.c
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r7 = r7.f(r5, r6, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            r6 = r4
        L50:
            ir.nasim.OP1 r0 = ir.nasim.OP1.ALL
            int r0 = r0.j()
            if (r5 != r0) goto L5f
            ir.nasim.core.modules.settings.SettingsModule r5 = r6.e
            int r5 = r5.y3()
            goto L65
        L5f:
            ir.nasim.core.modules.settings.SettingsModule r5 = r6.e
            int r5 = r5.z3()
        L65:
            java.lang.Throwable r7 = ir.nasim.C9475a16.e(r7)
            if (r7 == 0) goto Le2
            boolean r0 = r7 instanceof ir.nasim.core.network.RpcException
            if (r0 == 0) goto Lc6
            r0 = r7
            ir.nasim.core.network.RpcException r0 = (ir.nasim.core.network.RpcException) r0
            java.lang.String r7 = r0.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String()
            java.lang.String r1 = "pinned dialogs limit exceeded"
            boolean r1 = ir.nasim.AbstractC13042fc3.d(r7, r1)
            if (r1 == 0) goto L93
            ir.nasim.Zm4 r1 = r6.R0
        L80:
            java.lang.Object r6 = r1.getValue()
            r7 = r6
            ir.nasim.VF6 r7 = (ir.nasim.VF6) r7
            ir.nasim.VF6$e r7 = new ir.nasim.VF6$e
            r7.<init>(r5)
            boolean r6 = r1.f(r6, r7)
            if (r6 == 0) goto L80
            goto Le2
        L93:
            java.lang.String r5 = "TIMEOUT"
            boolean r5 = ir.nasim.AbstractC13042fc3.d(r7, r5)
            if (r5 == 0) goto Lad
            ir.nasim.Zm4 r5 = r6.R0
        L9d:
            java.lang.Object r6 = r5.getValue()
            r7 = r6
            ir.nasim.VF6 r7 = (ir.nasim.VF6) r7
            ir.nasim.VF6$k r7 = ir.nasim.VF6.k.b
            boolean r6 = r5.f(r6, r7)
            if (r6 == 0) goto L9d
            goto Le2
        Lad:
            ir.nasim.Zm4 r5 = r6.R0
        Laf:
            java.lang.Object r6 = r5.getValue()
            r7 = r6
            ir.nasim.VF6 r7 = (ir.nasim.VF6) r7
            ir.nasim.VF6$a r7 = new ir.nasim.VF6$a
            java.lang.String r1 = r0.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String()
            r7.<init>(r1)
            boolean r6 = r5.f(r6, r7)
            if (r6 == 0) goto Laf
            goto Le2
        Lc6:
            ir.nasim.Zm4 r5 = r6.R0
        Lc8:
            java.lang.Object r6 = r5.getValue()
            r0 = r6
            ir.nasim.VF6 r0 = (ir.nasim.VF6) r0
            ir.nasim.VF6$a r0 = new ir.nasim.VF6$a
            java.lang.String r1 = r7.getMessage()
            if (r1 != 0) goto Ld9
            java.lang.String r1 = "EXCEPTION"
        Ld9:
            r0.<init>(r1)
            boolean r6 = r5.f(r6, r0)
            if (r6 == 0) goto Lc8
        Le2:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XB4.m3(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    private final EnumC19108pn4 o2(Collection collection) {
        Boolean boolL;
        Collection collection2 = collection;
        boolean z2 = true;
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DialogDTO dialogDTO = (DialogDTO) it.next();
                SP1 sp1 = (SP1) ((Map) this.p.f().getValue()).get(Long.valueOf(dialogDTO.getPeerUniqueId()));
                if (!((sp1 == null || (boolL = sp1.l()) == null) ? GM1.c(dialogDTO).a() : boolL.booleanValue())) {
                    z2 = false;
                    break;
                }
            }
        }
        return z2 ? EnumC19108pn4.d : EnumC19108pn4.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o3(List list) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new E(list, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p3(int i, boolean z2) {
        Object value;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.A;
        do {
            value = interfaceC9336Zm4.getValue();
            List<C8870Xr2> list = (List) value;
            arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (C8870Xr2 c8870Xr2B : list) {
                if (c8870Xr2B.c() == i) {
                    c8870Xr2B = C8870Xr2.b(c8870Xr2B, 0, null, false, false, z2, false, 47, null);
                }
                arrayList.add(c8870Xr2B);
            }
        } while (!interfaceC9336Zm4.f(value, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q3(boolean z2) {
        Object value;
        Object objA;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
        do {
            value = interfaceC9336Zm4.getValue();
            objA = (InterfaceC14139hQ1) value;
            if (B3()) {
                this.e.C7(false);
            }
            if (objA instanceof InterfaceC14139hQ1.b) {
                InterfaceC14139hQ1.b bVar = (InterfaceC14139hQ1.b) objA;
                objA = bVar.a((3575 & 1) != 0 ? bVar.a : 0, (3575 & 2) != 0 ? bVar.b : false, (3575 & 4) != 0 ? bVar.c : false, (3575 & 8) != 0 ? bVar.d : z2, (3575 & 16) != 0 ? bVar.e : false, (3575 & 32) != 0 ? bVar.f : null, (3575 & 64) != 0 ? bVar.g : null, (3575 & 128) != 0 ? bVar.h : false, (3575 & 256) != 0 ? bVar.i : null, (3575 & 512) != 0 ? bVar.j : false, (3575 & 1024) != 0 ? bVar.k : false, (3575 & 2048) != 0 ? bVar.l : null);
            }
        } while (!interfaceC9336Zm4.f(value, objA));
    }

    private final EnumC7540Sd5 r2(Collection collection) {
        Collection collection2 = collection;
        boolean z2 = collection2 instanceof Collection;
        if (!z2 || !collection2.isEmpty()) {
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                if (!(!GM1.b((DialogDTO) it.next()).a())) {
                    if (!z2 || !collection2.isEmpty()) {
                        Iterator it2 = collection2.iterator();
                        while (it2.hasNext()) {
                            if (!GM1.b((DialogDTO) it2.next()).a()) {
                                return EnumC7540Sd5.c;
                            }
                        }
                    }
                    return EnumC7540Sd5.d;
                }
            }
        }
        return EnumC7540Sd5.c;
    }

    @Override // ir.nasim.JN1
    public void A0(Integer num, String str) {
        if (num == null || str == null) {
            return;
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8705d(num, str, null), 3, null);
    }

    public final InterfaceC10258bL6 A2() {
        return this.Y;
    }

    @Override // ir.nasim.JN1
    public void C0(int i, List list) {
        AbstractC13042fc3.i(list, "visibleItemsIds");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new J(i, list, null), 3, null);
    }

    public final InterfaceC10040ay6 C2() {
        return this.U0;
    }

    public final void C3() {
        this.l.p0();
        E3(true);
    }

    public final InterfaceC10258bL6 D2() {
        return this.V0;
    }

    public final void E3(boolean z2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z2)));
    }

    public final InterfaceC13730gj3 F2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new o(null), 3, null);
    }

    @Override // ir.nasim.JN1
    public void G0(C7960Tx6 c7960Tx6) {
        Object value;
        String strF;
        C7960Tx6 c7960Tx6B;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.Q0;
        do {
            value = interfaceC9336Zm4.getValue();
            if (c7960Tx6 == null) {
                c7960Tx6B = null;
            } else {
                SP1 sp1 = (SP1) ((Map) this.p.f().getValue()).get(Long.valueOf(c7960Tx6.e().u()));
                if (sp1 == null || (strF = sp1.j()) == null) {
                    strF = c7960Tx6.f();
                }
                c7960Tx6B = C7960Tx6.b(c7960Tx6, null, strF, false, null, 13, null);
            }
        } while (!interfaceC9336Zm4.f(value, c7960Tx6B));
    }

    public final InterfaceC10258bL6 H2() {
        return this.H;
    }

    public final void I1(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8709h(i, null), 3, null);
    }

    public final InterfaceC4557Fq2 I2() {
        return this.N0;
    }

    public final boolean J2() {
        return ((Boolean) this.v.getValue()).booleanValue();
    }

    public final void K1(AbstractC13089g.b bVar) {
        Object value;
        Object aVar;
        AbstractC13042fc3.i(bVar, "mode");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
        do {
            value = interfaceC9336Zm4.getValue();
            int i = C8704c.b[bVar.ordinal()];
            if (i == 1 || i == 2) {
                aVar = new InterfaceC14139hQ1.a(this.y, A3(), this.D, null, 8, null);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                M1();
                aVar = InterfaceC14139hQ1.c.a;
            }
        } while (!interfaceC9336Zm4.f(value, aVar));
    }

    public final void M1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC20051rO3.k()));
    }

    public final void N1() {
        Object value;
        M1();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new InterfaceC14139hQ1.a(this.y, A3(), this.D, null, 8, null)));
    }

    public final Object O2(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC10533bm0.b(AbstractC9773aX7.a(this), null, null, new s(null), 3, null).y(interfaceC20295rm1);
    }

    public final void R1(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C8712k(i, null), 3, null);
    }

    public final InterfaceC13730gj3 S2(Set set) {
        AbstractC13042fc3.i(set, DialogEntity.TABLE_NAME);
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new u(set, this, null), 3, null);
    }

    public final void T1(Context context) throws NumberFormatException {
        Object next;
        AbstractC13042fc3.i(context, "context");
        Set setKeySet = ((Map) this.E0.getValue()).keySet();
        ArrayList<XV4> arrayList = new ArrayList(AbstractC10976cX0.x(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(j3((String) it.next()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (XV4 xv4 : arrayList) {
            String str = (String) xv4.e();
            Object arrayList2 = linkedHashMap.get(str);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(str, arrayList2);
            }
            ((List) arrayList2).add((String) xv4.f());
        }
        int i = Integer.parseInt((String) ((Map.Entry) AbstractC15401jX0.p0(linkedHashMap.entrySet())).getKey());
        Iterator it2 = ((Iterable) this.Y.getValue()).iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            InterfaceC13521gN1 interfaceC13521gN1 = (InterfaceC13521gN1) next;
            if ((interfaceC13521gN1 instanceof InterfaceC13521gN1.b) && ((InterfaceC13521gN1.b) interfaceC13521gN1).e() == i) {
                break;
            }
        }
        AbstractC13042fc3.g(next, "null cannot be cast to non-null type ir.nasim.dialoglist.ui.components.DialogFolderTab.Folder");
        S1(i, ((InterfaceC13521gN1.b) next).f().a(context));
    }

    public final void U1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new m(null), 3, null);
    }

    public final void V1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.O0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final InterfaceC10258bL6 Y1() {
        return this.B0;
    }

    @Override // ir.nasim.JN1
    public InterfaceC10258bL6 Z() {
        return this.M0;
    }

    public final InterfaceC12321eQ1 Z1() {
        return this.W0;
    }

    public final void a3(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new z(i, null), 3, null);
    }

    public final InterfaceC10258bL6 c2() {
        return this.b.a();
    }

    public final void c3(int i) {
        this.h.m(i);
    }

    public final InterfaceC10258bL6 d2() {
        return this.K0;
    }

    public final void d3(int i) {
        if (i != EnumC7296Rc4.ReservedFolderID_ALL.getNumber()) {
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.I0;
            Integer num = (Integer) interfaceC9102Ym4.getValue();
            interfaceC9102Ym4.setValue((num != null && num.intValue() == i) ? null : Integer.valueOf(i));
        }
    }

    public final List e2() {
        return this.J;
    }

    public final void e3() {
        this.I0.setValue(null);
    }

    public final InterfaceC10258bL6 f2() {
        return this.P0;
    }

    public final InterfaceC10258bL6 g2() {
        return this.b.b();
    }

    public final InterfaceC4557Fq2 h2(int i, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        return C12903fN1.o(this.h, i, interfaceC20315ro1, 0, 0, 12, null);
    }

    public final InterfaceC9664aL6 i2() {
        return this.J0;
    }

    @Override // ir.nasim.JN1
    public void j0(DialogDTO dialogDTO, int i) {
        Object value;
        Map map;
        AbstractC13042fc3.i(dialogDTO, "dialog");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D0;
        do {
            value = interfaceC9336Zm4.getValue();
            map = (Map) value;
            String strP1 = P1(i, dialogDTO.getPeerUniqueId());
            boolean zContainsKey = map.containsKey(strP1);
            Map mapO = (zContainsKey || map.size() >= 100) ? zContainsKey ? AbstractC20051rO3.o(map, strP1) : map : AbstractC20051rO3.r(map, AbstractC4616Fw7.a(strP1, dialogDTO));
            if (mapO != null) {
                map = mapO;
            }
        } while (!interfaceC9336Zm4.f(value, map));
    }

    @Override // ir.nasim.JN1
    public void k(EnumC21241tM enumC21241tM) {
        AbstractC13042fc3.i(enumC21241tM, "speed");
        int i = C8704c.c[enumC21241tM.ordinal()];
        if (i == 1) {
            this.o.t(new AbstractC18874pP.c());
            return;
        }
        if (i == 2) {
            this.o.t(new AbstractC18874pP.a());
        } else if (i == 3) {
            this.o.t(new AbstractC18874pP.b());
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            this.o.t(new AbstractC18874pP.d());
        }
    }

    public final InterfaceC10258bL6 k2() {
        return this.z;
    }

    public final InterfaceC10258bL6 l2() {
        return this.B;
    }

    public final InterfaceC4557Fq2 m2() {
        return this.f.b();
    }

    public final String n2() {
        return (String) this.x.getValue();
    }

    public final void n3() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.R0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final int p2() {
        return this.d;
    }

    @Override // ir.nasim.JN1
    public void r(AbstractC20029rM abstractC20029rM) {
        AbstractC13042fc3.i(abstractC20029rM, "playbackState");
        if (AbstractC13042fc3.d(abstractC20029rM, AbstractC20029rM.b.c)) {
            this.o.h();
        } else {
            if (!AbstractC13042fc3.d(abstractC20029rM, AbstractC20029rM.a.c)) {
                throw new NoWhenBranchMatchedException();
            }
            this.o.q();
        }
    }

    public final void r3(InterfaceC13548gQ1 interfaceC13548gQ1) {
        Object bVar;
        Object value;
        AbstractC13042fc3.i(interfaceC13548gQ1, "appBarUiState");
        if (AbstractC13042fc3.d(interfaceC13548gQ1, InterfaceC13548gQ1.a.a)) {
            bVar = new InterfaceC14139hQ1.a(this.y, A3(), this.D, null, 8, null);
        } else {
            if (!(interfaceC13548gQ1 instanceof InterfaceC13548gQ1.b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC13548gQ1.b bVar2 = (InterfaceC13548gQ1.b) interfaceC13548gQ1;
            bVar = new InterfaceC14139hQ1.b(bVar2.a(), bVar2.b(), false, false, false, null, null, false, null, false, y3(), a2(((Map) this.E0.getValue()).keySet()), 492, null);
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, bVar));
    }

    public final InterfaceC4557Fq2 s2() {
        return new F(this.r.c());
    }

    public final void s3() {
        Object value;
        Object objB;
        if (A3()) {
            this.e.B7(false);
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
        do {
            value = interfaceC9336Zm4.getValue();
            objB = (InterfaceC14139hQ1) value;
            if (objB instanceof InterfaceC14139hQ1.a) {
                objB = InterfaceC14139hQ1.a.b((InterfaceC14139hQ1.a) objB, this.y, false, this.D, null, 8, null);
            }
        } while (!interfaceC9336Zm4.f(value, objB));
    }

    public final DialogDTO t2() {
        XV4 xv4;
        Map map = (Map) this.E0.getValue();
        if (!G2(map) || (xv4 = (XV4) AbstractC15401jX0.s0(AbstractC21263tO3.C(map))) == null) {
            return null;
        }
        return (DialogDTO) xv4.f();
    }

    public final void t3(boolean z2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.G;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z2)));
    }

    public final InterfaceC10258bL6 u2() {
        return this.E0;
    }

    public final void u3(int i) {
        Object value;
        if (((Number) this.z0.getValue()).intValue() == i) {
            return;
        }
        EnumC11273cj7 enumC11273cj7 = EnumC11273cj7.a;
        if (i == enumC11273cj7.ordinal() || ((Number) this.z0.getValue()).intValue() == enumC11273cj7.ordinal()) {
            this.T0.c(EnumC3635Br7.b);
            N1();
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Number) value).intValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i)));
    }

    @Override // ir.nasim.JN1
    public void v0() {
        this.o.s(true);
    }

    public final InterfaceC10258bL6 v2() {
        return this.A0;
    }

    public final void v3(boolean z2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.G0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C8136Ur2.b((C8136Ur2) value, false, false, z2, 3, null)));
    }

    public final InterfaceC10258bL6 w2() {
        return AbstractC6459Nq2.c(this.Q0);
    }

    public final void w3(boolean z2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.G0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C8136Ur2.b((C8136Ur2) value, false, z2, false, 5, null)));
    }

    public final InterfaceC10258bL6 x2() {
        return this.H0;
    }

    public final void x3(boolean z2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.G0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C8136Ur2.b((C8136Ur2) value, z2, false, false, 6, null)));
    }

    public final InterfaceC10258bL6 y2() {
        return this.S0;
    }

    public final boolean y3() {
        return !this.e.u0();
    }

    @Override // ir.nasim.JN1
    public InterfaceC20315ro1 z() {
        return this.w;
    }

    public final InterfaceC10258bL6 z2() {
        return this.Z;
    }

    public final void z3() {
        String userName;
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        Set setKeySet = ((Map) this.E0.getValue()).keySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : setKeySet) {
            String str = (String) j3((String) obj).f();
            Object arrayList = linkedHashMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(str, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        int size = linkedHashMap.size();
        if (size > 1) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.O0;
            do {
                value5 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value5, new AbstractC24832zH1.a(size)));
            return;
        }
        DialogDTO dialogDTO = (DialogDTO) ((Map.Entry) AbstractC15401jX0.p0(((Map) this.E0.getValue()).entrySet())).getValue();
        ExPeerType exPeerType = dialogDTO.getExPeerType();
        SP1 sp1 = (SP1) ((Map) this.p.f().getValue()).get(Long.valueOf(dialogDTO.getPeerUniqueId()));
        if (sp1 == null || (userName = sp1.j()) == null) {
            userName = dialogDTO.getUserName();
        }
        int i = C8704c.a[exPeerType.ordinal()];
        if (i == 1) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.O0;
            do {
                value = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value, new AbstractC24832zH1.d(userName)));
            return;
        }
        if (i == 2) {
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.O0;
            do {
                value2 = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value2, new AbstractC24832zH1.c(userName)));
            return;
        }
        if (i != 3) {
            InterfaceC9336Zm4 interfaceC9336Zm44 = this.O0;
            do {
                value4 = interfaceC9336Zm44.getValue();
            } while (!interfaceC9336Zm44.f(value4, new AbstractC24832zH1.e(userName)));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm45 = this.O0;
        do {
            value3 = interfaceC9336Zm45.getValue();
        } while (!interfaceC9336Zm45.f(value3, new AbstractC24832zH1.b(userName, GM1.a(dialogDTO))));
    }
}
