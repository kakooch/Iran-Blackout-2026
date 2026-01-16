package ir.nasim;

import android.os.CancellationSignal;

/* loaded from: classes2.dex */
public final class QE0 {
    private boolean a;
    private a b;
    private Object c;
    private boolean d;

    public interface a {
        void onCancel();
    }

    private void d() throws InterruptedException {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.a) {
                    return;
                }
                this.a = true;
                this.d = true;
                a aVar = this.b;
                Object obj = this.c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public Object b() {
        Object obj;
        synchronized (this) {
            try {
                if (this.c == null) {
                    CancellationSignal cancellationSignal = new CancellationSignal();
                    this.c = cancellationSignal;
                    if (this.a) {
                        cancellationSignal.cancel();
                    }
                }
                obj = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public void c(a aVar) {
        synchronized (this) {
            try {
                d();
                if (this.b == aVar) {
                    return;
                }
                this.b = aVar;
                if (this.a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }
}
