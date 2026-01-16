package ir.nasim;

import android.gov.nist.core.Separators;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import ir.nasim.InterfaceC22734vk2;
import okio.Okio;

/* renamed from: ir.nasim.vK, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22487vK implements InterfaceC22734vk2 {
    private final Uri a;
    private final IL4 b;

    /* renamed from: ir.nasim.vK$a */
    public static final class a implements InterfaceC22734vk2.a {
        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(Uri uri, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            if (AbstractC18638p.q(uri)) {
                return new C22487vK(uri, il4);
            }
            return null;
        }
    }

    public C22487vK(Uri uri, IL4 il4) {
        this.a = uri;
        this.b = il4;
    }

    @Override // ir.nasim.InterfaceC22734vk2
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        String strA0 = AbstractC15401jX0.A0(AbstractC15401jX0.k0(this.a.getPathSegments(), 1), Separators.SLASH, null, null, 0, null, null, 62, null);
        return new WH6(AbstractC11466d33.b(Okio.buffer(Okio.source(this.b.g().getAssets().open(strA0))), this.b.g(), new C21223tK(strA0)), AbstractC18638p.k(MimeTypeMap.getSingleton(), strA0), EnumC21699tz1.c);
    }
}
