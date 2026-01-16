package io.sentry.rrweb;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.u;

/* loaded from: classes3.dex */
public abstract class d extends io.sentry.rrweb.b {
    private b c;

    public static final class a {
        public boolean a(d dVar, String str, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            if (!str.equals("source")) {
                return false;
            }
            dVar.c = (b) u.c((b) interfaceC3118g1.E0(iLogger, new b.a()), "");
            return true;
        }
    }

    public enum b implements A0 {
        Mutation,
        MouseMove,
        MouseInteraction,
        Scroll,
        ViewportResize,
        Input,
        TouchMove,
        MediaInteraction,
        StyleSheetRule,
        CanvasMutation,
        Font,
        Log,
        Drag,
        StyleDeclaration,
        Selection,
        AdoptedStyleSheet,
        CustomElement;

        public static final class a implements InterfaceC3176q0 {
            @Override // io.sentry.InterfaceC3176q0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
                return b.values()[interfaceC3118g1.r0()];
            }
        }

        @Override // io.sentry.A0
        public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            interfaceC3123h1.b(ordinal());
        }
    }

    public static final class c {
        public void a(d dVar, InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            interfaceC3123h1.f("source").l(iLogger, dVar.c);
        }
    }

    public d(b bVar) {
        super(io.sentry.rrweb.c.IncrementalSnapshot);
        this.c = bVar;
    }
}
