package ir.nasim;

import java.io.Serializable;
import java.util.ListIterator;

/* loaded from: classes.dex */
public interface K44 extends Cloneable, Serializable {
    void addHeader(HU2 hu2);

    Object getContent();

    InterfaceC21427te2 getExpires();

    HU2 getHeader(String str);

    ListIterator getHeaders(String str);

    byte[] getRawContent();

    void removeHeader(String str);

    void setHeader(HU2 hu2);
}
