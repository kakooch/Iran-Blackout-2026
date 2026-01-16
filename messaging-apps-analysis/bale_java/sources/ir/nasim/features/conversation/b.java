package ir.nasim.features.conversation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC14869id0;
import ir.nasim.C11458d25;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class b extends RecyclerView.h {
    private final LayoutInflater d;
    ArrayList e;
    private a f;

    public interface a {
        boolean c(C11458d25 c11458d25);

        void d(C11458d25 c11458d25);

        boolean e(C11458d25 c11458d25);
    }

    public b(Context context, ArrayList arrayList) {
        this.e = arrayList;
        this.d = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public ir.nasim.features.conversation.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ir.nasim.features.conversation.a(this.d.inflate(AbstractC12208eD5.dialog_grid_item, viewGroup, false), this.f);
    }

    public void B(a aVar) {
        this.f = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ir.nasim.features.conversation.a aVar, int i) {
        if (i > 0) {
            aVar.F0(aVar, (AbstractC14869id0) this.e.get(i - 1));
        } else {
            aVar.H0(aVar);
        }
    }
}
