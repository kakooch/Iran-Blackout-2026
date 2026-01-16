package org.xbill.DNS.dnssec;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import lombok.Generated;
import org.xbill.DNS.Flags;
import org.xbill.DNS.Header;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.OPTRecord;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class SMessage {
    private static final int EXTENDED_FLAGS_BIT_OFFSET = 4;
    private static final int MAX_FLAGS = 16;
    private static final int NUM_SECTIONS = 3;

    @Generated
    private static final OI3 log = RI3.i(SMessage.class);
    private String bogusReason;
    private int edeReason;
    private final Header header;
    private OPTRecord oPTRecord;
    private Record question;
    private final List<SRRset>[] sections;
    private SecurityStatus securityStatus;

    public SMessage(Header header) {
        this.edeReason = -1;
        this.sections = new List[3];
        this.header = header;
        this.securityStatus = SecurityStatus.UNCHECKED;
    }

    private void addRRset(SRRset sRRset, int i) {
        checkSectionValidity(i);
        if (sRRset.getType() == 41) {
            this.oPTRecord = (OPTRecord) sRRset.first();
        } else {
            getSectionRRsets(i).add(sRRset);
        }
    }

    private void checkSectionValidity(int i) {
        if (i <= 0 || i > 3) {
            throw new IllegalArgumentException("Invalid section");
        }
    }

    public SRRset findAnswerRRset(Name name, int i, int i2) {
        return findRRset(name, i, i2, 1);
    }

    public SRRset findRRset(Name name, int i, int i2, int i3) {
        checkSectionValidity(i3);
        for (SRRset sRRset : getSectionRRsets(i3)) {
            if (sRRset.getName().equals(name) && sRRset.getType() == i && sRRset.getDClass() == i2) {
                return sRRset;
            }
        }
        return null;
    }

    public String getBogusReason() {
        return this.bogusReason;
    }

    public int getCount(int i) {
        if (i == 0) {
            return 1;
        }
        List<SRRset> sectionRRsets = getSectionRRsets(i);
        int size = 0;
        if (sectionRRsets.isEmpty()) {
            return 0;
        }
        Iterator<SRRset> it = sectionRRsets.iterator();
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public int getEdeReason() {
        return this.edeReason;
    }

    public Header getHeader() {
        return this.header;
    }

    public Message getMessage() {
        Message message = new Message(this.header.getID());
        Header header = message.getHeader();
        header.setOpcode(this.header.getOpcode());
        header.setRcode(this.header.getRcode());
        for (int i = 0; i < 16; i++) {
            if (Flags.isFlag(i) && this.header.getFlag(i)) {
                header.setFlag(i);
            }
        }
        Record record = this.question;
        if (record != null) {
            message.addRecord(record, 0);
        }
        for (int i2 = 1; i2 <= 3; i2++) {
            for (SRRset sRRset : getSectionRRsets(i2)) {
                Iterator<Record> it = sRRset.rrs().iterator();
                while (it.hasNext()) {
                    message.addRecord(it.next(), i2);
                }
                Iterator<RRSIGRecord> it2 = sRRset.sigs().iterator();
                while (it2.hasNext()) {
                    message.addRecord(it2.next(), i2);
                }
            }
        }
        OPTRecord oPTRecord = this.oPTRecord;
        if (oPTRecord != null) {
            message.addRecord(oPTRecord, 3);
        }
        return message;
    }

    public Record getQuestion() {
        return this.question;
    }

    public int getRcode() {
        int rcode = this.header.getRcode();
        OPTRecord oPTRecord = this.oPTRecord;
        return oPTRecord != null ? rcode + (oPTRecord.getExtendedRcode() << 4) : rcode;
    }

    public List<SRRset> getSectionRRsets(int i) {
        checkSectionValidity(i);
        List<SRRset>[] listArr = this.sections;
        int i2 = i - 1;
        if (listArr[i2] == null) {
            listArr[i2] = new LinkedList();
        }
        return this.sections[i2];
    }

    public SecurityStatus getStatus() {
        return this.securityStatus;
    }

    public void setBogus(String str) {
        setStatus(SecurityStatus.BOGUS, 6, str);
    }

    public void setStatus(SecurityStatus securityStatus, int i) {
        setStatus(securityStatus, i, null);
    }

    public void setBogus(String str, int i) {
        setStatus(SecurityStatus.BOGUS, i, str);
    }

    public void setStatus(SecurityStatus securityStatus, int i, String str) {
        this.securityStatus = securityStatus;
        this.edeReason = i;
        this.bogusReason = str;
        if (str != null) {
            log.s("Setting bad reason for message to {}", str);
        }
    }

    public List<SRRset> getSectionRRsets(int i, int i2) {
        List<SRRset> sectionRRsets = getSectionRRsets(i);
        if (sectionRRsets.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(sectionRRsets.size());
        for (SRRset sRRset : sectionRRsets) {
            if (sRRset.getType() == i2) {
                arrayList.add(sRRset);
            }
        }
        return arrayList;
    }

    public SMessage(int i, Record record) {
        this(new Header(i));
        this.question = record;
    }

    public SMessage(Message message) {
        this(message.getHeader());
        this.question = message.getQuestion();
        this.oPTRecord = message.getOPT();
        for (int i = 1; i <= 3; i++) {
            Iterator<RRset> it = message.getSectionRRsets(i).iterator();
            while (it.hasNext()) {
                addRRset(new SRRset(it.next()), i);
            }
        }
    }
}
