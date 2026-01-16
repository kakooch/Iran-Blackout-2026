package ir.resaneh1.iptv.barcode;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.Decoder;
import com.journeyapps.barcodescanner.DecoderFactory;
import com.journeyapps.barcodescanner.DecoderResultPointCallback;
import com.journeyapps.barcodescanner.DecoderThread;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import com.journeyapps.barcodescanner.Util;
import ir.medu.shad.R;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class RGHBarcodeView extends RGHCameraPreview {
    private BarcodeCallback callback;
    private DecodeMode decodeMode;
    private DecoderFactory decoderFactory;
    private DecoderThread decoderThread;
    private final Handler.Callback resultCallback;
    private Handler resultHandler;

    private enum DecodeMode {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public RGHBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.decodeMode = DecodeMode.NONE;
        this.callback = null;
        this.resultCallback = new Handler.Callback() { // from class: ir.resaneh1.iptv.barcode.RGHBarcodeView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == R.id.zxing_decode_succeeded) {
                    BarcodeResult barcodeResult = (BarcodeResult) message.obj;
                    if (barcodeResult != null && RGHBarcodeView.this.callback != null && RGHBarcodeView.this.decodeMode != DecodeMode.NONE) {
                        RGHBarcodeView.this.callback.barcodeResult(barcodeResult);
                        if (RGHBarcodeView.this.decodeMode == DecodeMode.SINGLE) {
                            RGHBarcodeView.this.stopDecoding();
                        }
                    }
                    return true;
                }
                if (i == R.id.zxing_decode_failed) {
                    return true;
                }
                if (i != R.id.zxing_possible_result_points) {
                    return false;
                }
                List<ResultPoint> list = (List) message.obj;
                if (RGHBarcodeView.this.callback != null && RGHBarcodeView.this.decodeMode != DecodeMode.NONE) {
                    RGHBarcodeView.this.callback.possibleResultPoints(list);
                }
                return true;
            }
        };
        initialize();
    }

    private void initialize() {
        this.decoderFactory = new DefaultDecoderFactory();
        this.resultHandler = new Handler(this.resultCallback);
    }

    public void setDecoderFactory(DecoderFactory decoderFactory) {
        Util.validateMainThread();
        this.decoderFactory = decoderFactory;
        DecoderThread decoderThread = this.decoderThread;
        if (decoderThread != null) {
            decoderThread.setDecoder(createDecoder());
        }
    }

    private Decoder createDecoder() {
        if (this.decoderFactory == null) {
            this.decoderFactory = createDefaultDecoderFactory();
        }
        DecoderResultPointCallback decoderResultPointCallback = new DecoderResultPointCallback();
        HashMap map = new HashMap();
        map.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, decoderResultPointCallback);
        Decoder decoderCreateDecoder = this.decoderFactory.createDecoder(map);
        decoderResultPointCallback.setDecoder(decoderCreateDecoder);
        return decoderCreateDecoder;
    }

    public DecoderFactory getDecoderFactory() {
        return this.decoderFactory;
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.decodeMode = DecodeMode.CONTINUOUS;
        this.callback = barcodeCallback;
        startDecoderThread();
    }

    public void stopDecoding() {
        this.decodeMode = DecodeMode.NONE;
        this.callback = null;
        stopDecoderThread();
    }

    protected DecoderFactory createDefaultDecoderFactory() {
        return new DefaultDecoderFactory();
    }

    private void startDecoderThread() {
        stopDecoderThread();
        if (this.decodeMode == DecodeMode.NONE || !isPreviewActive()) {
            return;
        }
        DecoderThread decoderThread = new DecoderThread(getCameraInstance(), createDecoder(), this.resultHandler);
        this.decoderThread = decoderThread;
        decoderThread.setCropRect(getPreviewFramingRect());
        this.decoderThread.start();
    }

    @Override // ir.resaneh1.iptv.barcode.RGHCameraPreview
    protected void previewStarted() {
        super.previewStarted();
        startDecoderThread();
    }

    private void stopDecoderThread() {
        DecoderThread decoderThread = this.decoderThread;
        if (decoderThread != null) {
            decoderThread.stop();
            this.decoderThread = null;
        }
    }

    @Override // ir.resaneh1.iptv.barcode.RGHCameraPreview
    public void pause() {
        stopDecoderThread();
        super.pause();
    }
}
