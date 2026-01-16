package org.xbill.DNS;

import android.gov.nist.core.Separators;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Generated;

/* loaded from: classes8.dex */
public class Cache {
    private static final int DEFAULT_MAX_ENTRIES = 50000;

    @Generated
    private static final OI3 log = RI3.i(Cache.class);
    private final CacheMap data;
    private final int dclass;
    private int maxcache;
    private int maxncache;

    private static class CacheMap extends LinkedHashMap<Name, Object> {
        private int maxsize;

        CacheMap(int i) {
            super(16, 0.75f, true);
            this.maxsize = i;
        }

        int getMaxSize() {
            return this.maxsize;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Name, Object> entry) {
            return this.maxsize >= 0 && size() > this.maxsize;
        }

        void setMaxSize(int i) {
            this.maxsize = i;
        }
    }

    private interface Element {
        int compareCredibility(int i);

        boolean expired();

        int getType();

        boolean isAuthenticated();
    }

    private static class NegativeElement implements Element {
        int credibility;
        int expire;
        boolean isAuthenticated;
        Name name;
        int type;

        public NegativeElement(Name name, int i, SOARecord sOARecord, int i2, long j, boolean z) {
            this.name = name;
            this.type = i;
            long jMin = sOARecord != null ? Math.min(sOARecord.getMinimum(), sOARecord.getTTL()) : 0L;
            this.credibility = i2;
            this.expire = Cache.limitExpire(jMin, j);
            this.isAuthenticated = z;
        }

        @Override // org.xbill.DNS.Cache.Element
        public final int compareCredibility(int i) {
            return this.credibility - i;
        }

        @Override // org.xbill.DNS.Cache.Element
        public final boolean expired() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.expire;
        }

        @Override // org.xbill.DNS.Cache.Element
        public int getType() {
            return this.type;
        }

        @Override // org.xbill.DNS.Cache.Element
        public boolean isAuthenticated() {
            return this.isAuthenticated;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.type == 0) {
                sb.append("NXDOMAIN ");
                sb.append(this.name);
            } else {
                sb.append("NXRRSET ");
                sb.append(this.name);
                sb.append(Separators.SP);
                sb.append(Type.string(this.type));
            }
            sb.append(" cl = ");
            sb.append(this.credibility);
            return sb.toString();
        }
    }

    public Cache(int i) {
        this.maxncache = -1;
        this.maxcache = -1;
        this.dclass = i;
        this.data = new CacheMap(DEFAULT_MAX_ENTRIES);
    }

    private synchronized void addElement(Name name, Element element) {
        Object obj = this.data.get(name);
        if (obj == null) {
            this.data.put(name, element);
            return;
        }
        int type = element.getType();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                if (((Element) list.get(i)).getType() == type) {
                    list.set(i, element);
                    return;
                }
            }
            list.add(element);
        } else {
            Element element2 = (Element) obj;
            if (element2.getType() == type) {
                this.data.put(name, element);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(element2);
                linkedList.add(element);
                this.data.put(name, linkedList);
            }
        }
    }

    private synchronized Element[] allElements(Object obj) {
        if (!(obj instanceof List)) {
            return new Element[]{(Element) obj};
        }
        List list = (List) obj;
        return (Element[]) list.toArray(new Element[list.size()]);
    }

    private synchronized Object exactName(Name name) {
        return this.data.get(name);
    }

    private synchronized Element findElement(Name name, int i, int i2) {
        Object objExactName = exactName(name);
        if (objExactName == null) {
            return null;
        }
        return oneElement(name, objExactName, i, i2);
    }

    private List<RRset> findRecords(Name name, int i, int i2) {
        SetResponse setResponseLookupRecords = lookupRecords(name, i, i2);
        if (setResponseLookupRecords.isSuccessful()) {
            return setResponseLookupRecords.answers();
        }
        return null;
    }

    private int getCred(int i, boolean z) {
        if (i == 1) {
            return z ? 4 : 3;
        }
        if (i == 2) {
            return z ? 4 : 3;
        }
        if (i == 3) {
            return 1;
        }
        throw new IllegalArgumentException("getCred: invalid section");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int limitExpire(long j, long j2) {
        if (j2 >= 0 && j2 < j) {
            j = j2;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + j;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) jCurrentTimeMillis;
    }

    private static void markAdditional(RRset rRset, Set<Name> set) {
        if (rRset.first().getAdditionalName() == null) {
            return;
        }
        Iterator<Record> it = rRset.rrs().iterator();
        while (it.hasNext()) {
            Name additionalName = it.next().getAdditionalName();
            if (additionalName != null) {
                set.add(additionalName);
            }
        }
    }

    private synchronized Element oneElement(Name name, Object obj, int i, int i2) {
        try {
            if (i == 255) {
                throw new IllegalArgumentException("oneElement(ANY)");
            }
            if (obj instanceof List) {
                for (Element element : (List) obj) {
                    if (element.getType() == i) {
                        break;
                    }
                }
                element = null;
            } else {
                element = (Element) obj;
                if (element.getType() != i) {
                    element = null;
                }
            }
            if (element == null) {
                return null;
            }
            if (element.expired()) {
                removeElement(name, i);
                return null;
            }
            if (element.compareCredibility(i2) < 0) {
                return null;
            }
            return element;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void removeElement(Name name, int i) {
        Object obj = this.data.get(name);
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((Element) list.get(i2)).getType() == i) {
                    list.remove(i2);
                    if (list.isEmpty()) {
                        this.data.remove(name);
                    }
                    return;
                }
            }
        } else if (((Element) obj).getType() == i) {
            this.data.remove(name);
        }
    }

    private synchronized void removeName(Name name) {
        this.data.remove(name);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.xbill.DNS.SetResponse addMessage(org.xbill.DNS.Message r21) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Cache.addMessage(org.xbill.DNS.Message):org.xbill.DNS.SetResponse");
    }

    public synchronized void addNegative(Name name, int i, SOARecord sOARecord, int i2) {
        addNegative(name, i, sOARecord, i2, false);
    }

    public synchronized <T extends Record> void addRRset(RRset rRset, int i) {
        addRRset(rRset, i, false);
    }

    @Deprecated
    public synchronized void addRecord(Record record, int i, Object obj) {
        addRecord(record, i, false);
    }

    public synchronized void clearCache() {
        this.data.clear();
    }

    public List<RRset> findAnyRecords(Name name, int i) {
        return findRecords(name, i, 2);
    }

    public void flushName(Name name) {
        removeName(name);
    }

    public void flushSet(Name name, int i) {
        removeElement(name, i);
    }

    public int getDClass() {
        return this.dclass;
    }

    public int getMaxCache() {
        return this.maxcache;
    }

    public int getMaxEntries() {
        return this.data.getMaxSize();
    }

    public int getMaxNCache() {
        return this.maxncache;
    }

    public int getSize() {
        return this.data.size();
    }

    protected synchronized SetResponse lookup(Name name, int i, int i2) {
        try {
            int iLabels = name.labels();
            int i3 = iLabels;
            while (true) {
                boolean z = true;
                if (i3 < 1) {
                    return SetResponse.ofType(SetResponseType.UNKNOWN);
                }
                boolean z2 = i3 == 1;
                if (i3 != iLabels) {
                    z = false;
                }
                Name name2 = z2 ? Name.root : z ? name : new Name(name, iLabels - i3);
                Object obj = this.data.get(name2);
                if (obj != null) {
                    if (z && i == 255) {
                        Element[] elementArrAllElements = allElements(obj);
                        SetResponse setResponseOfType = SetResponse.ofType(SetResponseType.SUCCESSFUL);
                        int i4 = 0;
                        for (Element element : elementArrAllElements) {
                            if (element.expired()) {
                                removeElement(name2, element.getType());
                            } else if ((element instanceof CacheRRset) && element.compareCredibility(i2) >= 0) {
                                setResponseOfType.addRRset((CacheRRset) element);
                                i4++;
                            }
                        }
                        if (i4 > 0) {
                            return setResponseOfType;
                        }
                    } else if (z) {
                        Element elementOneElement = oneElement(name2, obj, i, i2);
                        if (elementOneElement instanceof CacheRRset) {
                            return SetResponse.ofType(SetResponseType.SUCCESSFUL, (CacheRRset) elementOneElement);
                        }
                        if (elementOneElement != null) {
                            return SetResponse.ofType(SetResponseType.NXRRSET);
                        }
                        Element elementOneElement2 = oneElement(name2, obj, 5, i2);
                        if (elementOneElement2 instanceof CacheRRset) {
                            return SetResponse.ofType(SetResponseType.CNAME, (CacheRRset) elementOneElement2);
                        }
                    } else {
                        Element elementOneElement3 = oneElement(name2, obj, 39, i2);
                        if (elementOneElement3 instanceof CacheRRset) {
                            return SetResponse.ofType(SetResponseType.DNAME, (CacheRRset) elementOneElement3);
                        }
                    }
                    Element elementOneElement4 = oneElement(name2, obj, 2, i2);
                    if (elementOneElement4 instanceof CacheRRset) {
                        return SetResponse.ofType(SetResponseType.DELEGATION, (CacheRRset) elementOneElement4);
                    }
                    if (z && oneElement(name2, obj, 0, i2) != null) {
                        return SetResponse.ofType(SetResponseType.NXDOMAIN);
                    }
                }
                i3--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public SetResponse lookupRecords(Name name, int i, int i2) {
        return lookup(name, i, i2);
    }

    public void setMaxCache(int i) {
        this.maxcache = i;
    }

    public void setMaxEntries(int i) {
        this.data.setMaxSize(i);
    }

    public void setMaxNCache(int i) {
        this.maxncache = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            try {
                Iterator<Object> it = this.data.values().iterator();
                while (it.hasNext()) {
                    for (Element element : allElements(it.next())) {
                        sb.append(element);
                        sb.append(Separators.RETURN);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    private synchronized void addNegative(Name name, int i, SOARecord sOARecord, int i2, boolean z) {
        long jMin;
        if (sOARecord != null) {
            try {
                jMin = Math.min(sOARecord.getMinimum(), sOARecord.getTTL());
            } catch (Throwable th) {
                throw th;
            }
        } else {
            jMin = 0;
        }
        Element elementFindElement = findElement(name, i, 0);
        if (jMin == 0) {
            if (elementFindElement != null && elementFindElement.compareCredibility(i2) <= 0) {
                removeElement(name, i);
            }
        } else {
            if (elementFindElement != null && elementFindElement.compareCredibility(i2) <= 0) {
                elementFindElement = null;
            }
            if (elementFindElement == null) {
                addElement(name, new NegativeElement(name, i, sOARecord, i2, this.maxncache, z));
            }
        }
    }

    private synchronized <T extends Record> void addRRset(RRset rRset, int i, boolean z) {
        CacheRRset cacheRRset;
        try {
            long ttl = rRset.getTTL();
            Name name = rRset.getName();
            int type = rRset.getType();
            Element elementFindElement = findElement(name, type, 0);
            if (ttl == 0) {
                if (elementFindElement != null && elementFindElement.compareCredibility(i) <= 0) {
                    removeElement(name, type);
                }
            } else {
                if (elementFindElement != null && elementFindElement.compareCredibility(i) <= 0) {
                    elementFindElement = null;
                }
                if (elementFindElement == null) {
                    if (rRset instanceof CacheRRset) {
                        cacheRRset = (CacheRRset) rRset;
                    } else {
                        cacheRRset = new CacheRRset(rRset, i, this.maxcache, z);
                    }
                    addElement(name, cacheRRset);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void addRecord(Record record, int i) {
        addRecord(record, i, false);
    }

    public List<RRset> findRecords(Name name, int i) {
        return findRecords(name, i, 3);
    }

    static class CacheRRset extends RRset implements Element {
        int credibility;
        int expire;
        boolean isAuthenticated;

        public CacheRRset(Record record, int i, long j, boolean z) {
            this.credibility = i;
            this.expire = Cache.limitExpire(record.getTTL(), j);
            this.isAuthenticated = z;
            addRR(record);
        }

        @Override // org.xbill.DNS.Cache.Element
        public final int compareCredibility(int i) {
            return this.credibility - i;
        }

        @Override // org.xbill.DNS.Cache.Element
        public final boolean expired() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.expire;
        }

        @Override // org.xbill.DNS.Cache.Element
        public boolean isAuthenticated() {
            return this.isAuthenticated;
        }

        @Override // org.xbill.DNS.RRset
        public String toString() {
            return super.toString() + " cl = " + this.credibility;
        }

        public CacheRRset(RRset rRset, int i, long j, boolean z) {
            super(rRset);
            this.credibility = i;
            this.expire = Cache.limitExpire(rRset.getTTL(), j);
            this.isAuthenticated = z;
        }
    }

    private synchronized void addRecord(Record record, int i, boolean z) {
        try {
            Name name = record.getName();
            int rRsetType = record.getRRsetType();
            if (Type.isRR(rRsetType)) {
                Element elementFindElement = findElement(name, rRsetType, i);
                if (elementFindElement == null) {
                    addRRset(new CacheRRset(record, i, this.maxcache, z), i, z);
                } else if (elementFindElement.compareCredibility(i) == 0 && (elementFindElement instanceof CacheRRset)) {
                    ((CacheRRset) elementFindElement).addRR(record);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Cache() {
        this(1);
    }

    public Cache(String str) {
        this(new Master(str));
    }

    public Cache(InputStream inputStream) {
        this(new Master(inputStream));
    }

    private <T> Cache(Master master) throws IOException {
        this();
        while (true) {
            try {
                Record recordNextRecord = master.nextRecord();
                if (recordNextRecord == null) {
                    return;
                } else {
                    addRecord(recordNextRecord, 0);
                }
            } finally {
                master.close();
            }
        }
    }
}
