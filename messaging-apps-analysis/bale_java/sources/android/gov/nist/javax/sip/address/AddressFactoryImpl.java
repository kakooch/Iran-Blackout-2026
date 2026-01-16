package android.gov.nist.javax.sip.address;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.StringMsgParser;
import android.gov.nist.javax.sip.parser.URLParser;
import ir.nasim.InterfaceC16126kk7;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.ND6;
import java.text.ParseException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AddressFactoryImpl implements AddressFactoryEx {
    public static final Pattern SCHEME_PATTERN = Pattern.compile("\\p{Alpha}[[{\\p{Alpha}][\\p{Digit}][\\+][-][\\.]]*");

    public InterfaceC16609la createAddress() {
        return new AddressImpl();
    }

    @Override // android.gov.nist.javax.sip.address.AddressFactoryEx
    public ND6 createSipURI(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null URI");
        }
        try {
            return new StringMsgParser().parseSIPUrl(str);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    @Override // android.gov.nist.javax.sip.address.AddressFactoryEx
    public InterfaceC16126kk7 createTelURL(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null url");
        }
        if (!str.startsWith("tel:")) {
            str = "tel:" + str;
        }
        try {
            return (TelURLImpl) new StringMsgParser().parseUrl(str);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    @Override // android.gov.nist.javax.sip.address.AddressFactoryEx
    public InterfaceC21815uA7 createURI(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        try {
            String strPeekScheme = new URLParser(str).peekScheme();
            if (strPeekScheme == null) {
                throw new ParseException("bad scheme", 0);
            }
            if (!strPeekScheme.equalsIgnoreCase("sip") && !strPeekScheme.equalsIgnoreCase("sips")) {
                if (strPeekScheme.equalsIgnoreCase("tel")) {
                    return createTelURL(str);
                }
                if (SCHEME_PATTERN.matcher(strPeekScheme).matches()) {
                    return new GenericURI(str);
                }
                throw new ParseException("the scheme " + strPeekScheme + " from the following uri " + str + " doesn't match ALPHA *(ALPHA / DIGIT / \"+\" / \"-\" / \".\" ) from RFC3261", 0);
            }
            return createSipURI(str);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    @Override // android.gov.nist.javax.sip.address.AddressFactoryEx
    public InterfaceC16609la createAddress(String str, InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 == null) {
            throw new NullPointerException("null  URI");
        }
        AddressImpl addressImpl = new AddressImpl();
        if (str != null) {
            addressImpl.setDisplayName(str);
        }
        addressImpl.setURI(interfaceC21815uA7);
        return addressImpl;
    }

    @Override // android.gov.nist.javax.sip.address.AddressFactoryEx
    public ND6 createSipURI(String str, String str2) throws ParseException {
        if (str2 != null) {
            StringBuilder sb = new StringBuilder("sip:");
            if (str != null) {
                sb.append(str);
                sb.append(Separators.AT);
            }
            if (str2.indexOf(58) != str2.lastIndexOf(58) && str2.trim().charAt(0) != '[') {
                str2 = '[' + str2 + ']';
            }
            sb.append(str2);
            try {
                return createSipURI(sb.toString());
            } catch (ParseException e) {
                throw new ParseException(e.getMessage(), 0);
            }
        }
        throw new NullPointerException("null host");
    }

    @Override // android.gov.nist.javax.sip.address.AddressFactoryEx
    public InterfaceC16609la createAddress(InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 != null) {
            AddressImpl addressImpl = new AddressImpl();
            addressImpl.setURI(interfaceC21815uA7);
            return addressImpl;
        }
        throw new NullPointerException("null address");
    }

    @Override // android.gov.nist.javax.sip.address.AddressFactoryEx
    public InterfaceC16609la createAddress(String str) {
        if (str != null) {
            if (str.equals(Separators.STAR)) {
                AddressImpl addressImpl = new AddressImpl();
                addressImpl.setAddressType(3);
                SipUri sipUri = new SipUri();
                sipUri.setUser(Separators.STAR);
                addressImpl.setURI(sipUri);
                return addressImpl;
            }
            return new StringMsgParser().parseAddress(str);
        }
        throw new NullPointerException("null address");
    }
}
