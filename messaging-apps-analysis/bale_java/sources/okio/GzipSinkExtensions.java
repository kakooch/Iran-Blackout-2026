package okio;

import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, d2 = {"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* loaded from: classes8.dex */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        AbstractC13042fc3.i(sink, "<this>");
        return new GzipSink(sink);
    }
}
