package ir.nasim;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* renamed from: ir.nasim.nV3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17750nV3 {
    private static final int[] a = {android.R.attr.theme, AbstractC12181eA5.theme};
    private static final int[] b = {AbstractC12181eA5.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i, int i2) {
        int iB = b(context, attributeSet, i, i2);
        boolean z = (context instanceof C16731lm1) && ((C16731lm1) context).c() == iB;
        if (iB == 0 || z) {
            return context;
        }
        C16731lm1 c16731lm1 = new C16731lm1(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            c16731lm1.getTheme().applyStyle(iA, true);
        }
        return c16731lm1;
    }
}
