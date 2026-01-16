package ir.nasim.designsystem;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.g;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C19406qI3;
import ir.nasim.C5735Kp4;
import ir.nasim.E15;
import ir.nasim.F15;
import ir.nasim.QI2;
import ir.nasim.X38;
import java.io.File;

/* loaded from: classes5.dex */
public class BackgroundPreviewViewGlide extends AppCompatImageView {
    private static final String f = "BackgroundPreviewViewGlide";
    private int d;
    private int e;

    public BackgroundPreviewViewGlide(Context context) {
        super(context);
    }

    public static int d(int i) {
        return (i < 0 || getDefaultBackgrounds().length <= i) ? getDefaultBackgrounds()[0] : getDefaultBackgrounds()[i];
    }

    public static int e(String str, Context context, int i) {
        if (str != null && str.startsWith("local:")) {
            int identifier = context.getResources().getIdentifier(str.replace("local:", ""), "drawable", context.getPackageName());
            for (int i2 = 0; i2 < getDefaultBackgrounds().length; i2++) {
                if (getDefaultBackgrounds()[i2] == identifier) {
                    return i2;
                }
            }
        }
        return i;
    }

    static int[] getDefaultBackgrounds() {
        return C5735Kp4.w().a.a();
    }

    public static int getSelectedBackgroundIndex() throws NumberFormatException {
        String strR2 = AbstractC5969Lp4.d().r2();
        int[] iArrA = C5735Kp4.w().a.a();
        try {
            int i = Integer.parseInt(strR2.substring(6));
            if (i >= 0) {
                if (i < iArrA.length) {
                    return i;
                }
            }
        } catch (Exception unused) {
        }
        return getSize();
    }

    public static int getSize() {
        return C5735Kp4.w().a.a().length;
    }

    public void c(int i) {
        if (i < getSize()) {
            int iD = d(i);
            Resources resources = getContext().getResources();
            ((g) ((g) QI2.h(new Uri.Builder().scheme("android.resource").authority(resources.getResourcePackageName(iD)).appendPath(resources.getResourceTypeName(iD)).appendPath(resources.getResourceEntryName(iD)).build(), getContext(), this.e, this.d).i(AbstractC23175wU1.b)).p0(true)).Q0(this);
        } else if (i > getSize()) {
            try {
                ((g) ((g) QI2.h(Uri.fromFile(new File(X38.h(), X38.a(((E15) F15.a().get((i - getSize()) - 1)).f()))), getContext(), this.e, this.d).i(AbstractC23175wU1.b)).p0(true)).Q0(this);
            } catch (Exception e) {
                C19406qI3.a(f, e.getMessage(), new Object[0]);
            }
        }
    }

    public void f(int i, int i2) {
        this.d = i;
        this.e = i2;
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setBackGroundWallpaper(Drawable drawable) {
        setImageDrawable(drawable);
    }

    public BackgroundPreviewViewGlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BackgroundPreviewViewGlide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
