package ir.nasim;

import android.content.Context;
import com.google.android.exoplayer2.E0;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.C17595nE1;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes8.dex */
public final class ZT7 {
    public final RF3 a(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        C17595nE1 c17595nE1A = new C17595nE1.a().b(new UB1(true, 65536)).c(settingsModule.S1(), settingsModule.R1(), settingsModule.T1(), settingsModule.U1()).e(-1).d(true).a();
        if (C8386Vt0.a.s6()) {
            AbstractC13042fc3.f(c17595nE1A);
            new C13325g22(c17595nE1A, 0L, 0L, 6, null);
        }
        AbstractC13042fc3.h(c17595nE1A, "apply(...)");
        return c17595nE1A;
    }

    public final com.google.android.exoplayer2.E0 b(Context context, RF3 rf3, a.c cVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(rf3, "loadControl");
        AbstractC13042fc3.i(cVar, "cacheDataSource");
        com.google.android.exoplayer2.E0 e0A = new E0.a(context).b(rf3).c(new ProgressiveMediaSource.Factory(cVar)).a();
        AbstractC13042fc3.h(e0A, "build(...)");
        return e0A;
    }
}
