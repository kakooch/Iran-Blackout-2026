package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.aG2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9615aG2 {
    private final C10299bQ2 a;
    private final C8054Ui1 b;
    private final SettingsModule c;
    private final InterfaceC11621dJ7 d;
    private final AbstractC13778go1 e;

    /* renamed from: ir.nasim.aG2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        long e;
        long f;
        int g;
        final /* synthetic */ String h;
        final /* synthetic */ C9615aG2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, C9615aG2 c9615aG2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = str;
            this.i = c9615aG2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.h, this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0172  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01fd  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x021d  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0224  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x022c  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0252  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0257  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.lang.NumberFormatException, java.io.IOException {
            /*
                Method dump skipped, instructions count: 751
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9615aG2.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C9615aG2(C10299bQ2 c10299bQ2, C8054Ui1 c8054Ui1, SettingsModule settingsModule, InterfaceC11621dJ7 interfaceC11621dJ7, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c10299bQ2;
        this.b = c8054Ui1;
        this.c = settingsModule;
        this.d = interfaceC11621dJ7;
        this.e = abstractC13778go1;
    }

    public final Object e(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new a(str, this, null), interfaceC20295rm1);
    }
}
