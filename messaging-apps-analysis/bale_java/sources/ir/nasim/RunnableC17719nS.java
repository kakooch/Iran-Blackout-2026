package ir.nasim;

/* renamed from: ir.nasim.nS, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC17719nS implements Runnable {
    private final D20 a;

    public RunnableC17719nS(D20 d20) {
        AbstractC13042fc3.i(d20, "balloon");
        this.a = d20;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.E();
    }
}
