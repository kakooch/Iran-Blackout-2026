package ir.nasim;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class Qv8 implements Runnable {
    final /* synthetic */ yv8 a;
    final /* synthetic */ Callable b;

    Qv8(yv8 yv8Var, Callable callable) {
        this.a = yv8Var;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.s(this.b.call());
        } catch (Exception e) {
            this.a.r(e);
        } catch (Throwable th) {
            this.a.r(new RuntimeException(th));
        }
    }
}
