package ir.nasim.features.media.Actionbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC14525i33;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C22078ud6;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.JF5;
import ir.nasim.KB5;
import ir.nasim.features.media.Actionbar.ActionBarMenuItem;
import ir.nasim.features.media.components.ActionBarPopupWindow;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes6.dex */
public class ActionBarMenuItemImp extends ActionBarMenuItem {
    private ActionBarPopupWindow.ActionBarPopupWindowLayout c;
    private ActionBarMenu d;
    private ActionBarPopupWindow e;
    private EditText f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ProgressBar j;
    private FrameLayout k;
    private RelativeLayout l;
    private ActionBarMenuItem.a m;
    private Rect n;
    private int[] o;
    private View p;
    private Runnable q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Timer v;

    class a implements TextWatcher {

        /* renamed from: ir.nasim.features.media.Actionbar.ActionBarMenuItemImp$a$a, reason: collision with other inner class name */
        class C1176a extends TimerTask {
            C1176a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                ActionBarMenuItemImp.this.m.c(ActionBarMenuItemImp.this.f);
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (ActionBarMenuItemImp.this.m != null) {
                    AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.features.media.Actionbar.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.b();
                        }
                    });
                }
            }
        }

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ActionBarMenuItemImp.this.v = new Timer();
            ActionBarMenuItemImp.this.v.schedule(new C1176a(), 1000L);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (ActionBarMenuItemImp.this.v != null) {
                ActionBarMenuItemImp.this.v.cancel();
            }
            if (ActionBarMenuItemImp.this.g != null) {
                C5495Jo7 c5495Jo7 = C5495Jo7.a;
                int iE = c5495Jo7.e();
                if (charSequence == null || charSequence.length() == 0) {
                    iE = c5495Jo7.f();
                }
                AbstractC14525i33.c(ActionBarMenuItemImp.this.g, ColorStateList.valueOf(iE));
            }
        }
    }

    public ActionBarMenuItemImp(Context context) {
        super(context);
        this.r = 0;
        this.s = true;
        this.u = false;
    }

    private void B() {
        ImageView imageView = new ImageView(getContext());
        this.h = imageView;
        imageView.setId(7);
        this.h.setImageResource(KB5.ba_appbar_close_1);
        this.h.setScaleType(ImageView.ScaleType.CENTER);
        AbstractC14525i33.c(this.h, ColorStateList.valueOf(C5495Jo7.a.e()));
        this.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.o5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.G(view);
            }
        });
        this.l.addView(this.h);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.width = C22078ud6.a(48.0f);
        layoutParams.height = -1;
        layoutParams.addRule(11);
        this.h.setLayoutParams(layoutParams);
        this.h.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean D(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.e) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.n);
        if (this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.e.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.e) != null && actionBarPopupWindow.isShowing()) {
            this.e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.e;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            if (this.t) {
                return;
            }
            this.t = true;
            this.e.dismiss(this.s);
        }
        ActionBarMenu actionBarMenu = this.d;
        if (actionBarMenu != null) {
            actionBarMenu.h(((Integer) view.getTag()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        this.f.setText("");
        this.f.requestFocus();
        C23381wp3.f(this.f);
        ActionBarMenuItem.a aVar = this.m;
        if (aVar != null) {
            aVar.b(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean I(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        C23381wp3.f(this.f);
        ActionBarMenuItem.a aVar = this.m;
        if (aVar == null) {
            return false;
        }
        aVar.b(this.f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        C23381wp3.g(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z) {
        if (!z) {
            C23381wp3.f(this.f);
        } else {
            C23381wp3.g(this.f);
            AbstractC7426Rr.Q(new Runnable() { // from class: ir.nasim.f5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.J();
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        C23381wp3.f(this.f);
        ActionBarMenuItem.a aVar = this.m;
        if (aVar != null) {
            aVar.b(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        this.d.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean N(View view, int i, KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (i != 82 || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1 || (actionBarPopupWindow = this.e) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        this.e.dismiss();
        return true;
    }

    private void O(boolean z, boolean z2) {
        ActionBarMenu actionBarMenu = this.d;
        int top = (actionBarMenu == null || this.r != 0) ? -getMeasuredHeight() : (-actionBarMenu.a.getMeasuredHeight()) + this.d.getTop();
        if (z) {
            this.c.scrollToTop();
        }
        if (this.r != 0) {
            if (z) {
                this.e.showAsDropDown(this, -C22078ud6.a(8.0f), top);
            }
            if (z2) {
                this.e.update(this, -C22078ud6.a(8.0f), top, -1, -1);
                return;
            }
            return;
        }
        ActionBarMenu actionBarMenu2 = this.d;
        if (actionBarMenu2 != null) {
            ActionBar actionBar = actionBarMenu2.a;
            if (z) {
                this.e.showAsDropDown(actionBar, ((getLeft() + this.d.getLeft()) + getMeasuredWidth()) - this.c.getMeasuredWidth(), top);
            }
            if (z2) {
                this.e.update(actionBar, ((getLeft() + this.d.getLeft()) + getMeasuredWidth()) - this.c.getMeasuredWidth(), top, -1, -1);
                return;
            }
            return;
        }
        if (getParent() != null) {
            View view = (View) getParent();
            if (z) {
                this.e.showAsDropDown(view, ((view.getMeasuredWidth() - this.c.getMeasuredWidth()) - getLeft()) - view.getLeft(), top);
            }
            if (z2) {
                this.e.update(view, ((view.getMeasuredWidth() - this.c.getMeasuredWidth()) - getLeft()) - view.getLeft(), top, -1, -1);
            }
        }
    }

    public boolean C() {
        return this.u;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public TextView a(int i, String str, int i2) {
        if (this.c == null) {
            this.n = new Rect();
            this.o = new int[2];
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext());
            this.c = actionBarPopupWindowLayout;
            actionBarPopupWindowLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.h5
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.a.D(view, motionEvent);
                }
            });
            this.c.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: ir.nasim.i5
                @Override // ir.nasim.features.media.components.ActionBarPopupWindow.OnDispatchKeyEventListener
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.a.E(keyEvent);
                }
            });
        }
        View viewFindViewWithTag = this.c.findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag instanceof TextView) {
            return (TextView) viewFindViewWithTag;
        }
        TextView textView = new TextView(getContext());
        textView.setTextColor(C5495Jo7.a.d2());
        textView.setTypeface(C6011Lu2.k());
        if (JF5.g()) {
            textView.setGravity(21);
        } else {
            textView.setGravity(16);
        }
        textView.setPadding(C22078ud6.a(16.0f), 0, C22078ud6.a(16.0f), 0);
        textView.setTextSize(2, 15.0f);
        textView.setMinWidth(C22078ud6.a(196.0f));
        textView.setTag(Integer.valueOf(i));
        textView.setText(str);
        if (i2 != 0) {
            if (JF5.g()) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(i2), (Drawable) null);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.c.setShowedFromBotton(false);
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout2 = this.c;
        actionBarPopupWindowLayout2.showBackgroundDrawable = true;
        actionBarPopupWindowLayout2.addView(textView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (JF5.g()) {
            layoutParams.gravity = 5;
        }
        layoutParams.width = -1;
        layoutParams.height = C22078ud6.a(48.0f);
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.j5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.F(view);
            }
        });
        return textView;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public void b() {
        ActionBarPopupWindow actionBarPopupWindow = this.e;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.e.dismiss();
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public boolean c() {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.c;
        return (actionBarPopupWindowLayout == null || actionBarPopupWindowLayout.getItemsCount() == 0) ? false : true;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public void d(int i) {
        View viewFindViewWithTag;
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.c;
        if (actionBarPopupWindowLayout == null || (viewFindViewWithTag = actionBarPopupWindowLayout.findViewWithTag(Integer.valueOf(i))) == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(8);
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public boolean e() {
        return this.b;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public void f(boolean z) {
        ActionBarMenu actionBarMenu;
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0 || (actionBarMenu = this.d) == null) {
            return;
        }
        actionBarMenu.a.h(j(z));
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public ActionBarMenuItem g(ActionBarMenuItem.a aVar) {
        this.m = aVar;
        return this;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public EditText getSearchField() {
        return this.f;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public ActionBarMenuItem h(boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (this.d == null) {
            return this;
        }
        if (z && this.l == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.l = relativeLayout;
            this.d.addView(relativeLayout, 0);
            RelativeLayout relativeLayout2 = this.l;
            int iZ = AbstractC7426Rr.z(3.0f);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            relativeLayout2.setBackgroundDrawable(AbstractC4310Eo7.d(iZ, c5495Jo7.c()));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            int iA = C22078ud6.a(8.0f);
            layoutParams.leftMargin = iA;
            layoutParams.topMargin = iA;
            layoutParams.rightMargin = iA;
            layoutParams.bottomMargin = iA;
            this.l.setLayoutParams(layoutParams);
            this.l.setVisibility(8);
            String string = getContext().getString(AbstractC12217eE5.search_hint_dialogs);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.7f), 0, string.length(), 33);
            EditText editText = new EditText(getContext());
            this.f = editText;
            editText.setTextSize(2, 15.0f);
            this.f.setHintTextColor(c5495Jo7.d());
            this.f.setHint(spannableStringBuilder);
            this.f.setTextColor(c5495Jo7.g());
            this.f.setEllipsize(TextUtils.TruncateAt.END);
            this.f.setSingleLine();
            this.f.setTypeface(C6011Lu2.k());
            this.f.setBackgroundResource(0);
            this.f.setBackgroundColor(c5495Jo7.c());
            this.f.setInputType(1);
            this.f.setGravity(16);
            this.f.setPadding(0, 0, 0, 0);
            this.f.setImeOptions(33554435);
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.f, Integer.valueOf(KB5.search_carret));
            } catch (Exception unused) {
            }
            this.f.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.k5
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return this.a.I(textView, i, keyEvent);
                }
            });
            this.f.addTextChangedListener(new a());
            this.f.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.l5
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    this.a.K(view, z2);
                }
            });
            this.l.addView(this.f);
            ImageView imageView = new ImageView(getContext());
            this.g = imageView;
            imageView.setId(6);
            this.g.setImageResource(KB5.search_grey_vd);
            ImageView imageView2 = this.g;
            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
            imageView2.setScaleType(scaleType);
            ImageView imageView3 = this.g;
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            imageView3.setBackgroundColor(c5495Jo72.c());
            AbstractC14525i33.c(this.g, ColorStateList.valueOf(c5495Jo72.e()));
            this.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.m5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.L(view);
                }
            });
            this.l.addView(this.g);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams2.width = C22078ud6.a(48.0f);
            layoutParams2.height = -1;
            layoutParams2.addRule(11);
            this.g.setLayoutParams(layoutParams2);
            B();
            ImageView imageView4 = new ImageView(getContext());
            this.i = imageView4;
            imageView4.setId(5);
            this.i.setImageResource(KB5.back_grey_vd);
            this.i.setScaleType(scaleType);
            this.i.setBackgroundColor(c5495Jo72.c());
            AbstractC14525i33.c(this.i, ColorStateList.valueOf(c5495Jo72.e()));
            this.i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.n5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.M(view);
                }
            });
            this.l.addView(this.i);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams3.width = C22078ud6.a(48.0f);
            layoutParams3.height = -1;
            layoutParams3.addRule(9);
            this.i.setLayoutParams(layoutParams3);
            ProgressBar progressBar = new ProgressBar(getContext());
            this.j = progressBar;
            progressBar.setId(7);
            this.j.setIndeterminate(true);
            this.l.addView(this.j);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams4.width = C22078ud6.a(21.0f);
            layoutParams4.height = C22078ud6.a(21.0f);
            layoutParams4.rightMargin = C22078ud6.a(8.0f);
            layoutParams4.addRule(1, this.i.getId());
            layoutParams4.addRule(15);
            this.j.setLayoutParams(layoutParams4);
            this.j.setVisibility(8);
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.k = frameLayout;
            frameLayout.setBackgroundResource(KB5.circle_progress_vd);
            this.l.addView(this.k);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams5.width = C22078ud6.a(18.0f);
            layoutParams5.height = C22078ud6.a(18.0f);
            layoutParams5.rightMargin = C22078ud6.a(8.0f);
            layoutParams5.addRule(1, this.i.getId());
            layoutParams5.addRule(15);
            this.k.setLayoutParams(layoutParams5);
            this.k.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams6.width = -1;
            layoutParams6.height = -1;
            layoutParams6.addRule(0, this.g.getId());
            layoutParams6.addRule(1, this.j.getId());
            this.f.setLayoutParams(layoutParams6);
        }
        this.b = z;
        return this;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public void i(int i) {
        View viewFindViewWithTag;
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.c;
        if (actionBarPopupWindowLayout == null || (viewFindViewWithTag = actionBarPopupWindowLayout.findViewWithTag(Integer.valueOf(i))) == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(0);
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public boolean j(boolean z) {
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout == null) {
            return false;
        }
        if (relativeLayout.getVisibility() != 0) {
            this.l.setVisibility(0);
            setVisibility(8);
            this.f.setText("");
            this.f.requestFocus();
            if (!z) {
                return true;
            }
            C23381wp3.g(this.f);
            return true;
        }
        ActionBarMenuItem.a aVar = this.m;
        if (aVar == null || (aVar != null && aVar.a())) {
            this.l.setVisibility(8);
            this.f.clearFocus();
            setVisibility(0);
            C23381wp3.f(this.f);
        }
        return false;
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public void k() {
        if (this.c == null) {
            return;
        }
        Runnable runnable = this.q;
        if (runnable != null) {
            AbstractC7426Rr.w(runnable);
            this.q = null;
        }
        ActionBarPopupWindow actionBarPopupWindow = this.e;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.e.dismiss();
            return;
        }
        if (this.e == null) {
            ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(this.c, -2, -2);
            this.e = actionBarPopupWindow2;
            actionBarPopupWindow2.setAnimationStyle(0);
            this.e.setOutsideTouchable(true);
            this.e.setClippingEnabled(true);
            this.e.setInputMethodMode(2);
            this.e.setSoftInputMode(0);
            this.c.measure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(1000.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(1000.0f), RecyclerView.UNDEFINED_DURATION));
            this.e.getContentView().setFocusableInTouchMode(true);
            this.e.getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: ir.nasim.e5
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return this.a.N(view, i, keyEvent);
                }
            });
        }
        this.t = false;
        this.e.setFocusable(true);
        if (this.c.getMeasuredWidth() == 0) {
            O(true, true);
        } else {
            O(true, false);
        }
        this.e.startAnimation();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ActionBarPopupWindow actionBarPopupWindow = this.e;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        O(false, true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        ActionBarPopupWindow actionBarPopupWindow2;
        if (motionEvent.getActionMasked() == 0) {
            if (c() && ((actionBarPopupWindow2 = this.e) == null || (actionBarPopupWindow2 != null && !actionBarPopupWindow2.isShowing()))) {
                Runnable runnable = new Runnable() { // from class: ir.nasim.g5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.H();
                    }
                };
                this.q = runnable;
                AbstractC7426Rr.Q(runnable, 200L);
            }
        } else if (motionEvent.getActionMasked() != 2) {
            ActionBarPopupWindow actionBarPopupWindow3 = this.e;
            if (actionBarPopupWindow3 != null && actionBarPopupWindow3.isShowing() && motionEvent.getActionMasked() == 1) {
                View view = this.p;
                if (view != null) {
                    view.setSelected(false);
                    ActionBarMenu actionBarMenu = this.d;
                    if (actionBarMenu != null) {
                        actionBarMenu.h(((Integer) this.p.getTag()).intValue());
                    }
                    this.e.dismiss(this.s);
                } else {
                    this.e.dismiss();
                }
            } else {
                View view2 = this.p;
                if (view2 != null) {
                    view2.setSelected(false);
                    this.p = null;
                }
            }
        } else if (!c() || ((actionBarPopupWindow = this.e) != null && (actionBarPopupWindow == null || actionBarPopupWindow.isShowing()))) {
            ActionBarPopupWindow actionBarPopupWindow4 = this.e;
            if (actionBarPopupWindow4 != null && actionBarPopupWindow4.isShowing()) {
                getLocationOnScreen(this.o);
                float x = motionEvent.getX() + this.o[0];
                float y = motionEvent.getY();
                float f = y + r5[1];
                this.c.getLocationOnScreen(this.o);
                int[] iArr = this.o;
                float f2 = x - iArr[0];
                float f3 = f - iArr[1];
                this.p = null;
                for (int i = 0; i < this.c.getItemsCount(); i++) {
                    View itemAt = this.c.getItemAt(i);
                    itemAt.getHitRect(this.n);
                    if (((Integer) itemAt.getTag()).intValue() < 100) {
                        if (this.n.contains((int) f2, (int) f3)) {
                            itemAt.setPressed(true);
                            itemAt.setSelected(true);
                            itemAt.drawableHotspotChanged(f2, f3 - itemAt.getTop());
                            this.p = itemAt;
                        } else {
                            itemAt.setPressed(false);
                            itemAt.setSelected(false);
                        }
                    }
                }
            }
        } else if (motionEvent.getY() > getHeight()) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            k();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem
    public void setIcon(int i) {
        this.a.setImageResource(i);
    }

    public ActionBarMenuItemImp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 0;
        this.s = true;
        this.u = false;
    }

    public ActionBarMenuItemImp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = 0;
        this.s = true;
        this.u = false;
    }

    public ActionBarMenuItemImp(Context context, ActionBarMenu actionBarMenu, int i) {
        super(context);
        this.r = 0;
        this.s = true;
        this.u = false;
        if (i != 0) {
            setBackgroundDrawable(AbstractC4310Eo7.b(i));
        }
        this.d = actionBarMenu;
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.a);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.a.setLayoutParams(layoutParams);
    }
}
