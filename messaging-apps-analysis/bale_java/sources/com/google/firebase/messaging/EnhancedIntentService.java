package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.J;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C4982Hj7;
import ir.nasim.ExecutorC4596Fu5;
import ir.nasim.WI4;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public abstract class EnhancedIntentService extends Service {
    private Binder b;
    private int d;
    final ExecutorService a = AbstractC2368e.d();
    private final Object c = new Object();
    private int e = 0;

    class a implements J.a {
        a() {
        }

        @Override // com.google.firebase.messaging.J.a
        public Task a(Intent intent) {
            return EnhancedIntentService.this.j(intent);
        }
    }

    private void d(Intent intent) {
        if (intent != null) {
            H.c(intent);
        }
        synchronized (this.c) {
            try {
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    k(this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Intent intent, Task task) {
        d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Intent intent, C4982Hj7 c4982Hj7) {
        try {
            f(intent);
        } finally {
            c4982Hj7.c(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task j(final Intent intent) {
        if (g(intent)) {
            return AbstractC9078Yj7.e(null);
        }
        final C4982Hj7 c4982Hj7 = new C4982Hj7();
        this.a.execute(new Runnable() { // from class: ir.nasim.V82
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(intent, c4982Hj7);
            }
        });
        return c4982Hj7.a();
    }

    protected Intent e(Intent intent) {
        return intent;
    }

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    boolean k(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.b == null) {
                this.b = new J(new a());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, int i2) {
        synchronized (this.c) {
            this.d = i2;
            this.e++;
        }
        Intent intentE = e(intent);
        if (intentE == null) {
            d(intent);
            return 2;
        }
        Task taskJ = j(intentE);
        if (taskJ.o()) {
            d(intent);
            return 2;
        }
        taskJ.c(new ExecutorC4596Fu5(), new WI4() { // from class: ir.nasim.U82
            @Override // ir.nasim.WI4
            public final void onComplete(Task task) {
                this.a.h(intent, task);
            }
        });
        return 3;
    }
}
