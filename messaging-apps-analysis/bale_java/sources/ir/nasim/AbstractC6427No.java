package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.No, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6427No {
    public static final WH1 a(Context context) {
        float f = context.getResources().getConfiguration().fontScale;
        float f2 = context.getResources().getDisplayMetrics().density;
        InterfaceC21654tu2 interfaceC21654tu2B = C22244uu2.a.b(f);
        if (interfaceC21654tu2B == null) {
            interfaceC21654tu2B = new C6057Lz3(f);
        }
        return new ZH1(f2, f, interfaceC21654tu2B);
    }
}
