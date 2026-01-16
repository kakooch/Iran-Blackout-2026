package ir.nasim;

import android.hardware.camera2.params.DynamicRangeProfiles;
import ir.nasim.C19253q22;
import java.util.Collections;
import java.util.Set;

/* renamed from: ir.nasim.s22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C20453s22 implements C19253q22.a {
    static final C19253q22 a = new C19253q22(new C20453s22());
    private static final Set b = Collections.singleton(C15116j22.d);

    C20453s22() {
    }

    @Override // ir.nasim.C19253q22.a
    public DynamicRangeProfiles a() {
        return null;
    }

    @Override // ir.nasim.C19253q22.a
    public Set b(C15116j22 c15116j22) {
        AbstractC4980Hj5.b(C15116j22.d.equals(c15116j22), "DynamicRange is not supported: " + c15116j22);
        return b;
    }

    @Override // ir.nasim.C19253q22.a
    public Set c() {
        return b;
    }
}
