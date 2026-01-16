package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import ir.nasim.C14935ij7;
import ir.nasim.C16051kd2;
import ir.nasim.MB0;
import ir.nasim.NB0;
import ir.nasim.OB0;
import ir.nasim.PB0;
import ir.nasim.PI3;
import ir.nasim.QB0;
import java.nio.BufferUnderflowException;
import java.util.Map;

/* loaded from: classes.dex */
class b implements QB0 {
    private final Map a;
    private C14935ij7 b;
    private final long c;

    b(long j, C14935ij7 c14935ij7, Map map) {
        this.a = map;
        this.b = c14935ij7;
        this.c = j;
    }

    @Override // ir.nasim.QB0
    public void a(C16051kd2.b bVar) {
        super.a(bVar);
        try {
            Integer num = (Integer) this.a.get(CaptureResult.JPEG_ORIENTATION);
            if (num != null) {
                bVar.m(num.intValue());
            }
        } catch (BufferUnderflowException unused) {
            PI3.l("KeyValueMapCameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l = (Long) this.a.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l != null) {
            bVar.f(l.longValue());
        }
        Float f = (Float) this.a.get(CaptureResult.LENS_APERTURE);
        if (f != null) {
            bVar.l(f.floatValue());
        }
        Integer numValueOf = (Integer) this.a.get(CaptureResult.SENSOR_SENSITIVITY);
        if (numValueOf != null) {
            if (((Integer) this.a.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)) != null) {
                numValueOf = Integer.valueOf(numValueOf.intValue() * ((int) (r1.intValue() / 100.0f)));
            }
            bVar.k(numValueOf.intValue());
        }
        Float f2 = (Float) this.a.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f2 != null) {
            bVar.h(f2.floatValue());
        }
        Integer num2 = (Integer) this.a.get(CaptureResult.CONTROL_AWB_MODE);
        if (num2 != null) {
            C16051kd2.c cVar = C16051kd2.c.AUTO;
            if (num2.intValue() == 0) {
                cVar = C16051kd2.c.MANUAL;
            }
            bVar.n(cVar);
        }
    }

    @Override // ir.nasim.QB0
    public C14935ij7 b() {
        return this.b;
    }

    @Override // ir.nasim.QB0
    public PB0 c() {
        Integer num = (Integer) this.a.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return PB0.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 1) {
            return PB0.NONE;
        }
        if (iIntValue == 2) {
            return PB0.READY;
        }
        if (iIntValue == 3 || iIntValue == 4) {
            return PB0.FIRED;
        }
        PI3.c("KeyValueMapCameraCaptureResult", "Undefined flash state: " + num);
        return PB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public CaptureResult d() {
        return null;
    }

    @Override // ir.nasim.QB0
    public NB0 e() {
        Integer num = (Integer) this.a.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return NB0.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                break;
            case 1:
            case 3:
                break;
            case 2:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                PI3.c("KeyValueMapCameraCaptureResult", "Undefined af state: " + num);
                break;
        }
        return NB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public OB0 f() {
        Integer num = (Integer) this.a.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return OB0.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return OB0.INACTIVE;
        }
        if (iIntValue == 1) {
            return OB0.METERING;
        }
        if (iIntValue == 2) {
            return OB0.CONVERGED;
        }
        if (iIntValue == 3) {
            return OB0.LOCKED;
        }
        PI3.c("KeyValueMapCameraCaptureResult", "Undefined awb state: " + num);
        return OB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public MB0 g() {
        Integer num = (Integer) this.a.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return MB0.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return MB0.INACTIVE;
        }
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return MB0.CONVERGED;
            }
            if (iIntValue == 3) {
                return MB0.LOCKED;
            }
            if (iIntValue == 4) {
                return MB0.FLASH_REQUIRED;
            }
            if (iIntValue != 5) {
                PI3.c("KeyValueMapCameraCaptureResult", "Undefined ae state: " + num);
                return MB0.UNKNOWN;
            }
        }
        return MB0.SEARCHING;
    }

    @Override // ir.nasim.QB0
    public long getTimestamp() {
        return this.c;
    }
}
