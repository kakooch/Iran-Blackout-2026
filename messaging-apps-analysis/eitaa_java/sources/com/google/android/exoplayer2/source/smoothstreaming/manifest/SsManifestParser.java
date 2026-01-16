package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Util;
import ir.eitaa.messenger.MediaController;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.linphone.mediastream.Factory;
import org.webrtc.MediaStreamTrack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {
    private final XmlPullParserFactory xmlParserFactory;

    public SsManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public SsManifest parse(Uri uri, InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            return (SsManifest) new SmoothStreamingMediaParser(null, uri.toString()).parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String fieldName) {
            super("Missing required field: " + fieldName);
        }
    }

    private static abstract class ElementParser {
        private final String baseUri;
        private final List<Pair<String, Object>> normalizedAttributes = new LinkedList();
        private final ElementParser parent;
        private final String tag;

        protected void addChild(Object parsedChild) {
        }

        protected abstract Object build();

        protected boolean handleChildInline(String tagName) {
            return false;
        }

        protected void parseEndTag(XmlPullParser xmlParser) {
        }

        protected abstract void parseStartTag(XmlPullParser xmlParser) throws ParserException;

        protected void parseText(XmlPullParser xmlParser) {
        }

        public ElementParser(ElementParser parent, String baseUri, String tag) {
            this.parent = parent;
            this.baseUri = baseUri;
            this.tag = tag;
        }

        public final Object parse(XmlPullParser xmlParser) throws XmlPullParserException, IOException {
            boolean z = false;
            int i = 0;
            while (true) {
                int eventType = xmlParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlParser.getName();
                    if (this.tag.equals(name)) {
                        parseStartTag(xmlParser);
                        z = true;
                    } else if (z) {
                        if (i > 0) {
                            i++;
                        } else if (handleChildInline(name)) {
                            parseStartTag(xmlParser);
                        } else {
                            ElementParser elementParserNewChildParser = newChildParser(this, name, this.baseUri);
                            if (elementParserNewChildParser == null) {
                                i = 1;
                            } else {
                                addChild(elementParserNewChildParser.parse(xmlParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        parseText(xmlParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    String name2 = xmlParser.getName();
                    parseEndTag(xmlParser);
                    if (!handleChildInline(name2)) {
                        return build();
                    }
                }
                xmlParser.next();
            }
        }

        private ElementParser newChildParser(ElementParser parent, String name, String baseUri) {
            if ("QualityLevel".equals(name)) {
                return new QualityLevelParser(parent, baseUri);
            }
            if ("Protection".equals(name)) {
                return new ProtectionParser(parent, baseUri);
            }
            if ("StreamIndex".equals(name)) {
                return new StreamIndexParser(parent, baseUri);
            }
            return null;
        }

        protected final void putNormalizedAttribute(String key, Object value) {
            this.normalizedAttributes.add(Pair.create(key, value));
        }

        protected final Object getNormalizedAttribute(String key) {
            for (int i = 0; i < this.normalizedAttributes.size(); i++) {
                Pair<String, Object> pair = this.normalizedAttributes.get(i);
                if (((String) pair.first).equals(key)) {
                    return pair.second;
                }
            }
            ElementParser elementParser = this.parent;
            if (elementParser == null) {
                return null;
            }
            return elementParser.getNormalizedAttribute(key);
        }

        protected final String parseRequiredString(XmlPullParser parser, String key) throws MissingFieldException {
            String attributeValue = parser.getAttributeValue(null, key);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(key);
        }

        protected final int parseInt(XmlPullParser parser, String key, int defaultValue) throws ParserException {
            String attributeValue = parser.getAttributeValue(null, key);
            if (attributeValue == null) {
                return defaultValue;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw new ParserException(e);
            }
        }

        protected final int parseRequiredInt(XmlPullParser parser, String key) throws ParserException {
            String attributeValue = parser.getAttributeValue(null, key);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e) {
                    throw new ParserException(e);
                }
            }
            throw new MissingFieldException(key);
        }

        protected final long parseLong(XmlPullParser parser, String key, long defaultValue) throws ParserException {
            String attributeValue = parser.getAttributeValue(null, key);
            if (attributeValue == null) {
                return defaultValue;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e) {
                throw new ParserException(e);
            }
        }

        protected final long parseRequiredLong(XmlPullParser parser, String key) throws ParserException {
            String attributeValue = parser.getAttributeValue(null, key);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e) {
                    throw new ParserException(e);
                }
            }
            throw new MissingFieldException(key);
        }

        protected final boolean parseBoolean(XmlPullParser parser, String key, boolean defaultValue) {
            String attributeValue = parser.getAttributeValue(null, key);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : defaultValue;
        }
    }

    private static class SmoothStreamingMediaParser extends ElementParser {
        private long duration;
        private long dvrWindowLength;
        private boolean isLive;
        private int lookAheadCount;
        private int majorVersion;
        private int minorVersion;
        private SsManifest.ProtectionElement protectionElement;
        private final List<SsManifest.StreamElement> streamElements;
        private long timescale;

        public SmoothStreamingMediaParser(ElementParser parent, String baseUri) {
            super(parent, baseUri, "SmoothStreamingMedia");
            this.lookAheadCount = -1;
            this.protectionElement = null;
            this.streamElements = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser parser) throws ParserException {
            this.majorVersion = parseRequiredInt(parser, "MajorVersion");
            this.minorVersion = parseRequiredInt(parser, "MinorVersion");
            this.timescale = parseLong(parser, "TimeScale", 10000000L);
            this.duration = parseRequiredLong(parser, "Duration");
            this.dvrWindowLength = parseLong(parser, "DVRWindowLength", 0L);
            this.lookAheadCount = parseInt(parser, "LookaheadCount", -1);
            this.isLive = parseBoolean(parser, "IsLive", false);
            putNormalizedAttribute("TimeScale", Long.valueOf(this.timescale));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(Object child) {
            if (child instanceof SsManifest.StreamElement) {
                this.streamElements.add((SsManifest.StreamElement) child);
            } else if (child instanceof SsManifest.ProtectionElement) {
                Assertions.checkState(this.protectionElement == null);
                this.protectionElement = (SsManifest.ProtectionElement) child;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            int size = this.streamElements.size();
            SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
            this.streamElements.toArray(streamElementArr);
            if (this.protectionElement != null) {
                SsManifest.ProtectionElement protectionElement = this.protectionElement;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement.uuid, "video/mp4", protectionElement.data));
                for (int i = 0; i < size; i++) {
                    SsManifest.StreamElement streamElement = streamElementArr[i];
                    int i2 = streamElement.type;
                    if (i2 == 2 || i2 == 1) {
                        Format[] formatArr = streamElement.formats;
                        for (int i3 = 0; i3 < formatArr.length; i3++) {
                            formatArr[i3] = formatArr[i3].copyWithDrmInitData(drmInitData);
                        }
                    }
                }
            }
            return new SsManifest(this.majorVersion, this.minorVersion, this.timescale, this.duration, this.dvrWindowLength, this.lookAheadCount, this.isLive, this.protectionElement, streamElementArr);
        }
    }

    private static class ProtectionParser extends ElementParser {
        private boolean inProtectionHeader;
        private byte[] initData;
        private UUID uuid;

        public ProtectionParser(ElementParser parent, String baseUri) {
            super(parent, baseUri, "Protection");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(String tag) {
            return "ProtectionHeader".equals(tag);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser parser) {
            if ("ProtectionHeader".equals(parser.getName())) {
                this.inProtectionHeader = true;
                this.uuid = UUID.fromString(stripCurlyBraces(parser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseText(XmlPullParser parser) {
            if (this.inProtectionHeader) {
                this.initData = Base64.decode(parser.getText(), 0);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseEndTag(XmlPullParser parser) {
            if ("ProtectionHeader".equals(parser.getName())) {
                this.inProtectionHeader = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            UUID uuid = this.uuid;
            return new SsManifest.ProtectionElement(uuid, PsshAtomUtil.buildPsshAtom(uuid, this.initData), buildTrackEncryptionBoxes(this.initData));
        }

        private static TrackEncryptionBox[] buildTrackEncryptionBoxes(byte[] initData) {
            return new TrackEncryptionBox[]{new TrackEncryptionBox(true, null, 8, getProtectionElementKeyId(initData), 0, 0, null)};
        }

        private static byte[] getProtectionElementKeyId(byte[] initData) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < initData.length; i += 2) {
                sb.append((char) initData[i]);
            }
            String string = sb.toString();
            byte[] bArrDecode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            swap(bArrDecode, 0, 3);
            swap(bArrDecode, 1, 2);
            swap(bArrDecode, 4, 5);
            swap(bArrDecode, 6, 7);
            return bArrDecode;
        }

        private static void swap(byte[] data, int firstPosition, int secondPosition) {
            byte b = data[firstPosition];
            data[firstPosition] = data[secondPosition];
            data[secondPosition] = b;
        }

        private static String stripCurlyBraces(String uuidString) {
            return (uuidString.charAt(0) == '{' && uuidString.charAt(uuidString.length() - 1) == '}') ? uuidString.substring(1, uuidString.length() - 1) : uuidString;
        }
    }

    private static class StreamIndexParser extends ElementParser {
        private final String baseUri;
        private int displayHeight;
        private int displayWidth;
        private final List<Format> formats;
        private String language;
        private long lastChunkDuration;
        private int maxHeight;
        private int maxWidth;
        private String name;
        private ArrayList<Long> startTimes;
        private String subType;
        private long timescale;
        private int type;
        private String url;

        public StreamIndexParser(ElementParser parent, String baseUri) {
            super(parent, baseUri, "StreamIndex");
            this.baseUri = baseUri;
            this.formats = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(String tag) {
            return "c".equals(tag);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser parser) throws ParserException {
            if ("c".equals(parser.getName())) {
                parseStreamFragmentStartTag(parser);
            } else {
                parseStreamElementStartTag(parser);
            }
        }

        private void parseStreamFragmentStartTag(XmlPullParser parser) throws ParserException {
            int size = this.startTimes.size();
            long jLongValue = parseLong(parser, "t", -9223372036854775807L);
            int i = 1;
            if (jLongValue == -9223372036854775807L) {
                if (size == 0) {
                    jLongValue = 0;
                } else if (this.lastChunkDuration != -1) {
                    jLongValue = this.startTimes.get(size - 1).longValue() + this.lastChunkDuration;
                } else {
                    throw new ParserException("Unable to infer start time");
                }
            }
            this.startTimes.add(Long.valueOf(jLongValue));
            this.lastChunkDuration = parseLong(parser, "d", -9223372036854775807L);
            long j = parseLong(parser, "r", 1L);
            if (j > 1 && this.lastChunkDuration == -9223372036854775807L) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j2 = i;
                if (j2 >= j) {
                    return;
                }
                this.startTimes.add(Long.valueOf((this.lastChunkDuration * j2) + jLongValue));
                i++;
            }
        }

        private void parseStreamElementStartTag(XmlPullParser parser) throws ParserException {
            int type = parseType(parser);
            this.type = type;
            putNormalizedAttribute("Type", Integer.valueOf(type));
            if (this.type == 3) {
                this.subType = parseRequiredString(parser, "Subtype");
            } else {
                this.subType = parser.getAttributeValue(null, "Subtype");
            }
            putNormalizedAttribute("Subtype", this.subType);
            this.name = parser.getAttributeValue(null, "Name");
            this.url = parseRequiredString(parser, "Url");
            this.maxWidth = parseInt(parser, "MaxWidth", -1);
            this.maxHeight = parseInt(parser, "MaxHeight", -1);
            this.displayWidth = parseInt(parser, "DisplayWidth", -1);
            this.displayHeight = parseInt(parser, "DisplayHeight", -1);
            String attributeValue = parser.getAttributeValue(null, "Language");
            this.language = attributeValue;
            putNormalizedAttribute("Language", attributeValue);
            long j = parseInt(parser, "TimeScale", -1);
            this.timescale = j;
            if (j == -1) {
                this.timescale = ((Long) getNormalizedAttribute("TimeScale")).longValue();
            }
            this.startTimes = new ArrayList<>();
        }

        private int parseType(XmlPullParser parser) throws ParserException {
            String attributeValue = parser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if (MediaStreamTrack.AUDIO_TRACK_KIND.equalsIgnoreCase(attributeValue)) {
                    return 1;
                }
                if (MediaStreamTrack.VIDEO_TRACK_KIND.equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw new ParserException("Invalid key value[" + attributeValue + "]");
            }
            throw new MissingFieldException("Type");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(Object child) {
            if (child instanceof Format) {
                this.formats.add((Format) child);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            Format[] formatArr = new Format[this.formats.size()];
            this.formats.toArray(formatArr);
            return new SsManifest.StreamElement(this.baseUri, this.url, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.startTimes, this.lastChunkDuration);
        }
    }

    private static class QualityLevelParser extends ElementParser {
        private Format format;

        public QualityLevelParser(ElementParser parent, String baseUri) {
            super(parent, baseUri, "QualityLevel");
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser parser) throws ParserException {
            int iIntValue = ((Integer) getNormalizedAttribute("Type")).intValue();
            String attributeValue = parser.getAttributeValue(null, "Index");
            String str = (String) getNormalizedAttribute("Name");
            int requiredInt = parseRequiredInt(parser, "Bitrate");
            String strFourCCToMimeType = fourCCToMimeType(parseRequiredString(parser, "FourCC"));
            if (iIntValue == 2) {
                this.format = Format.createVideoContainerFormat(attributeValue, str, "video/mp4", strFourCCToMimeType, null, null, requiredInt, parseRequiredInt(parser, "MaxWidth"), parseRequiredInt(parser, "MaxHeight"), -1.0f, buildCodecSpecificData(parser.getAttributeValue(null, "CodecPrivateData")), 0, 0);
                return;
            }
            if (iIntValue != 1) {
                if (iIntValue == 3) {
                    String str2 = (String) getNormalizedAttribute("Subtype");
                    str2.hashCode();
                    this.format = Format.createTextContainerFormat(attributeValue, str, "application/mp4", strFourCCToMimeType, null, requiredInt, 0, !str2.equals("CAPT") ? !str2.equals("DESC") ? 0 : Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : 64, (String) getNormalizedAttribute("Language"));
                    return;
                }
                this.format = Format.createContainerFormat(attributeValue, str, "application/mp4", strFourCCToMimeType, null, requiredInt, 0, 0, null);
                return;
            }
            if (strFourCCToMimeType == null) {
                strFourCCToMimeType = MediaController.AUIDO_MIME_TYPE;
            }
            int requiredInt2 = parseRequiredInt(parser, "Channels");
            int requiredInt3 = parseRequiredInt(parser, "SamplingRate");
            List<byte[]> listBuildCodecSpecificData = buildCodecSpecificData(parser.getAttributeValue(null, "CodecPrivateData"));
            if (listBuildCodecSpecificData.isEmpty() && MediaController.AUIDO_MIME_TYPE.equals(strFourCCToMimeType)) {
                listBuildCodecSpecificData = Collections.singletonList(CodecSpecificDataUtil.buildAacLcAudioSpecificConfig(requiredInt3, requiredInt2));
            }
            this.format = Format.createAudioContainerFormat(attributeValue, str, "audio/mp4", strFourCCToMimeType, null, null, requiredInt, requiredInt2, requiredInt3, listBuildCodecSpecificData, 0, 0, (String) getNormalizedAttribute("Language"));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            return this.format;
        }

        private static List<byte[]> buildCodecSpecificData(String codecSpecificDataString) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(codecSpecificDataString)) {
                byte[] bytesFromHexString = Util.getBytesFromHexString(codecSpecificDataString);
                byte[][] bArrSplitNalUnits = CodecSpecificDataUtil.splitNalUnits(bytesFromHexString);
                if (bArrSplitNalUnits == null) {
                    arrayList.add(bytesFromHexString);
                } else {
                    Collections.addAll(arrayList, bArrSplitNalUnits);
                }
            }
            return arrayList;
        }

        private static String fourCCToMimeType(String fourCC) {
            if (fourCC.equalsIgnoreCase("H264") || fourCC.equalsIgnoreCase("X264") || fourCC.equalsIgnoreCase("AVC1") || fourCC.equalsIgnoreCase("DAVC")) {
                return MediaController.VIDEO_MIME_TYPE;
            }
            if (fourCC.equalsIgnoreCase("AAC") || fourCC.equalsIgnoreCase("AACL") || fourCC.equalsIgnoreCase("AACH") || fourCC.equalsIgnoreCase("AACP")) {
                return MediaController.AUIDO_MIME_TYPE;
            }
            if (fourCC.equalsIgnoreCase("TTML") || fourCC.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (fourCC.equalsIgnoreCase("ac-3") || fourCC.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (fourCC.equalsIgnoreCase("ec-3") || fourCC.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (fourCC.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (fourCC.equalsIgnoreCase("dtsh") || fourCC.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (fourCC.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (fourCC.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }
    }
}
