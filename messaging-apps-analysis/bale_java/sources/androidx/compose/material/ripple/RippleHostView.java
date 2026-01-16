package androidx.compose.material.ripple;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.material.ripple.RippleHostView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.OD6;
import ir.nasim.SA2;
import ir.nasim.ZG4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 @2\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"JN\u0010\u0016\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\r2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0,ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010.J\r\u0010/\u001a\u00020\b¢\u0006\u0004\b/\u0010\u001eJ0\u00102\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\r2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*ø\u0001\u0000¢\u0006\u0004\b0\u00101J\r\u00103\u001a\u00020\b¢\u0006\u0004\b3\u0010\u001eR\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010=R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010?\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "bounded", "Lir/nasim/rB7;", "c", "(Z)V", "pressed", "setRippleState", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "refreshDrawableState", "()V", "Landroid/graphics/drawable/Drawable;", "who", "invalidateDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Lir/nasim/Oo5$b;", "interaction", "Lir/nasim/OD6;", "size", "radius", "Lir/nasim/yX0;", "color", "", "alpha", "Lkotlin/Function0;", "onInvalidateRipple", "(Lir/nasim/Oo5$b;ZJIJFLir/nasim/SA2;)V", "e", "setRippleProperties-biQXAtU", "(JIJF)V", "setRippleProperties", "d", "Landroidx/compose/material/ripple/f;", "a", "Landroidx/compose/material/ripple/f;", "ripple", "Ljava/lang/Boolean;", "", "Ljava/lang/Long;", "lastRippleStateChangeTimeMillis", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "resetRippleRunnable", "Lir/nasim/SA2;", "f", "material-ripple_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class RippleHostView extends View {
    public static final int g = 8;
    private static final int[] h = {R.attr.state_pressed, R.attr.state_enabled};
    private static final int[] i = new int[0];

    /* renamed from: a, reason: from kotlin metadata */
    private f ripple;

    /* renamed from: b, reason: from kotlin metadata */
    private Boolean bounded;

    /* renamed from: c, reason: from kotlin metadata */
    private Long lastRippleStateChangeTimeMillis;

    /* renamed from: d, reason: from kotlin metadata */
    private Runnable resetRippleRunnable;

    /* renamed from: e, reason: from kotlin metadata */
    private SA2 onInvalidateRipple;

    public RippleHostView(Context context) {
        super(context);
    }

    private final void c(boolean bounded) {
        f fVar = new f(bounded);
        setBackground(fVar);
        this.ripple = fVar;
    }

    private final void setRippleState(boolean pressed) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l = this.lastRippleStateChangeTimeMillis;
        long jLongValue = jCurrentAnimationTimeMillis - (l != null ? l.longValue() : 0L);
        if (pressed || jLongValue >= 5) {
            int[] iArr = pressed ? h : i;
            f fVar = this.ripple;
            if (fVar != null) {
                fVar.setState(iArr);
            }
        } else {
            Runnable runnable2 = new Runnable() { // from class: ir.nasim.v26
                @Override // java.lang.Runnable
                public final void run() {
                    RippleHostView.setRippleState$lambda$2(this.a);
                }
            };
            this.resetRippleRunnable = runnable2;
            postDelayed(runnable2, 50L);
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$2(RippleHostView rippleHostView) {
        f fVar = rippleHostView.ripple;
        if (fVar != null) {
            fVar.setState(i);
        }
        rippleHostView.resetRippleRunnable = null;
    }

    public final void b(InterfaceC6693Oo5.b interaction, boolean bounded, long size, int radius, long color, float alpha, SA2 onInvalidateRipple) {
        if (this.ripple == null || !AbstractC13042fc3.d(Boolean.valueOf(bounded), this.bounded)) {
            c(bounded);
            this.bounded = Boolean.valueOf(bounded);
        }
        f fVar = this.ripple;
        AbstractC13042fc3.f(fVar);
        this.onInvalidateRipple = onInvalidateRipple;
        m0setRipplePropertiesbiQXAtU(size, radius, color, alpha);
        if (bounded) {
            fVar.setHotspot(ZG4.m(interaction.a()), ZG4.n(interaction.a()));
        } else {
            fVar.setHotspot(fVar.getBounds().centerX(), fVar.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void d() {
        this.onInvalidateRipple = null;
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            Runnable runnable2 = this.resetRippleRunnable;
            AbstractC13042fc3.f(runnable2);
            runnable2.run();
        } else {
            f fVar = this.ripple;
            if (fVar != null) {
                fVar.setState(i);
            }
        }
        f fVar2 = this.ripple;
        if (fVar2 == null) {
            return;
        }
        fVar2.setVisible(false, false);
        unscheduleDrawable(fVar2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (isAttachedToWindow()) {
            super.draw(canvas);
        } else {
            d();
        }
    }

    public final void e() {
        setRippleState(false);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        SA2 sa2 = this.onInvalidateRipple;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    /* renamed from: setRippleProperties-biQXAtU, reason: not valid java name */
    public final void m0setRipplePropertiesbiQXAtU(long size, int radius, long color, float alpha) {
        f fVar = this.ripple;
        if (fVar == null) {
            return;
        }
        fVar.c(radius);
        fVar.b(color, alpha);
        Rect rect = new Rect(0, 0, AbstractC20723sV3.d(OD6.i(size)), AbstractC20723sV3.d(OD6.g(size)));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        fVar.setBounds(rect);
    }
}
