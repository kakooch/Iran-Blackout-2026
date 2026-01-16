package ir.nasim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class DY2 extends BaseAdapter {
    private final Context a;
    private final HashSet b;

    protected DY2(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = new HashSet();
    }

    protected abstract DW7 a(Object obj);

    public void b() {
        Iterator it = this.b.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            ((DW7) next).d(true);
        }
    }

    protected final void c(DW7 dw7, Object obj, int i, Context context) {
        AbstractC13042fc3.i(dw7, "holder");
        AbstractC13042fc3.i(context, "context");
        dw7.a(obj, i, context);
    }

    public final void d(View view) {
        AbstractC13042fc3.i(view, "view");
        if (view.getTag() instanceof DW7) {
            Object tag = view.getTag();
            AbstractC13042fc3.g(tag, "null cannot be cast to non-null type ir.nasim.designsystem.adapters.ViewHolder<*>");
            ((DW7) tag).d(false);
        }
    }

    @Override // android.widget.Adapter
    public abstract Object getItem(int i);

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewC;
        DW7 dw7A;
        Object item = getItem(i);
        if ((view != null ? view.getTag() : null) == null) {
            dw7A = a(item);
            viewC = dw7A.c(item, viewGroup, this.a);
            viewC.setTag(dw7A);
            this.b.add(dw7A);
        } else {
            Object tag = view.getTag();
            AbstractC13042fc3.g(tag, "null cannot be cast to non-null type ir.nasim.designsystem.adapters.ViewHolder<V of ir.nasim.designsystem.adapters.HolderAdapter>");
            DW7 dw7 = (DW7) tag;
            viewC = view;
            dw7A = dw7;
        }
        c(dw7A, item, i, this.a);
        return viewC;
    }
}
