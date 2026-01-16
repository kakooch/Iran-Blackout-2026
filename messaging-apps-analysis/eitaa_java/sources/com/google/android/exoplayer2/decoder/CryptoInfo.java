package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final PatternHolderV24 patternHolder;

    /* JADX WARN: Multi-variable type inference failed */
    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.frameworkCryptoInfo = cryptoInfo;
        this.patternHolder = Util.SDK_INT >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public void set(int numSubSamples, int[] numBytesOfClearData, int[] numBytesOfEncryptedData, byte[] key, byte[] iv, int mode, int encryptedBlocks, int clearBlocks) {
        this.numSubSamples = numSubSamples;
        this.numBytesOfClearData = numBytesOfClearData;
        this.numBytesOfEncryptedData = numBytesOfEncryptedData;
        this.key = key;
        this.iv = iv;
        this.mode = mode;
        this.encryptedBlocks = encryptedBlocks;
        this.clearBlocks = clearBlocks;
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = numSubSamples;
        cryptoInfo.numBytesOfClearData = numBytesOfClearData;
        cryptoInfo.numBytesOfEncryptedData = numBytesOfEncryptedData;
        cryptoInfo.key = key;
        cryptoInfo.iv = iv;
        cryptoInfo.mode = mode;
        if (Util.SDK_INT >= 24) {
            this.patternHolder.set(encryptedBlocks, clearBlocks);
        }
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.frameworkCryptoInfo;
    }

    @TargetApi(24)
    private static final class PatternHolderV24 {
        private final MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final MediaCodec.CryptoInfo.Pattern pattern;

        private PatternHolderV24(MediaCodec.CryptoInfo frameworkCryptoInfo) {
            this.frameworkCryptoInfo = frameworkCryptoInfo;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int encryptedBlocks, int clearBlocks) {
            this.pattern.set(encryptedBlocks, clearBlocks);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }
    }
}
