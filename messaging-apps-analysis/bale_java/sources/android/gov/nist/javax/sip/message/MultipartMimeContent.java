package android.gov.nist.javax.sip.message;

import ir.nasim.InterfaceC19085pl1;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface MultipartMimeContent {
    boolean add(Content content);

    void addContent(Content content);

    int getContentCount();

    InterfaceC19085pl1 getContentTypeHeader();

    Iterator<Content> getContents();

    String toString();
}
