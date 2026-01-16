package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {
    private final String identifier;

    private AutoValue_CrashlyticsReport_Session_User(String str) {
        this.identifier = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User
    public String getIdentifier() {
        return this.identifier;
    }

    public String toString() {
        return "User{identifier=" + this.identifier + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.identifier.equals(((CrashlyticsReport.Session.User) obj).getIdentifier());
        }
        return false;
    }

    public int hashCode() {
        return this.identifier.hashCode() ^ 1000003;
    }

    static final class Builder extends CrashlyticsReport.Session.User.Builder {
        private String identifier;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User.Builder setIdentifier(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.identifier = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User build() {
            String str = this.identifier;
            String str2 = BuildConfig.FLAVOR;
            if (str == null) {
                str2 = BuildConfig.FLAVOR + " identifier";
            }
            if (!str2.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str2);
            }
            return new AutoValue_CrashlyticsReport_Session_User(this.identifier);
        }
    }
}
