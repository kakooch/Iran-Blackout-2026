package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes6.dex */
public class E34 extends RecyclerView.h {
    private final String d = "NewMembersAdapter";
    private ArrayList e = new ArrayList();
    private final InterfaceC22483vJ4 f;
    private C14733iO2 g;

    class a extends RecyclerView.C {
        private ImageView A;
        private ImageView B;
        private final InterfaceC22483vJ4 u;
        private TextView v;
        private TextView w;
        private AvatarViewGlide x;
        private TextView y;
        private C21231tK7 z;

        public a(View view, InterfaceC22483vJ4 interfaceC22483vJ4) {
            super(view);
            this.u = interfaceC22483vJ4;
            ImageView imageView = (ImageView) view.findViewById(BC5.menu_current_item);
            this.B = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) view.findViewById(BC5.online_circle);
            this.A = imageView2;
            imageView2.setVisibility(8);
            this.v = (TextView) view.findViewById(BC5.name);
            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) view.findViewById(BC5.avatar);
            this.x = avatarViewGlide;
            avatarViewGlide.B(24.0f, true);
            this.w = (TextView) view.findViewById(BC5.description_ad);
            TextView textView = (TextView) view.findViewById(BC5.online);
            this.y = textView;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.f1());
            this.y.setTypeface(C6011Lu2.k());
            this.y.setTextSize(13.0f);
            this.w.setTextColor(c5495Jo7.B0());
            this.w.setVisibility(8);
            this.v.setTextColor(c5495Jo7.g0());
            view.findViewById(BC5.divider).setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
            view.setBackgroundDrawable(AbstractC4310Eo7.g());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E0(C23104wM2 c23104wM2, View view) {
            this.u.e(c23104wM2);
        }

        public void D0(final C23104wM2 c23104wM2) {
            if (c23104wM2 == null) {
                return;
            }
            this.z = c23104wM2.g();
            try {
                if (c23104wM2.c() != null) {
                    this.y.setText(FM2.e(c23104wM2.c(), (W06) E34.this.g.E().b(), (C24119y45) E34.this.g.m().b(), E34.this.g.q() == ZN2.GROUP));
                } else {
                    this.y.setVisibility(8);
                }
                C21231tK7 c21231tK7 = this.z;
                if (c21231tK7 != null) {
                    this.x.r(c21231tK7);
                    this.v.setText((CharSequence) this.z.r().b());
                    if (E34.this.g != null && E34.this.g.x() == this.z.o()) {
                        if (E34.this.g.q() == ZN2.CHANNEL) {
                            this.w.setText(AbstractC12217eE5.channel_owner);
                        } else {
                            this.w.setText(AbstractC12217eE5.group_owner);
                        }
                    }
                }
            } catch (Exception e) {
                C19406qI3.d("NewMembersAdapter", e);
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
            this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.D34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.E0(c23104wM2, view);
                }
            });
            if (!c23104wM2.j()) {
                this.w.setVisibility(8);
            } else {
                this.w.setTextColor(C5495Jo7.a.T());
                this.w.setVisibility(0);
            }
        }

        public void a() {
            this.x.D();
            this.y.setText("");
        }
    }

    public E34(InterfaceC22483vJ4 interfaceC22483vJ4, C14733iO2 c14733iO2) {
        this.g = c14733iO2;
        this.f = interfaceC22483vJ4;
    }

    public void A(Collection collection) {
        int size = this.e.size();
        this.e.addAll(collection);
        notifyItemRangeInserted(size, collection.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        aVar.D0((C23104wM2) this.e.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.new_fragment_group_item, viewGroup, false), this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(a aVar) {
        super.onViewRecycled(aVar);
        aVar.a();
    }

    public void E(C23104wM2 c23104wM2) {
        int iIndexOf = this.e.indexOf(c23104wM2);
        this.e.remove(iIndexOf);
        notifyItemRemoved(iIndexOf);
        notifyItemRangeChanged(iIndexOf, this.e.size());
    }

    public void F(Collection collection) {
        this.e.clear();
        this.e.addAll(collection);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        return ((C23104wM2) this.e.get(i)).f();
    }
}
