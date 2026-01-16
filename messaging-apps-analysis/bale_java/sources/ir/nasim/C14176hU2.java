package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.hU2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14176hU2 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final SettingsModule a;
    private final C4627Fy0 b;

    /* renamed from: ir.nasim.hU2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C14176hU2(SettingsModule settingsModule, C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = settingsModule;
        this.b = c4627Fy0;
    }

    public static /* synthetic */ void b(C14176hU2 c14176hU2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        c14176hU2.a(z);
    }

    public final void a(boolean z) {
        C19406qI3.a("HangUpUseCase", "invoke HangUpUseCase", new Object[0]);
        if (this.a.B5(EnumC4196Ec1.C0) && ((C17448mz0) C18039nz0.a.d().getValue()).m()) {
            this.b.I0(z);
        } else {
            this.b.J0();
        }
    }
}
