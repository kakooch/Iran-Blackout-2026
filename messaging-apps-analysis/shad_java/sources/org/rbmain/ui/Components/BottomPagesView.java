package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.viewpager.widget.ViewPager;
import ir.resaneh1.iptv.helper.FlavorHelper;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class BottomPagesView extends View {
    private int colorKey;
    private int currentPage;
    private int pagesCount;
    private Paint paint;
    private float progress;
    private RectF rect;
    private int scrollPosition;
    private int selectedColor;
    private int selectedColorKey;
    private ViewPager viewPager;

    public BottomPagesView(Context context, ViewPager viewPager, int i) {
        super(context);
        this.paint = new Paint(1);
        new DecelerateInterpolator();
        this.rect = new RectF();
        this.colorKey = -1;
        this.selectedColorKey = -1;
        this.selectedColor = -1;
        this.viewPager = viewPager;
        this.pagesCount = i;
    }

    public void setPageOffset(int i, float f) {
        this.progress = f;
        this.scrollPosition = i;
        invalidate();
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
        invalidate();
    }

    public void setColor(int i, int i2) {
        this.colorKey = i;
        this.selectedColorKey = i2;
    }

    public void setColor(int i) {
        this.selectedColor = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        AndroidUtilities.dp(5.0f);
        int i = this.colorKey;
        if (i >= 0) {
            this.paint.setColor((Theme.getColor(i) & 16777215) | (-1275068416));
        } else {
            this.paint.setColor(-4473925);
        }
        this.currentPage = this.viewPager.getCurrentItem();
        for (int i2 = 0; i2 < this.pagesCount; i2++) {
            if (i2 != this.currentPage) {
                this.rect.set(AndroidUtilities.dp(11.0f) * i2, 0.0f, r2 + AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f));
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.5f), AndroidUtilities.dp(2.5f), this.paint);
            }
        }
        int i3 = this.selectedColor;
        if (i3 != -1) {
            this.paint.setColor(i3);
        } else {
            int i4 = this.selectedColorKey;
            if (i4 >= 0) {
                this.paint.setColor(Theme.getColor(i4));
            } else {
                this.paint.setColor(-13851168);
            }
        }
        int iDp = this.currentPage * AndroidUtilities.dp(11.0f);
        if (this.progress != 0.0f) {
            if (this.scrollPosition >= this.currentPage) {
                this.rect.set(iDp, 0.0f, AndroidUtilities.dp(5.0f) + iDp + (AndroidUtilities.dp(11.0f) * this.progress), AndroidUtilities.dp(5.0f));
            } else {
                this.rect.set(iDp - (AndroidUtilities.dp(11.0f) * (1.0f - this.progress)), 0.0f, AndroidUtilities.dp(5.0f) + iDp, AndroidUtilities.dp(5.0f));
            }
        } else {
            this.rect.set(iDp, 0.0f, AndroidUtilities.dp(5.0f) + iDp, AndroidUtilities.dp(5.0f));
        }
        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.5f), AndroidUtilities.dp(2.5f), this.paint);
        if (FlavorHelper.isShad()) {
            this.paint.setColor(-2137029);
            canvas.drawCircle(iDp + AndroidUtilities.dp(2.5f), AndroidUtilities.dp(2.5f), AndroidUtilities.dp(1.0f), this.paint);
        }
    }
}
