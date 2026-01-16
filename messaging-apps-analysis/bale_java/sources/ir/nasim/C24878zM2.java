package ir.nasim;

import com.google.protobuf.BytesValue;
import java.util.List;

/* renamed from: ir.nasim.zM2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24878zM2 {
    private List a;
    private BytesValue b;

    public C24878zM2(List list, BytesValue bytesValue) {
        AbstractC13042fc3.i(list, "members");
        AbstractC13042fc3.i(bytesValue, "nextPageToken");
        this.a = list;
        this.b = bytesValue;
    }

    public final List a() {
        return this.a;
    }

    public final BytesValue b() {
        return this.b;
    }

    public final void c(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.a = list;
    }

    public final void d(BytesValue bytesValue) {
        AbstractC13042fc3.i(bytesValue, "<set-?>");
        this.b = bytesValue;
    }
}
