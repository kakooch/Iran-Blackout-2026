package ir.nasim;

import android.os.Binder;

/* renamed from: ir.nasim.rp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC20332rp8 {
    public static Object a(InterfaceC20923sp8 interfaceC20923sp8) {
        try {
            return interfaceC20923sp8.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return interfaceC20923sp8.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
