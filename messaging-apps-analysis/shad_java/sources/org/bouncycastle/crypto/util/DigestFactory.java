package org.bouncycastle.crypto.util;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;

/* loaded from: classes4.dex */
public final class DigestFactory {
    public static Digest createSHA1() {
        return new SHA1Digest();
    }

    public static Digest createSHA224() {
        return new SHA224Digest();
    }

    public static Digest createSHA256() {
        return new SHA256Digest();
    }

    public static Digest createSHA384() {
        return new SHA384Digest();
    }

    public static Digest createSHA512() {
        return new SHA512Digest();
    }
}
