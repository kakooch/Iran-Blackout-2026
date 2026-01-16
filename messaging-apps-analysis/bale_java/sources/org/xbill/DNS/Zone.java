package org.xbill.DNS;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.Generated;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.Zone;

/* loaded from: classes8.dex */
public class Zone implements Serializable, Iterable<RRset> {
    public static final int PRIMARY = 1;
    public static final int SECONDARY = 2;
    private final Map<Name, Object> data;
    private boolean hasWild;
    private RRset nsRRset;
    private Name origin;
    private Object originNode;
    private final transient ReentrantReadWriteLock.ReadLock readLock;
    private final transient ReentrantReadWriteLock readWriteLock;
    private SOARecord soaRecord;
    private final transient ReentrantReadWriteLock.WriteLock writeLock;

    class ZoneIterator implements Iterator<RRset> {
        private List<RRset> current;
        private int index;
        private RRset returnedSet;
        private RRset soaSet;
        private boolean wantLastSOA;
        private final Iterator<Map.Entry<Name, Object>> zoneEntries;

        ZoneIterator(boolean z) {
            this.zoneEntries = Zone.this.data.entrySet().iterator();
            this.wantLastSOA = z;
            List list = (List) Zone.this.withReadLock(new Supplier() { // from class: org.xbill.DNS.L0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.a.lambda$new$0();
                }
            });
            RRset[] rRsetArr = new RRset[list.size()];
            this.current = Arrays.asList(rRsetArr);
            int i = 2;
            for (int i2 = 0; i2 < list.size(); i2++) {
                RRset rRset = (RRset) list.get(i2);
                int type = rRset.getType();
                if (type == 6) {
                    RRset rRset2 = new RRset(rRset);
                    this.soaSet = rRset2;
                    rRsetArr[0] = rRset2;
                } else if (type == 2) {
                    rRsetArr[1] = new RRset(rRset);
                } else {
                    rRsetArr[i] = new RRset(rRset);
                    i++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ArrayList lambda$new$0() {
            Zone zone = Zone.this;
            return new ArrayList(zone.allRRsetsWithoutLock(zone.originNode));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ArrayList lambda$next$1(Map.Entry entry) {
            return new ArrayList(Zone.this.allRRsetsWithoutLock(entry.getValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$remove$2() {
            Zone.this.lambda$removeRRset$4(this.returnedSet.getName(), this.returnedSet.getType());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null || this.wantLastSOA;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.returnedSet == null) {
                throw new IllegalStateException("Not at an element");
            }
            Zone.this.withWriteLock(new Runnable() { // from class: org.xbill.DNS.M0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$remove$2();
                }
            });
        }

        @Override // java.util.Iterator
        public RRset next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            List<RRset> list = this.current;
            if (list == null) {
                this.wantLastSOA = false;
                RRset rRset = this.soaSet;
                this.returnedSet = rRset;
                return rRset;
            }
            int i = this.index;
            this.index = i + 1;
            this.returnedSet = new RRset(list.get(i));
            if (this.index == this.current.size()) {
                this.current = null;
                while (true) {
                    if (!this.zoneEntries.hasNext()) {
                        break;
                    }
                    final Map.Entry<Name, Object> next = this.zoneEntries.next();
                    if (!next.getKey().equals(Zone.this.origin)) {
                        List<RRset> list2 = (List) Zone.this.withReadLock(new Supplier() { // from class: org.xbill.DNS.N0
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return this.a.lambda$next$1(next);
                            }
                        });
                        if (!list2.isEmpty()) {
                            this.current = list2;
                            this.index = 0;
                            break;
                        }
                    }
                }
            }
            return this.returnedSet;
        }
    }

    public Zone(Name name, InputStream inputStream) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("no input stream specified");
        }
        this.origin = name;
        fromMasterFile(new Master(inputStream, name));
    }

    private void addRRsetWithoutLock(Name name, RRset rRset) {
        if (!this.hasWild && name.isWild()) {
            this.hasWild = true;
        }
        Object obj = this.data.get(name);
        if (obj == null) {
            this.data.put(name, rRset);
            return;
        }
        int type = rRset.getType();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                if (((RRset) list.get(i)).getType() == type) {
                    list.set(i, rRset);
                    return;
                }
            }
            list.add(rRset);
            return;
        }
        RRset rRset2 = (RRset) obj;
        if (rRset2.getType() == type) {
            this.data.put(name, rRset);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(rRset2);
        linkedList.add(rRset);
        this.data.put(name, linkedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<RRset> allRRsetsWithoutLock(Object obj) {
        return obj instanceof List ? (List) obj : Collections.singletonList((RRset) obj);
    }

    private Object exactName(Name name) {
        return this.data.get(name);
    }

    private RRset expandSet(RRset rRset, Name name) {
        RRset rRset2 = new RRset();
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            rRset2.addRR(it.next().withName(name));
        }
        Iterator<RRSIGRecord> it2 = rRset.sigs().iterator();
        while (it2.hasNext()) {
            rRset2.addRR(it2.next().withName(name));
        }
        return rRset2;
    }

    private RRset findRRsetWithoutLock(Name name, int i) {
        Object objExactName = exactName(name);
        if (objExactName == null) {
            return null;
        }
        return oneRRsetWithoutLock(objExactName, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: findRecordsWithoutLock, reason: merged with bridge method [inline-methods] */
    public SetResponse lambda$findRecords$6(Name name, int i) {
        RRset rRsetOneRRsetWithoutLock;
        int iLabels = name.labels();
        int iLabels2 = this.origin.labels();
        int i2 = iLabels2;
        while (true) {
            if (i2 > iLabels) {
                if (this.hasWild) {
                    while (i < iLabels - iLabels2) {
                        i++;
                        Object objExactName = exactName(name.wild(i));
                        if (objExactName != null) {
                            if (i == 255) {
                                SetResponse setResponseOfType = SetResponse.ofType(SetResponseType.SUCCESSFUL);
                                Iterator<RRset> it = allRRsetsWithoutLock(objExactName).iterator();
                                while (it.hasNext()) {
                                    setResponseOfType.addRRset(expandSet(it.next(), name));
                                }
                                return setResponseOfType;
                            }
                            RRset rRsetOneRRsetWithoutLock2 = oneRRsetWithoutLock(objExactName, i);
                            if (rRsetOneRRsetWithoutLock2 != null) {
                                return SetResponse.ofType(SetResponseType.SUCCESSFUL, expandSet(rRsetOneRRsetWithoutLock2, name));
                            }
                        }
                    }
                }
                return SetResponse.ofType(SetResponseType.NXDOMAIN);
            }
            boolean z = i2 == iLabels2;
            i = i2 == iLabels ? 1 : 0;
            Object objExactName2 = exactName(z ? this.origin : i != 0 ? name : new Name(name, iLabels - i2));
            if (objExactName2 != null) {
                if (!z && (rRsetOneRRsetWithoutLock = oneRRsetWithoutLock(objExactName2, 2)) != null) {
                    return SetResponse.ofType(SetResponseType.DELEGATION, rRsetOneRRsetWithoutLock);
                }
                if (i != 0 && i == 255) {
                    SetResponse setResponseOfType2 = SetResponse.ofType(SetResponseType.SUCCESSFUL);
                    Iterator<RRset> it2 = allRRsetsWithoutLock(objExactName2).iterator();
                    while (it2.hasNext()) {
                        setResponseOfType2.addRRset(it2.next());
                    }
                    return setResponseOfType2;
                }
                if (i != 0) {
                    RRset rRsetOneRRsetWithoutLock3 = oneRRsetWithoutLock(objExactName2, i);
                    if (rRsetOneRRsetWithoutLock3 != null) {
                        return SetResponse.ofType(SetResponseType.SUCCESSFUL, rRsetOneRRsetWithoutLock3);
                    }
                    RRset rRsetOneRRsetWithoutLock4 = oneRRsetWithoutLock(objExactName2, 5);
                    if (rRsetOneRRsetWithoutLock4 != null) {
                        return SetResponse.ofType(SetResponseType.CNAME, rRsetOneRRsetWithoutLock4);
                    }
                } else {
                    RRset rRsetOneRRsetWithoutLock5 = oneRRsetWithoutLock(objExactName2, 39);
                    if (rRsetOneRRsetWithoutLock5 != null) {
                        return SetResponse.ofType(SetResponseType.DNAME, rRsetOneRRsetWithoutLock5);
                    }
                }
                if (i != 0) {
                    return SetResponse.ofType(SetResponseType.NXRRSET);
                }
            }
            i2++;
        }
    }

    private void fromMasterFile(Master master) throws IOException {
        while (true) {
            try {
                Record recordNextRecord = master.nextRecord();
                if (recordNextRecord == null) {
                    master.close();
                    validate();
                    return;
                }
                maybeAddRecord(recordNextRecord);
            } catch (Throwable th) {
                master.close();
                throw th;
            }
        }
    }

    private void fromXFR(ZoneTransferIn zoneTransferIn) throws IOException {
        this.origin = zoneTransferIn.getName();
        zoneTransferIn.run();
        if (!zoneTransferIn.isAXFR()) {
            throw new IllegalArgumentException("zones can only be created from AXFRs");
        }
        Iterator<Record> it = zoneTransferIn.getAXFR().iterator();
        while (it.hasNext()) {
            maybeAddRecord(it.next());
        }
        validate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRRset$3(Name name, RRset rRset, int i) {
        addRRsetWithoutLock(name, rRset);
        if (i == 6) {
            this.soaRecord = (SOARecord) rRset.first();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecord$1(Name name, int i, Record record, int i2) {
        RRset rRsetFindRRsetWithoutLock = findRRsetWithoutLock(name, i);
        if (rRsetFindRRsetWithoutLock == null) {
            addRRsetWithoutLock(name, new RRset(record));
            return;
        }
        if (i2 == 6) {
            rRsetFindRRsetWithoutLock.deleteRR(this.soaRecord);
            this.soaRecord = (SOARecord) record;
        }
        rRsetFindRRsetWithoutLock.addRR(record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RRset lambda$findExactMatch$5(Name name, int i) {
        RRset rRsetFindRRsetWithoutLock = findRRsetWithoutLock(name, i);
        if (rRsetFindRRsetWithoutLock == null) {
            return null;
        }
        return new RRset(rRsetFindRRsetWithoutLock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RRset lambda$getNS$0() {
        return new RRset(this.nsRRset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$nodeToString$7(StringBuilder sb, Record record) {
        sb.append(record);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$nodeToString$8(StringBuilder sb, RRSIGRecord rRSIGRecord) {
        sb.append(rRSIGRecord);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeRecord$2(Name name, int i, Record record) {
        RRset rRsetFindRRsetWithoutLock = findRRsetWithoutLock(name, i);
        if (rRsetFindRRsetWithoutLock == null) {
            return;
        }
        if (i == 2 && rRsetFindRRsetWithoutLock.size() == 1) {
            throw new IllegalArgumentException("Cannot remove all NS");
        }
        if (rRsetFindRRsetWithoutLock.size() + rRsetFindRRsetWithoutLock.sigSize() > 1) {
            rRsetFindRRsetWithoutLock.deleteRR(record);
        } else {
            lambda$removeRRset$4(name, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$toMasterFile$9(StringBuilder sb) {
        nodeToString(sb, this.originNode);
        for (Map.Entry<Name, Object> entry : this.data.entrySet()) {
            if (!this.origin.equals(entry.getKey())) {
                nodeToString(sb, entry.getValue());
            }
        }
        return null;
    }

    private void maybeAddRecord(Record record) throws IOException {
        int type = record.getType();
        Name name = record.getName();
        if (type != 6 || name.equals(this.origin)) {
            if (name.subdomain(this.origin)) {
                addRecord(record);
            }
        } else {
            throw new IOException("SOA owner " + name + " does not match zone origin " + this.origin);
        }
    }

    private void nodeToString(final StringBuilder sb, Object obj) {
        for (RRset rRset : allRRsetsWithoutLock(obj)) {
            rRset.rrs(false).forEach(new Consumer() { // from class: ir.nasim.Lc8
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    Zone.lambda$nodeToString$7(sb, (Record) obj2);
                }
            });
            rRset.sigs().forEach(new Consumer() { // from class: ir.nasim.Mc8
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    Zone.lambda$nodeToString$8(sb, (RRSIGRecord) obj2);
                }
            });
        }
    }

    private RRset oneRRsetWithoutLock(Object obj, int i) {
        if (i == 255) {
            throw new IllegalArgumentException("Cannot lookup an exact match for type ANY");
        }
        if (!(obj instanceof List)) {
            RRset rRset = (RRset) obj;
            if (rRset.getType() == i) {
                return rRset;
            }
            return null;
        }
        for (RRset rRset2 : (List) obj) {
            if (rRset2.getType() == i) {
                return rRset2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeRRsetWithoutLock, reason: merged with bridge method [inline-methods] */
    public void lambda$removeRRset$4(Name name, int i) {
        if (i == 6) {
            throw new IllegalArgumentException("Cannot remove SOA");
        }
        if (i == 2) {
            throw new IllegalArgumentException("Cannot remove all NS");
        }
        Object obj = this.data.get(name);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof List)) {
            if (((RRset) obj).getType() != i) {
                return;
            }
            this.data.remove(name);
            return;
        }
        List list = (List) obj;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            if (((RRset) list.get(i2)).getType() == i) {
                list.remove(i2);
                break;
            }
            i2++;
        }
        if (list.isEmpty()) {
            this.data.remove(name);
        }
    }

    private void validate() throws IOException {
        Object objExactName = exactName(this.origin);
        this.originNode = objExactName;
        if (objExactName == null) {
            throw new IOException(this.origin + ": no data specified");
        }
        RRset rRsetOneRRsetWithoutLock = oneRRsetWithoutLock(objExactName, 6);
        if (rRsetOneRRsetWithoutLock == null || rRsetOneRRsetWithoutLock.size() != 1) {
            throw new IOException(this.origin + ": exactly 1 SOA must be specified");
        }
        this.soaRecord = (SOARecord) rRsetOneRRsetWithoutLock.first();
        RRset rRsetOneRRsetWithoutLock2 = oneRRsetWithoutLock(this.originNode, 2);
        this.nsRRset = rRsetOneRRsetWithoutLock2;
        if (rRsetOneRRsetWithoutLock2 != null) {
            return;
        }
        throw new IOException(this.origin + ": no NS set specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T withReadLock(Supplier<T> supplier) {
        this.readLock.lock();
        try {
            return supplier.get();
        } finally {
            this.readLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void withWriteLock(Runnable runnable) {
        this.writeLock.lock();
        try {
            runnable.run();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Iterator<RRset> AXFR() {
        return new ZoneIterator(true);
    }

    public void addRRset(final RRset rRset) {
        if (rRset == null) {
            throw new IllegalArgumentException("rrset must not be null");
        }
        final Name name = rRset.getName();
        final int type = rRset.getType();
        if (type == 6) {
            if (!name.equals(this.origin)) {
                throw new IllegalArgumentException("SOA owner " + name + " does not match zone origin " + this.origin);
            }
            if (rRset.size() != 1) {
                throw new IllegalArgumentException(this.origin + ": exactly 1 SOA must be specified");
            }
        }
        if (name.subdomain(this.origin)) {
            withWriteLock(new Runnable() { // from class: ir.nasim.Kc8
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$addRRset$3(name, rRset, type);
                }
            });
            return;
        }
        throw new IllegalArgumentException("name " + name + " is absolute and not a subdomain of " + this.origin);
    }

    public <T extends Record> void addRecord(final T t) {
        if (t == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        final Name name = t.getName();
        final int rRsetType = t.getRRsetType();
        final int type = t.getType();
        if (rRsetType == 6 && !name.equals(this.origin)) {
            throw new IllegalArgumentException("SOA owner " + name + " does not match zone origin " + this.origin);
        }
        if (name.subdomain(this.origin)) {
            withWriteLock(new Runnable() { // from class: ir.nasim.Fc8
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$addRecord$1(name, rRsetType, t, type);
                }
            });
            return;
        }
        throw new IllegalArgumentException("name " + name + " is absolute and not a subdomain of " + this.origin);
    }

    public RRset findExactMatch(final Name name, final int i) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Type.check(i);
        return (RRset) withReadLock(new Supplier() { // from class: ir.nasim.Ec8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.lambda$findExactMatch$5(name, i);
            }
        });
    }

    public SetResponse findRecords(final Name name, final int i) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Type.check(i);
        return !name.subdomain(this.origin) ? SetResponse.ofType(SetResponseType.NXDOMAIN) : (SetResponse) withReadLock(new Supplier() { // from class: ir.nasim.Hc8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.lambda$findRecords$6(name, i);
            }
        });
    }

    public int getDClass() {
        return 1;
    }

    public RRset getNS() {
        return (RRset) withReadLock(new Supplier() { // from class: ir.nasim.Jc8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.lambda$getNS$0();
            }
        });
    }

    @Generated
    public Name getOrigin() {
        return this.origin;
    }

    public SOARecord getSOA() {
        return this.soaRecord;
    }

    @Override // java.lang.Iterable
    public Iterator<RRset> iterator() {
        return new ZoneIterator(false);
    }

    public void removeRRset(final Name name, final int i) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        Type.check(i);
        withWriteLock(new Runnable() { // from class: ir.nasim.Gc8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$removeRRset$4(name, i);
            }
        });
    }

    public void removeRecord(final Record record) {
        if (record == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        final Name name = record.getName();
        final int rRsetType = record.getRRsetType();
        if (record.getType() == 6) {
            throw new IllegalArgumentException("Cannot remove SOA record");
        }
        withWriteLock(new Runnable() { // from class: ir.nasim.Ic8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$removeRecord$2(name, rRsetType, record);
            }
        });
    }

    public String toMasterFile() {
        final StringBuilder sb = new StringBuilder();
        withReadLock(new Supplier() { // from class: ir.nasim.Dc8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.lambda$toMasterFile$9(sb);
            }
        });
        return sb.toString();
    }

    public String toString() {
        return toMasterFile();
    }

    public Zone(Name name, String str) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        if (str != null) {
            this.origin = name;
            fromMasterFile(new Master(str, name));
            return;
        }
        throw new IllegalArgumentException("no file name specified");
    }

    public Zone(Name name, Record... recordArr) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        if (recordArr != null) {
            this.origin = name;
            for (Record record : recordArr) {
                maybeAddRecord(record);
            }
            validate();
            return;
        }
        throw new IllegalArgumentException("no records are specified");
    }

    public Zone(ZoneTransferIn zoneTransferIn) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (zoneTransferIn != null) {
            fromXFR(zoneTransferIn);
            return;
        }
        throw new IllegalArgumentException("no xfrin specified");
    }

    public Zone(Name name, int i, String str) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readWriteLock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.data = new ConcurrentSkipListMap();
        if (name != null) {
            DClass.check(i);
            ZoneTransferIn zoneTransferInNewAXFR = ZoneTransferIn.newAXFR(name, str, (TSIG) null);
            zoneTransferInNewAXFR.setDClass(i);
            fromXFR(zoneTransferInNewAXFR);
            return;
        }
        throw new IllegalArgumentException("no zone name specified");
    }
}
