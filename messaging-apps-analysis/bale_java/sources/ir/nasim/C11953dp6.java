package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.dp6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11953dp6 implements InterfaceC14631iE {
    private static final a d = new a(null);
    private final Context a;
    private final AF2 b;
    private final InterfaceC7720Sx5 c;

    /* renamed from: ir.nasim.dp6$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C11953dp6(Context context, AF2 af2, InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(af2, "getConfigurationUseCase");
        AbstractC13042fc3.i(interfaceC7720Sx5, "sentryInstallerProvider");
        this.a = context;
        this.b = af2;
        this.c = interfaceC7720Sx5;
    }

    private final boolean e(AF2 af2) {
        Integer numO;
        String strA = af2.a("app.android.core.sentry_monitoring.enabled");
        return AbstractC7846Tl0.b.intValue() >= ((strA == null || (numO = AbstractC19562qZ6.o(strA)) == null) ? RecyclerView.UNDEFINED_DURATION : numO.intValue());
    }

    @Override // ir.nasim.InterfaceC14631iE
    public void d() {
        if (e(this.b)) {
            try {
                ((InterfaceC12566ep6) this.c.get()).a(this.a);
            } catch (Exception unused) {
                C19406qI3.b("SentryInitializer", "Failed to initialize the sentry.");
            }
        }
    }
}
