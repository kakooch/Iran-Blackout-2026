package ir.nasim;

import android.os.Looper;
import java.util.List;

/* renamed from: ir.nasim.Ro, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7399Ro implements XM3 {
    @Override // ir.nasim.XM3
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // ir.nasim.XM3
    public WM3 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C20095rT2(AbstractC21324tT2.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // ir.nasim.XM3
    public int c() {
        return 1073741823;
    }
}
