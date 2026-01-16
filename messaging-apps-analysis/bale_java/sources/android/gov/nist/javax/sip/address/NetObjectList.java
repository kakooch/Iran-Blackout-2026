package android.gov.nist.javax.sip.address;

import android.gov.nist.core.GenericObject;
import android.gov.nist.core.GenericObjectList;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class NetObjectList extends GenericObjectList {
    private static final long serialVersionUID = -1551780600806959023L;

    public NetObjectList(String str) {
        super(str);
    }

    public void add(NetObject netObject) {
        super.add((NetObjectList) netObject);
    }

    public void concatenate(NetObjectList netObjectList) {
        super.concatenate((GenericObjectList) netObjectList);
    }

    @Override // android.gov.nist.core.GenericObjectList
    public String debugDump(int i) {
        return super.debugDump(i);
    }

    @Override // android.gov.nist.core.GenericObjectList
    public GenericObject first() {
        return (NetObject) super.first();
    }

    @Override // android.gov.nist.core.GenericObjectList
    public GenericObject next() {
        return (NetObject) super.next();
    }

    @Override // android.gov.nist.core.GenericObjectList
    public void setMyClass(Class cls) {
        super.setMyClass(cls);
    }

    @Override // android.gov.nist.core.GenericObjectList, java.util.AbstractCollection
    public String toString() {
        return encode();
    }

    public NetObjectList(String str, Class<?> cls) {
        super(str, cls);
    }

    @Override // android.gov.nist.core.GenericObjectList
    public GenericObject next(ListIterator listIterator) {
        return (NetObject) super.next(listIterator);
    }

    public NetObjectList() {
    }
}
