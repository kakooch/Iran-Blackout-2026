package android.gov.nist.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiValueMapImpl<V> implements MultiValueMap<String, V>, Cloneable {
    private static final long serialVersionUID = 4275505380960964605L;
    private HashMap<String, ArrayList<V>> map = null;

    @Override // java.util.Map
    public void clear() {
        HashMap<String, ArrayList<V>> map = this.map;
        if (map != null) {
            Iterator<Map.Entry<String, ArrayList<V>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().clear();
            }
            this.map.clear();
        }
    }

    public Object clone() {
        MultiValueMapImpl multiValueMapImpl = new MultiValueMapImpl();
        HashMap<String, ArrayList<V>> map = this.map;
        if (map != null) {
            multiValueMapImpl.map = (HashMap) map.clone();
        }
        return multiValueMapImpl;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        HashMap<String, ArrayList<V>> map = this.map;
        if (map == null) {
            return false;
        }
        return map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        HashMap<String, ArrayList<V>> map = this.map;
        Set<Map.Entry<String, ArrayList<V>>> setEntrySet = map != null ? map.entrySet() : null;
        if (setEntrySet == null) {
            return false;
        }
        Iterator<Map.Entry<String, ArrayList<V>>> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (it.next().getValue().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set entrySet() {
        HashMap<String, ArrayList<V>> map = this.map;
        return map == null ? new HashSet() : map.entrySet();
    }

    public HashMap<String, ArrayList<V>> getMap() {
        if (this.map == null) {
            this.map = new HashMap<>(0);
        }
        return this.map;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        HashMap<String, ArrayList<V>> map = this.map;
        if (map == null) {
            return true;
        }
        return map.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        HashMap<String, ArrayList<V>> map = this.map;
        return map == null ? new HashSet() : map.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends List<V>> map) {
        for (String str : map.keySet()) {
            ArrayList<V> arrayList = new ArrayList<>();
            arrayList.addAll(map.get(str));
            getMap().put(str, arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.gov.nist.core.MultiValueMap
    public /* bridge */ /* synthetic */ Object removeKV(String str, Object obj) {
        return removeKV2(str, (String) obj);
    }

    @Override // java.util.Map
    public int size() {
        HashMap<String, ArrayList<V>> map = this.map;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    @Override // java.util.Map
    public Collection values() {
        if (this.map == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(this.map.size());
        Iterator<Map.Entry<String, ArrayList<V>>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            for (Object obj : it.next().getValue().toArray()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // java.util.Map
    public List<V> get(Object obj) {
        HashMap<String, ArrayList<V>> map = this.map;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public List<V> put(String str, V v) {
        HashMap<String, ArrayList<V>> map = this.map;
        ArrayList<V> arrayList = map != null ? map.get(str) : null;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            getMap().put(str, arrayList);
        }
        arrayList.add(v);
        return arrayList;
    }

    @Override // java.util.Map
    public List<V> remove(Object obj) {
        HashMap<String, ArrayList<V>> map = this.map;
        if (map == null) {
            return null;
        }
        return map.remove(obj);
    }

    /* renamed from: removeKV, reason: avoid collision after fix types in other method */
    public Object removeKV2(String str, V v) {
        ArrayList<V> arrayList;
        HashMap<String, ArrayList<V>> map = this.map;
        if (map == null || (arrayList = map.get(str)) == null) {
            return null;
        }
        return Boolean.valueOf(arrayList.remove(v));
    }

    @Override // java.util.Map
    public List<V> put(String str, List<V> list) {
        return getMap().put(str, (ArrayList) list);
    }
}
