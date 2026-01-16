package ir.nasim;

import androidx.camera.core.impl.j;

/* renamed from: ir.nasim.yj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC24505yj7 extends androidx.camera.core.impl.u {
    public static final j.a F = j.a.a("camerax.core.target.name", String.class);
    public static final j.a G = j.a.a("camerax.core.target.class", Class.class);

    default String P() {
        return (String) a(F);
    }

    default String s(String str) {
        return (String) g(F, str);
    }
}
