package ir.nasim.designsystem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes5.dex */
public class ChromeCustomTabReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.putExtra("android.intent.extra.TEXT", intent.getDataString());
        intent2.setType("text/plain");
        intent2.addFlags(268435456);
        context.startActivity(intent2);
    }
}
