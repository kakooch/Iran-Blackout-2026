package androidx.work;

import android.content.Context;
import androidx.work.a;
import ir.nasim.E73;
import ir.nasim.HI3;
import ir.nasim.Ya8;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class WorkManagerInitializer implements E73 {
    private static final String a = HI3.f("WrkMgrInitializer");

    @Override // ir.nasim.E73
    public List b() {
        return Collections.emptyList();
    }

    @Override // ir.nasim.E73
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Ya8 a(Context context) {
        HI3.c().a(a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        Ya8.e(context, new a.b().a());
        return Ya8.d(context);
    }
}
