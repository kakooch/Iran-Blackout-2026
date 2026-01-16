package ir.nasim;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PX6 {
    private final a a;
    private final GN4 b;
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();

    interface a {
        StreamConfigurationMap a();

        Size[] b(int i);

        int[] c();

        Size[] d(int i);
    }

    private PX6(StreamConfigurationMap streamConfigurationMap, GN4 gn4) {
        this.a = new QX6(streamConfigurationMap);
        this.b = gn4;
    }

    static PX6 e(StreamConfigurationMap streamConfigurationMap, GN4 gn4) {
        return new PX6(streamConfigurationMap, gn4);
    }

    public Size[] a(int i) {
        if (this.d.containsKey(Integer.valueOf(i))) {
            if (((Size[]) this.d.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) this.d.get(Integer.valueOf(i))).clone();
        }
        Size[] sizeArrD = this.a.d(i);
        if (sizeArrD != null && sizeArrD.length > 0) {
            sizeArrD = this.b.b(sizeArrD, i);
        }
        this.d.put(Integer.valueOf(i), sizeArrD);
        if (sizeArrD != null) {
            return (Size[]) sizeArrD.clone();
        }
        return null;
    }

    public int[] b() {
        int[] iArrC = this.a.c();
        if (iArrC == null) {
            return null;
        }
        return (int[]) iArrC.clone();
    }

    public Size[] c(int i) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            if (((Size[]) this.c.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) this.c.get(Integer.valueOf(i))).clone();
        }
        Size[] sizeArrB = this.a.b(i);
        if (sizeArrB != null && sizeArrB.length != 0) {
            Size[] sizeArrB2 = this.b.b(sizeArrB, i);
            this.c.put(Integer.valueOf(i), sizeArrB2);
            return (Size[]) sizeArrB2.clone();
        }
        PI3.l("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
        return sizeArrB;
    }

    public StreamConfigurationMap d() {
        return this.a.a();
    }
}
