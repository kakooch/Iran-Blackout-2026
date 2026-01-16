package ir.nasim;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class TM4 implements SM4 {
    private final io.livekit.android.room.f a;
    private final Map b;

    public TM4(io.livekit.android.room.f fVar) {
        AbstractC13042fc3.i(fVar, "engine");
        this.a = fVar;
        this.b = Collections.synchronizedMap(new LinkedHashMap());
    }
}
