package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC5044Hq6;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class Server extends SIPHeader implements InterfaceC5044Hq6 {
    private static final long serialVersionUID = -3587764149383342973L;
    protected List productTokens;

    public Server() {
        super(SIPHeaderNames.SERVER);
        this.productTokens = new LinkedList();
    }

    private StringBuilder encodeProduct(StringBuilder sb) {
        ListIterator listIterator = this.productTokens.listIterator();
        while (listIterator.hasNext()) {
            sb.append((String) listIterator.next());
            if (!listIterator.hasNext()) {
                break;
            }
            sb.append('/');
        }
        return sb;
    }

    public void addProductToken(String str) {
        this.productTokens.add(str);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        return encodeProduct(sb);
    }

    public ListIterator getProduct() {
        List list = this.productTokens;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.productTokens.listIterator();
    }

    public void setProduct(List list) {
        if (list == null) {
            throw new NullPointerException("JAIN-SIP Exception, UserAgent, setProduct(), the  product parameter is null");
        }
        this.productTokens = list;
    }
}
