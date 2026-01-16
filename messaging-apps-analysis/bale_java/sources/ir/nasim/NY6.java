package ir.nasim;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import ir.nasim.InterfaceC13701gg4;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class NY6 implements InterfaceC13701gg4 {
    private final InterfaceC13701gg4 a;

    public static final class a implements InterfaceC14292hg4 {
        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new NY6(c23932xl4.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements InterfaceC14292hg4 {
        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new NY6(c23932xl4.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements InterfaceC14292hg4 {
        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new NY6(c23932xl4.d(Uri.class, InputStream.class));
        }
    }

    public NY6(InterfaceC13701gg4 interfaceC13701gg4) {
        this.a = interfaceC13701gg4;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(String str, int i, int i2, HL4 hl4) {
        Uri uriE = e(str);
        if (uriE == null || !this.a.a(uriE)) {
            return null;
        }
        return this.a.b(uriE, i, i2, hl4);
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(String str) {
        return true;
    }
}
