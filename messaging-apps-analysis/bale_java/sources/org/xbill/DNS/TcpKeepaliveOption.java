package org.xbill.DNS;

import java.time.Duration;
import java.util.Optional;
import java.util.OptionalInt;

/* loaded from: classes8.dex */
public class TcpKeepaliveOption extends EDNSOption {
    private static final Duration UPPER_LIMIT = Duration.ofMillis(6553600);
    private Integer timeout;

    public TcpKeepaliveOption() {
        super(11);
        this.timeout = null;
    }

    public OptionalInt getTimeout() {
        Integer num = this.timeout;
        return num == null ? OptionalInt.empty() : OptionalInt.of(num.intValue());
    }

    public Optional<Duration> getTimeoutDuration() {
        return this.timeout != null ? Optional.of(Duration.ofMillis(r0.intValue() * 100)) : Optional.empty();
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) throws WireParseException {
        int iRemaining = dNSInput.remaining();
        if (iRemaining == 0) {
            this.timeout = null;
            return;
        }
        if (iRemaining == 2) {
            this.timeout = Integer.valueOf(dNSInput.readU16());
            return;
        }
        throw new WireParseException("invalid length (" + iRemaining + ") of the data in the edns_tcp_keepalive option");
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        Integer num = this.timeout;
        return num != null ? String.valueOf(num) : "-";
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        Integer num = this.timeout;
        if (num != null) {
            dNSOutput.writeU16(num.intValue());
        }
    }

    public TcpKeepaliveOption(int i) {
        super(11);
        if (i >= 0 && i <= 65535) {
            this.timeout = Integer.valueOf(i);
            return;
        }
        throw new IllegalArgumentException("timeout must be betwee 0 and 65535");
    }

    public TcpKeepaliveOption(Duration duration) {
        super(11);
        if (!duration.isNegative() && duration.compareTo(UPPER_LIMIT) < 0) {
            this.timeout = Integer.valueOf(((int) duration.toMillis()) / 100);
            return;
        }
        throw new IllegalArgumentException("timeout must be between 0 and 6553.6 seconds (exclusively)");
    }
}
