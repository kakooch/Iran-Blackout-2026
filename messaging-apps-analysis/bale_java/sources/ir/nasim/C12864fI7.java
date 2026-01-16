package ir.nasim;

import ir.nasim.InterfaceC13701gg4;
import java.io.InputStream;
import java.net.URL;

/* renamed from: ir.nasim.fI7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12864fI7 implements InterfaceC13701gg4 {
    private final InterfaceC13701gg4 a;

    /* renamed from: ir.nasim.fI7$a */
    public static class a implements InterfaceC14292hg4 {
        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C12864fI7(c23932xl4.d(YI2.class, InputStream.class));
        }
    }

    public C12864fI7(InterfaceC13701gg4 interfaceC13701gg4) {
        this.a = interfaceC13701gg4;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(URL url, int i, int i2, HL4 hl4) {
        return this.a.b(new YI2(url), i, i2, hl4);
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(URL url) {
        return true;
    }
}
