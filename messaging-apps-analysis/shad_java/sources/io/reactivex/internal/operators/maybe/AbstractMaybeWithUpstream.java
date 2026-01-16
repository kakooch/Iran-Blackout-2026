package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

/* loaded from: classes3.dex */
abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> {
    protected final MaybeSource<T> source;

    AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }
}
