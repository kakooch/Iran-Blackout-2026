package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.File;

/* renamed from: ir.nasim.p43, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18683p43 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final String a;
    private final String b;
    private final InterfaceC9173Yu3 c;

    /* renamed from: ir.nasim.p43$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C18683p43(String str, String str2) {
        AbstractC13042fc3.i(str, "path");
        AbstractC13042fc3.i(str2, "name");
        this.a = str;
        this.b = str2;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.o43
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C18683p43.f(this.a));
            }
        });
    }

    private final Integer[] d() {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            String path = Uri.parse(this.a).getPath();
            BitmapFactory.decodeFile(path != null ? new File(path).getAbsolutePath() : null, options);
            return new Integer[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)};
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            return null;
        }
    }

    private final boolean e() {
        Integer[] numArrD = d();
        return numArrD == null || numArrD[0].intValue() == numArrD[1].intValue() || numArrD[0].intValue() > numArrD[1].intValue() || ((double) numArrD[0].intValue()) * 1.3d > ((double) numArrD[1].intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(C18683p43 c18683p43) {
        AbstractC13042fc3.i(c18683p43, "this$0");
        return !c18683p43.e() ? 1 : 0;
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return ((Number) this.c.getValue()).intValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C18683p43)) {
            return false;
        }
        C18683p43 c18683p43 = (C18683p43) obj;
        return AbstractC13042fc3.d(this.a, c18683p43.a) && AbstractC13042fc3.d(this.b, c18683p43.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ImportedPhoto(path=" + this.a + ", name=" + this.b + Separators.RPAREN;
    }
}
