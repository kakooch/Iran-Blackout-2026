package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes5.dex */
public final class NL1 extends RecyclerView.h {
    private final List d;
    private final LayoutInflater e;

    public static final class a extends RecyclerView.C {
        private TextView u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            AbstractC13042fc3.i(view, "itemView");
            TextView textView = (TextView) view.findViewById(BC5.txt_desc);
            this.u = textView;
            textView.setTypeface(C6011Lu2.k());
        }

        public final TextView C0() {
            return this.u;
        }
    }

    public NL1(Context context, List list) {
        AbstractC13042fc3.i(list, "data");
        this.e = LayoutInflater.from(context);
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = this.e.inflate(AbstractC12208eD5.change_log_description_recycler_item, viewGroup, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return new a(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
        aVar.C0().setText((String) this.d.get(i));
    }
}
