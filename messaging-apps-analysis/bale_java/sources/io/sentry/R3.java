package io.sentry;

import java.util.Queue;

/* loaded from: classes3.dex */
final class R3 extends Q3 implements Queue {
    private R3(Queue queue) {
        super(queue);
    }

    static R3 r(Queue queue) {
        return new R3(queue);
    }

    @Override // java.util.Queue
    public Object element() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            Object objElement = f().element();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return objElement;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zEquals = f().equals(obj);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zEquals;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public int hashCode() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            int iHashCode = f().hashCode();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return iHashCode;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.sentry.Q3
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Queue f() {
        return (Queue) super.f();
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zOffer = f().offer(obj);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zOffer;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public Object peek() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            Object objPeek = f().peek();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return objPeek;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public Object poll() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            Object objPoll = f().poll();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return objPoll;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Queue
    public Object remove() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            Object objRemove = f().remove();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return objRemove;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            Object[] array = f().toArray();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return array;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            Object[] array = f().toArray(objArr);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return array;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
