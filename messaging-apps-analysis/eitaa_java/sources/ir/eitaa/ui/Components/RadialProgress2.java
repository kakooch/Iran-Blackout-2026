package ir.eitaa.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.MediaActionDrawable;
import java.util.Locale;

/* loaded from: classes3.dex */
public class RadialProgress2 {
    private int backgroundStroke;
    private float circleCheckProgress;
    private int circleColor;
    private String circleColorKey;
    private String circleCrossfadeColorKey;
    private float circleCrossfadeColorProgress;
    private Paint circleMiniPaint;
    private Paint circlePaint;
    private int circlePressedColor;
    private String circlePressedColorKey;
    private int circleRadius;
    private boolean drawBackground;
    private boolean drawMiniIcon;
    private int iconColor;
    private String iconColorKey;
    private int iconPressedColor;
    private String iconPressedColorKey;
    private boolean isPressed;
    private boolean isPressedMini;
    private MediaActionDrawable mediaActionDrawable;
    private Bitmap miniDrawBitmap;
    private Canvas miniDrawCanvas;
    private float miniIconScale;
    private MediaActionDrawable miniMediaActionDrawable;
    private Paint miniProgressBackgroundPaint;
    private ImageReceiver overlayImageView;
    private Paint overlayPaint;
    private float overrideAlpha;
    private View parent;
    private int progressColor;
    private RectF progressRect;
    private final Theme.ResourcesProvider resourcesProvider;

    public RadialProgress2(View parentView) {
        this(parentView, null);
    }

    public RadialProgress2(final View parentView, Theme.ResourcesProvider resourcesProvider) {
        this.progressRect = new RectF();
        this.progressColor = -1;
        this.overlayPaint = new Paint(1);
        this.circlePaint = new Paint(1);
        this.circleMiniPaint = new Paint(1);
        this.miniIconScale = 1.0f;
        this.circleCheckProgress = 1.0f;
        this.drawBackground = true;
        this.overrideAlpha = 1.0f;
        this.resourcesProvider = resourcesProvider;
        this.miniProgressBackgroundPaint = new Paint(1);
        this.parent = parentView;
        ImageReceiver imageReceiver = new ImageReceiver(parentView);
        this.overlayImageView = imageReceiver;
        imageReceiver.setInvalidateAll(true);
        MediaActionDrawable mediaActionDrawable = new MediaActionDrawable();
        this.mediaActionDrawable = mediaActionDrawable;
        parentView.getClass();
        mediaActionDrawable.setDelegate(new MediaActionDrawable.MediaActionDrawableDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$X0au712Asf7jBztzpjk4Pj-8mII
            @Override // ir.eitaa.ui.Components.MediaActionDrawable.MediaActionDrawableDelegate
            public final void invalidate() {
                parentView.invalidate();
            }
        });
        MediaActionDrawable mediaActionDrawable2 = new MediaActionDrawable();
        this.miniMediaActionDrawable = mediaActionDrawable2;
        mediaActionDrawable2.setDelegate(new MediaActionDrawable.MediaActionDrawableDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$X0au712Asf7jBztzpjk4Pj-8mII
            @Override // ir.eitaa.ui.Components.MediaActionDrawable.MediaActionDrawableDelegate
            public final void invalidate() {
                parentView.invalidate();
            }
        });
        this.miniMediaActionDrawable.setMini(true);
        this.miniMediaActionDrawable.setIcon(4, false);
        int iDp = AndroidUtilities.dp(22.0f);
        this.circleRadius = iDp;
        this.overlayImageView.setRoundRadius(iDp);
        this.overlayPaint.setColor(1677721600);
    }

    public void setAsMini() {
        this.mediaActionDrawable.setMini(true);
    }

    public void setCircleRadius(int value) {
        this.circleRadius = value;
        this.overlayImageView.setRoundRadius(value);
    }

    public void setBackgroundDrawable(Theme.MessageDrawable drawable) {
        this.mediaActionDrawable.setBackgroundDrawable(drawable);
        this.miniMediaActionDrawable.setBackgroundDrawable(drawable);
    }

    public void setBackgroundGradientDrawable(LinearGradient drawable) {
        this.mediaActionDrawable.setBackgroundGradientDrawable(drawable);
        this.miniMediaActionDrawable.setBackgroundGradientDrawable(drawable);
    }

    public void setImageOverlay(TLRPC$PhotoSize image, TLRPC$Document document, Object parentObject) {
        this.overlayImageView.setImage(ImageLocation.getForDocument(image, document), String.format(Locale.US, "%d_%d", Integer.valueOf(this.circleRadius * 2), Integer.valueOf(this.circleRadius * 2)), null, null, parentObject, 1);
    }

    public void setImageOverlay(String url) {
        this.overlayImageView.setImage(url, url != null ? String.format(Locale.US, "%d_%d", Integer.valueOf(this.circleRadius * 2), Integer.valueOf(this.circleRadius * 2)) : null, (Drawable) null, (String) null, -1);
    }

    public void onAttachedToWindow() {
        this.overlayImageView.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.overlayImageView.onDetachedFromWindow();
    }

    public void setColors(int circle, int circlePressed, int icon, int iconPressed) {
        this.circleColor = circle;
        this.circlePressedColor = circlePressed;
        this.iconColor = icon;
        this.iconPressedColor = iconPressed;
        this.circleColorKey = null;
        this.circlePressedColorKey = null;
        this.iconColorKey = null;
        this.iconPressedColorKey = null;
    }

    public void setColors(String circle, String circlePressed, String icon, String iconPressed) {
        this.circleColorKey = circle;
        this.circlePressedColorKey = circlePressed;
        this.iconColorKey = icon;
        this.iconPressedColorKey = iconPressed;
    }

    public void setCircleCrossfadeColor(String color, float progress, float checkProgress) {
        this.circleCrossfadeColorKey = color;
        this.circleCrossfadeColorProgress = progress;
        this.circleCheckProgress = checkProgress;
        this.miniIconScale = 1.0f;
        if (color != null) {
            initMiniIcons();
        }
    }

    public void setDrawBackground(boolean value) {
        this.drawBackground = value;
    }

    public void setProgressRect(int left, int top, int right, int bottom) {
        this.progressRect.set(left, top, right, bottom);
    }

    public RectF getProgressRect() {
        return this.progressRect;
    }

    public void setProgressColor(int color) {
        this.progressColor = color;
    }

    public void setMiniProgressBackgroundColor(int color) {
        this.miniProgressBackgroundPaint.setColor(color);
    }

    public void setProgress(float value, boolean animated) {
        if (this.drawMiniIcon) {
            this.miniMediaActionDrawable.setProgress(value, animated);
        } else {
            this.mediaActionDrawable.setProgress(value, animated);
        }
    }

    public float getProgress() {
        return (this.drawMiniIcon ? this.miniMediaActionDrawable : this.mediaActionDrawable).getProgress();
    }

    private void invalidateParent() {
        int iDp = AndroidUtilities.dp(2.0f);
        View view = this.parent;
        RectF rectF = this.progressRect;
        int i = ((int) rectF.left) - iDp;
        int i2 = ((int) rectF.top) - iDp;
        int i3 = iDp * 2;
        view.invalidate(i, i2, ((int) rectF.right) + i3, ((int) rectF.bottom) + i3);
    }

    public int getIcon() {
        return this.mediaActionDrawable.getCurrentIcon();
    }

    public int getMiniIcon() {
        return this.miniMediaActionDrawable.getCurrentIcon();
    }

    public void setIcon(int icon, boolean ifSame, boolean animated) {
        if (ifSame && icon == this.mediaActionDrawable.getCurrentIcon()) {
            return;
        }
        this.mediaActionDrawable.setIcon(icon, animated);
        if (!animated) {
            this.parent.invalidate();
        } else {
            invalidateParent();
        }
    }

    public void setMiniIconScale(float scale) {
        this.miniIconScale = scale;
    }

    public void setMiniIcon(int icon, boolean ifSame, boolean animated) {
        if (icon == 2 || icon == 3 || icon == 4) {
            if (ifSame && icon == this.miniMediaActionDrawable.getCurrentIcon()) {
                return;
            }
            this.miniMediaActionDrawable.setIcon(icon, animated);
            boolean z = icon != 4 || this.miniMediaActionDrawable.getTransitionProgress() < 1.0f;
            this.drawMiniIcon = z;
            if (z) {
                initMiniIcons();
            }
            if (!animated) {
                this.parent.invalidate();
            } else {
                invalidateParent();
            }
        }
    }

    public void initMiniIcons() {
        if (this.miniDrawBitmap == null) {
            try {
                this.miniDrawBitmap = Bitmap.createBitmap(AndroidUtilities.dp(48.0f), AndroidUtilities.dp(48.0f), Bitmap.Config.ARGB_8888);
                this.miniDrawCanvas = new Canvas(this.miniDrawBitmap);
            } catch (Throwable unused) {
            }
        }
    }

    public void setPressed(boolean value, boolean mini) {
        if (mini) {
            this.isPressedMini = value;
        } else {
            this.isPressed = value;
        }
        invalidateParent();
    }

    public void setOverrideAlpha(float alpha) {
        this.overrideAlpha = alpha;
    }

    public float getOverrideAlpha() {
        return this.overrideAlpha;
    }

    public void draw(Canvas canvas) {
        float transitionProgress;
        float transitionProgress2;
        int themedColor;
        int iCeil;
        int iCeil2;
        boolean z;
        int iSave;
        int i;
        float fCenterX;
        float fCenterY;
        float transitionProgress3;
        int iSave2;
        Canvas canvas2;
        Canvas canvas3;
        Canvas canvas4;
        int iArgb;
        if ((this.mediaActionDrawable.getCurrentIcon() != 4 || this.mediaActionDrawable.getTransitionProgress() < 1.0f) && !this.progressRect.isEmpty()) {
            int currentIcon = this.mediaActionDrawable.getCurrentIcon();
            int previousIcon = this.mediaActionDrawable.getPreviousIcon();
            if (this.backgroundStroke != 0) {
                if (currentIcon == 3) {
                    transitionProgress2 = this.mediaActionDrawable.getTransitionProgress();
                    transitionProgress = 1.0f - transitionProgress2;
                } else {
                    transitionProgress = previousIcon == 3 ? this.mediaActionDrawable.getTransitionProgress() : 1.0f;
                }
            } else if ((currentIcon == 3 || currentIcon == 6 || currentIcon == 10 || currentIcon == 8 || currentIcon == 0) && previousIcon == 4) {
                transitionProgress = this.mediaActionDrawable.getTransitionProgress();
            } else {
                if (currentIcon == 4) {
                    transitionProgress2 = this.mediaActionDrawable.getTransitionProgress();
                    transitionProgress = 1.0f - transitionProgress2;
                }
            }
            if (this.isPressedMini && this.circleCrossfadeColorKey == null) {
                String str = this.iconPressedColorKey;
                if (str != null) {
                    this.miniMediaActionDrawable.setColor(getThemedColor(str));
                } else {
                    this.miniMediaActionDrawable.setColor(this.iconPressedColor);
                }
                String str2 = this.circlePressedColorKey;
                if (str2 != null) {
                    this.circleMiniPaint.setColor(getThemedColor(str2));
                } else {
                    this.circleMiniPaint.setColor(this.circlePressedColor);
                }
            } else {
                String str3 = this.iconColorKey;
                if (str3 != null) {
                    this.miniMediaActionDrawable.setColor(getThemedColor(str3));
                } else {
                    this.miniMediaActionDrawable.setColor(this.iconColor);
                }
                String str4 = this.circleColorKey;
                if (str4 != null) {
                    if (this.circleCrossfadeColorKey != null) {
                        this.circleMiniPaint.setColor(AndroidUtilities.getOffsetColor(getThemedColor(str4), getThemedColor(this.circleCrossfadeColorKey), this.circleCrossfadeColorProgress, this.circleCheckProgress));
                    } else {
                        this.circleMiniPaint.setColor(getThemedColor(str4));
                    }
                } else {
                    this.circleMiniPaint.setColor(this.circleColor);
                }
            }
            if (this.isPressed) {
                String str5 = this.iconPressedColorKey;
                if (str5 != null) {
                    MediaActionDrawable mediaActionDrawable = this.mediaActionDrawable;
                    themedColor = getThemedColor(str5);
                    mediaActionDrawable.setColor(themedColor);
                    this.mediaActionDrawable.setBackColor(getThemedColor(this.circlePressedColorKey));
                } else {
                    MediaActionDrawable mediaActionDrawable2 = this.mediaActionDrawable;
                    int i2 = this.iconPressedColor;
                    mediaActionDrawable2.setColor(i2);
                    this.mediaActionDrawable.setBackColor(this.circlePressedColor);
                    themedColor = i2;
                }
                String str6 = this.circlePressedColorKey;
                if (str6 != null) {
                    this.circlePaint.setColor(getThemedColor(str6));
                } else {
                    this.circlePaint.setColor(this.circlePressedColor);
                }
            } else {
                String str7 = this.iconColorKey;
                if (str7 != null) {
                    MediaActionDrawable mediaActionDrawable3 = this.mediaActionDrawable;
                    themedColor = getThemedColor(str7);
                    mediaActionDrawable3.setColor(themedColor);
                    this.mediaActionDrawable.setBackColor(getThemedColor(this.circleColorKey));
                } else {
                    MediaActionDrawable mediaActionDrawable4 = this.mediaActionDrawable;
                    int i3 = this.iconColor;
                    mediaActionDrawable4.setColor(i3);
                    this.mediaActionDrawable.setBackColor(this.circleColor);
                    themedColor = i3;
                }
                String str8 = this.circleColorKey;
                if (str8 != null) {
                    this.circlePaint.setColor(getThemedColor(str8));
                } else {
                    this.circlePaint.setColor(this.circleColor);
                }
            }
            if ((this.drawMiniIcon || this.circleCrossfadeColorKey != null) && this.miniDrawCanvas != null) {
                this.miniDrawBitmap.eraseColor(0);
            }
            this.circlePaint.setAlpha((int) (this.circlePaint.getAlpha() * transitionProgress * this.overrideAlpha));
            this.circleMiniPaint.setAlpha((int) (this.circleMiniPaint.getAlpha() * transitionProgress * this.overrideAlpha));
            if ((this.drawMiniIcon || this.circleCrossfadeColorKey != null) && this.miniDrawCanvas != null) {
                iCeil = (int) Math.ceil(this.progressRect.width() / 2.0f);
                iCeil2 = (int) Math.ceil(this.progressRect.height() / 2.0f);
            } else {
                iCeil = (int) this.progressRect.centerX();
                iCeil2 = (int) this.progressRect.centerY();
            }
            int i4 = 2;
            if (this.overlayImageView.hasBitmapImage()) {
                float currentAlpha = this.overlayImageView.getCurrentAlpha();
                this.overlayPaint.setAlpha((int) (100.0f * currentAlpha * transitionProgress * this.overrideAlpha));
                if (currentAlpha >= 1.0f) {
                    iArgb = -1;
                    z = false;
                } else {
                    int iRed = Color.red(themedColor);
                    int iGreen = Color.green(themedColor);
                    int iBlue = Color.blue(themedColor);
                    iArgb = Color.argb(Color.alpha(themedColor) + ((int) ((255 - r6) * currentAlpha)), iRed + ((int) ((255 - iRed) * currentAlpha)), iGreen + ((int) ((255 - iGreen) * currentAlpha)), iBlue + ((int) ((255 - iBlue) * currentAlpha)));
                    z = true;
                }
                this.mediaActionDrawable.setColor(iArgb);
                ImageReceiver imageReceiver = this.overlayImageView;
                int i5 = this.circleRadius;
                imageReceiver.setImageCoords(iCeil - i5, iCeil2 - i5, i5 * 2, i5 * 2);
            } else {
                z = true;
            }
            Canvas canvas5 = this.miniDrawCanvas;
            if (canvas5 == null || this.circleCrossfadeColorKey == null || this.circleCheckProgress == 1.0f) {
                iSave = Integer.MIN_VALUE;
            } else {
                iSave = canvas5.save();
                float f = 1.0f - ((1.0f - this.circleCheckProgress) * 0.1f);
                this.miniDrawCanvas.scale(f, f, iCeil, iCeil2);
            }
            if (z && this.drawBackground) {
                if ((this.drawMiniIcon || this.circleCrossfadeColorKey != null) && (canvas4 = this.miniDrawCanvas) != null) {
                    canvas4.drawCircle(iCeil, iCeil2, this.circleRadius, this.circlePaint);
                } else if (currentIcon != 4 || transitionProgress != 0.0f) {
                    if (this.backgroundStroke != 0) {
                        canvas.drawCircle(iCeil, iCeil2, this.circleRadius - AndroidUtilities.dp(3.5f), this.circlePaint);
                    } else {
                        canvas.drawCircle(iCeil, iCeil2, this.circleRadius * transitionProgress, this.circlePaint);
                    }
                }
            }
            if (this.overlayImageView.hasBitmapImage()) {
                this.overlayImageView.setAlpha(transitionProgress * this.overrideAlpha);
                if ((this.drawMiniIcon || this.circleCrossfadeColorKey != null) && (canvas3 = this.miniDrawCanvas) != null) {
                    this.overlayImageView.draw(canvas3);
                    this.miniDrawCanvas.drawCircle(iCeil, iCeil2, this.circleRadius, this.overlayPaint);
                } else {
                    this.overlayImageView.draw(canvas);
                    canvas.drawCircle(iCeil, iCeil2, this.circleRadius, this.overlayPaint);
                }
            }
            MediaActionDrawable mediaActionDrawable5 = this.mediaActionDrawable;
            int i6 = this.circleRadius;
            mediaActionDrawable5.setBounds(iCeil - i6, iCeil2 - i6, iCeil + i6, iCeil2 + i6);
            this.mediaActionDrawable.setHasOverlayImage(this.overlayImageView.hasBitmapImage());
            if (this.drawMiniIcon || this.circleCrossfadeColorKey != null) {
                Canvas canvas6 = this.miniDrawCanvas;
                if (canvas6 != null) {
                    this.mediaActionDrawable.draw(canvas6);
                } else {
                    this.mediaActionDrawable.draw(canvas);
                }
            } else {
                this.mediaActionDrawable.setOverrideAlpha(this.overrideAlpha);
                this.mediaActionDrawable.draw(canvas);
            }
            if (iSave != Integer.MIN_VALUE && (canvas2 = this.miniDrawCanvas) != null) {
                canvas2.restoreToCount(iSave);
            }
            if (this.drawMiniIcon || this.circleCrossfadeColorKey != null) {
                if (Math.abs(this.progressRect.width() - AndroidUtilities.dp(44.0f)) < AndroidUtilities.density) {
                    i = 20;
                    float f2 = 16;
                    fCenterX = this.progressRect.centerX() + AndroidUtilities.dp(f2);
                    fCenterY = this.progressRect.centerY() + AndroidUtilities.dp(f2);
                    i4 = 0;
                } else {
                    i = 22;
                    fCenterX = this.progressRect.centerX() + AndroidUtilities.dp(18.0f);
                    fCenterY = this.progressRect.centerY() + AndroidUtilities.dp(18.0f);
                }
                int i7 = i / 2;
                if (this.drawMiniIcon) {
                    transitionProgress3 = this.miniMediaActionDrawable.getCurrentIcon() != 4 ? 1.0f : 1.0f - this.miniMediaActionDrawable.getTransitionProgress();
                    if (transitionProgress3 == 0.0f) {
                        this.drawMiniIcon = false;
                    }
                } else {
                    transitionProgress3 = 1.0f;
                }
                Canvas canvas7 = this.miniDrawCanvas;
                if (canvas7 != null) {
                    float f3 = i + 18 + i4;
                    canvas7.drawCircle(AndroidUtilities.dp(f3), AndroidUtilities.dp(f3), AndroidUtilities.dp(i7 + 1) * transitionProgress3 * this.miniIconScale, Theme.checkboxSquare_eraserPaint);
                } else {
                    this.miniProgressBackgroundPaint.setColor(this.progressColor);
                    canvas.drawCircle(fCenterX, fCenterY, AndroidUtilities.dp(12.0f), this.miniProgressBackgroundPaint);
                }
                if (this.miniDrawCanvas != null) {
                    Bitmap bitmap = this.miniDrawBitmap;
                    RectF rectF = this.progressRect;
                    canvas.drawBitmap(bitmap, (int) rectF.left, (int) rectF.top, (Paint) null);
                }
                if (this.miniIconScale < 1.0f) {
                    iSave2 = canvas.save();
                    float f4 = this.miniIconScale;
                    canvas.scale(f4, f4, fCenterX, fCenterY);
                } else {
                    iSave2 = Integer.MIN_VALUE;
                }
                float f5 = i7;
                canvas.drawCircle(fCenterX, fCenterY, (AndroidUtilities.dp(f5) * transitionProgress3) + (AndroidUtilities.dp(1.0f) * (1.0f - this.circleCheckProgress)), this.circleMiniPaint);
                if (this.drawMiniIcon) {
                    this.miniMediaActionDrawable.setBounds((int) (fCenterX - (AndroidUtilities.dp(f5) * transitionProgress3)), (int) (fCenterY - (AndroidUtilities.dp(f5) * transitionProgress3)), (int) (fCenterX + (AndroidUtilities.dp(f5) * transitionProgress3)), (int) (fCenterY + (AndroidUtilities.dp(f5) * transitionProgress3)));
                    this.miniMediaActionDrawable.draw(canvas);
                }
                if (iSave2 != Integer.MIN_VALUE) {
                    canvas.restoreToCount(iSave2);
                }
            }
        }
    }

    public String getCircleColorKey() {
        return this.circleColorKey;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
