package ir.nasim;

import android.os.CancellationSignal;
import android.util.Log;

/* loaded from: classes.dex */
class RE0 {
    private final c a = new a();
    private CancellationSignal b;
    private QE0 c;

    class a implements c {
        a() {
        }

        @Override // ir.nasim.RE0.c
        public QE0 a() {
            return new QE0();
        }

        @Override // ir.nasim.RE0.c
        public CancellationSignal b() {
            return b.b();
        }
    }

    private static class b {
        static void a(CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    interface c {
        QE0 a();

        CancellationSignal b();
    }

    RE0() {
    }

    void a() {
        CancellationSignal cancellationSignal = this.b;
        if (cancellationSignal != null) {
            try {
                b.a(cancellationSignal);
            } catch (NullPointerException e) {
                Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e);
            }
            this.b = null;
        }
        QE0 qe0 = this.c;
        if (qe0 != null) {
            try {
                qe0.a();
            } catch (NullPointerException e2) {
                Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e2);
            }
            this.c = null;
        }
    }

    CancellationSignal b() {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    QE0 c() {
        if (this.c == null) {
            this.c = this.a.a();
        }
        return this.c;
    }
}
