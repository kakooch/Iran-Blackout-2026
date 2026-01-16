package ir.nasim;

/* loaded from: classes6.dex */
public final class OE0 implements Runnable {
    private final Runnable a;
    private boolean b;

    public OE0(Runnable runnable) {
        AbstractC13042fc3.i(runnable, "runnable");
        this.a = runnable;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b) {
            return;
        }
        this.a.run();
    }
}
