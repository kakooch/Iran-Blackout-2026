package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.wG2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23050wG2 {
    private final InterfaceC6118Mg1 a;
    private final SettingsModule b;
    private final AbstractC13778go1 c;

    /* renamed from: ir.nasim.wG2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        int d;
        int e;
        int f;
        private /* synthetic */ Object g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C23050wG2.this.new a(interfaceC20295rm1);
            aVar.g = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0095 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0096 -> B:24:0x0097). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.f
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L37
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                int r1 = r10.e
                int r4 = r10.d
                int r5 = r10.c
                java.lang.Object r6 = r10.g
                ir.nasim.Gq2 r6 = (ir.nasim.InterfaceC4806Gq2) r6
                ir.nasim.AbstractC10685c16.b(r11)
                goto L97
            L1d:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L25:
                int r1 = r10.e
                int r4 = r10.d
                int r5 = r10.c
                java.lang.Object r6 = r10.b
                ir.nasim.Gq2 r6 = (ir.nasim.InterfaceC4806Gq2) r6
                java.lang.Object r7 = r10.g
                ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                ir.nasim.AbstractC10685c16.b(r11)
                goto L82
            L37:
                ir.nasim.AbstractC10685c16.b(r11)
                java.lang.Object r11 = r10.g
                ir.nasim.Gq2 r11 = (ir.nasim.InterfaceC4806Gq2) r11
                ir.nasim.wG2 r1 = ir.nasim.C23050wG2.this
                ir.nasim.Mg1 r1 = ir.nasim.C23050wG2.a(r1)
                int r1 = r1.d()
                ir.nasim.wG2 r4 = ir.nasim.C23050wG2.this
                ir.nasim.core.modules.settings.SettingsModule r4 = ir.nasim.C23050wG2.c(r4)
                int r4 = r4.u1()
                if (r1 != 0) goto L57
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            L57:
                ir.nasim.wG2 r5 = ir.nasim.C23050wG2.this
                int r6 = r4 + (-1)
                int r5 = ir.nasim.C23050wG2.b(r5, r6, r1)
                r6 = 0
                r9 = r6
                r6 = r11
                r11 = r9
            L63:
                if (r5 >= r1) goto La8
                ir.nasim.wG2 r7 = ir.nasim.C23050wG2.this
                ir.nasim.Mg1 r7 = ir.nasim.C23050wG2.a(r7)
                r10.g = r6
                r10.b = r6
                r10.c = r1
                r10.d = r4
                r10.e = r5
                r10.f = r3
                java.lang.Object r11 = r7.c(r11, r5, r10)
                if (r11 != r0) goto L7e
                return r0
            L7e:
                r7 = r6
                r9 = r5
                r5 = r1
                r1 = r9
            L82:
                r10.g = r7
                r8 = 0
                r10.b = r8
                r10.c = r5
                r10.d = r4
                r10.e = r1
                r10.f = r2
                java.lang.Object r11 = r6.a(r11, r10)
                if (r11 != r0) goto L96
                return r0
            L96:
                r6 = r7
            L97:
                int r11 = r5 + (-1)
                if (r1 == r11) goto La8
                int r11 = r1 + 1
                ir.nasim.wG2 r7 = ir.nasim.C23050wG2.this
                int r1 = r1 + r4
                int r1 = ir.nasim.C23050wG2.b(r7, r1, r5)
                r9 = r5
                r5 = r1
                r1 = r9
                goto L63
            La8:
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23050wG2.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C23050wG2(InterfaceC6118Mg1 interfaceC6118Mg1, SettingsModule settingsModule, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC6118Mg1, "contactRepository");
        AbstractC13042fc3.i(settingsModule, "settingModules");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        this.a = interfaceC6118Mg1;
        this.b = settingsModule;
        this.c = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d(int i, int i2) {
        return i < i2 ? i : i2 - 1;
    }

    public final InterfaceC4557Fq2 e() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.R(new a(null)), this.c);
    }
}
