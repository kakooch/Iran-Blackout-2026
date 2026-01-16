package ir.resaneh1.iptv.barcode;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R$styleable;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import ir.medu.shad.R;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class RGHDecorateBarcodeView extends FrameLayout {
    private RGHBarcodeView barcodeView;
    private TextView statusView;
    private TorchListener torchListener;
    private RGHViewfinderView viewFinder;

    public interface TorchListener {
        void onTorchOff();

        void onTorchOn();
    }

    private class WrappedCallback implements BarcodeCallback {
        private BarcodeCallback delegate;

        public WrappedCallback(BarcodeCallback barcodeCallback) {
            this.delegate = barcodeCallback;
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void barcodeResult(BarcodeResult barcodeResult) {
            this.delegate.barcodeResult(barcodeResult);
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void possibleResultPoints(List<ResultPoint> list) {
            Iterator<ResultPoint> it = list.iterator();
            while (it.hasNext()) {
                RGHDecorateBarcodeView.this.viewFinder.addPossibleResultPoint(it.next());
            }
            this.delegate.possibleResultPoints(list);
        }
    }

    public RGHDecorateBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(attributeSet);
    }

    private void initialize(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_view);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, R.layout.zxing_barcode_scanner);
        typedArrayObtainStyledAttributes.recycle();
        FrameLayout.inflate(getContext(), resourceId, this);
        RGHBarcodeView rGHBarcodeView = (RGHBarcodeView) findViewById(R.id.zxing_barcode_surface);
        this.barcodeView = rGHBarcodeView;
        if (rGHBarcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        rGHBarcodeView.initializeAttributes(attributeSet);
        RGHViewfinderView rGHViewfinderView = (RGHViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.viewFinder = rGHViewfinderView;
        if (rGHViewfinderView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        rGHViewfinderView.setCameraPreview(this.barcodeView);
        this.statusView = (TextView) findViewById(R.id.zxing_status_view);
    }

    public void setStatusText(String str) {
        TextView textView = this.statusView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void pause() {
        this.barcodeView.pause();
    }

    public void resume() {
        this.barcodeView.resume();
    }

    public RGHBarcodeView getBarcodeView() {
        return (RGHBarcodeView) findViewById(R.id.zxing_barcode_surface);
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.barcodeView.decodeContinuous(new WrappedCallback(barcodeCallback));
    }

    public void setTorchOn() {
        this.barcodeView.setTorch(true);
        TorchListener torchListener = this.torchListener;
        if (torchListener != null) {
            torchListener.onTorchOn();
        }
    }

    public void setTorchOff() {
        this.barcodeView.setTorch(false);
        TorchListener torchListener = this.torchListener;
        if (torchListener != null) {
            torchListener.onTorchOff();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            setTorchOn();
            return true;
        }
        if (i == 25) {
            setTorchOff();
            return true;
        }
        if (i == 27 || i == 80) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
