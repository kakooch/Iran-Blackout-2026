package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor;

/* loaded from: classes7.dex */
public class EditTextOutline extends EditTextBoldCursor {
    private Canvas B1;
    private TextPaint C1;
    private Paint D1;
    private Bitmap E1;
    private boolean F1;
    private int G1;
    private float H1;
    private int I1;
    private Path J1;
    public boolean K1;
    private RectF[] L1;
    private boolean M1;
    private float N1;

    public EditTextOutline(Context context) {
        super(context);
        this.B1 = new Canvas();
        this.C1 = new TextPaint(1);
        this.D1 = new Paint(1);
        this.J1 = new Path();
        this.G1 = 0;
        setInputType(getInputType() | 655360);
        this.F1 = true;
        this.M1 = true;
        setFrameRoundRadius(AbstractC21455b.F(16.0f));
        this.C1.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    private void setFrameRoundRadius(float f) {
        if (Math.abs(this.N1 - f) > 0.1f) {
            Paint paint = this.D1;
            this.N1 = f;
            paint.setPathEffect(new CornerPathEffect(f));
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException {
        boolean z;
        int i = 0;
        if (this.E1 != null && this.G1 != 0) {
            if (this.F1) {
                int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight = getMeasuredHeight();
                Editable text = getText();
                this.B1.setBitmap(this.E1);
                this.B1.drawColor(0, PorterDuff.Mode.CLEAR);
                float fCeil = this.H1;
                if (fCeil <= 0.0f) {
                    fCeil = (float) Math.ceil(getTextSize() / 11.5f);
                }
                this.C1.setStrokeWidth(fCeil);
                this.C1.setColor(this.G1);
                this.C1.setTextSize(getTextSize());
                this.C1.setTypeface(getTypeface());
                this.C1.setStyle(Paint.Style.FILL_AND_STROKE);
                Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                if (getLayout() != null) {
                    alignment = getLayout().getAlignment();
                }
                StaticLayout staticLayout = new StaticLayout(text, this.C1, measuredWidth, alignment, 1.0f, 0.0f, true);
                this.B1.save();
                this.B1.translate(getPaddingLeft(), ((((measuredHeight - getPaddingTop()) - getPaddingBottom()) - staticLayout.getHeight()) / 2.0f) + getPaddingTop());
                staticLayout.draw(this.B1);
                this.B1.restore();
                this.F1 = false;
            }
            canvas.drawBitmap(this.E1, 0.0f, 0.0f, this.C1);
        }
        if (this.I1 != 0) {
            canvas.save();
            if (this.K1) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            this.D1.setColor(this.I1);
            Layout layout = getLayout();
            if (layout == null) {
                super.onDraw(canvas);
                return;
            }
            RectF[] rectFArr = this.L1;
            if (rectFArr == null || rectFArr.length != layout.getLineCount()) {
                this.L1 = new RectF[layout.getLineCount()];
                this.M1 = true;
            }
            if (this.M1) {
                this.M1 = false;
                for (int i2 = 0; i2 < layout.getLineCount(); i2++) {
                    RectF[] rectFArr2 = this.L1;
                    if (rectFArr2[i2] == null) {
                        rectFArr2[i2] = new RectF();
                    }
                    this.L1[i2].set(layout.getLineLeft(i2), layout.getLineTop(i2), layout.getLineRight(i2), layout.getLineBottom(i2));
                    if (this.L1[i2].width() <= AbstractC21455b.F(1.0f)) {
                        RectF rectF = this.L1[i2];
                        rectF.left = rectF.right;
                    } else if (this.K1) {
                        this.L1[i2].inset((-getTextSize()) / 3.0f, 0.0f);
                        this.L1[i2].top += AbstractC21455b.H(1.2f);
                        this.L1[i2].bottom += AbstractC21455b.H(1.0f);
                        this.L1[i2].left = Math.max(-getPaddingLeft(), this.L1[i2].left);
                        this.L1[i2].right = Math.min(getWidth() - getPaddingLeft(), this.L1[i2].right);
                    } else {
                        this.L1[i2].right += AbstractC21455b.F(32.0f);
                        this.L1[i2].bottom += AbstractC21455b.F(6.0f);
                    }
                    if (i2 > 0) {
                        int i3 = i2 - 1;
                        if (this.L1[i3].width() > 0.0f) {
                            RectF[] rectFArr3 = this.L1;
                            rectFArr3[i3].bottom = rectFArr3[i2].top;
                        }
                    }
                }
            }
            this.J1.rewind();
            float height = getHeight();
            int i4 = 0;
            while (true) {
                RectF[] rectFArr4 = this.L1;
                if (i4 >= rectFArr4.length) {
                    break;
                }
                if (rectFArr4[i4].width() != 0.0f) {
                    RectF rectF2 = this.L1[i4];
                    height = rectF2.bottom - rectF2.top;
                }
                i4++;
            }
            float fMin = Math.min(height / 3.0f, AbstractC21455b.F(16.0f));
            float f = 1.5f * fMin;
            int i5 = 1;
            while (true) {
                RectF[] rectFArr5 = this.L1;
                if (i5 >= rectFArr5.length) {
                    break;
                }
                RectF rectF3 = rectFArr5[i5 - 1];
                RectF rectF4 = rectFArr5[i5];
                if (rectF3.width() >= AbstractC21455b.F(1.0f) && rectF4.width() >= AbstractC21455b.F(1.0f)) {
                    if (Math.abs(rectF3.left - rectF4.left) < f) {
                        float fMin2 = Math.min(rectF4.left, rectF3.left);
                        rectF3.left = fMin2;
                        rectF4.left = fMin2;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (Math.abs(rectF3.right - rectF4.right) < f) {
                        float fMax = Math.max(rectF4.right, rectF3.right);
                        rectF3.right = fMax;
                        rectF4.right = fMax;
                        z = true;
                    }
                    if (z) {
                        for (int i6 = i5; i6 >= 1; i6--) {
                            RectF[] rectFArr6 = this.L1;
                            RectF rectF5 = rectFArr6[i6 - 1];
                            RectF rectF6 = rectFArr6[i6];
                            if (rectF5.width() >= AbstractC21455b.F(1.0f) && rectF6.width() >= AbstractC21455b.F(1.0f)) {
                                if (Math.abs(rectF5.left - rectF6.left) < f) {
                                    float fMin3 = Math.min(rectF6.left, rectF5.left);
                                    rectF5.left = fMin3;
                                    rectF6.left = fMin3;
                                }
                                if (Math.abs(rectF5.right - rectF6.right) < f) {
                                    float fMax2 = Math.max(rectF6.right, rectF5.right);
                                    rectF5.right = fMax2;
                                    rectF6.right = fMax2;
                                }
                            }
                        }
                    }
                }
                i5++;
            }
            while (true) {
                RectF[] rectFArr7 = this.L1;
                if (i >= rectFArr7.length) {
                    break;
                }
                if (rectFArr7[i].width() != 0.0f) {
                    this.J1.addRect(this.L1[i], Path.Direction.CW);
                }
                i++;
            }
            setFrameRoundRadius(fMin);
            canvas.drawPath(this.J1, this.D1);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            this.E1 = null;
            return;
        }
        this.F1 = true;
        this.M1 = true;
        Bitmap bitmap = this.E1;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.E1 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.F1 = true;
        this.M1 = true;
    }

    public void setFrameColor(int i) {
        int i2 = this.I1;
        if (i2 == 0 && i != 0) {
            setPadding(AbstractC21455b.F(19.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(19.0f), AbstractC21455b.F(7.0f));
            setCursorColor(-1);
        } else if (i2 != 0 && i == 0) {
            setPadding(AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f), AbstractC21455b.F(7.0f));
            setCursorColor(-1);
        }
        this.I1 = i;
        if (i != 0) {
            float fZ = AbstractC21455b.z(i);
            if (fZ == 0.0f) {
                fZ = Color.red(this.I1) / 255.0f;
            }
            if (fZ > 0.87d) {
                setTextColor(-16777216);
            } else {
                setTextColor(-1);
            }
            this.M1 = true;
        }
        this.F1 = true;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        super.setGravity(i);
        this.F1 = true;
        this.M1 = true;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.G1 = i;
        this.F1 = true;
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.H1 = f;
        this.F1 = true;
        invalidate();
    }
}
