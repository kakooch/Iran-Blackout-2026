package ir.nasim;

import android.hardware.camera2.params.DynamicRangeProfiles;
import ir.nasim.C19253q22;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.r22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C19844r22 implements C19253q22.a {
    private final DynamicRangeProfiles a;

    C19844r22(Object obj) {
        this.a = (DynamicRangeProfiles) obj;
    }

    private Long d(C15116j22 c15116j22) {
        return AbstractC16298l22.a(c15116j22, this.a);
    }

    private static Set e(Set set) {
        if (set.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(f(((Long) it.next()).longValue()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static C15116j22 f(long j) {
        return (C15116j22) AbstractC4980Hj5.h(AbstractC16298l22.b(j), "Dynamic range profile cannot be converted to a DynamicRange object: " + j);
    }

    @Override // ir.nasim.C19253q22.a
    public DynamicRangeProfiles a() {
        return this.a;
    }

    @Override // ir.nasim.C19253q22.a
    public Set b(C15116j22 c15116j22) {
        Long lD = d(c15116j22);
        AbstractC4980Hj5.b(lD != null, "DynamicRange is not supported: " + c15116j22);
        return e(this.a.getProfileCaptureRequestConstraints(lD.longValue()));
    }

    @Override // ir.nasim.C19253q22.a
    public Set c() {
        return e(this.a.getSupportedProfiles());
    }
}
