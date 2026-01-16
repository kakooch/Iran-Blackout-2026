package ir.nasim.features.libphotovideo.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C5495Jo7;
import ir.nasim.H37;
import ir.nasim.features.libphotovideo.Paint.Views.EntityView;
import ir.nasim.features.media.components.Point;
import ir.nasim.features.media.components.Rect;

/* loaded from: classes3.dex */
public class TextPaintView extends EntityView {
    private EditTextOutline p;
    private H37 q;
    private boolean r;
    private int s;

    public class TextViewSelectionView extends EntityView.SelectionView {
        public TextViewSelectionView(Context context) {
            super(context);
        }

        @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView.SelectionView
        protected int a(float f, float f2) {
            float fZ = AbstractC7426Rr.z(1.0f);
            float fZ2 = AbstractC7426Rr.z(19.5f);
            float f3 = fZ + fZ2;
            float f4 = f3 * 2.0f;
            float width = getWidth() - f4;
            float height = getHeight() - f4;
            float f5 = (height / 2.0f) + f3;
            if (f > f3 - fZ2 && f2 > f5 - fZ2 && f < f3 + fZ2 && f2 < f5 + fZ2) {
                return 1;
            }
            float f6 = f3 + width;
            if (f <= f6 - fZ2 || f2 <= f5 - fZ2 || f >= f6 + fZ2 || f2 >= f5 + fZ2) {
                return (f <= f3 || f >= width || f2 <= f3 || f2 >= height) ? 0 : 3;
            }
            return 2;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float fZ = AbstractC7426Rr.z(3.0f);
            float fZ2 = AbstractC7426Rr.z(3.0f);
            float fZ3 = AbstractC7426Rr.z(1.0f);
            float fZ4 = AbstractC7426Rr.z(4.5f);
            float fZ5 = fZ4 + fZ3 + AbstractC7426Rr.z(15.0f);
            float f = fZ5 * 2.0f;
            float width = getWidth() - f;
            float height = getHeight() - f;
            float f2 = fZ + fZ2;
            int iFloor = (int) Math.floor(width / f2);
            float fCeil = (float) Math.ceil(((width - (iFloor * f2)) + fZ) / 2.0f);
            int i = 0;
            while (i < iFloor) {
                float f3 = fCeil + fZ5 + (i * f2);
                float f4 = fZ3 / 2.0f;
                float f5 = f3 + fZ2;
                canvas.drawRect(f3, fZ5 - f4, f5, fZ5 + f4, this.a);
                float f6 = fZ5 + height;
                canvas.drawRect(f3, f6 - f4, f5, f6 + f4, this.a);
                i++;
                iFloor = iFloor;
                fCeil = fCeil;
            }
            int iFloor2 = (int) Math.floor(height / f2);
            float fCeil2 = (float) Math.ceil(((height - (iFloor2 * f2)) + fZ) / 2.0f);
            int i2 = 0;
            while (i2 < iFloor2) {
                float f7 = fCeil2 + fZ5 + (i2 * f2);
                float f8 = fZ3 / 2.0f;
                float f9 = f7 + fZ2;
                canvas.drawRect(fZ5 - f8, f7, fZ5 + f8, f9, this.a);
                float f10 = fZ5 + width;
                canvas.drawRect(f10 - f8, f7, f10 + f8, f9, this.a);
                i2++;
                iFloor2 = iFloor2;
            }
            float f11 = (height / 2.0f) + fZ5;
            canvas.drawCircle(fZ5, f11, fZ4, this.b);
            canvas.drawCircle(fZ5, f11, fZ4, this.c);
            float f12 = fZ5 + width;
            canvas.drawCircle(f12, f11, fZ4, this.b);
            canvas.drawCircle(f12, f11, fZ4, this.c);
        }
    }

    class a implements TextWatcher {
        private String a;
        private int b = 0;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextPaintView.this.p.removeTextChangedListener(this);
            if (TextPaintView.this.p.getLineCount() > 9) {
                TextPaintView.this.p.setText(this.a);
                TextPaintView.this.p.setSelection(this.b);
            }
            TextPaintView.this.p.addTextChangedListener(this);
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

    public TextPaintView(Context context, Point point, int i, String str, H37 h37, boolean z) {
        super(context, point);
        this.s = i;
        EditTextOutline editTextOutline = new EditTextOutline(context);
        this.p = editTextOutline;
        editTextOutline.setBackgroundColor(0);
        this.p.setPadding(AbstractC7426Rr.z(7.0f), AbstractC7426Rr.z(7.0f), AbstractC7426Rr.z(7.0f), AbstractC7426Rr.z(7.0f));
        this.p.setClickable(false);
        this.p.setEnabled(false);
        this.p.setTextSize(0, this.s);
        this.p.setText(str);
        this.p.setTextColor(h37.a);
        this.p.setTypeface(null, 1);
        this.p.setGravity(17);
        this.p.setHorizontallyScrolling(false);
        this.p.setImeOptions(268435456);
        this.p.setFocusableInTouchMode(true);
        EditTextOutline editTextOutline2 = this.p;
        editTextOutline2.setInputType(editTextOutline2.getInputType() | 16384);
        addView(this.p, C14433hu3.c(-2, -2, 51));
        this.p.setBreakStrategy(0);
        setSwatch(h37);
        setStroke(z);
        A();
        this.p.addTextChangedListener(new a());
    }

    private void G() {
        if (this.r) {
            this.p.setTextColor(C5495Jo7.a.f0());
            this.p.setStrokeColor(this.q.a);
            this.p.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        } else {
            this.p.setTextColor(this.q.a);
            this.p.setStrokeColor(0);
            this.p.setShadowLayer(8.0f, 0.0f, 2.0f, C5495Jo7.a.k2());
        }
    }

    public void D() {
        this.p.setEnabled(true);
        this.p.setClickable(true);
        this.p.requestFocus();
        EditTextOutline editTextOutline = this.p;
        editTextOutline.setSelection(editTextOutline.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public TextViewSelectionView s() {
        return new TextViewSelectionView(getContext());
    }

    public void F() {
        this.p.clearFocus();
        this.p.setEnabled(false);
        this.p.setClickable(false);
        B();
    }

    public View getFocusedView() {
        return this.p;
    }

    @Override // ir.nasim.features.libphotovideo.Paint.Views.EntityView
    protected Rect getSelectionBounds() {
        float scaleX = ((ViewGroup) getParent()).getScaleX();
        float width = (getWidth() * getScale()) + (AbstractC7426Rr.z(46.0f) / scaleX);
        float height = (getHeight() * getScale()) + (AbstractC7426Rr.z(20.0f) / scaleX);
        Point point = this.j;
        return new Rect((point.x - (width / 2.0f)) * scaleX, (point.y - (height / 2.0f)) * scaleX, width * scaleX, height * scaleX);
    }

    public H37 getSwatch() {
        return this.q;
    }

    public String getText() {
        return this.p.getText().toString();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        A();
    }

    public void setMaxWidth(int i) {
        this.p.setMaxWidth(i);
    }

    public void setStroke(boolean z) {
        this.r = z;
        G();
    }

    public void setSwatch(H37 h37) {
        this.q = h37;
        G();
    }

    public void setText(String str) {
        this.p.setText(str);
    }

    public TextPaintView(Context context, TextPaintView textPaintView, Point point) {
        this(context, point, textPaintView.s, textPaintView.getText(), textPaintView.getSwatch(), textPaintView.r);
        setRotation(textPaintView.getRotation());
        setScale(textPaintView.getScale());
    }
}
