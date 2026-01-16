package ir.nasim;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;

/* loaded from: classes.dex */
class QX6 extends RX6 {
    QX6(StreamConfigurationMap streamConfigurationMap) {
        super(streamConfigurationMap);
    }

    @Override // ir.nasim.PX6.a
    public Size[] b(int i) {
        return this.a.getOutputSizes(i);
    }
}
