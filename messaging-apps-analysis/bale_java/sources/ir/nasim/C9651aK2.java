package ir.nasim;

import android.graphics.Path;

/* renamed from: ir.nasim.aK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C9651aK2 implements InterfaceC9904al1 {
    private final EnumC13495gK2 a;
    private final Path.FillType b;
    private final C17971ns c;
    private final C18562os d;
    private final C20944ss e;
    private final C20944ss f;
    private final String g;
    private final C17380ms h;
    private final C17380ms i;
    private final boolean j;

    public C9651aK2(String str, EnumC13495gK2 enumC13495gK2, Path.FillType fillType, C17971ns c17971ns, C18562os c18562os, C20944ss c20944ss, C20944ss c20944ss2, C17380ms c17380ms, C17380ms c17380ms2, boolean z) {
        this.a = enumC13495gK2;
        this.b = fillType;
        this.c = c17971ns;
        this.d = c18562os;
        this.e = c20944ss;
        this.f = c20944ss2;
        this.g = str;
        this.h = c17380ms;
        this.i = c17380ms2;
        this.j = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new C10245bK2(qVar, c23677xK3, abstractC3236Aa0, this);
    }

    public C20944ss b() {
        return this.f;
    }

    public Path.FillType c() {
        return this.b;
    }

    public C17971ns d() {
        return this.c;
    }

    public EnumC13495gK2 e() {
        return this.a;
    }

    public String f() {
        return this.g;
    }

    public C18562os g() {
        return this.d;
    }

    public C20944ss h() {
        return this.e;
    }

    public boolean i() {
        return this.j;
    }
}
