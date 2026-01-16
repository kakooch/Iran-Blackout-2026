package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: classes3.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int DEFAULT_STYLE = R$style.Widget_MaterialComponents_Badge;
    private static final int DEFAULT_THEME_ATTR = R$attr.badgeStyle;
    private WeakReference<View> anchorViewRef;
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private float badgeRadius;
    private float badgeWidePadding;
    private float badgeWithTextRadius;
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final SavedState savedState;
    private final MaterialShapeDrawable shapeDrawable;
    private final TextDrawableHelper textDrawableHelper;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.badge.BadgeDrawable.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private int additionalHorizontalOffset;
        private int additionalVerticalOffset;
        private int alpha;
        private int backgroundColor;
        private int badgeGravity;
        private int badgeTextColor;
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        private CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private int horizontalOffsetWithText;
        private int horizontalOffsetWithoutText;
        private boolean isVisible;
        private int maxCharacterCount;
        private int number;
        private int verticalOffsetWithText;
        private int verticalOffsetWithoutText;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState(Context context) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new TextAppearance(context, R$style.TextAppearance_MaterialComponents_Badge).getTextColor().getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R$string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R$plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R$string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        protected SavedState(Parcel parcel) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffsetWithoutText = parcel.readInt();
            this.verticalOffsetWithoutText = parcel.readInt();
            this.horizontalOffsetWithText = parcel.readInt();
            this.verticalOffsetWithText = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffsetWithoutText);
            parcel.writeInt(this.verticalOffsetWithoutText);
            parcel.writeInt(this.horizontalOffsetWithText);
            parcel.writeInt(this.verticalOffsetWithText);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }
    }

    public static BadgeDrawable create(Context context) {
        return createFromAttributes(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    private static BadgeDrawable createFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) throws Resources.NotFoundException {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i, i2);
        return badgeDrawable;
    }

    private void loadDefaultStateFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.Badge, i, i2, new int[0]);
        setMaxCharacterCount(typedArrayObtainStyledAttributes.getInt(R$styleable.Badge_maxCharacterCount, 4));
        int i3 = R$styleable.Badge_number;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            setNumber(typedArrayObtainStyledAttributes.getInt(i3, 0));
        }
        setBackgroundColor(readColorFromAttributes(context, typedArrayObtainStyledAttributes, R$styleable.Badge_backgroundColor));
        int i4 = R$styleable.Badge_badgeTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setBadgeTextColor(readColorFromAttributes(context, typedArrayObtainStyledAttributes, i4));
        }
        setBadgeGravity(typedArrayObtainStyledAttributes.getInt(R$styleable.Badge_badgeGravity, 8388661));
        setHorizontalOffsetWithoutText(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0));
        setVerticalOffsetWithoutText(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0));
        setHorizontalOffsetWithText(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_horizontalOffsetWithText, getHorizontalOffsetWithoutText()));
        setVerticalOffsetWithText(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_verticalOffsetWithText, getVerticalOffsetWithoutText()));
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.Badge_badgeRadius)) {
            this.badgeRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(r8, (int) this.badgeRadius);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.Badge_badgeWidePadding)) {
            this.badgeWidePadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(r8, (int) this.badgeWidePadding);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.Badge_badgeWithTextRadius)) {
            this.badgeWithTextRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(r8, (int) this.badgeWithTextRadius);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private static int readColorFromAttributes(Context context, TypedArray typedArray, int i) {
        return MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor();
    }

    private BadgeDrawable(Context context) throws Resources.NotFoundException {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.badgeBounds = new Rect();
        this.shapeDrawable = new MaterialShapeDrawable();
        this.badgeRadius = resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.badgeWidePadding = resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        setTextAppearanceResource(R$style.TextAppearance_MaterialComponents_Badge);
    }

    public void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        boolean z = BadgeUtils.USE_COMPAT_PARENT;
        if (z && frameLayout == null) {
            tryWrapAnchorInCompatParent(view);
        } else {
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
        }
        if (!z) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void tryWrapAnchorInCompatParent(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference == null || weakReference.get() != viewGroup) {
                updateAnchorParentToNotClip(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R$id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.customBadgeParentRef = new WeakReference<>(frameLayout);
                frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BadgeDrawable.this.updateBadgeCoordinates(view, frameLayout);
                    }
                });
            }
        }
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    public void setBackgroundColor(int i) {
        this.savedState.backgroundColor = i;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (this.shapeDrawable.getFillColor() != colorStateListValueOf) {
            this.shapeDrawable.setFillColor(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public void setBadgeTextColor(int i) {
        this.savedState.badgeTextColor = i;
        if (this.textDrawableHelper.getTextPaint().getColor() != i) {
            this.textDrawableHelper.getTextPaint().setColor(i);
            invalidateSelf();
        }
    }

    public boolean hasNumber() {
        return this.savedState.number != -1;
    }

    public int getNumber() {
        if (hasNumber()) {
            return this.savedState.number;
        }
        return 0;
    }

    public void setNumber(int i) throws Resources.NotFoundException {
        int iMax = Math.max(0, i);
        if (this.savedState.number != iMax) {
            this.savedState.number = iMax;
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public int getMaxCharacterCount() {
        return this.savedState.maxCharacterCount;
    }

    public void setMaxCharacterCount(int i) throws Resources.NotFoundException {
        if (this.savedState.maxCharacterCount != i) {
            this.savedState.maxCharacterCount = i;
            updateMaxBadgeNumber();
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setBadgeGravity(int i) {
        if (this.savedState.badgeGravity != i) {
            this.savedState.badgeGravity = i;
            WeakReference<View> weakReference = this.anchorViewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.anchorViewRef.get();
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            updateBadgeCoordinates(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.savedState.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.savedState.alpha = i;
        this.textDrawableHelper.getTextPaint().setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasNumber()) {
            drawText(canvas);
        }
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (hasNumber()) {
            if (this.savedState.contentDescriptionQuantityStrings <= 0 || (context = this.contextRef.get()) == null) {
                return null;
            }
            if (getNumber() <= this.maxBadgeNumber) {
                return context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), Integer.valueOf(getNumber()));
            }
            return context.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(this.maxBadgeNumber));
        }
        return this.savedState.contentDescriptionNumberless;
    }

    public void setHorizontalOffsetWithoutText(int i) throws Resources.NotFoundException {
        this.savedState.horizontalOffsetWithoutText = i;
        updateCenterAndBounds();
    }

    public int getHorizontalOffsetWithoutText() {
        return this.savedState.horizontalOffsetWithoutText;
    }

    public void setHorizontalOffsetWithText(int i) throws Resources.NotFoundException {
        this.savedState.horizontalOffsetWithText = i;
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(int i) throws Resources.NotFoundException {
        this.savedState.verticalOffsetWithoutText = i;
        updateCenterAndBounds();
    }

    public int getVerticalOffsetWithoutText() {
        return this.savedState.verticalOffsetWithoutText;
    }

    public void setVerticalOffsetWithText(int i) throws Resources.NotFoundException {
        this.savedState.verticalOffsetWithText = i;
        updateCenterAndBounds();
    }

    private void setTextAppearanceResource(int i) throws Resources.NotFoundException {
        Context context = this.contextRef.get();
        if (context == null) {
            return;
        }
        setTextAppearance(new TextAppearance(context, i));
    }

    private void setTextAppearance(TextAppearance textAppearance) throws Resources.NotFoundException {
        Context context;
        if (this.textDrawableHelper.getTextAppearance() == textAppearance || (context = this.contextRef.get()) == null) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        updateCenterAndBounds();
    }

    private void updateCenterAndBounds() throws Resources.NotFoundException {
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.badgeBounds);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || BadgeUtils.USE_COMPAT_PARENT) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        calculateCenterAndBounds(context, rect2, view);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        this.shapeDrawable.setCornerSize(this.cornerRadius);
        if (rect.equals(this.badgeBounds)) {
            return;
        }
        this.shapeDrawable.setBounds(this.badgeBounds);
    }

    private int getTotalVerticalOffsetForState() {
        return (hasNumber() ? this.savedState.verticalOffsetWithText : this.savedState.verticalOffsetWithoutText) + this.savedState.additionalVerticalOffset;
    }

    private int getTotalHorizontalOffsetForState() {
        return (hasNumber() ? this.savedState.horizontalOffsetWithText : this.savedState.horizontalOffsetWithoutText) + this.savedState.additionalHorizontalOffset;
    }

    private void calculateCenterAndBounds(Context context, Rect rect, View view) throws Resources.NotFoundException {
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        int i = this.savedState.badgeGravity;
        if (i == 8388691 || i == 8388693) {
            this.badgeCenterY = rect.bottom - totalVerticalOffsetForState;
        } else {
            this.badgeCenterY = rect.top + totalVerticalOffsetForState;
        }
        if (getNumber() <= 9) {
            float f = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
            this.cornerRadius = f;
            this.halfBadgeHeight = f;
            this.halfBadgeWidth = f;
        } else {
            float f2 = this.badgeWithTextRadius;
            this.cornerRadius = f2;
            this.halfBadgeHeight = f2;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        int i2 = this.savedState.badgeGravity;
        if (i2 == 8388659 || i2 == 8388691) {
            this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.halfBadgeWidth) + dimensionPixelSize + totalHorizontalOffsetForState : ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - totalHorizontalOffsetForState;
        } else {
            this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - totalHorizontalOffsetForState : (rect.left - this.halfBadgeWidth) + dimensionPixelSize + totalHorizontalOffsetForState;
        }
    }

    private void drawText(Canvas canvas) {
        Rect rect = new Rect();
        String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + (rect.height() / 2), this.textDrawableHelper.getTextPaint());
    }

    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance().format(getNumber());
        }
        Context context = this.contextRef.get();
        return context == null ? BuildConfig.FLAVOR : context.getString(R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.maxBadgeNumber), "+");
    }

    private void updateMaxBadgeNumber() {
        Double.isNaN(getMaxCharacterCount());
        this.maxBadgeNumber = ((int) Math.pow(10.0d, r0 - 1.0d)) - 1;
    }
}
