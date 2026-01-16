package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.FH3;
import ir.nasim.LU4;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.ChatActivityEnterViewAnimatedIconView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class PaintTextOptionsView extends FrameLayout implements E.d {
    private static final List n;
    private int a;
    private ChatActivityEnterViewAnimatedIconView b;
    private RLottieImageView c;
    private ImageView d;
    private ImageView e;
    private View f;
    private TypefaceCell g;
    private PaintTypefaceListView h;
    private b i;
    private int j;
    private int k;
    private int l;
    private String m;

    public static final class TypefaceCell extends AppCompatTextView {
        private boolean h;
        private Drawable i;

        public TypefaceCell(Context context) {
            super(context);
            setTextColor(-1);
            setTextSize(1, 14.0f);
            setCurrent(false);
            setEllipsize(TextUtils.TruncateAt.END);
            setSingleLine();
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.save();
            canvas.translate(0.0f, AbstractC21455b.F(-1.0f));
            super.onDraw(canvas);
            canvas.restore();
            if (this.h) {
                int height = (getHeight() - AbstractC21455b.F(16.0f)) / 2;
                if (FH3.D) {
                    this.i.setBounds(AbstractC21455b.F(7.0f), height, AbstractC21455b.F(23.0f), AbstractC21455b.F(16.0f) + height);
                } else {
                    this.i.setBounds(getWidth() - AbstractC21455b.F(23.0f), height, getWidth() - AbstractC21455b.F(7.0f), AbstractC21455b.F(16.0f) + height);
                }
                this.i.draw(canvas);
            }
        }

        public void r(LU4 lu4) {
            setTypeface(lu4.q());
            setText(lu4.p());
        }

        public void setCurrent(boolean z) {
            this.h = z;
            if (z) {
                setPadding(AbstractC21455b.F(FH3.D ? 27.0f : 12.0f), AbstractC21455b.F(6.0f), AbstractC21455b.F(FH3.D ? 12.0f : 27.0f), AbstractC21455b.F(6.0f));
                setBackground(m.e.h(1090519039, AbstractC21455b.F(32.0f)));
            } else {
                setPadding(AbstractC21455b.F(24.0f), AbstractC21455b.F(14.0f), AbstractC21455b.F(24.0f), AbstractC21455b.F(14.0f));
                setBackground(m.e.g(-14145495));
            }
            if (this.h && this.i == null) {
                Drawable drawableF = AbstractC4043Dl1.f(getContext(), AbstractC23598xB5.photo_expand);
                this.i = drawableF;
                drawableF.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
            }
            invalidate();
        }
    }

    private static final class a {
        private final int a;
        private final int b;
        private final int c;
        private final int d;

        private a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public interface b {
        void C();

        void b();

        void g(int i);

        void n();

        void y(View view);
    }

    static {
        int i = 40;
        int i2 = 2;
        int i3 = 20;
        int i4 = 0;
        n = Arrays.asList(new a(0, 1, 20, 0), new a(0, i2, 20, i), new a(1, i4, 0, i3), new a(1, i2, 60, i), new a(2, i4, 40, i3), new a(2, 1, 40, 60));
    }

    public PaintTextOptionsView(Context context) {
        super(context);
        this.a = 0;
        setWillNotDraw(false);
        View view = new View(context);
        this.f = view;
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.h(view2);
            }
        });
        addView(this.f, AbstractC13840gu3.c(24, 24.0f, 48, 0.0f, 0.0f, 16.0f, 0.0f));
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.c = rLottieImageView;
        rLottieImageView.setAnimation(AbstractC19363qD5.photo_text_allign, 24, 24);
        RLottieDrawable animatedDrawable = this.c.getAnimatedDrawable();
        animatedDrawable.q0(true);
        animatedDrawable.l0(20);
        animatedDrawable.g0(20);
        RLottieImageView rLottieImageView2 = this.c;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        rLottieImageView2.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.i(view2);
            }
        });
        this.c.setPadding(AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f));
        addView(this.c, AbstractC13840gu3.c(28, 28.0f, 16, 0.0f, 0.0f, 16.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        this.d = imageView;
        imageView.setImageResource(AbstractC23598xB5.msg_text_outlined);
        this.d.setPadding(AbstractC21455b.F(1.0f), AbstractC21455b.F(1.0f), AbstractC21455b.F(1.0f), AbstractC21455b.F(1.0f));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.j(view2);
            }
        });
        addView(this.d, AbstractC13840gu3.c(28, 28.0f, 16, 0.0f, 0.0f, 16.0f, 0.0f));
        ImageView imageView2 = new ImageView(context);
        this.e = imageView2;
        imageView2.setImageResource(AbstractC23598xB5.msg_add);
        this.e.setColorFilter(new PorterDuffColorFilter(-1, mode));
        this.e.setBackground(m.Y(1090519039));
        this.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.k(view2);
            }
        });
        this.e.setPadding(AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f));
        addView(this.e, AbstractC13840gu3.c(28, 28.0f, 16, 0.0f, 0.0f, 16.0f, 0.0f));
        TypefaceCell typefaceCell = new TypefaceCell(context);
        this.g = typefaceCell;
        typefaceCell.setCurrent(true);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.l(view2);
            }
        });
        addView(this.g, AbstractC13840gu3.j(-2, -2, 0.0f, 21));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        setAlignment((this.a + 1) % 3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        this.i.y(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        this.i.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        this.i.C();
    }

    private void m(View view) {
        if (view.getVisibility() != 8) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int i = this.k + layoutParams.leftMargin;
            this.k = i;
            view.layout(i, (getMeasuredHeight() - layoutParams.height) / 2, this.k + layoutParams.width, (getMeasuredHeight() + layoutParams.height) / 2);
            this.k += layoutParams.width + layoutParams.rightMargin;
        }
    }

    public void f(int i) {
        if (i == 0) {
            i = AbstractC23598xB5.msg_add;
        }
        if (this.l != i) {
            ImageView imageView = this.e;
            this.l = i;
            AbstractC21455b.G1(imageView, i);
        }
    }

    public void g(RectF rectF) {
        rectF.set(this.g.getLeft() + AbstractC21455b.F(8.0f), this.g.getTop(), this.g.getRight() + AbstractC21455b.F(8.0f), this.g.getBottom());
    }

    public View getColorClickableView() {
        return this.f;
    }

    public ChatActivityEnterViewAnimatedIconView getEmojiButton() {
        return this.b;
    }

    public TypefaceCell getTypefaceCell() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        E.j().e(this, E.a4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E.j().u(this, E.a4);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.k = getPaddingLeft();
        m(this.f);
        m(this.c);
        m(this.d);
        m(this.e);
        this.g.layout((getMeasuredWidth() - getPaddingRight()) - this.g.getMeasuredWidth(), (getMeasuredHeight() - this.g.getMeasuredHeight()) / 2, getMeasuredWidth() - getPaddingRight(), (getMeasuredHeight() + this.g.getMeasuredHeight()) / 2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            TypefaceCell typefaceCell = this.g;
            if (childAt == typefaceCell) {
                typefaceCell.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(size2, RecyclerView.UNDEFINED_DURATION));
            } else {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                childAt.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
                paddingLeft -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setAlignment(int i) {
        setAlignment(i, false);
    }

    public void setDelegate(b bVar) {
        this.i = bVar;
    }

    public void setOutlineType(int i) {
        setOutlineType(i, false);
    }

    public void setTypeface(String str) {
        this.m = str;
        if (this.g == null) {
            return;
        }
        for (LU4 lu4 : LU4.n()) {
            if (lu4.o().equals(str)) {
                this.g.r(lu4);
                return;
            }
        }
    }

    public void setTypefaceListView(PaintTypefaceListView paintTypefaceListView) {
        this.h = paintTypefaceListView;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        String str;
        if (i != E.a4 || (str = this.m) == null) {
            return;
        }
        setTypeface(str);
        this.m = null;
    }

    public void setAlignment(int i, boolean z) {
        int i2 = this.a;
        this.a = i;
        if (i2 == i) {
            RLottieDrawable animatedDrawable = this.c.getAnimatedDrawable();
            List list = n;
            a aVar = (a) list.get(0);
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a aVar2 = (a) it.next();
                if (this.a == aVar2.b) {
                    aVar = aVar2;
                    break;
                }
            }
            animatedDrawable.g0(aVar.d);
            animatedDrawable.l0(aVar.d);
            if (z) {
                this.i.g(i);
                return;
            }
            return;
        }
        List list2 = n;
        a aVar3 = (a) list2.get(0);
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            a aVar4 = (a) it2.next();
            if (i2 == aVar4.a && this.a == aVar4.b) {
                aVar3 = aVar4;
                break;
            }
        }
        RLottieDrawable animatedDrawable2 = this.c.getAnimatedDrawable();
        animatedDrawable2.g0(aVar3.c);
        animatedDrawable2.l0(aVar3.d);
        animatedDrawable2.start();
        if (z) {
            this.i.g(i);
        }
    }

    public void setOutlineType(int i, boolean z) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        int i2 = i != 1 ? i != 2 ? i != 3 ? AbstractC23598xB5.msg_photo_text_framed : AbstractC23598xB5.msg_photo_text_regular : AbstractC23598xB5.msg_photo_text_framed3 : AbstractC23598xB5.msg_photo_text_framed2;
        if (z) {
            AbstractC21455b.G1(this.d, i2);
        } else {
            this.d.setImageResource(i2);
        }
    }
}
