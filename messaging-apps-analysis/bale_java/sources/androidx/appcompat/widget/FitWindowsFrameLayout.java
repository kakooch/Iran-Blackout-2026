package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import ir.nasim.InterfaceC14382hp2;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout {
    private InterfaceC14382hp2 a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        InterfaceC14382hp2 interfaceC14382hp2 = this.a;
        if (interfaceC14382hp2 != null) {
            interfaceC14382hp2.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(InterfaceC14382hp2 interfaceC14382hp2) {
    }
}
