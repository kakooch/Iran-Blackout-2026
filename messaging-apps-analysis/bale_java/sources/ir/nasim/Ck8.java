package ir.nasim;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class Ck8 extends AbstractBinderC18501ol8 {
    private final AtomicReference a = new AtomicReference();
    private boolean h;

    public static final Object F2(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", cls.getCanonicalName(), obj.getClass().getCanonicalName()), e);
            throw e;
        }
    }

    public final Bundle C2(long j) {
        Bundle bundle;
        synchronized (this.a) {
            if (!this.h) {
                try {
                    this.a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.a.get();
        }
        return bundle;
    }

    public final Long D2(long j) {
        return (Long) F2(C2(j), Long.class);
    }

    public final String E2(long j) {
        return (String) F2(C2(j), String.class);
    }

    @Override // ir.nasim.InterfaceC19683ql8
    public final void F1(Bundle bundle) {
        synchronized (this.a) {
            try {
                try {
                    this.a.set(bundle);
                    this.h = true;
                } finally {
                    this.a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
