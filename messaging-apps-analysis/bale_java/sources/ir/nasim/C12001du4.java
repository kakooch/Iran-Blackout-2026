package ir.nasim;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* renamed from: ir.nasim.du4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12001du4 extends androidx.viewpager.widget.a {
    private final Context c;
    private final int d;
    private final int[] e;
    private final int[] f;
    private final int[] g;

    public C12001du4(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        this.c = context;
        this.d = i;
        this.e = new int[]{AbstractC19954rD5.slide1, AbstractC19954rD5.slide0, AbstractC19954rD5.slide2, AbstractC19954rD5.slide3, AbstractC19954rD5.slide4};
        this.f = new int[]{AbstractC12217eE5.new_intro_title0, AbstractC12217eE5.new_intro_title1, AbstractC12217eE5.new_intro_title2, AbstractC12217eE5.new_intro_title3, AbstractC12217eE5.new_intro_title4};
        this.g = new int[]{AbstractC12217eE5.new_intro_description0, AbstractC12217eE5.new_intro_description1, AbstractC12217eE5.new_intro_description2, AbstractC12217eE5.new_intro_description3, AbstractC12217eE5.new_intro_description4};
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object obj) {
        AbstractC13042fc3.i(viewGroup, "collection");
        AbstractC13042fc3.i(obj, "view");
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.d;
    }

    @Override // androidx.viewpager.widget.a
    public int e(Object obj) {
        AbstractC13042fc3.i(obj, "object");
        return -2;
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "container");
        View viewInflate = View.inflate(viewGroup.getContext(), AbstractC12208eD5.new_adapter_intro, null);
        ((LottieAnimationView) viewInflate.findViewById(BC5.intro_lottie_animation)).setAnimation(this.e[i]);
        TextView textView = (TextView) viewInflate.findViewById(BC5.intro_title);
        textView.setText(this.f[i]);
        textView.setTypeface(C6011Lu2.i());
        textView.setTextColor(this.c.getResources().getColor(TA5.c10));
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.intro_description);
        textView2.setText(this.g[i]);
        textView2.setTypeface(C6011Lu2.k());
        textView2.setTextColor(this.c.getResources().getColor(TA5.c9));
        viewGroup.addView(viewInflate);
        AbstractC13042fc3.f(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(obj, "object");
        return AbstractC13042fc3.d(view, obj);
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable m() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void s(DataSetObserver dataSetObserver) {
        AbstractC13042fc3.i(dataSetObserver, "observer");
        super.s(dataSetObserver);
    }

    @Override // androidx.viewpager.widget.a
    public void l(Parcelable parcelable, ClassLoader classLoader) {
    }
}
