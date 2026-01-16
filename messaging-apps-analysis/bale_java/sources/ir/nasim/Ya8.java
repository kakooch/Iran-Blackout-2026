package ir.nasim;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class Ya8 {
    protected Ya8() {
    }

    public static Ya8 d(Context context) {
        return Za8.k(context);
    }

    public static void e(Context context, androidx.work.a aVar) {
        Za8.e(context, aVar);
    }

    public abstract InterfaceC15297jL4 a(String str);

    public final InterfaceC15297jL4 b(AbstractC16037kb8 abstractC16037kb8) {
        return c(Collections.singletonList(abstractC16037kb8));
    }

    public abstract InterfaceC15297jL4 c(List list);
}
