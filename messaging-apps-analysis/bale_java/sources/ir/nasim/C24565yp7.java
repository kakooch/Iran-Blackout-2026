package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.yp7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24565yp7 {
    private final C22694vg2 a;
    private final boolean b;

    public C24565yp7(C22694vg2 c22694vg2, boolean z) {
        this.a = c22694vg2;
        this.b = z;
    }

    public final boolean a() {
        return this.b;
    }

    public final Bitmap b() {
        Object objB;
        C22694vg2 c22694vg2 = this.a;
        if (c22694vg2 == null) {
            return null;
        }
        try {
            C9475a16.a aVar = C9475a16.b;
            byte[] bArrC = c22694vg2.c();
            int length = c22694vg2.c().length;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            C19938rB7 c19938rB7 = C19938rB7.a;
            objB = C9475a16.b(BitmapFactory.decodeByteArray(bArrC, 0, length, options));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        return (Bitmap) (C9475a16.g(objB) ? null : objB);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24565yp7)) {
            return false;
        }
        C24565yp7 c24565yp7 = (C24565yp7) obj;
        return AbstractC13042fc3.d(this.a, c24565yp7.a) && this.b == c24565yp7.b;
    }

    public int hashCode() {
        C22694vg2 c22694vg2 = this.a;
        return ((c22694vg2 == null ? 0 : c22694vg2.hashCode()) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "ThumbnailItem(fastThumb=" + this.a + ", isVideo=" + this.b + Separators.RPAREN;
    }
}
