package ir.nasim;

import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import me.dm7.barcodescanner.core.BarcodeScannerView;

/* renamed from: ir.nasim.fD0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class HandlerThreadC12812fD0 extends HandlerThread {
    private BarcodeScannerView a;

    /* renamed from: ir.nasim.fD0$a */
    class a implements Runnable {
        final /* synthetic */ int a;

        /* renamed from: ir.nasim.fD0$a$a, reason: collision with other inner class name */
        class RunnableC1112a implements Runnable {
            final /* synthetic */ Camera a;

            RunnableC1112a(Camera camera) {
                this.a = camera;
            }

            @Override // java.lang.Runnable
            public void run() {
                HandlerThreadC12812fD0.this.a.setupCameraPreview(C17003mE0.a(this.a, a.this.a));
            }
        }

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            new Handler(Looper.getMainLooper()).post(new RunnableC1112a(RD0.a(this.a)));
        }
    }

    public HandlerThreadC12812fD0(BarcodeScannerView barcodeScannerView) {
        super("CameraHandlerThread");
        this.a = barcodeScannerView;
        start();
    }

    public void b(int i) {
        new Handler(getLooper()).post(new a(i));
    }
}
