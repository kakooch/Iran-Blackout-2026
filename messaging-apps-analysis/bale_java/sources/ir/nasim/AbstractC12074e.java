package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12074e {
    public static final List a(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? Collections.unmodifiableList(new ArrayList(list)) : Collections.singletonList(AbstractC15401jX0.q0(list)) : AbstractC10360bX0.m();
    }

    public static final Map b(Map map) {
        int size = map.size();
        if (size == 0) {
            return AbstractC20051rO3.k();
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) AbstractC15401jX0.p0(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }
}
