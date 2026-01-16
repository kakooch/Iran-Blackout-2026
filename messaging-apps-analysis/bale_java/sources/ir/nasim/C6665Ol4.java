package ir.nasim;

import android.content.res.Configuration;

/* renamed from: ir.nasim.Ol4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6665Ol4 {
    private final boolean a;
    private Configuration b;

    public C6665Ol4(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C6665Ol4(boolean z, Configuration configuration) {
        this(z);
        AbstractC13042fc3.i(configuration, "newConfig");
        this.b = configuration;
    }
}
