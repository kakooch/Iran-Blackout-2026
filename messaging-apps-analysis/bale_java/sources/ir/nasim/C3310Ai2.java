package ir.nasim;

import android.content.Context;
import android.os.Build;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C6918Pn5;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.Q12;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Ai2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3310Ai2 extends VW7 implements z0.d {
    public static final b C0 = new b(null);
    public static final int D0 = 8;
    private final InterfaceC9336Zm4 A;
    private final InterfaceC19699qn4 A0;
    private final InterfaceC4557Fq2 B;
    private boolean B0;
    private final InterfaceC9336Zm4 D;
    private final InterfaceC9336Zm4 G;
    private final InterfaceC9336Zm4 H;
    private final InterfaceC10258bL6 J;
    private final InterfaceC10258bL6 Y;
    private InterfaceC13730gj3 Z;
    private final InterfaceC15271jI5 b;
    private final C11590dG3 c;
    private final C15842kG3 d;
    private final C10299bQ2 e;
    private final E84 f;
    private final F84 g;
    private final C24314yP5 h;
    private final C6181Mn1 i;
    private final C4309Eo6 j;
    private final C16575lW1 k;
    private final C18206oG3 l;
    private final ZA6 m;
    private final C14970in2 n;
    private final SettingsModule o;
    private final int p;
    private final androidx.lifecycle.y q;
    private final AbstractC13778go1 r;
    private final AbstractC13778go1 s;
    private final C23300wh2 t;
    private final C15753k68 u;
    private final InterfaceC2037k v;
    private final C6918Pn5 w;
    private final InterfaceC3570Bk5 x;
    private final InterfaceC9336Zm4 y;
    private final InterfaceC9336Zm4 z;
    private boolean z0;

    /* renamed from: ir.nasim.Ai2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C3558Bj2 c;
        final /* synthetic */ C3310Ai2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C3558Bj2 c3558Bj2, C3310Ai2 c3310Ai2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c3558Bj2;
            this.d = c3310Ai2;
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
                C3558Bj2 c3558Bj2 = this.c;
                C8755Xe4 c8755Xe4M1 = this.d.m1();
                this.b = 1;
                obj = c3558Bj2.f(c8755Xe4M1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.D;
            NT4 nt4B = NT4.e.b(AbstractC9766aX0.e((C4743Gj2) obj));
            if (C8386Vt0.a.Ma()) {
                nt4B = UT4.c(nt4B, null, C4743Gj2.i.a(), 1, null);
            }
            interfaceC9336Zm4.setValue(nt4B);
            this.d.A1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ai2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14697iL2 c;
        final /* synthetic */ C5886Lg2 d;
        final /* synthetic */ C3310Ai2 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ WH5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, C3310Ai2 c3310Ai2, boolean z, String str, WH5 wh5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c14697iL2;
            this.d = c5886Lg2;
            this.e = c3310Ai2;
            this.f = z;
            this.g = str;
            this.h = wh5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.e.c.b(new C8755Xe4(this.c.I0().getPeerId(), this.d.e(), this.d.m(), 0, 8, null), this.f, this.d.k(), this.g);
                InterfaceC15271jI5 interfaceC15271jI5 = this.e.b;
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
            C3310Ai2.N1(this.e, this.c.I0().getPeerId(), K5.f, null, this.g, this.h, this.d, 4, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ long e;
        final /* synthetic */ C8755Xe4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C11458d25 c11458d25, long j, C8755Xe4 c8755Xe4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = j;
            this.f = c8755Xe4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3310Ai2.this.new d(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11590dG3 c11590dG3 = C3310Ai2.this.c;
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ C8755Xe4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, C8755Xe4 c8755Xe4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = c8755Xe4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3310Ai2.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15842kG3 c15842kG3 = C3310Ai2.this.d;
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC15520jj2.h d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC15520jj2.h hVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = hVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3310Ai2.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18206oG3 c18206oG3 = C3310Ai2.this.l;
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
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC14190hV7 interfaceC14190hV7 = (InterfaceC14190hV7) obj;
            C6918Pn5 c6918Pn5 = C3310Ai2.this.w;
            InterfaceC2037k interfaceC2037kO1 = C3310Ai2.this.o1();
            this.b = 2;
            if (C6918Pn5.h(c6918Pn5, null, interfaceC14190hV7, interfaceC2037kO1, this, 1, null) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ai2$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C3310Ai2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C3310Ai2 c3310Ai2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c3310Ai2;
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
                this.d.D.setValue((NT4) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3310Ai2.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2 = C3310Ai2.this.B;
                a aVar = new a(C3310Ai2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Ai2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3310Ai2.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(2000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C3310Ai2.this.H;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4.f(value, AbstractC6392Nk0.a(false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        int e;
        final /* synthetic */ C4743Gj2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C4743Gj2 c4743Gj2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = c4743Gj2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3310Ai2.this.new i(this.g, interfaceC20295rm1);
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3310Ai2.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14697iL2 c;
        final /* synthetic */ C5886Lg2 d;
        final /* synthetic */ C3310Ai2 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ WH5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, C3310Ai2 c3310Ai2, boolean z, String str, WH5 wh5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c14697iL2;
            this.d = c5886Lg2;
            this.e = c3310Ai2;
            this.f = z;
            this.g = str;
            this.h = wh5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.e.c.b(new C8755Xe4(this.c.I0().getPeerId(), this.d.e(), this.d.m(), 0, 8, null), this.f, this.d.k(), this.g);
                InterfaceC15271jI5 interfaceC15271jI5 = this.e.b;
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
            C3310Ai2.N1(this.e, this.c.I0().getPeerId(), K5.g, null, this.g, this.h, this.d, 4, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ String e;
        final /* synthetic */ OP5 f;
        final /* synthetic */ List g;

        /* renamed from: ir.nasim.Ai2$k$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C3310Ai2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C3310Ai2 c3310Ai2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c3310Ai2;
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
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.A;
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
        k(C11458d25 c11458d25, String str, OP5 op5, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = str;
            this.f = op5;
            this.g = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3310Ai2.this.new k(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24314yP5 c24314yP5 = C3310Ai2.this.h;
                ExPeer exPeer = new ExPeer(ExPeerType.CHANNEL, this.d.getPeerId());
                String str = this.e;
                OP5 op5 = this.f;
                List<J44> list = this.g;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (J44 j44 : list) {
                    arrayList.add(new Q64(j44.h(), j44.i()));
                }
                InterfaceC4557Fq2 interfaceC4557Fq2A = c24314yP5.a(exPeer, str, op5, arrayList);
                a aVar = new a(C3310Ai2.this, null);
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ai2$l */
    public static final class l implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;

        /* renamed from: ir.nasim.Ai2$l$a */
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

        /* renamed from: ir.nasim.Ai2$l$b */
        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            public b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Object[] objArr = (Object[]) this.d;
                    Object obj2 = objArr[0];
                    AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type androidx.paging.PagingData<ir.nasim.jaryan.feed.model.ui.FeedUI>");
                    NT4 nt4 = (NT4) obj2;
                    Object obj3 = objArr[1];
                    AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj3).intValue();
                    Object obj4 = objArr[2];
                    AbstractC13042fc3.g(obj4, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue2 = ((Integer) obj4).intValue();
                    Integer num = (Integer) objArr[3];
                    Object obj5 = objArr[4];
                    AbstractC13042fc3.g(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean zBooleanValue = ((Boolean) obj5).booleanValue();
                    Object obj6 = objArr[5];
                    AbstractC13042fc3.g(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                    LA2 la2 = new LA2(nt4, iIntValue, iIntValue2, num, zBooleanValue, ((Boolean) obj6).booleanValue());
                    this.b = 1;
                    if (interfaceC4806Gq2.a(la2, this) == objE) {
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
                b bVar = new b(interfaceC20295rm1);
                bVar.c = interfaceC4806Gq2;
                bVar.d = objArr;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        public l(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
            this.a = interfaceC4557Fq2Arr;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new b(null), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3310Ai2(C3558Bj2 c3558Bj2, InterfaceC15271jI5 interfaceC15271jI5, C11590dG3 c11590dG3, C15842kG3 c15842kG3, C10299bQ2 c10299bQ2, E84 e84, F84 f84, C6918Pn5.a aVar, C24314yP5 c24314yP5, C6181Mn1 c6181Mn1, C4309Eo6 c4309Eo6, C16575lW1 c16575lW1, C18206oG3 c18206oG3, ZA6 za6, C14970in2 c14970in2, SettingsModule settingsModule, int i2, SF2 sf2, androidx.lifecycle.y yVar, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C23300wh2 c23300wh2, C15753k68 c15753k68) {
        AbstractC13042fc3.i(c3558Bj2, "feedRepository");
        AbstractC13042fc3.i(interfaceC15271jI5, "reactionsRepository");
        AbstractC13042fc3.i(c11590dG3, "loadReactionUseCase");
        AbstractC13042fc3.i(c15842kG3, "loadSuggesterUseCase");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(f84, "messagesRepository");
        AbstractC13042fc3.i(aVar, "prepareVideoPlayerUseCaseFactory");
        AbstractC13042fc3.i(c24314yP5, "reportMessagesUseCase");
        AbstractC13042fc3.i(c6181Mn1, "copyMessageToClipboardUseCase");
        AbstractC13042fc3.i(c4309Eo6, "sendTrafficUsageEventUseCase");
        AbstractC13042fc3.i(c16575lW1, "doAdvancedForwardUseCase");
        AbstractC13042fc3.i(c18206oG3, "loadVideoSource");
        AbstractC13042fc3.i(za6, "shouldShowSwipeAnimationUseCase");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(sf2, "getFeedUiDataUseCase");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(c23300wh2, "feedEventHandler");
        AbstractC13042fc3.i(c15753k68, "minimizeManager");
        this.b = interfaceC15271jI5;
        this.c = c11590dG3;
        this.d = c15842kG3;
        this.e = c10299bQ2;
        this.f = e84;
        this.g = f84;
        this.h = c24314yP5;
        this.i = c6181Mn1;
        this.j = c4309Eo6;
        this.k = c16575lW1;
        this.l = c18206oG3;
        this.m = za6;
        this.n = c14970in2;
        this.o = settingsModule;
        this.p = i2;
        this.q = yVar;
        this.r = abstractC13778go1;
        this.s = abstractC13778go12;
        this.t = c23300wh2;
        this.u = c15753k68;
        com.google.android.exoplayer2.E0 e0C = C24480yh2.a.c();
        this.v = e0C;
        this.w = aVar.a(EnumC8893Xt7.e);
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.k);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        this.x = interfaceC3570Bk5Q;
        Boolean bool = Boolean.FALSE;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(bool);
        this.y = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(-1);
        this.z = interfaceC9336Zm4A2;
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(null);
        this.A = interfaceC9336Zm4A3;
        this.B = AbstractC9395Zt0.a(c3558Bj2.i(m1()), AbstractC9773aX7.a(this));
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(NT4.e.a());
        this.D = interfaceC9336Zm4A4;
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(Integer.valueOf(e0C.p()));
        this.G = interfaceC9336Zm4A5;
        InterfaceC9336Zm4 interfaceC9336Zm4A6 = AbstractC12281eL6.a(bool);
        this.H = interfaceC9336Zm4A6;
        l lVar = new l(new InterfaceC4557Fq2[]{sf2.b(interfaceC9336Zm4A4), interfaceC9336Zm4A2, interfaceC9336Zm4A5, interfaceC9336Zm4A3, interfaceC9336Zm4A, interfaceC9336Zm4A6});
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar2 = InterfaceC16863lz6.a;
        this.J = AbstractC6459Nq2.o0(lVar, interfaceC20315ro1A, aVar2.d(), LA2.g.a());
        this.Y = AbstractC6459Nq2.o0(AbstractC6459Nq2.V(new C12475eg5(e0C, null, 2, null == true ? 1 : 0).d(), abstractC13778go12), AbstractC9773aX7.a(this), aVar2.d(), AbstractC13702gg5.a(e0C));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(c3558Bj2, this, null), 3, null);
        this.A0 = AbstractC20899sn4.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 A1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(null), 3, null);
    }

    public static /* synthetic */ void N1(C3310Ai2 c3310Ai2, int i2, K5 k5, XH6 xh6, String str, WH5 wh5, C5886Lg2 c5886Lg2, int i3, Object obj) {
        c3310Ai2.M1(i2, k5, (i3 & 4) != 0 ? null : xh6, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : wh5, c5886Lg2);
    }

    public static /* synthetic */ void k1(C3310Ai2 c3310Ai2, C11458d25 c11458d25, List list, Context context, boolean z, UA2 ua2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            ua2 = null;
        }
        c3310Ai2.j1(c11458d25, list, context, z2, ua2);
    }

    private final int l1() {
        Integer num = (Integer) this.q.c("CATEGORY_ID");
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8755Xe4 m1() {
        Object objC = this.q.c("FULL_SCREEN_FEED_MID");
        AbstractC13042fc3.f(objC);
        return (C8755Xe4) objC;
    }

    public final void B1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.y;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
            this.o.f7(System.currentTimeMillis());
            C19406qI3.b("FeedFullScreenViewModel", "onAnimationSwipeActionTaken");
            this.z0 = true;
        } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
    }

    public final void C1(int i2) {
        Object value;
        Object value2;
        this.z.setValue(Integer.valueOf(i2));
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.H;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.y;
        do {
            value2 = interfaceC9336Zm42.getValue();
            ((Boolean) value2).booleanValue();
        } while (!interfaceC9336Zm42.f(value2, Boolean.FALSE));
    }

    public final void D1() {
        Object value;
        boolean z;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.H;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
            long jCurrentTimeMillis = System.currentTimeMillis() - this.o.M2();
            Q12.a aVar = Q12.b;
            z = (((Boolean) this.y.getValue()).booleanValue() || ((Number) this.z.getValue()).intValue() != 0 || ((jCurrentTimeMillis > Q12.A(T12.s(1, W12.h)) ? 1 : (jCurrentTimeMillis == Q12.A(T12.s(1, W12.h)) ? 0 : -1)) <= 0)) ? false : true;
            this.o.d7(System.currentTimeMillis());
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(null), 3, null);
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void E0(int i2) {
        C19406qI3.g("FeedFullScreenViewModel", "playback state: " + i2, new Object[0]);
        this.G.setValue(Integer.valueOf(i2));
    }

    public final void E1() {
        Object value;
        boolean zE;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.y;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
            zE = this.m.e();
            C19406qI3.b("FeedFullScreenViewModel", "onShouldShowSwipeAnimation: " + zE);
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(zE && !this.z0)));
    }

    public final void F1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.y;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
            C19406qI3.b("FeedFullScreenViewModel", "onAnimationSwipeActionUnderstood");
            this.z0 = true;
        } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
    }

    public final void G1(C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(c4743Gj2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(c4743Gj2, null), 3, null);
    }

    public final void H1(C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(xh6, "sourceType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        C18987pb3.x1(C18987pb3.a, c11458d25, Long.valueOf(c5886Lg2.m()), Long.valueOf(c5886Lg2.e()), false, null, "feed", false, null, null, false, null, 1984, null);
        N1(this, c11458d25.getPeerId(), K5.c, xh6, null, null, c5886Lg2, 24, null);
    }

    public final void I1(String str, C14697iL2 c14697iL2, boolean z, WH5 wh5, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(str, "reactionCode");
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(wh5, "reactionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.r, null, new j(c14697iL2, c5886Lg2, this, z, str, wh5, null), 2, null);
    }

    public final void J1(C11458d25 c11458d25, String str, OP5 op5, List list, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(op5, "reportType");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(c11458d25, str, op5, list, null), 3, null);
        N1(this, c11458d25.getPeerId(), K5.k, null, null, null, c5886Lg2, 28, null);
    }

    public final void K1() {
        this.u.i();
    }

    public final void L1(C11458d25 c11458d25, J44 j44, C5886Lg2 c5886Lg2) {
        Object value;
        AbstractC13042fc3.i(c11458d25, "fromPeer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c5886Lg2, "feed");
        C11458d25 c11458d25E = C11458d25.E(this.p);
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        this.f.x0(c11458d25E, c11458d25, j44);
        N1(this, c11458d25.getPeerId(), K5.h, XH6.a, null, null, c5886Lg2, 24, null);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.A;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(ID5.saved_message_success_message)));
    }

    public final void M1(int i2, K5 k5, XH6 xh6, String str, WH5 wh5, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(k5, "actionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        this.t.b(i2, k5, xh6, str, wh5, c5886Lg2, l1());
    }

    public final void O1(int i2, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        this.t.f(i2, null, null, c5886Lg2, l1());
    }

    public final void P1(int i2, int i3, int i4, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        this.t.f(i2, Integer.valueOf(i3), Integer.valueOf(i4), c5886Lg2, l1());
    }

    public final void Q1(long j2, String str, long j3, long j4) {
        AbstractC13042fc3.i(str, "mimeType");
        this.j.a(j2, EnumC8893Xt7.e, j3, j4, str);
    }

    public final void R1() {
        this.x.putInt("KEY_PRE_CLICK_REACTION_COUNT", this.x.getInt("KEY_PRE_CLICK_REACTION_COUNT", 1) + 1);
    }

    public final void S1() {
        this.v.D(!r0.X());
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void V2(boolean z) {
        super.V2(z);
        C19406qI3.b("FeedFullScreenViewModel", "onIsLoadingChanged, isLoading: " + z + ", , page: " + this.z.getValue());
    }

    public final void g1(String str, C14697iL2 c14697iL2, boolean z, WH5 wh5, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(str, "reactionCode");
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(wh5, "reactionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.r, null, new c(c14697iL2, c5886Lg2, this, z, str, wh5, null), 2, null);
    }

    public final boolean h1() {
        return !this.x.h("KEY_PRE_IS_USER_LONG_TOUCH", false) && this.x.getInt("KEY_PRE_CLICK_REACTION_COUNT", 1) <= 3;
    }

    public final void i1(J44 j44) {
        Object value;
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        if (!this.i.a(j44) || Build.VERSION.SDK_INT > 32) {
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.A;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(ID5.toast_messages_copied)));
    }

    public final void j1(C11458d25 c11458d25, List list, Context context, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(c11458d25, "forwardedPeer");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(context, "parent");
        this.k.a(c11458d25, list, context, z, ua2);
    }

    public final InterfaceC2037k o1() {
        return this.v;
    }

    public final C14970in2 p1() {
        return this.n;
    }

    public final int q1() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void s() {
        super.s();
        C19406qI3.b("FeedFullScreenViewModel", "onRenderedFirstFrame, page: " + this.z.getValue());
    }

    public final InterfaceC10258bL6 s1() {
        return this.Y;
    }

    public final InterfaceC10258bL6 t1() {
        return this.J;
    }

    public final void u1() {
        this.u.f();
    }

    public final void v1() {
        this.x.g("KEY_PRE_IS_USER_LONG_TOUCH", true);
    }

    public final void w1(C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(xh6, "sourceType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        C19406qI3.a("Source_Join_Cause", "feed fullScreen joinPublicGroup()", new Object[0]);
        this.e.q2(c11458d25);
        N1(this, c11458d25.getPeerId(), K5.d, xh6, null, null, c5886Lg2, 24, null);
    }

    public final void x1(C11458d25 c11458d25, long j2, C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c8755Xe4, "mid");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.r, null, new d(c11458d25, j2, c8755Xe4, null), 2, null);
    }

    public final void y1(int i2, C8755Xe4 c8755Xe4) {
        AbstractC13042fc3.i(c8755Xe4, "mid");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.r, null, new e(i2, c8755Xe4, null), 2, null);
    }

    public final void z1(AbstractC15520jj2.h hVar) {
        AbstractC13042fc3.i(hVar, "videoFeed");
        InterfaceC13730gj3 interfaceC13730gj3 = this.Z;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.Z = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(hVar, null), 3, null);
    }
}
