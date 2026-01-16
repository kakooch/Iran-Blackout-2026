package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.security.MessageDigest;

/* renamed from: ir.nasim.Ih0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C5191Ih0 extends AbstractC14898ig0 {
    private final int b;
    private final int c;

    public C5191Ih0(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        messageDigest.update(("ir.nasim.image.BlurTransformation.1" + this.b + this.c).getBytes(InterfaceC14373ho3.a));
    }

    @Override // ir.nasim.AbstractC14898ig0
    protected Bitmap d(Context context, InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.c;
        Bitmap bitmapD = interfaceC13106fg0.d(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        c(bitmap, bitmapD);
        Canvas canvas = new Canvas(bitmapD);
        int i4 = this.c;
        canvas.scale(1.0f / i4, 1.0f / i4);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return AbstractC7555Sf2.a(bitmapD, this.b, true);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (obj instanceof C5191Ih0) {
            C5191Ih0 c5191Ih0 = (C5191Ih0) obj;
            if (c5191Ih0.b == this.b && c5191Ih0.c == this.c) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return 1681976821 + (this.b * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) + (this.c * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.b + ", sampling=" + this.c + Separators.RPAREN;
    }
}
