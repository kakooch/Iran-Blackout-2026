package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes8.dex */
abstract class TXTBase extends Record {
    protected List<byte[]> strings;

    protected TXTBase() {
    }

    public List<String> getStrings() {
        ArrayList arrayList = new ArrayList(this.strings.size());
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            arrayList.add(Record.byteArrayToString(it.next(), false));
        }
        return arrayList;
    }

    public List<byte[]> getStringsAsByteArrays() {
        return this.strings;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        this.strings = new ArrayList(2);
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return;
            } else {
                try {
                    this.strings.add(Record.byteArrayFromString(token.value()));
                } catch (TextParseException e) {
                    throw tokenizer.exception(e.getMessage());
                }
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.strings = new ArrayList(2);
        while (dNSInput.remaining() > 0) {
            this.strings.add(dNSInput.readCountedString());
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        if (this.strings.isEmpty()) {
            return "\"\"";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            sb.append(Record.byteArrayToString(it.next(), true));
            if (it.hasNext()) {
                sb.append(Separators.SP);
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            dNSOutput.writeCountedString(it.next());
        }
    }

    protected TXTBase(Name name, int i, int i2, long j) {
        super(name, i, i2, j);
    }

    protected TXTBase(Name name, int i, int i2, long j, List<String> list) {
        super(name, i, i2, j);
        if (list != null) {
            this.strings = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.strings.add(Record.byteArrayFromString(it.next()));
                } catch (TextParseException e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
            }
            return;
        }
        throw new IllegalArgumentException("strings must not be null");
    }

    protected TXTBase(Name name, int i, int i2, long j, String str) {
        this(name, i, i2, j, (List<String>) Collections.singletonList(str));
    }
}
