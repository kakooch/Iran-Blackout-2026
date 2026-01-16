package ir.nasim;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Protocol;

/* renamed from: ir.nasim.gW1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13602gW1 extends EventListener {
    private final InterfaceC23154wR7 a;

    /* renamed from: ir.nasim.gW1$a */
    public static final class a implements EventListener.Factory {
        private final InterfaceC7720Sx5 a;

        public a(InterfaceC7720Sx5 interfaceC7720Sx5) {
            AbstractC13042fc3.i(interfaceC7720Sx5, "verifiableDnsResolverProvider");
            this.a = interfaceC7720Sx5;
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            AbstractC13042fc3.i(call, "call");
            Object obj = this.a.get();
            ((InterfaceC12984fW1) obj).initialize();
            AbstractC13042fc3.h(obj, "also(...)");
            return new C13602gW1((InterfaceC23154wR7) obj);
        }
    }

    public C13602gW1(InterfaceC23154wR7 interfaceC23154wR7) {
        AbstractC13042fc3.i(interfaceC23154wR7, "verifiableDnsResolver");
        this.a = interfaceC23154wR7;
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        InetAddress address;
        String hostAddress;
        AbstractC13042fc3.i(call, "call");
        AbstractC13042fc3.i(inetSocketAddress, "inetSocketAddress");
        AbstractC13042fc3.i(proxy, "proxy");
        String hostString = inetSocketAddress.getHostString();
        if (hostString == null || (address = inetSocketAddress.getAddress()) == null || (hostAddress = address.getHostAddress()) == null) {
            return;
        }
        this.a.a(hostString, AbstractC9766aX0.e(hostAddress));
    }
}
