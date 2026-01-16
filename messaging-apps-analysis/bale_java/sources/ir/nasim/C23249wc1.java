package ir.nasim;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: ir.nasim.wc1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23249wc1 extends EventListener {
    private final List a;

    /* renamed from: ir.nasim.wc1$a */
    public static final class a implements EventListener.Factory {
        private final Collection a;

        public a(Collection collection) {
            AbstractC13042fc3.i(collection, "factories");
            this.a = collection;
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            AbstractC13042fc3.i(call, "call");
            Collection collection = this.a;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection, 10));
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((EventListener.Factory) it.next()).create(call));
            }
            return new C23249wc1(arrayList, null);
        }
    }

    public /* synthetic */ C23249wc1(List list, ED1 ed1) {
        this(list);
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response response) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(response, "cachedResponse");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).cacheConditionalHit(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(response, "response");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).cacheHit(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).cacheMiss(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(iOException, "ioe");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).callFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).canceled(call);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(inetSocketAddress, "inetSocketAddress");
        AbstractC13042fc3.i(proxy, "proxy");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(inetSocketAddress, "inetSocketAddress");
        AbstractC13042fc3.i(proxy, "proxy");
        AbstractC13042fc3.i(iOException, "ioe");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(inetSocketAddress, "inetSocketAddress");
        AbstractC13042fc3.i(proxy, "proxy");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(connection, "connection");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(connection, "connection");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List list) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(str, "domainName");
        AbstractC13042fc3.i(list, "inetAddressList");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).dnsEnd(call, str, list);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(str, "domainName");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).dnsStart(call, str);
        }
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(Call call, HttpUrl httpUrl, List list) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(httpUrl, "url");
        AbstractC13042fc3.i(list, "proxies");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).proxySelectEnd(call, httpUrl, list);
        }
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(httpUrl, "url");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).proxySelectStart(call, httpUrl);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestBodyEnd(call, j);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException iOException) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(iOException, "ioe");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(request, "request");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestHeadersEnd(call, request);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseBodyEnd(call, j);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException iOException) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(iOException, "ioe");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(response, "response");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response) {
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(response, "response");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).satisfactionFailure(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        AbstractC13042fc3.i(call, "call");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((EventListener) it.next()).secureConnectStart(call);
        }
    }

    private C23249wc1(List list) {
        this.a = list;
    }
}
