package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* loaded from: classes3.dex */
public final class InternalChannelz$ChannelTrace$Event {
    public final InternalWithLogId channelRef;
    public final String description;
    public final Severity severity;
    public final InternalWithLogId subchannelRef;
    public final long timestampNanos;

    public enum Severity {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    private InternalChannelz$ChannelTrace$Event(String str, Severity severity, long j, InternalWithLogId internalWithLogId, InternalWithLogId internalWithLogId2) {
        this.description = str;
        this.severity = (Severity) Preconditions.checkNotNull(severity, "severity");
        this.timestampNanos = j;
        this.channelRef = internalWithLogId;
        this.subchannelRef = internalWithLogId2;
    }

    public int hashCode() {
        return Objects.hashCode(this.description, this.severity, Long.valueOf(this.timestampNanos), this.channelRef, this.subchannelRef);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternalChannelz$ChannelTrace$Event)) {
            return false;
        }
        InternalChannelz$ChannelTrace$Event internalChannelz$ChannelTrace$Event = (InternalChannelz$ChannelTrace$Event) obj;
        return Objects.equal(this.description, internalChannelz$ChannelTrace$Event.description) && Objects.equal(this.severity, internalChannelz$ChannelTrace$Event.severity) && this.timestampNanos == internalChannelz$ChannelTrace$Event.timestampNanos && Objects.equal(this.channelRef, internalChannelz$ChannelTrace$Event.channelRef) && Objects.equal(this.subchannelRef, internalChannelz$ChannelTrace$Event.subchannelRef);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("description", this.description).add("severity", this.severity).add("timestampNanos", this.timestampNanos).add("channelRef", this.channelRef).add("subchannelRef", this.subchannelRef).toString();
    }

    public static final class Builder {
        private InternalWithLogId channelRef;
        private String description;
        private Severity severity;
        private InternalWithLogId subchannelRef;
        private Long timestampNanos;

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder setTimestampNanos(long j) {
            this.timestampNanos = Long.valueOf(j);
            return this;
        }

        public Builder setSeverity(Severity severity) {
            this.severity = severity;
            return this;
        }

        public Builder setSubchannelRef(InternalWithLogId internalWithLogId) {
            this.subchannelRef = internalWithLogId;
            return this;
        }

        public InternalChannelz$ChannelTrace$Event build() {
            Preconditions.checkNotNull(this.description, "description");
            Preconditions.checkNotNull(this.severity, "severity");
            Preconditions.checkNotNull(this.timestampNanos, "timestampNanos");
            Preconditions.checkState(this.channelRef == null || this.subchannelRef == null, "at least one of channelRef and subchannelRef must be null");
            return new InternalChannelz$ChannelTrace$Event(this.description, this.severity, this.timestampNanos.longValue(), this.channelRef, this.subchannelRef);
        }
    }
}
