package ir.nasim;

/* renamed from: ir.nasim.bT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C10323bT extends AbstractC18976pa2 {
    private final Integer a;
    private final Object b;
    private final EnumC5979Lq5 c;

    C10323bT(Integer num, Object obj, EnumC5979Lq5 enumC5979Lq5) {
        this.a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.b = obj;
        if (enumC5979Lq5 == null) {
            throw new NullPointerException("Null priority");
        }
        this.c = enumC5979Lq5;
    }

    @Override // ir.nasim.AbstractC18976pa2
    public Integer a() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC18976pa2
    public Object b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC18976pa2
    public EnumC5979Lq5 c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC18976pa2)) {
            return false;
        }
        AbstractC18976pa2 abstractC18976pa2 = (AbstractC18976pa2) obj;
        Integer num = this.a;
        if (num != null ? num.equals(abstractC18976pa2.a()) : abstractC18976pa2.a() == null) {
            if (this.b.equals(abstractC18976pa2.b()) && this.c.equals(abstractC18976pa2.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.b + ", priority=" + this.c + "}";
    }
}
