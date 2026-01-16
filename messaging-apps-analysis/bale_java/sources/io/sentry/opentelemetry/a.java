package io.sentry.opentelemetry;

import io.sentry.C3155n3;
import io.sentry.EnumC3125h3;
import io.sentry.L0;
import io.sentry.Y2;
import io.sentry.util.A;
import io.sentry.util.r;
import io.sentry.util.w;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class a {
    public static void a(C3155n3 c3155n3) {
        if (w.c()) {
            Iterator it = b(c3155n3).iterator();
            while (it.hasNext()) {
                c3155n3.addIgnoredSpanOrigin((String) it.next());
            }
        }
    }

    private static List b(C3155n3 c3155n3) {
        EnumC3125h3 openTelemetryMode = c3155n3.getOpenTelemetryMode();
        return EnumC3125h3.OFF.equals(openTelemetryMode) ? Collections.emptyList() : A.a(openTelemetryMode);
    }

    public static void c(C3155n3 c3155n3, r rVar) {
        if (w.c()) {
            if (EnumC3125h3.AUTO.equals(c3155n3.getOpenTelemetryMode())) {
                if (rVar.a("io.sentry.opentelemetry.agent.AgentMarker", L0.e())) {
                    c3155n3.getLogger().c(Y2.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENT", new Object[0]);
                    c3155n3.setOpenTelemetryMode(EnumC3125h3.AGENT);
                } else if (rVar.a("io.sentry.opentelemetry.agent.AgentlessMarker", L0.e())) {
                    c3155n3.getLogger().c(Y2.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS", new Object[0]);
                    c3155n3.setOpenTelemetryMode(EnumC3125h3.AGENTLESS);
                } else if (rVar.a("io.sentry.opentelemetry.agent.AgentlessSpringMarker", L0.e())) {
                    c3155n3.getLogger().c(Y2.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS_SPRING", new Object[0]);
                    c3155n3.setOpenTelemetryMode(EnumC3125h3.AGENTLESS_SPRING);
                }
            }
        }
    }
}
