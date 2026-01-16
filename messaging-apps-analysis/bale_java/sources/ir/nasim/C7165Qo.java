package ir.nasim;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;

/* renamed from: ir.nasim.Qo, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C7165Qo implements YU1 {
    private HandlerThread a;
    private Handler b;

    public C7165Qo(String str) {
        HandlerThread handlerThreadJ = SZ.j(str, 5);
        this.a = handlerThreadJ;
        handlerThreadJ.start();
        while (this.a.getLooper() == null) {
        }
        this.b = new Handler(this.a.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Runnable runnable, Object obj) {
        this.b.removeCallbacks(runnable, obj);
    }

    @Override // ir.nasim.YU1
    public EU1 a(final Runnable runnable, long j) {
        final Object obj = new Object();
        this.b.postAtTime(runnable, obj, SystemClock.uptimeMillis() + j);
        return new EU1() { // from class: ir.nasim.Po
            @Override // ir.nasim.EU1
            public final void cancel() {
                this.a.c(runnable, obj);
            }
        };
    }
}
