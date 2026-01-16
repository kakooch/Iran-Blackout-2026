package ir.nasim;

import android.net.Uri;
import java.io.File;

/* renamed from: ir.nasim.Jm2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5472Jm2 implements InterfaceC14734iO3 {
    private final boolean b(Uri uri) {
        if (AbstractC18638p.q(uri)) {
            return false;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !AbstractC13042fc3.d(scheme, "file")) {
            return false;
        }
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        return AbstractC20762sZ6.S0(path, '/', false, 2, null) && AbstractC18638p.i(uri) != null;
    }

    @Override // ir.nasim.InterfaceC14734iO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public File a(Uri uri, IL4 il4) {
        if (!b(uri)) {
            return null;
        }
        if (!AbstractC13042fc3.d(uri.getScheme(), "file")) {
            return new File(uri.toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        return null;
    }
}
