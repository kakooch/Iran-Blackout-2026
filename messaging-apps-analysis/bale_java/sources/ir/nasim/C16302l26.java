package ir.nasim;

import android.content.ContentResolver;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ir.nasim.l26, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16302l26 {
    public static final C16302l26 a = new C16302l26();

    private C16302l26() {
    }

    private final String b(String str) {
        if (str == null) {
            return null;
        }
        String strSubstring = str.substring(AbstractC20762sZ6.q0(str, '@', 0, false, 6, null) + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final String c(ContentResolver contentResolver, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Settings.System.class.getMethod("getStringForUser", ContentResolver.class, String.class, Integer.TYPE).invoke(Settings.System.class, contentResolver, "ringtone", Integer.valueOf(i));
            AbstractC13042fc3.g(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private final Uri d(Uri uri) {
        Uri.Builder builderBuildUpon;
        Uri.Builder builderAuthority;
        if (uri == null || (builderBuildUpon = uri.buildUpon()) == null || (builderAuthority = builderBuildUpon.authority(b(uri.getAuthority()))) == null) {
            return null;
        }
        return builderAuthority.build();
    }

    private final int e(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Context.class.getMethod("getUserId", null).invoke(context, null);
            if (objInvoke instanceof Integer) {
                return ((Number) objInvoke).intValue();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private final int f(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            int iQ0 = AbstractC20762sZ6.q0(str, '@', 0, false, 6, null);
            if (iQ0 == -1) {
                return i;
            }
            String strSubstring = str.substring(0, iQ0);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return strSubstring != null ? Integer.parseInt(strSubstring) : i;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public final Uri a(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(context, "context");
        try {
            return RingtoneManager.getActualDefaultRingtoneUri(context, 1);
        } catch (SecurityException unused) {
            ContentResolver contentResolver = context.getContentResolver();
            AbstractC13042fc3.h(contentResolver, "getContentResolver(...)");
            String strC = c(contentResolver, e(context));
            Uri uri = strC != null ? Uri.parse(strC) : null;
            return (uri == null || f(uri.getAuthority(), e(context)) != e(context)) ? uri : d(uri);
        }
    }
}
