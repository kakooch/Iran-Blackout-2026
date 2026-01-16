package okio;

import ir.nasim.AbstractC11442d1;
import ir.nasim.ED1;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0018B!\b\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokio/Options;", "Lir/nasim/d1;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "byteStrings", "", "trie", "<init>", "([Lokio/ByteString;[I)V", "", "index", "get", "(I)Lokio/ByteString;", "[Lokio/ByteString;", "getByteStrings$okio", "()[Lokio/ByteString;", "[I", "getTrie$okio", "()[I", "getSize", "()I", "size", "Companion", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class Options extends AbstractC11442d1 implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00142\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0013\"\u00020\u000bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00020\u0004*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lokio/Options$Companion;", "", "<init>", "()V", "", "nodeOffset", "Lokio/Buffer;", "node", "", "byteStringOffset", "", "Lokio/ByteString;", "byteStrings", "fromIndex", "toIndex", "indexes", "Lir/nasim/rB7;", "buildTrieRecursive", "(JLokio/Buffer;ILjava/util/List;IILjava/util/List;)V", "", "Lokio/Options;", "of", "([Lokio/ByteString;)Lokio/Options;", "getIntCount", "(Lokio/Buffer;)J", "intCount", "okio"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i;
            int i2;
            int i3;
            int i4;
            Buffer buffer;
            int i5 = byteStringOffset;
            if (fromIndex >= toIndex) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i6 = fromIndex; i6 < toIndex; i6++) {
                if (byteStrings.get(i6).size() < i5) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = byteStrings.get(fromIndex);
            ByteString byteString2 = byteStrings.get(toIndex - 1);
            int i7 = -1;
            if (i5 == byteString.size()) {
                int iIntValue = indexes.get(fromIndex).intValue();
                int i8 = fromIndex + 1;
                ByteString byteString3 = byteStrings.get(i8);
                i = i8;
                i2 = iIntValue;
                byteString = byteString3;
            } else {
                i = fromIndex;
                i2 = -1;
            }
            if (byteString.getByte(i5) == byteString2.getByte(i5)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i9 = 0;
                for (int i10 = i5; i10 < iMin && byteString.getByte(i10) == byteString2.getByte(i10); i10++) {
                    i9++;
                }
                long intCount = nodeOffset + getIntCount(node) + 2 + i9 + 1;
                node.writeInt(-i9);
                node.writeInt(i2);
                int i11 = i9 + i5;
                while (i5 < i11) {
                    node.writeInt(byteString.getByte(i5) & 255);
                    i5++;
                }
                if (i + 1 == toIndex) {
                    if (i11 != byteStrings.get(i).size()) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    node.writeInt(indexes.get(i).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    node.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer2, i11, byteStrings, i, toIndex, indexes);
                    node.writeAll(buffer2);
                    return;
                }
            }
            int i12 = 1;
            for (int i13 = i + 1; i13 < toIndex; i13++) {
                if (byteStrings.get(i13 - 1).getByte(i5) != byteStrings.get(i13).getByte(i5)) {
                    i12++;
                }
            }
            long intCount2 = nodeOffset + getIntCount(node) + 2 + (i12 * 2);
            node.writeInt(i12);
            node.writeInt(i2);
            for (int i14 = i; i14 < toIndex; i14++) {
                byte b = byteStrings.get(i14).getByte(i5);
                if (i14 == i || b != byteStrings.get(i14 - 1).getByte(i5)) {
                    node.writeInt(b & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i < toIndex) {
                byte b2 = byteStrings.get(i).getByte(i5);
                int i15 = i + 1;
                int i16 = i15;
                while (true) {
                    if (i16 >= toIndex) {
                        i3 = toIndex;
                        break;
                    } else {
                        if (b2 != byteStrings.get(i16).getByte(i5)) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                }
                if (i15 == i3 && i5 + 1 == byteStrings.get(i).size()) {
                    node.writeInt(indexes.get(i).intValue());
                    i4 = i3;
                    buffer = buffer3;
                } else {
                    node.writeInt(((int) (intCount2 + getIntCount(buffer3))) * i7);
                    i4 = i3;
                    buffer = buffer3;
                    buildTrieRecursive(intCount2, buffer3, i5 + 1, byteStrings, i, i3, indexes);
                }
                buffer3 = buffer;
                i = i4;
                i7 = -1;
            }
            node.writeAll(buffer3);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0L : j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00c6, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okio.Options of(okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, ED1 ed1) {
        this(byteStringArr, iArr);
    }

    public static final Options of(ByteString... byteStringArr) {
        return INSTANCE.of(byteStringArr);
    }

    @Override // ir.nasim.G0, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    /* renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.byteStrings.length;
    }

    /* renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
