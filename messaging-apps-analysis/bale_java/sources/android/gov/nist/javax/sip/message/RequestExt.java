package android.gov.nist.javax.sip.message;

import ir.nasim.HU2;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC21427te2;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC23329wk1;
import ir.nasim.InterfaceC24509yk1;
import ir.nasim.InterfaceC7365Rk1;
import ir.nasim.InterfaceC7599Sk1;
import ir.nasim.UP5;
import java.util.ListIterator;

/* loaded from: classes.dex */
public interface RequestExt extends UP5, MessageExt {
    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void addFirst(HU2 hu2);

    @Override // ir.nasim.K44
    /* synthetic */ void addHeader(HU2 hu2);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void addLast(HU2 hu2);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ Object clone();

    @Override // ir.nasim.K44
    /* synthetic */ Object getContent();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ InterfaceC23329wk1 getContentDisposition();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ InterfaceC24509yk1 getContentEncoding();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ InterfaceC7365Rk1 getContentLanguage();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ InterfaceC7599Sk1 getContentLength();

    @Override // ir.nasim.K44
    /* synthetic */ InterfaceC21427te2 getExpires();

    @Override // ir.nasim.K44
    /* synthetic */ HU2 getHeader(String str);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ ListIterator getHeaderNames();

    @Override // ir.nasim.K44
    /* synthetic */ ListIterator getHeaders(String str);

    @Override // ir.nasim.UP5
    /* synthetic */ String getMethod();

    @Override // ir.nasim.K44
    /* synthetic */ byte[] getRawContent();

    @Override // ir.nasim.UP5
    /* synthetic */ InterfaceC21815uA7 getRequestURI();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ String getSIPVersion();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ ListIterator getUnrecognizedHeaders();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void removeContent();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void removeFirst(String str);

    @Override // ir.nasim.K44
    /* synthetic */ void removeHeader(String str);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void removeLast(String str);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void setContent(Object obj, InterfaceC19085pl1 interfaceC19085pl1);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void setContentDisposition(InterfaceC23329wk1 interfaceC23329wk1);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void setContentEncoding(InterfaceC24509yk1 interfaceC24509yk1);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void setContentLanguage(InterfaceC7365Rk1 interfaceC7365Rk1);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void setContentLength(InterfaceC7599Sk1 interfaceC7599Sk1);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void setExpires(InterfaceC21427te2 interfaceC21427te2);

    @Override // ir.nasim.K44
    /* synthetic */ void setHeader(HU2 hu2);

    /* synthetic */ void setMethod(String str);

    /* synthetic */ void setRequestURI(InterfaceC21815uA7 interfaceC21815uA7);

    @Override // android.gov.nist.javax.sip.message.MessageExt
    /* synthetic */ void setSIPVersion(String str);
}
