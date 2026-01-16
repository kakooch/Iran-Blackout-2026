package androidx.room;

import java.util.Collections;
import java.util.IdentityHashMap;

/* loaded from: classes.dex */
class InvalidationLiveDataContainer {
    InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        Collections.newSetFromMap(new IdentityHashMap());
    }
}
