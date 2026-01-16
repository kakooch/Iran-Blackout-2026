package ir.nasim;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import ir.nasim.PX6;

/* loaded from: classes.dex */
abstract class RX6 implements PX6.a {
    final StreamConfigurationMap a;

    static class a {
        static Size[] a(StreamConfigurationMap streamConfigurationMap, int i) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i);
        }
    }

    RX6(StreamConfigurationMap streamConfigurationMap) {
        this.a = streamConfigurationMap;
    }

    @Override // ir.nasim.PX6.a
    public StreamConfigurationMap a() {
        return this.a;
    }

    @Override // ir.nasim.PX6.a
    public int[] c() {
        try {
            return this.a.getOutputFormats();
        } catch (IllegalArgumentException | NullPointerException e) {
            PI3.m("StreamConfigurationMapCompatBaseImpl", "Failed to get output formats from StreamConfigurationMap", e);
            return null;
        }
    }

    @Override // ir.nasim.PX6.a
    public Size[] d(int i) {
        return a.a(this.a, i);
    }
}
