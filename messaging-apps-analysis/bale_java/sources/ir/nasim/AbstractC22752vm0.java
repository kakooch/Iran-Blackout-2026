package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;

/* renamed from: ir.nasim.vm0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22752vm0 {
    public static IBinder a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void b(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
