package ir.nasim;

import ir.nasim.InterfaceC16239kw0;
import ir.nasim.InterfaceC22261uw0;
import kotlin.NoWhenBranchMatchedException;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public abstract class NN3 {
    public static final InterfaceC16239kw0 a(InterfaceC22261uw0 interfaceC22261uw0, InterfaceC16239kw0 interfaceC16239kw0) {
        InterfaceC16239kw0 interfaceC16239kw0E;
        AbstractC13042fc3.i(interfaceC22261uw0, "callLogState");
        AbstractC13042fc3.i(interfaceC16239kw0, "callLogItem");
        if (interfaceC22261uw0 instanceof InterfaceC22261uw0.a) {
            return interfaceC16239kw0;
        }
        if (!(interfaceC22261uw0 instanceof InterfaceC22261uw0.b)) {
            throw new NoWhenBranchMatchedException();
        }
        if (AbstractC13042fc3.d(interfaceC16239kw0, InterfaceC16239kw0.d.a) || (interfaceC16239kw0 instanceof InterfaceC16239kw0.b) || (interfaceC16239kw0 instanceof InterfaceC16239kw0.f)) {
            return interfaceC16239kw0;
        }
        if (!(interfaceC16239kw0 instanceof InterfaceC16239kw0.a)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC22261uw0.b bVar = (InterfaceC22261uw0.b) interfaceC22261uw0;
        EnumC23944xm6 enumC23944xm6 = bVar.c() ? bVar.b().contains(Long.valueOf(((InterfaceC16239kw0.a) interfaceC16239kw0).getId())) ? EnumC23944xm6.b : EnumC23944xm6.a : bVar.b().contains(Long.valueOf(((InterfaceC16239kw0.a) interfaceC16239kw0).getId())) ? EnumC23944xm6.a : EnumC23944xm6.b;
        InterfaceC16239kw0.a aVar = (InterfaceC16239kw0.a) interfaceC16239kw0;
        if (aVar instanceof InterfaceC16239kw0.c) {
            InterfaceC16239kw0.c cVar = (InterfaceC16239kw0.c) interfaceC16239kw0;
            interfaceC16239kw0E = cVar.e((WKSRecord.Service.SUNRPC & 1) != 0 ? cVar.a : 0L, (WKSRecord.Service.SUNRPC & 2) != 0 ? cVar.b : null, (WKSRecord.Service.SUNRPC & 4) != 0 ? cVar.c : null, (WKSRecord.Service.SUNRPC & 8) != 0 ? cVar.d : 0, (WKSRecord.Service.SUNRPC & 16) != 0 ? cVar.e : enumC23944xm6, (WKSRecord.Service.SUNRPC & 32) != 0 ? cVar.f : null, (WKSRecord.Service.SUNRPC & 64) != 0 ? cVar.g : null);
        } else if (aVar instanceof InterfaceC16239kw0.e) {
            InterfaceC16239kw0.e eVar = (InterfaceC16239kw0.e) interfaceC16239kw0;
            interfaceC16239kw0E = eVar.e((WKSRecord.Service.SUNRPC & 1) != 0 ? eVar.a : 0L, (WKSRecord.Service.SUNRPC & 2) != 0 ? eVar.b : null, (WKSRecord.Service.SUNRPC & 4) != 0 ? eVar.c : null, (WKSRecord.Service.SUNRPC & 8) != 0 ? eVar.d : 0, (WKSRecord.Service.SUNRPC & 16) != 0 ? eVar.e : enumC23944xm6, (WKSRecord.Service.SUNRPC & 32) != 0 ? eVar.f : null, (WKSRecord.Service.SUNRPC & 64) != 0 ? eVar.g : null);
        } else {
            if (!(aVar instanceof InterfaceC16239kw0.g)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC16239kw0.g gVar = (InterfaceC16239kw0.g) interfaceC16239kw0;
            interfaceC16239kw0E = gVar.e((WKSRecord.Service.SUNRPC & 1) != 0 ? gVar.a : 0L, (WKSRecord.Service.SUNRPC & 2) != 0 ? gVar.b : null, (WKSRecord.Service.SUNRPC & 4) != 0 ? gVar.c : null, (WKSRecord.Service.SUNRPC & 8) != 0 ? gVar.d : 0, (WKSRecord.Service.SUNRPC & 16) != 0 ? gVar.e : enumC23944xm6, (WKSRecord.Service.SUNRPC & 32) != 0 ? gVar.f : null, (WKSRecord.Service.SUNRPC & 64) != 0 ? gVar.g : null);
        }
        return interfaceC16239kw0E;
    }
}
