package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.T45;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;

/* loaded from: classes7.dex */
public class PaintColorsListView extends RecyclerListView {
    private static Paint Y2 = new Paint(1);
    private static Paint Z2 = new Paint(1);
    private static Path a3;
    private static Paint b3;
    private Paint T2;
    private Paint U2;
    private int V2;
    private T45 W2;
    private InterfaceC25043ze1 X2;

    class a extends RecyclerView.h {
        final /* synthetic */ Context d;

        a(Context context) {
            this.d = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return 14;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onBindViewHolder(RecyclerView.C c, int i) {
            b bVar = (b) c.a;
            bVar.getLayoutParams().height = ((PaintColorsListView.this.getHeight() - PaintColorsListView.this.getPaddingTop()) - PaintColorsListView.this.getPaddingBottom()) / 2;
            if (PaintColorsListView.this.W2 != null) {
                bVar.a(PaintColorsListView.this.W2.b(i));
                bVar.b(PaintColorsListView.this.V2 == i, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RecyclerListView.g(PaintColorsListView.this.new b(this.d));
        }
    }

    private final class b extends View {
        private int a;
        private float b;

        public b(Context context) {
            super(context);
            setPadding(AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f));
            setLayoutParams(new RecyclerView.LayoutParams(-2, 0));
        }

        public void a(int i) {
            this.a = i;
            invalidate();
        }

        public void b(boolean z, boolean z2) {
            if (z2) {
                return;
            }
            this.b = z ? 1.0f : 0.0f;
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            PaintColorsListView.this.T2.setColor(this.a);
            float fMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f;
            if (this.b != 0.0f) {
                fMin -= (AbstractC21455b.F(3.0f) + PaintColorsListView.this.U2.getStrokeWidth()) * this.b;
            }
            float width = ((getWidth() / 2.0f) + getPaddingLeft()) - getPaddingRight();
            float height = ((getHeight() / 2.0f) + getPaddingTop()) - getPaddingBottom();
            PaintColorsListView.c2(canvas, width, height, fMin, this.a);
            if (this.b != 0.0f) {
                PaintColorsListView.this.U2.setColor(this.a);
                PaintColorsListView.this.U2.setAlpha(255);
                canvas.drawCircle(width, height, (Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) - AbstractC21455b.F(2.0f), PaintColorsListView.this.U2);
            }
        }
    }

    static {
        Y2.setColor(-2013265920);
        Z2.setColor(-1996488705);
        a3 = new Path();
        b3 = new Paint(1);
    }

    public PaintColorsListView(Context context) {
        super(context);
        this.T2 = new Paint(1);
        Paint paint = new Paint(1);
        this.U2 = paint;
        this.V2 = 0;
        paint.setStyle(Paint.Style.STROKE);
        this.U2.setStrokeWidth(AbstractC21455b.F(2.0f));
        setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
        setLayoutManager(new GridLayoutManager(context, 7));
        setAdapter(new a(context));
        setOverScrollMode(2);
        setOnItemClickListener(new RecyclerListView.i() { // from class: ir.nasim.gU4
            @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.i
            public final void a(View view, int i) {
                this.a.d2(view, i);
            }
        });
    }

    public static void b2(Canvas canvas, RectF rectF, int i) {
        float f = rectF.left;
        while (f <= rectF.right) {
            float f2 = rectF.top;
            while (f2 <= rectF.bottom) {
                float f3 = i;
                float f4 = f + f3;
                float f5 = f2 + f3;
                canvas.drawRect(f, f2, f4, f5, Y2);
                float f6 = i * 2;
                float f7 = f + f6;
                canvas.drawRect(f4, f2, f7, f5, Z2);
                f2 += f6;
                canvas.drawRect(f4, f5, f7, f2, Y2);
                canvas.drawRect(f, f5, f4, f2, Z2);
            }
            f += i * 2;
        }
    }

    public static void c2(Canvas canvas, float f, float f2, float f3, int i) {
        b3.setColor(i);
        if (b3.getAlpha() == 255) {
            canvas.drawCircle(f, f2, f3, b3);
            return;
        }
        RectF rectF = AbstractC21455b.x;
        rectF.set(f - f3, f2 - f3, f + f3, f2 + f3);
        b3.setAlpha(255);
        canvas.drawArc(rectF, -45.0f, -180.0f, true, b3);
        a3.rewind();
        a3.moveTo(rectF.centerX(), rectF.centerY());
        a3.lineTo((float) (rectF.centerX() + ((rectF.width() / 2.0f) * Math.cos(-1.5707963267948966d))), (float) (rectF.centerY() + ((rectF.height() / 2.0f) * Math.sin(-1.5707963267948966d))));
        a3.moveTo(rectF.centerX(), rectF.centerY());
        a3.lineTo((float) (rectF.centerX() + ((rectF.width() / 2.0f) * Math.cos(4.71238898038469d))), (float) (rectF.centerY() + ((rectF.height() / 2.0f) * Math.sin(4.71238898038469d))));
        a3.addArc(rectF, -45.0f, 180.0f);
        canvas.save();
        canvas.clipPath(a3);
        b2(canvas, rectF, AbstractC21455b.F(4.0f));
        canvas.restore();
        b3.setColor(i);
        canvas.drawArc(rectF, -45.0f, 180.0f, true, b3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view, int i) {
        this.X2.accept(Integer.valueOf(this.W2.b(i)));
        this.W2.m(i);
    }

    public void setColorListener(InterfaceC25043ze1 interfaceC25043ze1) {
        this.X2 = interfaceC25043ze1;
    }

    public void setColorPalette(T45 t45) {
        this.W2 = t45;
        getAdapter().notifyDataSetChanged();
    }

    public void setProgress(float f, boolean z) {
        float interpolation = z ? InterpolatorC12631ew1.g.getInterpolation(f) : InterpolatorC12631ew1.i.getInterpolation(f);
        float childCount = 1.0f / (getChildCount() - 1);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (i == 0) {
                childAt.setAlpha(interpolation == 1.0f ? 1.0f : 0.0f);
            } else {
                float f2 = i * childCount;
                float fMin = Math.min(interpolation, f2) / f2;
                childAt.setScaleX(fMin);
                childAt.setScaleY(fMin);
            }
        }
        invalidate();
    }

    public void setSelectedColorIndex(int i) {
        this.V2 = i;
        getAdapter().notifyDataSetChanged();
    }
}
