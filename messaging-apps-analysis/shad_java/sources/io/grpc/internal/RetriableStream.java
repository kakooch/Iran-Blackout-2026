package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
abstract class RetriableStream<ReqT> implements ClientStream {
    private static final Status CANCELLED_BECAUSE_COMMITTED;
    static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS;
    static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS;
    private static Random random;
    private final Executor callExecutor;
    private Status cancellationStatus;
    private final long channelBufferLimit;
    private final ChannelBufferMeter channelBufferUsed;
    private final Metadata headers;
    private final HedgingPolicy hedgingPolicy;
    private boolean isClosed;
    private final boolean isHedging;
    private ClientStreamListener masterListener;
    private final MethodDescriptor<ReqT, ?> method;
    private long nextBackoffIntervalNanos;
    private final long perRpcBufferLimit;
    private long perRpcBufferUsed;
    private final RetryPolicy retryPolicy;
    private final ScheduledExecutorService scheduledExecutorService;
    private FutureCanceller scheduledHedging;
    private FutureCanceller scheduledRetry;
    private final Throttle throttle;
    private final Executor listenerSerializeExecutor = new SynchronizationContext(new Thread.UncaughtExceptionHandler(this) { // from class: io.grpc.internal.RetriableStream.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw Status.fromThrowable(th).withDescription("Uncaught exception in the SynchronizationContext. Re-thrown.").asRuntimeException();
        }
    });
    private final Object lock = new Object();
    private final InsightBuilder closedSubstreamsInsight = new InsightBuilder();
    private volatile State state = new State(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    private final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();

    private interface BufferEntry {
        void runWith(Substream substream);
    }

    abstract ClientStream newSubstream(Metadata metadata, ClientStreamTracer.Factory factory, int i, boolean z);

    abstract void postCommit();

    abstract Status prestart();

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.of("grpc-previous-rpc-attempts", asciiMarshaller);
        GRPC_RETRY_PUSHBACK_MS = Metadata.Key.of("grpc-retry-pushback-ms", asciiMarshaller);
        CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
        random = new Random();
    }

    RetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, Metadata metadata, ChannelBufferMeter channelBufferMeter, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, RetryPolicy retryPolicy, HedgingPolicy hedgingPolicy, Throttle throttle) {
        this.method = methodDescriptor;
        this.channelBufferUsed = channelBufferMeter;
        this.perRpcBufferLimit = j;
        this.channelBufferLimit = j2;
        this.callExecutor = executor;
        this.scheduledExecutorService = scheduledExecutorService;
        this.headers = metadata;
        this.retryPolicy = retryPolicy;
        if (retryPolicy != null) {
            this.nextBackoffIntervalNanos = retryPolicy.initialBackoffNanos;
        }
        this.hedgingPolicy = hedgingPolicy;
        Preconditions.checkArgument(retryPolicy == null || hedgingPolicy == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.isHedging = hedgingPolicy != null;
        this.throttle = throttle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable commit(final Substream substream) {
        final Future<?> future;
        final Future<?> future2;
        synchronized (this.lock) {
            if (this.state.winningSubstream != null) {
                return null;
            }
            final Collection<Substream> collection = this.state.drainedSubstreams;
            this.state = this.state.committed(substream);
            this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
            FutureCanceller futureCanceller = this.scheduledRetry;
            if (futureCanceller != null) {
                Future<?> futureMarkCancelled = futureCanceller.markCancelled();
                this.scheduledRetry = null;
                future = futureMarkCancelled;
            } else {
                future = null;
            }
            FutureCanceller futureCanceller2 = this.scheduledHedging;
            if (futureCanceller2 != null) {
                Future<?> futureMarkCancelled2 = futureCanceller2.markCancelled();
                this.scheduledHedging = null;
                future2 = futureMarkCancelled2;
            } else {
                future2 = null;
            }
            return new Runnable() { // from class: io.grpc.internal.RetriableStream.1CommitTask
                @Override // java.lang.Runnable
                public void run() {
                    for (Substream substream2 : collection) {
                        if (substream2 != substream) {
                            substream2.stream.cancel(RetriableStream.CANCELLED_BECAUSE_COMMITTED);
                        }
                    }
                    Future future3 = future;
                    if (future3 != null) {
                        future3.cancel(false);
                    }
                    Future future4 = future2;
                    if (future4 != null) {
                        future4.cancel(false);
                    }
                    RetriableStream.this.postCommit();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitAndRun(Substream substream) {
        Runnable runnableCommit = commit(substream);
        if (runnableCommit != null) {
            runnableCommit.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Substream createSubstream(int i, boolean z) {
        Substream substream = new Substream(i);
        final BufferSizeTracer bufferSizeTracer = new BufferSizeTracer(substream);
        substream.stream = newSubstream(updateHeaders(this.headers, i), new ClientStreamTracer.Factory(this) { // from class: io.grpc.internal.RetriableStream.2
            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                return bufferSizeTracer;
            }
        }, i, z);
        return substream;
    }

    final Metadata updateHeaders(Metadata metadata, int i) {
        Metadata metadata2 = new Metadata();
        metadata2.merge(metadata);
        if (i > 0) {
            metadata2.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(i));
        }
        return metadata2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
    
        r8.listenerSerializeExecutor.execute(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        r0 = r9.stream;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        if (r8.state.winningSubstream != r9) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        r9 = r8.cancellationStatus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        r9 = io.grpc.internal.RetriableStream.CANCELLED_BECAUSE_COMMITTED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
    
        r0.cancel(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        if (r2.hasNext() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        r4 = (io.grpc.internal.RetriableStream.BufferEntry) r2.next();
        r4.runWith(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
    
        if ((r4 instanceof io.grpc.internal.RetriableStream.StartEntry) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
    
        if (r1 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        r4 = r8.state;
        r5 = r4.winningSubstream;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0099, code lost:
    
        if (r5 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        if (r5 == r9) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a0, code lost:
    
        if (r4.cancelled == false) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0019 A[Catch: all -> 0x00a5, TryCatch #0 {, blocks: (B:5:0x0007, B:7:0x000b, B:10:0x0011, B:12:0x0013, B:14:0x0017, B:16:0x0019, B:18:0x0021, B:20:0x002d, B:22:0x002f, B:23:0x0034, B:33:0x004e, B:35:0x0052, B:37:0x0054, B:39:0x0062, B:41:0x007a, B:40:0x006e), top: B:61:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drain(io.grpc.internal.RetriableStream.Substream r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r3 = r0
            r2 = 0
        L4:
            java.lang.Object r4 = r8.lock
            monitor-enter(r4)
            io.grpc.internal.RetriableStream$State r5 = r8.state     // Catch: java.lang.Throwable -> La5
            if (r1 == 0) goto L19
            io.grpc.internal.RetriableStream$Substream r6 = r5.winningSubstream     // Catch: java.lang.Throwable -> La5
            if (r6 == 0) goto L13
            if (r6 == r9) goto L13
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
            goto L35
        L13:
            boolean r6 = r5.cancelled     // Catch: java.lang.Throwable -> La5
            if (r6 == 0) goto L19
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
            goto L35
        L19:
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r6 = r5.buffer     // Catch: java.lang.Throwable -> La5
            int r6 = r6.size()     // Catch: java.lang.Throwable -> La5
            if (r2 != r6) goto L4e
            io.grpc.internal.RetriableStream$State r0 = r5.substreamDrained(r9)     // Catch: java.lang.Throwable -> La5
            r8.state = r0     // Catch: java.lang.Throwable -> La5
            boolean r0 = r8.isReady()     // Catch: java.lang.Throwable -> La5
            if (r0 != 0) goto L2f
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
            return
        L2f:
            io.grpc.internal.RetriableStream$3 r0 = new io.grpc.internal.RetriableStream$3     // Catch: java.lang.Throwable -> La5
            r0.<init>()     // Catch: java.lang.Throwable -> La5
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
        L35:
            if (r0 == 0) goto L3d
            java.util.concurrent.Executor r9 = r8.listenerSerializeExecutor
            r9.execute(r0)
            return
        L3d:
            io.grpc.internal.ClientStream r0 = r9.stream
            io.grpc.internal.RetriableStream$State r1 = r8.state
            io.grpc.internal.RetriableStream$Substream r1 = r1.winningSubstream
            if (r1 != r9) goto L48
            io.grpc.Status r9 = r8.cancellationStatus
            goto L4a
        L48:
            io.grpc.Status r9 = io.grpc.internal.RetriableStream.CANCELLED_BECAUSE_COMMITTED
        L4a:
            r0.cancel(r9)
            return
        L4e:
            boolean r6 = r9.closed     // Catch: java.lang.Throwable -> La5
            if (r6 == 0) goto L54
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
            return
        L54:
            int r6 = r2 + 128
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r7 = r5.buffer     // Catch: java.lang.Throwable -> La5
            int r7 = r7.size()     // Catch: java.lang.Throwable -> La5
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> La5
            if (r3 != 0) goto L6e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La5
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r5 = r5.buffer     // Catch: java.lang.Throwable -> La5
            java.util.List r2 = r5.subList(r2, r6)     // Catch: java.lang.Throwable -> La5
            r3.<init>(r2)     // Catch: java.lang.Throwable -> La5
            goto L7a
        L6e:
            r3.clear()     // Catch: java.lang.Throwable -> La5
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r5 = r5.buffer     // Catch: java.lang.Throwable -> La5
            java.util.List r2 = r5.subList(r2, r6)     // Catch: java.lang.Throwable -> La5
            r3.addAll(r2)     // Catch: java.lang.Throwable -> La5
        L7a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
            java.util.Iterator r2 = r3.iterator()
        L7f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto La2
            java.lang.Object r4 = r2.next()
            io.grpc.internal.RetriableStream$BufferEntry r4 = (io.grpc.internal.RetriableStream.BufferEntry) r4
            r4.runWith(r9)
            boolean r4 = r4 instanceof io.grpc.internal.RetriableStream.StartEntry
            if (r4 == 0) goto L93
            r1 = 1
        L93:
            if (r1 == 0) goto L7f
            io.grpc.internal.RetriableStream$State r4 = r8.state
            io.grpc.internal.RetriableStream$Substream r5 = r4.winningSubstream
            if (r5 == 0) goto L9e
            if (r5 == r9) goto L9e
            goto La2
        L9e:
            boolean r4 = r4.cancelled
            if (r4 == 0) goto L7f
        La2:
            r2 = r6
            goto L4
        La5:
            r9 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> La5
            goto La9
        La8:
            throw r9
        La9:
            goto La8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.drain(io.grpc.internal.RetriableStream$Substream):void");
    }

    class StartEntry implements BufferEntry {
        StartEntry() {
        }

        @Override // io.grpc.internal.RetriableStream.BufferEntry
        public void runWith(Substream substream) {
            substream.stream.start(new Sublistener(substream));
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener clientStreamListener) {
        Throttle throttle;
        this.masterListener = clientStreamListener;
        Status statusPrestart = prestart();
        if (statusPrestart != null) {
            cancel(statusPrestart);
            return;
        }
        synchronized (this.lock) {
            this.state.buffer.add(new StartEntry());
        }
        Substream substreamCreateSubstream = createSubstream(0, false);
        if (this.isHedging) {
            FutureCanceller futureCanceller = null;
            synchronized (this.lock) {
                this.state = this.state.addActiveHedge(substreamCreateSubstream);
                if (hasPotentialHedging(this.state) && ((throttle = this.throttle) == null || throttle.isAboveThreshold())) {
                    futureCanceller = new FutureCanceller(this.lock);
                    this.scheduledHedging = futureCanceller;
                }
            }
            if (futureCanceller != null) {
                futureCanceller.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
            }
        }
        drain(substreamCreateSubstream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushbackHedging(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            freezeHedging();
            return;
        }
        synchronized (this.lock) {
            FutureCanceller futureCanceller = this.scheduledHedging;
            if (futureCanceller == null) {
                return;
            }
            Future<?> futureMarkCancelled = futureCanceller.markCancelled();
            FutureCanceller futureCanceller2 = new FutureCanceller(this.lock);
            this.scheduledHedging = futureCanceller2;
            if (futureMarkCancelled != null) {
                futureMarkCancelled.cancel(false);
            }
            futureCanceller2.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller2), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    private final class HedgingRunnable implements Runnable {
        final FutureCanceller scheduledHedgingRef;

        HedgingRunnable(FutureCanceller futureCanceller) {
            this.scheduledHedgingRef = futureCanceller;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.HedgingRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    FutureCanceller futureCanceller;
                    RetriableStream retriableStream = RetriableStream.this;
                    boolean z = false;
                    Substream substreamCreateSubstream = retriableStream.createSubstream(retriableStream.state.hedgingAttemptCount, false);
                    synchronized (RetriableStream.this.lock) {
                        futureCanceller = null;
                        if (HedgingRunnable.this.scheduledHedgingRef.isCancelled()) {
                            z = true;
                        } else {
                            RetriableStream retriableStream2 = RetriableStream.this;
                            retriableStream2.state = retriableStream2.state.addActiveHedge(substreamCreateSubstream);
                            RetriableStream retriableStream3 = RetriableStream.this;
                            if (retriableStream3.hasPotentialHedging(retriableStream3.state) && (RetriableStream.this.throttle == null || RetriableStream.this.throttle.isAboveThreshold())) {
                                RetriableStream retriableStream4 = RetriableStream.this;
                                futureCanceller = new FutureCanceller(retriableStream4.lock);
                                retriableStream4.scheduledHedging = futureCanceller;
                            } else {
                                RetriableStream retriableStream5 = RetriableStream.this;
                                retriableStream5.state = retriableStream5.state.freezeHedging();
                                RetriableStream.this.scheduledHedging = null;
                            }
                        }
                    }
                    if (!z) {
                        if (futureCanceller != null) {
                            futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), RetriableStream.this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
                        }
                        RetriableStream.this.drain(substreamCreateSubstream);
                        return;
                    }
                    substreamCreateSubstream.stream.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(final Status status) {
        Substream substream = new Substream(0);
        substream.stream = new NoopClientStream();
        Runnable runnableCommit = commit(substream);
        if (runnableCommit != null) {
            runnableCommit.run();
            this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.4
                @Override // java.lang.Runnable
                public void run() {
                    RetriableStream.this.isClosed = true;
                    RetriableStream.this.masterListener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
                }
            });
            return;
        }
        Substream substream2 = null;
        synchronized (this.lock) {
            if (this.state.drainedSubstreams.contains(this.state.winningSubstream)) {
                substream2 = this.state.winningSubstream;
            } else {
                this.cancellationStatus = status;
            }
            this.state = this.state.cancelled();
        }
        if (substream2 != null) {
            substream2.stream.cancel(status);
        }
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> collection;
        synchronized (this.lock) {
            if (!this.state.passThrough) {
                this.state.buffer.add(bufferEntry);
            }
            collection = this.state.drainedSubstreams;
        }
        Iterator<Substream> it = collection.iterator();
        while (it.hasNext()) {
            bufferEntry.runWith(it.next());
        }
    }

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    final void sendMessage(final ReqT reqt) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.writeMessage(this.method.streamRequest(reqt));
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1SendMessageEntry
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.writeMessage(RetriableStream.this.method.streamRequest(reqt));
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public final void request(final int i) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.request(i);
        } else {
            delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1RequestEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.request(i);
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.flush();
        } else {
            delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1FlushEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public final boolean isReady() {
        Iterator<Substream> it = this.state.drainedSubstreams.iterator();
        while (it.hasNext()) {
            if (it.next().stream.isReady()) {
                return true;
            }
        }
        return false;
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1OptimizeDirectEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.optimizeForDirectExecutor();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(final Compressor compressor) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1CompressorEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(final boolean z) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1FullStreamDecompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setFullStreamDecompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1HalfCloseEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setAuthority(final String str) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1AuthorityEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1DecompressorRegistryEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxInboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1MaxInboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxInboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxOutboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1MaxOutboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxOutboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDeadline(final Deadline deadline) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1DeadlineEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        State state;
        synchronized (this.lock) {
            insightBuilder.appendKeyValue("closed", this.closedSubstreamsInsight);
            state = this.state;
        }
        if (state.winningSubstream != null) {
            InsightBuilder insightBuilder2 = new InsightBuilder();
            state.winningSubstream.stream.appendTimeoutInsight(insightBuilder2);
            insightBuilder.appendKeyValue("committed", insightBuilder2);
            return;
        }
        InsightBuilder insightBuilder3 = new InsightBuilder();
        for (Substream substream : state.drainedSubstreams) {
            InsightBuilder insightBuilder4 = new InsightBuilder();
            substream.stream.appendTimeoutInsight(insightBuilder4);
            insightBuilder3.append(insightBuilder4);
        }
        insightBuilder.appendKeyValue("open", insightBuilder3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPotentialHedging(State state) {
        return state.winningSubstream == null && state.hedgingAttemptCount < this.hedgingPolicy.maxAttempts && !state.hedgingFrozen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freezeHedging() {
        Future<?> future;
        synchronized (this.lock) {
            FutureCanceller futureCanceller = this.scheduledHedging;
            future = null;
            if (futureCanceller != null) {
                Future<?> futureMarkCancelled = futureCanceller.markCancelled();
                this.scheduledHedging = null;
                future = futureMarkCancelled;
            }
            this.state = this.state.freezeHedging();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    private final class Sublistener implements ClientStreamListener {
        final Substream substream;

        Sublistener(Substream substream) {
            this.substream = substream;
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                if (RetriableStream.this.throttle != null) {
                    RetriableStream.this.throttle.onSuccess();
                }
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.masterListener.headersRead(metadata);
                    }
                });
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
            FutureCanceller futureCanceller;
            synchronized (RetriableStream.this.lock) {
                RetriableStream retriableStream = RetriableStream.this;
                retriableStream.state = retriableStream.state.substreamClosed(this.substream);
                RetriableStream.this.closedSubstreamsInsight.append(status.getCode());
            }
            Substream substream = this.substream;
            if (substream.bufferLimitExceeded) {
                RetriableStream.this.commitAndRun(substream);
                if (RetriableStream.this.state.winningSubstream == this.substream) {
                    RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            RetriableStream.this.isClosed = true;
                            RetriableStream.this.masterListener.closed(status, rpcProgress, metadata);
                        }
                    });
                    return;
                }
                return;
            }
            if (RetriableStream.this.state.winningSubstream == null) {
                boolean z = true;
                if (rpcProgress == ClientStreamListener.RpcProgress.REFUSED && RetriableStream.this.noMoreTransparentRetry.compareAndSet(false, true)) {
                    final Substream substreamCreateSubstream = RetriableStream.this.createSubstream(this.substream.previousAttemptCount, true);
                    if (RetriableStream.this.isHedging) {
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream retriableStream2 = RetriableStream.this;
                            retriableStream2.state = retriableStream2.state.replaceActiveHedge(this.substream, substreamCreateSubstream);
                            RetriableStream retriableStream3 = RetriableStream.this;
                            if (retriableStream3.hasPotentialHedging(retriableStream3.state) || RetriableStream.this.state.activeHedges.size() != 1) {
                                z = false;
                            }
                        }
                        if (z) {
                            RetriableStream.this.commitAndRun(substreamCreateSubstream);
                        }
                    } else if (RetriableStream.this.retryPolicy == null || RetriableStream.this.retryPolicy.maxAttempts == 1) {
                        RetriableStream.this.commitAndRun(substreamCreateSubstream);
                    }
                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RetriableStream.this.drain(substreamCreateSubstream);
                        }
                    });
                    return;
                }
                if (rpcProgress == ClientStreamListener.RpcProgress.DROPPED) {
                    if (RetriableStream.this.isHedging) {
                        RetriableStream.this.freezeHedging();
                    }
                } else {
                    RetriableStream.this.noMoreTransparentRetry.set(true);
                    if (RetriableStream.this.isHedging) {
                        HedgingPlan hedgingPlanMakeHedgingDecision = makeHedgingDecision(status, metadata);
                        if (hedgingPlanMakeHedgingDecision.isHedgeable) {
                            RetriableStream.this.pushbackHedging(hedgingPlanMakeHedgingDecision.hedgingPushbackMillis);
                        }
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream retriableStream4 = RetriableStream.this;
                            retriableStream4.state = retriableStream4.state.removeActiveHedge(this.substream);
                            if (hedgingPlanMakeHedgingDecision.isHedgeable) {
                                RetriableStream retriableStream5 = RetriableStream.this;
                                if (retriableStream5.hasPotentialHedging(retriableStream5.state) || !RetriableStream.this.state.activeHedges.isEmpty()) {
                                    return;
                                }
                            }
                        }
                    } else {
                        RetryPlan retryPlanMakeRetryDecision = makeRetryDecision(status, metadata);
                        if (retryPlanMakeRetryDecision.shouldRetry) {
                            synchronized (RetriableStream.this.lock) {
                                RetriableStream retriableStream6 = RetriableStream.this;
                                futureCanceller = new FutureCanceller(retriableStream6.lock);
                                retriableStream6.scheduledRetry = futureCanceller;
                            }
                            futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1RetryBackoffRunnable
                                @Override // java.lang.Runnable
                                public void run() {
                                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1RetryBackoffRunnable.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Sublistener sublistener = Sublistener.this;
                                            RetriableStream.this.drain(RetriableStream.this.createSubstream(sublistener.substream.previousAttemptCount + 1, false));
                                        }
                                    });
                                }
                            }, retryPlanMakeRetryDecision.backoffNanos, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                }
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.isClosed = true;
                        RetriableStream.this.masterListener.closed(status, rpcProgress, metadata);
                    }
                });
            }
        }

        private RetryPlan makeRetryDecision(Status status, Metadata metadata) {
            long nanos = 0;
            boolean z = false;
            if (RetriableStream.this.retryPolicy != null) {
                boolean zContains = RetriableStream.this.retryPolicy.retryableStatusCodes.contains(status.getCode());
                Integer pushbackMills = getPushbackMills(metadata);
                boolean z2 = (RetriableStream.this.throttle == null || (!zContains && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
                if (RetriableStream.this.retryPolicy.maxAttempts > this.substream.previousAttemptCount + 1 && !z2) {
                    if (pushbackMills == null) {
                        if (zContains) {
                            double d = RetriableStream.this.nextBackoffIntervalNanos;
                            double dNextDouble = RetriableStream.random.nextDouble();
                            Double.isNaN(d);
                            nanos = (long) (d * dNextDouble);
                            RetriableStream retriableStream = RetriableStream.this;
                            double d2 = retriableStream.nextBackoffIntervalNanos;
                            double d3 = RetriableStream.this.retryPolicy.backoffMultiplier;
                            Double.isNaN(d2);
                            retriableStream.nextBackoffIntervalNanos = Math.min((long) (d2 * d3), RetriableStream.this.retryPolicy.maxBackoffNanos);
                            z = true;
                        }
                    } else if (pushbackMills.intValue() >= 0) {
                        nanos = TimeUnit.MILLISECONDS.toNanos(pushbackMills.intValue());
                        RetriableStream retriableStream2 = RetriableStream.this;
                        retriableStream2.nextBackoffIntervalNanos = retriableStream2.retryPolicy.initialBackoffNanos;
                        z = true;
                    }
                }
                return new RetryPlan(z, nanos);
            }
            return new RetryPlan(false, 0L);
        }

        private HedgingPlan makeHedgingDecision(Status status, Metadata metadata) {
            Integer pushbackMills = getPushbackMills(metadata);
            boolean z = !RetriableStream.this.hedgingPolicy.nonFatalStatusCodes.contains(status.getCode());
            return new HedgingPlan((z || ((RetriableStream.this.throttle == null || (z && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold() ^ true)) ? false : true, pushbackMills);
        }

        private Integer getPushbackMills(Metadata metadata) {
            String str = (String) metadata.get(RetriableStream.GRPC_RETRY_PUSHBACK_MS);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            State state = RetriableStream.this.state;
            Preconditions.checkState(state.winningSubstream != null, "Headers should be received prior to messages.");
            if (state.winningSubstream != this.substream) {
                return;
            }
            RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.5
                @Override // java.lang.Runnable
                public void run() {
                    RetriableStream.this.masterListener.messagesAvailable(messageProducer);
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (RetriableStream.this.isReady()) {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RetriableStream.this.isClosed) {
                            return;
                        }
                        RetriableStream.this.masterListener.onReady();
                    }
                });
            }
        }
    }

    private static final class State {
        final Collection<Substream> activeHedges;
        final List<BufferEntry> buffer;
        final boolean cancelled;
        final Collection<Substream> drainedSubstreams;
        final int hedgingAttemptCount;
        final boolean hedgingFrozen;
        final boolean passThrough;
        final Substream winningSubstream;

        State(List<BufferEntry> list, Collection<Substream> collection, Collection<Substream> collection2, Substream substream, boolean z, boolean z2, boolean z3, int i) {
            this.buffer = list;
            this.drainedSubstreams = (Collection) Preconditions.checkNotNull(collection, "drainedSubstreams");
            this.winningSubstream = substream;
            this.activeHedges = collection2;
            this.cancelled = z;
            this.passThrough = z2;
            this.hedgingFrozen = z3;
            this.hedgingAttemptCount = i;
            Preconditions.checkState(!z2 || list == null, "passThrough should imply buffer is null");
            Preconditions.checkState((z2 && substream == null) ? false : true, "passThrough should imply winningSubstream != null");
            Preconditions.checkState(!z2 || (collection.size() == 1 && collection.contains(substream)) || (collection.size() == 0 && substream.closed), "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((z && substream == null) ? false : true, "cancelled should imply committed");
        }

        State cancelled() {
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, true, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        State substreamDrained(Substream substream) {
            Collection collectionUnmodifiableCollection;
            Preconditions.checkState(!this.passThrough, "Already passThrough");
            if (substream.closed) {
                collectionUnmodifiableCollection = this.drainedSubstreams;
            } else if (this.drainedSubstreams.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.drainedSubstreams);
                arrayList.add(substream);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            Substream substream2 = this.winningSubstream;
            boolean z = substream2 != null;
            List<BufferEntry> list = this.buffer;
            if (z) {
                Preconditions.checkState(substream2 == substream, "Another RPC attempt has already committed");
                list = null;
            }
            return new State(list, collection, this.activeHedges, this.winningSubstream, this.cancelled, z, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        State substreamClosed(Substream substream) {
            substream.closed = true;
            if (!this.drainedSubstreams.contains(substream)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.drainedSubstreams);
            arrayList.remove(substream);
            return new State(this.buffer, Collections.unmodifiableCollection(arrayList), this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        State committed(Substream substream) {
            List<BufferEntry> list;
            Collection collectionEmptyList;
            boolean z;
            Preconditions.checkState(this.winningSubstream == null, "Already committed");
            List<BufferEntry> list2 = this.buffer;
            if (this.drainedSubstreams.contains(substream)) {
                list = null;
                collectionEmptyList = Collections.singleton(substream);
                z = true;
            } else {
                list = list2;
                collectionEmptyList = Collections.emptyList();
                z = false;
            }
            return new State(list, collectionEmptyList, this.activeHedges, substream, this.cancelled, z, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        State freezeHedging() {
            return this.hedgingFrozen ? this : new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, true, this.hedgingAttemptCount);
        }

        State addActiveHedge(Substream substream) {
            Collection collectionUnmodifiableCollection;
            Preconditions.checkState(!this.hedgingFrozen, "hedging frozen");
            Preconditions.checkState(this.winningSubstream == null, "already committed");
            if (this.activeHedges == null) {
                collectionUnmodifiableCollection = Collections.singleton(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.activeHedges);
                arrayList.add(substream);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new State(this.buffer, this.drainedSubstreams, collectionUnmodifiableCollection, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount + 1);
        }

        State removeActiveHedge(Substream substream) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        State replaceActiveHedge(Substream substream, Substream substream2) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            arrayList.add(substream2);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }
    }

    private static final class Substream {
        boolean bufferLimitExceeded;
        boolean closed;
        final int previousAttemptCount;
        ClientStream stream;

        Substream(int i) {
            this.previousAttemptCount = i;
        }
    }

    class BufferSizeTracer extends ClientStreamTracer {
        long bufferNeeded;
        private final Substream substream;

        BufferSizeTracer(Substream substream) {
            this.substream = substream;
        }

        @Override // io.grpc.StreamTracer
        public void outboundWireSize(long j) {
            if (RetriableStream.this.state.winningSubstream != null) {
                return;
            }
            synchronized (RetriableStream.this.lock) {
                if (RetriableStream.this.state.winningSubstream == null && !this.substream.closed) {
                    long j2 = this.bufferNeeded + j;
                    this.bufferNeeded = j2;
                    if (j2 <= RetriableStream.this.perRpcBufferUsed) {
                        return;
                    }
                    if (this.bufferNeeded <= RetriableStream.this.perRpcBufferLimit) {
                        long jAddAndGet = RetriableStream.this.channelBufferUsed.addAndGet(this.bufferNeeded - RetriableStream.this.perRpcBufferUsed);
                        RetriableStream.this.perRpcBufferUsed = this.bufferNeeded;
                        if (jAddAndGet > RetriableStream.this.channelBufferLimit) {
                            this.substream.bufferLimitExceeded = true;
                        }
                    } else {
                        this.substream.bufferLimitExceeded = true;
                    }
                    Substream substream = this.substream;
                    Runnable runnableCommit = substream.bufferLimitExceeded ? RetriableStream.this.commit(substream) : null;
                    if (runnableCommit != null) {
                        runnableCommit.run();
                    }
                }
            }
        }
    }

    static final class ChannelBufferMeter {
        private final AtomicLong bufferUsed = new AtomicLong();

        ChannelBufferMeter() {
        }

        long addAndGet(long j) {
            return this.bufferUsed.addAndGet(j);
        }
    }

    static final class Throttle {
        final int maxTokens;
        final int threshold;
        final AtomicInteger tokenCount;
        final int tokenRatio;

        Throttle(float f, float f2) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.tokenCount = atomicInteger;
            this.tokenRatio = (int) (f2 * 1000.0f);
            int i = (int) (f * 1000.0f);
            this.maxTokens = i;
            this.threshold = i / 2;
            atomicInteger.set(i);
        }

        boolean isAboveThreshold() {
            return this.tokenCount.get() > this.threshold;
        }

        boolean onQualifiedFailureThenCheckIsAboveThreshold() {
            int i;
            int i2;
            do {
                i = this.tokenCount.get();
                if (i == 0) {
                    return false;
                }
                i2 = i - 1000;
            } while (!this.tokenCount.compareAndSet(i, Math.max(i2, 0)));
            return i2 > this.threshold;
        }

        void onSuccess() {
            int i;
            int i2;
            do {
                i = this.tokenCount.get();
                i2 = this.maxTokens;
                if (i == i2) {
                    return;
                }
            } while (!this.tokenCount.compareAndSet(i, Math.min(this.tokenRatio + i, i2)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Throttle)) {
                return false;
            }
            Throttle throttle = (Throttle) obj;
            return this.maxTokens == throttle.maxTokens && this.tokenRatio == throttle.tokenRatio;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.maxTokens), Integer.valueOf(this.tokenRatio));
        }
    }

    private static final class RetryPlan {
        final long backoffNanos;
        final boolean shouldRetry;

        RetryPlan(boolean z, long j) {
            this.shouldRetry = z;
            this.backoffNanos = j;
        }
    }

    private static final class HedgingPlan {
        final Integer hedgingPushbackMillis;
        final boolean isHedgeable;

        public HedgingPlan(boolean z, Integer num) {
            this.isHedgeable = z;
            this.hedgingPushbackMillis = num;
        }
    }

    private static final class FutureCanceller {
        boolean cancelled;
        Future<?> future;
        final Object lock;

        FutureCanceller(Object obj) {
            this.lock = obj;
        }

        void setFuture(Future<?> future) {
            synchronized (this.lock) {
                if (!this.cancelled) {
                    this.future = future;
                }
            }
        }

        Future<?> markCancelled() {
            this.cancelled = true;
            return this.future;
        }

        boolean isCancelled() {
            return this.cancelled;
        }
    }
}
