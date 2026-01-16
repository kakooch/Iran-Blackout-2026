package ir.nasim;

import android.app.Activity;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.tour.NewPagerWithIndicator;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010$\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000e¢\u0006\u0004\b+\u0010\u0011J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b,\u0010\nJ\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0003R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00107\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u0010\u001dR\u0018\u0010'\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bH\u0010@R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010S\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\bR\u0010<R\u0014\u0010U\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\bT\u0010<R\u0018\u0010X\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006Y"}, d2 = {"Lir/nasim/SG;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "X9", "Y9", "Landroid/view/View$OnClickListener;", "onclickListener", "ma", "(Landroid/view/View$OnClickListener;)V", "na", "fa", "aa", "", "count", "ea", "(I)V", "index", "ja", "", "Z9", "()Z", "la", "selectedPosition", "ka", "Landroid/view/View;", "view", "pa", "(Landroid/view/View;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroidx/viewpager/widget/a;", "adapter", "ga", "(Landroidx/viewpager/widget/a;)V", "position", "ha", "ia", "h7", "Landroid/app/Activity;", "c1", "Landroid/app/Activity;", "parentActivity", "d1", "Landroid/view/View;", "W9", "()Landroid/view/View;", "oa", "rootView", "Lir/nasim/OG;", "e1", "Lir/nasim/OG;", "f1", TokenNames.I, "offset", "Landroid/widget/TextView;", "g1", "Landroid/widget/TextView;", "nextButton", "h1", "previousButton", "Landroid/widget/ImageView;", "i1", "Landroid/widget/ImageView;", "doneButton", "j1", "textIndicator", "Landroid/widget/LinearLayout;", "k1", "Landroid/widget/LinearLayout;", "layoutIndicator", "Landroidx/viewpager/widget/ViewPager;", "l1", "Landroidx/viewpager/widget/ViewPager;", "viewPagerBullet", "m1", "activeColorTint", "n1", "inactiveColorTint", "o1", "Landroidx/viewpager/widget/a;", "mPagerAdapter", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class SG extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    private Activity parentActivity;

    /* renamed from: d1, reason: from kotlin metadata */
    public View rootView;

    /* renamed from: e1, reason: from kotlin metadata */
    private OG adapter;

    /* renamed from: f1, reason: from kotlin metadata */
    private final int offset = 20;

    /* renamed from: g1, reason: from kotlin metadata */
    private TextView nextButton;

    /* renamed from: h1, reason: from kotlin metadata */
    private TextView previousButton;

    /* renamed from: i1, reason: from kotlin metadata */
    private ImageView doneButton;

    /* renamed from: j1, reason: from kotlin metadata */
    private TextView textIndicator;

    /* renamed from: k1, reason: from kotlin metadata */
    private LinearLayout layoutIndicator;

    /* renamed from: l1, reason: from kotlin metadata */
    private ViewPager viewPagerBullet;

    /* renamed from: m1, reason: from kotlin metadata */
    private final int activeColorTint;

    /* renamed from: n1, reason: from kotlin metadata */
    private final int inactiveColorTint;

    /* renamed from: o1, reason: from kotlin metadata */
    private androidx.viewpager.widget.a mPagerAdapter;

    private final void X9() throws Resources.NotFoundException {
        ViewPager viewPager = this.viewPagerBullet;
        if (viewPager == null) {
            AbstractC13042fc3.y("viewPagerBullet");
            viewPager = null;
        }
        ha(viewPager.getCurrentItem() + 1);
    }

    private final void Y9() throws Resources.NotFoundException {
        ViewPager viewPager = this.viewPagerBullet;
        if (viewPager == null) {
            AbstractC13042fc3.y("viewPagerBullet");
            viewPager = null;
        }
        ha(viewPager.getCurrentItem() - 1);
    }

    private final boolean Z9() {
        ViewPager viewPager = this.viewPagerBullet;
        if (viewPager == null) {
            AbstractC13042fc3.y("viewPagerBullet");
            viewPager = null;
        }
        androidx.viewpager.widget.a adapter = viewPager.getAdapter();
        return adapter != null && adapter.d() > this.offset;
    }

    private final void aa() throws Resources.NotFoundException {
        this.viewPagerBullet = (ViewPager) W9().findViewById(BC5.viewPagerBullet);
        this.nextButton = (TextView) W9().findViewById(BC5.text_btn_next);
        this.previousButton = (TextView) W9().findViewById(BC5.text_previous_next);
        this.doneButton = (ImageView) W9().findViewById(BC5.btn_done);
        this.layoutIndicator = (LinearLayout) W9().findViewById(BC5.pagerBulletIndicator);
        this.textIndicator = (TextView) W9().findViewById(BC5.pagerBulletIndicatorText);
        TextView textView = this.nextButton;
        ViewPager viewPager = null;
        if (textView == null) {
            AbstractC13042fc3.y("nextButton");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.i());
        TextView textView2 = this.nextButton;
        if (textView2 == null) {
            AbstractC13042fc3.y("nextButton");
            textView2 = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView2.setTextColor(c5495Jo7.b());
        TextView textView3 = this.previousButton;
        if (textView3 == null) {
            AbstractC13042fc3.y("previousButton");
            textView3 = null;
        }
        textView3.setTypeface(C6011Lu2.i());
        TextView textView4 = this.previousButton;
        if (textView4 == null) {
            AbstractC13042fc3.y("previousButton");
            textView4 = null;
        }
        textView4.setTextColor(c5495Jo7.e0());
        ViewPager viewPager2 = this.viewPagerBullet;
        if (viewPager2 == null) {
            AbstractC13042fc3.y("viewPagerBullet");
        } else {
            viewPager = viewPager2;
        }
        viewPager.setOffscreenPageLimit(4);
        viewPager.c(new a());
        fa();
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        OG og = new OG(fragmentActivityQ7, 6);
        this.adapter = og;
        AbstractC13042fc3.f(og);
        ga(og);
        OG og2 = this.adapter;
        AbstractC13042fc3.f(og2);
        og2.j();
        ma(new View.OnClickListener() { // from class: ir.nasim.PG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SG.ba(this.a, view);
            }
        });
        na(new View.OnClickListener() { // from class: ir.nasim.QG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SG.ca(this.a, view);
            }
        });
        ia(new View.OnClickListener() { // from class: ir.nasim.RG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SG.da(this.a, view);
            }
        });
        W9().setLayoutDirection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(SG sg, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(sg, "this$0");
        sg.X9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(SG sg, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(sg, "this$0");
        sg.Y9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(SG sg, View view) {
        AbstractC13042fc3.i(sg, "this$0");
        sg.Q7().onBackPressed();
    }

    private final void ea(int count) {
        LinearLayout linearLayout = this.layoutIndicator;
        if (linearLayout == null) {
            AbstractC13042fc3.y("layoutIndicator");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int iD = AbstractC20723sV3.d(S7().getResources().getDimension(AbstractC14008hB5.pager_bullet_indicator_dot_margin));
        layoutParams.setMargins(iD, 0, iD, 0);
        Drawable drawableF = AbstractC4043Dl1.f(S7(), KB5.arbaeen_inactive_dot);
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(G5());
            imageView.setImageDrawable(drawableF);
            LinearLayout linearLayout2 = this.layoutIndicator;
            if (linearLayout2 == null) {
                AbstractC13042fc3.y("layoutIndicator");
                linearLayout2 = null;
            }
            linearLayout2.addView(imageView, layoutParams);
        }
    }

    private final void fa() {
        ViewPager viewPager = this.viewPagerBullet;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            AbstractC13042fc3.y("viewPagerBullet");
            viewPager = null;
        }
        androidx.viewpager.widget.a adapter = viewPager.getAdapter();
        if (adapter != null) {
            boolean zZ9 = Z9();
            TextView textView = this.textIndicator;
            if (textView == null) {
                AbstractC13042fc3.y("textIndicator");
                textView = null;
            }
            textView.setVisibility(zZ9 ? 0 : 4);
            LinearLayout linearLayout = this.layoutIndicator;
            if (linearLayout == null) {
                AbstractC13042fc3.y("layoutIndicator");
                linearLayout = null;
            }
            linearLayout.setVisibility(zZ9 ? 4 : 0);
            if (!zZ9) {
                ea(adapter.d());
            }
            ViewPager viewPager3 = this.viewPagerBullet;
            if (viewPager3 == null) {
                AbstractC13042fc3.y("viewPagerBullet");
            } else {
                viewPager2 = viewPager3;
            }
            ja(viewPager2.getCurrentItem());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja(int index) {
        if (Z9()) {
            la(index);
        } else {
            ka(index);
        }
    }

    private final void ka(int selectedPosition) {
        Drawable drawableF = AbstractC4043Dl1.f(S7(), KB5.arbaeen_inactive_dot);
        NewPagerWithIndicator.Companion companion = NewPagerWithIndicator.INSTANCE;
        Drawable drawableA = companion.a(drawableF, this.inactiveColorTint);
        Drawable drawableA2 = companion.a(AbstractC4043Dl1.f(S7(), KB5.arbaeen_active_dot), this.activeColorTint);
        LinearLayout linearLayout = this.layoutIndicator;
        if (linearLayout == null) {
            AbstractC13042fc3.y("layoutIndicator");
            linearLayout = null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LinearLayout linearLayout2 = this.layoutIndicator;
            if (linearLayout2 == null) {
                AbstractC13042fc3.y("layoutIndicator");
                linearLayout2 = null;
            }
            View childAt = linearLayout2.getChildAt(i);
            AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) childAt;
            if (i != selectedPosition) {
                imageView.setImageDrawable(drawableA);
            } else {
                imageView.setImageDrawable(drawableA2);
            }
        }
    }

    private final void la(int index) {
        ViewPager viewPager = this.viewPagerBullet;
        TextView textView = null;
        if (viewPager == null) {
            AbstractC13042fc3.y("viewPagerBullet");
            viewPager = null;
        }
        androidx.viewpager.widget.a adapter = viewPager.getAdapter();
        if (adapter != null) {
            int iD = adapter.d();
            TextView textView2 = this.textIndicator;
            if (textView2 == null) {
                AbstractC13042fc3.y("textIndicator");
            } else {
                textView = textView2;
            }
            DY6 dy6 = DY6.a;
            String string = S7().getString(AbstractC12217eE5.pager_bullet_separator);
            AbstractC13042fc3.h(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(index + 1), String.valueOf(iD)}, 2));
            AbstractC13042fc3.h(str, "format(...)");
            textView.setText(str);
        }
    }

    private final void ma(View.OnClickListener onclickListener) {
        TextView textView = this.nextButton;
        if (textView == null) {
            AbstractC13042fc3.y("nextButton");
            textView = null;
        }
        textView.setOnClickListener(onclickListener);
    }

    private final void na(View.OnClickListener onclickListener) {
        TextView textView = this.previousButton;
        if (textView == null) {
            AbstractC13042fc3.y("previousButton");
            textView = null;
        }
        textView.setOnClickListener(onclickListener);
    }

    private final void pa(View view) {
        View viewFindViewById = view.findViewById(BC5.arbaeen_help_toolbar);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        BaleToolbar baleToolbar = (BaleToolbar) viewFindViewById;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        baleToolbar.setTitle(AbstractC12217eE5.arbaeen_help_title);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws Resources.NotFoundException {
        AbstractC13042fc3.i(inflater, "inflater");
        oa(inflater.inflate(AbstractC12208eD5.fragment_arbaeen_help, container, false));
        this.parentActivity = Q7();
        pa(W9());
        aa();
        return W9();
    }

    public final View W9() {
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        AbstractC13042fc3.y("rootView");
        return null;
    }

    public final void ga(androidx.viewpager.widget.a adapter) throws Resources.NotFoundException {
        AbstractC13042fc3.i(adapter, "adapter");
        this.mPagerAdapter = adapter;
        ViewPager viewPager = this.viewPagerBullet;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            AbstractC13042fc3.y("viewPagerBullet");
            viewPager = null;
        }
        viewPager.setPageTransformer(false, new C25054zf2());
        ViewPager viewPager3 = this.viewPagerBullet;
        if (viewPager3 == null) {
            AbstractC13042fc3.y("viewPagerBullet");
        } else {
            viewPager2 = viewPager3;
        }
        viewPager2.setAdapter(adapter);
        fa();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        if (this.parentActivity == null) {
            this.parentActivity = A5();
        }
        C23381wp3.c(this.parentActivity);
    }

    public final void ha(int position) throws Resources.NotFoundException {
        ViewPager viewPager = this.viewPagerBullet;
        if (viewPager == null) {
            AbstractC13042fc3.y("viewPagerBullet");
            viewPager = null;
        }
        viewPager.setCurrentItem(position);
        ja(position);
    }

    public final void ia(View.OnClickListener onclickListener) {
        AbstractC13042fc3.i(onclickListener, "onclickListener");
        ImageView imageView = this.doneButton;
        if (imageView == null) {
            AbstractC13042fc3.y("doneButton");
            imageView = null;
        }
        imageView.setOnClickListener(onclickListener);
    }

    public final void oa(View view) {
        AbstractC13042fc3.i(view, "<set-?>");
        this.rootView = view;
    }

    public static final class a implements ViewPager.i {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void d(int i) {
            SG.this.ja(i);
            androidx.viewpager.widget.a aVar = SG.this.mPagerAdapter;
            TextView textView = null;
            ImageView imageView = null;
            TextView textView2 = null;
            if (i == (aVar != null ? aVar.d() : 0) - 1) {
                TextView textView3 = SG.this.nextButton;
                if (textView3 == null) {
                    AbstractC13042fc3.y("nextButton");
                    textView3 = null;
                }
                textView3.setTextColor(C5495Jo7.a.e0());
                TextView textView4 = SG.this.nextButton;
                if (textView4 == null) {
                    AbstractC13042fc3.y("nextButton");
                    textView4 = null;
                }
                textView4.setVisibility(8);
                ImageView imageView2 = SG.this.doneButton;
                if (imageView2 == null) {
                    AbstractC13042fc3.y("doneButton");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(0);
                return;
            }
            if (i == 0) {
                TextView textView5 = SG.this.previousButton;
                if (textView5 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView5 = null;
                }
                C5495Jo7 c5495Jo7 = C5495Jo7.a;
                textView5.setTextColor(c5495Jo7.e0());
                TextView textView6 = SG.this.previousButton;
                if (textView6 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView6 = null;
                }
                textView6.setEnabled(false);
                TextView textView7 = SG.this.nextButton;
                if (textView7 == null) {
                    AbstractC13042fc3.y("nextButton");
                    textView7 = null;
                }
                textView7.setTextColor(c5495Jo7.b());
                TextView textView8 = SG.this.nextButton;
                if (textView8 == null) {
                    AbstractC13042fc3.y("nextButton");
                } else {
                    textView2 = textView8;
                }
                textView2.setEnabled(true);
                return;
            }
            TextView textView9 = SG.this.nextButton;
            if (textView9 == null) {
                AbstractC13042fc3.y("nextButton");
                textView9 = null;
            }
            textView9.setVisibility(0);
            TextView textView10 = SG.this.previousButton;
            if (textView10 == null) {
                AbstractC13042fc3.y("previousButton");
                textView10 = null;
            }
            textView10.setVisibility(0);
            TextView textView11 = SG.this.previousButton;
            if (textView11 == null) {
                AbstractC13042fc3.y("previousButton");
                textView11 = null;
            }
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            textView11.setTextColor(c5495Jo72.D0());
            TextView textView12 = SG.this.previousButton;
            if (textView12 == null) {
                AbstractC13042fc3.y("previousButton");
                textView12 = null;
            }
            textView12.setEnabled(true);
            TextView textView13 = SG.this.nextButton;
            if (textView13 == null) {
                AbstractC13042fc3.y("nextButton");
                textView13 = null;
            }
            textView13.setTextColor(c5495Jo72.b());
            TextView textView14 = SG.this.nextButton;
            if (textView14 == null) {
                AbstractC13042fc3.y("nextButton");
                textView14 = null;
            }
            textView14.setEnabled(true);
            ImageView imageView3 = SG.this.doneButton;
            if (imageView3 == null) {
                AbstractC13042fc3.y("doneButton");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            TextView textView15 = SG.this.nextButton;
            if (textView15 == null) {
                AbstractC13042fc3.y("nextButton");
            } else {
                textView = textView15;
            }
            textView.setVisibility(0);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
        }
    }
}
