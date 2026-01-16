package ir.nasim;

/* loaded from: classes5.dex */
public interface XZ extends InterfaceC18633oz3 {
    static /* synthetic */ void N4(XZ xz, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResumeConfirmed");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        xz.s2(z);
    }

    static /* synthetic */ void p4(XZ xz, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPauseConfirmed");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        xz.m5(z);
    }

    void U1(boolean z);

    default void V4(WZ wz) {
        AbstractC13042fc3.i(wz, "observer");
    }

    default void m5(boolean z) {
        if (!z && s3()) {
            U1(false);
        }
    }

    default void q4(WZ wz) {
        AbstractC13042fc3.i(wz, "observer");
    }

    default void s2(boolean z) {
        if (z || s3()) {
            return;
        }
        U1(true);
    }

    boolean s3();
}
