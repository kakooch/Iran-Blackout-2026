package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* renamed from: ir.nasim.oA0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC18149oA0 {
    static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
