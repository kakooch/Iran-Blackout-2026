package io.sentry.clientreport;

import io.sentry.EnumC3136k;
import io.sentry.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
final class b implements i {
    private final q a = new q(new q.a() { // from class: io.sentry.clientreport.a
        @Override // io.sentry.util.q.a
        public final Object a() {
            return b.d();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map d() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (f fVar : f.values()) {
            for (EnumC3136k enumC3136k : EnumC3136k.values()) {
                concurrentHashMap.put(new d(fVar.getReason(), enumC3136k.getCategory()), new AtomicLong(0L));
            }
        }
        return Collections.unmodifiableMap(concurrentHashMap);
    }

    @Override // io.sentry.clientreport.i
    public void a(d dVar, Long l) {
        AtomicLong atomicLong = (AtomicLong) ((Map) this.a.a()).get(dVar);
        if (atomicLong != null) {
            atomicLong.addAndGet(l.longValue());
        }
    }

    @Override // io.sentry.clientreport.i
    public List b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((Map) this.a.a()).entrySet()) {
            long andSet = ((AtomicLong) entry.getValue()).getAndSet(0L);
            Long lValueOf = Long.valueOf(andSet);
            if (andSet > 0) {
                arrayList.add(new g(((d) entry.getKey()).b(), ((d) entry.getKey()).a(), lValueOf));
            }
        }
        return arrayList;
    }
}
