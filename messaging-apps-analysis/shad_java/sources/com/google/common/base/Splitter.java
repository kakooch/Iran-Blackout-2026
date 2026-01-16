package com.google.common.base;

import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;

    private interface Strategy {
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.none(), ConnectionsManager.DEFAULT_DATACENTER_ID);
    }

    private Splitter(Strategy strategy, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = strategy;
        this.omitEmptyStrings = z;
        this.limit = i;
    }

    public static Splitter on(char c) {
        return on(CharMatcher.is(c));
    }

    public static Splitter on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy(charMatcher) { // from class: com.google.common.base.Splitter.1
        });
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }
}
