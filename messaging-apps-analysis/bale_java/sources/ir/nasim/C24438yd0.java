package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: ir.nasim.yd0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24438yd0 extends AbstractC11286cl0 {
    private static final String i = HI3.f("BatteryChrgTracker");

    public C24438yd0(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(context, interfaceC5684Kj7);
    }

    private boolean j(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    @Override // ir.nasim.AbstractC11286cl0
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    @Override // ir.nasim.AbstractC11286cl0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            java.lang.String r5 = r6.getAction()
            if (r5 != 0) goto L7
            return
        L7:
            ir.nasim.HI3 r6 = ir.nasim.HI3.c()
            java.lang.String r0 = ir.nasim.C24438yd0.i
            java.lang.String r1 = "Received %s"
            java.lang.Object[] r2 = new java.lang.Object[]{r5}
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r2 = 0
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r6.a(r0, r1, r3)
            int r6 = r5.hashCode()
            r0 = -1
            switch(r6) {
                case -1886648615: goto L48;
                case -54942926: goto L3d;
                case 948344062: goto L32;
                case 1019184907: goto L27;
                default: goto L25;
            }
        L25:
            r2 = r0
            goto L51
        L27:
            java.lang.String r6 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L30
            goto L25
        L30:
            r2 = 3
            goto L51
        L32:
            java.lang.String r6 = "android.os.action.CHARGING"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L3b
            goto L25
        L3b:
            r2 = 2
            goto L51
        L3d:
            java.lang.String r6 = "android.os.action.DISCHARGING"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L46
            goto L25
        L46:
            r2 = 1
            goto L51
        L48:
            java.lang.String r6 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L51
            goto L25
        L51:
            switch(r2) {
                case 0: goto L67;
                case 1: goto L61;
                case 2: goto L5b;
                case 3: goto L55;
                default: goto L54;
            }
        L54:
            goto L6c
        L55:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r4.d(r5)
            goto L6c
        L5b:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r4.d(r5)
            goto L6c
        L61:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r4.d(r5)
            goto L6c
        L67:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r4.d(r5)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24438yd0.h(android.content.Context, android.content.Intent):void");
    }

    @Override // ir.nasim.AbstractC15469je1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return Boolean.valueOf(j(intentRegisterReceiver));
        }
        HI3.c().b(i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
