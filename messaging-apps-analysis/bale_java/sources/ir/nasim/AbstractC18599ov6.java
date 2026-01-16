package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\u0003J+\u0010\u0010\u001a\u00020\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\fH\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lir/nasim/ov6;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/View;", "res", "Lir/nasim/rB7;", "P9", "(Landroid/view/View;)V", "Q9", "Lir/nasim/Ku6;", "holder", "Lir/nasim/tv6;", "item", "", "position", "R9", "(Lir/nasim/Ku6;Lir/nasim/tv6;I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "rowModel", "O9", "(Lir/nasim/tv6;)V", "c1", TokenNames.I, "columnCount", "", "d1", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.ov6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC18599ov6 extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    private int columnCount = 1;

    /* renamed from: d1, reason: from kotlin metadata */
    private final List items = new ArrayList();

    /* renamed from: ir.nasim.ov6$a */
    public static final class a extends AbstractC5548Ju6 {
        a(List list) {
            super(list);
        }

        @Override // ir.nasim.AbstractC5548Ju6
        public void B(AbstractC5782Ku6 abstractC5782Ku6, C21668tv6 c21668tv6, int i) {
            AbstractC13042fc3.i(abstractC5782Ku6, "holder");
            AbstractC13042fc3.i(c21668tv6, "item");
            super.B(abstractC5782Ku6, c21668tv6, i);
            AbstractC18599ov6.this.R9(abstractC5782Ku6, c21668tv6, i);
        }
    }

    private final void P9(View res) {
        View viewFindViewById = res.findViewById(BC5.settings_toolbar);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default((BaleToolbar) viewFindViewById, fragmentActivityQ7, true, false, 4, null);
    }

    protected final void O9(C21668tv6 rowModel) {
        AbstractC13042fc3.i(rowModel, "rowModel");
        this.items.add(rowModel);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        View viewInflate = inflater.inflate(AbstractC12208eD5.fragment_setting_main, container, false);
        viewInflate.setBackgroundColor(C5495Jo7.a.o());
        View viewFindViewById = viewInflate.findViewById(BC5.list);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        recyclerView.setLayoutManager(this.columnCount <= 1 ? new LinearLayoutManager(recyclerView.getContext()) : new GridLayoutManager(recyclerView.getContext(), this.columnCount));
        Q9();
        recyclerView.setAdapter(new a(this.items));
        AbstractC13042fc3.f(viewInflate);
        P9(viewInflate);
        return viewInflate;
    }

    public abstract void Q9();

    public abstract void R9(AbstractC5782Ku6 holder, C21668tv6 item, int position);
}
