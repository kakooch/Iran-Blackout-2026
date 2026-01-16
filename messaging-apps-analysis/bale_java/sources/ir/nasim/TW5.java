package ir.nasim;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import ir.nasim.InterfaceC13701gg4;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes2.dex */
public final class TW5 implements InterfaceC13701gg4 {
    private final Context a;
    private final InterfaceC13701gg4 b;

    private static final class a implements InterfaceC14292hg4 {
        private final Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new TW5(this.a, c23932xl4.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    private static final class b implements InterfaceC14292hg4 {
        private final Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new TW5(this.a, c23932xl4.d(Integer.class, InputStream.class));
        }
    }

    TW5(Context context, InterfaceC13701gg4 interfaceC13701gg4) {
        this.a = context.getApplicationContext();
        this.b = interfaceC13701gg4;
    }

    public static InterfaceC14292hg4 e(Context context) {
        return new a(context);
    }

    public static InterfaceC14292hg4 f(Context context) {
        return new b(context);
    }

    private InterfaceC13701gg4.a g(Uri uri, int i, int i2, HL4 hl4) throws NumberFormatException {
        try {
            int i3 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i3 != 0) {
                return this.b.b(Integer.valueOf(i3), i, i2, hl4);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    private InterfaceC13701gg4.a h(Uri uri, int i, int i2, HL4 hl4) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.a.getPackageName());
        if (identifier != 0) {
            return this.b.b(Integer.valueOf(identifier), i, i2, hl4);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
        return null;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Uri uri, int i, int i2, HL4 hl4) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i, i2, hl4);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i, i2, hl4);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.a.getPackageName().equals(uri.getAuthority());
    }
}
