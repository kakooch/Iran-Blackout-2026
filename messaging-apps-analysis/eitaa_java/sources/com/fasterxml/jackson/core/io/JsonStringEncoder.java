package com.fasterxml.jackson.core.io;

/* loaded from: classes.dex */
public final class JsonStringEncoder {
    private static final char[] HC = CharTypes.copyHexChars();
    private static final byte[] HB = CharTypes.copyHexBytes();
    private static final JsonStringEncoder instance = new JsonStringEncoder();

    private char[] _qbuf() {
        return new char[]{'\\', 0, '0', '0', 0, 0};
    }

    public static JsonStringEncoder getInstance() {
        return instance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        r9 = r7 + 1;
        r7 = r13.charAt(r7);
        r10 = r1[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (r10 >= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        r7 = _appendNumeric(r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        r7 = _appendNamed(r10, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        r10 = r8 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r10 <= r0.length) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        r10 = r0.length - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        if (r10 <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r4 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        r4 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        r0 = r4.finishCurrentSegment();
        r7 = r7 - r10;
        java.lang.System.arraycopy(r6, r10, r0, 0, r7);
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r7);
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r6 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        r6 = _qbuf();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public char[] quoteAsString(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 120(0x78, float:1.68E-43)
            char[] r0 = new char[r0]
            int[] r1 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes()
            int r2 = r1.length
            int r3 = r13.length()
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = 0
            r8 = 0
        L12:
            if (r7 >= r3) goto L73
        L14:
            char r9 = r13.charAt(r7)
            if (r9 >= r2) goto L59
            r10 = r1[r9]
            if (r10 == 0) goto L59
            if (r6 != 0) goto L24
            char[] r6 = r12._qbuf()
        L24:
            int r9 = r7 + 1
            char r7 = r13.charAt(r7)
            r10 = r1[r7]
            if (r10 >= 0) goto L33
            int r7 = r12._appendNumeric(r7, r6)
            goto L37
        L33:
            int r7 = r12._appendNamed(r10, r6)
        L37:
            int r10 = r8 + r7
            int r11 = r0.length
            if (r10 <= r11) goto L53
            int r10 = r0.length
            int r10 = r10 - r8
            if (r10 <= 0) goto L43
            java.lang.System.arraycopy(r6, r5, r0, r8, r10)
        L43:
            if (r4 != 0) goto L49
            com.fasterxml.jackson.core.util.TextBuffer r4 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r0)
        L49:
            char[] r0 = r4.finishCurrentSegment()
            int r7 = r7 - r10
            java.lang.System.arraycopy(r6, r10, r0, r5, r7)
            r8 = r7
            goto L57
        L53:
            java.lang.System.arraycopy(r6, r5, r0, r8, r7)
            r8 = r10
        L57:
            r7 = r9
            goto L12
        L59:
            int r10 = r0.length
            if (r8 < r10) goto L67
            if (r4 != 0) goto L62
            com.fasterxml.jackson.core.util.TextBuffer r4 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r0)
        L62:
            char[] r0 = r4.finishCurrentSegment()
            r8 = 0
        L67:
            int r10 = r8 + 1
            r0[r8] = r9
            int r7 = r7 + 1
            if (r7 < r3) goto L71
            r8 = r10
            goto L73
        L71:
            r8 = r10
            goto L14
        L73:
            if (r4 != 0) goto L7a
            char[] r13 = java.util.Arrays.copyOfRange(r0, r5, r8)
            return r13
        L7a:
            r4.setCurrentLength(r8)
            char[] r13 = r4.contentsAsArray()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    private int _appendNumeric(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = HC;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private int _appendNamed(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }
}
