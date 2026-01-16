package ir.nasim.features.conversation.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC19954rD5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.BC5;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.KB5;
import ir.nasim.designsystem.avatar.AvatarViewWithOnline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class BubbleContainer extends ViewGroup {
    private static final int u = C22078ud6.a(16.0f);
    private static final int v = C22078ud6.a(4.0f);
    private static final int w = C22078ud6.a(10.0f);
    private final Paint a;
    private boolean b;
    private boolean c;
    private boolean d;
    private TextView e;
    private TextView f;
    private AvatarViewWithOnline g;
    private ConstraintLayout h;
    private ImageView i;
    private TextView j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private LottieAnimationView r;
    private View s;
    private final List t;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BubbleContainer.this.r.setVisibility(8);
            BubbleContainer.this.i();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            BubbleContainer.this.i.setVisibility(8);
        }
    }

    public interface b {
    }

    public BubbleContainer(Context context) {
        super(context);
        this.a = new Paint();
        this.k = 2;
        this.m = true;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.t = new ArrayList();
        g();
    }

    private void e(int i, int i2, View view) {
        int measuredWidth = view.getMeasuredWidth();
        boolean z = false;
        int iMax = Math.max(view.getMeasuredHeight(), 0);
        int i3 = v;
        int i4 = measuredWidth + u;
        int i5 = i3;
        int i6 = 0;
        for (View view2 : this.t) {
            if (z) {
                view2.setVisibility(8);
            } else {
                int measuredWidth2 = view2.getMeasuredWidth();
                int measuredHeight = view2.getMeasuredHeight();
                i5 += measuredHeight;
                if ((u * Math.min(1, i6)) + i5 >= iMax) {
                    view2.setVisibility(8);
                    z = true;
                } else {
                    int i7 = (i2 - i) - i5;
                    i6++;
                    view2.layout(i4, i7, measuredWidth2 + i4, measuredHeight + i7);
                    i5 += w;
                }
            }
        }
    }

    private View f() {
        return getChildAt(getChildCount() - 1);
    }

    private void g() {
        setWillNotDraw(false);
        this.n = C22078ud6.a(16.0f);
        this.o = C22078ud6.a(16.0f);
        this.p = C22078ud6.a(48.0f);
        this.q = C22078ud6.a(48.0f);
        Paint paint = this.a;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        paint.setColor(c5495Jo7.V());
        this.a.setStyle(Paint.Style.FILL);
        this.b = false;
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setTextSize(12.0f);
        this.e.setTypeface(C6011Lu2.k());
        this.e.setIncludeFontPadding(false);
        this.e.setBackgroundResource(KB5.conv_bubble_divider_date_bg);
        this.e.setGravity(17);
        this.e.setTextColor(c5495Jo7.A2());
        if (this.b) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        addView(this.e, new ViewGroup.MarginLayoutParams(-2, -2));
        this.c = false;
        TextView textView2 = new TextView(getContext());
        this.f = textView2;
        textView2.setTextSize(13.0f);
        this.f.setTypeface(C6011Lu2.k());
        this.f.setIncludeFontPadding(false);
        this.f.setBackgroundResource(KB5.unread_div_bg);
        this.f.setGravity(17);
        this.f.setTextColor(c5495Jo7.A2());
        this.f.setPadding(0, C22078ud6.a(6.0f), 0, C22078ud6.a(6.0f));
        this.f.setText(AbstractC12217eE5.chat_new_messages);
        if (this.c) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        addView(this.f, new ViewGroup.MarginLayoutParams(-1, -2));
        AvatarViewWithOnline avatarViewWithOnline = new AvatarViewWithOnline(getContext());
        this.g = avatarViewWithOnline;
        avatarViewWithOnline.a(24.0f);
        addView(this.g, new ViewGroup.MarginLayoutParams(C22078ud6.a(42.0f), C22078ud6.a(42.0f)));
        k();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.i.setVisibility(0);
        this.i.setImageResource(KB5.ba_like_peer_active);
        ImageView imageView = this.i;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        imageView.setColorFilter(c5495Jo7.W(), PorterDuff.Mode.SRC_IN);
        this.j.setTextColor(c5495Jo7.W());
    }

    private void j() {
        this.s = View.inflate(getContext(), AbstractC12208eD5.message_forward_view, null);
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), KB5.ba_share_bg);
        if (drawableF != null) {
            AbstractC21710u02.h(drawableF, C5495Jo7.a.S());
            this.s.setBackground(drawableF);
        }
        ((ImageView) this.s.findViewById(BC5.imv_forward_icon)).setColorFilter(C5495Jo7.a.A2(), PorterDuff.Mode.SRC_IN);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(C22078ud6.a(36.0f), C22078ud6.a(36.0f));
        this.s.setLayoutParams(marginLayoutParams);
        this.s.setVisibility(8);
        addView(this.s, marginLayoutParams);
        this.s.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tl0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h(view);
            }
        });
    }

    private void k() {
        ConstraintLayout constraintLayout = (ConstraintLayout) View.inflate(getContext(), AbstractC12208eD5.message_like_view, null);
        this.h = constraintLayout;
        constraintLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(C22078ud6.a(36.0f), C22078ud6.a(52.0f)));
        this.h.setVisibility(8);
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), KB5.like_bg);
        if (drawableF != null) {
            AbstractC21710u02.h(drawableF, C5495Jo7.a.S());
            this.h.setBackground(drawableF);
        }
        addView(this.h, new ViewGroup.MarginLayoutParams(C22078ud6.a(36.0f), C22078ud6.a(52.0f)));
        this.i = (ImageView) this.h.findViewById(BC5.imv_like_icon);
        TextView textView = (TextView) this.h.findViewById(BC5.tv_like_counter);
        this.j = textView;
        textView.setTypeface(C6011Lu2.k());
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.h.findViewById(BC5.lottie_like_animation_view);
        this.r = lottieAnimationView;
        lottieAnimationView.setAnimation(AbstractC19954rD5.like);
        this.r.setRepeatCount(0);
        this.r.setVisibility(8);
        this.r.i(new a());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l) {
            canvas.drawRect(0.0f, Math.max(getHeight(), 0) - f().getHeight(), getWidth(), getHeight(), this.a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        if (this.o == 0) {
            this.o = C22078ud6.a(16.0f);
        }
        if (this.c) {
            int measuredWidth = this.f.getMeasuredWidth();
            int measuredHeight = this.f.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            this.f.layout(i5, C22078ud6.a(8.0f), measuredWidth + i5, C22078ud6.a(8.0f) + measuredHeight);
            iA = C22078ud6.a(16.0f) + measuredHeight;
        } else {
            iA = 0;
        }
        if (this.b) {
            int measuredWidth2 = this.e.getMeasuredWidth();
            int measuredHeight2 = this.e.getMeasuredHeight();
            int i6 = ((i3 - i) - measuredWidth2) / 2;
            this.e.layout(i6, C22078ud6.a(8.0f) + iA, measuredWidth2 + i6, C22078ud6.a(8.0f) + iA + measuredHeight2);
            iA += C22078ud6.a(16.0f) + measuredHeight2;
        }
        if (this.d) {
            int i7 = i4 - i2;
            this.g.layout(C22078ud6.a(6.0f), (i7 - this.g.getMeasuredHeight()) - C22078ud6.a(4.0f), C22078ud6.a(6.0f) + this.g.getMeasuredWidth(), i7 - C22078ud6.a(4.0f));
        }
        View viewF = f();
        int measuredWidth3 = viewF.getMeasuredWidth();
        int iMax = Math.max(viewF.getMeasuredHeight(), 0);
        int i8 = this.k;
        if (i8 == 0) {
            int i9 = this.d ? this.p : this.o;
            viewF.layout(i9, iA, measuredWidth3 + i9, iMax + iA);
        } else if (i8 == 1) {
            int i10 = this.o;
            viewF.layout((getMeasuredWidth() - measuredWidth3) - i10, iA, getMeasuredWidth() - i10, iMax + iA);
        } else if (i8 == 2) {
            int i11 = ((i3 - i) - measuredWidth3) / 2;
            viewF.layout(i11, iA, measuredWidth3 + i11, iMax + iA);
        }
        if (this.t.isEmpty()) {
            return;
        }
        e(i2, i4, viewF);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iA;
        int i3;
        if (this.n == 0) {
            this.n = C22078ud6.a(16.0f);
        }
        if (this.p == 0) {
            this.p = C22078ud6.a(48.0f);
        }
        if (this.o == 0) {
            this.o = C22078ud6.a(16.0f);
        }
        int i4 = this.m ? this.o : 0;
        if (this.d) {
            i4 += this.p;
        }
        int i5 = i4;
        View viewF = f();
        if (this.t.isEmpty() || i <= (i3 = this.q)) {
            measureChildWithMargins(viewF, i, i5, i2, 0);
        } else {
            measureChildWithMargins(viewF, i - i3, i5, i2, 0);
        }
        if (this.b) {
            measureChild(this.e, i, i2);
            iA = C22078ud6.a(16.0f) + this.e.getMeasuredHeight();
        } else {
            iA = 0;
        }
        if (this.c) {
            measureChild(this.f, i, i2);
            iA += C22078ud6.a(16.0f) + this.f.getMeasuredHeight();
        }
        if (this.d) {
            measureChild(this.g, i, i2);
        }
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            measureChild((View) it.next(), i, i2);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), Math.max(viewF.getMeasuredHeight(), 0) + iA);
    }

    public void setBubbleSelected(boolean z) {
        this.l = z;
        setSelected(z);
        invalidate();
    }

    public void setOnForwardClickListener(b bVar) {
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        if (z != this.l) {
            return;
        }
        super.setSelected(z);
    }

    public BubbleContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.k = 2;
        this.m = true;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.t = new ArrayList();
        g();
    }

    public BubbleContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.k = 2;
        this.m = true;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.t = new ArrayList();
        g();
    }
}
