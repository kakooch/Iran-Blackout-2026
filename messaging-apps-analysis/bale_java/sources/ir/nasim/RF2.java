package ir.nasim;

import android.content.Context;
import ir.nasim.Q12;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.eventbar.data.model.EventBarData;

/* loaded from: classes5.dex */
public final class RF2 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final SettingsModule a;
    private final C9615aG2 b;
    private final AbstractC13778go1 c;
    private final C12720f53 d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return RF2.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C12889fL5 c12889fL5;
            Object obj2;
            EventBarData.Enabled enabled;
            Object objE;
            C12889fL5 c12889fL52;
            Object objE2 = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (!C8386Vt0.J5()) {
                    return EventBarData.Disabled.INSTANCE;
                }
                c12889fL5 = new C12889fL5();
                c12889fL5.a = EventBarData.Disabled.INSTANCE;
                try {
                    obj2 = (EventBarData) new LS2().c(EventBarData.class, new ir.nasim.features.eventbar.data.model.a()).b().k(RF2.this.a.E1(), EventBarData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    obj2 = EventBarData.Disabled.INSTANCE;
                }
                if ((obj2 instanceof EventBarData.Enabled) && System.currentTimeMillis() < ((EventBarData.Enabled) obj2).getExpireTimeInMills() && RF2.this.e()) {
                    c12889fL5.a = obj2;
                } else if (RF2.this.f()) {
                    Context contextD = C5721Ko.a.d();
                    RF2 rf2 = RF2.this;
                    EventBarData.Enabled.a aVar = EventBarData.Enabled.a.b;
                    String string = contextD.getString(AbstractC12217eE5.event_bar_update_title_text);
                    AbstractC13042fc3.h(string, "getString(...)");
                    String string2 = contextD.getString(AbstractC12217eE5.event_bar_update_button_text);
                    AbstractC13042fc3.h(string2, "getString(...)");
                    c12889fL5.a = new EventBarData.Enabled(aVar, 0L, string, string2, rf2.a.y4(), 1, Long.MAX_VALUE, false);
                }
                Object obj3 = c12889fL5.a;
                enabled = obj3 instanceof EventBarData.Enabled ? (EventBarData.Enabled) obj3 : null;
                if (enabled != null) {
                    C9615aG2 c9615aG2 = RF2.this.b;
                    String contentLink = enabled.getContentLink();
                    this.b = c12889fL5;
                    this.c = enabled;
                    this.d = enabled;
                    this.e = 1;
                    objE = c9615aG2.e(contentLink, this);
                    if (objE == objE2) {
                        return objE2;
                    }
                    c12889fL52 = c12889fL5;
                }
                return (EventBarData) c12889fL5.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            enabled = (EventBarData.Enabled) this.d;
            c12889fL52 = (C12889fL5) this.b;
            AbstractC10685c16.b(obj);
            objE = obj;
            enabled.setContentLinkAction((InterfaceC10156bA3) objE);
            c12889fL5 = c12889fL52;
            return (EventBarData) c12889fL5.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public RF2(SettingsModule settingsModule, C9615aG2 c9615aG2, AbstractC13778go1 abstractC13778go1, C12720f53 c12720f53) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c9615aG2, "getLinkActionUseCase");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c12720f53, "inAppUpdateStateManager");
        this.a = settingsModule;
        this.b = c9615aG2;
        this.c = abstractC13778go1;
        this.d = c12720f53;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        return !this.a.C1() && this.a.D1() < this.a.B1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        if (!this.d.v() && this.a.R7()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - C7183Qq.p().getLong("update_event_bar_last_close_in_ms", -1L);
            Q12.a aVar = Q12.b;
            if (jCurrentTimeMillis > Q12.A(T12.s(5, W12.h))) {
                return true;
            }
        }
        return false;
    }

    public final Object g(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new b(null), interfaceC20295rm1);
    }
}
