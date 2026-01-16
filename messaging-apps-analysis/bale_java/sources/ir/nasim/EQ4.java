package ir.nasim;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/* loaded from: classes6.dex */
public final class EQ4 extends ArrayAdapter {
    private final List a;
    private final RoundRectShape b;
    private final RectShape c;
    private final RoundRectShape d;
    private final RoundRectShape e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EQ4(Context context, List list) {
        super(context, 0, list);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(list, "accounts");
        this.a = list;
        this.b = new RoundRectShape(new float[]{AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0)}, null, null);
        this.c = new RectShape();
        this.d = new RoundRectShape(new float[]{AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8)}, null, null);
        this.e = new RoundRectShape(new float[]{AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8)}, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(H75 h75, EQ4 eq4, View view, View view2) {
        AbstractC13042fc3.i(h75, "$account");
        AbstractC13042fc3.i(eq4, "this$0");
        h75.d(false);
        AbstractC13042fc3.f(view);
        eq4.i(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(H75 h75, EQ4 eq4, View view, View view2) {
        AbstractC13042fc3.i(h75, "$account");
        AbstractC13042fc3.i(eq4, "this$0");
        h75.d(true);
        AbstractC13042fc3.f(view);
        eq4.i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(H75 h75, EQ4 eq4, View view, View view2) {
        AbstractC13042fc3.i(h75, "$account");
        AbstractC13042fc3.i(eq4, "this$0");
        h75.d(false);
        AbstractC13042fc3.f(view);
        eq4.i(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(H75 h75, EQ4 eq4, View view, View view2) {
        AbstractC13042fc3.i(h75, "$account");
        AbstractC13042fc3.i(eq4, "this$0");
        h75.d(true);
        AbstractC13042fc3.f(view);
        eq4.i(view, true);
    }

    private final void i(View view, boolean z) {
        if (z) {
            View viewFindViewById = view.findViewById(BC5.linear_balance_invisible);
            AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
            viewFindViewById.setVisibility(8);
            View viewFindViewById2 = view.findViewById(BC5.linear_balance_visible);
            AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
            viewFindViewById2.setVisibility(0);
            return;
        }
        View viewFindViewById3 = view.findViewById(BC5.linear_balance_visible);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        viewFindViewById3.setVisibility(8);
        View viewFindViewById4 = view.findViewById(BC5.linear_balance_invisible);
        AbstractC13042fc3.h(viewFindViewById4, "findViewById(...)");
        viewFindViewById4.setVisibility(0);
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        AbstractC13042fc3.i(viewGroup, "parent");
        final View viewInflate = LayoutInflater.from(getContext()).inflate(AbstractC12208eD5.pfm_spinner_item_view, viewGroup, false);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        if (this.a.size() == 1) {
            shapeDrawable.setShape(this.e);
        } else if (this.a.size() == 2) {
            if (i == 0) {
                shapeDrawable.setShape(this.b);
            } else {
                shapeDrawable.setShape(this.d);
            }
        } else if (i == 0) {
            shapeDrawable.setShape(this.b);
        } else if (i != 1) {
            shapeDrawable.setShape(this.d);
        } else {
            shapeDrawable.setShape(this.c);
        }
        shapeDrawable.getPaint().setAntiAlias(true);
        shapeDrawable.getPaint().setColor(C5495Jo7.a.X());
        viewInflate.setBackground(shapeDrawable);
        final H75 h75 = (H75) this.a.get(i);
        String strValueOf = String.valueOf(h75.a());
        String strG = GY6.g(h75.b().length() == 0 ? "0" : h75.b());
        String strE = XY6.e(strValueOf);
        String strE2 = XY6.e(strG);
        ((TextView) viewInflate.findViewById(BC5.card_number_tv)).setText("xxxxx " + strE);
        ((TextView) viewInflate.findViewById(BC5.remaining_money_tv)).setText(strE2 + " ریال ");
        View viewFindViewById = viewInflate.findViewById(BC5.vertical_divider);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(i != this.a.size() - 1 ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(BC5.linear_balance_visible);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(BC5.linear_balance_invisible);
        AbstractC13042fc3.f(viewInflate);
        i(viewInflate, h75.c());
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.AQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EQ4.e(h75, this, viewInflate, view2);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EQ4.f(h75, this, viewInflate, view2);
            }
        });
        return viewInflate;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        AbstractC13042fc3.i(viewGroup, "parent");
        final View viewInflate = LayoutInflater.from(getContext()).inflate(AbstractC12208eD5.pfm_spinner_item_view, viewGroup, false);
        final H75 h75 = (H75) this.a.get(i);
        String strValueOf = String.valueOf(h75.a());
        String strG = GY6.g(h75.b().length() == 0 ? "0" : h75.b());
        String strE = XY6.e(strValueOf);
        String strE2 = XY6.e(strG);
        ((TextView) viewInflate.findViewById(BC5.card_number_tv)).setText("xxxxx " + strE);
        ((TextView) viewInflate.findViewById(BC5.remaining_money_tv)).setText(strE2 + " ریال ");
        View viewFindViewById = viewInflate.findViewById(BC5.vertical_divider);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(BC5.linear_balance_visible);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(BC5.linear_balance_invisible);
        AbstractC13042fc3.f(viewInflate);
        i(viewInflate, h75.c());
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.CQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EQ4.g(h75, this, viewInflate, view2);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.DQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EQ4.h(h75, this, viewInflate, view2);
            }
        });
        return viewInflate;
    }
}
