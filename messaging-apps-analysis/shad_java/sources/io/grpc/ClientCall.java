package io.grpc;

/* loaded from: classes3.dex */
public abstract class ClientCall<ReqT, RespT> {

    public static abstract class Listener<T> {
        public void onClose(Status status, Metadata metadata) {
        }

        public void onHeaders(Metadata metadata) {
        }

        public void onMessage(T t) {
        }

        public void onReady() {
        }
    }

    public abstract void cancel(String str, Throwable th);

    public abstract void halfClose();

    public abstract void request(int i);

    public abstract void sendMessage(ReqT reqt);

    public abstract void start(Listener<RespT> listener, Metadata metadata);
}
