package ir.nasim.designsystem.adapters;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C22078ud6;
import ir.nasim.ED1;
import ir.nasim.KB5;
import ir.nasim.designsystem.adapters.BottomSheetListView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010$\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00101R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00101¨\u00066"}, d2 = {"Lir/nasim/designsystem/adapters/BottomSheetListView;", "Lir/nasim/designsystem/adapters/RecyclerListView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "gravity", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "getCount", "()I", "w", "h", "oldw", "oldh", "Lir/nasim/rB7;", "onSizeChanged", "(IIII)V", "g", "()V", "minHeight", "setMinHeight", "(I)V", "", "xPoint", "yPoint", "", "f", "(FF)Z", "Landroid/view/View;", "underlyingView", "setUnderlyingView", "(Landroid/view/View;)V", "Landroid/widget/AdapterView$OnItemClickListener;", "listener", "setOnItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "Landroid/widget/AdapterView$OnItemLongClickListener;", "setOnItemLongClickListener", "(Landroid/widget/AdapterView$OnItemLongClickListener;)V", "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "header", "b", "Landroid/view/View;", "c", TokenNames.I, "d", "maxHeaderY", "e", "minHeaderY", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public class BottomSheetListView extends RecyclerListView {

    /* renamed from: a, reason: from kotlin metadata */
    private FrameLayout header;

    /* renamed from: b, reason: from kotlin metadata */
    private View underlyingView;

    /* renamed from: c, reason: from kotlin metadata */
    private int minHeight;

    /* renamed from: d, reason: from kotlin metadata */
    private int maxHeaderY;

    /* renamed from: e, reason: from kotlin metadata */
    private int minHeaderY;

    /* renamed from: f, reason: from kotlin metadata */
    private int gravity;

    public static final class a implements View.OnTouchListener {
        private boolean a;

        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(motionEvent, "motionEvent");
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    z = true;
                }
                if (this.a || BottomSheetListView.this.underlyingView == null) {
                    return false;
                }
                this.a = !z;
                View view2 = BottomSheetListView.this.underlyingView;
                if (view2 != null) {
                    view2.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            this.a = BottomSheetListView.this.f(motionEvent.getRawX(), motionEvent.getRawY());
            z = false;
            if (this.a) {
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetListView(Context context) {
        this(context, null, 0, 0, 14, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AdapterView.OnItemClickListener onItemClickListener, BottomSheetListView bottomSheetListView, AdapterView adapterView, View view, int i, long j) {
        AbstractC13042fc3.i(bottomSheetListView, "this$0");
        if (onItemClickListener != null) {
            if (bottomSheetListView.gravity != 48) {
                i--;
            }
            onItemClickListener.onItemClick(adapterView, view, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(AdapterView.OnItemLongClickListener onItemLongClickListener, BottomSheetListView bottomSheetListView, AdapterView adapterView, View view, int i, long j) {
        AbstractC13042fc3.i(onItemLongClickListener, "$listener");
        AbstractC13042fc3.i(bottomSheetListView, "this$0");
        if (bottomSheetListView.gravity != 48) {
            i--;
        }
        return onItemLongClickListener.onItemLongClick(adapterView, view, i, j);
    }

    public final boolean f(float xPoint, float yPoint) {
        int[] iArr = new int[2];
        this.header.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = this.header.getWidth();
        int height = this.header.getHeight();
        if (i2 > this.maxHeaderY) {
            this.maxHeaderY = i2;
        }
        if (i2 < this.minHeaderY) {
            this.minHeaderY = i2;
        }
        if (xPoint < i || xPoint > i + width || yPoint < i2 || yPoint > height + i2) {
            return false;
        }
        if (i2 != 0 || (-this.header.getY()) <= this.maxHeaderY) {
            return i2 != 0 || this.header.getY() <= ((float) (this.minHeaderY * 2));
        }
        return false;
    }

    protected final void g() {
        setVisibility(this.minHeight == 0 ? 8 : 0);
        if (this.header.getLayoutParams().height != getHeight() - this.minHeight) {
            this.header.getLayoutParams().height = getHeight() - this.minHeight;
            this.header.requestLayout();
            if (this.gravity != 80) {
                setSelection(getCount());
            }
        }
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        return super.getCount() - 1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        g();
    }

    public final void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        g();
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(final AdapterView.OnItemClickListener listener) {
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.fk0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                BottomSheetListView.h(listener, this, adapterView, view, i, j);
            }
        });
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(final AdapterView.OnItemLongClickListener listener) {
        AbstractC13042fc3.i(listener, "listener");
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: ir.nasim.ek0
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return BottomSheetListView.i(listener, this, adapterView, view, i, j);
            }
        });
    }

    public final void setUnderlyingView(View underlyingView) {
        this.underlyingView = underlyingView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetListView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ BottomSheetListView(Context context, AttributeSet attributeSet, int i, int i2, int i3, ED1 ed1) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 80 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.minHeaderY = getResources().getDisplayMetrics().heightPixels;
        this.gravity = i2;
        setSelector(new ColorDrawable(0));
        setOverScrollMode(2);
        setVerticalScrollBarEnabled(false);
        FrameLayout frameLayout = new FrameLayout(context);
        this.header = frameLayout;
        frameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(KB5.conv_field_shadow);
        this.header.addView(imageView, new FrameLayout.LayoutParams(-1, C22078ud6.a(2.0f), 80));
        if (i2 == 80) {
            addHeaderView(this.header);
        } else {
            addFooterView(this.header);
        }
        setOnTouchListener(new a());
    }
}
