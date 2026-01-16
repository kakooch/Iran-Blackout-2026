package ir.nasim.components.appbar.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14525i33;
import ir.nasim.AbstractC16172kp3;
import ir.nasim.AbstractC24188yB5;
import ir.nasim.C22078ud6;
import ir.nasim.C23381wp3;
import ir.nasim.C5161Id6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC4228Ef6;
import ir.nasim.SA2;
import ir.nasim.UD5;
import ir.nasim.components.appbar.view.SearchViewToolbar;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u000eJ\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010\u001dJ\r\u0010#\u001a\u00020\f¢\u0006\u0004\b#\u0010\u000eR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R*\u0010D\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR*\u0010H\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lir/nasim/components/appbar/view/SearchViewToolbar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "m", "()V", "rad", "defaultColor", "Landroid/graphics/drawable/Drawable;", "l", "(II)Landroid/graphics/drawable/Drawable;", "s", "t", "Lir/nasim/Ef6;", "searchCallback", "setSearchCallback", "(Lir/nasim/Ef6;)V", "", "query", "setSearchQuery", "(Ljava/lang/String;)V", "visibility", "setVisibility", "(I)V", "hint", "setSearchHint", "k", "Landroid/widget/EditText;", "a", "Landroid/widget/EditText;", "mEditTextSearch", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "searchButton", "c", "searchBackButton", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "searchProgressBar", "e", "Landroid/widget/FrameLayout;", "searchProgressBarBackground", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "mRelativeLayoutSearch", "Ljava/util/Timer;", "g", "Ljava/util/Timer;", "timer", "Lkotlin/Function0;", "h", "Lir/nasim/SA2;", "getCloseSearch", "()Lir/nasim/SA2;", "setCloseSearch", "(Lir/nasim/SA2;)V", "closeSearch", "i", "getOnBackClicked", "setOnBackClicked", "onBackClicked", "j", "Lir/nasim/Ef6;", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class SearchViewToolbar extends FrameLayout {
    public static final int l = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private EditText mEditTextSearch;

    /* renamed from: b, reason: from kotlin metadata */
    private ImageView searchButton;

    /* renamed from: c, reason: from kotlin metadata */
    private ImageView searchBackButton;

    /* renamed from: d, reason: from kotlin metadata */
    private ProgressBar searchProgressBar;

    /* renamed from: e, reason: from kotlin metadata */
    private FrameLayout searchProgressBarBackground;

    /* renamed from: f, reason: from kotlin metadata */
    private RelativeLayout mRelativeLayoutSearch;

    /* renamed from: g, reason: from kotlin metadata */
    private Timer timer;

    /* renamed from: h, reason: from kotlin metadata */
    private SA2 closeSearch;

    /* renamed from: i, reason: from kotlin metadata */
    private SA2 onBackClicked;

    /* renamed from: j, reason: from kotlin metadata */
    private InterfaceC4228Ef6 searchCallback;

    public static final class b implements TextWatcher {

        public static final class a extends TimerTask {
            final /* synthetic */ SearchViewToolbar a;

            a(SearchViewToolbar searchViewToolbar) {
                this.a = searchViewToolbar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(InterfaceC4228Ef6 interfaceC4228Ef6, SearchViewToolbar searchViewToolbar) {
                AbstractC13042fc3.i(interfaceC4228Ef6, "$this_apply");
                AbstractC13042fc3.i(searchViewToolbar, "this$0");
                EditText editText = searchViewToolbar.mEditTextSearch;
                if (editText == null) {
                    AbstractC13042fc3.y("mEditTextSearch");
                    editText = null;
                }
                interfaceC4228Ef6.d(editText.getText().toString());
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                final InterfaceC4228Ef6 interfaceC4228Ef6 = this.a.searchCallback;
                if (interfaceC4228Ef6 != null) {
                    final SearchViewToolbar searchViewToolbar = this.a;
                    searchViewToolbar.post(new Runnable() { // from class: ir.nasim.ni6
                        @Override // java.lang.Runnable
                        public final void run() {
                            SearchViewToolbar.b.a.b(interfaceC4228Ef6, searchViewToolbar);
                        }
                    });
                }
            }
        }

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            SearchViewToolbar searchViewToolbar = SearchViewToolbar.this;
            Timer timer = new Timer();
            timer.schedule(new a(SearchViewToolbar.this), 500L);
            searchViewToolbar.timer = timer;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            if (SearchViewToolbar.this.timer != null) {
                Timer timer = SearchViewToolbar.this.timer;
                AbstractC13042fc3.f(timer);
                timer.cancel();
            }
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            int iE = c5495Jo7.e();
            if (charSequence.length() == 0) {
                iE = c5495Jo7.f();
            }
            ImageView imageView = SearchViewToolbar.this.searchButton;
            if (imageView == null) {
                AbstractC13042fc3.y("searchButton");
                imageView = null;
            }
            AbstractC14525i33.c(imageView, ColorStateList.valueOf(iE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewToolbar(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        m();
    }

    private final Drawable l(int rad, int defaultColor) {
        float f = rad;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(defaultColor);
        return shapeDrawable;
    }

    private final void m() {
        EditText editText;
        setLayoutDirection(0);
        removeAllViews();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.mRelativeLayoutSearch = relativeLayout;
        addView(relativeLayout, 0);
        RelativeLayout relativeLayout2 = this.mRelativeLayoutSearch;
        if (relativeLayout2 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout2 = null;
        }
        int iE = C5161Id6.e(3.0f);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        relativeLayout2.setBackground(l(iE, c5495Jo7.c()));
        RelativeLayout relativeLayout3 = this.mRelativeLayoutSearch;
        if (relativeLayout3 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout3 = null;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout3.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        int iA = C22078ud6.a(8.0f);
        layoutParams2.leftMargin = iA;
        layoutParams2.topMargin = iA;
        layoutParams2.rightMargin = iA;
        layoutParams2.bottomMargin = iA;
        RelativeLayout relativeLayout4 = this.mRelativeLayoutSearch;
        if (relativeLayout4 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout4 = null;
        }
        relativeLayout4.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout5 = this.mRelativeLayoutSearch;
        if (relativeLayout5 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout5 = null;
        }
        relativeLayout5.setVisibility(0);
        EditText editText2 = new EditText(getContext());
        this.mEditTextSearch = editText2;
        editText2.setTextSize(2, 15.0f);
        editText2.setHintTextColor(c5495Jo7.d());
        editText2.setTextColor(c5495Jo7.g());
        editText2.setEllipsize(TextUtils.TruncateAt.END);
        editText2.setSingleLine();
        editText2.setTypeface(C6011Lu2.k());
        editText2.setBackgroundResource(0);
        editText2.setBackgroundColor(c5495Jo7.c());
        editText2.setInputType(1);
        editText2.setGravity(16);
        editText2.setPadding(0, 0, 0, 0);
        editText2.setImeOptions(33554435);
        String string = getContext().getString(UD5.search_hint_dialogs);
        AbstractC13042fc3.h(string, "getString(...)");
        setSearchHint(string);
        EditText editText3 = this.mEditTextSearch;
        if (editText3 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText3 = null;
        }
        editText3.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.ii6
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return SearchViewToolbar.n(this.a, textView, i, keyEvent);
            }
        });
        EditText editText4 = this.mEditTextSearch;
        if (editText4 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText4 = null;
        }
        editText4.addTextChangedListener(new b());
        EditText editText5 = this.mEditTextSearch;
        if (editText5 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText5 = null;
        }
        editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.ji6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SearchViewToolbar.o(this.a, view, z);
            }
        });
        RelativeLayout relativeLayout6 = this.mRelativeLayoutSearch;
        if (relativeLayout6 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout6 = null;
        }
        EditText editText6 = this.mEditTextSearch;
        if (editText6 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText6 = null;
        }
        relativeLayout6.addView(editText6);
        ImageView imageView = new ImageView(getContext());
        this.searchButton = imageView;
        imageView.setId(6);
        imageView.setImageResource(AbstractC24188yB5.search_grey_vd);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView.setScaleType(scaleType);
        imageView.setBackgroundColor(c5495Jo7.c());
        ImageView imageView2 = this.searchButton;
        if (imageView2 == null) {
            AbstractC13042fc3.y("searchButton");
            imageView2 = null;
        }
        AbstractC14525i33.c(imageView2, ColorStateList.valueOf(c5495Jo7.e()));
        ImageView imageView3 = this.searchButton;
        if (imageView3 == null) {
            AbstractC13042fc3.y("searchButton");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ki6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchViewToolbar.q(this.a, view);
            }
        });
        RelativeLayout relativeLayout7 = this.mRelativeLayoutSearch;
        if (relativeLayout7 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout7 = null;
        }
        ImageView imageView4 = this.searchButton;
        if (imageView4 == null) {
            AbstractC13042fc3.y("searchButton");
            imageView4 = null;
        }
        relativeLayout7.addView(imageView4);
        ImageView imageView5 = this.searchButton;
        if (imageView5 == null) {
            AbstractC13042fc3.y("searchButton");
            imageView5 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = imageView5.getLayoutParams();
        AbstractC13042fc3.g(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.width = C22078ud6.a(48.0f);
        layoutParams4.height = -1;
        layoutParams4.addRule(11);
        ImageView imageView6 = this.searchButton;
        if (imageView6 == null) {
            AbstractC13042fc3.y("searchButton");
            imageView6 = null;
        }
        imageView6.setLayoutParams(layoutParams4);
        ImageView imageView7 = new ImageView(getContext());
        imageView7.setId(5);
        imageView7.setImageResource(AbstractC24188yB5.back_grey_vd);
        imageView7.setScaleType(scaleType);
        imageView7.setBackgroundColor(c5495Jo7.c());
        this.searchBackButton = imageView7;
        AbstractC14525i33.c(imageView7, ColorStateList.valueOf(c5495Jo7.e()));
        ImageView imageView8 = this.searchBackButton;
        if (imageView8 == null) {
            AbstractC13042fc3.y("searchBackButton");
            imageView8 = null;
        }
        imageView8.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.li6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchViewToolbar.r(this.a, view);
            }
        });
        RelativeLayout relativeLayout8 = this.mRelativeLayoutSearch;
        if (relativeLayout8 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout8 = null;
        }
        ImageView imageView9 = this.searchBackButton;
        if (imageView9 == null) {
            AbstractC13042fc3.y("searchBackButton");
            imageView9 = null;
        }
        relativeLayout8.addView(imageView9);
        ImageView imageView10 = this.searchBackButton;
        if (imageView10 == null) {
            AbstractC13042fc3.y("searchBackButton");
            imageView10 = null;
        }
        ViewGroup.LayoutParams layoutParams5 = imageView10.getLayoutParams();
        AbstractC13042fc3.g(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        layoutParams6.width = C22078ud6.a(48.0f);
        layoutParams6.height = -1;
        layoutParams6.addRule(9);
        ImageView imageView11 = this.searchBackButton;
        if (imageView11 == null) {
            AbstractC13042fc3.y("searchBackButton");
            imageView11 = null;
        }
        imageView11.setLayoutParams(layoutParams6);
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setId(7);
        progressBar.setIndeterminate(true);
        this.searchProgressBar = progressBar;
        RelativeLayout relativeLayout9 = this.mRelativeLayoutSearch;
        if (relativeLayout9 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout9 = null;
        }
        ProgressBar progressBar2 = this.searchProgressBar;
        if (progressBar2 == null) {
            AbstractC13042fc3.y("searchProgressBar");
            progressBar2 = null;
        }
        relativeLayout9.addView(progressBar2);
        ProgressBar progressBar3 = this.searchProgressBar;
        if (progressBar3 == null) {
            AbstractC13042fc3.y("searchProgressBar");
            progressBar3 = null;
        }
        ViewGroup.LayoutParams layoutParams7 = progressBar3.getLayoutParams();
        AbstractC13042fc3.g(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        layoutParams8.width = C22078ud6.a(21.0f);
        layoutParams8.height = C22078ud6.a(21.0f);
        layoutParams8.rightMargin = C22078ud6.a(8.0f);
        ImageView imageView12 = this.searchBackButton;
        if (imageView12 == null) {
            AbstractC13042fc3.y("searchBackButton");
            imageView12 = null;
        }
        layoutParams8.addRule(1, imageView12.getId());
        layoutParams8.addRule(15);
        ProgressBar progressBar4 = this.searchProgressBar;
        if (progressBar4 == null) {
            AbstractC13042fc3.y("searchProgressBar");
            progressBar4 = null;
        }
        progressBar4.setLayoutParams(layoutParams8);
        ProgressBar progressBar5 = this.searchProgressBar;
        if (progressBar5 == null) {
            AbstractC13042fc3.y("searchProgressBar");
            progressBar5 = null;
        }
        progressBar5.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.searchProgressBarBackground = frameLayout;
        frameLayout.setBackgroundResource(AbstractC24188yB5.circle_progress_vd);
        RelativeLayout relativeLayout10 = this.mRelativeLayoutSearch;
        if (relativeLayout10 == null) {
            AbstractC13042fc3.y("mRelativeLayoutSearch");
            relativeLayout10 = null;
        }
        FrameLayout frameLayout2 = this.searchProgressBarBackground;
        if (frameLayout2 == null) {
            AbstractC13042fc3.y("searchProgressBarBackground");
            frameLayout2 = null;
        }
        relativeLayout10.addView(frameLayout2);
        ProgressBar progressBar6 = this.searchProgressBar;
        if (progressBar6 == null) {
            AbstractC13042fc3.y("searchProgressBar");
            progressBar6 = null;
        }
        ViewGroup.LayoutParams layoutParams9 = progressBar6.getLayoutParams();
        AbstractC13042fc3.g(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
        layoutParams10.width = C22078ud6.a(18.0f);
        layoutParams10.height = C22078ud6.a(18.0f);
        layoutParams10.rightMargin = C22078ud6.a(8.0f);
        ImageView imageView13 = this.searchBackButton;
        if (imageView13 == null) {
            AbstractC13042fc3.y("searchBackButton");
            imageView13 = null;
        }
        layoutParams10.addRule(1, imageView13.getId());
        layoutParams10.addRule(15);
        FrameLayout frameLayout3 = this.searchProgressBarBackground;
        if (frameLayout3 == null) {
            AbstractC13042fc3.y("searchProgressBarBackground");
            frameLayout3 = null;
        }
        frameLayout3.setLayoutParams(layoutParams10);
        FrameLayout frameLayout4 = this.searchProgressBarBackground;
        if (frameLayout4 == null) {
            AbstractC13042fc3.y("searchProgressBarBackground");
            frameLayout4 = null;
        }
        frameLayout4.setVisibility(8);
        EditText editText7 = this.mEditTextSearch;
        if (editText7 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText7 = null;
        }
        ViewGroup.LayoutParams layoutParams11 = editText7.getLayoutParams();
        AbstractC13042fc3.g(layoutParams11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) layoutParams11;
        layoutParams12.width = -1;
        layoutParams12.height = -1;
        ImageView imageView14 = this.searchButton;
        if (imageView14 == null) {
            AbstractC13042fc3.y("searchButton");
            imageView14 = null;
        }
        layoutParams12.addRule(0, imageView14.getId());
        ProgressBar progressBar7 = this.searchProgressBar;
        if (progressBar7 == null) {
            AbstractC13042fc3.y("searchProgressBar");
            progressBar7 = null;
        }
        layoutParams12.addRule(1, progressBar7.getId());
        EditText editText8 = this.mEditTextSearch;
        if (editText8 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        } else {
            editText = editText8;
        }
        editText.setLayoutParams(layoutParams12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(SearchViewToolbar searchViewToolbar, TextView textView, int i, KeyEvent keyEvent) {
        AbstractC13042fc3.i(searchViewToolbar, "this$0");
        if (keyEvent == null) {
            return false;
        }
        if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        EditText editText = searchViewToolbar.mEditTextSearch;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        }
        C23381wp3.f(editText);
        InterfaceC4228Ef6 interfaceC4228Ef6 = searchViewToolbar.searchCallback;
        if (interfaceC4228Ef6 == null) {
            return false;
        }
        EditText editText3 = searchViewToolbar.mEditTextSearch;
        if (editText3 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
        } else {
            editText2 = editText3;
        }
        interfaceC4228Ef6.a(editText2.getText().toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final SearchViewToolbar searchViewToolbar, View view, boolean z) {
        AbstractC13042fc3.i(searchViewToolbar, "this$0");
        EditText editText = null;
        if (!z) {
            EditText editText2 = searchViewToolbar.mEditTextSearch;
            if (editText2 == null) {
                AbstractC13042fc3.y("mEditTextSearch");
            } else {
                editText = editText2;
            }
            C23381wp3.f(editText);
            return;
        }
        EditText editText3 = searchViewToolbar.mEditTextSearch;
        if (editText3 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
        } else {
            editText = editText3;
        }
        C23381wp3.g(editText);
        view.postDelayed(new Runnable() { // from class: ir.nasim.mi6
            @Override // java.lang.Runnable
            public final void run() {
                SearchViewToolbar.p(this.a);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(SearchViewToolbar searchViewToolbar) {
        AbstractC13042fc3.i(searchViewToolbar, "this$0");
        EditText editText = searchViewToolbar.mEditTextSearch;
        if (editText == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        }
        C23381wp3.g(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(SearchViewToolbar searchViewToolbar, View view) {
        AbstractC13042fc3.i(searchViewToolbar, "this$0");
        EditText editText = searchViewToolbar.mEditTextSearch;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        }
        C23381wp3.f(editText);
        InterfaceC4228Ef6 interfaceC4228Ef6 = searchViewToolbar.searchCallback;
        if (interfaceC4228Ef6 != null) {
            EditText editText3 = searchViewToolbar.mEditTextSearch;
            if (editText3 == null) {
                AbstractC13042fc3.y("mEditTextSearch");
            } else {
                editText2 = editText3;
            }
            interfaceC4228Ef6.a(editText2.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(SearchViewToolbar searchViewToolbar, View view) {
        AbstractC13042fc3.i(searchViewToolbar, "this$0");
        searchViewToolbar.s();
    }

    private final void s() {
        k();
        SA2 sa2 = this.onBackClicked;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final SA2 getCloseSearch() {
        return this.closeSearch;
    }

    public final SA2 getOnBackClicked() {
        return this.onBackClicked;
    }

    public final void k() {
        EditText editText = this.mEditTextSearch;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        }
        AbstractC16172kp3.a(editText);
        SA2 sa2 = this.closeSearch;
        if (sa2 != null) {
            sa2.invoke();
        }
        EditText editText3 = this.mEditTextSearch;
        if (editText3 == null) {
            AbstractC13042fc3.y("mEditTextSearch");
        } else {
            editText2 = editText3;
        }
        editText2.setText("");
        setVisibility(8);
    }

    public final void setCloseSearch(SA2 sa2) {
        this.closeSearch = sa2;
    }

    public final void setOnBackClicked(SA2 sa2) {
        this.onBackClicked = sa2;
    }

    public final void setSearchCallback(InterfaceC4228Ef6 searchCallback) {
        AbstractC13042fc3.i(searchCallback, "searchCallback");
        this.searchCallback = searchCallback;
    }

    public final void setSearchHint(String hint) {
        AbstractC13042fc3.i(hint, "hint");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(hint);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(1.0f), 0, hint.length(), 33);
        EditText editText = this.mEditTextSearch;
        if (editText == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        }
        editText.setHint(spannableStringBuilder);
    }

    public final void setSearchQuery(String query) {
        AbstractC13042fc3.i(query, "query");
        EditText editText = this.mEditTextSearch;
        if (editText == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        }
        editText.setText(query);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0) {
            InterfaceC4228Ef6 interfaceC4228Ef6 = this.searchCallback;
            if (interfaceC4228Ef6 != null) {
                interfaceC4228Ef6.c();
            }
        } else {
            InterfaceC4228Ef6 interfaceC4228Ef62 = this.searchCallback;
            if (interfaceC4228Ef62 != null) {
                interfaceC4228Ef62.b();
            }
        }
        super.setVisibility(visibility);
    }

    public final void t() {
        EditText editText = this.mEditTextSearch;
        if (editText == null) {
            AbstractC13042fc3.y("mEditTextSearch");
            editText = null;
        }
        editText.requestFocus();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        m();
    }
}
