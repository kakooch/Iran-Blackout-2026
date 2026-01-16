package ir.eitaa.messenger.audioinfo.mp3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.eitaa.messenger.audioinfo.AudioInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class ID3v2Info extends AudioInfo {
    static final Logger LOGGER = Logger.getLogger(ID3v2Info.class.getName());
    private byte coverPictureType;
    private final Level debugLevel;

    static class AttachedPicture {
        final String description;
        final byte[] imageData;
        final String imageType;
        final byte type;

        public AttachedPicture(byte type, String description, String imageType, byte[] imageData) {
            this.type = type;
            this.description = description;
            this.imageType = imageType;
            this.imageData = imageData;
        }
    }

    static class CommentOrUnsynchronizedLyrics {
        final String description;
        final String language;
        final String text;

        public CommentOrUnsynchronizedLyrics(String language, String description, String text) {
            this.language = language;
            this.description = description;
            this.text = text;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isID3v2StartPosition(java.io.InputStream r2) throws java.io.IOException {
        /*
            r0 = 3
            r2.mark(r0)
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L23
            r1 = 73
            if (r0 != r1) goto L1e
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L23
            r1 = 68
            if (r0 != r1) goto L1e
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L23
            r1 = 51
            if (r0 != r1) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.reset()
            return r0
        L23:
            r0 = move-exception
            r2.reset()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.audioinfo.mp3.ID3v2Info.isID3v2StartPosition(java.io.InputStream):boolean");
    }

    public ID3v2Info(InputStream input, Level debugLevel) throws ID3v2Exception, IOException {
        ID3v2DataInput data;
        long remainingLength;
        this.debugLevel = debugLevel;
        if (isID3v2StartPosition(input)) {
            ID3v2TagHeader iD3v2TagHeader = new ID3v2TagHeader(input);
            this.brand = "ID3";
            this.version = String.format("2.%d.%d", Integer.valueOf(iD3v2TagHeader.getVersion()), Integer.valueOf(iD3v2TagHeader.getRevision()));
            ID3v2TagBody iD3v2TagBodyTagBody = iD3v2TagHeader.tagBody(input);
            while (true) {
                try {
                    if (iD3v2TagBodyTagBody.getRemainingLength() <= 10) {
                        break;
                    }
                    ID3v2FrameHeader iD3v2FrameHeader = new ID3v2FrameHeader(iD3v2TagBodyTagBody);
                    if (iD3v2FrameHeader.isPadding()) {
                        break;
                    }
                    if (iD3v2FrameHeader.getBodySize() > iD3v2TagBodyTagBody.getRemainingLength()) {
                        Logger logger = LOGGER;
                        if (logger.isLoggable(debugLevel)) {
                            logger.log(debugLevel, "ID3 frame claims to extend frames area");
                        }
                    } else if (iD3v2FrameHeader.isValid() && !iD3v2FrameHeader.isEncryption()) {
                        ID3v2FrameBody iD3v2FrameBodyFrameBody = iD3v2TagBodyTagBody.frameBody(iD3v2FrameHeader);
                        try {
                            try {
                                parseFrame(iD3v2FrameBodyFrameBody);
                                data = iD3v2FrameBodyFrameBody.getData();
                                remainingLength = iD3v2FrameBodyFrameBody.getRemainingLength();
                            } catch (ID3v2Exception e) {
                                if (LOGGER.isLoggable(debugLevel)) {
                                    LOGGER.log(debugLevel, String.format("ID3 exception occured in frame %s: %s", iD3v2FrameHeader.getFrameId(), e.getMessage()));
                                }
                                data = iD3v2FrameBodyFrameBody.getData();
                                remainingLength = iD3v2FrameBodyFrameBody.getRemainingLength();
                            }
                            data.skipFully(remainingLength);
                        } catch (Throwable th) {
                            iD3v2FrameBodyFrameBody.getData().skipFully(iD3v2FrameBodyFrameBody.getRemainingLength());
                            throw th;
                        }
                    } else {
                        iD3v2TagBodyTagBody.getData().skipFully(iD3v2FrameHeader.getBodySize());
                    }
                } catch (ID3v2Exception e2) {
                    Logger logger2 = LOGGER;
                    if (logger2.isLoggable(debugLevel)) {
                        logger2.log(debugLevel, "ID3 exception occured: " + e2.getMessage());
                    }
                }
            }
            iD3v2TagBodyTagBody.getData().skipFully(iD3v2TagBodyTagBody.getRemainingLength());
            if (iD3v2TagHeader.getFooterSize() > 0) {
                input.skip(iD3v2TagHeader.getFooterSize());
            }
        }
    }

    void parseFrame(ID3v2FrameBody frame) throws ID3v2Exception, IOException {
        String str;
        byte b;
        int i;
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, "Parsing frame: " + frame.getFrameHeader().getFrameId());
        }
        String frameId = frame.getFrameHeader().getFrameId();
        frameId.hashCode();
        switch (frameId) {
            case "COM":
            case "COMM":
                CommentOrUnsynchronizedLyrics commentOrUnsynchronizedLyricsFrame = parseCommentOrUnsynchronizedLyricsFrame(frame);
                if (this.comment == null || (str = commentOrUnsynchronizedLyricsFrame.description) == null || "".equals(str)) {
                    this.comment = commentOrUnsynchronizedLyricsFrame.text;
                    break;
                }
                break;
            case "PIC":
            case "APIC":
                if (this.cover == null || this.coverPictureType != 3) {
                    AttachedPicture attachedPictureFrame = parseAttachedPictureFrame(frame);
                    if (this.cover == null || (b = attachedPictureFrame.type) == 3 || b == 0) {
                        try {
                            byte[] bArr = attachedPictureFrame.imageData;
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            options.inSampleSize = 1;
                            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                            int i2 = options.outWidth;
                            if (i2 > 800 || options.outHeight > 800) {
                                for (int iMax = Math.max(i2, options.outHeight); iMax > 800; iMax /= 2) {
                                    options.inSampleSize *= 2;
                                }
                            }
                            options.inJustDecodeBounds = false;
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                            this.cover = bitmapDecodeByteArray;
                            if (bitmapDecodeByteArray != null) {
                                float fMax = Math.max(bitmapDecodeByteArray.getWidth(), this.cover.getHeight()) / 120.0f;
                                if (fMax > 0.0f) {
                                    this.smallCover = Bitmap.createScaledBitmap(this.cover, (int) (r1.getWidth() / fMax), (int) (this.cover.getHeight() / fMax), true);
                                } else {
                                    this.smallCover = this.cover;
                                }
                                if (this.smallCover == null) {
                                    this.smallCover = this.cover;
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        this.coverPictureType = attachedPictureFrame.type;
                        break;
                    }
                }
                break;
            case "TAL":
            case "TALB":
                this.album = parseTextFrame(frame);
                break;
            case "TCM":
            case "TCOM":
                this.composer = parseTextFrame(frame);
                break;
            case "TCO":
            case "TCON":
                String textFrame = parseTextFrame(frame);
                if (textFrame.length() > 0) {
                    this.genre = textFrame;
                    ID3v1Genre genre = null;
                    try {
                        if (textFrame.charAt(0) == '(') {
                            int iIndexOf = textFrame.indexOf(41);
                            if (iIndexOf > 1 && (genre = ID3v1Genre.getGenre(Integer.parseInt(textFrame.substring(1, iIndexOf)))) == null && textFrame.length() > (i = iIndexOf + 1)) {
                                this.genre = textFrame.substring(i);
                            }
                        } else {
                            genre = ID3v1Genre.getGenre(Integer.parseInt(textFrame));
                        }
                        if (genre != null) {
                            this.genre = genre.getDescription();
                            break;
                        }
                    } catch (NumberFormatException unused) {
                        return;
                    }
                }
                break;
            case "TCP":
            case "TCMP":
                this.compilation = "1".equals(parseTextFrame(frame));
                break;
            case "TCR":
            case "TCOP":
                this.copyright = parseTextFrame(frame);
                break;
            case "TLE":
            case "TLEN":
                String textFrame2 = parseTextFrame(frame);
                try {
                    this.duration = Long.valueOf(textFrame2).longValue();
                    break;
                } catch (NumberFormatException unused2) {
                    Logger logger2 = LOGGER;
                    if (logger2.isLoggable(this.debugLevel)) {
                        logger2.log(this.debugLevel, "Could not parse track duration: " + textFrame2);
                        return;
                    }
                    return;
                }
            case "TP1":
            case "TPE1":
                this.artist = parseTextFrame(frame);
                break;
            case "TP2":
            case "TPE2":
                this.albumArtist = parseTextFrame(frame);
                break;
            case "TPA":
            case "TPOS":
                String textFrame3 = parseTextFrame(frame);
                if (textFrame3.length() > 0) {
                    int iIndexOf2 = textFrame3.indexOf(47);
                    if (iIndexOf2 < 0) {
                        try {
                            this.disc = Short.valueOf(textFrame3).shortValue();
                            break;
                        } catch (NumberFormatException unused3) {
                            Logger logger3 = LOGGER;
                            if (logger3.isLoggable(this.debugLevel)) {
                                logger3.log(this.debugLevel, "Could not parse disc number: " + textFrame3);
                                return;
                            }
                            return;
                        }
                    } else {
                        try {
                            this.disc = Short.valueOf(textFrame3.substring(0, iIndexOf2)).shortValue();
                        } catch (NumberFormatException unused4) {
                            Logger logger4 = LOGGER;
                            if (logger4.isLoggable(this.debugLevel)) {
                                logger4.log(this.debugLevel, "Could not parse disc number: " + textFrame3);
                            }
                        }
                        try {
                            this.discs = Short.valueOf(textFrame3.substring(iIndexOf2 + 1)).shortValue();
                            break;
                        } catch (NumberFormatException unused5) {
                            Logger logger5 = LOGGER;
                            if (logger5.isLoggable(this.debugLevel)) {
                                logger5.log(this.debugLevel, "Could not parse number of discs: " + textFrame3);
                                return;
                            }
                            return;
                        }
                    }
                }
                break;
            case "TRK":
            case "TRCK":
                String textFrame4 = parseTextFrame(frame);
                if (textFrame4.length() > 0) {
                    int iIndexOf3 = textFrame4.indexOf(47);
                    if (iIndexOf3 < 0) {
                        try {
                            this.track = Short.valueOf(textFrame4).shortValue();
                            break;
                        } catch (NumberFormatException unused6) {
                            Logger logger6 = LOGGER;
                            if (logger6.isLoggable(this.debugLevel)) {
                                logger6.log(this.debugLevel, "Could not parse track number: " + textFrame4);
                                return;
                            }
                            return;
                        }
                    } else {
                        try {
                            this.track = Short.valueOf(textFrame4.substring(0, iIndexOf3)).shortValue();
                        } catch (NumberFormatException unused7) {
                            Logger logger7 = LOGGER;
                            if (logger7.isLoggable(this.debugLevel)) {
                                logger7.log(this.debugLevel, "Could not parse track number: " + textFrame4);
                            }
                        }
                        try {
                            this.tracks = Short.valueOf(textFrame4.substring(iIndexOf3 + 1)).shortValue();
                            break;
                        } catch (NumberFormatException unused8) {
                            Logger logger8 = LOGGER;
                            if (logger8.isLoggable(this.debugLevel)) {
                                logger8.log(this.debugLevel, "Could not parse number of tracks: " + textFrame4);
                                return;
                            }
                            return;
                        }
                    }
                }
                break;
            case "TT1":
            case "TIT1":
                this.grouping = parseTextFrame(frame);
                break;
            case "TT2":
            case "TIT2":
                this.title = parseTextFrame(frame);
                break;
            case "TYE":
            case "TYER":
                String textFrame5 = parseTextFrame(frame);
                if (textFrame5.length() > 0) {
                    try {
                        this.year = Short.valueOf(textFrame5).shortValue();
                        break;
                    } catch (NumberFormatException unused9) {
                        Logger logger9 = LOGGER;
                        if (logger9.isLoggable(this.debugLevel)) {
                            logger9.log(this.debugLevel, "Could not parse year: " + textFrame5);
                            return;
                        }
                        return;
                    }
                }
                break;
            case "ULT":
            case "USLT":
                if (this.lyrics == null) {
                    this.lyrics = parseCommentOrUnsynchronizedLyricsFrame(frame).text;
                    break;
                }
                break;
            case "TDRC":
                String textFrame6 = parseTextFrame(frame);
                if (textFrame6.length() >= 4) {
                    try {
                        this.year = Short.valueOf(textFrame6.substring(0, 4)).shortValue();
                        break;
                    } catch (NumberFormatException unused10) {
                        Logger logger10 = LOGGER;
                        if (logger10.isLoggable(this.debugLevel)) {
                            logger10.log(this.debugLevel, "Could not parse year from: " + textFrame6);
                            return;
                        }
                        return;
                    }
                }
                break;
        }
    }

    String parseTextFrame(ID3v2FrameBody frame) throws ID3v2Exception, IOException {
        return frame.readFixedLengthString((int) frame.getRemainingLength(), frame.readEncoding());
    }

    CommentOrUnsynchronizedLyrics parseCommentOrUnsynchronizedLyricsFrame(ID3v2FrameBody data) throws ID3v2Exception, IOException {
        ID3v2Encoding encoding = data.readEncoding();
        return new CommentOrUnsynchronizedLyrics(data.readFixedLengthString(3, ID3v2Encoding.ISO_8859_1), data.readZeroTerminatedString(200, encoding), data.readFixedLengthString((int) data.getRemainingLength(), encoding));
    }

    AttachedPicture parseAttachedPictureFrame(ID3v2FrameBody data) throws ID3v2Exception, IOException {
        String zeroTerminatedString;
        ID3v2Encoding encoding = data.readEncoding();
        if (data.getTagHeader().getVersion() == 2) {
            String upperCase = data.readFixedLengthString(3, ID3v2Encoding.ISO_8859_1).toUpperCase();
            upperCase.hashCode();
            zeroTerminatedString = !upperCase.equals("JPG") ? !upperCase.equals("PNG") ? "image/unknown" : "image/png" : "image/jpeg";
        } else {
            zeroTerminatedString = data.readZeroTerminatedString(20, ID3v2Encoding.ISO_8859_1);
        }
        return new AttachedPicture(data.getData().readByte(), data.readZeroTerminatedString(200, encoding), zeroTerminatedString, data.getData().readFully((int) data.getRemainingLength()));
    }
}
