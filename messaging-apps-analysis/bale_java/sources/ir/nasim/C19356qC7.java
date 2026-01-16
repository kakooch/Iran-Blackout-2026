package ir.nasim;

import java.util.function.Consumer;
import org.xbill.DNS.Record;
import org.xbill.DNS.Update;

/* renamed from: ir.nasim.qC7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final /* synthetic */ class C19356qC7 implements Consumer {
    public final /* synthetic */ Update a;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.add((Record) obj);
    }
}
