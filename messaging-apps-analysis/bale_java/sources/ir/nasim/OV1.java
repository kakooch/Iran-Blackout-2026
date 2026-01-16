package ir.nasim;

import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public enum OV1 implements GV1 {
    DISPOSED;

    public static boolean a(AtomicReference atomicReference) {
        GV1 gv1;
        GV1 gv12 = (GV1) atomicReference.get();
        OV1 ov1 = DISPOSED;
        if (gv12 == ov1 || (gv1 = (GV1) atomicReference.getAndSet(ov1)) == ov1) {
            return false;
        }
        if (gv1 == null) {
            return true;
        }
        gv1.dispose();
        return true;
    }

    public static boolean p(AtomicReference atomicReference, GV1 gv1) {
        GV1 gv12;
        do {
            gv12 = (GV1) atomicReference.get();
            if (gv12 == DISPOSED) {
                if (gv1 == null) {
                    return false;
                }
                gv1.dispose();
                return false;
            }
        } while (!AbstractC16775lq5.a(atomicReference, gv12, gv1));
        return true;
    }

    public static void q() {
        D76.d(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean r(AtomicReference atomicReference, GV1 gv1) {
        Objects.requireNonNull(gv1, "d is null");
        if (AbstractC16775lq5.a(atomicReference, null, gv1)) {
            return true;
        }
        gv1.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        q();
        return false;
    }

    public static boolean s(GV1 gv1, GV1 gv12) {
        if (gv12 == null) {
            D76.d(new NullPointerException("next is null"));
            return false;
        }
        if (gv1 == null) {
            return true;
        }
        gv12.dispose();
        q();
        return false;
    }

    @Override // ir.nasim.GV1
    public void dispose() {
    }
}
