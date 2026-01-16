package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.linphone.mediastream.Factory;
import org.webrtc.MediaStreamTrack;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    public DashManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public DashManifest parse(Uri uri, InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() != 2 || !"MPD".equals(xmlPullParserNewPullParser.getName())) {
                throw new ParserException("inputStream does not contain a valid media presentation description");
            }
            return parseMediaPresentationDescription(xmlPullParserNewPullParser, uri.toString());
        } catch (XmlPullParserException e) {
            throw new ParserException(e);
        }
    }

    protected DashManifest parseMediaPresentationDescription(XmlPullParser xpp, String baseUrl) throws XmlPullParserException, IOException, NumberFormatException {
        String str;
        long j;
        DashManifestParser dashManifestParser = this;
        long dateTime = parseDateTime(xpp, "availabilityStartTime", -9223372036854775807L);
        long duration = parseDuration(xpp, "mediaPresentationDuration", -9223372036854775807L);
        long duration2 = parseDuration(xpp, "minBufferTime", -9223372036854775807L);
        boolean zEquals = "dynamic".equals(xpp.getAttributeValue(null, "type"));
        long duration3 = zEquals ? parseDuration(xpp, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long duration4 = zEquals ? parseDuration(xpp, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long duration5 = zEquals ? parseDuration(xpp, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long dateTime2 = parseDateTime(xpp, "publishTime", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        Uri uri = null;
        long j2 = zEquals ? -9223372036854775807L : 0L;
        boolean z = false;
        boolean z2 = false;
        String baseUrl2 = baseUrl;
        ProgramInformation programInformation = null;
        UtcTimingElement utcTiming = null;
        while (true) {
            xpp.next();
            long j3 = duration4;
            if (XmlPullParserUtil.isStartTag(xpp, "BaseURL")) {
                if (z) {
                    str = baseUrl2;
                    j = j2;
                    baseUrl2 = str;
                    j2 = j;
                } else {
                    baseUrl2 = dashManifestParser.parseBaseUrl(xpp, baseUrl2);
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xpp, "ProgramInformation")) {
                programInformation = parseProgramInformation(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "UTCTiming")) {
                utcTiming = parseUtcTiming(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "Location")) {
                uri = Uri.parse(xpp.nextText());
            } else if (XmlPullParserUtil.isStartTag(xpp, "Period") && !z2) {
                Pair<Period, Long> period = dashManifestParser.parsePeriod(xpp, baseUrl2, j2);
                String str2 = baseUrl2;
                Period period2 = (Period) period.first;
                long j4 = j2;
                if (period2.startMs != -9223372036854775807L) {
                    long jLongValue = ((Long) period.second).longValue();
                    j2 = jLongValue == -9223372036854775807L ? -9223372036854775807L : period2.startMs + jLongValue;
                    arrayList.add(period2);
                } else {
                    if (!zEquals) {
                        throw new ParserException("Unable to determine start of period " + arrayList.size());
                    }
                    j2 = j4;
                    z2 = true;
                }
                baseUrl2 = str2;
            } else {
                str = baseUrl2;
                j = j2;
                maybeSkipTag(xpp);
                baseUrl2 = str;
                j2 = j;
            }
            if (XmlPullParserUtil.isEndTag(xpp, "MPD")) {
                if (duration == -9223372036854775807L) {
                    if (j2 != -9223372036854775807L) {
                        duration = j2;
                    } else if (!zEquals) {
                        throw new ParserException("Unable to determine duration of static manifest.");
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new ParserException("No periods found.");
                }
                return buildMediaPresentationDescription(dateTime, duration, duration2, zEquals, duration3, j3, duration5, dateTime2, programInformation, utcTiming, uri, arrayList);
            }
            dashManifestParser = this;
            duration4 = j3;
        }
    }

    protected DashManifest buildMediaPresentationDescription(long availabilityStartTime, long durationMs, long minBufferTimeMs, boolean dynamic, long minUpdateTimeMs, long timeShiftBufferDepthMs, long suggestedPresentationDelayMs, long publishTimeMs, ProgramInformation programInformation, UtcTimingElement utcTiming, Uri location, List<Period> periods) {
        return new DashManifest(availabilityStartTime, durationMs, minBufferTimeMs, dynamic, minUpdateTimeMs, timeShiftBufferDepthMs, suggestedPresentationDelayMs, publishTimeMs, programInformation, utcTiming, location, periods);
    }

    protected UtcTimingElement parseUtcTiming(XmlPullParser xpp) {
        return buildUtcTimingElement(xpp.getAttributeValue(null, "schemeIdUri"), xpp.getAttributeValue(null, "value"));
    }

    protected UtcTimingElement buildUtcTimingElement(String schemeIdUri, String value) {
        return new UtcTimingElement(schemeIdUri, value);
    }

    protected Pair<Period, Long> parsePeriod(XmlPullParser xpp, String baseUrl, long defaultStartMs) throws XmlPullParserException, IOException, NumberFormatException {
        String str;
        String attributeValue = xpp.getAttributeValue(null, "id");
        long duration = parseDuration(xpp, "start", defaultStartMs);
        long duration2 = parseDuration(xpp, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String baseUrl2 = baseUrl;
        SegmentBase segmentTemplate = null;
        Descriptor descriptor = null;
        boolean z = false;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "BaseURL")) {
                if (z) {
                    str = baseUrl2;
                } else {
                    baseUrl2 = parseBaseUrl(xpp, baseUrl2);
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xpp, "AdaptationSet")) {
                str = baseUrl2;
                arrayList.add(parseAdaptationSet(xpp, baseUrl2, segmentTemplate, duration2));
            } else {
                str = baseUrl2;
                if (XmlPullParserUtil.isStartTag(xpp, "EventStream")) {
                    arrayList2.add(parseEventStream(xpp));
                } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentBase")) {
                    segmentTemplate = parseSegmentBase(xpp, null);
                } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentList")) {
                    segmentTemplate = parseSegmentList(xpp, null, duration2);
                } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentTemplate")) {
                    segmentTemplate = parseSegmentTemplate(xpp, null, Collections.emptyList(), duration2);
                } else if (XmlPullParserUtil.isStartTag(xpp, "AssetIdentifier")) {
                    descriptor = parseDescriptor(xpp, "AssetIdentifier");
                } else {
                    maybeSkipTag(xpp);
                }
            }
            baseUrl2 = str;
        } while (!XmlPullParserUtil.isEndTag(xpp, "Period"));
        return Pair.create(buildPeriod(attributeValue, duration, arrayList, arrayList2, descriptor), Long.valueOf(duration2));
    }

    protected Period buildPeriod(String id, long startMs, List<AdaptationSet> adaptationSets, List<EventStream> eventStreams, Descriptor assetIdentifier) {
        return new Period(id, startMs, adaptationSets, eventStreams, assetIdentifier);
    }

    protected AdaptationSet parseAdaptationSet(XmlPullParser xpp, String baseUrl, SegmentBase segmentBase, long periodDurationMs) throws XmlPullParserException, NumberFormatException, IOException {
        String str;
        String str2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList<Descriptor> arrayList5;
        ArrayList<DrmInitData.SchemeData> arrayList6;
        String str3;
        String str4;
        DashManifestParser dashManifestParser;
        int iCheckContentTypeConsistency;
        ArrayList arrayList7;
        XmlPullParser xmlPullParser;
        ArrayList<Descriptor> arrayList8;
        SegmentBase segmentTemplate;
        DashManifestParser dashManifestParser2 = this;
        XmlPullParser xmlPullParser2 = xpp;
        int i = parseInt(xmlPullParser2, "id", -1);
        int contentType = parseContentType(xpp);
        String str5 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, "codecs");
        int i2 = parseInt(xmlPullParser2, "width", -1);
        int i3 = parseInt(xmlPullParser2, "height", -1);
        float frameRate = parseFrameRate(xmlPullParser2, -1.0f);
        int i4 = parseInt(xmlPullParser2, "audioSamplingRate", -1);
        String str6 = "lang";
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, "lang");
        String attributeValue4 = xmlPullParser2.getAttributeValue(null, "label");
        ArrayList<DrmInitData.SchemeData> arrayList9 = new ArrayList<>();
        ArrayList<Descriptor> arrayList10 = new ArrayList<>();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        String baseUrl2 = baseUrl;
        SegmentBase segmentBase2 = segmentBase;
        String label = attributeValue4;
        String str7 = null;
        int audioChannelConfiguration = -1;
        boolean z = false;
        int i5 = contentType;
        while (true) {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "BaseURL")) {
                if (!z) {
                    z = true;
                    baseUrl2 = dashManifestParser2.parseBaseUrl(xmlPullParser2, baseUrl2);
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser = xmlPullParser2;
                    dashManifestParser = dashManifestParser2;
                    iCheckContentTypeConsistency = i5;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                }
                str = attributeValue3;
                str2 = baseUrl2;
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = arrayList9;
                str3 = str6;
                str4 = str5;
                xmlPullParser = xmlPullParser2;
                dashManifestParser = dashManifestParser2;
                iCheckContentTypeConsistency = i5;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
                attributeValue3 = str;
                baseUrl2 = str2;
            } else {
                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xpp);
                    Object obj = contentProtection.first;
                    if (obj != null) {
                        str7 = (String) obj;
                    }
                    Object obj2 = contentProtection.second;
                    if (obj2 != null) {
                        arrayList9.add((DrmInitData.SchemeData) obj2);
                    }
                } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "ContentComponent")) {
                    attributeValue3 = checkLanguageConsistency(attributeValue3, xmlPullParser2.getAttributeValue(str5, str6));
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser = xmlPullParser2;
                    dashManifestParser = dashManifestParser2;
                    iCheckContentTypeConsistency = checkContentTypeConsistency(i5, parseContentType(xpp));
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                } else {
                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Role")) {
                        arrayList12.add(parseDescriptor(xmlPullParser2, "Role"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AudioChannelConfiguration")) {
                        audioChannelConfiguration = parseAudioChannelConfiguration(xpp);
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Accessibility")) {
                        arrayList11.add(parseDescriptor(xmlPullParser2, "Accessibility"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "EssentialProperty")) {
                        arrayList13.add(parseDescriptor(xmlPullParser2, "EssentialProperty"));
                    } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SupplementalProperty")) {
                        arrayList14.add(parseDescriptor(xmlPullParser2, "SupplementalProperty"));
                    } else {
                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Representation")) {
                            str = attributeValue3;
                            str2 = baseUrl2;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = arrayList9;
                            str3 = str6;
                            str4 = str5;
                            RepresentationInfo representation = parseRepresentation(xpp, baseUrl2, attributeValue, attributeValue2, i2, i3, frameRate, audioChannelConfiguration, i4, str, arrayList3, arrayList4, arrayList2, arrayList, segmentBase2, periodDurationMs);
                            dashManifestParser = this;
                            int iCheckContentTypeConsistency2 = checkContentTypeConsistency(i5, dashManifestParser.getContentType(representation.format));
                            arrayList7 = arrayList15;
                            arrayList7.add(representation);
                            xmlPullParser = xpp;
                            iCheckContentTypeConsistency = iCheckContentTypeConsistency2;
                        } else {
                            str = attributeValue3;
                            str2 = baseUrl2;
                            arrayList = arrayList14;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList6 = arrayList9;
                            str3 = str6;
                            str4 = str5;
                            dashManifestParser = dashManifestParser2;
                            iCheckContentTypeConsistency = i5;
                            arrayList7 = arrayList15;
                            xmlPullParser = xpp;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                                segmentTemplate = dashManifestParser.parseSegmentBase(xmlPullParser, (SegmentBase.SingleSegmentBase) segmentBase2);
                            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                                segmentTemplate = dashManifestParser.parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) segmentBase2, periodDurationMs);
                            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                                segmentTemplate = parseSegmentTemplate(xpp, (SegmentBase.SegmentTemplate) segmentBase2, arrayList, periodDurationMs);
                            } else {
                                if (XmlPullParserUtil.isStartTag(xmlPullParser, "InbandEventStream")) {
                                    arrayList8 = arrayList5;
                                    arrayList8.add(parseDescriptor(xmlPullParser, "InbandEventStream"));
                                } else {
                                    arrayList8 = arrayList5;
                                    if (XmlPullParserUtil.isStartTag(xmlPullParser, "Label")) {
                                        label = parseLabel(xpp);
                                    } else if (XmlPullParserUtil.isStartTag(xpp)) {
                                        parseAdaptationSetChild(xpp);
                                    }
                                }
                                attributeValue3 = str;
                                baseUrl2 = str2;
                            }
                            segmentBase2 = segmentTemplate;
                        }
                        attributeValue3 = str;
                        baseUrl2 = str2;
                        arrayList8 = arrayList5;
                    }
                    str = attributeValue3;
                    str2 = baseUrl2;
                    arrayList = arrayList14;
                    arrayList2 = arrayList13;
                    arrayList3 = arrayList12;
                    arrayList4 = arrayList11;
                    arrayList6 = arrayList9;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser = xmlPullParser2;
                    dashManifestParser = dashManifestParser2;
                    iCheckContentTypeConsistency = i5;
                    arrayList7 = arrayList15;
                    arrayList8 = arrayList10;
                    attributeValue3 = str;
                    baseUrl2 = str2;
                }
                arrayList = arrayList14;
                arrayList2 = arrayList13;
                arrayList3 = arrayList12;
                arrayList4 = arrayList11;
                arrayList6 = arrayList9;
                str3 = str6;
                str4 = str5;
                xmlPullParser = xmlPullParser2;
                dashManifestParser = dashManifestParser2;
                iCheckContentTypeConsistency = i5;
                arrayList7 = arrayList15;
                arrayList8 = arrayList10;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "AdaptationSet")) {
                break;
            }
            i5 = iCheckContentTypeConsistency;
            dashManifestParser2 = dashManifestParser;
            arrayList15 = arrayList7;
            xmlPullParser2 = xmlPullParser;
            arrayList10 = arrayList8;
            arrayList14 = arrayList;
            arrayList13 = arrayList2;
            arrayList12 = arrayList3;
            arrayList11 = arrayList4;
            arrayList9 = arrayList6;
            str6 = str3;
            str5 = str4;
        }
        ArrayList arrayList16 = new ArrayList(arrayList7.size());
        for (int i6 = 0; i6 < arrayList7.size(); i6++) {
            arrayList16.add(buildRepresentation((RepresentationInfo) arrayList7.get(i6), label, str7, arrayList6, arrayList8));
        }
        return buildAdaptationSet(i, iCheckContentTypeConsistency, arrayList16, arrayList4, arrayList2, arrayList);
    }

    protected AdaptationSet buildAdaptationSet(int id, int contentType, List<Representation> representations, List<Descriptor> accessibilityDescriptors, List<Descriptor> essentialProperties, List<Descriptor> supplementalProperties) {
        return new AdaptationSet(id, contentType, representations, accessibilityDescriptors, essentialProperties, supplementalProperties);
    }

    protected int parseContentType(XmlPullParser xpp) {
        String attributeValue = xpp.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MediaStreamTrack.AUDIO_TRACK_KIND.equals(attributeValue)) {
            return 1;
        }
        if (MediaStreamTrack.VIDEO_TRACK_KIND.equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    protected int getContentType(Format format) {
        String str = format.sampleMimeType;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (MimeTypes.isVideo(str)) {
            return 2;
        }
        if (MimeTypes.isAudio(str)) {
            return 1;
        }
        return mimeTypeIsRawText(str) ? 3 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ee  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.UUID] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseContentProtection(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    protected void parseAdaptationSetChild(XmlPullParser xpp) throws XmlPullParserException, IOException {
        maybeSkipTag(xpp);
    }

    protected RepresentationInfo parseRepresentation(XmlPullParser xpp, String baseUrl, String adaptationSetMimeType, String adaptationSetCodecs, int adaptationSetWidth, int adaptationSetHeight, float adaptationSetFrameRate, int adaptationSetAudioChannels, int adaptationSetAudioSamplingRate, String adaptationSetLanguage, List<Descriptor> adaptationSetRoleDescriptors, List<Descriptor> adaptationSetAccessibilityDescriptors, List<Descriptor> adaptationSetEssentialProperties, List<Descriptor> adaptationSetSupplementalProperties, SegmentBase segmentBase, long periodDurationMs) throws XmlPullParserException, NumberFormatException, IOException {
        int i;
        int i2;
        String str;
        SegmentBase segmentTemplate;
        int audioChannelConfiguration;
        String str2;
        String attributeValue = xpp.getAttributeValue(null, "id");
        int i3 = parseInt(xpp, "bandwidth", -1);
        String string = parseString(xpp, "mimeType", adaptationSetMimeType);
        String string2 = parseString(xpp, "codecs", adaptationSetCodecs);
        int i4 = parseInt(xpp, "width", adaptationSetWidth);
        int i5 = parseInt(xpp, "height", adaptationSetHeight);
        float frameRate = parseFrameRate(xpp, adaptationSetFrameRate);
        int i6 = parseInt(xpp, "audioSamplingRate", adaptationSetAudioSamplingRate);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(adaptationSetEssentialProperties);
        ArrayList arrayList4 = new ArrayList(adaptationSetSupplementalProperties);
        int i7 = adaptationSetAudioChannels;
        SegmentBase segmentBase2 = segmentBase;
        String str3 = null;
        boolean z = false;
        String baseUrl2 = baseUrl;
        while (true) {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "BaseURL")) {
                if (z) {
                    str = baseUrl2;
                    i = i6;
                    i2 = i3;
                    audioChannelConfiguration = i7;
                    str2 = str;
                } else {
                    baseUrl2 = parseBaseUrl(xpp, baseUrl2);
                    i = i6;
                    i2 = i3;
                    audioChannelConfiguration = i7;
                    z = true;
                    str2 = baseUrl2;
                }
            } else if (XmlPullParserUtil.isStartTag(xpp, "AudioChannelConfiguration")) {
                audioChannelConfiguration = parseAudioChannelConfiguration(xpp);
                str2 = baseUrl2;
                i = i6;
                i2 = i3;
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentBase")) {
                i = i6;
                i2 = i3;
                segmentBase2 = parseSegmentBase(xpp, (SegmentBase.SingleSegmentBase) segmentBase2);
                audioChannelConfiguration = i7;
                str2 = baseUrl2;
            } else {
                if (XmlPullParserUtil.isStartTag(xpp, "SegmentList")) {
                    i = i6;
                    i2 = i3;
                    segmentTemplate = parseSegmentList(xpp, (SegmentBase.SegmentList) segmentBase2, periodDurationMs);
                } else {
                    i = i6;
                    i2 = i3;
                    if (XmlPullParserUtil.isStartTag(xpp, "SegmentTemplate")) {
                        segmentTemplate = parseSegmentTemplate(xpp, (SegmentBase.SegmentTemplate) segmentBase2, adaptationSetSupplementalProperties, periodDurationMs);
                    } else {
                        if (XmlPullParserUtil.isStartTag(xpp, "ContentProtection")) {
                            Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xpp);
                            str = baseUrl2;
                            Object obj = contentProtection.first;
                            if (obj != null) {
                                str3 = (String) obj;
                            }
                            Object obj2 = contentProtection.second;
                            if (obj2 != null) {
                                arrayList.add((DrmInitData.SchemeData) obj2);
                            }
                        } else {
                            str = baseUrl2;
                            if (XmlPullParserUtil.isStartTag(xpp, "InbandEventStream")) {
                                arrayList2.add(parseDescriptor(xpp, "InbandEventStream"));
                            } else if (XmlPullParserUtil.isStartTag(xpp, "EssentialProperty")) {
                                arrayList3.add(parseDescriptor(xpp, "EssentialProperty"));
                            } else if (XmlPullParserUtil.isStartTag(xpp, "SupplementalProperty")) {
                                arrayList4.add(parseDescriptor(xpp, "SupplementalProperty"));
                            } else {
                                maybeSkipTag(xpp);
                            }
                        }
                        audioChannelConfiguration = i7;
                        str2 = str;
                    }
                }
                segmentBase2 = segmentTemplate;
                audioChannelConfiguration = i7;
                str2 = baseUrl2;
            }
            if (XmlPullParserUtil.isEndTag(xpp, "Representation")) {
                break;
            }
            i6 = i;
            baseUrl2 = str2;
            i3 = i2;
            i7 = audioChannelConfiguration;
        }
        return new RepresentationInfo(buildFormat(attributeValue, string, i4, i5, frameRate, audioChannelConfiguration, i, i2, adaptationSetLanguage, adaptationSetRoleDescriptors, adaptationSetAccessibilityDescriptors, string2, arrayList3, arrayList4), str2, segmentBase2 != null ? segmentBase2 : new SegmentBase.SingleSegmentBase(), str3, arrayList, arrayList2, -1L);
    }

    protected Format buildFormat(String id, String containerMimeType, int width, int height, float frameRate, int audioChannels, int audioSamplingRate, int bitrate, String language, List<Descriptor> roleDescriptors, List<Descriptor> accessibilityDescriptors, String codecs, List<Descriptor> essentialProperties, List<Descriptor> supplementalProperties) {
        String str;
        int i;
        int cea708AccessibilityChannel;
        String sampleMimeType = getSampleMimeType(containerMimeType, codecs);
        int selectionFlagsFromRoleDescriptors = parseSelectionFlagsFromRoleDescriptors(roleDescriptors);
        int roleFlagsFromRoleDescriptors = parseRoleFlagsFromRoleDescriptors(roleDescriptors) | parseRoleFlagsFromAccessibilityDescriptors(accessibilityDescriptors) | parseRoleFlagsFromProperties(essentialProperties) | parseRoleFlagsFromProperties(supplementalProperties);
        if (sampleMimeType != null) {
            String eac3SupplementalProperties = "audio/eac3".equals(sampleMimeType) ? parseEac3SupplementalProperties(supplementalProperties) : sampleMimeType;
            if (MimeTypes.isVideo(eac3SupplementalProperties)) {
                return Format.createVideoContainerFormat(id, null, containerMimeType, eac3SupplementalProperties, codecs, null, bitrate, width, height, frameRate, null, selectionFlagsFromRoleDescriptors, roleFlagsFromRoleDescriptors);
            }
            if (MimeTypes.isAudio(eac3SupplementalProperties)) {
                return Format.createAudioContainerFormat(id, null, containerMimeType, eac3SupplementalProperties, codecs, null, bitrate, audioChannels, audioSamplingRate, null, selectionFlagsFromRoleDescriptors, roleFlagsFromRoleDescriptors, language);
            }
            if (mimeTypeIsRawText(eac3SupplementalProperties)) {
                if ("application/cea-608".equals(eac3SupplementalProperties)) {
                    cea708AccessibilityChannel = parseCea608AccessibilityChannel(accessibilityDescriptors);
                } else if ("application/cea-708".equals(eac3SupplementalProperties)) {
                    cea708AccessibilityChannel = parseCea708AccessibilityChannel(accessibilityDescriptors);
                } else {
                    i = -1;
                    return Format.createTextContainerFormat(id, null, containerMimeType, eac3SupplementalProperties, codecs, bitrate, selectionFlagsFromRoleDescriptors, roleFlagsFromRoleDescriptors, language, i);
                }
                i = cea708AccessibilityChannel;
                return Format.createTextContainerFormat(id, null, containerMimeType, eac3SupplementalProperties, codecs, bitrate, selectionFlagsFromRoleDescriptors, roleFlagsFromRoleDescriptors, language, i);
            }
            str = eac3SupplementalProperties;
        } else {
            str = sampleMimeType;
        }
        return Format.createContainerFormat(id, null, containerMimeType, str, codecs, bitrate, selectionFlagsFromRoleDescriptors, roleFlagsFromRoleDescriptors, language);
    }

    protected Representation buildRepresentation(RepresentationInfo representationInfo, String label, String extraDrmSchemeType, ArrayList<DrmInitData.SchemeData> extraDrmSchemeDatas, ArrayList<Descriptor> extraInbandEventStreams) {
        Format formatCopyWithDrmInitData = representationInfo.format;
        if (label != null) {
            formatCopyWithDrmInitData = formatCopyWithDrmInitData.copyWithLabel(label);
        }
        String str = representationInfo.drmSchemeType;
        if (str != null) {
            extraDrmSchemeType = str;
        }
        ArrayList<DrmInitData.SchemeData> arrayList = representationInfo.drmSchemeDatas;
        arrayList.addAll(extraDrmSchemeDatas);
        if (!arrayList.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList);
            formatCopyWithDrmInitData = formatCopyWithDrmInitData.copyWithDrmInitData(new DrmInitData(extraDrmSchemeType, arrayList));
        }
        ArrayList<Descriptor> arrayList2 = representationInfo.inbandEventStreams;
        arrayList2.addAll(extraInbandEventStreams);
        return Representation.newInstance(representationInfo.revisionId, formatCopyWithDrmInitData, representationInfo.baseUrl, representationInfo.segmentBase, arrayList2);
    }

    protected SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xpp, SegmentBase.SingleSegmentBase parent) throws XmlPullParserException, NumberFormatException, IOException {
        long j;
        long j2;
        long j3 = parseLong(xpp, "timescale", parent != null ? parent.timescale : 1L);
        long j4 = parseLong(xpp, "presentationTimeOffset", parent != null ? parent.presentationTimeOffset : 0L);
        long j5 = parent != null ? parent.indexStart : 0L;
        long j6 = parent != null ? parent.indexLength : 0L;
        String attributeValue = xpp.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            long j7 = Long.parseLong(strArrSplit[0]);
            j = (Long.parseLong(strArrSplit[1]) - j7) + 1;
            j2 = j7;
        } else {
            j = j6;
            j2 = j5;
        }
        RangedUri initialization = parent != null ? parent.initialization : null;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Initialization")) {
                initialization = parseInitialization(xpp);
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentBase"));
        return buildSingleSegmentBase(initialization, j3, j4, j2, j);
    }

    protected SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri initialization, long timescale, long presentationTimeOffset, long indexStart, long indexLength) {
        return new SegmentBase.SingleSegmentBase(initialization, timescale, presentationTimeOffset, indexStart, indexLength);
    }

    protected SegmentBase.SegmentList parseSegmentList(XmlPullParser xpp, SegmentBase.SegmentList parent, long periodDurationMs) throws XmlPullParserException, IOException {
        long j = parseLong(xpp, "timescale", parent != null ? parent.timescale : 1L);
        long j2 = parseLong(xpp, "presentationTimeOffset", parent != null ? parent.presentationTimeOffset : 0L);
        long j3 = parseLong(xpp, "duration", parent != null ? parent.duration : -9223372036854775807L);
        long j4 = parseLong(xpp, "startNumber", parent != null ? parent.startNumber : 1L);
        List<SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        List<RangedUri> arrayList = null;
        RangedUri initialization = null;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Initialization")) {
                initialization = parseInitialization(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xpp, j, periodDurationMs);
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(parseSegmentUrl(xpp));
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentList"));
        if (parent != null) {
            if (initialization == null) {
                initialization = parent.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = parent.segmentTimeline;
            }
            if (arrayList == null) {
                arrayList = parent.mediaSegments;
            }
        }
        return buildSegmentList(initialization, j, j2, j4, j3, segmentTimeline, arrayList);
    }

    protected SegmentBase.SegmentList buildSegmentList(RangedUri initialization, long timescale, long presentationTimeOffset, long startNumber, long duration, List<SegmentBase.SegmentTimelineElement> timeline, List<RangedUri> segments) {
        return new SegmentBase.SegmentList(initialization, timescale, presentationTimeOffset, startNumber, duration, timeline, segments);
    }

    protected SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xpp, SegmentBase.SegmentTemplate parent, List<Descriptor> adaptationSetSupplementalProperties, long periodDurationMs) throws XmlPullParserException, IOException {
        long j = parseLong(xpp, "timescale", parent != null ? parent.timescale : 1L);
        long j2 = parseLong(xpp, "presentationTimeOffset", parent != null ? parent.presentationTimeOffset : 0L);
        long j3 = parseLong(xpp, "duration", parent != null ? parent.duration : -9223372036854775807L);
        long j4 = parseLong(xpp, "startNumber", parent != null ? parent.startNumber : 1L);
        long lastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(adaptationSetSupplementalProperties);
        List<SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        UrlTemplate urlTemplate = parseUrlTemplate(xpp, "media", parent != null ? parent.mediaTemplate : null);
        UrlTemplate urlTemplate2 = parseUrlTemplate(xpp, "initialization", parent != null ? parent.initializationTemplate : null);
        RangedUri initialization = null;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Initialization")) {
                initialization = parseInitialization(xpp);
            } else if (XmlPullParserUtil.isStartTag(xpp, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xpp, j, periodDurationMs);
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentTemplate"));
        if (parent != null) {
            if (initialization == null) {
                initialization = parent.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = parent.segmentTimeline;
            }
        }
        return buildSegmentTemplate(initialization, j, j2, j4, lastSegmentNumberSupplementalProperty, j3, segmentTimeline, urlTemplate2, urlTemplate);
    }

    protected SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri initialization, long timescale, long presentationTimeOffset, long startNumber, long endNumber, long duration, List<SegmentBase.SegmentTimelineElement> timeline, UrlTemplate initializationTemplate, UrlTemplate mediaTemplate) {
        return new SegmentBase.SegmentTemplate(initialization, timescale, presentationTimeOffset, startNumber, endNumber, duration, timeline, initializationTemplate, mediaTemplate);
    }

    protected EventStream parseEventStream(XmlPullParser xpp) throws XmlPullParserException, IOException {
        String string = parseString(xpp, "schemeIdUri", "");
        String string2 = parseString(xpp, "value", "");
        long j = parseLong(xpp, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Factory.DEVICE_USE_ANDROID_CAMCORDER);
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Event")) {
                arrayList.add(parseEvent(xpp, string, string2, j, byteArrayOutputStream));
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return buildEventStream(string, string2, j, jArr, eventMessageArr);
    }

    protected EventStream buildEventStream(String schemeIdUri, String value, long timescale, long[] presentationTimesUs, EventMessage[] events) {
        return new EventStream(schemeIdUri, value, timescale, presentationTimesUs, events);
    }

    protected Pair<Long, EventMessage> parseEvent(XmlPullParser xpp, String schemeIdUri, String value, long timescale, ByteArrayOutputStream scratchOutputStream) throws XmlPullParserException, IllegalStateException, IOException, IllegalArgumentException {
        long j = parseLong(xpp, "id", 0L);
        long j2 = parseLong(xpp, "duration", -9223372036854775807L);
        long j3 = parseLong(xpp, "presentationTime", 0L);
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j2, 1000L, timescale);
        long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(j3, 1000000L, timescale);
        String string = parseString(xpp, "messageData", null);
        byte[] eventObject = parseEventObject(xpp, scratchOutputStream);
        Long lValueOf = Long.valueOf(jScaleLargeTimestamp2);
        if (string != null) {
            eventObject = Util.getUtf8Bytes(string);
        }
        return Pair.create(lValueOf, buildEvent(schemeIdUri, value, j, jScaleLargeTimestamp, eventObject));
    }

    protected byte[] parseEventObject(XmlPullParser xpp, ByteArrayOutputStream scratchOutputStream) throws XmlPullParserException, IllegalStateException, IOException, IllegalArgumentException {
        scratchOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(scratchOutputStream, "UTF-8");
        xpp.nextToken();
        while (!XmlPullParserUtil.isEndTag(xpp, "Event")) {
            switch (xpp.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xpp.getNamespace(), xpp.getName());
                    for (int i = 0; i < xpp.getAttributeCount(); i++) {
                        xmlSerializerNewSerializer.attribute(xpp.getAttributeNamespace(i), xpp.getAttributeName(i), xpp.getAttributeValue(i));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xpp.getNamespace(), xpp.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xpp.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xpp.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xpp.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xpp.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xpp.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xpp.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xpp.getText());
                    break;
            }
            xpp.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return scratchOutputStream.toByteArray();
    }

    protected EventMessage buildEvent(String schemeIdUri, String value, long id, long durationMs, byte[] messageData) {
        return new EventMessage(schemeIdUri, value, durationMs, id, messageData);
    }

    protected List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xpp, long timescale, long periodDurationMs) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jAddSegmentTimelineElementsToList = 0;
        long j = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "S")) {
                long j2 = parseLong(xpp, "t", -9223372036854775807L);
                if (z) {
                    jAddSegmentTimelineElementsToList = addSegmentTimelineElementsToList(arrayList, jAddSegmentTimelineElementsToList, j, i, j2);
                }
                if (j2 == -9223372036854775807L) {
                    j2 = jAddSegmentTimelineElementsToList;
                }
                j = parseLong(xpp, "d", -9223372036854775807L);
                i = parseInt(xpp, "r", 0);
                jAddSegmentTimelineElementsToList = j2;
                z = true;
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, "SegmentTimeline"));
        if (z) {
            addSegmentTimelineElementsToList(arrayList, jAddSegmentTimelineElementsToList, j, i, Util.scaleLargeTimestamp(periodDurationMs, timescale, 1000L));
        }
        return arrayList;
    }

    private long addSegmentTimelineElementsToList(List<SegmentBase.SegmentTimelineElement> segmentTimeline, long startTime, long elementDuration, int elementRepeatCount, long endTime) {
        int iCeilDivide = elementRepeatCount >= 0 ? elementRepeatCount + 1 : (int) Util.ceilDivide(endTime - startTime, elementDuration);
        for (int i = 0; i < iCeilDivide; i++) {
            segmentTimeline.add(buildSegmentTimelineElement(startTime, elementDuration));
            startTime += elementDuration;
        }
        return startTime;
    }

    protected SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long startTime, long duration) {
        return new SegmentBase.SegmentTimelineElement(startTime, duration);
    }

    protected UrlTemplate parseUrlTemplate(XmlPullParser xpp, String name, UrlTemplate defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue != null ? UrlTemplate.compile(attributeValue) : defaultValue;
    }

    protected RangedUri parseInitialization(XmlPullParser xpp) {
        return parseRangedUrl(xpp, "sourceURL", "range");
    }

    protected RangedUri parseSegmentUrl(XmlPullParser xpp) {
        return parseRangedUrl(xpp, "media", "mediaRange");
    }

    protected RangedUri parseRangedUrl(XmlPullParser xpp, String urlAttribute, String rangeAttribute) throws NumberFormatException {
        long j;
        long j2;
        String attributeValue = xpp.getAttributeValue(null, urlAttribute);
        String attributeValue2 = xpp.getAttributeValue(null, rangeAttribute);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
            return buildRangedUri(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return buildRangedUri(attributeValue, j, j2);
    }

    protected RangedUri buildRangedUri(String urlText, long rangeStart, long rangeLength) {
        return new RangedUri(urlText, rangeStart, rangeLength);
    }

    protected ProgramInformation parseProgramInformation(XmlPullParser xpp) throws XmlPullParserException, IOException {
        String strNextText = null;
        String string = parseString(xpp, "moreInformationURL", null);
        String string2 = parseString(xpp, "lang", null);
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            xpp.next();
            if (XmlPullParserUtil.isStartTag(xpp, "Title")) {
                strNextText = xpp.nextText();
            } else if (XmlPullParserUtil.isStartTag(xpp, "Source")) {
                strNextText2 = xpp.nextText();
            } else if (XmlPullParserUtil.isStartTag(xpp, "Copyright")) {
                strNextText3 = xpp.nextText();
            } else {
                maybeSkipTag(xpp);
            }
            String str = strNextText3;
            if (XmlPullParserUtil.isEndTag(xpp, "ProgramInformation")) {
                return new ProgramInformation(strNextText, strNextText2, str, string, string2);
            }
            strNextText3 = str;
        }
    }

    protected String parseLabel(XmlPullParser xpp) throws XmlPullParserException, IOException {
        return parseText(xpp, "Label");
    }

    protected String parseBaseUrl(XmlPullParser xpp, String parentBaseUrl) throws XmlPullParserException, IOException {
        return UriUtil.resolve(parentBaseUrl, parseText(xpp, "BaseURL"));
    }

    protected int parseAudioChannelConfiguration(XmlPullParser xpp) throws XmlPullParserException, IOException {
        String string = parseString(xpp, "schemeIdUri", null);
        int dolbyChannelConfiguration = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseInt(xpp, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(string) || "urn:dolby:dash:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseDolbyChannelConfiguration(xpp);
        }
        do {
            xpp.next();
        } while (!XmlPullParserUtil.isEndTag(xpp, "AudioChannelConfiguration"));
        return dolbyChannelConfiguration;
    }

    protected int parseSelectionFlagsFromRoleDescriptors(List<Descriptor> roleDescriptors) {
        for (int i = 0; i < roleDescriptors.size(); i++) {
            Descriptor descriptor = roleDescriptors.get(i);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri) && "main".equals(descriptor.value)) {
                return 1;
            }
        }
        return 0;
    }

    protected int parseRoleFlagsFromRoleDescriptors(List<Descriptor> roleDescriptors) {
        int dashRoleSchemeValue = 0;
        for (int i = 0; i < roleDescriptors.size(); i++) {
            Descriptor descriptor = roleDescriptors.get(i);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                dashRoleSchemeValue |= parseDashRoleSchemeValue(descriptor.value);
            }
        }
        return dashRoleSchemeValue;
    }

    protected int parseRoleFlagsFromAccessibilityDescriptors(List<Descriptor> accessibilityDescriptors) {
        int tvaAudioPurposeCsValue;
        int i = 0;
        for (int i2 = 0; i2 < accessibilityDescriptors.size(); i2++) {
            Descriptor descriptor = accessibilityDescriptors.get(i2);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(descriptor.schemeIdUri)) {
                tvaAudioPurposeCsValue = parseDashRoleSchemeValue(descriptor.value);
            } else if ("urn:tva:metadata:cs:AudioPurposeCS:2007".equalsIgnoreCase(descriptor.schemeIdUri)) {
                tvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i |= tvaAudioPurposeCsValue;
        }
        return i;
    }

    protected int parseRoleFlagsFromProperties(List<Descriptor> accessibilityDescriptors) {
        int i = 0;
        for (int i2 = 0; i2 < accessibilityDescriptors.size(); i2++) {
            if ("http://dashif.org/guidelines/trickmode".equalsIgnoreCase(accessibilityDescriptors.get(i2).schemeIdUri)) {
                i |= 16384;
            }
        }
        return i;
    }

    protected int parseDashRoleSchemeValue(String value) {
        if (value == null) {
            return 0;
        }
        switch (value) {
        }
        return 0;
    }

    protected int parseTvaAudioPurposeCsValue(String value) {
        if (value == null) {
            return 0;
        }
        switch (value) {
        }
        return 0;
    }

    public static void maybeSkipTag(XmlPullParser xpp) throws XmlPullParserException, IOException {
        if (XmlPullParserUtil.isStartTag(xpp)) {
            int i = 1;
            while (i != 0) {
                xpp.next();
                if (XmlPullParserUtil.isStartTag(xpp)) {
                    i++;
                } else if (XmlPullParserUtil.isEndTag(xpp)) {
                    i--;
                }
            }
        }
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> schemeDatas) {
        for (int size = schemeDatas.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = schemeDatas.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= schemeDatas.size()) {
                        break;
                    }
                    if (schemeDatas.get(i).canReplace(schemeData)) {
                        schemeDatas.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    private static String getSampleMimeType(String containerMimeType, String codecs) {
        if (MimeTypes.isAudio(containerMimeType)) {
            return MimeTypes.getAudioMediaMimeType(codecs);
        }
        if (MimeTypes.isVideo(containerMimeType)) {
            return MimeTypes.getVideoMediaMimeType(codecs);
        }
        if (mimeTypeIsRawText(containerMimeType)) {
            return containerMimeType;
        }
        if ("application/mp4".equals(containerMimeType)) {
            if (codecs != null) {
                if (codecs.startsWith("stpp")) {
                    return "application/ttml+xml";
                }
                if (codecs.startsWith("wvtt")) {
                    return "application/x-mp4-vtt";
                }
            }
        } else if ("application/x-rawcc".equals(containerMimeType) && codecs != null) {
            if (codecs.contains("cea708")) {
                return "application/cea-708";
            }
            if (codecs.contains("eia608") || codecs.contains("cea608")) {
                return "application/cea-608";
            }
        }
        return null;
    }

    private static boolean mimeTypeIsRawText(String mimeType) {
        return MimeTypes.isText(mimeType) || "application/ttml+xml".equals(mimeType) || "application/x-mp4-vtt".equals(mimeType) || "application/cea-708".equals(mimeType) || "application/cea-608".equals(mimeType);
    }

    private static String checkLanguageConsistency(String firstLanguage, String secondLanguage) {
        if (firstLanguage == null) {
            return secondLanguage;
        }
        if (secondLanguage == null) {
            return firstLanguage;
        }
        Assertions.checkState(firstLanguage.equals(secondLanguage));
        return firstLanguage;
    }

    private static int checkContentTypeConsistency(int firstType, int secondType) {
        if (firstType == -1) {
            return secondType;
        }
        if (secondType == -1) {
            return firstType;
        }
        Assertions.checkState(firstType == secondType);
        return firstType;
    }

    protected static Descriptor parseDescriptor(XmlPullParser xpp, String tag) throws XmlPullParserException, IOException {
        String string = parseString(xpp, "schemeIdUri", "");
        String string2 = parseString(xpp, "value", null);
        String string3 = parseString(xpp, "id", null);
        do {
            xpp.next();
        } while (!XmlPullParserUtil.isEndTag(xpp, tag));
        return new Descriptor(string, string2, string3);
    }

    protected static int parseCea608AccessibilityChannel(List<Descriptor> accessibilityDescriptors) {
        String str;
        for (int i = 0; i < accessibilityDescriptors.size(); i++) {
            Descriptor descriptor = accessibilityDescriptors.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static int parseCea708AccessibilityChannel(List<Descriptor> accessibilityDescriptors) {
        String str;
        for (int i = 0; i < accessibilityDescriptors.size(); i++) {
            Descriptor descriptor = accessibilityDescriptors.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static String parseEac3SupplementalProperties(List<Descriptor> supplementalProperties) {
        for (int i = 0; i < supplementalProperties.size(); i++) {
            Descriptor descriptor = supplementalProperties.get(i);
            String str = descriptor.schemeIdUri;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float parseFrameRate(XmlPullParser xpp, float defaultValue) throws NumberFormatException {
        String attributeValue = xpp.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return defaultValue;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return defaultValue;
        }
        int i = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? i / Integer.parseInt(r2) : i;
    }

    protected static long parseDuration(XmlPullParser xpp, String name, long defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(XmlPullParser xpp, String name, long defaultValue) throws ParserException {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Util.parseXsDateTime(attributeValue);
    }

    protected static String parseText(XmlPullParser xpp, String label) throws XmlPullParserException, IOException {
        String text = "";
        do {
            xpp.next();
            if (xpp.getEventType() == 4) {
                text = xpp.getText();
            } else {
                maybeSkipTag(xpp);
            }
        } while (!XmlPullParserUtil.isEndTag(xpp, label));
        return text;
    }

    protected static int parseInt(XmlPullParser xpp, String name, int defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Integer.parseInt(attributeValue);
    }

    protected static long parseLong(XmlPullParser xpp, String name, long defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : Long.parseLong(attributeValue);
    }

    protected static String parseString(XmlPullParser xpp, String name, String defaultValue) {
        String attributeValue = xpp.getAttributeValue(null, name);
        return attributeValue == null ? defaultValue : attributeValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 0
            java.lang.String r1 = "value"
            java.lang.String r4 = r4.getAttributeValue(r0, r1)
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.toLowerInvariant(r4)
            r0 = -1
            if (r4 != 0) goto L10
            return r0
        L10:
            int r1 = r4.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case 1596796: goto L3c;
                case 2937391: goto L31;
                case 3094035: goto L26;
                case 3133436: goto L1b;
                default: goto L19;
            }
        L19:
            r4 = -1
            goto L46
        L1b:
            java.lang.String r1 = "fa01"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L24
            goto L19
        L24:
            r4 = 3
            goto L46
        L26:
            java.lang.String r1 = "f801"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L2f
            goto L19
        L2f:
            r4 = 2
            goto L46
        L31:
            java.lang.String r1 = "a000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L3a
            goto L19
        L3a:
            r4 = 1
            goto L46
        L3c:
            java.lang.String r1 = "4000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L45
            goto L19
        L45:
            r4 = 0
        L46:
            switch(r4) {
                case 0: goto L50;
                case 1: goto L4f;
                case 2: goto L4d;
                case 3: goto L4a;
                default: goto L49;
            }
        L49:
            return r0
        L4a:
            r4 = 8
            return r4
        L4d:
            r4 = 6
            return r4
        L4f:
            return r2
        L50:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static long parseLastSegmentNumberSupplementalProperty(List<Descriptor> supplementalProperties) {
        for (int i = 0; i < supplementalProperties.size(); i++) {
            Descriptor descriptor = supplementalProperties.get(i);
            if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(descriptor.schemeIdUri)) {
                return Long.parseLong(descriptor.value);
            }
        }
        return -1L;
    }

    protected static final class RepresentationInfo {
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format, String baseUrl, SegmentBase segmentBase, String drmSchemeType, ArrayList<DrmInitData.SchemeData> drmSchemeDatas, ArrayList<Descriptor> inbandEventStreams, long revisionId) {
            this.format = format;
            this.baseUrl = baseUrl;
            this.segmentBase = segmentBase;
            this.drmSchemeType = drmSchemeType;
            this.drmSchemeDatas = drmSchemeDatas;
            this.inbandEventStreams = inbandEventStreams;
            this.revisionId = revisionId;
        }
    }
}
