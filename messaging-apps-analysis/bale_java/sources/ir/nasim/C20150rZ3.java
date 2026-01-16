package ir.nasim;

import android.content.Context;
import android.net.Uri;
import ir.nasim.InterfaceC13701gg4;

/* renamed from: ir.nasim.rZ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20150rZ3 implements InterfaceC13701gg4 {
    private final Context a;

    /* renamed from: ir.nasim.rZ3$a */
    public static class a implements InterfaceC14292hg4 {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C20150rZ3(this.a);
        }
    }

    public C20150rZ3(Context context) {
        this.a = context.getApplicationContext();
    }

    private boolean e(HL4 hl4) {
        Long l = (Long) hl4.c(PS7.d);
        return l != null && l.longValue() == -1;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Uri uri, int i, int i2, HL4 hl4) {
        if (AbstractC19559qZ3.e(i, i2) && e(hl4)) {
            return new InterfaceC13701gg4.a(new C22456vG4(uri), C22789vp7.g(this.a, uri));
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return AbstractC19559qZ3.d(uri);
    }
}
