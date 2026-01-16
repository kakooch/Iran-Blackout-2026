package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes2.dex */
public class OO6 extends AbstractC11286cl0 {
    private static final String i = HI3.f("StorageNotLowTracker");

    public OO6(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(context, interfaceC5684Kj7);
    }

    @Override // ir.nasim.AbstractC11286cl0
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // ir.nasim.AbstractC11286cl0
    public void h(Context context, Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        HI3.c().a(i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            d(Boolean.FALSE);
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            d(Boolean.TRUE);
        }
    }

    @Override // ir.nasim.AbstractC15469je1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.b.registerReceiver(null, g());
        if (intentRegisterReceiver == null || intentRegisterReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = intentRegisterReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return Boolean.TRUE;
        }
        return null;
    }
}
