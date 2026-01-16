package ir.nasim.features.firebase.newPush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC10523bl0;
import ir.nasim.InterfaceC16942m75;
import ir.nasim.SB7;

/* loaded from: classes5.dex */
public abstract class Hilt_PfmSetTagActionReceiver extends BroadcastReceiver {
    private volatile boolean a = false;
    private final Object b = new Object();

    protected void a(Context context) {
        if (this.a) {
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.a) {
                    ((InterfaceC16942m75) AbstractC10523bl0.a(context)).U((PfmSetTagActionReceiver) SB7.a(this));
                    this.a = true;
                }
            } finally {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(context);
    }
}
