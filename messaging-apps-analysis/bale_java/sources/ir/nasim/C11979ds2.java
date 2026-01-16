package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ds2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11979ds2 implements InterfaceC15283jK {
    private final int a;
    private final String b;
    private final List c;
    private final List d;

    public C11979ds2(int i, String str, List list, List list2) {
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(list, "addedPeers");
        AbstractC13042fc3.i(list2, "deletedPeers");
        this.a = i;
        this.b = str;
        this.c = list;
        this.d = list2;
    }

    public final List a() {
        return this.c;
    }

    public final List b() {
        return this.d;
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }
}
