package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: ir.nasim.Ol2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6663Ol2 extends EventListener {
    private final String a;
    private long b;

    /* renamed from: ir.nasim.Ol2$a */
    public static final class a implements EventListener.Factory {
        private final String a;

        public a(String str) {
            AbstractC13042fc3.i(str, ParameterNames.TAG);
            this.a = str;
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            AbstractC13042fc3.i(call, "call");
            return new C6663Ol2(this.a);
        }
    }

    public C6663Ol2(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        this.a = str;
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.b);
        C19406qI3.a(this.a, str + " [" + millis + " ms]", new Object[0]);
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(iOException, "ioe");
        logWithTime("callFailed: " + iOException);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        this.b = System.nanoTime();
        logWithTime("callStart");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(inetSocketAddress, "inetSocketAddress");
        AbstractC13042fc3.i(proxy, "proxy");
        logWithTime("connectEnd: " + protocol);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(inetSocketAddress, "inetSocketAddress");
        AbstractC13042fc3.i(proxy, "proxy");
        AbstractC13042fc3.i(iOException, "ioe");
        logWithTime("connectFailed: " + protocol + Separators.SP + iOException);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(inetSocketAddress, "inetSocketAddress");
        AbstractC13042fc3.i(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress);
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(connection, "connection");
        logWithTime("connectionAcquired");
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(connection, "connection");
        logWithTime("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List list) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(str, "domainName");
        AbstractC13042fc3.i(list, "inetAddressList");
        logWithTime("dnsEnd: " + list);
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(str, "domainName");
        logWithTime("dnsStart: " + str);
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("requestBodyEnd: byteCount=" + j);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(request, "request");
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("responseBodyEnd: byteCount=" + j);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(response, "response");
        logWithTime("responseHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("secureConnectEnd");
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        logWithTime("secureConnectStart");
    }
}
