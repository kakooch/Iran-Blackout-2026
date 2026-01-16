package org.bouncycastle.asn1;

/* loaded from: classes4.dex */
class BERFactory {
    static final BERSequence EMPTY_SEQUENCE = new BERSequence();

    static {
        new BERSet();
    }

    static BERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() < 1 ? EMPTY_SEQUENCE : new BERSequence(aSN1EncodableVector);
    }
}
