package ir.nasim;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: ir.nasim.Ua3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7984Ua3 {

    /* renamed from: ir.nasim.Ua3$a */
    static class a {
        static <T> T[] a(Intent intent, String str, Class<T> cls) {
            return (T[]) intent.getParcelableArrayExtra(str, cls);
        }

        static <T> ArrayList<T> b(Intent intent, String str, Class<? extends T> cls) {
            return intent.getParcelableArrayListExtra(str, cls);
        }

        static <T> T c(Intent intent, String str, Class<T> cls) {
            return (T) intent.getParcelableExtra(str, cls);
        }

        static <T extends Serializable> T d(Intent intent, String str, Class<T> cls) {
            return (T) intent.getSerializableExtra(str, cls);
        }
    }

    public static Object a(Intent intent, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.c(intent, str, cls);
        }
        Parcelable parcelableExtra = intent.getParcelableExtra(str);
        if (cls.isInstance(parcelableExtra)) {
            return parcelableExtra;
        }
        return null;
    }
}
