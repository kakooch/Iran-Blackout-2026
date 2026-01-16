package ir.nasim;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Fw1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4610Fw1 {
    private final boolean a;
    private AtomicReference b = new AtomicReference(null);
    private final InterfaceC14354hm4 c = AbstractC4326Eq5.a(0.0f);

    /* renamed from: ir.nasim.Fw1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.Fw1$a$a, reason: collision with other inner class name */
        static final class C0379a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC13730gj3 c;
            final /* synthetic */ C4610Fw1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0379a(InterfaceC13730gj3 interfaceC13730gj3, C4610Fw1 c4610Fw1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC13730gj3;
                this.d = c4610Fw1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0379a(this.c, this.d, interfaceC20295rm1);
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0067 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0073 -> B:36:0x0076). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r10.b
                    r2 = 0
                    r3 = 500(0x1f4, double:2.47E-321)
                    r5 = 1065353216(0x3f800000, float:1.0)
                    r6 = 4
                    r7 = 3
                    r8 = 2
                    r9 = 1
                    if (r1 == 0) goto L33
                    if (r1 == r9) goto L2f
                    if (r1 == r8) goto L2b
                    if (r1 == r7) goto L27
                    if (r1 != r6) goto L1f
                    ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Throwable -> L1d
                    goto L76
                L1d:
                    r11 = move-exception
                    goto L7c
                L1f:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L27:
                    ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Throwable -> L1d
                    goto L68
                L2b:
                    ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Throwable -> L1d
                    goto L59
                L2f:
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto L43
                L33:
                    ir.nasim.AbstractC10685c16.b(r11)
                    ir.nasim.gj3 r11 = r10.c
                    if (r11 == 0) goto L43
                    r10.b = r9
                    java.lang.Object r11 = ir.nasim.AbstractC19067pj3.g(r11, r10)
                    if (r11 != r0) goto L43
                    return r0
                L43:
                    ir.nasim.Fw1 r11 = r10.d     // Catch: java.lang.Throwable -> L1d
                    ir.nasim.C4610Fw1.b(r11, r5)     // Catch: java.lang.Throwable -> L1d
                    ir.nasim.Fw1 r11 = r10.d     // Catch: java.lang.Throwable -> L1d
                    boolean r11 = r11.c()     // Catch: java.lang.Throwable -> L1d
                    if (r11 != 0) goto L5f
                    r10.b = r8     // Catch: java.lang.Throwable -> L1d
                    java.lang.Object r11 = ir.nasim.HG1.a(r10)     // Catch: java.lang.Throwable -> L1d
                    if (r11 != r0) goto L59
                    return r0
                L59:
                    kotlin.KotlinNothingValueException r11 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L1d
                    r11.<init>()     // Catch: java.lang.Throwable -> L1d
                    throw r11     // Catch: java.lang.Throwable -> L1d
                L5f:
                    r10.b = r7     // Catch: java.lang.Throwable -> L1d
                    java.lang.Object r11 = ir.nasim.HG1.b(r3, r10)     // Catch: java.lang.Throwable -> L1d
                    if (r11 != r0) goto L68
                    return r0
                L68:
                    ir.nasim.Fw1 r11 = r10.d     // Catch: java.lang.Throwable -> L1d
                    ir.nasim.C4610Fw1.b(r11, r2)     // Catch: java.lang.Throwable -> L1d
                    r10.b = r6     // Catch: java.lang.Throwable -> L1d
                    java.lang.Object r11 = ir.nasim.HG1.b(r3, r10)     // Catch: java.lang.Throwable -> L1d
                    if (r11 != r0) goto L76
                    return r0
                L76:
                    ir.nasim.Fw1 r11 = r10.d     // Catch: java.lang.Throwable -> L1d
                    ir.nasim.C4610Fw1.b(r11, r5)     // Catch: java.lang.Throwable -> L1d
                    goto L5f
                L7c:
                    ir.nasim.Fw1 r0 = r10.d
                    ir.nasim.C4610Fw1.b(r0, r2)
                    throw r11
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4610Fw1.a.C0379a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0379a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C4610Fw1.this.new a(interfaceC20295rm1);
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
            return AbstractC6392Nk0.a(AbstractC16775lq5.a(C4610Fw1.this.b, null, AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new C0379a((InterfaceC13730gj3) C4610Fw1.this.b.getAndSet(null), C4610Fw1.this, null), 3, null)));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4610Fw1(boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(float f) {
        this.c.s(f);
    }

    public final boolean c() {
        return this.a;
    }

    public final float d() {
        return this.c.a();
    }

    public final Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }
}
