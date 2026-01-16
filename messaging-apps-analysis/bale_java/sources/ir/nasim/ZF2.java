package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.inappmessage.data.model.InAppMessage;

/* loaded from: classes5.dex */
public final class ZF2 {
    private final SettingsModule a;
    private final InterfaceC12532em2 b;
    private final C9615aG2 c;
    private final AbstractC13778go1 d;
    private final InterfaceC9336Zm4 e;
    private final InterfaceC10258bL6 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        private /* synthetic */ Object g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = ZF2.this.new a(interfaceC20295rm1);
            aVar.g = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            InAppMessage.Disabled disabled;
            C12889fL5 c12889fL5;
            String name;
            Object obj2;
            InAppMessage.Enabled enabled;
            InAppMessage.Enabled enabled2;
            C12889fL5 c12889fL52;
            InAppMessage.Enabled enabled3;
            ZF2 zf2;
            InAppMessage.Enabled enabled4;
            C12889fL5 c12889fL53;
            InterfaceC9336Zm4 interfaceC9336Zm4;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.f;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.g;
                if (!C8386Vt0.e7()) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = ZF2.this.e;
                    do {
                        value = interfaceC9336Zm42.getValue();
                        disabled = InAppMessage.Disabled.INSTANCE;
                    } while (!interfaceC9336Zm42.f(value, disabled));
                    return disabled;
                }
                c12889fL5 = new C12889fL5();
                c12889fL5.a = InAppMessage.Disabled.INSTANCE;
                try {
                    obj2 = (InAppMessage) new LS2().c(InAppMessage.class, new ir.nasim.features.inappmessage.data.model.a()).b().k(ZF2.this.a.w2(), InAppMessage.class);
                } catch (Exception e) {
                    if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                        name = interfaceC20315ro1.getClass().getName();
                        int length = name.length();
                        AbstractC13042fc3.f(name);
                        if (length > 23) {
                            name = name.substring(name.length() - 23, name.length());
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    } else {
                        name = interfaceC20315ro1.getClass().getSimpleName();
                        int length2 = name.length();
                        AbstractC13042fc3.f(name);
                        if (length2 > 23) {
                            name = name.substring(0, 23);
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    }
                    C19406qI3.d(name, e);
                    obj2 = InAppMessage.Disabled.INSTANCE;
                }
                if ((obj2 instanceof InAppMessage.Enabled) && System.currentTimeMillis() < ((InAppMessage.Enabled) obj2).getExpireTimeInMills() && ZF2.this.a.y2() < ZF2.this.a.v2()) {
                    c12889fL5.a = obj2;
                }
                Object obj3 = c12889fL5.a;
                enabled = obj3 instanceof InAppMessage.Enabled ? (InAppMessage.Enabled) obj3 : null;
                if (enabled != null) {
                    ZF2 zf22 = ZF2.this;
                    InterfaceC12532em2 interfaceC12532em2 = zf22.b;
                    long contentMediaFileId = enabled.getContentMediaFileId();
                    long contentMediaAccessHash = enabled.getContentMediaAccessHash();
                    this.g = c12889fL5;
                    this.b = enabled;
                    this.c = zf22;
                    this.d = enabled;
                    this.e = enabled;
                    this.f = 1;
                    Object objC = interfaceC12532em2.c(contentMediaFileId, contentMediaAccessHash, this);
                    if (objC == objE) {
                        return objE;
                    }
                    enabled2 = enabled;
                    c12889fL52 = c12889fL5;
                    enabled3 = enabled2;
                    zf2 = zf22;
                    obj = objC;
                }
                interfaceC9336Zm4 = ZF2.this.e;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, (InAppMessage) c12889fL5.a));
                return (InAppMessage) c12889fL5.a;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                enabled4 = (InAppMessage.Enabled) this.c;
                c12889fL53 = (C12889fL5) this.g;
                AbstractC10685c16.b(obj);
                enabled4.setStartButtonLinkAction((InterfaceC10156bA3) obj);
                c12889fL5 = c12889fL53;
                interfaceC9336Zm4 = ZF2.this.e;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, (InAppMessage) c12889fL5.a));
                return (InAppMessage) c12889fL5.a;
            }
            enabled = (InAppMessage.Enabled) this.e;
            enabled3 = (InAppMessage.Enabled) this.d;
            zf2 = (ZF2) this.c;
            enabled2 = (InAppMessage.Enabled) this.b;
            c12889fL52 = (C12889fL5) this.g;
            AbstractC10685c16.b(obj);
            String str = (String) obj;
            if (str == null) {
                str = "";
            }
            enabled.setContentMediaLink(str);
            C9615aG2 c9615aG2 = zf2.c;
            String startButtonLink = ((InAppMessage.Enabled) c12889fL52.a).getStartButtonLink();
            this.g = c12889fL52;
            this.b = enabled2;
            this.c = enabled3;
            this.d = null;
            this.e = null;
            this.f = 2;
            obj = c9615aG2.e(startButtonLink, this);
            if (obj == objE) {
                return objE;
            }
            enabled4 = enabled3;
            c12889fL53 = c12889fL52;
            enabled4.setStartButtonLinkAction((InterfaceC10156bA3) obj);
            c12889fL5 = c12889fL53;
            interfaceC9336Zm4 = ZF2.this.e;
            do {
                value2 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value2, (InAppMessage) c12889fL5.a));
            return (InAppMessage) c12889fL5.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public ZF2(SettingsModule settingsModule, InterfaceC12532em2 interfaceC12532em2, C9615aG2 c9615aG2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(c9615aG2, "getLinkActionUseCase");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = settingsModule;
        this.b = interfaceC12532em2;
        this.c = c9615aG2;
        this.d = abstractC13778go1;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(InAppMessage.Idle.INSTANCE);
        this.e = interfaceC9336Zm4A;
        this.f = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    public final InterfaceC10258bL6 e() {
        return this.f;
    }

    public final Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.d, new a(null), interfaceC20295rm1);
    }

    public final void g() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, InAppMessage.Disabled.INSTANCE));
    }
}
