package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: ir.nasim.Ad0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3263Ad0 extends AbstractC11286cl0 {
    private static final String i = HI3.f("BatteryNotLowTracker");

    public C3263Ad0(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(context, interfaceC5684Kj7);
    }

    @Override // ir.nasim.AbstractC11286cl0
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
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
        if (action.equals("android.intent.action.BATTERY_OKAY")) {
            d(Boolean.TRUE);
        } else if (action.equals("android.intent.action.BATTERY_LOW")) {
            d(Boolean.FALSE);
        }
    }

    @Override // ir.nasim.AbstractC15469je1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return Boolean.valueOf(intentRegisterReceiver.getIntExtra("status", -1) == 1 || ((float) intentRegisterReceiver.getIntExtra("level", -1)) / ((float) intentRegisterReceiver.getIntExtra("scale", -1)) > 0.15f);
        }
        HI3.c().b(i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
