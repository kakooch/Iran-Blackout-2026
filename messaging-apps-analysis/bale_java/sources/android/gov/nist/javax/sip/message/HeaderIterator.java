package android.gov.nist.javax.sip.message;

import android.gov.nist.javax.sip.header.SIPHeader;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class HeaderIterator implements ListIterator {
    private int index;
    private SIPHeader sipHeader;
    private SIPMessage sipMessage;
    private boolean toRemove;

    protected HeaderIterator(SIPMessage sIPMessage, SIPHeader sIPHeader) {
        this.sipMessage = sIPMessage;
        this.sipHeader = sIPHeader;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.index == 0;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index == 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        SIPHeader sIPHeader = this.sipHeader;
        if (sIPHeader == null || this.index == 1) {
            throw new NoSuchElementException();
        }
        this.toRemove = true;
        this.index = 1;
        return sIPHeader;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 1;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        SIPHeader sIPHeader = this.sipHeader;
        if (sIPHeader == null || this.index == 0) {
            throw new NoSuchElementException();
        }
        this.toRemove = true;
        this.index = 0;
        return sIPHeader;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index == 0 ? -1 : 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        if (this.sipHeader == null) {
            throw new IllegalStateException();
        }
        if (!this.toRemove) {
            throw new IllegalStateException();
        }
        SIPHeader sIPHeader = null;
        this.sipHeader = null;
        this.sipMessage.removeHeader(sIPHeader.getName());
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
