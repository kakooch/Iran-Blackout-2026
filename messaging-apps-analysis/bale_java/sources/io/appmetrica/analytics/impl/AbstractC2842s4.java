package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* renamed from: io.appmetrica.analytics.impl.s4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2842s4 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[CounterConfigurationReporterType.values().length];
        a = iArr;
        try {
            iArr[CounterConfigurationReporterType.COMMUTATION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[CounterConfigurationReporterType.MAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[CounterConfigurationReporterType.MANUAL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[CounterConfigurationReporterType.SELF_SDK.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
