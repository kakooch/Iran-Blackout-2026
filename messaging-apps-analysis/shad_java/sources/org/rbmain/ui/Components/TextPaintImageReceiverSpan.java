package org.rbmain.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.view.View;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.tgnet.TLRPC$Document;

/* loaded from: classes5.dex */
public class TextPaintImageReceiverSpan extends ReplacementSpan {
    private boolean alignTop;
    private int height;
    private ImageReceiver imageReceiver;
    private int width;

    public TextPaintImageReceiverSpan(View view, TLRPC$Document tLRPC$Document, Object obj, int i, int i2, boolean z, boolean z2) {
        String str = String.format(Locale.US, "%d_%d_i", Integer.valueOf(i), Integer.valueOf(i2));
        this.width = i;
        this.height = i2;
        ImageReceiver imageReceiver = new ImageReceiver(view);
        this.imageReceiver = imageReceiver;
        imageReceiver.setInvalidateAll(true);
        if (z2) {
            this.imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: org.rbmain.ui.Components.TextPaintImageReceiverSpan$$ExternalSyntheticLambda0
                @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
                public final void didSetImage(ImageReceiver imageReceiver2, boolean z3, boolean z4, boolean z5) {
                    TextPaintImageReceiverSpan.lambda$new$0(imageReceiver2, z3, z4, z5);
                }

                @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
                public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                    ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
                }
            });
        }
        this.imageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), str, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90), tLRPC$Document), str, -1L, null, obj, 1);
        this.alignTop = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        if (imageReceiver.canInvertBitmap()) {
            imageReceiver.setColorFilter(new ColorMatrixColorFilter(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            if (this.alignTop) {
                int iDp = (fontMetricsInt.descent - fontMetricsInt.ascent) - AndroidUtilities.dp(4.0f);
                int i3 = this.height - iDp;
                fontMetricsInt.descent = i3;
                fontMetricsInt.bottom = i3;
                int i4 = 0 - iDp;
                fontMetricsInt.ascent = i4;
                fontMetricsInt.top = i4;
            } else {
                int iDp2 = ((-this.height) / 2) - AndroidUtilities.dp(4.0f);
                fontMetricsInt.ascent = iDp2;
                fontMetricsInt.top = iDp2;
                int i5 = this.height;
                int iDp3 = (i5 - (i5 / 2)) - AndroidUtilities.dp(4.0f);
                fontMetricsInt.descent = iDp3;
                fontMetricsInt.bottom = iDp3;
            }
        }
        return this.width;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        if (this.alignTop) {
            this.imageReceiver.setImageCoords((int) f, i3 - 1, this.width, this.height);
        } else {
            int iDp = (i5 - AndroidUtilities.dp(4.0f)) - i3;
            this.imageReceiver.setImageCoords((int) f, i3 + ((iDp - r4) / 2), this.width, this.height);
        }
        this.imageReceiver.draw(canvas);
        canvas.restore();
    }
}
