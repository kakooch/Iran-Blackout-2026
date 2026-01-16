package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.facebook.stetho.websocket.CloseCodes;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.ShopModels;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;

/* loaded from: classes3.dex */
public class ProductSpan extends View {
    private AvatarDrawable avatarDrawable;
    private int[] colors;
    private Drawable deleteDrawable;
    private boolean deleting;
    private String key;
    private long lastUpdateTime;
    private StaticLayout nameLayout;
    private float progress;
    private RectF rect;
    private int textWidth;
    private float textX;
    private String uid;
    private static TextPaint textPaint = new TextPaint(1);
    private static Paint backPaint = new Paint(1);

    public ProductSpan(Context context, ShopModels.ProductSummaryObject productSummaryObject) {
        int iMin;
        super(context);
        this.rect = new RectF();
        this.colors = new int[8];
        this.uid = productSummaryObject.id;
        this.deleteDrawable = getResources().getDrawable(R.drawable.close_white);
        textPaint.setTextSize(AndroidUtilities.dp(14.0f));
        textPaint.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        this.avatarDrawable = avatarDrawable;
        avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        if (AndroidUtilities.isTablet()) {
            iMin = AndroidUtilities.dp(366.0f) / 2;
        } else {
            Point point = AndroidUtilities.displaySize;
            iMin = (Math.min(point.x, point.y) - AndroidUtilities.dp(164.0f)) / 2;
        }
        StaticLayout staticLayout = new StaticLayout(TextUtils.ellipsize(productSummaryObject.product_name.replace('\n', ' '), textPaint, iMin, TextUtils.TruncateAt.END), textPaint, CloseCodes.NORMAL_CLOSURE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.nameLayout = staticLayout;
        if (staticLayout.getLineCount() > 0) {
            this.textWidth = (int) Math.ceil(this.nameLayout.getLineWidth(0));
            this.textX = -this.nameLayout.getLineLeft(0);
        }
        updateColors();
    }

    public void updateColors() {
        int color = Theme.getColor(Theme.key_avatar_backgroundGroupCreateSpanBlue);
        int color2 = Color.parseColor("#4d0295F7");
        int color3 = Theme.getColor(Theme.key_groupcreate_spanText);
        this.colors[0] = Color.red(color2);
        this.colors[1] = Color.red(color);
        this.colors[2] = Color.green(color2);
        this.colors[3] = Color.green(color);
        this.colors[4] = Color.blue(color2);
        this.colors[5] = Color.blue(color);
        this.colors[6] = Color.alpha(color2);
        this.colors[7] = Color.alpha(color);
        textPaint.setColor(color3);
        this.deleteDrawable.setColorFilter(new PorterDuffColorFilter(color3, PorterDuff.Mode.MULTIPLY));
        backPaint.setColor(color2);
    }

    public boolean isDeleting() {
        return this.deleting;
    }

    public void startDeleteAnimation() {
        if (this.deleting) {
            return;
        }
        this.deleting = true;
        this.lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    public void cancelDeleteAnimation() {
        if (this.deleting) {
            this.deleting = false;
            this.lastUpdateTime = System.currentTimeMillis();
            invalidate();
        }
    }

    public String getUid() {
        return this.uid;
    }

    public String getKey() {
        return this.key;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(AndroidUtilities.dp(57.0f) + this.textWidth, AndroidUtilities.dp(32.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = this.deleting;
        if ((z && this.progress != 1.0f) || (!z && this.progress != 0.0f)) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.lastUpdateTime;
            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 17) {
                jCurrentTimeMillis = 17;
            }
            if (this.deleting) {
                float f = this.progress + (jCurrentTimeMillis / 120.0f);
                this.progress = f;
                if (f >= 1.0f) {
                    this.progress = 1.0f;
                }
            } else {
                float f2 = this.progress - (jCurrentTimeMillis / 120.0f);
                this.progress = f2;
                if (f2 < 0.0f) {
                    this.progress = 0.0f;
                }
            }
            invalidate();
        }
        canvas.save();
        this.rect.set(0.0f, 0.0f, getMeasuredWidth(), AndroidUtilities.dp(32.0f));
        Paint paint = backPaint;
        int[] iArr = this.colors;
        int i = iArr[6];
        float f3 = iArr[7] - iArr[6];
        float f4 = this.progress;
        paint.setColor(Color.argb(i + ((int) (f3 * f4)), iArr[0] + ((int) ((iArr[1] - iArr[0]) * f4)), iArr[2] + ((int) ((iArr[3] - iArr[2]) * f4)), iArr[4] + ((int) ((iArr[5] - iArr[4]) * f4))));
        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), backPaint);
        if (this.progress != 0.0f) {
            backPaint.setColor(this.avatarDrawable.getColor());
            backPaint.setAlpha((int) (this.progress * 255.0f * (Color.alpha(r0) / 255.0f)));
            canvas.drawCircle(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), backPaint);
            canvas.save();
            canvas.rotate((1.0f - this.progress) * 45.0f, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
            this.deleteDrawable.setBounds(AndroidUtilities.dp(9.0f), AndroidUtilities.dp(9.0f), AndroidUtilities.dp(23.0f), AndroidUtilities.dp(23.0f));
            this.deleteDrawable.setAlpha((int) (this.progress * 255.0f));
            this.deleteDrawable.draw(canvas);
            canvas.restore();
        }
        canvas.translate(this.textX + AndroidUtilities.dp(41.0f), AndroidUtilities.dp(8.0f));
        this.nameLayout.draw(canvas);
        canvas.restore();
    }
}
