package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.ResourcesCompat;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.TouchHelper;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class RGHPostTagView extends View {
    private long animationStartTime;
    private RectF backgroundRectangleRect;
    private ClickOnMentionView clickListener;
    private Drawable closeIcon;
    private final int closeIconSize;
    private float currentScale;
    private final String defaultText;
    private Path holderPath;
    private DecelerateInterpolator interpolator;
    private boolean isAnimating;
    private boolean isVisible;
    private String itemDiscountedPrice;
    private String itemPrice;
    private boolean maybeWantToHideCloseIcon;
    private int parentCellHeight;
    private PointingDirection pointingDirection;
    private PostTagObject postTagObject;
    private boolean showCloseIcon;
    private float startX;
    private float startY;
    private PostTagType tagType;
    private TagViewDelegate tagViewDelegate;
    private Paint tagViewPaint;
    private final int textHorizontalPadding;
    private final int textVerticalPadding;
    private StaticLayout titleStaticLayout;
    private String titleText;
    private float titleYPositionInsideTag;
    private int topMargin;
    private boolean touchable;
    private TriangleCoordination triangleCoordination;
    private float triangleHeadXAdjustment;
    private final int triangleHeight;
    private Point trianglePointRelatedToParent;

    public interface ClickOnMentionView {
        void onCancel(View view);

        void onTouch(View view);
    }

    public enum PointingDirection {
        UP,
        DOWN
    }

    public interface TagViewDelegate {
        void onAnimationEnd();
    }

    public int getHorizontalMargin() {
        return 0;
    }

    public void setTrianglePointRelatedToParent(Point point) {
        this.trianglePointRelatedToParent = point;
    }

    public Point getTrianglePointRelatedToParent() {
        return this.trianglePointRelatedToParent;
    }

    public void setTouchable(boolean z) {
        this.touchable = z;
        changeUi(z);
    }

    private void changeUi(boolean z) {
        this.tagViewPaint.setAlpha(z ? 220 : 170);
    }

    public boolean isTouchable() {
        return this.touchable;
    }

    static class TriangleCoordination {
        public Point bottomLeft;
        public Point bottomRight;
        public Point top;

        TriangleCoordination() {
        }

        public void calculatePoints(float f, float f2, float f3, PointingDirection pointingDirection) {
            if (pointingDirection == PointingDirection.DOWN) {
                f3 *= -1.0f;
            }
            float f4 = f2 - f3;
            if (f3 > 0.0f) {
                f2 = Math.max(f4, f);
            } else if (f3 < 0.0f) {
                f2 = Math.min(f4, (f2 * 2.0f) - f);
            }
            Point point = new Point(f2, 0.0f);
            this.top = point;
            this.bottomLeft = new Point(point.x - f, f);
            this.bottomRight = new Point(this.top.x + f, f);
        }
    }

    public int getTriangleHeight() {
        return this.triangleHeight;
    }

    public RGHPostTagView(Context context, PostTagObject postTagObject, int i) {
        super(context);
        this.touchable = true;
        this.defaultText = getContext().getString(R.string.rubinoTagPeople);
        this.closeIconSize = AndroidUtilities.dp(18.0f);
        this.triangleHeight = AndroidUtilities.dp(10.0f);
        this.textHorizontalPadding = AndroidUtilities.dp(10.0f);
        this.textVerticalPadding = AndroidUtilities.dp(10.0f);
        this.postTagObject = postTagObject;
        this.parentCellHeight = i;
        this.tagType = PostTagType.USER;
        updateName();
    }

    public void updateName() {
        String str;
        PostTagObject postTagObject = this.postTagObject;
        if (postTagObject == null) {
            str = this.defaultText;
        } else {
            RubinoProfileObject rubinoProfileObject = postTagObject.profileObject;
            str = rubinoProfileObject != null ? rubinoProfileObject.username : "...";
        }
        init(str);
    }

    public boolean toggleVisibility() {
        if (this.isAnimating) {
            return false;
        }
        if (!this.isVisible) {
            setVisibility(0);
            this.currentScale = 0.0f;
        } else {
            this.currentScale = 1.0f;
        }
        this.isAnimating = true;
        this.animationStartTime = System.currentTimeMillis();
        invalidate();
        return true;
    }

    public void setClickListener(ClickOnMentionView clickOnMentionView) {
        this.clickListener = clickOnMentionView;
    }

    public void setPointingDirection(PointingDirection pointingDirection) {
        this.pointingDirection = pointingDirection;
        requestLayout();
    }

    public void setTriangleHeadXAdjustment(float f) {
        float estimatedWidth = (getEstimatedWidth() / 2.0f) - this.triangleHeight;
        if (Math.abs(f) > estimatedWidth) {
            if (f < 0.0f) {
                estimatedWidth = -estimatedWidth;
            }
            this.triangleHeadXAdjustment = estimatedWidth;
        } else {
            this.triangleHeadXAdjustment = f;
        }
        requestLayout();
    }

    public float getEstimatedWidth() {
        if (this.titleStaticLayout != null) {
            return r0.getWidth() + (this.textHorizontalPadding * 2) + 0;
        }
        return 0.0f;
    }

    public float getEstimatedHeight() {
        if (this.titleStaticLayout != null) {
            return r0.getHeight() + (this.textVerticalPadding * 2) + this.triangleHeight + this.topMargin;
        }
        return 0.0f;
    }

    public void setTagViewDelegate(TagViewDelegate tagViewDelegate) {
        this.tagViewDelegate = tagViewDelegate;
    }

    public PostTagObject getPostTagObject() {
        return this.postTagObject;
    }

    private void init(String str) {
        this.closeIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_circle_close_white, null);
        this.isVisible = false;
        this.currentScale = 0.0f;
        this.pointingDirection = PointingDirection.UP;
        if (str == null) {
            str = this.defaultText;
        }
        this.titleText = str;
        createNameTextStaticLayout();
        CornerPathEffect cornerPathEffect = new CornerPathEffect(AndroidUtilities.dp(4.0f));
        Paint paint = new Paint();
        this.tagViewPaint = paint;
        paint.setAntiAlias(true);
        this.tagViewPaint.setStrokeJoin(Paint.Join.ROUND);
        this.tagViewPaint.setStrokeCap(Paint.Cap.ROUND);
        this.tagViewPaint.setStyle(Paint.Style.FILL);
        this.tagViewPaint.setColor(Theme.getColor(Theme.key_rubino_mentionViewBackground));
        this.tagViewPaint.setAlpha(220);
        this.tagViewPaint.setPathEffect(cornerPathEffect);
        this.interpolator = new DecelerateInterpolator();
        this.backgroundRectangleRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.triangleCoordination = new TriangleCoordination();
        Path path = new Path();
        this.holderPath = path;
        path.setFillType(Path.FillType.WINDING);
        updatePosition();
    }

    private void createNameTextStaticLayout() {
        String str;
        SpannableString spannableString;
        String str2 = this.titleText;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        if (this.tagType == PostTagType.USER) {
            spannableString = new SpannableString(this.titleText);
        } else {
            if (this.itemDiscountedPrice.isEmpty()) {
                str = this.titleText + " " + this.itemPrice + "T >";
            } else {
                str = this.titleText + " " + this.itemDiscountedPrice + "T\n" + this.itemPrice + "T >";
            }
            spannableString = new SpannableString(str);
        }
        PostTagType postTagType = this.tagType;
        PostTagType postTagType2 = PostTagType.SHOP;
        if (postTagType == postTagType2) {
            if (this.itemDiscountedPrice.isEmpty()) {
                spannableString.setSpan(new ForegroundColorSpan(-7829368), this.titleText.length() + 1, spannableString.length(), 33);
            } else {
                spannableString.setSpan(new ForegroundColorSpan(-16776961), this.titleText.length() + 1, this.titleText.length() + this.itemDiscountedPrice.length() + 2, 33);
                spannableString.setSpan(new ForegroundColorSpan(-7829368), this.titleText.length() + this.itemDiscountedPrice.length() + 3, spannableString.length(), 33);
                spannableString.setSpan(new StrikethroughSpan(), this.titleText.length() + this.itemDiscountedPrice.length() + 3, spannableString.length() - 2, 33);
            }
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(AndroidUtilities.density * 12.0f);
        textPaint.setTypeface(Theme.getRubinoTypeFaceMedium());
        textPaint.setColor(-1);
        float fMeasureText = textPaint.measureText(spannableString.toString());
        if (this.tagType == postTagType2 && !this.itemDiscountedPrice.isEmpty()) {
            fMeasureText = textPaint.measureText(this.titleText + this.itemDiscountedPrice + " T");
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.titleStaticLayout = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, (int) fMeasureText).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        } else {
            this.titleStaticLayout = new StaticLayout(spannableString, textPaint, (int) fMeasureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
    }

    private void updateAnimation() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.animationStartTime;
        if (jCurrentTimeMillis <= 200) {
            float f = jCurrentTimeMillis / 200.0f;
            if (this.isVisible) {
                this.currentScale = 1.0f - this.interpolator.getInterpolation(f);
            } else {
                this.currentScale = this.interpolator.getInterpolation(f);
            }
        } else {
            this.isAnimating = false;
            boolean z = !this.isVisible;
            this.isVisible = z;
            if (!z) {
                this.currentScale = 0.0f;
                setVisibility(8);
            } else {
                this.currentScale = 1.0f;
            }
            TagViewDelegate tagViewDelegate = this.tagViewDelegate;
            if (tagViewDelegate != null) {
                tagViewDelegate.onAnimationEnd();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.touchable) {
            this.clickListener.onTouch(this);
            return false;
        }
        Rect bounds = this.closeIcon.getBounds();
        if (motionEvent.getAction() == 0) {
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
            if (this.showCloseIcon && bounds.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.maybeWantToHideCloseIcon = true;
                return true;
            }
            this.clickListener.onTouch(this);
        } else if (motionEvent.getAction() == 1 && TouchHelper.isClick(new Point(this.startX, this.startY), new Point(motionEvent.getX(), motionEvent.getY())) && this.maybeWantToHideCloseIcon) {
            this.clickListener.onCancel(this);
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int height = this.titleStaticLayout.getHeight();
        int width = this.titleStaticLayout.getWidth() + (this.showCloseIcon ? this.closeIconSize + AndroidUtilities.dp(8.0f) : 0) + (this.textHorizontalPadding * 2);
        int i3 = height + (this.textVerticalPadding * 2);
        if (this.pointingDirection == PointingDirection.UP) {
            this.topMargin = Math.max(0, Math.round(this.closeIconSize / 2.0f) - this.triangleHeight);
        } else {
            this.topMargin = Math.round(this.closeIconSize / 2.0f);
        }
        RectF rectF = this.backgroundRectangleRect;
        rectF.left = 0.0f;
        float f = this.triangleHeight + this.topMargin;
        rectF.top = f;
        rectF.right = width + 0.0f;
        float f2 = i3;
        rectF.bottom = f + f2;
        float height2 = ((r5 + r4) + (f2 / 2.0f)) - (this.titleStaticLayout.getHeight() / 2.0f);
        this.titleYPositionInsideTag = height2;
        PointingDirection pointingDirection = this.pointingDirection;
        if (pointingDirection == PointingDirection.DOWN) {
            this.titleYPositionInsideTag = height2 - this.triangleHeight;
        }
        int i4 = width + 0;
        this.triangleCoordination.calculatePoints(this.triangleHeight, i4 / 2.0f, this.triangleHeadXAdjustment, pointingDirection);
        this.holderPath.reset();
        Path path = this.holderPath;
        RectF rectF2 = this.backgroundRectangleRect;
        path.moveTo(rectF2.left, rectF2.top);
        Path path2 = this.holderPath;
        RectF rectF3 = this.backgroundRectangleRect;
        path2.lineTo(rectF3.left, rectF3.bottom);
        Path path3 = this.holderPath;
        RectF rectF4 = this.backgroundRectangleRect;
        path3.lineTo(rectF4.right, rectF4.bottom);
        Path path4 = this.holderPath;
        RectF rectF5 = this.backgroundRectangleRect;
        path4.lineTo(rectF5.right, rectF5.top);
        Path path5 = this.holderPath;
        Point point = this.triangleCoordination.bottomRight;
        path5.lineTo(point.x, point.y + this.topMargin);
        Path path6 = this.holderPath;
        Point point2 = this.triangleCoordination.top;
        path6.lineTo(point2.x, point2.y + this.topMargin);
        Path path7 = this.holderPath;
        Point point3 = this.triangleCoordination.bottomLeft;
        path7.lineTo(point3.x, point3.y + this.topMargin);
        this.holderPath.close();
        setMeasuredDimension(i4, i3 + this.triangleHeight + this.topMargin);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.isAnimating) {
            PointingDirection pointingDirection = this.pointingDirection;
            PointingDirection pointingDirection2 = PointingDirection.UP;
            float height = pointingDirection == pointingDirection2 ? 0.0f : getHeight();
            float width = this.pointingDirection == pointingDirection2 ? this.triangleCoordination.top.x : getWidth() - this.triangleCoordination.top.x;
            float f = this.currentScale;
            canvas.scale(f, f, width, height);
        }
        drawHolderPath(canvas);
        drawText(canvas);
        drawCloseIconIfNeeded(canvas);
        if (this.isAnimating) {
            updateAnimation();
        }
    }

    private void drawHolderPath(Canvas canvas) {
        canvas.save();
        if (this.pointingDirection == PointingDirection.DOWN) {
            canvas.rotate(180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            canvas.translate(0.0f, -this.topMargin);
        }
        canvas.drawPath(this.holderPath, this.tagViewPaint);
        canvas.restore();
    }

    private void drawText(Canvas canvas) {
        if (this.titleStaticLayout != null) {
            canvas.save();
            canvas.translate(this.textHorizontalPadding + this.backgroundRectangleRect.left, this.titleYPositionInsideTag);
            this.titleStaticLayout.draw(canvas);
            canvas.restore();
        }
    }

    public void toggleCloseMode(boolean z) {
        if (this.showCloseIcon == z) {
            return;
        }
        this.showCloseIcon = z;
        requestLayout();
    }

    private void drawCloseIconIfNeeded(Canvas canvas) {
        if (!this.showCloseIcon || this.postTagObject == null) {
            return;
        }
        this.closeIcon.setBounds(((getWidth() - this.closeIconSize) - AndroidUtilities.dp(8.0f)) + 0, ((getHeight() - this.closeIconSize) / 2) + this.topMargin + (this.triangleHeight / 2), (getWidth() - AndroidUtilities.dp(8.0f)) + 0, ((getHeight() + this.closeIconSize) / 2) + this.topMargin + (this.triangleHeight / 2));
        this.closeIcon.draw(canvas);
    }

    public boolean isCloseIconVisible() {
        return this.showCloseIcon;
    }

    private void updatePosition() {
        PostTagObject postTagObject = this.postTagObject;
        if (postTagObject == null || TextUtils.isEmpty(postTagObject.profileId)) {
            return;
        }
        float f = AndroidUtilities.displayMetrics.widthPixels;
        PostTagObject postTagObject2 = this.postTagObject;
        float f2 = f * postTagObject2.xPositionPercent * 1.0f;
        float estimatedHeight = this.parentCellHeight * postTagObject2.yPositionPercent;
        if (getEstimatedHeight() + estimatedHeight > this.parentCellHeight) {
            setPointingDirection(PointingDirection.DOWN);
            estimatedHeight = (this.parentCellHeight - getEstimatedHeight()) - this.triangleHeight;
        }
        float estimatedWidth = 0.0f;
        if (estimatedHeight < 0.0f) {
            estimatedHeight = 0.0f;
        }
        if ((f2 - (getEstimatedWidth() / 2.0f)) - getHorizontalMargin() >= 0.0f) {
            estimatedWidth = (f2 - (getEstimatedWidth() / 2.0f)) - getHorizontalMargin();
            float estimatedWidth2 = getEstimatedWidth() + estimatedWidth;
            int i = AndroidUtilities.displayMetrics.widthPixels;
            if (estimatedWidth2 > i) {
                setTriangleHeadXAdjustment(i - (estimatedWidth + getEstimatedWidth()));
                estimatedWidth = AndroidUtilities.displayMetrics.widthPixels - getEstimatedWidth();
            }
        } else {
            setTriangleHeadXAdjustment((getEstimatedWidth() / 2.0f) - f2);
        }
        setX(estimatedWidth);
        setY(estimatedHeight);
    }
}
