package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class BottomPagesView extends View {
    private String colorKey;
    private int currentPage;
    private DecelerateInterpolator decelerateInterpolator;
    private int pagesCount;
    private Paint paint;
    private float progress;
    private RectF rect;
    private int scrollPosition;
    private String selectedColorKey;
    private ViewPager viewPager;

    public BottomPagesView(Context context, ViewPager pager, int count) {
        super(context);
        this.paint = new Paint(1);
        this.decelerateInterpolator = new DecelerateInterpolator();
        this.rect = new RectF();
        this.viewPager = pager;
        this.pagesCount = count;
    }

    public void setPageOffset(int position, float offset) {
        this.progress = offset;
        this.scrollPosition = position;
        invalidate();
    }

    public void setCurrentPage(int page) {
        this.currentPage = page;
        invalidate();
    }

    public void setColor(String key, String selectedKey) {
        this.colorKey = key;
        this.selectedColorKey = selectedKey;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        AndroidUtilities.dp(5.0f);
        String str = this.colorKey;
        if (str != null) {
            this.paint.setColor((Theme.getColor(str) & 16777215) | (-1275068416));
        } else {
            this.paint.setColor(-4473925);
        }
        this.currentPage = this.viewPager.getCurrentItem();
        for (int i = 0; i < this.pagesCount; i++) {
            if (i != this.currentPage) {
                this.rect.set(AndroidUtilities.dp(11.0f) * i, 0.0f, r2 + AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f));
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.5f), AndroidUtilities.dp(2.5f), this.paint);
            }
        }
        String str2 = this.selectedColorKey;
        if (str2 != null) {
            this.paint.setColor(Theme.getColor(str2));
        } else {
            this.paint.setColor(-13851168);
        }
        int iDp = this.currentPage * AndroidUtilities.dp(11.0f);
        if (this.progress != 0.0f) {
            if (this.scrollPosition >= this.currentPage) {
                this.rect.set(iDp, 0.0f, iDp + AndroidUtilities.dp(5.0f) + (AndroidUtilities.dp(11.0f) * this.progress), AndroidUtilities.dp(5.0f));
            } else {
                this.rect.set(iDp - (AndroidUtilities.dp(11.0f) * (1.0f - this.progress)), 0.0f, iDp + AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f));
            }
        } else {
            this.rect.set(iDp, 0.0f, iDp + AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f));
        }
        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.5f), AndroidUtilities.dp(2.5f), this.paint);
    }
}
