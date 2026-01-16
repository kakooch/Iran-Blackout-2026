package ir.nasim;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import java.util.List;

/* loaded from: classes2.dex */
public final class UW5 implements InterfaceC14734iO3 {
    private final boolean b(Uri uri) {
        String authority;
        return AbstractC13042fc3.d(uri.getScheme(), "android.resource") && (authority = uri.getAuthority()) != null && !AbstractC20762sZ6.n0(authority) && uri.getPathSegments().size() == 2;
    }

    @Override // ir.nasim.InterfaceC14734iO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Uri a(Uri uri, IL4 il4) throws PackageManager.NameNotFoundException {
        if (!b(uri)) {
            return null;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            authority = "";
        }
        Resources resourcesForApplication = il4.g().getPackageManager().getResourcesForApplication(authority);
        List<String> pathSegments = uri.getPathSegments();
        int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        if (identifier == 0) {
            throw new IllegalStateException(("Invalid android.resource URI: " + uri).toString());
        }
        return Uri.parse("android.resource://" + authority + '/' + identifier);
    }
}
