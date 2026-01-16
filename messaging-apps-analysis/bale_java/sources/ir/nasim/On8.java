package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
final class On8 extends Kn8 {
    private final Nn8 b = new Nn8();

    On8() {
    }

    @Override // ir.nasim.Kn8
    public final void a(Throwable th) {
        th.printStackTrace();
        List<Throwable> listA = this.b.a(th, false);
        if (listA == null) {
            return;
        }
        synchronized (listA) {
            try {
                for (Throwable th2 : listA) {
                    System.err.print("Suppressed: ");
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
