package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.tgnet.TLRPC$Document;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TextPaintImageReceiverSpan extends ReplacementSpan {
    private boolean alignTop;
    private int height;
    private ImageReceiver imageReceiver;
    private int width;

    public TextPaintImageReceiverSpan(View parentView, TLRPC$Document document, Object parentObject, int w, int h, boolean top, boolean invert) {
        String str = String.format(Locale.US, "%d_%d_i", Integer.valueOf(w), Integer.valueOf(h));
        this.width = w;
        this.height = h;
        ImageReceiver imageReceiver = new ImageReceiver(parentView);
        this.imageReceiver = imageReceiver;
        imageReceiver.setInvalidateAll(true);
        if (invert) {
            this.imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$TextPaintImageReceiverSpan$pav8QlaTdqMRzKIL6Ll638BzflI
                @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                public final void didSetImage(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) {
                    TextPaintImageReceiverSpan.lambda$new$0(imageReceiver2, z, z2, z3);
                }

                @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                    ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
                }
            });
        }
        this.imageReceiver.setImage(ImageLocation.getForDocument(document), str, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90), document), str, -1, null, parentObject, 1);
        this.alignTop = top;
    }

    static /* synthetic */ void lambda$new$0(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        if (imageReceiver.canInvertBitmap()) {
            imageReceiver.setColorFilter(new ColorMatrixColorFilter(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        if (fm != null) {
            if (this.alignTop) {
                int iDp = (fm.descent - fm.ascent) - AndroidUtilities.dp(4.0f);
                int i = this.height - iDp;
                fm.descent = i;
                fm.bottom = i;
                int i2 = 0 - iDp;
                fm.ascent = i2;
                fm.top = i2;
            } else {
                int iDp2 = ((-this.height) / 2) - AndroidUtilities.dp(4.0f);
                fm.ascent = iDp2;
                fm.top = iDp2;
                int i3 = this.height;
                int iDp3 = (i3 - (i3 / 2)) - AndroidUtilities.dp(4.0f);
                fm.descent = iDp3;
                fm.bottom = iDp3;
            }
        }
        return this.width;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        canvas.save();
        if (this.alignTop) {
            this.imageReceiver.setImageCoords((int) x, top - 1, this.width, this.height);
        } else {
            int iDp = (bottom - AndroidUtilities.dp(4.0f)) - top;
            this.imageReceiver.setImageCoords((int) x, top + ((iDp - r4) / 2), this.width, this.height);
        }
        this.imageReceiver.draw(canvas);
        canvas.restore();
    }
}
