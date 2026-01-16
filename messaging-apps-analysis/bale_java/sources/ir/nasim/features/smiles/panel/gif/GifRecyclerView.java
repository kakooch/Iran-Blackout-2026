package ir.nasim.features.smiles.panel.gif;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.SA2;
import ir.nasim.features.smiles.panel.gif.GifRecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lir/nasim/features/smiles/panel/gif/GifRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lkotlin/Function0;", "B1", "Lir/nasim/SA2;", "getShowPreviewStateProvider", "()Lir/nasim/SA2;", "setShowPreviewStateProvider", "(Lir/nasim/SA2;)V", "showPreviewStateProvider", "Lir/nasim/features/smiles/panel/gif/GifPreviewView;", "C1", "getShowPreviewViewProvider", "setShowPreviewViewProvider", "showPreviewViewProvider", "", "D1", "Ljava/lang/Float;", "initialY", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class GifRecyclerView extends RecyclerView {

    /* renamed from: B1, reason: from kotlin metadata */
    private SA2 showPreviewStateProvider;

    /* renamed from: C1, reason: from kotlin metadata */
    private SA2 showPreviewViewProvider;

    /* renamed from: D1, reason: from kotlin metadata */
    private Float initialY;

    static final class a implements SA2 {
        public static final a a = new a();

        a() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.showPreviewStateProvider = new SA2() { // from class: ir.nasim.WH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(GifRecyclerView.X0());
            }
        };
        this.showPreviewViewProvider = a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X0() {
        return false;
    }

    public final SA2 getShowPreviewStateProvider() {
        return this.showPreviewStateProvider;
    }

    public final SA2 getShowPreviewViewProvider() {
        return this.showPreviewViewProvider;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (!((Boolean) this.showPreviewStateProvider.invoke()).booleanValue()) {
            return super.onInterceptTouchEvent(e);
        }
        Integer numValueOf = e != null ? Integer.valueOf(e.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            if (this.initialY == null) {
                this.initialY = Float.valueOf(e.getRawY());
            }
            GifPreviewView gifPreviewView = (GifPreviewView) this.showPreviewViewProvider.invoke();
            if (gifPreviewView != null) {
                gifPreviewView.k(e, this.initialY);
            }
            return false;
        }
        if (numValueOf == null || numValueOf.intValue() != 1) {
            return super.onInterceptTouchEvent(e);
        }
        this.initialY = null;
        GifPreviewView gifPreviewView2 = (GifPreviewView) this.showPreviewViewProvider.invoke();
        if (gifPreviewView2 != null) {
            gifPreviewView2.k(e, this.initialY);
        }
        return false;
    }

    public final void setShowPreviewStateProvider(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "<set-?>");
        this.showPreviewStateProvider = sa2;
    }

    public final void setShowPreviewViewProvider(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "<set-?>");
        this.showPreviewViewProvider = sa2;
    }
}
