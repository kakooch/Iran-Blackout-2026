package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.v;
import ir.nasim.O23;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
final class Wc8 implements Sc8 {
    private final C19349qC0 a;
    final Xc8 b;
    private boolean c = false;
    private boolean d = false;
    private boolean e;
    private boolean f;
    androidx.camera.core.i g;
    private JB0 h;
    private DeferrableSurface i;
    ImageWriter j;

    Wc8(C19349qC0 c19349qC0) {
        this.e = false;
        this.f = false;
        this.a = c19349qC0;
        this.e = Yc8.a(c19349qC0, 4);
        this.f = androidx.camera.camera2.internal.compat.quirk.b.b(ZslDisablerQuirk.class) != null;
        this.b = new Xc8(3, new InterfaceC15120j26() { // from class: ir.nasim.Tc8
            @Override // ir.nasim.InterfaceC15120j26
            public final void a(Object obj) {
                ((androidx.camera.core.f) obj).close();
            }
        });
    }

    private void f() {
        Xc8 xc8 = this.b;
        while (!xc8.c()) {
            ((androidx.camera.core.f) xc8.a()).close();
        }
        DeferrableSurface deferrableSurface = this.i;
        if (deferrableSurface != null) {
            androidx.camera.core.i iVar = this.g;
            if (iVar != null) {
                deferrableSurface.k().j(new Vc8(iVar), AbstractC20567sE0.c());
                this.g = null;
            }
            deferrableSurface.d();
            this.i = null;
        }
        ImageWriter imageWriter = this.j;
        if (imageWriter != null) {
            imageWriter.close();
            this.j = null;
        }
    }

    private Map g(C19349qC0 c19349qC0) {
        StreamConfigurationMap streamConfigurationMap;
        try {
            streamConfigurationMap = (StreamConfigurationMap) c19349qC0.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e) {
            PI3.c("ZslControlImpl", "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
            streamConfigurationMap = null;
        }
        if (streamConfigurationMap == null || streamConfigurationMap.getInputFormats() == null) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        for (int i : streamConfigurationMap.getInputFormats()) {
            Size[] inputSizes = streamConfigurationMap.getInputSizes(i);
            if (inputSizes != null) {
                Arrays.sort(inputSizes, new C15686k01(true));
                map.put(Integer.valueOf(i), inputSizes[0]);
            }
        }
        return map;
    }

    private boolean h(C19349qC0 c19349qC0, int i) {
        int[] validOutputFormatsForInput;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) c19349qC0.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null || (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(i)) == null) {
            return false;
        }
        for (int i2 : validOutputFormatsForInput) {
            if (i2 == 256) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(O23 o23) {
        try {
            androidx.camera.core.f fVarB = o23.b();
            if (fVarB != null) {
                this.b.d(fVarB);
            }
        } catch (IllegalStateException e) {
            PI3.c("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e.getMessage());
        }
    }

    @Override // ir.nasim.Sc8
    public void a(v.b bVar) {
        f();
        if (this.c) {
            bVar.w(1);
            return;
        }
        if (this.f) {
            bVar.w(1);
            return;
        }
        Map mapG = g(this.a);
        if (!this.e || mapG.isEmpty() || !mapG.containsKey(34) || !h(this.a, 34)) {
            bVar.w(1);
            return;
        }
        Size size = (Size) mapG.get(34);
        androidx.camera.core.h hVar = new androidx.camera.core.h(size.getWidth(), size.getHeight(), 34, 9);
        this.h = hVar.m();
        this.g = new androidx.camera.core.i(hVar);
        hVar.f(new O23.a() { // from class: ir.nasim.Uc8
            @Override // ir.nasim.O23.a
            public final void a(O23 o23) {
                this.a.i(o23);
            }
        }, AbstractC20567sE0.b());
        W33 w33 = new W33(this.g.getSurface(), new Size(this.g.getWidth(), this.g.getHeight()), 34);
        this.i = w33;
        androidx.camera.core.i iVar = this.g;
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3K = w33.k();
        Objects.requireNonNull(iVar);
        interfaceFutureC15215jC3K.j(new Vc8(iVar), AbstractC20567sE0.c());
        bVar.l(this.i);
        bVar.e(this.h);
        bVar.k(new a());
        bVar.t(new InputConfiguration(this.g.getWidth(), this.g.getHeight(), this.g.c()));
    }

    @Override // ir.nasim.Sc8
    public void b(boolean z) {
        this.d = z;
    }

    @Override // ir.nasim.Sc8
    public void c(boolean z) {
        this.c = z;
    }

    class a extends CameraCaptureSession.StateCallback {
        a() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Surface inputSurface = cameraCaptureSession.getInputSurface();
            if (inputSurface != null) {
                Wc8.this.j = AbstractC18673p33.a(inputSurface, 1);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        }
    }
}
