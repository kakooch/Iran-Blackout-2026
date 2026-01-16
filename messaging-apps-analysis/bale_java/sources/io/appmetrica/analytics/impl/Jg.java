package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Jg implements InterfaceC2693lm {
    public final /* synthetic */ C2513e9 a;
    public final /* synthetic */ Mg b;

    public Jg(Mg mg, C2513e9 c2513e9) {
        this.b = mg;
        this.a = c2513e9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2693lm
    public final void a(Object obj) {
        List list = (List) obj;
        C2513e9 c2513e9 = this.a;
        if (hn.a((Collection) list)) {
            return;
        }
        c2513e9.d = new C2463c9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C2596hk c2596hk = (C2596hk) list.get(i);
            C2463c9[] c2463c9Arr = c2513e9.d;
            Map map = AbstractC2444bf.a;
            C2463c9 c2463c9 = new C2463c9();
            Integer num = c2596hk.a;
            if (num != null) {
                c2463c9.a = num.intValue();
            }
            Integer num2 = c2596hk.b;
            if (num2 != null) {
                c2463c9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c2596hk.d)) {
                c2463c9.c = c2596hk.d;
            }
            c2463c9.d = c2596hk.c;
            c2463c9Arr[i] = c2463c9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(c2513e9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
