package ir.eitaa.messenger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<T> {
    private final LinkedHashMap<String, T> map;
    private final LinkedHashMap<String, ArrayList<String>> mapFilters;
    private int maxSize;
    private int size;

    protected void entryRemoved(boolean evicted, String key, T oldValue, T newValue) {
    }

    protected int sizeOf(String key, T value) {
        return 1;
    }

    public LruCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
        this.mapFilters = new LinkedHashMap<>();
    }

    public final T get(String key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            T t = this.map.get(key);
            if (t != null) {
                return t;
            }
            return null;
        }
    }

    public ArrayList<String> getFilterKeys(String key) {
        ArrayList<String> arrayList = this.mapFilters.get(key);
        if (arrayList != null) {
            return new ArrayList<>(arrayList);
        }
        return null;
    }

    public void moveToFront(String key) {
        T tRemove = this.map.remove(key);
        if (tRemove != null) {
            this.map.put(key, tRemove);
        }
    }

    public T put(String key, T value) {
        T tPut;
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.size += safeSizeOf(key, value);
            tPut = this.map.put(key, value);
            if (tPut != null) {
                this.size -= safeSizeOf(key, tPut);
            }
        }
        String[] strArrSplit = key.split("@");
        if (strArrSplit.length > 1) {
            ArrayList<String> arrayList = this.mapFilters.get(strArrSplit[0]);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mapFilters.put(strArrSplit[0], arrayList);
            }
            if (!arrayList.contains(strArrSplit[1])) {
                arrayList.add(strArrSplit[1]);
            }
        }
        if (tPut != null) {
            entryRemoved(false, key, tPut, value);
        }
        trimToSize(this.maxSize, key);
        return tPut;
    }

    private void trimToSize(int maxSize, String justAdded) {
        ArrayList<String> arrayList;
        synchronized (this) {
            Iterator<Map.Entry<String, T>> it = this.map.entrySet().iterator();
            while (it.hasNext() && this.size > maxSize && !this.map.isEmpty()) {
                Map.Entry<String, T> next = it.next();
                String key = next.getKey();
                if (justAdded == null || !justAdded.equals(key)) {
                    T value = next.getValue();
                    this.size -= safeSizeOf(key, value);
                    it.remove();
                    String[] strArrSplit = key.split("@");
                    if (strArrSplit.length > 1 && (arrayList = this.mapFilters.get(strArrSplit[0])) != null) {
                        arrayList.remove(strArrSplit[1]);
                        if (arrayList.isEmpty()) {
                            this.mapFilters.remove(strArrSplit[0]);
                        }
                    }
                    entryRemoved(true, key, value, null);
                }
            }
        }
    }

    public final T remove(String key) {
        T tRemove;
        ArrayList<String> arrayList;
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            tRemove = this.map.remove(key);
            if (tRemove != null) {
                this.size -= safeSizeOf(key, tRemove);
            }
        }
        if (tRemove != null) {
            String[] strArrSplit = key.split("@");
            if (strArrSplit.length > 1 && (arrayList = this.mapFilters.get(strArrSplit[0])) != null) {
                arrayList.remove(strArrSplit[1]);
                if (arrayList.isEmpty()) {
                    this.mapFilters.remove(strArrSplit[0]);
                }
            }
            entryRemoved(false, key, tRemove, null);
        }
        return tRemove;
    }

    public boolean contains(String key) {
        return this.map.containsKey(key);
    }

    private int safeSizeOf(String key, T value) {
        int iSizeOf = sizeOf(key, value);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException("Negative size: " + key + "=" + value);
    }

    public final void evictAll() {
        trimToSize(-1, null);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }
}
