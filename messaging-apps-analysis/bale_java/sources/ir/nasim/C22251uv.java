package ir.nasim;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;

/* renamed from: ir.nasim.uv, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C22251uv {
    public static final C22251uv a = new C22251uv();

    private C22251uv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(IntConsumer intConsumer, int i) {
        intConsumer.accept(i);
    }

    public final void b(C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, HandwritingGesture handwritingGesture, InterfaceC18354oW7 interfaceC18354oW7, Executor executor, final IntConsumer intConsumer, UA2 ua2) {
        final int iF = c6542Ny3 != null ? C12358eU2.a.f(c6542Ny3, handwritingGesture, c19101pm7, interfaceC18354oW7, ua2) : 3;
        if (intConsumer == null) {
            return;
        }
        if (executor != null) {
            executor.execute(new Runnable() { // from class: ir.nasim.tv
                @Override // java.lang.Runnable
                public final void run() {
                    C22251uv.c(intConsumer, iF);
                }
            });
        } else {
            intConsumer.accept(iF);
        }
    }

    public final boolean d(C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        if (c6542Ny3 != null) {
            return C12358eU2.a.p(c6542Ny3, previewableHandwritingGesture, c19101pm7, cancellationSignal);
        }
        return false;
    }
}
