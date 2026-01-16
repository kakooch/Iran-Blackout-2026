package io.sentry.android.core;

/* loaded from: classes3.dex */
public enum B0 {
    SENTRY_HANDLER_STRATEGY_DEFAULT(0),
    SENTRY_HANDLER_STRATEGY_CHAIN_AT_START(1);

    private final int value;

    B0(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
