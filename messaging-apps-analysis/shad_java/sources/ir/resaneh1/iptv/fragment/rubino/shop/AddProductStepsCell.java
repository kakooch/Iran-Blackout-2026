package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class AddProductStepsCell extends LinearLayout {
    private int iconId;
    public int imageSizeInDp;
    ImageView imageView;
    public boolean leftLine;
    public View line;
    public Paint paint;
    public boolean rightLine;
    private int selectedIconId;
    public TextView textView;

    public AddProductStepsCell(Context context) {
        super(context);
        this.imageSizeInDp = 24;
        setWillNotDraw(false);
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        int i = this.imageSizeInDp;
        addView(imageView, LayoutHelper.createFrame(i, i, 1, 0.0f, 8.0f, 0.0f, 8.0f));
        TextView textViewCreateTextView = ViewHelper.createTextView(context, 10, getResources().getColor(R.color.shop_blue), false);
        this.textView = textViewCreateTextView;
        textViewCreateTextView.setText(BuildConfig.FLAVOR);
        this.textView.setMaxLines(1);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity(5);
        addView(this.textView, LayoutHelper.createFrame(-2, -2, 1, 4.0f, 4.0f, 4.0f, 4.0f));
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAlpha(255);
        this.paint.setStrokeWidth(2.0f);
        this.paint.setColor(getContext().getResources().getColor(R.color.grey_400));
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setPathEffect(new DashPathEffect(new float[]{3.0f, 4.0f}, 50.0f));
        View view = new View(context);
        this.line = view;
        view.setBackgroundColor(getResources().getColor(R.color.shop_blue));
        addView(this.line, LayoutHelper.createFrame(-1, AndroidUtilities.dp(1.0f), 80));
    }

    public void setItem(String str, int i, int i2, boolean z, boolean z2) {
        TextView textView = this.textView;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        textView.setText(str);
        this.iconId = i;
        this.selectedIconId = i2;
        this.imageView.setImageResource(i);
        this.leftLine = z;
        this.rightLine = z2;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        if (z) {
            this.textView.setTextColor(getResources().getColor(R.color.shop_blue));
            this.imageView.setImageResource(this.selectedIconId);
        } else {
            this.textView.setTextColor(getResources().getColor(R.color.grey_400));
            this.imageView.setImageResource(this.iconId);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.leftLine) {
            canvas.drawLine(0.0f, (this.imageView.getHeight() / 2.0f) + this.imageView.getTop(), this.imageView.getLeft() - AndroidUtilities.dp(8.0f), (this.imageView.getHeight() / 2.0f) + this.imageView.getTop(), this.paint);
        }
        if (this.rightLine) {
            canvas.drawLine(this.imageView.getRight() + AndroidUtilities.dp(8.0f), (this.imageView.getHeight() / 2.0f) + this.imageView.getTop(), getWidth(), (this.imageView.getHeight() / 2.0f) + this.imageView.getTop(), this.paint);
        }
    }
}
