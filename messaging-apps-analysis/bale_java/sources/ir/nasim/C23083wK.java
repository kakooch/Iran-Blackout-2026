package ir.nasim;

import android.content.res.AssetManager;
import android.net.Uri;
import ir.nasim.InterfaceC13701gg4;

/* renamed from: ir.nasim.wK, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23083wK implements InterfaceC13701gg4 {
    private static final int c = 22;
    private final AssetManager a;
    private final a b;

    /* renamed from: ir.nasim.wK$a */
    public interface a {
        InterfaceC8666Wy1 a(AssetManager assetManager, String str);
    }

    /* renamed from: ir.nasim.wK$b */
    public static class b implements InterfaceC14292hg4, a {
        private final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // ir.nasim.C23083wK.a
        public InterfaceC8666Wy1 a(AssetManager assetManager, String str) {
            return new C12522el2(assetManager, str);
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C23083wK(this.a, this);
        }
    }

    /* renamed from: ir.nasim.wK$c */
    public static class c implements InterfaceC14292hg4, a {
        private final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // ir.nasim.C23083wK.a
        public InterfaceC8666Wy1 a(AssetManager assetManager, String str) {
            return new NX6(assetManager, str);
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C23083wK(this.a, this);
        }
    }

    public C23083wK(AssetManager assetManager, a aVar) {
        this.a = assetManager;
        this.b = aVar;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Uri uri, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(uri), this.b.a(this.a, uri.toString().substring(c)));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
