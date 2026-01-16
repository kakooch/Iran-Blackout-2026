package ir.resaneh1.iptv.barcode;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R$styleable;
import com.journeyapps.barcodescanner.CameraPreview;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RGHViewfinderView extends View {
    protected static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    protected RGHCameraPreview cameraPreview;
    protected Rect framingRect;
    protected final int laserColor;
    protected List<ResultPoint> lastPossibleResultPoints;
    protected ScannerBorder mBorder;
    protected Paint mBorderPaint;
    protected final int maskColor;
    protected final Paint paint;
    protected List<ResultPoint> possibleResultPoints;
    protected Rect previewFramingRect;
    protected Bitmap resultBitmap;
    protected final int resultColor;
    protected final int resultPointColor;
    protected int scannerAlpha;

    public RGHViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_finder);
        this.maskColor = typedArrayObtainStyledAttributes.getColor(3, resources.getColor(R.color.zxing_viewfinder_mask));
        this.resultColor = typedArrayObtainStyledAttributes.getColor(1, resources.getColor(R.color.zxing_result_view));
        this.laserColor = typedArrayObtainStyledAttributes.getColor(2, resources.getColor(R.color.zxing_viewfinder_laser));
        this.resultPointColor = typedArrayObtainStyledAttributes.getColor(0, resources.getColor(R.color.zxing_possible_result_points));
        typedArrayObtainStyledAttributes.recycle();
        this.scannerAlpha = 0;
        this.possibleResultPoints = new ArrayList(20);
        this.lastPossibleResultPoints = new ArrayList(20);
    }

    public void setScannerBorder(ScannerBorder scannerBorder) {
        this.mBorder = scannerBorder;
        Paint paint = new Paint(1);
        this.mBorderPaint = paint;
        paint.setColor(-889197765);
    }

    public void setCameraPreview(RGHCameraPreview rGHCameraPreview) {
        this.cameraPreview = rGHCameraPreview;
        rGHCameraPreview.addStateListener(new CameraPreview.StateListener() { // from class: ir.resaneh1.iptv.barcode.RGHViewfinderView.1
            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public void cameraClosed() {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public void cameraError(Exception exc) {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public void previewStarted() {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public void previewStopped() {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public void previewSized() {
                RGHViewfinderView.this.refreshSizes();
                RGHViewfinderView.this.invalidate();
            }
        });
    }

    protected void refreshSizes() {
        RGHCameraPreview rGHCameraPreview = this.cameraPreview;
        if (rGHCameraPreview == null) {
            return;
        }
        Rect framingRect = rGHCameraPreview.getFramingRect();
        Rect previewFramingRect = this.cameraPreview.getPreviewFramingRect();
        if (framingRect == null || previewFramingRect == null) {
            return;
        }
        this.framingRect = framingRect;
        this.previewFramingRect = previewFramingRect;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        refreshSizes();
        Rect rect2 = this.framingRect;
        if (rect2 == null || (rect = this.previewFramingRect) == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.paint.setColor(this.resultBitmap != null ? this.resultColor : this.maskColor);
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, rect2.top, this.paint);
        canvas.drawRect(0.0f, rect2.top, rect2.left, rect2.bottom + 1, this.paint);
        canvas.drawRect(rect2.right + 1, rect2.top, f, rect2.bottom + 1, this.paint);
        canvas.drawRect(0.0f, rect2.bottom + 1, f, height, this.paint);
        ScannerBorder scannerBorder = this.mBorder;
        if (scannerBorder != null && this.mBorderPaint != null) {
            int i = (rect2.bottom - rect2.top) / 6;
            int thickness = scannerBorder.getThickness();
            int i2 = rect2.left;
            canvas.drawRect(i2 - thickness, r2 - thickness, i2 + i, rect2.top, this.mBorderPaint);
            int i3 = rect2.left;
            canvas.drawRect(i3 - thickness, rect2.top, i3, r2 + i, this.mBorderPaint);
            int i4 = rect2.right;
            canvas.drawRect(i4 - i, r2 - thickness, i4 + thickness, rect2.top, this.mBorderPaint);
            canvas.drawRect(rect2.right, rect2.top, r0 + thickness, r2 + i, this.mBorderPaint);
            int i5 = rect2.left;
            canvas.drawRect(i5 - thickness, rect2.bottom, i5 + i, r2 + thickness, this.mBorderPaint);
            canvas.drawRect(r0 - thickness, r2 - i, rect2.left, rect2.bottom, this.mBorderPaint);
            int i6 = rect2.right;
            canvas.drawRect(i6 - i, rect2.bottom, i6 + thickness, r2 + thickness, this.mBorderPaint);
            canvas.drawRect(rect2.right, r2 - i, r0 + thickness, rect2.bottom, this.mBorderPaint);
        }
        if (this.resultBitmap != null) {
            this.paint.setAlpha(160);
            canvas.drawBitmap(this.resultBitmap, (Rect) null, rect2, this.paint);
            return;
        }
        this.paint.setColor(this.laserColor);
        Paint paint = this.paint;
        int[] iArr = SCANNER_ALPHA;
        paint.setAlpha(iArr[this.scannerAlpha]);
        this.scannerAlpha = (this.scannerAlpha + 1) % iArr.length;
        int iHeight = (rect2.height() / 2) + rect2.top;
        canvas.drawRect(rect2.left + 2, iHeight - 1, rect2.right - 1, iHeight + 2, this.paint);
        float fWidth = rect2.width() / rect.width();
        float fHeight = rect2.height() / rect.height();
        int i7 = rect2.left;
        int i8 = rect2.top;
        if (!this.lastPossibleResultPoints.isEmpty()) {
            this.paint.setAlpha(80);
            this.paint.setColor(this.resultPointColor);
            for (ResultPoint resultPoint : this.lastPossibleResultPoints) {
                canvas.drawCircle(((int) (resultPoint.getX() * fWidth)) + i7, ((int) (resultPoint.getY() * fHeight)) + i8, 3.0f, this.paint);
            }
            this.lastPossibleResultPoints.clear();
        }
        if (!this.possibleResultPoints.isEmpty()) {
            this.paint.setAlpha(160);
            this.paint.setColor(this.resultPointColor);
            for (ResultPoint resultPoint2 : this.possibleResultPoints) {
                canvas.drawCircle(((int) (resultPoint2.getX() * fWidth)) + i7, ((int) (resultPoint2.getY() * fHeight)) + i8, 6.0f, this.paint);
            }
            List<ResultPoint> list = this.possibleResultPoints;
            List<ResultPoint> list2 = this.lastPossibleResultPoints;
            this.possibleResultPoints = list2;
            this.lastPossibleResultPoints = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect2.left - 6, rect2.top - 6, rect2.right + 6, rect2.bottom + 6);
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        if (this.possibleResultPoints.size() < 20) {
            this.possibleResultPoints.add(resultPoint);
        }
    }
}
