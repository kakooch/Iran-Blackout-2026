package com.google.zxing.oned.rss.expanded;

import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

/* loaded from: classes3.dex */
final class ExpandedPair {
    private final FinderPattern finderPattern;
    private final DataCharacter leftChar;
    private final DataCharacter rightChar;

    ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern;
    }

    DataCharacter getLeftChar() {
        return this.leftChar;
    }

    DataCharacter getRightChar() {
        return this.rightChar;
    }

    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    boolean mustBeLast() {
        return this.rightChar == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.leftChar);
        sb.append(" , ");
        sb.append(this.rightChar);
        sb.append(" : ");
        FinderPattern finderPattern = this.finderPattern;
        sb.append(finderPattern == null ? "null" : Integer.valueOf(finderPattern.getValue()));
        sb.append(" ]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        return CallProxy$$ExternalSyntheticBackport0.m(this.leftChar, expandedPair.leftChar) && CallProxy$$ExternalSyntheticBackport0.m(this.rightChar, expandedPair.rightChar) && CallProxy$$ExternalSyntheticBackport0.m(this.finderPattern, expandedPair.finderPattern);
    }

    public int hashCode() {
        return (ExpandedPair$$ExternalSyntheticBackport0.m(this.leftChar) ^ ExpandedPair$$ExternalSyntheticBackport0.m(this.rightChar)) ^ ExpandedPair$$ExternalSyntheticBackport0.m(this.finderPattern);
    }
}
