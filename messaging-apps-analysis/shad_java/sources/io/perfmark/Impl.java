package io.perfmark;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class Impl {
    static final Tag NO_TAG = new Tag(BuildConfig.FLAVOR, Long.MIN_VALUE);
    static final Link NO_LINK = new Link(Long.MIN_VALUE);

    protected void event(String str, Tag tag) {
    }

    protected void linkIn(Link link) {
    }

    protected void startTask(String str) {
    }

    protected void startTask(String str, Tag tag) {
    }

    protected void stopTask(String str) {
    }

    protected void stopTask(String str, Tag tag) {
    }

    protected Impl(Tag tag) {
        if (tag != NO_TAG) {
            throw new AssertionError("nope");
        }
    }

    protected Link linkOut() {
        return NO_LINK;
    }

    protected Tag createTag(String str, long j) {
        return NO_TAG;
    }
}
