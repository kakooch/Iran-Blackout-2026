package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public final class LK6 {
    private final long a;
    private final long b;
    private final ExPeer c;
    private final String d;
    private final String e;
    private final String f;
    private final Long g;
    private final EnumC4543Fo6 h;
    private final InterfaceC10839cH7 i;
    private final boolean j;
    private final InterfaceC19401qH7 k;
    private final ir.nasim.tgwidgets.editor.messenger.H l;

    public LK6(long j, long j2, ExPeer exPeer, String str, String str2, String str3, Long l, EnumC4543Fo6 enumC4543Fo6, InterfaceC10839cH7 interfaceC10839cH7, boolean z, InterfaceC19401qH7 interfaceC19401qH7, ir.nasim.tgwidgets.editor.messenger.H h) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "fileDescriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        AbstractC13042fc3.i(interfaceC10839cH7, "fileType");
        this.a = j;
        this.b = j2;
        this.c = exPeer;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = l;
        this.h = enumC4543Fo6;
        this.i = interfaceC10839cH7;
        this.j = z;
        this.k = interfaceC19401qH7;
        this.l = h;
    }

    public final String a() {
        return this.f;
    }

    public final boolean b() {
        return this.j;
    }

    public final ExPeer c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final InterfaceC10839cH7 f() {
        return this.i;
    }

    public final long g() {
        return this.a;
    }

    public final Long h() {
        return this.g;
    }

    public final EnumC4543Fo6 i() {
        return this.h;
    }

    public final long j() {
        return this.b;
    }

    public final InterfaceC19401qH7 k() {
        return this.k;
    }

    public final ir.nasim.tgwidgets.editor.messenger.H l() {
        return this.l;
    }
}
