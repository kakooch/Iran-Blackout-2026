package ir.nasim;

import java.util.Date;

/* renamed from: ir.nasim.lA1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16377lA1 {
    public static long a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }

    public static Date b(long j) {
        return new Date((j - 2082844800) * 1000);
    }
}
