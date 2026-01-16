package ir.nasim;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: ir.nasim.dW7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11738dW7 {
    public static View a(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewFindViewById = viewGroup.getChildAt(i2).findViewById(i);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }
}
