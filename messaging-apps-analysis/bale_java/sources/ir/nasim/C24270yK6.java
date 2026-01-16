package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C21753u45;
import ir.nasim.G35;
import ir.nasim.J35;
import ir.nasim.features.call.ui.startOutGoingCall.StartOutGoingCallPeerData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.yK6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24270yK6 extends OX2 {
    public static final a m1 = new a(null);
    public static final int n1 = 8;
    private final boolean h1;
    private final StartOutGoingCallPeerData i1;
    private final List j1;
    private final InterfaceC9173Yu3 k1;
    private final InterfaceC9173Yu3 l1;

    /* renamed from: ir.nasim.yK6$a */
    public static final class a {
        private a() {
        }

        public final Fragment a(StartOutGoingCallPeerData startOutGoingCallPeerData) {
            return new C24270yK6(true, startOutGoingCallPeerData, null, 4, null);
        }

        public final Fragment b(StartOutGoingCallPeerData startOutGoingCallPeerData) {
            return new C24270yK6(false, startOutGoingCallPeerData, null, 4, null);
        }

        public final Fragment c(List list) {
            AbstractC13042fc3.i(list, "peers");
            return new C24270yK6(false, null, list, 2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yK6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C21753u45.d.values().length];
            try {
                iArr[C21753u45.d.s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C21753u45.d.f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C21753u45.d.u.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C21753u45.d.v.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.yK6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.yK6$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C24270yK6 c;

            /* renamed from: ir.nasim.yK6$c$a$a, reason: collision with other inner class name */
            static final class C1783a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C24270yK6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1783a(C24270yK6 c24270yK6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c24270yK6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1783a c1783a = new C1783a(this.d, interfaceC20295rm1);
                    c1783a.c = obj;
                    return c1783a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C13499gK6 c13499gK6 = (C13499gK6) this.c;
                    if (c13499gK6.c()) {
                        this.d.Ga();
                    } else if (c13499gK6.e()) {
                        this.d.na();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(C13499gK6 c13499gK6, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1783a) create(c13499gK6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24270yK6 c24270yK6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c24270yK6;
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
                    InterfaceC10258bL6 interfaceC10258bL6R0 = this.c.pa().R0();
                    C1783a c1783a = new C1783a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6R0, c1783a, this) == objE) {
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

        /* renamed from: ir.nasim.yK6$c$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C24270yK6 c;

            /* renamed from: ir.nasim.yK6$c$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C24270yK6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C24270yK6 c24270yK6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c24270yK6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = obj;
                    return aVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.qa((J35) this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(J35 j35, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(j35, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.yK6$c$b$b, reason: collision with other inner class name */
            public static final class C1784b implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.yK6$c$b$b$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.yK6$c$b$b$a$a, reason: collision with other inner class name */
                    public static final class C1785a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1785a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                            boolean r0 = r6 instanceof ir.nasim.C24270yK6.c.b.C1784b.a.C1785a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.yK6$c$b$b$a$a r0 = (ir.nasim.C24270yK6.c.b.C1784b.a.C1785a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.yK6$c$b$b$a$a r0 = new ir.nasim.yK6$c$b$b$a$a
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
                            ir.nasim.gK6 r5 = (ir.nasim.C13499gK6) r5
                            ir.nasim.J35 r5 = r5.d()
                            if (r5 == 0) goto L47
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L47
                            return r1
                        L47:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24270yK6.c.b.C1784b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public C1784b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C24270yK6 c24270yK6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c24270yK6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new C1784b(this.c.pa().R0()));
                    a aVar = new a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C24270yK6.this.new c(interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C24270yK6.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C24270yK6.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yK6$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.yK6$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.yK6$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.yK6$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.yK6$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    /* synthetic */ C24270yK6(boolean z, StartOutGoingCallPeerData startOutGoingCallPeerData, List list, int i, ED1 ed1) {
        this(z, (i & 2) != 0 ? null : startOutGoingCallPeerData, (i & 4) != 0 ? AbstractC10360bX0.m() : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Da(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Fa(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga() {
        StartOutGoingCallPeerData startOutGoingCallPeerData = this.i1;
        if (startOutGoingCallPeerData == null || !startOutGoingCallPeerData.getIsPrivatePeer()) {
            StartOutGoingCallPeerData startOutGoingCallPeerData2 = this.i1;
            if (startOutGoingCallPeerData2 != null && !startOutGoingCallPeerData2.getIsPrivatePeer()) {
                C20384rv0.a.h0(this.i1.getPeerId(), this.i1.getPeerUniqueId(), this.h1);
            } else if (!this.j1.isEmpty()) {
                C20384rv0 c20384rv0 = C20384rv0.a;
                List list = this.j1;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((C11458d25) it.next()).u()));
                }
                c20384rv0.i0(arrayList);
            }
        } else {
            C20384rv0.c0(this.i1.getPeerId(), this.h1, new SA2() { // from class: ir.nasim.pK6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24270yK6.Ha(this.a);
                }
            }, new SA2() { // from class: ir.nasim.qK6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24270yK6.Ia(this.a);
                }
            }, new UA2() { // from class: ir.nasim.rK6
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C24270yK6.Ja(((Integer) obj).intValue());
                }
            });
        }
        na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ha(C24270yK6 c24270yK6) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        C17468n10 c17468n10Oa = c24270yK6.oa();
        String strH6 = c24270yK6.h6(AbstractC12217eE5.not_possible_to_use_when_calling);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10Oa.o(strH6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ia(C24270yK6 c24270yK6) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        FragmentActivity fragmentActivityQ7 = c24270yK6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        FragmentActivity fragmentActivityQ72 = c24270yK6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
        C24398yZ.c(fragmentActivityQ7, fragmentActivityQ72).show();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja(int i) {
        C19406qI3.a("StartOutgoingCallFragment", "start call without enable required permissions", new Object[0]);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 la(C24270yK6 c24270yK6) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        View viewV7 = c24270yK6.V7();
        AbstractC13042fc3.h(viewV7, "requireView(...)");
        C17468n10 c17468n10 = new C17468n10(viewV7, null, 0, 6, null);
        c17468n10.m(4000);
        return c17468n10;
    }

    private final void ma() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (Build.VERSION.SDK_INT >= 31 && AbstractC4043Dl1.a(S7(), "android.permission.READ_PHONE_STATE") != 0) {
            linkedHashSet.add(C21753u45.d.u);
        }
        if (AbstractC4043Dl1.a(S7(), "android.permission.RECORD_AUDIO") != 0) {
            linkedHashSet.add(C21753u45.d.s);
        }
        if (this.h1 && AbstractC4043Dl1.a(S7(), "android.permission.CAMERA") != 0) {
            linkedHashSet.add(C21753u45.d.f);
        }
        pa().T0(linkedHashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na() {
        C22042ua0.o9(this, this, false, 2, null);
    }

    private final C17468n10 oa() {
        return (C17468n10) this.k1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C14090hK6 pa() {
        return (C14090hK6) this.l1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(J35 j35) {
        if (j35 instanceof J35.a) {
            wa((J35.a) j35);
        } else {
            if (!(j35 instanceof J35.b)) {
                throw new NoWhenBranchMatchedException();
            }
            za(((J35.b) j35).a());
        }
    }

    private final InterfaceC13730gj3 ra() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new c(null), 3, null);
    }

    private final void sa(final C21753u45.d dVar) {
        int i = b.a[dVar.ordinal()];
        if (i == 1) {
            C21753u45.a.I0(this, 1009, dVar, new SA2() { // from class: ir.nasim.mK6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24270yK6.ta(this.a, dVar);
                }
            });
            return;
        }
        if (i == 2) {
            C21753u45.a.I0(this, 1010, dVar, new SA2() { // from class: ir.nasim.nK6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24270yK6.ua(this.a, dVar);
                }
            });
            return;
        }
        if (i == 3) {
            C21753u45.a.I0(this, 1011, dVar, new SA2() { // from class: ir.nasim.oK6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24270yK6.va(this.a, dVar);
                }
            });
            return;
        }
        C19406qI3.a("StartOutgoingCallFragment", "permission <" + dVar + "> not handled ", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(C24270yK6 c24270yK6, C21753u45.d dVar) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        c24270yK6.pa().S0(dVar, false);
        return C19938rB7.a;
    }

    private final void wa(final J35.a aVar) {
        G35 g35A = aVar.a();
        if (AbstractC13042fc3.d(g35A, G35.a.a)) {
            sa((C21753u45.d) AbstractC15401jX0.q0(aVar.b()));
            return;
        }
        if (!(g35A instanceof G35.b)) {
            throw new NoWhenBranchMatchedException();
        }
        final C21753u45.d dVar = (C21753u45.d) AbstractC15401jX0.s0(aVar.b());
        if (dVar == null) {
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        boolean zY = c21753u45.Y(fragmentActivityQ7, dVar);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        NY nyF = new NY(contextS7).p(((G35.b) aVar.a()).b()).E(4).k(4).F(true).h(((G35.b) aVar.a()).a()).v(new View.OnClickListener() { // from class: ir.nasim.kK6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24270yK6.xa(this.a, dVar, view);
            }
        }).f(false);
        if (zY) {
            nyF.w(AbstractC12217eE5.permission_go_to_settings);
        } else {
            nyF.w(AbstractC12217eE5.permission_ok).t(AbstractC12217eE5.permission_deny).s(new View.OnClickListener() { // from class: ir.nasim.lK6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C24270yK6.ya(this.a, aVar, view);
                }
            });
        }
        nyF.a().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(C24270yK6 c24270yK6, C21753u45.d dVar, View view) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(dVar, "$firstPermission");
        c24270yK6.sa(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ya(C24270yK6 c24270yK6, J35.a aVar, View view) {
        AbstractC13042fc3.i(c24270yK6, "this$0");
        AbstractC13042fc3.i(aVar, "$permission");
        c24270yK6.pa().S0((C21753u45.d) AbstractC15401jX0.q0(aVar.b()), false);
    }

    private final void za(final C21753u45.d dVar) {
        int i = b.a[dVar.ordinal()];
        if (i == 1) {
            C21753u45.a.g0(this, 1009, dVar, (208 & 8) != 0 ? null : Integer.valueOf(AbstractC12217eE5.voice_call_permission_desctiption), (208 & 16) != 0 ? 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a4: INVOKE 
                  (wrap:ir.nasim.u45:0x0089: SGET  A[WRAPPED] (LINE:138) ir.nasim.u45.a ir.nasim.u45)
                  (r11v0 'this' ir.nasim.yK6 A[IMMUTABLE_TYPE, THIS])
                  (1009 int)
                  (r12v0 'dVar' ir.nasim.u45$d)
                  (wrap:java.lang.Integer:?: TERNARY null = ((wrap:int:0x0002: ARITH (208 int) & (8 int) A[WRAPPED] (LINE:3)) != (0 int)) ? (null java.lang.Integer) : (wrap:java.lang.Integer:0x008d: INVOKE (wrap:int:0x008b: SGET  A[WRAPPED] (LINE:140) ir.nasim.eE5.voice_call_permission_desctiption int) STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED] (LINE:142)))
                  (wrap:ir.nasim.SA2:?: TERNARY null = ((wrap:int:0x000a: ARITH (208 int) & (16 int) A[WRAPPED] (LINE:11)) != (0 int)) ? (wrap:??:0x0013: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:17) call: ir.nasim.b45.<init>():void type: CONSTRUCTOR) : (null ir.nasim.SA2))
                  (wrap:ir.nasim.SA2:?: TERNARY null = ((wrap:int:0x0017: ARITH (208 int) & (32 int) A[WRAPPED] (LINE:24)) != (0 int)) ? (wrap:??:0x0020: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:30) call: ir.nasim.c45.<init>():void type: CONSTRUCTOR) : (wrap:ir.nasim.SA2:0x0093: CONSTRUCTOR (r11v0 'this' ir.nasim.yK6 A[DONT_INLINE, IMMUTABLE_TYPE, THIS]), (r12v0 'dVar' ir.nasim.u45$d A[DONT_INLINE]) A[MD:(ir.nasim.yK6, ir.nasim.u45$d):void (m), WRAPPED] (LINE:148) call: ir.nasim.sK6.<init>(ir.nasim.yK6, ir.nasim.u45$d):void type: CONSTRUCTOR))
                  (wrap:ir.nasim.SA2:?: TERNARY null = ((wrap:int:0x0024: ARITH (208 int) & (64 int) A[WRAPPED] (LINE:37)) != (0 int)) ? (wrap:??:0x002d: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:43) call: ir.nasim.d45.<init>():void type: CONSTRUCTOR) : (wrap:ir.nasim.SA2:0x0098: CONSTRUCTOR (r11v0 'this' ir.nasim.yK6 A[DONT_INLINE, IMMUTABLE_TYPE, THIS]), (r12v0 'dVar' ir.nasim.u45$d A[DONT_INLINE]) A[MD:(ir.nasim.yK6, ir.nasim.u45$d):void (m), WRAPPED] (LINE:153) call: ir.nasim.tK6.<init>(ir.nasim.yK6, ir.nasim.u45$d):void type: CONSTRUCTOR))
                  (wrap:boolean:?: TERNARY null = ((wrap:int:0x0031: ARITH (208 int) & (128 int) A[WRAPPED] (LINE:50)) != (0 int)) ? true : false)
                 VIRTUAL call: ir.nasim.u45.g0(androidx.fragment.app.Fragment, int, ir.nasim.u45$d, java.lang.Integer, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, boolean):void A[MD:(androidx.fragment.app.Fragment, int, ir.nasim.u45$d, java.lang.Integer, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, boolean):void (m)] (LINE:63) in method: ir.nasim.yK6.za(ir.nasim.u45$d):void, file: classes5.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: ir.nasim.b45, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:1187)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:536)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                	... 23 more
                */
            /*
                this = this;
                int[] r0 = ir.nasim.C24270yK6.b.a
                int r1 = r12.ordinal()
                r0 = r0[r1]
                r1 = 1
                if (r0 == r1) goto L89
                r1 = 2
                if (r0 == r1) goto L6e
                r1 = 3
                if (r0 == r1) goto L4f
                r1 = 4
                if (r0 == r1) goto L34
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "permission <"
                r0.append(r1)
                r0.append(r12)
                java.lang.String r1 = "> not handled "
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.String r2 = "StartOutgoingCallFragment"
                ir.nasim.C19406qI3.a(r2, r0, r1)
                goto La7
            L34:
                ir.nasim.u45 r0 = ir.nasim.C21753u45.a
                int r1 = ir.nasim.AbstractC12217eE5.call_bluetooth_permission_desctiption
                java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
                ir.nasim.xK6 r6 = new ir.nasim.xK6
                r6.<init>()
                r9 = 208(0xd0, float:2.91E-43)
                r10 = 0
                r2 = 1020(0x3fc, float:1.43E-42)
                r5 = 0
                r7 = 0
                r8 = 0
                r1 = r11
                r3 = r12
                ir.nasim.C21753u45.l0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                goto La7
            L4f:
                ir.nasim.u45 r0 = ir.nasim.C21753u45.a
                int r1 = ir.nasim.AbstractC12217eE5.call_phone_state_permission_description
                java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
                ir.nasim.vK6 r6 = new ir.nasim.vK6
                r6.<init>()
                ir.nasim.wK6 r7 = new ir.nasim.wK6
                r7.<init>()
                r9 = 16
                r10 = 0
                r2 = 1011(0x3f3, float:1.417E-42)
                r5 = 0
                r8 = 0
                r1 = r11
                r3 = r12
                ir.nasim.C21753u45.l0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                goto La7
            L6e:
                ir.nasim.u45 r0 = ir.nasim.C21753u45.a
                int r1 = ir.nasim.AbstractC12217eE5.video_call_permission_desctiption
                java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
                ir.nasim.uK6 r6 = new ir.nasim.uK6
                r6.<init>()
                r9 = 80
                r10 = 0
                r2 = 1010(0x3f2, float:1.415E-42)
                r5 = 0
                r7 = 0
                r8 = 0
                r1 = r11
                r3 = r12
                ir.nasim.C21753u45.l0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                goto La7
            L89:
                ir.nasim.u45 r0 = ir.nasim.C21753u45.a
                int r1 = ir.nasim.AbstractC12217eE5.voice_call_permission_desctiption
                java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
                ir.nasim.sK6 r6 = new ir.nasim.sK6
                r6.<init>()
                ir.nasim.tK6 r7 = new ir.nasim.tK6
                r7.<init>()
                r9 = 16
                r10 = 0
                r2 = 1009(0x3f1, float:1.414E-42)
                r5 = 0
                r8 = 0
                r1 = r11
                r3 = r12
                ir.nasim.C21753u45.l0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            La7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24270yK6.za(ir.nasim.u45$d):void");
        }

        @Override // androidx.fragment.app.Fragment
        public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AbstractC13042fc3.i(layoutInflater, "inflater");
            return new FrameLayout(S7());
        }

        @Override // androidx.fragment.app.Fragment
        public void g7(int i, String[] strArr, int[] iArr) {
            AbstractC13042fc3.i(strArr, "permissions");
            AbstractC13042fc3.i(iArr, "grantResults");
            Integer numD0 = AbstractC10242bK.d0(iArr);
            boolean z = numD0 != null && numD0.intValue() == 0;
            if (i == 1020) {
                pa().S0(C21753u45.d.v, z);
            }
            switch (i) {
                case 1009:
                    pa().S0(C21753u45.d.s, z);
                    break;
                case 1010:
                    pa().S0(C21753u45.d.f, z);
                    break;
                case 1011:
                    pa().S0(C21753u45.d.u, z);
                    break;
                default:
                    super.g7(i, strArr, iArr);
                    break;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void l7(View view, Bundle bundle) {
            AbstractC13042fc3.i(view, "view");
            super.l7(view, bundle);
            ra();
            ma();
        }

        private C24270yK6(boolean z, StartOutGoingCallPeerData startOutGoingCallPeerData, List list) {
            this.h1 = z;
            this.i1 = startOutGoingCallPeerData;
            this.j1 = list;
            this.k1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jK6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24270yK6.la(this.a);
                }
            });
            InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
            this.l1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C14090hK6.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
        }
    }
