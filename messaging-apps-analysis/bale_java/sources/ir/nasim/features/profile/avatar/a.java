package ir.nasim.features.profile.avatar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C20110rV;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.List;

/* loaded from: classes6.dex */
public final class a extends RecyclerView.h {
    private final Context d;
    private List e;
    private final InterfaceC1208a f;
    private int g;

    /* renamed from: ir.nasim.features.profile.avatar.a$a, reason: collision with other inner class name */
    public interface InterfaceC1208a {
        void G(int i);
    }

    public a(Context context, List list, InterfaceC1208a interfaceC1208a) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(list, "avatars");
        AbstractC13042fc3.i(interfaceC1208a, "onSliderItemClickListener");
        this.d = context;
        this.e = list;
        this.f = interfaceC1208a;
        setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(a aVar, int i, View view) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.f.G(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C20110rV c20110rV, final int i) {
        AbstractC13042fc3.i(c20110rV, "holder");
        Avatar avatar = (Avatar) this.e.get(i);
        c20110rV.a.setSelected(i == this.g);
        c20110rV.E0(avatar);
        c20110rV.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qV
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.profile.avatar.a.B(this.a, i, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public C20110rV onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.d).inflate(AbstractC12208eD5.avatar_slider_item, viewGroup, false);
        AbstractC13042fc3.f(viewInflate);
        return new C20110rV(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C20110rV c20110rV) {
        AbstractC13042fc3.i(c20110rV, "holder");
        super.onViewRecycled(c20110rV);
        c20110rV.a();
    }

    public final void E(List list) {
        AbstractC13042fc3.i(list, "avatars");
        this.e = list;
    }

    public final void F(int i) {
        this.g = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        Long id = ((Avatar) this.e.get(i)).getId();
        return id != null ? id.longValue() : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return i;
    }
}
