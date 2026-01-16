package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.qC0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C19349qC0 {
    private final a b;
    private final String c;
    private final Map a = new HashMap();
    private PX6 d = null;

    /* renamed from: ir.nasim.qC0$a */
    public interface a {
        Object a(CameraCharacteristics.Key key);
    }

    private C19349qC0(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = new C17576nC0(cameraCharacteristics);
        } else {
            this.b = new C18167oC0(cameraCharacteristics);
        }
        this.c = str;
    }

    private boolean c(CameraCharacteristics.Key key) {
        return key.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    public static C19349qC0 e(CameraCharacteristics cameraCharacteristics, String str) {
        return new C19349qC0(cameraCharacteristics, str);
    }

    public Object a(CameraCharacteristics.Key key) {
        if (c(key)) {
            return this.b.a(key);
        }
        synchronized (this) {
            try {
                Object obj = this.a.get(key);
                if (obj != null) {
                    return obj;
                }
                Object objA = this.b.a(key);
                if (objA != null) {
                    this.a.put(key, objA);
                }
                return objA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PX6 b() {
        if (this.d == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
                this.d = PX6.e(streamConfigurationMap, new GN4(this.c));
            } catch (AssertionError | NullPointerException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return this.d;
    }

    public boolean d() {
        int[] iArr;
        if (Build.VERSION.SDK_INT >= 34 && (iArr = (int[]) this.b.a(CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES)) != null) {
            for (int i : iArr) {
                if (i == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
