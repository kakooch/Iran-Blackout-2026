package okio;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC14067hI1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
@InterfaceC14067hI1
/* renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* loaded from: classes8.dex */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @InterfaceC14067hI1
    public final long size(String string) {
        AbstractC13042fc3.i(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    @InterfaceC14067hI1
    public final long size(String string, int beginIndex, int endIndex) {
        AbstractC13042fc3.i(string, "string");
        return Utf8.size(string, beginIndex, endIndex);
    }
}
