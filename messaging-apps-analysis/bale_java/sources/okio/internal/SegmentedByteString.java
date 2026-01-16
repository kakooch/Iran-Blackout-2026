package okio.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9648aK;
import ir.nasim.InterfaceC15796kB2;
import kotlin.Metadata;
import okio.Buffer;
import okio.ByteString;
import okio.C25259SegmentedByteString;
import okio.Segment;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u000f\u001a\u00020\r*\u00020\u00072\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u000bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aD\u0010\u000f\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u000bH\u0082\b¢\u0006\u0004\b\u000f\u0010\u0013\u001a$\u0010\u0015\u001a\u00020\u0014*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0017*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\f*\u00020\u0007H\u0080\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a,\u0010\"\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a4\u0010'\u001a\u00020&*\u00020\u00072\u0006\u0010 \u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b'\u0010(\u001a4\u0010'\u001a\u00020&*\u00020\u00072\u0006\u0010 \u001a\u00020\u00012\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b'\u0010)\u001a4\u0010,\u001a\u00020\r*\u00020\u00072\u0006\u0010 \u001a\u00020\u00012\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b,\u0010-\u001a\u001e\u0010/\u001a\u00020&*\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010.H\u0080\b¢\u0006\u0004\b/\u00100\u001a\u0014\u00101\u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b1\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, d2 = {"", "", "value", "fromIndex", "toIndex", "binarySearch", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "segment", "(Lokio/SegmentedByteString;I)I", "Lkotlin/Function3;", "", "Lir/nasim/rB7;", "action", "forEachSegment", "(Lokio/SegmentedByteString;Lir/nasim/kB2;)V", "beginIndex", "endIndex", "(Lokio/SegmentedByteString;IILir/nasim/kB2;)V", "Lokio/ByteString;", "commonSubstring", "(Lokio/SegmentedByteString;II)Lokio/ByteString;", "", "commonInternalGet", "(Lokio/SegmentedByteString;I)B", "commonGetSize", "(Lokio/SegmentedByteString;)I", "commonToByteArray", "(Lokio/SegmentedByteString;)[B", "Lokio/Buffer;", "buffer", "offset", "byteCount", "commonWrite", "(Lokio/SegmentedByteString;Lokio/Buffer;II)V", "other", "otherOffset", "", "commonRangeEquals", "(Lokio/SegmentedByteString;ILokio/ByteString;II)Z", "(Lokio/SegmentedByteString;I[BII)Z", "target", "targetOffset", "commonCopyInto", "(Lokio/SegmentedByteString;I[BII)V", "", "commonEquals", "(Lokio/SegmentedByteString;Ljava/lang/Object;)Z", "commonHashCode", "okio"}, k = 2, mv = {1, 9, 0})
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes8.dex */
public final class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        AbstractC13042fc3.i(iArr, "<this>");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final void commonCopyInto(C25259SegmentedByteString c25259SegmentedByteString, int i, byte[] bArr, int i2, int i3) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        AbstractC13042fc3.i(bArr, "target");
        long j = i3;
        okio.SegmentedByteString.checkOffsetAndCount(c25259SegmentedByteString.size(), i, j);
        okio.SegmentedByteString.checkOffsetAndCount(bArr.length, i2, j);
        int i4 = i3 + i;
        int iSegment = segment(c25259SegmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : c25259SegmentedByteString.getDirectory()[iSegment - 1];
            int i6 = c25259SegmentedByteString.getDirectory()[iSegment] - i5;
            int i7 = c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            int i8 = i7 + (i - i5);
            AbstractC9648aK.g(c25259SegmentedByteString.getSegments()[iSegment], bArr, i2, i8, i8 + iMin);
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
    }

    public static final boolean commonEquals(C25259SegmentedByteString c25259SegmentedByteString, Object obj) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        if (obj == c25259SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == c25259SegmentedByteString.size() && c25259SegmentedByteString.rangeEquals(0, byteString, 0, c25259SegmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(C25259SegmentedByteString c25259SegmentedByteString) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        return c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length - 1];
    }

    public static final int commonHashCode(C25259SegmentedByteString c25259SegmentedByteString) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        int hashCode = c25259SegmentedByteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = c25259SegmentedByteString.getSegments().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = c25259SegmentedByteString.getDirectory()[length + i];
            int i5 = c25259SegmentedByteString.getDirectory()[i];
            byte[] bArr = c25259SegmentedByteString.getSegments()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        c25259SegmentedByteString.setHashCode$okio(i2);
        return i2;
    }

    public static final byte commonInternalGet(C25259SegmentedByteString c25259SegmentedByteString, int i) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        okio.SegmentedByteString.checkOffsetAndCount(c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length - 1], i, 1L);
        int iSegment = segment(c25259SegmentedByteString, i);
        return c25259SegmentedByteString.getSegments()[iSegment][(i - (iSegment == 0 ? 0 : c25259SegmentedByteString.getDirectory()[iSegment - 1])) + c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length + iSegment]];
    }

    public static final boolean commonRangeEquals(C25259SegmentedByteString c25259SegmentedByteString, int i, ByteString byteString, int i2, int i3) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        AbstractC13042fc3.i(byteString, "other");
        if (i < 0 || i > c25259SegmentedByteString.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(c25259SegmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : c25259SegmentedByteString.getDirectory()[iSegment - 1];
            int i6 = c25259SegmentedByteString.getDirectory()[iSegment] - i5;
            int i7 = c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!byteString.rangeEquals(i2, c25259SegmentedByteString.getSegments()[iSegment], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(C25259SegmentedByteString c25259SegmentedByteString, int i, int i2) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        int iResolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(c25259SegmentedByteString, i2);
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (iResolveDefaultParameter > c25259SegmentedByteString.size()) {
            throw new IllegalArgumentException(("endIndex=" + iResolveDefaultParameter + " > length(" + c25259SegmentedByteString.size() + ')').toString());
        }
        int i3 = iResolveDefaultParameter - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(("endIndex=" + iResolveDefaultParameter + " < beginIndex=" + i).toString());
        }
        if (i == 0 && iResolveDefaultParameter == c25259SegmentedByteString.size()) {
            return c25259SegmentedByteString;
        }
        if (i == iResolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(c25259SegmentedByteString, i);
        int iSegment2 = segment(c25259SegmentedByteString, iResolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) AbstractC9648aK.s(c25259SegmentedByteString.getSegments(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i4 = iSegment;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(c25259SegmentedByteString.getDirectory()[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr.length] = c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length + i4];
                if (i4 == iSegment2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = iSegment != 0 ? c25259SegmentedByteString.getDirectory()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new C25259SegmentedByteString(bArr, iArr);
    }

    public static final byte[] commonToByteArray(C25259SegmentedByteString c25259SegmentedByteString) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        byte[] bArr = new byte[c25259SegmentedByteString.size()];
        int length = c25259SegmentedByteString.getSegments().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = c25259SegmentedByteString.getDirectory()[length + i];
            int i5 = c25259SegmentedByteString.getDirectory()[i];
            int i6 = i5 - i2;
            AbstractC9648aK.g(c25259SegmentedByteString.getSegments()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(C25259SegmentedByteString c25259SegmentedByteString, Buffer buffer, int i, int i2) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        AbstractC13042fc3.i(buffer, "buffer");
        int i3 = i + i2;
        int iSegment = segment(c25259SegmentedByteString, i);
        while (i < i3) {
            int i4 = iSegment == 0 ? 0 : c25259SegmentedByteString.getDirectory()[iSegment - 1];
            int i5 = c25259SegmentedByteString.getDirectory()[iSegment] - i4;
            int i6 = c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            Segment segment = new Segment(c25259SegmentedByteString.getSegments()[iSegment], i7, i7 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                AbstractC13042fc3.f(segment2);
                Segment segment3 = segment2.prev;
                AbstractC13042fc3.f(segment3);
                segment3.push(segment);
            }
            i += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + i2);
    }

    public static final void forEachSegment(C25259SegmentedByteString c25259SegmentedByteString, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        AbstractC13042fc3.i(interfaceC15796kB2, "action");
        int length = c25259SegmentedByteString.getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = c25259SegmentedByteString.getDirectory()[length + i];
            int i4 = c25259SegmentedByteString.getDirectory()[i];
            interfaceC15796kB2.q(c25259SegmentedByteString.getSegments()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    public static final int segment(C25259SegmentedByteString c25259SegmentedByteString, int i) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        int iBinarySearch = binarySearch(c25259SegmentedByteString.getDirectory(), i + 1, 0, c25259SegmentedByteString.getSegments().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private static final void forEachSegment(C25259SegmentedByteString c25259SegmentedByteString, int i, int i2, InterfaceC15796kB2 interfaceC15796kB2) {
        int iSegment = segment(c25259SegmentedByteString, i);
        while (i < i2) {
            int i3 = iSegment == 0 ? 0 : c25259SegmentedByteString.getDirectory()[iSegment - 1];
            int i4 = c25259SegmentedByteString.getDirectory()[iSegment] - i3;
            int i5 = c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - i;
            interfaceC15796kB2.q(c25259SegmentedByteString.getSegments()[iSegment], Integer.valueOf(i5 + (i - i3)), Integer.valueOf(iMin));
            i += iMin;
            iSegment++;
        }
    }

    public static final boolean commonRangeEquals(C25259SegmentedByteString c25259SegmentedByteString, int i, byte[] bArr, int i2, int i3) {
        AbstractC13042fc3.i(c25259SegmentedByteString, "<this>");
        AbstractC13042fc3.i(bArr, "other");
        if (i < 0 || i > c25259SegmentedByteString.size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(c25259SegmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : c25259SegmentedByteString.getDirectory()[iSegment - 1];
            int i6 = c25259SegmentedByteString.getDirectory()[iSegment] - i5;
            int i7 = c25259SegmentedByteString.getDirectory()[c25259SegmentedByteString.getSegments().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!okio.SegmentedByteString.arrayRangeEquals(c25259SegmentedByteString.getSegments()[iSegment], i7 + (i - i5), bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }
}
