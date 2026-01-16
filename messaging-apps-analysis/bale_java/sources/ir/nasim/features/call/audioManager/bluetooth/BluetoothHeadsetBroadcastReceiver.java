package ir.nasim.features.call.audioManager.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/features/call/audioManager/bluetooth/BluetoothHeadsetBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lir/nasim/rB7;", "onConnectionStateChanged", "Lkotlin/Function2;", "", "onAudioStateChanged", "<init>", "(Landroid/content/Context;Lir/nasim/UA2;Lir/nasim/iB2;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "(Landroid/content/Context;)V", "Lir/nasim/UA2;", "b", "Lir/nasim/iB2;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class BluetoothHeadsetBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    private final UA2 onConnectionStateChanged;

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC14603iB2 onAudioStateChanged;

    public BluetoothHeadsetBroadcastReceiver(Context context, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(ua2, "onConnectionStateChanged");
        AbstractC13042fc3.i(interfaceC14603iB2, "onAudioStateChanged");
        this.onConnectionStateChanged = ua2;
        this.onAudioStateChanged = interfaceC14603iB2;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        context.registerReceiver(this, intentFilter);
    }

    public final void a(Context context) {
        AbstractC13042fc3.i(context, "context");
        context.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        if (AbstractC13042fc3.d(intent.getAction(), "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
            this.onConnectionStateChanged.invoke(Integer.valueOf(intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0)));
        } else if (AbstractC13042fc3.d(intent.getAction(), "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
            this.onAudioStateChanged.invoke(Integer.valueOf(intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10)), Boolean.valueOf(isInitialStickyBroadcast()));
        }
    }
}
