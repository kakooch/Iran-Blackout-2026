package io.livekit.android.room;

import android.content.Context;
import io.livekit.android.room.h;
import io.livekit.android.room.participant.a;
import io.livekit.android.room.participant.d;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC24096y22;
import ir.nasim.C19977rG1;
import ir.nasim.C6952Pr3;
import ir.nasim.F53;
import ir.nasim.IN;
import ir.nasim.IO;
import ir.nasim.InterfaceC10670c01;
import ir.nasim.InterfaceC24893zO;
import ir.nasim.InterfaceC3503Bd1;
import ir.nasim.InterfaceC7720Sx5;
import ir.nasim.UA2;
import ir.nasim.ZV0;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.audio.AudioDeviceModule;

/* loaded from: classes3.dex */
public final class j {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;
    private final InterfaceC7720Sx5 f;
    private final InterfaceC7720Sx5 g;
    private final InterfaceC7720Sx5 h;
    private final InterfaceC7720Sx5 i;
    private final InterfaceC7720Sx5 j;
    private final InterfaceC7720Sx5 k;
    private final InterfaceC7720Sx5 l;
    private final InterfaceC7720Sx5 m;
    private final InterfaceC7720Sx5 n;
    private final InterfaceC7720Sx5 o;
    private final InterfaceC7720Sx5 p;
    private final InterfaceC7720Sx5 q;
    private final InterfaceC7720Sx5 r;
    private final InterfaceC7720Sx5 s;

    public j(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58, InterfaceC7720Sx5 interfaceC7720Sx59, InterfaceC7720Sx5 interfaceC7720Sx510, InterfaceC7720Sx5 interfaceC7720Sx511, InterfaceC7720Sx5 interfaceC7720Sx512, InterfaceC7720Sx5 interfaceC7720Sx513, InterfaceC7720Sx5 interfaceC7720Sx514, InterfaceC7720Sx5 interfaceC7720Sx515, InterfaceC7720Sx5 interfaceC7720Sx516, InterfaceC7720Sx5 interfaceC7720Sx517, InterfaceC7720Sx5 interfaceC7720Sx518, InterfaceC7720Sx5 interfaceC7720Sx519) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
        this.f = interfaceC7720Sx56;
        this.g = interfaceC7720Sx57;
        this.h = interfaceC7720Sx58;
        this.i = interfaceC7720Sx59;
        this.j = interfaceC7720Sx510;
        this.k = interfaceC7720Sx511;
        this.l = interfaceC7720Sx512;
        this.m = interfaceC7720Sx513;
        this.n = interfaceC7720Sx514;
        this.o = interfaceC7720Sx515;
        this.p = interfaceC7720Sx516;
        this.q = interfaceC7720Sx517;
        this.r = interfaceC7720Sx518;
        this.s = interfaceC7720Sx519;
    }

    public static j a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58, InterfaceC7720Sx5 interfaceC7720Sx59, InterfaceC7720Sx5 interfaceC7720Sx510, InterfaceC7720Sx5 interfaceC7720Sx511, InterfaceC7720Sx5 interfaceC7720Sx512, InterfaceC7720Sx5 interfaceC7720Sx513, InterfaceC7720Sx5 interfaceC7720Sx514, InterfaceC7720Sx5 interfaceC7720Sx515, InterfaceC7720Sx5 interfaceC7720Sx516, InterfaceC7720Sx5 interfaceC7720Sx517, InterfaceC7720Sx5 interfaceC7720Sx518, InterfaceC7720Sx5 interfaceC7720Sx519) {
        return new j(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56, interfaceC7720Sx57, interfaceC7720Sx58, interfaceC7720Sx59, interfaceC7720Sx510, interfaceC7720Sx511, interfaceC7720Sx512, interfaceC7720Sx513, interfaceC7720Sx514, interfaceC7720Sx515, interfaceC7720Sx516, interfaceC7720Sx517, interfaceC7720Sx518, interfaceC7720Sx519);
    }

    public static Room c(Context context, f fVar, EglBase eglBase, a.InterfaceC0225a interfaceC0225a, C19977rG1 c19977rG1, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, IN in, ZV0 zv0, AbstractC24096y22.a aVar, InterfaceC10670c01 interfaceC10670c01, InterfaceC24893zO interfaceC24893zO, C6952Pr3 c6952Pr3, UA2 ua2, AudioDeviceModule audioDeviceModule, h.a aVar2, InterfaceC3503Bd1 interfaceC3503Bd1, IO io2, F53 f53, d.a aVar3) {
        return new Room(context, fVar, eglBase, interfaceC0225a, c19977rG1, abstractC13778go1, abstractC13778go12, in, zv0, aVar, interfaceC10670c01, interfaceC24893zO, c6952Pr3, ua2, audioDeviceModule, aVar2, interfaceC3503Bd1, io2, f53, aVar3);
    }

    public Room b(Context context) {
        return c(context, (f) this.a.get(), (EglBase) this.b.get(), (a.InterfaceC0225a) this.c.get(), (C19977rG1) this.d.get(), (AbstractC13778go1) this.e.get(), (AbstractC13778go1) this.f.get(), (IN) this.g.get(), (ZV0) this.h.get(), (AbstractC24096y22.a) this.i.get(), (InterfaceC10670c01) this.j.get(), (InterfaceC24893zO) this.k.get(), (C6952Pr3) this.l.get(), (UA2) this.m.get(), (AudioDeviceModule) this.n.get(), (h.a) this.o.get(), (InterfaceC3503Bd1) this.p.get(), (IO) this.q.get(), (F53) this.r.get(), (d.a) this.s.get());
    }
}
