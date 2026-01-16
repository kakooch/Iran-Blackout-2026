package ir.nasim;

import java.util.Timer;

/* renamed from: ir.nasim.Gq7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4811Gq7 {
    public static final Timer a(String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }
}
