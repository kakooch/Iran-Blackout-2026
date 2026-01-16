package ir.nasim;

/* loaded from: classes3.dex */
final class Cq8 implements Runnable {
    final /* synthetic */ Fr8 a;

    /* synthetic */ Cq8(Fr8 fr8, Sp8 sp8) {
        this.a = fr8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jA = this.a.a();
        if (jA == -1 || BD1.a().currentTimeMillis() <= jA) {
            return;
        }
        Fr8.e(this.a.a);
    }
}
