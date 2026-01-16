package com.google.android.exoplayer2t.extractor.mp3;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.ParserException;
import com.google.android.exoplayer2t.extractor.Extractor;
import com.google.android.exoplayer2t.extractor.ExtractorInput;
import com.google.android.exoplayer2t.extractor.ExtractorOutput;
import com.google.android.exoplayer2t.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2t.extractor.Id3Peeker;
import com.google.android.exoplayer2t.extractor.MpegAudioHeader;
import com.google.android.exoplayer2t.extractor.PositionHolder;
import com.google.android.exoplayer2t.extractor.TrackOutput;
import com.google.android.exoplayer2t.extractor.mp3.Seeker;
import com.google.android.exoplayer2t.metadata.Metadata;
import com.google.android.exoplayer2t.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2t.metadata.id3.MlltFrame;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes.dex */
public final class Mp3Extractor implements Extractor {
    private static final Id3Decoder.FramePredicate REQUIRED_ID3_FRAME_PREDICATE = new Id3Decoder.FramePredicate() { // from class: com.google.android.exoplayer2t.extractor.mp3.Mp3Extractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2t.metadata.id3.Id3Decoder.FramePredicate
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return Mp3Extractor.lambda$static$1(i, i2, i3, i4, i5);
        }
    };
    private long basisTimeUs;
    private boolean disableSeeking;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private Metadata metadata;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private Seeker seeker;
    private final MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;

    private static boolean headersMatch(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$1(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void release() {
    }

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int i) {
        this(i, -9223372036854775807L);
    }

    public Mp3Extractor(int i, long j) {
        this.flags = i;
        this.forcedFirstSampleTimestampUs = j;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioHeader();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = -9223372036854775807L;
        this.id3Peeker = new Id3Peeker();
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        return synchronize(extractorInput, true);
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        this.extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public void seek(long j, long j2) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = -9223372036854775807L;
        this.samplesRead = 0L;
        this.sampleBytesRemaining = 0;
    }

    @Override // com.google.android.exoplayer2t.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.seeker == null) {
            Seeker seekerMaybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
            MlltSeeker mlltSeekerMaybeHandleSeekMetadata = maybeHandleSeekMetadata(this.metadata, extractorInput.getPosition());
            if (this.disableSeeking) {
                this.seeker = new Seeker.UnseekableSeeker();
            } else {
                if (mlltSeekerMaybeHandleSeekMetadata != null) {
                    this.seeker = mlltSeekerMaybeHandleSeekMetadata;
                } else if (seekerMaybeReadSeekFrame != null) {
                    this.seeker = seekerMaybeReadSeekFrame;
                }
                Seeker seeker = this.seeker;
                if (seeker == null || (!seeker.isSeekable() && (this.flags & 1) != 0)) {
                    this.seeker = getConstantBitrateSeeker(extractorInput);
                }
            }
            this.extractorOutput.seekMap(this.seeker);
            TrackOutput trackOutput = this.trackOutput;
            MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
            String str = mpegAudioHeader.mimeType;
            int i = mpegAudioHeader.channels;
            int i2 = mpegAudioHeader.sampleRate;
            GaplessInfoHolder gaplessInfoHolder = this.gaplessInfoHolder;
            trackOutput.format(Format.createAudioSampleFormat(null, str, null, -1, 4096, i, i2, -1, gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding, null, null, 0, null, (this.flags & 2) != 0 ? null : this.metadata));
            this.firstSamplePosition = extractorInput.getPosition();
        } else if (this.firstSamplePosition != 0) {
            long position = extractorInput.getPosition();
            long j = this.firstSamplePosition;
            if (position < j) {
                extractorInput.skipFully((int) (j - position));
            }
        }
        return readSample(extractorInput);
    }

    public void disableSeeking() {
        this.disableSeeking = true;
    }

    private int readSample(ExtractorInput extractorInput) throws InterruptedException, IOException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (peekEndOfStreamOrHeader(extractorInput)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int i = this.scratch.readInt();
            if (!headersMatch(i, this.synchronizedHeaderData) || MpegAudioHeader.getFrameSize(i) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            MpegAudioHeader.populateHeader(i, this.synchronizedHeader);
            if (this.basisTimeUs == -9223372036854775807L) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != -9223372036854775807L) {
                    this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0L);
                }
            }
            this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
        }
        int iSampleData = this.trackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
        if (iSampleData == -1) {
            return -1;
        }
        int i2 = this.sampleBytesRemaining - iSampleData;
        this.sampleBytesRemaining = i2;
        if (i2 > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.basisTimeUs + ((this.samplesRead * 1000000) / r14.sampleRate), 1, this.synchronizedHeader.frameSize, 0, null);
        this.samplesRead += this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z) throws InterruptedException, IOException {
        int i;
        int peekPosition;
        int frameSize;
        int i2 = z ? LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : MessagesController.UPDATE_MASK_REORDER;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataPeekId3Data = this.id3Peeker.peekId3Data(extractorInput, (this.flags & 2) == 0 ? null : REQUIRED_ID3_FRAME_PREDICATE);
            this.metadata = metadataPeekId3Data;
            if (metadataPeekId3Data != null) {
                this.gaplessInfoHolder.setFromMetadata(metadataPeekId3Data);
            }
            peekPosition = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(peekPosition);
            }
            i = 0;
        } else {
            i = 0;
            peekPosition = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!peekEndOfStreamOrHeader(extractorInput)) {
                this.scratch.setPosition(0);
                int i5 = this.scratch.readInt();
                if ((i == 0 || headersMatch(i5, i)) && (frameSize = MpegAudioHeader.getFrameSize(i5)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        MpegAudioHeader.populateHeader(i5, this.synchronizedHeader);
                        i = i5;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i6 = i4 + 1;
                    if (i4 == i2) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("Searched too many bytes.");
                    }
                    if (z) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(peekPosition + i6);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i4 = i6;
                    i = 0;
                    i3 = 0;
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            extractorInput.skipFully(peekPosition + i4);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i;
        return true;
    }

    private boolean peekEndOfStreamOrHeader(ExtractorInput extractorInput) throws InterruptedException, IOException {
        Seeker seeker = this.seeker;
        if (seeker != null) {
            long dataEndPosition = seeker.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.peekFully(this.scratch.data, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2t.extractor.mp3.Seeker maybeReadSeekFrame(com.google.android.exoplayer2t.extractor.ExtractorInput r11) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r10 = this;
            com.google.android.exoplayer2t.util.ParsableByteArray r5 = new com.google.android.exoplayer2t.util.ParsableByteArray
            com.google.android.exoplayer2t.extractor.MpegAudioHeader r0 = r10.synchronizedHeader
            int r0 = r0.frameSize
            r5.<init>(r0)
            byte[] r0 = r5.data
            com.google.android.exoplayer2t.extractor.MpegAudioHeader r1 = r10.synchronizedHeader
            int r1 = r1.frameSize
            r6 = 0
            r11.peekFully(r0, r6, r1)
            com.google.android.exoplayer2t.extractor.MpegAudioHeader r0 = r10.synchronizedHeader
            int r1 = r0.version
            r2 = 1
            r1 = r1 & r2
            r3 = 21
            if (r1 == 0) goto L26
            int r0 = r0.channels
            if (r0 == r2) goto L2a
            r3 = 36
            r7 = 36
            goto L31
        L26:
            int r0 = r0.channels
            if (r0 == r2) goto L2d
        L2a:
            r7 = 21
            goto L31
        L2d:
            r3 = 13
            r7 = 13
        L31:
            int r8 = getSeekFrameHeader(r5, r7)
            r0 = 1483304551(0x58696e67, float:1.02664153E15)
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r8 == r0) goto L60
            if (r8 != r9) goto L40
            goto L60
        L40:
            r0 = 1447187017(0x56425249, float:5.3414667E13)
            if (r8 != r0) goto L5b
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            com.google.android.exoplayer2t.extractor.MpegAudioHeader r4 = r10.synchronizedHeader
            com.google.android.exoplayer2t.extractor.mp3.VbriSeeker r0 = com.google.android.exoplayer2t.extractor.mp3.VbriSeeker.create(r0, r2, r4, r5)
            com.google.android.exoplayer2t.extractor.MpegAudioHeader r1 = r10.synchronizedHeader
            int r1 = r1.frameSize
            r11.skipFully(r1)
            goto Lae
        L5b:
            r0 = 0
            r11.resetPeekPosition()
            goto Lae
        L60:
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            com.google.android.exoplayer2t.extractor.MpegAudioHeader r4 = r10.synchronizedHeader
            com.google.android.exoplayer2t.extractor.mp3.XingSeeker r0 = com.google.android.exoplayer2t.extractor.mp3.XingSeeker.create(r0, r2, r4, r5)
            if (r0 == 0) goto L98
            com.google.android.exoplayer2t.extractor.GaplessInfoHolder r1 = r10.gaplessInfoHolder
            boolean r1 = r1.hasGaplessInfo()
            if (r1 != 0) goto L98
            r11.resetPeekPosition()
            int r7 = r7 + 141
            r11.advancePeekPosition(r7)
            com.google.android.exoplayer2t.util.ParsableByteArray r1 = r10.scratch
            byte[] r1 = r1.data
            r2 = 3
            r11.peekFully(r1, r6, r2)
            com.google.android.exoplayer2t.util.ParsableByteArray r1 = r10.scratch
            r1.setPosition(r6)
            com.google.android.exoplayer2t.extractor.GaplessInfoHolder r1 = r10.gaplessInfoHolder
            com.google.android.exoplayer2t.util.ParsableByteArray r2 = r10.scratch
            int r2 = r2.readUnsignedInt24()
            r1.setFromXingHeaderValue(r2)
        L98:
            com.google.android.exoplayer2t.extractor.MpegAudioHeader r1 = r10.synchronizedHeader
            int r1 = r1.frameSize
            r11.skipFully(r1)
            if (r0 == 0) goto Lae
            boolean r1 = r0.isSeekable()
            if (r1 != 0) goto Lae
            if (r8 != r9) goto Lae
            com.google.android.exoplayer2t.extractor.mp3.Seeker r11 = r10.getConstantBitrateSeeker(r11)
            return r11
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2t.extractor.mp3.Mp3Extractor.maybeReadSeekFrame(com.google.android.exoplayer2t.extractor.ExtractorInput):com.google.android.exoplayer2t.extractor.mp3.Seeker");
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput) throws InterruptedException, IOException {
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader);
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.limit() >= i + 4) {
            parsableByteArray.setPosition(i);
            int i2 = parsableByteArray.readInt();
            if (i2 == 1483304551 || i2 == 1231971951) {
                return i2;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        return parsableByteArray.readInt() == 1447187017 ? 1447187017 : 0;
    }

    private static MlltSeeker maybeHandleSeekMetadata(Metadata metadata, long j) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof MlltFrame) {
                return MlltSeeker.create(j, (MlltFrame) entry);
            }
        }
        return null;
    }
}
