package ir.eitaa.ui.Components;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes3.dex */
public abstract class FloatSeekBarAccessibilityDelegate extends SeekBarAccessibilityDelegate {
    private final boolean setPercentsEnabled;

    protected float getDelta() {
        return 0.05f;
    }

    protected float getMaxValue() {
        return 1.0f;
    }

    protected float getMinValue() {
        return 0.0f;
    }

    protected abstract float getProgress();

    protected abstract void setProgress(float progress);

    public FloatSeekBarAccessibilityDelegate() {
        this(false);
    }

    public FloatSeekBarAccessibilityDelegate(boolean setPercentsEnabled) {
        this.setPercentsEnabled = setPercentsEnabled;
    }

    @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
    public void onInitializeAccessibilityNodeInfoInternal(View host, AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfoInternal(host, info);
        if (this.setPercentsEnabled) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(info);
            accessibilityNodeInfoCompatWrap.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            accessibilityNodeInfoCompatWrap.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, getMinValue(), getMaxValue(), getProgress()));
        }
    }

    @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
    public boolean performAccessibilityActionInternal(View host, int action, Bundle args) {
        if (super.performAccessibilityActionInternal(host, action, args)) {
            return true;
        }
        if (action != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS.getId()) {
            return false;
        }
        setProgress(args.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"));
        return true;
    }

    @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
    protected void doScroll(View host, boolean backward) {
        float delta = getDelta();
        if (backward) {
            delta *= -1.0f;
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
