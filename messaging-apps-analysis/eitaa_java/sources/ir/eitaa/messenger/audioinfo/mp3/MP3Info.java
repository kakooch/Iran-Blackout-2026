package ir.eitaa.messenger.audioinfo.mp3;

import ir.eitaa.messenger.audioinfo.AudioInfo;
import ir.eitaa.messenger.audioinfo.mp3.MP3Frame;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class MP3Info extends AudioInfo {
    static final Logger LOGGER = Logger.getLogger(MP3Info.class.getName());

    interface StopReadCondition {
        boolean stopRead(MP3Input data) throws IOException;
    }

    public MP3Info(InputStream input, long fileLength) throws ID3v2Exception, MP3Exception, IOException {
        this(input, fileLength, Level.FINEST);
    }

    public MP3Info(InputStream input, final long fileLength, Level debugLevel) throws ID3v2Exception, MP3Exception, IOException {
        this.brand = "MP3";
        this.version = "0";
        MP3Input mP3Input = new MP3Input(input);
        if (ID3v2Info.isID3v2StartPosition(mP3Input)) {
            ID3v2Info iD3v2Info = new ID3v2Info(mP3Input, debugLevel);
            this.album = iD3v2Info.getAlbum();
            this.albumArtist = iD3v2Info.getAlbumArtist();
            this.artist = iD3v2Info.getArtist();
            this.comment = iD3v2Info.getComment();
            this.cover = iD3v2Info.getCover();
            this.smallCover = iD3v2Info.getSmallCover();
            this.compilation = iD3v2Info.isCompilation();
            this.composer = iD3v2Info.getComposer();
            this.copyright = iD3v2Info.getCopyright();
            this.disc = iD3v2Info.getDisc();
            this.discs = iD3v2Info.getDiscs();
            this.duration = iD3v2Info.getDuration();
            this.genre = iD3v2Info.getGenre();
            this.grouping = iD3v2Info.getGrouping();
            this.lyrics = iD3v2Info.getLyrics();
            this.title = iD3v2Info.getTitle();
            this.track = iD3v2Info.getTrack();
            this.tracks = iD3v2Info.getTracks();
            this.year = iD3v2Info.getYear();
        }
        long j = this.duration;
        if (j <= 0 || j >= 3600000) {
            try {
                this.duration = calculateDuration(mP3Input, fileLength, new StopReadCondition(fileLength) { // from class: ir.eitaa.messenger.audioinfo.mp3.MP3Info.1
                    final long stopPosition;
                    final /* synthetic */ long val$fileLength;

                    {
                        this.val$fileLength = fileLength;
                        this.stopPosition = fileLength - 128;
                    }

                    @Override // ir.eitaa.messenger.audioinfo.mp3.MP3Info.StopReadCondition
                    public boolean stopRead(MP3Input data) throws IOException {
                        return data.getPosition() == this.stopPosition && ID3v1Info.isID3v1StartPosition(data);
                    }
                });
            } catch (MP3Exception e) {
                Logger logger = LOGGER;
                if (logger.isLoggable(debugLevel)) {
                    logger.log(debugLevel, "Could not determine MP3 duration", (Throwable) e);
                }
            }
        }
        if (this.title == null || this.album == null || this.artist == null) {
            long j2 = fileLength - 128;
            if (mP3Input.getPosition() <= j2) {
                mP3Input.skipFully(j2 - mP3Input.getPosition());
                if (ID3v1Info.isID3v1StartPosition(input)) {
                    ID3v1Info iD3v1Info = new ID3v1Info(input);
                    if (this.album == null) {
                        this.album = iD3v1Info.getAlbum();
                    }
                    if (this.artist == null) {
                        this.artist = iD3v1Info.getArtist();
                    }
                    if (this.comment == null) {
                        this.comment = iD3v1Info.getComment();
                    }
                    if (this.genre == null) {
                        this.genre = iD3v1Info.getGenre();
                    }
                    if (this.title == null) {
                        this.title = iD3v1Info.getTitle();
                    }
                    if (this.track == 0) {
                        this.track = iD3v1Info.getTrack();
                    }
                    if (this.year == 0) {
                        this.year = iD3v1Info.getYear();
                    }
                }
            }
        }
    }

    MP3Frame readFirstFrame(MP3Input data, StopReadCondition stopCondition) throws IOException {
        MP3Frame.Header header;
        int i = stopCondition.stopRead(data) ? -1 : data.read();
        int i2 = 0;
        while (i != -1) {
            if (i2 == 255 && (i & 224) == 224) {
                data.mark(2);
                int i3 = stopCondition.stopRead(data) ? -1 : data.read();
                if (i3 == -1) {
                    break;
                }
                int i4 = stopCondition.stopRead(data) ? -1 : data.read();
                if (i4 == -1) {
                    break;
                }
                try {
                    header = new MP3Frame.Header(i, i3, i4);
                } catch (MP3Exception unused) {
                    header = null;
                }
                if (header != null) {
                    data.reset();
                    data.mark(header.getFrameSize() + 2);
                    int frameSize = header.getFrameSize();
                    byte[] bArr = new byte[frameSize];
                    bArr[0] = -1;
                    bArr[1] = (byte) i;
                    int i5 = frameSize - 2;
                    try {
                        data.readFully(bArr, 2, i5);
                        MP3Frame mP3Frame = new MP3Frame(header, bArr);
                        if (!mP3Frame.isChecksumError()) {
                            int i6 = stopCondition.stopRead(data) ? -1 : data.read();
                            int i7 = stopCondition.stopRead(data) ? -1 : data.read();
                            if (i6 != -1 && i7 != -1) {
                                if (i6 == 255 && (i7 & 254) == (i & 254)) {
                                    int i8 = stopCondition.stopRead(data) ? -1 : data.read();
                                    int i9 = stopCondition.stopRead(data) ? -1 : data.read();
                                    if (i8 != -1 && i9 != -1) {
                                        try {
                                            if (new MP3Frame.Header(i7, i8, i9).isCompatible(header)) {
                                                data.reset();
                                                data.skipFully(i5);
                                            }
                                        } catch (MP3Exception unused2) {
                                        }
                                    }
                                }
                            }
                            return mP3Frame;
                        }
                    } catch (EOFException unused3) {
                    }
                }
                data.reset();
            }
            i2 = i;
            i = stopCondition.stopRead(data) ? -1 : data.read();
        }
        return null;
    }

    MP3Frame readNextFrame(MP3Input data, StopReadCondition stopCondition, MP3Frame previousFrame) throws IOException {
        MP3Frame.Header header;
        MP3Frame.Header header2 = previousFrame.getHeader();
        data.mark(4);
        int i = stopCondition.stopRead(data) ? -1 : data.read();
        int i2 = stopCondition.stopRead(data) ? -1 : data.read();
        if (i != -1 && i2 != -1) {
            if (i == 255 && (i2 & 224) == 224) {
                int i3 = stopCondition.stopRead(data) ? -1 : data.read();
                int i4 = stopCondition.stopRead(data) ? -1 : data.read();
                if (i3 != -1 && i4 != -1) {
                    try {
                        header = new MP3Frame.Header(i2, i3, i4);
                    } catch (MP3Exception unused) {
                        header = null;
                    }
                    if (header != null && header.isCompatible(header2)) {
                        int frameSize = header.getFrameSize();
                        byte[] bArr = new byte[frameSize];
                        bArr[0] = (byte) i;
                        bArr[1] = (byte) i2;
                        bArr[2] = (byte) i3;
                        bArr[3] = (byte) i4;
                        try {
                            data.readFully(bArr, 4, frameSize - 4);
                            return new MP3Frame(header, bArr);
                        } catch (EOFException unused2) {
                        }
                    }
                }
                return null;
            }
            data.reset();
        }
        return null;
    }

    long calculateDuration(MP3Input data, long totalLength, StopReadCondition stopCondition) throws MP3Exception, IOException {
        MP3Frame firstFrame = readFirstFrame(data, stopCondition);
        if (firstFrame != null) {
            if (firstFrame.getNumberOfFrames() > 0) {
                return firstFrame.getHeader().getTotalDuration(r4 * firstFrame.getSize());
            }
            long position = data.getPosition() - firstFrame.getSize();
            long size = firstFrame.getSize();
            int bitrate = firstFrame.getHeader().getBitrate();
            long j = bitrate;
            boolean z = false;
            int duration = 10000 / firstFrame.getHeader().getDuration();
            int i = 1;
            while (true) {
                if (i == duration && !z && totalLength > 0) {
                    return firstFrame.getHeader().getTotalDuration(totalLength - position);
                }
                firstFrame = readNextFrame(data, stopCondition, firstFrame);
                if (firstFrame != null) {
                    int bitrate2 = firstFrame.getHeader().getBitrate();
                    int i2 = i;
                    if (bitrate2 != bitrate) {
                        z = true;
                    }
                    j += bitrate2;
                    size += firstFrame.getSize();
                    i = i2 + 1;
                } else {
                    return (((size * 1000) * i) * 8) / j;
                }
            }
        } else {
            throw new MP3Exception("No audio frame");
        }
    }
}
