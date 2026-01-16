package ir.nasim;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.internal.AbstractC2064h;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public final class Nf8 extends com.google.android.gms.common.api.b implements InterfaceC17308mk7 {
    private static final a.g k;
    private static final a.AbstractC0169a l;
    private static final com.google.android.gms.common.api.a m;
    public static final /* synthetic */ int n = 0;

    static {
        a.g gVar = new a.g();
        k = gVar;
        Kf8 kf8 = new Kf8();
        l = kf8;
        m = new com.google.android.gms.common.api.a("ClientTelemetry.API", kf8, gVar);
    }

    public Nf8(Context context, C17899nk7 c17899nk7) {
        super(context, m, c17899nk7, b.a.c);
    }

    @Override // ir.nasim.InterfaceC17308mk7
    public final Task a(final TelemetryData telemetryData) {
        AbstractC2064h.a aVarA = AbstractC2064h.a();
        aVarA.d(AbstractC25060zf8.a);
        aVarA.c(false);
        aVarA.b(new InterfaceC13525gN5() { // from class: ir.nasim.Jf8
            @Override // ir.nasim.InterfaceC13525gN5
            public final void accept(Object obj, Object obj2) {
                TelemetryData telemetryData2 = telemetryData;
                int i = Nf8.n;
                ((Hf8) ((Qf8) obj).D()).F2(telemetryData2);
                ((C4982Hj7) obj2).c(null);
            }
        });
        return k(aVarA.a());
    }
}
