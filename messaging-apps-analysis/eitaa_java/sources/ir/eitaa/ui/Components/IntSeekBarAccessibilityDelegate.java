package ir.eitaa.ui.Components;

import android.view.View;

/* loaded from: classes3.dex */
public abstract class IntSeekBarAccessibilityDelegate extends SeekBarAccessibilityDelegate {
    protected int getDelta() {
        return 1;
    }

    protected abstract int getMaxValue();

    protected int getMinValue() {
        return 0;
    }

    protected abstract int getProgress();

    protected abstract void setProgress(int progress);

    @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
    protected void doScroll(View host, boolean backward) {
        int delta = getDelta();
        if (backward) {
            delta *= -1;
        }
        setProgress(Math.min(getMaxValue(), Math.max(getMinValue(), getProgress() + delta)));
    }

    @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
    protected boolean canScrollBackward(View host) {
        return getProgress() > getMinValue();
    }

    @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
    protected boolean canScrollForward(View host) {
        return getProgress() < getMaxValue();
    }
}
