package okhttp3;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0011J'\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J)\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lokhttp3/WebSocketListener;", "", "<init>", "()V", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "Lir/nasim/rB7;", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", ParameterNames.TEXT, "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", "code", "reason", "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int code, String reason) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(reason, "reason");
    }

    public void onClosing(WebSocket webSocket, int code, String reason) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(reason, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(t, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(text, ParameterNames.TEXT);
    }

    public void onOpen(WebSocket webSocket, Response response) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(response, "response");
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(bytes, "bytes");
    }
}
