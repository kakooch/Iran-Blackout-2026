package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;

/* loaded from: classes5.dex */
public final class GK4 implements FK4 {
    public static final a h = new a(null);
    private final C6287Mz a;
    private final InterfaceC11621dJ7 b;
    private final KM2 c;
    private final SettingsModule d;
    private final InterfaceC3570Bk5 e;
    private final AbstractC13778go1 f;
    private final String g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC10088b35.values().length];
            try {
                iArr[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_BOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        int h;
        final /* synthetic */ OnboardingSpot i;
        final /* synthetic */ GK4 j;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC10088b35.values().length];
                try {
                    iArr[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC10088b35.ExPeerType_BOT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(OnboardingSpot onboardingSpot, GK4 gk4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = onboardingSpot;
            this.j = gk4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.i, this.j, interfaceC20295rm1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0452  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x046e  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x049b  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x04e2  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x04e5  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x04ea  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x04f0  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x04fc  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x0503  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x0585  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x059d  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x05cb  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x0614  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x0617  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x061d  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x0636  */
        /* JADX WARN: Removed duplicated region for block: B:171:0x0644  */
        /* JADX WARN: Removed duplicated region for block: B:183:0x02b1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01c1  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x029b  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x02c1  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x037c  */
        /* JADX WARN: Type inference failed for: r2v29, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x0494 -> B:123:0x0497). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:155:0x05c4 -> B:157:0x05c7). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instructions count: 1644
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GK4.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return GK4.this.g(null, this);
        }
    }

    public GK4(C6287Mz c6287Mz, InterfaceC11621dJ7 interfaceC11621dJ7, KM2 km2, SettingsModule settingsModule, InterfaceC3570Bk5 interfaceC3570Bk5, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(abstractC13778go1, "coroutineDispatcher");
        this.a = c6287Mz;
        this.b = interfaceC11621dJ7;
        this.c = km2;
        this.d = settingsModule;
        this.e = interfaceC3570Bk5;
        this.f = abstractC13778go1;
        this.g = "EMPTY_STATE_JOINED_BOTS";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0222  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x021b -> B:96:0x021e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.util.List r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GK4.g(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.FK4
    public Object a(OnboardingSpot onboardingSpot, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.f, new c(onboardingSpot, this, null), interfaceC20295rm1);
    }
}
