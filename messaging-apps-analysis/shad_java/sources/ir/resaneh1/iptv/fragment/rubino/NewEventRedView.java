package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class NewEventRedView extends View {
    int currnetAccount;
    private Drawable drawableBackground;
    private Rect drawableBoundBackGround;
    private Rect drawableBoundLike;
    private Rect drawableBoundRequest;
    private Rect drawableBoundTriangle;
    private Drawable drawableLike;
    private Drawable drawableRequest;
    private int drawableSize;
    private Drawable drawableTriangle;
    private int height;
    private int paddingRightAndLeft;
    private int paddingTextIcon;
    private int paddingTop;
    public StaticLayout staticLayoutLike;
    public StaticLayout staticLayoutRequest;
    private TextPaint textPaint;
    private int triangleH;
    private int triangleW;

    public NewEventRedView(Context context) {
        super(context);
        this.currnetAccount = UserConfig.selectedAccount;
        setWillNotDraw(false);
        this.drawableTriangle = context.getResources().getDrawable(R.drawable.rubino_red_triangle).mutate();
        this.drawableBackground = context.getResources().getDrawable(R.drawable.rubino_like_red_background).mutate();
        this.drawableLike = context.getResources().getDrawable(R.drawable.rubino_notification_like_icon).mutate();
        this.drawableRequest = context.getResources().getDrawable(R.drawable.rubino_notification_people_icon).mutate();
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(11.0f));
        this.textPaint.setTypeface(Theme.getRubinoTypeFaceBold());
        this.textPaint.setColor(-1);
        this.triangleW = AndroidUtilities.dp(12.0f);
        this.triangleH = AndroidUtilities.dp(8.0f);
        this.drawableBoundBackGround = new Rect(0, this.triangleH, 0, 0);
        this.drawableBoundTriangle = new Rect(0, AndroidUtilities.dp(2.0f), this.triangleW, this.triangleH + AndroidUtilities.dp(2.0f));
        this.height = AndroidUtilities.dp(38.0f);
        this.paddingRightAndLeft = AndroidUtilities.dp(12.0f);
        this.paddingTextIcon = AndroidUtilities.dp(4.0f);
        int iDp = AndroidUtilities.dp(14.0f);
        this.drawableSize = iDp;
        this.paddingTop = (this.height - iDp) / 2;
        int i = this.paddingRightAndLeft;
        int i2 = this.paddingTop;
        int i3 = this.drawableSize;
        this.drawableBoundLike = new Rect(i, i2, i + i3, i3 + i2);
        int i4 = this.paddingRightAndLeft;
        int i5 = this.paddingTop;
        int i6 = this.drawableSize;
        this.drawableBoundRequest = new Rect(i4, i5, i4 + i6, i6 + i5);
        setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventRedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoController.openNewEventActivity(NewEventRedView.this.currnetAccount);
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.drawableBoundBackGround.right = getCalculatedWidth();
        this.drawableBoundBackGround.bottom = this.height + this.triangleH;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getCalculatedWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.height + this.triangleH, 1073741824));
    }

    public int getCalculatedWidth() {
        int width;
        int width2 = this.paddingRightAndLeft;
        StaticLayout staticLayout = this.staticLayoutLike;
        int iDp = 0;
        if (staticLayout != null) {
            width2 = width2 + this.drawableSize + this.paddingTextIcon + staticLayout.getWidth() + this.paddingRightAndLeft;
            iDp = AndroidUtilities.dp(12.0f);
            width = width2;
        } else {
            width = 0;
        }
        StaticLayout staticLayout2 = this.staticLayoutRequest;
        if (staticLayout2 != null) {
            int i = width2 + iDp;
            Rect rect = this.drawableBoundRequest;
            rect.left = i;
            int i2 = this.drawableSize;
            rect.right = i + i2;
            width = this.paddingRightAndLeft + i + i2 + this.paddingTextIcon + staticLayout2.getWidth();
        }
        return Math.max(AndroidUtilities.dp(10.0f), width);
    }

    public void setText(String str, String str2, int i) {
        if (str == null || str.isEmpty()) {
            this.staticLayoutLike = null;
        } else {
            this.staticLayoutLike = new StaticLayout(str, this.textPaint, (int) this.textPaint.measureText(str), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        if (str2 == null || str2.isEmpty()) {
            this.staticLayoutRequest = null;
        } else {
            this.staticLayoutRequest = new StaticLayout(str2, this.textPaint, (int) this.textPaint.measureText(str2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        if (getCalculatedWidth() / 2 < i) {
            this.drawableBoundTriangle.left = (int) ((r11 - this.triangleW) / 2.0f);
        } else {
            this.drawableBoundTriangle.left = (int) ((r11 - i) - (this.triangleW / 2.0f));
        }
        Rect rect = this.drawableBoundTriangle;
        rect.right = rect.left + this.triangleW;
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.drawableBackground.setBounds(this.drawableBoundBackGround);
        this.drawableBackground.draw(canvas);
        this.drawableTriangle.setBounds(this.drawableBoundTriangle);
        this.drawableTriangle.draw(canvas);
        canvas.save();
        canvas.translate(0.0f, this.triangleH);
        if (this.staticLayoutLike != null) {
            this.drawableLike.setBounds(this.drawableBoundLike);
            this.drawableLike.draw(canvas);
            canvas.save();
            canvas.translate(this.drawableBoundLike.right + this.paddingTextIcon, this.paddingTop + AndroidUtilities.dp(1.0f));
            this.staticLayoutLike.draw(canvas);
            canvas.restore();
        }
        if (this.staticLayoutRequest != null) {
            this.drawableRequest.setBounds(this.drawableBoundRequest);
            this.drawableRequest.draw(canvas);
            canvas.save();
            canvas.translate(this.drawableBoundRequest.right + this.paddingTextIcon, this.paddingTop + AndroidUtilities.dp(1.0f));
            this.staticLayoutRequest.draw(canvas);
            canvas.restore();
        }
        canvas.restore();
    }
}
