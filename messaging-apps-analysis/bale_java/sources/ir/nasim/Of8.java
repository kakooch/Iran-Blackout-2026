package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes3.dex */
public abstract class Of8 extends AbstractC4043Dl1 {
    public static Intent q(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Lf8.a()) {
            return context.registerReceiver(broadcastReceiver, intentFilter, true != Lf8.a() ? 0 : 2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
