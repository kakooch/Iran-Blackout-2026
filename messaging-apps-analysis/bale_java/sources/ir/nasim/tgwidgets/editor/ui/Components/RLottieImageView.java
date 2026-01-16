package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.AbstractC11500d67;
import ir.nasim.AbstractC18106o57;
import ir.nasim.C24687z23;
import ir.nasim.C4278El2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class RLottieImageView extends AppCompatImageView {
    private HashMap d;
    private RLottieDrawable e;
    private ImageReceiver f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private Integer k;
    private boolean l;
    public boolean m;

    class a extends ImageReceiver {
        a() {
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver
        protected boolean X0(Drawable drawable, String str, int i, boolean z, int i2) {
            if (drawable != null) {
                RLottieImageView.this.e();
            }
            return super.X0(drawable, str, i, z, i2);
        }
    }

    class b extends Drawable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect rect = AbstractC21455b.y;
            rect.set(getBounds().centerX() - (AbstractC21455b.F(this.a) / 2), getBounds().centerY() - (AbstractC21455b.F(this.b) / 2), getBounds().centerX() + (AbstractC21455b.F(this.a) / 2), getBounds().centerY() + (AbstractC21455b.F(this.b) / 2));
            RLottieImageView.this.f.Z0(rect);
            RLottieImageView.this.f.e(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            RLottieImageView.this.f.setAlpha(i / 255.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            RLottieImageView.this.f.C0(colorFilter);
        }
    }

    public RLottieImageView(Context context) {
        super(context);
    }

    public void d() throws InterruptedException {
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable != null) {
            rLottieDrawable.stop();
        }
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.s0();
            this.f = null;
        }
        this.e = null;
        setImageDrawable(null);
    }

    protected void e() {
    }

    public void f() {
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable == null && this.f == null) {
            return;
        }
        this.i = true;
        if (!this.h) {
            this.j = true;
            return;
        }
        if (rLottieDrawable != null) {
            rLottieDrawable.start();
        }
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.u1();
        }
    }

    public void g() {
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable == null && this.f == null) {
            return;
        }
        this.i = false;
        if (!this.h) {
            this.j = false;
            return;
        }
        if (rLottieDrawable != null) {
            rLottieDrawable.stop();
        }
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.v1();
        }
    }

    public RLottieDrawable getAnimatedDrawable() {
        return this.e;
    }

    public ImageReceiver getImageReceiver() {
        return this.f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        this.h = true;
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.q0();
            if (this.i) {
                this.f.u1();
            }
        }
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable != null) {
            rLottieDrawable.setCallback(this);
            if (this.i) {
                this.e.start();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        super.onDetachedFromWindow();
        this.h = false;
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable != null) {
            rLottieDrawable.stop();
        }
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.s0();
        }
    }

    public void setAnimation(int i, int i2, int i3) {
        setAnimation(i, i2, i3, null);
    }

    public void setAnimationWithName(String str, String str2, int i, int i2) {
        setAnimation(new RLottieDrawable(str, str2, AbstractC21455b.F(i), AbstractC21455b.F(i2), true, (int[]) null));
    }

    public void setAutoRepeat(boolean z) {
        this.g = z;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.e = null;
    }

    public void setLayerColor(String str, int i) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, Integer.valueOf(i));
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable != null) {
            rLottieDrawable.n0(str, i);
        }
    }

    public void setLayerNum(Integer num) {
        this.k = num;
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.d1(num.intValue());
        }
    }

    public void setOnAnimationEndListener(Runnable runnable) {
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable != null) {
            rLottieDrawable.p0(runnable);
        }
    }

    public void setOnlyLastFrame(boolean z) {
        this.l = z;
    }

    public void setProgress(float f) {
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable != null) {
            rLottieDrawable.r0(f);
        }
    }

    public void setReverse() {
        RLottieDrawable rLottieDrawable = this.e;
        if (rLottieDrawable != null) {
            rLottieDrawable.q0(true);
            RLottieDrawable rLottieDrawable2 = this.e;
            rLottieDrawable2.g0(rLottieDrawable2.J());
            this.e.l0(0);
        }
    }

    public RLottieImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAnimation(int i, int i2, int i3, int[] iArr) {
        setAnimation(new RLottieDrawable(i, "" + i, AbstractC21455b.F(i2), AbstractC21455b.F(i3), false, iArr));
    }

    public void setAnimationWithName(String str, String str2) {
        setAnimation(new RLottieDrawable(str, str2, AbstractC21455b.F(20.0f), AbstractC21455b.F(20.0f), true, (int[]) null));
    }

    public RLottieImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAnimation(RLottieDrawable rLottieDrawable) {
        if (this.e == rLottieDrawable) {
            return;
        }
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.s0();
            this.f = null;
        }
        this.e = rLottieDrawable;
        rLottieDrawable.o0(this);
        if (this.g) {
            this.e.d0(1);
        }
        if (this.d != null) {
            this.e.w();
            for (Map.Entry entry : this.d.entrySet()) {
                this.e.n0((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
            this.e.B();
        }
        this.e.b0(true);
        setImageDrawable(this.e);
    }

    public void setAnimation(AbstractC18106o57 abstractC18106o57, int i, int i2) throws InterruptedException {
        ImageReceiver imageReceiver = this.f;
        if (imageReceiver != null) {
            imageReceiver.s0();
            this.f = null;
        }
        if (abstractC18106o57 == null) {
            return;
        }
        a aVar = new a();
        this.f = aVar;
        aVar.v0(true);
        if (this.l) {
            this.f.S0(C24687z23.b(abstractC18106o57), i + "_" + i2 + "_lastframe", null, null, null, null, null, 0L, null, abstractC18106o57, 1);
        } else if ("video/webm".equals(abstractC18106o57.i)) {
            AbstractC11500d67 abstractC11500d67Y = C4278El2.y(abstractC18106o57.k, 90);
            ImageReceiver imageReceiver2 = this.f;
            C24687z23 c24687z23B = C24687z23.b(abstractC18106o57);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("_");
            sb.append(i2);
            sb.append(this.m ? "_pcache" : "");
            sb.append("_");
            sb.append("g");
            imageReceiver2.Q0(c24687z23B, sb.toString(), C24687z23.c(abstractC11500d67Y, abstractC18106o57), null, null, abstractC18106o57.j, null, abstractC18106o57, 1);
        }
        this.f.y0(true);
        this.f.j1(this);
        if (this.g) {
            this.f.z0(1);
            this.f.x0(true);
            this.f.w0(true);
        } else {
            this.f.z0(0);
        }
        ImageReceiver imageReceiver3 = this.f;
        Integer num = this.k;
        imageReceiver3.d1(num != null ? num.intValue() : 7);
        this.f.a2 = false;
        setImageDrawable(new b(i, i2));
        if (this.h) {
            this.f.q0();
        }
    }
}
