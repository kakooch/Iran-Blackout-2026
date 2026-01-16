package org.xbill.DNS;

import android.gov.nist.core.Separators;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import lombok.Generated;
import org.xbill.DNS.ExtendedResolver;

/* loaded from: classes8.dex */
public class ExtendedResolver implements Resolver {
    private final AtomicInteger lbStart;
    private boolean loadBalance;
    private final List<ResolverEntry> resolvers;
    private int retries;
    private Duration timeout;

    @Generated
    private static final OI3 log = RI3.i(ExtendedResolver.class);
    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    public static final Duration DEFAULT_RESOLVER_TIMEOUT = Duration.ofSeconds(5);

    /* JADX INFO: Access modifiers changed from: private */
    static class Resolution {
        private final int[] attempts;
        private int currentResolver;
        private final long endTime;
        private final Message query;
        private List<ResolverEntry> resolvers;
        private final int retriesPerResolver;

        Resolution(ExtendedResolver extendedResolver, Message message) {
            this.resolvers = new ArrayList(extendedResolver.resolvers);
            this.endTime = System.nanoTime() + extendedResolver.timeout.toNanos();
            if (extendedResolver.loadBalance) {
                int iUpdateAndGet = extendedResolver.lbStart.updateAndGet(new IntUnaryOperator() { // from class: org.xbill.DNS.h
                    @Override // java.util.function.IntUnaryOperator
                    public final int applyAsInt(int i) {
                        return this.a.lambda$new$0(i);
                    }
                });
                if (iUpdateAndGet > 0) {
                    ArrayList arrayList = new ArrayList(this.resolvers.size());
                    for (int i = 0; i < this.resolvers.size(); i++) {
                        arrayList.add(this.resolvers.get((i + iUpdateAndGet) % this.resolvers.size()));
                    }
                    this.resolvers = arrayList;
                }
            } else {
                this.resolvers = (List) this.resolvers.stream().sorted(Comparator.comparingInt(new ToIntFunction() { // from class: org.xbill.DNS.i
                    @Override // java.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        return ExtendedResolver.Resolution.lambda$new$1((ExtendedResolver.ResolverEntry) obj);
                    }
                })).collect(Collectors.toList());
            }
            this.attempts = new int[this.resolvers.size()];
            this.retriesPerResolver = extendedResolver.retries;
            this.query = message;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: handle, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public CompletionStage<Message> lambda$startAsync$2(Message message, Throwable th, final Executor executor) {
            AtomicInteger atomicInteger = this.resolvers.get(this.currentResolver).failures;
            if (th == null) {
                atomicInteger.updateAndGet(new IntUnaryOperator() { // from class: org.xbill.DNS.l
                    @Override // java.util.function.IntUnaryOperator
                    public final int applyAsInt(int i) {
                        return ExtendedResolver.Resolution.lambda$handle$4(i);
                    }
                });
                return CompletableFuture.completedFuture(message);
            }
            ExtendedResolver.log.l("Failed to resolve {}/{}, id={} with resolver {} ({}) on attempt {} of {}, reason={}", this.query.getQuestion().getName(), Type.string(this.query.getQuestion().getType()), Integer.valueOf(this.query.getHeader().getID()), Integer.valueOf(this.currentResolver), this.resolvers.get(this.currentResolver).resolver, Integer.valueOf(this.attempts[this.currentResolver]), Integer.valueOf(this.retriesPerResolver), th.getMessage());
            atomicInteger.incrementAndGet();
            if (this.endTime - System.nanoTime() >= 0) {
                int size = (this.currentResolver + 1) % this.resolvers.size();
                this.currentResolver = size;
                if (this.attempts[size] < this.retriesPerResolver) {
                    return send(executor).handle(new BiFunction() { // from class: org.xbill.DNS.k
                        @Override // java.util.function.BiFunction
                        public final Object apply(Object obj, Object obj2) {
                            return this.a.lambda$handle$3(executor, (Message) obj, (Throwable) obj2);
                        }
                    }).thenCompose(Function.identity());
                }
                CompletableFuture completableFuture = new CompletableFuture();
                completableFuture.completeExceptionally(th);
                return completableFuture;
            }
            CompletableFuture completableFuture2 = new CompletableFuture();
            completableFuture2.completeExceptionally(new IOException("Timed out while trying to resolve " + this.query.getQuestion().getName() + Separators.SLASH + Type.string(this.query.getQuestion().type) + ", id=" + this.query.getHeader().getID()));
            return completableFuture2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$handle$4(int i) {
            if (i > 0) {
                return (int) Math.log(i);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$new$0(int i) {
            return (i + 1) % this.resolvers.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$new$1(ResolverEntry resolverEntry) {
            return resolverEntry.failures.get();
        }

        private CompletionStage<Message> send(Executor executor) {
            ResolverEntry resolverEntry = this.resolvers.get(this.currentResolver);
            ExtendedResolver.log.l("Sending {}/{}, id={} to resolver {} ({}), attempt {} of {}", this.query.getQuestion().getName(), Type.string(this.query.getQuestion().getType()), Integer.valueOf(this.query.getHeader().getID()), Integer.valueOf(this.currentResolver), resolverEntry.resolver, Integer.valueOf(this.attempts[this.currentResolver] + 1), Integer.valueOf(this.retriesPerResolver));
            int[] iArr = this.attempts;
            int i = this.currentResolver;
            iArr[i] = iArr[i] + 1;
            return resolverEntry.resolver.sendAsync(this.query, executor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletionStage<Message> startAsync(final Executor executor) {
            return send(executor).handle(new BiFunction() { // from class: org.xbill.DNS.j
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return this.a.lambda$startAsync$2(executor, (Message) obj, (Throwable) obj2);
                }
            }).thenCompose(Function.identity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static class ResolverEntry {
        private final AtomicInteger failures;
        private final Resolver resolver;

        @Generated
        public ResolverEntry(Resolver resolver, AtomicInteger atomicInteger) {
            this.resolver = resolver;
            this.failures = atomicInteger;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Resolver access$500(ResolverEntry resolverEntry) {
            return resolverEntry.resolver;
        }

        public String toString() {
            return this.resolver.toString();
        }

        ResolverEntry(Resolver resolver) {
            this(resolver, new AtomicInteger(0));
        }
    }

    public ExtendedResolver() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.resolvers = copyOnWriteArrayList;
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        copyOnWriteArrayList.addAll((Collection) ResolverConfig.getCurrentConfig().servers().stream().map(new Function() { // from class: ir.nasim.Ie2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ExtendedResolver.lambda$new$0((InetSocketAddress) obj);
            }
        }).collect(Collectors.toList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteResolver$3(Resolver resolver, ResolverEntry resolverEntry) {
        return resolverEntry.resolver == resolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Resolver[] lambda$getResolvers$2(int i) {
        return new Resolver[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ResolverEntry lambda$new$0(InetSocketAddress inetSocketAddress) {
        SimpleResolver simpleResolver = new SimpleResolver(inetSocketAddress);
        simpleResolver.setTimeout(DEFAULT_RESOLVER_TIMEOUT);
        return new ResolverEntry(simpleResolver);
    }

    public void addResolver(Resolver resolver) {
        this.resolvers.add(new ResolverEntry(resolver));
    }

    public void deleteResolver(final Resolver resolver) {
        this.resolvers.removeIf(new Predicate() { // from class: org.xbill.DNS.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ExtendedResolver.lambda$deleteResolver$3(resolver, (ExtendedResolver.ResolverEntry) obj);
            }
        });
    }

    public boolean getLoadBalance() {
        return this.loadBalance;
    }

    public Resolver getResolver(int i) {
        if (i < this.resolvers.size()) {
            return this.resolvers.get(i).resolver;
        }
        return null;
    }

    public Resolver[] getResolvers() {
        return (Resolver[]) this.resolvers.stream().map(new Function() { // from class: org.xbill.DNS.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ExtendedResolver.ResolverEntry.access$500((ExtendedResolver.ResolverEntry) obj);
            }
        }).toArray(new IntFunction() { // from class: ir.nasim.He2
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return ExtendedResolver.lambda$getResolvers$2(i);
            }
        });
    }

    public int getRetries() {
        return this.retries;
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeout;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, ForkJoinPool.commonPool());
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i, int i2, int i3, List<EDNSOption> list) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setEDNS(i, i2, i3, list);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setIgnoreTruncation(z);
        }
    }

    public void setLoadBalance(boolean z) {
        this.loadBalance = z;
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setPort(i);
        }
    }

    public void setRetries(int i) {
        this.retries = i;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setTCP(z);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        Iterator<ResolverEntry> it = this.resolvers.iterator();
        while (it.hasNext()) {
            it.next().resolver.setTSIGKey(tsig);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeout = duration;
    }

    public String toString() {
        return "ExtendedResolver of " + this.resolvers;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        return new Resolution(this, message).startAsync(executor);
    }

    public ExtendedResolver(String[] strArr) {
        this.resolvers = new CopyOnWriteArrayList();
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        for (String str : strArr) {
            SimpleResolver simpleResolver = new SimpleResolver(str);
            simpleResolver.setTimeout(DEFAULT_RESOLVER_TIMEOUT);
            this.resolvers.add(new ResolverEntry(simpleResolver));
        }
    }

    public ExtendedResolver(Resolver[] resolverArr) {
        this(Arrays.asList(resolverArr));
    }

    public ExtendedResolver(Iterable<Resolver> iterable) {
        this.resolvers = new CopyOnWriteArrayList();
        this.lbStart = new AtomicInteger();
        this.retries = 3;
        this.timeout = DEFAULT_TIMEOUT;
        Iterator<Resolver> it = iterable.iterator();
        while (it.hasNext()) {
            this.resolvers.add(new ResolverEntry(it.next()));
        }
    }
}
