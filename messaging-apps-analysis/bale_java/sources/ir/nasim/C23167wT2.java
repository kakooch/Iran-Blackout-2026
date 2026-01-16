package ir.nasim;

import android.os.Handler;
import android.os.Message;
import ir.nasim.AbstractC3967Dc6;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.wT2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23167wT2 extends AbstractC3967Dc6 {
    private final Handler b;
    private final boolean c;

    /* renamed from: ir.nasim.wT2$a */
    private static final class a extends AbstractC3967Dc6.a {
        private final Handler a;
        private final boolean b;
        private volatile boolean c;

        a(Handler handler, boolean z) {
            this.a = handler;
            this.b = z;
        }

        @Override // ir.nasim.AbstractC3967Dc6.a
        public GV1 a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.c) {
                return GV1.j();
            }
            b bVar = new b(this.a, D76.e(runnable));
            Message messageObtain = Message.obtain(this.a, bVar);
            messageObtain.obj = this;
            if (this.b) {
                messageObtain.setAsynchronous(true);
            }
            this.a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.c) {
                return bVar;
            }
            this.a.removeCallbacks(bVar);
            return GV1.j();
        }

        @Override // ir.nasim.GV1
        public void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: ir.nasim.wT2$b */
    private static final class b implements Runnable, GV1 {
        private final Handler a;
        private final Runnable b;
        private volatile boolean c;

        b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        @Override // ir.nasim.GV1
        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                D76.d(th);
            }
        }
    }

    C23167wT2(Handler handler, boolean z) {
        this.b = handler;
        this.c = z;
    }

    @Override // ir.nasim.AbstractC3967Dc6
    public AbstractC3967Dc6.a a() {
        return new a(this.b, this.c);
    }
}
