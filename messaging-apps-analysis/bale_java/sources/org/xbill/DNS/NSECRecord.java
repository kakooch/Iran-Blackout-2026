package org.xbill.DNS;

/* loaded from: classes8.dex */
public class NSECRecord extends Record {
    private Name next;
    private TypeBitmap types;

    NSECRecord() {
    }

    public Name getNext() {
        return this.next;
    }

    public int[] getTypes() {
        return this.types.toArray();
    }

    public boolean hasType(int i) {
        return this.types.contains(i);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.next = tokenizer.getName(name);
        this.types = new TypeBitmap(tokenizer);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.next = new Name(dNSInput);
        this.types = new TypeBitmap(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.next);
        if (!this.types.empty()) {
            sb.append(' ');
            sb.append(this.types.toString());
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.next.toWire(dNSOutput, null, false);
        this.types.toWire(dNSOutput);
    }

    public NSECRecord(Name name, int i, long j, Name name2, int[] iArr) {
        super(name, 47, i, j);
        this.next = Record.checkName("next", name2);
        for (int i2 : iArr) {
            Type.check(i2);
        }
        this.types = new TypeBitmap(iArr);
    }
}
