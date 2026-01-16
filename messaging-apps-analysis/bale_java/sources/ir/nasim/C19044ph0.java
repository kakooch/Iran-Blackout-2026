package ir.nasim;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ph0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C19044ph0 extends RecyclerView.h {
    List d;
    b e;

    /* renamed from: ir.nasim.ph0$a */
    public class a extends RecyclerView.C {
        private final TextView u;
        private final AvatarViewGlide v;
        private C21231tK7 w;
        private final View x;

        public a(View view) {
            super(view);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            view.setBackgroundColor(c5495Jo7.O0());
            this.u = (TextView) view.findViewById(BC5.name);
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) view.findViewById(BC5.avatar);
            this.v = avatarViewGlide;
            avatarViewGlide.B(24.0f, true);
            TextView textView = (TextView) view.findViewById(BC5.unblock);
            textView.setTextColor(c5495Jo7.W0());
            ((TextView) view.findViewById(BC5.name)).setTextColor(c5495Jo7.g1());
            View viewFindViewById = view.findViewById(BC5.divider);
            this.x = viewFindViewById;
            viewFindViewById.setBackgroundColor(c5495Jo7.a1());
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oh0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.E0(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E0(View view) {
            C19044ph0.this.e.a(this.w);
        }

        public void D0(C17637nI7 c17637nI7, int i) {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c17637nI7.n0());
            this.w = c21231tK7;
            this.v.r(c21231tK7);
            Drawable drawableF = (C8386Vt0.a8() && c17637nI7.i0() != null && c17637nI7.i0().s()) ? AbstractC4043Dl1.f(this.a.getContext(), c17637nI7.i0().p()) : null;
            this.u.setText((CharSequence) this.w.r().b());
            AbstractC15575jo7.k(this.u, drawableF, null, null, null);
            this.x.setVisibility(i == C19044ph0.this.getItemCount() + (-1) ? 4 : 0);
        }

        public void a() {
            this.v.D();
        }
    }

    /* renamed from: ir.nasim.ph0$b */
    public interface b {
        void a(C21231tK7 c21231tK7);
    }

    public C19044ph0(List list, b bVar) {
        this.d = list;
        this.e = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.fragment_blocked_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(a aVar) {
        aVar.a();
    }

    public void C(List list) {
        ArrayList arrayList = new ArrayList(this.d);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C17637nI7 c17637nI7 = (C17637nI7) arrayList.get(size);
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((C17637nI7) it.next()).n0() == c17637nI7.n0()) {
                        break;
                    }
                } else {
                    this.d.remove(c17637nI7);
                    notifyItemRemoved(size);
                    break;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(this.d);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            C17637nI7 c17637nI72 = (C17637nI7) it2.next();
            Iterator it3 = arrayList2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (c17637nI72.n0() == ((C17637nI7) it3.next()).n0()) {
                        break;
                    }
                } else {
                    this.d.add(c17637nI72);
                    notifyItemInserted(getItemCount());
                    break;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        aVar.D0((C17637nI7) this.d.get(i), i);
    }
}
