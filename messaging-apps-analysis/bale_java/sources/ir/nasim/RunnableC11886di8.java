package ir.nasim;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* renamed from: ir.nasim.di8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC11886di8 implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ InterfaceC21590tn8 b;
    final /* synthetic */ C13725gi8 c;

    RunnableC11886di8(C13725gi8 c13725gi8, List list, InterfaceC21590tn8 interfaceC21590tn8) {
        this.c = c13725gi8;
        this.a = list;
        this.b = interfaceC21590tn8;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.c.c.b(this.a)) {
                C13725gi8.d(this.c, this.b);
            } else {
                C13725gi8.c(this.c, this.a, this.b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.b.l(-11);
        }
    }
}
