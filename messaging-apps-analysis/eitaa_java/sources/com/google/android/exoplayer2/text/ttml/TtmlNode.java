package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
final class TtmlNode {
    private List<TtmlNode> children;
    public final long endTimeUs;
    public final String imageId;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    public static TtmlNode buildTextNode(String text) {
        return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(text), -9223372036854775807L, -9223372036854775807L, null, null, "", null);
    }

    public static TtmlNode buildNode(String tag, long startTimeUs, long endTimeUs, TtmlStyle style, String[] styleIds, String regionId, String imageId) {
        return new TtmlNode(tag, null, startTimeUs, endTimeUs, style, styleIds, regionId, imageId);
    }

    private TtmlNode(String tag, String text, long startTimeUs, long endTimeUs, TtmlStyle style, String[] styleIds, String regionId, String imageId) {
        this.tag = tag;
        this.text = text;
        this.imageId = imageId;
        this.style = style;
        this.styleIds = styleIds;
        this.isTextNode = text != null;
        this.startTimeUs = startTimeUs;
        this.endTimeUs = endTimeUs;
        this.regionId = (String) Assertions.checkNotNull(regionId);
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    public boolean isActive(long timeUs) {
        long j = this.startTimeUs;
        return (j == -9223372036854775807L && this.endTimeUs == -9223372036854775807L) || (j <= timeUs && this.endTimeUs == -9223372036854775807L) || ((j == -9223372036854775807L && timeUs < this.endTimeUs) || (j <= timeUs && timeUs < this.endTimeUs));
    }

    public void addChild(TtmlNode child) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(child);
    }

    public TtmlNode getChild(int index) {
        List<TtmlNode> list = this.children;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(index);
    }

    public int getChildCount() {
        List<TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long[] getEventTimesUs() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    private void getEventTimes(TreeSet<Long> out, boolean descendsPNode) {
        boolean zEquals = "p".equals(this.tag);
        boolean zEquals2 = "div".equals(this.tag);
        if (descendsPNode || zEquals || (zEquals2 && this.imageId != null)) {
            long j = this.startTimeUs;
            if (j != -9223372036854775807L) {
                out.add(Long.valueOf(j));
            }
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L) {
                out.add(Long.valueOf(j2));
            }
        }
        if (this.children == null) {
            return;
        }
        for (int i = 0; i < this.children.size(); i++) {
            this.children.get(i).getEventTimes(out, descendsPNode || zEquals);
        }
    }

    public List<Cue> getCues(long timeUs, Map<String, TtmlStyle> globalStyles, Map<String, TtmlRegion> regionMap, Map<String, String> imageMap) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        traverseForImage(timeUs, this.regionId, arrayList);
        TreeMap treeMap = new TreeMap();
        traverseForText(timeUs, false, this.regionId, treeMap);
        traverseForStyle(timeUs, globalStyles, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = imageMap.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                TtmlRegion ttmlRegion = regionMap.get(pair.first);
                arrayList2.add(new Cue(bitmapDecodeByteArray, ttmlRegion.position, 0, ttmlRegion.line, ttmlRegion.lineAnchor, ttmlRegion.width, ttmlRegion.height));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = regionMap.get(entry.getKey());
            arrayList2.add(new Cue(cleanUpText((SpannableStringBuilder) entry.getValue()), (Layout.Alignment) null, ttmlRegion2.line, ttmlRegion2.lineType, ttmlRegion2.lineAnchor, ttmlRegion2.position, Integer.MIN_VALUE, ttmlRegion2.width, ttmlRegion2.textSizeType, ttmlRegion2.textSize));
        }
        return arrayList2;
    }

    private void traverseForImage(long timeUs, String inheritedRegion, List<Pair<String, String>> regionImageList) {
        if (!"".equals(this.regionId)) {
            inheritedRegion = this.regionId;
        }
        if (isActive(timeUs) && "div".equals(this.tag) && this.imageId != null) {
            regionImageList.add(new Pair<>(inheritedRegion, this.imageId));
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChild(i).traverseForImage(timeUs, inheritedRegion, regionImageList);
        }
    }

    private void traverseForText(long timeUs, boolean descendsPNode, String inheritedRegion, Map<String, SpannableStringBuilder> regionOutputs) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if ("metadata".equals(this.tag)) {
            return;
        }
        if (!"".equals(this.regionId)) {
            inheritedRegion = this.regionId;
        }
        if (this.isTextNode && descendsPNode) {
            getRegionOutput(inheritedRegion, regionOutputs).append((CharSequence) this.text);
            return;
        }
        if ("br".equals(this.tag) && descendsPNode) {
            getRegionOutput(inheritedRegion, regionOutputs).append('\n');
            return;
        }
        if (isActive(timeUs)) {
            for (Map.Entry<String, SpannableStringBuilder> entry : regionOutputs.entrySet()) {
                this.nodeStartsByRegion.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
            }
            boolean zEquals = "p".equals(this.tag);
            for (int i = 0; i < getChildCount(); i++) {
                getChild(i).traverseForText(timeUs, descendsPNode || zEquals, inheritedRegion, regionOutputs);
            }
            if (zEquals) {
                TtmlRenderUtil.endParagraph(getRegionOutput(inheritedRegion, regionOutputs));
            }
            for (Map.Entry<String, SpannableStringBuilder> entry2 : regionOutputs.entrySet()) {
                this.nodeEndsByRegion.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    private static SpannableStringBuilder getRegionOutput(String resolvedRegionId, Map<String, SpannableStringBuilder> regionOutputs) {
        if (!regionOutputs.containsKey(resolvedRegionId)) {
            regionOutputs.put(resolvedRegionId, new SpannableStringBuilder());
        }
        return regionOutputs.get(resolvedRegionId);
    }

    private void traverseForStyle(long timeUs, Map<String, TtmlStyle> globalStyles, Map<String, SpannableStringBuilder> regionOutputs) {
        int iIntValue;
        if (isActive(timeUs)) {
            Iterator<Map.Entry<String, Integer>> it = this.nodeEndsByRegion.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                iIntValue = this.nodeStartsByRegion.containsKey(key) ? this.nodeStartsByRegion.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    applyStyleToOutput(globalStyles, regionOutputs.get(key), iIntValue, iIntValue2);
                }
            }
            while (iIntValue < getChildCount()) {
                getChild(iIntValue).traverseForStyle(timeUs, globalStyles, regionOutputs);
                iIntValue++;
            }
        }
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> globalStyles, SpannableStringBuilder regionOutput, int start, int end) {
        TtmlStyle ttmlStyleResolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, globalStyles);
        if (ttmlStyleResolveStyle != null) {
            TtmlRenderUtil.applyStylesToSpan(regionOutput, start, end, ttmlStyleResolveStyle);
        }
    }

    private SpannableStringBuilder cleanUpText(SpannableStringBuilder builder) {
        int i;
        int i2;
        int length = builder.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (builder.charAt(i4) == ' ') {
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < builder.length() && builder.charAt(i6) == ' ') {
                    i6++;
                }
                int i7 = i6 - i5;
                if (i7 > 0) {
                    builder.delete(i4, i4 + i7);
                    length -= i7;
                }
            }
        }
        if (length > 0 && builder.charAt(0) == ' ') {
            builder.delete(0, 1);
            length--;
        }
        int i8 = 0;
        while (true) {
            i = length - 1;
            if (i8 >= i) {
                break;
            }
            if (builder.charAt(i8) == '\n') {
                int i9 = i8 + 1;
                if (builder.charAt(i9) == ' ') {
                    builder.delete(i9, i8 + 2);
                    length--;
                }
            }
            i8++;
        }
        if (length > 0 && builder.charAt(i) == ' ') {
            builder.delete(i, length);
            length--;
        }
        while (true) {
            i2 = length - 1;
            if (i3 >= i2) {
                break;
            }
            if (builder.charAt(i3) == ' ') {
                int i10 = i3 + 1;
                if (builder.charAt(i10) == '\n') {
                    builder.delete(i3, i10);
                    length--;
                }
            }
            i3++;
        }
        if (length > 0 && builder.charAt(i2) == '\n') {
            builder.delete(i2, length);
        }
        return builder;
    }
}
