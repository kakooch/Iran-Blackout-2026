package androidx.camera.core.impl;

import androidx.camera.core.impl.j;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.C15116j22;

/* loaded from: classes.dex */
public interface n extends u {
    public static final j.a h = j.a.a("camerax.core.imageInput.inputFormat", Integer.TYPE);
    public static final j.a i = j.a.a("camerax.core.imageInput.inputDynamicRange", C15116j22.class);

    default C15116j22 F() {
        return (C15116j22) AbstractC4980Hj5.g((C15116j22) g(i, C15116j22.c));
    }

    default int getInputFormat() {
        return ((Integer) a(h)).intValue();
    }
}
