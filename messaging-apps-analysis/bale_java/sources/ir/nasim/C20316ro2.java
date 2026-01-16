package ir.nasim;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.k;
import java.io.InputStream;
import java.util.List;

/* renamed from: ir.nasim.ro2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20316ro2 implements k.a {
    private final k.a a;
    private final List b;

    public C20316ro2(k.a aVar, List list) {
        this.a = aVar;
        this.b = list;
    }

    @Override // com.google.android.exoplayer2.upstream.k.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC18525oo2 a(Uri uri, InputStream inputStream) {
        InterfaceC18525oo2 interfaceC18525oo2 = (InterfaceC18525oo2) this.a.a(uri, inputStream);
        List list = this.b;
        return (list == null || list.isEmpty()) ? interfaceC18525oo2 : (InterfaceC18525oo2) interfaceC18525oo2.a(this.b);
    }
}
