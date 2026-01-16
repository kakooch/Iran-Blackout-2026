package com.google.android.exoplayer2t.text.webvtt;

import com.google.android.exoplayer2t.text.Cue;
import com.google.android.exoplayer2t.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2t.text.Subtitle;
import com.google.android.exoplayer2t.text.SubtitleDecoderException;
import com.google.android.exoplayer2t.text.webvtt.WebvttCue;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import com.google.android.exoplayer2t.util.Util;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    private final WebvttCue.Builder builder;
    private final ParsableByteArray sampleData;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.sampleData = new ParsableByteArray();
        this.builder = new WebvttCue.Builder();
    }

    @Override // com.google.android.exoplayer2t.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.sampleData.reset(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.sampleData.bytesLeft() > 0) {
            if (this.sampleData.bytesLeft() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int i2 = this.sampleData.readInt();
            if (this.sampleData.readInt() == 1987343459) {
                arrayList.add(parseVttCueBox(this.sampleData, this.builder, i2 - 8));
            } else {
                this.sampleData.skipBytes(i2 - 8);
            }
        }
        return new Mp4WebvttSubtitle(arrayList);
    }

    private static Cue parseVttCueBox(ParsableByteArray parsableByteArray, WebvttCue.Builder builder, int i) throws SubtitleDecoderException {
        builder.reset();
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int i2 = parsableByteArray.readInt();
            int i3 = parsableByteArray.readInt();
            int i4 = i2 - 8;
            String strFromUtf8Bytes = Util.fromUtf8Bytes(parsableByteArray.data, parsableByteArray.getPosition(), i4);
            parsableByteArray.skipBytes(i4);
            i = (i - 8) - i4;
            if (i3 == 1937011815) {
                WebvttCueParser.parseCueSettingsList(strFromUtf8Bytes, builder);
            } else if (i3 == 1885436268) {
                WebvttCueParser.parseCueText(null, strFromUtf8Bytes.trim(), builder, Collections.emptyList());
            }
        }
        return builder.build();
    }
}
