package ir.nasim;

import android.util.Log;
import java.io.File;

/* loaded from: classes3.dex */
final class Hj8 implements InterfaceC25090zi8 {
    Hj8() {
    }

    @Override // ir.nasim.InterfaceC25090zi8
    public final boolean a(Object obj, File file, File file2) {
        try {
            return !((Boolean) com.google.android.play.core.splitinstall.internal.c.f(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
