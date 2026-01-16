package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.dn2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC11930dn2 extends AbstractC11308cn2 {
    public static final C4521Fm2 l(File file, EnumC9334Zm2 enumC9334Zm2) {
        AbstractC13042fc3.i(file, "<this>");
        AbstractC13042fc3.i(enumC9334Zm2, "direction");
        return new C4521Fm2(file, enumC9334Zm2);
    }

    public static final C4521Fm2 m(File file) {
        AbstractC13042fc3.i(file, "<this>");
        return l(file, EnumC9334Zm2.b);
    }
}
