package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.InterfaceC2427an;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class UserProfile {
    private final List a;

    public static class Builder {
        private final LinkedList a;

        /* synthetic */ Builder(int i) {
            this();
        }

        public Builder apply(UserProfileUpdate<? extends InterfaceC2427an> userProfileUpdate) {
            this.a.add(userProfileUpdate);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this.a, 0);
        }

        private Builder() {
            this.a = new LinkedList();
        }
    }

    /* synthetic */ UserProfile(LinkedList linkedList, int i) {
        this(linkedList);
    }

    public static Builder newBuilder() {
        return new Builder(0);
    }

    public List<UserProfileUpdate<? extends InterfaceC2427an>> getUserProfileUpdates() {
        return this.a;
    }

    private UserProfile(LinkedList linkedList) {
        this.a = CollectionUtils.unmodifiableListCopy(linkedList);
    }
}
