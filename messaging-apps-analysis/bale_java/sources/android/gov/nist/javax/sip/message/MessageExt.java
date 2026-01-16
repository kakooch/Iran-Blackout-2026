package android.gov.nist.javax.sip.message;

import ir.nasim.HU2;
import ir.nasim.InterfaceC12560ep0;
import ir.nasim.InterfaceC17560nA2;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC18560or7;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC21427te2;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.InterfaceC23329wk1;
import ir.nasim.InterfaceC24509yk1;
import ir.nasim.InterfaceC7365Rk1;
import ir.nasim.InterfaceC7599Sk1;
import ir.nasim.K44;
import java.util.ListIterator;

/* loaded from: classes.dex */
public interface MessageExt extends K44 {
    /* synthetic */ void addFirst(HU2 hu2);

    @Override // ir.nasim.K44
    /* synthetic */ void addHeader(HU2 hu2);

    /* synthetic */ void addLast(HU2 hu2);

    /* synthetic */ Object clone();

    Object getApplicationData();

    InterfaceC12560ep0 getCSeqHeader();

    InterfaceC21662tv0 getCallIdHeader();

    @Override // ir.nasim.K44
    /* synthetic */ Object getContent();

    /* synthetic */ InterfaceC23329wk1 getContentDisposition();

    /* synthetic */ InterfaceC24509yk1 getContentEncoding();

    /* synthetic */ InterfaceC7365Rk1 getContentLanguage();

    /* synthetic */ InterfaceC7599Sk1 getContentLength();

    InterfaceC7599Sk1 getContentLengthHeader();

    InterfaceC19085pl1 getContentTypeHeader();

    @Override // ir.nasim.K44
    /* synthetic */ InterfaceC21427te2 getExpires();

    String getFirstLine();

    InterfaceC17560nA2 getFromHeader();

    @Override // ir.nasim.K44
    /* synthetic */ HU2 getHeader(String str);

    /* synthetic */ ListIterator getHeaderNames();

    @Override // ir.nasim.K44
    /* synthetic */ ListIterator getHeaders(String str);

    MultipartMimeContent getMultipartMimeContent();

    @Override // ir.nasim.K44
    /* synthetic */ byte[] getRawContent();

    /* synthetic */ String getSIPVersion();

    InterfaceC18560or7 getToHeader();

    InterfaceC18318oS7 getTopmostViaHeader();

    /* synthetic */ ListIterator getUnrecognizedHeaders();

    /* synthetic */ void removeContent();

    /* synthetic */ void removeFirst(String str);

    @Override // ir.nasim.K44
    /* synthetic */ void removeHeader(String str);

    /* synthetic */ void removeLast(String str);

    void setApplicationData(Object obj);

    /* synthetic */ void setContent(Object obj, InterfaceC19085pl1 interfaceC19085pl1);

    /* synthetic */ void setContentDisposition(InterfaceC23329wk1 interfaceC23329wk1);

    /* synthetic */ void setContentEncoding(InterfaceC24509yk1 interfaceC24509yk1);

    /* synthetic */ void setContentLanguage(InterfaceC7365Rk1 interfaceC7365Rk1);

    /* synthetic */ void setContentLength(InterfaceC7599Sk1 interfaceC7599Sk1);

    /* synthetic */ void setExpires(InterfaceC21427te2 interfaceC21427te2);

    @Override // ir.nasim.K44
    /* synthetic */ void setHeader(HU2 hu2);

    /* synthetic */ void setSIPVersion(String str);
}
