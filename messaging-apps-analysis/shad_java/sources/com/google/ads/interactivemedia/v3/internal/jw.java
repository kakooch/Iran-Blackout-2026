package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jw implements kc {
    private static final int[] a = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7};
    private static final Constructor<? extends jy> b;
    private final int c = 1;
    private final int d = 112800;

    static {
        Constructor<? extends jy> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.ads.interactivemedia.v3.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.google.ads.interactivemedia.v3.exoplayer2.ext.flac.FlacExtractor").asSubclass(jy.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating FLAC extension", e);
        }
        b = constructor;
    }

    private final void c(int i, List<jy> list) {
        switch (i) {
            case 0:
                list.add(new nw());
                return;
            case 1:
                list.add(new nz());
                return;
            case 2:
                list.add(new oc(null));
                return;
            case 3:
                list.add(new kx(null));
                return;
            case 4:
                Constructor<? extends jy> constructor = b;
                if (constructor == null) {
                    list.add(new lc(null));
                    return;
                }
                try {
                    list.add(constructor.newInstance(0));
                    return;
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                }
            case 5:
                list.add(new lf());
                return;
            case 6:
                list.add(new lr(0));
                return;
            case 7:
                list.add(new ly((byte[]) null));
                return;
            case 8:
                list.add(new ms(null));
                list.add(new mx(null));
                return;
            case 9:
                list.add(new nk());
                return;
            case 10:
                list.add(new pc());
                return;
            case 11:
                list.add(new pm(1, 112800));
                return;
            case 12:
                list.add(new px());
                return;
            default:
                return;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kc
    public final synchronized jy[] a() {
        return b(Uri.EMPTY, new HashMap());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kc
    public final synchronized jy[] b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int iP = aqd.p(map);
        if (iP != -1) {
            c(iP, arrayList);
        }
        int iR = aqd.r(uri);
        if (iR != -1 && iR != iP) {
            c(iR, arrayList);
        }
        int[] iArr = a;
        int length = iArr.length;
        for (int i = 0; i < 13; i++) {
            int i2 = iArr[i];
            if (i2 != iP && i2 != iR) {
                c(i2, arrayList);
            }
        }
        return (jy[]) arrayList.toArray(new jy[arrayList.size()]);
    }
}
