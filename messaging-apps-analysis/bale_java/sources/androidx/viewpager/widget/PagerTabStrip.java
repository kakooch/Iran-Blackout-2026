package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import ir.nasim.AbstractC4043Dl1;

/* loaded from: classes2.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private boolean A;
    private int B;
    private boolean D;
    private float G;
    private float H;
    private int J;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private final Paint w;
    private final Rect x;
    private int y;
    private boolean z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            PagerTabStrip.this.a.setCurrentItem(r2.getCurrentItem() - 1);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            ViewPager viewPager = PagerTabStrip.this.a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void c(int i, float f, boolean z) {
        Rect rect = this.x;
        int height = getHeight();
        int left = this.c.getLeft() - this.v;
        int right = this.c.getRight() + this.v;
        int i2 = height - this.r;
        rect.set(left, i2, right, height);
        super.c(i, f, z);
        this.y = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.c.getLeft() - this.v, i2, this.c.getRight() + this.v, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.z;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.u);
    }

    public int getTabIndicatorColor() {
        return this.q;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.v;
        int right = this.c.getRight() + this.v;
        int i = height - this.r;
        this.w.setColor((this.y << 24) | (this.q & 16777215));
        float f = height;
        canvas.drawRect(left, i, right, f, this.w);
        if (this.z) {
            this.w.setColor((this.q & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.B, getWidth() - getPaddingRight(), f, this.w);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction();
        if (action != 0 && this.D) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.G = x;
            this.H = y;
            this.D = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.G) > this.J || Math.abs(y - this.H) > this.J)) {
                this.D = true;
            }
        } else if (x < this.c.getLeft() - this.v) {
            ViewPager viewPager = this.a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x > this.c.getRight() + this.v) {
            ViewPager viewPager2 = this.a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.A) {
            return;
        }
        this.z = (i & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.A) {
            return;
        }
        this.z = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.A) {
            return;
        }
        this.z = i == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.z = z;
        this.A = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.s;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(int i) {
        this.q = i;
        this.w.setColor(i);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(AbstractC4043Dl1.c(getContext(), i));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        int i2 = this.t;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.w = paint;
        this.x = new Rect();
        this.y = 255;
        this.z = false;
        this.A = false;
        int i = this.n;
        this.q = i;
        paint.setColor(i);
        float f = context.getResources().getDisplayMetrics().density;
        this.r = (int) ((3.0f * f) + 0.5f);
        this.s = (int) ((6.0f * f) + 0.5f);
        this.t = (int) (64.0f * f);
        this.v = (int) ((16.0f * f) + 0.5f);
        this.B = (int) ((1.0f * f) + 0.5f);
        this.u = (int) ((f * 32.0f) + 0.5f);
        this.J = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new a());
        this.d.setFocusable(true);
        this.d.setOnClickListener(new b());
        if (getBackground() == null) {
            this.z = true;
        }
    }
}
