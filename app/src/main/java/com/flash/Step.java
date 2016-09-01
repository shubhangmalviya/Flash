package com.flash;

public interface Step {

    boolean isEnabled();

    void enable();

    void disable();

    void makeVisible();

    void makeInvisible();
}
