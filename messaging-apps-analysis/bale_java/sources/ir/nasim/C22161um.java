package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.um, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22161um {
    private final int[] a;

    public C22161um(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = new int[]{OY0.b(context, AbstractC21139tA5.a01), OY0.b(context, AbstractC21139tA5.a02), OY0.b(context, AbstractC21139tA5.a03), OY0.b(context, AbstractC21139tA5.a04), OY0.b(context, AbstractC21139tA5.a05), OY0.b(context, AbstractC21139tA5.a06), OY0.b(context, AbstractC21139tA5.a07), OY0.b(context, AbstractC21139tA5.a08), OY0.b(context, AbstractC21139tA5.a09), OY0.b(context, AbstractC21139tA5.a10)};
    }

    public final int a(int i) {
        return this.a[Math.abs(i) % this.a.length];
    }
}
