package ir.nasim.designsystem.photoviewer;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.VI2;
import ir.nasim.designsystem.photoviewer.data.Photo;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class a extends RecyclerView.h {
    private final VI2 d;
    private boolean e;
    private c f;
    private InterfaceC1021a g;
    private b h;
    private ArrayList i;

    /* renamed from: ir.nasim.designsystem.photoviewer.a$a, reason: collision with other inner class name */
    public interface InterfaceC1021a {
        void J(int i, Photo photo);

        void k(int i, Photo photo);
    }

    public interface b {
        void A();
    }

    public interface c {
        void v();
    }

    public a(VI2 vi2) {
        AbstractC13042fc3.i(vi2, "glide");
        this.d = vi2;
        this.i = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public ir.nasim.designsystem.photoviewer.b onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return ir.nasim.designsystem.photoviewer.b.H.a(viewGroup, this.f, this.g, this.h, this.e, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(ir.nasim.designsystem.photoviewer.b bVar) {
        AbstractC13042fc3.i(bVar, "holder");
        super.onViewRecycled(bVar);
        bVar.a();
    }

    public final void C(boolean z) {
        this.e = z;
    }

    public final void D(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.i = arrayList;
    }

    public final void E(InterfaceC1021a interfaceC1021a) {
        this.g = interfaceC1021a;
    }

    public final void F(b bVar) {
        this.h = bVar;
    }

    public final void G(c cVar) {
        this.f = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        return ((Photo) this.i.get(i)).getTimeStamp();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ir.nasim.designsystem.photoviewer.b bVar, int i) {
        AbstractC13042fc3.i(bVar, "holder");
        Object obj = this.i.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        bVar.P0(i, (Photo) obj);
    }
}
