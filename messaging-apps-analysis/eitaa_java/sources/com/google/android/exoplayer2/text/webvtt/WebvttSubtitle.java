package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List<WebvttCue> cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCue> cues) {
        this.cues = cues;
        int size = cues.size();
        this.numCues = size;
        this.cueTimesUs = new long[size * 2];
        for (int i = 0; i < this.numCues; i++) {
            WebvttCue webvttCue = cues.get(i);
            int i2 = i * 2;
            long[] jArr = this.cueTimesUs;
            jArr[i2] = webvttCue.startTime;
            jArr[i2 + 1] = webvttCue.endTime;
        }
        long[] jArr2 = this.cueTimesUs;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.sortedCueTimesUs = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long timeUs) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, timeUs, false, false);
        if (iBinarySearchCeil < this.sortedCueTimesUs.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int index) {
        Assertions.checkArgument(index >= 0);
        Assertions.checkArgument(index < this.sortedCueTimesUs.length);
        return this.sortedCueTimesUs[index];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long timeUs) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = null;
        WebvttCue webvttCue = null;
        for (int i = 0; i < this.numCues; i++) {
            long[] jArr = this.cueTimesUs;
            int i2 = i * 2;
            if (jArr[i2] <= timeUs && timeUs < jArr[i2 + 1]) {
                WebvttCue webvttCue2 = this.cues.get(i);
                if (!webvttCue2.isNormalCue()) {
                    arrayList.add(webvttCue2);
                } else if (webvttCue == null) {
                    webvttCue = webvttCue2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) Assertions.checkNotNull(webvttCue.text)).append((CharSequence) "\n").append((CharSequence) Assertions.checkNotNull(webvttCue2.text));
                } else {
                    spannableStringBuilder.append((CharSequence) "\n").append((CharSequence) Assertions.checkNotNull(webvttCue2.text));
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new WebvttCue.Builder().setText(spannableStringBuilder).build());
        } else if (webvttCue != null) {
            arrayList.add(webvttCue);
        }
        return arrayList;
    }
}
