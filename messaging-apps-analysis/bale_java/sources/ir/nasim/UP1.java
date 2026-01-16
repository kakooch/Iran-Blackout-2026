package ir.nasim;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

/* loaded from: classes5.dex */
public abstract class UP1 {
    public static final void a(boolean z, ConstraintLayout constraintLayout, FrameLayout frameLayout, LinearLayout linearLayout, Guideline guideline, Guideline guideline2, Boolean bool) {
        AbstractC13042fc3.i(constraintLayout, "constraintChild");
        AbstractC13042fc3.i(frameLayout, "frameMain");
        AbstractC13042fc3.i(linearLayout, "linearCB");
        AbstractC13042fc3.i(guideline, "guidelineStart");
        AbstractC13042fc3.i(guideline2, "guidelineEnd");
        if (AbstractC13042fc3.d(Boolean.valueOf(z), bool)) {
            return;
        }
        TransitionManager.endTransitions(constraintLayout);
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.p(constraintLayout);
        if (z) {
            cVar.t(linearLayout.getId(), 7, guideline2.getId(), 6, 0);
            cVar.t(frameLayout.getId(), 6, guideline2.getId(), 7, 0);
        } else {
            cVar.t(linearLayout.getId(), 7, guideline.getId(), 6, 0);
            cVar.t(frameLayout.getId(), 6, guideline.getId(), 7, 0);
        }
        if (bool != null) {
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setDuration(250L);
            TransitionManager.beginDelayedTransition(constraintLayout, autoTransition);
        }
        cVar.i(constraintLayout);
    }
}
