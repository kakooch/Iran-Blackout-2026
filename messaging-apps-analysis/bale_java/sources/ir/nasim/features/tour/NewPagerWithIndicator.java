package ir.nasim.features.tour;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14008hB5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C13250fu4;
import ir.nasim.C22078ud6;
import ir.nasim.C25054zf2;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.DY6;
import ir.nasim.ED1;
import ir.nasim.KB5;
import ir.nasim.TA5;
import ir.nasim.features.tour.NewPagerWithIndicator;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\fJ\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b!\u0010\u001eJ\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\bJ\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b#\u0010\u0018R\u0014\u0010&\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010;\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0010\u0010%R\u0014\u0010<\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0018\u0010>\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010=R\"\u0010B\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010%\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\fR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010D¨\u0006G"}, d2 = {"Lir/nasim/features/tour/NewPagerWithIndicator;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lir/nasim/rB7;", "h", "()V", "", "count", "i", "(I)V", "index", "setIndicatorItem", "", "g", "()Z", "setItemText", "selectedPosition", "setItemBullet", "Landroidx/viewpager/widget/a;", "adapter", "setAdapter", "(Landroidx/viewpager/widget/a;)V", "position", "setCurrentItem", "Landroid/view/View$OnClickListener;", "onclickListener", "setNextButtonOnclickListener", "(Landroid/view/View$OnClickListener;)V", "setPreviousButtonOnclickListener", "setSkipTextOnclickListener", "setDoneOnclickListener", "j", "k", "a", TokenNames.I, "offset", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "nextButton", "c", "previousButton", "d", "skipButton", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "doneButton", "Landroidx/viewpager/widget/ViewPager;", "f", "Landroidx/viewpager/widget/ViewPager;", "getViewPagerBullet", "()Landroidx/viewpager/widget/ViewPager;", "setViewPagerBullet", "(Landroidx/viewpager/widget/ViewPager;)V", "viewPagerBullet", "activeColorTint", "inactiveColorTint", "Landroidx/viewpager/widget/a;", "mPagerAdapter", "getLastIndex$nasim_release", "()I", "setLastIndex$nasim_release", "lastIndex", "Lir/nasim/fu4;", "Lir/nasim/fu4;", "bindingIntroLayout", "l", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class NewPagerWithIndicator extends FrameLayout {

    /* renamed from: l, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m = 8;
    private static final int n = 20;

    /* renamed from: a, reason: from kotlin metadata */
    private final int offset;

    /* renamed from: b, reason: from kotlin metadata */
    private TextView nextButton;

    /* renamed from: c, reason: from kotlin metadata */
    private TextView previousButton;

    /* renamed from: d, reason: from kotlin metadata */
    private TextView skipButton;

    /* renamed from: e, reason: from kotlin metadata */
    private ImageView doneButton;

    /* renamed from: f, reason: from kotlin metadata */
    public ViewPager viewPagerBullet;

    /* renamed from: g, reason: from kotlin metadata */
    private final int activeColorTint;

    /* renamed from: h, reason: from kotlin metadata */
    private final int inactiveColorTint;

    /* renamed from: i, reason: from kotlin metadata */
    private a mPagerAdapter;

    /* renamed from: j, reason: from kotlin metadata */
    private int lastIndex;

    /* renamed from: k, reason: from kotlin metadata */
    private C13250fu4 bindingIntroLayout;

    /* renamed from: ir.nasim.features.tour.NewPagerWithIndicator$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Drawable a(Drawable drawable, int i) {
            if (i == 0) {
                return drawable;
            }
            AbstractC13042fc3.f(drawable);
            Drawable drawableL = AbstractC21710u02.l(drawable);
            AbstractC13042fc3.h(drawableL, "wrap(...)");
            AbstractC21710u02.h(drawableL, i);
            drawableL.setBounds(0, 0, drawableL.getIntrinsicWidth(), drawableL.getIntrinsicHeight());
            return drawableL;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements ViewPager.i {
        final /* synthetic */ ViewPager b;

        b(ViewPager viewPager) {
            this.b = viewPager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(LottieAnimationView lottieAnimationView) {
            AbstractC13042fc3.i(lottieAnimationView, "$lottieAnimationView");
            lottieAnimationView.k();
            lottieAnimationView.v(true);
            lottieAnimationView.x();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(LottieAnimationView lottieAnimationView) {
            AbstractC13042fc3.i(lottieAnimationView, "$lottieAnimationView");
            lottieAnimationView.k();
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            if (f != 0.0f || i == NewPagerWithIndicator.this.getLastIndex()) {
                return;
            }
            NewPagerWithIndicator.this.setLastIndex$nasim_release(i);
            View childAt = this.b.getChildAt(i);
            AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt2 = ((ViewGroup) childAt).getChildAt(0);
            AbstractC13042fc3.g(childAt2, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) childAt2;
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.tu4
                @Override // java.lang.Runnable
                public final void run() {
                    NewPagerWithIndicator.b.f(lottieAnimationView);
                }
            });
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void d(int i) {
            NewPagerWithIndicator.this.setIndicatorItem(i);
            a aVar = NewPagerWithIndicator.this.mPagerAdapter;
            ImageView imageView = null;
            if (i == (aVar != null ? aVar.d() : 0) - 1) {
                TextView textView = NewPagerWithIndicator.this.nextButton;
                if (textView == null) {
                    AbstractC13042fc3.y("nextButton");
                    textView = null;
                }
                textView.setVisibility(4);
                TextView textView2 = NewPagerWithIndicator.this.previousButton;
                if (textView2 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView2 = null;
                }
                textView2.setVisibility(4);
                TextView textView3 = NewPagerWithIndicator.this.skipButton;
                if (textView3 == null) {
                    AbstractC13042fc3.y("skipButton");
                    textView3 = null;
                }
                textView3.setVisibility(4);
                ImageView imageView2 = NewPagerWithIndicator.this.doneButton;
                if (imageView2 == null) {
                    AbstractC13042fc3.y("doneButton");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(0);
            } else if (i == 0) {
                TextView textView4 = NewPagerWithIndicator.this.previousButton;
                if (textView4 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView4 = null;
                }
                textView4.setTextColor(C5495Jo7.a.e0());
                TextView textView5 = NewPagerWithIndicator.this.previousButton;
                if (textView5 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView5 = null;
                }
                textView5.setEnabled(false);
                ImageView imageView3 = NewPagerWithIndicator.this.doneButton;
                if (imageView3 == null) {
                    AbstractC13042fc3.y("doneButton");
                } else {
                    imageView = imageView3;
                }
                imageView.setVisibility(8);
            } else {
                TextView textView6 = NewPagerWithIndicator.this.nextButton;
                if (textView6 == null) {
                    AbstractC13042fc3.y("nextButton");
                    textView6 = null;
                }
                textView6.setVisibility(0);
                TextView textView7 = NewPagerWithIndicator.this.previousButton;
                if (textView7 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView7 = null;
                }
                textView7.setVisibility(0);
                TextView textView8 = NewPagerWithIndicator.this.skipButton;
                if (textView8 == null) {
                    AbstractC13042fc3.y("skipButton");
                    textView8 = null;
                }
                textView8.setVisibility(0);
                TextView textView9 = NewPagerWithIndicator.this.previousButton;
                if (textView9 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView9 = null;
                }
                textView9.setTextColor(C5495Jo7.a.t2());
                TextView textView10 = NewPagerWithIndicator.this.previousButton;
                if (textView10 == null) {
                    AbstractC13042fc3.y("previousButton");
                    textView10 = null;
                }
                textView10.setEnabled(true);
                ImageView imageView4 = NewPagerWithIndicator.this.doneButton;
                if (imageView4 == null) {
                    AbstractC13042fc3.y("doneButton");
                } else {
                    imageView = imageView4;
                }
                imageView.setVisibility(8);
            }
            if (NewPagerWithIndicator.this.getLastIndex() == i || NewPagerWithIndicator.this.getLastIndex() == -1) {
                return;
            }
            View childAt = this.b.getChildAt(NewPagerWithIndicator.this.getLastIndex());
            AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt2 = ((ViewGroup) childAt).getChildAt(0);
            AbstractC13042fc3.g(childAt2, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) childAt2;
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.su4
                @Override // java.lang.Runnable
                public final void run() {
                    NewPagerWithIndicator.b.g(lottieAnimationView);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPagerWithIndicator(Context context) throws Resources.NotFoundException {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.offset = n;
        this.lastIndex = -1;
        C13250fu4 c13250fu4C = C13250fu4.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(c13250fu4C, "inflate(...)");
        this.bindingIntroLayout = c13250fu4C;
        h();
    }

    private final boolean g() {
        a adapter = this.bindingIntroLayout.e.getAdapter();
        return adapter != null && adapter.d() > this.offset;
    }

    private final void h() throws Resources.NotFoundException {
        TextView textView = this.bindingIntroLayout.b.f;
        int iC = AbstractC4043Dl1.c(getContext(), TA5.background_3);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setBackground(AbstractC4310Eo7.j(iC, c5495Jo7.y0(c5495Jo7.n0(), 27), C22078ud6.a(4.0f)));
        textView.setTypeface(C6011Lu2.i());
        textView.setTextColor(c5495Jo7.t2());
        this.nextButton = textView;
        TextView textView2 = this.bindingIntroLayout.b.g;
        textView2.setBackground(AbstractC4310Eo7.j(AbstractC4043Dl1.c(getContext(), TA5.background_3), c5495Jo7.y0(c5495Jo7.n0(), 27), C22078ud6.a(4.0f)));
        textView2.setTypeface(C6011Lu2.i());
        textView2.setTextColor(c5495Jo7.e0());
        this.previousButton = textView2;
        TextView textView3 = this.bindingIntroLayout.d;
        textView3.setBackground(AbstractC4310Eo7.j(AbstractC4043Dl1.c(getContext(), TA5.background_3), c5495Jo7.y0(c5495Jo7.n0(), 27), C22078ud6.a(4.0f)));
        textView3.setTypeface(C6011Lu2.k());
        textView3.setTextColor(c5495Jo7.f1());
        this.skipButton = textView3;
        C13250fu4 c13250fu4 = this.bindingIntroLayout;
        this.doneButton = c13250fu4.b.b;
        setViewPagerBullet(c13250fu4.e);
        ViewPager viewPager = this.bindingIntroLayout.e;
        viewPager.setOffscreenPageLimit(4);
        viewPager.c(new b(viewPager));
    }

    private final void i(int count) {
        this.bindingIntroLayout.b.c.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int iRound = Math.round(getContext().getResources().getDimension(AbstractC14008hB5.pager_bullet_indicator_dot_margin));
        layoutParams.setMargins(iRound, 0, iRound, 0);
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), KB5.inactive_dot);
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(drawableF);
            this.bindingIntroLayout.b.c.addView(imageView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setIndicatorItem(int index) {
        if (g()) {
            setItemText(index);
        } else {
            setItemBullet(index);
        }
    }

    private final void setItemBullet(int selectedPosition) {
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), KB5.new_inactive_dot);
        Companion companion = INSTANCE;
        Drawable drawableA = companion.a(drawableF, this.inactiveColorTint);
        Drawable drawableA2 = companion.a(AbstractC4043Dl1.f(getContext(), KB5.new_active_dot), this.activeColorTint);
        int childCount = this.bindingIntroLayout.b.c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bindingIntroLayout.b.c.getChildAt(i);
            AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) childAt;
            if (i != selectedPosition) {
                imageView.setImageDrawable(drawableA);
            } else {
                imageView.setImageDrawable(drawableA2);
            }
        }
    }

    private final void setItemText(int index) {
        a adapter = this.bindingIntroLayout.e.getAdapter();
        if (adapter != null) {
            int iD = adapter.d();
            TextView textView = this.bindingIntroLayout.b.e;
            DY6 dy6 = DY6.a;
            String string = getContext().getString(AbstractC12217eE5.pager_bullet_separator);
            AbstractC13042fc3.h(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(index + 1), String.valueOf(iD)}, 2));
            AbstractC13042fc3.h(str, "format(...)");
            textView.setText(str);
        }
    }

    /* renamed from: getLastIndex$nasim_release, reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    public final ViewPager getViewPagerBullet() {
        ViewPager viewPager = this.viewPagerBullet;
        if (viewPager != null) {
            return viewPager;
        }
        AbstractC13042fc3.y("viewPagerBullet");
        return null;
    }

    public final void j() {
        a adapter = getViewPagerBullet().getAdapter();
        if (adapter != null) {
            k(adapter);
        }
    }

    public final void k(a adapter) {
        AbstractC13042fc3.i(adapter, "adapter");
        boolean zG = g();
        this.bindingIntroLayout.b.e.setVisibility(zG ? 0 : 4);
        this.bindingIntroLayout.b.c.setVisibility(zG ? 4 : 0);
        if (!zG) {
            i(adapter.d());
        }
        setIndicatorItem(this.bindingIntroLayout.e.getCurrentItem());
    }

    public final void setAdapter(a adapter) {
        AbstractC13042fc3.i(adapter, "adapter");
        this.mPagerAdapter = adapter;
        this.bindingIntroLayout.e.setPageTransformer(false, new C25054zf2());
        this.bindingIntroLayout.e.setAdapter(adapter);
        k(adapter);
    }

    public final void setCurrentItem(int position) {
        this.bindingIntroLayout.e.setCurrentItem(position);
        setIndicatorItem(position);
    }

    public final void setDoneOnclickListener(View.OnClickListener onclickListener) {
        AbstractC13042fc3.i(onclickListener, "onclickListener");
        this.bindingIntroLayout.b.b.setOnClickListener(onclickListener);
    }

    public final void setLastIndex$nasim_release(int i) {
        this.lastIndex = i;
    }

    public final void setNextButtonOnclickListener(View.OnClickListener onclickListener) {
        AbstractC13042fc3.i(onclickListener, "onclickListener");
        this.bindingIntroLayout.b.f.setOnClickListener(onclickListener);
    }

    public final void setPreviousButtonOnclickListener(View.OnClickListener onclickListener) {
        AbstractC13042fc3.i(onclickListener, "onclickListener");
        this.bindingIntroLayout.b.g.setOnClickListener(onclickListener);
    }

    public final void setSkipTextOnclickListener(View.OnClickListener onclickListener) {
        AbstractC13042fc3.i(onclickListener, "onclickListener");
        this.bindingIntroLayout.d.setOnClickListener(onclickListener);
    }

    public final void setViewPagerBullet(ViewPager viewPager) {
        AbstractC13042fc3.i(viewPager, "<set-?>");
        this.viewPagerBullet = viewPager;
    }
}
