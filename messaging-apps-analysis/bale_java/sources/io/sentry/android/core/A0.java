package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import io.sentry.EnumC3147m0;
import io.sentry.EnumC3177q1;
import io.sentry.ILogger;
import io.sentry.Q2;
import io.sentry.W2;
import io.sentry.Y2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
abstract class A0 {
    static void a(Context context, SentryAndroidOptions sentryAndroidOptions, Y y) {
        io.sentry.util.u.c(context, "The application context is required.");
        io.sentry.util.u.c(sentryAndroidOptions, "The options object is required.");
        try {
            Bundle bundleB = b(context, sentryAndroidOptions.getLogger(), y);
            ILogger logger = sentryAndroidOptions.getLogger();
            if (bundleB != null) {
                sentryAndroidOptions.setDebug(d(bundleB, logger, "io.sentry.debug", sentryAndroidOptions.isDebug()));
                if (sentryAndroidOptions.isDebug()) {
                    String strName = sentryAndroidOptions.getDiagnosticLevel().name();
                    Locale locale = Locale.ROOT;
                    String strH = h(bundleB, logger, "io.sentry.debug.level", strName.toLowerCase(locale));
                    if (strH != null) {
                        sentryAndroidOptions.setDiagnosticLevel(Y2.valueOf(strH.toUpperCase(locale)));
                    }
                }
                sentryAndroidOptions.setAnrEnabled(d(bundleB, logger, "io.sentry.anr.enable", sentryAndroidOptions.isAnrEnabled()));
                sentryAndroidOptions.setEnableAutoSessionTracking(d(bundleB, logger, "io.sentry.auto-session-tracking.enable", sentryAndroidOptions.isEnableAutoSessionTracking()));
                if (sentryAndroidOptions.getSampleRate() == null) {
                    double dE = e(bundleB, logger, "io.sentry.sample-rate");
                    if (dE != -1.0d) {
                        sentryAndroidOptions.setSampleRate(Double.valueOf(dE));
                    }
                }
                sentryAndroidOptions.setAnrReportInDebug(d(bundleB, logger, "io.sentry.anr.report-debug", sentryAndroidOptions.isAnrReportInDebug()));
                sentryAndroidOptions.setAnrTimeoutIntervalMillis(g(bundleB, logger, "io.sentry.anr.timeout-interval-millis", sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                sentryAndroidOptions.setAttachAnrThreadDump(d(bundleB, logger, "io.sentry.anr.attach-thread-dumps", sentryAndroidOptions.isAttachAnrThreadDump()));
                String strH2 = h(bundleB, logger, "io.sentry.dsn", sentryAndroidOptions.getDsn());
                boolean zD = d(bundleB, logger, "io.sentry.enabled", sentryAndroidOptions.isEnabled());
                if (!zD || (strH2 != null && strH2.isEmpty())) {
                    sentryAndroidOptions.getLogger().c(Y2.DEBUG, "Sentry enabled flag set to false or DSN is empty: disabling sentry-android", new Object[0]);
                } else if (strH2 == null) {
                    sentryAndroidOptions.getLogger().c(Y2.FATAL, "DSN is required. Use empty string to disable SDK.", new Object[0]);
                }
                sentryAndroidOptions.setEnabled(zD);
                sentryAndroidOptions.setDsn(strH2);
                sentryAndroidOptions.setEnableNdk(d(bundleB, logger, "io.sentry.ndk.enable", sentryAndroidOptions.isEnableNdk()));
                sentryAndroidOptions.setEnableScopeSync(d(bundleB, logger, "io.sentry.ndk.scope-sync.enable", sentryAndroidOptions.isEnableScopeSync()));
                sentryAndroidOptions.setRelease(h(bundleB, logger, "io.sentry.release", sentryAndroidOptions.getRelease()));
                sentryAndroidOptions.setEnvironment(h(bundleB, logger, "io.sentry.environment", sentryAndroidOptions.getEnvironment()));
                sentryAndroidOptions.setSessionTrackingIntervalMillis(g(bundleB, logger, "io.sentry.session-tracking.timeout-interval-millis", sentryAndroidOptions.getSessionTrackingIntervalMillis()));
                sentryAndroidOptions.setMaxBreadcrumbs((int) g(bundleB, logger, "io.sentry.max-breadcrumbs", sentryAndroidOptions.getMaxBreadcrumbs()));
                sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.activity-lifecycle", sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.app-lifecycle", sentryAndroidOptions.isEnableAppLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableSystemEventBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.system-events", sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                sentryAndroidOptions.setEnableAppComponentBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.app-components", sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                sentryAndroidOptions.setEnableUserInteractionBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.user-interaction", sentryAndroidOptions.isEnableUserInteractionBreadcrumbs()));
                sentryAndroidOptions.setEnableNetworkEventBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.network-events", sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
                sentryAndroidOptions.setEnableUncaughtExceptionHandler(d(bundleB, logger, "io.sentry.uncaught-exception-handler.enable", sentryAndroidOptions.isEnableUncaughtExceptionHandler()));
                sentryAndroidOptions.setAttachThreads(d(bundleB, logger, "io.sentry.attach-threads", sentryAndroidOptions.isAttachThreads()));
                sentryAndroidOptions.setAttachScreenshot(d(bundleB, logger, "io.sentry.attach-screenshot", sentryAndroidOptions.isAttachScreenshot()));
                sentryAndroidOptions.setAttachViewHierarchy(d(bundleB, logger, "io.sentry.attach-view-hierarchy", sentryAndroidOptions.isAttachViewHierarchy()));
                sentryAndroidOptions.setSendClientReports(d(bundleB, logger, "io.sentry.send-client-reports", sentryAndroidOptions.isSendClientReports()));
                if (d(bundleB, logger, "io.sentry.auto-init", true)) {
                    sentryAndroidOptions.setInitPriority(EnumC3147m0.LOW);
                }
                sentryAndroidOptions.setForceInit(d(bundleB, logger, "io.sentry.force-init", sentryAndroidOptions.isForceInit()));
                sentryAndroidOptions.setCollectAdditionalContext(d(bundleB, logger, "io.sentry.additional-context", sentryAndroidOptions.isCollectAdditionalContext()));
                if (sentryAndroidOptions.getTracesSampleRate() == null) {
                    double dE2 = e(bundleB, logger, "io.sentry.traces.sample-rate");
                    if (dE2 != -1.0d) {
                        sentryAndroidOptions.setTracesSampleRate(Double.valueOf(dE2));
                    }
                }
                sentryAndroidOptions.setTraceSampling(d(bundleB, logger, "io.sentry.traces.trace-sampling", sentryAndroidOptions.isTraceSampling()));
                sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(d(bundleB, logger, "io.sentry.traces.activity.enable", sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(d(bundleB, logger, "io.sentry.traces.activity.auto-finish.enable", sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
                if (sentryAndroidOptions.getProfilesSampleRate() == null) {
                    double dE3 = e(bundleB, logger, "io.sentry.traces.profiling.sample-rate");
                    if (dE3 != -1.0d) {
                        sentryAndroidOptions.setProfilesSampleRate(Double.valueOf(dE3));
                    }
                }
                if (sentryAndroidOptions.getProfileSessionSampleRate() == null) {
                    double dE4 = e(bundleB, logger, "io.sentry.traces.profiling.session-sample-rate");
                    if (dE4 != -1.0d) {
                        sentryAndroidOptions.setProfileSessionSampleRate(Double.valueOf(dE4));
                    }
                }
                String strName2 = sentryAndroidOptions.getProfileLifecycle().name();
                Locale locale2 = Locale.ROOT;
                String strH3 = h(bundleB, logger, "io.sentry.traces.profiling.lifecycle", strName2.toLowerCase(locale2));
                if (strH3 != null) {
                    sentryAndroidOptions.setProfileLifecycle(EnumC3177q1.valueOf(strH3.toUpperCase(locale2)));
                }
                sentryAndroidOptions.setStartProfilerOnAppStart(d(bundleB, logger, "io.sentry.traces.profiling.start-on-app-start", sentryAndroidOptions.isStartProfilerOnAppStart()));
                sentryAndroidOptions.setEnableUserInteractionTracing(d(bundleB, logger, "io.sentry.traces.user-interaction.enable", sentryAndroidOptions.isEnableUserInteractionTracing()));
                sentryAndroidOptions.setEnableTimeToFullDisplayTracing(d(bundleB, logger, "io.sentry.traces.time-to-full-display.enable", sentryAndroidOptions.isEnableTimeToFullDisplayTracing()));
                long jG = g(bundleB, logger, "io.sentry.traces.idle-timeout", -1L);
                if (jG != -1) {
                    sentryAndroidOptions.setIdleTimeout(Long.valueOf(jG));
                }
                List<String> listF = f(bundleB, logger, "io.sentry.traces.trace-propagation-targets");
                if (bundleB.containsKey("io.sentry.traces.trace-propagation-targets") && listF == null) {
                    sentryAndroidOptions.setTracePropagationTargets(Collections.emptyList());
                } else if (listF != null) {
                    sentryAndroidOptions.setTracePropagationTargets(listF);
                }
                sentryAndroidOptions.setEnableFramesTracking(d(bundleB, logger, "io.sentry.traces.frames-tracking", true));
                sentryAndroidOptions.setProguardUuid(h(bundleB, logger, "io.sentry.proguard-uuid", sentryAndroidOptions.getProguardUuid()));
                io.sentry.protocol.p sdkVersion = sentryAndroidOptions.getSdkVersion();
                if (sdkVersion == null) {
                    sdkVersion = new io.sentry.protocol.p("", "");
                }
                sdkVersion.h(i(bundleB, logger, "io.sentry.sdk.name", sdkVersion.e()));
                sdkVersion.j(i(bundleB, logger, "io.sentry.sdk.version", sdkVersion.g()));
                sentryAndroidOptions.setSdkVersion(sdkVersion);
                sentryAndroidOptions.setSendDefaultPii(d(bundleB, logger, "io.sentry.send-default-pii", sentryAndroidOptions.isSendDefaultPii()));
                List listF2 = f(bundleB, logger, "io.sentry.gradle-plugin-integrations");
                if (listF2 != null) {
                    Iterator it = listF2.iterator();
                    while (it.hasNext()) {
                        W2.d().a((String) it.next());
                    }
                }
                sentryAndroidOptions.setEnableRootCheck(d(bundleB, logger, "io.sentry.enable-root-check", sentryAndroidOptions.isEnableRootCheck()));
                sentryAndroidOptions.setSendModules(d(bundleB, logger, "io.sentry.send-modules", sentryAndroidOptions.isSendModules()));
                sentryAndroidOptions.setEnablePerformanceV2(d(bundleB, logger, "io.sentry.performance-v2.enable", sentryAndroidOptions.isEnablePerformanceV2()));
                sentryAndroidOptions.setEnableAppStartProfiling(d(bundleB, logger, "io.sentry.profiling.enable-app-start", sentryAndroidOptions.isEnableAppStartProfiling()));
                sentryAndroidOptions.setEnableScopePersistence(d(bundleB, logger, "io.sentry.enable-scope-persistence", sentryAndroidOptions.isEnableScopePersistence()));
                sentryAndroidOptions.setEnableAutoTraceIdGeneration(d(bundleB, logger, "io.sentry.traces.enable-auto-id-generation", sentryAndroidOptions.isEnableAutoTraceIdGeneration()));
                sentryAndroidOptions.setDeadlineTimeout(g(bundleB, logger, "io.sentry.traces.deadline-timeout", sentryAndroidOptions.getDeadlineTimeout()));
                if (sentryAndroidOptions.getSessionReplay().k() == null) {
                    double dE5 = e(bundleB, logger, "io.sentry.session-replay.session-sample-rate");
                    if (dE5 != -1.0d) {
                        sentryAndroidOptions.getSessionReplay().x(Double.valueOf(dE5));
                    }
                }
                if (sentryAndroidOptions.getSessionReplay().g() == null) {
                    double dE6 = e(bundleB, logger, "io.sentry.session-replay.on-error-sample-rate");
                    if (dE6 != -1.0d) {
                        sentryAndroidOptions.getSessionReplay().v(Double.valueOf(dE6));
                    }
                }
                sentryAndroidOptions.getSessionReplay().u(d(bundleB, logger, "io.sentry.session-replay.mask-all-text", true));
                sentryAndroidOptions.getSessionReplay().t(d(bundleB, logger, "io.sentry.session-replay.mask-all-images", true));
                sentryAndroidOptions.getSessionReplay().s(d(bundleB, logger, "io.sentry.session-replay.debug", false));
                sentryAndroidOptions.setIgnoredErrors(f(bundleB, logger, "io.sentry.ignored-errors"));
                List listF3 = f(bundleB, logger, "io.sentry.in-app-includes");
                if (listF3 != null && !listF3.isEmpty()) {
                    Iterator it2 = listF3.iterator();
                    while (it2.hasNext()) {
                        sentryAndroidOptions.addInAppInclude((String) it2.next());
                    }
                }
                List listF4 = f(bundleB, logger, "io.sentry.in-app-excludes");
                if (listF4 != null && !listF4.isEmpty()) {
                    Iterator it3 = listF4.iterator();
                    while (it3.hasNext()) {
                        sentryAndroidOptions.addInAppExclude((String) it3.next());
                    }
                }
                sentryAndroidOptions.getLogs().b(d(bundleB, logger, "io.sentry.logs.enabled", sentryAndroidOptions.getLogs().a()));
                Q2 feedbackOptions = sentryAndroidOptions.getFeedbackOptions();
                feedbackOptions.x(d(bundleB, logger, "io.sentry.feedback.is-name-required", feedbackOptions.q()));
                feedbackOptions.A(d(bundleB, logger, "io.sentry.feedback.show-name", feedbackOptions.t()));
                feedbackOptions.w(d(bundleB, logger, "io.sentry.feedback.is-email-required", feedbackOptions.p()));
                feedbackOptions.z(d(bundleB, logger, "io.sentry.feedback.show-email", feedbackOptions.s()));
                feedbackOptions.B(d(bundleB, logger, "io.sentry.feedback.use-sentry-user", feedbackOptions.u()));
                feedbackOptions.y(d(bundleB, logger, "io.sentry.feedback.show-branding", feedbackOptions.r()));
            }
            sentryAndroidOptions.getLogger().c(Y2.INFO, "Retrieving configuration from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(Y2.ERROR, "Failed to read configuration from android manifest metadata.", th);
        }
    }

    private static Bundle b(Context context, ILogger iLogger, Y y) {
        if (y == null) {
            y = new Y(iLogger);
        }
        ApplicationInfo applicationInfoH = AbstractC3060k0.h(context, y);
        if (applicationInfoH != null) {
            return applicationInfoH.metaData;
        }
        return null;
    }

    static boolean c(Context context, ILogger iLogger) {
        io.sentry.util.u.c(context, "The application context is required.");
        try {
            Bundle bundleB = b(context, iLogger, null);
            if (bundleB != null) {
                return d(bundleB, iLogger, "io.sentry.auto-init", true);
            }
            return true;
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Failed to read auto-init from android manifest metadata.", th);
            return true;
        }
    }

    private static boolean d(Bundle bundle, ILogger iLogger, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        iLogger.c(Y2.DEBUG, str + " read: " + z2, new Object[0]);
        return z2;
    }

    private static double e(Bundle bundle, ILogger iLogger, String str) {
        double dDoubleValue = Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue();
        if (dDoubleValue == -1.0d) {
            dDoubleValue = Integer.valueOf(bundle.getInt(str, -1)).doubleValue();
        }
        iLogger.c(Y2.DEBUG, str + " read: " + dDoubleValue, new Object[0]);
        return dDoubleValue;
    }

    private static List f(Bundle bundle, ILogger iLogger, String str) {
        String string = bundle.getString(str);
        iLogger.c(Y2.DEBUG, str + " read: " + string, new Object[0]);
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    private static long g(Bundle bundle, ILogger iLogger, String str, long j) {
        long j2 = bundle.getInt(str, (int) j);
        iLogger.c(Y2.DEBUG, str + " read: " + j2, new Object[0]);
        return j2;
    }

    private static String h(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.c(Y2.DEBUG, str + " read: " + string, new Object[0]);
        return string;
    }

    private static String i(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.c(Y2.DEBUG, str + " read: " + string, new Object[0]);
        return string;
    }
}
