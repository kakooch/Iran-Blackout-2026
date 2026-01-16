package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class d {

    static class a {
        public final Parcelable[] a;

        a(Parcelable[] parcelableArr) {
            this.a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.a);
            return bundle;
        }
    }

    static class b {
        public final String a;
        public final int b;

        b(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public static b a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    static class c {
        public final String a;

        c(String str) {
            this.a = str;
        }

        public static c a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* renamed from: androidx.browser.trusted.d$d, reason: collision with other inner class name */
    static class C0016d {
        public final String a;
        public final int b;
        public final Notification c;
        public final String d;

        C0016d(String str, int i, Notification notification, String str2) {
            this.a = str;
            this.b = i;
            this.c = notification;
            this.d = str2;
        }

        public static C0016d a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            d.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new C0016d(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    static class e {
        public final boolean a;

        e(boolean z) {
            this.a = z;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.a);
            return bundle;
        }
    }

    static void a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        throw new IllegalArgumentException("Bundle must contain " + str);
    }
}
