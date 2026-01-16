package android.gov.nist.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class NameValueList implements Serializable, Cloneable, Map<String, NameValue> {
    private static final long serialVersionUID = -6998271876574260243L;
    private Map<String, NameValue> hmap;
    private String separator;
    private boolean sync;

    public NameValueList() {
        this.sync = false;
        this.separator = Separators.SEMICOLON;
    }

    @Override // java.util.Map
    public void clear() {
        Map<String, NameValue> map = this.hmap;
        if (map != null) {
            map.clear();
        }
    }

    public Object clone() {
        NameValueList nameValueList = new NameValueList();
        nameValueList.setSeparator(this.separator);
        if (this.hmap != null) {
            Iterator<NameValue> it = iterator();
            while (it.hasNext()) {
                nameValueList.set((NameValue) it.next().clone());
            }
        }
        return nameValueList;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        Map<String, NameValue> map = this.hmap;
        if (map == null) {
            return false;
        }
        return map.containsKey(obj.toString().toLowerCase());
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Map<String, NameValue> map = this.hmap;
        if (map == null) {
            return false;
        }
        return map.containsValue(obj);
    }

    public boolean delete(String str) {
        String lowerCase = str.toLowerCase();
        if (!containsKey(lowerCase)) {
            return false;
        }
        remove((Object) lowerCase);
        return true;
    }

    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, NameValue>> entrySet() {
        Map<String, NameValue> map = this.hmap;
        return map == null ? new HashSet() : map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        NameValueList nameValueList = (NameValueList) obj;
        if (size() != size()) {
            return false;
        }
        Iterator<String> names = getNames();
        while (names.hasNext()) {
            String next = names.next();
            NameValue nameValue = getNameValue(next);
            NameValue nameValue2 = nameValueList.get((Object) next);
            if (nameValue2 == null || !nameValue2.equals(nameValue)) {
                return false;
            }
        }
        return true;
    }

    protected Map<String, NameValue> getMap() {
        if (this.hmap == null) {
            if (this.sync) {
                this.hmap = new ConcurrentHashMap(0);
            } else {
                this.hmap = new LinkedHashMap(0);
            }
        }
        return this.hmap;
    }

    public NameValue getNameValue(String str) {
        Map<String, NameValue> map = this.hmap;
        if (map == null) {
            return null;
        }
        return map.get(str.toLowerCase());
    }

    public Iterator<String> getNames() {
        return getMap().keySet().iterator();
    }

    public String getParameter(String str) {
        return getParameter(str, true);
    }

    public Object getValue(String str) {
        return getValue(str, true);
    }

    public boolean hasNameValue(String str) {
        return containsKey(str.toLowerCase());
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().keySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        Map<String, NameValue> map = this.hmap;
        if (map == null) {
            return true;
        }
        return map.isEmpty();
    }

    public Iterator<NameValue> iterator() {
        return getMap().values().iterator();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        Map<String, NameValue> map = this.hmap;
        return map == null ? new HashSet() : map.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends NameValue> map) {
        getMap().putAll(map);
    }

    public void set(NameValue nameValue) {
        put(nameValue.getName().toLowerCase(), nameValue);
    }

    public void setSeparator(String str) {
        this.separator = str;
    }

    @Override // java.util.Map
    public int size() {
        Map<String, NameValue> map = this.hmap;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public String toString() {
        return encode();
    }

    @Override // java.util.Map
    public Collection<NameValue> values() {
        return getMap().values();
    }

    public StringBuilder encode(StringBuilder sb) {
        if (!isEmpty()) {
            Iterator<NameValue> it = iterator();
            if (it.hasNext()) {
                while (true) {
                    NameValue next = it.next();
                    if (next instanceof GenericObject) {
                        next.encode(sb);
                    } else {
                        sb.append(next.toString());
                    }
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(this.separator);
                }
            }
        }
        return sb;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public NameValue get(Object obj) {
        Map<String, NameValue> map = this.hmap;
        if (map == null) {
            return null;
        }
        return map.get(obj.toString().toLowerCase());
    }

    public String getParameter(String str, boolean z) {
        Object value = getValue(str, z);
        if (value == null) {
            return null;
        }
        return value instanceof GenericObject ? ((GenericObject) value).encode() : value.toString();
    }

    public Object getValue(String str, boolean z) {
        NameValue nameValue = getNameValue(str.toLowerCase());
        if (nameValue != null) {
            return nameValue.getValueAsObject(z);
        }
        return null;
    }

    @Override // java.util.Map
    public NameValue put(String str, NameValue nameValue) {
        return getMap().put(str, nameValue);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public NameValue remove(Object obj) {
        if (this.hmap == null) {
            return null;
        }
        return getMap().remove(obj.toString().toLowerCase());
    }

    public void set(String str, Object obj) {
        put(str.toLowerCase(), new NameValue(str, obj));
    }

    public NameValueList(boolean z) {
        this.separator = Separators.SEMICOLON;
        this.sync = z;
    }
}
