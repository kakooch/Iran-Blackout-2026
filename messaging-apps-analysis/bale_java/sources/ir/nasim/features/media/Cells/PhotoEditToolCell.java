package ir.nasim.features.media.Cells;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;

/* loaded from: classes6.dex */
public class PhotoEditToolCell extends FrameLayout {
    private ImageView a;
    private TextView b;
    private TextView c;

    public PhotoEditToolCell(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.a, C14433hu3.b(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 12.0f));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setGravity(17);
        TextView textView2 = this.b;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView2.setTextColor(c5495Jo7.f0());
        this.b.setTextSize(1, 10.0f);
        this.b.setTypeface(C6011Lu2.k());
        this.b.setMaxLines(1);
        this.b.setSingleLine(true);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.b, C14433hu3.b(-1, -2.0f, 83, 4.0f, 0.0f, 4.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.c = textView3;
        textView3.setTextColor(c5495Jo7.t2());
        this.c.setTextSize(1, 11.0f);
        this.c.setTypeface(C6011Lu2.k());
        addView(this.c, C14433hu3.b(-2, -2.0f, 51, 57.0f, 3.0f, 0.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(86.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(60.0f), 1073741824));
    }

    public void setIconAndTextAndValue(int i, String str, float f) {
        this.a.setImageResource(i);
        this.b.setText(str.toUpperCase());
        if (f == 0.0f) {
            this.c.setText("");
            return;
        }
        if (f > 0.0f) {
            this.c.setText("+" + ((int) f));
            return;
        }
        this.c.setText("" + ((int) f));
    }

    public void setIconAndTextAndValue(int i, String str, String str2) {
        this.a.setImageResource(i);
        this.b.setText(str.toUpperCase());
        this.c.setText(str2);
    }
}
