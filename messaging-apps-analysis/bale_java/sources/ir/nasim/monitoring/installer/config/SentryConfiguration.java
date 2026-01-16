package ir.nasim.monitoring.installer.config;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.ED1;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\nHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006-"}, d2 = {"Lir/nasim/monitoring/installer/config/SentryConfiguration;", "", "enableUncaughtExceptionHandler", "", "tracesSampleRate", "", "enableAnr", "isReportHistoricalAnrs", "enableFramesTracking", "maxCacheItems", "", "enableAppLifecycleBreadcrumbs", "enableSystemEventBreadcrumbs", "maxBreadcrumbs", "enableRootCheck", "<init>", "(ZDZZZIZZIZ)V", "getEnableUncaughtExceptionHandler", "()Z", "getTracesSampleRate", "()D", "getEnableAnr", "getEnableFramesTracking", "getMaxCacheItems", "()I", "getEnableAppLifecycleBreadcrumbs", "getEnableSystemEventBreadcrumbs", "getMaxBreadcrumbs", "getEnableRootCheck", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "monitoring_productionRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes4.dex */
public final /* data */ class SentryConfiguration {
    private final boolean enableAnr;
    private final boolean enableAppLifecycleBreadcrumbs;
    private final boolean enableFramesTracking;
    private final boolean enableRootCheck;
    private final boolean enableSystemEventBreadcrumbs;
    private final boolean enableUncaughtExceptionHandler;
    private final boolean isReportHistoricalAnrs;
    private final int maxBreadcrumbs;
    private final int maxCacheItems;
    private final double tracesSampleRate;

    public SentryConfiguration() {
        this(false, 0.0d, false, false, false, 0, false, false, 0, false, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getEnableRootCheck() {
        return this.enableRootCheck;
    }

    /* renamed from: component2, reason: from getter */
    public final double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableAnr() {
        return this.enableAnr;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsReportHistoricalAnrs() {
        return this.isReportHistoricalAnrs;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnableFramesTracking() {
        return this.enableFramesTracking;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public final SentryConfiguration copy(boolean enableUncaughtExceptionHandler, double tracesSampleRate, boolean enableAnr, boolean isReportHistoricalAnrs, boolean enableFramesTracking, int maxCacheItems, boolean enableAppLifecycleBreadcrumbs, boolean enableSystemEventBreadcrumbs, int maxBreadcrumbs, boolean enableRootCheck) {
        return new SentryConfiguration(enableUncaughtExceptionHandler, tracesSampleRate, enableAnr, isReportHistoricalAnrs, enableFramesTracking, maxCacheItems, enableAppLifecycleBreadcrumbs, enableSystemEventBreadcrumbs, maxBreadcrumbs, enableRootCheck);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SentryConfiguration)) {
            return false;
        }
        SentryConfiguration sentryConfiguration = (SentryConfiguration) other;
        return this.enableUncaughtExceptionHandler == sentryConfiguration.enableUncaughtExceptionHandler && Double.compare(this.tracesSampleRate, sentryConfiguration.tracesSampleRate) == 0 && this.enableAnr == sentryConfiguration.enableAnr && this.isReportHistoricalAnrs == sentryConfiguration.isReportHistoricalAnrs && this.enableFramesTracking == sentryConfiguration.enableFramesTracking && this.maxCacheItems == sentryConfiguration.maxCacheItems && this.enableAppLifecycleBreadcrumbs == sentryConfiguration.enableAppLifecycleBreadcrumbs && this.enableSystemEventBreadcrumbs == sentryConfiguration.enableSystemEventBreadcrumbs && this.maxBreadcrumbs == sentryConfiguration.maxBreadcrumbs && this.enableRootCheck == sentryConfiguration.enableRootCheck;
    }

    public final boolean getEnableAnr() {
        return this.enableAnr;
    }

    public final boolean getEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }

    public final boolean getEnableFramesTracking() {
        return this.enableFramesTracking;
    }

    public final boolean getEnableRootCheck() {
        return this.enableRootCheck;
    }

    public final boolean getEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }

    public final boolean getEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public final int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public final int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public final double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public int hashCode() {
        return (((((((((((((((((Boolean.hashCode(this.enableUncaughtExceptionHandler) * 31) + Double.hashCode(this.tracesSampleRate)) * 31) + Boolean.hashCode(this.enableAnr)) * 31) + Boolean.hashCode(this.isReportHistoricalAnrs)) * 31) + Boolean.hashCode(this.enableFramesTracking)) * 31) + Integer.hashCode(this.maxCacheItems)) * 31) + Boolean.hashCode(this.enableAppLifecycleBreadcrumbs)) * 31) + Boolean.hashCode(this.enableSystemEventBreadcrumbs)) * 31) + Integer.hashCode(this.maxBreadcrumbs)) * 31) + Boolean.hashCode(this.enableRootCheck);
    }

    public final boolean isReportHistoricalAnrs() {
        return this.isReportHistoricalAnrs;
    }

    public String toString() {
        return "SentryConfiguration(enableUncaughtExceptionHandler=" + this.enableUncaughtExceptionHandler + ", tracesSampleRate=" + this.tracesSampleRate + ", enableAnr=" + this.enableAnr + ", isReportHistoricalAnrs=" + this.isReportHistoricalAnrs + ", enableFramesTracking=" + this.enableFramesTracking + ", maxCacheItems=" + this.maxCacheItems + ", enableAppLifecycleBreadcrumbs=" + this.enableAppLifecycleBreadcrumbs + ", enableSystemEventBreadcrumbs=" + this.enableSystemEventBreadcrumbs + ", maxBreadcrumbs=" + this.maxBreadcrumbs + ", enableRootCheck=" + this.enableRootCheck + Separators.RPAREN;
    }

    public SentryConfiguration(boolean z, double d, boolean z2, boolean z3, boolean z4, int i, boolean z5, boolean z6, int i2, boolean z7) {
        this.enableUncaughtExceptionHandler = z;
        this.tracesSampleRate = d;
        this.enableAnr = z2;
        this.isReportHistoricalAnrs = z3;
        this.enableFramesTracking = z4;
        this.maxCacheItems = i;
        this.enableAppLifecycleBreadcrumbs = z5;
        this.enableSystemEventBreadcrumbs = z6;
        this.maxBreadcrumbs = i2;
        this.enableRootCheck = z7;
    }

    public /* synthetic */ SentryConfiguration(boolean z, double d, boolean z2, boolean z3, boolean z4, int i, boolean z5, boolean z6, int i2, boolean z7, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0.05d : d, (i3 & 4) != 0 ? true : z2, (i3 & 8) != 0 ? true : z3, (i3 & 16) != 0 ? true : z4, (i3 & 32) != 0 ? 50 : i, (i3 & 64) != 0 ? true : z5, (i3 & 128) != 0 ? true : z6, (i3 & 256) != 0 ? 30 : i2, (i3 & 512) == 0 ? z7 : true);
    }
}
