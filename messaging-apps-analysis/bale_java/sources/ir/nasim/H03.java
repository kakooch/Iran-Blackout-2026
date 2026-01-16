package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* loaded from: classes2.dex */
public class H03 {
    private final WorkDatabase a;

    public H03(WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void a(Context context, InterfaceC12694f27 interfaceC12694f27) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i2 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            interfaceC12694f27.I();
            try {
                interfaceC12694f27.i0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                interfaceC12694f27.i0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                sharedPreferences.edit().clear().apply();
                interfaceC12694f27.h0();
            } finally {
                interfaceC12694f27.t0();
            }
        }
    }

    private int c(String str) {
        this.a.e();
        try {
            Long lB = this.a.M().b(str);
            int i = 0;
            int iIntValue = lB != null ? lB.intValue() : 0;
            if (iIntValue != Integer.MAX_VALUE) {
                i = iIntValue + 1;
            }
            e(str, i);
            this.a.F();
            this.a.j();
            return iIntValue;
        } catch (Throwable th) {
            this.a.j();
            throw th;
        }
    }

    private void e(String str, int i) {
        this.a.M().a(new C13742gk5(str, i));
    }

    public int b() {
        int iC;
        synchronized (H03.class) {
            iC = c("next_alarm_manager_id");
        }
        return iC;
    }

    public int d(int i, int i2) {
        synchronized (H03.class) {
            int iC = c("next_job_scheduler_id");
            if (iC < i || iC > i2) {
                e("next_job_scheduler_id", i + 1);
            } else {
                i = iC;
            }
        }
        return i;
    }
}
