package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes3.dex */
public final class Xs8 {
    private static final Uri f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    private final String a;
    private final String b;
    private final ComponentName c;
    private final int d;
    private final boolean e;

    public Xs8(String str, String str2, int i, boolean z) {
        AbstractC3795Cj5.f(str);
        this.a = str;
        AbstractC3795Cj5.f(str2);
        this.b = str2;
        this.c = null;
        this.d = 4225;
        this.e = z;
    }

    public final ComponentName a() {
        return this.c;
    }

    public final Intent b(Context context) {
        Bundle bundleCall;
        if (this.a == null) {
            return new Intent().setComponent(this.c);
        }
        if (this.e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.a);
            try {
                bundleCall = context.getContentResolver().call(f, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.a)));
            }
        }
        return intent == null ? new Intent(this.a).setPackage(this.b) : intent;
    }

    public final String c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Xs8)) {
            return false;
        }
        Xs8 xs8 = (Xs8) obj;
        return DG4.a(this.a, xs8.a) && DG4.a(this.b, xs8.b) && DG4.a(this.c, xs8.c) && this.e == xs8.e;
    }

    public final int hashCode() {
        return DG4.b(this.a, this.b, this.c, 4225, Boolean.valueOf(this.e));
    }

    public final String toString() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        AbstractC3795Cj5.j(this.c);
        return this.c.flattenToString();
    }
}
