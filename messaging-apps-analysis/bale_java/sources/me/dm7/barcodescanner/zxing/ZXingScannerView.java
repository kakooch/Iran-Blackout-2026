package me.dm7.barcodescanner.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import ir.nasim.C20288rl4;
import ir.nasim.C23221wZ2;
import ir.nasim.C5871Le5;
import ir.nasim.C6338Ne0;
import ir.nasim.EV1;
import ir.nasim.EnumC19932rB1;
import ir.nasim.EnumC9549a90;
import ir.nasim.X06;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import me.dm7.barcodescanner.core.BarcodeScannerView;

/* loaded from: classes8.dex */
public class ZXingScannerView extends BarcodeScannerView {
    public static final List x;
    private C20288rl4 u;
    private List v;
    private b w;

    class a implements Runnable {
        final /* synthetic */ X06 a;

        a(X06 x06) {
            this.a = x06;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = ZXingScannerView.this.w;
            ZXingScannerView.this.w = null;
            ZXingScannerView.this.i();
            if (bVar != null) {
                bVar.p(this.a);
            }
        }
    }

    public interface b {
        void p(X06 x06);
    }

    static {
        ArrayList arrayList = new ArrayList();
        x = arrayList;
        arrayList.add(EnumC9549a90.AZTEC);
        arrayList.add(EnumC9549a90.CODABAR);
        arrayList.add(EnumC9549a90.CODE_39);
        arrayList.add(EnumC9549a90.CODE_93);
        arrayList.add(EnumC9549a90.CODE_128);
        arrayList.add(EnumC9549a90.DATA_MATRIX);
        arrayList.add(EnumC9549a90.EAN_8);
        arrayList.add(EnumC9549a90.EAN_13);
        arrayList.add(EnumC9549a90.ITF);
        arrayList.add(EnumC9549a90.MAXICODE);
        arrayList.add(EnumC9549a90.PDF_417);
        arrayList.add(EnumC9549a90.QR_CODE);
        arrayList.add(EnumC9549a90.RSS_14);
        arrayList.add(EnumC9549a90.RSS_EXPANDED);
        arrayList.add(EnumC9549a90.UPC_A);
        arrayList.add(EnumC9549a90.UPC_E);
        arrayList.add(EnumC9549a90.UPC_EAN_EXTENSION);
    }

    public ZXingScannerView(Context context) {
        super(context);
        n();
    }

    private void n() {
        EnumMap enumMap = new EnumMap(EnumC19932rB1.class);
        enumMap.put((EnumMap) EnumC19932rB1.POSSIBLE_FORMATS, (EnumC19932rB1) getFormats());
        C20288rl4 c20288rl4 = new C20288rl4();
        this.u = c20288rl4;
        c20288rl4.d(enumMap);
    }

    public Collection<EnumC9549a90> getFormats() {
        List list = this.v;
        return list == null ? x : list;
    }

    public C5871Le5 m(byte[] bArr, int i, int i2) {
        Rect rectB = b(i, i2);
        if (rectB == null) {
            return null;
        }
        try {
            return new C5871Le5(bArr, i, i2, rectB.left, rectB.top, rectB.width(), rectB.height(), false);
        } catch (Exception unused) {
            return null;
        }
    }

    public void o(b bVar) throws IOException {
        this.w = bVar;
        super.e();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        C20288rl4 c20288rl4;
        C20288rl4 c20288rl42;
        if (this.w == null) {
            return;
        }
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            int i = previewSize.width;
            int i2 = previewSize.height;
            if (EV1.a(getContext()) == 1) {
                int rotationCount = getRotationCount();
                if (rotationCount == 1 || rotationCount == 3) {
                    i = i2;
                    i2 = i;
                }
                bArr = c(bArr, camera);
            }
            C5871Le5 c5871Le5M = m(bArr, i, i2);
            X06 x06C = null;
            if (c5871Le5M != null) {
                try {
                    try {
                        try {
                            x06C = this.u.c(new C6338Ne0(new C23221wZ2(c5871Le5M)));
                            c20288rl4 = this.u;
                        } finally {
                            this.u.reset();
                        }
                    } catch (NullPointerException unused) {
                        c20288rl4 = this.u;
                    }
                } catch (ReaderException unused2) {
                    c20288rl4 = this.u;
                } catch (ArrayIndexOutOfBoundsException unused3) {
                    c20288rl4 = this.u;
                }
                c20288rl4.reset();
                if (x06C == null) {
                    try {
                        x06C = this.u.c(new C6338Ne0(new C23221wZ2(c5871Le5M.e())));
                        c20288rl42 = this.u;
                    } catch (NotFoundException unused4) {
                        c20288rl42 = this.u;
                    } catch (Throwable th) {
                        throw th;
                    }
                    c20288rl42.reset();
                }
            }
            if (x06C != null) {
                new Handler(Looper.getMainLooper()).post(new a(x06C));
            } else {
                camera.setOneShotPreviewCallback(this);
            }
        } catch (RuntimeException e) {
            Log.e("ZXingScannerView", e.toString(), e);
        }
    }

    public void setFormats(List<EnumC9549a90> list) {
        this.v = list;
        n();
    }

    public void setResultHandler(b bVar) {
        this.w = bVar;
    }

    public ZXingScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n();
    }
}
