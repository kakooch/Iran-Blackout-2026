package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import ir.nasim.AbstractC19849r27;
import ir.nasim.InterfaceC5592Jz5;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes.dex */
public class ExtraCroppingQuirk implements InterfaceC5592Jz5 {
    private static final Map a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC19849r27.b.values().length];
            a = iArr;
            try {
                iArr[AbstractC19849r27.b.PRIV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbstractC19849r27.b.YUV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbstractC19849r27.b.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("SM-T580", null);
        map.put("SM-J710MN", new Range(21, 26));
        map.put("SM-A320FL", null);
        map.put("SM-G570M", null);
        map.put("SM-G610F", null);
        map.put("SM-G610M", new Range(21, 26));
    }

    private static boolean d() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        Map map = a;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (!map.containsKey(str.toUpperCase(locale))) {
            return false;
        }
        Range range = (Range) map.get(str.toUpperCase(locale));
        if (range == null) {
            return true;
        }
        return range.contains((Range) Integer.valueOf(Build.VERSION.SDK_INT));
    }

    static boolean e() {
        return d();
    }

    public Size c(AbstractC19849r27.b bVar) {
        if (!d()) {
            return null;
        }
        int i = a.a[bVar.ordinal()];
        if (i == 1) {
            return new Size(1920, 1080);
        }
        if (i == 2) {
            return new Size(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 720);
        }
        if (i != 3) {
            return null;
        }
        return new Size(3264, 1836);
    }
}
