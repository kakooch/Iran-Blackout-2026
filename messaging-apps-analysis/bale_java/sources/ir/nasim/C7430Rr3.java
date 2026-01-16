package ir.nasim;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;

/* renamed from: ir.nasim.Rr3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7430Rr3 extends Paint {
    public C7430Rr3() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            super.setAlpha(AbstractC7323Rf4.c(i, 0, 255));
        } else {
            setColor((AbstractC7323Rf4.c(i, 0, 255) << 24) | (getColor() & 16777215));
        }
    }

    public C7430Rr3(int i) {
        super(i);
    }

    public C7430Rr3(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public C7430Rr3(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
