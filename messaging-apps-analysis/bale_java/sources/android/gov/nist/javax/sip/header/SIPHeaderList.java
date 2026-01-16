package android.gov.nist.javax.sip.header;

import android.gov.nist.core.GenericObject;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeader;
import ir.nasim.HU2;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public abstract class SIPHeaderList<HDR extends SIPHeader> extends SIPHeader implements List<HDR>, HU2 {
    private static boolean prettyEncode = false;
    protected List<HDR> hlist;
    private Class<HDR> myClass;

    private SIPHeaderList() {
        this.hlist = new LinkedList();
    }

    public static void setPrettyEncode(boolean z) {
        prettyEncode = z;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends HDR> collection) {
        return this.hlist.addAll(collection);
    }

    public void addFirst(HDR hdr) {
        this.hlist.add(0, hdr);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.hlist.clear();
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        try {
            SIPHeaderList sIPHeaderList = (SIPHeaderList) getClass().getConstructor(null).newInstance(null);
            sIPHeaderList.headerName = this.headerName;
            sIPHeaderList.myClass = this.myClass;
            return sIPHeaderList.clonehlist(this.hlist);
        } catch (Exception e) {
            throw new RuntimeException("Could not clone!", e);
        }
    }

    protected final SIPHeaderList<HDR> clonehlist(List<HDR> list) {
        if (list != null) {
            Iterator<HDR> it = list.iterator();
            while (it.hasNext()) {
                this.hlist.add((SIPHeader) it.next().clone());
            }
        }
        return this;
    }

    public void concatenate(SIPHeaderList<HDR> sIPHeaderList, boolean z) {
        if (z) {
            addAll(0, sIPHeaderList);
        } else {
            addAll(sIPHeaderList);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.hlist.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.hlist.containsAll(collection);
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String debugDump(int i) {
        this.stringRepresentation = "";
        String indentation = new Indentation(i).getIndentation();
        sprint(indentation + getClass().getName());
        sprint(indentation + "{");
        Iterator<HDR> it = this.hlist.iterator();
        while (it.hasNext()) {
            sprint(indentation + it.next().debugDump());
        }
        sprint(indentation + "}");
        return this.stringRepresentation;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    protected String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SIPHeaderList)) {
            return false;
        }
        List<HDR> list = this.hlist;
        List<HDR> list2 = ((SIPHeaderList) obj).hlist;
        if (list == list2) {
            return true;
        }
        return list == null ? list2 == null || list2.size() == 0 : list.equals(list2);
    }

    public HU2 getFirst() {
        List<HDR> list = this.hlist;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.hlist.get(0);
    }

    public List<HDR> getHeaderList() {
        return this.hlist;
    }

    public List<String> getHeadersAsEncodedStrings() {
        LinkedList linkedList = new LinkedList();
        ListIterator<HDR> listIterator = this.hlist.listIterator();
        while (listIterator.hasNext()) {
            linkedList.add(listIterator.next().toString());
        }
        return linkedList;
    }

    public HU2 getLast() {
        List<HDR> list = this.hlist;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.hlist.get(r0.size() - 1);
    }

    public Class<HDR> getMyClass() {
        return this.myClass;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.HeaderExt
    public String getName() {
        return this.headerName;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public int hashCode() {
        return this.headerName.hashCode();
    }

    public int indexOf(GenericObject genericObject) {
        return this.hlist.indexOf(genericObject);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.hlist.isEmpty();
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public boolean isHeaderList() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<HDR> iterator() {
        return this.hlist.listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.hlist.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<HDR> listIterator() {
        return this.hlist.listIterator(0);
    }

    public boolean match(SIPHeaderList<?> sIPHeaderList) throws IllegalAccessException, IllegalArgumentException {
        if (sIPHeaderList == null) {
            return true;
        }
        if (!getClass().equals(sIPHeaderList.getClass())) {
            return false;
        }
        List<HDR> list = this.hlist;
        List<HDR> list2 = sIPHeaderList.hlist;
        if (list == list2) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (HDR hdr : list2) {
            Iterator<HDR> it = this.hlist.iterator();
            boolean zMatch = false;
            while (it.hasNext() && !zMatch) {
                zMatch = it.next().match(hdr);
            }
            if (!zMatch) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.hlist.removeAll(collection);
    }

    public void removeFirst() {
        if (this.hlist.size() != 0) {
            this.hlist.remove(0);
        }
    }

    public void removeLast() {
        if (this.hlist.size() != 0) {
            this.hlist.remove(r0.size() - 1);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.hlist.retainAll(collection);
    }

    protected void setMyClass(Class<HDR> cls) {
        this.myClass = cls;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.hlist.size();
    }

    @Override // java.util.List
    public List<HDR> subList(int i, int i2) {
        return this.hlist.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.hlist.toArray();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends HDR> collection) {
        return this.hlist.addAll(i, collection);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        if (this.hlist.isEmpty()) {
            sb.append(this.headerName);
            sb.append(':');
            sb.append(Separators.NEWLINE);
        } else if (this.headerName.equals(SIPHeaderNames.WWW_AUTHENTICATE) || this.headerName.equals(SIPHeaderNames.PROXY_AUTHENTICATE) || this.headerName.equals(SIPHeaderNames.AUTHORIZATION) || this.headerName.equals(SIPHeaderNames.PROXY_AUTHORIZATION) || ((prettyEncode && (this.headerName.equals(SIPHeaderNames.VIA) || this.headerName.equals(SIPHeaderNames.ROUTE) || this.headerName.equals(SIPHeaderNames.RECORD_ROUTE))) || getClass().equals(ExtensionHeaderList.class))) {
            ListIterator<HDR> listIterator = this.hlist.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().encode(sb);
            }
        } else {
            sb.append(this.headerName);
            sb.append(":");
            sb.append(Separators.SP);
            encodeBody(sb);
            sb.append(Separators.NEWLINE);
        }
        return sb;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        ListIterator<HDR> listIterator = listIterator();
        while (true) {
            HDR next = listIterator.next();
            if (next == this) {
                throw new RuntimeException("Unexpected circularity in SipHeaderList");
            }
            next.encodeBody(sb);
            if (!listIterator.hasNext()) {
                return sb;
            }
            if (this.headerName.equals("Privacy")) {
                sb.append(Separators.SEMICOLON);
            } else {
                sb.append(",");
            }
        }
    }

    @Override // java.util.List
    public HDR get(int i) {
        return this.hlist.get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.hlist.indexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<HDR> listIterator(int i) {
        return this.hlist.listIterator(i);
    }

    public boolean remove(HDR hdr) {
        if (this.hlist.size() == 0) {
            return false;
        }
        return this.hlist.remove(hdr);
    }

    @Override // java.util.List
    public HDR set(int i, HDR hdr) {
        return this.hlist.set(i, hdr);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.hlist.toArray(tArr);
    }

    protected SIPHeaderList(Class<HDR> cls, String str) {
        this();
        this.headerName = str;
        this.myClass = cls;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(HDR hdr) {
        this.hlist.add(hdr);
        return true;
    }

    public void add(HDR hdr, boolean z) {
        if (z) {
            addFirst(hdr);
        } else {
            add((SIPHeaderList<HDR>) hdr);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.hlist.remove(obj);
    }

    @Override // java.util.List
    public HDR remove(int i) {
        return this.hlist.remove(i);
    }

    @Override // java.util.List
    public void add(int i, HDR hdr) {
        this.hlist.add(i, hdr);
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String debugDump() {
        return debugDump(0);
    }
}
