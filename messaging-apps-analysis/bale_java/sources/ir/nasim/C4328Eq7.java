package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import ir.nasim.C4328Eq7;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: ir.nasim.Eq7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4328Eq7 extends AbstractC3879Ct {
    private final Timer b;
    private float c;
    private final float d;
    private final InterfaceC9173Yu3 e;

    /* renamed from: ir.nasim.Eq7$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* renamed from: ir.nasim.Eq7$b */
    public static final class b extends TimerTask {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(C4328Eq7 c4328Eq7) {
            AbstractC13042fc3.i(c4328Eq7, "this$0");
            InterfaceC25191zt interfaceC25191ztB = c4328Eq7.b();
            if (interfaceC25191ztB == null) {
                return;
            }
            interfaceC25191ztB.a(c4328Eq7.c);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C4328Eq7.this.c += 1.0f;
            final C4328Eq7 c4328Eq7 = C4328Eq7.this;
            Runnable runnable = new Runnable() { // from class: ir.nasim.Fq7
                @Override // java.lang.Runnable
                public final void run() {
                    C4328Eq7.b.b(c4328Eq7);
                }
            };
            if (AbstractC13042fc3.d(Looper.myLooper(), Looper.getMainLooper())) {
                runnable.run();
            } else {
                C4328Eq7.this.h().post(runnable);
            }
        }
    }

    public C4328Eq7(float f, float f2, long j) {
        super(f, f2, j);
        this.b = new Timer();
        this.c = f;
        this.d = j / (f2 - f);
        this.e = AbstractC13269fw3.a(a.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler h() {
        return (Handler) this.e.getValue();
    }

    @Override // ir.nasim.AbstractC3879Ct
    public void a() {
        this.b.cancel();
    }

    @Override // ir.nasim.AbstractC3879Ct
    public void d() {
        this.b.scheduleAtFixedRate(new b(), 0L, (long) this.d);
    }
}
