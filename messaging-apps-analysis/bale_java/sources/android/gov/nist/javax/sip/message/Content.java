package android.gov.nist.javax.sip.message;

import ir.nasim.HU2;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC23329wk1;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface Content {
    Object getContent();

    InterfaceC23329wk1 getContentDispositionHeader();

    InterfaceC19085pl1 getContentTypeHeader();

    Iterator<HU2> getExtensionHeaders();

    void setContent(Object obj);

    String toString();
}
