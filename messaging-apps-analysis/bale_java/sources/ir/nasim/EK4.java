package ir.nasim;

import androidx.fragment.app.Fragment;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.onboarding.data.model.OnboardingData;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;

/* loaded from: classes5.dex */
public final class EK4 implements DK4 {
    private final FK4 a;
    private final SettingsModule b;
    private final InterfaceC20315ro1 c;
    private final AbstractC13778go1 d;
    private final InterfaceC15796kB2 e;
    private final InterfaceC15796kB2 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return EK4.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (EK4.this.j()) {
                    FK4 fk4 = EK4.this.a;
                    OnboardingSpot.DialogBanner dialogBanner = OnboardingSpot.DialogBanner.a;
                    this.b = 1;
                    obj = fk4.a(dialogBanner, this);
                    if (obj == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            OnboardingData onboardingData = (OnboardingData) obj;
            if (onboardingData instanceof OnboardingData.Enabled) {
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                OnboardingData.Enabled enabled = (OnboardingData.Enabled) onboardingData;
                Integer numD = AbstractC6392Nk0.d(OnboardingData.Enabled.d(enabled, null, 1, null));
                String bannerUrl = enabled.getBannerUrl();
                if (bannerUrl == null) {
                    bannerUrl = "";
                }
                interfaceC14603iB2.invoke(numD, bannerUrl);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return EK4.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FK4 fk4 = EK4.this.a;
                OnboardingSpot.SignUp signUp = OnboardingSpot.SignUp.a;
                this.b = 1;
                obj = fk4.a(signUp, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            OnboardingData onboardingData = (OnboardingData) obj;
            if (onboardingData instanceof OnboardingData.Enabled) {
                this.d.invoke(AbstractC6392Nk0.d(OnboardingData.Enabled.d((OnboardingData.Enabled) onboardingData, null, 1, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public EK4(FK4 fk4, SettingsModule settingsModule, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(fk4, "onboardingRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = fk4;
        this.b = settingsModule;
        this.c = interfaceC20315ro1;
        this.d = abstractC13778go1;
        C11504d71 c11504d71 = C11504d71.a;
        this.e = c11504d71.a();
        this.f = c11504d71.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        return C8386Vt0.S5() && !this.b.s3() && (this.b.t3() < 3);
    }

    @Override // ir.nasim.DK4
    public void a(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onEnabledStatus");
        AbstractC10533bm0.d(this.c, this.d, null, new b(ua2, null), 2, null);
    }

    @Override // ir.nasim.DK4
    public Fragment b(int i) {
        return C21902uK4.INSTANCE.a(OnboardingSpot.ActionBanner.a, i);
    }

    @Override // ir.nasim.DK4
    public void c(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "onEnabledStatus");
        AbstractC10533bm0.d(this.c, this.d, null, new a(interfaceC14603iB2, null), 2, null);
    }

    @Override // ir.nasim.DK4
    public InterfaceC15796kB2 d() {
        return this.f;
    }

    @Override // ir.nasim.DK4
    public InterfaceC15796kB2 e() {
        return this.e;
    }

    @Override // ir.nasim.DK4
    public Fragment f(int i) {
        return C21902uK4.INSTANCE.a(OnboardingSpot.DialogBanner.a, i);
    }

    @Override // ir.nasim.DK4
    public Fragment g(int i) {
        return C21902uK4.INSTANCE.a(OnboardingSpot.SignUp.a, i);
    }
}
