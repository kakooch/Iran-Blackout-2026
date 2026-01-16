package ir.nasim.designsystem.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.DY2;
import ir.nasim.ED1;
import ir.nasim.designsystem.adapters.RecyclerListView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lir/nasim/designsystem/adapters/RecyclerListView;", "Landroid/widget/ListView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/ListAdapter;", "adapter", "Lir/nasim/rB7;", "setAdapter", "(Landroid/widget/ListAdapter;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public class RecyclerListView extends ListView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclerListView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ListAdapter listAdapter, View view) {
        AbstractC13042fc3.f(view);
        ((DY2) listAdapter).d(view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclerListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    @Override // android.widget.AdapterView
    public void setAdapter(final ListAdapter adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof DY2) {
            setRecyclerListener(new AbsListView.RecyclerListener() { // from class: ir.nasim.TK5
                @Override // android.widget.AbsListView.RecyclerListener
                public final void onMovedToScrapHeap(View view) {
                    RecyclerListView.b(adapter, view);
                }
            });
        }
    }

    public /* synthetic */ RecyclerListView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
    }
}
