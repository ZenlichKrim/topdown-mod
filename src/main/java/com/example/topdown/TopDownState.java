package com.example.topdown;

public final class TopDownState {
    private static boolean enabled = false;
    private static double height = 20.0;

    private TopDownState() {}

    public static boolean isEnabled() { return enabled; }
    public static void setEnabled(boolean value) { enabled = value; }
    public static void toggle() { enabled = !enabled; }
    public static double getHeight() { return height; }
    public static void setHeight(double h) { height = h; }
}
