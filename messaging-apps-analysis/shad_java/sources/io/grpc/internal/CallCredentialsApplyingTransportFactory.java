package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ChannelLogger;
import io.grpc.ClientStreamTracer;
import io.grpc.CompositeCallCredentials;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.MetadataApplierImpl;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
final class CallCredentialsApplyingTransportFactory implements ClientTransportFactory {
    private final Executor appExecutor;
    private final CallCredentials channelCallCredentials;
    private final ClientTransportFactory delegate;

    CallCredentialsApplyingTransportFactory(ClientTransportFactory clientTransportFactory, CallCredentials callCredentials, Executor executor) {
        this.delegate = (ClientTransportFactory) Preconditions.checkNotNull(clientTransportFactory, "delegate");
        this.channelCallCredentials = callCredentials;
        this.appExecutor = (Executor) Preconditions.checkNotNull(executor, "appExecutor");
    }

    @Override // io.grpc.internal.ClientTransportFactory
    public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportFactory.ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger) {
        return new CallCredentialsApplyingTransport(this.delegate.newClientTransport(socketAddress, clientTransportOptions, channelLogger), clientTransportOptions.getAuthority());
    }

    @Override // io.grpc.internal.ClientTransportFactory
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.delegate.getScheduledExecutorService();
    }

    @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    private class CallCredentialsApplyingTransport extends ForwardingConnectionClientTransport {
        private final ConnectionClientTransport delegate;
        private Status savedShutdownNowStatus;
        private Status savedShutdownStatus;
        private volatile Status shutdownStatus;
        private final AtomicInteger pendingApplier = new AtomicInteger(-2147483647);
        private final MetadataApplierImpl.MetadataApplierListener applierListener = new MetadataApplierImpl.MetadataApplierListener() { // from class: io.grpc.internal.CallCredentialsApplyingTransportFactory.CallCredentialsApplyingTransport.1
            @Override // io.grpc.internal.MetadataApplierImpl.MetadataApplierListener
            public void onComplete() {
                if (CallCredentialsApplyingTransport.this.pendingApplier.decrementAndGet() == 0) {
                    CallCredentialsApplyingTransport.this.maybeShutdown();
                }
            }
        };

        CallCredentialsApplyingTransport(ConnectionClientTransport connectionClientTransport, String str) {
            this.delegate = (ConnectionClientTransport) Preconditions.checkNotNull(connectionClientTransport, "delegate");
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport
        protected ConnectionClientTransport delegate() {
            return this.delegate;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ClientTransport
        public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
            CallCredentials credentials = callOptions.getCredentials();
            if (credentials == null) {
                credentials = CallCredentialsApplyingTransportFactory.this.channelCallCredentials;
            } else if (CallCredentialsApplyingTransportFactory.this.channelCallCredentials != null) {
                credentials = new CompositeCallCredentials(CallCredentialsApplyingTransportFactory.this.channelCallCredentials, credentials);
            }
            if (credentials != null) {
                MetadataApplierImpl metadataApplierImpl = new MetadataApplierImpl(this.delegate, methodDescriptor, metadata, callOptions, this.applierListener, clientStreamTracerArr);
                if (this.pendingApplier.incrementAndGet() > 0) {
                    this.applierListener.onComplete();
                    return new FailingClientStream(this.shutdownStatus, clientStreamTracerArr);
                }
                try {
                    credentials.applyRequestMetadata(new CallCredentials.RequestInfo(this, methodDescriptor, callOptions) { // from class: io.grpc.internal.CallCredentialsApplyingTransportFactory.CallCredentialsApplyingTransport.2
                    }, (Executor) MoreObjects.firstNonNull(callOptions.getExecutor(), CallCredentialsApplyingTransportFactory.this.appExecutor), metadataApplierImpl);
                } catch (Throwable th) {
                    metadataApplierImpl.fail(Status.UNAUTHENTICATED.withDescription("Credentials should use fail() instead of throwing exceptions").withCause(th));
                }
                return metadataApplierImpl.returnStream();
            }
            if (this.pendingApplier.get() >= 0) {
                return new FailingClientStream(this.shutdownStatus, clientStreamTracerArr);
            }
            return this.delegate.newStream(methodDescriptor, metadata, callOptions, clientStreamTracerArr);
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ManagedClientTransport
        public void shutdown(Status status) {
            Preconditions.checkNotNull(status, "status");
            synchronized (this) {
                if (this.pendingApplier.get() < 0) {
                    this.shutdownStatus = status;
                    this.pendingApplier.addAndGet(ConnectionsManager.DEFAULT_DATACENTER_ID);
                    if (this.pendingApplier.get() != 0) {
                        this.savedShutdownStatus = status;
                    } else {
                        super.shutdown(status);
                    }
                }
            }
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ManagedClientTransport
        public void shutdownNow(Status status) {
            Preconditions.checkNotNull(status, "status");
            synchronized (this) {
                if (this.pendingApplier.get() < 0) {
                    this.shutdownStatus = status;
                    this.pendingApplier.addAndGet(ConnectionsManager.DEFAULT_DATACENTER_ID);
                } else if (this.savedShutdownNowStatus != null) {
                    return;
                }
                if (this.pendingApplier.get() != 0) {
                    this.savedShutdownNowStatus = status;
                } else {
                    super.shutdownNow(status);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeShutdown() {
            synchronized (this) {
                if (this.pendingApplier.get() != 0) {
                    return;
                }
                Status status = this.savedShutdownStatus;
                Status status2 = this.savedShutdownNowStatus;
                this.savedShutdownStatus = null;
                this.savedShutdownNowStatus = null;
                if (status != null) {
                    super.shutdown(status);
                }
                if (status2 != null) {
                    super.shutdownNow(status2);
                }
            }
        }
    }
}
