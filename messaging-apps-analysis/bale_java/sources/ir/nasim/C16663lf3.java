package ir.nasim;

import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.lf3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C16663lf3 extends CancellationException {
    private final int a;
    private final C6233Mt b;

    public C16663lf3(int i, C6233Mt c6233Mt) {
        this.a = i;
        this.b = c6233Mt;
    }

    public final int a() {
        return this.a;
    }

    public final C6233Mt b() {
        return this.b;
    }
}
