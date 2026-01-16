package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aiq implements agu {
    private final ahp a;

    public aiq(ahp ahpVar) {
        this.a = ahpVar;
    }

    static final agt<?> b(ahp ahpVar, age ageVar, akz<?> akzVar, agv agvVar) {
        agp agpVar;
        agt<?> ajiVar;
        Object objA = ahpVar.a(akz.d(agvVar.a())).a();
        if (objA instanceof agt) {
            ajiVar = (agt) objA;
        } else if (objA instanceof agu) {
            ajiVar = ((agu) objA).a(ageVar, akzVar);
        } else {
            if (objA instanceof agp) {
                agpVar = (agp) objA;
            } else {
                if (!(objA instanceof agi)) {
                    throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + akzVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                }
                agpVar = null;
            }
            ajiVar = new aji<>(agpVar, objA instanceof agi ? (agi) objA : null, ageVar, akzVar, null);
        }
        return (ajiVar == null || !agvVar.b()) ? ajiVar : ajiVar.nullSafe();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        agv agvVar = (agv) akzVar.a().getAnnotation(agv.class);
        if (agvVar == null) {
            return null;
        }
        return (agt<T>) b(this.a, ageVar, akzVar, agvVar);
    }
}
