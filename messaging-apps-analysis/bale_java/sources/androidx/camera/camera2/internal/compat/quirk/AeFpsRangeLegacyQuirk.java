package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class AeFpsRangeLegacyQuirk implements InterfaceC5592Jz5 {
    private final Range a;

    public AeFpsRangeLegacyQuirk(C19349qC0 c19349qC0) {
        this.a = f((Range[]) c19349qC0.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    private Range c(Range range) {
        int iIntValue = ((Integer) range.getUpper()).intValue();
        int iIntValue2 = ((Integer) range.getLower()).intValue();
        if (((Integer) range.getUpper()).intValue() >= 1000) {
            iIntValue = ((Integer) range.getUpper()).intValue() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        }
        if (((Integer) range.getLower()).intValue() >= 1000) {
            iIntValue2 = ((Integer) range.getLower()).intValue() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        }
        return new Range(Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue));
    }

    static boolean e(C19349qC0 c19349qC0) {
        Integer num = (Integer) c19349qC0.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    private Range f(Range[] rangeArr) {
        Range range = null;
        if (rangeArr != null && rangeArr.length != 0) {
            for (Range range2 : rangeArr) {
                Range rangeC = c(range2);
                if (((Integer) rangeC.getUpper()).intValue() == 30 && (range == null || ((Integer) rangeC.getLower()).intValue() < ((Integer) range.getLower()).intValue())) {
                    range = rangeC;
                }
            }
        }
        return range;
    }

    public Range d() {
        return this.a;
    }
}
