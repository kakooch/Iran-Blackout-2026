package com.neovisionaries.ws.client;

import java.util.Map;

/* loaded from: classes3.dex */
class PerMessageDeflateExtension extends PerMessageCompressionExtension {
    private static final byte[] COMPRESSION_TERMINATOR = {0, 0, -1, -1};
    private int mClientWindowSize;
    private ByteArray mIncomingSlidingWindow;
    private int mIncomingSlidingWindowBufferSize;
    private boolean mServerNoContextTakeover;
    private int mServerWindowSize;

    public PerMessageDeflateExtension() {
        super("permessage-deflate");
        this.mServerWindowSize = 32768;
        this.mClientWindowSize = 32768;
    }

    public PerMessageDeflateExtension(String str) {
        super(str);
        this.mServerWindowSize = 32768;
        this.mClientWindowSize = 32768;
    }

    @Override // com.neovisionaries.ws.client.WebSocketExtension
    void validate() throws WebSocketException {
        for (Map.Entry<String, String> entry : getParameters().entrySet()) {
            validateParameter(entry.getKey(), entry.getValue());
        }
        this.mIncomingSlidingWindowBufferSize = this.mServerWindowSize + 1024;
    }

    private void validateParameter(String str, String str2) throws WebSocketException {
        if ("server_no_context_takeover".equals(str)) {
            this.mServerNoContextTakeover = true;
            return;
        }
        if ("client_no_context_takeover".equals(str)) {
            return;
        }
        if ("server_max_window_bits".equals(str)) {
            this.mServerWindowSize = computeWindowSize(str, str2);
            return;
        }
        if ("client_max_window_bits".equals(str)) {
            this.mClientWindowSize = computeWindowSize(str, str2);
            return;
        }
        throw new WebSocketException(WebSocketError.PERMESSAGE_DEFLATE_UNSUPPORTED_PARAMETER, "permessage-deflate extension contains an unsupported parameter: " + str);
    }

    private int computeWindowSize(String str, String str2) throws WebSocketException, NumberFormatException {
        int iExtractMaxWindowBits = extractMaxWindowBits(str, str2);
        int i = 256;
        for (int i2 = 8; i2 < iExtractMaxWindowBits; i2++) {
            i *= 2;
        }
        return i;
    }

    private int extractMaxWindowBits(String str, String str2) throws WebSocketException, NumberFormatException {
        int maxWindowBits = parseMaxWindowBits(str2);
        if (maxWindowBits >= 0) {
            return maxWindowBits;
        }
        throw new WebSocketException(WebSocketError.PERMESSAGE_DEFLATE_INVALID_MAX_WINDOW_BITS, String.format("The value of %s parameter of permessage-deflate extension is invalid: %s", str, str2));
    }

    private int parseMaxWindowBits(String str) throws NumberFormatException {
        int i;
        if (str == null) {
            return -1;
        }
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        if (i < 8 || 15 < i) {
            return -1;
        }
        return i;
    }

    @Override // com.neovisionaries.ws.client.PerMessageCompressionExtension
    protected byte[] decompress(byte[] bArr) throws WebSocketException {
        int length = bArr.length;
        byte[] bArr2 = COMPRESSION_TERMINATOR;
        ByteArray byteArray = new ByteArray(length + bArr2.length);
        byteArray.put(bArr);
        byteArray.put(bArr2);
        if (this.mIncomingSlidingWindow == null) {
            this.mIncomingSlidingWindow = new ByteArray(this.mIncomingSlidingWindowBufferSize);
        }
        int length2 = this.mIncomingSlidingWindow.length();
        try {
            DeflateDecompressor.decompress(byteArray, this.mIncomingSlidingWindow);
            byte[] bytes = this.mIncomingSlidingWindow.toBytes(length2);
            this.mIncomingSlidingWindow.shrink(this.mIncomingSlidingWindowBufferSize);
            if (this.mServerNoContextTakeover) {
                this.mIncomingSlidingWindow.clear();
            }
            return bytes;
        } catch (Exception e) {
            throw new WebSocketException(WebSocketError.DECOMPRESSION_ERROR, String.format("Failed to decompress the message: %s", e.getMessage()), e);
        }
    }

    @Override // com.neovisionaries.ws.client.PerMessageCompressionExtension
    protected byte[] compress(byte[] bArr) throws WebSocketException {
        if (!canCompress(bArr)) {
            return bArr;
        }
        try {
            return adjustCompressedData(DeflateCompressor.compress(bArr));
        } catch (Exception e) {
            throw new WebSocketException(WebSocketError.COMPRESSION_ERROR, String.format("Failed to compress the message: %s", e.getMessage()), e);
        }
    }

    private boolean canCompress(byte[] bArr) {
        int i = this.mClientWindowSize;
        return i == 32768 || bArr.length < i;
    }

    private static byte[] adjustCompressedData(byte[] bArr) throws FormatException {
        ByteArray byteArray = new ByteArray(bArr.length + 1);
        byteArray.put(bArr);
        int[] iArr = new int[1];
        boolean[] zArr = new boolean[1];
        while (skipBlock(byteArray, iArr, zArr)) {
        }
        if (zArr[0]) {
            return byteArray.toBytes(0, (((iArr[0] - 1) / 8) + 1) - 4);
        }
        appendEmptyBlock(byteArray, iArr);
        return byteArray.toBytes(0, ((iArr[0] - 1) / 8) + 1);
    }

    private static void appendEmptyBlock(ByteArray byteArray, int[] iArr) {
        int i = iArr[0] % 8;
        if (i == 0 || i == 6 || i == 7) {
            byteArray.put(0);
        }
        iArr[0] = iArr[0] + 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean skipBlock(com.neovisionaries.ws.client.ByteArray r5, int[] r6, boolean[] r7) throws java.lang.IndexOutOfBoundsException, com.neovisionaries.ws.client.FormatException {
        /*
            boolean r0 = r5.readBit(r6)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Le
            r3 = r6[r2]
            int r3 = r3 - r1
            r5.clearBit(r3)
        Le:
            r3 = 2
            int r4 = r5.readBits(r6, r3)
            if (r4 == 0) goto L40
            if (r4 == r1) goto L3b
            if (r4 != r3) goto L1d
            skipDynamicBlock(r5, r6)
            goto L3e
        L1d:
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.Class<com.neovisionaries.ws.client.PerMessageDeflateExtension> r7 = com.neovisionaries.ws.client.PerMessageDeflateExtension.class
            java.lang.String r7 = r7.getSimpleName()
            r5[r2] = r7
            r6 = r6[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r1] = r6
            java.lang.String r6 = "[%s] Bad compression type '11' at the bit index '%d'."
            java.lang.String r5 = java.lang.String.format(r6, r5)
            com.neovisionaries.ws.client.FormatException r6 = new com.neovisionaries.ws.client.FormatException
            r6.<init>(r5)
            throw r6
        L3b:
            skipFixedBlock(r5, r6)
        L3e:
            r3 = 0
            goto L47
        L40:
            int r3 = skipPlainBlock(r5, r6)
            if (r3 != 0) goto L3e
            r3 = 1
        L47:
            int r5 = r5.length()
            r6 = r6[r2]
            int r6 = r6 / 8
            if (r5 > r6) goto L52
            r0 = 1
        L52:
            if (r0 == 0) goto L58
            if (r3 == 0) goto L58
            r7[r2] = r1
        L58:
            r5 = r0 ^ 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.PerMessageDeflateExtension.skipBlock(com.neovisionaries.ws.client.ByteArray, int[], boolean[]):boolean");
    }

    private static int skipPlainBlock(ByteArray byteArray, int[] iArr) {
        int i = ((iArr[0] + 7) & (-8)) / 8;
        int i2 = (byteArray.get(i) & 255) + ((byteArray.get(i + 1) & 255) * 256);
        iArr[0] = (i + 4 + i2) * 8;
        return i2;
    }

    private static void skipFixedBlock(ByteArray byteArray, int[] iArr) throws FormatException {
        skipData(byteArray, iArr, FixedLiteralLengthHuffman.getInstance(), FixedDistanceHuffman.getInstance());
    }

    private static void skipDynamicBlock(ByteArray byteArray, int[] iArr) throws FormatException {
        Huffman[] huffmanArr = new Huffman[2];
        DeflateUtil.readDynamicTables(byteArray, iArr, huffmanArr);
        skipData(byteArray, iArr, huffmanArr[0], huffmanArr[1]);
    }

    private static void skipData(ByteArray byteArray, int[] iArr, Huffman huffman, Huffman huffman2) throws FormatException {
        while (true) {
            int sym = huffman.readSym(byteArray, iArr);
            if (sym == 256) {
                return;
            }
            if (sym < 0 || sym > 255) {
                DeflateUtil.readLength(byteArray, iArr, sym);
                DeflateUtil.readDistance(byteArray, iArr, huffman2);
            }
        }
    }
}
