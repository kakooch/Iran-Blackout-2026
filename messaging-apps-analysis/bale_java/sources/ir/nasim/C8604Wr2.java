package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Wr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8604Wr2 implements InterfaceC15283jK {
    private final int a;
    private final String b;
    private final int c;
    private final List d;

    public C8604Wr2(int i, String str, int i2, List list) {
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(list, "peers");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = list;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final List d() {
        return this.d;
    }
}
