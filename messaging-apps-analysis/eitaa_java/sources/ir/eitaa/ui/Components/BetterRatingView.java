package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class BetterRatingView extends View {
    private Bitmap filledStar;
    private Bitmap hollowStar;
    private OnRatingChangeListener listener;
    private int numStars;
    private Paint paint;
    private int selectedRating;

    public interface OnRatingChangeListener {
        void onRatingChanged(int newRating);
    }

    public BetterRatingView(Context context) {
        super(context);
        this.paint = new Paint();
        this.numStars = 5;
        this.selectedRating = 0;
        this.filledStar = BitmapFactory.decodeResource(getResources(), R.drawable.ic_rating_star_filled).extractAlpha();
        this.hollowStar = BitmapFactory.decodeResource(getResources(), R.drawable.ic_rating_star).extractAlpha();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((this.numStars * AndroidUtilities.dp(32.0f)) + ((this.numStars - 1) * AndroidUtilities.dp(16.0f)), AndroidUtilities.dp(32.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = 0;
        while (i < this.numStars) {
            this.paint.setColor(Theme.getColor(i < this.selectedRating ? "dialogTextBlue" : "dialogTextHint"));
            canvas.drawBitmap(i < this.selectedRating ? this.filledStar : this.hollowStar, AndroidUtilities.dp(48.0f) * i, 0.0f, this.paint);
            i++;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i;
        float fDp = AndroidUtilities.dp(-8.0f);
        for (int i2 = 0; i2 < this.numStars; i2++) {
            if (event.getX() > fDp && event.getX() < AndroidUtilities.dp(48.0f) + fDp && this.selectedRating != (i = i2 + 1)) {
                this.selectedRating = i;
                OnRatingChangeListener onRatingChangeListener = this.listener;
                if (onRatingChangeListener != null) {
                    onRatingChangeListener.onRatingChanged(i);
                }
                invalidate();
                return true;
            }
            fDp += AndroidUtilities.dp(48.0f);
        }
        return true;
    }

    public int getRating() {
        return this.selectedRating;
    }

    public void setOnRatingChangeListener(OnRatingChangeListener l) {
        this.listener = l;
    }
}
