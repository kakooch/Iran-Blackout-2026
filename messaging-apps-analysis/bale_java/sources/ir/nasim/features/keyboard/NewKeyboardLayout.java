package ir.nasim.features.keyboard;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.O98;
import ir.nasim.features.keyboard.NewKeyboardLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0002#\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0011J\u0015\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R$\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010+\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b)\u0010*R(\u0010/\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.R(\u00102\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00103R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00104R.\u0010;\u001a\u0004\u0018\u0001052\b\u0010\"\u001a\u0004\u0018\u0001058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010>\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lir/nasim/features/keyboard/NewKeyboardLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/FrameLayout$LayoutParams;", "e", "()Landroid/widget/FrameLayout$LayoutParams;", "", "keyboardHeight", "Lir/nasim/rB7;", "f", "(I)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/view/View;", "view", "", "isBotKeyboard", "c", "(Landroid/view/View;Z)V", "height", "h", "(IZ)V", "b", "Lir/nasim/O98;", "insets", "g", "(Lir/nasim/O98;)Lir/nasim/O98;", "Lir/nasim/features/keyboard/NewKeyboardLayout$b;", "value", "a", "Lir/nasim/features/keyboard/NewKeyboardLayout$b;", "getWindowInsetState", "()Lir/nasim/features/keyboard/NewKeyboardLayout$b;", "windowInsetState", TokenNames.I, "getRequestedHeight", "()I", "requestedHeight", "Landroid/view/View;", "getMainView", "()Landroid/view/View;", "mainView", "d", "getKeyboardView", "keyboardView", "Z", "Ljava/lang/Integer;", "Lir/nasim/features/keyboard/NewKeyboardLayout$a;", "Lir/nasim/features/keyboard/NewKeyboardLayout$a;", "getKeyboardLayoutListener", "()Lir/nasim/features/keyboard/NewKeyboardLayout$a;", "setKeyboardLayoutListener", "(Lir/nasim/features/keyboard/NewKeyboardLayout$a;)V", "keyboardLayoutListener", "getHasKeyboard", "()Z", "hasKeyboard", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class NewKeyboardLayout extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private b windowInsetState;

    /* renamed from: b, reason: from kotlin metadata */
    private int requestedHeight;

    /* renamed from: c, reason: from kotlin metadata */
    private View mainView;

    /* renamed from: d, reason: from kotlin metadata */
    private View keyboardView;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isBotKeyboard;

    /* renamed from: f, reason: from kotlin metadata */
    private Integer keyboardHeight;

    /* renamed from: g, reason: from kotlin metadata */
    private a keyboardLayoutListener;

    public interface a {
        void a(int i);

        void b();
    }

    public static final class b {
        private final boolean a;
        private final int b;

        public b(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public final boolean b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "WindowInsetState(isImeShow=" + this.a + ", imeHeight=" + this.b + Separators.RPAREN;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NewKeyboardLayout(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(NewKeyboardLayout newKeyboardLayout, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AbstractC13042fc3.i(newKeyboardLayout, "this$0");
        int size = View.MeasureSpec.getSize(view.getMeasuredHeight());
        View view2 = newKeyboardLayout.mainView;
        if (view2 != null) {
            int i9 = newKeyboardLayout.requestedHeight;
            if (size >= i9) {
                size = i9;
            }
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), size);
        }
    }

    private final FrameLayout.LayoutParams e() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.isBotKeyboard ? -2 : this.requestedHeight);
        layoutParams.gravity = 80;
        return layoutParams;
    }

    private final void f(int keyboardHeight) {
        if (keyboardHeight > 0) {
            this.windowInsetState = new b(true, keyboardHeight);
            a aVar = this.keyboardLayoutListener;
            if (aVar != null) {
                aVar.a(keyboardHeight);
                return;
            }
            return;
        }
        this.windowInsetState = new b(false, 0);
        a aVar2 = this.keyboardLayoutListener;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public static /* synthetic */ void i(NewKeyboardLayout newKeyboardLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        newKeyboardLayout.h(i, z);
    }

    public final void b() {
        View view = this.mainView;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
        }
        View view2 = this.keyboardView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void c(View view, boolean isBotKeyboard) {
        AbstractC13042fc3.i(view, "view");
        if (AbstractC13042fc3.d(view, this.keyboardView)) {
            return;
        }
        this.isBotKeyboard = isBotKeyboard;
        if (this.keyboardView != null) {
            removeViewAt(1);
        } else {
            view.setVisibility(8);
        }
        addView(view, 1, e());
        this.keyboardView = view;
        if (!isBotKeyboard || view == null) {
            return;
        }
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ir.nasim.gu4
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                NewKeyboardLayout.d(this.a, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    public final O98 g(O98 insets) {
        AbstractC13042fc3.i(insets, "insets");
        Integer numValueOf = Integer.valueOf(insets.f(O98.m.d()).d - insets.f(O98.m.g()).d);
        f(numValueOf.intValue());
        this.keyboardHeight = numValueOf;
        O98 o98 = O98.b;
        AbstractC13042fc3.h(o98, "CONSUMED");
        return o98;
    }

    public final boolean getHasKeyboard() {
        return this.keyboardView != null;
    }

    public final a getKeyboardLayoutListener() {
        return this.keyboardLayoutListener;
    }

    public final View getKeyboardView() {
        return this.keyboardView;
    }

    public final View getMainView() {
        return this.mainView;
    }

    public final int getRequestedHeight() {
        return this.requestedHeight;
    }

    public final b getWindowInsetState() {
        return this.windowInsetState;
    }

    public final void h(int height, boolean isBotKeyboard) {
        View view;
        this.isBotKeyboard = isBotKeyboard;
        this.requestedHeight = height;
        if (!isBotKeyboard && (view = this.mainView) != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), height);
        }
        View view2 = this.keyboardView;
        if (view2 != null) {
            view2.setLayoutParams(e());
            view2.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.mainView = getChildAt(0);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        setKeyboardLayoutListener(null);
        this.mainView = null;
        this.keyboardView = null;
        super.onDetachedFromWindow();
    }

    public final void setKeyboardLayoutListener(a aVar) {
        this.keyboardLayoutListener = aVar;
        Integer num = this.keyboardHeight;
        if (num != null) {
            f(num.intValue());
        }
    }

    public /* synthetic */ NewKeyboardLayout(Context context, AttributeSet attributeSet, int i, ED1 ed1) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewKeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.windowInsetState = new b(false, 0);
    }
}
