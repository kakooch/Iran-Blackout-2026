package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class JW5 implements HW5 {
    public static final C23097wL4 b = C23097wL4.e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");
    private final Context a;

    public JW5(Context context) {
        this.a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
            return this.a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.a.getPackageName())) {
                return this.a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, ConstantDeviceInfo.APP_PLATFORM);
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(Uri uri, int i, int i2, HL4 hl4) {
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            Context contextD = d(uri, authority);
            int iG = g(contextD, uri);
            Resources.Theme theme = ((String) AbstractC3322Aj5.d(authority)).equals(this.a.getPackageName()) ? (Resources.Theme) hl4.c(b) : null;
            return C16389lB4.d(theme == null ? AbstractC23486x02.b(this.a, contextD, iG) : AbstractC23486x02.a(this.a, iG, theme));
        }
        throw new IllegalStateException("Package name for " + uri + " is null or empty");
    }

    @Override // ir.nasim.HW5
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri, HL4 hl4) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("android.resource");
    }
}
