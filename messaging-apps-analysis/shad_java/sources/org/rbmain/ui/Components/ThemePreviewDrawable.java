package org.rbmain.ui.Components;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import ir.medu.shad.R;
import java.io.File;
import java.io.IOException;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Bitmaps;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class ThemePreviewDrawable extends BitmapDrawable {
    public ThemePreviewDrawable(File file, DocumentObject.ThemeDocument themeDocument) {
        super(createPreview(file, themeDocument));
    }

    private static Bitmap createPreview(File file, DocumentObject.ThemeDocument themeDocument) throws IOException {
        boolean z;
        Drawable drawableCreateDitheredGradientBitmapDrawable;
        MotionBackgroundDrawable motionBackgroundDrawable;
        int patternColor;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmapDecodeFile;
        new RectF();
        Paint paint = new Paint();
        Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(560, 678, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        SparseIntArray themeFileValues = Theme.getThemeFileValues(null, themeDocument.baseTheme.assetName, null);
        final SparseIntArray sparseIntArrayClone = themeFileValues.clone();
        themeDocument.accent.fillAccentColors(themeFileValues, sparseIntArrayClone);
        int previewColor = Theme.getPreviewColor(sparseIntArrayClone, Theme.key_actionBarDefault);
        int previewColor2 = Theme.getPreviewColor(sparseIntArrayClone, Theme.key_actionBarDefaultIcon);
        int previewColor3 = Theme.getPreviewColor(sparseIntArrayClone, Theme.key_chat_messagePanelBackground);
        int previewColor4 = Theme.getPreviewColor(sparseIntArrayClone, Theme.key_chat_messagePanelIcons);
        int previewColor5 = Theme.getPreviewColor(sparseIntArrayClone, Theme.key_chat_inBubble);
        int previewColor6 = Theme.getPreviewColor(sparseIntArrayClone, Theme.key_chat_outBubble);
        Integer numValueOf = Integer.valueOf(sparseIntArrayClone.get(Theme.key_chat_wallpaper));
        Integer numValueOf2 = Integer.valueOf(sparseIntArrayClone.get(Theme.key_chat_wallpaper_gradient_to1));
        Integer numValueOf3 = Integer.valueOf(sparseIntArrayClone.get(Theme.key_chat_wallpaper_gradient_to2));
        Integer numValueOf4 = Integer.valueOf(sparseIntArrayClone.get(Theme.key_chat_wallpaper_gradient_to3));
        Integer numValueOf5 = Integer.valueOf(sparseIntArrayClone.get(Theme.key_chat_wallpaper_gradient_rotation));
        if (numValueOf5 == null) {
            numValueOf5 = 45;
        }
        Drawable drawableMutate = ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.preview_back).mutate();
        Theme.setDrawableColor(drawableMutate, previewColor2);
        Drawable drawableMutate2 = ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.preview_dots).mutate();
        Theme.setDrawableColor(drawableMutate2, previewColor2);
        Drawable drawableMutate3 = ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.preview_smile).mutate();
        Theme.setDrawableColor(drawableMutate3, previewColor4);
        Drawable drawableMutate4 = ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.preview_mic).mutate();
        Theme.setDrawableColor(drawableMutate4, previewColor4);
        Theme.MessageDrawable[] messageDrawableArr = new Theme.MessageDrawable[2];
        int i = 0;
        while (i < 2) {
            Drawable drawable = drawableMutate2;
            Paint paint2 = paint;
            int i2 = previewColor;
            messageDrawableArr[i] = new Theme.MessageDrawable(2, i == 1, false) { // from class: org.rbmain.ui.Components.ThemePreviewDrawable.1
                @Override // org.rbmain.ui.ActionBar.Theme.MessageDrawable
                protected int getColor(int i3) {
                    Integer numValueOf6 = Integer.valueOf(sparseIntArrayClone.get(i3));
                    if (numValueOf6 == null) {
                        return Theme.getColor(i3);
                    }
                    return numValueOf6.intValue();
                }

                @Override // org.rbmain.ui.ActionBar.Theme.MessageDrawable
                protected int getCurrentColor(int i3) {
                    return sparseIntArrayClone.get(i3);
                }
            };
            Theme.setDrawableColor(messageDrawableArr[i], i == 1 ? previewColor6 : previewColor5);
            i++;
            drawableMutate2 = drawable;
            paint = paint2;
            previewColor = i2;
        }
        Paint paint3 = paint;
        int i3 = previewColor;
        Drawable drawable2 = drawableMutate2;
        if (numValueOf != null) {
            if (numValueOf2 == null) {
                drawableCreateDitheredGradientBitmapDrawable = new ColorDrawable(numValueOf.intValue());
                patternColor = AndroidUtilities.getPatternColor(numValueOf.intValue());
                motionBackgroundDrawable = null;
            } else {
                if (numValueOf3.intValue() != 0) {
                    motionBackgroundDrawable = new MotionBackgroundDrawable(numValueOf.intValue(), numValueOf2.intValue(), numValueOf3.intValue(), numValueOf4.intValue(), true);
                    drawableCreateDitheredGradientBitmapDrawable = null;
                } else {
                    drawableCreateDitheredGradientBitmapDrawable = BackgroundGradientDrawable.createDitheredGradientBitmapDrawable(numValueOf5.intValue(), new int[]{numValueOf.intValue(), numValueOf2.intValue()}, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight() - 120);
                    motionBackgroundDrawable = null;
                }
                patternColor = AndroidUtilities.getPatternColor(AndroidUtilities.getAverageColor(numValueOf.intValue(), numValueOf2.intValue()));
            }
            if (drawableCreateDitheredGradientBitmapDrawable != null) {
                z2 = false;
                drawableCreateDitheredGradientBitmapDrawable.setBounds(0, 120, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight() - 120);
                drawableCreateDitheredGradientBitmapDrawable.draw(canvas);
            } else {
                z2 = false;
            }
            if (file != null) {
                if ("application/x-tgwallpattern".equals(themeDocument.mime_type)) {
                    bitmapDecodeFile = SvgHelper.getBitmap(file, 560, 678, z2);
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 1;
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    float f = options.outWidth;
                    float f2 = options.outHeight;
                    float fMin = Math.min(f / 560, f2 / 678);
                    if (fMin < 1.2f) {
                        fMin = 1.0f;
                    }
                    options.inJustDecodeBounds = false;
                    if (fMin > 1.0f && (f > 560 || f2 > 678)) {
                        int i4 = 1;
                        do {
                            i4 *= 2;
                        } while (i4 * 2 < fMin);
                        options.inSampleSize = i4;
                    } else {
                        options.inSampleSize = (int) fMin;
                    }
                    bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                }
                bitmap = bitmapDecodeFile;
                if (bitmap != null) {
                    if (motionBackgroundDrawable != null) {
                        motionBackgroundDrawable.setPatternBitmap((int) (themeDocument.accent.patternIntensity * 100.0f), bitmap);
                        motionBackgroundDrawable.setBounds(0, 120, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight() - 120);
                        motionBackgroundDrawable.draw(canvas);
                    } else {
                        Paint paint4 = new Paint(2);
                        if (themeDocument.accent.patternIntensity >= 0.0f) {
                            paint4.setColorFilter(new PorterDuffColorFilter(patternColor, PorterDuff.Mode.SRC_IN));
                        }
                        paint4.setAlpha(255);
                        float fMax = Math.max(560 / bitmap.getWidth(), 678 / bitmap.getHeight());
                        int width = (int) (bitmap.getWidth() * fMax);
                        canvas.save();
                        canvas.translate((560 - width) / 2, (678 - ((int) (bitmap.getHeight() * fMax))) / 2);
                        canvas.scale(fMax, fMax);
                        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint4);
                        canvas.restore();
                    }
                }
            } else {
                bitmap = null;
            }
            if (bitmap == null && motionBackgroundDrawable != null) {
                motionBackgroundDrawable.setBounds(0, 120, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight() - 120);
                motionBackgroundDrawable.draw(canvas);
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Drawable drawableCreateDefaultWallpaper = Theme.createDefaultWallpaper(bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight() - 120);
            drawableCreateDefaultWallpaper.setBounds(0, 120, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight() - 120);
            drawableCreateDefaultWallpaper.draw(canvas);
        }
        paint3.setColor(i3);
        canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), 120.0f, paint3);
        if (drawableMutate != null) {
            int intrinsicHeight = (120 - drawableMutate.getIntrinsicHeight()) / 2;
            drawableMutate.setBounds(13, intrinsicHeight, drawableMutate.getIntrinsicWidth() + 13, drawableMutate.getIntrinsicHeight() + intrinsicHeight);
            drawableMutate.draw(canvas);
        }
        if (drawable2 != null) {
            int width2 = (bitmapCreateBitmap.getWidth() - drawable2.getIntrinsicWidth()) - 10;
            int intrinsicHeight2 = (120 - drawable2.getIntrinsicHeight()) / 2;
            drawable2.setBounds(width2, intrinsicHeight2, drawable2.getIntrinsicWidth() + width2, drawable2.getIntrinsicHeight() + intrinsicHeight2);
            drawable2.draw(canvas);
        }
        messageDrawableArr[1].setBounds(161, 216, bitmapCreateBitmap.getWidth() - 20, 308);
        messageDrawableArr[1].setTop(0, 560, 522, false, false);
        messageDrawableArr[1].draw(canvas);
        messageDrawableArr[1].setBounds(161, 430, bitmapCreateBitmap.getWidth() - 20, 522);
        messageDrawableArr[1].setTop(430, 560, 522, false, false);
        messageDrawableArr[1].draw(canvas);
        messageDrawableArr[0].setBounds(20, 323, 399, 415);
        messageDrawableArr[0].setTop(323, 560, 522, false, false);
        messageDrawableArr[0].draw(canvas);
        paint3.setColor(previewColor3);
        canvas.drawRect(0.0f, bitmapCreateBitmap.getHeight() - 120, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), paint3);
        if (drawableMutate3 != null) {
            int height = (bitmapCreateBitmap.getHeight() - 120) + ((120 - drawableMutate3.getIntrinsicHeight()) / 2);
            drawableMutate3.setBounds(22, height, drawableMutate3.getIntrinsicWidth() + 22, drawableMutate3.getIntrinsicHeight() + height);
            drawableMutate3.draw(canvas);
        }
        if (drawableMutate4 != null) {
            int width3 = (bitmapCreateBitmap.getWidth() - drawableMutate4.getIntrinsicWidth()) - 22;
            int height2 = (bitmapCreateBitmap.getHeight() - 120) + ((120 - drawableMutate4.getIntrinsicHeight()) / 2);
            drawableMutate4.setBounds(width3, height2, drawableMutate4.getIntrinsicWidth() + width3, drawableMutate4.getIntrinsicHeight() + height2);
            drawableMutate4.draw(canvas);
        }
        return bitmapCreateBitmap;
    }
}
