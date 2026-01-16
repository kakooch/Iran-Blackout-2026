package org.xbill.DNS;

import ir.nasim.OI3;
import ir.nasim.RI3;
import lombok.Generated;

/* loaded from: classes8.dex */
public class Compression {
    private static final int MAX_POINTER = 16383;
    private static final int TABLE_SIZE = 17;

    @Generated
    private static final OI3 log = RI3.i(Compression.class);
    private final Entry[] table = new Entry[17];

    private static class Entry {
        Name name;
        Entry next;
        int pos;

        private Entry() {
        }
    }

    public void add(int i, Name name) {
        if (i > MAX_POINTER) {
            return;
        }
        int iHashCode = (name.hashCode() & Integer.MAX_VALUE) % 17;
        Entry entry = new Entry();
        entry.name = name;
        entry.pos = i;
        Entry[] entryArr = this.table;
        entry.next = entryArr[iHashCode];
        entryArr[iHashCode] = entry;
        log.e("Adding {} at {}", name, Integer.valueOf(i));
    }

    public int get(Name name) {
        int i = -1;
        for (Entry entry = this.table[(name.hashCode() & Integer.MAX_VALUE) % 17]; entry != null; entry = entry.next) {
            if (entry.name.equals(name)) {
                i = entry.pos;
            }
        }
        log.e("Looking for {}, found {}", name, Integer.valueOf(i));
        return i;
    }
}
