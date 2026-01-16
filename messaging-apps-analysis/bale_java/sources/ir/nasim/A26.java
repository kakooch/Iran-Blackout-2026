package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material.ripple.RippleContainer;

/* loaded from: classes.dex */
public abstract class A26 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final RippleContainer c(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof RippleContainer) {
                return (RippleContainer) childAt;
            }
        }
        RippleContainer rippleContainer = new RippleContainer(viewGroup.getContext());
        viewGroup.addView(rippleContainer);
        return rippleContainer;
    }

    public static final JG1 d(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0, SA2 sa2) {
        return new androidx.compose.material.ripple.b(interfaceC23241wb3, z, f, vx0, sa2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewParent] */
    public static final ViewGroup e(View view) {
        while (!(view instanceof ViewGroup)) {
            ?? parent = view.getParent();
            if (!(parent instanceof View)) {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + view + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
            view = parent;
        }
        return (ViewGroup) view;
    }
}
