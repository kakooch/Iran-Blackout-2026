package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.fragment.app.Fragment;
import ir.nasim.A98;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC25193zt1;
import ir.nasim.AbstractC7195Qr2;
import ir.nasim.C12700f33;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.zt1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC25193zt1 {

    /* renamed from: ir.nasim.zt1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ InterfaceC20315ro1 d;
        final /* synthetic */ C19391qG6 e;
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.zt1$a$a, reason: collision with other inner class name */
        static final class C1824a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19391qG6 c;
            final /* synthetic */ String d;
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1824a(C19391qG6 c19391qG6, String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19391qG6;
                this.d = str;
                this.e = sa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1824a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19391qG6 c19391qG6 = this.c;
                    String str = this.d;
                    EnumC17618nG6 enumC17618nG6 = EnumC17618nG6.Short;
                    this.b = 1;
                    if (C19391qG6.f(c19391qG6, str, null, false, enumC17618nG6, this, 2, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                this.e.invoke();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1824a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, InterfaceC20315ro1 interfaceC20315ro1, C19391qG6 c19391qG6, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = interfaceC20315ro1;
            this.e = c19391qG6;
            this.f = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String str = this.c;
            if (str != null) {
                AbstractC10533bm0.d(this.d, null, null, new C1824a(this.e, str, this.f, null), 3, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zt1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ C19818qz6 c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ defpackage.t f;
        final /* synthetic */ C19206px3 g;
        final /* synthetic */ String h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ List j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ SA2 m;
        final /* synthetic */ InterfaceC20315ro1 n;
        final /* synthetic */ String o;
        final /* synthetic */ boolean p;
        final /* synthetic */ boolean q;
        final /* synthetic */ UA2 r;
        final /* synthetic */ UA2 s;
        final /* synthetic */ boolean t;
        final /* synthetic */ boolean u;
        final /* synthetic */ SA2 v;
        final /* synthetic */ C19391qG6 w;
        final /* synthetic */ InterfaceC9102Ym4 x;
        final /* synthetic */ String y;

        /* renamed from: ir.nasim.zt1$b$a */
        static final class a implements InterfaceC14603iB2 {
            public static final a a = new a();

            a() {
            }

            public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(1928109239);
                A98.a aVar = A98.a;
                A98 a98H = AbstractC21393ta8.h(AbstractC24416ya8.c(aVar, interfaceC22053ub1, 6), AbstractC24416ya8.b(aVar, interfaceC22053ub1, 6));
                interfaceC22053ub1.Q();
                return a98H;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        /* renamed from: ir.nasim.zt1$b$b, reason: collision with other inner class name */
        static final class C1825b implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC9664aL6 a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ defpackage.t c;
            final /* synthetic */ C19206px3 d;
            final /* synthetic */ String e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ List g;
            final /* synthetic */ InterfaceC14603iB2 h;
            final /* synthetic */ UA2 i;
            final /* synthetic */ SA2 j;
            final /* synthetic */ InterfaceC20315ro1 k;
            final /* synthetic */ String l;
            final /* synthetic */ boolean m;
            final /* synthetic */ boolean n;
            final /* synthetic */ UA2 o;
            final /* synthetic */ UA2 p;
            final /* synthetic */ boolean q;
            final /* synthetic */ boolean r;
            final /* synthetic */ SA2 s;
            final /* synthetic */ C19391qG6 t;
            final /* synthetic */ InterfaceC9102Ym4 u;
            final /* synthetic */ InterfaceC9102Ym4 v;
            final /* synthetic */ String w;
            final /* synthetic */ InterfaceC9102Ym4 x;
            final /* synthetic */ InterfaceC9102Ym4 y;

            /* renamed from: ir.nasim.zt1$b$b$a */
            static final class a implements PointerInputEventHandler {
                final /* synthetic */ defpackage.t a;

                a(defpackage.t tVar) {
                    this.a = tVar;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 e(defpackage.t tVar, ZG4 zg4) {
                    AbstractC13042fc3.i(tVar, "$dragDropState");
                    tVar.f(zg4.t());
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(defpackage.t tVar) {
                    AbstractC13042fc3.i(tVar, "$dragDropState");
                    tVar.e();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 g(defpackage.t tVar) {
                    AbstractC13042fc3.i(tVar, "$dragDropState");
                    tVar.e();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(defpackage.t tVar, C6616Og5 c6616Og5, ZG4 zg4) {
                    AbstractC13042fc3.i(tVar, "$dragDropState");
                    AbstractC13042fc3.i(c6616Og5, "change");
                    c6616Og5.a();
                    tVar.d(zg4.t());
                    return C19938rB7.a;
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                    final defpackage.t tVar = this.a;
                    UA2 ua2 = new UA2() { // from class: ir.nasim.Et1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC25193zt1.b.C1825b.a.e(tVar, (ZG4) obj);
                        }
                    };
                    final defpackage.t tVar2 = this.a;
                    SA2 sa2 = new SA2() { // from class: ir.nasim.Ft1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC25193zt1.b.C1825b.a.f(tVar2);
                        }
                    };
                    final defpackage.t tVar3 = this.a;
                    SA2 sa22 = new SA2() { // from class: ir.nasim.Gt1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC25193zt1.b.C1825b.a.g(tVar3);
                        }
                    };
                    final defpackage.t tVar4 = this.a;
                    Object objG = EZ1.g(interfaceC9049Yg5, ua2, sa2, sa22, new InterfaceC14603iB2() { // from class: ir.nasim.Ht1
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return AbstractC25193zt1.b.C1825b.a.h(tVar4, (C6616Og5) obj, (ZG4) obj2);
                        }
                    }, interfaceC20295rm1);
                    return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$b, reason: collision with other inner class name */
            static final class C1826b implements InterfaceC15796kB2 {
                final /* synthetic */ String a;
                final /* synthetic */ UA2 b;
                final /* synthetic */ InterfaceC9102Ym4 c;

                C1826b(String str, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    this.a = str;
                    this.b = ua2;
                    this.c = interfaceC9102Ym4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(UA2 ua2, String str) {
                    AbstractC13042fc3.i(ua2, "$onQuestionChanged");
                    AbstractC13042fc3.i(str, "it");
                    ua2.invoke(str);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$focusedField$delegate");
                    AbstractC25193zt1.K(interfaceC9102Ym4, AbstractC7195Qr2.c.a);
                    return C19938rB7.a;
                }

                public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    String str = this.a;
                    interfaceC22053ub1.W(-163319576);
                    boolean zV = interfaceC22053ub1.V(this.b);
                    final UA2 ua2 = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.It1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC25193zt1.b.C1825b.C1826b.d(ua2, (String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    UA2 ua22 = (UA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-163315177);
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
                    Object objB2 = interfaceC22053ub1.B();
                    if (objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.Jt1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC25193zt1.b.C1825b.C1826b.f(interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC25193zt1.T(str, ua22, (SA2) objB2, interfaceC22053ub1, 384);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    c((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$c */
            static final class c implements UA2 {
                final /* synthetic */ InterfaceC9102Ym4 a;

                c(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    this.a = interfaceC9102Ym4;
                }

                public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
                    AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
                    C1825b.i(this.a, interfaceC11379cu3.p0(ZG4.b.c()));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((InterfaceC11379cu3) obj);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$d */
            static final class d implements UA2 {
                final /* synthetic */ InterfaceC14603iB2 a;
                final /* synthetic */ int b;

                d(InterfaceC14603iB2 interfaceC14603iB2, int i) {
                    this.a = interfaceC14603iB2;
                    this.b = i;
                }

                public final void a(String str) {
                    AbstractC13042fc3.i(str, "newText");
                    this.a.invoke(Integer.valueOf(this.b), str);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((String) obj);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$e */
            static final class e implements UA2 {
                final /* synthetic */ UA2 a;

                e(UA2 ua2) {
                    this.a = ua2;
                }

                public final void a(int i) {
                    this.a.invoke(Integer.valueOf(i));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a(((Number) obj).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$f */
            static final class f implements UA2 {
                final /* synthetic */ InterfaceC9102Ym4 a;
                final /* synthetic */ InterfaceC9102Ym4 b;

                f(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
                    this.a = interfaceC9102Ym4;
                    this.b = interfaceC9102Ym42;
                }

                public final void a(int i) {
                    AbstractC25193zt1.K(this.a, new AbstractC7195Qr2.a(i));
                    b.h(this.b, null);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a(((Number) obj).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$g */
            static final class g implements InterfaceC15796kB2 {
                final /* synthetic */ List a;
                final /* synthetic */ SA2 b;
                final /* synthetic */ InterfaceC20315ro1 c;
                final /* synthetic */ String d;
                final /* synthetic */ InterfaceC9102Ym4 e;
                final /* synthetic */ C19391qG6 f;

                /* renamed from: ir.nasim.zt1$b$b$g$a */
                static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C19391qG6 c;
                    final /* synthetic */ String d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    a(C19391qG6 c19391qG6, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c19391qG6;
                        this.d = str;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            C19391qG6 c19391qG6 = this.c;
                            String str = this.d;
                            this.b = 1;
                            if (C19391qG6.f(c19391qG6, str, null, false, null, this, 14, null) == objE) {
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

                g(List list, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, String str, InterfaceC9102Ym4 interfaceC9102Ym4, C19391qG6 c19391qG6) {
                    this.a = list;
                    this.b = sa2;
                    this.c = interfaceC20315ro1;
                    this.d = str;
                    this.e = interfaceC9102Ym4;
                    this.f = c19391qG6;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(List list, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, C19391qG6 c19391qG6, String str) {
                    AbstractC13042fc3.i(list, "$answers");
                    AbstractC13042fc3.i(sa2, "$addNewAnswer");
                    AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$lastAddedIndex$delegate");
                    AbstractC13042fc3.i(c19391qG6, "$snackBarHostState");
                    AbstractC13042fc3.i(str, "$pollAnswersLimitExceedsMessage");
                    if (list.size() < 12) {
                        sa2.invoke();
                        b.h(interfaceC9102Ym4, Integer.valueOf(list.size()));
                    } else {
                        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19391qG6, str, null), 3, null);
                    }
                    return C19938rB7.a;
                }

                public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    long jX;
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    interfaceC22053ub1.W(-163240473);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.c) | interfaceC22053ub1.V(this.d);
                    final List list = this.a;
                    final SA2 sa2 = this.b;
                    final InterfaceC20315ro1 interfaceC20315ro1 = this.c;
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.e;
                    final C19391qG6 c19391qG6 = this.f;
                    final String str = this.d;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Kt1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC25193zt1.b.C1825b.g.c(list, sa2, interfaceC20315ro1, interfaceC9102Ym4, c19391qG6, str);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa22 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    if (this.a.size() < 12) {
                        interfaceC22053ub1.W(-764927536);
                        jX = G10.a.a(interfaceC22053ub1, G10.b).I();
                        interfaceC22053ub1.Q();
                    } else {
                        interfaceC22053ub1.W(-764819501);
                        jX = G10.a.a(interfaceC22053ub1, G10.b).x();
                        interfaceC22053ub1.Q();
                    }
                    AbstractC25193zt1.u(null, sa22, jX, interfaceC22053ub1, 0, 1);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$h */
            static final class h implements InterfaceC15796kB2 {
                final /* synthetic */ boolean a;
                final /* synthetic */ boolean b;
                final /* synthetic */ UA2 c;
                final /* synthetic */ UA2 d;
                final /* synthetic */ boolean e;

                h(boolean z, boolean z2, UA2 ua2, UA2 ua22, boolean z3) {
                    this.a = z;
                    this.b = z2;
                    this.c = ua2;
                    this.d = ua22;
                    this.e = z3;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(UA2 ua2, boolean z) {
                    AbstractC13042fc3.i(ua2, "$onIsMultipleChoiceChanged");
                    ua2.invoke(Boolean.valueOf(z));
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(UA2 ua2, boolean z) {
                    AbstractC13042fc3.i(ua2, "$onIsUnknownChanged");
                    ua2.invoke(Boolean.valueOf(z));
                    return C19938rB7.a;
                }

                public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    boolean z = this.a;
                    boolean z2 = this.b;
                    interfaceC22053ub1.W(-163192400);
                    boolean zV = interfaceC22053ub1.V(this.c);
                    final UA2 ua2 = this.c;
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.Lt1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC25193zt1.b.C1825b.h.d(ua2, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    UA2 ua22 = (UA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-163197335);
                    boolean zV2 = interfaceC22053ub1.V(this.d);
                    final UA2 ua23 = this.d;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new UA2() { // from class: ir.nasim.Mt1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC25193zt1.b.C1825b.h.f(ua23, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC25193zt1.X(null, z, z2, ua22, (UA2) objB2, this.e, interfaceC22053ub1, 0, 1);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    c((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$i */
            static final class i implements InterfaceC15796kB2 {
                final /* synthetic */ boolean a;
                final /* synthetic */ SA2 b;

                i(boolean z, SA2 sa2) {
                    this.a = z;
                    this.b = sa2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(boolean z, SA2 sa2) {
                    AbstractC13042fc3.i(sa2, "$onCreatePoll");
                    if (z) {
                        sa2.invoke();
                    }
                    return C19938rB7.a;
                }

                public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(16)), 0.0f, 1, null);
                    InterfaceC19114po0 interfaceC19114po0 = this.a ? OA2.b.C0545b.c : OA2.b.a.c;
                    String strC = UY6.c(DD5.send_poll, interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(-163181306);
                    boolean zA = interfaceC22053ub1.a(this.a) | interfaceC22053ub1.V(this.b);
                    final boolean z = this.a;
                    final SA2 sa2 = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zA || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Nt1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC25193zt1.b.C1825b.i.c(z, sa2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC17932no0.A((SA2) objB, interfaceC19114po0, strC, eVarH, null, null, interfaceC22053ub1, (OA2.b.b << 3) | 27648, 32);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$j */
            static final class j implements InterfaceC15796kB2 {
                final /* synthetic */ String a;
                final /* synthetic */ String b;

                j(String str, String str2) {
                    this.a = str;
                    this.b = str2;
                }

                public final void a(InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC15254jG6, "it");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    String str = this.a;
                    if (str == null) {
                        str = this.b;
                    }
                    AbstractC10984cY.c(str, null, new AbstractC13463gG6.b(AbstractC15208jB5.danger), 0, null, interfaceC22053ub1, AbstractC13463gG6.b.d << 6, 26);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$k */
            static final class k implements InterfaceC14603iB2 {
                final /* synthetic */ SA2 a;
                final /* synthetic */ InterfaceC9102Ym4 b;
                final /* synthetic */ InterfaceC9102Ym4 c;

                k(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
                    this.a = sa2;
                    this.b = interfaceC9102Ym4;
                    this.c = interfaceC9102Ym42;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showDiscardDialog$delegate");
                    AbstractC25193zt1.F(interfaceC9102Ym4, false);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showDiscardDialog$delegate");
                    AbstractC13042fc3.i(interfaceC9102Ym42, "$showBottomSheet$delegate");
                    AbstractC25193zt1.F(interfaceC9102Ym4, false);
                    AbstractC25193zt1.D(interfaceC9102Ym42, false);
                    sa2.invoke();
                    return C19938rB7.a;
                }

                public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
                    AbstractC10289bP1.a.b bVar = AbstractC10289bP1.a.b.a;
                    InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                    String strC = UY6.c(DD5.discard_poll, interfaceC22053ub1, 0);
                    InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                    String strC2 = UY6.c(DD5.dialog_cancel, interfaceC22053ub1, 0);
                    C10710c41 c10710c41 = C10710c41.a;
                    InterfaceC14603iB2 interfaceC14603iB2B = c10710c41.b();
                    InterfaceC14603iB2 interfaceC14603iB2C = c10710c41.c();
                    interfaceC22053ub1.W(-791451961);
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
                    Object objB = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
                    if (objB == aVar2.a()) {
                        objB = new SA2() { // from class: ir.nasim.Ot1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC25193zt1.b.C1825b.k.d(interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-791442325);
                    boolean zV = interfaceC22053ub1.V(this.a);
                    final SA2 sa22 = this.a;
                    final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
                    final InterfaceC9102Ym4 interfaceC9102Ym43 = this.c;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV || objB2 == aVar2.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.Pt1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC25193zt1.b.C1825b.k.f(sa22, interfaceC9102Ym42, interfaceC9102Ym43);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.F(interfaceC14603iB2B, c0905b, interfaceC14603iB2C, bVar, c1454b, sa2, strC2, aVar, (SA2) objB2, strC, null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 196998 | (AbstractC10289bP1.a.b.b << 9) | (InterfaceC19114po0.b.C1454b.b << 12) | (InterfaceC19114po0.b.a.b << 21), 0, 1024);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$l */
            public static final class l implements InterfaceC14603iB2 {
                final /* synthetic */ UA2 a;

                public l(UA2 ua2) {
                    this.a = ua2;
                }

                public final Object a(int i, Object obj) {
                    Object objInvoke;
                    UA2 ua2 = this.a;
                    return (ua2 == null || (objInvoke = ua2.invoke(obj)) == null) ? Integer.valueOf(i) : objInvoke;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return a(((Number) obj).intValue(), obj2);
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$m */
            public static final class m extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ InterfaceC14603iB2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public m(InterfaceC14603iB2 interfaceC14603iB2, List list) {
                    super(1);
                    this.e = interfaceC14603iB2;
                    this.f = list;
                }

                public final Object a(int i) {
                    return this.e.invoke(Integer.valueOf(i), this.f.get(i));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$n */
            public static final class n extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ List e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public n(List list) {
                    super(1);
                    this.e = list;
                }

                public final Object a(int i) {
                    this.e.get(i);
                    return new defpackage.v(i);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.zt1$b$b$o */
            public static final class o extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;
                final /* synthetic */ defpackage.t f;
                final /* synthetic */ List g;
                final /* synthetic */ InterfaceC14603iB2 h;
                final /* synthetic */ UA2 i;
                final /* synthetic */ InterfaceC9102Ym4 j;
                final /* synthetic */ InterfaceC9102Ym4 k;

                /* renamed from: ir.nasim.zt1$b$b$o$a */
                public static final class a implements UA2 {
                    final /* synthetic */ defpackage.t a;

                    public a(defpackage.t tVar) {
                        this.a = tVar;
                    }

                    public final void a(androidx.compose.ui.graphics.c cVar) {
                        AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
                        cVar.e(this.a.a());
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((androidx.compose.ui.graphics.c) obj);
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public o(List list, defpackage.t tVar, List list2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
                    super(4);
                    this.e = list;
                    this.f = tVar;
                    this.g = list2;
                    this.h = interfaceC14603iB2;
                    this.i = ua2;
                    this.j = interfaceC9102Ym4;
                    this.k = interfaceC9102Ym42;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
                    androidx.compose.ui.e eVarA;
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    Object obj = this.e.get(i);
                    int i4 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 14);
                    interfaceC22053ub1.W(1917688087);
                    Integer numB = this.f.b();
                    boolean z = numB != null && i == numB.intValue();
                    interfaceC22053ub1.W(-2016346676);
                    if (z) {
                        androidx.compose.ui.e eVarA2 = Ac8.a(androidx.compose.ui.e.a, 1.0f);
                        interfaceC22053ub1.W(-2016343748);
                        boolean zD = interfaceC22053ub1.D(this.f);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new a(this.f);
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        eVarA = androidx.compose.ui.graphics.b.a(eVarA2, (UA2) objB);
                    } else {
                        eVarA = androidx.compose.ui.e.a;
                    }
                    interfaceC22053ub1.Q();
                    int i5 = i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                    String str = (String) obj;
                    interfaceC22053ub1.W(-767019260);
                    interfaceC22053ub1.W(-163290253);
                    Object objB2 = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                    if (objB2 == aVar.a()) {
                        objB2 = AbstractC13472gH6.d(ZG4.d(ZG4.b.c()), null, 2, null);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-163284035);
                    Object objB3 = interfaceC22053ub1.B();
                    if (objB3 == aVar.a()) {
                        objB3 = new c(interfaceC9102Ym4);
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.ui.layout.c.a(eVarA, (UA2) objB3), 0.0f, C17784nZ1.q(10), 0.0f, 0.0f, 13, null);
                    boolean z2 = this.g.size() > 1;
                    Integer numF = b.f(this.j);
                    boolean z3 = numF != null && numF.intValue() == i;
                    interfaceC22053ub1.W(-163270341);
                    boolean zV = interfaceC22053ub1.V(this.h) | ((((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i4 & 48) == 32);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zV || objB4 == aVar.a()) {
                        objB4 = new d(this.h, i);
                        interfaceC22053ub1.s(objB4);
                    }
                    UA2 ua2 = (UA2) objB4;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-163265167);
                    boolean zV2 = interfaceC22053ub1.V(this.i);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zV2 || objB5 == aVar.a()) {
                        objB5 = new e(this.i);
                        interfaceC22053ub1.s(objB5);
                    }
                    UA2 ua22 = (UA2) objB5;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-163260417);
                    Object objB6 = interfaceC22053ub1.B();
                    if (objB6 == aVar.a()) {
                        objB6 = new f(this.k, this.j);
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC25193zt1.x(i, str, ua2, ua22, (UA2) objB6, eVarM, z2, z3, interfaceC22053ub1, ((i5 >> 3) & 14) | 24576, 0);
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.Q();
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.P();
                    }
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            C1825b(InterfaceC9664aL6 interfaceC9664aL6, SA2 sa2, defpackage.t tVar, C19206px3 c19206px3, String str, UA2 ua2, List list, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, SA2 sa22, InterfaceC20315ro1 interfaceC20315ro1, String str2, boolean z, boolean z2, UA2 ua23, UA2 ua24, boolean z3, boolean z4, SA2 sa23, C19391qG6 c19391qG6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, String str3, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44) {
                this.a = interfaceC9664aL6;
                this.b = sa2;
                this.c = tVar;
                this.d = c19206px3;
                this.e = str;
                this.f = ua2;
                this.g = list;
                this.h = interfaceC14603iB2;
                this.i = ua22;
                this.j = sa22;
                this.k = interfaceC20315ro1;
                this.l = str2;
                this.m = z;
                this.n = z2;
                this.o = ua23;
                this.p = ua24;
                this.q = z3;
                this.r = z4;
                this.s = sa23;
                this.t = c19391qG6;
                this.u = interfaceC9102Ym4;
                this.v = interfaceC9102Ym42;
                this.w = str3;
                this.x = interfaceC9102Ym43;
                this.y = interfaceC9102Ym44;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(List list, defpackage.t tVar, String str, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, InterfaceC9102Ym4 interfaceC9102Ym42, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, String str2, C19391qG6 c19391qG6, boolean z, boolean z2, UA2 ua23, UA2 ua24, boolean z3, boolean z4, SA2 sa22, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(list, "$answers");
                AbstractC13042fc3.i(tVar, "$dragDropState");
                AbstractC13042fc3.i(str, "$question");
                AbstractC13042fc3.i(ua2, "$onQuestionChanged");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$focusedField$delegate");
                AbstractC13042fc3.i(interfaceC14603iB2, "$updateAnswers");
                AbstractC13042fc3.i(ua22, "$onDeleteAnswer");
                AbstractC13042fc3.i(interfaceC9102Ym42, "$lastAddedIndex$delegate");
                AbstractC13042fc3.i(sa2, "$addNewAnswer");
                AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                AbstractC13042fc3.i(str2, "$pollAnswersLimitExceedsMessage");
                AbstractC13042fc3.i(c19391qG6, "$snackBarHostState");
                AbstractC13042fc3.i(ua23, "$onIsMultipleChoiceChanged");
                AbstractC13042fc3.i(ua24, "$onIsUnknownChanged");
                AbstractC13042fc3.i(sa22, "$onCreatePoll");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                C10710c41 c10710c41 = C10710c41.a;
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.a(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.d(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.e(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.f(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1209975016, true, new C1826b(str, ua2, interfaceC9102Ym4)), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.g(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.h(), 3, null);
                interfaceC15069ix3.a(list.size(), new m(new l(null), list), new n(list), AbstractC19242q11.c(-1091073711, true, new o(list, tVar, list, interfaceC14603iB2, ua22, interfaceC9102Ym42, interfaceC9102Ym4)));
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.i(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-765350628, true, new g(list, sa2, interfaceC20315ro1, str2, interfaceC9102Ym42, c19391qG6)), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.j(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, c10710c41.k(), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(2060506200, true, new h(z, z2, ua23, ua24, z3)), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1049563175, true, new i(z4, sa22)), 3, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void i(InterfaceC9102Ym4 interfaceC9102Ym4, long j2) {
                interfaceC9102Ym4.setValue(ZG4.d(j2));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
                AbstractC13042fc3.i(interfaceC9664aL6, "$currentFormIsEmpty$delegate");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$showDiscardDialog$delegate");
                AbstractC13042fc3.i(interfaceC9102Ym42, "$showBottomSheet$delegate");
                if (AbstractC25193zt1.I(interfaceC9664aL6)) {
                    sa2.invoke();
                    AbstractC25193zt1.D(interfaceC9102Ym42, false);
                } else {
                    AbstractC25193zt1.F(interfaceC9102Ym4, true);
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n() {
                return C19938rB7.a;
            }

            public final void f(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                InterfaceC22053ub1 interfaceC22053ub12;
                AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
                if ((i2 & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
                final defpackage.t tVar = this.c;
                C19206px3 c19206px3 = this.d;
                final String str = this.e;
                final UA2 ua2 = this.f;
                final List list = this.g;
                final InterfaceC14603iB2 interfaceC14603iB2 = this.h;
                final UA2 ua22 = this.i;
                final SA2 sa2 = this.j;
                final InterfaceC20315ro1 interfaceC20315ro1 = this.k;
                final String str2 = this.l;
                final boolean z = this.m;
                final boolean z2 = this.n;
                final UA2 ua23 = this.o;
                final UA2 ua24 = this.p;
                final boolean z3 = this.q;
                final boolean z4 = this.r;
                final SA2 sa22 = this.s;
                final C19391qG6 c19391qG6 = this.t;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.u;
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.v;
                String str3 = this.w;
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
                InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), 0.0f, C17784nZ1.q(16), 1, null);
                interfaceC22053ub1.W(-791745996);
                boolean zD = interfaceC22053ub1.D(tVar);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new a(tVar);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarC = AbstractC21071t37.c(eVarK, tVar, (PointerInputEventHandler) objB);
                interfaceC22053ub1.W(-791717795);
                boolean zV = interfaceC22053ub1.V(str) | interfaceC22053ub1.V(ua2) | interfaceC22053ub1.D(list) | interfaceC22053ub1.D(tVar) | interfaceC22053ub1.V(interfaceC14603iB2) | interfaceC22053ub1.V(ua22) | interfaceC22053ub1.V(sa2) | interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.V(str2) | interfaceC22053ub1.a(z) | interfaceC22053ub1.a(z2) | interfaceC22053ub1.V(ua23) | interfaceC22053ub1.V(ua24) | interfaceC22053ub1.a(z3) | interfaceC22053ub1.a(z4) | interfaceC22053ub1.V(sa22);
                Object objB2 = interfaceC22053ub1.B();
                if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Bt1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC25193zt1.b.C1825b.h(list, tVar, str, ua2, interfaceC9102Ym4, interfaceC14603iB2, ua22, interfaceC9102Ym42, sa2, interfaceC20315ro1, str2, c19391qG6, z, z2, ua23, ua24, z3, z4, sa22, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub12 = interfaceC22053ub1;
                    interfaceC22053ub12.s(objB2);
                } else {
                    interfaceC22053ub12 = interfaceC22053ub1;
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarC, c19206px3, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1, 0, 508);
                AbstractC18209oG6.b(c19391qG6, hVar.h(aVar, aVar2.b()), AbstractC19242q11.e(1974679830, true, new j(str3, str2), interfaceC22053ub12, 54), interfaceC22053ub1, 390, 0);
                interfaceC22053ub1.u();
                interfaceC22053ub12.W(178262350);
                boolean zV2 = interfaceC22053ub12.V(this.a) | interfaceC22053ub12.V(this.b);
                final SA2 sa23 = this.b;
                final InterfaceC9664aL6 interfaceC9664aL6 = this.a;
                final InterfaceC9102Ym4 interfaceC9102Ym43 = this.x;
                final InterfaceC9102Ym4 interfaceC9102Ym44 = this.y;
                Object objB3 = interfaceC22053ub1.B();
                if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Ct1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC25193zt1.b.C1825b.k(sa23, interfaceC9664aL6, interfaceC9102Ym43, interfaceC9102Ym44);
                        }
                    };
                    interfaceC22053ub12.s(objB3);
                }
                interfaceC22053ub1.Q();
                UV.a(true, (SA2) objB3, interfaceC22053ub12, 6, 0);
                if (AbstractC25193zt1.E(this.x)) {
                    interfaceC22053ub12.W(178273073);
                    Object objB4 = interfaceC22053ub1.B();
                    if (objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.Dt1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC25193zt1.b.C1825b.n();
                            }
                        };
                        interfaceC22053ub12.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC6687Oo.a((SA2) objB4, null, AbstractC19242q11.e(1338904501, true, new k(this.b, this.x, this.y), interfaceC22053ub12, 54), interfaceC22053ub1, 390, 2);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                f((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        b(InterfaceC9664aL6 interfaceC9664aL6, SA2 sa2, C19818qz6 c19818qz6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, defpackage.t tVar, C19206px3 c19206px3, String str, UA2 ua2, List list, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, SA2 sa22, InterfaceC20315ro1 interfaceC20315ro1, String str2, boolean z, boolean z2, UA2 ua23, UA2 ua24, boolean z3, boolean z4, SA2 sa23, C19391qG6 c19391qG6, InterfaceC9102Ym4 interfaceC9102Ym43, String str3) {
            this.a = interfaceC9664aL6;
            this.b = sa2;
            this.c = c19818qz6;
            this.d = interfaceC9102Ym4;
            this.e = interfaceC9102Ym42;
            this.f = tVar;
            this.g = c19206px3;
            this.h = str;
            this.i = ua2;
            this.j = list;
            this.k = interfaceC14603iB2;
            this.l = ua22;
            this.m = sa22;
            this.n = interfaceC20315ro1;
            this.o = str2;
            this.p = z;
            this.q = z2;
            this.r = ua23;
            this.s = ua24;
            this.t = z3;
            this.u = z4;
            this.v = sa23;
            this.w = c19391qG6;
            this.x = interfaceC9102Ym43;
            this.y = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Integer f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (Integer) interfaceC9102Ym4.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, Integer num) {
            interfaceC9102Ym4.setValue(num);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$currentFormIsEmpty$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$showDiscardDialog$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$showBottomSheet$delegate");
            if (AbstractC25193zt1.I(interfaceC9664aL6)) {
                sa2.invoke();
                AbstractC25193zt1.D(interfaceC9102Ym42, false);
            } else {
                AbstractC25193zt1.F(interfaceC9102Ym4, true);
            }
            return C19938rB7.a;
        }

        public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(607105559);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(null, null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            if (AbstractC25193zt1.P(this.d)) {
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC21393ta8.d(AbstractC24416ya8.f(A98.a, interfaceC22053ub1, 6), interfaceC22053ub1, 0));
                long jM = G10.a.a(interfaceC22053ub1, G10.b).M();
                interfaceC22053ub1.W(607110127);
                boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
                final SA2 sa2 = this.b;
                final InterfaceC9664aL6 interfaceC9664aL6 = this.a;
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.e;
                final InterfaceC9102Ym4 interfaceC9102Ym43 = this.d;
                Object objB2 = interfaceC22053ub1.B();
                if (zV || objB2 == aVar.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.At1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC25193zt1.b.i(sa2, interfaceC9664aL6, interfaceC9102Ym42, interfaceC9102Ym43);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC9273Zf4.a((SA2) objB2, eVarH, this.c, 0.0f, null, jM, 0L, 0.0f, 0L, null, a.a, null, AbstractC19242q11.e(-512651261, true, new C1825b(this.a, this.b, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, interfaceC9102Ym4, this.y, this.e, this.d), interfaceC22053ub1, 54), interfaceC22053ub1, 805306368, 384, 2520);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zt1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ androidx.compose.ui.focus.m d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, androidx.compose.ui.focus.m mVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = mVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c) {
                androidx.compose.ui.focus.m.g(this.d, 0, 1, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zt1$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ int c;

        d(boolean z, UA2 ua2, int i) {
            this.a = z;
            this.b = ua2;
            this.c = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(String str, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(str, "$deleteContentDescription");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.e0(interfaceC11943do6, str);
            AbstractC9939ao6.p0(interfaceC11943do6, B26.b.a());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(UA2 ua2, int i) {
            AbstractC13042fc3.i(ua2, "$onDeleteClick");
            ua2.invoke(Integer.valueOf(i));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(String str, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(str, "$sortContentDescription");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.e0(interfaceC11943do6, str);
            AbstractC9939ao6.p0(interfaceC11943do6, B26.b.a());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n() {
            return C19938rB7.a;
        }

        public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            long jX;
            long jX2;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final String strC = UY6.c(DD5.poll_delete_button_label, interfaceC22053ub1, 0);
            final String strC2 = UY6.c(DD5.poll_sort_button_label, interfaceC22053ub1, 0);
            boolean z = this.a;
            final UA2 ua2 = this.b;
            final int i2 = this.c;
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            C12700f33.b bVar = C12700f33.k;
            C12700f33 c12700f33B = XQ7.b(bVar, AbstractC15208jB5.delete, interfaceC22053ub1, 6);
            String strC3 = UY6.c(DD5.poll_delete_button_label, interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(24));
            interfaceC22053ub1.W(548943239);
            boolean zV = interfaceC22053ub1.V(strC);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Qt1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC25193zt1.d.h(strC, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVarT, false, (UA2) objB, 1, null);
            interfaceC22053ub1.W(548951487);
            boolean zV2 = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.e(i2);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Rt1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC25193zt1.d.i(ua2, i2);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarD, z, null, null, (SA2) objB2, 6, null);
            AbstractC24975zX0.a aVar3 = AbstractC24975zX0.b;
            if (z) {
                interfaceC22053ub1.W(-162173445);
                jX = G10.a.a(interfaceC22053ub1, G10.b).B();
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-162084165);
                jX = G10.a.a(interfaceC22053ub1, G10.b).x();
                interfaceC22053ub1.Q();
            }
            AbstractC11456d23.a(c12700f33B, strC3, eVarF, null, null, 0.0f, AbstractC24975zX0.a.b(aVar3, jX, 0, 2, null), interfaceC22053ub1, 0, 56);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(12)), interfaceC22053ub1, 6);
            C12700f33 c12700f33B2 = XQ7.b(bVar, AbstractC15208jB5.drag_down_up, interfaceC22053ub1, 6);
            String strC4 = UY6.c(DD5.poll_sort_button_label, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(548975557);
            boolean zV3 = interfaceC22053ub1.V(strC2);
            Object objB3 = interfaceC22053ub1.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.St1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC25193zt1.d.k(strC2, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD2 = AbstractC6919Pn6.d(aVar, false, (UA2) objB3, 1, null);
            boolean z2 = 1 <= i2 && i2 < 13;
            interfaceC22053ub1.W(548981294);
            Object objB4 = interfaceC22053ub1.B();
            if (objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.Tt1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC25193zt1.d.n();
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF2 = androidx.compose.foundation.e.f(eVarD2, z2, null, null, (SA2) objB4, 6, null);
            if (z) {
                interfaceC22053ub1.W(-161295525);
                jX2 = G10.a.a(interfaceC22053ub1, G10.b).B();
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-161206245);
                jX2 = G10.a.a(interfaceC22053ub1, G10.b).x();
                interfaceC22053ub1.Q();
            }
            AbstractC11456d23.a(c12700f33B2, strC4, eVarF2, null, null, 0.0f, AbstractC24975zX0.a.b(aVar3, jX2, 0, 2, null), interfaceC22053ub1, 0, 56);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(int i, String str, UA2 ua2, UA2 ua22, UA2 ua23, androidx.compose.ui.e eVar, boolean z, boolean z2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$value");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(ua22, "$onDeleteClick");
        AbstractC13042fc3.i(ua23, "$onFocus");
        x(i, str, ua2, ua22, ua23, eVar, z, z2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:264:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void B(ir.nasim.SA2 r36, ir.nasim.SA2 r37, final androidx.fragment.app.Fragment r38, final ir.nasim.SA2 r39, final boolean r40, final java.util.List r41, final java.lang.String r42, final boolean r43, final boolean r44, final boolean r45, final java.lang.String r46, final ir.nasim.SA2 r47, final ir.nasim.UA2 r48, final ir.nasim.UA2 r49, final ir.nasim.InterfaceC14603iB2 r50, final ir.nasim.UA2 r51, final ir.nasim.UA2 r52, final ir.nasim.InterfaceC14603iB2 r53, final ir.nasim.SA2 r54, final ir.nasim.SA2 r55, ir.nasim.InterfaceC22053ub1 r56, final int r57, final int r58, final int r59) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25193zt1.B(ir.nasim.SA2, ir.nasim.SA2, androidx.fragment.app.Fragment, ir.nasim.SA2, boolean, java.util.List, java.lang.String, boolean, boolean, boolean, java.lang.String, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.iB2, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.iB2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(String str, List list) {
        AbstractC13042fc3.i(str, "$question");
        AbstractC13042fc3.i(list, "$answers");
        if (AbstractC20762sZ6.n0(str)) {
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (!AbstractC20762sZ6.n0((String) it.next())) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static final boolean H(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, EnumC20427rz6 enumC20427rz6) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$currentFormIsEmpty$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$showDiscardDialog$delegate");
        AbstractC13042fc3.i(enumC20427rz6, "newValue");
        boolean z = true;
        if (enumC20427rz6 != EnumC20427rz6.Hidden) {
            return true;
        }
        if (I(interfaceC9664aL6)) {
            D(interfaceC9102Ym4, false);
            sa2.invoke();
            z = false;
        }
        F(interfaceC9102Ym42, z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(InterfaceC9102Ym4 interfaceC9102Ym4, AbstractC7195Qr2 abstractC7195Qr2) {
        interfaceC9102Ym4.setValue(abstractC7195Qr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$onMoveAnswers");
        interfaceC14603iB2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(SA2 sa2, SA2 sa22, Fragment fragment, SA2 sa23, boolean z, List list, String str, boolean z2, boolean z3, boolean z4, String str2, SA2 sa24, UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua23, UA2 ua24, InterfaceC14603iB2 interfaceC14603iB22, SA2 sa25, SA2 sa26, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(sa23, "$onBackspace");
        AbstractC13042fc3.i(list, "$answers");
        AbstractC13042fc3.i(str, "$question");
        AbstractC13042fc3.i(sa24, "$onSnackBarShown");
        AbstractC13042fc3.i(ua2, "$onIsUnknownChanged");
        AbstractC13042fc3.i(ua22, "$onIsMultipleChoiceChanged");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onMoveAnswers");
        AbstractC13042fc3.i(ua23, "$onQuestionChanged");
        AbstractC13042fc3.i(ua24, "$onDeleteAnswer");
        AbstractC13042fc3.i(interfaceC14603iB22, "$updateAnswers");
        AbstractC13042fc3.i(sa25, "$addNewAnswer");
        AbstractC13042fc3.i(sa26, "$onCreatePoll");
        B(sa2, sa22, fragment, sa23, z, list, str, z2, z3, z4, str2, sa24, ua2, ua22, interfaceC14603iB2, ua23, ua24, interfaceC14603iB22, sa25, sa26, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Q(final int r31, final java.lang.String r32, final ir.nasim.UA2 r33, androidx.compose.ui.e r34, final ir.nasim.UA2 r35, final ir.nasim.UA2 r36, final boolean r37, final boolean r38, ir.nasim.InterfaceC22053ub1 r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25193zt1.Q(int, java.lang.String, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.UA2, ir.nasim.UA2, boolean, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R(UA2 ua2, int i, InterfaceC5517Jr2 interfaceC5517Jr2) {
        AbstractC13042fc3.i(ua2, "$onFocus");
        AbstractC13042fc3.i(interfaceC5517Jr2, "focusState");
        ua2.invoke(Integer.valueOf(i));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S(int i, String str, UA2 ua2, androidx.compose.ui.e eVar, UA2 ua22, UA2 ua23, boolean z, boolean z2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$value");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(ua22, "$onDeleteClick");
        AbstractC13042fc3.i(ua23, "$onFocus");
        Q(i, str, ua2, eVar, ua22, ua23, z, z2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void T(final String str, final UA2 ua2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "value");
        AbstractC13042fc3.i(ua2, "onValueChanged");
        AbstractC13042fc3.i(sa2, "onFocus");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1634604024);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(1277602019);
            AbstractC14472hy4 aVar = str.length() > 255 ? new AbstractC14472hy4.a(Integer.valueOf(AbstractC15208jB5.danger), UY6.c(DD5.poll_question_limit_exceeded, interfaceC22053ub1J, 0), 255) : new AbstractC14472hy4.d(null, null, 255, 3, null);
            interfaceC22053ub1J.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar2);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strC = UY6.c(DD5.question, interfaceC22053ub1J, 0);
            String strC2 = UY6.c(DD5.writing_question_hint, interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar2, C17784nZ1.q(8), 0.0f, 2, null), 0.0f, 1, null);
            interfaceC22053ub1J.W(666950293);
            boolean z = (i3 & 896) == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.jt1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC25193zt1.U(sa2, (InterfaceC5517Jr2) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.focus.b.a(eVarH, (UA2) objB);
            InterfaceC7614Sl7 interfaceC7614Sl7A = AbstractC19798qx4.a(G10.a.a(interfaceC22053ub1J, G10.b).M(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, interfaceC22053ub1J, 0, 0, 4094);
            interfaceC22053ub1J.W(666937640);
            boolean z2 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.kt1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC25193zt1.V(ua2, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC8426Vx4.e0(str, (UA2) objB2, strC, strC2, eVarA, null, false, false, null, null, aVar, null, null, false, 1, 0, null, interfaceC7614Sl7A, false, false, null, false, interfaceC22053ub12, i3 & 14, AbstractC14472hy4.a | 27648, 0, 4037600);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.lt1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25193zt1.W(str, ua2, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U(SA2 sa2, InterfaceC5517Jr2 interfaceC5517Jr2) {
        AbstractC13042fc3.i(sa2, "$onFocus");
        AbstractC13042fc3.i(interfaceC5517Jr2, "focusState");
        if (interfaceC5517Jr2.a()) {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V(UA2 ua2, String str) {
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        if (str.length() <= 256) {
            ua2.invoke(str);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W(String str, UA2 ua2, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$value");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(sa2, "$onFocus");
        T(str, ua2, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void X(androidx.compose.ui.e eVar, final boolean z, final boolean z2, final UA2 ua2, final UA2 ua22, final boolean z3, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        int i4;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(ua2, "onMultipleChoiceClicked");
        AbstractC13042fc3.i(ua22, "onUnknownClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1208391162);
        if ((i2 & 2) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.a(z2) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(ua22) ? 16384 : 8192;
        }
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            i3 |= interfaceC22053ub1J.a(z3) ? 131072 : 65536;
        }
        int i5 = i3;
        if ((74897 & i5) == 74896 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
        } else {
            androidx.compose.ui.e eVar3 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(-1590942144);
            if (z3) {
                i4 = 0;
                Z(null, z2, ua22, UY6.c(DD5.unknown_poll, interfaceC22053ub1J, 0), AbstractC15208jB5.incognito, interfaceC22053ub1J, ((i5 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i5 >> 6) & 896), 1);
            } else {
                i4 = 0;
            }
            interfaceC22053ub1J.Q();
            Z(null, z, ua2, UY6.c(DD5.poll_multy_choice, interfaceC22053ub1J, i4), AbstractC15208jB5.multiple_choice, interfaceC22053ub1J, (i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i5 >> 3) & 896), 1);
            interfaceC22053ub1J.u();
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ot1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25193zt1.Y(eVar2, z, z2, ua2, ua22, z3, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y(androidx.compose.ui.e eVar, boolean z, boolean z2, UA2 ua2, UA2 ua22, boolean z3, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$onMultipleChoiceClicked");
        AbstractC13042fc3.i(ua22, "$onUnknownClicked");
        X(eVar, z, z2, ua2, ua22, z3, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void Z(androidx.compose.ui.e eVar, final boolean z, final UA2 ua2, final String str, final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub12;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(ua2, "onCheckedChange");
        AbstractC13042fc3.i(str, "title");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1398241020);
        if ((i3 & 2) != 0) {
            i4 = i2 | 48;
        } else if ((i2 & 48) == 0) {
            i4 = (interfaceC22053ub1J.a(z) ? 32 : 16) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 16384 : 8192;
        }
        int i5 = i4;
        if ((i5 & 9361) == 9360 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVar3 = (i3 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC24074y00.e(str, new C10(z, ua2, false, false, 12, null), null, Integer.valueOf(i), null, true, G10.a.a(interfaceC22053ub1J, G10.b).M(), interfaceC22053ub12, ((i5 >> 9) & 14) | 196608 | (C10.e << 3) | ((i5 >> 3) & 7168), 20);
            MY2.b(null, null, 0L, interfaceC22053ub12, 0, 7);
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.pt1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25193zt1.a0(eVar2, z, ua2, str, i, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a0(androidx.compose.ui.e eVar, boolean z, UA2 ua2, String str, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(ua2, "$onCheckedChange");
        AbstractC13042fc3.i(str, "$title");
        Z(eVar, z, ua2, str, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1485522630);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), bVarG, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(4)), C17784nZ1.q(44)), N46.d(C17784nZ1.q(16)));
            EnumC10352bW1 enumC10352bW1 = EnumC10352bW1.c;
            G10 g10 = G10.a;
            int i2 = G10.b;
            MY2.b(eVarA, enumC10352bW1, g10.a(interfaceC22053ub1J, i2).E(), interfaceC22053ub1J, 48, 0);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(10)), interfaceC22053ub1J, 6);
            AbstractC9339Zm7.b(UY6.c(DD5.send_poll, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1J, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i2).l(), interfaceC22053ub1J, 48, 0, 65016);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.gt1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25193zt1.c0(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c0(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        b0(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(androidx.compose.ui.e eVar, final SA2 sa2, final long j, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        androidx.compose.ui.e eVar2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1193899456);
        if ((i2 & 2) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = (interfaceC22053ub1J.D(sa2) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.f(j) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
        } else {
            eVar2 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(aVar, C17784nZ1.q(12), 0.0f, 2, null);
            interfaceC22053ub1J.W(-1185589298);
            boolean z = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.ht1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC25193zt1.v(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarE = SP6.E(eVarK, (SA2) objB);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarE);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE2, aVar2.f());
            M66 m66 = M66.a;
            AbstractC11456d23.a(XQ7.b(C12700f33.k, AbstractC15208jB5.plus_add, interfaceC22053ub1J, 6), "", androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(24)), null, null, 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, j, 0, 2, null), interfaceC22053ub1J, 432, 56);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(8)), interfaceC22053ub1J, 6);
            AbstractC9339Zm7.b(UY6.c(DD5.add_poll_choice, interfaceC22053ub1J, 0), null, j, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1J, G10.b).a(), interfaceC22053ub1J, i3 & 896, 0, 65530);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            final androidx.compose.ui.e eVar3 = eVar2;
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.it1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25193zt1.w(eVar3, sa2, j, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(androidx.compose.ui.e eVar, SA2 sa2, long j, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onClick");
        u(eVar, sa2, j, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void x(final int r22, final java.lang.String r23, final ir.nasim.UA2 r24, final ir.nasim.UA2 r25, final ir.nasim.UA2 r26, androidx.compose.ui.e r27, final boolean r28, final boolean r29, ir.nasim.InterfaceC22053ub1 r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25193zt1.x(int, java.lang.String, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.UA2, androidx.compose.ui.e, boolean, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(UA2 ua2, String str) {
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(str, "newText");
        ua2.invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(UA2 ua2, int i) {
        AbstractC13042fc3.i(ua2, "$onDeleteClick");
        ua2.invoke(Integer.valueOf(i));
        return C19938rB7.a;
    }
}
