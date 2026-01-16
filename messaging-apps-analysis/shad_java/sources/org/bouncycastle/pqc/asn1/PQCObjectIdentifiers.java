package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;

/* loaded from: classes4.dex */
public interface PQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier gmss;
    public static final ASN1ObjectIdentifier mcEliece;
    public static final ASN1ObjectIdentifier mcElieceCca2;
    public static final ASN1ObjectIdentifier newHope;
    public static final ASN1ObjectIdentifier qTESLA_p_I;
    public static final ASN1ObjectIdentifier qTESLA_p_III;
    public static final ASN1ObjectIdentifier rainbow;
    public static final ASN1ObjectIdentifier sphincs256;
    public static final ASN1ObjectIdentifier xmss;
    public static final ASN1ObjectIdentifier xmss_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE128ph;
    public static final ASN1ObjectIdentifier xmss_SHAKE256ph;
    public static final ASN1ObjectIdentifier xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_SHA256ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHA512ph;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_SHAKE256;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
        rainbow = aSN1ObjectIdentifier;
        aSN1ObjectIdentifier.branch("1");
        aSN1ObjectIdentifier.branch("2");
        aSN1ObjectIdentifier.branch("3");
        aSN1ObjectIdentifier.branch("4");
        aSN1ObjectIdentifier.branch("5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.3");
        gmss = aSN1ObjectIdentifier2;
        aSN1ObjectIdentifier2.branch("1");
        aSN1ObjectIdentifier2.branch("2");
        aSN1ObjectIdentifier2.branch("3");
        aSN1ObjectIdentifier2.branch("4");
        aSN1ObjectIdentifier2.branch("5");
        mcEliece = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
        mcElieceCca2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.1");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.2");
        new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.3");
        sphincs256 = BCObjectIdentifiers.sphincs256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.sphincs256_with_BLAKE512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.sphincs256_with_SHA512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = BCObjectIdentifiers.sphincs256_with_SHA3_512;
        newHope = BCObjectIdentifiers.newHope;
        xmss = BCObjectIdentifiers.xmss;
        xmss_SHA256ph = BCObjectIdentifiers.xmss_SHA256ph;
        xmss_SHA512ph = BCObjectIdentifiers.xmss_SHA512ph;
        xmss_SHAKE128ph = BCObjectIdentifiers.xmss_SHAKE128ph;
        xmss_SHAKE256ph = BCObjectIdentifiers.xmss_SHAKE256ph;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = BCObjectIdentifiers.xmss_SHA256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = BCObjectIdentifiers.xmss_SHA512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = BCObjectIdentifiers.xmss_SHAKE128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = BCObjectIdentifiers.xmss_SHAKE256;
        xmss_mt = BCObjectIdentifiers.xmss_mt;
        xmss_mt_SHA256ph = BCObjectIdentifiers.xmss_mt_SHA256ph;
        xmss_mt_SHA512ph = BCObjectIdentifiers.xmss_mt_SHA512ph;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = BCObjectIdentifiers.xmss_mt_SHAKE128ph;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = BCObjectIdentifiers.xmss_mt_SHAKE256ph;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = BCObjectIdentifiers.xmss_mt_SHA256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = BCObjectIdentifiers.xmss_mt_SHA512;
        xmss_mt_SHAKE128 = BCObjectIdentifiers.xmss_mt_SHAKE128;
        xmss_mt_SHAKE256 = BCObjectIdentifiers.xmss_mt_SHAKE256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = BCObjectIdentifiers.qTESLA;
        qTESLA_p_I = BCObjectIdentifiers.qTESLA_p_I;
        qTESLA_p_III = BCObjectIdentifiers.qTESLA_p_III;
    }
}
