package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* loaded from: classes.dex */
public class IdGenerator {
    private final WorkDatabase mWorkDatabase;

    public IdGenerator(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public int nextJobSchedulerIdWithRange(int minInclusive, int maxInclusive) {
        synchronized (IdGenerator.class) {
            int iNextId = nextId("next_job_scheduler_id");
            if (iNextId < minInclusive || iNextId > maxInclusive) {
                update("next_job_scheduler_id", minInclusive + 1);
            } else {
                minInclusive = iNextId;
            }
        }
        return minInclusive;
    }

    public int nextAlarmManagerId() {
        int iNextId;
        synchronized (IdGenerator.class) {
            iNextId = nextId("next_alarm_manager_id");
        }
        return iNextId;
    }

    private int nextId(String key) {
        this.mWorkDatabase.beginTransaction();
        try {
            Long longValue = this.mWorkDatabase.preferenceDao().getLongValue(key);
            int i = 0;
            int iIntValue = longValue != null ? longValue.intValue() : 0;
            if (iIntValue != Integer.MAX_VALUE) {
                i = iIntValue + 1;
            }
            update(key, i);
            this.mWorkDatabase.setTransactionSuccessful();
            return iIntValue;
        } finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    private void update(String key, int value) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(key, value));
    }

    public static void migrateLegacyIdGenerator(Context context, SupportSQLiteDatabase sqLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i2 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            sqLiteDatabase.beginTransaction();
            try {
                sqLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                sqLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                sharedPreferences.edit().clear().apply();
                sqLiteDatabase.setTransactionSuccessful();
            } finally {
                sqLiteDatabase.endTransaction();
            }
        }
    }
}
