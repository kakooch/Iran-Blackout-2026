package org.xbill.DNS.lookup;

import android.gov.nist.core.Separators;
import ir.nasim.C10996cZ2;
import ir.nasim.OI3;
import ir.nasim.RI3;
import ir.nasim.SJ3;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Generated;
import lombok.NonNull;
import org.xbill.DNS.AAAARecord;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.CNAMERecord;
import org.xbill.DNS.Cache;
import org.xbill.DNS.DClass;
import org.xbill.DNS.DNAMERecord;
import org.xbill.DNS.EDNSOption;
import org.xbill.DNS.ExtendedErrorCodeOption;
import org.xbill.DNS.ExtendedResolver;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.ResolverConfig;
import org.xbill.DNS.SetResponse;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.Type;
import org.xbill.DNS.WireParseException;
import org.xbill.DNS.hosts.HostsFileParser;
import org.xbill.DNS.lookup.LookupResult;
import org.xbill.DNS.lookup.LookupSession;

/* loaded from: classes8.dex */
public class LookupSession {
    public static final int DEFAULT_MAX_ITERATIONS = 16;
    public static final int DEFAULT_NDOTS = 1;

    @Generated
    private static final OI3 log = RI3.i(LookupSession.class);
    private final Map<Integer, Cache> caches;
    private final boolean cycleResults;
    private final Executor executor;
    private final HostsFileParser hostsFileParser;
    private final IrrelevantRecordMode irrelevantRecordMode;
    private final int maxRedirects;
    private final int ndots;
    private final Resolver resolver;
    private final List<Name> searchPath;

    public static class LookupSessionBuilder {
        private List<Cache> caches;
        private boolean cycleResults;
        private Executor executor;
        private HostsFileParser hostsFileParser;
        private IrrelevantRecordMode irrelevantRecordMode;
        private int maxRedirects;
        private int ndots;
        private Resolver resolver;
        private List<Name> searchPath;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Name lambda$build$0(Name name) {
            try {
                return Name.concatenate(name, Name.root);
            } catch (NameTooLongException unused) {
                throw new IllegalArgumentException("Search path name too long");
            }
        }

        public LookupSession build() {
            List<Name> list = this.searchPath;
            if (list != null) {
                this.searchPath = (List) list.stream().map(new Function() { // from class: ir.nasim.cK3
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return LookupSession.LookupSessionBuilder.lambda$build$0((Name) obj);
                    }
                }).collect(Collectors.toCollection(new SJ3()));
            } else {
                this.searchPath = Collections.emptyList();
            }
            return new LookupSession(this.resolver, this.maxRedirects, this.ndots, this.searchPath, this.cycleResults, this.caches, this.hostsFileParser, this.executor, this.irrelevantRecordMode);
        }

        public LookupSessionBuilder cache(@NonNull Cache cache) {
            if (cache == null) {
                throw new NullPointerException("cache is marked non-null but is null");
            }
            if (this.caches == null) {
                this.caches = new ArrayList(1);
            }
            Iterator<Cache> it = this.caches.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Cache next = it.next();
                if (next.getDClass() == cache.getDClass()) {
                    this.caches.remove(next);
                    break;
                }
            }
            this.caches.add(cache);
            return this;
        }

        public LookupSessionBuilder caches(@NonNull Collection<Cache> collection) {
            if (collection == null) {
                throw new NullPointerException("caches is marked non-null but is null");
            }
            collection.forEach(new Consumer() { // from class: ir.nasim.bK3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.cache((Cache) obj);
                }
            });
            return this;
        }

        public LookupSessionBuilder clearCaches() {
            List<Cache> list = this.caches;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        public LookupSessionBuilder clearSearchPath() {
            List<Name> list = this.searchPath;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        public LookupSessionBuilder cycleResults(boolean z) {
            this.cycleResults = z;
            return this;
        }

        public LookupSessionBuilder defaultHostsFileParser() {
            this.hostsFileParser = new HostsFileParser();
            return this;
        }

        public LookupSessionBuilder executor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public LookupSessionBuilder hostsFileParser(HostsFileParser hostsFileParser) {
            this.hostsFileParser = hostsFileParser;
            return this;
        }

        LookupSessionBuilder irrelevantRecordMode(IrrelevantRecordMode irrelevantRecordMode) {
            this.irrelevantRecordMode = irrelevantRecordMode;
            return this;
        }

        public LookupSessionBuilder maxRedirects(int i) {
            this.maxRedirects = i;
            return this;
        }

        public LookupSessionBuilder ndots(int i) {
            this.ndots = i;
            return this;
        }

        public LookupSessionBuilder resolver(@NonNull Resolver resolver) {
            if (resolver == null) {
                throw new NullPointerException("resolver is marked non-null but is null");
            }
            this.resolver = resolver;
            return this;
        }

        public LookupSessionBuilder searchPath(Name name) {
            if (this.searchPath == null) {
                this.searchPath = new ArrayList();
            }
            this.searchPath.add(name);
            return this;
        }

        @Generated
        public String toString() {
            return "LookupSession.LookupSessionBuilder(resolver=" + this.resolver + ", maxRedirects=" + this.maxRedirects + ", ndots=" + this.ndots + ", searchPath=" + this.searchPath + ", cycleResults=" + this.cycleResults + ", caches=" + this.caches + ", hostsFileParser=" + this.hostsFileParser + ", executor=" + this.executor + ", irrelevantRecordMode=" + this.irrelevantRecordMode + Separators.RPAREN;
        }

        private LookupSessionBuilder() {
            this.irrelevantRecordMode = IrrelevantRecordMode.REMOVE;
        }

        @Deprecated
        public LookupSessionBuilder caches(@NonNull Map<Integer, Cache> map) {
            if (map != null) {
                return caches(map.values());
            }
            throw new NullPointerException("caches is marked non-null but is null");
        }

        public LookupSessionBuilder searchPath(Collection<? extends Name> collection) {
            if (this.searchPath == null) {
                this.searchPath = new ArrayList();
            }
            this.searchPath.addAll(collection);
            return this;
        }

        @Deprecated
        public LookupSessionBuilder cache(@NonNull Integer num, @NonNull Cache cache) {
            if (num == null) {
                throw new NullPointerException("dclass is marked non-null but is null");
            }
            if (cache != null) {
                cache(cache);
                return this;
            }
            throw new NullPointerException("cache is marked non-null but is null");
        }
    }

    private static LookupResult buildResult(Message message, List<Name> list, Record record) {
        int rcode = message.getRcode();
        List<Record> section = message.getSection(1);
        if (!section.isEmpty() || rcode == 0) {
            return new LookupResult(section, list);
        }
        if (rcode != 2) {
            if (rcode == 3) {
                throw new NoSuchDomainException(record.getName(), record.getType());
            }
            if (rcode != 8) {
                throw new LookupFailedException(String.format("Unknown non-success error code %s", Rcode.string(rcode)));
            }
            throw new NoSuchRRSetException(record.getName(), record.getType());
        }
        if (message.getOPT() != null) {
            List<EDNSOption> options = message.getOPT().getOptions(15);
            if (!options.isEmpty()) {
                throw new ServerFailedException(record.getName(), record.getType(), (ExtendedErrorCodeOption) options.get(0));
            }
        }
        throw new ServerFailedException(record.getName(), record.getType());
    }

    public static LookupSessionBuilder builder() {
        LookupSessionBuilder lookupSessionBuilder = new LookupSessionBuilder();
        lookupSessionBuilder.maxRedirects = 16;
        lookupSessionBuilder.ndots = 1;
        return lookupSessionBuilder;
    }

    private <T extends Throwable, R> CompletionStage<R> completeExceptionally(T t) {
        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.completeExceptionally(t);
        return completableFuture;
    }

    public static LookupSessionBuilder defaultBuilder() {
        return builder().resolver(new ExtendedResolver((Iterable<Resolver>) ResolverConfig.getCurrentConfig().servers().stream().map(new Function() { // from class: ir.nasim.VJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new SimpleResolver((InetSocketAddress) obj);
            }
        }).collect(Collectors.toList()))).ndots(ResolverConfig.getCurrentConfig().ndots()).cache(new Cache(1)).defaultHostsFileParser();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$lookupUntilSuccess$3(Iterator it, int i, int i2, LookupResult lookupResult, Throwable th) {
        Throwable cause = th == null ? null : th.getCause();
        return ((cause instanceof NoSuchDomainException) || (cause instanceof NoSuchRRSetException)) ? it.hasNext() ? lookupUntilSuccess(it, i, i2) : completeExceptionally(cause) : cause != null ? completeExceptionally(cause) : CompletableFuture.completedFuture(lookupResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SetResponse lambda$lookupWithCache$4(Record record, Cache cache) {
        log.l("Looking for <{}/{}/{}> in cache", record.getName(), Type.string(record.getType()), DClass.string(record.getDClass()));
        return cache.lookupRecords(record.getName(), record.getType(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$lookupWithResolver$7(Message message, Record record, Message message2) {
        try {
            Message messageNormalize = message2.normalize(message, this.irrelevantRecordMode == IrrelevantRecordMode.THROW);
            log.n("Normalized response for <{}/{}/{}> from \n{}\ninto\n{}", record.getName(), Type.string(record.getType()), DClass.string(record.getDClass()), message2, messageNormalize);
            return messageNormalize == null ? completeExceptionally(new InvalidZoneDataException("Failed to normalize message")) : CompletableFuture.completedFuture(messageNormalize);
        } catch (WireParseException e) {
            return completeExceptionally(new LookupFailedException("Message normalization failed, refusing to return it", e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LookupResult lambda$lookupWithResolver$8(List list, Record record, Message message) {
        return buildResult(message, list, record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Cache lambda$new$0(Cache cache) {
        return cache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Stream lambda$setResponseToMessageFuture$10(RRset rRset) {
        return rRset.rrs(this.cycleResults).stream();
    }

    private CompletionStage<LookupResult> lookupUntilSuccess(final Iterator<Name> it, final int i, final int i2) {
        final Record recordNewRecord = Record.newRecord(it.next(), i, i2);
        return lookupWithCache(recordNewRecord, null).thenCompose(new Function() { // from class: ir.nasim.NJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$lookupUntilSuccess$2(recordNewRecord, (LookupResult) obj);
            }
        }).handle(new BiFunction() { // from class: ir.nasim.OJ3
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.a.lambda$lookupUntilSuccess$3(it, i, i2, (LookupResult) obj, (Throwable) obj2);
            }
        }).thenCompose(Function.identity());
    }

    private CompletionStage<LookupResult> lookupWithCache(final Record record, final List<Name> list) {
        return (CompletionStage) Optional.ofNullable(this.caches.get(Integer.valueOf(record.getDClass()))).map(new Function() { // from class: ir.nasim.WJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LookupSession.lambda$lookupWithCache$4(record, (Cache) obj);
            }
        }).map(new Function() { // from class: ir.nasim.XJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$lookupWithCache$5(record, list, (SetResponse) obj);
            }
        }).orElseGet(new Supplier() { // from class: ir.nasim.YJ3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.lambda$lookupWithCache$6(record, list);
            }
        });
    }

    private LookupResult lookupWithHosts(List<Name> list, int i) {
        if (this.hostsFileParser == null) {
            return null;
        }
        if (i != 1 && i != 28) {
            return null;
        }
        try {
            for (Name name : list) {
                Optional<InetAddress> addressForHost = this.hostsFileParser.getAddressForHost(name, i);
                if (addressForHost.isPresent()) {
                    return new LookupResult(Record.newRecord(name, i, 1), true, i == 1 ? new ARecord(name, 1, 0L, addressForHost.get()) : new AAAARecord(name, 1, 0L, addressForHost.get()));
                }
            }
            return null;
        } catch (IOException e) {
            log.w("Local hosts database parsing failed, ignoring and using resolver", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lookupWithResolver, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$lookupWithCache$6(final Record record, final List<Name> list) {
        final Message messageNewQuery = Message.newQuery(record);
        log.l("Asking {} for <{}/{}/{}>", this.resolver, record.getName(), Type.string(record.getType()), DClass.string(record.getDClass()));
        return this.resolver.sendAsync(messageNewQuery, this.executor).thenCompose(new Function() { // from class: ir.nasim.PJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$lookupWithResolver$7(messageNewQuery, record, (Message) obj);
            }
        }).thenApply(new Function() { // from class: ir.nasim.QJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.maybeAddToCache((Message) obj);
            }
        }).thenApply(new Function() { // from class: ir.nasim.RJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LookupSession.lambda$lookupWithResolver$8(list, record, (Message) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message maybeAddToCache(final Message message) {
        for (RRset rRset : message.getSectionRRsets(1)) {
            if (rRset.getType() == 5 || rRset.getType() == 39) {
                if (rRset.size() != 1) {
                    throw new InvalidZoneDataException("Multiple CNAME RRs not allowed, see RFC 1034 3.6.2");
                }
            }
        }
        Optional.ofNullable(this.caches.get(Integer.valueOf(message.getQuestion().getDClass()))).ifPresent(new Consumer() { // from class: ir.nasim.ZJ3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Cache) obj).addMessage(message);
            }
        });
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: maybeFollowRedirect, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$maybeFollowRedirectsInAnswer$11(LookupResult lookupResult, Record record, int i) {
        if (i > this.maxRedirects) {
            throw new RedirectOverflowException(this.maxRedirects);
        }
        List<Record> records = lookupResult.getRecords();
        return (records.isEmpty() || record.getType() == records.get(0).getType() || !(records.get(0).getType() == 5 || records.get(0).getType() == 39)) ? CompletableFuture.completedFuture(lookupResult) : maybeFollowRedirectsInAnswer(lookupResult, record, i);
    }

    private CompletionStage<LookupResult> maybeFollowRedirectsInAnswer(LookupResult lookupResult, Record record, final int i) {
        ArrayList arrayList = new ArrayList(lookupResult.getAliases());
        ArrayList arrayList2 = new ArrayList();
        Name name = record.getName();
        for (Record record2 : lookupResult.getRecords()) {
            if (arrayList.contains(name)) {
                return completeExceptionally(new RedirectLoopException(this.maxRedirects));
            }
            if (i >= this.maxRedirects) {
                throw new RedirectOverflowException(this.maxRedirects);
            }
            if (record2.getDClass() == record.getDClass()) {
                if (record2.getType() == 5 && name.equals(record2.getName())) {
                    arrayList.add(name);
                    i++;
                    name = ((CNAMERecord) record2).getTarget();
                } else if (record2.getType() == 39 && name.subdomain(record2.getName())) {
                    arrayList.add(name);
                    i++;
                    try {
                        name = name.fromDNAME((DNAMERecord) record2);
                    } catch (NameTooLongException e) {
                        throw new InvalidZoneDataException("Cannot derive DNAME from " + record2 + " for " + name, e);
                    }
                } else if (record2.getType() == record.getType() && name.equals(record2.getName())) {
                    arrayList2.add(record2);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            return CompletableFuture.completedFuture(new LookupResult(arrayList2, arrayList));
        }
        if (arrayList.contains(name)) {
            return completeExceptionally(new RedirectLoopException(this.maxRedirects));
        }
        if (i >= this.maxRedirects) {
            throw new RedirectOverflowException(this.maxRedirects);
        }
        final Record recordNewRecord = Record.newRecord(name, record.getType(), record.getDClass());
        return lookupWithCache(recordNewRecord, arrayList).thenCompose(new Function() { // from class: ir.nasim.TJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$maybeFollowRedirectsInAnswer$11(recordNewRecord, i, (LookupResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resolveRedirects, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$lookupUntilSuccess$2(LookupResult lookupResult, Record record) {
        return lambda$maybeFollowRedirectsInAnswer$11(lookupResult, record, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Name safeConcat(Name name, Name name2) {
        try {
            return Name.concatenate(name, name2);
        } catch (NameTooLongException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setResponseToMessageFuture, reason: merged with bridge method [inline-methods] */
    public CompletionStage<LookupResult> lambda$lookupWithCache$5(SetResponse setResponse, Record record, List<Name> list) {
        if (setResponse.isNXDOMAIN()) {
            return completeExceptionally(new NoSuchDomainException(record.getName(), record.getType()));
        }
        if (setResponse.isNXRRSET()) {
            return completeExceptionally(new NoSuchRRSetException(record.getName(), record.getType()));
        }
        if (setResponse.isCNAME()) {
            return CompletableFuture.completedFuture(new LookupResult(Collections.singletonList(setResponse.getCNAME()), list));
        }
        if (setResponse.isDNAME()) {
            return CompletableFuture.completedFuture(new LookupResult(Collections.singletonList(setResponse.getDNAME()), list));
        }
        if (setResponse.isSuccessful()) {
            return CompletableFuture.completedFuture(new LookupResult((List) setResponse.answers().stream().flatMap(new Function() { // from class: ir.nasim.UJ3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.lambda$setResponseToMessageFuture$10((RRset) obj);
                }
            }).collect(Collectors.toList()), list));
        }
        return null;
    }

    List<Name> expandName(final Name name) {
        if (name.isAbsolute()) {
            return Collections.singletonList(name);
        }
        List<Name> list = (List) this.searchPath.stream().map(new Function() { // from class: ir.nasim.LJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LookupSession.safeConcat(name, (Name) obj);
            }
        }).filter(new C10996cZ2()).collect(Collectors.toCollection(new SJ3()));
        if (name.labels() > this.ndots) {
            list.add(0, safeConcat(name, Name.root));
        } else {
            list.add(safeConcat(name, Name.root));
        }
        return list;
    }

    Cache getCache(int i) {
        return this.caches.get(Integer.valueOf(i));
    }

    public CompletionStage<LookupResult> lookupAsync(Record record) {
        return lookupAsync(record.getName(), record.getType(), record.getDClass());
    }

    private LookupSession(@NonNull Resolver resolver, int i, int i2, List<Name> list, boolean z, List<Cache> list2, HostsFileParser hostsFileParser, Executor executor, IrrelevantRecordMode irrelevantRecordMode) {
        if (resolver == null) {
            throw new NullPointerException("resolver is marked non-null but is null");
        }
        this.resolver = resolver;
        this.maxRedirects = i;
        this.ndots = i2;
        this.searchPath = list;
        this.cycleResults = z;
        this.caches = list2 == null ? Collections.emptyMap() : (Map) list2.stream().collect(Collectors.toMap(new Function() { // from class: ir.nasim.aK3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((Cache) obj).getDClass());
            }
        }, new Function() { // from class: ir.nasim.MJ3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LookupSession.lambda$new$0((Cache) obj);
            }
        }));
        this.hostsFileParser = hostsFileParser;
        this.executor = executor == null ? ForkJoinPool.commonPool() : executor;
        this.irrelevantRecordMode = irrelevantRecordMode;
    }

    public CompletionStage<LookupResult> lookupAsync(Name name, int i) {
        return lookupAsync(name, i, 1);
    }

    public CompletionStage<LookupResult> lookupAsync(Name name, int i, int i2) {
        List<Name> listExpandName = expandName(name);
        LookupResult lookupResultLookupWithHosts = lookupWithHosts(listExpandName, i);
        if (lookupResultLookupWithHosts != null) {
            return CompletableFuture.completedFuture(lookupResultLookupWithHosts);
        }
        return lookupUntilSuccess(listExpandName.iterator(), i, i2);
    }
}
