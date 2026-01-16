package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes2.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        B0();
    }

    private void B0() {
        w0(1);
        n0(new Fade(2)).n0(new ChangeBounds()).n0(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B0();
    }
}
