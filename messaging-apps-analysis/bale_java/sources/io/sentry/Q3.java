package io.sentry;

import io.sentry.util.C3202a;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
abstract class Q3 implements Collection, Serializable {
    private final Collection a;
    final C3202a b;

    Q3(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.a = collection;
        this.b = new C3202a();
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zAdd = f().add(obj);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zAdd;
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
    public boolean addAll(Collection collection) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zAddAll = f().addAll(collection);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zAddAll;
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
    public void clear() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            f().clear();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
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
    public boolean contains(Object obj) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zContains = f().contains(obj);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zContains;
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
    public boolean containsAll(Collection collection) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zContainsAll = f().containsAll(collection);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zContainsAll;
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

    protected Collection f() {
        return this.a;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zIsEmpty = f().isEmpty();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zIsEmpty;
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

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return f().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zRemove = f().remove(obj);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zRemove;
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
    public boolean removeAll(Collection collection) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zRemoveAll = f().removeAll(collection);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zRemoveAll;
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
    public boolean retainAll(Collection collection) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zRetainAll = f().retainAll(collection);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zRetainAll;
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
    public int size() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            int size = f().size();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return size;
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

    public String toString() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            String string = f().toString();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return string;
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
