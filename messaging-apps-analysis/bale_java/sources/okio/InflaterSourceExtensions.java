package okio;

import ir.nasim.AbstractC13042fc3;
import java.util.zip.Inflater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: classes8.dex */
public final class InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        AbstractC13042fc3.i(source, "<this>");
        AbstractC13042fc3.i(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        AbstractC13042fc3.i(source, "<this>");
        AbstractC13042fc3.i(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
