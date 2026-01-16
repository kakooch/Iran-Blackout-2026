package org.rbmain.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.MediaActionDrawable;

/* loaded from: classes5.dex */
public class RadialProgress2 {
    private int backgroundStroke;
    private float circleCheckProgress;
    private int circleColor;
    private int circleColorKey;
    private int circleCrossfadeColorKey;
    private float circleCrossfadeColorProgress;
    private Paint circleMiniPaint;
    private Paint circlePaint;
    private int circlePressedColor;
    private int circlePressedColorKey;
    private int circleRadius;
    private boolean drawBackground;
    private boolean drawMiniIcon;
    private int iconColor;
    private int iconColorKey;
    private int iconPressedColor;
    private int iconPressedColorKey;
    private boolean isPressed;
    private boolean isPressedMini;
    private int maxIconSize;
    private MediaActionDrawable mediaActionDrawable;
    private Bitmap miniDrawBitmap;
    private Canvas miniDrawCanvas;
    private float miniIconScale;
    private MediaActionDrawable miniMediaActionDrawable;
    private Paint miniProgressBackgroundPaint;
    private float overlayImageAlpha;
    private ImageReceiver overlayImageView;
    private Paint overlayPaint;
    private float overrideAlpha;
    public float overrideCircleAlpha;
    private View parent;
    private int progressColor;
    private RectF progressRect;
    private Theme.ResourcesProvider resourcesProvider;

    public RadialProgress2(View view) {
        this(view, null);
    }

    public RadialProgress2(final View view, Theme.ResourcesProvider resourcesProvider) {
        this.progressRect = new RectF();
        this.progressColor = -1;
        this.overlayPaint = new Paint(1);
        this.circlePaint = new Paint(1);
        this.circleMiniPaint = new Paint(1);
        this.miniIconScale = 1.0f;
        this.circleColorKey = -1;
        this.circleCrossfadeColorKey = -1;
        this.circleCheckProgress = 1.0f;
        this.circlePressedColorKey = -1;
        this.iconColorKey = -1;
        this.iconPressedColorKey = -1;
        this.overrideCircleAlpha = 1.0f;
        this.drawBackground = true;
        this.overrideAlpha = 1.0f;
        this.overlayImageAlpha = 1.0f;
        this.resourcesProvider = resourcesProvider;
        this.miniProgressBackgroundPaint = new Paint(1);
        this.parent = view;
        ImageReceiver imageReceiver = new ImageReceiver(view);
        this.overlayImageView = imageReceiver;
        imageReceiver.setInvalidateAll(true);
        MediaActionDrawable mediaActionDrawable = new MediaActionDrawable();
        this.mediaActionDrawable = mediaActionDrawable;
        view.getClass();
        mediaActionDrawable.setDelegate(new MediaActionDrawable.MediaActionDrawableDelegate() { // from class: org.rbmain.ui.Components.RadialProgress2$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.MediaActionDrawable.MediaActionDrawableDelegate
            public final void invalidate() {
                view.invalidate();
            }
        });
        MediaActionDrawable mediaActionDrawable2 = new MediaActionDrawable();
        this.miniMediaActionDrawable = mediaActionDrawable2;
        mediaActionDrawable2.setDelegate(new MediaActionDrawable.MediaActionDrawableDelegate() { // from class: org.rbmain.ui.Components.RadialProgress2$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.MediaActionDrawable.MediaActionDrawableDelegate
            public final void invalidate() {
                view.invalidate();
            }
        });
        this.miniMediaActionDrawable.setMini(true);
        this.miniMediaActionDrawable.setIcon(4, false);
        int iDp = AndroidUtilities.dp(22.0f);
        this.circleRadius = iDp;
        this.overlayImageView.setRoundRadius(iDp);
        this.overlayPaint.setColor(1677721600);
    }

    public void setCircleRadius(int i) {
        this.circleRadius = i;
        this.overlayImageView.setRoundRadius(i);
    }

    public int getRadius() {
        return this.circleRadius;
    }

    public void setBackgroundDrawable(Theme.MessageDrawable messageDrawable) {
        this.mediaActionDrawable.setBackgroundDrawable(messageDrawable);
        this.miniMediaActionDrawable.setBackgroundDrawable(messageDrawable);
    }

    public void setImageOverlay(TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$Document tLRPC$Document, Object obj) {
        this.overlayImageView.setImage(ImageLocation.getForDocument(tLRPC$PhotoSize, tLRPC$Document), String.format(Locale.US, "%d_%d", Integer.valueOf(this.circleRadius * 2), Integer.valueOf(this.circleRadius * 2)), null, null, obj, 1);
    }

    public void setImageOverlay(String str) {
        this.overlayImageView.setImage(str, str != null ? String.format(Locale.US, "%d_%d", Integer.valueOf(this.circleRadius * 2), Integer.valueOf(this.circleRadius * 2)) : null, (Drawable) null, (String) null, -1L);
    }

    public void onAttachedToWindow() {
        this.overlayImageView.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.overlayImageView.onDetachedFromWindow();
    }

    public void setColorKeys(int i, int i2, int i3, int i4) {
        this.circleColorKey = i;
        this.circlePressedColorKey = i2;
        this.iconColorKey = i3;
        this.iconPressedColorKey = i4;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.circleColor = i;
        this.circlePressedColor = i2;
        this.iconColor = i3;
        this.iconPressedColor = i4;
        this.circleColorKey = -1;
        this.circlePressedColorKey = -1;
        this.iconColorKey = -1;
        this.iconPressedColorKey = -1;
    }

    public void setCircleCrossfadeColor(int i, float f, float f2) {
        this.circleCrossfadeColorKey = i;
        this.circleCrossfadeColorProgress = f;
        this.circleCheckProgress = f2;
        this.miniIconScale = 1.0f;
        if (i >= 0) {
            initMiniIcons();
        }
    }

    public void setDrawBackground(boolean z) {
        this.drawBackground = z;
    }

    public void setProgressRect(int i, int i2, int i3, int i4) {
        this.progressRect.set(i, i2, i3, i4);
    }

    public void setProgressRect(float f, float f2, float f3, float f4) {
        this.progressRect.set(f, f2, f3, f4);
    }

    public RectF getProgressRect() {
        return this.progressRect;
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
    }

    public void setMiniProgressBackgroundColor(int i) {
        this.miniProgressBackgroundPaint.setColor(i);
    }

    public void setProgress(float f, boolean z) {
        if (this.drawMiniIcon) {
            this.miniMediaActionDrawable.setProgress(f, z);
        } else {
            this.mediaActionDrawable.setProgress(f, z);
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

    public void setIcon(int i, boolean z, boolean z2) {
        if (z && i == this.mediaActionDrawable.getCurrentIcon()) {
            return;
        }
        this.mediaActionDrawable.setIcon(i, z2);
        if (!z2) {
            this.parent.invalidate();
        } else {
            invalidateParent();
        }
    }

    public void setMiniIconScale(float f) {
        this.miniIconScale = f;
    }

    public void setMiniIcon(int i, boolean z, boolean z2) {
        if (i == 2 || i == 3 || i == 4) {
            if (z && i == this.miniMediaActionDrawable.getCurrentIcon()) {
                return;
            }
            this.miniMediaActionDrawable.setIcon(i, z2);
            boolean z3 = i != 4 || this.miniMediaActionDrawable.getTransitionProgress() < 1.0f;
            this.drawMiniIcon = z3;
            if (z3) {
                initMiniIcons();
            }
            if (!z2) {
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

    public void setPressed(boolean z, boolean z2) {
        if (z2) {
            this.isPressedMini = z;
        } else {
            this.isPressed = z;
        }
        invalidateParent();
    }

    public void setOverrideAlpha(float f) {
        this.overrideAlpha = f;
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
            if (this.isPressedMini && this.circleCrossfadeColorKey < 0) {
                int i2 = this.iconPressedColorKey;
                if (i2 >= 0) {
                    this.miniMediaActionDrawable.setColor(getThemedColor(i2));
                } else {
                    this.miniMediaActionDrawable.setColor(this.iconPressedColor);
                }
                int i3 = this.circlePressedColorKey;
                if (i3 >= 0) {
                    this.circleMiniPaint.setColor(getThemedColor(i3));
                } else {
                    this.circleMiniPaint.setColor(this.circlePressedColor);
                }
            } else {
                int i4 = this.iconColorKey;
                if (i4 >= 0) {
                    this.miniMediaActionDrawable.setColor(getThemedColor(i4));
                } else {
                    this.miniMediaActionDrawable.setColor(this.iconColor);
                }
                int i5 = this.circleColorKey;
                if (i5 >= 0) {
                    if (this.circleCrossfadeColorKey >= 0) {
                        this.circleMiniPaint.setColor(AndroidUtilities.getOffsetColor(getThemedColor(i5), getThemedColor(this.circleCrossfadeColorKey), this.circleCrossfadeColorProgress, this.circleCheckProgress));
                    } else {
                        this.circleMiniPaint.setColor(getThemedColor(i5));
                    }
                } else {
                    this.circleMiniPaint.setColor(this.circleColor);
                }
            }
            if (this.isPressed) {
                int i6 = this.iconPressedColorKey;
                if (i6 >= 0) {
                    MediaActionDrawable mediaActionDrawable = this.mediaActionDrawable;
                    themedColor = getThemedColor(i6);
                    mediaActionDrawable.setColor(themedColor);
                    this.mediaActionDrawable.setBackColor(getThemedColor(this.circlePressedColorKey));
                } else {
                    MediaActionDrawable mediaActionDrawable2 = this.mediaActionDrawable;
                    int i7 = this.iconPressedColor;
                    mediaActionDrawable2.setColor(i7);
                    this.mediaActionDrawable.setBackColor(this.circlePressedColor);
                    themedColor = i7;
                }
                int i8 = this.circlePressedColorKey;
                if (i8 >= 0) {
                    this.circlePaint.setColor(getThemedColor(i8));
                } else {
                    this.circlePaint.setColor(this.circlePressedColor);
                }
            } else {
                int i9 = this.iconColorKey;
                if (i9 >= 0) {
                    MediaActionDrawable mediaActionDrawable3 = this.mediaActionDrawable;
                    themedColor = getThemedColor(i9);
                    mediaActionDrawable3.setColor(themedColor);
                    this.mediaActionDrawable.setBackColor(getThemedColor(this.circleColorKey));
                } else {
                    MediaActionDrawable mediaActionDrawable4 = this.mediaActionDrawable;
                    int i10 = this.iconColor;
                    mediaActionDrawable4.setColor(i10);
                    this.mediaActionDrawable.setBackColor(this.circleColor);
                    themedColor = i10;
                }
                int i11 = this.circleColorKey;
                if (i11 >= 0) {
                    this.circlePaint.setColor(getThemedColor(i11));
                } else {
                    this.circlePaint.setColor(this.circleColor);
                }
            }
            if ((this.drawMiniIcon || this.circleCrossfadeColorKey >= 0) && this.miniDrawCanvas != null) {
                this.miniDrawBitmap.eraseColor(0);
            }
            this.circlePaint.setAlpha((int) (this.circlePaint.getAlpha() * transitionProgress * this.overrideAlpha * this.overrideCircleAlpha));
            this.circleMiniPaint.setAlpha((int) (this.circleMiniPaint.getAlpha() * transitionProgress * this.overrideAlpha));
            if ((this.drawMiniIcon || this.circleCrossfadeColorKey >= 0) && this.miniDrawCanvas != null) {
                iCeil = (int) Math.ceil(this.progressRect.width() / 2.0f);
                iCeil2 = (int) Math.ceil(this.progressRect.height() / 2.0f);
            } else {
                iCeil = (int) this.progressRect.centerX();
                iCeil2 = (int) this.progressRect.centerY();
            }
            int i12 = 2;
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
                int i13 = this.circleRadius;
                imageReceiver.setImageCoords(iCeil - i13, iCeil2 - i13, i13 * 2, i13 * 2);
            } else {
                z = true;
            }
            Canvas canvas5 = this.miniDrawCanvas;
            if (canvas5 == null || this.circleCrossfadeColorKey < 0 || this.circleCheckProgress == 1.0f) {
                iSave = Integer.MIN_VALUE;
            } else {
                iSave = canvas5.save();
                float f = 1.0f - ((1.0f - this.circleCheckProgress) * 0.1f);
                this.miniDrawCanvas.scale(f, f, iCeil, iCeil2);
            }
            if (z && this.drawBackground) {
                if ((this.drawMiniIcon || this.circleCrossfadeColorKey >= 0) && (canvas4 = this.miniDrawCanvas) != null) {
                    canvas4.drawCircle(iCeil, iCeil2, this.circleRadius, this.circlePaint);
                } else if (currentIcon != 4 || transitionProgress != 0.0f) {
                    if (this.backgroundStroke != 0) {
                        canvas.drawCircle(iCeil, iCeil2, this.circleRadius - AndroidUtilities.dp(3.5f), this.circlePaint);
                    } else {
                        canvas.drawCircle(iCeil, iCeil2, this.circleRadius, this.circlePaint);
                    }
                }
            }
            if (this.overlayImageView.hasBitmapImage()) {
                this.overlayImageView.setAlpha(transitionProgress * this.overrideAlpha * this.overlayImageAlpha);
                if ((this.drawMiniIcon || this.circleCrossfadeColorKey >= 0) && (canvas3 = this.miniDrawCanvas) != null) {
                    this.overlayImageView.draw(canvas3);
                    this.miniDrawCanvas.drawCircle(iCeil, iCeil2, this.circleRadius, this.overlayPaint);
                } else {
                    this.overlayImageView.draw(canvas);
                    canvas.drawCircle(iCeil, iCeil2, this.circleRadius, this.overlayPaint);
                }
            }
            int i14 = this.circleRadius;
            int i15 = this.maxIconSize;
            if (i15 > 0 && i14 > i15) {
                i14 = i15;
            }
            this.mediaActionDrawable.setBounds(iCeil - i14, iCeil2 - i14, iCeil + i14, iCeil2 + i14);
            this.mediaActionDrawable.setHasOverlayImage(this.overlayImageView.hasBitmapImage());
            if (this.drawMiniIcon || this.circleCrossfadeColorKey >= 0) {
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
            if (this.drawMiniIcon || this.circleCrossfadeColorKey >= 0) {
                if (Math.abs(this.progressRect.width() - AndroidUtilities.dp(44.0f)) < AndroidUtilities.density) {
                    i = 20;
                    float f2 = 16;
                    fCenterX = this.progressRect.centerX() + AndroidUtilities.dp(f2);
                    fCenterY = this.progressRect.centerY() + AndroidUtilities.dp(f2);
                    i12 = 0;
                } else {
                    i = 22;
                    fCenterX = this.progressRect.centerX() + AndroidUtilities.dp(18.0f);
                    fCenterY = this.progressRect.centerY() + AndroidUtilities.dp(18.0f);
                }
                int i16 = i / 2;
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
                    float f3 = i + 18 + i12;
                    canvas7.drawCircle(AndroidUtilities.dp(f3), AndroidUtilities.dp(f3), AndroidUtilities.dp(i16 + 1) * transitionProgress3 * this.miniIconScale, Theme.checkboxSquare_eraserPaint);
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
                float f5 = i16;
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

    public int getCircleColorKey() {
        return this.circleColorKey;
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i, this.resourcesProvider);
    }

    public void setMaxIconSize(int i) {
        this.maxIconSize = i;
    }

    public float getTransitionProgress() {
        return (this.drawMiniIcon ? this.miniMediaActionDrawable : this.mediaActionDrawable).getTransitionProgress();
    }
}
