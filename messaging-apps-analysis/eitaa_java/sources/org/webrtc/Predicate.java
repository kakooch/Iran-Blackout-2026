package org.webrtc;

/* loaded from: classes3.dex */
public interface Predicate<T> {
    Predicate<T> and(Predicate<? super T> other);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> other);

    boolean test(T arg);

    /* renamed from: org.webrtc.Predicate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Predicate $default$or(final Predicate _this, final Predicate predicate) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.1
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.$default$and(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.$default$negate(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return CC.$default$or(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T arg) {
                    return Predicate.this.test(arg) || predicate.test(arg);
                }
            };
        }

        public static Predicate $default$and(final Predicate _this, final Predicate predicate) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.2
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.$default$and(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.$default$negate(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return CC.$default$or(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T arg) {
                    return Predicate.this.test(arg) && predicate.test(arg);
                }
            };
        }

        public static Predicate $default$negate(final Predicate _this) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.3
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return CC.$default$and(this, predicate);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.$default$negate(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return CC.$default$or(this, predicate);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T arg) {
                    return !Predicate.this.test(arg);
                }
            };
        }
    }
}
