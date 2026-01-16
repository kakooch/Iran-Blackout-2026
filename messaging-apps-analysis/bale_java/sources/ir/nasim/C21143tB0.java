package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: ir.nasim.tB0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C21143tB0 {
    private final PA0 a;
    private final C16455lI7 b;
    private final boolean c;
    private final C6293Mz5 d;
    private final Executor e;
    private final ScheduledExecutorService f;
    private final boolean g;
    private int h = 1;

    C21143tB0(PA0 pa0, C19349qC0 c19349qC0, C6293Mz5 c6293Mz5, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.a = pa0;
        Integer num = (Integer) c19349qC0.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.g = num != null && num.intValue() == 2;
        this.e = executor;
        this.f = scheduledExecutorService;
        this.d = c6293Mz5;
        this.b = new C16455lI7(c6293Mz5);
        this.c = AbstractC5265Ip2.a(new C20540sB0(c19349qC0));
    }

    public void a(int i) {
        this.h = i;
    }
}
