package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.pa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2777pa extends J2 {
    public final C2705ma b;
    public final C2705ma c;
    public final C2753oa d;

    public C2777pa(int i, int i2, int i3) {
        this(i, new C2705ma(i2), new C2705ma(i3));
    }

    public C2777pa(int i, C2705ma c2705ma, C2705ma c2705ma2) {
        super(i);
        this.d = new C2753oa();
        this.b = c2705ma;
        this.c = c2705ma2;
    }

    @Override // io.appmetrica.analytics.impl.J2, io.appmetrica.analytics.impl.InterfaceC2729na
    public final Im a(Map<String, String> map) {
        HashMap map2;
        int bytesTruncated;
        int i = 0;
        if (map != null) {
            map2 = new HashMap();
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            Map.Entry[] entryArr = (Map.Entry[]) setEntrySet.toArray(new Map.Entry[setEntrySet.size()]);
            Arrays.sort(entryArr, this.d);
            int length = entryArr.length;
            bytesTruncated = 0;
            int i2 = 0;
            boolean z = false;
            int i3 = 0;
            while (i < length) {
                Map.Entry entry = entryArr[i];
                Im imA = this.b.a((String) entry.getKey());
                Im imA2 = this.c.a((String) entry.getValue());
                int utf8BytesLength = StringUtils.getUtf8BytesLength((String) entry.getValue()) + StringUtils.getUtf8BytesLength((String) entry.getKey());
                int utf8BytesLength2 = StringUtils.getUtf8BytesLength((String) imA2.a) + StringUtils.getUtf8BytesLength((String) imA.a);
                if (z || utf8BytesLength2 + i3 > this.a) {
                    i2++;
                    bytesTruncated += utf8BytesLength;
                    z = true;
                } else {
                    bytesTruncated = imA2.b.getBytesTruncated() + imA.b.getBytesTruncated() + bytesTruncated;
                    int utf8BytesLength3 = StringUtils.getUtf8BytesLength((String) imA2.a) + StringUtils.getUtf8BytesLength((String) imA.a) + i3;
                    map2.put((String) imA.a, (String) imA2.a);
                    i3 = utf8BytesLength3;
                }
                i++;
            }
            i = i2;
        } else {
            map2 = null;
            bytesTruncated = 0;
        }
        return new Im(map2, new C2986y4(i, bytesTruncated));
    }
}
