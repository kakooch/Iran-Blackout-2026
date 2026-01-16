package ir.nasim.tgwidgets.editor.ui.Components;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class SizeNotifierFrameLayoutPhoto extends FrameLayout {
    private Activity a;
    private Rect b;
    private int c;
    private a d;
    private boolean e;
    private boolean f;

    public interface a {
        void onSizeChanged(int i, boolean z);
    }

    public SizeNotifierFrameLayoutPhoto(Context context, Activity activity, boolean z) {
        super(context);
        this.b = new Rect();
        setActivity(activity);
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(boolean z) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.onSizeChanged(this.c, z);
        }
    }

    public int G() {
        View rootView = getRootView();
        getWindowVisibleDisplayFrame(this.b);
        if (this.e) {
            int height = (rootView.getHeight() - (this.b.top != 0 ? AbstractC21455b.d : 0)) - AbstractC21455b.s0(rootView);
            Rect rect = this.b;
            return height - (rect.bottom - rect.top);
        }
        int height2 = (this.a.getWindow().getDecorView().getHeight() - AbstractC21455b.s0(rootView)) - rootView.getBottom();
        if (height2 <= Math.max(AbstractC21455b.F(10.0f), AbstractC21455b.d)) {
            return 0;
        }
        return height2;
    }

    public void H() {
        if (this.d != null) {
            this.c = G();
            Point point = AbstractC21455b.h;
            final boolean z = point.x > point.y;
            post(new Runnable() { // from class: ir.nasim.XD6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.F(z);
                }
            });
        }
    }

    public int getKeyboardHeight() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        H();
    }

    public void setActivity(Activity activity) {
        this.a = activity;
    }

    public void setDelegate(a aVar) {
        this.d = aVar;
    }

    public void setWithoutWindow(boolean z) {
        this.e = z;
    }
}
