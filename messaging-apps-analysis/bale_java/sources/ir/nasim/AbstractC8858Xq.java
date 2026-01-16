package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import ir.nasim.AbstractC8858Xq;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.Xq, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC8858Xq {
    private static final AbstractC3967Dc6 a = C76.d(new Callable() { // from class: ir.nasim.Wq
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return AbstractC8858Xq.a.a;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.Xq$a */
    static final class a {
        static final AbstractC3967Dc6 a = new C23167wT2(new Handler(Looper.getMainLooper()), true);
    }

    public static AbstractC3967Dc6 c() {
        return C76.e(a);
    }
}
