package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.google.android.exoplayer2.Format.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format createFromParcel(Parcel in) {
            return new Format(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format[] newArray(int size) {
            return new Format[size];
        }
    };
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final Class<? extends ExoMediaCrypto> exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Format createVideoContainerFormat(String id, String label, String containerMimeType, String sampleMimeType, String codecs, Metadata metadata, int bitrate, int width, int height, float frameRate, List<byte[]> initializationData, int selectionFlags, int roleFlags) {
        return new Format(id, label, selectionFlags, roleFlags, bitrate, codecs, metadata, containerMimeType, sampleMimeType, -1, initializationData, null, Long.MAX_VALUE, width, height, frameRate, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format createVideoSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int width, int height, float frameRate, List<byte[]> initializationData, int rotationDegrees, float pixelWidthHeightRatio, DrmInitData drmInitData) {
        return createVideoSampleFormat(id, sampleMimeType, codecs, bitrate, maxInputSize, width, height, frameRate, initializationData, rotationDegrees, pixelWidthHeightRatio, null, -1, null, drmInitData);
    }

    public static Format createVideoSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int width, int height, float frameRate, List<byte[]> initializationData, int rotationDegrees, float pixelWidthHeightRatio, byte[] projectionData, int stereoMode, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(id, null, 0, 0, bitrate, codecs, null, null, sampleMimeType, maxInputSize, initializationData, drmInitData, Long.MAX_VALUE, width, height, frameRate, rotationDegrees, pixelWidthHeightRatio, projectionData, stereoMode, colorInfo, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format createAudioContainerFormat(String id, String label, String containerMimeType, String sampleMimeType, String codecs, Metadata metadata, int bitrate, int channelCount, int sampleRate, List<byte[]> initializationData, int selectionFlags, int roleFlags, String language) {
        return new Format(id, label, selectionFlags, roleFlags, bitrate, codecs, metadata, containerMimeType, sampleMimeType, -1, initializationData, null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, channelCount, sampleRate, -1, -1, -1, language, -1, null);
    }

    public static Format createAudioSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int channelCount, int sampleRate, List<byte[]> initializationData, DrmInitData drmInitData, int selectionFlags, String language) {
        return createAudioSampleFormat(id, sampleMimeType, codecs, bitrate, maxInputSize, channelCount, sampleRate, -1, initializationData, drmInitData, selectionFlags, language);
    }

    public static Format createAudioSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int channelCount, int sampleRate, int pcmEncoding, List<byte[]> initializationData, DrmInitData drmInitData, int selectionFlags, String language) {
        return createAudioSampleFormat(id, sampleMimeType, codecs, bitrate, maxInputSize, channelCount, sampleRate, pcmEncoding, -1, -1, initializationData, drmInitData, selectionFlags, language, null);
    }

    public static Format createAudioSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int maxInputSize, int channelCount, int sampleRate, int pcmEncoding, int encoderDelay, int encoderPadding, List<byte[]> initializationData, DrmInitData drmInitData, int selectionFlags, String language, Metadata metadata) {
        return new Format(id, null, selectionFlags, 0, bitrate, codecs, metadata, null, sampleMimeType, maxInputSize, initializationData, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, channelCount, sampleRate, pcmEncoding, encoderDelay, encoderPadding, language, -1, null);
    }

    public static Format createTextContainerFormat(String id, String label, String containerMimeType, String sampleMimeType, String codecs, int bitrate, int selectionFlags, int roleFlags, String language) {
        return createTextContainerFormat(id, label, containerMimeType, sampleMimeType, codecs, bitrate, selectionFlags, roleFlags, language, -1);
    }

    public static Format createTextContainerFormat(String id, String label, String containerMimeType, String sampleMimeType, String codecs, int bitrate, int selectionFlags, int roleFlags, String language, int accessibilityChannel) {
        return new Format(id, label, selectionFlags, roleFlags, bitrate, codecs, null, containerMimeType, sampleMimeType, -1, null, null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, language, accessibilityChannel, null);
    }

    public static Format createTextSampleFormat(String id, String sampleMimeType, int selectionFlags, String language) {
        return createTextSampleFormat(id, sampleMimeType, selectionFlags, language, null);
    }

    public static Format createTextSampleFormat(String id, String sampleMimeType, int selectionFlags, String language, DrmInitData drmInitData) {
        return createTextSampleFormat(id, sampleMimeType, null, -1, selectionFlags, language, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format createTextSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int selectionFlags, String language, DrmInitData drmInitData, long subsampleOffsetUs) {
        return createTextSampleFormat(id, sampleMimeType, codecs, bitrate, selectionFlags, language, -1, drmInitData, subsampleOffsetUs, Collections.emptyList());
    }

    public static Format createTextSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int selectionFlags, String language, int accessibilityChannel, DrmInitData drmInitData, long subsampleOffsetUs, List<byte[]> initializationData) {
        return new Format(id, null, selectionFlags, 0, bitrate, codecs, null, null, sampleMimeType, -1, initializationData, drmInitData, subsampleOffsetUs, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, language, accessibilityChannel, null);
    }

    public static Format createImageSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, int selectionFlags, List<byte[]> initializationData, String language, DrmInitData drmInitData) {
        return new Format(id, null, selectionFlags, 0, bitrate, codecs, null, null, sampleMimeType, -1, initializationData, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, language, -1, null);
    }

    public static Format createContainerFormat(String id, String label, String containerMimeType, String sampleMimeType, String codecs, int bitrate, int selectionFlags, int roleFlags, String language) {
        return new Format(id, label, selectionFlags, roleFlags, bitrate, codecs, null, containerMimeType, sampleMimeType, -1, null, null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, language, -1, null);
    }

    public static Format createSampleFormat(String id, String sampleMimeType, long subsampleOffsetUs) {
        return new Format(id, null, 0, 0, -1, null, null, null, sampleMimeType, -1, null, null, subsampleOffsetUs, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format createSampleFormat(String id, String sampleMimeType, String codecs, int bitrate, DrmInitData drmInitData) {
        return new Format(id, null, 0, 0, bitrate, codecs, null, null, sampleMimeType, -1, null, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    Format(String id, String label, int selectionFlags, int roleFlags, int bitrate, String codecs, Metadata metadata, String containerMimeType, String sampleMimeType, int maxInputSize, List<byte[]> initializationData, DrmInitData drmInitData, long subsampleOffsetUs, int width, int height, float frameRate, int rotationDegrees, float pixelWidthHeightRatio, byte[] projectionData, int stereoMode, ColorInfo colorInfo, int channelCount, int sampleRate, int pcmEncoding, int encoderDelay, int encoderPadding, String language, int accessibilityChannel, Class<? extends ExoMediaCrypto> exoMediaCryptoType) {
        this.id = id;
        this.label = label;
        this.selectionFlags = selectionFlags;
        this.roleFlags = roleFlags;
        this.bitrate = bitrate;
        this.codecs = codecs;
        this.metadata = metadata;
        this.containerMimeType = containerMimeType;
        this.sampleMimeType = sampleMimeType;
        this.maxInputSize = maxInputSize;
        this.initializationData = initializationData == null ? Collections.emptyList() : initializationData;
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = subsampleOffsetUs;
        this.width = width;
        this.height = height;
        this.frameRate = frameRate;
        int i = rotationDegrees;
        this.rotationDegrees = i == -1 ? 0 : i;
        this.pixelWidthHeightRatio = pixelWidthHeightRatio == -1.0f ? 1.0f : pixelWidthHeightRatio;
        this.projectionData = projectionData;
        this.stereoMode = stereoMode;
        this.colorInfo = colorInfo;
        this.channelCount = channelCount;
        this.sampleRate = sampleRate;
        this.pcmEncoding = pcmEncoding;
        int i2 = encoderDelay;
        this.encoderDelay = i2 == -1 ? 0 : i2;
        this.encoderPadding = encoderPadding != -1 ? encoderPadding : 0;
        this.language = Util.normalizeLanguageCode(language);
        this.accessibilityChannel = accessibilityChannel;
        this.exoMediaCryptoType = exoMediaCryptoType;
    }

    Format(Parcel in) {
        this.id = in.readString();
        this.label = in.readString();
        this.selectionFlags = in.readInt();
        this.roleFlags = in.readInt();
        this.bitrate = in.readInt();
        this.codecs = in.readString();
        this.metadata = (Metadata) in.readParcelable(Metadata.class.getClassLoader());
        this.containerMimeType = in.readString();
        this.sampleMimeType = in.readString();
        this.maxInputSize = in.readInt();
        int i = in.readInt();
        this.initializationData = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.initializationData.add(in.createByteArray());
        }
        this.drmInitData = (DrmInitData) in.readParcelable(DrmInitData.class.getClassLoader());
        this.subsampleOffsetUs = in.readLong();
        this.width = in.readInt();
        this.height = in.readInt();
        this.frameRate = in.readFloat();
        this.rotationDegrees = in.readInt();
        this.pixelWidthHeightRatio = in.readFloat();
        this.projectionData = Util.readBoolean(in) ? in.createByteArray() : null;
        this.stereoMode = in.readInt();
        this.colorInfo = (ColorInfo) in.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = in.readInt();
        this.sampleRate = in.readInt();
        this.pcmEncoding = in.readInt();
        this.encoderDelay = in.readInt();
        this.encoderPadding = in.readInt();
        this.language = in.readString();
        this.accessibilityChannel = in.readInt();
        this.exoMediaCryptoType = null;
    }

    public Format copyWithMaxInputSize(int maxInputSize) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithSubsampleOffsetUs(long subsampleOffsetUs) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithLabel(String label) {
        return new Format(this.id, label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithContainerInfo(String id, String label, String sampleMimeType, String codecs, Metadata metadata, int bitrate, int width, int height, int channelCount, int selectionFlags, String language) {
        Metadata metadata2 = this.metadata;
        return new Format(id, label, selectionFlags, this.roleFlags, bitrate, codecs, metadata2 != null ? metadata2.copyWithAppendedEntriesFrom(metadata) : metadata, this.containerMimeType, sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, width, height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.Format copyWithManifestFormatInfo(com.google.android.exoplayer2.Format r35) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.Format.copyWithManifestFormatInfo(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.Format");
    }

    public Format copyWithGaplessInfo(int encoderDelay, int encoderPadding) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, encoderDelay, encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithFrameRate(float frameRate) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithDrmInitData(DrmInitData drmInitData) {
        return copyWithAdjustments(drmInitData, this.metadata);
    }

    public Format copyWithMetadata(Metadata metadata) {
        return copyWithAdjustments(this.drmInitData, metadata);
    }

    public Format copyWithAdjustments(DrmInitData drmInitData, Metadata metadata) {
        if (drmInitData == this.drmInitData && metadata == this.metadata) {
            return this;
        }
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithBitrate(int bitrate) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithExoMediaCryptoType(Class<? extends ExoMediaCrypto> exoMediaCryptoType) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, exoMediaCryptoType);
    }

    public int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public String toString() {
        return "Format(" + this.id + ", " + this.label + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.codecs + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.id;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.label;
            int iHashCode2 = (((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.bitrate) * 31;
            String str3 = this.codecs;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Metadata metadata = this.metadata;
            int iHashCode4 = (iHashCode3 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str4 = this.containerMimeType;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.sampleMimeType;
            int iHashCode6 = (((((((((((((((((((((((((((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31;
            String str6 = this.language;
            int iHashCode7 = (((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.accessibilityChannel) * 31;
            Class<? extends ExoMediaCrypto> cls = this.exoMediaCryptoType;
            this.hashCode = iHashCode7 + (cls != null ? cls.hashCode() : 0);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i2 = this.hashCode;
        return (i2 == 0 || (i = format.hashCode) == 0 || i2 == i) && this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.exoMediaCryptoType, format.exoMediaCryptoType) && Util.areEqual(this.id, format.id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format);
    }

    public boolean initializationDataEquals(Format other) {
        if (this.initializationData.size() != other.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!Arrays.equals(this.initializationData.get(i), other.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.label);
        dest.writeInt(this.selectionFlags);
        dest.writeInt(this.roleFlags);
        dest.writeInt(this.bitrate);
        dest.writeString(this.codecs);
        dest.writeParcelable(this.metadata, 0);
        dest.writeString(this.containerMimeType);
        dest.writeString(this.sampleMimeType);
        dest.writeInt(this.maxInputSize);
        int size = this.initializationData.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            dest.writeByteArray(this.initializationData.get(i));
        }
        dest.writeParcelable(this.drmInitData, 0);
        dest.writeLong(this.subsampleOffsetUs);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeFloat(this.frameRate);
        dest.writeInt(this.rotationDegrees);
        dest.writeFloat(this.pixelWidthHeightRatio);
        Util.writeBoolean(dest, this.projectionData != null);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            dest.writeByteArray(bArr);
        }
        dest.writeInt(this.stereoMode);
        dest.writeParcelable(this.colorInfo, flags);
        dest.writeInt(this.channelCount);
        dest.writeInt(this.sampleRate);
        dest.writeInt(this.pcmEncoding);
        dest.writeInt(this.encoderDelay);
        dest.writeInt(this.encoderPadding);
        dest.writeString(this.language);
        dest.writeInt(this.accessibilityChannel);
    }
}
