package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class RelativeNameException extends IllegalArgumentException {
    public RelativeNameException(Name name) {
        super(Separators.QUOTE + name + "' is not an absolute name");
    }

    public RelativeNameException(String str) {
        super(str);
    }
}
