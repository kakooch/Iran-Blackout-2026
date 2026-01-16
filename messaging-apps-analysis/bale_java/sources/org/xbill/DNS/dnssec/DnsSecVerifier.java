package org.xbill.DNS.dnssec;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import lombok.Generated;
import org.xbill.DNS.DClass;
import org.xbill.DNS.DNSKEYRecord;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

/* loaded from: classes8.dex */
final class DnsSecVerifier {
    public static final String MAX_VALIDATE_RRSIGS_PROPERTY = "dnsjava.dnssec.max_validate_rrsigs";

    @Generated
    private static final OI3 log = RI3.i(DnsSecVerifier.class);
    private int maxValidateRRsigs;
    private final ValUtils valUtils;

    public DnsSecVerifier(ValUtils valUtils) {
        this.valUtils = valUtils;
    }

    private List<DNSKEYRecord> findKey(RRset rRset, RRSIGRecord rRSIGRecord) {
        if (!rRSIGRecord.getSigner().equals(rRset.getName())) {
            log.e("Could not find appropriate key because incorrect keyset was supplied. Wanted: {}, got: {}", rRSIGRecord.getSigner(), rRset.getName());
            return Collections.emptyList();
        }
        int footprint = rRSIGRecord.getFootprint();
        int algorithm = rRSIGRecord.getAlgorithm();
        ArrayList arrayList = new ArrayList(rRset.size());
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            DNSKEYRecord dNSKEYRecord = (DNSKEYRecord) it.next();
            if (dNSKEYRecord.getAlgorithm() == algorithm && dNSKEYRecord.getFootprint() == footprint) {
                arrayList.add(dNSKEYRecord);
            }
        }
        return arrayList;
    }

    private JustifiedSecStatus verifySignature(SRRset sRRset, RRSIGRecord rRSIGRecord, KeyEntry keyEntry, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (!sRRset.getName().subdomain(rRSIGRecord.getSigner())) {
            log.c("Signer name {} is off-tree for {}", rRSIGRecord.getSigner(), sRRset.getName());
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.key_offtree", rRSIGRecord.getSigner(), sRRset.getName()));
        }
        Iterator<DNSKEYRecord> it = findKey(keyEntry, rRSIGRecord).iterator();
        if (!it.hasNext()) {
            log.r("Could not find appropriate key for {}", rRSIGRecord);
            return new JustifiedSecStatus(SecurityStatus.UNCHECKED, 9, R.get("dnskey.no_key", rRSIGRecord.getSigner()));
        }
        try {
            DNSSEC.verify(sRRset, rRSIGRecord, it.next(), instant);
            ValUtils.setCanonicalNsecOwner(sRRset, rRSIGRecord);
            return new JustifiedSecStatus(SecurityStatus.SECURE, -1, null);
        } catch (DNSSEC.InvalidDnskeyException e) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, e.getEdeCode(), R.get("dnskey.invalid", new Object[0]));
        } catch (DNSSEC.KeyMismatchException unused) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.no_match", new Object[0]));
        } catch (DNSSEC.SignatureExpiredException unused2) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 7, R.get("dnskey.expired", new Object[0]));
        } catch (DNSSEC.SignatureNotYetValidException unused3) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 8, R.get("dnskey.not_yet_valid", new Object[0]));
        } catch (DNSSEC.DNSSECException e2) {
            log.k("Failed to validate RRset <{}/{}/{}>", sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()), e2);
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.invalid", new Object[0]));
        }
    }

    public void init(Properties properties) {
        this.maxValidateRRsigs = Integer.parseInt(properties.getProperty(MAX_VALIDATE_RRSIGS_PROPERTY, "8"));
    }

    public JustifiedSecStatus verify(SRRset sRRset, KeyEntry keyEntry, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        AlgorithmRequirements algorithmRequirements;
        List<RRSIGRecord> listSigs = sRRset.sigs();
        if (listSigs.isEmpty()) {
            log.C("RRset <{}/{}/{}> failed to verify due to a lack of signatures", sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()));
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 10, R.get("validate.bogus.missingsig_named", sRRset.getName(), Type.string(sRRset.getType())));
        }
        JustifiedSecStatus justifiedSecStatus = null;
        if (keyEntry.getAlgo() != null) {
            algorithmRequirements = new AlgorithmRequirements(this.valUtils);
            algorithmRequirements.initList(keyEntry.getAlgo());
            if (algorithmRequirements.getNum() == 0) {
                log.s("{} has no known algorithms", sRRset.getName());
                return new JustifiedSecStatus(SecurityStatus.INSECURE, 1, R.get("validate.insecure.noalg", sRRset.getName()));
            }
        } else {
            algorithmRequirements = null;
        }
        int i = 0;
        for (RRSIGRecord rRSIGRecord : listSigs) {
            JustifiedSecStatus justifiedSecStatusVerifySignature = verifySignature(sRRset, rRSIGRecord, keyEntry, instant);
            SecurityStatus securityStatus = justifiedSecStatusVerifySignature.status;
            if (securityStatus == SecurityStatus.SECURE) {
                if (algorithmRequirements == null || algorithmRequirements.setSecure(rRSIGRecord.getAlgorithm())) {
                    return justifiedSecStatusVerifySignature;
                }
            } else if (algorithmRequirements != null && securityStatus == SecurityStatus.BOGUS) {
                algorithmRequirements.setBogus(rRSIGRecord.getAlgorithm());
            }
            i++;
            if (i > this.maxValidateRRsigs) {
                log.f("RRset <{}/{}/{}> failed to verify: too many signatures", sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()));
                return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("validate.bogus.rrsigtoomany", sRRset.getName(), Type.string(sRRset.getType())));
            }
            justifiedSecStatus = justifiedSecStatusVerifySignature;
        }
        log.f("RRset <{}/{}/{}> failed to verify: all signatures are BOGUS", sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()));
        return justifiedSecStatus;
    }

    public JustifiedSecStatus verify(RRset rRset, DNSKEYRecord dNSKEYRecord, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        String str;
        List<RRSIGRecord> listSigs = rRset.sigs();
        if (listSigs.isEmpty()) {
            log.f("RRset <{}/{}/{}> failed to verify due to lack of signatures", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()));
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 10, R.get("validate.bogus.missingsig_named", rRset.getName(), Type.string(rRset.getType())));
        }
        Iterator<RRSIGRecord> it = listSigs.iterator();
        int i = 0;
        DNSSEC.DNSSECException e = null;
        while (true) {
            int i2 = 6;
            if (it.hasNext()) {
                RRSIGRecord next = it.next();
                if (next.getFootprint() == dNSKEYRecord.getFootprint()) {
                    i++;
                    try {
                        DNSSEC.verify(rRset, next, dNSKEYRecord, instant);
                        return new JustifiedSecStatus(SecurityStatus.SECURE, -1, null);
                    } catch (DNSSEC.DNSSECException e2) {
                        e = e2;
                        OI3 oi3 = log;
                        oi3.f("Failed to validate RRset <{}/{}/{}> with signature {}", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()), Integer.valueOf(next.getFootprint()), e);
                        if (i > this.maxValidateRRsigs) {
                            oi3.f("RRset <{}/{}/{}> failed to verify: too many signatures", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()));
                            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("validate.bogus.rrsigtoomany", rRset.getName(), Type.string(rRset.getType())));
                        }
                    }
                }
            } else {
                log.f("RRset <{}/{}/{}> failed to verify: all signatures were BOGUS", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()));
                if (i == 0) {
                    i2 = 9;
                    str = "dnskey.no_ds_match";
                } else if (e instanceof DNSSEC.SignatureExpiredException) {
                    i2 = 7;
                    str = "dnskey.expired";
                } else if (e instanceof DNSSEC.SignatureNotYetValidException) {
                    i2 = 8;
                    str = "dnskey.not_yet_valid";
                } else {
                    str = "dnskey.invalid";
                }
                return new JustifiedSecStatus(SecurityStatus.BOGUS, i2, R.get(str, new Object[0]));
            }
        }
    }
}
