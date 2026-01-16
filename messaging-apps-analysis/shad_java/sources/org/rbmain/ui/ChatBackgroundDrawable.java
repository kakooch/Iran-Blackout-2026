package org.rbmain.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.Arrays;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.tgnet.ResultCallback;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$WallPaper;
import org.rbmain.tgnet.TLRPC$WallPaperSettings;
import org.rbmain.ui.ActionBar.EmojiThemes;
import org.rbmain.ui.Components.BackgroundGradientDrawable;
import org.rbmain.ui.Components.MotionBackgroundDrawable;

/* loaded from: classes4.dex */
public class ChatBackgroundDrawable extends Drawable {
    int alpha = 255;
    boolean attached;
    private boolean colorFilterSetted;
    float dimAmount;
    ImageReceiver imageReceiver;
    boolean isPattern;
    MotionBackgroundDrawable motionBackgroundDrawable;
    View parent;
    private final boolean themeIsDark;
    final TLRPC$WallPaper wallpaper;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static Drawable getOrCreate(Drawable drawable, TLRPC$WallPaper tLRPC$WallPaper, boolean z) {
        TLRPC$WallPaperSettings tLRPC$WallPaperSettings;
        TLRPC$WallPaperSettings tLRPC$WallPaperSettings2;
        if (drawable instanceof ChatBackgroundDrawable) {
            ChatBackgroundDrawable chatBackgroundDrawable = (ChatBackgroundDrawable) drawable;
            String str = tLRPC$WallPaper.uploadingImage;
            if (str != null) {
                if (str.equals(chatBackgroundDrawable.wallpaper.uploadingImage) && ((tLRPC$WallPaperSettings2 = tLRPC$WallPaper.settings) == null || chatBackgroundDrawable.wallpaper.settings == null || tLRPC$WallPaperSettings2.intensity <= 0 || chatBackgroundDrawable.themeIsDark == z)) {
                    return chatBackgroundDrawable;
                }
            } else if (tLRPC$WallPaper.id == chatBackgroundDrawable.wallpaper.id && TextUtils.equals(hash(tLRPC$WallPaper.settings), hash(chatBackgroundDrawable.wallpaper.settings)) && (tLRPC$WallPaper.document == null || tLRPC$WallPaper.pattern || (tLRPC$WallPaperSettings = tLRPC$WallPaper.settings) == null || tLRPC$WallPaperSettings.intensity <= 0 || chatBackgroundDrawable.themeIsDark == z)) {
                return chatBackgroundDrawable;
            }
        }
        return new ChatBackgroundDrawable(tLRPC$WallPaper, z, false);
    }

    public void setParent(View view) {
        this.parent = view;
        MotionBackgroundDrawable motionBackgroundDrawable = this.motionBackgroundDrawable;
        if (motionBackgroundDrawable != null) {
            motionBackgroundDrawable.setParentView(view);
        }
    }

    public ChatBackgroundDrawable(final TLRPC$WallPaper tLRPC$WallPaper, boolean z, boolean z2) {
        TLRPC$WallPaperSettings tLRPC$WallPaperSettings;
        String str;
        TLRPC$WallPaperSettings tLRPC$WallPaperSettings2;
        ImageReceiver imageReceiver = new ImageReceiver() { // from class: org.rbmain.ui.ChatBackgroundDrawable.1
            @Override // org.rbmain.messenger.ImageReceiver
            public void invalidate() {
                View view = ChatBackgroundDrawable.this.parent;
                if (view != null) {
                    view.invalidate();
                }
            }
        };
        this.imageReceiver = imageReceiver;
        imageReceiver.setInvalidateAll(true);
        boolean z3 = tLRPC$WallPaper.pattern;
        this.isPattern = z3;
        this.wallpaper = tLRPC$WallPaper;
        this.themeIsDark = z;
        if (z && ((tLRPC$WallPaper.document != null || tLRPC$WallPaper.uploadingImage != null) && !z3 && (tLRPC$WallPaperSettings2 = tLRPC$WallPaper.settings) != null)) {
            this.dimAmount = tLRPC$WallPaperSettings2.intensity / 100.0f;
        }
        if ((z3 || tLRPC$WallPaper.document == null) && (tLRPC$WallPaperSettings = tLRPC$WallPaper.settings) != null && tLRPC$WallPaperSettings.second_background_color != 0 && tLRPC$WallPaperSettings.third_background_color != 0) {
            MotionBackgroundDrawable motionBackgroundDrawable = new MotionBackgroundDrawable();
            this.motionBackgroundDrawable = motionBackgroundDrawable;
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings3 = tLRPC$WallPaper.settings;
            motionBackgroundDrawable.setColors(tLRPC$WallPaperSettings3.background_color, tLRPC$WallPaperSettings3.second_background_color, tLRPC$WallPaperSettings3.third_background_color, tLRPC$WallPaperSettings3.fourth_background_color);
            EmojiThemes.loadWallpaperImage(tLRPC$WallPaper.id, tLRPC$WallPaper, new ResultCallback() { // from class: org.rbmain.ui.ChatBackgroundDrawable$$ExternalSyntheticLambda0
                @Override // org.rbmain.tgnet.ResultCallback
                public final void onComplete(Object obj) {
                    this.f$0.lambda$new$0(tLRPC$WallPaper, (Pair) obj);
                }

                @Override // org.rbmain.tgnet.ResultCallback
                public /* synthetic */ void onError(TLRPC$TL_error tLRPC$TL_error) {
                    ResultCallback.CC.$default$onError(this, tLRPC$TL_error);
                }
            });
            return;
        }
        Point point = AndroidUtilities.displaySize;
        int iMin = Math.min(point.x, point.y);
        Point point2 = AndroidUtilities.displaySize;
        int iMax = Math.max(point2.x, point2.y);
        if (z2) {
            str = "150_150_wallpaper";
        } else {
            str = ((int) (iMin / AndroidUtilities.density)) + "_" + ((int) (iMax / AndroidUtilities.density)) + "_wallpaper";
        }
        String str2 = (str + tLRPC$WallPaper.id) + hash(tLRPC$WallPaper.settings);
        Drawable drawableCreateThumb = createThumb(tLRPC$WallPaper);
        String str3 = tLRPC$WallPaper.uploadingImage;
        if (str3 != null) {
            this.imageReceiver.setImage(ImageLocation.getForPath(str3), str2, drawableCreateThumb, null, tLRPC$WallPaper, 1);
            return;
        }
        TLRPC$Document tLRPC$Document = tLRPC$WallPaper.document;
        if (tLRPC$Document != null) {
            this.imageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), str2, drawableCreateThumb, null, tLRPC$WallPaper, 1);
        } else {
            this.imageReceiver.setImageBitmap(drawableCreateThumb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(TLRPC$WallPaper tLRPC$WallPaper, Pair pair) {
        this.motionBackgroundDrawable.setPatternBitmap(tLRPC$WallPaper.settings.intensity, (Bitmap) pair.second);
        View view = this.parent;
        if (view != null) {
            view.invalidate();
        }
    }

    public static Drawable createThumb(TLRPC$WallPaper tLRPC$WallPaper) {
        if (tLRPC$WallPaper.stripedThumb != null) {
            return new BitmapDrawable(tLRPC$WallPaper.stripedThumb);
        }
        if (tLRPC$WallPaper.pattern && tLRPC$WallPaper.settings == null) {
            return new ColorDrawable(-16777216);
        }
        if (tLRPC$WallPaper.document != null) {
            BitmapDrawable bitmapDrawable = null;
            while (alphaComponent < tLRPC$WallPaper.document.thumbs.size()) {
                if (tLRPC$WallPaper.document.thumbs.get(alphaComponent) instanceof TLRPC$TL_photoStrippedSize) {
                    bitmapDrawable = new BitmapDrawable(ImageLoader.getStrippedPhotoBitmap(tLRPC$WallPaper.document.thumbs.get(alphaComponent).bytes, "b"));
                }
                alphaComponent++;
            }
            return bitmapDrawable;
        }
        TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$WallPaper.settings;
        if (tLRPC$WallPaperSettings.intensity < 0) {
            return bitmapDrawableOf(new ColorDrawable(-16777216));
        }
        if (tLRPC$WallPaperSettings.second_background_color == 0) {
            return bitmapDrawableOf(new ColorDrawable(ColorUtils.setAlphaComponent(tLRPC$WallPaper.settings.background_color, 255)));
        }
        if (tLRPC$WallPaperSettings.third_background_color == 0) {
            return bitmapDrawableOf(new GradientDrawable(BackgroundGradientDrawable.getGradientOrientation(tLRPC$WallPaper.settings.rotation), new int[]{ColorUtils.setAlphaComponent(tLRPC$WallPaperSettings.background_color, 255), ColorUtils.setAlphaComponent(tLRPC$WallPaper.settings.second_background_color, 255)}));
        }
        int alphaComponent = ColorUtils.setAlphaComponent(tLRPC$WallPaperSettings.background_color, 255);
        int alphaComponent2 = ColorUtils.setAlphaComponent(tLRPC$WallPaper.settings.second_background_color, 255);
        int alphaComponent3 = ColorUtils.setAlphaComponent(tLRPC$WallPaper.settings.third_background_color, 255);
        int i = tLRPC$WallPaper.settings.fourth_background_color;
        alphaComponent = i != 0 ? ColorUtils.setAlphaComponent(i, 255) : 0;
        MotionBackgroundDrawable motionBackgroundDrawable = new MotionBackgroundDrawable();
        motionBackgroundDrawable.setColors(alphaComponent, alphaComponent2, alphaComponent3, alphaComponent);
        return new BitmapDrawable(motionBackgroundDrawable.getBitmap());
    }

    private static Drawable bitmapDrawableOf(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(20, 20, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, 20, 20);
        drawable.draw(canvas);
        return new BitmapDrawable(bitmapCreateBitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        MotionBackgroundDrawable motionBackgroundDrawable = this.motionBackgroundDrawable;
        if (motionBackgroundDrawable != null) {
            motionBackgroundDrawable.setBounds(getBounds());
            this.motionBackgroundDrawable.setAlpha(this.alpha);
            this.motionBackgroundDrawable.draw(canvas);
            return;
        }
        boolean z = false;
        if (!this.imageReceiver.hasImageLoaded() || this.imageReceiver.getCurrentAlpha() != 1.0f) {
            z = true;
        } else if (!this.colorFilterSetted) {
            this.colorFilterSetted = true;
            this.imageReceiver.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(-16777216, (int) (this.dimAmount * 255.0f)), PorterDuff.Mode.DARKEN));
        }
        this.imageReceiver.setImageCoords(getBounds());
        this.imageReceiver.setAlpha(this.alpha / 255.0f);
        this.imageReceiver.draw(canvas);
        if (z) {
            float f = this.dimAmount;
            if (f != 0.0f) {
                canvas.drawColor(ColorUtils.setAlphaComponent(-16777216, (int) (f * 255.0f)));
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public void onAttachedToWindow() {
        if (this.attached) {
            return;
        }
        this.attached = true;
        this.imageReceiver.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        if (this.attached) {
            this.attached = false;
            this.imageReceiver.onDetachedFromWindow();
        }
    }

    public Drawable getDrawable() {
        MotionBackgroundDrawable motionBackgroundDrawable = this.motionBackgroundDrawable;
        if (motionBackgroundDrawable != null) {
            return motionBackgroundDrawable;
        }
        if (this.imageReceiver.getStaticThumb() != null) {
            return this.imageReceiver.getStaticThumb();
        }
        if (this.imageReceiver.getThumb() != null) {
            return this.imageReceiver.getThumb();
        }
        return this.imageReceiver.getDrawable();
    }

    public static String hash(TLRPC$WallPaperSettings tLRPC$WallPaperSettings) {
        return tLRPC$WallPaperSettings == null ? BuildConfig.FLAVOR : String.valueOf(Arrays.hashCode(new Object[]{Boolean.valueOf(tLRPC$WallPaperSettings.blur), Boolean.valueOf(tLRPC$WallPaperSettings.motion), Integer.valueOf(tLRPC$WallPaperSettings.intensity), Integer.valueOf(tLRPC$WallPaperSettings.background_color), Integer.valueOf(tLRPC$WallPaperSettings.second_background_color), Integer.valueOf(tLRPC$WallPaperSettings.third_background_color), Integer.valueOf(tLRPC$WallPaperSettings.fourth_background_color)}));
    }
}
