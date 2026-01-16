package ir.nasim;

import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Qx5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7252Qx5 {
    public static final int i = 8;
    private final AbstractC8979Yb1 a;
    private final boolean b;
    private final ZG6 c;
    private final InterfaceC9102Ym4 d;
    private final UA2 e;
    private final boolean f;
    private final Object g;
    private boolean h = true;

    public C7252Qx5(AbstractC8979Yb1 abstractC8979Yb1, Object obj, boolean z, ZG6 zg6, InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2, boolean z2) {
        this.a = abstractC8979Yb1;
        this.b = z;
        this.c = zg6;
        this.d = interfaceC9102Ym4;
        this.e = ua2;
        this.f = z2;
        this.g = obj;
    }

    public final boolean a() {
        return this.h;
    }

    public final AbstractC8979Yb1 b() {
        return this.a;
    }

    public final UA2 c() {
        return this.e;
    }

    public final Object d() {
        if (this.b) {
            return null;
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
        if (interfaceC9102Ym4 != null) {
            return interfaceC9102Ym4.getValue();
        }
        Object obj = this.g;
        if (obj != null) {
            return obj;
        }
        AbstractC5138Ib1.t("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
    }

    public final ZG6 e() {
        return this.c;
    }

    public final InterfaceC9102Ym4 f() {
        return this.d;
    }

    public final Object g() {
        return this.g;
    }

    public final C7252Qx5 h() {
        this.h = false;
        return this;
    }

    public final boolean i() {
        return this.f;
    }

    public final boolean j() {
        return (this.b || g() != null) && !this.f;
    }
}
