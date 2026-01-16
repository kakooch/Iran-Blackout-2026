package ir.nasim.tgwidgets.editor.ui.Components.ListView;

import android.content.Context;
import android.graphics.Canvas;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;

/* loaded from: classes7.dex */
public class RecyclerListViewWithOverlayDraw extends RecyclerListView {
    boolean T2;

    public RecyclerListViewWithOverlayDraw(Context context) {
        super(context);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.T2 = false;
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.T2) {
            return;
        }
        super.invalidate();
        this.T2 = true;
    }
}
