package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Gd implements W7 {
    public final Jd a;
    public final A3 b;
    public final C2705ma c;
    public final Ve d;

    public Gd() {
        this(new Jd(), new A3(), new C2705ma(100), new Ve());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<Rh> fromModel(Fd fd) {
        Rh rhFromModel;
        C2775p8 c2775p8 = new C2775p8();
        c2775p8.a = fd.a;
        c2775p8.f = new C2512e8();
        Hd hd = fd.b;
        C2462c8 c2462c8 = new C2462c8();
        c2462c8.a = StringUtils.getUTF8Bytes(hd.a);
        Im imA = this.c.a(hd.b);
        c2462c8.b = StringUtils.getUTF8Bytes((String) imA.a);
        c2462c8.e = hd.c.size();
        Map<String, String> map = hd.d;
        if (map != null) {
            rhFromModel = this.a.fromModel(map);
            c2462c8.c = (C2560g8) rhFromModel.a;
        } else {
            rhFromModel = null;
        }
        c2775p8.f.a = c2462c8;
        C2817r3 c2817r3 = new C2817r3(C2817r3.b(imA, rhFromModel));
        List list = hd.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int iComputeInt32Size = c2775p8.a != new C2775p8().a ? CodedOutputByteBufferNano.computeInt32Size(1, c2775p8.a) : 0;
        C2751o8 c2751o8 = c2775p8.b;
        if (c2751o8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, c2751o8);
        }
        C2703m8 c2703m8 = c2775p8.c;
        if (c2703m8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c2703m8);
        }
        C2727n8 c2727n8 = c2775p8.d;
        int i = 4;
        if (c2727n8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, c2727n8);
        }
        Y7 y7 = c2775p8.e;
        if (y7 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, y7);
        }
        C2512e8 c2512e8 = c2775p8.f;
        if (c2512e8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c2512e8);
        }
        ArrayList arrayList2 = new ArrayList();
        C2775p8 c2775p82 = new C2775p8();
        c2775p82.a = c2775p8.a;
        C2512e8 c2512e82 = new C2512e8();
        c2775p82.f = c2512e82;
        c2512e82.a = new C2462c8();
        C2462c8 c2462c82 = c2775p82.f.a;
        C2462c8 c2462c83 = c2775p8.f.a;
        c2462c82.b = c2462c83.b;
        c2462c82.a = c2462c83.a;
        c2462c82.e = c2462c83.e;
        c2462c82.c = c2462c83.c;
        int i2 = 0;
        C2817r3 c2817r32 = c2817r3;
        int i3 = iComputeInt32Size;
        while (i2 < list.size()) {
            B3 b3 = (B3) list.get(i2);
            C2487d8 c2487d8 = new C2487d8();
            c2487d8.a = i2;
            Rh rhFromModel2 = this.b.fromModel(b3);
            c2487d8.b = (Z7) rhFromModel2.a;
            rhFromModel2.b.getBytesTruncated();
            Rh rh = new Rh(c2487d8, rhFromModel2);
            Ve ve = this.d;
            C2487d8 c2487d82 = (C2487d8) rh.a;
            ve.getClass();
            int iComputeTagSize = CodedOutputByteBufferNano.computeTagSize(i);
            int iComputeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag(c2487d82);
            int iComputeRawVarint32Size = iComputeTagSize + iComputeMessageSizeNoTag + ((iComputeMessageSizeNoTag & (-128)) == 0 ? 0 : CodedOutputByteBufferNano.computeRawVarint32Size(iComputeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i3 + iComputeRawVarint32Size > 204800) {
                c2775p82.f.a.d = (C2487d8[]) arrayList2.toArray(new C2487d8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Rh(c2775p82, c2817r32));
                C2775p8 c2775p83 = new C2775p8();
                c2775p83.a = c2775p8.a;
                C2512e8 c2512e83 = new C2512e8();
                c2775p83.f = c2512e83;
                c2512e83.a = new C2462c8();
                C2462c8 c2462c84 = c2775p83.f.a;
                C2462c8 c2462c85 = c2775p8.f.a;
                c2462c84.b = c2462c85.b;
                c2462c84.a = c2462c85.a;
                c2462c84.e = c2462c85.e;
                c2462c84.c = c2462c85.c;
                c2817r32 = c2817r3;
                i3 = iComputeInt32Size;
                c2775p82 = c2775p83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C2487d8) rh.a);
            c2817r32 = new C2817r3(C2817r3.b(c2817r32, rh.b));
            i3 += iComputeRawVarint32Size;
            i2++;
            i = 4;
        }
        c2775p82.f.a.d = (C2487d8[]) arrayList2.toArray(new C2487d8[arrayList2.size()]);
        arrayList.add(new Rh(c2775p82, c2817r32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Gd(Jd jd, A3 a3, C2705ma c2705ma, Ve ve) {
        this.a = jd;
        this.b = a3;
        this.c = c2705ma;
        this.d = ve;
    }

    public final Fd a(List<Rh> list) {
        throw new UnsupportedOperationException();
    }
}
