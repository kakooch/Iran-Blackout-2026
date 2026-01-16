package ir.nasim;

import android.graphics.Path;

/* renamed from: ir.nasim.px6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19209px6 implements InterfaceC9904al1 {
    private final boolean a;
    private final Path.FillType b;
    private final String c;
    private final C16789ls d;
    private final C18562os e;
    private final boolean f;

    public C19209px6(String str, boolean z, Path.FillType fillType, C16789ls c16789ls, C18562os c18562os, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = c16789ls;
        this.e = c18562os;
        this.f = z2;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new C8834Xn2(qVar, abstractC3236Aa0, this);
    }

    public C16789ls b() {
        return this.d;
    }

    public Path.FillType c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public C18562os e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
