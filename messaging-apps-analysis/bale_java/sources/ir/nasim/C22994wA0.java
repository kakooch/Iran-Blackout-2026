package ir.nasim;

import android.hardware.camera2.CaptureResult;
import ir.nasim.C16051kd2;
import java.nio.BufferUnderflowException;

/* renamed from: ir.nasim.wA0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C22994wA0 implements QB0 {
    private final C14935ij7 a;
    private final CaptureResult b;

    public C22994wA0(C14935ij7 c14935ij7, CaptureResult captureResult) {
        this.a = c14935ij7;
        this.b = captureResult;
    }

    @Override // ir.nasim.QB0
    public void a(C16051kd2.b bVar) {
        super.a(bVar);
        try {
            Integer num = (Integer) this.b.get(CaptureResult.JPEG_ORIENTATION);
            if (num != null) {
                bVar.m(num.intValue());
            }
        } catch (BufferUnderflowException unused) {
            PI3.l("C2CameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l = (Long) this.b.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l != null) {
            bVar.f(l.longValue());
        }
        Float f = (Float) this.b.get(CaptureResult.LENS_APERTURE);
        if (f != null) {
            bVar.l(f.floatValue());
        }
        Integer numValueOf = (Integer) this.b.get(CaptureResult.SENSOR_SENSITIVITY);
        if (numValueOf != null) {
            if (((Integer) this.b.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)) != null) {
                numValueOf = Integer.valueOf(numValueOf.intValue() * ((int) (r1.intValue() / 100.0f)));
            }
            bVar.k(numValueOf.intValue());
        }
        Float f2 = (Float) this.b.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f2 != null) {
            bVar.h(f2.floatValue());
        }
        Integer num2 = (Integer) this.b.get(CaptureResult.CONTROL_AWB_MODE);
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
        return this.a;
    }

    @Override // ir.nasim.QB0
    public PB0 c() {
        Integer num = (Integer) this.b.get(CaptureResult.FLASH_STATE);
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
        PI3.c("C2CameraCaptureResult", "Undefined flash state: " + num);
        return PB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public CaptureResult d() {
        return this.b;
    }

    @Override // ir.nasim.QB0
    public NB0 e() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AF_STATE);
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
                PI3.c("C2CameraCaptureResult", "Undefined af state: " + num);
                break;
        }
        return NB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public OB0 f() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AWB_STATE);
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
        PI3.c("C2CameraCaptureResult", "Undefined awb state: " + num);
        return OB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public MB0 g() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AE_STATE);
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
                PI3.c("C2CameraCaptureResult", "Undefined ae state: " + num);
                return MB0.UNKNOWN;
            }
        }
        return MB0.SEARCHING;
    }

    @Override // ir.nasim.QB0
    public long getTimestamp() {
        Long l = (Long) this.b.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }
}
