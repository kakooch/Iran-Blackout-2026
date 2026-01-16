package ir.nasim;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Y2 {
    private final Object a;

    static class a extends AccessibilityNodeProvider {
        final Y2 a;

        a(Y2 y2) {
            this.a = y2;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            X2 x2B = this.a.b(i);
            if (x2B == null) {
                return null;
            }
            return x2B.f1();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i) {
            List listC = this.a.c(str, i);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((X2) listC.get(i2)).f1());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            X2 x2D = this.a.d(i);
            if (x2D == null) {
                return null;
            }
            return x2D.f1();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.f(i, i2, bundle);
        }
    }

    static class b extends a {
        b(Y2 y2) {
            super(y2);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.a.a(i, X2.g1(accessibilityNodeInfo), str, bundle);
        }
    }

    public Y2() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new b(this);
        } else {
            this.a = new a(this);
        }
    }

    public X2 b(int i) {
        return null;
    }

    public List c(String str, int i) {
        return null;
    }

    public X2 d(int i) {
        return null;
    }

    public Object e() {
        return this.a;
    }

    public boolean f(int i, int i2, Bundle bundle) {
        return false;
    }

    public Y2(Object obj) {
        this.a = obj;
    }

    public void a(int i, X2 x2, String str, Bundle bundle) {
    }
}
