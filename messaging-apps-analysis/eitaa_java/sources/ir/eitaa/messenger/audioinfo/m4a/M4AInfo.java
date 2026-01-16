package ir.eitaa.messenger.audioinfo.m4a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.eitaa.messenger.audioinfo.AudioInfo;
import ir.eitaa.messenger.audioinfo.mp3.ID3v1Genre;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class M4AInfo extends AudioInfo {
    static final Logger LOGGER = Logger.getLogger(M4AInfo.class.getName());
    private final Level debugLevel;
    private byte rating;
    private BigDecimal speed;
    private short tempo;
    private BigDecimal volume;

    public M4AInfo(InputStream input) throws IOException {
        this(input, Level.FINEST);
    }

    public M4AInfo(InputStream input, Level debugLevel) throws IOException {
        this.debugLevel = debugLevel;
        MP4Input mP4Input = new MP4Input(input);
        Logger logger = LOGGER;
        if (logger.isLoggable(debugLevel)) {
            logger.log(debugLevel, mP4Input.toString());
        }
        ftyp(mP4Input.nextChild("ftyp"));
        moov(mP4Input.nextChildUpTo("moov"));
    }

    void ftyp(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        String strTrim = atom.readString(4, "ISO8859_1").trim();
        this.brand = strTrim;
        if (strTrim.matches("M4V|MP4|mp42|isom")) {
            logger.warning(atom.getPath() + ": brand=" + this.brand + " (experimental)");
        } else if (!this.brand.matches("M4A|M4P")) {
            logger.warning(atom.getPath() + ": brand=" + this.brand + " (expected M4A or M4P)");
        }
        this.version = String.valueOf(atom.readInt());
    }

    void moov(MP4Atom atom) throws IOException {
        MP4Atom mP4AtomNextChild;
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        while (atom.hasMoreChildren()) {
            mP4AtomNextChild = atom.nextChild();
            String type = mP4AtomNextChild.getType();
            type.hashCode();
            switch (type) {
                case "mvhd":
                    mvhd(mP4AtomNextChild);
                    break;
                case "trak":
                    trak(mP4AtomNextChild);
                    break;
                case "udta":
                    udta(mP4AtomNextChild);
                    break;
            }
        }
    }

    void mvhd(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        byte b = atom.readByte();
        atom.skip(3);
        atom.skip(b == 1 ? 16 : 8);
        int i = atom.readInt();
        long j = b == 1 ? atom.readLong() : atom.readInt();
        if (this.duration == 0) {
            this.duration = (j * 1000) / i;
        } else if (logger.isLoggable(this.debugLevel)) {
            long j2 = (j * 1000) / i;
            if (Math.abs(this.duration - j2) > 2) {
                logger.log(this.debugLevel, "mvhd: duration " + this.duration + " -> " + j2);
            }
        }
        this.speed = atom.readIntegerFixedPoint();
        this.volume = atom.readShortFixedPoint();
    }

    void trak(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        mdia(atom.nextChildUpTo("mdia"));
    }

    void mdia(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        mdhd(atom.nextChild("mdhd"));
    }

    void mdhd(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        byte b = atom.readByte();
        atom.skip(3);
        atom.skip(b == 1 ? 16 : 8);
        int i = atom.readInt();
        long j = b == 1 ? atom.readLong() : atom.readInt();
        if (this.duration == 0) {
            this.duration = (j * 1000) / i;
            return;
        }
        if (logger.isLoggable(this.debugLevel)) {
            long j2 = (j * 1000) / i;
            if (Math.abs(this.duration - j2) > 2) {
                logger.log(this.debugLevel, "mdhd: duration " + this.duration + " -> " + j2);
            }
        }
    }

    void udta(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        while (atom.hasMoreChildren()) {
            MP4Atom mP4AtomNextChild = atom.nextChild();
            if ("meta".equals(mP4AtomNextChild.getType())) {
                meta(mP4AtomNextChild);
                return;
            }
        }
    }

    void meta(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        atom.skip(4);
        while (atom.hasMoreChildren()) {
            MP4Atom mP4AtomNextChild = atom.nextChild();
            if ("ilst".equals(mP4AtomNextChild.getType())) {
                ilst(mP4AtomNextChild);
                return;
            }
        }
    }

    void ilst(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        while (atom.hasMoreChildren()) {
            MP4Atom mP4AtomNextChild = atom.nextChild();
            Logger logger2 = LOGGER;
            if (logger2.isLoggable(this.debugLevel)) {
                logger2.log(this.debugLevel, mP4AtomNextChild.toString());
            }
            if (mP4AtomNextChild.getRemaining() == 0) {
                if (logger2.isLoggable(this.debugLevel)) {
                    logger2.log(this.debugLevel, mP4AtomNextChild.getPath() + ": contains no value");
                }
            } else {
                data(mP4AtomNextChild.nextChildUpTo("data"));
            }
        }
    }

    void data(MP4Atom atom) throws IOException {
        Logger logger = LOGGER;
        if (logger.isLoggable(this.debugLevel)) {
            logger.log(this.debugLevel, atom.toString());
        }
        atom.skip(4);
        atom.skip(4);
        String type = atom.getParent().getType();
        type.hashCode();
        switch (type) {
            case "aART":
                this.albumArtist = atom.readString("UTF-8");
                break;
            case "covr":
                try {
                    byte[] bytes = atom.readBytes();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    options.inSampleSize = 1;
                    BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
                    int i = options.outWidth;
                    if (i > 800 || options.outHeight > 800) {
                        for (int iMax = Math.max(i, options.outHeight); iMax > 800; iMax /= 2) {
                            options.inSampleSize *= 2;
                        }
                    }
                    options.inJustDecodeBounds = false;
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
                    this.cover = bitmapDecodeByteArray;
                    if (bitmapDecodeByteArray != null) {
                        float fMax = Math.max(bitmapDecodeByteArray.getWidth(), this.cover.getHeight()) / 120.0f;
                        if (fMax > 0.0f) {
                            this.smallCover = Bitmap.createScaledBitmap(this.cover, (int) (r0.getWidth() / fMax), (int) (this.cover.getHeight() / fMax), true);
                        } else {
                            this.smallCover = this.cover;
                        }
                        if (this.smallCover == null) {
                            this.smallCover = this.cover;
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case "cpil":
                this.compilation = atom.readBoolean();
                break;
            case "cprt":
            case "©cpy":
                String str = this.copyright;
                if (str == null || str.trim().length() == 0) {
                    this.copyright = atom.readString("UTF-8");
                    break;
                }
                break;
            case "disk":
                atom.skip(2);
                this.disc = atom.readShort();
                this.discs = atom.readShort();
                break;
            case "gnre":
                String str2 = this.genre;
                if (str2 == null || str2.trim().length() == 0) {
                    if (atom.getRemaining() == 2) {
                        ID3v1Genre genre = ID3v1Genre.getGenre(atom.readShort() - 1);
                        if (genre != null) {
                            this.genre = genre.getDescription();
                            break;
                        }
                    } else {
                        this.genre = atom.readString("UTF-8");
                        break;
                    }
                }
                break;
            case "rtng":
                this.rating = atom.readByte();
                break;
            case "tmpo":
                this.tempo = atom.readShort();
                break;
            case "trkn":
                atom.skip(2);
                this.track = atom.readShort();
                this.tracks = atom.readShort();
                break;
            case "©ART":
                this.artist = atom.readString("UTF-8");
                break;
            case "©alb":
                this.album = atom.readString("UTF-8");
                break;
            case "©cmt":
                this.comment = atom.readString("UTF-8");
                break;
            case "©com":
            case "©wrt":
                String str3 = this.composer;
                if (str3 == null || str3.trim().length() == 0) {
                    this.composer = atom.readString("UTF-8");
                    break;
                }
                break;
            case "©day":
                String strTrim = atom.readString("UTF-8").trim();
                if (strTrim.length() >= 4) {
                    try {
                        this.year = Short.valueOf(strTrim.substring(0, 4)).shortValue();
                        break;
                    } catch (NumberFormatException unused) {
                        return;
                    }
                }
                break;
            case "©gen":
                String str4 = this.genre;
                if (str4 == null || str4.trim().length() == 0) {
                    this.genre = atom.readString("UTF-8");
                    break;
                }
                break;
            case "©grp":
                this.grouping = atom.readString("UTF-8");
                break;
            case "©lyr":
                this.lyrics = atom.readString("UTF-8");
                break;
            case "©nam":
                this.title = atom.readString("UTF-8");
                break;
        }
    }
}
