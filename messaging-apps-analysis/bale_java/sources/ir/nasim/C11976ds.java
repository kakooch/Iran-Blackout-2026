package ir.nasim;

import android.content.Context;
import android.os.PowerManager;

/* renamed from: ir.nasim.ds, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11976ds implements InterfaceC22912w18 {
    private final PowerManager.WakeLock a;

    public C11976ds() {
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) C5721Ko.b.getSystemService("power")).newWakeLock(1, "NasimWakelock");
        this.a = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire(20000L);
        wakeLockNewWakeLock.setReferenceCounted(false);
        C19406qI3.a("NasimWakeLock", "acquire", new Object[0]);
    }

    @Override // ir.nasim.InterfaceC22912w18
    public void a() {
        PowerManager.WakeLock wakeLock = this.a;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.a.release();
        C19406qI3.a("NasimWakeLock", "release", new Object[0]);
    }

    public void b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        boolean zIsScreenOn = powerManager.isScreenOn();
        C19406qI3.b("screen on.................................", "" + zIsScreenOn);
        if (zIsScreenOn) {
            return;
        }
        powerManager.newWakeLock(805306394, "ir.nasim.bale:lockTag").acquire(5000L);
        powerManager.newWakeLock(1, "ir.nasim.bale:MyCpuLock").acquire(5000L);
    }
}
