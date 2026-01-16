package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.C12275eL0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class c implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final f fromModel(a aVar) {
        f fVar = new f();
        Set set = aVar.a;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((String) it.next()).getBytes(C12275eL0.b));
        }
        Object[] array = arrayList.toArray(new byte[0][]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        fVar.a = (byte[][]) array;
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.remotepermissions.impl.a toModel(io.appmetrica.analytics.remotepermissions.impl.f r7) {
        /*
            r6 = this;
            byte[][] r7 = r7.a
            if (r7 == 0) goto L23
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.length
            r0.<init>(r1)
            int r1 = r7.length
            r2 = 0
        Lc:
            if (r2 >= r1) goto L1d
            r3 = r7[r2]
            java.lang.String r4 = new java.lang.String
            java.nio.charset.Charset r5 = ir.nasim.C12275eL0.b
            r4.<init>(r3, r5)
            r0.add(r4)
            int r2 = r2 + 1
            goto Lc
        L1d:
            java.util.Set r7 = ir.nasim.ZW0.r1(r0)
            if (r7 != 0) goto L27
        L23:
            java.util.Set r7 = ir.nasim.AbstractC4129Du6.d()
        L27:
            io.appmetrica.analytics.remotepermissions.impl.a r0 = new io.appmetrica.analytics.remotepermissions.impl.a
            r0.<init>(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.remotepermissions.impl.c.toModel(io.appmetrica.analytics.remotepermissions.impl.f):io.appmetrica.analytics.remotepermissions.impl.a");
    }
}
