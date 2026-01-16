package com.google.android.exoplayer2t.source;

import com.google.android.exoplayer2t.Timeline;
import com.google.android.exoplayer2t.util.Assertions;

/* loaded from: classes.dex */
public final class SinglePeriodTimeline extends Timeline {
    private static final Object UID = new Object();
    private final boolean isDynamic;
    private final boolean isLive;
    private final boolean isSeekable;
    private final Object manifest;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final Object tag;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    @Override // com.google.android.exoplayer2t.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2t.Timeline
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3, Object obj, Object obj2) {
        this(j, j, 0L, 0L, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, Object obj2) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2, boolean z3, Object obj, Object obj2) {
        this.presentationStartTimeMs = j;
        this.windowStartTimeMs = j2;
        this.periodDurationUs = j3;
        this.windowDurationUs = j4;
        this.windowPositionInPeriodUs = j5;
        this.windowDefaultStartPositionUs = j6;
        this.isSeekable = z;
        this.isDynamic = z2;
        this.isLive = z3;
        this.manifest = obj;
        this.tag = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[PHI: r1
      0x0029: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x0012, B:5:0x0018, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2t.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2t.Timeline.Window getWindow(int r23, com.google.android.exoplayer2t.Timeline.Window r24, long r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = 0
            r2 = 1
            r3 = r23
            com.google.android.exoplayer2t.util.Assertions.checkIndex(r3, r1, r2)
            long r1 = r0.windowDefaultStartPositionUs
            boolean r12 = r0.isDynamic
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r12 == 0) goto L29
            r5 = 0
            int r7 = (r25 > r5 ? 1 : (r25 == r5 ? 0 : -1))
            if (r7 == 0) goto L29
            long r5 = r0.windowDurationUs
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L22
        L20:
            r14 = r3
            goto L2a
        L22:
            long r1 = r1 + r25
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L29
            goto L20
        L29:
            r14 = r1
        L2a:
            java.lang.Object r4 = com.google.android.exoplayer2t.Timeline.Window.SINGLE_WINDOW_UID
            java.lang.Object r5 = r0.tag
            java.lang.Object r6 = r0.manifest
            long r7 = r0.presentationStartTimeMs
            long r9 = r0.windowStartTimeMs
            boolean r11 = r0.isSeekable
            boolean r13 = r0.isLive
            long r1 = r0.windowDurationUs
            r16 = r1
            r18 = 0
            r19 = 0
            long r1 = r0.windowPositionInPeriodUs
            r20 = r1
            r3 = r24
            com.google.android.exoplayer2t.Timeline$Window r1 = r3.set(r4, r5, r6, r7, r9, r11, r12, r13, r14, r16, r18, r19, r20)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2t.source.SinglePeriodTimeline.getWindow(int, com.google.android.exoplayer2t.Timeline$Window, long):com.google.android.exoplayer2t.Timeline$Window");
    }

    @Override // com.google.android.exoplayer2t.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        Assertions.checkIndex(i, 0, 1);
        return period.set(null, z ? UID : null, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2t.Timeline
    public int getIndexOfPeriod(Object obj) {
        return UID.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2t.Timeline
    public Object getUidOfPeriod(int i) {
        Assertions.checkIndex(i, 0, 1);
        return UID;
    }
}
