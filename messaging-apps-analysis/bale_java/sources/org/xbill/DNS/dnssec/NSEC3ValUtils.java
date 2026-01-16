package org.xbill.DNS.dnssec;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import lombok.Generated;
import org.xbill.DNS.NSEC3Record;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;
import org.xbill.DNS.utils.base32;

/* loaded from: classes8.dex */
final class NSEC3ValUtils {
    private static final int MAX_ITERATION_COUNT = 65536;
    private static final int MAX_NSEC3_CALCULATIONS = 8;
    private static final int MAX_NSEC3_ERRORS = -1;
    public static final String NSEC3_MAX_ITERATIONS_PROPERTY_PREFIX = "dnsjava.dnssec.nsec3.iterations";
    private final TreeMap<Integer, Integer> maxIterations;

    @Generated
    private static final OI3 log = RI3.i(NSEC3ValUtils.class);
    private static final Name ASTERISK_LABEL = Name.fromConstantString(Separators.STAR);

    private static final class CEResponse {
        private final NSEC3Record ceNsec3;
        private final Name closestEncloser;
        private NSEC3Record ncNsec3;
        private SecurityStatus status;

        private CEResponse(Name name, NSEC3Record nSEC3Record) {
            this.status = SecurityStatus.UNCHECKED;
            this.closestEncloser = name;
            this.ceNsec3 = nSEC3Record;
        }
    }

    NSEC3ValUtils() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        this.maxIterations = treeMap;
        treeMap.put(1024, 150);
        treeMap.put(2048, Integer.valueOf(SIPTransactionStack.BASE_TIMER_INTERVAL));
        treeMap.put(4096, 2500);
    }

    private Name ceWildcard(Name name) {
        try {
            return Name.concatenate(ASTERISK_LABEL, name);
        } catch (NameTooLongException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        org.xbill.DNS.dnssec.NSEC3ValUtils.log.b("NSEC3 reached max. hash calculations");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.xbill.DNS.dnssec.NSEC3ValUtils.CEResponse findClosestEncloser(org.xbill.DNS.Name r4, org.xbill.DNS.Name r5, java.util.List<org.xbill.DNS.dnssec.SRRset> r6, org.xbill.DNS.dnssec.Nsec3ValidationState r7) {
        /*
            r3 = this;
        L0:
            int r0 = r4.labels()
            int r1 = r5.labels()
            r2 = 0
            if (r0 < r1) goto L30
            int r0 = r7.numCalc
            r1 = 8
            if (r0 >= r1) goto L29
            r1 = -1
            if (r0 != r1) goto L15
            goto L29
        L15:
            org.xbill.DNS.NSEC3Record r0 = r3.findMatchingNSEC3(r4, r5, r6, r7)
            if (r0 == 0) goto L21
            org.xbill.DNS.dnssec.NSEC3ValUtils$CEResponse r5 = new org.xbill.DNS.dnssec.NSEC3ValUtils$CEResponse
            r5.<init>(r4, r0)
            return r5
        L21:
            org.xbill.DNS.Name r0 = new org.xbill.DNS.Name
            r1 = 1
            r0.<init>(r4, r1)
            r4 = r0
            goto L0
        L29:
            ir.nasim.OI3 r4 = org.xbill.DNS.dnssec.NSEC3ValUtils.log
            java.lang.String r5 = "NSEC3 reached max. hash calculations"
            r4.b(r5)
        L30:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.dnssec.NSEC3ValUtils.findClosestEncloser(org.xbill.DNS.Name, org.xbill.DNS.Name, java.util.List, org.xbill.DNS.dnssec.Nsec3ValidationState):org.xbill.DNS.dnssec.NSEC3ValUtils$CEResponse");
    }

    private NSEC3Record findCoveringNSEC3(Name name, Name name2, List<SRRset> list, Nsec3ValidationState nsec3ValidationState) {
        NSEC3Record nSEC3Record;
        for (SRRset sRRset : list) {
            int i = nsec3ValidationState.numCalc;
            if (i >= 8) {
                if (nsec3ValidationState.numCalcErrors == i) {
                    nsec3ValidationState.numCalc = -1;
                }
                return null;
            }
            try {
                nSEC3Record = (NSEC3Record) sRRset.first();
            } catch (NoSuchAlgorithmException e) {
                nsec3ValidationState.numCalcErrors++;
                log.c("Unrecognized NSEC3 in set: {}", sRRset, e);
            }
            if (nsec3Covers(nSEC3Record, name2, nsec3ValidationState.computeIfAbsent(nSEC3Record, name).getHash())) {
                return nSEC3Record;
            }
        }
        return null;
    }

    private NSEC3Record findMatchingNSEC3(Name name, Name name2, List<SRRset> list, Nsec3ValidationState nsec3ValidationState) {
        NSEC3Record nSEC3Record;
        for (SRRset sRRset : list) {
            int i = nsec3ValidationState.numCalc;
            if (i >= 8) {
                if (i != nsec3ValidationState.numCalcErrors) {
                    log.b("NSEC3 reached max. hash calculations");
                    return null;
                }
                log.b("NSEC3 reached max. hash calculation errors");
                nsec3ValidationState.numCalc = -1;
                return null;
            }
            try {
                nSEC3Record = (NSEC3Record) sRRset.first();
            } catch (NoSuchAlgorithmException | TextParseException e) {
                nsec3ValidationState.numCalcErrors++;
                log.c("Unrecognized NSEC3 in set: {}", sRRset, e);
            }
            if (new Name(nsec3ValidationState.computeIfAbsent(nSEC3Record, name).getHashAsBase32(), name2).equals(nSEC3Record.getName())) {
                return nSEC3Record;
            }
        }
        return null;
    }

    private Name nextClosest(Name name, Name name2) {
        int iLabels = (name.labels() - name2.labels()) - 1;
        return iLabels > 0 ? new Name(name, iLabels) : name;
    }

    private boolean nsec3Covers(NSEC3Record nSEC3Record, Name name, byte[] bArr) throws IOException {
        if (!new Name(nSEC3Record.getName(), 1).equals(name)) {
            return false;
        }
        byte[] bArrFromString = new base32(base32.Alphabet.BASE32HEX, false, false).fromString(nSEC3Record.getName().getLabelString(0));
        byte[] next = nSEC3Record.getNext();
        if (ByteArrayComparator.compare(bArrFromString, bArr) >= 0 || ByteArrayComparator.compare(bArr, next) >= 0) {
            return ByteArrayComparator.compare(next, bArrFromString) <= 0 && (ByteArrayComparator.compare(bArr, bArrFromString) > 0 || ByteArrayComparator.compare(bArr, next) < 0);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CEResponse proveClosestEncloser(Name name, Name name2, List<SRRset> list, Nsec3ValidationState nsec3ValidationState) {
        CEResponse cEResponseFindClosestEncloser = findClosestEncloser(name, name2, list, nsec3ValidationState);
        if (cEResponseFindClosestEncloser == null) {
            log.b("Could not find a candidate for the closest encloser");
            CEResponse cEResponse = new CEResponse(Name.empty, null);
            cEResponse.status = SecurityStatus.BOGUS;
            return cEResponse;
        }
        if (cEResponseFindClosestEncloser.closestEncloser.equals(name)) {
            log.b("Proved that qname existed!");
            cEResponseFindClosestEncloser.status = SecurityStatus.BOGUS;
            return cEResponseFindClosestEncloser;
        }
        if (cEResponseFindClosestEncloser.ceNsec3.hasType(2) && !cEResponseFindClosestEncloser.ceNsec3.hasType(6)) {
            if (!cEResponseFindClosestEncloser.ceNsec3.hasType(43)) {
                cEResponseFindClosestEncloser.status = SecurityStatus.INSECURE;
                return cEResponseFindClosestEncloser;
            }
            log.b("Closest encloser was a delegation!");
            cEResponseFindClosestEncloser.status = SecurityStatus.BOGUS;
            return cEResponseFindClosestEncloser;
        }
        if (cEResponseFindClosestEncloser.ceNsec3.hasType(39)) {
            log.b("Closest encloser was a DNAME!");
            cEResponseFindClosestEncloser.status = SecurityStatus.BOGUS;
            return cEResponseFindClosestEncloser;
        }
        cEResponseFindClosestEncloser.ncNsec3 = findCoveringNSEC3(nextClosest(name, cEResponseFindClosestEncloser.closestEncloser), name2, list, nsec3ValidationState);
        if (cEResponseFindClosestEncloser.ncNsec3 != null) {
            cEResponseFindClosestEncloser.status = SecurityStatus.SECURE;
            return cEResponseFindClosestEncloser;
        }
        log.b("Could not find proof that the closest encloser was the closest encloser");
        cEResponseFindClosestEncloser.status = SecurityStatus.BOGUS;
        return cEResponseFindClosestEncloser;
    }

    private boolean supportsHashAlgorithm(int i) {
        return i == 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x001b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean validIterations(org.xbill.DNS.dnssec.SRRset r6, org.xbill.DNS.dnssec.KeyCache r7) {
        /*
            r5 = this;
            org.xbill.DNS.Name r0 = r6.getSignerName()
            int r1 = r6.getDClass()
            org.xbill.DNS.dnssec.KeyEntry r7 = r7.find(r0, r1)
            r0 = 0
            if (r7 != 0) goto L10
            return r0
        L10:
            java.util.List r7 = r7.rrs(r0)     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.util.Iterator r7 = r7.iterator()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            r1 = 2147483647(0x7fffffff, float:NaN)
        L1b:
            boolean r2 = r7.hasNext()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            if (r2 == 0) goto L7f
            java.lang.Object r2 = r7.next()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            org.xbill.DNS.Record r2 = (org.xbill.DNS.Record) r2     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            org.xbill.DNS.DNSKEYRecord r2 = (org.xbill.DNS.DNSKEYRecord) r2     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            int r3 = r2.getFlags()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            r4 = 256(0x100, float:3.59E-43)
            r3 = r3 & r4
            if (r3 == r4) goto L33
            goto L1b
        L33:
            int r3 = r2.getAlgorithm()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            switch(r3) {
                case 3: goto L69;
                case 4: goto L3a;
                case 5: goto L5a;
                case 6: goto L69;
                case 7: goto L5a;
                case 8: goto L5a;
                case 9: goto L3a;
                case 10: goto L5a;
                case 11: goto L3a;
                case 12: goto L57;
                case 13: goto L3e;
                case 14: goto L3e;
                case 15: goto L7b;
                case 16: goto L3b;
                default: goto L3a;
            }     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
        L3a:
            return r0
        L3b:
            r4 = 456(0x1c8, float:6.39E-43)
            goto L7b
        L3e:
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.security.interfaces.ECPublicKey r2 = (java.security.interfaces.ECPublicKey) r2     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.security.spec.ECParameterSpec r2 = r2.getParams()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.security.spec.EllipticCurve r2 = r2.getCurve()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.security.spec.ECField r2 = r2.getField()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            int r4 = r2.getFieldSize()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            goto L7b
        L55:
            r6 = move-exception
            goto Laf
        L57:
            r4 = 512(0x200, float:7.17E-43)
            goto L7b
        L5a:
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.security.interfaces.RSAPublicKey r2 = (java.security.interfaces.RSAPublicKey) r2     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.math.BigInteger r2 = r2.getModulus()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            int r4 = r2.bitLength()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            goto L7b
        L69:
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.security.interfaces.DSAPublicKey r2 = (java.security.interfaces.DSAPublicKey) r2     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.security.interfaces.DSAParams r2 = r2.getParams()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.math.BigInteger r2 = r2.getP()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            int r4 = r2.bitLength()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
        L7b:
            if (r4 >= r1) goto L1b
            r1 = r4
            goto L1b
        L7f:
            java.util.TreeMap<java.lang.Integer, java.lang.Integer> r7 = r5.maxIterations     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.lang.Object r7 = r7.floorKey(r1)     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            if (r7 != 0) goto L95
            java.util.TreeMap<java.lang.Integer, java.lang.Integer> r7 = r5.maxIterations     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.lang.Object r7 = r7.firstKey()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
        L95:
            java.util.TreeMap<java.lang.Integer, java.lang.Integer> r1 = r5.maxIterations     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.lang.Object r7 = r1.get(r7)     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            org.xbill.DNS.Record r6 = r6.first()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            org.xbill.DNS.NSEC3Record r6 = (org.xbill.DNS.NSEC3Record) r6     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            int r6 = r6.getIterations()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            int r7 = r7.intValue()     // Catch: org.xbill.DNS.DNSSEC.DNSSECException -> L55
            if (r6 > r7) goto Lae
            r0 = 1
        Lae:
            return r0
        Laf:
            ir.nasim.OI3 r7 = org.xbill.DNS.dnssec.NSEC3ValUtils.log
            java.lang.String r1 = "Could not get public key from NSEC3 record"
            r7.a(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.dnssec.NSEC3ValUtils.validIterations(org.xbill.DNS.dnssec.SRRset, org.xbill.DNS.dnssec.KeyCache):boolean");
    }

    public boolean allNSEC3sIgnorable(List<SRRset> list, KeyCache keyCache) {
        HashMap map = new HashMap();
        Iterator<SRRset> it = list.iterator();
        while (it.hasNext()) {
            Iterator<Record> it2 = it.next().rrs().iterator();
            while (it2.hasNext()) {
                NSEC3Record nSEC3Record = (NSEC3Record) it2.next();
                Name name = new Name(nSEC3Record.getName(), 1);
                NSEC3Record nSEC3Record2 = (NSEC3Record) map.get(name);
                if (nSEC3Record2 == null) {
                    map.put(name, nSEC3Record);
                } else {
                    if (nSEC3Record.getHashAlgorithm() != nSEC3Record2.getHashAlgorithm() || nSEC3Record.getIterations() != nSEC3Record2.getIterations()) {
                        return true;
                    }
                    if ((nSEC3Record.getSalt() == null) ^ (nSEC3Record2.getSalt() == null)) {
                        return true;
                    }
                    if (nSEC3Record.getSalt() != null && ByteArrayComparator.compare(nSEC3Record.getSalt(), nSEC3Record2.getSalt()) != 0) {
                        return true;
                    }
                }
            }
        }
        Iterator<SRRset> it3 = list.iterator();
        while (it3.hasNext()) {
            if (validIterations(it3.next(), keyCache)) {
                return false;
            }
        }
        return true;
    }

    void init(Properties properties) throws NumberFormatException {
        boolean z = true;
        for (Map.Entry entry : properties.entrySet()) {
            String string = entry.getKey().toString();
            if (string.startsWith(NSEC3_MAX_ITERATIONS_PROPERTY_PREFIX)) {
                int i = Integer.parseInt(string.substring(string.lastIndexOf(Separators.DOT) + 1));
                int i2 = Integer.parseInt(entry.getValue().toString());
                if (i2 > MAX_ITERATION_COUNT) {
                    throw new IllegalArgumentException(i2 + " iterations is too high, maximum is " + MAX_ITERATION_COUNT);
                }
                if (z) {
                    this.maxIterations.clear();
                    z = false;
                }
                this.maxIterations.put(Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    public SecurityStatus proveNameError(List<SRRset> list, Name name, Name name2, Nsec3ValidationState nsec3ValidationState) {
        if (list == null || list.isEmpty()) {
            return SecurityStatus.BOGUS;
        }
        CEResponse cEResponseProveClosestEncloser = proveClosestEncloser(name, name2, list, nsec3ValidationState);
        SecurityStatus securityStatus = cEResponseProveClosestEncloser.status;
        SecurityStatus securityStatus2 = SecurityStatus.SECURE;
        if (securityStatus != securityStatus2) {
            log.b("Failed to prove a closest encloser");
            return cEResponseProveClosestEncloser.status;
        }
        Name nameCeWildcard = ceWildcard(cEResponseProveClosestEncloser.closestEncloser);
        if (nameCeWildcard == null) {
            return SecurityStatus.BOGUS;
        }
        if (findCoveringNSEC3(nameCeWildcard, name2, list, nsec3ValidationState) != null) {
            if ((cEResponseProveClosestEncloser.ncNsec3.getFlags() & 1) != 1) {
                return securityStatus2;
            }
            log.b("NSEC3 nameerror proof: nc has optout");
            return SecurityStatus.INSECURE;
        }
        OI3 oi3 = log;
        oi3.b("Could not prove that the applicable wildcard did not exist");
        int i = nsec3ValidationState.numCalc;
        if (i == -1) {
            oi3.b("NSEC3 reached max. hash calculation errors");
            return SecurityStatus.BOGUS;
        }
        if (i != 8) {
            return SecurityStatus.BOGUS;
        }
        oi3.b("NSEC3 reached max. hash calculations");
        return SecurityStatus.UNCHECKED;
    }

    public SecurityStatus proveNoDS(List<SRRset> list, Name name, Name name2, Nsec3ValidationState nsec3ValidationState) {
        if (list == null || list.isEmpty()) {
            return SecurityStatus.BOGUS;
        }
        NSEC3Record nSEC3RecordFindMatchingNSEC3 = findMatchingNSEC3(name, name2, list, nsec3ValidationState);
        if (nSEC3RecordFindMatchingNSEC3 != null) {
            return (nSEC3RecordFindMatchingNSEC3.hasType(6) || nSEC3RecordFindMatchingNSEC3.hasType(43)) ? SecurityStatus.BOGUS : !nSEC3RecordFindMatchingNSEC3.hasType(2) ? SecurityStatus.INDETERMINATE : SecurityStatus.SECURE;
        }
        CEResponse cEResponseProveClosestEncloser = proveClosestEncloser(name, name2, list, nsec3ValidationState);
        return cEResponseProveClosestEncloser.status != SecurityStatus.SECURE ? SecurityStatus.BOGUS : (cEResponseProveClosestEncloser.ncNsec3.getFlags() & 1) != 1 ? SecurityStatus.BOGUS : SecurityStatus.INSECURE;
    }

    public JustifiedSecStatus proveNodata(List<SRRset> list, Name name, int i, Name name2, Nsec3ValidationState nsec3ValidationState) {
        int i2;
        if (list == null || list.isEmpty()) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 12, R.get("failed.nsec3.none", new Object[0]));
        }
        NSEC3Record nSEC3RecordFindMatchingNSEC3 = findMatchingNSEC3(name, name2, list, nsec3ValidationState);
        if (nSEC3RecordFindMatchingNSEC3 != null) {
            if (nSEC3RecordFindMatchingNSEC3.hasType(i)) {
                log.b("Matching NSEC3 proved that type existed!");
                return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("failed.nsec3.type_exists", new Object[0]));
            }
            if (nSEC3RecordFindMatchingNSEC3.hasType(5)) {
                log.b("Matching NSEC3 proved that a CNAME existed!");
                return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("failed.nsec3.cname_exists", new Object[0]));
            }
            if (i == 43 && nSEC3RecordFindMatchingNSEC3.hasType(6) && !Name.root.equals(name)) {
                log.b("Apex NSEC3 abused for no DS proof, bogus");
                return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("failed.nsec3.apex_abuse", new Object[0]));
            }
            if (i == 43 || !nSEC3RecordFindMatchingNSEC3.hasType(2) || nSEC3RecordFindMatchingNSEC3.hasType(6)) {
                return new JustifiedSecStatus(SecurityStatus.SECURE, -1, null);
            }
            if (nSEC3RecordFindMatchingNSEC3.hasType(43)) {
                log.b("Matching NSEC3 is a delegation, bogus");
                return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("failed.nsec3.delegation", new Object[0]));
            }
            log.b("Matching NSEC3 is insecure delegation");
            return new JustifiedSecStatus(SecurityStatus.INSECURE, -1, null);
        }
        int i3 = nsec3ValidationState.numCalc;
        if (i3 == -1) {
            log.b("NSEC3 reached max. hash calculation errors");
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("failed.nsec3.hash_errors", new Object[0]));
        }
        if (i3 == 8) {
            log.b("NSEC3 reached max. hash calculations");
            return new JustifiedSecStatus(SecurityStatus.UNCHECKED, -1, null);
        }
        CEResponse cEResponseProveClosestEncloser = proveClosestEncloser(name, name2, list, nsec3ValidationState);
        SecurityStatus securityStatus = cEResponseProveClosestEncloser.status;
        SecurityStatus securityStatus2 = SecurityStatus.BOGUS;
        if (securityStatus == securityStatus2) {
            log.b("Did not match qname, nor found a proven closest encloser");
            return new JustifiedSecStatus(securityStatus2, 6, R.get("failed.nsec3.qname_ce", new Object[0]));
        }
        SecurityStatus securityStatus3 = cEResponseProveClosestEncloser.status;
        SecurityStatus securityStatus4 = SecurityStatus.INSECURE;
        if (securityStatus3 == securityStatus4 && i != 43) {
            log.b("Closest NSEC3 is insecure delegation");
            return new JustifiedSecStatus(securityStatus4, -1, null);
        }
        SecurityStatus securityStatus5 = cEResponseProveClosestEncloser.status;
        SecurityStatus securityStatus6 = SecurityStatus.UNCHECKED;
        if (securityStatus5 == securityStatus6) {
            return new JustifiedSecStatus(securityStatus6, -1, null);
        }
        NSEC3Record nSEC3RecordFindMatchingNSEC32 = findMatchingNSEC3(ceWildcard(cEResponseProveClosestEncloser.closestEncloser), name2, list, nsec3ValidationState);
        if (nSEC3RecordFindMatchingNSEC32 == null) {
            int i4 = nsec3ValidationState.numCalc;
            if (i4 == -1) {
                log.b("NSEC3 reached max. hash calculation errors");
                return new JustifiedSecStatus(securityStatus2, 6, R.get("failed.nsec3.wc.hash_errors", new Object[0]));
            }
            if (i4 == 8) {
                log.b("NSEC3 reached max. hash calculations");
                return new JustifiedSecStatus(securityStatus6, -1, null);
            }
            if (cEResponseProveClosestEncloser.ncNsec3 == null) {
                log.b("No next closer NSEC3");
                return new JustifiedSecStatus(securityStatus2, 12, R.get("failed.nsec3.no_next", new Object[0]));
            }
            if ((cEResponseProveClosestEncloser.ncNsec3.getFlags() & 1) != 0) {
                return new JustifiedSecStatus(securityStatus4, -1, null);
            }
            if (i != 43) {
                log.b("Covering NSEC3 was not opt-out in an opt-out DS NOERROR/NODATA case");
                return new JustifiedSecStatus(securityStatus2, 6, R.get("failed.nsec3.not_optout", new Object[0]));
            }
            log.b("Could not find matching NSEC3, nor matching wildcard, and qtype is not DS -- no more options");
            return new JustifiedSecStatus(securityStatus2, 12, R.get("failed.nsec3.not_found", new Object[0]));
        }
        if (nSEC3RecordFindMatchingNSEC32.hasType(i)) {
            log.s("Matching wildcard has qtype {}", Type.string(i));
            return new JustifiedSecStatus(securityStatus2, 6, R.get("failed.nsec3.type_exists_wc", new Object[0]));
        }
        if (nSEC3RecordFindMatchingNSEC32.hasType(5)) {
            log.b("Matching wildcard has a CNAME, bogus");
            return new JustifiedSecStatus(securityStatus2, 6, R.get("failed.nsec3.cname_exists_wc", new Object[0]));
        }
        if (i != 43) {
            i2 = 43;
        } else {
            if (name.labels() != 1 && nSEC3RecordFindMatchingNSEC32.hasType(6)) {
                log.b("Matching wildcard for no DS proof has a SOA, bogus");
                return new JustifiedSecStatus(securityStatus2, 6, R.get("failed.nsec3.wc_soa", new Object[0]));
            }
            i2 = 43;
        }
        if (i != i2 && nSEC3RecordFindMatchingNSEC32.hasType(2) && !nSEC3RecordFindMatchingNSEC32.hasType(6)) {
            log.b("Matching wildcard is a delegation, bogus");
            return new JustifiedSecStatus(securityStatus2, 6, R.get("failed.nsec3.delegation_wc", new Object[0]));
        }
        if (cEResponseProveClosestEncloser.ncNsec3 == null || (cEResponseProveClosestEncloser.ncNsec3.getFlags() & 1) != 1) {
            return new JustifiedSecStatus(SecurityStatus.SECURE, -1, null);
        }
        log.b("Matching wildcard is in opt-out range, insecure");
        return new JustifiedSecStatus(securityStatus4, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SecurityStatus proveWildcard(List<SRRset> list, Name name, Name name2, Name name3, Nsec3ValidationState nsec3ValidationState) {
        if (list == null || list.isEmpty() || name == null || name3 == null) {
            return SecurityStatus.BOGUS;
        }
        CEResponse cEResponse = new CEResponse(new Name(name3, 1), null);
        cEResponse.ncNsec3 = findCoveringNSEC3(nextClosest(name, cEResponse.closestEncloser), name2, list, nsec3ValidationState);
        if (cEResponse.ncNsec3 != null) {
            return (cEResponse.ncNsec3.getFlags() & 1) == 1 ? SecurityStatus.INSECURE : SecurityStatus.SECURE;
        }
        log.l("did not find a covering NSEC3 that covered the next closer name to {} from {} (derived from wildcard {})", name, cEResponse.closestEncloser, name3);
        return SecurityStatus.BOGUS;
    }

    public void stripUnknownAlgNSEC3s(List<SRRset> list) {
        ListIterator<SRRset> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (!supportsHashAlgorithm(((NSEC3Record) listIterator.next().first()).getHashAlgorithm())) {
                listIterator.remove();
            }
        }
    }
}
