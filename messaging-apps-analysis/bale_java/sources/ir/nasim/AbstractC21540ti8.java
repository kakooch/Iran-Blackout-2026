package ir.nasim;

import android.os.Build;

/* renamed from: ir.nasim.ti8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC21540ti8 {
    public static InterfaceC19653qi8 a() {
        switch (Build.VERSION.SDK_INT) {
            case 24:
                return new Vi8();
            case 25:
                return new Cj8();
            case 26:
                return new Jj8();
            case 27:
                if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                    return new Oj8();
                }
                break;
        }
        return new Sj8();
    }
}
