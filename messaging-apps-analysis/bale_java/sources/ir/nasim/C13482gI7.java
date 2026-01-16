package ir.nasim;

import android.net.Uri;
import ir.nasim.InterfaceC13701gg4;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: ir.nasim.gI7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13482gI7 implements InterfaceC13701gg4 {
    private static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final InterfaceC13701gg4 a;

    /* renamed from: ir.nasim.gI7$a */
    public static class a implements InterfaceC14292hg4 {
        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C13482gI7(c23932xl4.d(YI2.class, InputStream.class));
        }
    }

    public C13482gI7(InterfaceC13701gg4 interfaceC13701gg4) {
        this.a = interfaceC13701gg4;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Uri uri, int i, int i2, HL4 hl4) {
        return this.a.b(new YI2(uri.toString()), i, i2, hl4);
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
