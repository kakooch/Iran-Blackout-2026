package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* renamed from: ir.nasim.af8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9851af8 {
    private static final C24792zC6 a = new C24792zC6();
    private static Locale b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return Fb8.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(AbstractC21166tD5.common_google_play_services_notification_channel_name);
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        return i != 1 ? i != 2 ? i != 3 ? resources.getString(android.R.string.ok) : resources.getString(AbstractC21166tD5.common_google_play_services_enable_button) : resources.getString(AbstractC21166tD5.common_google_play_services_update_button) : resources.getString(AbstractC21166tD5.common_google_play_services_install_button);
    }

    public static String d(Context context, int i) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i == 1) {
            return resources.getString(AbstractC21166tD5.common_google_play_services_install_text, strA);
        }
        if (i == 2) {
            return AbstractC20013rK1.d(context) ? resources.getString(AbstractC21166tD5.common_google_play_services_wear_update_text) : resources.getString(AbstractC21166tD5.common_google_play_services_update_text, strA);
        }
        if (i == 3) {
            return resources.getString(AbstractC21166tD5.common_google_play_services_enable_text, strA);
        }
        if (i == 5) {
            return h(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i == 7) {
            return h(context, "common_google_play_services_network_error_text", strA);
        }
        if (i == 9) {
            return resources.getString(AbstractC21166tD5.common_google_play_services_unsupported_text, strA);
        }
        if (i == 20) {
            return h(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i) {
            case 16:
                return h(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return h(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(AbstractC21166tD5.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(AbstractC21840uD5.common_google_play_services_unknown_issue, strA);
        }
    }

    public static String e(Context context, int i) {
        return (i == 6 || i == 19) ? h(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i);
    }

    public static String f(Context context, int i) {
        String strI = i == 6 ? i(context, "common_google_play_services_resolution_required_title") : g(context, i);
        return strI == null ? context.getResources().getString(AbstractC21166tD5.common_google_play_services_notification_ticker) : strI;
    }

    public static String g(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(AbstractC21166tD5.common_google_play_services_install_title);
            case 2:
                return resources.getString(AbstractC21166tD5.common_google_play_services_update_title);
            case 3:
                return resources.getString(AbstractC21166tD5.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String h(Context context, String str, String str2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        String strI = i(context, str);
        if (strI == null) {
            strI = resources.getString(AbstractC21840uD5.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strI, str2);
    }

    private static String i(Context context, String str) {
        C24792zC6 c24792zC6 = a;
        synchronized (c24792zC6) {
            try {
                Locale localeC = AbstractC9243Zc1.a(context.getResources().getConfiguration()).c(0);
                if (!localeC.equals(b)) {
                    c24792zC6.clear();
                    b = localeC;
                }
                String str2 = (String) c24792zC6.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesD = com.google.android.gms.common.c.d(context);
                if (resourcesD == null) {
                    return null;
                }
                int identifier = resourcesD.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: " + str);
                    return null;
                }
                String string = resourcesD.getString(identifier);
                if (!TextUtils.isEmpty(string)) {
                    c24792zC6.put(str, string);
                    return string;
                }
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
