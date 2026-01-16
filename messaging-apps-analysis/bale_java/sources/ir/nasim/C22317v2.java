package ir.nasim;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import ir.nasim.X2;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.v2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22317v2 {
    private static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate a;
    private final View.AccessibilityDelegate b;

    /* renamed from: ir.nasim.v2$a */
    static final class a extends View.AccessibilityDelegate {
        final C22317v2 a;

        a(C22317v2 c22317v2) {
            this.a = c22317v2;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            Y2 y2B = this.a.b(view);
            if (y2B != null) {
                return (AccessibilityNodeProvider) y2B.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            X2 x2G1 = X2.g1(accessibilityNodeInfo);
            x2G1.Q0(AbstractC12990fW7.W(view));
            x2G1.B0(AbstractC12990fW7.R(view));
            x2G1.K0(AbstractC12990fW7.o(view));
            x2G1.W0(AbstractC12990fW7.I(view));
            this.a.g(view, x2G1);
            x2G1.f(accessibilityNodeInfo.getText(), view);
            List listC = C22317v2.c(view);
            for (int i = 0; i < listC.size(); i++) {
                x2G1.b((X2.a) listC.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.j(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.a.l(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.m(view, accessibilityEvent);
        }
    }

    public C22317v2() {
        this(c);
    }

    static List c(View view) {
        List list = (List) view.getTag(AbstractC24197yC5.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrR = X2.r(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; clickableSpanArrR != null && i < clickableSpanArrR.length; i++) {
                if (clickableSpan.equals(clickableSpanArrR[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(AbstractC24197yC5.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public Y2 b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new Y2(accessibilityNodeProvider);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, X2 x2) {
        this.a.onInitializeAccessibilityNodeInfo(view, x2.f1());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i, Bundle bundle) {
        List listC = c(view);
        boolean zPerformAccessibilityAction = false;
        int i2 = 0;
        while (true) {
            if (i2 >= listC.size()) {
                break;
            }
            X2.a aVar = (X2.a) listC.get(i2);
            if (aVar.b() == i) {
                zPerformAccessibilityAction = aVar.d(view, bundle);
                break;
            }
            i2++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.a.performAccessibilityAction(view, i, bundle);
        }
        return (zPerformAccessibilityAction || i != AbstractC24197yC5.accessibility_action_clickable_span || bundle == null) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i) {
        this.a.sendAccessibilityEvent(view, i);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C22317v2(View.AccessibilityDelegate accessibilityDelegate) {
        this.a = accessibilityDelegate;
        this.b = new a(this);
    }
}
