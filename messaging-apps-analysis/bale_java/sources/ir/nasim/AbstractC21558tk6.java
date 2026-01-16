package ir.nasim;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.tk6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC21558tk6 extends View.AccessibilityDelegate {
    private static final CharSequence c = SeekBar.class.getName();
    private final Map a = new HashMap(4);
    private final View.OnAttachStateChangeListener b = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        sendAccessibilityEvent(view, 4);
    }

    private void j(final View view) {
        if (AbstractC12990fW7.S(view)) {
            Runnable runnable = (Runnable) this.a.get(view);
            if (runnable == null) {
                Map map = this.a;
                Runnable runnable2 = new Runnable() { // from class: ir.nasim.sk6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g(view);
                    }
                };
                map.put(view, runnable2);
                view.addOnAttachStateChangeListener(this.b);
                runnable = runnable2;
            } else {
                view.removeCallbacks(runnable);
            }
            view.postDelayed(runnable, 400L);
        }
    }

    protected abstract boolean c(View view);

    protected abstract boolean d(View view);

    protected abstract void e(View view, boolean z);

    protected abstract CharSequence f(View view);

    public void h(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.setClassName(c);
        CharSequence charSequenceF = f(view);
        if (!TextUtils.isEmpty(charSequenceF)) {
            accessibilityNodeInfo.setText(charSequenceF);
        }
        if (c(view)) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        }
        if (d(view)) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        }
    }

    public boolean i(View view, int i, Bundle bundle) {
        if (i != 4096 && i != 8192) {
            return false;
        }
        e(view, i == 8192);
        if (view != null) {
            j(view);
        }
        return true;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        h(view, accessibilityNodeInfo);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        return i(view, i, bundle);
    }

    /* renamed from: ir.nasim.tk6$a */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeCallbacks((Runnable) AbstractC21558tk6.this.a.remove(view));
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
