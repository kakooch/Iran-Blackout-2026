package ir.nasim;

import android.hardware.Camera;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.attach.model.ShareAttachment;
import java.util.ArrayList;

/* renamed from: ir.nasim.Lx6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6042Lx6 extends RecyclerView.h {
    private a d;
    private ArrayList e;

    /* renamed from: ir.nasim.Lx6$a */
    public interface a {
        EM2 H();

        void I(ShareAttachment shareAttachment);

        void J(Camera camera);
    }

    public C6042Lx6(a aVar) {
        this.d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public TextureViewSurfaceTextureListenerC6536Nx6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return TextureViewSurfaceTextureListenerC6536Nx6.H.a(viewGroup, this.d);
    }

    public final void B(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "attachments");
        this.e = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        ArrayList arrayList = this.e;
        if (arrayList == null) {
            AbstractC13042fc3.y("attachments");
            arrayList = null;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(TextureViewSurfaceTextureListenerC6536Nx6 textureViewSurfaceTextureListenerC6536Nx6, int i) {
        AbstractC13042fc3.i(textureViewSurfaceTextureListenerC6536Nx6, "holder");
        ArrayList arrayList = this.e;
        if (arrayList == null) {
            AbstractC13042fc3.y("attachments");
            arrayList = null;
        }
        Object obj = arrayList.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        textureViewSurfaceTextureListenerC6536Nx6.E0((ShareAttachment) obj);
    }
}
