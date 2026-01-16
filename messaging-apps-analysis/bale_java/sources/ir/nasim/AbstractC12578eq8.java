package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/* renamed from: ir.nasim.eq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12578eq8 {
    public static String a(String str, String[] strArr, String[] strArr2) {
        AbstractC3795Cj5.j(strArr);
        AbstractC3795Cj5.j(strArr2);
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i];
            }
        }
        return null;
    }

    public static String b(Context context, String str, String str2) {
        AbstractC3795Cj5.j(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = Pn8.a(context);
        }
        return Pn8.b("google_app_id", resources, str2);
    }
}
