package org.xbill.DNS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.NSEC3Record;

/* loaded from: classes8.dex */
public class DnssecAlgorithmOption extends EDNSOption {
    private final List<Integer> algCodes;

    private DnssecAlgorithmOption(int i) {
        super(i);
        if (i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException("Invalid option code, must be one of DAU, DHU, N3U");
        }
        this.algCodes = new ArrayList();
    }

    public List<Integer> getAlgorithms() {
        return Collections.unmodifiableList(this.algCodes);
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) {
        this.algCodes.clear();
        while (dNSInput.remaining() > 0) {
            this.algCodes.add(Integer.valueOf(dNSInput.readU8()));
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        Function function;
        int code = getCode();
        if (code == 5) {
            function = new Function() { // from class: ir.nasim.hW1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DNSSEC.Algorithm.string(((Integer) obj).intValue());
                }
            };
        } else if (code == 6) {
            function = new Function() { // from class: ir.nasim.iW1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DNSSEC.Digest.string(((Integer) obj).intValue());
                }
            };
        } else {
            if (code != 7) {
                throw new IllegalStateException("Unknown option code");
            }
            function = new Function() { // from class: ir.nasim.jW1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return NSEC3Record.Digest.string(((Integer) obj).intValue());
                }
            };
        }
        return "[" + ((String) this.algCodes.stream().map(function).collect(Collectors.joining(", "))) + "]";
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(final DNSOutput dNSOutput) {
        List<Integer> list = this.algCodes;
        Objects.requireNonNull(dNSOutput);
        list.forEach(new Consumer() { // from class: ir.nasim.kW1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                dNSOutput.writeU8(((Integer) obj).intValue());
            }
        });
    }

    public DnssecAlgorithmOption(int i, List<Integer> list) {
        this(i);
        this.algCodes.addAll(list);
    }

    public DnssecAlgorithmOption(int i, int... iArr) {
        this(i);
        if (iArr != null) {
            for (int i2 : iArr) {
                this.algCodes.add(Integer.valueOf(i2));
            }
        }
    }
}
