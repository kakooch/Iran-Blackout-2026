package org.xbill.DNS.lookup;

import android.gov.nist.core.Separators;
import lombok.Generated;
import org.xbill.DNS.ExtendedErrorCodeOption;
import org.xbill.DNS.Name;
import org.xbill.DNS.Type;

/* loaded from: classes8.dex */
public class ServerFailedException extends LookupFailedException {
    private final ExtendedErrorCodeOption extendedRcode;

    public ServerFailedException() {
        this.extendedRcode = null;
    }

    @Generated
    public ExtendedErrorCodeOption getExtendedRcode() {
        return this.extendedRcode;
    }

    public ServerFailedException(Name name, int i) {
        super(name, i);
        this.extendedRcode = null;
    }

    public ServerFailedException(Name name, int i, ExtendedErrorCodeOption extendedErrorCodeOption) {
        super("Lookup for " + name + Separators.SLASH + Type.string(i) + " failed with " + extendedErrorCodeOption.getText(), name, i);
        this.extendedRcode = extendedErrorCodeOption;
    }
}
