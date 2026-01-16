package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.os.Build;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.El1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4277El1 {
    public static final ComponentActivity a(Context context) {
        AbstractC13042fc3.i(context, "<this>");
        if (context instanceof ComponentActivity) {
            return (ComponentActivity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        return a(baseContext);
    }

    public static final void b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        AbstractC13042fc3.i(context, "<this>");
        AbstractC13042fc3.i(broadcastReceiver, "receiver");
        AbstractC13042fc3.i(intentFilter, "intentFilter");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, z ? 2 : 4);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static /* synthetic */ void c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        b(context, broadcastReceiver, intentFilter, z);
    }

    public static final void d(Context context, String str, int i) {
        AbstractC13042fc3.i(context, "<this>");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        Toast.makeText(context, str, i).show();
    }

    public static /* synthetic */ void e(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        d(context, str, i);
    }
}
