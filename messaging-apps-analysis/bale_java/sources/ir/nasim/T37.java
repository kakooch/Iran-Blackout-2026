package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.z0;
import ir.nasim.C8947Xx5;
import ir.nasim.T37;
import ir.nasim.core.modules.file.audio.output.GetAudioOutputsUseCase;
import ir.nasim.core.modules.file.audio.output.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class T37 {
    private static final b e = new b(null);
    public static final int f = 8;
    private final GetAudioOutputsUseCase a;
    private final AbstractC13778go1 b;
    private final C8947Xx5.c c;
    private final InterfaceC19699qn4 d;

    private static final class a extends Exception {
        public static final a a = new a();

        private a() {
        }
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ T37 b;
        final /* synthetic */ InterfaceC2037k c;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ T37 b;
            final /* synthetic */ InterfaceC2037k c;

            /* renamed from: ir.nasim.T37$c$a$a, reason: collision with other inner class name */
            public static final class C0640a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0640a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, T37 t37, InterfaceC2037k interfaceC2037k) {
                this.a = interfaceC4806Gq2;
                this.b = t37;
                this.c = interfaceC2037k;
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
                    boolean r0 = r6 instanceof ir.nasim.T37.c.a.C0640a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.T37$c$a$a r0 = (ir.nasim.T37.c.a.C0640a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.T37$c$a$a r0 = new ir.nasim.T37$c$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L58
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
                    if (r5 == 0) goto L4a
                    ir.nasim.T37 r5 = r4.b
                    com.google.android.exoplayer2.k r2 = r4.c
                    boolean r5 = ir.nasim.T37.c(r5, r2)
                    if (r5 == 0) goto L4a
                    r5 = r3
                    goto L4b
                L4a:
                    r5 = 0
                L4b:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L58
                    return r1
                L58:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.T37.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, T37 t37, InterfaceC2037k interfaceC2037k) {
            this.a = interfaceC4557Fq2;
            this.b = t37;
            this.c = interfaceC2037k;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC2037k d;

        public static final class a implements z0.d {
            final /* synthetic */ InterfaceC16204ks5 a;
            final /* synthetic */ InterfaceC2037k b;

            a(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC2037k interfaceC2037k) {
                this.a = interfaceC16204ks5;
                this.b = interfaceC2037k;
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void D4(C2018a0 c2018a0, int i) {
                this.a.h(Boolean.valueOf(this.b.i() || this.b.X()));
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void E0(int i) {
                this.a.h(Boolean.valueOf(this.b.i()));
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void S4(boolean z, int i) {
                this.a.h(Boolean.valueOf(z && this.b.i()));
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void V2(boolean z) {
                this.a.h(Boolean.valueOf(this.b.i()));
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void q2(PlaybackException playbackException) {
                C19406qI3.b("SwitchOutputUseCase", "onPlayerErrorChanged(" + playbackException + Separators.RPAREN);
                this.a.h(Boolean.valueOf(playbackException != null && this.b.i()));
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void r5(boolean z) {
                this.a.h(Boolean.valueOf(z));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC2037k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(InterfaceC2037k interfaceC2037k, a aVar) {
            interfaceC2037k.o(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final a aVar = new a(interfaceC16204ks5, this.d);
                this.d.m0(aVar);
                final InterfaceC2037k interfaceC2037k = this.d;
                SA2 sa2 = new SA2() { // from class: ir.nasim.U37
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return T37.d.y(interfaceC2037k, aVar);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC2037k d;
        final /* synthetic */ T37 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC2037k interfaceC2037k, T37 t37, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC2037k;
            this.e = t37;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, this.e, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Boolean boolA = AbstractC6392Nk0.a(this.d.i() && this.e.m(this.d));
                this.b = 1;
                if (interfaceC4806Gq2.a(boolA, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T37.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws a {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (T37.this.d.d()) {
                throw a.a;
            }
            return C19938rB7.a;
        }

        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = T37.this.new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC19699qn4 interfaceC19699qn4;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            boolean z = false;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Throwable th = (Throwable) this.c;
                    if (!(th instanceof a)) {
                        C19406qI3.d("SwitchOutputUseCase", th);
                        return AbstractC6392Nk0.a(z);
                    }
                    C19406qI3.j("SwitchOutputUseCase", "The mutex is enabled and prevents sending player's events.", new Object[0]);
                    InterfaceC19699qn4 interfaceC19699qn42 = T37.this.d;
                    this.c = interfaceC19699qn42;
                    this.b = 1;
                    if (interfaceC19699qn42.a(null, this) == objE) {
                        return objE;
                    }
                    interfaceC19699qn4 = interfaceC19699qn42;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interfaceC19699qn4 = (InterfaceC19699qn4) this.c;
                    AbstractC10685c16.b(obj);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                interfaceC19699qn4.e(null);
                C19406qI3.j("SwitchOutputUseCase", "The mutex is now disabled and it's time to restart the flow.", new Object[0]);
                z = true;
                return AbstractC6392Nk0.a(z);
            } catch (Throwable th2) {
                interfaceC19699qn4.e(null);
                throw th2;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(th, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C8947Xx5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C8947Xx5 c8947Xx5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c8947Xx5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(C8947Xx5 c8947Xx5) {
            c8947Xx5.u(null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(InterfaceC16204ks5 interfaceC16204ks5, C8947Xx5.b bVar) {
            interfaceC16204ks5.h(bVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(this.d, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                this.d.u(new UA2() { // from class: ir.nasim.V37
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return T37.h.z(interfaceC16204ks5, (C8947Xx5.b) obj2);
                    }
                });
                final C8947Xx5 c8947Xx5 = this.d;
                SA2 sa2 = new SA2() { // from class: ir.nasim.W37
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return T37.h.D(c8947Xx5);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AppCompatActivity e;
        final /* synthetic */ InterfaceC2037k f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ T37 d;
            final /* synthetic */ InterfaceC2037k e;
            final /* synthetic */ C8947Xx5 f;

            /* renamed from: ir.nasim.T37$i$a$a, reason: collision with other inner class name */
            static final class C0641a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ T37 c;
                final /* synthetic */ InterfaceC2037k d;
                final /* synthetic */ C8947Xx5 e;

                /* renamed from: ir.nasim.T37$i$a$a$a, reason: collision with other inner class name */
                static final class C0642a extends AbstractC19859r37 implements InterfaceC15796kB2 {
                    int b;
                    /* synthetic */ Object c;
                    /* synthetic */ boolean d;

                    C0642a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(3, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        boolean z;
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        List list = (List) this.c;
                        if (!this.d) {
                            z = false;
                            break;
                        }
                        List list2 = list;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                if (!(((ir.nasim.core.modules.file.audio.output.a) it.next()) instanceof a.b)) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                        z = true;
                        return AbstractC6392Nk0.a(z);
                    }

                    public final Object n(List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                        C0642a c0642a = new C0642a(interfaceC20295rm1);
                        c0642a.c = list;
                        c0642a.d = z;
                        return c0642a.invokeSuspend(C19938rB7.a);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        return n((List) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
                    }
                }

                /* renamed from: ir.nasim.T37$i$a$a$b */
                static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ boolean c;

                    b(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        b bVar = new b(interfaceC20295rm1);
                        bVar.c = ((Boolean) obj).booleanValue();
                        return bVar;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        C19406qI3.a("SwitchOutputUseCase", "needToRegisterSensor: " + this.c, new Object[0]);
                        return C19938rB7.a;
                    }

                    public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.T37$i$a$a$c */
                static final class c implements InterfaceC4806Gq2 {
                    final /* synthetic */ C8947Xx5 a;

                    c(C8947Xx5 c8947Xx5) {
                        this.a = c8947Xx5;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
                    }

                    public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                        if (z) {
                            this.a.l();
                        } else {
                            this.a.k();
                        }
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0641a(T37 t37, InterfaceC2037k interfaceC2037k, C8947Xx5 c8947Xx5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = t37;
                    this.d = interfaceC2037k;
                    this.e = c8947Xx5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0641a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2B0 = AbstractC6459Nq2.b0(AbstractC6459Nq2.v(AbstractC6459Nq2.p(this.c.a.j(), this.c.k(this.d), new C0642a(null))), new b(null));
                        c cVar = new c(this.e);
                        this.b = 1;
                        if (interfaceC4557Fq2B0.b(cVar, this) == objE) {
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
                    return ((C0641a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ T37 c;
                final /* synthetic */ C8947Xx5 d;
                final /* synthetic */ InterfaceC2037k e;

                /* renamed from: ir.nasim.T37$i$a$b$a, reason: collision with other inner class name */
                static final class C0643a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ T37 d;
                    final /* synthetic */ InterfaceC2037k e;

                    /* renamed from: ir.nasim.T37$i$a$b$a$a, reason: collision with other inner class name */
                    public /* synthetic */ class C0644a {
                        public static final /* synthetic */ int[] a;

                        static {
                            int[] iArr = new int[C8947Xx5.b.values().length];
                            try {
                                iArr[C8947Xx5.b.a.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[C8947Xx5.b.b.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            a = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0643a(T37 t37, InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = t37;
                        this.e = interfaceC2037k;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C0643a c0643a = new C0643a(this.d, this.e, interfaceC20295rm1);
                        c0643a.c = obj;
                        return c0643a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            int i2 = C0644a.a[((C8947Xx5.b) this.c).ordinal()];
                            if (i2 == 1) {
                                T37 t37 = this.d;
                                InterfaceC2037k interfaceC2037k = this.e;
                                this.b = 1;
                                if (t37.p(interfaceC2037k, this) == objE) {
                                    return objE;
                                }
                            } else {
                                if (i2 != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                T37 t372 = this.d;
                                InterfaceC2037k interfaceC2037k2 = this.e;
                                this.b = 2;
                                if (t372.q(interfaceC2037k2, this) == objE) {
                                    return objE;
                                }
                            }
                        } else {
                            if (i != 1 && i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(C8947Xx5.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0643a) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(T37 t37, C8947Xx5 c8947Xx5, InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = t37;
                    this.d = c8947Xx5;
                    this.e = interfaceC2037k;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2L = this.c.l(this.d);
                        C0643a c0643a = new C0643a(this.c, this.e, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2L, c0643a, this) == objE) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(T37 t37, InterfaceC2037k interfaceC2037k, C8947Xx5 c8947Xx5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = t37;
                this.e = interfaceC2037k;
                this.f = c8947Xx5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
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
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0641a(this.d, this.e, this.f, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(this.d, this.f, this.e, null), 3, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AppCompatActivity appCompatActivity, InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = appCompatActivity;
            this.f = interfaceC2037k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C8947Xx5 c8947Xx5, Throwable th) {
            c8947Xx5.r();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = T37.this.new i(this.e, this.f, interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            final C8947Xx5 c8947Xx5A = T37.this.c.a(this.e);
            return AbstractC10533bm0.d(interfaceC20315ro1, T37.this.b, null, new a(T37.this, this.f, c8947Xx5A, null), 2, null).s(new UA2() { // from class: ir.nasim.X37
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return T37.i.y(c8947Xx5A, (Throwable) obj2);
                }
            });
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        int d;
        boolean e;
        /* synthetic */ Object f;
        int h;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return T37.this.o(null, 0, 0, this);
        }
    }

    public T37(GetAudioOutputsUseCase getAudioOutputsUseCase, AbstractC13778go1 abstractC13778go1, C8947Xx5.c cVar) {
        AbstractC13042fc3.i(getAudioOutputsUseCase, "getAudioOutputsUseCase");
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        AbstractC13042fc3.i(cVar, "proximitySensorListenerFactory");
        this.a = getAudioOutputsUseCase;
        this.b = abstractC13778go1;
        this.c = cVar;
        this.d = AbstractC20899sn4.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 k(InterfaceC2037k interfaceC2037k) {
        return AbstractC6459Nq2.v(AbstractC8361Vq2.f(AbstractC6459Nq2.b0(AbstractC6459Nq2.c0(new c(AbstractC6459Nq2.f(new d(interfaceC2037k, null)), this, interfaceC2037k), new e(interfaceC2037k, this, null)), new f(null)), 0L, new g(null), 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 l(C8947Xx5 c8947Xx5) {
        return AbstractC6459Nq2.f(new h(c8947Xx5, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(InterfaceC2037k interfaceC2037k) {
        C2018a0 c2018a0N = interfaceC2037k.n();
        if (c2018a0N == null) {
            return false;
        }
        C2018a0.h hVar = c2018a0N.b;
        if (hVar != null) {
            return AbstractC13042fc3.d(hVar.h, Boolean.TRUE);
        }
        C19406qI3.j("SwitchOutputUseCase", "The local configuration of media item wall null (" + c2018a0N.a + Separators.RPAREN, new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:13:0x0035, B:34:0x009e, B:38:0x00b3, B:40:0x00b8, B:41:0x00bb), top: B:46:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(com.google.android.exoplayer2.InterfaceC2037k r9, int r10, int r11, ir.nasim.InterfaceC20295rm1 r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof ir.nasim.T37.j
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.T37$j r0 = (ir.nasim.T37.j) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            ir.nasim.T37$j r0 = new ir.nasim.T37$j
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.h
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L56
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            boolean r9 = r0.e
            int r10 = r0.c
            java.lang.Object r11 = r0.b
            ir.nasim.qn4 r11 = (ir.nasim.InterfaceC19699qn4) r11
            java.lang.Object r0 = r0.a
            com.google.android.exoplayer2.k r0 = (com.google.android.exoplayer2.InterfaceC2037k) r0
            ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.lang.Throwable -> L39
            goto L9e
        L39:
            r9 = move-exception
            goto Lc1
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L44:
            int r11 = r0.d
            int r10 = r0.c
            java.lang.Object r9 = r0.b
            ir.nasim.qn4 r9 = (ir.nasim.InterfaceC19699qn4) r9
            java.lang.Object r2 = r0.a
            com.google.android.exoplayer2.k r2 = (com.google.android.exoplayer2.InterfaceC2037k) r2
            ir.nasim.AbstractC10685c16.b(r12)
            r12 = r9
            r9 = r2
            goto L6c
        L56:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.qn4 r12 = r8.d
            r0.a = r9
            r0.b = r12
            r0.c = r10
            r0.d = r11
            r0.h = r4
            java.lang.Object r2 = r12.a(r5, r0)
            if (r2 != r1) goto L6c
            return r1
        L6c:
            com.google.android.exoplayer2.audio.a r2 = r9.b()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.c     // Catch: java.lang.Throwable -> L7e
            int r2 = ir.nasim.AbstractC9683aN7.e0(r2)     // Catch: java.lang.Throwable -> L7e
            if (r2 != r11) goto L81
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L7e
            r12.e(r5)
            return r9
        L7e:
            r9 = move-exception
            r11 = r12
            goto Lc1
        L81:
            boolean r11 = r9.X()     // Catch: java.lang.Throwable -> L7e
            r9.h()     // Catch: java.lang.Throwable -> L7e
            r0.a = r9     // Catch: java.lang.Throwable -> L7e
            r0.b = r12     // Catch: java.lang.Throwable -> L7e
            r0.c = r10     // Catch: java.lang.Throwable -> L7e
            r0.e = r11     // Catch: java.lang.Throwable -> L7e
            r0.h = r3     // Catch: java.lang.Throwable -> L7e
            r6 = 200(0xc8, double:9.9E-322)
            java.lang.Object r0 = ir.nasim.HG1.b(r6, r0)     // Catch: java.lang.Throwable -> L7e
            if (r0 != r1) goto L9b
            return r1
        L9b:
            r0 = r9
            r9 = r11
            r11 = r12
        L9e:
            com.google.android.exoplayer2.audio.a$e r12 = new com.google.android.exoplayer2.audio.a$e     // Catch: java.lang.Throwable -> L39
            r12.<init>()     // Catch: java.lang.Throwable -> L39
            com.google.android.exoplayer2.audio.a$e r12 = r12.c(r3)     // Catch: java.lang.Throwable -> L39
            com.google.android.exoplayer2.audio.a$e r12 = r12.f(r10)     // Catch: java.lang.Throwable -> L39
            com.google.android.exoplayer2.audio.a r12 = r12.a()     // Catch: java.lang.Throwable -> L39
            if (r10 != r4) goto Lb2
            goto Lb3
        Lb2:
            r4 = 0
        Lb3:
            r0.S(r12, r4)     // Catch: java.lang.Throwable -> L39
            if (r9 == 0) goto Lbb
            r0.q()     // Catch: java.lang.Throwable -> L39
        Lbb:
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L39
            r11.e(r5)
            return r9
        Lc1:
            r11.e(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.T37.o(com.google.android.exoplayer2.k, int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        C19406qI3.a("SwitchOutputUseCase", "switchToEarpiece()", new Object[0]);
        Object objO = o(interfaceC2037k, 2, 0, interfaceC20295rm1);
        return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(InterfaceC2037k interfaceC2037k, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        C19406qI3.a("SwitchOutputUseCase", "switchToSpeaker()", new Object[0]);
        Object objO = o(interfaceC2037k, 1, 3, interfaceC20295rm1);
        return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
    }

    public final Object n(InterfaceC2037k interfaceC2037k, AppCompatActivity appCompatActivity, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new i(appCompatActivity, interfaceC2037k, null), interfaceC20295rm1);
    }
}
