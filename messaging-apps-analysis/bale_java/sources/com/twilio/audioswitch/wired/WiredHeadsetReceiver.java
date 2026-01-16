package com.twilio.audioswitch.wired;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.Ha8;
import ir.nasim.NI3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/twilio/audioswitch/wired/WiredHeadsetReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lir/nasim/Ha8;", "a", "Lir/nasim/Ha8;", "getDeviceListener$audioswitch_release", "()Lir/nasim/Ha8;", "setDeviceListener$audioswitch_release", "(Lir/nasim/Ha8;)V", "deviceListener", "Lir/nasim/NI3;", "b", "Lir/nasim/NI3;", "logger", "audioswitch_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class WiredHeadsetReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    private Ha8 deviceListener;

    /* renamed from: b, reason: from kotlin metadata */
    private final NI3 logger;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        if (intent.getIntExtra("state", 0) == 1) {
            String stringExtra = intent.getStringExtra("name");
            NI3 ni3 = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Wired headset device ");
            sb.append(stringExtra != null ? stringExtra : "");
            sb.append(" connected");
            ni3.a("WiredHeadsetReceiver", sb.toString());
            Ha8 ha8 = this.deviceListener;
            if (ha8 != null) {
                ha8.a();
                return;
            }
            return;
        }
        String stringExtra2 = intent.getStringExtra("name");
        NI3 ni32 = this.logger;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Wired headset device ");
        sb2.append(stringExtra2 != null ? stringExtra2 : "");
        sb2.append(" disconnected");
        ni32.a("WiredHeadsetReceiver", sb2.toString());
        Ha8 ha82 = this.deviceListener;
        if (ha82 != null) {
            ha82.b();
        }
    }
}
