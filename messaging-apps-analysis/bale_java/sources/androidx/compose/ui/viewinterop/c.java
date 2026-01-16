package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.e;
import androidx.compose.ui.focus.i;
import ir.nasim.CK5;
import ir.nasim.InterfaceC4566Fr2;
import ir.nasim.KG1;

/* loaded from: classes2.dex */
public abstract class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(View view, View view2) {
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view.getParent()) {
                return true;
            }
        }
        return false;
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar) {
        return i.a(i.a(eVar.i(FocusGroupPropertiesElement.b)).i(FocusTargetPropertiesElement.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect f(InterfaceC4566Fr2 interfaceC4566Fr2, View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        CK5 ck5R = interfaceC4566Fr2.r();
        if (ck5R == null) {
            return null;
        }
        return new Rect((((int) ck5R.i()) + iArr[0]) - iArr2[0], (((int) ck5R.l()) + iArr[1]) - iArr2[1], (((int) ck5R.j()) + iArr[0]) - iArr2[0], (((int) ck5R.e()) + iArr[1]) - iArr2[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View g(e.c cVar) {
        View viewA0 = KG1.o(cVar.h()).a0();
        if (viewA0 != null) {
            return viewA0;
        }
        throw new IllegalStateException("Could not fetch interop view".toString());
    }
}
