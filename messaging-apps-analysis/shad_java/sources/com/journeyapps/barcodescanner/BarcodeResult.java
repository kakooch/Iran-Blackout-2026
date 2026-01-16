package com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* loaded from: classes3.dex */
public class BarcodeResult {
    protected Result mResult;
    protected SourceData sourceData;

    public BarcodeResult(Result result, SourceData sourceData) {
        this.mResult = result;
        this.sourceData = sourceData;
    }

    public Bitmap getBitmap() {
        return this.sourceData.getBitmap(2);
    }

    public String getText() {
        return this.mResult.getText();
    }

    public byte[] getRawBytes() {
        return this.mResult.getRawBytes();
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.mResult.getBarcodeFormat();
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.mResult.getResultMetadata();
    }

    public String toString() {
        return this.mResult.getText();
    }
}
