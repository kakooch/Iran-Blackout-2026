package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.QY0;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.stories.StoryCaptionView;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes7.dex */
public class PreviewHighlightView extends FrameLayout {
    private int a;
    private int b;
    private final FrameLayout c;
    private final FrameLayout d;
    private final StoryCaptionView e;
    private boolean f;
    private boolean g;

    class a extends FrameLayout {
        private RectF a;
        private Paint b;

        a(Context context) {
            super(context);
            this.a = new RectF();
            this.b = new Paint(1);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            this.b.setColor(-1);
            float width = ((getWidth() - (AbstractC21455b.H(5.0f) * 2.0f)) - AbstractC21455b.H((PreviewHighlightView.this.b - 1) * 2)) / PreviewHighlightView.this.b;
            float fH = AbstractC21455b.H(5.0f);
            int i = 0;
            while (i < PreviewHighlightView.this.b) {
                this.a.set(fH, AbstractC21455b.H(8.0f), fH + width, AbstractC21455b.H(10.0f));
                this.b.setAlpha(i < PreviewHighlightView.this.b + (-1) ? 255 : WKSRecord.Service.STATSRV);
                canvas.drawRoundRect(this.a, AbstractC21455b.H(1.0f), AbstractC21455b.H(1.0f), this.b);
                fH += AbstractC21455b.H(2.0f) + width;
                i++;
            }
        }
    }

    public PreviewHighlightView(Context context, int i, m.h hVar) {
        super(context);
        this.b = 1;
        this.f = false;
        this.g = false;
        this.a = i;
        a aVar = new a(getContext());
        this.c = aVar;
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(getContext().getResources().getDrawable(AbstractC23598xB5.ic_close_white).mutate());
        imageView.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
        aVar.addView(imageView, AbstractC13840gu3.c(40, 40.0f, 53, 12.0f, 15.0f, 12.0f, 0.0f));
        addView(aVar, AbstractC13840gu3.b(-1, -2.0f));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        StoryCaptionView storyCaptionView = new StoryCaptionView(getContext(), hVar);
        this.e = storyCaptionView;
        storyCaptionView.P0 = true;
        storyCaptionView.setTranslationY(AbstractC21455b.F(8.0f));
        frameLayout.addView(storyCaptionView, AbstractC13840gu3.c(-1, -1.0f, 87, 0.0f, 0.0f, 0.0f, 64.0f));
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(AbstractC23598xB5.msg_share);
        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
        imageView2.setColorFilter(new PorterDuffColorFilter(-1, mode));
        frameLayout.addView(imageView2, AbstractC13840gu3.c(28, 28.0f, 85, 0.0f, 0.0f, 12.0f, 16.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(22.0f), QY0.k(-16777216, 122)));
        TextView textView = new TextView(context);
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(1694498815);
        textView.setText(FH3.E("ReplyPrivately", TD5.tgwidget_ReplyPrivately));
        frameLayout2.addView(textView, AbstractC13840gu3.c(-2, -2.0f, 19, 24.0f, 0.0f, 24.0f, 0.0f));
        ImageView imageView3 = new ImageView(context);
        imageView3.setImageResource(AbstractC23598xB5.input_attach);
        imageView3.setColorFilter(new PorterDuffColorFilter(-1, mode));
        frameLayout2.addView(imageView3, AbstractC13840gu3.c(28, 28.0f, 21, 0.0f, 0.0f, 9.0f, 0.0f));
        frameLayout.addView(frameLayout2, AbstractC13840gu3.c(-1, 44.0f, 87, 9.0f, 8.0f, 55.0f, 8.0f));
        addView(frameLayout, AbstractC13840gu3.b(-1, -1.0f));
        aVar.setAlpha(0.0f);
        frameLayout.setAlpha(0.0f);
    }

    public void b(boolean z, boolean z2, View view) {
        if (z) {
            if (this.f == z2) {
                return;
            } else {
                this.f = z2;
            }
        } else if (this.g == z2) {
            return;
        } else {
            this.g = z2;
        }
        FrameLayout frameLayout = z ? this.c : this.d;
        frameLayout.clearAnimation();
        frameLayout.animate().alpha(z2 ? z ? 0.5f : 0.2f : 0.0f).start();
        if (view != null) {
            view.clearAnimation();
            view.animate().alpha(z2 ? 0.0f : 1.0f).start();
        }
    }

    public void c() {
        this.b = C.n(this.a).r().f() + 1;
        this.c.invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
