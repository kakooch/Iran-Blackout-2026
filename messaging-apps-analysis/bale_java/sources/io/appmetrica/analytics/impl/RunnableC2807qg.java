package io.appmetrica.analytics.impl;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.XV4;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinVersion;

/* renamed from: io.appmetrica.analytics.impl.qg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2807qg implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        TimePassedChecker timePassedChecker = new TimePassedChecker();
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        C2733ne c2733neW = C2586ha.C.w();
        if (timePassedChecker.didTimePassMillis(c2733neW.f(), TimeUnit.DAYS.toMillis(1L), "[ReportKotlinVersionTask]")) {
            KotlinVersion kotlinVersion = KotlinVersion.CURRENT;
            XV4 xv4A = AbstractC4616Fw7.a("major", Integer.valueOf(kotlinVersion.getMajor()));
            XV4 xv4A2 = AbstractC4616Fw7.a("minor", Integer.valueOf(kotlinVersion.getMinor()));
            XV4 xv4A3 = AbstractC4616Fw7.a("patch", Integer.valueOf(kotlinVersion.getPatch()));
            StringBuilder sb = new StringBuilder();
            sb.append(kotlinVersion.getMajor());
            sb.append('.');
            sb.append(kotlinVersion.getMinor());
            sb.append('.');
            sb.append(kotlinVersion.getPatch());
            Map mapN = AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a(ParameterNames.VERSION, sb.toString()));
            C2523ej c2523ej = Ei.a;
            c2523ej.getClass();
            c2523ej.a(new C2473cj("kotlin_version", mapN));
            c2733neW.c(systemTimeProvider.currentTimeMillis()).b();
        }
    }
}
