package org.xbill.DNS.hosts;

import ir.nasim.AbstractC10157bA4;
import ir.nasim.C10996cZ2;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.Generated;
import org.xbill.DNS.Address;
import org.xbill.DNS.Name;
import org.xbill.DNS.TextParseException;

/* loaded from: classes8.dex */
public final class HostsFileParser {

    @Generated
    private static final OI3 log = RI3.i(HostsFileParser.class);
    private final boolean clearCacheOnChange;
    private final Map<String, InetAddress> hostsCache;
    private boolean isEntireFileParsed;
    private Instant lastFileReadTime;
    private final int maxFullCacheFileSizeBytes;
    private final Path path;

    private static final class LineData {
        final byte[] address;
        final Iterable<? extends Name> names;
        final int type;

        @Generated
        public LineData(int i, byte[] bArr, Iterable<? extends Name> iterable) {
            this.type = i;
            this.address = bArr;
            this.names = iterable;
        }
    }

    public HostsFileParser() {
        this(System.getProperty("os.name").contains("Windows") ? Paths.get(System.getenv("SystemRoot"), "\\System32\\drivers\\etc\\hosts") : Paths.get("/etc/hosts", new String[0]), true);
    }

    private String[] getLineTokens(String str) {
        int iIndexOf = str.indexOf(35);
        if (iIndexOf == -1) {
            iIndexOf = str.length();
        }
        return str.substring(0, iIndexOf).trim().split("\\s+");
    }

    private String key(Name name, int i) {
        return name.toString() + '\t' + i;
    }

    private void parseEntireHostsFile() throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(this.path, StandardCharsets.UTF_8);
        int i = 0;
        while (true) {
            try {
                String line = bufferedReaderNewBufferedReader.readLine();
                if (line == null) {
                    bufferedReaderNewBufferedReader.close();
                    this.isEntireFileParsed = true;
                    return;
                }
                i++;
                LineData line2 = parseLine(i, line);
                if (line2 != null) {
                    for (Name name : line2.names) {
                        this.hostsCache.putIfAbsent(key(name, line2.type), InetAddress.getByAddress(name.toString(true), line2.address));
                    }
                }
            } catch (Throwable th) {
                if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private LineData parseLine(final int i, String str) {
        String[] lineTokens = getLineTokens(str);
        if (lineTokens.length < 2) {
            return null;
        }
        int i2 = 1;
        byte[] byteArray = Address.toByteArray(lineTokens[0], 1);
        if (byteArray == null) {
            byteArray = Address.toByteArray(lineTokens[0], 2);
            i2 = 28;
        }
        if (byteArray == null) {
            log.f("Could not decode address {}, {}#L{}", lineTokens[0], this.path, Integer.valueOf(i));
            return null;
        }
        final Stream streamFilter = Arrays.stream(lineTokens).skip(1L).map(new Function() { // from class: ir.nasim.bZ2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$parseLine$0(i, (String) obj);
            }
        }).filter(new C10996cZ2());
        Objects.requireNonNull(streamFilter);
        return new LineData(i2, byteArray, new Iterable() { // from class: ir.nasim.aZ2
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return streamFilter.iterator();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: safeName, reason: merged with bridge method [inline-methods] */
    public Name lambda$parseLine$0(String str, int i) {
        try {
            return Name.fromString(str, Name.root);
        } catch (TextParseException unused) {
            log.f("Could not decode name {}, {}#L{}, skipping", str, this.path, Integer.valueOf(i));
            return null;
        }
    }

    private void searchHostsFileForEntry(Name name, int i) throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(this.path, StandardCharsets.UTF_8);
        int i2 = 0;
        while (true) {
            try {
                String line = bufferedReaderNewBufferedReader.readLine();
                if (line == null) {
                    bufferedReaderNewBufferedReader.close();
                    return;
                }
                i2++;
                LineData line2 = parseLine(i2, line);
                if (line2 != null) {
                    for (Name name2 : line2.names) {
                        if (name2.equals(name) && i == line2.type) {
                            this.hostsCache.putIfAbsent(key(name2, line2.type), InetAddress.getByAddress(name2.toString(true), line2.address));
                            bufferedReaderNewBufferedReader.close();
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private void validateCache() {
        if (this.clearCacheOnChange) {
            Instant instant = Files.exists(this.path, new LinkOption[0]) ? Files.getLastModifiedTime(this.path, new LinkOption[0]).toInstant() : Instant.MAX;
            if (instant.isAfter(this.lastFileReadTime)) {
                if (!this.hostsCache.isEmpty()) {
                    log.p("Local hosts database has changed at {}, clearing cache", instant);
                    this.hostsCache.clear();
                }
                this.isEntireFileParsed = false;
                this.lastFileReadTime = instant;
            }
        }
    }

    int cacheSize() {
        return this.hostsCache.size();
    }

    public synchronized Optional<InetAddress> getAddressForHost(Name name, int i) {
        try {
            Objects.requireNonNull(name, "name is required");
            if (i != 1 && i != 28) {
                throw new IllegalArgumentException("type can only be A or AAAA");
            }
            validateCache();
            InetAddress inetAddress = this.hostsCache.get(key(name, i));
            if (inetAddress != null) {
                return Optional.of(inetAddress);
            }
            if (!this.isEntireFileParsed && Files.exists(this.path, new LinkOption[0])) {
                if (Files.size(this.path) <= this.maxFullCacheFileSizeBytes) {
                    parseEntireHostsFile();
                } else {
                    searchHostsFileForEntry(name, i);
                }
                return Optional.ofNullable(this.hostsCache.get(key(name, i)));
            }
            return Optional.empty();
        } catch (Throwable th) {
            throw th;
        }
    }

    public HostsFileParser(Path path) {
        this(path, true);
    }

    public HostsFileParser(Path path, boolean z) {
        this.maxFullCacheFileSizeBytes = Integer.parseInt(System.getProperty("dnsjava.hostsfile.max_size_bytes", "16384"));
        this.hostsCache = new HashMap();
        this.lastFileReadTime = Instant.MIN;
        Objects.requireNonNull(path, "path is required");
        this.path = AbstractC10157bA4.a(path);
        this.clearCacheOnChange = z;
        if (Files.isDirectory(path, new LinkOption[0])) {
            throw new IllegalArgumentException("path must be a file");
        }
    }
}
