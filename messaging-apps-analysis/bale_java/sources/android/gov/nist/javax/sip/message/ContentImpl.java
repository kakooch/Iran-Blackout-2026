package android.gov.nist.javax.sip.message;

import android.gov.nist.core.Separators;
import ir.nasim.HU2;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC23329wk1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ContentImpl implements Content {
    private Object content;
    private InterfaceC23329wk1 contentDispositionHeader;
    private InterfaceC19085pl1 contentTypeHeader;
    private List<HU2> extensionHeaders = new ArrayList();

    public ContentImpl(String str) {
        this.content = str;
    }

    public void addExtensionHeader(HU2 hu2) {
        this.extensionHeaders.add(hu2);
    }

    @Override // android.gov.nist.javax.sip.message.Content
    public Object getContent() {
        return this.content;
    }

    @Override // android.gov.nist.javax.sip.message.Content
    public InterfaceC23329wk1 getContentDispositionHeader() {
        return this.contentDispositionHeader;
    }

    @Override // android.gov.nist.javax.sip.message.Content
    public InterfaceC19085pl1 getContentTypeHeader() {
        return this.contentTypeHeader;
    }

    @Override // android.gov.nist.javax.sip.message.Content
    public Iterator<HU2> getExtensionHeaders() {
        return this.extensionHeaders.iterator();
    }

    @Override // android.gov.nist.javax.sip.message.Content
    public void setContent(Object obj) {
        this.content = obj;
    }

    public void setContentDispositionHeader(InterfaceC23329wk1 interfaceC23329wk1) {
        this.contentDispositionHeader = interfaceC23329wk1;
    }

    public void setContentTypeHeader(InterfaceC19085pl1 interfaceC19085pl1) {
        this.contentTypeHeader = interfaceC19085pl1;
    }

    @Override // android.gov.nist.javax.sip.message.Content
    public String toString() {
        StringBuilder sb = new StringBuilder();
        InterfaceC19085pl1 interfaceC19085pl1 = this.contentTypeHeader;
        if (interfaceC19085pl1 != null) {
            sb.append(interfaceC19085pl1.toString());
        }
        InterfaceC23329wk1 interfaceC23329wk1 = this.contentDispositionHeader;
        if (interfaceC23329wk1 != null) {
            sb.append(interfaceC23329wk1.toString());
        }
        Iterator<HU2> it = this.extensionHeaders.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        sb.append(Separators.NEWLINE);
        sb.append(this.content.toString());
        return sb.toString();
    }
}
