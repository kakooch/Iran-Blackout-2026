package ir.nasim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes5.dex */
public abstract class DW7 {
    private View a;

    public abstract void a(Object obj, int i, Context context);

    public final View b(View view, Object obj, int i, ViewGroup viewGroup, Context context) {
        AbstractC13042fc3.i(context, "context");
        if (view == null) {
            view = c(obj, viewGroup, context);
            view.setTag(this);
        }
        this.a = view;
        a(obj, i, context);
        View view2 = this.a;
        if (view2 != null) {
            return view2;
        }
        AbstractC13042fc3.y("view");
        return null;
    }

    public abstract View c(Object obj, ViewGroup viewGroup, Context context);

    public void d(boolean z) {
    }
}
