package io.appmetrica.analytics.coreutils.internal.collection;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC9648aK;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010&\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001J/\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\f\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u00112\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00028\u00000\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\u001f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00122\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u001f\u0010 J?\u0010!\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\nH\u0007¢\u0006\u0004\b!\u0010\u0017J)\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\u0004\b\u0000\u0010\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b$\u0010%J;\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H\u0007¢\u0006\u0004\b&\u0010\u0017J;\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H\u0007¢\u0006\u0004\b'\u0010\u0017J/\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u00112\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000(\"\u00028\u0000H\u0007¢\u0006\u0004\b*\u0010+J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0#2\u0006\u0010,\u001a\u00020\u0018H\u0007¢\u0006\u0004\b-\u0010.J)\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130(\"\u00020\u0013H\u0007¢\u0006\u0004\b0\u00101JE\u00103\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0018\u00010#\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012H\u0007¢\u0006\u0004\b3\u00104JC\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u001a\u00105\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0018\u00010#H\u0007¢\u0006\u0004\b6\u00107JE\u00108\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u001a\u00105\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102\u0018\u00010#H\u0007¢\u0006\u0004\b8\u00107J-\u00109\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#\"\u0004\b\u0000\u0010\u00112\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0007¢\u0006\u0004\b9\u0010%J?\u0010:\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0012H\u0007¢\u0006\u0004\b:\u0010\u0017J)\u0010;\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010#H\u0007¢\u0006\u0004\b;\u0010<J#\u0010?\u001a\u00020>2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020=0\u0012H\u0007¢\u0006\u0004\b?\u0010@J%\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020=0\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010>H\u0007¢\u0006\u0004\bA\u0010BJ-\u0010C\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#\"\u0004\b\u0000\u0010\u00112\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#H\u0007¢\u0006\u0004\bC\u0010DJ\u001d\u0010F\u001a\u00020\u00052\f\u0010E\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/collection/CollectionUtils;", "", "", "left", "right", "", "areCollectionsEqual", "(Ljava/util/Collection;Ljava/util/Collection;)Z", TokenNames.K, TokenNames.V, "", "map", "key", "value", "Lir/nasim/rB7;", "putOpt", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", TokenNames.T, "", "", "getFromMapIgnoreCase", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "convertMapKeysToLowerCase", "(Ljava/util/Map;)Ljava/util/Map;", "", "input", "", "", "hashSetFromIntArray", "([I)Ljava/util/Set;", "defValue", "getOrDefault", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "copyOf", "original", "", "unmodifiableListCopy", "(Ljava/util/Collection;)Ljava/util/List;", "unmodifiableMapCopy", "unmodifiableSameOrderMapCopy", "", "values", "unmodifiableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "array", "toIntList", "([I)Ljava/util/List;", "elements", "createSortedListWithoutRepetitions", "([Ljava/lang/String;)Ljava/util/List;", "", "getListFromMap", "(Ljava/util/Map;)Ljava/util/List;", "list", "getMapFromList", "(Ljava/util/List;)Ljava/util/Map;", "getMapFromListOrNull", "arrayListCopyOfNullableCollection", "mapCopyOfNullableMap", "getFirstOrNull", "(Ljava/util/List;)Ljava/lang/Object;", "", "Landroid/os/Bundle;", "mapToBundle", "(Ljava/util/Map;)Landroid/os/Bundle;", "bundleToMap", "(Landroid/os/Bundle;)Ljava/util/Map;", "nullIfEmptyList", "(Ljava/util/List;)Ljava/util/List;", "collection", "isNullOrEmpty", "(Ljava/util/Collection;)Z", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class CollectionUtils {
    public static final CollectionUtils INSTANCE = new CollectionUtils();

    private CollectionUtils() {
    }

    public static final boolean areCollectionsEqual(Collection<? extends Object> left, Collection<? extends Object> right) {
        HashSet hashSet;
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.size() != right.size()) {
            return false;
        }
        if (left instanceof HashSet) {
            hashSet = (HashSet) left;
            left = right;
        } else if (right instanceof HashSet) {
            hashSet = (HashSet) right;
        } else {
            HashSet hashSet2 = new HashSet(left);
            left = right;
            hashSet = hashSet2;
        }
        Iterator<? extends Object> it = left.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <T> List<T> arrayListCopyOfNullableCollection(Collection<? extends T> input) {
        if (input != null) {
            return AbstractC15401jX0.m1(input);
        }
        return null;
    }

    public static final Map<String, byte[]> bundleToMap(Bundle input) {
        HashMap map = new HashMap();
        if (input != null) {
            for (String str : input.keySet()) {
                byte[] byteArray = input.getByteArray(str);
                if (byteArray != null) {
                    map.put(str, byteArray);
                }
            }
        }
        return map;
    }

    public static final <T> Map<String, T> convertMapKeysToLowerCase(Map<String, ? extends T> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            linkedHashMap.put(str != null ? str.toLowerCase(Locale.getDefault()) : null, entry.getValue());
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> copyOf(Map<K, V> input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        return new HashMap(input);
    }

    public static final List<String> createSortedListWithoutRepetitions(String... elements) {
        return unmodifiableListCopy(AbstractC9648aK.M(elements));
    }

    public static final <T> T getFirstOrNull(List<? extends T> input) {
        if (input != null) {
            return (T) AbstractC15401jX0.s0(input);
        }
        return null;
    }

    public static final <T> T getFromMapIgnoreCase(Map<String, ? extends T> map, String key) {
        T next;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Map.Entry entry = (Map.Entry) next;
            CharSequence charSequence = (CharSequence) entry.getKey();
            if (charSequence != null && charSequence.length() != 0 && AbstractC20153rZ6.D((String) entry.getKey(), key, true)) {
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 != null) {
            return (T) entry2.getValue();
        }
        return null;
    }

    public static final <K, V> List<Map.Entry<K, V>> getListFromMap(Map<K, ? extends V> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(new AbstractMap.SimpleEntry(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> getMapFromList(List<? extends Map.Entry<? extends K, ? extends V>> list) {
        if (list == null) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list, 10)), 16));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> getMapFromListOrNull(List<? extends Map.Entry<? extends K, ? extends V>> list) {
        if (list == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list, 10)), 16));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static final <K, V> V getOrDefault(Map<K, ? extends V> map, K key, V defValue) {
        V v = map.get(key);
        return v == null ? defValue : v;
    }

    public static final Set<Integer> hashSetFromIntArray(int[] input) {
        return AbstractC10242bK.X0(input);
    }

    public static final boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final <K, V> Map<K, V> mapCopyOfNullableMap(Map<K, ? extends V> input) {
        if (input != null) {
            return AbstractC20051rO3.y(input);
        }
        return null;
    }

    public static final Bundle mapToBundle(Map<String, byte[]> input) {
        Bundle bundle = new Bundle(input.size());
        for (Map.Entry<String, byte[]> entry : input.entrySet()) {
            bundle.putByteArray(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> nullIfEmptyList(List<? extends T> input) {
        if (input == 0 || !(!input.isEmpty())) {
            return null;
        }
        return input;
    }

    public static final <K, V> void putOpt(Map<K, V> map, K key, V value) {
        if (key == null || value == null) {
            return;
        }
        map.put(key, value);
    }

    public static final List<Integer> toIntList(int[] array) {
        return AbstractC10242bK.d1(array);
    }

    public static final <T> List<T> unmodifiableListCopy(Collection<? extends T> original) {
        return Collections.unmodifiableList(new ArrayList(original));
    }

    public static final <K, V> Map<K, V> unmodifiableMapCopy(Map<K, ? extends V> original) {
        return Collections.unmodifiableMap(new HashMap(original));
    }

    public static final <K, V> Map<K, V> unmodifiableSameOrderMapCopy(Map<K, ? extends V> original) {
        return Collections.unmodifiableMap(new LinkedHashMap(original));
    }

    public static final <T> Set<T> unmodifiableSetOf(T... values) {
        return Collections.unmodifiableSet(AbstractC10242bK.Y0(values));
    }
}
