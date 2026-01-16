package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.C22697vg5;
import ir.nasim.DK5;
import ir.nasim.FH3;
import ir.nasim.G37;
import ir.nasim.LU4;
import ir.nasim.R62;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class TextPaintView extends EntityView {
    private EditTextOutline D0;
    private G37 E0;
    private int F0;
    private int G0;
    private int H0;
    private LU4 I0;
    private String J0;

    public class TextViewSelectionView extends EntityView.SelectionView {
        private final Paint f;
        private Path g;

        public TextViewSelectionView(Context context) {
            super(context);
            Paint paint = new Paint(1);
            this.f = paint;
            this.g = new Path();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.SelectionView
        protected int a(float f, float f2) {
            float F = AbstractC21455b.F(1.0f);
            float F2 = AbstractC21455b.F(19.5f);
            float f3 = F + F2;
            float f4 = f3 * 2.0f;
            float measuredWidth = getMeasuredWidth() - f4;
            float measuredHeight = ((getMeasuredHeight() - f4) / 2.0f) + f3;
            if (f > f3 - F2 && f2 > measuredHeight - F2 && f < f3 + F2 && f2 < measuredHeight + F2) {
                return 1;
            }
            float f5 = f3 + measuredWidth;
            return (f <= f5 - F2 || f2 <= measuredHeight - F2 || f >= f5 + F2 || f2 >= measuredHeight + F2) ? 0 : 2;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float F = AbstractC21455b.F(2.0f);
            float fH = AbstractC21455b.H(5.66f);
            float F2 = F + fH + AbstractC21455b.F(15.0f);
            float f = F2 * 2.0f;
            float measuredWidth = getMeasuredWidth() - f;
            float measuredHeight = getMeasuredHeight() - f;
            RectF rectF = AbstractC21455b.x;
            float f2 = F2 + measuredWidth;
            float f3 = F2 + measuredHeight;
            rectF.set(F2, F2, f2, f3);
            float F3 = AbstractC21455b.F(12.0f);
            float fMin = Math.min(F3, measuredWidth / 2.0f);
            float f4 = measuredHeight / 2.0f;
            float fMin2 = Math.min(F3, f4);
            this.g.rewind();
            float f5 = fMin * 2.0f;
            float f6 = F2 + f5;
            float f7 = 2.0f * fMin2;
            float f8 = F2 + f7;
            rectF.set(F2, F2, f6, f8);
            this.g.arcTo(rectF, 180.0f, 90.0f);
            float f9 = f2 - f5;
            rectF.set(f9, F2, f2, f8);
            this.g.arcTo(rectF, 270.0f, 90.0f);
            canvas.drawPath(this.g, this.a);
            this.g.rewind();
            float f10 = f3 - f7;
            rectF.set(F2, f10, f6, f3);
            this.g.arcTo(rectF, 180.0f, -90.0f);
            rectF.set(f9, f10, f2, f3);
            this.g.arcTo(rectF, 90.0f, -90.0f);
            canvas.drawPath(this.g, this.a);
            float f11 = F2 + f4;
            canvas.drawCircle(F2, f11, fH, this.c);
            canvas.drawCircle(F2, f11, (fH - AbstractC21455b.F(1.0f)) + 1.0f, this.b);
            canvas.drawCircle(f2, f11, fH, this.c);
            canvas.drawCircle(f2, f11, (fH - AbstractC21455b.F(1.0f)) + 1.0f, this.b);
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), 255, 31);
            float f12 = F2 + fMin2;
            float f13 = f3 - fMin2;
            canvas.drawLine(F2, f12, F2, f13, this.a);
            canvas.drawLine(f2, f12, f2, f13, this.a);
            canvas.drawCircle(f2, f11, (AbstractC21455b.F(1.0f) + fH) - 1.0f, this.f);
            canvas.drawCircle(F2, f11, (fH + AbstractC21455b.F(1.0f)) - 1.0f, this.f);
            canvas.restore();
        }
    }

    class a extends EditTextOutline {
        a(Context context) {
            super(context);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EntityView.SelectionView selectionView = TextPaintView.this.m;
            if (selectionView == null || selectionView.getVisibility() != 0) {
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            TextPaintView.this.d0();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            TextPaintView.this.d0();
        }
    }

    class b implements TextWatcher {
        private String a;
        private int b = 0;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextPaintView.this.D0.removeTextChangedListener(this);
            if (TextPaintView.this.D0.getLineCount() > 9) {
                TextPaintView.this.D0.setText(this.a);
                TextPaintView.this.D0.setSelection(this.b);
            }
            TextPaintView.this.n0();
            TextPaintView.this.D0.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a = charSequence.toString();
            this.b = i;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public TextPaintView(Context context, C22697vg5 c22697vg5, int i, CharSequence charSequence, G37 g37, int i2) {
        super(context, c22697vg5);
        this.I0 = LU4.g;
        this.G0 = i;
        a aVar = new a(context);
        this.D0 = aVar;
        E.p(aVar);
        this.D0.setGravity(19);
        this.D0.setBackgroundColor(0);
        this.D0.setPadding(AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f));
        this.D0.setClickable(false);
        this.D0.setEnabled(false);
        this.D0.setCursorColor(-1);
        this.D0.setTextSize(0, this.G0);
        this.D0.setCursorSize(AbstractC21455b.F(this.G0 * 0.4f));
        this.D0.setText(charSequence);
        n0();
        this.D0.setTextColor(g37.a);
        this.D0.setTypeface(null, 1);
        this.D0.setHorizontallyScrolling(false);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            this.D0.setImeOptions(285212672);
        } else {
            this.D0.setImeOptions(268435456);
        }
        this.D0.setFocusableInTouchMode(true);
        this.D0.setSingleLine(false);
        addView(this.D0, AbstractC13840gu3.d(-2, -2, 51));
        if (i3 >= 29) {
            this.D0.setBreakStrategy(0);
        } else {
            this.D0.setBreakStrategy(0);
        }
        setSwatch(g37);
        setType(i2);
        b0();
        this.D0.addTextChangedListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0() {
        AbstractC21455b.C1(this.D0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (this.D0.getText().length() > 0) {
            this.D0.setHint((CharSequence) null);
        } else {
            this.D0.setHint(FH3.C(TD5.tgwidget_TextPlaceholder));
            this.D0.setHintTextColor(1627389951);
        }
    }

    public int getAlign() {
        return this.H0;
    }

    public int getBaseFontSize() {
        return this.G0;
    }

    public EditTextOutline getEditText() {
        return this.D0;
    }

    public View getFocusedView() {
        return this.D0;
    }

    public Paint.FontMetricsInt getFontMetricsInt() {
        return this.D0.getPaint().getFontMetricsInt();
    }

    public float getFontSize() {
        return this.D0.getTextSize();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    protected DK5 getSelectionBounds() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return new DK5();
        }
        float scaleX = viewGroup.getScaleX();
        float measuredWidth = (getMeasuredWidth() * getScale()) + (AbstractC21455b.F(64.0f) / scaleX);
        float measuredHeight = (getMeasuredHeight() * getScale()) + (AbstractC21455b.F(52.0f) / scaleX);
        float positionX = (getPositionX() - (measuredWidth / 2.0f)) * scaleX;
        return new DK5(positionX, (getPositionY() - (((measuredHeight - this.D0.getExtendedPaddingTop()) - AbstractC21455b.H(4.0f)) / 2.0f)) * scaleX, ((measuredWidth * scaleX) + positionX) - positionX, (measuredHeight - this.D0.getExtendedPaddingBottom()) * scaleX);
    }

    public G37 getSwatch() {
        return this.E0;
    }

    public CharSequence getText() {
        return this.D0.getText();
    }

    public int getTextSize() {
        return (int) this.D0.getTextSize();
    }

    public int getType() {
        return this.F0;
    }

    public LU4 getTypeface() {
        return this.I0;
    }

    public void i0() {
        this.D0.setEnabled(true);
        this.D0.setClickable(true);
        this.D0.requestFocus();
        EditTextOutline editTextOutline = this.D0;
        editTextOutline.setSelection(editTextOutline.getText().length());
        AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.yn7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l0();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public TextViewSelectionView G() {
        return new TextViewSelectionView(getContext());
    }

    public void k0() {
        this.D0.clearFocus();
        this.D0.setEnabled(false);
        this.D0.setClickable(false);
        d0();
    }

    public void m0() {
        this.D0.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        int i = this.E0.a;
        int i2 = this.F0;
        if (i2 == 0) {
            this.D0.setFrameColor(i);
            i = AbstractC21455b.z(this.E0.a) >= 0.721f ? -16777216 : -1;
        } else if (i2 == 1) {
            this.D0.setFrameColor(AbstractC21455b.z(i) >= 0.25f ? -1728053248 : -1711276033);
        } else if (i2 == 2) {
            this.D0.setFrameColor(AbstractC21455b.z(i) >= 0.25f ? -16777216 : -1);
        } else {
            this.D0.setFrameColor(0);
        }
        this.D0.setTextColor(i);
        this.D0.setCursorColor(i);
        this.D0.setHandlesColor(i);
        this.D0.setHighlightColor(m.Q0(i, 0.4f));
    }

    public void o0() {
        String str = this.J0;
        if (str != null) {
            setTypeface(str);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        b0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b0();
    }

    public void setAlign(int i) {
        this.H0 = i;
    }

    public void setBaseFontSize(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.G0 = i;
        float f = i;
        this.D0.setTextSize(0, f);
        this.D0.setCursorSize(AbstractC21455b.F(f * 0.4f));
        if (this.D0.getText() instanceof Spanned) {
            Editable text = this.D0.getText();
            R62.c[] cVarArr = (R62.c[]) text.getSpans(0, text.length(), R62.c.class);
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                cVarArr[i2].a(getFontMetricsInt());
                cVarArr[i2].d(0.85f);
            }
            for (AnimatedEmojiSpan animatedEmojiSpan : (AnimatedEmojiSpan[]) text.getSpans(0, text.length(), AnimatedEmojiSpan.class)) {
                animatedEmojiSpan.j(getFontMetricsInt());
            }
            this.D0.D();
        }
    }

    public void setMaxWidth(int i) {
        this.D0.setMaxWidth(i);
    }

    public void setSwatch(G37 g37) {
        this.E0 = g37;
        m0();
    }

    public void setText(CharSequence charSequence) {
        this.D0.setText(charSequence);
        n0();
    }

    public void setType(int i) {
        this.F0 = i;
        m0();
    }

    public void setTypeface(LU4 lu4) {
        this.I0 = lu4;
        if (lu4 != null) {
            this.D0.setTypeface(lu4.q());
        }
        d0();
    }

    public void setTypeface(String str) {
        Iterator it = LU4.n().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LU4 lu4 = (LU4) it.next();
            if (lu4.o().equals(str)) {
                setTypeface(lu4);
                str = null;
                break;
            }
        }
        this.J0 = str;
        d0();
    }

    public TextPaintView(Context context, TextPaintView textPaintView, C22697vg5 c22697vg5) {
        this(context, c22697vg5, textPaintView.G0, textPaintView.getText(), textPaintView.getSwatch(), textPaintView.F0);
        setRotation(textPaintView.getRotation());
        setScale(textPaintView.getScale());
        setTypeface(textPaintView.getTypeface());
        setAlign(textPaintView.getAlign());
        int align = getAlign();
        int i = 2;
        this.D0.setGravity(align != 1 ? align != 2 ? 19 : 21 : 17);
        int align2 = getAlign();
        if (align2 == 1) {
            i = 4;
        } else if (align2 == 2 ? !FH3.D : FH3.D) {
            i = 3;
        }
        this.D0.setTextAlignment(i);
    }
}
