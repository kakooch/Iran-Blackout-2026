package ir.nasim;

/* renamed from: ir.nasim.aX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9773aX7 {
    private static final B47 a = new B47();

    public static final InterfaceC20315ro1 a(VW7 vw7) {
        WV0 wv0A;
        AbstractC13042fc3.i(vw7, "<this>");
        synchronized (a) {
            wv0A = (WV0) vw7.K0("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if (wv0A == null) {
                wv0A = XV0.a();
                vw7.I0("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", wv0A);
            }
        }
        return wv0A;
    }
}
