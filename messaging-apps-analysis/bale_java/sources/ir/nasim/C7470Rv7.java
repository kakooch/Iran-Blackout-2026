package ir.nasim;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* renamed from: ir.nasim.Rv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7470Rv7 implements InterfaceC6992Pv7 {
    private static volatile AbstractC7704Sv7 e;
    private final QV0 a;
    private final QV0 b;
    private final InterfaceC3733Cc6 c;
    private final WH7 d;

    C7470Rv7(QV0 qv0, QV0 qv02, InterfaceC3733Cc6 interfaceC3733Cc6, WH7 wh7, Wa8 wa8) {
        this.a = qv0;
        this.b = qv02;
        this.c = interfaceC3733Cc6;
        this.d = wh7;
        wa8.c();
    }

    private AbstractC7747Ta2 b(AbstractC4075Do6 abstractC4075Do6) {
        return AbstractC7747Ta2.a().i(this.a.getTime()).k(this.b.getTime()).j(abstractC4075Do6.g()).h(new X72(abstractC4075Do6.b(), abstractC4075Do6.d())).g(abstractC4075Do6.c().a()).d();
    }

    public static C7470Rv7 c() {
        AbstractC7704Sv7 abstractC7704Sv7 = e;
        if (abstractC7704Sv7 != null) {
            return abstractC7704Sv7.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(InterfaceC22480vJ1 interfaceC22480vJ1) {
        return interfaceC22480vJ1 instanceof U72 ? Collections.unmodifiableSet(((U72) interfaceC22480vJ1).a()) : Collections.singleton(C11515d82.b("proto"));
    }

    public static void f(Context context) {
        if (e == null) {
            synchronized (C7470Rv7.class) {
                try {
                    if (e == null) {
                        e = C19213py1.c().b(context).a();
                    }
                } finally {
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC6992Pv7
    public void a(AbstractC4075Do6 abstractC4075Do6, InterfaceC8177Uv7 interfaceC8177Uv7) {
        this.c.a(abstractC4075Do6.f().f(abstractC4075Do6.c().c()), b(abstractC4075Do6), interfaceC8177Uv7);
    }

    public WH7 e() {
        return this.d;
    }

    public InterfaceC6025Lv7 g(InterfaceC22480vJ1 interfaceC22480vJ1) {
        return new C6259Mv7(d(interfaceC22480vJ1), AbstractC5792Kv7.a().b(interfaceC22480vJ1.getName()).c(interfaceC22480vJ1.getExtras()).a(), this);
    }
}
