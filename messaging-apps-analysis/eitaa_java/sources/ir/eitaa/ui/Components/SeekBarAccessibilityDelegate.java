package ir.eitaa.ui.Components;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class SeekBarAccessibilityDelegate extends View.AccessibilityDelegate {
    private static final CharSequence SEEK_BAR_CLASS_NAME = android.widget.SeekBar.class.getName();
    private final Map<View, Runnable> accessibilityEventRunnables = new HashMap(4);
    private final View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: ir.eitaa.ui.Components.SeekBarAccessibilityDelegate.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            v.removeCallbacks((Runnable) SeekBarAccessibilityDelegate.this.accessibilityEventRunnables.remove(v));
            v.removeOnAttachStateChangeListener(this);
        }
    };

    protected abstract boolean canScrollBackward(View host);

    protected abstract boolean canScrollForward(View host);

    protected abstract void doScroll(View host, boolean backward);

    protected CharSequence getContentDescription(View host) {
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View host, int action, Bundle args) {
        if (super.performAccessibilityAction(host, action, args)) {
            return true;
        }
        return performAccessibilityActionInternal(host, action, args);
    }

    public boolean performAccessibilityActionInternal(View host, int action, Bundle args) {
        if (action != 4096 && action != 8192) {
            return false;
        }
        doScroll(host, action == 8192);
        if (host != null) {
            postAccessibilityEventRunnable(host);
        }
        return true;
    }

    public final boolean performAccessibilityActionInternal(int action, Bundle args) {
        return performAccessibilityActionInternal(null, action, args);
    }

    private void postAccessibilityEventRunnable(final View host) {
        if (ViewCompat.isAttachedToWindow(host)) {
            Runnable runnable = this.accessibilityEventRunnables.get(host);
            if (runnable == null) {
                Map<View, Runnable> map = this.accessibilityEventRunnables;
                Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SeekBarAccessibilityDelegate$Eq0FYXaXmVt4gTQOyiQDXopctEY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$postAccessibilityEventRunnable$0$SeekBarAccessibilityDelegate(host);
                    }
                };
                map.put(host, runnable2);
                host.addOnAttachStateChangeListener(this.onAttachStateChangeListener);
                runnable = runnable2;
            } else {
                host.removeCallbacks(runnable);
            }
            host.postDelayed(runnable, 400L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$postAccessibilityEventRunnable$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$postAccessibilityEventRunnable$0$SeekBarAccessibilityDelegate(View view) {
        sendAccessibilityEvent(view, 4);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(host, info);
        onInitializeAccessibilityNodeInfoInternal(host, info);
    }

    public void onInitializeAccessibilityNodeInfoInternal(View host, AccessibilityNodeInfo info) {
        info.setClassName(SEEK_BAR_CLASS_NAME);
        CharSequence contentDescription = getContentDescription(host);
        if (!TextUtils.isEmpty(contentDescription)) {
            info.setText(contentDescription);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (canScrollBackward(host)) {
                info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            }
            if (canScrollForward(host)) {
                info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            }
        }
    }

    public final void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        onInitializeAccessibilityNodeInfoInternal(null, info);
    }
}
