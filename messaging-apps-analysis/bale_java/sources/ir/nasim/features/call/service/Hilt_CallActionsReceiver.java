package ir.nasim.features.call.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC10523bl0;
import ir.nasim.InterfaceC11997du0;
import ir.nasim.SB7;

/* loaded from: classes5.dex */
public abstract class Hilt_CallActionsReceiver extends BroadcastReceiver {
    private volatile boolean a = false;
    private final Object b = new Object();

    protected void a(Context context) {
        if (this.a) {
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.a) {
                    ((InterfaceC11997du0) AbstractC10523bl0.a(context)).V((CallActionsReceiver) SB7.a(this));
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
