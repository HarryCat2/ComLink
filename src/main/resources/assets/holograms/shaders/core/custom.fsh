#version 150

#moj_import <minecraft:fog.glsl>

uniform sampler2D Sampler0;
uniform vec4 ColorModulator;
uniform float FogStart;
uniform float FogEnd;
uniform vec4 FogColor;
uniform float Time; // optional, if you want animation

in float vertexDistance;
in vec4 vertexColor;
in vec2 texCoord0;

out vec4 fragColor;

void main() {
    vec4 texColor = texture(Sampler0, texCoord0);

    // Cutout for transparent areas
    if (texColor.a < 0.1) discard;

    // Cyan hologram tint
    vec3 hologramTint = vec3(0.2, 0.8, 1.0);

    // Apply tint and modulator color
    vec3 baseColor = texColor.rgb * hologramTint * ColorModulator.rgb;

    // Add pulsing transparency and light flicker
    float pulse = 0.7 + 0.3 * sin(Time * 5.0 + texCoord0.y * 10.0);
    float alpha = texColor.a * 0.6 * pulse;

    // Optional horizontal scanlines
    float scanline = 0.85 + 0.15 * sin(texCoord0.y * 800.0 + Time * 8.0);
    baseColor *= scanline;

    vec4 color = vec4(baseColor, alpha);

    fragColor = linear_fog(color, vertexDistance, FogStart, FogEnd, FogColor);
}
