package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import ir.nasim.AbstractC16967mA0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.nU5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C17743nU5 {
    private final boolean a;
    private final List b = Collections.synchronizedList(new ArrayList());

    /* renamed from: ir.nasim.nU5$a */
    static class a extends CameraCaptureSession.CaptureCallback {
        final InterfaceFutureC15215jC3 a = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.mU5
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.c(aVar);
            }
        });
        AbstractC16967mA0.a b;

        a() {
        }

        private void b() {
            AbstractC16967mA0.a aVar = this.b;
            if (aVar != null) {
                aVar.c(null);
                this.b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object c(AbstractC16967mA0.a aVar) {
            this.b = aVar;
            return "RequestCompleteListener[" + this + "]";
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            b();
        }
    }

    public C17743nU5(boolean z) {
        this.a = z;
    }

    private CameraCaptureSession.CaptureCallback c() {
        final a aVar = new a();
        final InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = aVar.a;
        this.b.add(interfaceFutureC15215jC3);
        Log.d("RequestMonitor", "RequestListener " + aVar + " monitoring " + this);
        interfaceFutureC15215jC3.j(new Runnable() { // from class: ir.nasim.kU5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(aVar, interfaceFutureC15215jC3);
            }
        }, AbstractC20567sE0.a());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(a aVar, InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        Log.d("RequestMonitor", "RequestListener " + aVar + " done " + this);
        this.b.remove(interfaceFutureC15215jC3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void g(List list) {
        return null;
    }

    public CameraCaptureSession.CaptureCallback d(CameraCaptureSession.CaptureCallback captureCallback) {
        return h() ? AbstractC19340qB0.b(c(), captureCallback) : captureCallback;
    }

    public InterfaceFutureC15215jC3 e() {
        return this.b.isEmpty() ? WB2.l(null) : WB2.t(WB2.y(WB2.x(new ArrayList(this.b)), new InterfaceC21819uB2() { // from class: ir.nasim.lU5
            @Override // ir.nasim.InterfaceC21819uB2
            public final Object apply(Object obj) {
                return C17743nU5.g((List) obj);
            }
        }, AbstractC20567sE0.a()));
    }

    public boolean h() {
        return this.a;
    }

    public void i() {
        LinkedList linkedList = new LinkedList(this.b);
        while (!linkedList.isEmpty()) {
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = (InterfaceFutureC15215jC3) linkedList.poll();
            Objects.requireNonNull(interfaceFutureC15215jC3);
            interfaceFutureC15215jC3.cancel(true);
        }
    }
}
