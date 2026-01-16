package ir.nasim;

import ir.nasim.UO1;
import java.util.List;

/* renamed from: ir.nasim.dQ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11678dQ1 implements InterfaceC10914cQ1 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final InterfaceC24010xt2 a;
    private final InterfaceC20667sP1 b;
    private final E84 c;
    private final InterfaceC6828Pd5 d;
    private final InterfaceC3570Bk5 e;
    private final C17024mG3 f;
    private final AbstractC13778go1 g;

    /* renamed from: ir.nasim.dQ1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.dQ1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;

        /* renamed from: ir.nasim.dQ1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C11678dQ1 c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C11678dQ1 c11678dQ1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c11678dQ1;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20667sP1 interfaceC20667sP1 = this.c.b;
                    int i2 = this.d;
                    this.b = 1;
                    objD = interfaceC20667sP1.D(i2, this);
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.dQ1$b$b, reason: collision with other inner class name */
        static final class C1007b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C11678dQ1 c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1007b(C11678dQ1 c11678dQ1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c11678dQ1;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1007b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objB;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.c.e.g("LOAD_PIN_DIALOG", false);
                    InterfaceC6828Pd5 interfaceC6828Pd5 = this.c.d;
                    int i2 = this.d;
                    this.b = 1;
                    objB = interfaceC6828Pd5.b(i2, true, this);
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
                return ((C1007b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C11678dQ1.this.new b(interfaceC20295rm1);
            bVar.f = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0130 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x014c A[Catch: all -> 0x0068, Exception -> 0x006c, CancellationException -> 0x0070, TryCatch #7 {CancellationException -> 0x0070, Exception -> 0x006c, all -> 0x0068, blocks: (B:30:0x0061, B:67:0x0136, B:68:0x0144, B:70:0x014c, B:75:0x0164, B:73:0x015a, B:76:0x0168, B:77:0x0175, B:79:0x017b, B:80:0x01af), top: B:103:0x0061 }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x017b A[Catch: all -> 0x0068, Exception -> 0x006c, CancellationException -> 0x0070, LOOP:1: B:77:0x0175->B:79:0x017b, LOOP_END, TryCatch #7 {CancellationException -> 0x0070, Exception -> 0x006c, all -> 0x0068, blocks: (B:30:0x0061, B:67:0x0136, B:68:0x0144, B:70:0x014c, B:75:0x0164, B:73:0x015a, B:76:0x0168, B:77:0x0175, B:79:0x017b, B:80:0x01af), top: B:103:0x0061 }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01bf A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01d6 A[RETURN] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v26, types: [ir.nasim.dQ1] */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v43 */
        /* JADX WARN: Type inference failed for: r2v44 */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 559
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11678dQ1.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dQ1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11678dQ1.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11678dQ1 c11678dQ1 = C11678dQ1.this;
                this.b = 1;
                obj = c11678dQ1.h(this);
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dQ1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11678dQ1.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20667sP1 interfaceC20667sP1 = C11678dQ1.this.b;
            List listY = C11678dQ1.this.c.L0().y();
            AbstractC13042fc3.h(listY, "getUnreadExPeers(...)");
            interfaceC20667sP1.E(listY);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C11678dQ1(InterfaceC24010xt2 interfaceC24010xt2, InterfaceC20667sP1 interfaceC20667sP1, E84 e84, InterfaceC6828Pd5 interfaceC6828Pd5, InterfaceC3570Bk5 interfaceC3570Bk5, C17024mG3 c17024mG3, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC24010xt2, "foldersRepository");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(e84, "messageModule");
        AbstractC13042fc3.i(interfaceC6828Pd5, "pinRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(c17024mG3, "loadUnreadDialogsUseCase");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC24010xt2;
        this.b = interfaceC20667sP1;
        this.c = e84;
        this.d = interfaceC6828Pd5;
        this.e = interfaceC3570Bk5;
        this.f = c17024mG3;
        this.g = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!C8386Vt0.X3()) {
            j();
            return C19938rB7.a;
        }
        UO1.e.b(UO1.e.a, "Refresh Dialogs And Folder: " + list.size() + " Some of the unread peers were missed, starting to load 10 unread dialogs.", null, 2, null);
        Object objE = this.f.e(list, interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC10914cQ1
    public boolean a() {
        return ((Boolean) AbstractC9913am0.b(null, new c(null), 1, null)).booleanValue();
    }

    public Object h(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new b(null), interfaceC20295rm1);
    }

    public void j() {
        AbstractC9323Zl0.e(this.g, new d(null));
    }
}
