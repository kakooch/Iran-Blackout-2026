package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* renamed from: ir.nasim.pk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19079pk5 {
    private final WorkDatabase a;

    public C19079pk5(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void b(Context context, InterfaceC12694f27 interfaceC12694f27) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j2 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            interfaceC12694f27.I();
            try {
                interfaceC12694f27.i0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j)});
                interfaceC12694f27.i0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j2)});
                sharedPreferences.edit().clear().apply();
                interfaceC12694f27.h0();
            } finally {
                interfaceC12694f27.t0();
            }
        }
    }

    public boolean a() {
        Long lB = this.a.M().b("reschedule_needed");
        return lB != null && lB.longValue() == 1;
    }

    public void c(boolean z) {
        this.a.M().a(new C13742gk5("reschedule_needed", z));
    }
}
