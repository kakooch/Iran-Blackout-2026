package ir.nasim.videoplayer.ui.component;

import android.content.Context;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18154oA5;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.C19406qI3;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.L93;
import ir.nasim.O98;
import ir.nasim.videoplayer.ui.component.ScrollableCaption;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 |2\u00020\u0001:\u0003}%~B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u000fJ7\u0010&\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0014¢\u0006\u0004\b(\u0010\u000fJ\u0019\u0010+\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010)H\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J/\u00105\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H\u0014¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0013H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0013H\u0017¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\rH\u0016¢\u0006\u0004\b;\u0010\u000fJ\u0017\u0010>\u001a\u00020\r2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0015\u0010B\u001a\u00020\r2\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010R\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010MR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010MR\u0016\u0010Z\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010MR\u0016\u0010]\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010\\R\u0016\u0010c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010MR\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010MR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010MR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010u\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010MR\u0016\u0010x\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010z¨\u0006\u007f"}, d2 = {"Lir/nasim/videoplayer/ui/component/ScrollableCaption;", "Landroidx/core/widget/NestedScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/appcompat/widget/AppCompatTextView;", "j0", "()Landroidx/appcompat/widget/AppCompatTextView;", "Lir/nasim/rB7;", "o0", "()V", "m0", "Landroid/view/View;", "view", "Landroid/view/MotionEvent;", "event", "", "k0", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "n0", "offset", "l0", "(I)V", "Lir/nasim/videoplayer/ui/component/ScrollableCaption$c;", "newState", "q0", "(Lir/nasim/videoplayer/ui/component/ScrollableCaption$c;)V", "onAttachedToWindow", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "onDetachedFromWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/text/Spannable;", "caption", "i0", "(Landroid/text/Spannable;)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "computeScroll", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "Lir/nasim/videoplayer/ui/component/ScrollableCaption$b;", "listener", "setOnScrollListener", "(Lir/nasim/videoplayer/ui/component/ScrollableCaption$b;)V", "Landroid/view/VelocityTracker;", "z0", "Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/widget/OverScroller;", "A0", "Landroid/widget/OverScroller;", "overScroller", "B0", TokenNames.I, "touchSlop", "C0", "peekHeight", "D0", "currentTop", "", "E0", TokenNames.F, "lastMotionY", "F0", "minimumVelocity", "G0", "maximumVelocity", "H0", "Z", "needToBeLaidOut", "I0", "isBeingDragged", "J0", "overScrollerIsFinished", "K0", "maxOverFling", "L0", "maxOverScroll", "Landroid/graphics/Paint;", "M0", "Landroid/graphics/Paint;", "overScrollPaint", "Landroid/graphics/Rect;", "N0", "Landroid/graphics/Rect;", "overScrollRect", "O0", "activePointerId", "Landroid/widget/TextView;", "P0", "Landroid/widget/TextView;", "textView", "Q0", "textViewHorizontalPadding", "R0", "Lir/nasim/videoplayer/ui/component/ScrollableCaption$c;", "currentScrollState", "S0", "Lir/nasim/videoplayer/ui/component/ScrollableCaption$b;", "scrollListener", "T0", "c", "a", "videoplayer_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class ScrollableCaption extends NestedScrollView {
    private static final a T0 = new a(null);
    private static final int U0 = (int) ((100 * AbstractC3742Cd6.c()) + 0.5d);
    private static final int V0 = (int) ((10 * AbstractC3742Cd6.c()) + 0.5d);

    /* renamed from: A0, reason: from kotlin metadata */
    private OverScroller overScroller;

    /* renamed from: B0, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: C0, reason: from kotlin metadata */
    private int peekHeight;

    /* renamed from: D0, reason: from kotlin metadata */
    private int currentTop;

    /* renamed from: E0, reason: from kotlin metadata */
    private float lastMotionY;

    /* renamed from: F0, reason: from kotlin metadata */
    private int minimumVelocity;

    /* renamed from: G0, reason: from kotlin metadata */
    private int maximumVelocity;

    /* renamed from: H0, reason: from kotlin metadata */
    private boolean needToBeLaidOut;

    /* renamed from: I0, reason: from kotlin metadata */
    private boolean isBeingDragged;

    /* renamed from: J0, reason: from kotlin metadata */
    private boolean overScrollerIsFinished;

    /* renamed from: K0, reason: from kotlin metadata */
    private int maxOverFling;

    /* renamed from: L0, reason: from kotlin metadata */
    private int maxOverScroll;

    /* renamed from: M0, reason: from kotlin metadata */
    private final Paint overScrollPaint;

    /* renamed from: N0, reason: from kotlin metadata */
    private final Rect overScrollRect;

    /* renamed from: O0, reason: from kotlin metadata */
    private int activePointerId;

    /* renamed from: P0, reason: from kotlin metadata */
    private final TextView textView;

    /* renamed from: Q0, reason: from kotlin metadata */
    private final int textViewHorizontalPadding;

    /* renamed from: R0, reason: from kotlin metadata */
    private c currentScrollState;

    /* renamed from: S0, reason: from kotlin metadata */
    private b scrollListener;

    /* renamed from: z0, reason: from kotlin metadata */
    private VelocityTracker velocityTracker;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void a(c cVar);
    }

    public interface c {

        public static final class a implements c {
            private final int a;

            public a(int i) {
                this.a = i;
            }

            @Override // ir.nasim.videoplayer.ui.component.ScrollableCaption.c
            public int a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && this.a == ((a) obj).a;
            }

            public int hashCode() {
                return Integer.hashCode(this.a);
            }

            public String toString() {
                return "Collapsed(captionTop=" + this.a + Separators.RPAREN;
            }
        }

        public static final class b implements c {
            private final int a;

            public b(int i) {
                this.a = i;
            }

            @Override // ir.nasim.videoplayer.ui.component.ScrollableCaption.c
            public int a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.a == ((b) obj).a;
            }

            public int hashCode() {
                return Integer.hashCode(this.a);
            }

            public String toString() {
                return "Expanded(captionTop=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.videoplayer.ui.component.ScrollableCaption$c$c, reason: collision with other inner class name */
        public static final class C1721c implements c {
            private final int a;

            public C1721c(int i) {
                this.a = i;
            }

            @Override // ir.nasim.videoplayer.ui.component.ScrollableCaption.c
            public int a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1721c) && this.a == ((C1721c) obj).a;
            }

            public int hashCode() {
                return Integer.hashCode(this.a);
            }

            public String toString() {
                return "Scrolling(captionTop=" + this.a + Separators.RPAREN;
            }
        }

        int a();
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;
        final /* synthetic */ ScrollableCaption b;

        public d(View view, ScrollableCaption scrollableCaption) {
            this.a = view;
            this.b = scrollableCaption;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.b.m0();
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            ScrollableCaption.this.peekHeight = Math.min(ScrollableCaption.U0, view.getHeight());
            ViewParent parent = view.getParent();
            AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            int bottom = ((-view.getTop()) + ((ViewGroup) parent).getBottom()) - ScrollableCaption.this.peekHeight;
            if (Math.abs(bottom) > 0) {
                ScrollableCaption.this.l0(bottom);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScrollableCaption(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final AppCompatTextView j0() {
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setFocusable(true);
        appCompatTextView.setClickable(true);
        appCompatTextView.setLinksClickable(true);
        appCompatTextView.setTextColor(-1);
        appCompatTextView.setTypeface(C6011Lu2.k());
        appCompatTextView.setBackgroundColor(Color.parseColor("#991A1B1C"));
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setPadding(this.textViewHorizontalPadding, (int) ((6 * AbstractC3742Cd6.c()) + 0.5d), this.textViewHorizontalPadding, (int) ((10 * AbstractC3742Cd6.c()) + 0.5d));
        return appCompatTextView;
    }

    private final boolean k0(View view, MotionEvent event) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        return rawX >= ((float) i) && rawX <= ((float) (i + view.getWidth())) && rawY >= ((float) i2) && rawY <= ((float) (i2 + view.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(int offset) {
        TextView textView = this.textView;
        this.currentTop = textView.getTop() + offset;
        AbstractC12990fW7.a0(textView, offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        TextView textView = this.textView;
        if (!textView.isLaidOut() || textView.isLayoutRequested()) {
            textView.addOnLayoutChangeListener(new e());
            return;
        }
        this.peekHeight = Math.min(U0, textView.getHeight());
        ViewParent parent = textView.getParent();
        AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        int bottom = ((-textView.getTop()) + ((ViewGroup) parent).getBottom()) - this.peekHeight;
        if (Math.abs(bottom) > 0) {
            l0(bottom);
        }
    }

    private final void n0() {
        requestDisallowInterceptTouchEvent(false);
        this.activePointerId = -1;
        this.isBeingDragged = false;
    }

    private final void o0() {
        AbstractC12990fW7.E0(this, new InterfaceC22474vI4() { // from class: ir.nasim.Zd6
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return ScrollableCaption.p0(this.a, view, o98);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 p0(ScrollableCaption scrollableCaption, View view, O98 o98) {
        AbstractC13042fc3.i(scrollableCaption, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.i());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        TextView textView = scrollableCaption.textView;
        int i = scrollableCaption.textViewHorizontalPadding;
        textView.setPadding(l93F.a + i, textView.getPaddingTop(), i + l93F.c, textView.getPaddingBottom());
        return O98.b;
    }

    private final void q0(c newState) {
        if (AbstractC13042fc3.d(newState, this.currentScrollState)) {
            return;
        }
        this.currentScrollState = newState;
        b bVar = this.scrollListener;
        if (bVar != null) {
            bVar.a(newState);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        if (this.overScroller.isFinished() && this.overScrollerIsFinished) {
            return;
        }
        this.overScrollerIsFinished = this.overScroller.isFinished();
        if (this.overScroller.computeScrollOffset()) {
            l0(this.overScroller.getCurrY() - this.textView.getTop());
            AbstractC12990fW7.g0(this);
            q0(new c.C1721c(this.overScroller.getCurrY()));
        } else if (this.textView.getTop() + this.peekHeight + V0 < getBottom()) {
            q0(new c.b(this.textView.getTop()));
        } else {
            q0(new c.a(this.textView.getTop()));
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void draw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.draw(canvas);
        if (this.textView.getVisibility() != 0 || getBottom() - this.textView.getBottom() <= 0) {
            return;
        }
        this.overScrollRect.set(getLeft(), this.textView.getBottom(), getRight(), getBottom());
        canvas.drawRect(this.overScrollRect, this.overScrollPaint);
    }

    public final void i0(Spannable caption) {
        this.textView.setText(caption, TextView.BufferType.SPANNABLE);
        setVisibility((caption == null || AbstractC20762sZ6.n0(caption)) ^ true ? 0 : 8);
        this.needToBeLaidOut = true;
        this.textView.requestLayout();
        m0();
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.velocityTracker = VelocityTracker.obtain();
        o0();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.needToBeLaidOut = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new d(this, this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AbstractC12990fW7.E0(this, null);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ev"
            ir.nasim.AbstractC13042fc3.i(r6, r0)
            int r0 = r6.getActionMasked()
            r1 = 0
            if (r0 != 0) goto L15
            android.widget.TextView r2 = r5.textView
            boolean r2 = r5.k0(r2, r6)
            if (r2 != 0) goto L15
            return r1
        L15:
            if (r0 == 0) goto L1d
            int r2 = r5.activePointerId
            r3 = -1
            if (r2 != r3) goto L1d
            return r1
        L1d:
            r2 = 2
            r3 = 1
            if (r0 != r2) goto L26
            boolean r4 = r5.isBeingDragged
            if (r4 == 0) goto L26
            return r3
        L26:
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L4d
            if (r0 == r3) goto L4a
            if (r0 == r2) goto L32
            r6 = 3
            if (r0 == r6) goto L4a
            goto L76
        L32:
            int r0 = r5.activePointerId
            float r6 = r6.getY(r0)
            float r0 = r5.lastMotionY
            float r0 = r6 - r0
            float r0 = java.lang.Math.abs(r0)
            int r0 = (int) r0
            int r1 = r5.touchSlop
            if (r0 <= r1) goto L76
            r5.isBeingDragged = r3
            r5.lastMotionY = r6
            goto L76
        L4a:
            r5.isBeingDragged = r1
            goto L76
        L4d:
            android.widget.OverScroller r0 = r5.overScroller
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L5a
            android.widget.OverScroller r0 = r5.overScroller
            r0.abortAnimation()
        L5a:
            android.view.VelocityTracker r0 = r5.velocityTracker
            if (r0 == 0) goto L61
            r0.clear()
        L61:
            float r0 = r6.getY()
            r5.lastMotionY = r0
            android.widget.OverScroller r0 = r5.overScroller
            boolean r0 = r0.isFinished()
            r0 = r0 ^ r3
            r5.isBeingDragged = r0
            int r6 = r6.getPointerId(r1)
            r5.activePointerId = r6
        L76:
            boolean r6 = r5.isBeingDragged
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.ui.component.ScrollableCaption.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b2) {
        if (this.needToBeLaidOut) {
            this.needToBeLaidOut = false;
            C19406qI3.a("ScrollableCaption", "before onLayout(" + changed + ")(l: " + l + ", t: " + t + ", r: " + r + ", b: " + b2 + ", viewTop: " + this.textView.getTop() + ", currentTop: " + this.currentTop + Separators.RPAREN, new Object[0]);
            super.onLayout(changed, l, t, r, b2);
            C19406qI3.a("ScrollableCaption", "after onLayout(" + changed + ")(l: " + l + ", t: " + t + ", r: " + r + ", b: " + b2 + ", viewTop: " + this.textView.getTop() + ", currentTop: " + this.currentTop + Separators.RPAREN, new Object[0]);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.maxOverFling = h / 6;
        this.maxOverScroll = h / 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.ui.component.ScrollableCaption.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setOnScrollListener(b listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.scrollListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScrollableCaption(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ ScrollableCaption(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? AbstractC18154oA5.nestedScrollViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableCaption(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.currentTop = -1;
        this.needToBeLaidOut = true;
        this.overScrollerIsFinished = true;
        Paint paint = new Paint(1);
        paint.setColor(Color.parseColor("#991A1B1C"));
        paint.setStyle(Paint.Style.FILL);
        this.overScrollPaint = paint;
        this.overScrollRect = new Rect();
        this.activePointerId = -1;
        this.textViewHorizontalPadding = (int) ((16 * AbstractC3742Cd6.c()) + 0.5d);
        this.currentScrollState = new c.a(0);
        this.overScroller = new OverScroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.minimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        AppCompatTextView appCompatTextViewJ0 = j0();
        addView(appCompatTextViewJ0);
        this.textView = appCompatTextViewJ0;
    }
}
