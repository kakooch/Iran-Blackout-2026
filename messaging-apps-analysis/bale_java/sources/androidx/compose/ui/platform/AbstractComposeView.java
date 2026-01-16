package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC7050Qb1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.Ga8;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC23714xO4;
import ir.nasim.InterfaceC6806Pb1;
import ir.nasim.SA2;
import ir.nasim.SJ5;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH'¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\fJ\r\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001e\u0010\fJ\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0004¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0010¢\u0006\u0004\b#\u0010\"J7\u0010*\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0004¢\u0006\u0004\b*\u0010+J7\u0010,\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0010¢\u0006\u0004\b,\u0010+J\u0017\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020$H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\n2\u0006\u00100\u001a\u00020$H\u0016¢\u0006\u0004\b2\u00103J\u0019\u00106\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J!\u00106\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u00109J)\u00106\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010<J#\u00106\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\b\u0010>\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\b6\u0010?J+\u00106\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00108\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\b6\u0010@J+\u0010A\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00108\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010=H\u0014¢\u0006\u0004\bA\u0010BJ3\u0010A\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00108\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010C\u001a\u00020$H\u0014¢\u0006\u0004\bA\u0010DJ\u000f\u0010E\u001a\u00020$H\u0016¢\u0006\u0004\bE\u00101R\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR(\u0010P\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010J8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR(\u0010W\u001a\u0004\u0018\u00010\r2\b\u0010K\u001a\u0004\u0018\u00010\r8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001a\u0010U\"\u0004\bV\u0010\u0015R$\u0010[\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000e\u0010Y\u0012\u0004\bZ\u0010\fR0\u0010`\u001a\u00020$2\u0006\u0010K\u001a\u00020$8F@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\\\u0012\u0004\b_\u0010\f\u001a\u0004\b]\u00101\"\u0004\b^\u00103R\u0016\u0010a\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\\R\u0016\u0010b\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\\R\u0018\u0010e\u001a\u00020$*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0014\u0010g\u001a\u00020$8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bf\u00101R\u0011\u0010i\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bh\u00101¨\u0006j"}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "f", "()V", "Lir/nasim/Qb1;", "e", "(Lir/nasim/Qb1;)Lir/nasim/Qb1;", "m", "()Lir/nasim/Qb1;", "i", "parent", "setParentCompositionContext", "(Lir/nasim/Qb1;)V", "Landroidx/compose/ui/platform/v;", "strategy", "setViewCompositionStrategy", "(Landroidx/compose/ui/platform/v;)V", "d", "(Lir/nasim/ub1;I)V", "g", "h", "onAttachedToWindow", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "k", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "j", "layoutDirection", "onRtlPropertiesChanged", "(I)V", "isTransitionGroup", "()Z", "setTransitionGroup", "(Z)V", "Landroid/view/View;", "child", "addView", "(Landroid/view/View;)V", "index", "(Landroid/view/View;I)V", "width", "height", "(Landroid/view/View;II)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "addViewInLayout", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)Z", "preventRequestLayout", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z", "shouldDelayChildPressedState", "Ljava/lang/ref/WeakReference;", "a", "Ljava/lang/ref/WeakReference;", "cachedViewTreeCompositionContext", "Landroid/os/IBinder;", "value", "b", "Landroid/os/IBinder;", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "previousAttachedWindowToken", "Lir/nasim/Pb1;", "c", "Lir/nasim/Pb1;", "composition", "Lir/nasim/Qb1;", "setParentContext", "parentContext", "Lkotlin/Function0;", "Lir/nasim/SA2;", "getDisposeViewCompositionStrategy$annotations", "disposeViewCompositionStrategy", "Z", "getShowLayoutBounds", "setShowLayoutBounds", "getShowLayoutBounds$annotations", "showLayoutBounds", "creatingComposition", "isTransitionGroupSet", "l", "(Lir/nasim/Qb1;)Z", "isAlive", "getShouldCreateCompositionOnAttachedToWindow", "shouldCreateCompositionOnAttachedToWindow", "getHasComposition", "hasComposition", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public abstract class AbstractComposeView extends ViewGroup {

    /* renamed from: a, reason: from kotlin metadata */
    private WeakReference cachedViewTreeCompositionContext;

    /* renamed from: b, reason: from kotlin metadata */
    private IBinder previousAttachedWindowToken;

    /* renamed from: c, reason: from kotlin metadata */
    private InterfaceC6806Pb1 composition;

    /* renamed from: d, reason: from kotlin metadata */
    private AbstractC7050Qb1 parentContext;

    /* renamed from: e, reason: from kotlin metadata */
    private SA2 disposeViewCompositionStrategy;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean showLayoutBounds;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean creatingComposition;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isTransitionGroupSet;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        a() {
            super(2);
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-656146368, i, -1, "androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous> (ComposeView.android.kt:249)");
            }
            AbstractComposeView.this.d(interfaceC22053ub1, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public AbstractComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final AbstractC7050Qb1 e(AbstractC7050Qb1 abstractC7050Qb1) {
        AbstractC7050Qb1 abstractC7050Qb12 = l(abstractC7050Qb1) ? abstractC7050Qb1 : null;
        if (abstractC7050Qb12 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference(abstractC7050Qb12);
        }
        return abstractC7050Qb1;
    }

    private final void f() {
        if (this.creatingComposition) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    private final void i() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = A.c(this, m(), AbstractC19242q11.c(-656146368, true, new a()));
            } finally {
                this.creatingComposition = false;
            }
        }
    }

    private final boolean l(AbstractC7050Qb1 abstractC7050Qb1) {
        return !(abstractC7050Qb1 instanceof SJ5) || ((SJ5.d) ((SJ5) abstractC7050Qb1).d0().getValue()).compareTo(SJ5.d.b) > 0;
    }

    private final AbstractC7050Qb1 m() {
        AbstractC7050Qb1 abstractC7050Qb1;
        AbstractC7050Qb1 abstractC7050Qb12 = this.parentContext;
        if (abstractC7050Qb12 != null) {
            return abstractC7050Qb12;
        }
        AbstractC7050Qb1 abstractC7050Qb1D = Ga8.d(this);
        AbstractC7050Qb1 abstractC7050Qb13 = null;
        AbstractC7050Qb1 abstractC7050Qb1E = abstractC7050Qb1D != null ? e(abstractC7050Qb1D) : null;
        if (abstractC7050Qb1E != null) {
            return abstractC7050Qb1E;
        }
        WeakReference weakReference = this.cachedViewTreeCompositionContext;
        if (weakReference != null && (abstractC7050Qb1 = (AbstractC7050Qb1) weakReference.get()) != null && l(abstractC7050Qb1)) {
            abstractC7050Qb13 = abstractC7050Qb1;
        }
        AbstractC7050Qb1 abstractC7050Qb14 = abstractC7050Qb13;
        return abstractC7050Qb14 == null ? e(Ga8.h(this)) : abstractC7050Qb14;
    }

    private final void setParentContext(AbstractC7050Qb1 abstractC7050Qb1) {
        if (this.parentContext != abstractC7050Qb1) {
            this.parentContext = abstractC7050Qb1;
            if (abstractC7050Qb1 != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            InterfaceC6806Pb1 interfaceC6806Pb1 = this.composition;
            if (interfaceC6806Pb1 != null) {
                interfaceC6806Pb1.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    i();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        f();
        super.addView(child);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        f();
        return super.addViewInLayout(child, index, params);
    }

    public abstract void d(InterfaceC22053ub1 interfaceC22053ub1, int i);

    public final void g() {
        if (this.parentContext == null && !isAttachedToWindow()) {
            throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
        }
        i();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public final void h() {
        InterfaceC6806Pb1 interfaceC6806Pb1 = this.composition;
        if (interfaceC6806Pb1 != null) {
            interfaceC6806Pb1.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    public void j(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
        }
    }

    public void k(int widthMeasureSpec, int heightMeasureSpec) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(widthMeasureSpec)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(heightMeasureSpec)));
        setMeasuredDimension(childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            i();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        j(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        i();
        k(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        childAt.setLayoutDirection(layoutDirection);
    }

    public final void setParentCompositionContext(AbstractC7050Qb1 parent) {
        setParentContext(parent);
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((InterfaceC23714xO4) childAt).setShowLayoutBounds(z);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean isTransitionGroup) {
        super.setTransitionGroup(isTransitionGroup);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(v strategy) {
        SA2 sa2 = this.disposeViewCompositionStrategy;
        if (sa2 != null) {
            sa2.invoke();
        }
        this.disposeViewCompositionStrategy = strategy.a(this);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        f();
        super.addView(child, index);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        f();
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        this.disposeViewCompositionStrategy = v.a.a().a(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        f();
        super.addView(child, width, height);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        f();
        super.addView(child, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        f();
        super.addView(child, index, params);
    }
}
