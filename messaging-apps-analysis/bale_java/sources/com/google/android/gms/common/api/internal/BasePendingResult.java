package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC22929w35;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.InterfaceC10069b16;
import ir.nasim.Vf8;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* loaded from: classes3.dex */
public abstract class BasePendingResult<R extends InterfaceC10069b16> extends AbstractC22929w35 {
    static final ThreadLocal zaa = new M();
    protected final a zab;
    protected final WeakReference zac;
    private InterfaceC10069b16 zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private final Object zae = new Object();
    private final CountDownLatch zaf = new CountDownLatch(1);
    private final ArrayList zag = new ArrayList();
    private final AtomicReference zai = new AtomicReference();
    private boolean zaq = false;

    public static class a extends Vf8 {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                AbstractC18350oW3.a(pair.first);
                InterfaceC10069b16 interfaceC10069b16 = (InterfaceC10069b16) pair.second;
                try {
                    throw null;
                } catch (RuntimeException e) {
                    BasePendingResult.zal(interfaceC10069b16);
                    throw e;
                }
            }
            if (i == 2) {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.i);
                return;
            }
            Log.wtf("BasePendingResult", "Don't know how to handle message: " + i, new Exception());
        }
    }

    protected BasePendingResult(com.google.android.gms.common.api.c cVar) {
        this.zab = new a(cVar != null ? cVar.c() : Looper.getMainLooper());
        this.zac = new WeakReference(cVar);
    }

    private final InterfaceC10069b16 b() {
        InterfaceC10069b16 interfaceC10069b16;
        synchronized (this.zae) {
            AbstractC3795Cj5.n(!this.zal, "Result has already been consumed.");
            AbstractC3795Cj5.n(isReady(), "Result is not ready.");
            interfaceC10069b16 = this.zaj;
            this.zaj = null;
            this.zal = true;
        }
        AbstractC18350oW3.a(this.zai.getAndSet(null));
        return (InterfaceC10069b16) AbstractC3795Cj5.j(interfaceC10069b16);
    }

    private final void c(InterfaceC10069b16 interfaceC10069b16) {
        this.zaj = interfaceC10069b16;
        this.zak = interfaceC10069b16.j();
        this.zaf.countDown();
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC22929w35.a) arrayList.get(i)).a(this.zak);
        }
        this.zag.clear();
    }

    protected abstract InterfaceC10069b16 a(Status status);

    @Override // ir.nasim.AbstractC22929w35
    public final void addStatusListener(AbstractC22929w35.a aVar) {
        AbstractC3795Cj5.b(aVar != null, "Callback cannot be null.");
        synchronized (this.zae) {
            try {
                if (isReady()) {
                    aVar.a(this.zak);
                } else {
                    this.zag.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.AbstractC22929w35
    public final R await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            AbstractC3795Cj5.i("await must not be called on the UI thread when time is greater than zero.");
        }
        AbstractC3795Cj5.n(!this.zal, "Result has already been consumed.");
        AbstractC3795Cj5.n(true, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.i);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.g);
        }
        AbstractC3795Cj5.n(isReady(), "Result is not ready.");
        return (R) b();
    }

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            try {
                if (!isReady()) {
                    setResult(a(status));
                    this.zan = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    public final void setResult(R r) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r);
                    return;
                }
                isReady();
                AbstractC3795Cj5.n(!isReady(), "Results have already been set");
                AbstractC3795Cj5.n(!this.zal, "Result has already been consumed");
                c(r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zak() {
        boolean z = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z = false;
        }
        this.zaq = z;
    }

    public static void zal(InterfaceC10069b16 interfaceC10069b16) {
    }
}
