package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Te0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7781Te0 {
    private final List a;
    private final boolean b;
    private final int c;
    private final int d;

    public C7781Te0(List list, boolean z, int i, int i2) {
        this.a = list;
        this.b = z;
        this.c = i;
        this.d = i2;
    }

    public final int a() {
        return this.c;
    }

    public final List b() {
        return this.a;
    }

    public final int c() {
        return this.d;
    }

    public final boolean d() {
        return this.b;
    }

    public /* synthetic */ C7781Te0(List list, boolean z, int i, int i2, int i3, ED1 ed1) {
        this(list, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? 1 : i, (i3 & 8) != 0 ? 0 : i2);
    }
}
