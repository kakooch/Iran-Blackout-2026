package ir.nasim;

import android.content.Context;
import android.view.View;
import com.google.android.exoplayer2.InterfaceC2037k;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C11840de2;
import ir.nasim.C14330hk2;
import ir.nasim.C6918Pn5;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Kj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5679Kj2 extends VW7 {
    private static final a T0 = new a(null);
    public static final int U0 = 8;
    private final C11840de2 A;
    private final InterfaceC9336Zm4 A0;
    private final C6918Pn5 B;
    private final InterfaceC10258bL6 B0;
    private final InterfaceC9336Zm4 C0;
    private final InterfaceC3570Bk5 D;
    private final InterfaceC9336Zm4 D0;
    private C14330hk2.EnumC14332b E0;
    private final C11863dg5 F0;
    private final InterfaceC2037k G;
    private final InterfaceC10258bL6 G0;
    private final InterfaceC9336Zm4 H;
    private final InterfaceC4557Fq2 H0;
    private final InterfaceC9336Zm4 I0;
    private final InterfaceC10258bL6 J;
    private final InterfaceC9336Zm4 J0;
    private final InterfaceC9336Zm4 K0;
    private final InterfaceC10258bL6 L0;
    private final InterfaceC9173Yu3 M0;
    private final InterfaceC10258bL6 N0;
    private InterfaceC13730gj3 O0;
    private final Map P0;
    private final InterfaceC19699qn4 Q0;
    private boolean R0;
    private KK S0;
    private final InterfaceC9336Zm4 Y;
    private final InterfaceC10258bL6 Z;
    private final C3558Bj2 b;
    private final C10299bQ2 c;
    private final E84 d;
    private final C24314yP5 e;
    private final C11590dG3 f;
    private final C15842kG3 g;
    private final C6181Mn1 h;
    private final C4309Eo6 i;
    private final SettingsModule j;
    private final InterfaceC15271jI5 k;
    private final C18206oG3 l;
    private final int m;
    private final AbstractC13778go1 n;
    private final AbstractC13778go1 o;
    private final C12349eT2 p;
    private final C24440yd2 q;
    private final XA6 r;
    private final C23300wh2 s;
    private final C14970in2 t;
    private final F84 u;
    private final C24978zX3 v;
    private final C16575lW1 w;
    private final MF3 x;
    private final C15629ju1 y;
    private final InterfaceC20315ro1 z;
    private final InterfaceC4557Fq2 z0;

    /* renamed from: ir.nasim.Kj2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Kj2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14697iL2 c;
        final /* synthetic */ C5886Lg2 d;
        final /* synthetic */ C5679Kj2 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ WH5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, C5679Kj2 c5679Kj2, boolean z, String str, WH5 wh5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c14697iL2;
            this.d = c5886Lg2;
            this.e = c5679Kj2;
            this.f = z;
            this.g = str;
            this.h = wh5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.e.f.b(new C8755Xe4(this.c.I0().getPeerId(), this.d.e(), this.d.m(), 0, 8, null), this.f, this.d.k(), this.g);
                InterfaceC15271jI5 interfaceC15271jI5 = this.e.k;
                String str = this.g;
                C11458d25 c11458d25I0 = this.c.I0();
                AbstractC13042fc3.h(c11458d25I0, "peer(...)");
                long jM = this.d.m();
                long jE = this.d.e();
                this.b = 1;
                if (interfaceC15271jI5.c(str, c11458d25I0, jM, jE, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            C5679Kj2.f2(this.e, this.c.I0().getPeerId(), K5.f, null, this.g, this.h, this.d, 4, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C6119Mg2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C6119Mg2 c6119Mg2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c6119Mg2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.c.G();
                C6119Mg2 c6119Mg2 = this.c;
                NT4 nt4A = NT4.e.a();
                this.b = 1;
                if (c6119Mg2.L(nt4A, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$d */
    public static final class d implements InterfaceC8091Um2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ UA2 c;

        d(UA2 ua2, UA2 ua22, UA2 ua23) {
            this.a = ua2;
            this.b = ua22;
            this.c = ua23;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            this.a.invoke(Float.valueOf(f));
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.b.invoke(interfaceC3346Am2);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void g(DX1 dx1) {
            super.g(dx1);
            this.c.invoke(dx1);
        }
    }

    /* renamed from: ir.nasim.Kj2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C8755Xe4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C8755Xe4 c8755Xe4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c8755Xe4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5679Kj2.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C3558Bj2 c3558Bj2 = C5679Kj2.this.b;
                C8755Xe4 c8755Xe4 = this.d;
                this.b = 1;
                obj = c3558Bj2.p(c8755Xe4, this);
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
            if (list != null) {
                C5679Kj2.this.C0.setValue(list);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5679Kj2.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC9336Zm4 interfaceC9336Zm4;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm42 = C5679Kj2.this.A0;
                MF3 mf3 = C5679Kj2.this.x;
                this.b = interfaceC9336Zm42;
                this.c = 1;
                Object objA = mf3.a(this);
                if (objA == objE) {
                    return objE;
                }
                interfaceC9336Zm4 = interfaceC9336Zm42;
                obj = objA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC9336Zm4 = (InterfaceC9336Zm4) this.b;
                AbstractC10685c16.b(obj);
            }
            interfaceC9336Zm4.setValue(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ long e;
        final /* synthetic */ C8755Xe4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C11458d25 c11458d25, long j, C8755Xe4 c8755Xe4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = j;
            this.f = c8755Xe4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5679Kj2.this.new g(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11590dG3 c11590dG3 = C5679Kj2.this.f;
                C11458d25 c11458d25 = this.d;
                long j = this.e;
                C8755Xe4 c8755Xe4 = this.f;
                this.b = 1;
                if (c11590dG3.d(c11458d25, j, c8755Xe4, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ C8755Xe4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i, C8755Xe4 c8755Xe4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = c8755Xe4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5679Kj2.this.new h(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15842kG3 c15842kG3 = C5679Kj2.this.g;
                int i2 = this.d;
                C8755Xe4 c8755Xe4 = this.e;
                this.b = 1;
                if (c15842kG3.e(i2, c8755Xe4, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AbstractC15520jj2.h e;
        final /* synthetic */ View f;

        /* renamed from: ir.nasim.Kj2$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C5679Kj2 c;
            final /* synthetic */ AbstractC15520jj2.h d;
            final /* synthetic */ View e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C5679Kj2 c5679Kj2, AbstractC15520jj2.h hVar, View view, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c5679Kj2;
                this.d = hVar;
                this.e = view;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C18206oG3 c18206oG3 = this.c.l;
                    FileReference fileReferenceD = this.d.d();
                    String strI = this.d.i();
                    this.b = 1;
                    obj = c18206oG3.d(fileReferenceD, strI, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        C19406qI3.g("FeedViewModel", "video player prepared", new Object[0]);
                        this.c.p.a(new WeakReference(this.e));
                        return C19938rB7.a;
                    }
                    AbstractC10685c16.b(obj);
                }
                InterfaceC14190hV7 interfaceC14190hV7 = (InterfaceC14190hV7) obj;
                C19406qI3.g("FeedViewModel", "video source loaded", new Object[0]);
                C6918Pn5 c6918Pn5 = this.c.B;
                InterfaceC2037k interfaceC2037kZ1 = this.c.z1();
                this.b = 2;
                if (C6918Pn5.h(c6918Pn5, null, interfaceC14190hV7, interfaceC2037kZ1, this, 1, null) == objE) {
                    return objE;
                }
                C19406qI3.g("FeedViewModel", "video player prepared", new Object[0]);
                this.c.p.a(new WeakReference(this.e));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AbstractC15520jj2.h hVar, View view, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = hVar;
            this.f = view;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = C5679Kj2.this.new i(this.e, this.f, interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            InterfaceC20315ro1 interfaceC20315ro12;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro13 = (InterfaceC20315ro1) this.c;
                C5679Kj2.this.z1().i0();
                C5679Kj2.this.z1().x(0L);
                C19406qI3.g("FeedViewModel", "loadVideo", new Object[0]);
                InterfaceC13730gj3 interfaceC13730gj3 = C5679Kj2.this.O0;
                if (interfaceC13730gj3 == null) {
                    interfaceC20315ro1 = interfaceC20315ro13;
                    C19406qI3.g("FeedViewModel", "previous job cancelled", new Object[0]);
                    C5679Kj2 c5679Kj2 = C5679Kj2.this;
                    c5679Kj2.O0 = AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c5679Kj2, this.e, this.f, null), 3, null);
                    return C19938rB7.a;
                }
                this.c = interfaceC20315ro13;
                this.b = 1;
                if (AbstractC19067pj3.g(interfaceC13730gj3, this) == objE) {
                    return objE;
                }
                interfaceC20315ro12 = interfaceC20315ro13;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
            }
            interfaceC20315ro1 = interfaceC20315ro12;
            C19406qI3.g("FeedViewModel", "previous job cancelled", new Object[0]);
            C5679Kj2 c5679Kj22 = C5679Kj2.this;
            c5679Kj22.O0 = AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c5679Kj22, this.e, this.f, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        int e;
        final /* synthetic */ C4743Gj2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C4743Gj2 c4743Gj2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = c4743Gj2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5679Kj2.this.new j(this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5679Kj2.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14697iL2 c;
        final /* synthetic */ C5886Lg2 d;
        final /* synthetic */ C5679Kj2 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ WH5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, C5679Kj2 c5679Kj2, boolean z, String str, WH5 wh5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c14697iL2;
            this.d = c5886Lg2;
            this.e = c5679Kj2;
            this.f = z;
            this.g = str;
            this.h = wh5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new k(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.e.f.b(new C8755Xe4(this.c.I0().getPeerId(), this.d.e(), this.d.m(), 0, 8, null), this.f, this.d.k(), this.g);
                InterfaceC15271jI5 interfaceC15271jI5 = this.e.k;
                String str = this.g;
                C11458d25 c11458d25I0 = this.c.I0();
                AbstractC13042fc3.h(c11458d25I0, "peer(...)");
                long jM = this.d.m();
                long jE = this.d.e();
                this.b = 1;
                if (interfaceC15271jI5.d(str, c11458d25I0, jM, jE, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            C5679Kj2.f2(this.e, this.c.I0().getPeerId(), K5.g, null, this.g, this.h, this.d, 4, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ String e;
        final /* synthetic */ OP5 f;
        final /* synthetic */ List g;

        /* renamed from: ir.nasim.Kj2$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C5679Kj2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C5679Kj2 c5679Kj2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c5679Kj2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((C9475a16) obj).l(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                int i = C9475a16.j(((C9475a16) this.c).l()) ? ID5.report_sent_success : ID5.report_sent_failure;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.I0;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC6392Nk0.d(i)));
                return C19938rB7.a;
            }

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(C9475a16.a(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(C11458d25 c11458d25, String str, OP5 op5, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = str;
            this.f = op5;
            this.g = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5679Kj2.this.new l(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24314yP5 c24314yP5 = C5679Kj2.this.e;
                ExPeer exPeer = new ExPeer(ExPeerType.CHANNEL, this.d.getPeerId());
                String str = this.e;
                OP5 op5 = this.f;
                List<J44> list = this.g;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (J44 j44 : list) {
                    arrayList.add(new Q64(j44.h(), j44.i()));
                }
                InterfaceC4557Fq2 interfaceC4557Fq2A = c24314yP5.a(exPeer, str, op5, arrayList);
                a aVar = new a(C5679Kj2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, aVar, this) == objE) {
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$m */
    public static final class m extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C5679Kj2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(InterfaceC20295rm1 interfaceC20295rm1, C5679Kj2 c5679Kj2) {
            super(3, interfaceC20295rm1);
            this.e = c5679Kj2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2G = this.e.b.g(((Number) this.d).intValue());
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2G, this) == objE) {
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
            m mVar = new m(interfaceC20295rm1, this.e);
            mVar.c = interfaceC4806Gq2;
            mVar.d = obj;
            return mVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kj2$n */
    static final class n extends AbstractC19859r37 implements InterfaceC18160oB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ boolean e;
        /* synthetic */ boolean f;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(5, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            NT4 nt4 = (NT4) this.c;
            Integer num = (Integer) this.d;
            return new C4977Hj2(nt4, this.f, this.e, num);
        }

        public final Object n(NT4 nt4, Integer num, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = new n(interfaceC20295rm1);
            nVar.c = nt4;
            nVar.d = num;
            nVar.e = z;
            nVar.f = z2;
            return nVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC18160oB2
        public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return n((NT4) obj, (Integer) obj2, ((Boolean) obj3).booleanValue(), ((Boolean) obj4).booleanValue(), (InterfaceC20295rm1) obj5);
        }
    }

    public C5679Kj2(C3558Bj2 c3558Bj2, C10299bQ2 c10299bQ2, E84 e84, C24314yP5 c24314yP5, C11590dG3 c11590dG3, C15842kG3 c15842kG3, C6918Pn5.a aVar, C6181Mn1 c6181Mn1, C4309Eo6 c4309Eo6, SettingsModule settingsModule, InterfaceC15271jI5 interfaceC15271jI5, C18206oG3 c18206oG3, SF2 sf2, int i2, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C12349eT2 c12349eT2, C24440yd2 c24440yd2, C19110pn6 c19110pn6, XA6 xa6, C23300wh2 c23300wh2, C14970in2 c14970in2, F84 f84, C24978zX3 c24978zX3, C11840de2.c cVar, C16575lW1 c16575lW1, MF3 mf3, C15629ju1 c15629ju1) {
        AbstractC13042fc3.i(c3558Bj2, "feedRepository");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c24314yP5, "reportMessagesUseCase");
        AbstractC13042fc3.i(c11590dG3, "loadReactionUseCase");
        AbstractC13042fc3.i(c15842kG3, "loadSuggesterUseCase");
        AbstractC13042fc3.i(aVar, "prepareVideoPlayerUseCaseFactory");
        AbstractC13042fc3.i(c6181Mn1, "copyMessageToClipboardUseCase");
        AbstractC13042fc3.i(c4309Eo6, "sendTrafficUsageEventUseCase");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC15271jI5, "reactionsRepository");
        AbstractC13042fc3.i(c18206oG3, "loadVideoSource");
        AbstractC13042fc3.i(sf2, "getFeedUiDataUseCase");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(c12349eT2, "handleFeedPlayerErrorUseCase");
        AbstractC13042fc3.i(c24440yd2, "exoAnalytics");
        AbstractC13042fc3.i(c19110pn6, "selectedTabFlowProvider");
        AbstractC13042fc3.i(xa6, "shouldRefreshFeedUseCase");
        AbstractC13042fc3.i(c23300wh2, "feedEventHandler");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(f84, "messageRepository");
        AbstractC13042fc3.i(c24978zX3, "mediaMessageToAbsContentMapper");
        AbstractC13042fc3.i(cVar, "exoPreloadUseCaseFactory");
        AbstractC13042fc3.i(c16575lW1, "doAdvancedForwardUseCase");
        AbstractC13042fc3.i(mf3, "loadCategoryUseCase");
        AbstractC13042fc3.i(c15629ju1, "createPostLinkUseCase");
        this.b = c3558Bj2;
        this.c = c10299bQ2;
        this.d = e84;
        this.e = c24314yP5;
        this.f = c11590dG3;
        this.g = c15842kG3;
        this.h = c6181Mn1;
        this.i = c4309Eo6;
        this.j = settingsModule;
        this.k = interfaceC15271jI5;
        this.l = c18206oG3;
        this.m = i2;
        this.n = abstractC13778go1;
        this.o = abstractC13778go12;
        this.p = c12349eT2;
        this.q = c24440yd2;
        this.r = xa6;
        this.s = c23300wh2;
        this.t = c14970in2;
        this.u = f84;
        this.v = c24978zX3;
        this.w = c16575lW1;
        this.x = mf3;
        this.y = c15629ju1;
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(abstractC13778go1);
        this.z = interfaceC20315ro1A;
        this.A = cVar.a(interfaceC20315ro1A);
        this.B = aVar.a(EnumC8893Xt7.e);
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.k);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        this.D = interfaceC3570Bk5Q;
        com.google.android.exoplayer2.E0 e0C = C24480yh2.a.c();
        this.G = e0C;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(0);
        this.H = interfaceC9336Zm4A;
        this.J = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(0);
        this.Y = interfaceC9336Zm4A2;
        this.Z = interfaceC9336Zm4A2;
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC9395Zt0.a(AbstractC6459Nq2.s0(interfaceC9336Zm4A, new m(null, this)), AbstractC9773aX7.a(this));
        this.z0 = interfaceC4557Fq2A;
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.A0 = interfaceC9336Zm4A3;
        this.B0 = interfaceC9336Zm4A3;
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.C0 = interfaceC9336Zm4A4;
        this.D0 = interfaceC9336Zm4A4;
        this.E0 = C14330hk2.EnumC14332b.a;
        C11863dg5 c11863dg5B1 = B1(e0C);
        this.F0 = c11863dg5B1;
        InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(new C12475eg5(e0C, c11863dg5B1).d(), abstractC13778go12);
        InterfaceC20315ro1 interfaceC20315ro1A2 = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar2 = InterfaceC16863lz6.a;
        this.G0 = AbstractC6459Nq2.o0(interfaceC4557Fq2V, interfaceC20315ro1A2, aVar2.d(), c11863dg5B1);
        o2();
        Q1();
        this.H0 = c19110pn6.a();
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(null);
        this.I0 = interfaceC9336Zm4A5;
        Boolean bool = Boolean.FALSE;
        InterfaceC9336Zm4 interfaceC9336Zm4A6 = AbstractC12281eL6.a(bool);
        this.J0 = interfaceC9336Zm4A6;
        InterfaceC9336Zm4 interfaceC9336Zm4A7 = AbstractC12281eL6.a(bool);
        this.K0 = interfaceC9336Zm4A7;
        this.L0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.n(sf2.b(interfaceC4557Fq2A), interfaceC9336Zm4A5, interfaceC9336Zm4A6, interfaceC9336Zm4A7, new n(null)), AbstractC9773aX7.a(this), aVar2.d(), C4977Hj2.e.a());
        this.M0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Jj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C5679Kj2.R0();
            }
        });
        this.N0 = AbstractC6459Nq2.c(N1());
        this.P0 = new LinkedHashMap();
        this.Q0 = AbstractC20899sn4.b(false, 1, null);
        this.S0 = new KK(3, AbstractC9773aX7.a(this));
    }

    private final C11863dg5 B1(InterfaceC2037k interfaceC2037k) {
        return new C11863dg5(interfaceC2037k.i(), !interfaceC2037k.X(), interfaceC2037k.p(), interfaceC2037k.a(), 0.0f, interfaceC2037k.D0(), false);
    }

    private final InterfaceC9336Zm4 N1() {
        return (InterfaceC9336Zm4) this.M0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9336Zm4 R0() {
        return AbstractC12281eL6.a(new C22315v17(false));
    }

    public static /* synthetic */ void f2(C5679Kj2 c5679Kj2, int i2, K5 k5, XH6 xh6, String str, WH5 wh5, C5886Lg2 c5886Lg2, int i3, Object obj) {
        c5679Kj2.e2(i2, k5, (i3 & 4) != 0 ? null : xh6, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : wh5, c5886Lg2);
    }

    private final void o2() {
        this.G.E(this.q);
    }

    public static /* synthetic */ void u1(C5679Kj2 c5679Kj2, C11458d25 c11458d25, List list, Context context, boolean z, UA2 ua2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            ua2 = null;
        }
        c5679Kj2.t1(c11458d25, list, context, z2, ua2);
    }

    public final C14970in2 A1() {
        return this.t;
    }

    public final C24978zX3 C1() {
        return this.v;
    }

    public final int D1() {
        return this.m;
    }

    public final InterfaceC10258bL6 E1() {
        return this.G0;
    }

    public final InterfaceC10258bL6 F1() {
        return this.Z;
    }

    public final InterfaceC4557Fq2 G1() {
        return this.H0;
    }

    public final void H1(C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c8755Xe4, "currentMid");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new e(c8755Xe4, null), 2, null);
    }

    public final InterfaceC9336Zm4 I1() {
        return this.D0;
    }

    public final InterfaceC4557Fq2 J1(boolean z, int i2, long j2, long j3) {
        return AbstractC9395Zt0.a(this.b.k(z, i2, j2, j3), AbstractC9773aX7.a(this));
    }

    public final boolean K1() {
        return this.j.r4();
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        super.L0();
        KK kk = this.S0;
        if (kk != null) {
            kk.f();
        }
        this.S0 = null;
        this.P0.clear();
    }

    public final InterfaceC10258bL6 L1() {
        return this.N0;
    }

    public final InterfaceC10258bL6 M1() {
        return this.L0;
    }

    public final void O1() {
        this.D.g("KEY_PRE_IS_USER_LONG_TOUCH", true);
    }

    public final void P1(C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(xh6, "sourceType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        C19406qI3.a("Source_Join_Cause", "feed joinPublicGroup()", new Object[0]);
        this.c.q2(c11458d25);
        f2(this, c11458d25.getPeerId(), K5.d, xh6, null, null, c5886Lg2, 24, null);
    }

    public final void Q1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new f(null), 2, null);
    }

    public final void R1(C11458d25 c11458d25, long j2, C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c8755Xe4, "mid");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.n, null, new g(c11458d25, j2, c8755Xe4, null), 2, null);
    }

    public final void S1(int i2, C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c8755Xe4, "mid");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.n, null, new h(i2, c8755Xe4, null), 2, null);
    }

    public final InterfaceC13730gj3 T1(AbstractC15520jj2.h hVar, View view) {
        AbstractC13042fc3.i(hVar, "videoFeed");
        AbstractC13042fc3.i(view, "videoSurface");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(hVar, view, null), 3, null);
    }

    public final void U1(C8755Xe4 c8755Xe4, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c8755Xe4, "itemMid");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        f2(this, c8755Xe4.b(), K5.l, null, null, null, c5886Lg2, 28, null);
    }

    public final void V1(C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(c4743Gj2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(c4743Gj2, null), 3, null);
    }

    public final void W1(C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(xh6, "sourceType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        C18987pb3.x1(C18987pb3.a, c11458d25, Long.valueOf(c5886Lg2.m()), Long.valueOf(c5886Lg2.e()), false, null, "feed", false, null, null, false, null, 1984, null);
        f2(this, c11458d25.getPeerId(), K5.c, xh6, null, null, c5886Lg2, 24, null);
    }

    public final InterfaceC13730gj3 X1(AbstractC15520jj2.h hVar) {
        AbstractC13042fc3.i(hVar, "videoFeed");
        if (!C8386Vt0.a.Q3()) {
            return null;
        }
        InterfaceC13730gj3 interfaceC13730gj3J = this.A.j(hVar.d().getFileId(), hVar.d().getAccessHash(), hVar.d().getFileSize(), 750L);
        KK kk = this.S0;
        if (kk != null) {
            kk.e(interfaceC13730gj3J);
        }
        return interfaceC13730gj3J;
    }

    public final void Y1(String str, C14697iL2 c14697iL2, boolean z, WH5 wh5, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(str, "reactionCode");
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(wh5, "reactionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.n, null, new k(c14697iL2, c5886Lg2, this, z, str, wh5, null), 2, null);
    }

    public final void Z1(C11458d25 c11458d25, String str, OP5 op5, List list, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(op5, "reportType");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l(c11458d25, str, op5, list, null), 3, null);
        f2(this, c11458d25.getPeerId(), K5.k, XH6.a, null, null, c5886Lg2, 24, null);
    }

    public final void a2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.I0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void c2(C11458d25 c11458d25, J44 j44, C5886Lg2 c5886Lg2) {
        Object value;
        AbstractC13042fc3.i(c11458d25, "fromPeer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c5886Lg2, "feed");
        C11458d25 c11458d25E = C11458d25.E(this.m);
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        this.d.x0(c11458d25E, c11458d25, j44);
        f2(this, c11458d25.getPeerId(), K5.h, XH6.a, null, null, c5886Lg2, 24, null);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.I0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(ID5.saved_message_success_message)));
    }

    public final void d2(int i2) {
        this.s.d(i2, ((Number) this.H.getValue()).intValue());
    }

    public final void e2(int i2, K5 k5, XH6 xh6, String str, WH5 wh5, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(k5, "actionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        this.s.c(i2, k5, xh6, str, wh5, c5886Lg2, ((Number) this.J.getValue()).intValue());
    }

    public final void g2(int i2, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        this.s.g(i2, null, null, c5886Lg2, ((Number) this.H.getValue()).intValue());
    }

    public final void h2(int i2, int i3, int i4, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        this.s.f(i2, Integer.valueOf(i3), Integer.valueOf(i4), c5886Lg2, ((Number) this.H.getValue()).intValue());
    }

    public final void i2(long j2) {
        this.s.h(j2);
    }

    public final void j2(long j2, String str, long j3, long j4) {
        AbstractC13042fc3.i(str, "mimeType");
        this.i.a(j2, EnumC8893Xt7.e, j3, j4, str);
    }

    public final void k1(String str, C14697iL2 c14697iL2, boolean z, WH5 wh5, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(str, "reactionCode");
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(wh5, "reactionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.n, null, new b(c14697iL2, c5886Lg2, this, z, str, wh5, null), 2, null);
    }

    public final void k2(int i2) {
        this.H.setValue(Integer.valueOf(i2));
    }

    public final boolean l1() {
        return !this.D.h("KEY_PRE_IS_USER_LONG_TOUCH", false) && this.D.getInt("KEY_PRE_CLICK_REACTION_COUNT", 1) <= 3;
    }

    public final void l2(C14330hk2.EnumC14332b enumC14332b) {
        AbstractC13042fc3.i(enumC14332b, "<set-?>");
        this.E0 = enumC14332b;
    }

    public final void m1(int i2) {
        InterfaceC7857Tm2 interfaceC7857Tm2 = (InterfaceC7857Tm2) this.P0.get(Integer.valueOf(i2));
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
        }
        this.P0.remove(Integer.valueOf(i2));
    }

    public final void m2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.J0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
    }

    public final void n2(boolean z) {
        this.j.M7(z);
    }

    public final void o1() {
        KK kk = this.S0;
        if (kk != null) {
            kk.f();
        }
    }

    public final void p1(int i2) {
        this.Y.setValue(Integer.valueOf(i2));
    }

    public final boolean p2(long j2, int i2) {
        return this.r.a(j2, i2);
    }

    public final InterfaceC13730gj3 q1(C6119Mg2 c6119Mg2) {
        AbstractC13042fc3.i(c6119Mg2, "adapter");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(c6119Mg2, null), 3, null);
    }

    public final void r2() {
        this.D.putInt("KEY_PRE_CLICK_REACTION_COUNT", this.D.getInt("KEY_PRE_CLICK_REACTION_COUNT", 1) + 1);
    }

    public final void s1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.J0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
        this.f.a();
        this.g.b();
    }

    public final void s2() {
        InterfaceC2037k interfaceC2037k = this.G;
        interfaceC2037k.g(interfaceC2037k.f0() == 0.0f ? 1.0f : 0.0f);
    }

    public final void t1(C11458d25 c11458d25, List list, Context context, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(c11458d25, "forwardedPeer");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(context, "parent");
        this.w.a(c11458d25, list, context, z, ua2);
    }

    public final void t2(boolean z) {
        Object value;
        if (((Boolean) this.J0.getValue()).booleanValue()) {
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.K0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void u2(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.J0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final boolean v1(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        return this.h.a(j44);
    }

    public final void v2(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4N1 = N1();
        do {
            value = interfaceC9336Zm4N1.getValue();
        } while (!interfaceC9336Zm4N1.f(value, ((C22315v17) value).a(z)));
    }

    public final void w1(FileReference fileReference, UA2 ua2, UA2 ua22, UA2 ua23, int i2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(ua2, "onDownloading");
        AbstractC13042fc3.i(ua22, "onDownloaded");
        AbstractC13042fc3.i(ua23, "onNotDownloaded");
        this.P0.put(Integer.valueOf(i2), this.t.D(fileReference, true, new d(ua2, ua22, ua23), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false));
    }

    public final InterfaceC10258bL6 x1() {
        return this.B0;
    }

    public final InterfaceC10258bL6 y1() {
        return this.J;
    }

    public final InterfaceC2037k z1() {
        return this.G;
    }
}
