package ir.nasim;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes2.dex */
public class EW5 implements HW5 {
    private final JW5 a;
    private final InterfaceC13106fg0 b;

    public EW5(JW5 jw5, InterfaceC13106fg0 interfaceC13106fg0) {
        this.a = jw5;
        this.b = interfaceC13106fg0;
    }

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(Uri uri, int i, int i2, HL4 hl4) {
        DW5 dw5A = this.a.a(uri, i, i2, hl4);
        if (dw5A == null) {
            return null;
        }
        return F02.a(this.b, (Drawable) dw5A.get(), i, i2);
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Uri uri, HL4 hl4) {
        return "android.resource".equals(uri.getScheme());
    }
}
