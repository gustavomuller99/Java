package uxExample.components;

import uxExample.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
