package org.xbill.DNS;

import android.gov.nist.core.Separators;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.Generated;

/* loaded from: classes8.dex */
public class Message implements Cloneable {
    public static final int MAXLENGTH = 65535;
    static final int TSIG_FAILED = 4;
    static final int TSIG_INTERMEDIATE = 2;
    static final int TSIG_SIGNED = 3;
    static final int TSIG_UNSIGNED = 0;
    static final int TSIG_VERIFIED = 1;
    private TSIGRecord generatedTsig;
    private Header header;
    private TSIGRecord querytsig;
    private Resolver resolver;
    private List<Record>[] sections;
    int sig0start;
    private int size;
    int tsigState;
    private int tsigerror;
    private TSIG tsigkey;
    int tsigstart;

    @Generated
    private static final OI3 log = RI3.i(Message.class);
    private static final Record[] emptyRecordArray = new Record[0];

    private Message(Header header) {
        this.sections = new List[4];
        this.header = header;
    }

    private void addAdditionalRRset(RRset rRset, List<RRset> list, List<RRset> list2) {
        if (doesTypeHaveAdditionalRecords(rRset.getType())) {
            for (Record record : rRset.rrs(false)) {
                for (RRset rRset2 : list) {
                    if (rRset2.getName().equals(record.getAdditionalName()) && isTypeAllowedInSection(rRset2.getType(), 3)) {
                        list2.add(rRset2);
                    }
                }
            }
        }
    }

    private boolean doesTypeHaveAdditionalRecords(int i) {
        return i == 2 || i == 3 || i == 4 || i == 7 || i == 15 || i == 33 || i == 35 || i == 36;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$normalize$0(RRset rRset) {
        return rRset.getType() == 6;
    }

    private void logOrThrow(boolean z, String str, RRset rRset, Name name, Message message) throws WireParseException {
        if (z) {
            throw new WireParseException(String.format(str.replace("{}", "%s"), rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()), name, DClass.string(message.getQuestion().getDClass()), Type.string(message.getQuestion().getType()), Integer.valueOf(getHeader().getID())));
        }
        log.l(str, rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()), name, DClass.string(message.getQuestion().getDClass()), Type.string(message.getQuestion().getType()), Integer.valueOf(getHeader().getID()));
    }

    public static Message newQuery(Record record) {
        Message message = new Message();
        message.header.setOpcode(0);
        message.header.setFlag(7);
        message.addRecord(record, 0);
        return message;
    }

    public static Message newUpdate(Name name) {
        return new Update(name);
    }

    private List<Record> rrsetListToRecords(List<RRset> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (RRset rRset : list) {
            arrayList.addAll(rRset.rrs(false));
            arrayList.addAll(rRset.sigs());
        }
        return arrayList;
    }

    private int sectionToWire(DNSOutput dNSOutput, int i, Compression compression, int i2) {
        int size = this.sections[i].size();
        int iCurrent = dNSOutput.current();
        int i3 = 0;
        Record record = null;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Record record2 = this.sections[i].get(i5);
            if (i != 3 || !(record2 instanceof OPTRecord)) {
                if (record != null && !record2.sameRRset(record)) {
                    iCurrent = dNSOutput.current();
                    i3 = i4;
                }
                record2.toWire(dNSOutput, i, compression);
                if (dNSOutput.current() > i2) {
                    dNSOutput.jump(iCurrent);
                    return size - i3;
                }
                i4++;
                record = record2;
            }
        }
        return size - i4;
    }

    public void addRecord(Record record, int i) {
        List<Record>[] listArr = this.sections;
        if (listArr[i] == null) {
            listArr[i] = new LinkedList();
        }
        this.header.incCount(i);
        this.sections[i].add(record);
    }

    public boolean findRRset(Name name, int i, int i2) {
        Type.check(i);
        Section.check(i2);
        if (this.sections[i2] == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.sections[i2].size(); i3++) {
            Record record = this.sections[i2].get(i3);
            if (record.getType() == i && name.equals(record.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findRecord(Record record, int i) {
        Section.check(i);
        List<Record> list = this.sections[i];
        return list != null && list.contains(record);
    }

    TSIGRecord getGeneratedTSIG() {
        return this.generatedTsig;
    }

    public Header getHeader() {
        return this.header;
    }

    public OPTRecord getOPT() {
        for (Record record : getSection(3)) {
            if (record instanceof OPTRecord) {
                return (OPTRecord) record;
            }
        }
        return null;
    }

    public Record getQuestion() {
        List<Record> list = this.sections[0];
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int getRcode() {
        int rcode = this.header.getRcode();
        OPTRecord opt = getOPT();
        return opt != null ? rcode + (opt.getExtendedRcode() << 4) : rcode;
    }

    public Optional<Resolver> getResolver() {
        return Optional.ofNullable(this.resolver);
    }

    public List<Record> getSection(int i) {
        Section.check(i);
        List<Record> list = this.sections[i];
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    @Deprecated
    public Record[] getSectionArray(int i) {
        Section.check(i);
        List<Record> list = this.sections[i];
        return list == null ? emptyRecordArray : (Record[]) list.toArray(new Record[0]);
    }

    public List<RRset> getSectionRRsets(int i) {
        Section.check(i);
        if (this.sections[i] == null) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        for (Record record : this.sections[i]) {
            int size = linkedList.size() - 1;
            while (true) {
                if (size < 0) {
                    linkedList.add(new RRset(record));
                    break;
                }
                RRset rRset = (RRset) linkedList.get(size);
                if (record.sameRRset(rRset)) {
                    rRset.addRR(record);
                    break;
                }
                size--;
            }
        }
        return linkedList;
    }

    public TSIGRecord getTSIG() {
        int count = this.header.getCount(3);
        if (count == 0) {
            return null;
        }
        Record record = this.sections[3].get(count - 1);
        if (record.type != 250) {
            return null;
        }
        return (TSIGRecord) record;
    }

    public boolean isSigned() {
        int i = this.tsigState;
        return i == 3 || i == 1 || i == 4;
    }

    boolean isTypeAllowedInSection(int i, int i2) {
        Type.check(i);
        Section.check(i2);
        if (i2 != 2) {
            if (i2 == 3 && (i == 1 || i == 28)) {
                return true;
            }
        } else if (i == 6 || i == 2 || i == 43 || i == 47 || i == 50) {
            return true;
        }
        return !Boolean.parseBoolean(System.getProperty("dnsjava.harden_unknown_additional", "true"));
    }

    public boolean isVerified() {
        return this.tsigState == 1;
    }

    public Message normalize(Message message) {
        try {
            return normalize(message, false);
        } catch (WireParseException unused) {
            return null;
        }
    }

    public int numBytes() {
        return this.size;
    }

    public void removeAllRecords(int i) {
        Section.check(i);
        this.sections[i] = null;
        this.header.setCount(i, 0);
    }

    public boolean removeRecord(Record record, int i) {
        Section.check(i);
        List<Record> list = this.sections[i];
        if (list == null || !list.remove(record)) {
            return false;
        }
        this.header.decCount(i);
        return true;
    }

    public String sectionToString(int i) {
        Section.check(i);
        StringBuilder sb = new StringBuilder();
        sectionToString(sb, i);
        return sb.toString();
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setResolver(Resolver resolver) {
        this.resolver = resolver;
    }

    public void setTSIG(TSIG tsig) {
        setTSIG(tsig, 0, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        OPTRecord opt = getOPT();
        if (opt != null) {
            sb.append(this.header.toStringWithRcode(getRcode()));
            sb.append("\n\n");
            opt.printPseudoSection(sb);
            sb.append('\n');
        } else {
            sb.append(this.header);
            sb.append('\n');
        }
        if (isSigned()) {
            sb.append(";; TSIG ");
            if (isVerified()) {
                sb.append("ok");
            } else {
                sb.append("invalid");
            }
            sb.append('\n');
        }
        for (int i = 0; i < 4; i++) {
            if (this.header.getOpcode() != 5) {
                sb.append(";; ");
                sb.append(Section.longString(i));
                sb.append(":\n");
            } else {
                sb.append(";; ");
                sb.append(Section.updString(i));
                sb.append(":\n");
            }
            sectionToString(sb, i);
            sb.append(Separators.RETURN);
        }
        sb.append(";; Message size: ");
        sb.append(numBytes());
        sb.append(" bytes");
        return sb.toString();
    }

    void toWire(DNSOutput dNSOutput) {
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        int i = 0;
        while (true) {
            List<Record>[] listArr = this.sections;
            if (i >= listArr.length) {
                return;
            }
            List<Record> list = listArr[i];
            if (list != null) {
                Iterator<Record> it = list.iterator();
                while (it.hasNext()) {
                    it.next().toWire(dNSOutput, i, compression);
                }
            }
            i++;
        }
    }

    public Message clone() {
        Message message = (Message) super.clone();
        message.sections = new List[this.sections.length];
        int i = 0;
        while (true) {
            List<Record>[] listArr = this.sections;
            if (i >= listArr.length) {
                break;
            }
            if (listArr[i] != null) {
                message.sections[i] = new LinkedList(this.sections[i]);
            }
            i++;
        }
        message.header = this.header.clone();
        TSIGRecord tSIGRecord = this.querytsig;
        if (tSIGRecord != null) {
            message.querytsig = (TSIGRecord) tSIGRecord.cloneRecord();
        }
        TSIGRecord tSIGRecord2 = this.generatedTsig;
        if (tSIGRecord2 != null) {
            message.generatedTsig = (TSIGRecord) tSIGRecord2.cloneRecord();
        }
        return message;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.xbill.DNS.Message normalize(org.xbill.DNS.Message r25, boolean r26) throws org.xbill.DNS.WireParseException {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Message.normalize(org.xbill.DNS.Message, boolean):org.xbill.DNS.Message");
    }

    public void setTSIG(TSIG tsig, int i, TSIGRecord tSIGRecord) {
        this.tsigkey = tsig;
        this.tsigerror = i;
        this.querytsig = tSIGRecord;
    }

    public boolean findRecord(Record record) {
        for (int i = 1; i <= 3; i++) {
            List<Record> list = this.sections[i];
            if (list != null && list.contains(record)) {
                return true;
            }
        }
        return false;
    }

    public Message(int i) {
        this(new Header(i));
    }

    public Message() {
        this(new Header());
    }

    private void sectionToString(StringBuilder sb, int i) {
        if (i > 3) {
            return;
        }
        for (Record record : getSection(i)) {
            if (i == 0) {
                sb.append(";;\t");
                sb.append(record.name);
                sb.append(", type = ");
                sb.append(Type.string(record.type));
                sb.append(", class = ");
                sb.append(DClass.string(record.dclass));
            } else if (!(record instanceof OPTRecord)) {
                sb.append(record);
            }
            sb.append(Separators.RETURN);
        }
    }

    Message(DNSInput dNSInput) throws WireParseException {
        this(new Header(dNSInput));
        boolean z = this.header.getOpcode() == 5;
        boolean flag = this.header.getFlag(6);
        for (int i = 0; i < 4; i++) {
            try {
                int count = this.header.getCount(i);
                if (count > 0) {
                    this.sections[i] = new ArrayList(count);
                }
                for (int i2 = 0; i2 < count; i2++) {
                    int iCurrent = dNSInput.current();
                    Record recordFromWire = Record.fromWire(dNSInput, i, z);
                    this.sections[i].add(recordFromWire);
                    if (i == 3) {
                        if (recordFromWire.getType() == 250) {
                            this.tsigstart = iCurrent;
                            if (i2 != count - 1) {
                                throw new WireParseException("TSIG is not the last record in the message");
                            }
                        }
                        if (recordFromWire.getType() == 24 && ((SIGRecord) recordFromWire).getTypeCovered() == 0) {
                            this.sig0start = iCurrent;
                        }
                    }
                }
            } catch (WireParseException e) {
                if (!flag) {
                    throw e;
                }
            }
        }
        this.size = dNSInput.current();
    }

    private boolean toWire(DNSOutput dNSOutput, int i) {
        byte[] wire;
        if (i < 12) {
            return false;
        }
        TSIG tsig = this.tsigkey;
        if (tsig != null) {
            i -= tsig.recordLength();
        }
        OPTRecord opt = getOPT();
        if (opt != null) {
            wire = opt.toWire(3);
            i -= wire.length;
        } else {
            wire = null;
        }
        int iCurrent = dNSOutput.current();
        this.header.toWire(dNSOutput);
        Compression compression = new Compression();
        int flagsByte = this.header.getFlagsByte();
        int i2 = 0;
        int count = 0;
        while (true) {
            if (i2 >= 4) {
                break;
            }
            if (this.sections[i2] != null) {
                int iSectionToWire = sectionToWire(dNSOutput, i2, compression, i);
                if (iSectionToWire != 0 && i2 != 3) {
                    flagsByte = Header.setFlag(flagsByte, 6, true);
                    int count2 = this.header.getCount(i2) - iSectionToWire;
                    int i3 = iCurrent + 4;
                    dNSOutput.writeU16At(count2, (i2 * 2) + i3);
                    for (int i4 = i2 + 1; i4 < 3; i4++) {
                        dNSOutput.writeU16At(0, (i4 * 2) + i3);
                    }
                } else if (i2 == 3) {
                    count = this.header.getCount(i2) - iSectionToWire;
                }
            }
            i2++;
        }
        if (wire != null) {
            dNSOutput.writeByteArray(wire);
            count++;
        }
        if (flagsByte != this.header.getFlagsByte()) {
            dNSOutput.writeU16At(flagsByte, iCurrent + 2);
        }
        if (count != this.header.getCount(3)) {
            dNSOutput.writeU16At(count, iCurrent + 10);
        }
        TSIG tsig2 = this.tsigkey;
        if (tsig2 != null) {
            TSIGRecord tSIGRecordGenerate = tsig2.generate(this, dNSOutput.toByteArray(), this.tsigerror, this.querytsig);
            tSIGRecordGenerate.toWire(dNSOutput, 3, compression);
            this.generatedTsig = tSIGRecordGenerate;
            dNSOutput.writeU16At(count + 1, iCurrent + 10);
        }
        return !Header.getFlag(flagsByte, 6);
    }

    public boolean findRRset(Name name, int i) {
        return findRRset(name, i, 1) || findRRset(name, i, 2) || findRRset(name, i, 3);
    }

    public Message(byte[] bArr) {
        this(new DNSInput(bArr));
    }

    public Message(ByteBuffer byteBuffer) {
        this(new DNSInput(byteBuffer));
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }

    public byte[] toWire(int i) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i);
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }

    public byte[] toWire(int i, boolean z) throws MessageSizeExceededException {
        DNSOutput dNSOutput = new DNSOutput();
        if (!toWire(dNSOutput, i) && !z) {
            throw new MessageSizeExceededException(i);
        }
        this.size = dNSOutput.current();
        return dNSOutput.toByteArray();
    }
}
