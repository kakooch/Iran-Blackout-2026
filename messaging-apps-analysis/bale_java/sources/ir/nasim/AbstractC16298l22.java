package ir.nasim;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.internal.ws.RealWebSocket;

/* renamed from: ir.nasim.l22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC16298l22 {
    private static final Map a;
    private static final Map b;

    static {
        HashMap map = new HashMap();
        a = map;
        HashMap map2 = new HashMap();
        b = map2;
        C15116j22 c15116j22 = C15116j22.d;
        map.put(1L, c15116j22);
        map2.put(c15116j22, Collections.singletonList(1L));
        map.put(2L, C15116j22.f);
        map2.put((C15116j22) map.get(2L), Collections.singletonList(2L));
        C15116j22 c15116j222 = C15116j22.g;
        map.put(4L, c15116j222);
        map2.put(c15116j222, Collections.singletonList(4L));
        C15116j22 c15116j223 = C15116j22.h;
        map.put(8L, c15116j223);
        map2.put(c15116j223, Collections.singletonList(8L));
        List listAsList = Arrays.asList(64L, 128L, 16L, 32L);
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            a.put((Long) it.next(), C15116j22.i);
        }
        b.put(C15116j22.i, listAsList);
        List listAsList2 = Arrays.asList(Long.valueOf(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE), 2048L, 256L, 512L);
        Iterator it2 = listAsList2.iterator();
        while (it2.hasNext()) {
            a.put((Long) it2.next(), C15116j22.j);
        }
        b.put(C15116j22.j, listAsList2);
    }

    public static Long a(C15116j22 c15116j22, DynamicRangeProfiles dynamicRangeProfiles) {
        List<Long> list = (List) b.get(c15116j22);
        if (list == null) {
            return null;
        }
        Set supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l : list) {
            if (supportedProfiles.contains(l)) {
                return l;
            }
        }
        return null;
    }

    public static C15116j22 b(long j) {
        return (C15116j22) a.get(Long.valueOf(j));
    }
}
