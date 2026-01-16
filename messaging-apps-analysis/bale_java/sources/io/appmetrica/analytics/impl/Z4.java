package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public abstract class Z4 {
    public final C2484d5 a;
    public final String b = "[ComponentMigrationToV113]";

    public Z4(C2484d5 c2484d5) {
        this.a = c2484d5;
    }

    public final C2484d5 a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public abstract boolean b(int i);

    public abstract void c();

    public final void a(int i) {
        if (b(i)) {
            c();
        }
    }
}
