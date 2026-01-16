package ir.nasim;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes4.dex */
public final class UB3 extends BaseAdapter {
    public static final a d = new a(null);
    public static final int e = 8;
    private final boolean a;
    private LayoutInflater b;
    private List c;

    public static final class a {
        private a() {
        }

        public final int a() {
            return C5161Id6.e(218.0f);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private TextView a;
        private ImageView b;
        private ImageView c;

        public b(View view) {
            AbstractC13042fc3.i(view, "view");
            View viewFindViewById = view.findViewById(AbstractC19354qC5.titleTxt);
            AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
            this.a = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(AbstractC19354qC5.start_icon_iv);
            AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
            this.b = (ImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(AbstractC19354qC5.end_icon_iv);
            AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
            this.c = (ImageView) viewFindViewById3;
        }

        public final ImageView a() {
            return this.c;
        }

        public final ImageView b() {
            return this.b;
        }

        public final TextView c() {
            return this.a;
        }
    }

    public UB3(Context context, List list, boolean z) {
        AbstractC13042fc3.i(list, "itemList");
        this.a = z;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        AbstractC13042fc3.h(layoutInflaterFrom, "from(...)");
        this.b = layoutInflaterFrom;
        this.c = list;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C18684p44 getItem(int i) {
        return (C18684p44) this.c.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return ((C18684p44) this.c.get(i)).d();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AbstractC13042fc3.i(viewGroup, "parent");
        if (view == null) {
            view = this.a ? this.b.inflate(TC5.item_card_payment_popup_menu_with_locale, (ViewGroup) null) : this.b.inflate(TC5.item_card_payment_popup_menu, (ViewGroup) null);
            AbstractC13042fc3.f(view);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            Object tag = view.getTag();
            AbstractC13042fc3.g(tag, "null cannot be cast to non-null type ir.nasim.components.appbar.view.ListPopupWindowAdapter.ViewHolder");
            bVar = (b) tag;
        }
        C18684p44 item = getItem(i);
        bVar.c().setText(item.f());
        bVar.b().setImageResource(item.e());
        bVar.a().setImageResource(item.b());
        bVar.c().setTextColor(item.g());
        bVar.c().setTypeface(C6011Lu2.k());
        if (item.c() != 0) {
            bVar.b().setColorFilter(new PorterDuffColorFilter(item.c(), PorterDuff.Mode.MULTIPLY));
        }
        AbstractC13042fc3.f(view);
        return view;
    }

    public /* synthetic */ UB3(Context context, List list, boolean z, int i, ED1 ed1) {
        this(context, list, (i & 4) != 0 ? false : z);
    }
}
