package org.re.reforwardingbe.sea.main.application.ports.input;

import org.re.reforwardingbe.sea.main.application.ports.output.SeaMainOutputPort;
import org.re.reforwardingbe.sea.main.application.usecases.SeaMainUseCase;
import org.re.reforwardingbe.sea.main.framework.adapters.input.SeaMainAdapter;
import org.re.reforwardingbe.sea.main.framework.adapters.output.SeaMainMemoryAdapter;

public class SeaMainInputPort implements SeaMainUseCase {
    private SeaMainOutputPort seaMainOutputPort;
}
