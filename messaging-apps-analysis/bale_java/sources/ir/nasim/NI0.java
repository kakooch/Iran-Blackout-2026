package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.transition.ChangeImageTransform;
import android.transition.TransitionValues;
import android.view.View;
import android.widget.ImageView;
import java.util.Map;

/* loaded from: classes8.dex */
public final class NI0 extends ChangeImageTransform {
    private static final a b = new a(null);
    private View a;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final void b(TransitionValues transitionValues) {
        Drawable drawable;
        View view = transitionValues.view;
        AbstractC13042fc3.h(view, "view");
        if ((view instanceof ImageView) && view.getVisibility() == 0 && (drawable = ((ImageView) view).getDrawable()) != null) {
            Map map = transitionValues.values;
            AbstractC13042fc3.h(map, "values");
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            float fMax = Math.max(r5.width() / intrinsicWidth, r5.height() / intrinsicHeight);
            float f = intrinsicHeight * fMax;
            Matrix matrix = new Matrix();
            matrix.setScale(fMax, fMax);
            float fWidth = r5.width() - (intrinsicWidth * fMax);
            float f2 = 2;
            matrix.postTranslate(fWidth / f2, (r5.height() - f) / f2);
            map.put("android:changeImageTransform:matrix", matrix);
        }
    }

    public final void c(View view) {
        this.a = view;
    }

    @Override // android.transition.ChangeImageTransform, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        AbstractC13042fc3.i(transitionValues, "transitionValues");
        if (this.a != null) {
            b(transitionValues);
        } else {
            super.captureEndValues(transitionValues);
        }
    }

    @Override // android.transition.ChangeImageTransform, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        AbstractC13042fc3.i(transitionValues, "transitionValues");
        if (this.a == null) {
            b(transitionValues);
        } else {
            super.captureStartValues(transitionValues);
        }
    }
}
