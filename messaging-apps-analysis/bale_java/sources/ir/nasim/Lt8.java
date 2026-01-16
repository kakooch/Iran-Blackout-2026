package ir.nasim;

import android.content.Context;
import com.google.android.gms.appset.zza;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.internal.AbstractC2064h;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public final class Lt8 extends com.google.android.gms.common.api.b implements JE {
    private static final a.g m;
    private static final a.AbstractC0169a n;
    private static final com.google.android.gms.common.api.a o;
    private final Context k;
    private final com.google.android.gms.common.b l;

    static {
        a.g gVar = new a.g();
        m = gVar;
        C21640ts8 c21640ts8 = new C21640ts8();
        n = c21640ts8;
        o = new com.google.android.gms.common.api.a("AppSet.API", c21640ts8, gVar);
    }

    Lt8(Context context, com.google.android.gms.common.b bVar) {
        super(context, o, a.d.P, b.a.c);
        this.k = context;
        this.l = bVar;
    }

    @Override // ir.nasim.JE
    public final Task f() {
        return this.l.h(this.k, 212800000) == 0 ? l(AbstractC2064h.a().d(AbstractC11314cn8.a).b(new InterfaceC13525gN5() { // from class: ir.nasim.Zr8
            @Override // ir.nasim.InterfaceC13525gN5
            public final void accept(Object obj, Object obj2) {
                ((C17940no8) ((Xl8) obj).D()).D2(new zza(null, null), new Ys8(this.a, (C4982Hj7) obj2));
            }
        }).c(false).e(27601).a()) : AbstractC9078Yj7.d(new ApiException(new Status(17)));
    }
}
