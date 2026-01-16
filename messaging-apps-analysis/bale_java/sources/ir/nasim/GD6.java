package ir.nasim;

import android.content.Context;
import ir.nasim.InterfaceC21332tU1;

/* loaded from: classes2.dex */
public final class GD6 {
    public static final GD6 a = new GD6();
    private static InterfaceC21332tU1 b;

    private GD6() {
    }

    public final synchronized InterfaceC21332tU1 a(Context context) {
        InterfaceC21332tU1 interfaceC21332tU1A;
        interfaceC21332tU1A = b;
        if (interfaceC21332tU1A == null) {
            interfaceC21332tU1A = new InterfaceC21332tU1.a().b(AbstractC12542en2.w(AbstractC18638p.m(context), "image_cache")).a();
            b = interfaceC21332tU1A;
        }
        return interfaceC21332tU1A;
    }
}
