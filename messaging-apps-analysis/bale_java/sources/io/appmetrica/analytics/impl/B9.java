package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.C12275eL0;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class B9 extends AbstractC2568gg {
    public final C9 b;

    public B9(C2484d5 c2484d5, TimeProvider timeProvider) {
        super(c2484d5);
        this.b = new C9(c2484d5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        long jOptLong;
        C9 c9 = this.b;
        C2919v9 c2919v9 = c9.a.t().C;
        Long lValueOf = c2919v9 != null ? Long.valueOf(c2919v9.a) : null;
        if (lValueOf != null) {
            tn tnVar = c9.a.v;
            synchronized (tnVar) {
                jOptLong = tnVar.a.a().optLong("external_attribution_window_start", -1L);
            }
            if (jOptLong < 0) {
                jOptLong = c9.b.currentTimeMillis();
                c9.a.v.a(jOptLong);
            }
            if (c9.b.currentTimeMillis() - jOptLong <= lValueOf.longValue()) {
                C2895u9 c2895u9 = (C2895u9) MessageNano.mergeFrom(new C2895u9(), q5.getValueBytes());
                int i = c2895u9.a;
                String str = new String(c2895u9.b, C12275eL0.b);
                if (this.b.a.c.j().get(Integer.valueOf(i)) != null) {
                    try {
                        if (!(!JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(r10)))) {
                            this.a.n.info("Ignoring attribution of type `" + E9.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C9 c92 = this.b;
                Map<Integer, String> mapJ = c92.a.c.j();
                mapJ.put(Integer.valueOf(i), str);
                c92.a.c.a(mapJ);
                this.a.n.info("Handling attribution of type `" + E9.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.a.n.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
