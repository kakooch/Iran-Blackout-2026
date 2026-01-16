package org.rbmain.ui.Components.Paint;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class ShaderSet {
    private static final Map<String, Map<String, Object>> AVAILBALBE_SHADERS = createMap();

    private static Map<String, Map<String, Object>> createMap() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; attribute float alpha; varying vec2 varTexcoord; varying float varIntensity; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; varIntensity = alpha; }");
        map2.put("fragment", "precision highp float; varying vec2 varTexcoord; varying float varIntensity; uniform sampler2D texture; void main (void) { gl_FragColor = vec4(0, 0, 0, varIntensity * texture2D(texture, varTexcoord.st, 0.0).r); }");
        map2.put("attributes", new String[]{"inPosition", "inTexcoord", "alpha"});
        map2.put("uniforms", new String[]{"mvpMatrix", "texture"});
        map.put("brush", Collections.unmodifiableMap(map2));
        HashMap map3 = new HashMap();
        map3.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; attribute float alpha; varying vec2 varTexcoord; varying float varIntensity; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; varIntensity = alpha; }");
        map3.put("fragment", "precision highp float; varying vec2 varTexcoord; varying float varIntensity; uniform sampler2D texture; void main (void) { vec4 f = texture2D(texture, varTexcoord.st, 0.0); gl_FragColor = vec4(f.r * varIntensity, f.g, f.b, 0.0); }");
        map3.put("attributes", new String[]{"inPosition", "inTexcoord", "alpha"});
        map3.put("uniforms", new String[]{"mvpMatrix", "texture"});
        map.put("brushLight", Collections.unmodifiableMap(map3));
        HashMap map4 = new HashMap();
        map4.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; varying vec2 varTexcoord; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; }");
        map4.put("fragment", "precision highp float; varying vec2 varTexcoord; uniform sampler2D texture; void main (void) { gl_FragColor = texture2D(texture, varTexcoord.st, 0.0); gl_FragColor.rgb *= gl_FragColor.a; }");
        map4.put("attributes", new String[]{"inPosition", "inTexcoord"});
        map4.put("uniforms", new String[]{"mvpMatrix", "texture"});
        map.put("blit", Collections.unmodifiableMap(map4));
        HashMap map5 = new HashMap();
        map5.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; varying vec2 varTexcoord; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; }");
        map5.put("fragment", "precision highp float; varying vec2 varTexcoord; uniform sampler2D texture; uniform sampler2D mask; uniform vec4 color; void main (void) { vec4 dst = texture2D(texture, varTexcoord.st, 0.0); vec3 maskColor = texture2D(mask, varTexcoord.st, 0.0).rgb; float srcAlpha = clamp(0.78 * maskColor.r + maskColor.b + maskColor.g, 0.0, 1.0); vec3 borderColor = mix(color.rgb, vec3(1.0, 1.0, 1.0), 0.86); vec3 finalColor = mix(color.rgb, borderColor, maskColor.g); finalColor = mix(finalColor.rgb, vec3(1.0, 1.0, 1.0), maskColor.b); float outAlpha = srcAlpha + dst.a * (1.0 - srcAlpha); gl_FragColor.rgb = (finalColor * srcAlpha + dst.rgb * dst.a * (1.0 - srcAlpha)) / outAlpha; gl_FragColor.a = outAlpha; gl_FragColor.rgb *= gl_FragColor.a; }");
        map5.put("attributes", new String[]{"inPosition", "inTexcoord"});
        map5.put("uniforms", new String[]{"mvpMatrix", "texture", "mask", "color"});
        map.put("blitWithMaskLight", Collections.unmodifiableMap(map5));
        HashMap map6 = new HashMap();
        map6.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; varying vec2 varTexcoord; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; }");
        map6.put("fragment", "precision highp float; varying vec2 varTexcoord; uniform sampler2D texture; uniform sampler2D mask; uniform vec4 color; void main (void) { vec4 dst = texture2D(texture, varTexcoord.st, 0.0); float srcAlpha = color.a * texture2D(mask, varTexcoord.st, 0.0).a; float outAlpha = srcAlpha + dst.a * (1.0 - srcAlpha); gl_FragColor.rgb = (color.rgb * srcAlpha + dst.rgb * dst.a * (1.0 - srcAlpha)) / outAlpha; gl_FragColor.a = outAlpha; gl_FragColor.rgb *= gl_FragColor.a; }");
        map6.put("attributes", new String[]{"inPosition", "inTexcoord"});
        map6.put("uniforms", new String[]{"mvpMatrix", "texture", "mask", "color"});
        map.put("blitWithMask", Collections.unmodifiableMap(map6));
        HashMap map7 = new HashMap();
        map7.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; varying vec2 varTexcoord; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; }");
        map7.put("fragment", "precision highp float; varying vec2 varTexcoord; uniform sampler2D texture; uniform sampler2D mask; uniform vec4 color; void main(void) { vec4 dst = texture2D(texture, varTexcoord.st, 0.0); float srcAlpha = color.a * texture2D(mask, varTexcoord.st, 0.0).a; float outAlpha = srcAlpha + dst.a * (1.0 - srcAlpha); gl_FragColor.rgb = (color.rgb * srcAlpha + dst.rgb * dst.a * (1.0 - srcAlpha)) / outAlpha; gl_FragColor.a = outAlpha; }");
        map7.put("attributes", new String[]{"inPosition", "inTexcoord"});
        map7.put("uniforms", new String[]{"mvpMatrix", "texture", "mask", "color"});
        map.put("compositeWithMask", Collections.unmodifiableMap(map7));
        HashMap map8 = new HashMap();
        map8.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; varying vec2 varTexcoord; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; }");
        map8.put("fragment", "precision highp float; varying vec2 varTexcoord; uniform sampler2D texture; uniform sampler2D mask; uniform vec4 color; void main(void) { vec4 dst = texture2D(texture, varTexcoord.st, 0.0); vec3 maskColor = texture2D(mask, varTexcoord.st, 0.0).rgb; float srcAlpha = clamp(0.78 * maskColor.r + maskColor.b + maskColor.g, 0.0, 1.0); vec3 borderColor = mix(color.rgb, vec3(1.0, 1.0, 1.0), 0.86); vec3 finalColor = mix(color.rgb, borderColor, maskColor.g); finalColor = mix(finalColor.rgb, vec3(1.0, 1.0, 1.0), maskColor.b); float outAlpha = srcAlpha + dst.a * (1.0 - srcAlpha); gl_FragColor.rgb = (finalColor * srcAlpha + dst.rgb * dst.a * (1.0 - srcAlpha)) / outAlpha; gl_FragColor.a = outAlpha; }");
        map8.put("attributes", new String[]{"inPosition", "inTexcoord"});
        map8.put("uniforms", new String[]{"mvpMatrix", "texture", "mask", "color"});
        map.put("compositeWithMaskLight", Collections.unmodifiableMap(map8));
        HashMap map9 = new HashMap();
        map9.put("vertex", "precision highp float; uniform mat4 mvpMatrix; attribute vec4 inPosition; attribute vec2 inTexcoord; varying vec2 varTexcoord; void main (void) { gl_Position = mvpMatrix * inPosition; varTexcoord = inTexcoord; }");
        map9.put("fragment", "precision highp float; varying vec2 varTexcoord; uniform sampler2D texture; void main (void) { gl_FragColor = texture2D(texture, varTexcoord.st, 0.0); }");
        map9.put("attributes", new String[]{"inPosition", "inTexcoord"});
        map9.put("uniforms", new String[]{"mvpMatrix", "texture"});
        map.put("nonPremultipliedBlit", Collections.unmodifiableMap(map9));
        return Collections.unmodifiableMap(map);
    }

    public static Map<String, Shader> setup() {
        HashMap map = new HashMap();
        for (Map.Entry<String, Map<String, Object>> entry : AVAILBALBE_SHADERS.entrySet()) {
            Map<String, Object> value = entry.getValue();
            map.put(entry.getKey(), new Shader((String) value.get("vertex"), (String) value.get("fragment"), (String[]) value.get("attributes"), (String[]) value.get("uniforms")));
        }
        return Collections.unmodifiableMap(map);
    }
}
