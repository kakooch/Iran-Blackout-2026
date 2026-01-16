package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.KX0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class KX0 extends RecyclerView.h {
    public static final a j = new a(null);
    public static final int k = 8;
    private Context d;
    private LayoutInflater e;
    private final List f;
    private b g;
    private int h;
    private UX0 i;

    public static final class a {
        private a() {
        }

        public final List a(Context context) {
            AbstractC13042fc3.i(context, "context");
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.blue_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.brown_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.green_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.orange_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.red_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.black)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.red_orange_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.sky_blue_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.violet_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.white)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.yellow_color_picker)));
            arrayList.add(Integer.valueOf(AbstractC4043Dl1.c(context, TA5.yellow_green_color_picker)));
            return arrayList;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void a(int i);
    }

    public final class c extends RecyclerView.C {
        private ImageView u;
        private ImageView v;
        private ImageView w;
        final /* synthetic */ KX0 x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(final KX0 kx0, View view) {
            super(view);
            AbstractC13042fc3.i(view, "itemView");
            this.x = kx0;
            UX0 ux0 = kx0.i;
            UX0 ux02 = null;
            if (ux0 == null) {
                AbstractC13042fc3.y("binding");
                ux0 = null;
            }
            ImageView imageView = ux0.c;
            AbstractC13042fc3.h(imageView, "colorPickerView");
            this.u = imageView;
            UX0 ux03 = kx0.i;
            if (ux03 == null) {
                AbstractC13042fc3.y("binding");
                ux03 = null;
            }
            ImageView imageView2 = ux03.d;
            AbstractC13042fc3.h(imageView2, "selectIcon");
            this.v = imageView2;
            UX0 ux04 = kx0.i;
            if (ux04 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                ux02 = ux04;
            }
            ImageView imageView3 = ux02.b;
            AbstractC13042fc3.h(imageView3, "border");
            this.w = imageView3;
            view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LX0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    KX0.c.D0(kx0, this, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D0(KX0 kx0, c cVar, View view) {
            AbstractC13042fc3.i(kx0, "this$0");
            AbstractC13042fc3.i(cVar, "this$1");
            if (kx0.g != null) {
                b bVar = kx0.g;
                AbstractC13042fc3.f(bVar);
                bVar.a(((Number) kx0.f.get(cVar.J())).intValue());
                kx0.F(cVar.J());
                kx0.notifyDataSetChanged();
            }
        }

        public final ImageView E0() {
            return this.w;
        }

        public final ImageView F0() {
            return this.u;
        }

        public final ImageView H0() {
            return this.v;
        }
    }

    public KX0(Context context, List list) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(list, "colorPickerColors");
        this.d = context;
        this.h = 9;
        this.e = LayoutInflater.from(context);
        this.f = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        AbstractC13042fc3.i(cVar, "holder");
        cVar.F0().setColorFilter(((Number) this.f.get(i)).intValue());
        cVar.H0().setVisibility(this.h == i ? 0 : 8);
        if (this.h == i) {
            cVar.H0().setVisibility(0);
            cVar.E0().setVisibility(0);
        } else {
            cVar.H0().setVisibility(8);
            cVar.E0().setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        this.i = UX0.c(this.e, viewGroup, false);
        UX0 ux0 = this.i;
        if (ux0 == null) {
            AbstractC13042fc3.y("binding");
            ux0 = null;
        }
        ConstraintLayout root = ux0.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return new c(this, root);
    }

    public final void E(b bVar) {
        this.g = bVar;
    }

    public final void F(int i) {
        this.h = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.f.size();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KX0(Context context, int i) {
        this(context, j.a(context));
        AbstractC13042fc3.i(context, "context");
        this.d = context;
        this.e = LayoutInflater.from(context);
        this.h = this.f.indexOf(Integer.valueOf(i));
    }
}
