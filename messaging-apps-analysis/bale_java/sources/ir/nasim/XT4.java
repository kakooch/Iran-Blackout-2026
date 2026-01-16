package ir.nasim;

import android.os.Build;
import android.util.Log;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes2.dex */
public final class XT4 {
    public static final XT4 a = new XT4();

    private XT4() {
    }

    public final boolean a(int i) {
        return Build.ID != null && Log.isLoggable("Paging", i);
    }

    public final void b(int i, String str, Throwable th) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        if (i == 2) {
            Log.v("Paging", str, th);
            return;
        }
        if (i == 3) {
            Log.d("Paging", str, th);
            return;
        }
        throw new IllegalArgumentException("debug level " + i + " is requested but Paging only supports default logging for level 2 (VERBOSE) or level 3 (DEBUG)");
    }
}
