package ir.nasim;

import android.content.res.Configuration;

/* renamed from: ir.nasim.md5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17236md5 {
    private final boolean a;
    private Configuration b;

    public C17236md5(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C17236md5(boolean z, Configuration configuration) {
        this(z);
        AbstractC13042fc3.i(configuration, "newConfig");
        this.b = configuration;
    }
}
