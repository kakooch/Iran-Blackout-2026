package ir.nasim.features.media.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.JF5;
import ir.nasim.features.media.components.CheckBoxSquare;

/* loaded from: classes6.dex */
public class CheckBoxCell extends FrameLayout {
    private static Paint e;
    private TextView a;
    private TextView b;
    private CheckBoxSquare c;
    private boolean d;

    public CheckBoxCell(Context context) {
        super(context);
        TextView textView = new TextView(context);
        this.a = textView;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.g0());
        this.a.setTextSize(1, 16.0f);
        this.a.setLines(1);
        this.a.setMaxLines(1);
        this.a.setSingleLine(true);
        TextView textView2 = this.a;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        this.a.setTypeface(C6011Lu2.k());
        this.a.setGravity((JF5.g() ? 5 : 3) | 16);
        addView(this.a, C14433hu3.b(-1, -1.0f, (JF5.g() ? 5 : 3) | 16, JF5.g() ? 17 : 46, 0.0f, JF5.g() ? 46 : 17, 0.0f));
        TextView textView3 = new TextView(context);
        this.b = textView3;
        textView3.setTextColor(c5495Jo7.t2());
        this.b.setTextSize(1, 16.0f);
        this.b.setLines(1);
        this.b.setMaxLines(1);
        this.b.setSingleLine(true);
        this.b.setEllipsize(truncateAt);
        this.b.setGravity((JF5.g() ? 3 : 5) | 16);
        addView(this.b, C14433hu3.b(-2, -1.0f, (JF5.g() ? 3 : 5) | 16, 17.0f, 0.0f, 17.0f, 0.0f));
        CheckBoxSquare checkBoxSquare = new CheckBoxSquare(context);
        this.c = checkBoxSquare;
        addView(checkBoxSquare, C14433hu3.b(18, 18.0f, (JF5.g() ? 5 : 3) | 16, JF5.g() ? 0 : 17, 0.0f, JF5.g() ? 17 : 0, 0.0f));
    }

    private Paint getDividerPaint() {
        if (e == null) {
            Paint paint = new Paint();
            e = paint;
            paint.setStrokeWidth(1.0f);
            e.setColor(C5495Jo7.a.n0());
        }
        return e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.d) {
            canvas.drawLine(getPaddingLeft(), getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, getDividerPaint());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), AbstractC7426Rr.z(48.0f) + (this.d ? 1 : 0));
        int measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - AbstractC7426Rr.z(34.0f);
        this.b.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth / 2, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.a.measure(View.MeasureSpec.makeMeasureSpec((measuredWidth - this.b.getMeasuredWidth()) - AbstractC7426Rr.z(8.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.c.measure(View.MeasureSpec.makeMeasureSpec(AbstractC7426Rr.z(18.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC7426Rr.z(18.0f), 1073741824));
    }

    public void setCheckBoxContentDescription(String str) {
        CheckBoxSquare checkBoxSquare = this.c;
        if (checkBoxSquare != null) {
            checkBoxSquare.setContentDescription(str);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        this.c.setChecked(z, z2);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.a.setAlpha(z ? 1.0f : 0.5f);
        this.b.setAlpha(z ? 1.0f : 0.5f);
        this.c.setAlpha(z ? 1.0f : 0.5f);
    }

    public void setText(String str, String str2, boolean z, boolean z2) {
        this.a.setText(str);
        this.c.setChecked(z, false);
        this.b.setText(str2);
        this.d = z2;
        setWillNotDraw(!z2);
    }
}
