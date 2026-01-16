package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraValidator;
import ir.nasim.InterfaceC21050t16;

/* loaded from: classes.dex */
public final class g implements InterfaceC21050t16.b {
    private final int a;
    private final int b;
    private final long c;
    private final Throwable d;

    public g(long j, int i, Throwable th) {
        this.c = SystemClock.elapsedRealtime() - j;
        this.b = i;
        if (th instanceof CameraValidator.CameraIdListIncorrectException) {
            this.a = 2;
            this.d = th;
            return;
        }
        if (!(th instanceof InitializationException)) {
            this.a = 0;
            this.d = th;
            return;
        }
        Throwable cause = th.getCause();
        th = cause != null ? cause : th;
        this.d = th;
        if (th instanceof CameraUnavailableException) {
            this.a = 2;
        } else if (th instanceof IllegalArgumentException) {
            this.a = 1;
        } else {
            this.a = 0;
        }
    }

    @Override // ir.nasim.InterfaceC21050t16.b
    public Throwable a() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC21050t16.b
    public long b() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC21050t16.b
    public int j() {
        return this.a;
    }
}
