package ir.appp.vod.util;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiListenerMotionLayout.kt */
/* loaded from: classes3.dex */
public class MultiListenerMotionLayout extends MotionLayout {
    private final CopyOnWriteArrayList<MotionLayout.TransitionListener> listeners;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiListenerMotionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MultiListenerMotionLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiListenerMotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.listeners = new CopyOnWriteArrayList<>();
        super.setTransitionListener(new MotionLayout.TransitionListener() { // from class: ir.appp.vod.util.MultiListenerMotionLayout.1
            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionTrigger(MotionLayout motionLayout, int i2, boolean z, float f) {
                Intrinsics.checkNotNullParameter(motionLayout, "motionLayout");
                Iterator it = MultiListenerMotionLayout.this.listeners.iterator();
                while (it.hasNext()) {
                    ((MotionLayout.TransitionListener) it.next()).onTransitionTrigger(motionLayout, i2, z, f);
                }
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionStarted(MotionLayout motionLayout, int i2, int i3) {
                Intrinsics.checkNotNullParameter(motionLayout, "motionLayout");
                Iterator it = MultiListenerMotionLayout.this.listeners.iterator();
                while (it.hasNext()) {
                    ((MotionLayout.TransitionListener) it.next()).onTransitionStarted(motionLayout, i2, i3);
                }
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionChange(MotionLayout motionLayout, int i2, int i3, float f) {
                Intrinsics.checkNotNullParameter(motionLayout, "motionLayout");
                Iterator it = MultiListenerMotionLayout.this.listeners.iterator();
                while (it.hasNext()) {
                    ((MotionLayout.TransitionListener) it.next()).onTransitionChange(motionLayout, i2, i3, f);
                }
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionCompleted(MotionLayout motionLayout, int i2) {
                Intrinsics.checkNotNullParameter(motionLayout, "motionLayout");
                Iterator it = MultiListenerMotionLayout.this.listeners.iterator();
                while (it.hasNext()) {
                    ((MotionLayout.TransitionListener) it.next()).onTransitionCompleted(motionLayout, i2);
                }
            }
        });
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout
    public void setTransitionListener(MotionLayout.TransitionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw new IllegalArgumentException("Use addTransitionListener instead");
    }
}
