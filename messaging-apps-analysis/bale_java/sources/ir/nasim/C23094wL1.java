package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC23684xL1;
import ir.nasim.AbstractC24274yL1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.wL1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23094wL1 {
    private final InterfaceC21103t7 a;
    private final InterfaceC17527n7 b;
    private final C9615aG2 c;
    private final SettingsModule d;
    private final SA2 e;
    private final InterfaceC20315ro1 f;
    private final InterfaceC19699qn4 g;
    private final List h;
    private final long i;
    private final InterfaceC9336Zm4 j;

    /* renamed from: ir.nasim.wL1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ AbstractC23684xL1.a g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC23684xL1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23094wL1.this.new a(this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x012f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0130 A[LOOP:0: B:27:0x0092->B:49:0x0130, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0104 A[EDGE_INSN: B:63:0x0104->B:40:0x0104 BREAK  A[LOOP:0: B:27:0x0092->B:49:0x0130], SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23094wL1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wL1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC24274yL1.b.C1786b c;
        final /* synthetic */ C23094wL1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC24274yL1.b.C1786b c1786b, C23094wL1 c23094wL1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c1786b;
            this.d = c23094wL1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c.g()) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.j;
                AbstractC24274yL1.b.C1786b c1786b = this.c;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC24274yL1.b.C1786b.b(c1786b, null, 0, 0L, 0, false, 15, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wL1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.wL1$c$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C23094wL1 a;

            /* renamed from: ir.nasim.wL1$c$a$a, reason: collision with other inner class name */
            static final class C1756a extends AbstractC22163um1 {
                Object a;
                Object b;
                Object c;
                Object d;
                Object e;
                Object f;
                /* synthetic */ Object g;
                int i;

                C1756a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.g = obj;
                    this.i |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C23094wL1 c23094wL1) {
                this.a = c23094wL1;
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:17:0x007b A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0097 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:18:0x007c, B:20:0x0097, B:23:0x009d, B:25:0x00a5, B:28:0x00ab, B:30:0x00af, B:31:0x00c5, B:32:0x00ca, B:33:0x00cb), top: B:41:0x007c }] */
            /* JADX WARN: Removed duplicated region for block: B:23:0x009d A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:18:0x007c, B:20:0x0097, B:23:0x009d, B:25:0x00a5, B:28:0x00ab, B:30:0x00af, B:31:0x00c5, B:32:0x00ca, B:33:0x00cb), top: B:41:0x007c }] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0108  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0079 -> B:41:0x007c). Please report as a decompilation issue!!! */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.util.List r22, ir.nasim.InterfaceC20295rm1 r23) {
                /*
                    Method dump skipped, instructions count: 271
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23094wL1.c.a.a(java.util.List, ir.nasim.rm1):java.lang.Object");
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23094wL1.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC21103t7 interfaceC21103t7 = C23094wL1.this.a;
                this.b = 1;
                obj = interfaceC21103t7.c(this);
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
            C23564x80 c23564x80 = (C23564x80) obj;
            if (c23564x80 != null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C23094wL1.this.j;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, new AbstractC24274yL1.b.a(c23564x80)));
            } else {
                InterfaceC4557Fq2 interfaceC4557Fq2A = C23094wL1.this.a.a();
                a aVar = new a(C23094wL1.this);
                this.b = 2;
                if (interfaceC4557Fq2A.b(aVar, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wL1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23094wL1.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C23564x80 c23564x80A;
            C17103mP1 c17103mP1C;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Object value = C23094wL1.this.j.getValue();
                AbstractC24274yL1.b.C1786b c1786b = value instanceof AbstractC24274yL1.b.C1786b ? (AbstractC24274yL1.b.C1786b) value : null;
                if (c1786b == null || (c17103mP1C = c1786b.c()) == null) {
                    Object value2 = C23094wL1.this.j.getValue();
                    AbstractC24274yL1.b.a aVar = value2 instanceof AbstractC24274yL1.b.a ? (AbstractC24274yL1.b.a) value2 : null;
                    if (aVar != null && (c23564x80A = aVar.a()) != null) {
                        C23094wL1 c23094wL1 = C23094wL1.this;
                        c23094wL1.y(c23564x80A);
                        SettingsModule settingsModule = c23094wL1.d;
                        settingsModule.J6(settingsModule.L1() + 1);
                    }
                } else {
                    C23094wL1 c23094wL12 = C23094wL1.this;
                    this.b = 1;
                    if (c23094wL12.A(c17103mP1C, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wL1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C17103mP1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C17103mP1 c17103mP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c17103mP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23094wL1.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9615aG2 c9615aG2 = C23094wL1.this.c;
                String strE = this.d.e();
                this.b = 1;
                obj = c9615aG2.e(strE, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wL1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C17103mP1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C17103mP1 c17103mP1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c17103mP1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23094wL1.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC21103t7 interfaceC21103t7 = C23094wL1.this.a;
                FileReference fileReferenceD = this.d.d();
                this.b = 1;
                obj = interfaceC21103t7.b(fileReferenceD, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wL1$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C23094wL1.this.z(null, this);
        }
    }

    /* renamed from: ir.nasim.wL1$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C23094wL1.this.A(null, this);
        }
    }

    public C23094wL1(InterfaceC21103t7 interfaceC21103t7, InterfaceC17527n7 interfaceC17527n7, C9615aG2 c9615aG2, SettingsModule settingsModule, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC21103t7, "adRepository");
        AbstractC13042fc3.i(interfaceC17527n7, "adEventRepository");
        AbstractC13042fc3.i(c9615aG2, "getLinkActionUseCase");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(sa2, "currentTimeMillis");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = interfaceC21103t7;
        this.b = interfaceC17527n7;
        this.c = c9615aG2;
        this.d = settingsModule;
        this.e = sa2;
        this.f = interfaceC20315ro1;
        this.g = AbstractC20899sn4.b(false, 1, null);
        this.h = new ArrayList();
        this.i = settingsModule.N1() * 1000;
        this.j = AbstractC12281eL6.a(AbstractC24274yL1.a.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(ir.nasim.C17103mP1 r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23094wL1.A(ir.nasim.mP1, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(int i) {
        return (i + 1) % this.h.size();
    }

    private final int p(C17103mP1 c17103mP1) {
        if (c17103mP1.g().length() != 0) {
            return 3;
        }
        String lowerCase = c17103mP1.e().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC20762sZ6.X(lowerCase, "/join/", false, 2, null) ? 2 : 1;
    }

    private final void q(AbstractC23684xL1.a aVar) {
        AbstractC10533bm0.d(this.f, null, null, new a(aVar, null), 3, null);
    }

    private final void r(AbstractC23684xL1.b bVar) {
        Object value;
        int iM;
        Object value2 = this.j.getValue();
        AbstractC24274yL1.b.C1786b c1786b = value2 instanceof AbstractC24274yL1.b.C1786b ? (AbstractC24274yL1.b.C1786b) value2 : null;
        if (c1786b == null || ((Number) this.e.invoke()).longValue() - c1786b.e() <= this.i) {
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
            iM = m(c1786b.f());
            w(iM);
        } while (!interfaceC9336Zm4.f(value, c1786b.a((C17103mP1) this.h.get(c1786b.f()), 0, ((Number) this.e.invoke()).longValue(), iM, true)));
    }

    private final void s(AbstractC23684xL1.c cVar) {
        Object value = this.j.getValue();
        AbstractC24274yL1.b.C1786b c1786b = value instanceof AbstractC24274yL1.b.C1786b ? (AbstractC24274yL1.b.C1786b) value : null;
        if (c1786b != null) {
            AbstractC10533bm0.d(this.f, null, null, new b(c1786b, this, null), 3, null);
        }
    }

    private final void u(AbstractC23684xL1.d dVar) {
        AbstractC10533bm0.d(this.f, null, null, new c(null), 3, null);
    }

    private final void v(AbstractC23684xL1.e eVar) {
        AbstractC10533bm0.d(this.f, null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int i) {
        synchronized (this.h) {
            try {
                InterfaceC20315ro1 interfaceC20315ro1 = this.f;
                for (int i2 = 0; i2 < 3; i2++) {
                    C17103mP1 c17103mP1 = (C17103mP1) this.h.get(i);
                    if (c17103mP1.f() == null) {
                        c17103mP1.l(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new e(c17103mP1, null), 3, null));
                    }
                    if (c17103mP1.c() == null) {
                        c17103mP1.k(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new f(c17103mP1, null), 3, null));
                    }
                    i = m(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(C23564x80 c23564x80) {
        this.b.h(c23564x80.a(), c23564x80.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(C23564x80 c23564x80) {
        this.b.g(c23564x80.a(), c23564x80.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(ir.nasim.C17103mP1 r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23094wL1.z(ir.nasim.mP1, ir.nasim.rm1):java.lang.Object");
    }

    public final SA2 n() {
        return this.e;
    }

    public final InterfaceC10258bL6 o() {
        return AbstractC6459Nq2.c(this.j);
    }

    public final void t(AbstractC23684xL1 abstractC23684xL1) {
        AbstractC13042fc3.i(abstractC23684xL1, "adUiAction");
        if (abstractC23684xL1 instanceof AbstractC23684xL1.d) {
            u((AbstractC23684xL1.d) abstractC23684xL1);
            return;
        }
        if (abstractC23684xL1 instanceof AbstractC23684xL1.e) {
            v((AbstractC23684xL1.e) abstractC23684xL1);
            return;
        }
        if (abstractC23684xL1 instanceof AbstractC23684xL1.a) {
            q((AbstractC23684xL1.a) abstractC23684xL1);
        } else if (abstractC23684xL1 instanceof AbstractC23684xL1.b) {
            r((AbstractC23684xL1.b) abstractC23684xL1);
        } else {
            if (!(abstractC23684xL1 instanceof AbstractC23684xL1.c)) {
                throw new NoWhenBranchMatchedException();
            }
            s((AbstractC23684xL1.c) abstractC23684xL1);
        }
    }
}
