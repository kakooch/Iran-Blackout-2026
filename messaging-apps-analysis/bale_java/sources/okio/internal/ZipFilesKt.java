package okio.internal;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC10868cL0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12280eL5;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.C9663aL5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.UA2;
import ir.nasim.YV0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a5\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u001f\u001a\u00020\u001d*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0013\u0010!\u001a\u00020\u001d*\u00020\u0010H\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010%\u001a\u00020#*\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010'\u001a\u0004\u0018\u00010#*\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b'\u0010&\u001a!\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0002¢\u0006\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-\"\u0014\u0010.\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010-\"\u0014\u0010/\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010-\"\u0014\u00100\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010-\"\u0014\u00101\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010-\"\u0014\u00102\u001a\u00020\u00198\u0000X\u0080T¢\u0006\u0006\n\u0004\b2\u0010-\"\u0014\u00103\u001a\u00020\u00198\u0000X\u0080T¢\u0006\u0006\n\u0004\b3\u0010-\"\u0014\u00104\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010-\"\u0014\u00105\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010-\"\u0014\u00106\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107\"\u0014\u00108\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u0010-\"\u0014\u00109\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010-\"\u0018\u0010=\u001a\u00020:*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lokio/Path;", "zipPath", "Lokio/FileSystem;", "fileSystem", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", "", "predicate", "Lokio/ZipFileSystem;", "openZip", "(Lokio/Path;Lokio/FileSystem;Lir/nasim/UA2;)Lokio/ZipFileSystem;", "", "entries", "", "buildIndex", "(Ljava/util/List;)Ljava/util/Map;", "Lokio/BufferedSource;", "readEntry", "(Lokio/BufferedSource;)Lokio/internal/ZipEntry;", "Lokio/internal/EocdRecord;", "readEocdRecord", "(Lokio/BufferedSource;)Lokio/internal/EocdRecord;", "regularRecord", "readZip64EocdRecord", "(Lokio/BufferedSource;Lokio/internal/EocdRecord;)Lokio/internal/EocdRecord;", "", "extraSize", "Lkotlin/Function2;", "", "Lir/nasim/rB7;", "block", "readExtra", "(Lokio/BufferedSource;ILir/nasim/iB2;)V", "skipLocalHeader", "(Lokio/BufferedSource;)V", "Lokio/FileMetadata;", "basicMetadata", "readLocalHeader", "(Lokio/BufferedSource;Lokio/FileMetadata;)Lokio/FileMetadata;", "readOrSkipLocalHeader", "date", "time", "dosDateTimeToEpochMillis", "(II)Ljava/lang/Long;", "LOCAL_FILE_HEADER_SIGNATURE", TokenNames.I, "CENTRAL_FILE_HEADER_SIGNATURE", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "J", "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_EXTENDED_TIMESTAMP", "", "getHex", "(I)Ljava/lang/String;", "hex", "okio"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lokio/internal/ZipEntry;", "invoke", "(Lokio/internal/ZipEntry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: okio.internal.ZipFilesKt$openZip$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC8614Ws3 implements UA2 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public final Boolean invoke(ZipEntry zipEntry) {
            AbstractC13042fc3.i(zipEntry, "it");
            return Boolean.TRUE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "headerId", "", "dataSize", "Lir/nasim/rB7;", "invoke", "(IJ)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    /* renamed from: okio.internal.ZipFilesKt$readEntry$1, reason: invalid class name and case insensitive filesystem */
    static final class C252621 extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C12280eL5 $compressedSize;
        final /* synthetic */ C9663aL5 $hasZip64Extra;
        final /* synthetic */ C12280eL5 $offset;
        final /* synthetic */ long $requiredZip64ExtraSize;
        final /* synthetic */ C12280eL5 $size;
        final /* synthetic */ BufferedSource $this_readEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C252621(C9663aL5 c9663aL5, long j, C12280eL5 c12280eL5, BufferedSource bufferedSource, C12280eL5 c12280eL52, C12280eL5 c12280eL53) {
            super(2);
            this.$hasZip64Extra = c9663aL5;
            this.$requiredZip64ExtraSize = j;
            this.$size = c12280eL5;
            this.$this_readEntry = bufferedSource;
            this.$compressedSize = c12280eL52;
            this.$offset = c12280eL53;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IOException {
            invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
            return C19938rB7.a;
        }

        public final void invoke(int i, long j) throws IOException {
            if (i == 1) {
                C9663aL5 c9663aL5 = this.$hasZip64Extra;
                if (c9663aL5.a) {
                    throw new IOException("bad zip: zip64 extra repeated");
                }
                c9663aL5.a = true;
                if (j < this.$requiredZip64ExtraSize) {
                    throw new IOException("bad zip: zip64 extra too short");
                }
                C12280eL5 c12280eL5 = this.$size;
                long longLe = c12280eL5.a;
                if (longLe == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                    longLe = this.$this_readEntry.readLongLe();
                }
                c12280eL5.a = longLe;
                C12280eL5 c12280eL52 = this.$compressedSize;
                c12280eL52.a = c12280eL52.a == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? this.$this_readEntry.readLongLe() : 0L;
                C12280eL5 c12280eL53 = this.$offset;
                c12280eL53.a = c12280eL53.a == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? this.$this_readEntry.readLongLe() : 0L;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "headerId", "", "dataSize", "Lir/nasim/rB7;", "invoke", "(IJ)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    /* renamed from: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1, reason: invalid class name and case insensitive filesystem */
    static final class C252631 extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C12889fL5 $createdAtMillis;
        final /* synthetic */ C12889fL5 $lastAccessedAtMillis;
        final /* synthetic */ C12889fL5 $lastModifiedAtMillis;
        final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C252631(BufferedSource bufferedSource, C12889fL5 c12889fL5, C12889fL5 c12889fL52, C12889fL5 c12889fL53) {
            super(2);
            this.$this_readOrSkipLocalHeader = bufferedSource;
            this.$lastModifiedAtMillis = c12889fL5;
            this.$lastAccessedAtMillis = c12889fL52;
            this.$createdAtMillis = c12889fL53;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IOException {
            invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
            return C19938rB7.a;
        }

        public final void invoke(int i, long j) throws IOException {
            if (i == ZipFilesKt.HEADER_ID_EXTENDED_TIMESTAMP) {
                if (j < 1) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                byte b = this.$this_readOrSkipLocalHeader.readByte();
                boolean z = (b & 1) == 1;
                boolean z2 = (b & 2) == 2;
                boolean z3 = (b & 4) == 4;
                BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
                long j2 = z ? 5L : 1L;
                if (z2) {
                    j2 += 4;
                }
                if (z3) {
                    j2 += 4;
                }
                if (j < j2) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                if (z) {
                    this.$lastModifiedAtMillis.a = Long.valueOf(bufferedSource.readIntLe() * 1000);
                }
                if (z2) {
                    this.$lastAccessedAtMillis.a = Long.valueOf(this.$this_readOrSkipLocalHeader.readIntLe() * 1000);
                }
                if (z3) {
                    this.$createdAtMillis.a = Long.valueOf(this.$this_readOrSkipLocalHeader.readIntLe() * 1000);
                }
            }
        }
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.INSTANCE, Separators.SLASH, false, 1, (Object) null);
        Map<Path, ZipEntry> mapP = AbstractC20051rO3.p(AbstractC4616Fw7.a(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (ZipEntry zipEntry : AbstractC15401jX0.a1(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return AbstractC18050o01.d(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            if (mapP.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path pathParent = zipEntry.getCanonicalPath().parent();
                    if (pathParent != null) {
                        ZipEntry zipEntry2 = mapP.get(pathParent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(pathParent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        mapP.put(pathParent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return mapP;
    }

    private static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String string = Integer.toString(i, AbstractC10868cL0.a(16));
        AbstractC13042fc3.h(string, "toString(...)");
        sb.append(string);
        return sb.toString();
    }

    /* JADX WARN: Finally extract failed */
    public static final ZipFileSystem openZip(Path path, FileSystem fileSystem, UA2 ua2) throws IOException {
        BufferedSource bufferedSourceBuffer;
        AbstractC13042fc3.i(path, "zipPath");
        AbstractC13042fc3.i(fileSystem, "fileSystem");
        AbstractC13042fc3.i(ua2, "predicate");
        FileHandle fileHandleOpenReadOnly = fileSystem.openReadOnly(path);
        try {
            long size = fileHandleOpenReadOnly.size() - 22;
            if (size < 0) {
                throw new IOException("not a zip: size=" + fileHandleOpenReadOnly.size());
            }
            long jMax = Math.max(size - 65536, 0L);
            do {
                BufferedSource bufferedSourceBuffer2 = Okio.buffer(fileHandleOpenReadOnly.source(size));
                try {
                    if (bufferedSourceBuffer2.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        EocdRecord eocdRecord = readEocdRecord(bufferedSourceBuffer2);
                        String utf8 = bufferedSourceBuffer2.readUtf8(eocdRecord.getCommentByteCount());
                        bufferedSourceBuffer2.close();
                        long j = size - 20;
                        if (j > 0) {
                            BufferedSource bufferedSourceBuffer3 = Okio.buffer(fileHandleOpenReadOnly.source(j));
                            try {
                                if (bufferedSourceBuffer3.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                    int intLe = bufferedSourceBuffer3.readIntLe();
                                    long longLe = bufferedSourceBuffer3.readLongLe();
                                    if (bufferedSourceBuffer3.readIntLe() != 1 || intLe != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    bufferedSourceBuffer = Okio.buffer(fileHandleOpenReadOnly.source(longLe));
                                    try {
                                        int intLe2 = bufferedSourceBuffer.readIntLe();
                                        if (intLe2 != ZIP64_EOCD_RECORD_SIGNATURE) {
                                            throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(intLe2));
                                        }
                                        eocdRecord = readZip64EocdRecord(bufferedSourceBuffer, eocdRecord);
                                        C19938rB7 c19938rB7 = C19938rB7.a;
                                        YV0.a(bufferedSourceBuffer, null);
                                    } finally {
                                    }
                                }
                                C19938rB7 c19938rB72 = C19938rB7.a;
                                YV0.a(bufferedSourceBuffer3, null);
                            } finally {
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        bufferedSourceBuffer = Okio.buffer(fileHandleOpenReadOnly.source(eocdRecord.getCentralDirectoryOffset()));
                        try {
                            long entryCount = eocdRecord.getEntryCount();
                            for (long j2 = 0; j2 < entryCount; j2++) {
                                ZipEntry entry = readEntry(bufferedSourceBuffer);
                                if (entry.getOffset() >= eocdRecord.getCentralDirectoryOffset()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (((Boolean) ua2.invoke(entry)).booleanValue()) {
                                    arrayList.add(entry);
                                }
                            }
                            C19938rB7 c19938rB73 = C19938rB7.a;
                            YV0.a(bufferedSourceBuffer, null);
                            ZipFileSystem zipFileSystem = new ZipFileSystem(path, fileSystem, buildIndex(arrayList), utf8);
                            YV0.a(fileHandleOpenReadOnly, null);
                            return zipFileSystem;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } finally {
                                YV0.a(bufferedSourceBuffer, th);
                            }
                        }
                    }
                    bufferedSourceBuffer2.close();
                    size--;
                } finally {
                    bufferedSourceBuffer2.close();
                }
            } while (size >= jMax);
            throw new IOException("not a zip: end of central directory signature not found");
        } finally {
        }
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, UA2 ua2, int i, Object obj) {
        if ((i & 4) != 0) {
            ua2 = AnonymousClass1.INSTANCE;
        }
        return openZip(path, fileSystem, ua2);
    }

    public static final ZipEntry readEntry(BufferedSource bufferedSource) throws IOException {
        AbstractC13042fc3.i(bufferedSource, "<this>");
        int intLe = bufferedSource.readIntLe();
        if (intLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(4L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        Long lDosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & 65535, bufferedSource.readShortLe() & 65535);
        long intLe2 = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        C12280eL5 c12280eL5 = new C12280eL5();
        c12280eL5.a = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        C12280eL5 c12280eL52 = new C12280eL5();
        c12280eL52.a = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int shortLe3 = bufferedSource.readShortLe() & 65535;
        int shortLe4 = bufferedSource.readShortLe() & 65535;
        int shortLe5 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(8L);
        C12280eL5 c12280eL53 = new C12280eL5();
        c12280eL53.a = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String utf8 = bufferedSource.readUtf8(shortLe3);
        if (AbstractC20762sZ6.W(utf8, (char) 0, false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j = c12280eL52.a == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? 8 : 0L;
        long j2 = c12280eL5.a == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? j + 8 : j;
        if (c12280eL53.a == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j2 += 8;
        }
        long j3 = j2;
        C9663aL5 c9663aL5 = new C9663aL5();
        readExtra(bufferedSource, shortLe4, new C252621(c9663aL5, j3, c12280eL52, bufferedSource, c12280eL5, c12280eL53));
        if (j3 <= 0 || c9663aL5.a) {
            return new ZipEntry(Path.Companion.get$default(Path.INSTANCE, Separators.SLASH, false, 1, (Object) null).resolve(utf8), AbstractC20153rZ6.C(utf8, Separators.SLASH, false, 2, null), bufferedSource.readUtf8(shortLe5), intLe2, c12280eL5.a, c12280eL52.a, shortLe2, lDosDateTimeToEpochMillis, c12280eL53.a);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int shortLe = bufferedSource.readShortLe() & 65535;
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        long shortLe3 = bufferedSource.readShortLe() & 65535;
        if (shortLe3 != (bufferedSource.readShortLe() & 65535) || shortLe != 0 || shortLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(4L);
        return new EocdRecord(shortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & bufferedSource.readIntLe(), bufferedSource.readShortLe() & 65535);
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, InterfaceC14603iB2 interfaceC14603iB2) throws IOException {
        long j = i;
        while (j != 0) {
            if (j < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int shortLe = bufferedSource.readShortLe() & 65535;
            long shortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j2 = j - 4;
            if (j2 < shortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(shortLe2);
            long size = bufferedSource.getBuffer().size();
            interfaceC14603iB2.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long size2 = (bufferedSource.getBuffer().size() + shortLe2) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + shortLe);
            }
            if (size2 > 0) {
                bufferedSource.getBuffer().skip(size2);
            }
            j = j2 - shortLe2;
        }
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) throws IOException {
        AbstractC13042fc3.i(bufferedSource, "<this>");
        AbstractC13042fc3.i(fileMetadata, "basicMetadata");
        FileMetadata orSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        AbstractC13042fc3.f(orSkipLocalHeader);
        return orSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) throws IOException {
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : null;
        C12889fL5 c12889fL52 = new C12889fL5();
        C12889fL5 c12889fL53 = new C12889fL5();
        int intLe = bufferedSource.readIntLe();
        if (intLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(2L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        bufferedSource.skip(18L);
        long shortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int shortLe3 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(shortLe2);
        if (fileMetadata == null) {
            bufferedSource.skip(shortLe3);
            return null;
        }
        readExtra(bufferedSource, shortLe3, new C252631(bufferedSource, c12889fL5, c12889fL52, c12889fL53));
        return new FileMetadata(fileMetadata.getIsRegularFile(), fileMetadata.getIsDirectory(), null, fileMetadata.getSize(), (Long) c12889fL53.a, (Long) c12889fL5.a, (Long) c12889fL52.a, null, 128, null);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int intLe = bufferedSource.readIntLe();
        int intLe2 = bufferedSource.readIntLe();
        long longLe = bufferedSource.readLongLe();
        if (longLe != bufferedSource.readLongLe() || intLe != 0 || intLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(longLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) throws IOException {
        AbstractC13042fc3.i(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
