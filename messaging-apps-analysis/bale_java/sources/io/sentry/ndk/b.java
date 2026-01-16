package io.sentry.ndk;

/* loaded from: classes3.dex */
public enum b {
    SENTRY_HANDLER_STRATEGY_DEFAULT(0),
    SENTRY_HANDLER_STRATEGY_CHAIN_AT_START(1);

    private final int value;

    b(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
