package io.grpc.stub;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class ClientCalls {
    private static final Logger logger = Logger.getLogger(ClientCalls.class.getName());
    static final CallOptions.Key<StubType> STUB_TYPE_OPTION = CallOptions.Key.create("internal-stub-type");

    enum StubType {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    private ClientCalls() {
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(Channel channel, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, ReqT reqt) throws Throwable {
        ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
        ClientCall clientCallNewCall = channel.newCall(methodDescriptor, callOptions.withOption(STUB_TYPE_OPTION, StubType.BLOCKING).withExecutor(threadlessExecutor));
        boolean z = false;
        try {
            try {
                ListenableFuture listenableFutureFutureUnaryCall = futureUnaryCall(clientCallNewCall, reqt);
                while (!listenableFutureFutureUnaryCall.isDone()) {
                    try {
                        threadlessExecutor.waitAndDrain();
                    } catch (InterruptedException e) {
                        try {
                            clientCallNewCall.cancel("Thread interrupted", e);
                            z = true;
                        } catch (Error e2) {
                            e = e2;
                            throw cancelThrow(clientCallNewCall, e);
                        } catch (RuntimeException e3) {
                            e = e3;
                            throw cancelThrow(clientCallNewCall, e);
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                RespT respt = (RespT) getUnchecked(listenableFutureFutureUnaryCall);
                if (z) {
                    Thread.currentThread().interrupt();
                }
                return respt;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Error e4) {
            e = e4;
        } catch (RuntimeException e5) {
            e = e5;
        }
    }

    public static <ReqT, RespT> ListenableFuture<RespT> futureUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        GrpcFuture grpcFuture = new GrpcFuture(clientCall);
        asyncUnaryRequestCall(clientCall, reqt, new UnaryStreamToFuture(grpcFuture));
        return grpcFuture;
    }

    private static <V> V getUnchecked(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withDescription("Thread interrupted").withCause(e).asRuntimeException();
        } catch (ExecutionException e2) {
            throw toStatusRuntimeException(e2.getCause());
        }
    }

    private static StatusRuntimeException toStatusRuntimeException(Throwable th) {
        for (Throwable cause = (Throwable) Preconditions.checkNotNull(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                StatusException statusException = (StatusException) cause;
                return new StatusRuntimeException(statusException.getStatus(), statusException.getTrailers());
            }
            if (cause instanceof StatusRuntimeException) {
                StatusRuntimeException statusRuntimeException = (StatusRuntimeException) cause;
                return new StatusRuntimeException(statusRuntimeException.getStatus(), statusRuntimeException.getTrailers());
            }
        }
        return Status.UNKNOWN.withDescription("unexpected exception").withCause(th).asRuntimeException();
    }

    private static RuntimeException cancelThrow(ClientCall<?, ?> clientCall, Throwable th) {
        try {
            clientCall.cancel(null, th);
        } catch (Throwable th2) {
            logger.log(Level.SEVERE, "RuntimeException encountered while closing call", th2);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StartableListener<RespT> startableListener) {
        startCall(clientCall, startableListener);
        try {
            clientCall.sendMessage(reqt);
            clientCall.halfClose();
        } catch (Error e) {
            throw cancelThrow(clientCall, e);
        } catch (RuntimeException e2) {
            throw cancelThrow(clientCall, e2);
        }
    }

    private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> clientCall, StartableListener<RespT> startableListener) {
        clientCall.start(startableListener, new Metadata());
        startableListener.onStart();
    }

    private static abstract class StartableListener<T> extends ClientCall.Listener<T> {
        abstract void onStart();

        private StartableListener() {
        }
    }

    private static final class UnaryStreamToFuture<RespT> extends StartableListener<RespT> {
        private final GrpcFuture<RespT> responseFuture;
        private RespT value;

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
        }

        UnaryStreamToFuture(GrpcFuture<RespT> grpcFuture) {
            super();
            this.responseFuture = grpcFuture;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            if (this.value != null) {
                throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
            }
            this.value = respt;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (status.isOk()) {
                if (this.value == null) {
                    this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(metadata));
                }
                this.responseFuture.set(this.value);
                return;
            }
            this.responseFuture.setException(status.asRuntimeException(metadata));
        }

        @Override // io.grpc.stub.ClientCalls.StartableListener
        void onStart() {
            ((GrpcFuture) this.responseFuture).call.request(2);
        }
    }

    private static final class GrpcFuture<RespT> extends AbstractFuture<RespT> {
        private final ClientCall<?, RespT> call;

        GrpcFuture(ClientCall<?, RespT> clientCall) {
            this.call = clientCall;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void interruptTask() {
            this.call.cancel("GrpcFuture was cancelled", null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected boolean set(RespT respt) {
            return super.set(respt);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected boolean setException(Throwable th) {
            return super.setException(th);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected String pendingToString() {
            return MoreObjects.toStringHelper(this).add("clientCall", this.call).toString();
        }
    }

    private static final class ThreadlessExecutor extends ConcurrentLinkedQueue<Runnable> implements Executor {
        private static final Logger log = Logger.getLogger(ThreadlessExecutor.class.getName());
        private volatile Thread waiter;

        ThreadlessExecutor() {
        }

        public void waitAndDrain() throws InterruptedException {
            Runnable runnablePoll;
            throwIfInterrupted();
            Runnable runnablePoll2 = poll();
            if (runnablePoll2 == null) {
                this.waiter = Thread.currentThread();
                while (true) {
                    try {
                        runnablePoll = poll();
                        if (runnablePoll != null) {
                            break;
                        }
                        LockSupport.park(this);
                        throwIfInterrupted();
                    } catch (Throwable th) {
                        this.waiter = null;
                        throw th;
                    }
                }
                this.waiter = null;
                runnablePoll2 = runnablePoll;
            }
            do {
                try {
                    runnablePoll2.run();
                } catch (Throwable th2) {
                    log.log(Level.WARNING, "Runnable threw exception", th2);
                }
                runnablePoll2 = poll();
            } while (runnablePoll2 != null);
        }

        private static void throwIfInterrupted() throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            add(runnable);
            LockSupport.unpark(this.waiter);
        }
    }
}
