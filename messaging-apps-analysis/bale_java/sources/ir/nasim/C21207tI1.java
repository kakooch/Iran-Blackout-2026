package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.nasim.AbstractC13863gw6;

/* renamed from: ir.nasim.tI1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21207tI1 extends AbstractC15063iw6 {
    public static final a v = new a(null);
    private final TextView u;

    /* renamed from: ir.nasim.tI1$a */
    public static final class a {
        private a() {
        }

        public final C21207tI1 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            return new C21207tI1(new TextView(viewGroup.getContext()), null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C21207tI1(TextView textView, ED1 ed1) {
        this(textView);
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void C0(AbstractC13863gw6 abstractC13863gw6) {
        AbstractC13042fc3.i(abstractC13863gw6, "item");
        TextView textView = this.u;
        AbstractC13863gw6.b bVar = (AbstractC13863gw6.b) abstractC13863gw6;
        Context context = textView.getContext();
        int iG = bVar.g();
        Context context2 = textView.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        textView.setText(context.getString(iG, AbstractC20655sN7.i(context2, bVar.h(), false, 2, null)));
    }

    private C21207tI1(TextView textView) {
        super(textView);
        this.u = textView;
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setPadding(AbstractC8943Xx1.c(16), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(16), AbstractC8943Xx1.c(8));
        textView.setTextSize(2, 13.0f);
        textView.setTypeface(C6011Lu2.k());
        textView.setTextColor(AbstractC4043Dl1.c(textView.getContext(), TA5.color8));
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void a() {
    }
}
