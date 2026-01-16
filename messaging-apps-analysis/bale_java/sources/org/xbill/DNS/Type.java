package org.xbill.DNS;

import android.gov.nist.javax.sdp.fields.SDPKeywords;
import java.util.HashMap;
import java.util.function.Supplier;

/* loaded from: classes8.dex */
public final class Type {
    public static final int A = 1;
    public static final int A6 = 38;
    public static final int AAAA = 28;
    public static final int AFSDB = 18;
    public static final int AMTRELAY = 260;
    public static final int ANY = 255;
    public static final int APL = 42;
    public static final int ATMA = 34;
    public static final int AVC = 258;
    public static final int AXFR = 252;
    public static final int CAA = 257;
    public static final int CDNSKEY = 60;
    public static final int CDS = 59;
    public static final int CERT = 37;
    public static final int CNAME = 5;
    public static final int CSYNC = 62;
    public static final int DHCID = 49;
    public static final int DLV = 32769;
    public static final int DNAME = 39;
    public static final int DNSKEY = 48;
    public static final int DOA = 259;
    public static final int DS = 43;
    public static final int EID = 31;
    public static final int EUI48 = 108;
    public static final int EUI64 = 109;
    public static final int GID = 102;
    public static final int GPOS = 27;
    public static final int HINFO = 13;
    public static final int HIP = 55;
    public static final int HTTPS = 65;
    public static final int IPSECKEY = 45;
    public static final int ISDN = 20;
    public static final int IXFR = 251;
    public static final int KEY = 25;
    public static final int KX = 36;
    public static final int L32 = 105;
    public static final int L64 = 106;
    public static final int LOC = 29;
    public static final int LP = 107;
    public static final int MAILA = 254;
    public static final int MAILB = 253;
    public static final int MB = 7;
    public static final int MD = 3;
    public static final int MF = 4;
    public static final int MG = 8;
    public static final int MINFO = 14;
    public static final int MR = 9;
    public static final int MX = 15;
    public static final int NAPTR = 35;
    public static final int NID = 104;
    public static final int NIMLOC = 32;
    public static final int NINFO = 56;
    public static final int NS = 2;
    public static final int NSAP = 22;
    public static final int NSAP_PTR = 23;
    public static final int NSEC = 47;
    public static final int NSEC3 = 50;
    public static final int NSEC3PARAM = 51;
    public static final int NULL = 10;
    public static final int NXT = 30;
    public static final int OPENPGPKEY = 61;
    public static final int OPT = 41;
    public static final int PTR = 12;
    public static final int PX = 26;
    public static final int RKEY = 57;
    public static final int RP = 17;
    public static final int RRSIG = 46;
    public static final int RT = 21;
    public static final int SIG = 24;
    public static final int SINK = 40;
    public static final int SMIMEA = 53;
    public static final int SOA = 6;
    public static final int SPF = 99;
    public static final int SRV = 33;
    public static final int SSHFP = 44;
    public static final int SVCB = 64;
    public static final int TA = 32768;
    public static final int TALINK = 58;
    public static final int TKEY = 249;
    public static final int TLSA = 52;
    public static final int TSIG = 250;
    public static final int TXT = 16;
    public static final int UID = 101;
    public static final int UINFO = 100;
    public static final int UNSPEC = 103;
    public static final int URI = 256;
    public static final int WKS = 11;
    public static final int X25 = 19;
    public static final int ZONEMD = 63;
    private static final TypeMnemonic types;

    private static class TypeMnemonic extends Mnemonic {
        private final HashMap<Integer, Supplier<Record>> factories;

        public TypeMnemonic() {
            super("Type", 2);
            setPrefix("TYPE");
            setMaximum(65535);
            this.factories = new HashMap<>();
        }

        public void add(int i, String str, Supplier<Record> supplier) {
            super.add(i, str);
            this.factories.put(Integer.valueOf(i), supplier);
        }

        @Override // org.xbill.DNS.Mnemonic
        public void check(int i) {
            Type.check(i);
        }

        public Supplier<Record> getFactory(int i) {
            check(i);
            return this.factories.get(Integer.valueOf(i));
        }

        public void replace(int i, String str, Supplier<Record> supplier) {
            int value = getValue(str);
            if (value != -1) {
                if (value != i) {
                    throw new IllegalArgumentException("mnemnonic \"" + str + "\" already used by type " + value);
                }
                remove(i);
                this.factories.remove(Integer.valueOf(i));
            }
            add(i, str, supplier);
        }
    }

    static {
        TypeMnemonic typeMnemonic = new TypeMnemonic();
        types = typeMnemonic;
        typeMnemonic.add(1, "A", new Supplier() { // from class: org.xbill.DNS.A
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ARecord();
            }
        });
        typeMnemonic.add(2, "NS", new Supplier() { // from class: org.xbill.DNS.C
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NSRecord();
            }
        });
        typeMnemonic.add(3, "MD", new Supplier() { // from class: org.xbill.DNS.O
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MDRecord();
            }
        });
        typeMnemonic.add(4, "MF", new Supplier() { // from class: org.xbill.DNS.b0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MFRecord();
            }
        });
        typeMnemonic.add(5, "CNAME", new Supplier() { // from class: org.xbill.DNS.n0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new CNAMERecord();
            }
        });
        typeMnemonic.add(6, "SOA", new Supplier() { // from class: org.xbill.DNS.z0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new SOARecord();
            }
        });
        typeMnemonic.add(7, "MB", new Supplier() { // from class: org.xbill.DNS.C0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MBRecord();
            }
        });
        typeMnemonic.add(8, "MG", new Supplier() { // from class: org.xbill.DNS.D0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MGRecord();
            }
        });
        typeMnemonic.add(9, "MR", new Supplier() { // from class: org.xbill.DNS.F0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MRRecord();
            }
        });
        typeMnemonic.add(10, "NULL", new Supplier() { // from class: org.xbill.DNS.G0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NULLRecord();
            }
        });
        typeMnemonic.add(11, "WKS", new Supplier() { // from class: org.xbill.DNS.L
            @Override // java.util.function.Supplier
            public final Object get() {
                return new WKSRecord();
            }
        });
        typeMnemonic.add(12, "PTR", new Supplier() { // from class: org.xbill.DNS.X
            @Override // java.util.function.Supplier
            public final Object get() {
                return new PTRRecord();
            }
        });
        typeMnemonic.add(13, "HINFO", new Supplier() { // from class: org.xbill.DNS.i0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new HINFORecord();
            }
        });
        typeMnemonic.add(14, "MINFO", new Supplier() { // from class: org.xbill.DNS.t0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MINFORecord();
            }
        });
        typeMnemonic.add(15, "MX", new Supplier() { // from class: org.xbill.DNS.E0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MXRecord();
            }
        });
        typeMnemonic.add(16, "TXT", new Supplier() { // from class: org.xbill.DNS.H0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new TXTRecord();
            }
        });
        typeMnemonic.add(17, "RP", new Supplier() { // from class: org.xbill.DNS.I0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new RPRecord();
            }
        });
        typeMnemonic.add(18, "AFSDB", new Supplier() { // from class: org.xbill.DNS.J0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new AFSDBRecord();
            }
        });
        typeMnemonic.add(19, "X25", new Supplier() { // from class: org.xbill.DNS.K0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new X25Record();
            }
        });
        typeMnemonic.add(20, "ISDN", new Supplier() { // from class: org.xbill.DNS.B
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ISDNRecord();
            }
        });
        typeMnemonic.add(21, "RT", new Supplier() { // from class: org.xbill.DNS.D
            @Override // java.util.function.Supplier
            public final Object get() {
                return new RTRecord();
            }
        });
        typeMnemonic.add(22, "NSAP", new Supplier() { // from class: org.xbill.DNS.E
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NSAPRecord();
            }
        });
        typeMnemonic.add(23, "NSAP-PTR", new Supplier() { // from class: org.xbill.DNS.F
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NSAP_PTRRecord();
            }
        });
        typeMnemonic.add(24, "SIG", new Supplier() { // from class: org.xbill.DNS.G
            @Override // java.util.function.Supplier
            public final Object get() {
                return new SIGRecord();
            }
        });
        typeMnemonic.add(25, "KEY", new Supplier() { // from class: org.xbill.DNS.H
            @Override // java.util.function.Supplier
            public final Object get() {
                return new KEYRecord();
            }
        });
        typeMnemonic.add(26, "PX", new Supplier() { // from class: org.xbill.DNS.I
            @Override // java.util.function.Supplier
            public final Object get() {
                return new PXRecord();
            }
        });
        typeMnemonic.add(27, "GPOS", new Supplier() { // from class: org.xbill.DNS.J
            @Override // java.util.function.Supplier
            public final Object get() {
                return new GPOSRecord();
            }
        });
        typeMnemonic.add(28, "AAAA", new Supplier() { // from class: org.xbill.DNS.K
            @Override // java.util.function.Supplier
            public final Object get() {
                return new AAAARecord();
            }
        });
        typeMnemonic.add(29, "LOC", new Supplier() { // from class: org.xbill.DNS.M
            @Override // java.util.function.Supplier
            public final Object get() {
                return new LOCRecord();
            }
        });
        typeMnemonic.add(30, "NXT", new Supplier() { // from class: org.xbill.DNS.N
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NXTRecord();
            }
        });
        typeMnemonic.add(31, "EID");
        typeMnemonic.add(32, "NIMLOC");
        typeMnemonic.add(33, "SRV", new Supplier() { // from class: org.xbill.DNS.P
            @Override // java.util.function.Supplier
            public final Object get() {
                return new SRVRecord();
            }
        });
        typeMnemonic.add(34, "ATMA");
        typeMnemonic.add(35, "NAPTR", new Supplier() { // from class: org.xbill.DNS.Q
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NAPTRRecord();
            }
        });
        typeMnemonic.add(36, "KX", new Supplier() { // from class: org.xbill.DNS.S
            @Override // java.util.function.Supplier
            public final Object get() {
                return new KXRecord();
            }
        });
        typeMnemonic.add(37, "CERT", new Supplier() { // from class: org.xbill.DNS.T
            @Override // java.util.function.Supplier
            public final Object get() {
                return new CERTRecord();
            }
        });
        typeMnemonic.add(38, "A6", new Supplier() { // from class: org.xbill.DNS.U
            @Override // java.util.function.Supplier
            public final Object get() {
                return new A6Record();
            }
        });
        typeMnemonic.add(39, "DNAME", new Supplier() { // from class: org.xbill.DNS.V
            @Override // java.util.function.Supplier
            public final Object get() {
                return new DNAMERecord();
            }
        });
        typeMnemonic.add(40, "SINK");
        typeMnemonic.add(41, "OPT", new Supplier() { // from class: org.xbill.DNS.W
            @Override // java.util.function.Supplier
            public final Object get() {
                return new OPTRecord();
            }
        });
        typeMnemonic.add(42, "APL", new Supplier() { // from class: org.xbill.DNS.Y
            @Override // java.util.function.Supplier
            public final Object get() {
                return new APLRecord();
            }
        });
        typeMnemonic.add(43, "DS", new Supplier() { // from class: org.xbill.DNS.Z
            @Override // java.util.function.Supplier
            public final Object get() {
                return new DSRecord();
            }
        });
        typeMnemonic.add(44, "SSHFP", new Supplier() { // from class: org.xbill.DNS.a0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new SSHFPRecord();
            }
        });
        typeMnemonic.add(45, "IPSECKEY", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new IPSECKEYRecord();
            }
        });
        typeMnemonic.add(46, "RRSIG", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new RRSIGRecord();
            }
        });
        typeMnemonic.add(47, "NSEC", new Supplier() { // from class: org.xbill.DNS.e0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NSECRecord();
            }
        });
        typeMnemonic.add(48, "DNSKEY", new Supplier() { // from class: org.xbill.DNS.f0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new DNSKEYRecord();
            }
        });
        typeMnemonic.add(49, "DHCID", new Supplier() { // from class: org.xbill.DNS.g0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new DHCIDRecord();
            }
        });
        typeMnemonic.add(50, "NSEC3", new Supplier() { // from class: org.xbill.DNS.h0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NSEC3Record();
            }
        });
        typeMnemonic.add(51, "NSEC3PARAM", new Supplier() { // from class: org.xbill.DNS.j0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new NSEC3PARAMRecord();
            }
        });
        typeMnemonic.add(52, "TLSA", new Supplier() { // from class: org.xbill.DNS.k0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new TLSARecord();
            }
        });
        typeMnemonic.add(53, "SMIMEA", new Supplier() { // from class: org.xbill.DNS.l0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new SMIMEARecord();
            }
        });
        typeMnemonic.add(55, "HIP", new Supplier() { // from class: org.xbill.DNS.m0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new HIPRecord();
            }
        });
        typeMnemonic.add(56, "NINFO");
        typeMnemonic.add(57, "RKEY");
        typeMnemonic.add(58, "TALINK");
        typeMnemonic.add(59, "CDS", new Supplier() { // from class: org.xbill.DNS.o0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new CDSRecord();
            }
        });
        typeMnemonic.add(60, "CDNSKEY", new Supplier() { // from class: org.xbill.DNS.p0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new CDNSKEYRecord();
            }
        });
        typeMnemonic.add(61, "OPENPGPKEY", new Supplier() { // from class: org.xbill.DNS.q0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new OPENPGPKEYRecord();
            }
        });
        typeMnemonic.add(62, "CSYNC");
        typeMnemonic.add(63, "ZONEMD", new Supplier() { // from class: org.xbill.DNS.r0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ZoneMDRecord();
            }
        });
        typeMnemonic.add(64, "SVCB", new Supplier() { // from class: org.xbill.DNS.s0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new SVCBRecord();
            }
        });
        typeMnemonic.add(65, "HTTPS", new Supplier() { // from class: org.xbill.DNS.u0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new HTTPSRecord();
            }
        });
        typeMnemonic.add(99, "SPF", new Supplier() { // from class: org.xbill.DNS.v0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new SPFRecord();
            }
        });
        typeMnemonic.add(100, "UINFO");
        typeMnemonic.add(101, "UID");
        typeMnemonic.add(102, "GID");
        typeMnemonic.add(103, "UNSPEC");
        typeMnemonic.add(104, "NID");
        typeMnemonic.add(105, "L32");
        typeMnemonic.add(L64, "L64");
        typeMnemonic.add(107, "LP");
        typeMnemonic.add(EUI48, "EUI48");
        typeMnemonic.add(109, "EUI64");
        typeMnemonic.add(249, "TKEY", new Supplier() { // from class: org.xbill.DNS.w0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new TKEYRecord();
            }
        });
        typeMnemonic.add(TSIG, "TSIG", new Supplier() { // from class: org.xbill.DNS.x0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new TSIGRecord();
            }
        });
        typeMnemonic.add(IXFR, "IXFR");
        typeMnemonic.add(252, "AXFR");
        typeMnemonic.add(253, "MAILB");
        typeMnemonic.add(254, "MAILA");
        typeMnemonic.add(255, "ANY");
        typeMnemonic.add(256, SDPKeywords.URI, new Supplier() { // from class: org.xbill.DNS.y0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new URIRecord();
            }
        });
        typeMnemonic.add(CAA, "CAA", new Supplier() { // from class: org.xbill.DNS.A0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new CAARecord();
            }
        });
        typeMnemonic.add(AVC, "AVC");
        typeMnemonic.add(DOA, "DOA");
        typeMnemonic.add(AMTRELAY, "AMTRELAY");
        typeMnemonic.add(32768, "TA");
        typeMnemonic.add(DLV, "DLV", new Supplier() { // from class: org.xbill.DNS.B0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new DLVRecord();
            }
        });
    }

    private Type() {
    }

    public static void check(int i) {
        if (!Utils.isUInt16(i)) {
            throw new InvalidTypeException(i);
        }
    }

    static Supplier<Record> getFactory(int i) {
        return types.getFactory(i);
    }

    public static boolean isRR(int i) {
        if (i == 41) {
            return false;
        }
        switch (i) {
            case 249:
            case TSIG /* 250 */:
            case IXFR /* 251 */:
            case 252:
            case 253:
            case 254:
            case 255:
                return false;
            default:
                return true;
        }
    }

    public static void register(int i, String str, Supplier<Record> supplier) {
        types.replace(i, str, supplier);
    }

    public static String string(int i) {
        return types.getText(i);
    }

    public static int value(String str, boolean z) {
        TypeMnemonic typeMnemonic = types;
        int value = typeMnemonic.getValue(str);
        if (value != -1 || !z) {
            return value;
        }
        return typeMnemonic.getValue("TYPE" + str);
    }

    public static int value(String str) {
        return value(str, false);
    }
}
