package ir.nasim;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class VS extends LD0 {
    private final Executor a;
    private final Handler b;

    VS(Executor executor, Handler handler) {
        if (executor == null) {
            throw new NullPointerException("Null cameraExecutor");
        }
        this.a = executor;
        if (handler == null) {
            throw new NullPointerException("Null schedulerHandler");
        }
        this.b = handler;
    }

    @Override // ir.nasim.LD0
    public Executor b() {
        return this.a;
    }

    @Override // ir.nasim.LD0
    public Handler c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LD0)) {
            return false;
        }
        LD0 ld0 = (LD0) obj;
        return this.a.equals(ld0.b()) && this.b.equals(ld0.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.a + ", schedulerHandler=" + this.b + "}";
    }
}
