package ir.nasim.features.conversation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC19981rG5;
import ir.nasim.C22078ud6;
import ir.nasim.C23880xg2;
import ir.nasim.C24967zW1;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.EnumC5425Jh0;
import ir.nasim.JF5;
import ir.nasim.QI2;

/* loaded from: classes5.dex */
public class QuoteMessageView extends RelativeLayout {
    private int a;
    private ImageView b;
    private TextView c;
    private TextView d;

    public QuoteMessageView(Context context) {
        super(context);
        this.a = C5495Jo7.a.t2();
        setWillNotDraw(false);
        a(context);
    }

    private void a(Context context) {
        setGravity(16);
        ImageView imageView = new ImageView(context);
        this.b = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.b.setId(b() + AbstractC19981rG5.b(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C22078ud6.a(36.0f), C22078ud6.a(36.0f));
        layoutParams.addRule(JF5.g() ? 11 : 9);
        addView(this.b, layoutParams);
        TextView textView = new TextView(context);
        this.c = textView;
        textView.setTextSize(1, 14.0f);
        this.c.setTypeface(C6011Lu2.k());
        this.c.setTextColor(this.a);
        TextView textView2 = this.c;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        this.c.setLines(1);
        this.c.setId(b() + AbstractC19981rG5.b(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(!JF5.g() ? 1 : 0, this.b.getId());
        JF5.l(layoutParams2, C22078ud6.a(3.0f));
        addView(this.c, layoutParams2);
        TextView textView3 = new TextView(context);
        this.d = textView3;
        textView3.setTextColor(C5495Jo7.a.o0());
        this.d.setTypeface(C6011Lu2.k());
        this.d.setTextSize(1, 12.0f);
        this.d.setMaxLines(1);
        this.d.setEllipsize(truncateAt);
        this.d.setId(b() + AbstractC19981rG5.b(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(!JF5.g() ? 1 : 0, this.b.getId());
        layoutParams3.setMargins(0, C22078ud6.a(20.0f), 0, 0);
        JF5.l(layoutParams3, C22078ud6.a(3.0f));
        addView(this.d, layoutParams3);
    }

    private int b() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.a);
        paint.setStrokeWidth(C22078ud6.a(2.0f));
        paint.setAntiAlias(true);
        return paint;
    }

    public String getQuoteText() {
        return this.d.getText().toString();
    }

    public TextView getTvSender() {
        return this.c;
    }

    public TextView getTvText() {
        return this.d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float width = JF5.g() ? (getWidth() - getPaddingRight()) + C22078ud6.a(4.0f) : getPaddingLeft() - C22078ud6.a(4.0f);
        canvas.drawLine(width, getHeight(), width, getPaddingTop(), getPaint());
        super.onDraw(canvas);
    }

    public void setImageQuote(C24967zW1 c24967zW1) {
        new C23880xg2(this.b, EnumC5425Jh0.BITMAP_BLUR, c24967zW1);
    }

    public void setImageVisibility(int i) {
        this.b.setVisibility(i);
    }

    public void setQuoteText(String str) {
        this.d.setText(str);
    }

    public void setQuoteTextVisibility(int i) {
        this.d.setVisibility(i);
    }

    public void setSender(CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    public void setSenderColor(int i) {
        this.a = i;
        this.c.setTextColor(i);
        invalidate();
    }

    public void setStoryImageQuote(String str) {
        QI2.n(str, this.b);
    }

    public void setQuoteText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    public QuoteMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = C5495Jo7.a.t2();
        setWillNotDraw(false);
        a(context);
    }

    public QuoteMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = C5495Jo7.a.t2();
        setWillNotDraw(false);
        a(context);
    }
}
